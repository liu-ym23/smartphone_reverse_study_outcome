package com.android.server.audio;

import android.media.AudioAttributes;
import android.media.AudioDeviceAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioPlaybackConfiguration;
import android.media.AudioSystem;
import android.media.ILoudnessCodecUpdatesDispatcher;
import android.media.LoudnessCodecInfo;
import android.media.permission.ClearCallingIdentityContext;
import android.media.permission.SafeCloseable;
import android.os.Binder;
import android.os.IInterface;
import android.os.PersistableBundle;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.util.Log;
import android.util.SparseIntArray;
import com.android.server.utils.EventLogger;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes.dex */
public class LoudnessCodecHelper {
    private static final boolean DEBUG = false;
    static final int SPL_RANGE_LARGE = 3;
    static final int SPL_RANGE_MEDIUM = 2;
    static final int SPL_RANGE_SMALL = 1;
    static final int SPL_RANGE_UNKNOWN = 0;
    private static final String SYSTEM_PROPERTY_SPEAKER_SPL_RANGE_SIZE = "audio.loudness.builtin-speaker-spl-range-size";
    private static final String TAG = "AS.LoudnessCodecHelper";
    private static final EventLogger sLogger = null;
    private final AudioService mAudioService;
    private final HashMap<LoudnessCodecInputProperties, PersistableBundle> mCachedProperties;
    private final Object mDispatcherLock;
    private final Object mLock;
    private final LoudnessRemoteCallbackList mLoudnessUpdateDispatchers;
    private final SparseIntArray mPiidToDeviceIdCache;
    private final SparseIntArray mPiidToPidCache;
    private final HashMap<LoudnessTrackId, Set<LoudnessCodecInfo>> mStartedConfigInfo;
    private final HashMap<LoudnessTrackId, Set<Integer>> mStartedConfigPiids;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DeviceSplRange {
    }

    static final class LoudnessCodecInputProperties {
        private final int mDeviceSplRange;
        private final boolean mIsDownmixing;
        private final int mMetadataType;

        static final class Builder {
            private int mDeviceSplRange;
            private boolean mIsDownmixing;
            private int mMetadataType;

            Builder() {
            }

            Builder setMetadataType(int metadataType) {
                this.mMetadataType = metadataType;
                return this;
            }

            Builder setIsDownmixing(boolean isDownmixing) {
                this.mIsDownmixing = isDownmixing;
                return this;
            }

            Builder setDeviceSplRange(int deviceSplRange) {
                this.mDeviceSplRange = deviceSplRange;
                return this;
            }

            LoudnessCodecInputProperties build() {
                return new LoudnessCodecInputProperties(this.mMetadataType, this.mIsDownmixing, this.mDeviceSplRange, null);
            }
        }

        /* synthetic */ LoudnessCodecInputProperties(int r1, boolean r2, int r3, LoudnessCodecHelperIA r4) {
            this(r1, r2, r3);
        }

        private LoudnessCodecInputProperties(int metadataType, boolean isDownmixing, int deviceSplRange) {
            this.mMetadataType = metadataType;
            this.mIsDownmixing = isDownmixing;
            this.mDeviceSplRange = deviceSplRange;
        }

