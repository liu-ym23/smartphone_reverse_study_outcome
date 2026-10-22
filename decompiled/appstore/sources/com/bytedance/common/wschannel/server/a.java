package com.bytedance.common.wschannel.server;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.utility.e;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.model.IntegerParcelable;
import com.bytedance.common.wschannel.model.SocketState;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedanceos.common.ad.param.AdReportParam;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes.dex */
public class a implements WeakHandler.IHandler, WsChannelEnableObserver.OnWsChannelEnableChangedObserver {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static a f7091m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HandlerThread f7092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakHandler f7093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f7094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f7095d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f7096e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.common.wschannel.server.b f7097f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AtomicLong f7098g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public WsChannelEnableObserver f7099h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map f7100i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Map f7101j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Map f7102k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f7103l;

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.server.a$a, reason: collision with other inner class name */
    public class RunnableC0089a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f7104a;

        public RunnableC0089a(a r10) {
            this.f7104a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            a r10 = this.f7104a;
            a.a(r10, new WsChannelEnableObserver(a.b(r10), a.c(this.f7104a), this.f7104a));
            a r11 = this.f7104a;
            a.e(r11, a.d(r11).b());
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Message f7105a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f7106b;

        public b(a r10, Message r11) {
            this.f7106b = r10;
            this.f7105a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.f(this.f7106b, this.f7105a);
        }
    }

    public a(Context r10) {
        HandlerThread r11 = new HandlerThread("wschannel");
        this.f7092a = r11;
        this.f7095d = new Object();
        this.f7098g = new AtomicLong(0);
        this.f7100i = new ConcurrentHashMap();
        this.f7101j = new ConcurrentHashMap();
        this.f7102k = new ConcurrentHashMap();
        this.f7103l = false;
        Context r12 = r10.getApplicationContext();
        this.f7094c = r12;
        r11.start();
        this.f7093b = new WeakHandler(r11.getLooper(), this);
        this.f7096e = new c(r12);
        this.f7097f = new com.bytedance.common.wschannel.server.b(r12, this.f7102k, this.f7100i);
        p(new RunnableC0089a(this));
    }

    public static /* synthetic */ WsChannelEnableObserver a(a r10, WsChannelEnableObserver r11) {
        r10.f7099h = r11;
        return r11;
    }

    public static /* synthetic */ Context b(a r10) {
        return r10.f7094c;
    }

    public static /* synthetic */ WeakHandler c(a r10) {
        return r10.f7093b;
    }

    public static /* synthetic */ c d(a r10) {
        return r10.f7096e;
    }

    public static /* synthetic */ void e(a r10, Map r11) {
        r10.s(r11);
    }

    public static /* synthetic */ void f(a r10, Message r11) {
        r10.h(r11);
    }

