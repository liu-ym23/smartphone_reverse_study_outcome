package com.obric.autogui.platforms.obric.d.a;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi;
import com.obric.autogui.common.api.platform.security.VirusCheckResult;
import com.obric.oui.texteffects.OProtocolTextEffectTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.g;
import d.h.a.m;
import d.h.b.o;
import d.x;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.dg;
import kotlinx.coroutines.i;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: compiled from: VirusChecker.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements IAutoActionPackagesApi.PackageChangeListener {
    private static final String TAG = "O-VirusChecker";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f30087a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final am f30088b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap<String, a> f30089c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ConcurrentHashMap<String, w<VirusCheckResult>> f30090d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f30091e;

    /* JADX INFO: compiled from: VirusChecker.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final VirusCheckResult f30092a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f30093b;

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, a.class) == true) goto L8;
            return false;
        L8:
            a r8 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f30092a, r8.f30092a) == true) goto L12;
            return false;
        L12:
            if (this.f30093b == r8.f30093b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f30092a.hashCode() * 31) + Long.hashCode(this.f30093b);
        }

        public String toString() {
            return "CacheEntry(result=" + this.f30092a + ", cachedAt=" + this.f30093b + ')';
        }

        public a(VirusCheckResult r2, long r3) {
            o.e(r2, "result");
            this.f30092a = r2;
            this.f30093b = r3;
        }

        public final VirusCheckResult a() {
            return this.f30092a;
        }

        public final long b() {
            return this.f30093b;
        }
    }

    /* JADX INFO: compiled from: VirusChecker.kt */
    @f(b = "VirusChecker.kt", c = {96}, d = "checkVirus", e = "com.obric.autogui.platforms.obric.security.virus.VirusChecker")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f30094a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f30095b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f30096c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f30097d;

        b(c r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30096c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f30095b = r3;
            this.f30097d |= Integer.MIN_VALUE;
            return this.f30096c.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.platforms.obric.d.a.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: VirusChecker.kt */
    @f(b = "VirusChecker.kt", c = {97}, d = "invokeSuspend", e = "com.obric.autogui.platforms.obric.security.virus.VirusChecker$checkVirus$result$1")
    static final class C0794c extends l implements m<am, d.c.d<? super VirusCheckResult>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30098a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ w<VirusCheckResult> f30099b;

        C0794c(w<VirusCheckResult> r3, d.c.d<? super C0794c> r4) {
            w<VirusCheckResult> r5 = (w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30099b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super VirusCheckResult> r4) {
            return ((C0794c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0794c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0794c(this.f30099b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super VirusCheckResult> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f30098a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            w<VirusCheckResult> r6 = this.f30099b;
            d.c.d<? super VirusCheckResult> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30098a = 1;
            r5 = r6.a(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: VirusChecker.kt */
    @f(b = "VirusChecker.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.platforms.obric.security.virus.VirusChecker$startOrJoinInFlight$2")
    static final class d extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30100a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f30101b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ w<VirusCheckResult> f30102c;

        d(String r3, w<VirusCheckResult> r4, d.c.d<? super d> r5) {
            w<VirusCheckResult> r6 = (w) ZeusTransformUtils.wrapperContextForParams(r4, w.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30101b = r3;
            this.f30102c = r6;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f30101b, this.f30102c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            d.c.a.b.a();
            if (this.f30100a != 0) goto L18;
            d.o.a(r10);
            Loog.INSTANCE.d(c.TAG, "startOrJoinInFlight: provider call start, pkg=" + this.f30101b);
            VirusCheckResult r11 = c.a(c.f30087a, this.f30101b);     // Catch: Exception -> L7
        L10:
            if (r11.isSuccess() == true) goto L12;
        L14:
            Loog.INSTANCE.w(c.TAG, "provider call failed or unknown, not cached: pkg=" + this.f30101b + ", resultCode=" + r11.getResultCode() + ", virusType=" + r11.getVirusType());
        L15:
            this.f30102c.a(r11);
            c.c().remove(this.f30101b, this.f30102c);
            Loog.INSTANCE.d(c.TAG, "startOrJoinInFlight: provider call end, pkg=" + this.f30101b);
            return x.f38692a;
        L12:
            if (o.a(r11.getVirusType(), SensitiveType.UNKNOWN) == true) goto L14;
            ((Map) ZeusTransformUtils.preCheckCast(c.b(), Map.class, "com.obric.aiagent.plugin")).put(this.f30101b, new a(r11, SystemClock.elapsedRealtime()));
            Loog.INSTANCE.d(c.TAG, "provider call success, cached: pkg=" + this.f30101b + ", isVirus=" + r11.isVirus());
        L7:
            e = move-exception;
            Loog.INSTANCE.e(c.TAG, "provider call failed: pkg=" + this.f30101b + ", err=" + e.getMessage());
            r11 = new VirusCheckResult(-1, null, null, false, "exception: " + e.getMessage());
            goto L10
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private c() {
    }

    public static final /* synthetic */ VirusCheckResult a(c r0, String r1) {
        return r0.d(r1);
    }

    public static final /* synthetic */ ConcurrentHashMap b() {
        return f30089c;
    }

    public static final /* synthetic */ ConcurrentHashMap c() {
        return f30090d;
    }

    static {
        f30087a = new c();
        f30088b = an.a(cx.a(null, 1, null).plus((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin")));
        f30089c = new ConcurrentHashMap();
        f30090d = new ConcurrentHashMap();
    }

    public final void a() {
        if (f30091e == true) goto L17;
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L6:
        if (f30091e == true) goto L11;
        IAutoActionPackagesApi r0 = AOPlatformTools.INSTANCE.packages();     // Catch: Throwable -> L14
        if (r0 == null) goto L10;
        r0.registerPackageChangeListener((IAutoActionPackagesApi.PackageChangeListener) ZeusTransformUtils.preCheckCast(f30087a, IAutoActionPackagesApi.PackageChangeListener.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L14
    L10:
        f30091e = true;     // Catch: Throwable -> L14
        Loog.INSTANCE.i(TAG, "Registered package change listener for cache invalidation.");     // Catch: Throwable -> L14
    L11:
        x r1 = x.f38692a;     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi.PackageChangeListener
    public void onPackageAdded(String r2) {
        o.e(r2, "packageName");
        a(r2);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi.PackageChangeListener
    public void onPackageRemoved(String r2) {
        o.e(r2, "packageName");
        a(r2);
    }

    @Override // com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi.PackageChangeListener
    public void onPackageChanged(String r2) {
        o.e(r2, "packageName");
        a(r2);
    }

    private final void a(String r3) {
        if (((a) ZeusTransformUtils.preCheckCast(f30089c.remove(r3), a.class, "com.obric.aiagent.plugin")) == null) goto L6;
        Loog.INSTANCE.i(TAG, "Virus cache invalidated via package change: " + r3);
        return;
    }

    public final Object a(String r11, d.c.d<? super Boolean> r12) {
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r13, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r13, b.class, "com.obric.aiagent.plugin");
        if ((r0.f30097d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f30097d -= Integer.MIN_VALUE;
    L8:
        Object r14 = r0.f30095b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f30097d;
        boolean r5 = false;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r11 = (String) ZeusTransformUtils.preCheckCast(r0.f30094a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r14);
    L25:
        VirusCheckResult r10 = (VirusCheckResult) ZeusTransformUtils.preCheckCast(r14, VirusCheckResult.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L28;
        Loog.INSTANCE.w(TAG, "checkVirus: timeout after 100ms, pkg=" + r11);
    L29:
        if (r10 == null) goto L32;
        r5 = r10.isVirus();
    L32:
        return d.c.b.a.b.a(r5);
    L28:
        Loog.INSTANCE.d(TAG, "checkVirus: got result in-time: pkg=" + r11 + ", isVirus=" + r10.isVirus());
        goto L29
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r14);
        a();
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L18;
        Loog.INSTANCE.w(TAG, "checkVirus: blank package name");
        return d.c.b.a.b.a(false);
    L18:
        VirusCheckResult r15 = c(r11);
        if (r15 == null) goto L22;
        Loog.INSTANCE.d(TAG, "checkVirus: cache hit: pkg=" + r11 + ", isVirus=" + r15.isVirus());
        return d.c.b.a.b.a(r15.isVirus());
    L22:
        Loog.INSTANCE.d(TAG, "checkVirus: cache miss, waiting for provider: pkg=" + r11);
        m r16 = (m) ZeusTransformUtils.preCheckCast(new C0794c(b(r11), null), m.class, "com.obric.aiagent.plugin");
        r0.f30094a = r11;
        r0.f30097d = 1;
        r14 = dg.b(100, r16, r0);
        if (r14 != r2) goto L25;
        return r2;
    L7:
        r0 = new b(this, r13);
        goto L8
    }

    private final w<VirusCheckResult> b(String r9) {
        ConcurrentHashMap<String, w<VirusCheckResult>> r8 = f30090d;
        w<VirusCheckResult> r0 = (w) ZeusTransformUtils.preCheckCast(r8.get(r9), w.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        Loog.INSTANCE.d(TAG, "startOrJoinInFlight: join existing, pkg=" + r9);
        return r0;
    L6:
        w<VirusCheckResult> r1 = y.a(null, 1, null);
        w<VirusCheckResult> r10 = (w) ZeusTransformUtils.preCheckCast(r8.putIfAbsent(r9, r1), w.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L10;
        Loog.INSTANCE.d(TAG, "startOrJoinInFlight: join existing (race), pkg=" + r9);
        return r10;
    L10:
        i.a(f30088b, null, null, (m) ZeusTransformUtils.preCheckCast(new d(r9, r1, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return r1;
    }

    private final VirusCheckResult c(String r7) {
        ConcurrentHashMap<String, a> r6 = f30089c;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r6.get(r7), a.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        return null;
    L6:
        if ((SystemClock.elapsedRealtime() - r0.b()) < 600000) goto L10;
        r6.remove(r7, r0);
        Loog.INSTANCE.d(TAG, "getCachedResult: cache expired, pkg=" + r7);
        return null;
    L10:
        return r0.a();
    }

    private final VirusCheckResult d(String r10) {
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L5;
        Loog.INSTANCE.d(TAG, "queryProvider: call provider, pkg=" + r10);
        com.obric.autogui.platforms.obric.d.a.a r9 = new com.obric.autogui.platforms.obric.d.a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).a(r10);
        if (r9.a() != 0) goto L21;
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r9.b(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L11;
    L14:
        boolean r12 = true;
    L15:
        if (r12 == true) goto L21;
        if (o.a(r9.b(), OProtocolTextEffectTextView.EffectNameNone) == true) goto L21;
        if (o.a(r9.b(), SensitiveType.UNKNOWN) == true) goto L21;
        boolean r7 = true;
    L23:
        return new VirusCheckResult(r9.a(), r9.b(), r9.c(), r7, r9.d());
    L11:
        if (d.o.o.d(r11) == true) goto L14;
        r12 = false;
    L21:
        r7 = false;
        goto L23
    L5:
        return new VirusCheckResult(-1, null, null, false, "blank package name");
    }
}
