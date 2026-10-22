package com.android.server.audio;

import android.media.INativeAudioVolumeGroupCallback;
import android.media.audio.common.AudioVolumeGroupChangeEvent;
import android.media.audiopolicy.IAudioVolumeChangeDispatcher;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Slog;
import com.android.internal.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
class AudioVolumeChangeHandler {
    private static final String TAG = "AudioVolumeChangeHandler";
    private final AudioSystemAdapter mAudioSystem;
    private AudioVolumeGroupCallback mAudioVolumeGroupCallback;
    private final RemoteCallbackList<IAudioVolumeChangeDispatcher> mListeners;
    private final Object mLock;

    private final class AudioVolumeGroupCallback extends INativeAudioVolumeGroupCallback.Stub {
        final /* synthetic */ AudioVolumeChangeHandler this$0;

        /* synthetic */ AudioVolumeGroupCallback(AudioVolumeChangeHandler r1, AudioVolumeChangeHandlerIA r2) {
            this(r1);
        }

        private AudioVolumeGroupCallback(AudioVolumeChangeHandler r1) {
            this.this$0 = r1;
        }

        public void onAudioVolumeGroupChanged(AudioVolumeGroupChangeEvent volumeEvent) {
            Slog.v(AudioVolumeChangeHandler.TAG, "onAudioVolumeGroupChanged volumeEvent=" + volumeEvent);
            AudioVolumeChangeHandler.m2133$$Nest$msendAudioVolumeGroupChangedToClients(this.this$0, volumeEvent.groupId, volumeEvent.flags);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$msendAudioVolumeGroupChangedToClients, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2133$$Nest$msendAudioVolumeGroupChangedToClients(AudioVolumeChangeHandler r0, int r1, int r2) {
        r0.sendAudioVolumeGroupChangedToClients(r1, r2);
    }

    AudioVolumeChangeHandler(AudioSystemAdapter asa) {
        this.mLock = new Object();
        this.mListeners = new RemoteCallbackList();
        this.mAudioSystem = asa;
    }

    private void lazyInitLocked() {
        this.mAudioVolumeGroupCallback = new AudioVolumeGroupCallback(this, null);
        this.mAudioSystem.registerAudioVolumeGroupCallback(this.mAudioVolumeGroupCallback);
    }

    private void sendAudioVolumeGroupChangedToClients(int groupId, int index) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        RemoteCallbackList<IAudioVolumeChangeDispatcher> listeners = this.mListeners;     // Catch: Throwable -> L21
        int nbDispatchers = this.mListeners.beginBroadcast();     // Catch: Throwable -> L21
        monitor-exit(r0);     // Catch: Throwable -> L21
        int i = 0;
    L7:
        if (i >= nbDispatchers) goto L13;
        listeners.getBroadcastItem(i).onAudioVolumeGroupChanged(groupId, index);     // Catch: RemoteException -> L10
    L12:
        i = i + 1;
    L11:
        Slog.e(TAG, "Failed to broadcast Volume Changed event");
        goto L12
    L13:
        Object r3 = this.mLock;
        monitor-enter(r3);
        this.mListeners.finishBroadcast();     // Catch: Throwable -> L18
        monitor-exit(r3);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    L21:
        th = move-exception;
        throw th;
    }

    public void registerListener(IAudioVolumeChangeDispatcher cb) {
        Preconditions.checkNotNull(cb, "Volume group callback must not be null");
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mAudioVolumeGroupCallback != null) goto L9;
        lazyInitLocked();     // Catch: Throwable -> L7
    L9:
        this.mListeners.register(cb);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    public void unregisterListener(IAudioVolumeChangeDispatcher cb) {
        Preconditions.checkNotNull(cb, "Volume group callback must not be null");
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mListeners.unregister(cb);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
