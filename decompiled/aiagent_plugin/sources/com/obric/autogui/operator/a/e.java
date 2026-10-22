package com.obric.autogui.operator.a;

import android.content.ComponentName;
import android.content.Context;
import android.os.SystemClock;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.obric.autogui.common.api.platform.input.CoordinateScrollResult;
import com.obric.autogui.common.api.platform.input.IAutoActionInputApi;
import com.obric.autogui.common.api.presentation.IAutoActionPresentationApi;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.common.api.space.DisplayOperatingSpace;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.obric.capabilitykit.common.Ext;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.bduploader.BDImageUploader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.m;

/* JADX INFO: compiled from: SwipeV3Executor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    private static final String TAG = "SwipeV3Executor";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f29835a = null;

    /* JADX INFO: compiled from: SwipeV3Executor.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.autogui.operator.a.f f29836a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ComponentName f29837b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final m<Float, Float> f29838c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final m<Float, Float> f29839d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final long f29840e;
        private final boolean f;
        private final com.obric.autogui.operator.a.d.c g;

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, a.class) == true) goto L8;
            return false;
        L8:
            a r10 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f29836a, r10.f29836a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f29837b, r10.f29837b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f29838c, r10.f29838c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f29839d, r10.f29839d) == true) goto L21;
            return false;
        L21:
            if (this.f29840e == r10.f29840e) goto L24;
            return false;
        L24:
            if (this.f == r10.f) goto L27;
            return false;
        L27:
            if (o.a(this.g, r10.g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public int hashCode() {
            return (((((((((((this.f29836a.hashCode() * 31) + this.f29837b.hashCode()) * 31) + this.f29838c.hashCode()) * 31) + this.f29839d.hashCode()) * 31) + Long.hashCode(this.f29840e)) * 31) + Boolean.hashCode(this.f)) * 31) + this.g.hashCode();
        }

        public String toString() {
            return "PreparedSwipe(request=" + this.f29836a + ", topActivity=" + this.f29837b + ", start=" + this.f29838c + ", end=" + this.f29839d + ", duration=" + this.f29840e + ", isDelay=" + this.f + ", tracking=" + this.g + ')';
        }

        public a(com.obric.autogui.operator.a.f r2, ComponentName r3, m<Float, Float> r4, m<Float, Float> r5, long r6, boolean r8, com.obric.autogui.operator.a.d.c r9) {
            o.e(r2, Ext.KEY_REQUEST);
            o.e(r3, "topActivity");
            o.e(r4, "start");
            o.e(r5, "end");
            o.e(r9, "tracking");
            this.f29836a = r2;
            this.f29837b = r3;
            this.f29838c = r4;
            this.f29839d = r5;
            this.f29840e = r6;
            this.f = r8;
            this.g = r9;
        }

        public final com.obric.autogui.operator.a.f a() {
            return this.f29836a;
        }

        public final ComponentName b() {
            return this.f29837b;
        }

        public final m<Float, Float> c() {
            return this.f29838c;
        }

        public final m<Float, Float> d() {
            return this.f29839d;
        }

        public final long e() {
            return this.f29840e;
        }

        public final boolean f() {
            return this.f;
        }

        public final com.obric.autogui.operator.a.d.c g() {
            return this.g;
        }
    }

    /* JADX INFO: compiled from: SwipeV3Executor.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CoordinateScrollResult f29841a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f29842b;

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, b.class) == true) goto L8;
            return false;
        L8:
            b r8 = (b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f29841a, r8.f29841a) == true) goto L12;
            return false;
        L12:
            if (this.f29842b == r8.f29842b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f29841a.hashCode() * 31) + Long.hashCode(this.f29842b);
        }

        public String toString() {
            return "TimedFrameworkResult(result=" + this.f29841a + ", durationMs=" + this.f29842b + ')';
        }

        public b(CoordinateScrollResult r2, long r3) {
            o.e(r2, "result");
            this.f29841a = r2;
            this.f29842b = r3;
        }

        public final CoordinateScrollResult a() {
            return this.f29841a;
        }

        public final long b() {
            return this.f29842b;
        }
    }

    /* JADX INFO: compiled from: SwipeV3Executor.kt */
    @d.c.b.a.f(b = "SwipeV3Executor.kt", c = {122, BDImageUploader.MessageIsPreHeatResultUsed, ApWakeEvent.ACCELERATING_END}, d = "execute", e = "com.obric.autogui.operator.impl.SwipeV3Executor")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29843a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29844b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f29845c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f29846d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ e f29847e;
        int f;

        c(e r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29847e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f29846d = r3;
            this.f |= Integer.MIN_VALUE;
            return e.a(this.f29847e, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SwipeV3Executor.kt */
    @d.c.b.a.f(b = "SwipeV3Executor.kt", c = {152}, d = "executeFrameworkScroll", e = "com.obric.autogui.operator.impl.SwipeV3Executor")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29848a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29849b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f29850c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f29851d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ e f29852e;
        int f;

        d(e r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29852e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f29851d = r3;
            this.f |= Integer.MIN_VALUE;
            return e.b(this.f29852e, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.operator.a.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SwipeV3Executor.kt */
    @d.c.b.a.f(b = "SwipeV3Executor.kt", c = {211}, d = "fallbackToSwipeV2", e = "com.obric.autogui.operator.impl.SwipeV3Executor")
    static final class C0776e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29853a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29854b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f29855c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f29856d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ e f29857e;
        int f;

        C0776e(e r3, d.c.d<? super C0776e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29857e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f29856d = r3;
            this.f |= Integer.MIN_VALUE;
            return e.a(this.f29857e, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SwipeV3Executor.kt */
    @d.c.b.a.f(b = "SwipeV3Executor.kt", c = {179}, d = "finishSuccessfulFrameworkScroll", e = "com.obric.autogui.operator.impl.SwipeV3Executor")
    static final class f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29858a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29859b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f29860c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f29861d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ e f29862e;
        int f;

        f(e r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29862e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f29861d = r3;
            this.f |= Integer.MIN_VALUE;
            return e.c(this.f29862e, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f29835a = new e();
    }

    private e() {
    }

    public static final /* synthetic */ Object a(e r2, IAutoActionInputApi r3, a r4, com.obric.autogui.operator.a.d.b r5, d.c.d r6) {
        return r2.a((IAutoActionInputApi) ZeusTransformUtils.wrapperContextForParams(r3, IAutoActionInputApi.class, "com.obric.aiagent.plugin"), r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(e r2, IAutoActionInputApi r3, a r4, d.c.d r5) {
        return r2.a((IAutoActionInputApi) ZeusTransformUtils.wrapperContextForParams(r3, IAutoActionInputApi.class, "com.obric.aiagent.plugin"), r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object b(e r2, IAutoActionInputApi r3, a r4, d.c.d r5) {
        return r2.b((IAutoActionInputApi) ZeusTransformUtils.wrapperContextForParams(r3, IAutoActionInputApi.class, "com.obric.aiagent.plugin"), r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object c(e r2, IAutoActionInputApi r3, a r4, d.c.d r5) {
        return r2.c((IAutoActionInputApi) ZeusTransformUtils.wrapperContextForParams(r3, IAutoActionInputApi.class, "com.obric.aiagent.plugin"), r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public final Object a(IAutoActionInputApi r11, AOOperatingSpace r12, m<Float, Float> r13, m<Float, Float> r14, long r15, boolean r17, d.c.d<? super com.obric.autogui.common.e> r18) {
        IAutoActionInputApi r0 = (IAutoActionInputApi) ZeusTransformUtils.wrapperContextForParams(r11, IAutoActionInputApi.class, "com.obric.aiagent.plugin");
        AOOperatingSpace r4 = (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r12, AOOperatingSpace.class, "com.obric.aiagent.plugin");
        d.c.d<? super com.obric.autogui.common.e> r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r18, d.c.d.class, "com.obric.aiagent.plugin");
        a r2 = a(r4, r13, r14, r15, r17);
        if (r2 != null) goto L7;
        return null;
    L7:
        return a(r0, r2, r1);
    }

    private final a a(AOOperatingSpace r15, m<Float, Float> r16, m<Float, Float> r17, long r18, boolean r20) {
        AOOperatingSpace r0 = (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r15, AOOperatingSpace.class, "com.obric.aiagent.plugin");
        if (com.obric.autogui.common.a.d.f28974a.Y() == true) goto L6;
        return null;
    L6:
        if (ZeusTransformUtils.instanceOf(r0, DisplayOperatingSpace.class) == false) goto L8;
        DisplayOperatingSpace r1 = (DisplayOperatingSpace) ZeusTransformUtils.preCheckCast(r0, DisplayOperatingSpace.class, "com.obric.aiagent.plugin");
    L9:
        if (r1 != null) goto L11;
    L58:
        return null;
    L11:
        if (r1.isValid() == true) goto L14;
        r1 = null;
    L14:
        if (r1 == null) goto L58;
        if (a() == false) goto L19;
        Loog.INSTANCE.i(TAG, "swipe v3 skipped because VDPlayer is foreground");
        return null;
    L19:
        com.obric.autogui.operator.a.f r2 = com.obric.autogui.operator.a.f.f29863a.a(r1.getDisplayId(), r16, r17);
        if (r2 != null) goto L59;
        return null;
    L59:
        DisplayedAppInfo r3 = r1.getDisplayAccessor().getTopDisplayedApp();     // Catch: Throwable -> L24
    L26:
        if (r3 != null) goto L28;
    L33:
        ComponentName r4 = null;
    L34:
        com.obric.autogui.common.a.d r5 = com.obric.autogui.common.a.d.f28974a;
        if (r4 == null) goto L37;
        String r6 = r4.getClassName();
    L39:
        if (r5.d(r6) == true) goto L54;
        Loog r7 = Loog.INSTANCE;
        StringBuilder r8 = new StringBuilder().append("swipe v3 skipped for activity, packageName=");
        if (r4 == null) goto L43;
        String r9 = r4.getPackageName();
    L44:
        StringBuilder r10 = r8.append(r9).append(", activityName=");
        if (r4 == null) goto L47;
        String r11 = r4.getClassName();
    L48:
        StringBuilder r12 = r10.append(r11).append(", isVisible=");
        if (r3 == null) goto L51;
        Boolean r13 = Boolean.valueOf(r3.isVisible());
    L52:
        r7.d(TAG, r12.append(r13).toString());
        return null;
    L51:
        r13 = null;
        goto L52
    L47:
        r11 = null;
        goto L48
    L43:
        r9 = null;
        goto L44
    L54:
        if (r4 != null) goto L56;
        return null;
    L56:
        int r14 = r2.a();
        String r19 = r4.getPackageName();
        o.c(r19, "getPackageName(...)");
        String r21 = r4.flattenToShortString();
        o.c(r21, "flattenToShortString(...)");
        return new a(r2, r4, r16, r17, r18, r20, new com.obric.autogui.operator.a.d.c(r14, r19, r21, r16, r17));
    L37:
        r6 = null;
        goto L39
    L28:
        if (r3.isVisible() == false) goto L30;
        DisplayedAppInfo r22 = r3;
    L31:
        if (r22 == null) goto L33;
        r4 = r22.getTopActivity();
        goto L34
    L30:
        r22 = null;
    L24:
        th = move-exception;
        Loog.INSTANCE.w(TAG, "swipe v3 top app query failed, fallback to touch", th);
        r3 = null;
        goto L26
    L8:
        r1 = null;
        goto L9
    }

    private final boolean a() {
        IAutoActionPresentationApi r3 = (IAutoActionPresentationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionPresentationApi.class), IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L5;
        IAutoActionPresentationApi.PlayerVisibility r4 = r3.getPlayerVisibility((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L7:
        if (r4 != IAutoActionPresentationApi.PlayerVisibility.Visible) goto L9;
        return true;
    L9:
        return false;
    L5:
        r4 = null;
        goto L7
    }

    private final Object a(IAutoActionInputApi r8, a r9, d.c.d<? super com.obric.autogui.common.e> r10) {
        IAutoActionInputApi r11 = (IAutoActionInputApi) ZeusTransformUtils.wrapperContextForParams(r8, IAutoActionInputApi.class, "com.obric.aiagent.plugin");
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r12, c.class, "com.obric.aiagent.plugin");
        if ((r0.f & Integer.MIN_VALUE) == 0) goto L7;
        r0.f -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.f29846d;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        d.o.a(r13);
    L32:
        return r13;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        d.o.a(r13);
    L26:
        return r13;
    L17:
        r9 = (a) ZeusTransformUtils.preCheckCast(r0.f29845c, a.class, "com.obric.aiagent.plugin");
        r11 = (IAutoActionInputApi) ZeusTransformUtils.preCheckCast(r0.f29844b, IAutoActionInputApi.class, "com.obric.aiagent.plugin");
        e this = (e) ZeusTransformUtils.preCheckCast(r0.f29843a, e.class, "com.obric.aiagent.plugin");
        d.o.a(r13);
    L21:
        b r14 = (b) ZeusTransformUtils.preCheckCast(r13, b.class, "com.obric.aiagent.plugin");
        if (r14.a().isSuccess() == false) goto L28;
        r0.f29843a = null;
        r0.f29844b = null;
        r0.f29845c = null;
        r0.f = 2;
        r13 = this.c(r11, r9, r0);
        if (r13 != r2) goto L26;
        return r2;
    L28:
        if (r14.a().getShouldFallbackToTouch() == false) goto L34;
        Loog.INSTANCE.w(TAG, "swipe v3 falls back to touch, result=" + r14.a().getStatus());
        com.obric.autogui.operator.a.d.b r15 = com.obric.autogui.operator.a.d.b.f29825a;
        r0.f29843a = null;
        r0.f29844b = null;
        r0.f29845c = null;
        r0.f = 3;
        r13 = this.a(r11, r9, r15, r0);
        if (r13 != r2) goto L32;
        return r2;
    L34:
        return this.a(r9.g(), com.obric.autogui.operator.a.d.a.f29821b, "Swipe V3 result is uncertain: " + r14.a().getStatus(), "result=" + r14.a().getStatus() + ", rawCode=" + r14.a().getRawCode() + ", elapsedMs=" + r14.b());
    L18:
        d.o.a(r13);
        r0.f29843a = this;
        r0.f29844b = r11;
        r0.f29845c = r9;
        r0.f = 1;
        r13 = b(r11, r9, r0);
        if (r13 != r2) goto L21;
        return r2;
    L7:
        r0 = new c(this, r12);
        goto L8
    }

    private final Object b(IAutoActionInputApi r12, a r13, d.c.d<? super b> r14) {
        IAutoActionInputApi r2 = (IAutoActionInputApi) ZeusTransformUtils.wrapperContextForParams(r12, IAutoActionInputApi.class, "com.obric.aiagent.plugin");
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, d.class) == false) goto L7;
        d r16 = (d) ZeusTransformUtils.preCheckCast(r15, d.class, "com.obric.aiagent.plugin");
        if ((r16.f & Integer.MIN_VALUE) == 0) goto L7;
        r16.f -= Integer.MIN_VALUE;
    L8:
        d r8 = r16;
        Object r11 = r8.f29851d;
        Object r17 = d.c.a.b.a();
        int r18 = r8.f;
        if (r18 == 0) goto L14;
        if (r18 != 1) goto L13;
        long r19 = r8.f29850c;
        com.obric.autogui.operator.a.f r110 = (com.obric.autogui.operator.a.f) ZeusTransformUtils.preCheckCast(r8.f29849b, com.obric.autogui.operator.a.f.class, "com.obric.aiagent.plugin");
        a r0 = (a) ZeusTransformUtils.preCheckCast(r8.f29848a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r11);
    L18:
        CoordinateScrollResult r111 = (CoordinateScrollResult) ZeusTransformUtils.preCheckCast(r11, CoordinateScrollResult.class, "com.obric.aiagent.plugin");
        long r1 = SystemClock.elapsedRealtime() - r19;
        r0.g().a(r111, r1);
        Loog.INSTANCE.i(TAG, "swipe v3 result=" + r111.getStatus() + ", rawCode=" + r111.getRawCode() + ", elapsedMs=" + r1 + ", displayId=" + r110.a() + ", packageName=" + r0.b().getPackageName() + ", x=" + r110.b() + ", y=" + r110.c() + ", deltaX=" + r110.d() + ", deltaY=" + r110.e() + ", touchTailStart=" + r110.f() + ", touchTailEnd=" + r110.g());
        return new b(r111, r1);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r11);
        r110 = r13.a();
        long r9 = SystemClock.elapsedRealtime();
        int r3 = r110.a();
        float r4 = r110.b();
        float r5 = r110.c();
        int r6 = r110.d();
        int r7 = r110.e();
        r8.f29848a = r13;
        r8.f29849b = r110;
        r8.f29850c = r9;
        r8.f = 1;
        r11 = r2.scrollAtCoordinate(r3, r4, r5, r6, r7, r8);
        if (r11 != r17) goto L17;
        return r17;
    L17:
        r0 = r13;
        r19 = r9;
    L7:
        r16 = new d(this, r15);
        goto L8
    }

    private final Object c(IAutoActionInputApi r9, a r10, d.c.d<? super com.obric.autogui.common.e> r11) {
        IAutoActionInputApi r12 = (IAutoActionInputApi) ZeusTransformUtils.wrapperContextForParams(r9, IAutoActionInputApi.class, "com.obric.aiagent.plugin");
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r13, f.class) == false) goto L7;
        f r0 = (f) ZeusTransformUtils.preCheckCast(r13, f.class, "com.obric.aiagent.plugin");
        if ((r0.f & Integer.MIN_VALUE) == 0) goto L7;
        r0.f -= Integer.MIN_VALUE;
    L8:
        Object r14 = r0.f29861d;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        long r8 = r0.f29860c;
        r10 = (a) ZeusTransformUtils.preCheckCast(r0.f29859b, a.class, "com.obric.aiagent.plugin");
        e r1 = (e) ZeusTransformUtils.preCheckCast(r0.f29858a, e.class, "com.obric.aiagent.plugin");
        d.o.a(r14);
    L18:
        com.obric.autogui.common.e r4 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r14, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        r10.g().a(SystemClock.elapsedRealtime() - r8);
        com.obric.autogui.common.e r15 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r14, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        if (r15.g() == true) goto L22;
        Loog.INSTANCE.w(TAG, "swipe v3 touch tail failed after Framework success, message=" + r15.h());
        return r1.a(r10.g(), com.obric.autogui.operator.a.d.a.f29820a, "Swipe V3 touch tail result is uncertain", "phase=touch_tail, message=" + r15.h());
    L22:
        r10.g().a();
        return com.obric.autogui.common.e.f29014b.a();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r14);
        long r5 = SystemClock.elapsedRealtime();
        int r16 = r10.a().a();
        m<Float, Float> r6 = r10.a().f();
        m<Float, Float> r7 = r10.a().g();
        r0.f29858a = this;
        r0.f29859b = r10;
        r0.f29860c = r5;
        r0.f = 1;
        r14 = r12.swipeV3Tail(r16, r6, r7, r0);
        if (r14 != r2) goto L17;
        return r2;
    L17:
        r1 = this;
        r8 = r5;
    L7:
        r0 = new f(this, r13);
        goto L8
    }

    private final Object a(IAutoActionInputApi r12, a r13, com.obric.autogui.operator.a.d.b r14, d.c.d<? super com.obric.autogui.common.e> r15) {
        IAutoActionInputApi r2 = (IAutoActionInputApi) ZeusTransformUtils.wrapperContextForParams(r12, IAutoActionInputApi.class, "com.obric.aiagent.plugin");
        d.c.d r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r16, C0776e.class) == false) goto L7;
        C0776e r17 = (C0776e) ZeusTransformUtils.preCheckCast(r16, C0776e.class, "com.obric.aiagent.plugin");
        if ((r17.f & Integer.MIN_VALUE) == 0) goto L7;
        r17.f -= Integer.MIN_VALUE;
    L8:
        C0776e r8 = r17;
        Object r11 = r8.f29856d;
        Object r18 = d.c.a.b.a();
        int r19 = r8.f;
        if (r19 == 0) goto L14;
        if (r19 != 1) goto L13;
        long r110 = r8.f29855c;
        r14 = (com.obric.autogui.operator.a.d.b) ZeusTransformUtils.preCheckCast(r8.f29854b, com.obric.autogui.operator.a.d.b.class, "com.obric.aiagent.plugin");
        a r111 = (a) ZeusTransformUtils.preCheckCast(r8.f29853a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r11);
    L18:
        com.obric.autogui.common.e r112 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r11, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        r111.g().a(r14, r112.g(), SystemClock.elapsedRealtime() - r110);
        return r112;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r11);
        long r9 = SystemClock.elapsedRealtime();
        m<Float, Float> r3 = r13.c();
        m<Float, Float> r4 = r13.d();
        long r5 = r13.e();
        boolean r7 = r13.f();
        r8.f29853a = r13;
        r8.f29854b = r14;
        r8.f29855c = r9;
        r8.f = 1;
        r11 = r2.swipe(r3, r4, r5, r7, r8);
        if (r11 != r18) goto L17;
        return r18;
    L17:
        r111 = r13;
        r110 = r9;
    L7:
        r17 = new C0776e(this, r16);
        goto L8
    }

    private final com.obric.autogui.common.e a(com.obric.autogui.operator.a.d.c r9, com.obric.autogui.operator.a.d.a r10, String r11, String r12) {
        r9.a(r10);
        return (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(com.obric.autogui.common.b.a(com.obric.autogui.common.e.f29014b.b(r11), "swipe_v3_uncertain", r12, false, null, 0, 28, null), com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
    }
}
