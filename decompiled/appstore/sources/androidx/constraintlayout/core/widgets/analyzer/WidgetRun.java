package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* JADX INFO: loaded from: classes.dex */
public abstract class WidgetRun implements Dependency {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ConstraintWidget f1542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j f1543c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ConstraintWidget.DimensionBehaviour f1544d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f1545e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1546f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1547g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DependencyNode f1548h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public DependencyNode f1549i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RunType f1550j;

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
        public static final /* synthetic */ int[] f1551a = null;

        static {
            int[] r10 = new int[ConstraintAnchor.Type.values().length];
            f1551a = r10;
            r10[ConstraintAnchor.Type.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f1551a[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f1551a[ConstraintAnchor.Type.TOP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f1551a[ConstraintAnchor.Type.BASELINE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f1551a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public WidgetRun(ConstraintWidget r10) {
        this.f1545e = new d(this);
        this.f1546f = 0;
        this.f1547g = false;
        this.f1548h = new DependencyNode(this);
        this.f1549i = new DependencyNode(this);
        this.f1550j = RunType.NONE;
        this.f1542b = r10;
    }

    public final void a(DependencyNode r10, DependencyNode r11, int r12) {
        r10.f1540l.add(r11);
        r10.f1534f = r12;
        r11.f1539k.add(r10);
    }

    public final void b(DependencyNode r10, DependencyNode r11, int r12, d r13) {
        r10.f1540l.add(r11);
        r10.f1540l.add(this.f1545e);
        r10.f1536h = r12;
        r10.f1537i = r13;
        r11.f1539k.add(r10);
        r13.f1539k.add(r10);
    }

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public final int f(int r10, int r11) {
        if (r11 != 0) goto L8;
        ConstraintWidget r12 = this.f1542b;
        int r13 = r12.A;
        int r14 = Math.max(r12.f1482z, r10);
        if (r13 <= 0) goto L6;
        r14 = Math.min(r13, r10);
    L6:
        if (r14 != r10) goto L13;
        return r10;
    L13:
        return r14;
    L8:
        ConstraintWidget r15 = this.f1542b;
        int r16 = r15.D;
        r14 = Math.max(r15.C, r10);
        if (r16 <= 0) goto L11;
        r14 = Math.min(r16, r10);
    L11:
        if (r14 != r10) goto L13;
        return r10;
    }

    public final DependencyNode g(ConstraintAnchor r10) {
        ConstraintAnchor r11 = r10.f1426f;
        if (r11 != null) goto L5;
        return null;
    L5:
        ConstraintWidget r12 = r11.f1424d;
        ConstraintAnchor.Type r13 = r11.f1425e;
        int r14 = a.f1551a[r13.ordinal()];
        if (r14 == 1) goto L21;
        if (r14 == 2) goto L25;
        if (r14 == 3) goto L24;
        if (r14 == 4) goto L23;
        if (r14 == 5) goto L22;
        return null;
    L22:
        return r12.f1442f.f1549i;
    L23:
        return r12.f1442f.f1577k;
    L24:
        return r12.f1442f.f1548h;
    L25:
        return r12.f1440e.f1549i;
    L21:
        return r12.f1440e.f1548h;
    }

    public final DependencyNode h(ConstraintAnchor r10, int r11) {
        ConstraintAnchor r12 = r10.f1426f;
        if (r12 != null) goto L5;
        return null;
    L5:
        ConstraintWidget r13 = r12.f1424d;
        if (r11 != 0) goto L8;
        WidgetRun r14 = r13.f1440e;
    L9:
        ConstraintAnchor.Type r15 = r12.f1425e;
        int r16 = a.f1551a[r15.ordinal()];
        if (r16 == 1) goto L20;
        if (r16 == 2) goto L21;
        if (r16 == 3) goto L20;
        if (r16 == 5) goto L21;
        return null;
    L21:
        return r14.f1549i;
    L20:
        return r14.f1548h;
    L8:
        r14 = r13.f1442f;
        goto L9
    }

    public long i() {
        d r10 = this.f1545e;
        if (r10.f1538j == true) goto L5;
        return 0;
    L5:
        return r10.f1535g;
    }

    public boolean j() {
        return this.f1547g;
    }

    public final void k(int r10, int r11) {
        int r12 = this.f1541a;
        if (r12 != 0) goto L5;
        this.f1545e.c(f(r11, r10));
        return;
    L5:
        if (r12 != 1) goto L7;
        this.f1545e.c(Math.min(f(this.f1545e.f1563m, r10), r11));
        return;
    L7:
        if (r12 != 2) goto L9;
        ConstraintWidget r13 = this.f1542b.J();
        if (r13 == null) goto L46;
        if (r10 != 0) goto L33;
        WidgetRun r14 = r13.f1440e;
    L34:
        d r15 = r14.f1545e;
        if (r15.f1538j == false) goto L47;
        ConstraintWidget r16 = this.f1542b;
        if (r10 != 0) goto L39;
        float r17 = r16.B;
    L40:
        this.f1545e.c(f((int) ((r15.f1535g * r17) + 0.5f), r10));
        return;
    L39:
        r17 = r16.E;
        goto L40
    L47:
        return;
    L33:
        r14 = r13.f1442f;
        goto L34
    L46:
        return;
    L9:
        if (r12 != 3) goto L50;
        ConstraintWidget r18 = this.f1542b;
        WidgetRun r19 = r18.f1440e;
        ConstraintWidget.DimensionBehaviour r20 = r19.f1544d;
        ConstraintWidget.DimensionBehaviour r21 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r20 == r21) goto L14;
    L20:
        if (r10 != 0) goto L23;
        r19 = r18.f1442f;
    L23:
        if (r19.f1545e.f1538j == false) goto L44;
        float r22 = r18.u();
        if (r10 != 1) goto L27;
        int r23 = (int) ((r19.f1545e.f1535g / r22) + 0.5f);
    L28:
        this.f1545e.c(r23);
        return;
    L27:
        r23 = (int) ((r22 * r19.f1545e.f1535g) + 0.5f);
        goto L28
    L44:
        return;
    L14:
        if (r19.f1541a != 3) goto L20;
        k r24 = r18.f1442f;
        if (r24.f1544d != r21) goto L20;
        if (r24.f1541a != 3) goto L20;
        return;
    }

    public abstract boolean l();

    public void m(Dependency r10, ConstraintAnchor r11, ConstraintAnchor r12, int r13) {
        DependencyNode r14 = g(r11);
        DependencyNode r15 = g(r12);
        if (r14.f1538j == true) goto L5;
        return;
    L5:
        if (r15.f1538j == false) goto L29;
        int r16 = r14.f1535g + r11.f();
        int r17 = r15.f1535g - r12.f();
        int r18 = r17 - r16;
        if (this.f1545e.f1538j == false) goto L10;
    L12:
        d r19 = this.f1545e;
        if (r19.f1538j == true) goto L16;
        return;
    L16:
        if (r19.f1535g != r18) goto L19;
        this.f1548h.c(r16);
        this.f1549i.c(r17);
        return;
    L19:
        ConstraintWidget r20 = this.f1542b;
        if (r13 != 0) goto L22;
        float r21 = r20.x();
    L24:
        if (r14 != r15) goto L26;
        r16 = r14.f1535g;
        r17 = r15.f1535g;
        r21 = 0.5f;
    L26:
        this.f1548h.c((int) ((r16 + 0.5f) + (((r17 - r16) - this.f1545e.f1535g) * r21)));
        this.f1549i.c(this.f1548h.f1535g + this.f1545e.f1535g);
        return;
    L22:
        r21 = r20.Q();
        goto L24
    L10:
        if (this.f1544d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L12;
        k(r13, r18);
        goto L12
    }

    public void n(Dependency r10) {
    }

    public void o(Dependency r10) {
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.Dependency
    public abstract void update(Dependency r10);
}
