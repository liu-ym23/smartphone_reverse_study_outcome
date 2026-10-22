package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes17.dex */
class RunGroup {
    public static final int BASELINE = 2;
    public static final int END = 1;
    public static final int START = 0;
    public static int index;
    int direction;
    public boolean dual;
    WidgetRun firstRun;
    int groupIndex;
    WidgetRun lastRun;
    public int position;
    ArrayList<WidgetRun> runs;

    public void add(WidgetRun r100) {
        this.runs.add(r100);
        this.lastRun = r100;
    }

    public RunGroup(WidgetRun r100, int r101) {
        this.position = 0;
        this.dual = false;
        this.firstRun = null;
        this.lastRun = null;
        this.runs = new ArrayList();
        int r102 = index;
        this.groupIndex = r102;
        index = r102 + 1;
        this.firstRun = r100;
        this.lastRun = r100;
        this.direction = r101;
    }

    private boolean defineTerminalWidget(WidgetRun r100, int r101) {
        if (r100.widget.isTerminalWidget[r101] == true) goto L5;
        return false;
    L5:
        Iterator<Dependency> r102 = r100.start.dependencies.iterator();
    L7:
        if (r102.hasNext() == false) goto L25;
        Dependency r103 = r102.next();
        if ((r103 instanceof DependencyNode) == false) goto L7;
        DependencyNode r104 = (DependencyNode) r103;
        WidgetRun r105 = r104.run;
        if (r105 == r100) goto L7;
        if (r104 != r105.start) goto L7;
        if ((r100 instanceof ChainRun) == false) goto L22;
        Iterator<WidgetRun> r106 = ((ChainRun) r100).widgets.iterator();
    L19:
        if (r106.hasNext() == false) goto L24;
        defineTerminalWidget(r106.next(), r101);
    L24:
        defineTerminalWidget(r104.run, r101);
        goto L7
    L22:
        if ((r100 instanceof HelperReferences) == true) goto L24;
        r100.widget.isTerminalWidget[r101] = false;
        goto L24
    L25:
        Iterator<Dependency> r107 = r100.end.dependencies.iterator();
    L27:
        if (r107.hasNext() == false) goto L45;
        Dependency r108 = r107.next();
        if ((r108 instanceof DependencyNode) == false) goto L27;
        DependencyNode r109 = (DependencyNode) r108;
        WidgetRun r110 = r109.run;
        if (r110 == r100) goto L27;
        if (r109 != r110.start) goto L27;
        if ((r100 instanceof ChainRun) == false) goto L42;
        Iterator<WidgetRun> r111 = ((ChainRun) r100).widgets.iterator();
    L39:
        if (r111.hasNext() == false) goto L44;
        defineTerminalWidget(r111.next(), r101);
    L44:
        defineTerminalWidget(r109.run, r101);
        goto L27
    L42:
        if ((r100 instanceof HelperReferences) == true) goto L44;
        r100.widget.isTerminalWidget[r101] = false;
        goto L44
    L45:
        return false;
    }

    private long traverseEnd(DependencyNode r100, long r110) {
        WidgetRun r101 = r100.run;
        if ((r101 instanceof HelperReferences) == false) goto L5;
        return r110;
    L5:
        int r102 = r100.dependencies.size();
        int r103 = 0;
        long r104 = r110;
    L6:
        if (r103 >= r102) goto L15;
        Dependency r105 = (Dependency) ListProtector.get(r100.dependencies, r103);
        if ((r105 instanceof DependencyNode) == false) goto L13;
        DependencyNode r106 = (DependencyNode) r105;
        if (r106.run == r101) goto L13;
        r104 = Math.min(r104, traverseEnd(r106, ((long) r106.margin) + r110));
    L13:
        r103 = r103 + 1;
        goto L6
    L15:
        if (r100 != r101.end) goto L22;
        long r107 = r101.getWrapDimension();
        long r111 = r110 - r107;
        return Math.min(Math.min(r104, traverseEnd(r101.start, r111)), r111 - ((long) r101.start.margin));
    L22:
        return r104;
    }

