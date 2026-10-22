package y1;

import androidx.room.AbstractC0351g;
import com.google.android.material.button.MaterialButton;
import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public final class i extends I.h {

    /* renamed from: c, reason: collision with root package name */
    public final int f16225c;

    public i(int i4) {
        super(AbstractC0351g.m("cornerSizeAtIndex", i4), 1);
        this.f16225c = i4;
    }

    @Override // I.h
    public final float e(Object obj) {
        float[] fArr = ((j) obj).f16230C;
        return fArr != null ? fArr[this.f16225c] : Property.DEFAULT_FLOAT_VALUE;
    }

    @Override // I.h
    public final void g(Object obj, float f4) {
        j jVar = (j) obj;
        float[] fArr = jVar.f16230C;
        if (fArr != null) {
            int i4 = this.f16225c;
            if (fArr[i4] != f4) {
                fArr[i4] = f4;
                androidx.core.app.f fVar = jVar.f16232E;
                if (fVar != null) {
                    float fI = jVar.i();
                    MaterialButton materialButton = (MaterialButton) fVar.f3281a;
                    int i5 = (int) (fI * 0.11f);
                    if (materialButton.f10496x != i5) {
                        materialButton.f10496x = i5;
                        materialButton.k();
                        materialButton.invalidate();
                    }
                }
                jVar.invalidateSelf();
            }
        }
    }
}
