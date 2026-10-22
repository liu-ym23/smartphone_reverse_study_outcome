package t1;

import com.google.android.material.button.MaterialButton;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class i extends k4.v {

    /* renamed from: a, reason: collision with root package name */
    public final int f5473a;

    public i(int i8) {
        this.f5473a = i8;
    }

    @Override // k4.v
    public final float R(x xVar) {
        float[] fArr = ((j) xVar).A;
        if (fArr != null) {
            return fArr[this.f5473a];
        }
        return 0.0f;
    }

    @Override // k4.v
    public final void l0(x xVar, float f3) {
        j jVar = (j) xVar;
        float[] fArr = jVar.A;
        if (fArr != null) {
            int i8 = this.f5473a;
            if (fArr[i8] != f3) {
                fArr[i8] = f3;
                j1.a aVar = jVar.C;
                if (aVar != null) {
                    float fG = jVar.g();
                    MaterialButton materialButton = (MaterialButton) aVar.f3473a;
                    int i9 = (int) (fG * 0.11f);
                    if (materialButton.y != i9) {
                        materialButton.y = i9;
                        materialButton.j();
                        materialButton.invalidate();
                    }
                }
                jVar.invalidateSelf();
            }
        }
    }
}
