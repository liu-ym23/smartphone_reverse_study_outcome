package androidx.constraintlayout.solver.widgets.analyzer;

import java.util.Iterator;

/* JADX INFO: loaded from: classes17.dex */
class DimensionDependency extends DependencyNode {
    public int wrapValue;

    public DimensionDependency(WidgetRun r100) {
        super(r100);
        if ((r100 instanceof HorizontalWidgetRun) == false) goto L5;
        this.type = DependencyNode.Type.HORIZONTAL_DIMENSION;
        return;
    L5:
        this.type = DependencyNode.Type.VERTICAL_DIMENSION;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.DependencyNode
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
}
