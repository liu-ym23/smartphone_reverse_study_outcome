package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import h0.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class h extends g0.a {

    /* renamed from: t0, reason: collision with root package name */
    public int f1229t0 = 0;

    /* renamed from: u0, reason: collision with root package name */
    public int f1230u0 = 0;

    /* renamed from: v0, reason: collision with root package name */
    public int f1231v0 = 0;

    /* renamed from: w0, reason: collision with root package name */
    public int f1232w0 = 0;

    /* renamed from: x0, reason: collision with root package name */
    public int f1233x0 = 0;

    /* renamed from: y0, reason: collision with root package name */
    public int f1234y0 = 0;
    public boolean z0 = false;
    public int A0 = 0;
    public int B0 = 0;
    public final b.a C0 = new b.a();
    public b.InterfaceC0086b D0 = null;

    @Override // g0.a
    public final void S() {
        for (int i10 = 0; i10 < this.f8945s0; i10++) {
            ConstraintWidget constraintWidget = this.f8944r0[i10];
            if (constraintWidget != null) {
                constraintWidget.G = true;
            }
        }
    }

    public final void U(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i10, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i11) {
        b.InterfaceC0086b interfaceC0086b;
        ConstraintWidget constraintWidget2;
        while (true) {
            interfaceC0086b = this.D0;
            if (interfaceC0086b != null || (constraintWidget2 = this.V) == null) {
                break;
            } else {
                this.D0 = ((d) constraintWidget2).f1199v0;
            }
        }
        b.a aVar = this.C0;
        aVar.f9178a = dimensionBehaviour;
        aVar.f9179b = dimensionBehaviour2;
        aVar.f9180c = i10;
        aVar.f9181d = i11;
        ((ConstraintLayout.b) interfaceC0086b).b(constraintWidget, aVar);
        constraintWidget.O(aVar.f9182e);
        constraintWidget.L(aVar.f9183f);
        constraintWidget.E = aVar.h;
        constraintWidget.I(aVar.f9184g);
    }

    public void T(int i10, int i11, int i12, int i13) {
    }
}