    private long traverseStart(DependencyNode r100, long r110) {
        WidgetRun r101 = r100.run;
        if ((r101 instanceof HelperReferences) == false) goto L5;
        return r110;
    L5:
        int r102 = r100.dependencies.size();
        int r103 = 0;
        long r104 = r110;
    L6:
        if (r103 >= r102) goto L15;
        Dependency r105 = (Dependency) ListProtector.get(r100.dependencies, r103);
        if ((r105 instanceof DependencyNode) == false) goto L13;
        DependencyNode r106 = (DependencyNode) r105;
        if (r106.run == r101) goto L13;
        r104 = Math.max(r104, traverseStart(r106, ((long) r106.margin) + r110));
    L13:
        r103 = r103 + 1;
        goto L6
    L15:
        if (r100 != r101.start) goto L22;
        long r107 = r101.getWrapDimension();
        long r111 = r110 + r107;
        return Math.max(Math.max(r104, traverseStart(r101.end, r111)), r111 - ((long) r101.end.margin));
    L22:
        return r104;
    }

    public long computeWrapSize(ConstraintWidgetContainer r110, int r111) {
        WidgetRun r100 = this.firstRun;
        long r101 = 0;
        if ((r100 instanceof ChainRun) == true) goto L5;
        if (r111 != 0) goto L12;
        if ((r100 instanceof HorizontalWidgetRun) == true) goto L14;
        return 0;
    L14:
        if (r111 != 0) goto L16;
        WidgetRun r102 = r110.horizontalRun;
    L17:
        DependencyNode r103 = r102.start;
        if (r111 != 0) goto L20;
        WidgetRun r112 = r110.horizontalRun;
    L21:
        DependencyNode r113 = r112.end;
        boolean r104 = r100.start.targets.contains(r103);
        boolean r114 = this.firstRun.end.targets.contains(r113);
        long r105 = this.firstRun.getWrapDimension();
        if (r104 == false) goto L34;
        if (r114 == false) goto L34;
        long r106 = traverseStart(this.firstRun.start, 0);
        long r107 = traverseEnd(this.firstRun.end, 0);
        long r108 = r106 - r105;
        WidgetRun r115 = this.firstRun;
        int r109 = r115.end.margin;
        if (r108 < (-r109)) goto L27;
        r108 = r108 + ((long) r109);
    L27:
        int r116 = r115.start.margin;
        long r117 = ((-r107) - r105) - ((long) r116);
        if (r117 < r116) goto L30;
        r117 = r117 - ((long) r116);
    L30:
        float r118 = r115.widget.getBiasPercent(r111);
        if (r118 <= 0.0f) goto L33;
        r101 = (long) ((r117 / r118) + (r108 / (1.0f - r118)));
    L33:
        float r119 = r101;
        long r120 = (((long) ((r119 * r118) + 0.5f)) + r105) + ((long) ((r119 * (1.0f - r118)) + 0.5f));
        WidgetRun r121 = this.firstRun;
        long r122 = ((long) r121.start.margin) + r120;
        int r123 = r121.end.margin;
    L40:
        return r122 - ((long) r123);
    L34:
        if (r104 == false) goto L36;
        DependencyNode r124 = this.firstRun.start;
        return Math.max(traverseStart(r124, r124.margin), ((long) this.firstRun.start.margin) + r105);
    L36:
        if (r114 == false) goto L38;
        DependencyNode r125 = this.firstRun.end;
        return Math.max(-traverseEnd(r125, r125.margin), ((long) (-this.firstRun.end.margin)) + r105);
    L38:
        WidgetRun r126 = this.firstRun;
        r122 = ((long) r126.start.margin) + r126.getWrapDimension();
        r123 = this.firstRun.end.margin;
        goto L40
    L20:
        r112 = r110.verticalRun;
        goto L21
    L16:
        r102 = r110.verticalRun;
        goto L17
    L12:
        if ((r100 instanceof VerticalWidgetRun) == true) goto L14;
        return 0;
    L5:
        if (((ChainRun) r100).orientation == r111) goto L14;
        return 0;
    }

    public void defineTerminalWidgets(boolean r100, boolean r101) {
        if (r100 == false) goto L6;
        WidgetRun r102 = this.firstRun;
        if ((r102 instanceof HorizontalWidgetRun) == false) goto L6;
        defineTerminalWidget(r102, 0);
    L6:
        if (r101 == false) goto L11;
        WidgetRun r103 = this.firstRun;
        if ((r103 instanceof VerticalWidgetRun) == false) goto L12;
        defineTerminalWidget(r103, 1);
        return;
    L12:
        return;
    }
}
