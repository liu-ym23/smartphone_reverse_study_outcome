package g0;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import h0.h;
import h0.k;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class a extends ConstraintWidget {

    /* renamed from: r0, reason: collision with root package name */
    public ConstraintWidget[] f8944r0 = new ConstraintWidget[4];

    /* renamed from: s0, reason: collision with root package name */
    public int f8945s0 = 0;

    public final void R(int i10, k kVar, ArrayList arrayList) {
        for (int i11 = 0; i11 < this.f8945s0; i11++) {
            ConstraintWidget constraintWidget = this.f8944r0[i11];
            ArrayList<ConstraintWidget> arrayList2 = kVar.f9200a;
            if (!arrayList2.contains(constraintWidget)) {
                arrayList2.add(constraintWidget);
            }
        }
        for (int i12 = 0; i12 < this.f8945s0; i12++) {
            h.a(this.f8944r0[i12], i10, arrayList, kVar);
        }
    }

    public void S() {
    }
}
