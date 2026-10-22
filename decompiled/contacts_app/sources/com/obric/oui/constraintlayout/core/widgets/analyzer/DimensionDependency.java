package com.obric.oui.constraintlayout.core.widgets.analyzer;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
class DimensionDependency extends DependencyNode {
    public int wrapValue;

    DimensionDependency(WidgetRun r1) {
        super(r1);
        if ((r1 instanceof HorizontalWidgetRun) == false) goto L5;
        this.mType = DependencyNode.Type.HORIZONTAL_DIMENSION;
        return;
    L5:
        this.mType = DependencyNode.Type.VERTICAL_DIMENSION;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.DependencyNode
    public void resolve(int r2) {
        if (this.resolved == false) goto L5;
        return;
    L5:
        this.resolved = true;
        this.value = r2;
        Iterator<Dependency> r1 = this.mDependencies.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        Dependency r3 = r1.next();
        r3.update(r3);
        goto L7
    }
}
