package e3;

import androidx.dynamicanimation.animation.FloatPropertyCompat;
import com.google.android.material.button.MaterialButton;

/* renamed from: e3.j, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1421j extends FloatPropertyCompat {

    /* renamed from: a, reason: collision with root package name */
    public final int f4349a;

    public C1421j(int i) {
        super(B7.a.h(i, "cornerSizeAtIndex"));
        this.f4349a = i;
    }

    @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
    public final float getValue(Object obj) {
        float[] fArr = ((k) obj).f4354C;
        if (fArr != null) {
            return fArr[this.f4349a];
        }
        return 0.0f;
    }

    @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
    public final void setValue(Object obj, float f) {
        k kVar = (k) obj;
        float[] fArr = kVar.f4354C;
        if (fArr != null) {
            int i = this.f4349a;
            if (fArr[i] != f) {
                fArr[i] = f;
                InterfaceC1420i interfaceC1420i = kVar.E;
                if (interfaceC1420i != null) {
                    float fI = kVar.i();
                    MaterialButton materialButton = (MaterialButton) ((B5.a) interfaceC1420i).b;
                    int i6 = (int) (fI * 0.11f);
                    if (materialButton.u != i6) {
                        materialButton.u = i6;
                        materialButton.j();
                        materialButton.invalidate();
                    }
                }
                kVar.invalidateSelf();
            }
        }
    }
}
