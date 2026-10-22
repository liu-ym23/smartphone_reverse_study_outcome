package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import p0.InterfaceC5036d;

/* loaded from: classes.dex */
public class a extends DependencyNode {

    /* renamed from: m, reason: collision with root package name */
    public int f12058m;

    public a(WidgetRun widgetRun) {
        super(widgetRun);
        if (widgetRun instanceof c) {
            this.f12039e = DependencyNode.Type.HORIZONTAL_DIMENSION;
        } else {
            this.f12039e = DependencyNode.Type.VERTICAL_DIMENSION;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.DependencyNode
    public void d(int i10) {
        if (this.f12044j) {
            return;
        }
        this.f12044j = true;
        this.f12041g = i10;
        for (InterfaceC5036d interfaceC5036d : this.f12045k) {
            interfaceC5036d.a(interfaceC5036d);
        }
    }
}
