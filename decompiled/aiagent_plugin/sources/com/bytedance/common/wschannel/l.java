package com.bytedance.common.wschannel;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: WsChannelSdk2.java */
/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.bytedance.common.wschannel.client.j f6975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<Integer, j> f6976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static AtomicBoolean f6977c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f6978d;

    /* JADX INFO: compiled from: WsChannelSdk2.java */
    private static class a implements LifeCycleMonitor.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Application f6979a;

        a(Application r3) {
            this.f6979a = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.aiagent.plugin");
        }

        @Override // com.bytedance.common.wschannel.LifeCycleMonitor.a
        public void a() {
            l.a(false);
            if (l.a().get() == false) goto L6;
            l.b().a(this.f6979a);
            return;
        }

        @Override // com.bytedance.common.wschannel.LifeCycleMonitor.a
        public void b() {
            l.a(true);
            if (l.a().get() == false) goto L6;
            l.b().b(this.f6979a);
            return;
        }
    }

    static /* synthetic */ AtomicBoolean a() {
        return f6977c;
    }

    static /* synthetic */ boolean a(boolean r0) {
        f6978d = r0;
        return r0;
    }

    static /* synthetic */ com.bytedance.common.wschannel.client.j b() {
        return f6975a;
    }

    static {
        f6975a = new com.bytedance.common.wschannel.client.k();
        f6976b = new ConcurrentHashMap();
        f6977c = new AtomicBoolean(false);
        f6978d = true;
    }

    public static i a(Context r9, com.bytedance.common.wschannel.a r10, com.bytedance.common.wschannel.app.c r11, com.bytedance.common.wschannel.app.d r12, com.bytedance.common.wschannel.app.b r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        com.bytedance.common.wschannel.app.c r6 = (com.bytedance.common.wschannel.app.c) ZeusTransformUtils.wrapperContextForParams(r11, com.bytedance.common.wschannel.app.c.class, "com.obric.aiagent.plugin");
        com.bytedance.common.wschannel.app.d r7 = (com.bytedance.common.wschannel.app.d) ZeusTransformUtils.wrapperContextForParams(r12, com.bytedance.common.wschannel.app.d.class, "com.obric.aiagent.plugin");
        com.bytedance.common.wschannel.app.b r8 = (com.bytedance.common.wschannel.app.b) ZeusTransformUtils.wrapperContextForParams(r13, com.bytedance.common.wschannel.app.b.class, "com.obric.aiagent.plugin");
        b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r14.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        j r15 = new j((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r14.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), f6975a, r10, r6, r7, r8);
        f6976b.put(Integer.valueOf(r10.f6756a), r15);
        r15.d();
        return r15;
    }

    public static i a(Context r2, com.bytedance.common.wschannel.a r3, com.bytedance.common.wschannel.app.c r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        com.bytedance.common.wschannel.app.c r6 = (com.bytedance.common.wschannel.app.c) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.common.wschannel.app.c.class, "com.obric.aiagent.plugin");
        return a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r3, r6, null, null);
    }

    private static void b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (f6977c.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        if (f6978d == false) goto L7;
        f6975a.b(r4);
    L8:
        c(r4);
        return;
    L7:
        f6975a.a(r4);
        goto L8
    }

    private static void c(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        IntentFilter r0 = new IntentFilter();     // Catch: Exception -> L5
        r0.addAction("android.net.conn.CONNECTIVITY_CHANGE");     // Catch: Exception -> L5
        ZeusTransformUtils.registerReceiver(r5, new com.bytedance.common.wschannel.server.m(r5, com.bytedance.common.wschannel.server.g.a(r5)), r0, "com.obric.aiagent.plugin");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    static SsWsApp a(com.bytedance.common.wschannel.a r10) {
        Map<String, String> r0 = r10.f6759d;
        ArrayList r1 = new ArrayList();
        Iterator<Map.Entry<String, String>> r2 = r0.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L4;
        r1.add(((String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.aiagent.plugin")) + "=" + Uri.encode((String) ZeusTransformUtils.preCheckCast(r3.getValue(), String.class, "com.obric.aiagent.plugin")));
        goto L4
    L9:
        int r4 = r10.h;
        if (r4 <= 0) goto L38;
        String r5 = r10.f6757b;
        if (com.bytedance.common.utility.j.a(r5) == true) goto L36;
        String r6 = r10.f6758c;
        if (com.bytedance.common.utility.j.a(r6) == true) goto L34;
        int r7 = r10.g;
        if (r7 <= 0) goto L32;
        String r8 = r10.i;
        if (com.bytedance.common.utility.j.a(r8) == true) goto L30;
        int r9 = r10.j;
        if (r9 <= 0) goto L28;
        int r11 = r10.f6756a;
        if (r11 <= 0) goto L26;
        return new SsWsApp.a().a(r4).a(r5).b(r6).d(r7).d(r8).a(r10.f).b(r9).c(0).e(r11).a(r10.f6760e).c(TextUtils.join("&", r1.toArray())).a(r10.k).b(r10.l).e(r10.m).f(r10.n.a()).b(r10.o).a();
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

    static j a(int r2) {
        return (j) ZeusTransformUtils.preCheckCast(f6976b.get(Integer.valueOf(r2)), j.class, "com.obric.aiagent.plugin");
    }

    static void b(int r1) {
        f6976b.remove(Integer.valueOf(r1));
    }

    static void a(Context r2) {
        Application r3 = (Application) ZeusTransformUtils.preCheckCast((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        LifeCycleMonitor r0 = new LifeCycleMonitor();
        r0.setAppStateChangedListener(new a(r3));
        r3.registerActivityLifecycleCallbacks(r0);
    }
}
