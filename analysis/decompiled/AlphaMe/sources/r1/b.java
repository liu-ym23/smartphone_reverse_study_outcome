package r1;

import android.graphics.Typeface;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.i;
import com.google.android.material.internal.j;
import f1.AbstractC0557a;

/* loaded from: classes.dex */
public final class b extends AbstractC0557a {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f14007i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f14008j;

    public /* synthetic */ b(int i4, Object obj) {
        this.f14007i = i4;
        this.f14008j = obj;
    }

    @Override // f1.AbstractC0557a
    public final void O(int i4) {
        switch (this.f14007i) {
            case 0:
                break;
            default:
                j jVar = (j) this.f14008j;
                jVar.f10856d = true;
                i iVar = (i) jVar.f10857e.get();
                if (iVar != null) {
                    f fVar = (f) iVar;
                    fVar.B();
                    fVar.invalidateSelf();
                    break;
                }
                break;
        }
    }

    @Override // f1.AbstractC0557a
    public final void P(Typeface typeface, boolean z4) {
        int i4 = this.f14007i;
        Object obj = this.f14008j;
        switch (i4) {
            case 0:
                Chip chip = (Chip) obj;
                f fVar = chip.f10574e;
                chip.setText(fVar.f14052X0 ? fVar.f14035O : chip.getText());
                chip.requestLayout();
                chip.invalidate();
                break;
            default:
                if (!z4) {
                    j jVar = (j) obj;
                    jVar.f10856d = true;
                    i iVar = (i) jVar.f10857e.get();
                    if (iVar != null) {
                        f fVar2 = (f) iVar;
                        fVar2.B();
                        fVar2.invalidateSelf();
                        break;
                    }
                }
                break;
        }
    }
}
