package com.obric.aiagent.product.platform.impl.rom;

import android.content.Context;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.platform.api.rom.IRomInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.c.g;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.f.c;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: PublicRomInfoImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements IRomInfo {
    private static final String TAG = "PublicRomInfoImpl";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18881a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ CommonRomInfoImpl f18882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile String f18883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlinx.coroutines.f.a f18884d;

    /* JADX INFO: compiled from: PublicRomInfoImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.product.platform.impl.rom.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PublicRomInfoImpl.kt */
    @f(b = "PublicRomInfoImpl.kt", c = {84}, d = "invokeSuspend", e = "com.obric.aiagent.product.platform.impl.rom.PublicRomInfoImpl$getOSDeviceIdAsync$1")
    static final class C0411b extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18885a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f18886b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f18887c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f18888d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f18889e;
        final /* synthetic */ d.h.a.b<String, x> f;

        /* JADX INFO: renamed from: com.obric.aiagent.product.platform.impl.rom.b$b$a */
        /* JADX INFO: compiled from: PublicRomInfoImpl.kt */
        public static final class a implements com.obric.matrixpro.sdk.deviceinfoclient.a.InterfaceC0914a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f18890a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ d.h.a.b<String, x> f18891b;

            a(b r3, d.h.a.b<? super String, x> r4) {
                d.h.a.b<String, x> r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
                this.f18890a = r3;
                this.f18891b = r5;
            }

            @Override // com.obric.matrixpro.sdk.deviceinfoclient.a.InterfaceC0914a
            public void a(String r3) {
                o.e(r3, "errorMsg");
                ILogDepend.Companion.i(b.TAG, "errorMsg: " + r3);
            }

            @Override // com.obric.matrixpro.sdk.deviceinfoclient.a.InterfaceC0914a
            public void b(String r3) {
                o.e(r3, "osDid");
                b.a(this.f18890a, r3);
                this.f18891b.invoke(r3);
                ILogDepend.Companion.i(b.TAG, "getOSDeviceIdAsync: " + b.b(this.f18890a));
            }
        }

        C0411b(b r3, d.h.a.b<? super String, x> r4, d<? super C0411b> r5) {
            d.h.a.b<String, x> r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            this.f18889e = r3;
            this.f = r6;
            super(2, r7);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((C0411b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), C0411b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r3, d<?> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C0411b(this.f18889e, this.f, r5), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f18888d;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            b r2 = (b) ZeusTransformUtils.preCheckCast(this.f18887c, b.class, "com.obric.aiagent.plugin");
            d.h.a.b<String, x> r3 = (d.h.a.b) ZeusTransformUtils.preCheckCast(this.f18886b, d.h.a.b.class, "com.obric.aiagent.plugin");
            kotlinx.coroutines.f.a r7 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(this.f18885a, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
            d.o.a(r8);
        L22:
            com.obric.matrixpro.sdk.deviceinfoclient.a.f33777a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), (com.obric.matrixpro.sdk.deviceinfoclient.a.InterfaceC0914a) ZeusTransformUtils.preCheckCast(new a(r2, r3), com.obric.matrixpro.sdk.deviceinfoclient.a.InterfaceC0914a.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L14
        L16:
            x r9 = x.f38692a;     // Catch: Throwable -> L19
            r7.b(null);
            return x.f38692a;
        L14:
            th = move-exception;
            r3.invoke("");     // Catch: Throwable -> L19
            ILogDepend.Companion.e(b.TAG, "catch getOSDeviceIdAsync crash", th);     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            r7.b(null);
            throw th;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r8);
            kotlinx.coroutines.f.a r10 = b.a(this.f18889e);
            r3 = this.f;
            b r5 = this.f18889e;
            d<? super x> r6 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f18885a = r10;
            this.f18886b = r3;
            this.f18887c = r5;
            this.f18888d = 1;
            if (r10.a(null, r6) != r0) goto L11;
            return r0;
        L11:
            r7 = r10;
            r2 = r5;
            goto L22
        }
    }

    static {
        f18881a = new a(null);
    }

    public static /* synthetic */ x lambda$yHX1Pvpj4rfcGouZaOECZintTOE(String r0) {
        return a(r0);
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getDeviceBrand() {
        return this.f18882b.getDeviceBrand();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getDeviceModel() {
        return this.f18882b.getDeviceModel();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public int getFwkApiVersion() {
        return this.f18882b.getFwkApiVersion();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public int getOSReleaseDate() {
        return this.f18882b.getOSReleaseDate();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getOSVersion() {
        return this.f18882b.getOSVersion();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getRomBuildType() {
        return this.f18882b.getRomBuildType();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getRomReleaseRegion() {
        return this.f18882b.getRomReleaseRegion();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getShortOSVersion() {
        return this.f18882b.getShortOSVersion();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public boolean isOautoModelPreinstalled(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        return this.f18882b.isOautoModelPreinstalled(r4);
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public boolean isUTRom() {
        return this.f18882b.isUTRom();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public boolean useAssistantApi() {
        return this.f18882b.useAssistantApi();
    }

    public b() {
        this.f18882b = new CommonRomInfoImpl();
        this.f18884d = c.a(false, 1, null);
    }

    public static final /* synthetic */ kotlinx.coroutines.f.a a(b r0) {
        return r0.f18884d;
    }

    public static final /* synthetic */ void a(b r0, String r1) {
        r0.f18883c = r1;
    }

    public static final /* synthetic */ String b(b r0) {
        return r0.f18883c;
    }

    private static final x a(String r1) {
        o.e(r1, "it");
        return x.f38692a;
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public void tryInit() {
        getOSDeviceIdAsync($$Lambda$b$yHX1Pvpj4rfcGouZaOECZintTOE.INSTANCE);
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getOSDeviceIdFromCache() {
        ILogDepend.Companion.i(TAG, "getOSDeviceIdFromCache: " + this.f18883c);
        return this.f18883c;
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public void getOSDeviceIdAsync(d.h.a.b<? super String, x> r9) {
        d.h.a.b r10 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r10, "callback");
        i.a(an.a((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new C0411b(this, r10, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }
}