        public boolean equals(Object obj) {
            if (this != obj) goto L6;
            return true;
        L6:
            if (obj != null) goto L9;
            return false;
        L9:
            if (getClass() == obj.getClass()) goto L11;
            return false;
        L11:
            LoudnessCodecInputProperties lcip = (LoudnessCodecInputProperties) obj;
            if (this.mMetadataType != lcip.mMetadataType) goto L19;
            if (this.mIsDownmixing != lcip.mIsDownmixing) goto L19;
            if (this.mDeviceSplRange != lcip.mDeviceSplRange) goto L19;
            return true;
        L19:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.mMetadataType), Boolean.valueOf(this.mIsDownmixing), Integer.valueOf(this.mDeviceSplRange)});
        }

        public String toString() {
            return "Loudness properties: device SPL range: " + LoudnessCodecHelper.m2145$$Nest$smsplRangeToString(this.mDeviceSplRange) + " down-mixing: " + this.mIsDownmixing + " metadata type: " + this.mMetadataType;
        }

        PersistableBundle createLoudnessParameters() {
            PersistableBundle r0 = new PersistableBundle();
            int r2 = 0;
            switch(this.mDeviceSplRange) {
                case 1: goto L25;
                case 2: goto L19;
                case 3: goto L13;
                default: goto L4;
            };
        L4:
            r0.putInt("aac-target-ref-level", 96);
            if (this.mMetadataType != 1) goto L11;
            if (this.mIsDownmixing == false) goto L9;
            r2 = 1;
        L9:
            r0.putInt("aac-drc-heavy-compression", r2);
        L31:
            return r0;
        L11:
            if (this.mMetadataType != 2) goto L31;
            r0.putInt("aac-drc-effect-type", 6);
            goto L31
        L13:
            r0.putInt("aac-target-ref-level", 124);
            if (this.mMetadataType != 1) goto L17;
            r0.putInt("aac-drc-heavy-compression", 0);
            goto L31
        L17:
            if (this.mMetadataType != 2) goto L31;
            r0.putInt("aac-drc-effect-type", 6);
            goto L31
        L19:
            r0.putInt("aac-target-ref-level", 96);
            if (this.mMetadataType != 1) goto L23;
            r0.putInt("aac-drc-heavy-compression", this.mIsDownmixing ? 1 : 0);
            goto L31
        L23:
            if (this.mMetadataType != 2) goto L31;
            r0.putInt("aac-drc-effect-type", 6);
            goto L31
        L25:
            r0.putInt("aac-target-ref-level", 64);
            if (this.mMetadataType != 1) goto L29;
            r0.putInt("aac-drc-heavy-compression", 1);
            goto L31
        L29:
            if (this.mMetadataType != 2) goto L31;
            r0.putInt("aac-drc-effect-type", 3);
            goto L31
        }
    }

    private static final class LoudnessRemoteCallbackList extends RemoteCallbackList<ILoudnessCodecUpdatesDispatcher> {
        private final LoudnessCodecHelper mLoudnessCodecHelper;

        @Override // android.os.RemoteCallbackList
        public /* bridge */ /* synthetic */ void onCallbackDied(IInterface r1, Object r2) {
            onCallbackDied((ILoudnessCodecUpdatesDispatcher) r1, r2);
        }

        LoudnessRemoteCallbackList(LoudnessCodecHelper loudnessCodecHelper) {
            this.mLoudnessCodecHelper = loudnessCodecHelper;
        }

        public void onCallbackDied(ILoudnessCodecUpdatesDispatcher callback, Object cookie) {
            Integer pid = null;
            if ((cookie instanceof Integer) == false) goto L5;
            pid = (Integer) cookie;
        L5:
            if (pid == null) goto L7;
            LoudnessCodecHelper.m2144$$Nest$sfgetsLogger().enqueue(AudioServiceEvents.LoudnessEvent.getClientDied(pid.intValue()));
            LoudnessCodecHelper.m2143$$Nest$monClientPidDied(this.mLoudnessCodecHelper, pid.intValue());
        L7:
            super.onCallbackDied(callback, cookie);
        }
    }

    static final class LoudnessTrackId {
        private final int mPid;
        private final int mSessionId;

        /* JADX INFO: renamed from: -$$Nest$fgetmPid, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m2146$$Nest$fgetmPid(LoudnessTrackId r0) {
            return r0.mPid;
        }

        /* synthetic */ LoudnessTrackId(int r1, int r2, LoudnessCodecHelperIA r3) {
            this(r1, r2);
        }

        private LoudnessTrackId(int sessionId, int pid) {
            this.mSessionId = sessionId;
            this.mPid = pid;
        }

        public boolean equals(Object obj) {
            if (this != obj) goto L6;
            return true;
        L6:
            if (obj != null) goto L9;
            return false;
        L9:
            if (getClass() == obj.getClass()) goto L11;
            return false;
        L11:
            LoudnessTrackId lti = (LoudnessTrackId) obj;
            if (this.mSessionId != lti.mSessionId) goto L17;
            if (this.mPid != lti.mPid) goto L17;
            return true;
        L17:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.mSessionId), Integer.valueOf(this.mPid)});
        }

        public String toString() {
            return "Loudness track id: session ID: " + this.mSessionId + " pid: " + this.mPid;
        }
    }

    public static /* synthetic */ void $r8$lambda$Ajcn9BvyI0W7WD6temMDzo_JpWE(LoudnessCodecHelper r0, AudioPlaybackConfiguration r1) {
        r0.updateCodecParametersForConfiguration(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$QMGLUxl1YafNqp8Zhcj3n2OqJPo(int r0, int r1, AudioPlaybackConfiguration r2) {
        return lambda$addLoudnessCodecInfo$2(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$ZGgIBkkFUgAmKH1I5GVSQ8sDWFU(LoudnessCodecHelper r0, HashSet r1, int r2, AudioPlaybackConfiguration r3) {
        r0.lambda$startLoudnessCodecUpdates$1(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$tG2UQ_Gx-U1MRWCSRLcaixSVMPo, reason: not valid java name */
    public static /* synthetic */ boolean m2142$r8$lambda$tG2UQ_GxU1MRWCSRLcaixSVMPo(int r0, Map.Entry r1) {
        return lambda$onClientPidDied$3(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$tsoYN4BPDMPKxwL5Bx4EhDIiuok(int r0, int r1, AudioPlaybackConfiguration r2) {
        return lambda$startLoudnessCodecUpdates$0(r0, r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$utGdds8PGTb38gBf05StyRB2eTQ(int r0, Map.Entry r1) {
        return lambda$onClientPidDied$4(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monClientPidDied, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2143$$Nest$monClientPidDied(LoudnessCodecHelper r0, int r1) {
        r0.onClientPidDied(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsLogger, reason: not valid java name */
    static /* bridge */ /* synthetic */ EventLogger m2144$$Nest$sfgetsLogger() {
        return sLogger;
    }

    /* JADX INFO: renamed from: -$$Nest$smsplRangeToString, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m2145$$Nest$smsplRangeToString(int r0) {
        return splRangeToString(r0);
    }

    static {
        sLogger = new EventLogger(30, "Loudness updates");
    }

    LoudnessCodecHelper(AudioService audioService) {
        this.mDispatcherLock = new Object();
        this.mLoudnessUpdateDispatchers = new LoudnessRemoteCallbackList(this);
        this.mLock = new Object();
        this.mStartedConfigPiids = new HashMap();
        this.mStartedConfigInfo = new HashMap();
        this.mPiidToDeviceIdCache = new SparseIntArray();
        this.mPiidToPidCache = new SparseIntArray();
        this.mCachedProperties = new HashMap();
        audioService.getClass();
        this.mAudioService = audioService;
    }

    void registerLoudnessCodecUpdatesDispatcher(ILoudnessCodecUpdatesDispatcher dispatcher) {
        Object r0 = this.mDispatcherLock;
        monitor-enter(r0);
        this.mLoudnessUpdateDispatchers.register(dispatcher, Integer.valueOf(Binder.getCallingPid()));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void unregisterLoudnessCodecUpdatesDispatcher(ILoudnessCodecUpdatesDispatcher dispatcher) {
        Object r0 = this.mDispatcherLock;
        monitor-enter(r0);
        this.mLoudnessUpdateDispatchers.unregister(dispatcher);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void startLoudnessCodecUpdates(final int sessionId) {
        final int pid = Binder.getCallingPid();
        LoudnessTrackId newConfig = new LoudnessTrackId(sessionId, pid, null);
        Object r2 = this.mLock;
        monitor-enter(r2);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mStartedConfigInfo.containsKey(newConfig) == false) goto L11;
        Log.w(TAG, "Already started loudness updates for config: " + newConfig);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        return;
    L11:
        this.mStartedConfigInfo.put(newConfig, new HashSet());     // Catch: Throwable -> L9
        final HashSet<Integer> newPiids = new HashSet();     // Catch: Throwable -> L9
        this.mStartedConfigPiids.put(newConfig, newPiids);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        SafeCloseable ignored = ClearCallingIdentityContext.create();
        this.mAudioService.getActivePlaybackConfigurations().stream().filter(new LoudnessCodecHelper$$ExternalSyntheticLambda2(sessionId, pid)).forEach(new LoudnessCodecHelper$$ExternalSyntheticLambda3(this, newPiids, pid));     // Catch: Throwable -> L18
        if (ignored == null) goto L32;
        ignored.close();
        return;
    L32:
        return;
    L18:
        th = move-exception;
        if (ignored != null) goto L27;
    L24:
        throw th;
    L27:
        ignored.close();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        th.addSuppressed(th);
        goto L24
    }

    private static /* synthetic */ boolean lambda$startLoudnessCodecUpdates$0(int sessionId, int pid, AudioPlaybackConfiguration conf) {
        if (conf.getSessionId() == sessionId) goto L5;
    L7:
        return false;
    L5:
        if (conf.getClientPid() != pid) goto L7;
        return true;
    }

    private /* synthetic */ void lambda$startLoudnessCodecUpdates$1(HashSet newPiids, int pid, AudioPlaybackConfiguration apc) {
        int piid = apc.getPlayerInterfaceId();
        Object r1 = this.mLock;
        monitor-enter(r1);
        newPiids.add(Integer.valueOf(piid));     // Catch: Throwable -> L7
        this.mPiidToPidCache.put(piid, pid);     // Catch: Throwable -> L7
        sLogger.enqueue(AudioServiceEvents.LoudnessEvent.getStartPiid(piid, pid));     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void stopLoudnessCodecUpdates(int sessionId) {
        int pid = Binder.getCallingPid();
        LoudnessTrackId config = new LoudnessTrackId(sessionId, pid, null);
        Object r2 = this.mLock;
        monitor-enter(r2);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mStartedConfigInfo.containsKey(config) == true) goto L11;
        Log.w(TAG, "Loudness updates are already stopped config: " + config);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        return;
    L11:
        Set<Integer> startedPiidSet = this.mStartedConfigPiids.get(config);     // Catch: Throwable -> L9
        if (startedPiidSet != null) goto L16;
        Log.e(TAG, "Loudness updates are already stopped config: " + config);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        return;
    L16:
        Iterator<Integer> r4 = startedPiidSet.iterator();     // Catch: Throwable -> L9
    L18:
        if (r4.hasNext() == false) goto L20;
        Integer piid = r4.next();     // Catch: Throwable -> L9
        sLogger.enqueue(AudioServiceEvents.LoudnessEvent.getStopPiid(piid.intValue(), this.mPiidToPidCache.get(piid.intValue(), -1)));     // Catch: Throwable -> L9
        this.mPiidToDeviceIdCache.delete(piid.intValue());     // Catch: Throwable -> L9
        this.mPiidToPidCache.delete(piid.intValue());     // Catch: Throwable -> L9
        goto L18
    L20:
        this.mStartedConfigPiids.remove(config);     // Catch: Throwable -> L9
        this.mStartedConfigInfo.remove(config);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
    }

    void addLoudnessCodecInfo(final int sessionId, int mediaCodecHash, LoudnessCodecInfo info) {
        final int pid = Binder.getCallingPid();
        LoudnessTrackId config = new LoudnessTrackId(sessionId, pid, null);
        Object r2 = this.mLock;
        monitor-enter(r2);
    L39:
        th = move-exception;
        throw th;
    L5:
        if (this.mStartedConfigInfo.containsKey(config) == false) goto L41;
        if (this.mStartedConfigPiids.containsKey(config) == false) goto L41;
        Set<Integer> piids = this.mStartedConfigPiids.get(config);     // Catch: Throwable -> L39
        Set<LoudnessCodecInfo> infoSet = this.mStartedConfigInfo.get(config);     // Catch: Throwable -> L39
        infoSet.add(info);     // Catch: Throwable -> L39
        monitor-exit(r2);     // Catch: Throwable -> L39
        SafeCloseable ignored = ClearCallingIdentityContext.create();
        PersistableBundle updateBundle = new PersistableBundle();     // Catch: Throwable -> L15
        Optional<AudioPlaybackConfiguration> apc = this.mAudioService.getActivePlaybackConfigurations().stream().filter(new LoudnessCodecHelper$$ExternalSyntheticLambda6(sessionId, pid)).findFirst();     // Catch: Throwable -> L15
        if (apc.isEmpty() == false) goto L17;
        updateBundle.putPersistableBundle(Integer.toString(mediaCodecHash), getLoudnessParams(info));     // Catch: Throwable -> L15
    L28:
        if (updateBundle.isDefinitelyEmpty() == true) goto L30;
        dispatchNewLoudnessParameters(sessionId, updateBundle);     // Catch: Throwable -> L15
    L30:
        if (ignored == null) goto L52;
        ignored.close();
        return;
    L52:
        return;
    L17:
        AudioDeviceInfo deviceInfo = apc.get().getAudioDeviceInfo();     // Catch: Throwable -> L15
        if (deviceInfo == null) goto L28;
        Object r8 = this.mLock;     // Catch: Throwable -> L15
        monitor-enter(r8);     // Catch: Throwable -> L15
        piids.add(Integer.valueOf(apc.get().getPlayerInterfaceId()));     // Catch: Throwable -> L24
        updateBundle.putPersistableBundle(Integer.toString(mediaCodecHash), getCodecBundle_l(deviceInfo.getInternalType(), deviceInfo.getAddress(), info));     // Catch: Throwable -> L24
        monitor-exit(r8);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        if (ignored != null) goto L46;
    L38:
        throw th;
    L46:
        ignored.close();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        th.addSuppressed(th);
    L41:
        Log.w(TAG, "Cannot add new loudness info for stopped config " + config);     // Catch: Throwable -> L39
        monitor-exit(r2);     // Catch: Throwable -> L39
    }

    private static /* synthetic */ boolean lambda$addLoudnessCodecInfo$2(int sessionId, int pid, AudioPlaybackConfiguration conf) {
        if (conf.getSessionId() == sessionId) goto L5;
    L7:
        return false;
    L5:
        if (conf.getClientPid() != pid) goto L7;
        return true;
    }

    void removeLoudnessCodecInfo(int sessionId, LoudnessCodecInfo codecInfo) {
        int pid = Binder.getCallingPid();
        LoudnessTrackId config = new LoudnessTrackId(sessionId, pid, null);
        Object r2 = this.mLock;
        monitor-enter(r2);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mStartedConfigInfo.containsKey(config) == false) goto L16;
        if (this.mStartedConfigPiids.containsKey(config) == false) goto L16;
        Set<LoudnessCodecInfo> codecInfos = this.mStartedConfigInfo.get(config);     // Catch: Throwable -> L12
        if (codecInfos.remove(codecInfo) == true) goto L14;
        Log.w(TAG, "Could not find to remove codecInfo " + codecInfo);     // Catch: Throwable -> L12
    L14:
        monitor-exit(r2);     // Catch: Throwable -> L12
        return;
    L16:
        Log.w(TAG, "Cannot remove loudness info for stopped config " + config);     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
    }

    PersistableBundle getLoudnessParams(LoudnessCodecInfo codecInfo) {
        ArrayList<AudioDeviceAttributes> devicesForAttributes = this.mAudioService.getDevicesForAttributesInt(new AudioAttributes.Builder().setUsage(1).setContentType(2).build(), false);
        if (devicesForAttributes.isEmpty() == true) goto L13;
        AudioDeviceAttributes audioDeviceAttribute = devicesForAttributes.get(0);
        Object r2 = this.mLock;
        monitor-enter(r2);
        PersistableBundle r3 = getCodecBundle_l(audioDeviceAttribute.getInternalType(), audioDeviceAttribute.getAddress(), codecInfo);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    L13:
        return new PersistableBundle();
    }

    void updateCodecParameters(List<AudioPlaybackConfiguration> configs) {
        List<AudioPlaybackConfiguration> updateApcList = new ArrayList();
        Object r1 = this.mLock;
        monitor-enter(r1);
        Iterator<AudioPlaybackConfiguration> r2 = configs.iterator();     // Catch: Throwable -> L11
    L6:
        if (r2.hasNext() == false) goto L22;
        AudioPlaybackConfiguration apc = r2.next();     // Catch: Throwable -> L11
        int piid = apc.getPlayerInterfaceId();     // Catch: Throwable -> L11
        int cachedDeviceId = this.mPiidToDeviceIdCache.get(piid, 0);     // Catch: Throwable -> L11
        AudioDeviceInfo deviceInfo = apc.getAudioDeviceInfo();     // Catch: Throwable -> L11
        if (deviceInfo == null) goto L9;
        if (cachedDeviceId == deviceInfo.getId()) goto L6;
        this.mPiidToDeviceIdCache.put(piid, deviceInfo.getId());     // Catch: Throwable -> L11
        LoudnessTrackId config = new LoudnessTrackId(apc.getSessionId(), apc.getClientPid(), null);     // Catch: Throwable -> L11
        if (this.mStartedConfigInfo.containsKey(config) == false) goto L6;
        if (this.mStartedConfigPiids.containsKey(config) == false) goto L6;
        updateApcList.add(apc);     // Catch: Throwable -> L11
        this.mStartedConfigPiids.get(config).add(Integer.valueOf(piid));     // Catch: Throwable -> L11
        goto L6
    L9:
        if (cachedDeviceId == 0) goto L6;
        this.mPiidToDeviceIdCache.delete(piid);     // Catch: Throwable -> L11
        goto L6
    L22:
        monitor-exit(r1);     // Catch: Throwable -> L11
        updateApcList.forEach(new LoudnessCodecHelper$$ExternalSyntheticLambda1(this));
        return;
    L11:
        th = move-exception;
        throw th;
    }

    void dump(PrintWriter pw) {
        pw.println("\nRegistered clients:\n");
        Object r0 = this.mLock;
        monitor-enter(r0);
        Iterator<Map.Entry<LoudnessTrackId, Set<Integer>>> r1 = this.mStartedConfigPiids.entrySet().iterator();     // Catch: Throwable -> L13
    L6:
        if (r1.hasNext() == false) goto L17;
        Map.Entry<LoudnessTrackId, Set<Integer>> entry = r1.next();     // Catch: Throwable -> L13
        Iterator<Integer> r3 = entry.getValue().iterator();     // Catch: Throwable -> L13
    L9:
        if (r3.hasNext() == false) goto L6;
        Integer piid = r3.next();     // Catch: Throwable -> L13
        int pid = this.mPiidToPidCache.get(piid.intValue(), -1);     // Catch: Throwable -> L13
        Set<LoudnessCodecInfo> codecInfos = this.mStartedConfigInfo.get(entry.getKey());     // Catch: Throwable -> L13
        if (codecInfos == null) goto L9;
        pw.println(String.format("Player piid %d pid %d active codec types %s\n", new Object[]{piid, Integer.valueOf(pid), codecInfos.stream().map(new LoudnessCodecHelper$$ExternalSyntheticLambda0()).collect(Collectors.joining(", "))}));     // Catch: Throwable -> L13
        goto L9
    L17:
        pw.println();     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        sLogger.dump(pw);
        pw.println();
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private void onClientPidDied(final int pid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int i = 0;
    L18:
    L10:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mPiidToPidCache.size()) goto L13;
        int piid = this.mPiidToPidCache.keyAt(i);     // Catch: Throwable -> L10
        if (this.mPiidToPidCache.get(piid) != pid) goto L12;
        this.mPiidToDeviceIdCache.delete(piid);     // Catch: Throwable -> L10
    L12:
        i = i + 1;     // Catch: Throwable -> L10
        goto L18
    L13:
        this.mStartedConfigPiids.entrySet().removeIf(new LoudnessCodecHelper$$ExternalSyntheticLambda4(pid));     // Catch: Throwable -> L10
        this.mStartedConfigInfo.entrySet().removeIf(new LoudnessCodecHelper$$ExternalSyntheticLambda5(pid));     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    private static /* synthetic */ boolean lambda$onClientPidDied$3(int pid, Map.Entry entry) {
        if (LoudnessTrackId.m2146$$Nest$fgetmPid((LoudnessTrackId) entry.getKey()) != pid) goto L5;
        return true;
    L5:
        return false;
    }

    private static /* synthetic */ boolean lambda$onClientPidDied$4(int pid, Map.Entry entry) {
        if (LoudnessTrackId.m2146$$Nest$fgetmPid((LoudnessTrackId) entry.getKey()) != pid) goto L5;
        return true;
    L5:
        return false;
    }

    private void updateCodecParametersForConfiguration(AudioPlaybackConfiguration apc) {
        PersistableBundle allBundles = new PersistableBundle();
        Object r1 = this.mLock;
        monitor-enter(r1);
        LoudnessTrackId config = new LoudnessTrackId(apc.getSessionId(), apc.getClientPid(), null);     // Catch: Throwable -> L13
        Set<LoudnessCodecInfo> codecInfos = this.mStartedConfigInfo.get(config);     // Catch: Throwable -> L13
        AudioDeviceInfo deviceInfo = apc.getAudioDeviceInfo();     // Catch: Throwable -> L13
        if (codecInfos == null) goto L16;
        if (deviceInfo == null) goto L16;
        Iterator<LoudnessCodecInfo> r5 = codecInfos.iterator();     // Catch: Throwable -> L13
    L9:
        if (r5.hasNext() == false) goto L16;
        LoudnessCodecInfo info = r5.next();     // Catch: Throwable -> L13
        if (info == null) goto L9;
        allBundles.putPersistableBundle(Integer.toString(info.hashCode()), getCodecBundle_l(deviceInfo.getInternalType(), deviceInfo.getAddress(), info));     // Catch: Throwable -> L13
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L13
        if (allBundles.isDefinitelyEmpty() == true) goto L28;
        dispatchNewLoudnessParameters(apc.getSessionId(), allBundles);
        return;
    L28:
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private void dispatchNewLoudnessParameters(int sessionId, PersistableBundle bundle) {
        Object r0 = this.mDispatcherLock;
        monitor-enter(r0);
        int nbDispatchers = this.mLoudnessUpdateDispatchers.beginBroadcast();     // Catch: Throwable -> L9
        int i = 0;
    L6:
        if (i >= nbDispatchers) goto L14;
        this.mLoudnessUpdateDispatchers.getBroadcastItem(i).dispatchLoudnessCodecParameterChange(sessionId, bundle);     // Catch: Throwable -> L9 RemoteException -> L11
    L13:
        i = i + 1;     // Catch: Throwable -> L9
    L11:
        e = move-exception;
        Log.e(TAG, "Error dispatching for sessionId " + sessionId + " bundle: " + bundle, e);     // Catch: Throwable -> L9
        goto L13
    L14:
        this.mLoudnessUpdateDispatchers.finishBroadcast();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private PersistableBundle getCodecBundle_l(int internalDeviceType, String address, LoudnessCodecInfo codecInfo) {
        LoudnessCodecInputProperties.Builder builder = new LoudnessCodecInputProperties.Builder();
        LoudnessCodecInputProperties prop = builder.setDeviceSplRange(getDeviceSplRange(internalDeviceType, address)).setIsDownmixing(codecInfo.isDownmixing).setMetadataType(codecInfo.metadataType).build();
        if (this.mCachedProperties.containsKey(prop) == true) goto L5;
        PersistableBundle codecBundle = prop.createLoudnessParameters();
        this.mCachedProperties.put(prop, codecBundle);
        return codecBundle;
    L5:
        return this.mCachedProperties.get(prop);
    }

    private int getDeviceSplRange(int internalDeviceType, String address) {
        SafeCloseable ignored = ClearCallingIdentityContext.create();
        int deviceCategory = this.mAudioService.getBluetoothAudioDeviceCategory(address);     // Catch: Throwable -> L41
        if (ignored == null) goto L7;
        ignored.close();
    L7:
        if (internalDeviceType != 2) goto L19;
        String splRange = SystemProperties.get(SYSTEM_PROPERTY_SPEAKER_SPL_RANGE_SIZE, "unknown");
        if (splRange.equals("unknown") == true) goto L13;
        return stringToSplRange(splRange);
    L13:
        if (this.mAudioService.isPlatformAutomotive() == false) goto L15;
    L16:
        return 2;
    L15:
        if (this.mAudioService.isPlatformTelevision() == true) goto L16;
        return 1;
    L19:
        if (internalDeviceType != 67108864) goto L21;
    L40:
        return 3;
    L21:
        if (internalDeviceType == 8) goto L40;
        if (internalDeviceType == 4) goto L40;
        if (AudioSystem.isBluetoothDevice(internalDeviceType) == false) goto L29;
        if (deviceCategory == 3) goto L40;
    L29:
        if (AudioSystem.isBluetoothDevice(internalDeviceType) == false) goto L38;
        if (deviceCategory != 4) goto L33;
        return 2;
    L33:
        if (deviceCategory != 5) goto L36;
        return 1;
    L36:
        if (deviceCategory != 6) goto L53;
        return 1;
    L53:
        return 0;
    L38:
        return 0;
    L41:
        th = move-exception;
        if (ignored != null) goto L50;
    L47:
        throw th;
    L50:
        ignored.close();     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        th.addSuppressed(th);
        goto L47
    }

    private static String splRangeToString(int splRange) {
        switch(splRange) {
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L3;
        };
    L3:
        return "unknown";
    L5:
        return "large";
    L7:
        return "medium";
    L9:
        return "small";
    }

    private static int stringToSplRange(String splRange) {
        switch(splRange.hashCode()) {
            case -1078030475: goto L12;
            case 102742843: goto L9;
            case 109548807: goto L6;
            default: goto L14;
        };
    L14:
        byte r0 = -1;
    L15:
        switch(r0) {
            case 0: goto L19;
            case 1: goto L18;
            case 2: goto L17;
            default: goto L16;
        };
    L16:
        return 0;
    L17:
        return 1;
    L18:
        return 2;
    L19:
        return 3;
    L6:
        if (splRange.equals("small") == false) goto L14;
        r0 = 2;
        goto L15
    L9:
        if (splRange.equals("large") == false) goto L14;
        r0 = 0;
        goto L15
    L12:
        if (splRange.equals("medium") == false) goto L14;
        r0 = 1;
        goto L15
    }
}
