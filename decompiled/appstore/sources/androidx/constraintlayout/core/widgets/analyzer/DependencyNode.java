package androidx.constraintlayout.core.widgets.analyzer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DependencyNode implements Dependency {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Dependency f1529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WidgetRun f1532d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Type f1533e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1534f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1535g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1536h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f1537i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f1538j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List f1539k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List f1540l;

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type BASELINE = null;
        public static final Type BOTTOM = null;
        public static final Type HORIZONTAL_DIMENSION = null;
        public static final Type LEFT = null;
        public static final Type RIGHT = null;
        public static final Type TOP = null;
        public static final Type UNKNOWN = null;
        public static final Type VERTICAL_DIMENSION = null;

        static {
            Type r10 = new Type("UNKNOWN", 0);
            UNKNOWN = r10;
            Type r11 = new Type("HORIZONTAL_DIMENSION", 1);
            HORIZONTAL_DIMENSION = r11;
            Type r12 = new Type("VERTICAL_DIMENSION", 2);
            VERTICAL_DIMENSION = r12;
            Type r13 = new Type("LEFT", 3);
            LEFT = r13;
            Type r14 = new Type("RIGHT", 4);
            RIGHT = r14;
            Type r15 = new Type("TOP", 5);
            TOP = r15;
            Type r16 = new Type("BOTTOM", 6);
            BOTTOM = r16;
            Type r17 = new Type("BASELINE", 7);
            BASELINE = r17;
            $VALUES = new Type[]{r10, r11, r12, r13, r14, r15, r16, r17};
        }

        private Type(String r10, int r11) {
            super(r10, r11);
        }

        public static Type valueOf(String r10) {
            return (Type) Enum.valueOf(Type.class, r10);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    public DependencyNode(WidgetRun r10) {
        this.f1529a = null;
        this.f1530b = false;
        this.f1531c = false;
        this.f1533e = Type.UNKNOWN;
        this.f1536h = 1;
        this.f1537i = null;
        this.f1538j = false;
        this.f1539k = new ArrayList();
        this.f1540l = new ArrayList();
        this.f1532d = r10;
    }

    public void a(Dependency r10) {
        this.f1539k.add(r10);
        if (this.f1538j == false) goto L6;
        r10.update(r10);
        return;
    }

    public void b() {
        this.f1540l.clear();
        this.f1539k.clear();
        this.f1538j = false;
        this.f1535g = 0;
        this.f1531c = false;
        this.f1530b = false;
    }

    public void c(int r10) {
        if (this.f1538j == false) goto L5;
        return;
    L5:
        this.f1538j = true;
        this.f1535g = r10;
        Iterator r11 = this.f1539k.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        Dependency r12 = (Dependency) r11.next();
        r12.update(r12);
        goto L7
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append(this.f1532d.f1542b.s());
        r10.append(":");
        r10.append(this.f1533e);
        r10.append("(");
        if (this.f1538j == false) goto L5;
        Object r11 = Integer.valueOf(this.f1535g);
    L6:
        r10.append(r11);
        r10.append(") <t=");
        r10.append(this.f1540l.size());
        r10.append(":d=");
        r10.append(this.f1539k.size());
        r10.append(">");
        return r10.toString();
    L5:
        r11 = "unresolved";
        goto L6
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency r10) {
        Iterator r11 = this.f1540l.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        if (((DependencyNode) r11.next()).f1538j == true) goto L4;
        return;
    L8:
        this.f1531c = true;
        Dependency r12 = this.f1529a;
        if (r12 == null) goto L12;
        r12.update(this);
    L12:
        if (this.f1530b == false) goto L15;
        this.f1532d.update(this);
        return;
    L15:
        Iterator r13 = this.f1540l.iterator();
        DependencyNode r14 = null;
        int r15 = 0;
    L17:
        if (r13.hasNext() == false) goto L22;
        DependencyNode r16 = (DependencyNode) r13.next();
        if ((r16 instanceof d) == true) goto L17;
        r15 = r15 + 1;
        r14 = r16;
        goto L17
    L22:
        if (r14 == null) goto L33;
        if (r15 != 1) goto L33;
        if (r14.f1538j == false) goto L33;
        d r17 = this.f1537i;
        if (r17 != null) goto L29;
    L32:
        c(r14.f1535g + this.f1534f);
        goto L33
    L29:
        if (r17.f1538j == false) goto L31;
        this.f1534f = this.f1536h * r17.f1535g;
        goto L32
    L31:
        return;
    L33:
        Dependency r18 = this.f1529a;
        if (r18 == null) goto L45;
        r18.update(this);
        return;
    }
}
