package g0;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class b extends ConstraintWidget {

    /* renamed from: r0, reason: collision with root package name */
    public ArrayList<ConstraintWidget> f8946r0 = new ArrayList<>();

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void C() {
        this.f8946r0.clear();
        super.C();
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final void F(e0.a aVar) {
        super.F(aVar);
        int size = this.f8946r0.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f8946r0.get(i10).F(aVar);
        }
    }

    public void R() {
        ArrayList<ConstraintWidget> arrayList = this.f8946r0;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ConstraintWidget constraintWidget = this.f8946r0.get(i10);
            if (constraintWidget instanceof b) {
                ((b) constraintWidget).R();
            }
        }
    }
}
