package com.bytedance.android.livesdkapi.ws.host;

import com.bytedance.android.livesdkapi.ws.LiveWsBridge;
import com.bytedance.android.livesdkapi.ws.LiveWsConnectState;
import com.bytedance.android.livesdkapi.ws.LiveWsMessage;
import com.bytedance.android.livesdkapi.ws.OnLiveWsMessageReceiveListener;
import com.bytedance.android.livesdkapi.ws.OnLiveWsMessageSendListener;
import com.bytedance.common.utility.collection.WeakContainer;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class LiveHostWsMessageBridge {
    private static volatile LiveHostWsMessageBridge ourInstance;
    private WeakContainer<OnLiveWsMessageReceiveListener> dynamicStrategyListeners;
    private WeakContainer<OnLiveWsMessageReceiveListener> followSkylightLiveListeners;
    private LiveWsBridge hostWsBridge;
    private WeakContainer<OnLiveWsMessageReceiveListener> liveStatusListeners;
    private WeakContainer<OnLiveWsMessageReceiveListener> msgListeners;
    private WeakContainer<OnLiveWsMessageReceiveListener> settingListeners;
    private WeakContainer<OnLiveWsMessageReceiveListener> uplinkListeners;

    public static LiveHostWsMessageBridge getInstance() {
        if (ourInstance != null) goto L15;
        monitor-enter(LiveWsMessage.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (ourInstance != null) goto L9;
        ourInstance = new LiveHostWsMessageBridge();     // Catch: Throwable -> L11
    L9:
        monitor-exit(LiveWsMessage.class);     // Catch: Throwable -> L11
    L15:
        return ourInstance;
    }

    public boolean isWSConnected() {
        LiveWsBridge r100 = this.hostWsBridge;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isConnected() == false) goto L7;
        return true;
    }

    private LiveHostWsMessageBridge() {
        this.msgListeners = new WeakContainer();
        this.uplinkListeners = new WeakContainer();
        this.settingListeners = new WeakContainer();
        this.dynamicStrategyListeners = new WeakContainer();
        this.liveStatusListeners = new WeakContainer();
        this.followSkylightLiveListeners = new WeakContainer();
    }

    public void injectWS(LiveWsBridge r100) {
        this.hostWsBridge = r100;
    }

    public void onReceiveDynamicStrategy(LiveWsMessage r100) {
        Iterator<OnLiveWsMessageReceiveListener> r101 = this.dynamicStrategyListeners.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        OnLiveWsMessageReceiveListener r102 = r101.next();
        if (r102 == null) goto L4;
        r102.onReceiveMsg(r100);
        goto L4
    }

    public void onReceiveFollowSkylightLiveMsg(LiveWsMessage r100) {
        Iterator<OnLiveWsMessageReceiveListener> r101 = this.followSkylightLiveListeners.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        OnLiveWsMessageReceiveListener r102 = r101.next();
        if (r102 == null) goto L4;
        r102.onReceiveMsg(r100);
        goto L4
    }

    public void onReceiveLiveStatus(LiveWsMessage r100) {
        Iterator<OnLiveWsMessageReceiveListener> r101 = this.liveStatusListeners.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        OnLiveWsMessageReceiveListener r102 = r101.next();
        if (r102 == null) goto L4;
        r102.onReceiveMsg(r100);
        goto L4
    }

    public void onReceiveMsg(LiveWsMessage r100) {
        Iterator<OnLiveWsMessageReceiveListener> r101 = this.msgListeners.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        OnLiveWsMessageReceiveListener r102 = r101.next();
        if (r102 == null) goto L4;
        r102.onReceiveMsg(r100);
        goto L4
    }

    public void onReceiveSetting(LiveWsMessage r100) {
        Iterator<OnLiveWsMessageReceiveListener> r101 = this.settingListeners.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        OnLiveWsMessageReceiveListener r102 = r101.next();
        if (r102 == null) goto L4;
        r102.onReceiveMsg(r100);
        goto L4
    }

    public void onReceiveUplink(LiveWsMessage r100) {
        Iterator<OnLiveWsMessageReceiveListener> r101 = this.uplinkListeners.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        OnLiveWsMessageReceiveListener r102 = r101.next();
        if (r102 == null) goto L4;
        r102.onReceiveMsg(r100);
        goto L4
    }

    public void registerDynamicStrategyListener(OnLiveWsMessageReceiveListener r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.dynamicStrategyListeners.add(r100);
    }

    public void registerFollowSkylightLiveListener(OnLiveWsMessageReceiveListener r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.followSkylightLiveListeners.add(r100);
    }

    public void registerLiveStatusListener(OnLiveWsMessageReceiveListener r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.liveStatusListeners.add(r100);
    }

    public void registerMsgListener(OnLiveWsMessageReceiveListener r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.msgListeners.add(r100);
    }

    public void registerSettingListener(OnLiveWsMessageReceiveListener r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.settingListeners.add(r100);
    }

    public void registerUplinkListener(OnLiveWsMessageReceiveListener r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.uplinkListeners.add(r100);
    }

    public void unregisterFollowSkylightLiveListener(OnLiveWsMessageReceiveListener r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.followSkylightLiveListeners.remove(r100);
    }

    public void unregisterLiveStatusListener(OnLiveWsMessageReceiveListener r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.liveStatusListeners.remove(r100);
    }

    public void unregisterMsgListener(OnLiveWsMessageReceiveListener r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.msgListeners.remove(r100);
    }

    public void unregisterUplinkListener(OnLiveWsMessageReceiveListener r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.uplinkListeners.remove(r100);
    }

    public void onReceiveConnectEvent(LiveWsConnectState r100, JSONObject r101) {
        Iterator<OnLiveWsMessageReceiveListener> r102 = this.msgListeners.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().onReceiveConnectEvent(r100, r101);
        goto L4
    L6:
        Iterator<OnLiveWsMessageReceiveListener> r103 = this.uplinkListeners.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        r103.next().onReceiveConnectEvent(r100, r101);
        goto L8
    L10:
        Iterator<OnLiveWsMessageReceiveListener> r104 = this.liveStatusListeners.iterator();
    L12:
        if (r104.hasNext() == false) goto L14;
        r104.next().onReceiveConnectEvent(r100, r101);
        goto L12
    }

    public void sendMsg(LiveWsMessage r100, OnLiveWsMessageSendListener r101) {
        LiveWsBridge r102 = this.hostWsBridge;
        if (r102 == null) goto L6;
        r102.sendMessage(r100, r101);
        return;
    }
}
