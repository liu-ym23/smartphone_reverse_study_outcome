package h0;

import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public WidgetRun f9197a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<WidgetRun> f9198b;

    public static long a(DependencyNode dependencyNode, long j10) {
        WidgetRun widgetRun = dependencyNode.f1148d;
        ArrayList arrayList = dependencyNode.f1154k;
        if (widgetRun instanceof androidx.constraintlayout.core.widgets.analyzer.b) {
            return j10;
        }
        int size = arrayList.size();
        long jMin = j10;
        for (int i10 = 0; i10 < size; i10++) {
            d dVar = (d) arrayList.get(i10);
            if (dVar instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dVar;
                if (dependencyNode2.f1148d != widgetRun) {
                    jMin = Math.min(jMin, a(dependencyNode2, dependencyNode2.f1150f + j10));
                }
            }
        }
        DependencyNode dependencyNode3 = widgetRun.f1171i;
        DependencyNode dependencyNode4 = widgetRun.h;
        if (dependencyNode != dependencyNode3) {
            return jMin;
        }
        long j11 = j10 - widgetRun.j();
        return Math.min(Math.min(jMin, a(dependencyNode4, j11)), j11 - dependencyNode4.f1150f);
    }

    public static long b(DependencyNode dependencyNode, long j10) {
        WidgetRun widgetRun = dependencyNode.f1148d;
        ArrayList arrayList = dependencyNode.f1154k;
        if (widgetRun instanceof androidx.constraintlayout.core.widgets.analyzer.b) {
            return j10;
        }
        int size = arrayList.size();
        long jMax = j10;
        for (int i10 = 0; i10 < size; i10++) {
            d dVar = (d) arrayList.get(i10);
            if (dVar instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dVar;
                if (dependencyNode2.f1148d != widgetRun) {
                    jMax = Math.max(jMax, b(dependencyNode2, dependencyNode2.f1150f + j10));
                }
            }
        }
        DependencyNode dependencyNode3 = widgetRun.h;
        DependencyNode dependencyNode4 = widgetRun.f1171i;
        if (dependencyNode != dependencyNode3) {
            return jMax;
        }
        long j11 = widgetRun.j() + j10;
        return Math.max(Math.max(jMax, b(dependencyNode4, j11)), j11 - dependencyNode4.f1150f);
    }
}
