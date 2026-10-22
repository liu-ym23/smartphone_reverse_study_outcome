package com.bytedance.common.wschannel;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import com.bytedance.common.wschannel.client.WsChannelMultiProcessImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: WsChannelSdk.java */
/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f6968a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static com.bytedance.common.wschannel.client.j f6969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f6970c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Application f6971d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static a f6972e;
    private static e f;
    private static Map<Integer, com.bytedance.common.wschannel.a> g;
    private static Map<Integer, com.bytedance.common.wschannel.c.a> h;
    private static String i;
    private static b j;
    private static boolean k;
    private static boolean l;

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.k$1, reason: invalid class name */
    /* JADX INFO: compiled from: WsChannelSdk.java */
    static class AnonymousClass1 implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (k.b() == false) goto L5;
            k.d().b((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(k.c(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"));
            return;
        L5:
            k.d().a((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(k.c(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: WsChannelSdk.java */
    private static class a implements LifeCycleMonitor.a {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.common.wschannel.LifeCycleMonitor.a
        public void a() {
            k.a(false);
            if (k.e() != null) goto L5;
        L6:
            k.d().a((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(k.c(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"));
            return;
        L5:
            if (b.a(k.e()) == true) goto L6;
        }

        @Override // com.bytedance.common.wschannel.LifeCycleMonitor.a
        public void b() {
            k.a(true);
            if (k.e() != null) goto L5;
        L6:
            k.d().b((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(k.c(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"));
            return;
        L5:
            if (b.a(k.e()) == true) goto L6;
        }
    }

    /* JADX INFO: compiled from: WsChannelSdk.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f6973a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Map<Integer, com.bytedance.common.wschannel.a> f6974b;

        private b() {
            this.f6973a = false;
            this.f6974b = new ConcurrentHashMap();
        }

        /* synthetic */ b(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ boolean a(b r0) {
            return r0.f6973a;
        }

        static /* synthetic */ boolean a(b r0, boolean r1) {
            r0.f6973a = r1;
            return r1;
        }
    }

    static /* synthetic */ boolean a(boolean r0) {
        l = r0;
        return r0;
    }

    static /* synthetic */ boolean b() {
        return l;
    }

    static /* synthetic */ Application c() {
        return f6971d;
    }

    static /* synthetic */ com.bytedance.common.wschannel.client.j d() {
        return f6969b;
    }

    static /* synthetic */ b e() {
        return j;
    }

    static {
        f6968a = new Object();
        f6969b = new WsChannelMultiProcessImpl();
        f6972e = new a(null);
        f = null;
        g = new ConcurrentHashMap();
        h = new ConcurrentHashMap();
    }

    public static Context getContext() {
        return f6971d;
    }

    public static void a(Application r3, com.bytedance.common.wschannel.app.c r4) {
        a((Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.aiagent.plugin"), (com.bytedance.common.wschannel.app.c) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.common.wschannel.app.c.class, "com.obric.aiagent.plugin"), false, true, null);
    }

    public static e a() {
        return f;
    }

    public static <T extends com.bytedance.common.wschannel.c.a.b> com.bytedance.common.wschannel.c.a<T> a(int r2) {
        return (com.bytedance.common.wschannel.c.a) ZeusTransformUtils.preCheckCast(h.get(Integer.valueOf(r2)), com.bytedance.common.wschannel.c.a.class, "com.obric.aiagent.plugin");
    }

    private static void a(n r9) {
        if (f6970c == false) goto L5;
        return;
    L5:
        Application r0 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.a(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        com.bytedance.common.wschannel.app.c r1 = r9.b();
        boolean r2 = r9.e();
        boolean r3 = r9.d();
        com.bytedance.common.wschannel.app.a r4 = r9.f7004a;
        boolean r5 = r9.c();
        f6970c = true;
        f6971d = r0;
        k = r2;
        String r7 = com.bytedance.common.wschannel.e.c.b(r0);
        i = r7;
        boolean r8 = com.bytedance.common.wschannel.e.c.a(r0, r7);
        if (r3 == false) goto L9;
        if (r8 == false) goto L9;
        b r6 = new b(null);
        j = r6;
        b.a(r6, false);
    L9:
        if (r8 == false) goto L18;
        if (r2 == false) goto L12;
        LifeCycleMonitor r10 = new LifeCycleMonitor();
        r10.setAppStateChangedListener(f6972e);
        r0.registerActivityLifecycleCallbacks(r10);
    L12:
        WsConstants.setOnMessageReceiveListener(r1);
        WsConstants.setOptLogic(r9.f());
        WsConstants.setBindWsChannelServiceListener(r4);
        if (r0 == null) goto L21;
        m r11 = m.a(r0);
        if (r11 == null) goto L21;
        r11.a(r5);
    L21:
        if (j != null) goto L24;
        f6969b.a(f6971d, r8, true);
        return;
    L24:
        return;
    L18:
        if (com.bytedance.common.wschannel.e.c.b(i) == false) goto L21;
        f();
        goto L21
    }

    private static void a(Application r2, com.bytedance.common.wschannel.app.c r3, boolean r4, boolean r5, com.bytedance.common.wschannel.app.a r6) {
        Application r7 = (Application) ZeusTransformUtils.wrapperContextForParams(r2, Application.class, "com.obric.aiagent.plugin");
        com.bytedance.common.wschannel.app.c r8 = (com.bytedance.common.wschannel.app.c) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.common.wschannel.app.c.class, "com.obric.aiagent.plugin");
        com.bytedance.common.wschannel.app.a r9 = (com.bytedance.common.wschannel.app.a) ZeusTransformUtils.wrapperContextForParams(r6, com.bytedance.common.wschannel.app.a.class, "com.obric.aiagent.plugin");
        a(new n.a().a(r7).a(r8).a(r4).b(r5).c(false).a(r9).a());
    }

    private static void f() {
        IntentFilter r0 = new IntentFilter();     // Catch: Exception -> L4
        r0.addAction("android.net.conn.CONNECTIVITY_CHANGE");     // Catch: Exception -> L4
        Application r1 = f6971d;     // Catch: Exception -> L4
        Application r3 = f6971d;     // Catch: Exception -> L4
        ZeusTransformUtils.registerReceiver(r1, new com.bytedance.common.wschannel.server.m(r3, com.bytedance.common.wschannel.server.j.a(r3)), r0, "com.obric.aiagent.plugin");     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
