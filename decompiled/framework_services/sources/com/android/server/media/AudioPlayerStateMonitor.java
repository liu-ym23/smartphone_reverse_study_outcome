package com.android.server.media;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioPlaybackConfiguration;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Log;
import com.android.server.SysOptBridge;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class AudioPlayerStateMonitor {
    private static final boolean DEBUG = false;
    private static String TAG;
    private static AudioPlayerStateMonitor sInstance;
    final Set<Integer> mActiveAudioUids;
    private final Map<OnAudioPlayerActiveStateChangedListener, MessageHandler> mListenerMap;
    private final Object mLock;
    ArrayMap<Integer, AudioPlaybackConfiguration> mPrevActiveAudioPlaybackConfigs;
    final List<Integer> mSortedAudioPlaybackClientUids;

    private class AudioManagerPlaybackListener extends AudioManager.AudioPlaybackCallback {
        final /* synthetic */ AudioPlayerStateMonitor this$0;

        /* synthetic */ AudioManagerPlaybackListener(AudioPlayerStateMonitor r1, AudioPlayerStateMonitorIA r2) {
            this(r1);
        }

        private AudioManagerPlaybackListener(AudioPlayerStateMonitor r1) {
            this.this$0 = r1;
        }

        @Override // android.media.AudioManager.AudioPlaybackCallback
        public void onPlaybackConfigChanged(List<AudioPlaybackConfiguration> configs) {
            SysOptBridge.getFactory().getAppRecordManagerService().onPlaybackConfigChanged(configs);
            Object r0 = AudioPlayerStateMonitor.m5505$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            this.this$0.mActiveAudioUids.clear();     // Catch: Throwable -> L10
            ArrayMap<Integer, AudioPlaybackConfiguration> activeAudioPlaybackConfigs = new ArrayMap();     // Catch: Throwable -> L10
            Iterator<AudioPlaybackConfiguration> r2 = configs.iterator();     // Catch: Throwable -> L10
        L6:
            if (r2.hasNext() == false) goto L13;
            AudioPlaybackConfiguration config = r2.next();     // Catch: Throwable -> L10
            if (config.isActive() == false) goto L6;
            this.this$0.mActiveAudioUids.add(Integer.valueOf(config.getClientUid()));     // Catch: Throwable -> L10
            activeAudioPlaybackConfigs.put(Integer.valueOf(config.getPlayerInterfaceId()), config);     // Catch: Throwable -> L10
            goto L6
        L13:
            int i = 0;
        L15:
            if (i >= activeAudioPlaybackConfigs.size()) goto L29;
            AudioPlaybackConfiguration config2 = activeAudioPlaybackConfigs.valueAt(i);     // Catch: Throwable -> L10
            int uid = config2.getClientUid();     // Catch: Throwable -> L10
            if (this.this$0.mPrevActiveAudioPlaybackConfigs.containsKey(Integer.valueOf(config2.getPlayerInterfaceId())) == true) goto L27;
            if (AudioPlayerStateMonitor.m5507$$Nest$sfgetDEBUG() == false) goto L21;
            Log.d(AudioPlayerStateMonitor.m5508$$Nest$sfgetTAG(), "Found a new active media playback. " + config2);     // Catch: Throwable -> L10
        L21:
            int index = this.this$0.mSortedAudioPlaybackClientUids.indexOf(Integer.valueOf(uid));     // Catch: Throwable -> L10
            if (index == 0) goto L27;
            if (index <= 0) goto L26;
            this.this$0.mSortedAudioPlaybackClientUids.remove(index);     // Catch: Throwable -> L10
        L26:
            this.this$0.mSortedAudioPlaybackClientUids.add(0, Integer.valueOf(uid));     // Catch: Throwable -> L10
        L27:
            i = i + 1;     // Catch: Throwable -> L10
            goto L15
        L29:
            if (this.this$0.mActiveAudioUids.size() > 0) goto L31;
        L43:
            Iterator<AudioPlaybackConfiguration> r3 = configs.iterator();     // Catch: Throwable -> L10
        L44:
            boolean wasActive = true;
            if (r3.hasNext() == false) goto L54;
            AudioPlaybackConfiguration config3 = r3.next();     // Catch: Throwable -> L10
            int pii = config3.getPlayerInterfaceId();     // Catch: Throwable -> L10
            if (this.this$0.mPrevActiveAudioPlaybackConfigs.remove(Integer.valueOf(pii)) != null) goto L51;
            wasActive = false;
        L51:
            if (wasActive == config3.isActive()) goto L44;
            AudioPlayerStateMonitor.m5506$$Nest$msendAudioPlayerActiveStateChangedMessageLocked(this.this$0, config3, false);     // Catch: Throwable -> L10
            goto L44
        L54:
            Iterator<AudioPlaybackConfiguration> r4 = this.this$0.mPrevActiveAudioPlaybackConfigs.values().iterator();     // Catch: Throwable -> L10
        L56:
            if (r4.hasNext() == false) goto L58;
            AudioPlayerStateMonitor.m5506$$Nest$msendAudioPlayerActiveStateChangedMessageLocked(this.this$0, r4.next(), true);     // Catch: Throwable -> L10
            goto L56
        L58:
            this.this$0.mPrevActiveAudioPlaybackConfigs = activeAudioPlaybackConfigs;     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L31:
            if (this.this$0.mActiveAudioUids.contains(this.this$0.mSortedAudioPlaybackClientUids.get(0)) == true) goto L43;
            int firstActiveUid = -1;
            int firstActiveUidIndex = -1;
            int i2 = 1;
        L34:
            if (i2 >= this.this$0.mSortedAudioPlaybackClientUids.size()) goto L39;
            int uid2 = this.this$0.mSortedAudioPlaybackClientUids.get(i2).intValue();     // Catch: Throwable -> L10
            if (this.this$0.mActiveAudioUids.contains(Integer.valueOf(uid2)) == true) goto L37;
            i2 = i2 + 1;     // Catch: Throwable -> L10
            goto L34
        L37:
            firstActiveUidIndex = i2;
            firstActiveUid = uid2;
        L39:
            int i3 = firstActiveUidIndex;
        L40:
            if (i3 <= 0) goto L42;
            this.this$0.mSortedAudioPlaybackClientUids.set(i3, this.this$0.mSortedAudioPlaybackClientUids.get(i3 - 1));     // Catch: Throwable -> L10
            i3 = i3 - 1;     // Catch: Throwable -> L10
            goto L40
        L42:
            this.this$0.mSortedAudioPlaybackClientUids.set(0, Integer.valueOf(firstActiveUid));     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }
    }

    private static final class MessageHandler extends Handler {
        private static final int MSG_AUDIO_PLAYER_ACTIVE_STATE_CHANGED = 1;
        private final OnAudioPlayerActiveStateChangedListener mListener;

        MessageHandler(Looper looper, OnAudioPlayerActiveStateChangedListener listener) {
            super(looper);
            this.mListener = listener;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 1: goto L5;
                default: goto L11;
            };
        L5:
            OnAudioPlayerActiveStateChangedListener r0 = this.mListener;
            AudioPlaybackConfiguration r1 = (AudioPlaybackConfiguration) msg.obj;
            if (msg.arg1 == 0) goto L8;
            boolean r2 = true;
        L9:
            r0.onAudioPlayerActiveStateChanged(r1, r2);
            return;
        L8:
            r2 = false;
            goto L9
        }

        void sendAudioPlayerActiveStateChangedMessage(AudioPlaybackConfiguration r3, boolean r4) {
            obtainMessage(1, r4 ? 1 : 0, 0, r3).sendToTarget();
        }
    }

    interface OnAudioPlayerActiveStateChangedListener {
        void onAudioPlayerActiveStateChanged(AudioPlaybackConfiguration r1, boolean r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m5505$$Nest$fgetmLock(AudioPlayerStateMonitor r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$msendAudioPlayerActiveStateChangedMessageLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5506$$Nest$msendAudioPlayerActiveStateChangedMessageLocked(AudioPlayerStateMonitor r0, AudioPlaybackConfiguration r1, boolean r2) {
        r0.sendAudioPlayerActiveStateChangedMessageLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5507$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m5508$$Nest$sfgetTAG() {
        return TAG;
    }

    static {
        DEBUG = MediaSessionService.DEBUG;
        TAG = "AudioPlayerStateMonitor";
    }

    static AudioPlayerStateMonitor getInstance(Context context) {
        monitor-enter(AudioPlayerStateMonitor.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L9;
        sInstance = new AudioPlayerStateMonitor(context);     // Catch: Throwable -> L7
    L9:
        AudioPlayerStateMonitor r1 = sInstance;     // Catch: Throwable -> L7
        monitor-exit(AudioPlayerStateMonitor.class);     // Catch: Throwable -> L7
        return r1;
    }

    private AudioPlayerStateMonitor(Context context) {
        this.mLock = new Object();
        this.mListenerMap = new ArrayMap();
        this.mActiveAudioUids = new ArraySet();
        this.mPrevActiveAudioPlaybackConfigs = new ArrayMap();
        this.mSortedAudioPlaybackClientUids = new ArrayList();
        AudioManager am = (AudioManager) context.getSystemService("audio");
        am.registerAudioPlaybackCallback(new AudioManagerPlaybackListener(this, null), null);
    }

    public void registerListener(OnAudioPlayerActiveStateChangedListener listener, Handler handler) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Map<OnAudioPlayerActiveStateChangedListener, MessageHandler> r1 = this.mListenerMap;     // Catch: Throwable -> L7
        if (handler != null) goto L9;
        Looper r3 = Looper.myLooper();     // Catch: Throwable -> L7
    L10:
        r1.put(listener, new MessageHandler(r3, listener));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        r3 = handler.getLooper();     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public void unregisterListener(OnAudioPlayerActiveStateChangedListener listener) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mListenerMap.remove(listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public List<Integer> getSortedAudioPlaybackClientUids() {
        List<Integer> sortedAudioPlaybackClientUids = new ArrayList();
        Object r1 = this.mLock;
        monitor-enter(r1);
        sortedAudioPlaybackClientUids.addAll(this.mSortedAudioPlaybackClientUids);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return sortedAudioPlaybackClientUids;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean hasUidPlayedAudioLast(int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r2 = false;
        if (this.mSortedAudioPlaybackClientUids.isEmpty() == false) goto L7;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L7:
        if (uid != this.mSortedAudioPlaybackClientUids.get(0).intValue()) goto L12;
        r2 = true;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean isPlaybackActive(int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mActiveAudioUids.contains(Integer.valueOf(uid));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void cleanUpAudioPlaybackUids(int mediaButtonSessionUid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int userId = UserHandle.getUserHandleForUid(mediaButtonSessionUid).getIdentifier();     // Catch: Throwable -> L14
        int i = this.mSortedAudioPlaybackClientUids.size() - 1;     // Catch: Throwable -> L14
    L5:
        if (i < 0) goto L17;
        if (this.mSortedAudioPlaybackClientUids.get(i).intValue() == mediaButtonSessionUid) goto L17;
        int uid = this.mSortedAudioPlaybackClientUids.get(i).intValue();     // Catch: Throwable -> L14
        if (userId != UserHandle.getUserHandleForUid(uid).getIdentifier()) goto L16;
        if (isPlaybackActive(uid) == true) goto L16;
        this.mSortedAudioPlaybackClientUids.remove(i);     // Catch: Throwable -> L14
    L16:
        i = i - 1;     // Catch: Throwable -> L14
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public void dump(Context context, PrintWriter pw, String prefix) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.println(prefix + "Audio playback (lastly played comes first)");     // Catch: Throwable -> L15
        String indent = prefix + "  ";     // Catch: Throwable -> L15
        int i = 0;
    L6:
        if (i >= this.mSortedAudioPlaybackClientUids.size()) goto L19;
        int uid = this.mSortedAudioPlaybackClientUids.get(i).intValue();     // Catch: Throwable -> L15
        pw.print(indent + "uid=" + uid + " packages=");     // Catch: Throwable -> L15
        String[] packages = context.getPackageManager().getPackagesForUid(uid);     // Catch: Throwable -> L15
        if (packages == null) goto L17;
        if (packages.length <= 0) goto L17;
        int j = 0;
    L13:
        if (j >= packages.length) goto L17;
        pw.print(packages[j] + " ");     // Catch: Throwable -> L15
        j = j + 1;     // Catch: Throwable -> L15
    L17:
        pw.println();     // Catch: Throwable -> L15
        i = i + 1;     // Catch: Throwable -> L15
        goto L6
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private void sendAudioPlayerActiveStateChangedMessageLocked(AudioPlaybackConfiguration config, boolean isRemoved) {
        Iterator<MessageHandler> r0 = this.mListenerMap.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        MessageHandler messageHandler = r0.next();
        messageHandler.sendAudioPlayerActiveStateChangedMessage(config, isRemoved);
        goto L4
    }
}
