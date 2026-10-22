package com.bytedance.android.livesdkapi.ws;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes12.dex */
public class LiveWsManager {
    private static volatile LiveWsManager ourInstance;
    private WeakReference<LiveWsBridge> liveWsBridgeWeakRef;
    private WeakReference<OnLiveWsConnectListener> liveWsConnectListenerWeakRef;

    public interface OnLiveWsConnectListener {
        void onConnected();

        void onDisconnect();

        void onReceiveMessage(LiveWsMessage r100);
    }

    public static LiveWsManager getInstance() {
        if (ourInstance != null) goto L13;
        monitor-enter(LiveWsMessage.class);
        ourInstance = new LiveWsManager();     // Catch: Throwable -> L9
        monitor-exit(LiveWsMessage.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L13:
        return ourInstance;
    }

    public void disconnect() {
        WeakReference<LiveWsBridge> r100 = this.liveWsBridgeWeakRef;
        if (r100 != null) goto L5;
        return;
    L5:
        LiveWsBridge r101 = r100.get();
        if (r101 != null) goto L8;
    L10:
        WeakReference<OnLiveWsConnectListener> r102 = this.liveWsConnectListenerWeakRef;
        if (r102 != null) goto L13;
    L15:
        this.liveWsBridgeWeakRef = null;
        return;
    L13:
        if (r102.get() == null) goto L15;
        this.liveWsConnectListenerWeakRef.get().onDisconnect();
        goto L15
    L8:
        if (r101.isConnected() == false) goto L10;
        r101.unregisterChannel();
        goto L10
    }

    public boolean isWsConnected() {
        WeakReference<LiveWsBridge> r100 = this.liveWsBridgeWeakRef;
        if (r100 != null) goto L5;
        return false;
    L5:
        LiveWsBridge r101 = r100.get();
        if (r101 != null) goto L8;
        return false;
    L8:
        return r101.isConnected();
    }

    private LiveWsManager() {
        this.liveWsBridgeWeakRef = null;
        this.liveWsConnectListenerWeakRef = null;
    }

    public void connect(LiveWsBridge r100) {
        this.liveWsBridgeWeakRef = new WeakReference(r100);
        WeakReference<OnLiveWsConnectListener> r101 = this.liveWsConnectListenerWeakRef;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.get() == null) goto L9;
        this.liveWsConnectListenerWeakRef.get().onConnected();
        return;
    }

    public void onReceiveMessage(LiveWsMessage r100) {
        if (this.liveWsBridgeWeakRef != null) goto L5;
        return;
    L5:
        WeakReference<OnLiveWsConnectListener> r101 = this.liveWsConnectListenerWeakRef;
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.get() == null) goto L12;
        this.liveWsConnectListenerWeakRef.get().onReceiveMessage(r100);
        return;
    }

    public void setLiveWsConnectListener(OnLiveWsConnectListener r100) {
        if (r100 == null) goto L4;
        this.liveWsConnectListenerWeakRef = new WeakReference(r100);
        return;
    L4:
        this.liveWsConnectListenerWeakRef = null;
    }

    public boolean sendMessage(LiveWsMessage r100, OnLiveWsMessageSendListener r101) {
        WeakReference<LiveWsBridge> r102 = this.liveWsBridgeWeakRef;
        if (r102 != null) goto L5;
        return false;
    L5:
        LiveWsBridge r103 = r102.get();
        if (r103 != null) goto L8;
    L11:
        return false;
    L8:
        if (r103.isConnected() == false) goto L11;
        r103.sendMessage(r100, r101);
        return true;
    }
}
