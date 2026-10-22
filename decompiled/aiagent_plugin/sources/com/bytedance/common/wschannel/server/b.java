package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.model.IntegerParcelable;
import com.bytedance.common.wschannel.model.ServiceParcelable;
import com.bytedance.common.wschannel.model.SocketState;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: ChannelManager.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements WeakHandler.IHandler, e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakHandler f7034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f7035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f7036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final f f7037d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bytedance.common.wschannel.channel.a f7038e;
    private final a f;
    private AtomicLong g;
    private e h;
    private boolean i;

    static /* synthetic */ f a(b r0) {
        return r0.f7037d;
    }

    static /* synthetic */ void a(b r0, Message r1) {
        r0.a(r1);
    }

    static /* synthetic */ void a(b r2, IWsChannelClient r3) {
        r2.b((IWsChannelClient) ZeusTransformUtils.wrapperContextForParams(r3, IWsChannelClient.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ void a(b r2, Map r3) {
        r2.a((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ e b(b r0) {
        return r0.h;
    }

    b(Context r5, Looper r6, f r7, a r8, com.bytedance.common.wschannel.channel.a r9, e r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        f r12 = (f) ZeusTransformUtils.wrapperContextForParams(r7, f.class, "com.obric.aiagent.plugin");
        com.bytedance.common.wschannel.channel.a r13 = (com.bytedance.common.wschannel.channel.a) ZeusTransformUtils.wrapperContextForParams(r9, com.bytedance.common.wschannel.channel.a.class, "com.obric.aiagent.plugin");
        final e r14 = (e) ZeusTransformUtils.wrapperContextForParams(r10, e.class, "com.obric.aiagent.plugin");
        this.f7036c = new Object();
        this.g = new AtomicLong(0);
        this.i = false;
        this.f7035b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f7034a = new WeakHandler(r6, this);
        this.f7037d = r12;
        this.f = r8;
        this.f7038e = r13;
        this.h = r14;
        r14.a(this);
        a(new AnonymousClass1(this, r14));
    }

    private Map<String, Object> a(IWsApp r11) {
        IWsApp r12 = (IWsApp) ZeusTransformUtils.wrapperContextForParams(r11, IWsApp.class, "com.obric.aiagent.plugin");
        HashMap r0 = new HashMap();
        r0.put(WsConstants.KEY_APP_KEY, r12.getAppKey());
        r0.put(WsConstants.KEY_FPID, Integer.valueOf(r12.getFPID()));
        r0.put("sdk_version", 2);
        r0.put(WsConstants.KEY_PLATFORM, 0);
        r0.put(WsConstants.KEY_APP_VERSION, Integer.valueOf(r12.getAppVersion()));
        r0.put(WsConstants.KEY_APP_ID, Integer.valueOf(r12.getAppId()));
        r0.put("device_id", r12.getDeviceId());
        r0.put(WsConstants.KEY_INSTALL_ID, r12.getInstallId());
        r0.put(WsConstants.KEY_HEADERS, r12.getHeaders());
        String r3 = r12.getExtra();
        if (r3 != null) goto L6;
        a("extra");
        r3 = "";
    L6:
        if (com.bytedance.common.wschannel.m.a(this.f7035b).h() == false) goto L17;
        String[] r7 = r3.split("&");
        StringBuilder r8 = new StringBuilder().append("is_background=");
        if (b() == false) goto L10;
        String r9 = "0";
    L11:
        String r10 = r8.append(r9).toString();
        if (r7.length > 0) goto L14;
    L16:
        r3 = r10;
        goto L17
    L14:
        if (TextUtils.isEmpty(r7[0]) == true) goto L16;
        r3 = r3 + "&" + r10;
        goto L17
    L10:
        r9 = "1";
    L17:
        r0.put("extra", r3);
        if (r12.getDeviceId() != null) goto L21;
        a("device_id");
    L21:
        if (r12.getInstallId() != null) goto L24;
        a("install_id");
    L24:
        if (com.bytedance.common.utility.j.a(r12.getAppKey()) == false) goto L26;
        a(WsConstants.KEY_APP_KEY);
    L26:
        r0.put(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE, Boolean.valueOf(r12.newPrivateProtocolEnabled()));
        if (r12.getServiceIdList() == null) goto L30;
        r0.put(WsConstants.KEY_SERVICE_ID_LIST, r12.getServiceIdList());
    L30:
        if (TextUtils.isEmpty(r12.getPrivateProtocolUrl()) == true) goto L32;
        r0.put(WsConstants.KEY_PRIVATE_PROTOCOL_URL, r12.getPrivateProtocolUrl());
    L32:
        r0.put(WsConstants.KEY_TRANSPORT_MODE, Integer.valueOf(r12.getTransportMode()));
        r0.put(WsConstants.KEY_DISABLE_FALLBACK_WEBSOCKET, Boolean.valueOf(r12.disableFallbackWSEnabled()));
        return r0;
    }

    private boolean b() {
        return this.i;
    }

    private void a(String r3) {
        Bundle r0 = new Bundle();
        r0.putString("param_name", r3);
        com.bytedance.common.wschannel.d.a.a(this.f7035b, "wschannel_param_null", r0);
    }

    private void a(Map<Integer, IWsApp> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        if (c() == false) goto L8;
        if (i.a(this.f7035b) == true) goto L8;
        return;
    L8:
        if (this.h.b() == false) goto L17;
        if (r5 == null) goto L23;
        Iterator r6 = r5.values().iterator();
    L12:
        if (r6.hasNext() == false) goto L24;
        IWsApp r0 = (IWsApp) ZeusTransformUtils.preCheckCast(r6.next(), IWsApp.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L12;
        c(r0);
        goto L12
    L24:
        return;
    L23:
        return;
    }

    private boolean c() {
        Context r1 = this.f7035b;
        if (r1 != null) goto L5;
        return false;
    L5:
        com.bytedance.common.wschannel.m r2 = com.bytedance.common.wschannel.m.a(r1);
        if (r2 != null) goto L9;
        return false;
    L9:
        return r2.a();
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r2) {
        final Message r3 = Message.obtain(r2);
        a(new AnonymousClass2(this, r3));
    }

    private void a(Message r11) {
        int r0 = r11.what;     // Catch: Throwable -> L133
        if (r0 == 0) goto L129;
        boolean r1 = true;
        if (r0 == 1) goto L106;
        boolean r3 = false;
        if (r0 != 2) goto L9;
        int r12 = r11.arg1;     // Catch: Throwable -> L133
        if (Logger.debug() == false) goto L95;
        Logger.d("WsChannelService", "appState = " + r12);     // Catch: Throwable -> L133
    L95:
        if (r12 == 1) goto L98;
        r1 = false;
    L98:
        this.i = r1;     // Catch: Throwable -> L133
        this.f7038e.a();     // Catch: Throwable -> L133
        if (d() == false) goto L165;
        a(this.f.f7032b.values());     // Catch: Throwable -> L133
        Iterator<IWsChannelClient> r10 = this.f.f7032b.values().iterator();     // Catch: Throwable -> L133
    L102:
        if (r10.hasNext() == false) goto L171;
        IWsChannelClient r2 = (IWsChannelClient) ZeusTransformUtils.preCheckCast(r10.next(), IWsChannelClient.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L133
        if (r2 == null) goto L102;
        r2.onAppStateChanged(r12);     // Catch: Throwable -> L133
        goto L102
    L171:
        return;
    L165:
        return;
    L9:
        if (r0 != 3) goto L11;
        int r13 = r11.arg1;     // Catch: Throwable -> L133
        if (Logger.debug() == false) goto L84;
        Logger.d("WsChannelService", "networkState = " + r13);     // Catch: Throwable -> L133
    L84:
        this.f7038e.a();     // Catch: Throwable -> L133
        if (d() == false) goto L164;
        Iterator<IWsChannelClient> r14 = this.f.f7032b.values().iterator();     // Catch: Throwable -> L133
    L88:
        if (r14.hasNext() == false) goto L170;
        IWsChannelClient r4 = (IWsChannelClient) ZeusTransformUtils.preCheckCast(r14.next(), IWsChannelClient.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L133
        if (r4 == null) goto L88;
        r4.onNetworkStateChanged(r13);     // Catch: Throwable -> L133
        goto L88
    L170:
        return;
    L164:
        return;
    L11:
        if (r0 != 4) goto L13;
        r11.getData().setClassLoader(SsWsApp.class.getClassLoader());     // Catch: Throwable -> L133
        Parcelable r15 = r11.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L133
        if (ZeusTransformUtils.instanceOf(r15, IWsApp.class) == false) goto L162;
        b((IWsApp) ZeusTransformUtils.preCheckCast(r15, IWsApp.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L133
        return;
    L162:
        return;
    L13:
        if (r0 != 5) goto L15;
    L39:
        if (r0 == 10) goto L42;
        r1 = false;
    L42:
        r11.getData().setClassLoader(WsChannelMsg.class.getClassLoader());     // Catch: Throwable -> L133
        Parcelable r5 = r11.getData().getParcelable("payload");     // Catch: Throwable -> L133
        if (ZeusTransformUtils.instanceOf(r5, WsChannelMsg.class) == false) goto L159;
        WsChannelMsg r6 = (WsChannelMsg) ZeusTransformUtils.preCheckCast(r5, WsChannelMsg.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L133
        if (r6.getSeqId() > 0) goto L47;
        r6.setSeqId(this.g.incrementAndGet());     // Catch: Throwable -> L133
    L47:
        IWsChannelClient r7 = (IWsChannelClient) ZeusTransformUtils.preCheckCast(this.f.f7032b.get(Integer.valueOf(r6.getChannelId())), IWsChannelClient.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L133
        if (r1 == false) goto L50;
        Logger.d("WsChannelService", "retry send msg");     // Catch: Throwable -> L133
    L50:
        if (r7 == null) goto L74;
        if (r0 == 10) goto L58;
        if (ZeusTransformUtils.instanceOf(r7, com.bytedance.common.wschannel.channel.b.class) == false) goto L58;
        if (((com.bytedance.common.wschannel.channel.b) ZeusTransformUtils.preCheckCast(r7, com.bytedance.common.wschannel.channel.b.class, "com.obric.aiagent.plugin")).a() == false) goto L58;
        r6 = a(r7, r6);     // Catch: Throwable -> L133
    L58:
        if (r7.privateProtocolEnabled() == true) goto L60;
    L62:
        boolean r8 = r7.sendMessage(com.bytedance.common.wschannel.a.b.a().a(r6));     // Catch: Throwable -> L133
    L63:
        r3 = r8;
        long r9 = com.bytedance.common.wschannel.m.a(this.f7035b).g();     // Catch: Throwable -> L133
        if (r3 == true) goto L69;
        if (r1 == true) goto L69;
        if (r9 <= 0) goto L69;
        Message r16 = Message.obtain(r11);     // Catch: Throwable -> L133
        r16.what = 10;     // Catch: Throwable -> L133
        this.f7034a.sendMessageDelayed(r16, r9);     // Catch: Throwable -> L133
    L69:
        if (r3 == false) goto L71;
    L73:
        this.f7038e.a(r6, r3);     // Catch: Throwable -> L133
    L76:
        if (Logger.debug() == false) goto L160;
        Logger.d("WsChannelService", "send payload success = " + r3);     // Catch: Throwable -> L133
        return;
    L160:
        return;
    L71:
        if (r9 <= 0) goto L73;
        if (r1 == false) goto L76;
    L60:
        if (r7.privateProtocolProxyEnabled() == true) goto L62;
        r8 = r7.sendMessage(r6);     // Catch: Throwable -> L133
        goto L63
    L74:
        this.f7038e.a(r6, false);     // Catch: Throwable -> L133
        goto L76
    L159:
        return;
    L15:
        if (r0 == 9) goto L38;
        if (r0 == 10) goto L39;
        if (r0 != 12) goto L20;
        r11.getData().setClassLoader(ServiceParcelable.class.getClassLoader());     // Catch: Throwable -> L133
        Parcelable r17 = r11.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L133
        if (ZeusTransformUtils.instanceOf(r17, ServiceParcelable.class) == false) goto L155;
        int r18 = ((ServiceParcelable) ZeusTransformUtils.preCheckCast(r17, ServiceParcelable.class, "com.obric.aiagent.plugin")).getChannelId();     // Catch: Throwable -> L133
        int r19 = ((ServiceParcelable) ZeusTransformUtils.preCheckCast(r17, ServiceParcelable.class, "com.obric.aiagent.plugin")).getServiceId();     // Catch: Throwable -> L133
        IWsChannelClient r110 = (IWsChannelClient) ZeusTransformUtils.preCheckCast(this.f.f7032b.get(Integer.valueOf(r18)), IWsChannelClient.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L133
        if (r110 != null) goto L35;
        return;
    L35:
        if (Logger.debug() == false) goto L37;
        Logger.d("WsChannelService", "register serviceId = " + r19);     // Catch: Throwable -> L133
    L37:
        r110.registerService(r19);     // Catch: Throwable -> L133
        return;
    L155:
        return;
    L20:
        if (r0 != 13) goto L151;
        r11.getData().setClassLoader(ServiceParcelable.class.getClassLoader());     // Catch: Throwable -> L133
        Parcelable r111 = r11.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L133
        if (ZeusTransformUtils.instanceOf(r111, ServiceParcelable.class) == false) goto L152;
        int r20 = ((ServiceParcelable) ZeusTransformUtils.preCheckCast(r111, ServiceParcelable.class, "com.obric.aiagent.plugin")).getChannelId();     // Catch: Throwable -> L133
        int r112 = ((ServiceParcelable) ZeusTransformUtils.preCheckCast(r111, ServiceParcelable.class, "com.obric.aiagent.plugin")).getServiceId();     // Catch: Throwable -> L133
        IWsChannelClient r113 = (IWsChannelClient) ZeusTransformUtils.preCheckCast(this.f.f7032b.get(Integer.valueOf(r20)), IWsChannelClient.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L133
        if (r113 != null) goto L27;
        return;
    L27:
        if (Logger.debug() == false) goto L29;
        Logger.d("WsChannelService", "unregister serviceId = " + r112);     // Catch: Throwable -> L133
    L29:
        r113.unregisterService(r112);     // Catch: Throwable -> L133
        return;
    L152:
        return;
    L151:
        return;
    L38:
        this.f7038e.b();     // Catch: Throwable -> L133
        return;
    L106:
        r11.getData().setClassLoader(SsWsApp.class.getClassLoader());     // Catch: Throwable -> L133
        Parcelable r114 = r11.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L133
        if (ZeusTransformUtils.instanceOf(r114, IntegerParcelable.class) == false) goto L166;
        int r115 = ((IntegerParcelable) ZeusTransformUtils.preCheckCast(r114, IntegerParcelable.class, "com.obric.aiagent.plugin")).getData();     // Catch: Throwable -> L133
        monitor-enter(WsChannelService.class);     // Catch: Throwable -> L133
        this.f.f7031a.remove(Integer.valueOf(r115));     // Catch: Throwable -> L126
        this.f7037d.a(this.f.f7031a);     // Catch: Throwable -> L126
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L126
        Object r21 = this.f7036c;     // Catch: Throwable -> L133
        monitor-enter(r21);     // Catch: Throwable -> L133
        IWsChannelClient r22 = (IWsChannelClient) ZeusTransformUtils.preCheckCast(this.f.f7032b.remove(Integer.valueOf(r115)), IWsChannelClient.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L123
        monitor-exit(r21);     // Catch: Throwable -> L123
        if (r22 != null) goto L118;
    L121:
        this.f.f7033c.remove(Integer.valueOf(r115));     // Catch: Throwable -> L133
        this.f7034a.sendMessageDelayed(this.f7034a.obtainMessage(8, r22), 1000);     // Catch: Throwable -> L133
        return;
    L118:
        if (Logger.debug() == false) goto L120;
        Logger.d("WsChannelService", "stopConnection,channelId = " + r115);     // Catch: Throwable -> L133
    L120:
        r22.destroy();     // Catch: Throwable -> L133
        goto L121
    L123:
        th = move-exception;
        throw th;     // Catch: Throwable -> L133
    L126:
        th = move-exception;
        throw th;     // Catch: Throwable -> L133
    L166:
        return;
    L129:
        r11.getData().setClassLoader(SsWsApp.class.getClassLoader());     // Catch: Throwable -> L133
        Parcelable r116 = r11.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L133
        if (ZeusTransformUtils.instanceOf(r116, IWsApp.class) == false) goto L167;
        c((IWsApp) ZeusTransformUtils.preCheckCast(r116, IWsApp.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L133
        return;
    L167:
        return;
    L133:
        th = move-exception;
        th.printStackTrace();
    }

    public WsChannelMsg a(IWsChannelClient r4, WsChannelMsg r5) {
        IWsChannelClient r3 = (IWsChannelClient) ZeusTransformUtils.wrapperContextForParams(r4, IWsChannelClient.class, "com.obric.aiagent.plugin");
        com.bytedance.common.wschannel.m.a r6 = com.bytedance.common.wschannel.m.b();
        if (r6 != null) goto L14;
        return r5;
    L14:
        Iterator<Map.Entry<String, String>> r7 = r6.a(r5.toMap()).entrySet().iterator();     // Catch: Exception -> L11
    L7:
        if (r7.hasNext() == false) goto L10;
        Map.Entry r8 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L11
        r5.addHeader((String) ZeusTransformUtils.preCheckCast(r8.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r8.getValue(), String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L11
        goto L7
    L10:
        return r5;
    L11:
        e = move-exception;
        Logger.w("tryAddOkWsPayloadOpaque failed with exception" + e);
        return r5;
    }

    private void a(Collection<IWsChannelClient> r4) {
        Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.aiagent.plugin");
        if (com.bytedance.common.wschannel.m.a(this.f7035b).h() == true) goto L5;
        return;
    L5:
        Iterator r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L13;
        b((IWsChannelClient) ZeusTransformUtils.preCheckCast(r6.next(), IWsChannelClient.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    WsChannelMsg a() {
        WsChannelMsg.a r0 = WsChannelMsg.a.a(Integer.MAX_VALUE).c(4).b(WsConstants.APP_STATE_CHANGE_SERVICE).a(1008601).a(new byte[0]).b("pb").a("pb");
        if (b() == false) goto L5;
        String r3 = "0";
    L7:
        return r0.a(WsConstants.APP_STATE_BACKGROUND_KEY, r3).a();
    L5:
        r3 = "1";
        goto L7
    }

    private void b(IWsApp r7) {
        IWsApp r8 = (IWsApp) ZeusTransformUtils.wrapperContextForParams(r7, IWsApp.class, "com.obric.aiagent.plugin");
        if (Logger.debug() == false) goto L5;
        Logger.d("WsChannelService", "doOnParamChange");
    L5:
        int r0 = WsChannelService.getClientKey(r8);
        if (d() == false) goto L33;
        IWsChannelClient r1 = (IWsChannelClient) ZeusTransformUtils.preCheckCast(this.f.f7032b.get(Integer.valueOf(r8.getChannelId())), IWsChannelClient.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
        monitor-enter(WsChannelService.class);     // Catch: Throwable -> L28
        IWsApp r3 = (IWsApp) ZeusTransformUtils.preCheckCast(this.f.f7031a.get(Integer.valueOf(r0)), IWsApp.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r1 != null) goto L12;
    L23:
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L25
        return;
    L12:
        if (r8.equals(r3) == true) goto L14;
    L16:
        this.f.f7031a.put(Integer.valueOf(r0), r8);     // Catch: Throwable -> L25
        this.f7037d.a(this.f.f7031a);     // Catch: Throwable -> L25
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L25
        Map<String, Object> r6 = a(r8);     // Catch: Throwable -> L28
        if (r6 == null) goto L22;
        r1.onParameterChange(r6, r8.getConnectUrls());     // Catch: Throwable -> L28
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

    private void c(IWsApp r9) {
        IWsApp r10 = (IWsApp) ZeusTransformUtils.wrapperContextForParams(r9, IWsApp.class, "com.obric.aiagent.plugin");
        int r0 = WsChannelService.getClientKey(r10);
        if (d() == true) goto L6;
        return;
    L6:
        monitor-enter(WsChannelService.class);
        IWsApp r2 = (IWsApp) ZeusTransformUtils.preCheckCast(this.f.f7031a.get(Integer.valueOf(r0)), IWsApp.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        IWsChannelClient r3 = (IWsChannelClient) ZeusTransformUtils.preCheckCast(this.f.f7032b.get(Integer.valueOf(r0)), IWsChannelClient.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        boolean r4 = false;
        boolean r5 = true;
        if (r2 != null) goto L10;
    L14:
        if (r2 != null) goto L16;
        this.f.f7031a.put(Integer.valueOf(r0), r10);     // Catch: Throwable -> L22
        this.f7037d.a(this.f.f7031a);     // Catch: Throwable -> L22
    L12:
        r5 = false;
        r4 = true;
    L16:
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L22
        if (r4 == false) goto L19;
        d(r10);
        return;
    L19:
        if (r5 == false) goto L28;
        b(r10);
        return;
    L28:
        return;
    L10:
        if (r10.equals(r2) == false) goto L14;
        if (r3 == null) goto L12;
        r5 = false;
    L22:
        th = move-exception;
        throw th;
    }

    private void d(IWsApp r5) {
        IWsApp r6 = (IWsApp) ZeusTransformUtils.wrapperContextForParams(r5, IWsApp.class, "com.obric.aiagent.plugin");
        if (Logger.debug() == false) goto L5;
        Logger.d("WsChannelService", "tryOpenConnection");
    L5:
        Object r0 = this.f7036c;
        monitor-enter(r0);
        IWsChannelClient r1 = (IWsChannelClient) ZeusTransformUtils.preCheckCast(this.f.f7032b.get(Integer.valueOf(r6.getChannelId())), IWsChannelClient.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
        if (r1 != null) goto L10;
        r1 = com.bytedance.common.wschannel.channel.b.a(r6.getChannelId(), this.f7038e, this.f7034a);     // Catch: Throwable -> L28
        r1.init(this.f7035b, r1);     // Catch: Throwable -> L28
        this.f.f7032b.put(Integer.valueOf(r6.getChannelId()), r1);     // Catch: Throwable -> L28
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L28
        if (r1.isConnected() == false) goto L36;
        SocketState r7 = (SocketState) ZeusTransformUtils.preCheckCast(this.f.f7033c.get(Integer.valueOf(r6.getChannelId())), SocketState.class, "com.obric.aiagent.plugin");
        Logger.d("WsChannelService", "state = " + r7);
        if (r7 == null) goto L37;
        this.f7038e.a(r1, r7);     // Catch: Throwable -> L31
        return;
    L40:
        return;
    L37:
        return;
    L36:
    L25:
        th = move-exception;
        th.printStackTrace();
        return;
    L18:
        if (Logger.debug() == false) goto L20;
        Logger.d("WsChannelService", "try to open connection ,channelId = " + r6.getChannelId());     // Catch: Throwable -> L25
    L20:
        Map<String, Object> r4 = a(r6);     // Catch: Throwable -> L25
        if (r4 == null) goto L24;
        r1.openConnection(r4, r6.getConnectUrls());     // Catch: Throwable -> L25
        return;
    L24:
        throw new IllegalArgumentException("configMap is empty !!!");     // Catch: Throwable -> L25
    L28:
        th = move-exception;
        throw th;
    }

    private boolean d() {
        return this.h.b();
    }

    private void a(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        this.f7034a.post(r4);
    }

    @Override // com.bytedance.common.wschannel.server.e.a
    public void a(boolean r1) {
        if (r1 == false) goto L4;
        a(this.f7037d.a());
        return;
    L4:
        e();
    }

    private void e() {
        Object r0 = this.f7036c;     // Catch: Throwable -> L17
        monitor-enter(r0);     // Catch: Throwable -> L17
        Iterator<Map.Entry<Integer, IWsChannelClient>> r1 = this.f.f7032b.entrySet().iterator();     // Catch: Throwable -> L14
    L6:
        if (r1.hasNext() == false) goto L10;
        IWsChannelClient r2 = (IWsChannelClient) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), IWsChannelClient.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (r2 == null) goto L6;
        r2.destroy();     // Catch: Throwable -> L14
        goto L6
    L10:
        this.f.f7032b.clear();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        this.f.f7031a.clear();     // Catch: Throwable -> L17
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.printStackTrace();
    }

    void a(IWsChannelClient r3) {
        final IWsChannelClient r4 = (IWsChannelClient) ZeusTransformUtils.wrapperContextForParams(r3, IWsChannelClient.class, "com.obric.aiagent.plugin");
        if (r4.isConnected() == true) goto L5;
        return;
    L5:
        this.f7034a.post(new AnonymousClass3(this, r4));
    }

    private void b(IWsChannelClient r3) {
        IWsChannelClient r4 = (IWsChannelClient) ZeusTransformUtils.wrapperContextForParams(r3, IWsChannelClient.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        WsChannelMsg r2 = a();
        if (r4.privateProtocolEnabled() == false) goto L9;
        r4.sendMessage(r2);
        return;
    L9:
        r4.sendMessage(com.bytedance.common.wschannel.a.b.a().a(r2));
    }
}
