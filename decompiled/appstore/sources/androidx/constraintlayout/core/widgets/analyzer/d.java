package androidx.constraintlayout.core.widgets.analyzer;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class d extends DependencyNode {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f1563m;

    public d(WidgetRun r10) {
        super(r10);
        if ((r10 instanceof i) == false) goto L5;
        this.f1533e = DependencyNode.Type.HORIZONTAL_DIMENSION;
        return;
    L5:
        this.f1533e = DependencyNode.Type.VERTICAL_DIMENSION;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.DependencyNode
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
}
