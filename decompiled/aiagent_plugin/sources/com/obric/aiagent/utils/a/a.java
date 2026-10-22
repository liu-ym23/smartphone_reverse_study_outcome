package com.obric.aiagent.utils.a;

import android.app.Application;
import android.content.Context;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.autoaction.BuildConfig;
import com.obric.matrix.platform.sdk.ones.account.OAccount;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.g;
import d.h.a.m;
import d.h.b.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: ObricSystemInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final String TAG = "ObricSystemInfo";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f22293a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile String f22294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile String f22295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f22296d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f22297e;
    private static final d f = null;
    private static final e g = null;

    /* JADX INFO: renamed from: com.obric.aiagent.utils.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ObricSystemInfo.kt */
    @f(b = "ObricSystemInfo.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.utils.device.ObricSystemInfo$acquireSysDeviceId$1")
    static final class C0482a extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22298a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.a.b<String, x> f22299b;

        /* JADX INFO: renamed from: com.obric.aiagent.utils.a.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ObricSystemInfo.kt */
        public static final class C0483a implements com.obric.matrix.platform.sdk.ones.dataanalysis.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ d.h.a.b<String, x> f22300a;

            @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.a
            public void b(String r1) {
                o.e(r1, "installId");
            }

            C0483a(d.h.a.b<? super String, x> r3) {
                this.f22300a = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
            }

            @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.a
            public void a(String r3) {
                o.e(r3, "did");
                this.f22300a.invoke(r3);
                com.obric.matrix.platform.sdk.ones.dataanalysis.c.f33671a.a().b((com.obric.matrix.platform.sdk.ones.dataanalysis.a) ZeusTransformUtils.preCheckCast(this, com.obric.matrix.platform.sdk.ones.dataanalysis.a.class, "com.obric.aiagent.plugin"));
            }
        }

        C0482a(d.h.a.b<? super String, x> r3, d.c.d<? super C0482a> r4) {
            d.h.a.b<String, x> r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22299b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((C0482a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0482a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0482a(this.f22299b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            String r0 = "0";
            d.c.a.b.a();
            if (this.f22298a != 0) goto L31;
            d.o.a(r8);
            ILogDepend.Companion.i(a.TAG, "acquireSysDeviceId: " + a.c());
            boolean r9 = false;
            a.a(a.f22293a, (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L18
            String r4 = com.obric.matrix.platform.sdk.ones.dataanalysis.c.f33671a.a().c();     // Catch: Exception -> L18
            CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L18
            if (r5 != null) goto L8;
        L11:
            boolean r6 = true;
        L12:
            if (r6 == false) goto L14;
        L16:
            com.obric.matrix.platform.sdk.ones.dataanalysis.c.f33671a.a().a((com.obric.matrix.platform.sdk.ones.dataanalysis.a) ZeusTransformUtils.preCheckCast(new C0483a(this.f22299b), com.obric.matrix.platform.sdk.ones.dataanalysis.a.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L18
        L29:
            return x.f38692a;
        L14:
            if (o.a(r4, "0") == true) goto L16;
            this.f22299b.invoke(r4);     // Catch: Exception -> L18
            goto L29
        L8:
            if (d.o.o.d(r5) == true) goto L11;
            r6 = false;
        L18:
            e = move-exception;
            CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(a.d(), CharSequence.class, "com.obric.aiagent.plugin");
            if (r1 != null) goto L22;
        L23:
            r9 = true;
        L24:
            if (r9 == true) goto L27;
            r0 = a.d();
        L27:
            this.f22299b.invoke(r0);
            ILogDepend.Companion.e(a.TAG, "acquireSysDeviceId, backup=" + r0 + ": " + e);
            goto L29
        L22:
            if (r1.length() != 0) goto L24;
        L31:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: ObricSystemInfo.kt */
    @f(b = "ObricSystemInfo.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.utils.device.ObricSystemInfo$acquireSysUserId$1")
    static final class b extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22301a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.a.b<String, x> f22302b;

        /* JADX INFO: renamed from: com.obric.aiagent.utils.a.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ObricSystemInfo.kt */
        public static final class C0484a implements com.obric.matrix.platform.sdk.ones.account.a.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f22303a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ d.h.a.b<String, x> f22304b;

            @Override // com.obric.matrix.platform.sdk.ones.account.a.c
            public void a(int r1) {
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.a.c
            public void b() {
            }

            C0484a(String r3, d.h.a.b<? super String, x> r4) {
                d.h.a.b<String, x> r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
                this.f22303a = r3;
                this.f22304b = r5;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.a.c
            public void a() {
                if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(this.f22303a, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L5;
                return;
            L5:
                if (o.a(this.f22303a, "0") == true) goto L9;
                this.f22304b.invoke(this.f22303a);
                OAccount.f33600a.b((com.obric.matrix.platform.sdk.ones.account.a.c) ZeusTransformUtils.preCheckCast(this, com.obric.matrix.platform.sdk.ones.account.a.c.class, "com.obric.aiagent.plugin"));
                return;
            }
        }

        b(d.h.a.b<? super String, x> r3, d.c.d<? super b> r4) {
            d.h.a.b<String, x> r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22302b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f22302b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            String r0 = "0";
            d.c.a.b.a();
            if (this.f22301a != 0) goto L25;
            d.o.a(r8);
            ILogDepend.Companion.i(a.TAG, "acquireSysUserId: " + a.e());
            boolean r9 = false;
            a.b(a.f22293a, (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L12
            String r4 = OAccount.a(OAccount.f33600a, false, 1, null).b();     // Catch: Exception -> L12
            if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L8;
        L10:
            OAccount.f33600a.a((com.obric.matrix.platform.sdk.ones.account.a.c) ZeusTransformUtils.preCheckCast(new C0484a(r4, this.f22302b), com.obric.matrix.platform.sdk.ones.account.a.c.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L12
        L26:
        L23:
            return x.f38692a;
        L8:
            if (o.a(r4, "0") == true) goto L10;
            this.f22302b.invoke(r4);     // Catch: Exception -> L12
        L12:
            e = move-exception;
            CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(a.f(), CharSequence.class, "com.obric.aiagent.plugin");
            if (r1 != null) goto L16;
        L17:
            r9 = true;
        L18:
            if (r9 == true) goto L21;
            r0 = a.f();
        L21:
            this.f22302b.invoke(r0);
            ILogDepend.Companion.e(a.TAG, "acquireSysUserId, backup=" + r0 + ": " + e);
            goto L23
        L16:
            if (r1.length() != 0) goto L18;
        L25:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: ObricSystemInfo.kt */
    @f(b = "ObricSystemInfo.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.utils.device.ObricSystemInfo$init$1")
    static final class c extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22305a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Application f22306b;

        c(Application r3, d.c.d<? super c> r4) {
            Application r5 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22306b = r5;
            super(2, r6);
        }

        /* JADX INFO: renamed from: lambda$Mlq9BmAVv_64sFtRuBdTHJV4-Tk, reason: not valid java name */
        public static /* synthetic */ x m390lambda$Mlq9BmAVv_64sFtRuBdTHJV4Tk(String r0) {
            return b(r0);
        }

        /* JADX INFO: renamed from: lambda$SvpY6q-ni7lv_uE5MTxXQu6z6fQ, reason: not valid java name */
        public static /* synthetic */ x m391lambda$SvpY6qni7lv_uE5MTxXQu6z6fQ(String r0) {
            return a(r0);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f22306b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f22305a != 0) goto L12;
            d.o.a(r3);
            a.a(a.f22293a, this.f22306b);     // Catch: Exception -> L7
            a.b(a.f22293a, this.f22306b);     // Catch: Exception -> L7
            a.f22293a.a($$Lambda$a$c$SvpY6qni7lv_uE5MTxXQu6z6fQ.INSTANCE);     // Catch: Exception -> L7
            a.f22293a.b($$Lambda$a$c$Mlq9BmAVv_64sFtRuBdTHJV4Tk.INSTANCE);     // Catch: Exception -> L7
        L10:
            return x.f38692a;
        L7:
            e = move-exception;
            ILogDepend.Companion.e(a.TAG, "init Matrix&OAccount error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            goto L10
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        private static final x a(String r3) {
            ILogDepend.Companion.i(a.TAG, "acquireSysDeviceId: " + r3);
            a r0 = a.f22293a;
            a.a(r3);
            com.obric.aiagent.utils.a.f22291a.a().storeString("os_device_id", r3);
            return x.f38692a;
        }

        private static final x b(String r3) {
            ILogDepend.Companion.i(a.TAG, "acquireSysUserId: " + r3);
            a r0 = a.f22293a;
            a.b(r3);
            com.obric.aiagent.utils.a.f22291a.a().storeString("os_user_id", r3);
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: ObricSystemInfo.kt */
    public static final class d implements com.obric.matrix.platform.sdk.ones.account.a.a {
        d() {
        }
    }

    /* JADX INFO: compiled from: ObricSystemInfo.kt */
    public static final class e implements com.obric.matrix.platform.sdk.ones.account.a.d {
        e() {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.a.d
        public void a(String r2, String r3, Throwable r4) {
            o.e(r2, "tag");
            o.e(r3, "msg");
            ILogDepend.Companion.d(r2, r3 + r4);
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.a.d
        public void b(String r1, String r2, Throwable r3) {
            o.e(r1, "tag");
            o.e(r2, "msg");
            ILogDepend.Companion.e(r1, r2, r3);
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.a.d
        public void c(String r2, String r3, Throwable r4) {
            o.e(r2, "tag");
            o.e(r3, "msg");
            ILogDepend.Companion.i(r2, r3 + r4);
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.a.d
        public void d(String r1, String r2, Throwable r3) {
            o.e(r1, "tag");
            o.e(r2, "msg");
            ILogDepend.Companion.w(r1, r2, r3);
        }
    }

    private a() {
    }

    public static final /* synthetic */ void a(a r2, Application r3) {
        r2.c((Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(String r0) {
        f22294b = r0;
    }

    public static final /* synthetic */ void b(a r2, Application r3) {
        r2.b((Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void b(String r0) {
        f22295c = r0;
    }

    public static final /* synthetic */ boolean c() {
        return f22296d;
    }

    public static final /* synthetic */ String d() {
        return f22294b;
    }

    public static final /* synthetic */ boolean e() {
        return f22297e;
    }

    public static final /* synthetic */ String f() {
        return f22295c;
    }

    static {
        f22293a = new a();
        f22294b = "";
        f22295c = "";
        f = new d();
        g = new e();
    }

    public final void a(Application r8) {
        Application r7 = (Application) ZeusTransformUtils.wrapperContextForParams(r8, Application.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        String r9 = com.obric.aiagent.utils.a.f22291a.a().getString("os_device_id", "");
        o.c(r9, "getString(...)");
        f22294b = r9;
        String r10 = com.obric.aiagent.utils.a.f22291a.a().getString("os_user_id", "");
        o.c(r10, "getString(...)");
        f22295c = r10;
        ILogDepend.Companion.i(TAG, "init, sysDeviceId: " + f22294b + ", sysUserId: " + f22295c);
        i.a(an.a((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new c(r7, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void b(Application r5) {
        Application r4 = (Application) ZeusTransformUtils.wrapperContextForParams(r5, Application.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.i(TAG, "initOAccount: " + f22297e);
        if (f22297e == false) goto L5;
        return;
    L5:
        OAccount.f33600a.a(r4, (com.obric.matrix.platform.sdk.ones.account.a.d) ZeusTransformUtils.preCheckCast(g, com.obric.matrix.platform.sdk.ones.account.a.d.class, "com.obric.aiagent.plugin"), (com.obric.matrix.platform.sdk.ones.account.a.a) ZeusTransformUtils.preCheckCast(f, com.obric.matrix.platform.sdk.ones.account.a.a.class, "com.obric.aiagent.plugin"));
        f22297e = true;
    }

    private final void c(Application r4) {
        Application r3 = (Application) ZeusTransformUtils.wrapperContextForParams(r4, Application.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.i(TAG, "initMatrix: " + f22296d);
        if (f22296d == false) goto L5;
        return;
    L5:
        com.obric.matrix.platform.sdk.ones.dataanalysis.c.f33671a.a((Context) ZeusTransformUtils.preCheckCast(r3, Context.class, "com.obric.aiagent.plugin"), new com.obric.matrix.platform.sdk.ones.dataanalysis.b.a().a(BuildConfig.LIBRARY_PACKAGE_NAME).a(IAppContext.Companion.getVersionCode()).b(IAppContext.Companion.getVersionName()).a(false).a());
        f22296d = true;
    }

    public final String a() {
        return f22294b;
    }

    public final String b() {
        return f22295c;
    }

    public final void a(d.h.a.b<? super String, x> r8) {
        d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r7, "acquirer");
        i.a(an.a((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new C0482a(r7, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void b(d.h.a.b<? super String, x> r8) {
        d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r7, "acquirer");
        i.a(an.a((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new b(r7, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }
}
