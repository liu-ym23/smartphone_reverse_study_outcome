package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class a extends DependencyNode {

    /* renamed from: m, reason: collision with root package name */
    public int f1176m;

    public a(WidgetRun widgetRun) {
        super(widgetRun);
        if (widgetRun instanceof c) {
            this.f1149e = DependencyNode.Type.f1157b;
        } else {
            this.f1149e = DependencyNode.Type.f1158c;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.DependencyNode
    public final void d(int i10) {
        if (this.f1153j) {
            return;
        }
        this.f1153j = true;
        this.f1151g = i10;
        ArrayList arrayList = this.f1154k;
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            h0.d dVar = (h0.d) obj;
            dVar.a(dVar);
        }
    }
}
