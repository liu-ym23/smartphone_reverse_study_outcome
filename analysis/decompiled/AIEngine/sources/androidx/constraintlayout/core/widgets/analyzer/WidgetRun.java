package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import com.stepos.core.download.ModelFlowMeta;
import h0.j;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class WidgetRun implements h0.d {

    /* renamed from: a, reason: collision with root package name */
    public int f1164a;

    /* renamed from: b, reason: collision with root package name */
    public ConstraintWidget f1165b;

    /* renamed from: c, reason: collision with root package name */
    public j f1166c;

    /* renamed from: d, reason: collision with root package name */
    public ConstraintWidget.DimensionBehaviour f1167d;

    /* renamed from: e, reason: collision with root package name */
    public final a f1168e = new a(this);

    /* renamed from: f, reason: collision with root package name */
    public int f1169f = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1170g = false;
    public final DependencyNode h = new DependencyNode(this);

    /* renamed from: i, reason: collision with root package name */
    public final DependencyNode f1171i = new DependencyNode(this);

    /* renamed from: j, reason: collision with root package name */
    public RunType f1172j = RunType.f1173a;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class RunType {

        /* renamed from: a, reason: collision with root package name */
        public static final RunType f1173a;

        /* renamed from: b, reason: collision with root package name */
        public static final RunType f1174b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ RunType[] f1175c;

        static {
            RunType runType = new RunType(ModelFlowMeta.PLAN_NONE, 0);
            f1173a = runType;
            RunType runType2 = new RunType("START", 1);
            RunType runType3 = new RunType("END", 2);
            RunType runType4 = new RunType("CENTER", 3);
            f1174b = runType4;
            f1175c = new RunType[]{runType, runType2, runType3, runType4};
        }

        public RunType() {
            throw null;
        }

        public static RunType valueOf(String str) {
            return (RunType) Enum.valueOf(RunType.class, str);
        }

        public static RunType[] values() {
            return (RunType[]) f1175c.clone();
        }
    }

    public WidgetRun(ConstraintWidget constraintWidget) {
        this.f1165b = constraintWidget;
    }

    public static void b(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i10) {
        dependencyNode.f1155l.add(dependencyNode2);
        dependencyNode.f1150f = i10;
        dependencyNode2.f1154k.add(dependencyNode);
    }

    public static DependencyNode h(ConstraintAnchor constraintAnchor) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f1088f;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.f1086d;
        int iOrdinal = constraintAnchor2.f1087e.ordinal();
        if (iOrdinal == 1) {
            return constraintWidget.f1103d.h;
        }
        if (iOrdinal == 2) {
            return constraintWidget.f1105e.h;
        }
        if (iOrdinal == 3) {
            return constraintWidget.f1103d.f1171i;
        }
        if (iOrdinal == 4) {
            return constraintWidget.f1105e.f1171i;
        }
        if (iOrdinal != 5) {
            return null;
        }
        return constraintWidget.f1105e.f1178k;
    }

    public static DependencyNode i(ConstraintAnchor constraintAnchor, int i10) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f1088f;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.f1086d;
        WidgetRun widgetRun = i10 == 0 ? constraintWidget.f1103d : constraintWidget.f1105e;
        int iOrdinal = constraintAnchor2.f1087e.ordinal();
        if (iOrdinal == 1 || iOrdinal == 2) {
            return widgetRun.h;
        }
        if (iOrdinal == 3 || iOrdinal == 4) {
            return widgetRun.f1171i;
        }
        return null;
    }

    public final void c(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i10, a aVar) {
        dependencyNode.f1155l.add(dependencyNode2);
        dependencyNode.f1155l.add(this.f1168e);
        dependencyNode.h = i10;
        dependencyNode.f1152i = aVar;
        dependencyNode2.f1154k.add(dependencyNode);
        aVar.f1154k.add(dependencyNode);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i10, int i11) {
        if (i11 == 0) {
            ConstraintWidget constraintWidget = this.f1165b;
            int i12 = constraintWidget.f1132v;
            int iMax = Math.max(constraintWidget.f1131u, i10);
            if (i12 > 0) {
                iMax = Math.min(i12, i10);
            }
            if (iMax != i10) {
                return iMax;
            }
        } else {
            ConstraintWidget constraintWidget2 = this.f1165b;
            int i13 = constraintWidget2.f1135y;
            int iMax2 = Math.max(constraintWidget2.f1134x, i10);
            if (i13 > 0) {
                iMax2 = Math.min(i13, i10);
            }
            if (iMax2 != i10) {
                return iMax2;
            }
        }
        return i10;
    }

    public long j() {
        if (this.f1168e.f1153j) {
            return r2.f1151g;
        }
        return 0L;
    }

    public abstract boolean k();

    /* JADX WARN: Removed duplicated region for block: B:29:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(androidx.constraintlayout.core.widgets.ConstraintAnchor r13, androidx.constraintlayout.core.widgets.ConstraintAnchor r14, int r15) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.WidgetRun.l(androidx.constraintlayout.core.widgets.ConstraintAnchor, androidx.constraintlayout.core.widgets.ConstraintAnchor, int):void");
    }

    @Override // h0.d
    public void a(h0.d dVar) {
    }
}
