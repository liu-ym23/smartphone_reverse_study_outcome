package com.android.server.audio;

import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioRecordingConfiguration;
import android.media.AudioSystem;
import android.media.IRecordingConfigDispatcher;
import android.media.MediaRecorder;
import android.media.audiofx.AudioEffect;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.android.server.SysOptBridge;
import com.android.server.media.projection.IMediaProjectionManagerServiceExt;
import com.android.server.utils.EventLogger;
import com.obric.cae.libs.BuildConfig;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class RecordingActivityMonitor implements AudioSystem.AudioRecordingCallback {
    public static final String TAG = "AudioService.RecordingActivityMonitor";
    private static final EventLogger sEventLogger = null;
    private ArrayList<RecMonitorClient> mClients;
    private boolean mHasPublicClients;
    private AtomicBoolean mLegacyRemoteSubmixActive;
    private AtomicInteger mLegacyRemoteSubmixRiid;
    private final PackageManager mPackMan;
    private List<RecordingState> mRecordStates;
    private final RecordingActivityMonitorExt mRecordingActivityMonitorExt;

    private static final class RecMonitorClient implements IBinder.DeathRecipient {
        static RecordingActivityMonitor sMonitor;
        final IRecordingConfigDispatcher mDispatcherCb;
        final boolean mIsPrivileged;

        RecMonitorClient(IRecordingConfigDispatcher rcdb, boolean isPrivileged) {
            this.mDispatcherCb = rcdb;
            this.mIsPrivileged = isPrivileged;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Log.w(RecordingActivityMonitor.TAG, "client died");
            sMonitor.unregisterRecordingCallback(this.mDispatcherCb);
        }

        boolean init() {
            this.mDispatcherCb.asBinder().linkToDeath(this, 0);     // Catch: RemoteException -> L6
            return true;
        L6:
            e = move-exception;
            Log.w(RecordingActivityMonitor.TAG, "Could not link to client death", e);
            return false;
        }

        void release() {
            this.mDispatcherCb.asBinder().unlinkToDeath(this, 0);
        }
    }

    private static final class RecorderDeathHandler implements IBinder.DeathRecipient {
        static RecordingActivityMonitor sMonitor;
        private final IBinder mRecorderToken;
        final int mRiid;

        RecorderDeathHandler(int riid, IBinder recorderToken) {
            this.mRiid = riid;
            this.mRecorderToken = recorderToken;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            sMonitor.releaseRecorder(this.mRiid);
        }

        boolean init() {
            this.mRecorderToken.linkToDeath(this, 0);     // Catch: RemoteException -> L6
            return true;
        L6:
            e = move-exception;
            Log.w(RecordingActivityMonitor.TAG, "Could not link to recorder death", e);
            return false;
        }

        void release() {
            this.mRecorderToken.unlinkToDeath(this, 0);
        }
    }

    private static final class RecordingEvent extends EventLogger.Event {
        private final int mClientUid;
        private final String mPackName;
        private final int mRIId;
        private final int mRecEvent;
        private final int mSession;
        private final boolean mSilenced;
        private final int mSource;

        RecordingEvent(int event, int riid, AudioRecordingConfiguration config) {
            this.mRecEvent = event;
            this.mRIId = riid;
            if (config == null) goto L5;
            this.mClientUid = config.getClientUid();
            this.mSession = config.getClientAudioSessionId();
            this.mSource = config.getClientAudioSource();
            this.mPackName = config.getClientPackageName();
            this.mSilenced = config.isClientSilenced();
            return;
        L5:
            this.mClientUid = -1;
            this.mSession = -1;
            this.mSource = -1;
            this.mPackName = null;
            this.mSilenced = false;
        }

        private static String recordEventToString(int recEvent) {
            switch(recEvent) {
                case 0: goto L11;
                case 1: goto L9;
                case 2: goto L7;
                case 3: goto L5;
                default: goto L4;
            };
        L5:
            return BuildConfig.BUILD_TYPE;
        L7:
            return "update";
        L9:
            return IMediaProjectionManagerServiceExt.NODE_STOP;
        L11:
            return IMediaProjectionManagerServiceExt.NODE_START;
        L4:
            return "unknown (" + recEvent + ")";
        }

        @Override // com.android.server.utils.EventLogger.Event
        public String eventToString() {
            StringBuilder r0 = new StringBuilder("rec ");
            r0.append(recordEventToString(this.mRecEvent));
            r0.append(" riid:");
            r0.append(this.mRIId);
            r0.append(" uid:");
            r0.append(this.mClientUid);
            r0.append(" session:");
            r0.append(this.mSession);
            r0.append(" src:");
            r0.append(MediaRecorder.toLogFriendlyAudioSource(this.mSource));
            if (this.mSilenced == false) goto L5;
            String r1 = " silenced";
        L6:
            r0.append(r1);
            if (this.mPackName != null) goto L9;
            String r2 = "";
        L10:
            r0.append(r2);
            return r0.toString();
        L9:
            r2 = " pack:" + this.mPackName;
            goto L10
        L5:
            r1 = " not silenced";
            goto L6
        }
    }

    static final class RecordingState {
        private AudioRecordingConfiguration mConfig;
        private final RecorderDeathHandler mDeathHandler;
        private boolean mIsActive;
        private final int mRiid;

        RecordingState(int riid, RecorderDeathHandler handler) {
            this.mRiid = riid;
            this.mDeathHandler = handler;
        }

        RecordingState(AudioRecordingConfiguration config) {
            this.mRiid = -1;
            this.mDeathHandler = null;
            this.mConfig = config;
        }

        RecordingState(int riid, AudioRecordingConfiguration config) {
            this.mRiid = riid;
            this.mDeathHandler = null;
            this.mConfig = config;
        }

        int getRiid() {
            return this.mRiid;
        }

        int getPortId() {
            if (this.mConfig != null) goto L7;
            return -1;
        L7:
            return this.mConfig.getClientPortId();
        }

        AudioRecordingConfiguration getConfig() {
            return this.mConfig;
        }

        boolean hasDeathHandler() {
            if (this.mDeathHandler == null) goto L5;
            return true;
        L5:
            return false;
        }

        boolean isActiveConfiguration() {
            if (this.mIsActive == true) goto L5;
        L7:
            return false;
        L5:
            if (this.mConfig == null) goto L7;
            return true;
        }

        void release() {
            if (this.mDeathHandler == null) goto L6;
            this.mDeathHandler.release();
            return;
        }

        boolean setActive(boolean active) {
            if (this.mIsActive != active) goto L5;
            return false;
        L5:
            this.mIsActive = active;
            if (this.mConfig == null) goto L9;
            return true;
        L9:
            return false;
        }

        boolean setConfig(AudioRecordingConfiguration config) {
            if (config.equals(this.mConfig) == false) goto L6;
            return false;
        L6:
            this.mConfig = config;
            return this.mIsActive;
        }

        void dump(PrintWriter pw) {
            pw.println("riid " + this.mRiid + "; active? " + this.mIsActive);
            if (this.mConfig == null) goto L5;
            this.mConfig.dump(pw);
            return;
        L5:
            pw.println("  no config");
        }
    }

    RecordingActivityMonitor(Context ctxt) {
        this.mClients = new ArrayList();
        this.mHasPublicClients = false;
        this.mLegacyRemoteSubmixRiid = new AtomicInteger(-1);
        this.mLegacyRemoteSubmixActive = new AtomicBoolean(false);
        this.mRecordStates = new ArrayList();
        RecMonitorClient.sMonitor = this;
        RecorderDeathHandler.sMonitor = this;
        this.mPackMan = ctxt.getPackageManager();
        this.mRecordingActivityMonitorExt = RecordingActivityMonitorExt.get(this);
        this.mRecordingActivityMonitorExt.init_onEnd(ctxt);
    }

    public void onRecordingConfigurationChanged(int event, int riid, int uid, int session, int source, int portId, boolean silenced, int[] recordingInfo, AudioEffect.Descriptor[] clientEffects, AudioEffect.Descriptor[] effects, int activeSource, String packName) {
        AudioRecordingConfiguration config = createRecordingConfiguration(uid, session, source, recordingInfo, portId, silenced, activeSource, clientEffects, effects);
        this.mRecordingActivityMonitorExt.onRecordingConfigurationChanged_afterCreatingRecordingConfiguration(event, riid, config);
        if (source != 8) goto L13;
        if (event != 0) goto L6;
    L7:
        AudioDeviceInfo device = config.getAudioDevice();
        if (device == null) goto L13;
        if ("0".equals(device.getAddress()) == false) goto L13;
        this.mLegacyRemoteSubmixRiid.set(riid);
        this.mLegacyRemoteSubmixActive.set(true);
        goto L13
    L6:
        if (event == 2) goto L7;
    L13:
        if (MediaRecorder.isSystemOnlyAudioSource(source) == false) goto L16;
        sEventLogger.enqueue(new RecordingEvent(event, riid, config).printLog(TAG));
        return;
    L16:
        dispatchCallbacks(updateSnapshot(event, riid, config));
    }

    public int trackRecorder(IBinder recorder) {
        if (recorder != null) goto L6;
        Log.e(TAG, "trackRecorder called with null token");
        return -1;
    L6:
        int newRiid = AudioSystem.newAudioRecorderId();
        RecorderDeathHandler handler = new RecorderDeathHandler(newRiid, recorder);
        if (handler.init() == true) goto L9;
        return -1;
    L9:
        List<RecordingState> r0 = this.mRecordStates;
        monitor-enter(r0);
        this.mRecordStates.add(new RecordingState(newRiid, handler));     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return newRiid;
    L14:
        th = move-exception;
        throw th;
    }

    public void recorderEvent(int riid, int event) {
        int configEvent = 0;
        if (this.mLegacyRemoteSubmixRiid.get() != riid) goto L10;
        AtomicBoolean r0 = this.mLegacyRemoteSubmixActive;
        if (event != 0) goto L7;
        boolean r3 = true;
    L8:
        r0.set(r3);
        goto L10
    L7:
        r3 = false;
    L10:
        if (event == 0) goto L16;
        if (event != 1) goto L14;
        configEvent = 1;
        goto L16
    L14:
        configEvent = -1;
    L16:
        if (riid == (-1)) goto L21;
        if (configEvent == (-1)) goto L21;
        this.mRecordingActivityMonitorExt.recorderEvent_beforeDispatchCallbacks(configEvent, riid);
        dispatchCallbacks(updateSnapshot(configEvent, riid, null));
        return;
    L21:
        sEventLogger.enqueue(new RecordingEvent(event, riid, null).printLog(TAG));
    }

    public void releaseRecorder(int riid) {
        this.mRecordingActivityMonitorExt.releaseRecorder_beforeDispatchCallbacks(riid);
        dispatchCallbacks(updateSnapshot(3, riid, null));
    }

    public boolean isRecordingActiveForUid(int uid) {
        List<RecordingState> r0 = this.mRecordStates;
        monitor-enter(r0);
        Iterator<RecordingState> r1 = this.mRecordStates.iterator();     // Catch: Throwable -> L16
    L6:
        if (r1.hasNext() == false) goto L19;
        RecordingState state = r1.next();     // Catch: Throwable -> L16
        if (state.isActiveConfiguration() == false) goto L6;
        if (state.getConfig().getClientUid() != uid) goto L6;
        if (state.getConfig().isClientSilenced() == true) goto L6;
        monitor-exit(r0);     // Catch: Throwable -> L16
        return true;
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return false;
    L16:
        th = move-exception;
        throw th;
    }

    private void dispatchCallbacks(List<AudioRecordingConfiguration> configs) {
        if (configs != null) goto L4;
        return;
    L4:
        ArrayList<RecMonitorClient> r0 = this.mClients;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (this.mHasPublicClients == false) goto L11;
        List<AudioRecordingConfiguration> configsPublic = anonymizeForPublicConsumption(configs);     // Catch: Throwable -> L9
    L12:
        Iterator<RecMonitorClient> r2 = this.mClients.iterator();     // Catch: Throwable -> L9
    L14:
        if (r2.hasNext() == false) goto L26;
        RecMonitorClient rmc = r2.next();     // Catch: Throwable -> L9
        if (rmc.mIsPrivileged == false) goto L21;
        rmc.mDispatcherCb.dispatchRecordingConfigChange(configs);     // Catch: Throwable -> L9 RemoteException -> L19
        goto L14
    L21:
        rmc.mDispatcherCb.dispatchRecordingConfigChange(configsPublic);     // Catch: Throwable -> L9 RemoteException -> L19
        goto L14
    L19:
        e = move-exception;
        Log.w(TAG, "Could not call dispatchRecordingConfigChange() on client", e);     // Catch: Throwable -> L9
        goto L14
    L26:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        configsPublic = new ArrayList();     // Catch: Throwable -> L9
        goto L12
    }

    protected void dump(PrintWriter pw) {
        pw.println("\nRecordActivityMonitor dump time: " + DateFormat.getTimeInstance().format(new Date()));
        List<RecordingState> r0 = this.mRecordStates;
        monitor-enter(r0);
        Iterator<RecordingState> r1 = this.mRecordStates.iterator();     // Catch: Throwable -> L8
    L6:
        if (r1.hasNext() == false) goto L10;
        RecordingState state = r1.next();     // Catch: Throwable -> L8
        state.dump(pw);     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        pw.println("\n");
        sEventLogger.dump(pw);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static ArrayList<AudioRecordingConfiguration> anonymizeForPublicConsumption(List<AudioRecordingConfiguration> sysConfigs) {
        ArrayList<AudioRecordingConfiguration> publicConfigs = new ArrayList();
        Iterator<AudioRecordingConfiguration> r1 = sysConfigs.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        AudioRecordingConfiguration config = r1.next();
        publicConfigs.add(AudioRecordingConfiguration.anonymizedCopy(config));
        goto L4
    L6:
        return publicConfigs;
    }

    void initMonitor() {
        AudioSystem.setRecordingCallback(this);
    }

    void onAudioServerDied() {
        List<AudioRecordingConfiguration> configs = null;
        List<RecordingState> r1 = this.mRecordStates;
        monitor-enter(r1);
        boolean configChanged = false;
        Iterator<RecordingState> it = this.mRecordStates.iterator();     // Catch: Throwable -> L13
    L7:
        if (it.hasNext() == false) goto L18;
        RecordingState state = it.next();     // Catch: Throwable -> L13
        if (state.hasDeathHandler() == true) goto L7;
        if (state.isActiveConfiguration() == false) goto L15;
        configChanged = true;
        sEventLogger.enqueue(new RecordingEvent(3, state.getRiid(), state.getConfig()));     // Catch: Throwable -> L13
        this.mRecordingActivityMonitorExt.onAudioServerDied_beforeRemovingRecordingState(state.getRiid(), state.getConfig());     // Catch: Throwable -> L13
    L15:
        it.remove();     // Catch: Throwable -> L13
        goto L7
    L18:
        if (configChanged == false) goto L20;
        configs = getActiveRecordingConfigurations(true);     // Catch: Throwable -> L13
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L13
        dispatchCallbacks(configs);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    void registerRecordingCallback(IRecordingConfigDispatcher rcdb, boolean isPrivileged) {
        if (rcdb != null) goto L4;
        return;
    L4:
        ArrayList<RecMonitorClient> r0 = this.mClients;
        monitor-enter(r0);
        RecMonitorClient rmc = new RecMonitorClient(rcdb, isPrivileged);     // Catch: Throwable -> L10
        if (rmc.init() == false) goto L13;
        if (isPrivileged == true) goto L12;
        this.mHasPublicClients = true;     // Catch: Throwable -> L10
    L12:
        this.mClients.add(rmc);     // Catch: Throwable -> L10
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    void unregisterRecordingCallback(IRecordingConfigDispatcher rcdb) {
        if (rcdb != null) goto L4;
        return;
    L4:
        ArrayList<RecMonitorClient> r0 = this.mClients;
        monitor-enter(r0);
        Iterator<RecMonitorClient> clientIterator = this.mClients.iterator();     // Catch: Throwable -> L12
        boolean hasPublicClients = false;
    L8:
        if (clientIterator.hasNext() == false) goto L18;
        RecMonitorClient rmc = clientIterator.next();     // Catch: Throwable -> L12
        if (rcdb.asBinder().equals(rmc.mDispatcherCb.asBinder()) == false) goto L15;
        rmc.release();     // Catch: Throwable -> L12
        clientIterator.remove();     // Catch: Throwable -> L12
        goto L8
    L15:
        if (rmc.mIsPrivileged == true) goto L8;
        hasPublicClients = true;
        goto L8
    L18:
        this.mHasPublicClients = hasPublicClients;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    List<AudioRecordingConfiguration> getActiveRecordingConfigurations(boolean isPrivileged) {
        List<AudioRecordingConfiguration> configs = new ArrayList();
        List<RecordingState> r1 = this.mRecordStates;
        monitor-enter(r1);
        Iterator<RecordingState> r2 = this.mRecordStates.iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L13;
        RecordingState state = r2.next();     // Catch: Throwable -> L10
        if (state.isActiveConfiguration() == false) goto L6;
        configs.add(state.getConfig());     // Catch: Throwable -> L10
        goto L6
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L10
        if (isPrivileged == false) goto L16;
        return configs;
    L16:
        return anonymizeForPublicConsumption(configs);
    L10:
        th = move-exception;
        throw th;
    }

    boolean isLegacyRemoteSubmixActive() {
        return this.mLegacyRemoteSubmixActive.get();
    }

    private AudioRecordingConfiguration createRecordingConfiguration(int uid, int session, int source, int[] recordingInfo, int portId, boolean silenced, int activeSource, AudioEffect.Descriptor[] clientEffects, AudioEffect.Descriptor[] effects) {
        AudioFormat clientFormat = new AudioFormat.Builder().setEncoding(recordingInfo[0]).setChannelMask(recordingInfo[1]).setSampleRate(recordingInfo[2]).build();
        AudioFormat deviceFormat = new AudioFormat.Builder().setEncoding(recordingInfo[3]).setChannelMask(recordingInfo[4]).setSampleRate(recordingInfo[5]).build();
        int patchHandle = recordingInfo[6];
        String[] packages = this.mPackMan.getPackagesForUid(uid);
        if (packages != null) goto L5;
    L7:
        String packageName = "";
    L9:
        return new AudioRecordingConfiguration(uid, session, source, clientFormat, deviceFormat, patchHandle, packageName, portId, silenced, activeSource, clientEffects, effects);
    L5:
        if (packages.length <= 0) goto L7;
        packageName = packages[0];
        goto L9
    }

    private List<AudioRecordingConfiguration> updateSnapshot(int event, int riid, AudioRecordingConfiguration config) {
        List<AudioRecordingConfiguration> configs = null;
        List<RecordingState> r1 = this.mRecordStates;
        monitor-enter(r1);
        int stateIndex = -1;
        if (riid == (-1)) goto L9;
        stateIndex = findStateByRiid(riid);     // Catch: Throwable -> L7
    L12:
        if (stateIndex != (-1)) goto L20;
        if (event != 0) goto L16;
        if (config == null) goto L16;
        this.mRecordStates.add(new RecordingState(riid, config));     // Catch: Throwable -> L7
        stateIndex = this.mRecordStates.size() - 1;     // Catch: Throwable -> L7
    L16:
        if (config != null) goto L18;
        Log.e(TAG, String.format("Unexpected event %d for riid %d", new Object[]{Integer.valueOf(event), Integer.valueOf(riid)}));     // Catch: Throwable -> L7
    L18:
        monitor-exit(r1);     // Catch: Throwable -> L7
        return null;
    L20:
        RecordingState state = this.mRecordStates.get(stateIndex);     // Catch: Throwable -> L7
        boolean configChanged = false;
        switch(event) {
            case 0: goto L38;
            case 1: goto L31;
            case 2: goto L28;
            case 3: goto L23;
            default: goto L22;
        };     // Catch: Throwable -> L7
    L22:
        Log.e(TAG, String.format("Unknown event %d for riid %d / portid %d", new Object[]{Integer.valueOf(event), Integer.valueOf(riid), Integer.valueOf(state.getPortId())}));     // Catch: Throwable -> L7
        configChanged = false;
    L48:
        if (configChanged == false) goto L50;
        sEventLogger.enqueue(new RecordingEvent(event, riid, state.getConfig()));     // Catch: Throwable -> L7
        configs = getActiveRecordingConfigurations(true);     // Catch: Throwable -> L7
    L50:
        monitor-exit(r1);     // Catch: Throwable -> L7
        return configs;
    L23:
        if (state != null) goto L25;
    L27:
        configChanged = state.isActiveConfiguration();     // Catch: Throwable -> L7
        state.release();     // Catch: Throwable -> L7
        this.mRecordStates.remove(stateIndex);     // Catch: Throwable -> L7
        goto L48
    L25:
        if (state.getConfig() == null) goto L27;
        SysOptBridge.getFactory().getSmartScenes().updateRecordingUid(state.getConfig().getClientUid(), false);     // Catch: Throwable -> L7
        goto L27
    L28:
        configChanged = state.setConfig(config);     // Catch: Throwable -> L7
        if (state.getConfig() == null) goto L48;
        SysOptBridge.getFactory().getSmartScenes().updateRecordingUid(state.getConfig().getClientUid(), true);     // Catch: Throwable -> L7
        goto L48
    L31:
        if (state != null) goto L33;
    L35:
        configChanged = state.setActive(false);     // Catch: Throwable -> L7
        if (state.hasDeathHandler() == true) goto L48;
        this.mRecordStates.remove(stateIndex);     // Catch: Throwable -> L7
        goto L48
    L33:
        if (state.getConfig() == null) goto L35;
        SysOptBridge.getFactory().getSmartScenes().updateRecordingUid(state.getConfig().getClientUid(), false);     // Catch: Throwable -> L7
        goto L35
    L38:
        boolean configChanged2 = state.setActive(true);     // Catch: Throwable -> L7
        if (config != null) goto L41;
        configChanged = configChanged2;
        goto L48
    L41:
        if (state.setConfig(config) == true) goto L43;
        if (configChanged2 == true) goto L43;
    L45:
        if (state.getConfig() == null) goto L48;
        SysOptBridge.getFactory().getSmartScenes().updateRecordingUid(state.getConfig().getClientUid(), true);     // Catch: Throwable -> L7
    L43:
        configChanged = true;
        goto L45
    L9:
        if (config == null) goto L12;
        stateIndex = findStateByPortId(config.getClientPortId());     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    private int findStateByRiid(int riid) {
        List<RecordingState> r0 = this.mRecordStates;
        monitor-enter(r0);
        int i = 0;
    L20:
    L11:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mRecordStates.size()) goto L15;
        if (this.mRecordStates.get(i).getRiid() == riid) goto L9;
        i = i + 1;     // Catch: Throwable -> L11
        goto L20
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return i;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return -1;
    }

    private int findStateByPortId(int portId) {
        List<RecordingState> r0 = this.mRecordStates;
        monitor-enter(r0);
        int i = 0;
    L22:
    L13:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mRecordStates.size()) goto L17;
        if (this.mRecordStates.get(i).hasDeathHandler() == true) goto L15;
        if (this.mRecordStates.get(i).getPortId() != portId) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return i;
    L15:
        i = i + 1;     // Catch: Throwable -> L13
        goto L22
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return -1;
    }

    static {
        sEventLogger = new EventLogger(50, "recording activity received by AudioService");
    }
}
