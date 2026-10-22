package o0;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import p0.g;
import p0.j;

/* renamed from: o0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C4994b extends ConstraintWidget implements InterfaceC4993a {

    /* renamed from: V0, reason: collision with root package name */
    public ConstraintWidget[] f37460V0 = new ConstraintWidget[4];

    /* renamed from: W0, reason: collision with root package name */
    public int f37461W0 = 0;

    @Override // o0.InterfaceC4993a
    public void a(ConstraintWidget constraintWidget) {
        if (constraintWidget == this || constraintWidget == null) {
            return;
        }
        int i10 = this.f37461W0 + 1;
        ConstraintWidget[] constraintWidgetArr = this.f37460V0;
        if (i10 > constraintWidgetArr.length) {
            this.f37460V0 = (ConstraintWidget[]) Arrays.copyOf(constraintWidgetArr, constraintWidgetArr.length * 2);
        }
        ConstraintWidget[] constraintWidgetArr2 = this.f37460V0;
        int i11 = this.f37461W0;
        constraintWidgetArr2[i11] = constraintWidget;
        this.f37461W0 = i11 + 1;
    }

    @Override // o0.InterfaceC4993a
    public void b() {
        this.f37461W0 = 0;
        Arrays.fill(this.f37460V0, (Object) null);
    }

    public void c(d dVar) {
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void n(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> map) {
        super.n(constraintWidget, map);
        C4994b c4994b = (C4994b) constraintWidget;
        this.f37461W0 = 0;
        int i10 = c4994b.f37461W0;
        for (int i11 = 0; i11 < i10; i11++) {
            a(map.get(c4994b.f37460V0[i11]));
        }
    }

    public void w1(ArrayList<j> arrayList, int i10, j jVar) {
        for (int i11 = 0; i11 < this.f37461W0; i11++) {
            jVar.a(this.f37460V0[i11]);
        }
        for (int i12 = 0; i12 < this.f37461W0; i12++) {
            g.a(this.f37460V0[i12], i10, arrayList, jVar);
        }
    }

    public int x1(int i10) {
        int i11;
        int i12;
        for (int i13 = 0; i13 < this.f37461W0; i13++) {
            ConstraintWidget constraintWidget = this.f37460V0[i13];
            if (i10 == 0 && (i12 = constraintWidget.f11969S0) != -1) {
                return i12;
            }
            if (i10 == 1 && (i11 = constraintWidget.f11971T0) != -1) {
                return i11;
            }
        }
        return -1;
    }
}
