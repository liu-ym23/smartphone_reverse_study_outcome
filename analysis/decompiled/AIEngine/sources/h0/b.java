package h0;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<ConstraintWidget> f9175a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    public final a f9176b = new a();

    /* renamed from: c, reason: collision with root package name */
    public final androidx.constraintlayout.core.widgets.d f9177c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public ConstraintWidget.DimensionBehaviour f9178a;

        /* renamed from: b, reason: collision with root package name */
        public ConstraintWidget.DimensionBehaviour f9179b;

        /* renamed from: c, reason: collision with root package name */
        public int f9180c;

        /* renamed from: d, reason: collision with root package name */
        public int f9181d;

        /* renamed from: e, reason: collision with root package name */
        public int f9182e;

        /* renamed from: f, reason: collision with root package name */
        public int f9183f;

        /* renamed from: g, reason: collision with root package name */
        public int f9184g;
        public boolean h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f9185i;

        /* renamed from: j, reason: collision with root package name */
        public int f9186j;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: h0.b$b, reason: collision with other inner class name */
    public interface InterfaceC0086b {
    }

    public b(androidx.constraintlayout.core.widgets.d dVar) {
        this.f9177c = dVar;
    }

    public final boolean a(int i10, ConstraintWidget constraintWidget, InterfaceC0086b interfaceC0086b) {
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.U;
        int[] iArr = constraintWidget.f1130t;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        a aVar = this.f9176b;
        aVar.f9178a = dimensionBehaviour;
        aVar.f9179b = dimensionBehaviourArr[1];
        aVar.f9180c = constraintWidget.q();
        aVar.f9181d = constraintWidget.k();
        aVar.f9185i = false;
        aVar.f9186j = i10;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = aVar.f9178a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.f1138c;
        boolean z = dimensionBehaviour2 == dimensionBehaviour3;
        boolean z3 = aVar.f9179b == dimensionBehaviour3;
        boolean z10 = z && constraintWidget.Y > 0.0f;
        boolean z11 = z3 && constraintWidget.Y > 0.0f;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.f1136a;
        if (z10 && iArr[0] == 4) {
            aVar.f9178a = dimensionBehaviour4;
        }
        if (z11 && iArr[1] == 4) {
            aVar.f9179b = dimensionBehaviour4;
        }
        ((ConstraintLayout.b) interfaceC0086b).b(constraintWidget, aVar);
        constraintWidget.O(aVar.f9182e);
        constraintWidget.L(aVar.f9183f);
        constraintWidget.E = aVar.h;
        constraintWidget.I(aVar.f9184g);
        aVar.f9186j = 0;
        return aVar.f9185i;
    }

    public final void b(androidx.constraintlayout.core.widgets.d dVar, int i10, int i11, int i12) {
        dVar.getClass();
        int i13 = dVar.f1104d0;
        int i14 = dVar.f1106e0;
        dVar.f1104d0 = 0;
        dVar.f1106e0 = 0;
        dVar.O(i11);
        dVar.L(i12);
        if (i13 < 0) {
            dVar.f1104d0 = 0;
        } else {
            dVar.f1104d0 = i13;
        }
        if (i14 < 0) {
            dVar.f1106e0 = 0;
        } else {
            dVar.f1106e0 = i14;
        }
        androidx.constraintlayout.core.widgets.d dVar2 = this.f9177c;
        dVar2.f1198u0 = i10;
        dVar2.R();
    }

    public final void c(androidx.constraintlayout.core.widgets.d dVar) {
        ArrayList<ConstraintWidget> arrayList = this.f9175a;
        arrayList.clear();
        int size = dVar.f8946r0.size();
        for (int i10 = 0; i10 < size; i10++) {
            ConstraintWidget constraintWidget = dVar.f8946r0.get(i10);
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.U;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.f1138c;
            if (dimensionBehaviour == dimensionBehaviour2 || dimensionBehaviourArr[1] == dimensionBehaviour2) {
                arrayList.add(constraintWidget);
            }
        }
        dVar.f1197t0.f9190b = true;
    }
}
