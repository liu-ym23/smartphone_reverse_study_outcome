package com.obric.autogui.net.wschannel.a;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.common.wschannel.app.c;
import com.bytedance.common.wschannel.i;
import com.bytedance.common.wschannel.l;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.google.gson.Gson;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.device.AODeviceInfo;
import com.obric.autogui.common.api.platform.device.DeviceInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.q;
import d.h.b.o;
import d.o.d;
import d.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: WsChannelManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements c {
    private static final String TAG = "WsChannelManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f29245a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile i f29246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Context f29247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final List<com.obric.autogui.tools.api.net.wschannel.a> f29248d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f29249e;
    private static Handler f;
    private static Handler g;

    /* JADX INFO: renamed from: lambda$Fcro4PrtJZmPylmM1GDLmNV-ICs, reason: not valid java name */
    public static /* synthetic */ x m822lambda$Fcro4PrtJZmPylmM1GDLmNVICs(DeviceInfo r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$mQ-9AlfTWglluBAtiOTI-8nBKTI, reason: not valid java name */
    public static /* synthetic */ void m823lambda$mQ9AlfTWglluBAtiOTI8nBKTI(q r0, String r1) {
        a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$wd-6GXiP08ga8ow_jeZYNTi3bnU, reason: not valid java name */
    public static /* synthetic */ void m824lambda$wd6GXiP08ga8ow_jeZYNTi3bnU(long r0, q r2, String r3, WsChannelMsg r4, boolean r5) {
        a(r0, r2, r3, r4, r5);
    }

    private a() {
    }

    static {
        f29245a = new a();
        f29248d = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        HandlerThread r0 = new HandlerThread("WsChannelManager-SendMsg-Thread");
        r0.start();
        f = new Handler(r0.getLooper());
        HandlerThread r1 = new HandlerThread("WsChannelManager-ReceiveMsg-Thread");
        r1.start();
        g = new Handler(r1.getLooper());
    }

    public final void a(Application r3) {
        Application r2 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.aiagent.plugin");
        o.e(r2, "context");
        f29247c = (Context) ZeusTransformUtils.preCheckCast(r2, Context.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.d(TAG, "init, context:" + r2 + ", mContext:" + f29247c);
        PackageManager r4 = r2.getPackageManager();
        if (r4 == null) goto L7;
        PackageInfo r5 = r4.getPackageInfo(r2.getPackageName(), 0);
        if (r5 == null) goto L7;
        long r6 = r5.getLongVersionCode();
    L8:
        f29249e = r6;
        return;
    L7:
        r6 = 0;
        goto L8
    }

    public final void a() {
        Loog.INSTANCE.d(TAG, "connect() called with: context : " + f29247c + ", did : " + AODeviceInfo.INSTANCE.getDid());
        AODeviceInfo.INSTANCE.whenDeviceRegistered($$Lambda$a$Fcro4PrtJZmPylmM1GDLmNVICs.INSTANCE);
    }

    private static final x a(DeviceInfo r3) {
        DeviceInfo r4 = (DeviceInfo) ZeusTransformUtils.wrapperContextForParams(r3, DeviceInfo.class, "com.obric.aiagent.plugin");
        o.e(r4, "devInfo");
        Loog.INSTANCE.d(TAG, "onDeviceIdLoaded called with: did : " + r4.getDeviceId() + " in connect()");
        f29245a.a("whenDeviceInfoReady");
        return x.f38692a;
    }

    private final void a(String r8) {
        Loog.INSTANCE.d(TAG, "tryConnect, start, from: " + r8);
        i r9 = f29246b;
        boolean r0 = false;
        if (r9 != null) goto L5;
    L7:
        boolean r10 = false;
    L8:
        if (r10 == false) goto L11;
        Loog.INSTANCE.i(TAG, "tryConnect, ws is connect, no need to connect");
        return;
    L11:
        Context r11 = f29247c;
        if (r11 != null) goto L16;
        Loog.INSTANCE.e(TAG, "tryConnect, context is null");
        return;
    L16:
        if (com.bytedance.common.utility.i.b(r11) == true) goto L20;
        Loog.INSTANCE.w(TAG, "tryConnect, device is not connected to network");
        return;
    L20:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(AODeviceInfo.INSTANCE.getDid(), CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L22;
        r0 = true;
    L22:
        if (r0 == false) goto L25;
        Loog.INSTANCE.w(TAG, "tryConnect, deviceId is empty");
        return;
    L25:
        Map<String, String> r12 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        r12.put("ttnet_heartbeat_interval", String.valueOf(b.f29250a.g()));
        r12.put("ttnet_timeout_millis", String.valueOf(b.f29250a.f()));
        r12.put("max_reconnect_count", String.valueOf(b.f29250a.b()));
        r12.put("qos_level", "2");
        r12.put("use-olympus-account", "1");
        Map<String, String> r1 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Map<String, String> r3 = b.f29250a.k();
        if ((true ^ r3.isEmpty()) == false) goto L28;
        r1.putAll(r3);
    L28:
        Loog.INSTANCE.d(TAG, "tryConnect, did: " + AODeviceInfo.INSTANCE.getDid() + ", iid: " + AODeviceInfo.INSTANCE.getIid());
        com.bytedance.common.wschannel.a r13 = com.bytedance.common.wschannel.a.C0152a.a(b.f29250a.d()).a(b.f29250a.e()).b(b.f29250a.c()).a(b.f29250a.a()).b(AODeviceInfo.INSTANCE.getDid()).c(AODeviceInfo.INSTANCE.getIid()).c(Integer.parseInt("728048")).d((int) f29249e).a(r12).b(r1).a();
        Loog.INSTANCE.d(TAG, "tryConnect, channelInfo:\n" + new Gson().toJson(r13));
        if (f29246b != null) goto L31;
        Loog.INSTANCE.d(TAG, "WsChannelSdk2.registerChannel");
        Context r2 = f29247c;
        o.a(r2);
        f29246b = l.a(r2, r13, (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin"));
        return;
    L31:
        Loog.INSTANCE.d(TAG, "WsChannelSdk2.onParamChanged");
        i r7 = f29246b;
        if (r7 == null) goto L36;
        r7.a(r13);
        return;
    L36:
        return;
    L5:
        if (r9.c() != true) goto L7;
        r10 = true;
        goto L8
    }

    public final void b() {
        Loog.INSTANCE.d(TAG, "disconnect, start, mWsChannel: " + f29246b);
        i r2 = f29246b;
        if (r2 == null) goto L5;
        r2.b();
    L5:
        f29246b = null;
    }

    public final boolean c() {
        i r2 = f29246b;
        if (r2 == null) goto L8;
        if (r2.c() != true) goto L8;
        return true;
    L8:
        return false;
    }

    public final void a(com.obric.autogui.tools.api.net.wschannel.a r2) {
        com.obric.autogui.tools.api.net.wschannel.a r1 = (com.obric.autogui.tools.api.net.wschannel.a) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.autogui.tools.api.net.wschannel.a.class, "com.obric.aiagent.plugin");
        o.e(r1, "callback");
        List<com.obric.autogui.tools.api.net.wschannel.a> r3 = f29248d;
        monitor-enter(r3);
        r3.add(r1);     // Catch: Throwable -> L7
        monitor-exit(r3);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void b(com.obric.autogui.tools.api.net.wschannel.a r2) {
        com.obric.autogui.tools.api.net.wschannel.a r1 = (com.obric.autogui.tools.api.net.wschannel.a) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.autogui.tools.api.net.wschannel.a.class, "com.obric.aiagent.plugin");
        o.e(r1, "callback");
        List<com.obric.autogui.tools.api.net.wschannel.a> r3 = f29248d;
        monitor-enter(r3);
        r3.remove(r1);     // Catch: Throwable -> L7
        monitor-exit(r3);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void a(final String r3, q<? super Boolean, ? super String, ? super Exception, x> r4) {
        final q r2 = (q) ZeusTransformUtils.wrapperContextForParams(r4, q.class, "com.obric.aiagent.plugin");
        o.e(r3, "jsonMessage");
        Loog.INSTANCE.d(TAG, "sendMessage start, msg: " + r3);
        f.post(new $$Lambda$a$mQ9AlfTWglluBAtiOTI8nBKTI(r2, r3));
    }

    private static final void a(q r6, final String r7) {
        final q r8 = (q) ZeusTransformUtils.wrapperContextForParams(r6, q.class, "com.obric.aiagent.plugin");
        f29245a.a("sendMessage");
        boolean r0 = false;
        int r2 = 0;
    L4:
        if (f29245a.c() == true) goto L8;
        if (r2 >= 10) goto L8;
        Thread.sleep(300);
        r2 = r2 + 1;
    L8:
        i r3 = f29246b;
        if (r3 != null) goto L11;
    L13:
        if (r0 == false) goto L24;
        if (r8 == null) goto L28;
        r8.invoke(false, r7, new Exception("WsChannel not Connected"));
        return;
    L28:
        return;
    L24:
        final long r4 = b.f29250a.j();     // Catch: Exception -> L19
        i r1 = f29246b;     // Catch: Exception -> L19
        o.a(r1);     // Catch: Exception -> L19
        WsChannelMsg.a r5 = WsChannelMsg.a.a(r1.a()).a(r4).b(b.f29250a.h()).c(b.f29250a.i());     // Catch: Exception -> L19
        byte[] r9 = r7.getBytes(d.f38623b);     // Catch: Exception -> L19
        o.c(r9, "getBytes(...)");     // Catch: Exception -> L19
        WsChannelMsg r10 = r5.a(r9).a();     // Catch: Exception -> L19
        i r11 = f29246b;     // Catch: Exception -> L19
        o.a(r11);     // Catch: Exception -> L19
        r11.a(r10, new $$Lambda$a$wd6GXiP08ga8ow_jeZYNTi3bnU(r4, r8, r7));     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        Loog.INSTANCE.d(TAG, "sendMessage, exception: " + e);
        if (r8 == null) goto L29;
        r8.invoke(false, r7, e);
        return;
    L29:
        return;
    L11:
        if (r3.c() == true) goto L13;
        r0 = true;
        goto L13
    }

    private static final void a(long r3, q r5, String r6, WsChannelMsg r7, boolean r8) {
        q r9 = (q) ZeusTransformUtils.wrapperContextForParams(r5, q.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.d(TAG, "sendMessage, success: " + r8 + ", wsChannelMsg: " + r7);
        if (r8 == true) goto L5;
        StringBuilder r1 = new StringBuilder();
        a r2 = f29245a;
        o.a(r7);
        Exception r0 = new Exception(r1.append(r2.b(r7)).append(", logId:").append(r3).toString());
    L6:
        if (r9 == null) goto L9;
        r9.invoke(Boolean.valueOf(r8), r6, r0);
        return;
    L9:
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.bytedance.common.wschannel.app.c
    public void a(com.bytedance.common.wschannel.b.b r4, JSONObject r5) {
        Loog.INSTANCE.d(TAG, "onReceiveConnectEvent: " + r4 + ", " + r5);
        List<com.obric.autogui.tools.api.net.wschannel.a> r3 = f29248d;
        monitor-enter(r3);
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L19
    L6:
        if (r6.hasNext() == false) goto L16;
        com.obric.autogui.tools.api.net.wschannel.a r0 = (com.obric.autogui.tools.api.net.wschannel.a) ZeusTransformUtils.preCheckCast(r6.next(), com.obric.autogui.tools.api.net.wschannel.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        if (r4 == null) goto L10;
        com.bytedance.common.wschannel.b.c r1 = r4.f6774b;     // Catch: Throwable -> L19
    L12:
        if (r1 != com.bytedance.common.wschannel.b.c.f6780e) goto L14;
        boolean r2 = true;
    L15:
        r0.a(r2);     // Catch: Throwable -> L19
        goto L6
    L14:
        r2 = false;
        goto L15
    L10:
        r1 = null;
        goto L12
    L16:
        x r7 = x.f38692a;     // Catch: Throwable -> L19
        monitor-exit(r3);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.common.wschannel.app.c
    public void a(WsChannelMsg r5) {
        Loog.INSTANCE.d(TAG, "onReceiveMsg, wsChannelMsg：" + r5);
        if (r5 == null) goto L16;
        byte[] r4 = r5.getPayload();
        o.c(r4, "getPayload(...)");
        String r6 = new String(r4, d.f38623b);
        Loog.INSTANCE.d(TAG, "onReceiveMsg, msg payload: " + r6);
        List<com.obric.autogui.tools.api.net.wschannel.a> r7 = f29248d;
        monitor-enter(r7);
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L13
    L8:
        if (r0.hasNext() == false) goto L10;
        ((com.obric.autogui.tools.api.net.wschannel.a) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.autogui.tools.api.net.wschannel.a.class, "com.obric.aiagent.plugin")).a(r6);     // Catch: Throwable -> L13
        goto L8
    L10:
        x r8 = x.f38692a;     // Catch: Throwable -> L13
        monitor-exit(r7);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private final String b(WsChannelMsg r3) {
        return "WsChannelMsg{, channelId : " + r3.getChannelId() + ", logId=" + r3.getLogId() + ", service=" + r3.getService() + ", method=" + r3.getMethod() + ", msgHeaders=" + r3.getMsgHeaders() + '}';
    }
}
