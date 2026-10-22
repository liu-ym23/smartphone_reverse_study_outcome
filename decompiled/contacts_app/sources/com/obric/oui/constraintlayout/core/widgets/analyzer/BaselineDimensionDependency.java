package com.obric.oui.constraintlayout.core.widgets.analyzer;

/* JADX INFO: loaded from: classes3.dex */
class BaselineDimensionDependency extends DimensionDependency {
    BaselineDimensionDependency(WidgetRun r1) {
        super(r1);
    }

    public void update(DependencyNode r2) {
        DependencyNode r3 = ((VerticalWidgetRun) this.mRun).baseline;
        r3.mMargin = this.mRun.mWidget.getBaselineDistance();
        this.resolved = true;
    }
}
