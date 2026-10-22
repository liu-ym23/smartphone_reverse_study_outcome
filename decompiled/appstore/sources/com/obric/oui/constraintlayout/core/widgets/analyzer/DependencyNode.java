package com.obric.oui.constraintlayout.core.widgets.analyzer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class DependencyNode implements Dependency {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Dependency f13322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f13323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f13324c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WidgetRun f13325d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Type f13326e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13327f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f13328g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f13329h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f13330i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f13331j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List f13332k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List f13333l;

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
        this.f13322a = null;
        this.f13323b = false;
        this.f13324c = false;
        this.f13326e = Type.UNKNOWN;
        this.f13329h = 1;
        this.f13330i = null;
        this.f13331j = false;
        this.f13332k = new ArrayList();
        this.f13333l = new ArrayList();
        this.f13325d = r10;
    }

    public void a(Dependency r10) {
        this.f13332k.add(r10);
        if (this.f13331j == false) goto L6;
        r10.update(r10);
        return;
    }

    public void b() {
        this.f13333l.clear();
        this.f13332k.clear();
        this.f13331j = false;
        this.f13328g = 0;
        this.f13324c = false;
        this.f13323b = false;
    }

    public void c(int r10) {
        if (this.f13331j == false) goto L5;
        return;
    L5:
        this.f13331j = true;
        this.f13328g = r10;
        Iterator r11 = this.f13332k.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        Dependency r12 = (Dependency) r11.next();
        r12.update(r12);
        goto L7
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append(this.f13325d.f13335b.s());
        r10.append(":");
        r10.append(this.f13326e);
        r10.append("(");
        if (this.f13331j == false) goto L5;
        Object r11 = Integer.valueOf(this.f13328g);
    L6:
        r10.append(r11);
        r10.append(") <t=");
        r10.append(this.f13333l.size());
        r10.append(":d=");
        r10.append(this.f13332k.size());
        r10.append(">");
        return r10.toString();
    L5:
        r11 = "unresolved";
        goto L6
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency r10) {
        Iterator r11 = this.f13333l.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        if (((DependencyNode) r11.next()).f13331j == true) goto L4;
        return;
    L8:
        this.f13324c = true;
        Dependency r12 = this.f13322a;
        if (r12 == null) goto L12;
        r12.update(this);
    L12:
        if (this.f13323b == false) goto L15;
        this.f13325d.update(this);
        return;
    L15:
        Iterator r13 = this.f13333l.iterator();
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
        if (r14.f13331j == false) goto L33;
        d r17 = this.f13330i;
        if (r17 != null) goto L29;
    L32:
        c(r14.f13328g + this.f13327f);
        goto L33
    L29:
        if (r17.f13331j == false) goto L31;
        this.f13327f = this.f13329h * r17.f13328g;
        goto L32
    L31:
        return;
    L33:
        Dependency r18 = this.f13322a;
        if (r18 == null) goto L45;
        r18.update(this);
        return;
    }
}
