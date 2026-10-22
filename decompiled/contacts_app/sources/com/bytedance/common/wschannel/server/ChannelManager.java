package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsChannelSettings;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.channel.IMessageHandler;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.channel.WsChannelClient;
import com.bytedance.common.wschannel.converter.MsgConverterFactory;
import com.bytedance.common.wschannel.log.WsChannelLog;
import com.bytedance.common.wschannel.model.IntegerParcelable;
import com.bytedance.common.wschannel.model.ServiceParcelable;
import com.bytedance.common.wschannel.model.SocketState;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class ChannelManager implements WeakHandler.IHandler, IEnableObserver.OnWsChannelEnableChangedObserver {
    private final ChannelKeeper mChannelKeeper;
    private final IWsChannelSaver mChannelSaver;
    private final Context mContext;
    private AtomicLong mCounter;
    private boolean mIsForeground;
    private final Object mLock;
    private final IMessageHandler mMessageHandler;
    private final WeakHandler mThreadHandler;
    private IEnableObserver mWsChannelEnableObserver;

    static /* synthetic */ IWsChannelSaver access$000(ChannelManager r0) {
        return r0.mChannelSaver;
    }

    static /* synthetic */ void access$100(ChannelManager r0, Map r1) {
        r0.tryConnectIfEnable(r1);
    }

    static /* synthetic */ IEnableObserver access$200(ChannelManager r0) {
        return r0.mWsChannelEnableObserver;
    }

    static /* synthetic */ void access$300(ChannelManager r0, Message r1) {
        r0.doHandleMsg(r1);
    }

    static /* synthetic */ void access$400(ChannelManager r0, IWsChannelClient r1) {
        r0.sendAppStateChangeMessage(r1);
    }

    ChannelManager(Context r4, Looper r5, IWsChannelSaver r6, ChannelKeeper r7, IMessageHandler r8, final IEnableObserver r9) {
        this.mLock = new Object();
        this.mCounter = new AtomicLong(0);
        this.mIsForeground = false;
        this.mContext = r4.getApplicationContext();
        this.mThreadHandler = new WeakHandler(r5, this);
        this.mChannelSaver = r6;
        this.mChannelKeeper = r7;
        this.mMessageHandler = r8;
        this.mWsChannelEnableObserver = r9;
        r9.setEnableListener(this);
        runOnHandlerThread(new AnonymousClass1(this, r9));
    }

    private Map<String, Object> getConfigMap(IWsApp r11) {
        HashMap r0 = new HashMap();
        r0.put(WsConstants.KEY_APP_KEY, r11.getAppKey());
        r0.put(WsConstants.KEY_FPID, Integer.valueOf(r11.getFPID()));
        r0.put(WsConstants.KEY_SDK_VERSION, 2);
        r0.put(WsConstants.KEY_PLATFORM, 0);
        r0.put("app_version", Integer.valueOf(r11.getAppVersion()));
        r0.put("aid", Integer.valueOf(r11.getAppId()));
        r0.put("device_id", r11.getDeviceId());
        r0.put(WsConstants.KEY_INSTALL_ID, r11.getInstallId());
        r0.put(WsConstants.KEY_HEADERS, r11.getHeaders());
        String r3 = r11.getExtra();
        if (r3 != null) goto L6;
        onNullParamLog("extra");
        r3 = "";
    L6:
        if (WsChannelSettings.inst(this.mContext).isReportAppStateEnable() == false) goto L17;
        String[] r7 = r3.split("&");
        if (isForeground() == false) goto L10;
        String r8 = "0";
    L11:
        String r9 = "is_background=".concat(r8);
        if (r7.length > 0) goto L14;
    L16:
        r3 = r9;
        goto L17
    L14:
        if (TextUtils.isEmpty(r7[0]) == true) goto L16;
        r3 = r3 + "&" + r9;
        goto L17
    L10:
        r8 = "1";
    L17:
        r0.put("extra", r3);
        if (r11.getDeviceId() != null) goto L21;
        onNullParamLog("device_id");
    L21:
        if (r11.getInstallId() != null) goto L24;
        onNullParamLog("install_id");
    L24:
        if (StringUtils.isEmpty(r11.getAppKey()) == false) goto L26;
        onNullParamLog(WsConstants.KEY_APP_KEY);
    L26:
        r0.put(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE, Boolean.valueOf(r11.newPrivateProtocolEnabled()));
        if (r11.getServiceIdList() == null) goto L30;
        r0.put(WsConstants.KEY_SERVICE_ID_LIST, r11.getServiceIdList());
    L30:
        if (TextUtils.isEmpty(r11.getPrivateProtocolUrl()) == true) goto L32;
        r0.put(WsConstants.KEY_PRIVATE_PROTOCOL_URL, r11.getPrivateProtocolUrl());
    L32:
        r0.put(WsConstants.KEY_TRANSPORT_MODE, Integer.valueOf(r11.getTransportMode()));
        r0.put(WsConstants.KEY_DISABLE_FALLBACK_WEBSOCKET, Boolean.valueOf(r11.disableFallbackWSEnabled()));
        return r0;
    }

    private boolean isForeground() {
        return this.mIsForeground;
    }

    private void onNullParamLog(String r3) {
        Bundle r0 = new Bundle();
        r0.putString("param_name", r3);
        WsChannelLog.onEventV3Bundle(this.mContext, "wschannel_param_null", r0);
    }

    private void tryConnectIfEnable(Map<Integer, IWsApp> r2) {
        if (isEnableOfflineDetect() == false) goto L8;
        if (NetworkUtils.isNetworkAvailable(this.mContext) == true) goto L8;
        return;
    L8:
        if (this.mWsChannelEnableObserver.isEnable() == false) goto L17;
        if (r2 == null) goto L23;
        Iterator<IWsApp> r3 = r2.values().iterator();
    L12:
        if (r3.hasNext() == false) goto L24;
        IWsApp r0 = r3.next();
        if (r0 == null) goto L12;
        doRegisterChannel(r0);
        goto L12
    L24:
        return;
    L23:
        return;
    }

    private boolean isEnableOfflineDetect() {
        Context r1 = this.mContext;
        if (r1 != null) goto L5;
        return false;
    L5:
        WsChannelSettings r2 = WsChannelSettings.inst(r1);
        if (r2 != null) goto L9;
        return false;
    L9:
        return r2.isEnableOfflineDetect();
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r2) {
        final Message r3 = Message.obtain(r2);
        runOnHandlerThread(new AnonymousClass2(this, r3));
    }

    private void doHandleMsg(Message r12) {
        int r6 = r12.what;     // Catch: Throwable -> L134
        if (r6 == 0) goto L130;
        boolean r7 = true;
        if (r6 == 1) goto L107;
        boolean r8 = false;
        if (r6 != 2) goto L10;
        int r13 = r12.arg1;     // Catch: Throwable -> L134
        if (Logger.debug() == false) goto L96;
        Logger.d("WsChannelService", "appState = " + r13);     // Catch: Throwable -> L134
    L96:
        if (r13 == 1) goto L99;
        r7 = false;
    L99:
        this.mIsForeground = r7;     // Catch: Throwable -> L134
        this.mMessageHandler.tryResendMsg();     // Catch: Throwable -> L134
        if (isEnable() == false) goto L166;
        sendAppStateChangeEvent(this.mChannelKeeper.mWsChannelClientMap.values());     // Catch: Throwable -> L134
        Iterator<IWsChannelClient> r11 = this.mChannelKeeper.mWsChannelClientMap.values().iterator();     // Catch: Throwable -> L134
    L103:
        if (r11.hasNext() == false) goto L172;
        IWsChannelClient r0 = r11.next();     // Catch: Throwable -> L134
        if (r0 == null) goto L103;
        r0.onAppStateChanged(r13);     // Catch: Throwable -> L134
        goto L103
    L172:
        return;
    L166:
        return;
    L10:
        if (r6 != 3) goto L12;
        int r14 = r12.arg1;     // Catch: Throwable -> L134
        if (Logger.debug() == false) goto L85;
        Logger.d("WsChannelService", "networkState = " + r14);     // Catch: Throwable -> L134
    L85:
        this.mMessageHandler.tryResendMsg();     // Catch: Throwable -> L134
        if (isEnable() == false) goto L165;
        Iterator<IWsChannelClient> r15 = this.mChannelKeeper.mWsChannelClientMap.values().iterator();     // Catch: Throwable -> L134
    L89:
        if (r15.hasNext() == false) goto L171;
        IWsChannelClient r1 = r15.next();     // Catch: Throwable -> L134
        if (r1 == null) goto L89;
        r1.onNetworkStateChanged(r14);     // Catch: Throwable -> L134
        goto L89
    L171:
        return;
    L165:
        return;
    L12:
        if (r6 != 4) goto L14;
        r12.getData().setClassLoader(SsWsApp.class.getClassLoader());     // Catch: Throwable -> L134
        Parcelable r16 = r12.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L134
        if ((r16 instanceof IWsApp) == false) goto L163;
        doOnParamChange((IWsApp) r16);     // Catch: Throwable -> L134
        return;
    L163:
        return;
    L14:
        if (r6 != 5) goto L16;
    L40:
        if (r6 == 10) goto L43;
        r7 = false;
    L43:
        r12.getData().setClassLoader(WsChannelMsg.class.getClassLoader());     // Catch: Throwable -> L134
        Parcelable r2 = r12.getData().getParcelable("payload");     // Catch: Throwable -> L134
        if ((r2 instanceof WsChannelMsg) == false) goto L160;
        WsChannelMsg r3 = (WsChannelMsg) r2;     // Catch: Throwable -> L134
        if (r3.getSeqId() > 0) goto L48;
        r3.setSeqId(this.mCounter.incrementAndGet());     // Catch: Throwable -> L134
    L48:
        IWsChannelClient r4 = this.mChannelKeeper.mWsChannelClientMap.get(Integer.valueOf(r3.getChannelId()));     // Catch: Throwable -> L134
        if (r7 == false) goto L51;
        Logger.d("WsChannelService", "retry send msg");     // Catch: Throwable -> L134
    L51:
        if (r4 == null) goto L75;
        if (r6 == 10) goto L59;
        if ((r4 instanceof WsChannelClient) == false) goto L59;
        if (((WsChannelClient) r4).isOkChannelImpl() == false) goto L59;
        r3 = tryAddOkWsPayloadOpaque(r4, r3);     // Catch: Throwable -> L134
    L59:
        if (r4.privateProtocolEnabled() == true) goto L61;
    L63:
        boolean r5 = r4.sendMessage(MsgConverterFactory.getConverter().encode(r3));     // Catch: Throwable -> L134
    L64:
        r8 = r5;
        long r9 = WsChannelSettings.inst(this.mContext).getRetryDelay();     // Catch: Throwable -> L134
        if (r8 == true) goto L70;
        if (r7 == true) goto L70;
        if (r9 <= 0) goto L70;
        Message r17 = Message.obtain(r12);     // Catch: Throwable -> L134
        r17.what = 10;     // Catch: Throwable -> L134
        this.mThreadHandler.sendMessageDelayed(r17, r9);     // Catch: Throwable -> L134
    L70:
        if (r8 == false) goto L72;
    L74:
        this.mMessageHandler.replySendMsgResult(r3, r8);     // Catch: Throwable -> L134
    L77:
        if (Logger.debug() == false) goto L161;
        Logger.d("WsChannelService", "send payload success = " + r8);     // Catch: Throwable -> L134
        return;
    L161:
        return;
    L72:
        if (r9 <= 0) goto L74;
        if (r7 == false) goto L77;
    L61:
        if (r4.privateProtocolProxyEnabled() == true) goto L63;
        r5 = r4.sendMessage(r3);     // Catch: Throwable -> L134
        goto L64
    L75:
        this.mMessageHandler.replySendMsgResult(r3, false);     // Catch: Throwable -> L134
        goto L77
    L160:
        return;
    L16:
        if (r6 == 9) goto L39;
        if (r6 == 10) goto L40;
        if (r6 != 12) goto L21;
        r12.getData().setClassLoader(ServiceParcelable.class.getClassLoader());     // Catch: Throwable -> L134
        Parcelable r18 = r12.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L134
        if ((r18 instanceof ServiceParcelable) == false) goto L156;
        int r10 = ((ServiceParcelable) r18).getChannelId();     // Catch: Throwable -> L134
        int r19 = ((ServiceParcelable) r18).getServiceId();     // Catch: Throwable -> L134
        IWsChannelClient r110 = this.mChannelKeeper.mWsChannelClientMap.get(Integer.valueOf(r10));     // Catch: Throwable -> L134
        if (r110 != null) goto L36;
        return;
    L36:
        if (Logger.debug() == false) goto L38;
        Logger.d("WsChannelService", "register serviceId = " + r19);     // Catch: Throwable -> L134
    L38:
        r110.registerService(r19);     // Catch: Throwable -> L134
        return;
    L156:
        return;
    L21:
        if (r6 != 13) goto L152;
        r12.getData().setClassLoader(ServiceParcelable.class.getClassLoader());     // Catch: Throwable -> L134
        Parcelable r111 = r12.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L134
        if ((r111 instanceof ServiceParcelable) == false) goto L153;
        int r20 = ((ServiceParcelable) r111).getChannelId();     // Catch: Throwable -> L134
        int r112 = ((ServiceParcelable) r111).getServiceId();     // Catch: Throwable -> L134
        IWsChannelClient r113 = this.mChannelKeeper.mWsChannelClientMap.get(Integer.valueOf(r20));     // Catch: Throwable -> L134
        if (r113 != null) goto L28;
        return;
    L28:
        if (Logger.debug() == false) goto L30;
        Logger.d("WsChannelService", "unregister serviceId = " + r112);     // Catch: Throwable -> L134
    L30:
        r113.unregisterService(r112);     // Catch: Throwable -> L134
        return;
    L153:
        return;
    L152:
        return;
    L39:
        this.mMessageHandler.syncSocketState();     // Catch: Throwable -> L134
        return;
    L107:
        r12.getData().setClassLoader(SsWsApp.class.getClassLoader());     // Catch: Throwable -> L134
        Parcelable r114 = r12.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L134
        if ((r114 instanceof IntegerParcelable) == false) goto L167;
        int r115 = ((IntegerParcelable) r114).getData();     // Catch: Throwable -> L134
        monitor-enter(WsChannelService.class);     // Catch: Throwable -> L134
        this.mChannelKeeper.mWsAppMap.remove(Integer.valueOf(r115));     // Catch: Throwable -> L127
        this.mChannelSaver.saveWsChannels(this.mChannelKeeper.mWsAppMap);     // Catch: Throwable -> L127
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L127
        Object r21 = this.mLock;     // Catch: Throwable -> L134
        monitor-enter(r21);     // Catch: Throwable -> L134
        IWsChannelClient r22 = this.mChannelKeeper.mWsChannelClientMap.remove(Integer.valueOf(r115));     // Catch: Throwable -> L124
        monitor-exit(r21);     // Catch: Throwable -> L124
        if (r22 != null) goto L119;
    L122:
        this.mChannelKeeper.mChannelState.remove(Integer.valueOf(r115));     // Catch: Throwable -> L134
        this.mThreadHandler.sendMessageDelayed(this.mThreadHandler.obtainMessage(8, r22), 1000);     // Catch: Throwable -> L134
        return;
    L119:
        if (Logger.debug() == false) goto L121;
        Logger.d("WsChannelService", "stopConnection,channelId = " + r115);     // Catch: Throwable -> L134
    L121:
        r22.destroy();     // Catch: Throwable -> L134
        goto L122
    L124:
        th = move-exception;
        throw th;     // Catch: Throwable -> L134
    L127:
        th = move-exception;
        throw th;     // Catch: Throwable -> L134
    L167:
        return;
    L130:
        r12.getData().setClassLoader(SsWsApp.class.getClassLoader());     // Catch: Throwable -> L134
        Parcelable r116 = r12.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L134
        if ((r116 instanceof IWsApp) == false) goto L168;
        doRegisterChannel((IWsApp) r116);     // Catch: Throwable -> L134
        return;
    L168:
        return;
    L134:
        th = move-exception;
        th.printStackTrace();
    }

    public WsChannelMsg tryAddOkWsPayloadOpaque(IWsChannelClient r2, WsChannelMsg r3) {
        WsChannelSettings.OkOpaqueCallback r1 = WsChannelSettings.getOkOpaqueCallback();
        if (r1 != null) goto L14;
        return r3;
    L14:
        Iterator<Map.Entry<String, String>> r4 = r1.onCallToWSPayloadOpaque(r3.toMap()).entrySet().iterator();     // Catch: Exception -> L11
    L7:
        if (r4.hasNext() == false) goto L10;
        Map.Entry<String, String> r5 = r4.next();     // Catch: Exception -> L11
        r3.addHeader(r5.getKey(), r5.getValue());     // Catch: Exception -> L11
        goto L7
    L10:
        return r3;
    L11:
        e = move-exception;
        Logger.w("tryAddOkWsPayloadOpaque failed with exception" + e);
        return r3;
    }

    private void sendAppStateChangeEvent(Collection<IWsChannelClient> r2) {
        if (WsChannelSettings.inst(this.mContext).isReportAppStateEnable() == true) goto L5;
        return;
    L5:
        Iterator<IWsChannelClient> r3 = r2.iterator();
    L7:
        if (r3.hasNext() == false) goto L13;
        sendAppStateChangeMessage(r3.next());     // Catch: Exception -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    WsChannelMsg createStateChangedMsg() {
        WsChannelMsg.Builder r0 = WsChannelMsg.Builder.create(Integer.MAX_VALUE).setMethod(4).setService(WsConstants.APP_STATE_CHANGE_SERVICE).setLogId(1008601).setPayload(new byte[0]).setPayloadEncoding("pb").setPayloadType("pb");
        if (isForeground() == false) goto L5;
        String r3 = "0";
    L7:
        return r0.addMsgHeader(WsConstants.APP_STATE_BACKGROUND_KEY, r3).build();
    L5:
        r3 = "1";
        goto L7
    }

    private void doOnParamChange(IWsApp r6) {
        if (Logger.debug() == false) goto L5;
        Logger.d("WsChannelService", "doOnParamChange");
    L5:
        int r0 = WsChannelService.getClientKey(r6);
        if (isEnable() == false) goto L33;
        IWsChannelClient r1 = this.mChannelKeeper.mWsChannelClientMap.get(Integer.valueOf(r6.getChannelId()));     // Catch: Throwable -> L28
        monitor-enter(WsChannelService.class);     // Catch: Throwable -> L28
        IWsApp r3 = this.mChannelKeeper.mWsAppMap.get(Integer.valueOf(r0));     // Catch: Throwable -> L25
        if (r1 != null) goto L12;
    L23:
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L25
        return;
    L12:
        if (r6.equals(r3) == true) goto L14;
    L16:
        this.mChannelKeeper.mWsAppMap.put(Integer.valueOf(r0), r6);     // Catch: Throwable -> L25
        this.mChannelSaver.saveWsChannels(this.mChannelKeeper.mWsAppMap);     // Catch: Throwable -> L25
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L25
        Map<String, Object> r5 = getConfigMap(r6);     // Catch: Throwable -> L28
        if (r5 == null) goto L22;
        r1.onParameterChange(r5, r6.getConnectUrls());     // Catch: Throwable -> L28
        return;
    L22:
        throw new IllegalArgumentException("configMap is empty !!!");     // Catch: Throwable -> L28
    L14:
        if (r1.isConnected() == false) goto L16;
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    private void doRegisterChannel(IWsApp r9) {
        int r0 = WsChannelService.getClientKey(r9);
        if (isEnable() == true) goto L6;
        return;
    L6:
        monitor-enter(WsChannelService.class);
        IWsApp r2 = this.mChannelKeeper.mWsAppMap.get(Integer.valueOf(r0));     // Catch: Throwable -> L22
        IWsChannelClient r3 = this.mChannelKeeper.mWsChannelClientMap.get(Integer.valueOf(r0));     // Catch: Throwable -> L22
        boolean r4 = false;
        boolean r5 = true;
        if (r2 != null) goto L10;
    L14:
        if (r2 != null) goto L16;
        this.mChannelKeeper.mWsAppMap.put(Integer.valueOf(r0), r9);     // Catch: Throwable -> L22
        this.mChannelSaver.saveWsChannels(this.mChannelKeeper.mWsAppMap);     // Catch: Throwable -> L22
    L12:
        r5 = false;
        r4 = true;
    L16:
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L22
        if (r4 == false) goto L19;
        tryOpenConnection(r9);
        return;
    L19:
        if (r5 == false) goto L28;
        doOnParamChange(r9);
        return;
    L28:
        return;
    L10:
        if (r9.equals(r2) == false) goto L14;
        if (r3 == null) goto L12;
        r5 = false;
    L22:
        th = move-exception;
        throw th;
    }

    private void tryOpenConnection(IWsApp r6) {
        if (Logger.debug() == false) goto L5;
        Logger.d("WsChannelService", "tryOpenConnection");
    L5:
        Object r1 = this.mLock;
        monitor-enter(r1);
        IWsChannelClient r2 = this.mChannelKeeper.mWsChannelClientMap.get(Integer.valueOf(r6.getChannelId()));     // Catch: Throwable -> L28
        if (r2 != null) goto L10;
        r2 = WsChannelClient.newInstance(r6.getChannelId(), this.mMessageHandler, this.mThreadHandler);     // Catch: Throwable -> L28
        r2.init(this.mContext, r2);     // Catch: Throwable -> L28
        this.mChannelKeeper.mWsChannelClientMap.put(Integer.valueOf(r6.getChannelId()), r2);     // Catch: Throwable -> L28
    L10:
        monitor-exit(r1);     // Catch: Throwable -> L28
        if (r2.isConnected() == false) goto L32;
        SocketState r7 = this.mChannelKeeper.mChannelState.get(Integer.valueOf(r6.getChannelId()));
        Logger.d("WsChannelService", "state = " + r7);
        if (r7 == null) goto L37;
        this.mMessageHandler.onConnection(r2, r7);     // Catch: Throwable -> L31
        return;
    L40:
        return;
    L37:
        return;
    L32:
    L25:
        th = move-exception;
        th.printStackTrace();
        return;
    L18:
        if (Logger.debug() == false) goto L20;
        Logger.d("WsChannelService", "try to open connection ,channelId = " + r6.getChannelId());     // Catch: Throwable -> L25
    L20:
        Map<String, Object> r5 = getConfigMap(r6);     // Catch: Throwable -> L25
        if (r5 == null) goto L24;
        r2.openConnection(r5, r6.getConnectUrls());     // Catch: Throwable -> L25
        return;
    L24:
        throw new IllegalArgumentException("configMap is empty !!!");     // Catch: Throwable -> L25
    L28:
        th = move-exception;
        throw th;
    }

    private boolean isEnable() {
        return this.mWsChannelEnableObserver.isEnable();
    }

    private void runOnHandlerThread(Runnable r1) {
        this.mThreadHandler.post(r1);
    }

    @Override // com.bytedance.common.wschannel.server.IEnableObserver.OnWsChannelEnableChangedObserver
    public void onWsChannelEnableChange(boolean r1) {
        if (r1 == false) goto L4;
        tryConnectIfEnable(this.mChannelSaver.loadWsChannels());
        return;
    L4:
        stopAllSocket();
    }

    private void stopAllSocket() {
        Object r0 = this.mLock;     // Catch: Throwable -> L17
        monitor-enter(r0);     // Catch: Throwable -> L17
        Iterator<Map.Entry<Integer, IWsChannelClient>> r1 = this.mChannelKeeper.mWsChannelClientMap.entrySet().iterator();     // Catch: Throwable -> L14
    L6:
        if (r1.hasNext() == false) goto L10;
        IWsChannelClient r2 = r1.next().getValue();     // Catch: Throwable -> L14
        if (r2 == null) goto L6;
        r2.destroy();     // Catch: Throwable -> L14
        goto L6
    L10:
        this.mChannelKeeper.mWsChannelClientMap.clear();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        this.mChannelKeeper.mWsAppMap.clear();     // Catch: Throwable -> L17
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.printStackTrace();
    }

    void syncCurrentState(final IWsChannelClient r3) {
        if (r3.isConnected() == true) goto L5;
        return;
    L5:
        this.mThreadHandler.post(new AnonymousClass3(this, r3));
    }

    private void sendAppStateChangeMessage(IWsChannelClient r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        WsChannelMsg r1 = createStateChangedMsg();
        if (r2.privateProtocolEnabled() == false) goto L8;
        r2.sendMessage(r1);
        return;
    L8:
        r2.sendMessage(MsgConverterFactory.getConverter().encode(r1));
    }
}
