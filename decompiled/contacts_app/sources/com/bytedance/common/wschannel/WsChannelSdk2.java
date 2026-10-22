package com.bytedance.common.wschannel;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.wschannel.app.OnMessageAckListener;
import com.bytedance.common.wschannel.app.OnMessageReceiveListener;
import com.bytedance.common.wschannel.app.OnServiceConnectListener;
import com.bytedance.common.wschannel.client.WsChannelApi;
import com.bytedance.common.wschannel.client.WsChannelSingleProcessImpl;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.server.MainChannelManager;
import com.bytedance.common.wschannel.server.WsChannelReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class WsChannelSdk2 {
    private static WsChannelApi impl;
    private static Map<Integer, WsChannelImpl> mChannels;
    private static AtomicBoolean sInited;
    private static boolean sIsCurrentBackground;

    private static class AppStateListener implements LifeCycleMonitor.AppStateListener {
        private final Application mApp;

        AppStateListener(Application r1) {
            this.mApp = r1;
        }

        @Override // com.bytedance.common.wschannel.LifeCycleMonitor.AppStateListener
        public void onEnterToForeground() {
            WsChannelSdk2.access$002(false);
            if (WsChannelSdk2.access$100().get() == false) goto L6;
            WsChannelSdk2.access$200().onEnterToForeground(this.mApp);
            return;
        }

        @Override // com.bytedance.common.wschannel.LifeCycleMonitor.AppStateListener
        public void onEnterToBackground() {
            WsChannelSdk2.access$002(true);
            if (WsChannelSdk2.access$100().get() == false) goto L6;
            WsChannelSdk2.access$200().onEnterToBackground(this.mApp);
            return;
        }
    }

    public WsChannelSdk2() {
    }

    static /* synthetic */ boolean access$002(boolean r0) {
        sIsCurrentBackground = r0;
        return r0;
    }

    static /* synthetic */ AtomicBoolean access$100() {
        return sInited;
    }

    static /* synthetic */ WsChannelApi access$200() {
        return impl;
    }

    static {
        impl = new WsChannelSingleProcessImpl();
        mChannels = new ConcurrentHashMap();
        sInited = new AtomicBoolean(false);
        sIsCurrentBackground = true;
    }

    public static WsChannel registerChannel(Context r8, ChannelInfo r9, OnMessageReceiveListener r10, OnServiceConnectListener r11, OnMessageAckListener r12) {
        tryInit(r8.getApplicationContext());
        WsChannelImpl r0 = new WsChannelImpl(r8.getApplicationContext(), impl, r9, r10, r11, r12);
        mChannels.put(Integer.valueOf(r9.channelId), r0);
        r0.register();
        return r0;
    }

    public static WsChannel registerChannel(Context r1, ChannelInfo r2, OnMessageReceiveListener r3) {
        return registerChannel(r1.getApplicationContext(), r2, r3, null, null);
    }

    private static void tryInit(Context r3) {
        if (sInited.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        if (sIsCurrentBackground == false) goto L7;
        impl.onEnterToBackground(r3);
    L8:
        registerNetChangeReceiver(r3);
        return;
    L7:
        impl.onEnterToForeground(r3);
        goto L8
    }

    private static void registerNetChangeReceiver(Context r3) {
        IntentFilter r0 = new IntentFilter();     // Catch: Exception -> L4
        r0.addAction("android.net.conn.CONNECTIVITY_CHANGE");     // Catch: Exception -> L4
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r3, new WsChannelReceiver(r3, MainChannelManager.inst(r3)), r0);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    static SsWsApp createParameterMap(ChannelInfo r10) {
        Map<String, String> r0 = r10.extra;
        ArrayList r1 = new ArrayList();
        Iterator<Map.Entry<String, String>> r2 = r0.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        Map.Entry<String, String> r3 = r2.next();
        if (r3 == null) goto L4;
        r1.add(r3.getKey() + "=" + Uri.encode(r3.getValue()));
        goto L4
    L9:
        int r4 = r10.aid;
        if (r4 <= 0) goto L38;
        String r5 = r10.deviceId;
        if (StringUtils.isEmpty(r5) == true) goto L36;
        String r6 = r10.installId;
        if (StringUtils.isEmpty(r6) == true) goto L34;
        int r7 = r10.fpid;
        if (r7 <= 0) goto L32;
        String r8 = r10.appKey;
        if (StringUtils.isEmpty(r8) == true) goto L30;
        int r9 = r10.updateVersionCode;
        if (r9 <= 0) goto L28;
        int r11 = r10.channelId;
        if (r11 <= 0) goto L26;
        return new SsWsApp.SsWsAppBuilder().setAppId(r4).setDeviceId(r5).setInstallId(r6).setFPID(r7).setAppKey(r8).setConnectUrls(r10.urls).setAppVersion(r9).setPlatform(0).setChannelId(r11).setHeaders(r10.headers).setExtra(TextUtils.join("&", r1.toArray())).enableNewPrivateProtocol(r10.privateProtocolEnabled).setServiceIdList(r10.serviceIdList).setPrivateProtocolUrl(r10.privateProtocolUrl).setTransportMode(r10.transportMode.getTypeValue()).disableFallbackWS(r10.disableFallbackWs).build();
    L26:
        throw new IllegalArgumentException("channelId <= 0 ,please set channelId first");
    L28:
        throw new IllegalArgumentException("appVersion <= 0 ,please set appVersion first");
    L30:
        throw new IllegalArgumentException("appKey is empty,please set appKey first");
    L32:
        throw new IllegalArgumentException("fpid <= 0 ,please set fpid first");
    L34:
        throw new IllegalArgumentException("installId is empty ,please set installId first");
    L36:
        throw new IllegalArgumentException("deviceId is empty ,please set deviceId first");
    L38:
        throw new IllegalArgumentException("aid == 0 ,please set aid first");
    }

    static WsChannelImpl getChannel(int r1) {
        return mChannels.get(Integer.valueOf(r1));
    }

    static void unregister(int r1) {
        mChannels.remove(Integer.valueOf(r1));
    }

    static void monitorLifeCycle(Context r2) {
        Application r3 = (Application) r2.getApplicationContext();
        LifeCycleMonitor r0 = new LifeCycleMonitor();
        r0.setAppStateChangedListener(new AppStateListener(r3));
        r3.registerActivityLifecycleCallbacks(r0);
    }
}
