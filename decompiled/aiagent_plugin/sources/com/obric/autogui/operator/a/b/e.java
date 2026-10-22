package com.obric.autogui.operator.a.b;

import android.content.Context;
import android.graphics.PointF;
import com.obric.autogui.common.api.AODeviceSpecificTools;
import com.obric.autogui.common.api.configs.AutoActionConfigs;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.system.viewhierarchy.VHNode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.k;
import d.l.n;
import d.m;
import d.s;

/* JADX INFO: compiled from: OpSwipeUI.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends com.obric.autogui.operator.a.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f29654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private m<m<Integer, Integer>, m<Integer, Integer>> f29655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.obric.autogui.operator.a.c.a.c.a f29656d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.obric.autogui.operator.a.c.b f29657e;

    /* JADX INFO: compiled from: OpSwipeUI.kt */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f29658a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f29659b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f29660c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f29661d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f29662e = null;
        private static final /* synthetic */ a[] g = null;
        private static final /* synthetic */ d.d.a h = null;
        private final String f;

        private static final /* synthetic */ a[] b() {
            return new a[]{f29658a, f29659b, f29660c, f29661d, f29662e};
        }

        private a(String r1, int r2, String r3) {
            super(r1, r2);
            this.f = r3;
        }

        public final String a() {
            return this.f;
        }

        static {
            f29658a = new a("BETWEEN", 0, "between");
            f29659b = new a("UP", 1, "up");
            f29660c = new a("DOWN", 2, "down");
            f29661d = new a("LEFT", 3, "left");
            f29662e = new a("RIGHT", 4, "right");
            a[] r0 = b();
            g = r0;
            h = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(g.clone(), a[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: OpSwipeUI.kt */
    public static final class b implements com.obric.autogui.operator.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a f29663a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final PointF f29664b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final PointF f29665c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f29666d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f29667e;

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
            return false;
        L8:
            b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.aiagent.plugin");
            if (this.f29663a == r10.f29663a) goto L12;
            return false;
        L12:
            if (o.a(this.f29664b, r10.f29664b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f29665c, r10.f29665c) == true) goto L18;
            return false;
        L18:
            if (this.f29666d == r10.f29666d) goto L21;
            return false;
        L21:
            if (this.f29667e == r10.f29667e) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((this.f29663a.hashCode() * 31) + this.f29664b.hashCode()) * 31) + this.f29665c.hashCode()) * 31) + Long.hashCode(this.f29666d)) * 31) + Integer.hashCode(this.f29667e);
        }

        public String toString() {
            return "Input(direction=" + this.f29663a + ", fromPos=" + this.f29664b + ", toPos=" + this.f29665c + ", duration=" + this.f29666d + ", lengthPixels=" + this.f29667e + ')';
        }

        public b(a r2, PointF r3, PointF r4, long r5, int r7) {
            o.e(r2, "direction");
            o.e(r3, "fromPos");
            o.e(r4, "toPos");
            this.f29663a = r2;
            this.f29664b = r3;
            this.f29665c = r4;
            this.f29666d = r5;
            this.f29667e = r7;
        }

        public final a a() {
            return this.f29663a;
        }

        public /* synthetic */ b(a r8, PointF r9, PointF r10, long r11, int r13, int r14, d.h.b.h r15) {
            if ((r14 & 2) == 0) goto L5;
            r9 = new PointF();
        L5:
            PointF r2 = r9;
            if ((r14 & 4) == 0) goto L8;
            r10 = new PointF();
        L8:
            PointF r3 = r10;
            if ((r14 & 8) == 0) goto L11;
            r11 = 750;
        L11:
            long r4 = r11;
            if ((r14 & 16) == 0) goto L14;
            r13 = -1;
        L14:
            this(r8, r2, r3, r4, r13);
        }

        public final PointF b() {
            return this.f29664b;
        }

        public final PointF c() {
            return this.f29665c;
        }

        public final long d() {
            return this.f29666d;
        }

        public final int e() {
            return this.f29667e;
        }
    }

    /* JADX INFO: compiled from: OpSwipeUI.kt */
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f29668a = null;

        static {
            int[] r0 = new int[a.values().length];
            r0[a.f29659b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[a.f29660c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[a.f29661d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[a.f29662e.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[a.f29658a.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f29668a = r0;
        }
    }

    /* JADX INFO: compiled from: OpSwipeUI.kt */
    @d.c.b.a.f(b = "OpSwipeUI.kt", c = {227}, d = "adjustedSwipeRange", e = "com.obric.autogui.operator.impl.op.OpSwipeUI")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29669a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29670b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f29671c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f29672d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ e f29673e;
        int f;

        d(e r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29673e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f29672d = r3;
            this.f |= Integer.MIN_VALUE;
            return e.a(this.f29673e, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.operator.a.b.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OpSwipeUI.kt */
    @d.c.b.a.f(b = "OpSwipeUI.kt", c = {102, 108}, d = "performSingletonOperation", e = "com.obric.autogui.operator.impl.op.OpSwipeUI")
    static final class C0766e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29674a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29675b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f29676c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ e f29677d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f29678e;

        C0766e(e r3, d.c.d<? super C0766e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29677d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f29676c = r3;
            this.f29678e |= Integer.MIN_VALUE;
            return this.f29677d.c(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OpSwipeUI.kt */
    @d.c.b.a.f(b = "OpSwipeUI.kt", c = {193}, d = "resolveBetweenSwipeRange", e = "com.obric.autogui.operator.impl.op.OpSwipeUI")
    static final class f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f29679a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f29680b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f29681c;

        f(e r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29680b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f29679a = r3;
            this.f29681c |= Integer.MIN_VALUE;
            return e.a(this.f29680b, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OpSwipeUI.kt */
    @d.c.b.a.f(b = "OpSwipeUI.kt", c = {123}, d = "resolveExecutionRange$operator_release", e = "com.obric.autogui.operator.impl.op.OpSwipeUI")
    static final class g extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29682a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f29683b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ e f29684c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f29685d;

        g(e r3, d.c.d<? super g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29684c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f29683b = r3;
            this.f29685d |= Integer.MIN_VALUE;
            return this.f29684c.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    private final float a(int r1) {
        if (r1 >= 0) goto L5;
        return 0.0f;
    L5:
        return r1;
    }

    public static /* synthetic */ String lambda$F24MDRK7k9GCrQrAEVTuGT7TN_A(VHNode r0) {
        return a(r0);
    }

    public e() {
        com.obric.autogui.operator.a.c.a.c.a r0 = new com.obric.autogui.operator.a.c.a.c.a();
        this.f29656d = r0;
        this.f29657e = new com.obric.autogui.operator.a.c.b("SwipeUI", p.b(new com.obric.autogui.operator.a.c.c[]{new com.obric.autogui.operator.a.c.a.a(AutoActionConfigs.INSTANCE.getBooleanCfg("operator.precheck.swipe.activity_change.enable", false)), r0}));
    }

    public static final /* synthetic */ Object a(e r2, PointF r3, PointF r4, d.c.d r5) {
        return r2.a(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(e r2, b r3, d.c.d r4) {
        return r2.d(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.operator.b
    public com.obric.autogui.operator.a.c.b a() {
        return this.f29657e;
    }

    @Override // com.obric.autogui.operator.d
    public boolean b(com.obric.autogui.operator.b.a r3) {
        com.obric.autogui.operator.b.a r4 = (com.obric.autogui.operator.b.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "input");
        if (ZeusTransformUtils.instanceOf(r4, b.class) == true) goto L6;
        return false;
    L6:
        this.f29654b = (b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.aiagent.plugin");
        this.f29655c = null;
        return true;
    }

    @Override // com.obric.autogui.operator.b
    public void a(com.obric.autogui.operator.e r2) {
        o.e(r2, "step");
        super.a(r2);
        this.f29655c = null;
    }

    @Override // com.obric.autogui.operator.a.b
    public Object c(Context r13, d.c.d<? super com.obric.autogui.common.e> r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        d.c.d r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r16, C0766e.class) == false) goto L7;
        C0766e r17 = (C0766e) ZeusTransformUtils.preCheckCast(r16, C0766e.class, "com.obric.aiagent.plugin");
        if ((r17.f29678e & Integer.MIN_VALUE) == 0) goto L7;
        r17.f29678e -= Integer.MIN_VALUE;
    L8:
        C0766e r7 = r17;
        Object r18 = r7.f29676c;
        Object r19 = d.c.a.b.a();
        int r0 = r7.f29678e;
        if (r0 == 0) goto L16;
        if (r0 == 1) goto L15;
        if (r0 != 2) goto L14;
        d.o.a(r18);
    L32:
        return (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r18, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        b r12 = (b) ZeusTransformUtils.preCheckCast(r7.f29675b, b.class, "com.obric.aiagent.plugin");
        e r1 = (e) ZeusTransformUtils.preCheckCast(r7.f29674a, e.class, "com.obric.aiagent.plugin");
        d.o.a(r18);
    L24:
        m r110 = (m) ZeusTransformUtils.preCheckCast(r18, m.class, "com.obric.aiagent.plugin");
        if (r110 == null) goto L27;
        m<Integer, Integer> r3 = (m) ZeusTransformUtils.preCheckCast(r110.c(), m.class, "com.obric.aiagent.plugin");
        m<Integer, Integer> r4 = (m) ZeusTransformUtils.preCheckCast(r110.d(), m.class, "com.obric.aiagent.plugin");
        long r5 = Math.max(r12.d(), 10);
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(r1), "performing swipe from " + r3 + " to " + r4 + " (type=" + r12.a() + "); dur=" + r5);
        r7.f29674a = null;
        r7.f29675b = null;
        r7.f29678e = 2;
        r18 = r1.a(r3, r4, r5, r7);
        if (r18 != r19) goto L32;
        return r19;
    L27:
        return com.obric.autogui.common.e.f29014b.b("failed to get screen size");
    L16:
        d.o.a(r18);
        b r111 = this.f29654b;
        if (r111 == null) goto L19;
        r7.f29674a = this;
        r7.f29675b = r111;
        r7.f29678e = 1;
        Object r2 = a(r7);
        if (r2 != r19) goto L23;
        return r19;
    L23:
        r1 = this;
        r12 = r111;
        r18 = r2;
        goto L24
    L19:
        return com.obric.autogui.common.e.f29014b.b("no input provided");
    L7:
        r17 = new C0766e(this, r16);
        goto L8
    }

    public final Object a(d.c.d<? super m<m<Integer, Integer>, m<Integer, Integer>>> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, g.class) == false) goto L7;
        g r0 = (g) ZeusTransformUtils.preCheckCast(r8, g.class, "com.obric.aiagent.plugin");
        if ((r0.f29685d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f29685d -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.f29683b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f29685d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        e this = (e) ZeusTransformUtils.preCheckCast(r0.f29682a, e.class, "com.obric.aiagent.plugin");
        d.o.a(r9);
    L23:
        m<m<Integer, Integer>, m<Integer, Integer>> r10 = (m) ZeusTransformUtils.preCheckCast(r9, m.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L27;
        this.f29655c = r10;
        return r10;
    L27:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r9);
        m<m<Integer, Integer>, m<Integer, Integer>> r11 = this.f29655c;
        if (r11 == null) goto L17;
        return r11;
    L17:
        b r12 = this.f29654b;
        if (r12 != null) goto L20;
        return null;
    L20:
        r0.f29682a = this;
        r0.f29685d = 1;
        r9 = a(r12, r0);
        if (r9 != r2) goto L23;
        return r2;
    L7:
        r0 = new g(this, r8);
        goto L8
    }

    private final Object a(b r5, d.c.d<? super m<m<Integer, Integer>, m<Integer, Integer>>> r6) {
        d.c.d<? super m<m<Integer, Integer>, m<Integer, Integer>>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (r5.a() == a.f29658a) goto L5;
        m<Integer, Integer> r4 = AODeviceSpecificTools.INSTANCE.getScreenDimensions();
        if (r4 != null) goto L18;
        return null;
    L18:
        int r0 = ((Number) ZeusTransformUtils.preCheckCast(r4.a(), Number.class, "com.obric.aiagent.plugin")).intValue();
        int r1 = r0 / 2;
        int r8 = ((Number) ZeusTransformUtils.preCheckCast(r4.b(), Number.class, "com.obric.aiagent.plugin")).intValue() / 2;
        if (r5.e() <= 0) goto L21;
        int r2 = r5.e();
    L22:
        int r3 = r2 / 2;
        a r9 = r5.a();
        int r10 = c.f29668a[r9.ordinal()];
        if (r10 == 1) goto L38;
        if (r10 == 2) goto L42;
        if (r10 == 3) goto L41;
        if (r10 == 4) goto L40;
        if (r10 != 5) goto L33;
        return null;
    L33:
        throw new k();
    L40:
        return s.a(new m(d.c.b.a.b.a(r1 - r3), d.c.b.a.b.a(r8)), new m(d.c.b.a.b.a(r1 + r3), d.c.b.a.b.a(r8)));
    L41:
        return s.a(new m(d.c.b.a.b.a(r1 + r3), d.c.b.a.b.a(r8)), new m(d.c.b.a.b.a(r1 - r3), d.c.b.a.b.a(r8)));
    L42:
        return s.a(new m(d.c.b.a.b.a(r1), d.c.b.a.b.a(r8 - r3)), new m(d.c.b.a.b.a(r1), d.c.b.a.b.a(r8 + r3)));
    L38:
        return s.a(new m(d.c.b.a.b.a(r1), d.c.b.a.b.a(r8 + r3)), new m(d.c.b.a.b.a(r1), d.c.b.a.b.a(r8 - r3)));
    L21:
        r2 = r1;
        goto L22
    L5:
        if (c() == false) goto L10;
        Object r11 = b(r5, r7);
        if (r11 != d.c.a.b.a()) goto L39;
        return r11;
    L39:
        return (m) ZeusTransformUtils.preCheckCast(r11, m.class, "com.obric.aiagent.plugin");
    L10:
        Object r12 = c(r5, r7);
        if (r12 != d.c.a.b.a()) goto L14;
        return r12;
    L14:
        return (m) ZeusTransformUtils.preCheckCast(r12, m.class, "com.obric.aiagent.plugin");
    }

    private final boolean c() {
        return AutoActionConfigs.INSTANCE.getBooleanCfg("operator.swipe.between.coordinate_fix.enable", true);
    }

    private final Object b(b r3, d.c.d<? super m<m<Integer, Integer>, m<Integer, Integer>>> r4) {
        return d(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    private final Object c(b r3, d.c.d<? super m<m<Integer, Integer>, m<Integer, Integer>>> r4) {
        d.c.d<? super m<m<Integer, Integer>, m<Integer, Integer>>> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        if (AODeviceSpecificTools.INSTANCE.getScreenDimensions() != null) goto L7;
        return null;
    L7:
        return d(r3, r5);
    }

    private final Object d(b r6, d.c.d<? super m<m<Integer, Integer>, m<Integer, Integer>>> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, f.class) == false) goto L7;
        f r0 = (f) ZeusTransformUtils.preCheckCast(r8, f.class, "com.obric.aiagent.plugin");
        if ((r0.f29681c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f29681c -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.f29679a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f29681c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        d.o.a(r9);
    L17:
        m r5 = (m) ZeusTransformUtils.preCheckCast(r9, m.class, "com.obric.aiagent.plugin");
        return s.a(new m(d.c.b.a.b.a((int) ((PointF) ZeusTransformUtils.preCheckCast(r5.a(), PointF.class, "com.obric.aiagent.plugin")).x), d.c.b.a.b.a((int) ((PointF) ZeusTransformUtils.preCheckCast(r5.a(), PointF.class, "com.obric.aiagent.plugin")).y)), new m(d.c.b.a.b.a((int) ((PointF) ZeusTransformUtils.preCheckCast(r5.b(), PointF.class, "com.obric.aiagent.plugin")).x), d.c.b.a.b.a((int) ((PointF) ZeusTransformUtils.preCheckCast(r5.b(), PointF.class, "com.obric.aiagent.plugin")).y)));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r9);
        PointF r10 = r6.b();
        PointF r11 = r6.c();
        r0.f29681c = 1;
        r9 = a(r10, r11, r0);
        if (r9 != r2) goto L17;
        return r2;
    L7:
        r0 = new f(this, r8);
        goto L8
    }

    private final m<Float, Float> a(m<Integer, Integer> r5) {
        return new m(Float.valueOf(a(((Number) ZeusTransformUtils.preCheckCast(r5.a(), Number.class, "com.obric.aiagent.plugin")).intValue())), Float.valueOf(a(((Number) ZeusTransformUtils.preCheckCast(r5.b(), Number.class, "com.obric.aiagent.plugin")).intValue())));
    }

    private final Object a(m<Integer, Integer> r13, m<Integer, Integer> r14, long r15, d.c.d<? super com.obric.autogui.common.e> r17) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r17, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.autogui.operator.a.c.a(com.obric.autogui.operator.a.c.f29713a, a(r13), a(r14), r15, false, null, null, r9, 56, null);
    }

    private final Object a(PointF r7, PointF r8, d.c.d<? super m<? extends PointF, ? extends PointF>> r9) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, d.class) == false) goto L7;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r10, d.class, "com.obric.aiagent.plugin");
        if ((r0.f & Integer.MIN_VALUE) == 0) goto L7;
        r0.f -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.f29672d;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r8 = (PointF) ZeusTransformUtils.preCheckCast(r0.f29671c, PointF.class, "com.obric.aiagent.plugin");
        r7 = (PointF) ZeusTransformUtils.preCheckCast(r0.f29670b, PointF.class, "com.obric.aiagent.plugin");
        e this = (e) ZeusTransformUtils.preCheckCast(r0.f29669a, e.class, "com.obric.aiagent.plugin");
        d.o.a(r11);
    L18:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L20;
        final VHNode r12 = this.f29656d.d();
        if (r12 != null) goto L25;
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), "current scrollable VHNode not found");
        return s.a(r7, r8);
    L25:
        m<PointF, PointF> r1 = this.a(r7, r8, r12.getBounds());
        m<PointF, PointF> r4 = this.a((PointF) ZeusTransformUtils.preCheckCast(r1.c(), PointF.class, "com.obric.aiagent.plugin"), (PointF) ZeusTransformUtils.preCheckCast(r1.d(), PointF.class, "com.obric.aiagent.plugin"), r7, r8);
        PointF r5 = (PointF) ZeusTransformUtils.preCheckCast(r4.c(), PointF.class, "com.obric.aiagent.plugin");
        PointF r6 = (PointF) ZeusTransformUtils.preCheckCast(r4.d(), PointF.class, "com.obric.aiagent.plugin");
        if (o.a(r5, r7) == true) goto L28;
    L29:
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), "adjusted swipe range from (" + r7 + "=>" + r8 + ") to (" + r5 + "=>" + r6 + ')');
        Loog.INSTANCE.dp(LogUtil.INSTANCE.getCLAZZ_TAG(this), new $$Lambda$e$F24MDRK7k9GCrQrAEVTuGT7TN_A(r12));
    L31:
        return s.a(r5, r6);
    L28:
        if (o.a(r6, r8) == true) goto L31;
    L20:
        return s.a(r7, r8);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r11);
        com.obric.autogui.operator.a.c.a.c.a r13 = this.f29656d;
        r0.f29669a = this;
        r0.f29670b = r7;
        r0.f29671c = r8;
        r0.f = 1;
        r11 = r13.a(r0);
        if (r11 != r2) goto L18;
        return r2;
    L7:
        r0 = new d(this, r10);
        goto L8
    }

    private static final String a(VHNode r2) {
        return "swipeVH : " + ((VHNode) ZeusTransformUtils.wrapperContextForParams(r2, VHNode.class, "com.obric.aiagent.plugin"));
    }

    private final m<PointF, PointF> a(PointF r6, PointF r7, VHNode.Bounds r8) {
        if ((r8.getScreenRight() - r8.getScreenLeft()) <= 2) goto L5;
        int r5 = r8.getScreenLeft() + 1;
    L6:
        float r9 = r5;
        if ((r8.getScreenRight() - r8.getScreenLeft()) <= 2) goto L9;
        int r1 = r8.getScreenRight() - 1;
    L10:
        float r2 = r1;
        if ((r8.getScreenBottom() - r8.getScreenTop()) <= 2) goto L13;
        int r3 = r8.getScreenTop() + 1;
    L14:
        float r4 = r3;
        if ((r8.getScreenBottom() - r8.getScreenTop()) <= 2) goto L17;
        int r10 = r8.getScreenBottom() - 1;
    L19:
        return s.a(new PointF(n.a(r6.x, r9, r2), n.a(r6.y, r4, r10)), new PointF(r7.x, r7.y));
    L17:
        r10 = r8.getScreenBottom();
        goto L19
    L13:
        r3 = r8.getScreenTop();
        goto L14
    L9:
        r1 = r8.getScreenRight();
        goto L10
    L5:
        r5 = r8.getScreenLeft();
        goto L6
    }

    private final m<PointF, PointF> a(PointF r9, PointF r10, PointF r11, PointF r12) {
        double r0 = Math.hypot(r12.x - r11.x, r12.y - r11.y);
        double r2 = Math.hypot(r10.x - r9.x, r10.y - r9.y);
        if (r2 >= (((double) 0.8f) * r0)) goto L13;
        if (r0 <= 0.0d) goto L13;
        double r1 = r0 - r2;
        double r3 = r12.x - r11.x;
        double r13 = r12.y - r11.y;
        double r6 = Math.hypot(r3, r13);
        if (r6 <= 0.0d) goto L13;
        double r4 = r3 / r6;
        double r14 = r13 / r6;
        m<Integer, Integer> r8 = AODeviceSpecificTools.INSTANCE.getScreenDimensions();
        if (r8 == null) goto L13;
        return s.a(r9, new PointF(n.a(r10.x + ((float) (r4 * r1)), 0.0f, ((Number) ZeusTransformUtils.preCheckCast(r8.a(), Number.class, "com.obric.aiagent.plugin")).intValue()), n.a(r10.y + ((float) (r14 * r1)), 0.0f, ((Number) ZeusTransformUtils.preCheckCast(r8.b(), Number.class, "com.obric.aiagent.plugin")).intValue())));
    L13:
        return s.a(r9, r10);
    }
}
