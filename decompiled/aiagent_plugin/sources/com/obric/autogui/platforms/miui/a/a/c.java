package com.obric.autogui.platforms.miui.a.a;

import android.os.SystemClock;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi;
import com.obric.oui.lisitem.OCardListItem;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.g;
import d.h.a.m;
import d.h.b.o;
import d.k;
import d.x;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.dg;
import kotlinx.coroutines.i;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: compiled from: MiuiVirusChecker.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements IAutoActionPackagesApi.PackageChangeListener {
    private static final String TAG = "GR-VirusChecker";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f30002a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final am f30003b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap<String, a> f30004c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ConcurrentHashMap<String, w<com.obric.autogui.platforms.miui.a.a.a>> f30005d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final AtomicLong f30006e = null;
    private static volatile boolean f;

    /* JADX INFO: compiled from: MiuiVirusChecker.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.autogui.platforms.miui.a.a.a f30007a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f30008b;

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, a.class) == true) goto L8;
            return false;
        L8:
            a r8 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f30007a, r8.f30007a) == true) goto L12;
            return false;
        L12:
            if (this.f30008b == r8.f30008b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f30007a.hashCode() * 31) + Long.hashCode(this.f30008b);
        }

        public String toString() {
            return "CacheEntry(outcome=" + this.f30007a + ", cachedAt=" + this.f30008b + ')';
        }

        public a(com.obric.autogui.platforms.miui.a.a.a r2, long r3) {
            o.e(r2, "outcome");
            this.f30007a = r2;
            this.f30008b = r3;
        }

        public final com.obric.autogui.platforms.miui.a.a.a a() {
            return this.f30007a;
        }

        public final long b() {
            return this.f30008b;
        }
    }

    /* JADX INFO: compiled from: MiuiVirusChecker.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final w<com.obric.autogui.platforms.miui.a.a.a> f30009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f30010b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f30009a, r6.f30009a) == true) goto L12;
            return false;
        L12:
            if (this.f30010b == r6.f30010b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f30009a.hashCode() * 31) + Boolean.hashCode(this.f30010b);
        }

        public String toString() {
            return "InFlightHandle(deferred=" + this.f30009a + ", isNewRequest=" + this.f30010b + ')';
        }

        public b(w<com.obric.autogui.platforms.miui.a.a.a> r3, boolean r4) {
            w<com.obric.autogui.platforms.miui.a.a.a> r5 = (w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.aiagent.plugin");
            o.e(r5, "deferred");
            this.f30009a = r5;
            this.f30010b = r4;
        }

        public final w<com.obric.autogui.platforms.miui.a.a.a> a() {
            return this.f30009a;
        }

        public final boolean b() {
            return this.f30010b;
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.platforms.miui.a.a.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MiuiVirusChecker.kt */
    @f(b = "MiuiVirusChecker.kt", c = {125}, d = "checkVirus", e = "com.obric.autogui.platforms.miui.security.virus.MiuiVirusChecker")
    static final class C0786c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f30011a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f30012b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f30013c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f30014d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f30015e;
        final /* synthetic */ c f;
        int g;

        C0786c(c r3, d.c.d<? super C0786c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f30015e = r3;
            this.g |= Integer.MIN_VALUE;
            return this.f.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: MiuiVirusChecker.kt */
    @f(b = "MiuiVirusChecker.kt", c = {126}, d = "invokeSuspend", e = "com.obric.autogui.platforms.miui.security.virus.MiuiVirusChecker$checkVirus$outcome$1")
    static final class d extends l implements m<am, d.c.d<? super com.obric.autogui.platforms.miui.a.a.a>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30016a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f30017b;

        d(b r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30017b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super com.obric.autogui.platforms.miui.a.a.a> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f30017b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super com.obric.autogui.platforms.miui.a.a.a> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f30016a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            w<com.obric.autogui.platforms.miui.a.a.a> r6 = this.f30017b.a();
            d.c.d<? super com.obric.autogui.platforms.miui.a.a.a> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30016a = 1;
            r5 = r6.a(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: MiuiVirusChecker.kt */
    @f(b = "MiuiVirusChecker.kt", c = {OCardListItem.DEFAULT_TAIL_DETAIL_MAX_WIDTH_DP}, d = "invokeSuspend", e = "com.obric.autogui.platforms.miui.security.virus.MiuiVirusChecker$startOrJoinInFlight$2")
    static final class e extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f30018a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f30019b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f30020c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f30021d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ w<com.obric.autogui.platforms.miui.a.a.a> f30022e;

        e(String r3, long r4, w<com.obric.autogui.platforms.miui.a.a.a> r6, d.c.d<? super e> r7) {
            w<com.obric.autogui.platforms.miui.a.a.a> r8 = (w) ZeusTransformUtils.wrapperContextForParams(r6, w.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30020c = r3;
            this.f30021d = r4;
            this.f30022e = r8;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f30020c, this.f30021d, this.f30022e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r14) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f30019b;
            if (r1 == 0) goto L12;
            if (r1 != 1) goto L11;
            long r2 = this.f30018a;
            d.o.a(r14);     // Catch: Throwable -> L8
        L17:
            com.obric.autogui.platforms.miui.a.a.a r15 = (com.obric.autogui.platforms.miui.a.a.a) ZeusTransformUtils.preCheckCast(r14, com.obric.autogui.platforms.miui.a.a.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        L22:
            long r5 = SystemClock.elapsedRealtime() - r2;
            if (r15.a() == false) goto L25;
            Loog.INSTANCE.w(c.TAG, "scan finished: VIRUS: reqId=" + this.f30021d + ", pkg=" + this.f30020c + ", outcome=" + c.a(c.f30002a, r15) + ", cacheable=" + r15.b() + ", cost=" + r5 + "ms");
        L27:
            if (r15.b() == false) goto L30;
            ((Map) ZeusTransformUtils.preCheckCast(c.b(), Map.class, "com.obric.aiagent.plugin")).put(this.f30020c, new a(r15, SystemClock.elapsedRealtime()));
            Loog.INSTANCE.i(c.TAG, "scan finished: cached: reqId=" + this.f30021d + ", pkg=" + this.f30020c + ", outcome=" + c.a(c.f30002a, r15) + ", isVirus=" + r15.a() + ", cacheTtlMs=1800000");
        L36:
            this.f30022e.a(r15);
            c.c().remove(this.f30020c, this.f30022e);
            Loog.INSTANCE.d(c.TAG, "checkVirus: in-flight removed: reqId=" + this.f30021d + ", pkg=" + this.f30020c);
            return x.f38692a;
        L30:
            if (ZeusTransformUtils.instanceOf(r15, com.obric.autogui.platforms.miui.a.a.a.c.class) == false) goto L33;
            Loog.INSTANCE.w(c.TAG, "scan finished: NOT cached: reqId=" + this.f30021d + ", pkg=" + this.f30020c + ", outcome=FinishedNoItem, code=" + ((com.obric.autogui.platforms.miui.a.a.a.c) ZeusTransformUtils.preCheckCast(r15, com.obric.autogui.platforms.miui.a.a.a.c.class, "com.obric.aiagent.plugin")).c() + ", msg=" + ((com.obric.autogui.platforms.miui.a.a.a.c) ZeusTransformUtils.preCheckCast(r15, com.obric.autogui.platforms.miui.a.a.a.c.class, "com.obric.aiagent.plugin")).d());
            goto L36
        L33:
            if (ZeusTransformUtils.instanceOf(r15, com.obric.autogui.platforms.miui.a.a.a.b.class) == false) goto L35;
            Loog.INSTANCE.w(c.TAG, "scan finished: NOT cached: reqId=" + this.f30021d + ", pkg=" + this.f30020c + ", outcome=Error, msg=" + ((com.obric.autogui.platforms.miui.a.a.a.b) ZeusTransformUtils.preCheckCast(r15, com.obric.autogui.platforms.miui.a.a.a.b.class, "com.obric.aiagent.plugin")).c());
            goto L36
        L35:
            Loog.INSTANCE.w(c.TAG, "scan finished: NOT cached: reqId=" + this.f30021d + ", pkg=" + this.f30020c + ", outcome=" + c.a(c.f30002a, r15));
            goto L36
        L25:
            Loog.INSTANCE.i(c.TAG, "scan finished: not virus: reqId=" + this.f30021d + ", pkg=" + this.f30020c + ", outcome=" + c.a(c.f30002a, r15) + ", cacheable=" + r15.b() + ", cost=" + r5 + "ms");
        L8:
            th = th;
        L21:
            Loog.INSTANCE.e(c.TAG, "provider call failed: pkg=" + this.f30020c + ", err=" + th, th);
            r15 = (com.obric.autogui.platforms.miui.a.a.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.platforms.miui.a.a.a.b(this.f30020c, "exception: " + th.getMessage()), com.obric.autogui.platforms.miui.a.a.a.class, "com.obric.aiagent.plugin");
            goto L22
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            d.o.a(r14);
            long r6 = SystemClock.elapsedRealtime();
            com.obric.autogui.platforms.miui.a.a.d r16 = com.obric.autogui.platforms.miui.a.a.d.f30023a;     // Catch: Throwable -> L19
            String r3 = this.f30020c;     // Catch: Throwable -> L19
            d.c.d<? super com.obric.autogui.platforms.miui.a.a.a> r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
            this.f30018a = r6;     // Catch: Throwable -> L19
            this.f30019b = 1;     // Catch: Throwable -> L19
            r14 = r16.a(r3, r7);     // Catch: Throwable -> L19
            if (r14 != r0) goto L16;
            return r0;
        L16:
            r2 = r6;
        L19:
            th = th;
            r2 = r6;
            goto L21
        }
    }

    private c() {
    }

    public static final /* synthetic */ String a(c r0, com.obric.autogui.platforms.miui.a.a.a r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ ConcurrentHashMap b() {
        return f30004c;
    }

    public static final /* synthetic */ ConcurrentHashMap c() {
        return f30005d;
    }

    static {
        f30002a = new c();
        f30003b = an.a(cx.a(null, 1, null).plus((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin")));
        f30004c = new ConcurrentHashMap();
        f30005d = new ConcurrentHashMap();
        f30006e = new AtomicLong(0);
    }

    private final String a(com.obric.autogui.platforms.miui.a.a.a r3) {
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autogui.platforms.miui.a.a.a.C0784a.class) == false) goto L6;
        return "Done(" + ((com.obric.autogui.platforms.miui.a.a.a.C0784a) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.platforms.miui.a.a.a.C0784a.class, "com.obric.aiagent.plugin")).c() + ')';
    L6:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autogui.platforms.miui.a.a.a.c.class) == false) goto L9;
        return "FinishedNoItem";
    L9:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autogui.platforms.miui.a.a.a.d.class) == false) goto L12;
        return "NotSupported";
    L12:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autogui.platforms.miui.a.a.a.e.class) == false) goto L15;
        return "Timeout";
    L15:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autogui.platforms.miui.a.a.a.b.class) == false) goto L19;
        return "Error";
    L19:
        throw new k();
    }

    public final void a() {
        if (f == true) goto L17;
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L6:
        if (f == true) goto L11;
        IAutoActionPackagesApi r0 = AOPlatformTools.INSTANCE.packages();     // Catch: Throwable -> L14
        if (r0 == null) goto L10;
        r0.registerPackageChangeListener((IAutoActionPackagesApi.PackageChangeListener) ZeusTransformUtils.preCheckCast(f30002a, IAutoActionPackagesApi.PackageChangeListener.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L14
    L10:
        f = true;     // Catch: Throwable -> L14
        Loog.INSTANCE.i(TAG, "Registered package change listener for cache invalidation");     // Catch: Throwable -> L14
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

    private final void a(String r6) {
        a r0 = (a) ZeusTransformUtils.preCheckCast(f30004c.remove(r6), a.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        Loog.INSTANCE.i(TAG, "Virus cache invalidated via package change: pkg=" + r6 + ", prevOutcome=" + a(r0.a()) + ", prevIsVirus=" + r0.a().a());
        return;
    L5:
        Loog.INSTANCE.d(TAG, "Virus cache invalidation observed via package change: pkg=" + r6 + " (no cache entry)");
    }

    public final Object a(String r20, d.c.d<? super Boolean> r21) {
        c r0 = this;
        String r1 = r20;
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r21, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, C0786c.class) == false) goto L7;
        C0786c r4 = (C0786c) ZeusTransformUtils.preCheckCast(r2, C0786c.class, "com.obric.aiagent.plugin");
        if ((r4.g & Integer.MIN_VALUE) == 0) goto L7;
        r4.g -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.f30015e;
        Object r5 = d.c.a.b.a();
        int r6 = r4.g;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        long r7 = r4.f30014d;
        long r8 = r4.f30013c;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r4.f30012b, String.class, "com.obric.aiagent.plugin");
        c r10 = (c) ZeusTransformUtils.preCheckCast(r4.f30011a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
        String r16 = ", outcome=";
        r0 = r10;
        r1 = r9;
        long r11 = r7;
    L30:
        com.obric.autogui.platforms.miui.a.a.a r12 = (com.obric.autogui.platforms.miui.a.a.a) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.platforms.miui.a.a.a.class, "com.obric.aiagent.plugin");
        long r13 = SystemClock.elapsedRealtime() - r11;
        if (r12 != null) goto L35;
        Loog.INSTANCE.w(TAG, "checkVirus: sync wait timeout after 500ms: reqId=" + r8 + ", pkg=" + r1 + ", stillInFlight=" + f30005d.containsKey(r1) + ", cost=" + r13 + "ms");
        return d.c.b.a.b.a(false);
    L35:
        if (r12.a() == false) goto L37;
        Loog.INSTANCE.w(TAG, "checkVirus: VIRUS confirmed: reqId=" + r8 + ", pkg=" + r1 + r16 + r0.a(r12) + ", cost=" + r13 + "ms");
    L39:
        return d.c.b.a.b.a(r12.a());
    L37:
        Loog.INSTANCE.i(TAG, new StringBuilder().append("checkVirus: not virus: reqId=").append(r8).append(", pkg=").append(r1).append(r16).append(r0.a(r12)).append(", cost=").append(r13).append("ms").toString());
        goto L39
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r3);
        a();
        long r14 = f30006e.incrementAndGet();
        r11 = SystemClock.elapsedRealtime();
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L18;
        Loog.INSTANCE.w(TAG, "checkVirus: blank package name, reqId=" + r14);
        return d.c.b.a.b.a(false);
    L18:
        com.obric.autogui.platforms.miui.a.a.a r15 = b(r20);
        if (r15 == null) goto L22;
        Loog.INSTANCE.i(TAG, "checkVirus: cache hit: reqId=" + r14 + ", pkg=" + r1 + ", outcome=" + r0.a(r15) + ", isVirus=" + r15.a() + ", cacheTtlMs=1800000, cost=" + (SystemClock.elapsedRealtime() - r11) + "ms");
        return d.c.b.a.b.a(r15.a());
    L22:
        r16 = ", outcome=";
        Loog.INSTANCE.d(TAG, "checkVirus: cache miss: reqId=" + r14 + ", pkg=" + r1 + ", hadInFlight=" + f30005d.containsKey(r1));
        b r17 = r0.a(r1, r14);
        if (r17.b() == true) goto L25;
        Loog.INSTANCE.d(TAG, "checkVirus: join in-flight: reqId=" + r14 + ", pkg=" + r1);
    L26:
        m r18 = (m) ZeusTransformUtils.preCheckCast(new d(r17, null), m.class, "com.obric.aiagent.plugin");
        r4.f30011a = r0;
        r4.f30012b = r1;
        r4.f30013c = r14;
        r4.f30014d = r11;
        r4.g = 1;
        r3 = dg.b(500, r18, r4);
        if (r3 != r5) goto L29;
        return r5;
    L29:
        r8 = r14;
        goto L30
    L25:
        Loog.INSTANCE.i(TAG, "checkVirus: start backend scan: reqId=" + r14 + ", pkg=" + r1);
    L7:
        r4 = new C0786c(r0, r2);
        goto L8
    }

    private final b a(String r13, long r14) {
        ConcurrentHashMap<String, w<com.obric.autogui.platforms.miui.a.a.a>> r12 = f30005d;
        w r0 = (w) ZeusTransformUtils.preCheckCast(r12.get(r13), w.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        Loog.INSTANCE.d(TAG, "checkVirus: found existing in-flight: reqId=" + r14 + ", pkg=" + r13);
        return new b(r0, false);
    L6:
        w<com.obric.autogui.platforms.miui.a.a.a> r1 = y.a(null, 1, null);
        w r15 = (w) ZeusTransformUtils.preCheckCast(r12.putIfAbsent(r13, r1), w.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L10;
        Loog.INSTANCE.d(TAG, "checkVirus: join in-flight (race): reqId=" + r14 + ", pkg=" + r13);
        return new b(r15, false);
    L10:
        i.a(f30003b, null, null, (m) ZeusTransformUtils.preCheckCast(new e(r13, r14, r1, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return new b(r1, true);
    }

    private final com.obric.autogui.platforms.miui.a.a.a b(String r10) {
        ConcurrentHashMap<String, a> r0 = f30004c;
        a r1 = (a) ZeusTransformUtils.preCheckCast(r0.get(r10), a.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
        return null;
    L5:
        long r3 = SystemClock.elapsedRealtime();
        if ((r3 - r1.b()) < 1800000) goto L10;
        r0.remove(r10, r1);
        Loog.INSTANCE.d(TAG, "checkVirus: cache expired: pkg=" + r10 + ", ttlMs=1800000, ageMs=" + (r3 - r1.b()) + ", outcome=" + a(r1.a()));
        return null;
    L10:
        return r1.a();
    }
}
