package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;

/* JADX INFO: loaded from: classes4.dex */
public abstract class WidgetRun implements Dependency {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ConstraintWidget f13335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j f13336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ConstraintWidget.DimensionBehaviour f13337d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f13338e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13339f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f13340g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DependencyNode f13341h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public DependencyNode f13342i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RunType f13343j;

    public static final enum RunType extends Enum<RunType> {
        private static final /* synthetic */ RunType[] $VALUES = null;
        public static final RunType CENTER = null;
        public static final RunType END = null;
        public static final RunType NONE = null;
        public static final RunType START = null;

        static {
            RunType r10 = new RunType("NONE", 0);
            NONE = r10;
            RunType r11 = new RunType("START", 1);
            START = r11;
            RunType r12 = new RunType("END", 2);
            END = r12;
            RunType r13 = new RunType("CENTER", 3);
            CENTER = r13;
            $VALUES = new RunType[]{r10, r11, r12, r13};
        }

        private RunType(String r10, int r11) {
            super(r10, r11);
        }

        public static RunType valueOf(String r10) {
            return (RunType) Enum.valueOf(RunType.class, r10);
        }

        public static RunType[] values() {
            return (RunType[]) $VALUES.clone();
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13344a = null;

        static {
            int[] r10 = new int[ConstraintAnchor.Type.values().length];
            f13344a = r10;
            r10[ConstraintAnchor.Type.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f13344a[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f13344a[ConstraintAnchor.Type.TOP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f13344a[ConstraintAnchor.Type.BASELINE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f13344a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public WidgetRun(ConstraintWidget r10) {
        this.f13338e = new d(this);
        this.f13339f = 0;
        this.f13340g = false;
        this.f13341h = new DependencyNode(this);
        this.f13342i = new DependencyNode(this);
        this.f13343j = RunType.NONE;
        this.f13335b = r10;
    }

    public final void a(DependencyNode r10, DependencyNode r11, int r12) {
        r10.f13333l.add(r11);
        r10.f13327f = r12;
        r11.f13332k.add(r10);
    }

    public final void b(DependencyNode r10, DependencyNode r11, int r12, d r13) {
        r10.f13333l.add(r11);
        r10.f13333l.add(this.f13338e);
        r10.f13329h = r12;
        r10.f13330i = r13;
        r11.f13332k.add(r10);
        r13.f13332k.add(r10);
    }

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public final int f(int r10, int r11) {
        if (r11 != 0) goto L8;
        ConstraintWidget r12 = this.f13335b;
        int r13 = r12.A;
        int r14 = Math.max(r12.f13301z, r10);
        if (r13 <= 0) goto L6;
        r14 = Math.min(r13, r10);
    L6:
        if (r14 != r10) goto L13;
        return r10;
    L13:
        return r14;
    L8:
        ConstraintWidget r15 = this.f13335b;
        int r16 = r15.D;
        r14 = Math.max(r15.C, r10);
        if (r16 <= 0) goto L11;
        r14 = Math.min(r16, r10);
    L11:
        if (r14 != r10) goto L13;
        return r10;
    }

    public final DependencyNode g(ConstraintAnchor r10) {
        ConstraintAnchor r11 = r10.f13245f;
        if (r11 != null) goto L5;
        return null;
    L5:
        ConstraintWidget r12 = r11.f13243d;
        ConstraintAnchor.Type r13 = r11.f13244e;
        int r14 = a.f13344a[r13.ordinal()];
        if (r14 == 1) goto L21;
        if (r14 == 2) goto L25;
        if (r14 == 3) goto L24;
        if (r14 == 4) goto L23;
        if (r14 == 5) goto L22;
        return null;
    L22:
        return r12.f13261f.f13342i;
    L23:
        return r12.f13261f.f13370k;
    L24:
        return r12.f13261f.f13341h;
    L25:
        return r12.f13259e.f13342i;
    L21:
        return r12.f13259e.f13341h;
    }

    public final DependencyNode h(ConstraintAnchor r10, int r11) {
        ConstraintAnchor r12 = r10.f13245f;
        if (r12 != null) goto L5;
        return null;
    L5:
        ConstraintWidget r13 = r12.f13243d;
        if (r11 != 0) goto L8;
        WidgetRun r14 = r13.f13259e;
    L9:
        ConstraintAnchor.Type r15 = r12.f13244e;
        int r16 = a.f13344a[r15.ordinal()];
        if (r16 == 1) goto L20;
        if (r16 == 2) goto L21;
        if (r16 == 3) goto L20;
        if (r16 == 5) goto L21;
        return null;
    L21:
        return r14.f13342i;
    L20:
        return r14.f13341h;
    L8:
        r14 = r13.f13261f;
        goto L9
    }

    public long i() {
        d r10 = this.f13338e;
        if (r10.f13331j == true) goto L5;
        return 0;
    L5:
        return r10.f13328g;
    }

    public boolean j() {
        return this.f13340g;
    }

    public final void k(int r10, int r11) {
        int r12 = this.f13334a;
        if (r12 != 0) goto L5;
        this.f13338e.c(f(r11, r10));
        return;
    L5:
        if (r12 != 1) goto L7;
        this.f13338e.c(Math.min(f(this.f13338e.f13356m, r10), r11));
        return;
    L7:
        if (r12 != 2) goto L9;
        ConstraintWidget r13 = this.f13335b.J();
        if (r13 == null) goto L45;
        if (r10 != 0) goto L33;
        WidgetRun r14 = r13.f13259e;
    L34:
        d r15 = r14.f13338e;
        if (r15.f13331j == false) goto L46;
        if (r10 != 0) goto L38;
        float r16 = this.f13335b.B;
    L39:
        this.f13338e.c(f((int) ((r15.f13328g * r16) + 0.5f), r10));
        return;
    L38:
        r16 = this.f13335b.E;
        goto L39
    L46:
        return;
    L33:
        r14 = r13.f13261f;
        goto L34
    L45:
        return;
    L9:
        if (r12 != 3) goto L49;
        ConstraintWidget r17 = this.f13335b;
        WidgetRun r18 = r17.f13259e;
        ConstraintWidget.DimensionBehaviour r19 = r18.f13337d;
        ConstraintWidget.DimensionBehaviour r20 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r19 == r20) goto L14;
    L20:
        if (r10 != 0) goto L23;
        r18 = r17.f13261f;
    L23:
        if (r18.f13338e.f13331j == false) goto L43;
        float r21 = r17.u();
        if (r10 != 1) goto L27;
        int r22 = (int) ((r18.f13338e.f13328g / r21) + 0.5f);
    L28:
        this.f13338e.c(r22);
        return;
    L27:
        r22 = (int) ((r21 * r18.f13338e.f13328g) + 0.5f);
        goto L28
    L43:
        return;
    L14:
        if (r18.f13334a != 3) goto L20;
        k r23 = r17.f13261f;
        if (r23.f13337d != r20) goto L20;
        if (r23.f13334a != 3) goto L20;
        return;
    }

    public abstract boolean l();

    public void m(Dependency r10, ConstraintAnchor r11, ConstraintAnchor r12, int r13) {
        DependencyNode r14 = g(r11);
        DependencyNode r15 = g(r12);
        if (r14.f13331j == true) goto L5;
        return;
    L5:
        if (r15.f13331j == false) goto L28;
        int r16 = r14.f13328g + r11.f();
        int r17 = r15.f13328g - r12.f();
        int r18 = r17 - r16;
        if (this.f13338e.f13331j == false) goto L10;
    L12:
        d r19 = this.f13338e;
        if (r19.f13331j == true) goto L16;
        return;
    L16:
        if (r19.f13328g != r18) goto L19;
        this.f13341h.c(r16);
        this.f13342i.c(r17);
        return;
    L19:
        if (r13 != 0) goto L21;
        float r20 = this.f13335b.x();
    L23:
        if (r14 != r15) goto L25;
        r16 = r14.f13328g;
        r17 = r15.f13328g;
        r20 = 0.5f;
    L25:
        this.f13341h.c((int) ((r16 + 0.5f) + (((r17 - r16) - this.f13338e.f13328g) * r20)));
        this.f13342i.c(this.f13341h.f13328g + this.f13338e.f13328g);
        return;
    L21:
        r20 = this.f13335b.Q();
        goto L23
    L10:
        if (this.f13337d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L12;
        k(r13, r18);
        goto L12
    }

    public void n(Dependency r10) {
    }

    public void o(Dependency r10) {
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.Dependency
    public abstract void update(Dependency r10);
}
