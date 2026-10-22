package l1;

import android.graphics.Typeface;
import com.google.android.material.chip.Chip;
import k4.z;
import p1.h;
import p1.i;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b extends z {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3734b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3735c;

    public /* synthetic */ b(int i8, Object obj) {
        this.f3734b = i8;
        this.f3735c = obj;
    }

    @Override // k4.z
    public final void A(Typeface typeface, boolean z) {
        switch (this.f3734b) {
            case 0:
                Chip chip = (Chip) this.f3735c;
                f fVar = chip.f1291e;
                chip.setText(fVar.J0 ? fVar.L : chip.getText());
                chip.requestLayout();
                chip.invalidate();
                break;
            default:
                if (!z) {
                    i iVar = (i) this.f3735c;
                    iVar.d = true;
                    h hVar = (h) iVar.f4719e.get();
                    if (hVar != null) {
                        f fVar2 = (f) hVar;
                        fVar2.z();
                        fVar2.invalidateSelf();
                        break;
                    }
                }
                break;
        }
    }

    @Override // k4.z
    public final void z(int i8) {
        switch (this.f3734b) {
            case 0:
                break;
            default:
                i iVar = (i) this.f3735c;
                iVar.d = true;
                h hVar = (h) iVar.f4719e.get();
                if (hVar != null) {
                    f fVar = (f) hVar;
                    fVar.z();
                    fVar.invalidateSelf();
                    break;
                }
                break;
        }
    }

    private final void L(int i8) {
    }
}