    public static a l(Context r10) {
        if (f7091m != null) goto L16;
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f7091m != null) goto L11;
        f7091m = new a(r10);     // Catch: Throwable -> L9
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L9
    L16:
        return f7091m;
    }

    public byte[] g() {
        WsChannelMsg.b r10 = WsChannelMsg.b.c(Channel.UNLIMITED).e(4).i(9000).d(1008601).f(new byte[0]).g("pb").h("pb");
        if (n() == false) goto L5;
        String r11 = AdReportParam.ClickPosType.SKIP;
    L6:
        WsChannelMsg r12 = r10.a("IsBackground", r11).b();
        return e4.a.a().encode(r12);
    L5:
        r11 = "1";
        goto L6
    }

    public final void h(Message r11) {
        int r10 = r11.what;     // Catch: Throwable -> L7
        if (r10 != 0) goto L9;
        r11.getData().setClassLoader(SsWsApp.class.getClassLoader());     // Catch: Throwable -> L7
        Parcelable r12 = r11.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L7
        if ((r12 instanceof IWsApp) == false) goto L129;
        j((IWsApp) r12);     // Catch: Throwable -> L7
        return;
    L129:
        return;
    L9:
        boolean r13 = true;
        if (r10 != 1) goto L34;
        r11.getData().setClassLoader(SsWsApp.class.getClassLoader());     // Catch: Throwable -> L7
        Parcelable r14 = r11.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L7
        if ((r14 instanceof IntegerParcelable) == false) goto L131;
        int r15 = ((IntegerParcelable) r14).getData();     // Catch: Throwable -> L7
        monitor-enter(WsChannelService.class);     // Catch: Throwable -> L7
        this.f7100i.remove(Integer.valueOf(r15));     // Catch: Throwable -> L31
        this.f7096e.c(this.f7100i);     // Catch: Throwable -> L31
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L31
        Object r16 = this.f7095d;     // Catch: Throwable -> L7
        monitor-enter(r16);     // Catch: Throwable -> L7
        IWsChannelClient r17 = (IWsChannelClient) this.f7101j.remove(Integer.valueOf(r15));     // Catch: Throwable -> L28
        monitor-exit(r16);     // Catch: Throwable -> L28
        if (r17 != null) goto L23;
    L26:
        this.f7102k.remove(Integer.valueOf(r15));     // Catch: Throwable -> L7
        this.f7093b.sendMessageDelayed(this.f7093b.obtainMessage(8, r17), 1000);     // Catch: Throwable -> L7
        return;
    L23:
        if (Logger.debug() == false) goto L25;
        Logger.d("WsChannelService", "stopConnection,channelId = " + r15);     // Catch: Throwable -> L7
    L25:
        r17.destroy();     // Catch: Throwable -> L7
        goto L26
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L7
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L7
    L131:
        return;
    L34:
        boolean r18 = false;
        if (r10 != 2) goto L51;
        int r19 = r11.arg1;     // Catch: Throwable -> L7
        if (Logger.debug() == false) goto L39;
        Logger.d("WsChannelService", "appState = " + r19);     // Catch: Throwable -> L7
    L39:
        if (r19 == 1) goto L42;
        r13 = false;
    L42:
        this.f7103l = r13;     // Catch: Throwable -> L7
        this.f7097f.k();     // Catch: Throwable -> L7
        if (m() == false) goto L132;
        q(this.f7101j.values());     // Catch: Throwable -> L7
        Iterator r110 = this.f7101j.values().iterator();     // Catch: Throwable -> L7
    L46:
        if (r110.hasNext() == false) goto L143;
        IWsChannelClient r20 = (IWsChannelClient) r110.next();     // Catch: Throwable -> L7
        if (r20 == null) goto L46;
        r20.onAppStateChanged(r19);     // Catch: Throwable -> L7
        goto L46
    L143:
        return;
    L132:
        return;
    L51:
        if (r10 != 3) goto L64;
        int r111 = r11.arg1;     // Catch: Throwable -> L7
        if (Logger.debug() == false) goto L55;
        Logger.d("WsChannelService", "networkState = " + r111);     // Catch: Throwable -> L7
    L55:
        this.f7097f.k();     // Catch: Throwable -> L7
        if (m() == false) goto L133;
        Iterator r112 = this.f7101j.values().iterator();     // Catch: Throwable -> L7
    L59:
        if (r112.hasNext() == false) goto L144;
        IWsChannelClient r21 = (IWsChannelClient) r112.next();     // Catch: Throwable -> L7
        if (r21 == null) goto L59;
        r21.onNetworkStateChanged(r111);     // Catch: Throwable -> L7
        goto L59
    L144:
        return;
    L133:
        return;
    L64:
        if (r10 != 4) goto L69;
        r11.getData().setClassLoader(SsWsApp.class.getClassLoader());     // Catch: Throwable -> L7
        Parcelable r113 = r11.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L7
        if ((r113 instanceof IWsApp) == false) goto L134;
        i((IWsApp) r113);     // Catch: Throwable -> L7
        return;
    L134:
        return;
    L69:
        if (r10 == 5) goto L75;
        if (r10 == 10) goto L75;
        if (r10 != 9) goto L136;
        this.f7097f.j();     // Catch: Throwable -> L7
        return;
    L136:
        return;
    L75:
        if (r10 != 10) goto L77;
        boolean r22 = true;
    L78:
        r11.getData().setClassLoader(WsChannelMsg.class.getClassLoader());     // Catch: Throwable -> L7
        Parcelable r23 = r11.getData().getParcelable(WsConstants.KEY_PAYLOAD);     // Catch: Throwable -> L7
        if ((r23 instanceof WsChannelMsg) == false) goto L138;
        WsChannelMsg r24 = (WsChannelMsg) r23;     // Catch: Throwable -> L7
        if (r24.getSeqId() > 0) goto L83;
        r24.setSeqId(this.f7098g.incrementAndGet());     // Catch: Throwable -> L7
    L83:
        IWsChannelClient r25 = (IWsChannelClient) this.f7101j.get(Integer.valueOf(r24.getChannelId()));     // Catch: Throwable -> L7
        if (r22 == false) goto L86;
        Logger.d("WsChannelService", "retry send msg");     // Catch: Throwable -> L7
    L86:
        if (r25 == null) goto L94;
        r18 = r25.sendMessage(e4.a.a().encode(r24));     // Catch: Throwable -> L7
        if (r18 == true) goto L94;
        if (r22 == true) goto L94;
        long r26 = com.bytedance.common.wschannel.b.d(this.f7094c).a();     // Catch: Throwable -> L7
        if (r26 <= 0) goto L94;
        Message r114 = Message.obtain(r11);     // Catch: Throwable -> L7
        r114.what = 10;     // Catch: Throwable -> L7
        this.f7093b.sendMessageDelayed(r114, r26);     // Catch: Throwable -> L7
    L94:
        if (Logger.debug() == false) goto L96;
        Logger.d("WsChannelService", "send payload success = " + r18);     // Catch: Throwable -> L7
    L96:
        ComponentName r115 = r24.getReplayToComponentName();     // Catch: Throwable -> L7
        if (r115 == null) goto L139;
        byte[] r27 = r24.getPayload();     // Catch: Throwable -> L101
        if (r27 != null) goto L103;
        r27 = new byte[1];     // Catch: Throwable -> L101
    L103:
        Intent r28 = new Intent();     // Catch: Throwable -> L101
        r28.setAction(WsConstants.SEND_PAYLOAD_ACTION);     // Catch: Throwable -> L101
        r28.setComponent(r115);     // Catch: Throwable -> L101
        r28.putExtra(WsConstants.KEY_SEND_RESULT, r18);     // Catch: Throwable -> L101
        r28.putExtra(WsConstants.KEY_PAYLOAD_MD5, com.bytedance.common.utility.a.a(r27));     // Catch: Throwable -> L101
        if (Logger.debug() == false) goto L106;
        Logger.d("WsChannelService", "send result = " + r18 + " payloadMd5 = " + r28.getStringExtra(WsConstants.KEY_PAYLOAD_MD5));     // Catch: Throwable -> L101
    L106:
        this.f7094c.startService(r28);     // Catch: Throwable -> L101
    L141:
        return;
    L101:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L7
        return;
    L139:
        return;
    L138:
        return;
    L77:
        r22 = false;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r10) {
        p(new b(this, Message.obtain(r10)));
    }

    public final void i(IWsApp r10) {
        int r11 = WsChannelService.b(r10);
        if (m() == false) goto L32;
        IWsChannelClient r12 = (IWsChannelClient) this.f7101j.get(Integer.valueOf(r10.getChannelId()));     // Catch: Throwable -> L20
        monitor-enter(WsChannelService.class);     // Catch: Throwable -> L20
        IWsApp r13 = (IWsApp) this.f7100i.get(Integer.valueOf(r11));     // Catch: Throwable -> L13
        if (r12 != null) goto L9;
    L24:
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L13
        return;
    L9:
        if (r10.equals(r13) == true) goto L11;
    L15:
        this.f7100i.put(Integer.valueOf(r11), r10);     // Catch: Throwable -> L13
        this.f7096e.c(this.f7100i);     // Catch: Throwable -> L13
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L13
        Map<String, Object> r14 = k(r10);     // Catch: Throwable -> L20
        if (r14 == null) goto L23;
        r12.onParameterChange(r14, r10.getConnectUrls());     // Catch: Throwable -> L20
        return;
    L23:
        throw new IllegalArgumentException("configMap is empty !!!");     // Catch: Throwable -> L20
    L11:
        if (r12.isConnected() == false) goto L15;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public final void j(IWsApp r10) {
        int r11 = WsChannelService.b(r10);
        if (m() == true) goto L6;
        return;
    L6:
        monitor-enter(WsChannelService.class);
        IWsApp r12 = (IWsApp) this.f7100i.get(Integer.valueOf(r11));     // Catch: Throwable -> L14
        IWsChannelClient r13 = (IWsChannelClient) this.f7101j.get(Integer.valueOf(r11));     // Catch: Throwable -> L14
        boolean r14 = false;
        boolean r15 = true;
        if (r12 != null) goto L10;
    L16:
        if (r12 != null) goto L18;
        this.f7100i.put(Integer.valueOf(r11), r10);     // Catch: Throwable -> L14
        this.f7096e.c(this.f7100i);     // Catch: Throwable -> L14
    L12:
        r15 = false;
        r14 = true;
    L18:
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L14
        if (r14 == false) goto L21;
        t(r10);
        return;
    L21:
        if (r15 == false) goto L29;
        i(r10);
        return;
    L29:
        return;
    L10:
        if (r10.equals(r12) == false) goto L16;
        if (r13 == null) goto L12;
        r15 = false;
    L14:
        th = move-exception;
        throw th;
    }

    public final Map k(IWsApp r11) {
        HashMap r10 = new HashMap();
        r10.put(WsConstants.KEY_APP_KEY, r11.getAppKey());
        r10.put(WsConstants.KEY_FPID, Integer.valueOf(r11.getFPID()));
        r10.put(WsConstants.KEY_SDK_VERSION, 2);
        r10.put(WsConstants.KEY_PLATFORM, 0);
        r10.put("app_version", Integer.valueOf(r11.getAppVersion()));
        r10.put("aid", Integer.valueOf(r11.getAppId()));
        r10.put("device_id", r11.getDeviceId());
        r10.put(WsConstants.KEY_INSTALL_ID, r11.getInstallId());
        r10.put(WsConstants.KEY_CHANNEL_ID, Integer.valueOf(r11.getChannelId()));
        String r12 = r11.getExtra();
        if (r12 != null) goto L6;
        o(WsConstants.KEY_EXTRA);
        r12 = "";
    L6:
        if (com.bytedance.common.wschannel.b.d(this.f7094c).g() == false) goto L17;
        String[] r13 = r12.split("&");
        StringBuilder r14 = new StringBuilder();
        r14.append("is_background=");
        if (n() == false) goto L10;
        String r15 = AdReportParam.ClickPosType.SKIP;
    L11:
        r14.append(r15);
        String r16 = r14.toString();
        if (r13.length > 0) goto L14;
    L16:
        r12 = r16;
        goto L17
    L14:
        if (TextUtils.isEmpty(r13[0]) == true) goto L16;
        r12 = r12 + "&" + r16;
        goto L17
    L10:
        r15 = "1";
    L17:
        r10.put(WsConstants.KEY_EXTRA, r12);
        if (r11.getDeviceId() != null) goto L21;
        o("device_id");
    L21:
        if (r11.getInstallId() != null) goto L24;
        o("install_id");
    L24:
        if (e.b(r11.getAppKey()) == false) goto L26;
        o(WsConstants.KEY_APP_KEY);
    L26:
        return r10;
    }

    public final boolean m() {
        return this.f7099h.c();
    }

    public final boolean n() {
        return this.f7103l;
    }

    public final void o(String r10) {
        Bundle r11 = new Bundle();
        r11.putString("param_name", r10);
        i4.a.a(this.f7094c, "wschannel_param_null", r11);
    }

    @Override // com.bytedance.common.wschannel.server.WsChannelEnableObserver.OnWsChannelEnableChangedObserver
    public void onWsChannelEnableChange(boolean r10) {
        if (r10 == false) goto L4;
        s(this.f7096e.b());
        return;
    L4:
        r();
    }

    public void p(Runnable r10) {
        this.f7093b.post(r10);
    }

    public final void q(Collection r10) {
        if (com.bytedance.common.wschannel.b.d(this.f7094c).g() == true) goto L5;
        return;
    L5:
        byte[] r11 = g();
        Iterator r12 = r10.iterator();
    L7:
        if (r12.hasNext() == false) goto L13;
        ((IWsChannelClient) r12.next()).sendMessage(r11);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public final void r() {
        Object r10 = this.f7095d;     // Catch: Throwable -> L16
        monitor-enter(r10);     // Catch: Throwable -> L16
        Iterator r11 = this.f7101j.entrySet().iterator();     // Catch: Throwable -> L10
    L6:
        if (r11.hasNext() == false) goto L12;
        IWsChannelClient r12 = (IWsChannelClient) ((Map.Entry) r11.next()).getValue();     // Catch: Throwable -> L10
        if (r12 == null) goto L6;
        r12.destroy();     // Catch: Throwable -> L10
        goto L6
    L12:
        this.f7101j.clear();     // Catch: Throwable -> L10
        monitor-exit(r10);     // Catch: Throwable -> L10
        this.f7100i.clear();     // Catch: Throwable -> L16
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.printStackTrace();
    }

    public final void s(Map r10) {
        if (this.f7099h.c() == false) goto L12;
        if (r10 == null) goto L18;
        Iterator r11 = r10.values().iterator();
    L7:
        if (r11.hasNext() == false) goto L19;
        IWsApp r12 = (IWsApp) r11.next();
        if (r12 == null) goto L7;
        j(r12);
        goto L7
    L19:
        return;
    L18:
        return;
    }

    public final void t(IWsApp r10) {
        if (Logger.debug() == false) goto L5;
        Logger.d("WsChannelService", "tryOpenConnection");
    L5:
        Object r11 = this.f7095d;
        monitor-enter(r11);
        IWsChannelClient r12 = (IWsChannelClient) this.f7101j.get(Integer.valueOf(r10.getChannelId()));     // Catch: Throwable -> L10
        if (r12 != null) goto L12;
        r12 = a4.a.b(r10.getChannelId(), this.f7097f, this.f7093b);     // Catch: Throwable -> L10
        r12.init(this.f7094c, r12);     // Catch: Throwable -> L10
        this.f7101j.put(Integer.valueOf(r10.getChannelId()), r12);     // Catch: Throwable -> L10
    L12:
        monitor-exit(r11);     // Catch: Throwable -> L10
        if (r12.isConnected() == false) goto L38;
        SocketState r13 = (SocketState) this.f7102k.get(Integer.valueOf(r10.getChannelId()));
        Logger.d("WsChannelService", "state = " + r13);
        if (r13 == null) goto L39;
        this.f7097f.g(r13);     // Catch: Throwable -> L33
        return;
    L42:
        return;
    L39:
        return;
    L38:
    L22:
        th = move-exception;
        th.printStackTrace();
        return;
    L20:
        if (Logger.debug() == false) goto L24;
        Logger.d("WsChannelService", "尝试打开长连接,channelId = " + r10.getChannelId());     // Catch: Throwable -> L22
    L24:
        Map<String, Object> r14 = k(r10);     // Catch: Throwable -> L22
        if (r14 == null) goto L28;
        r12.openConnection(r14, r10.getConnectUrls());     // Catch: Throwable -> L22
        return;
    L28:
        throw new IllegalArgumentException("configMap is empty !!!");     // Catch: Throwable -> L22
    L10:
        th = move-exception;
        throw th;
    }
}
