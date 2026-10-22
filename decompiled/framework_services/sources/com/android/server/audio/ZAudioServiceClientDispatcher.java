package com.android.server.audio;

import android.os.Handler;
import android.util.Log;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
class ZAudioServiceClientDispatcher implements ZAudioClientDispatcher {
    private static final String TAG = "ZAudioClientDispatcher";
    CopyOnWriteArrayList<ZAudioPlaybackListener> mAudioPlaybackListeners;
    CopyOnWriteArrayList<ZAudioRecordListener> mAudioRecordListeners;
    private final Handler mHandler;

    public static /* synthetic */ void $r8$lambda$08Z3A7sGFdzUW59dRLcyE7Ia9WI(ZAudioServiceClientDispatcher r0, ZPlaybackClientInterface r1, boolean r2) {
        r0.lambda$dispatchPlaybackActive$11(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$0RYQE9nymbqoadHJTrcW0tYfABI(ZAudioServiceClientDispatcher r0, int r1, boolean r2) {
        r0.lambda$dispatchRecordingSourceActive$1(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$30ppDPgE6HMFEB2Y1j3qA_26SOA(ZAudioServiceClientDispatcher r0, ZRecordClientInterface r1, boolean r2) {
        r0.lambda$dispatchRecordingActive$5(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$3bRFnxRVPlrc0I2VB_Jnf2_xoEw(int r0, boolean r1, ZAudioRecordListener r2) {
        lambda$dispatchRecordingUidActive$2(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$7u01qoq8kaMvk5Wou6sSEg_mXIg(ZAudioServiceClientDispatcher r0, int r1, boolean r2) {
        r0.lambda$dispatchPlaybackUidActive$9(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$ClRuxVyiqOrrXS9j-OFUUs2DrcE, reason: not valid java name */
    public static /* synthetic */ void m2226$r8$lambda$ClRuxVyiqOrrXS9jOFUUs2DrcE(ZAudioServiceClientDispatcher r0, int r1, boolean r2) {
        r0.lambda$dispatchRecordingUidActive$3(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$FqJG-gQKSFYDOMpn6RFFGVW-QTE, reason: not valid java name */
    public static /* synthetic */ void m2227$r8$lambda$FqJGgQKSFYDOMpn6RFFGVWQTE(ZAudioServiceClientDispatcher r0, int r1, boolean r2) {
        r0.lambda$dispatchAudioStreamActive$7(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$M6dU6MhfCa_88PMoR_6OeiQ8MJ0(int r0, boolean r1, ZAudioPlaybackListener r2) {
        lambda$dispatchPlaybackUidActive$8(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$XT2fltjNHjqN9uDNcZYtmzTmolc(int r0, boolean r1, ZAudioPlaybackListener r2) {
        lambda$dispatchAudioStreamActive$6(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$nSUeUlZcg8x9KCSJfWOGTchhe5A(int r0, boolean r1, ZAudioRecordListener r2) {
        lambda$dispatchRecordingSourceActive$0(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$r3VW2FDnVUIgGmOlnhOtljxWVUc(ZRecordClientInterface r0, ZAudioRecordListener r1) {
        lambda$dispatchRecordingActive$4(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$xtZqxaxW0M-j0QrLxFGvlq3alds, reason: not valid java name */
    public static /* synthetic */ void m2228$r8$lambda$xtZqxaxW0Mj0QrLxFGvlq3alds(ZPlaybackClientInterface r0, ZAudioPlaybackListener r1) {
        lambda$dispatchPlaybackActive$10(r0, r1);
    }

    public ZAudioServiceClientDispatcher(Handler handler) {
        this.mAudioRecordListeners = new CopyOnWriteArrayList();
        this.mAudioPlaybackListeners = new CopyOnWriteArrayList();
        this.mHandler = handler;
    }

    @Override // com.android.server.audio.ZAudioClientDispatcher
    public void reset() {
        this.mAudioRecordListeners.clear();
        this.mAudioPlaybackListeners.clear();
    }

    @Override // com.android.server.audio.ZAudioClientDispatcher
    public void registerAudioRecordListener(String name, ZAudioRecordListener listener) {
        if (this.mAudioRecordListeners.contains(listener) == true) goto L6;
        Log.i(TAG, "registerAudioSourceListener who:" + name + " " + listener);
        this.mAudioRecordListeners.add(listener);
        return;
    }

    @Override // com.android.server.audio.ZAudioClientDispatcher
    public void unregisterAudioRecordListener(ZAudioRecordListener listener) {
        Log.i(TAG, "unregisterAudioSourceListener :" + listener);
        this.mAudioRecordListeners.remove(listener);
    }

    @Override // com.android.server.audio.ZAudioClientDispatcher
    public void registerAudioPlaybackListener(String name, ZAudioPlaybackListener listener) {
        if (this.mAudioPlaybackListeners.contains(listener) == true) goto L6;
        Log.i(TAG, "registerAudioPlaybackListener who:" + name + " " + listener);
        this.mAudioPlaybackListeners.add(listener);
        return;
    }

    @Override // com.android.server.audio.ZAudioClientDispatcher
    public void unregisterAudioPlaybackListener(ZAudioPlaybackListener listener) {
        Log.i(TAG, "unregisterAudioPlaybackListener :" + listener);
        this.mAudioPlaybackListeners.remove(listener);
    }

    @Override // com.android.server.audio.ZAudioClientDispatcher
    public void dispatchRecordingSourceActive(final int audioSource, final boolean isActive) {
        this.mHandler.post(new ZAudioServiceClientDispatcher$$ExternalSyntheticLambda4(this, audioSource, isActive));
    }

    private /* synthetic */ void lambda$dispatchRecordingSourceActive$1(final int audioSource, final boolean isActive) {
        CopyOnWriteArrayList<ZAudioRecordListener> listeners = this.mAudioRecordListeners;
        if (listeners.isEmpty() == false) goto L5;
        return;
    L5:
        Log.i(TAG, "dispatchRecordingSourceActive source:" + audioSource + " active:" + isActive);
        listeners.forEach(new ZAudioServiceClientDispatcher$$ExternalSyntheticLambda11(audioSource, isActive));
    }

    private static /* synthetic */ void lambda$dispatchRecordingSourceActive$0(int audioSource, boolean isActive, ZAudioRecordListener l) {
        l.onAudioSourceChanged(audioSource, isActive);
    }

    @Override // com.android.server.audio.ZAudioClientDispatcher
    public void dispatchRecordingUidActive(final int uid, final boolean isActive) {
        this.mHandler.post(new ZAudioServiceClientDispatcher$$ExternalSyntheticLambda6(this, uid, isActive));
    }

    private /* synthetic */ void lambda$dispatchRecordingUidActive$3(final int uid, final boolean isActive) {
        CopyOnWriteArrayList<ZAudioRecordListener> listeners = this.mAudioRecordListeners;
        if (listeners.isEmpty() == false) goto L5;
        return;
    L5:
        Log.i(TAG, "dispatchRecordingUidActive uid:" + uid + " active:" + isActive);
        listeners.forEach(new ZAudioServiceClientDispatcher$$ExternalSyntheticLambda7(uid, isActive));
    }

    private static /* synthetic */ void lambda$dispatchRecordingUidActive$2(int uid, boolean isActive, ZAudioRecordListener l) {
        l.onRecordingUidChanged(uid, isActive);
    }

    @Override // com.android.server.audio.ZAudioClientDispatcher
    public void dispatchRecordingActive(final ZRecordClientInterface client, final boolean isActive) {
        if (this.mAudioRecordListeners.isEmpty() == false) goto L5;
        return;
    L5:
        this.mHandler.post(new ZAudioServiceClientDispatcher$$ExternalSyntheticLambda10(this, client, isActive));
    }

    private /* synthetic */ void lambda$dispatchRecordingActive$5(final ZRecordClientInterface client, boolean isActive) {
        CopyOnWriteArrayList<ZAudioRecordListener> listeners = this.mAudioRecordListeners;
        if (listeners.isEmpty() == false) goto L5;
        return;
    L5:
        Log.i(TAG, "dispatchRecordingUidActive uid:" + client.getUid() + " pid:" + client.getPid() + " sessionId:" + client.getSessionId() + " packageName:" + client.getPackageName() + " audioSource:" + client.getAudioSource() + " active:" + isActive);
        listeners.forEach(new ZAudioServiceClientDispatcher$$ExternalSyntheticLambda1(client));
    }

    private static /* synthetic */ void lambda$dispatchRecordingActive$4(ZRecordClientInterface client, ZAudioRecordListener l) {
        l.onAudioRecordChange(client);
    }

    @Override // com.android.server.audio.ZAudioClientDispatcher
    public void dispatchAudioStreamActive(final int streamType, final boolean isActive) {
        this.mHandler.post(new ZAudioServiceClientDispatcher$$ExternalSyntheticLambda2(this, streamType, isActive));
    }

    private /* synthetic */ void lambda$dispatchAudioStreamActive$7(final int streamType, final boolean isActive) {
        CopyOnWriteArrayList<ZAudioPlaybackListener> listeners = this.mAudioPlaybackListeners;
        if (listeners.isEmpty() == false) goto L5;
        return;
    L5:
        Log.i(TAG, "dispatchAudioStreamActive streamType:" + streamType + " active:" + isActive);
        listeners.forEach(new ZAudioServiceClientDispatcher$$ExternalSyntheticLambda8(streamType, isActive));
    }

    private static /* synthetic */ void lambda$dispatchAudioStreamActive$6(int streamType, boolean isActive, ZAudioPlaybackListener l) {
        l.onAudioStreamChanged(streamType, isActive);
    }

    @Override // com.android.server.audio.ZAudioClientDispatcher
    public void dispatchPlaybackUidActive(final int uid, final boolean isActive) {
        this.mHandler.post(new ZAudioServiceClientDispatcher$$ExternalSyntheticLambda0(this, uid, isActive));
    }

    private /* synthetic */ void lambda$dispatchPlaybackUidActive$9(final int uid, final boolean isActive) {
        CopyOnWriteArrayList<ZAudioPlaybackListener> listeners = this.mAudioPlaybackListeners;
        if (listeners.isEmpty() == false) goto L5;
        return;
    L5:
        Log.i(TAG, "dispatchPlaybackUidActive uid:" + uid + " active:" + isActive);
        listeners.forEach(new ZAudioServiceClientDispatcher$$ExternalSyntheticLambda3(uid, isActive));
    }

    private static /* synthetic */ void lambda$dispatchPlaybackUidActive$8(int uid, boolean isActive, ZAudioPlaybackListener l) {
        l.onPlaybackUidChanged(uid, isActive);
    }

    @Override // com.android.server.audio.ZAudioClientDispatcher
    public void dispatchPlaybackActive(final ZPlaybackClientInterface client, final boolean isActive) {
        this.mHandler.post(new ZAudioServiceClientDispatcher$$ExternalSyntheticLambda9(this, client, isActive));
    }

    private /* synthetic */ void lambda$dispatchPlaybackActive$11(final ZPlaybackClientInterface client, boolean isActive) {
        CopyOnWriteArrayList<ZAudioPlaybackListener> listeners = this.mAudioPlaybackListeners;
        if (listeners.isEmpty() == false) goto L5;
        return;
    L5:
        Log.i(TAG, "dispatchPlaybackActive uid:" + client.getUid() + " pid:" + client.getPid() + " sessionId:" + client.getSessionId() + " packageName:" + client.getPackageName() + " streamType:" + client.getStreamType() + " active:" + isActive);
        listeners.forEach(new ZAudioServiceClientDispatcher$$ExternalSyntheticLambda5(client));
    }

    private static /* synthetic */ void lambda$dispatchPlaybackActive$10(ZPlaybackClientInterface client, ZAudioPlaybackListener l) {
        l.onPlaybackChange(client);
    }
}
