package V2;

import android.graphics.Typeface;
import c3.AbstractC0877g;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.h;
import com.google.android.material.internal.i;

/* loaded from: classes3.dex */
public final class a extends AbstractC0877g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1302a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(Object obj, int i) {
        this.f1302a = i;
        this.b = obj;
    }

    private final void c(int i) {
    }

    @Override // c3.AbstractC0877g
    public final void a(int i) {
        switch (this.f1302a) {
            case 0:
                break;
            default:
                i iVar = (i) this.b;
                iVar.d = true;
                h hVar = (h) iVar.e.get();
                if (hVar != null) {
                    hVar.a();
                    break;
                }
                break;
        }
    }

    @Override // c3.AbstractC0877g
    public final void b(Typeface typeface, boolean z10) {
        switch (this.f1302a) {
            case 0:
                Chip chip = (Chip) this.b;
                d dVar = chip.f2391a;
                chip.setText(dVar.f1326Q0 ? dVar.f1329S : chip.getText());
                chip.requestLayout();
                chip.invalidate();
                break;
            default:
                if (!z10) {
                    i iVar = (i) this.b;
                    iVar.d = true;
                    h hVar = (h) iVar.e.get();
                    if (hVar != null) {
                        hVar.a();
                        break;
                    }
                }
                break;
        }
    }
}
