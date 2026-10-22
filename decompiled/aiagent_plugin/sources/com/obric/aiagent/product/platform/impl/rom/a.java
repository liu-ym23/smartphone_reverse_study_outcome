package com.obric.aiagent.product.platform.impl.rom;

import android.content.Context;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.platform.api.rom.IRomInfo;
import com.obric.matrix.platform.sdk.ones.dataanalysis.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.c.g;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.o.k;
import d.x;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: PacificRomInfoImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements IRomInfo {
    private static final String TAG = "PacificRomInfoImpl";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0409a f18869a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ CommonRomInfoImpl f18870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile String f18871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f18872d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final kotlinx.coroutines.f.a f18873e;

    /* JADX INFO: renamed from: com.obric.aiagent.product.platform.impl.rom.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PacificRomInfoImpl.kt */
    public static final class C0409a {
        public /* synthetic */ C0409a(h r1) {
            this();
        }

        private C0409a() {
        }
    }

    /* JADX INFO: compiled from: PacificRomInfoImpl.kt */
    @f(b = "PacificRomInfoImpl.kt", c = {181}, d = "invokeSuspend", e = "com.obric.aiagent.product.platform.impl.rom.PacificRomInfoImpl$getOSDeviceIdAsyncInternal$1")
    static final class b extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18874a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f18875b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f18876c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f18877d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f18878e;
        final /* synthetic */ d.h.a.b<String, x> f;

        /* JADX INFO: renamed from: com.obric.aiagent.product.platform.impl.rom.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: PacificRomInfoImpl.kt */
        public static final class C0410a implements com.obric.matrix.platform.sdk.ones.dataanalysis.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ d.h.a.b<String, x> f18879a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ a f18880b;

            @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.a
            public void b(String r1) {
                o.e(r1, "installId");
            }

            C0410a(d.h.a.b<? super String, x> r3, a r4) {
                this.f18879a = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
                this.f18880b = r4;
            }

            @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.a
            public void a(String r3) {
                o.e(r3, "did");
                this.f18879a.invoke(r3);
                a.a(this.f18880b, r3);
                c.f33671a.a().b((com.obric.matrix.platform.sdk.ones.dataanalysis.a) ZeusTransformUtils.preCheckCast(this, com.obric.matrix.platform.sdk.ones.dataanalysis.a.class, "com.obric.aiagent.plugin"));
                ILogDepend.Companion.i(a.TAG, "getOSDeviceIdAsyncInternal listener: " + a.b(this.f18880b));
            }
        }

        b(a r3, d.h.a.b<? super String, x> r4, d<? super b> r5) {
            d.h.a.b<String, x> r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            this.f18878e = r3;
            this.f = r6;
            super(2, r7);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r3, d<?> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new b(this.f18878e, this.f, r5), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f18877d;
            boolean r3 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.h.a.b<String, x> r2 = (d.h.a.b) ZeusTransformUtils.preCheckCast(this.f18876c, d.h.a.b.class, "com.obric.aiagent.plugin");
            a r4 = (a) ZeusTransformUtils.preCheckCast(this.f18875b, a.class, "com.obric.aiagent.plugin");
            kotlinx.coroutines.f.a r10 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(this.f18874a, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
            d.o.a(r11);
        L43:
            String r12 = a.b(r4);     // Catch: Throwable -> L39
            if (r12 != null) goto L16;
        L23:
            ILogDepend.Companion.i(a.TAG, "getOSDeviceIdAsyncInternal: " + a.c(r4));     // Catch: Throwable -> L39
            a.d(r4);     // Catch: Throwable -> L34
            String r13 = c.f33671a.a().c();     // Catch: Throwable -> L34
            CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
            if (r8 != null) goto L27;
        L30:
            if (r3 == true) goto L32;
            r2.invoke(r13);     // Catch: Throwable -> L34
            a.a(r4, r13);     // Catch: Throwable -> L34
            ILogDepend.Companion.i(a.TAG, "getOSDeviceIdAsyncInternal cache: " + a.b(r4));     // Catch: Throwable -> L34
        L36:
            x r14 = x.f38692a;     // Catch: Throwable -> L39
            r10.b(null);
            return x.f38692a;
        L32:
            c.f33671a.a().a((com.obric.matrix.platform.sdk.ones.dataanalysis.a) ZeusTransformUtils.preCheckCast(new C0410a(r2, r4), com.obric.matrix.platform.sdk.ones.dataanalysis.a.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L34
            goto L36
        L27:
            if (d.o.o.d(r8) == true) goto L30;
            r3 = false;
        L34:
            th = move-exception;
            r2.invoke("");     // Catch: Throwable -> L39
            ILogDepend.Companion.e(a.TAG, "getOSDeviceIdAsyncInternal crash", th);     // Catch: Throwable -> L39
            goto L36
        L16:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L18;
            boolean r9 = true;
        L19:
            if (r9 == false) goto L23;
            r2.invoke(r12);     // Catch: Throwable -> L39
            ILogDepend.Companion.i(a.TAG, "getOSDeviceIdAsyncInternal cache: " + a.b(r4));     // Catch: Throwable -> L39
            x r15 = x.f38692a;     // Catch: Throwable -> L39
            r10.b(null);
            return r15;
        L18:
            r9 = false;
        L39:
            th = move-exception;
            r10.b(null);
            throw th;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r11);
            kotlinx.coroutines.f.a r16 = a.a(this.f18878e);
            r4 = this.f18878e;
            d.h.a.b<String, x> r5 = this.f;
            d<? super x> r6 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f18874a = r16;
            this.f18875b = r4;
            this.f18876c = r5;
            this.f18877d = 1;
            if (r16.a(null, r6) != r0) goto L11;
            return r0;
        L11:
            r10 = r16;
            r2 = r5;
            goto L43
        }
    }

    static {
        f18869a = new C0409a(null);
    }

    public static /* synthetic */ x lambda$irGe6rgqdrLFSz4A2OBUBk6xY6A(String r0) {
        return a(r0);
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getDeviceBrand() {
        return this.f18870b.getDeviceBrand();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getDeviceModel() {
        return this.f18870b.getDeviceModel();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public int getFwkApiVersion() {
        return this.f18870b.getFwkApiVersion();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public int getOSReleaseDate() {
        return this.f18870b.getOSReleaseDate();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getRomReleaseRegion() {
        return this.f18870b.getRomReleaseRegion();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public boolean isOautoModelPreinstalled(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        return this.f18870b.isOautoModelPreinstalled(r4);
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public boolean useAssistantApi() {
        return this.f18870b.useAssistantApi();
    }

    public a() {
        this.f18870b = new CommonRomInfoImpl();
        this.f18873e = kotlinx.coroutines.f.c.a(false, 1, null);
    }

    public static final /* synthetic */ kotlinx.coroutines.f.a a(a r0) {
        return r0.f18873e;
    }

    public static final /* synthetic */ void a(a r0, String r1) {
        r0.f18871c = r1;
    }

    public static final /* synthetic */ String b(a r0) {
        return r0.f18871c;
    }

    public static final /* synthetic */ boolean c(a r0) {
        return r0.f18872d;
    }

    public static final /* synthetic */ void d(a r0) {
        r0.a();
    }

    private static final x a(String r1) {
        o.e(r1, "it");
        return x.f38692a;
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public void tryInit() {
        a($$Lambda$a$irGe6rgqdrLFSz4A2OBUBk6xY6A.INSTANCE);
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getOSVersion() {
        return com.obric.aiagent.product.a.d.f18776a.a("ro.os.ota.version", "");
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getShortOSVersion() {
        String r4 = com.obric.aiagent.product.a.d.f18776a.a("ro.os.ota.version", "");
        String r0 = com.obric.aiagent.product.a.c.f18771a.c(r4);
        ILogDepend.Companion.i(TAG, "getShortOSVersion: fullVersion " + r4 + ", shortVersion " + r0);
        return r0;
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public boolean isUTRom() {
        String r6 = com.obric.aiagent.product.a.d.f18776a.a("ro.os.ota.version", "");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L30;
        List<String> r7 = new k("-").c((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"), 0);
        if (r7.isEmpty() == true) goto L18;
        ListIterator<String> r1 = r7.listIterator(r7.size());
    L11:
        if (r1.hasPrevious() == false) goto L18;
        if (((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r1.previous(), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L15;
        boolean r4 = true;
    L16:
        if (r4 == true) goto L11;
        List r8 = p.c((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin"), r1.nextIndex() + 1);
    L19:
        String[] r9 = (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.aiagent.plugin")).toArray(new String[0]), String[].class, "com.obric.aiagent.plugin");
        if (r9.length != 0) goto L22;
        boolean r2 = true;
    L24:
        if ((!r2) == false) goto L30;
        if (r9.length <= 1) goto L30;
        if (d.o.o.b(r9[1], "ut", false, 2, null) == false) goto L30;
        return true;
    L22:
        r2 = false;
        goto L24
    L15:
        r4 = false;
    L18:
        r8 = p.b();
    L30:
        return false;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getOSDeviceIdFromCache() {
        ILogDepend.Companion.i(TAG, "getOSDeviceIdFromCache cache: " + this.f18871c);
        return this.f18871c;
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public void getOSDeviceIdAsync(d.h.a.b<? super String, x> r3) {
        d.h.a.b<? super String, x> r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r4, "callback");
        a(r4);
    }

    private final void a(d.h.a.b<? super String, x> r9) {
        d.h.a.b r10 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.b.class, "com.obric.aiagent.plugin");
        i.a(an.a((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new b(this, r10, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void a() {
        ILogDepend.Companion.i(TAG, "initMatrix: " + this.f18872d);
        if (this.f18872d == false) goto L5;
        return;
    L5:
        c.f33671a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), new com.obric.matrix.platform.sdk.ones.dataanalysis.b.a().a(IAppContext.Companion.getPackageName()).a(IAppContext.Companion.getVersionCode()).b(IAppContext.Companion.getVersionName()).a(false).a());
        this.f18872d = true;
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getRomBuildType() {
        String r8 = com.obric.aiagent.product.a.d.f18776a.a("ro.os.ota.version", "");
        String r3 = "userroot";
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("userroot", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L6;
    L12:
        ILogDepend.Companion.i(TAG, "getRomBuildType: buildType " + r3);
        return r3;
    L6:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("userdebug", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L9;
        r3 = "userdebug";
        goto L12
    L9:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("user", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L11;
        r3 = "user";
        goto L12
    L11:
        r3 = SensitiveType.UNKNOWN;
        goto L12
    }
}
