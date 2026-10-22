package com.bytedance.ttnet;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.cronet.b.i;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.r;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.MalformedURLException;

/* JADX INFO: compiled from: HttpClient.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private static final String TAG = "HttpClient";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final C0257c f11391a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final a f11392b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static boolean f11393c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static volatile boolean f11394d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static String f11395e;
    private static volatile b f;

    /* JADX INFO: renamed from: com.bytedance.ttnet.c$1, reason: invalid class name */
    /* JADX INFO: compiled from: HttpClient.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: HttpClient.java */
    private static class a extends C0257c {
        private a() {
            super(null);
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.ttnet.c.C0257c
        public com.bytedance.frameworks.baselib.network.http.d a() {
            return d.a(i.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TTNetInit.getTTNetDepend().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")));
        }
    }

    /* JADX INFO: compiled from: HttpClient.java */
    public interface b {
        boolean g();
    }

    /* JADX INFO: renamed from: com.bytedance.ttnet.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: HttpClient.java */
    private static class C0257c {
        private C0257c() {
        }

        /* synthetic */ C0257c(AnonymousClass1 r1) {
            this();
        }

        public com.bytedance.frameworks.baselib.network.http.d a() {
            Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TTNetInit.getTTNetDepend().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            r r0 = r.a(r2);
            if (com.bytedance.frameworks.baselib.network.http.i.h.b(r2) == false) goto L5;
            r0.a(com.bytedance.ttnet.tnc.c.c());
        L5:
            return r0;
        }
    }

    /* JADX INFO: compiled from: HttpClient.java */
    private static class d implements com.bytedance.frameworks.baselib.network.http.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static volatile d f11396a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private i f11397b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private volatile int f11398c;

        public static d a(i r2) {
            if (f11396a != null) goto L15;
            monitor-enter(d.class);
        L11:
            th = move-exception;
            throw th;
        L7:
            if (f11396a != null) goto L9;
            f11396a = new d(r2);     // Catch: Throwable -> L11
        L9:
            monitor-exit(d.class);     // Catch: Throwable -> L11
        L15:
            return f11396a;
        }

        private d(i r1) {
            this.f11397b = r1;
        }

        private void a(Throwable r4) {
            if (ZeusTransformUtils.instanceOf(r4, MalformedURLException.class) == false) goto L6;
            return;
        L6:
            if (r4.getMessage() == null) goto L11;
            if (r4.getMessage().contains("MalformedURLException") == false) goto L11;
            return;
        L11:
            if (Logger.debug() == false) goto L14;
            Logger.d(c.TAG, "init mode is " + com.bytedance.frameworks.baselib.network.c.c().b());
            Logger.d(c.TAG, "exception times is " + this.f11398c);
        L14:
            if (com.bytedance.frameworks.baselib.network.c.c().b() == false) goto L27;
            int r0 = this.f11398c + 1;
            this.f11398c = r0;
            if (r0 > 3) goto L18;
            return;
        L18:
            if (com.bytedance.ttnet.a.c.d() == false) goto L20;
        L23:
            c.f11395e = com.bytedance.ttnet.utils.e.a(r4);
            if (c.f11395e.length() <= 256) goto L29;
            c.f11395e = c.f11395e.substring(0, 256);
            return;
        L29:
            return;
        L20:
            if (Logger.debug() == false) goto L22;
            Logger.d(c.TAG, "set sIsCronetException true");
        L22:
            c.f11393c = true;
            goto L23
        }

        @Override // com.bytedance.retrofit2.b.a
        public com.bytedance.retrofit2.b.e a(com.bytedance.retrofit2.b.c r4) {
            return this.f11397b.a(r4);
        L4:
            th = move-exception;
            a(th);
            TTNetInit.notifyColdStartFinish();
            if (r4.p() == null) goto L14;
            String r0 = com.bytedance.ttnet.utils.e.a(th);
            if (r0.length() <= 1024) goto L10;
            r0 = r0.substring(0, 1024);
        L10:
            r4.p().j = r0;
            r4.p().i = 10;
            if (Logger.debug() == false) goto L14;
            Logger.d(c.TAG, "new CronetSscall failed " + this.f11398c + " for " + r4.o());
            Logger.d(c.TAG, "new CronetSscall failed message " + r0);
        L14:
            return c.f11391a.a().a(r4);
        }
    }

    public static void a(b r2) {
        f = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
    }

    static {
        AnonymousClass1 r1 = null;
        f11391a = new C0257c(r1);
        f11392b = new a(r1);
    }

    public static void a(boolean r0) {
        f11394d = r0;
    }

    public static String a() {
        return f11395e;
    }

    public static boolean b() {
        if (f == null) goto L11;
        if (r.e() != 9) goto L11;
        if (Logger.debug() == false) goto L9;
        Logger.d(TAG, "reset null config fallback");
    L9:
        r.a(-1);
    L11:
        if (f != null) goto L20;
        if (com.bytedance.ttnet.a.c.e() == true) goto L20;
        if (Logger.debug() == false) goto L17;
        Logger.d(TAG, "check null config and fallback");
    L17:
        com.bytedance.ttnet.tnc.c.c().f();
        r.a(9);
        return false;
    L20:
        if (f == null) goto L25;
        if (f.g() == true) goto L25;
        return false;
    L25:
        if (f11393c == true) goto L27;
        return true;
    L27:
        if (f11394d == true) goto L32;
        r.a(7);
        r.b(f11395e);
        return false;
    L32:
        return true;
    }

    public static com.bytedance.frameworks.baselib.network.http.d a(String r0, boolean r1) {
        if (b() == false) goto L8;
        if (r1 == true) goto L8;
        return f11392b.a();
    L8:
        return f11391a.a();
    }
}
