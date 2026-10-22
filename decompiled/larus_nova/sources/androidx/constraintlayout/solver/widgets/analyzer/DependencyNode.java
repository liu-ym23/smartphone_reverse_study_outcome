package androidx.constraintlayout.solver.widgets.analyzer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import r27.a;

/* JADX INFO: loaded from: classes17.dex */
public class DependencyNode implements Dependency {
    public boolean delegateToWidgetRun;
    List<Dependency> dependencies;
    int margin;
    DimensionDependency marginDependency;
    int marginFactor;
    public boolean readyToSolve;
    public boolean resolved;
    WidgetRun run;
    List<DependencyNode> targets;
    Type type;
    public Dependency updateDelegate;
    public int value;

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
            Type r100 = new Type("UNKNOWN", 0);
            UNKNOWN = r100;
            Type r101 = new Type("HORIZONTAL_DIMENSION", 1);
            HORIZONTAL_DIMENSION = r101;
            Type r102 = new Type("VERTICAL_DIMENSION", 2);
            VERTICAL_DIMENSION = r102;
            Type r103 = new Type("LEFT", 3);
            LEFT = r103;
            Type r104 = new Type("RIGHT", 4);
            RIGHT = r104;
            Type r105 = new Type("TOP", 5);
            TOP = r105;
            Type r110 = new Type("BOTTOM", 6);
            BOTTOM = r110;
            Type r111 = new Type("BASELINE", 7);
            BASELINE = r111;
            $VALUES = new Type[]{r100, r101, r102, r103, r104, r105, r110, r111};
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        private Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public void clear() {
        this.targets.clear();
        this.dependencies.clear();
        this.resolved = false;
        this.value = 0;
        this.readyToSolve = false;
        this.delegateToWidgetRun = false;
    }

    public String name() {
        String r100 = this.run.widget.getDebugName();
        Type r101 = this.type;
        if (r101 != Type.LEFT) goto L5;
    L8:
        String r102 = r100 + "_HORIZONTAL";
    L10:
        return r102 + ":" + this.type.name();
    L5:
        if (r101 == Type.RIGHT) goto L8;
        r102 = r100 + "_VERTICAL";
        goto L10
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(this.run.widget.getDebugName());
        r100.append(":");
        r100.append(this.type);
        r100.append("(");
        if (this.resolved == false) goto L5;
        Object r101 = Integer.valueOf(this.value);
    L6:
        r100.append(r101);
        r100.append(") <t=");
        r100.append(this.targets.size());
        r100.append(":d=");
        r100.append(this.dependencies.size());
        r100.append(">");
        return r100.toString();
    L5:
        r101 = "unresolved";
        goto L6
    }

    public DependencyNode(WidgetRun r100) {
        this.updateDelegate = null;
        this.delegateToWidgetRun = false;
        this.readyToSolve = false;
        this.type = Type.UNKNOWN;
        this.marginFactor = 1;
        this.marginDependency = null;
        this.resolved = false;
        this.dependencies = new ArrayList();
        this.targets = new ArrayList();
        this.run = r100;
    }

    public void addDependency(Dependency r100) {
        this.dependencies.add(r100);
        if (this.resolved == false) goto L6;
        r100.update(r100);
        return;
    }

    public void resolve(int r100) {
        if (this.resolved == false) goto L5;
        return;
    L5:
        this.resolved = true;
        this.value = r100;
        Iterator<Dependency> r101 = this.dependencies.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        Dependency r102 = r101.next();
        r102.update(r102);
        goto L7
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public void update(Dependency r100) {
        Iterator<DependencyNode> r101 = this.targets.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        if (r101.next().resolved == true) goto L4;
        return;
    L8:
        this.readyToSolve = true;
        Dependency r102 = this.updateDelegate;
        if (r102 == null) goto L12;
        r102.update(this);
    L12:
        if (this.delegateToWidgetRun == false) goto L15;
        this.run.update(this);
        return;
    L15:
        Iterator<DependencyNode> r103 = this.targets.iterator();
        DependencyNode r104 = null;
        int r105 = 0;
    L17:
        if (r103.hasNext() == false) goto L22;
        DependencyNode r106 = r103.next();
        if ((r106 instanceof DimensionDependency) == true) goto L17;
        r105 = r105 + 1;
        r104 = r106;
        goto L17
    L22:
        if (r104 == null) goto L33;
        if (r105 != 1) goto L33;
        if (r104.resolved == false) goto L33;
        DimensionDependency r107 = this.marginDependency;
        if (r107 != null) goto L29;
    L32:
        resolve(r104.value + this.margin);
        goto L33
    L29:
        if (r107.resolved == false) goto L31;
        this.margin = this.marginFactor * r107.value;
        goto L32
    L31:
        return;
    L33:
        Dependency r108 = this.updateDelegate;
        if (r108 == null) goto L45;
        r108.update(this);
        return;
    }
}
