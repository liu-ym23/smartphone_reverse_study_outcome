package g7;

import android.graphics.Color;
import android.view.View;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.invoke.VarHandle;
import stepos.support.v7.app.palette.ColorPickerView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4355c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ int f4356f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f4357g;

    public /* synthetic */ c(int i) {
        this.f4355c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4355c) {
            case 0:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f4357g;
                int i = this.f4356f;
                View view = (View) sideSheetBehavior.f2457p.get();
                if (view != null) {
                    sideSheetBehavior.e(view, i, false);
                    break;
                }
                break;
            default:
                ColorPickerView colorPickerView = (ColorPickerView) this.f4357g;
                int i3 = this.f4356f;
                int i10 = ColorPickerView.f12424u;
                float[] fArr = new float[3];
                Color.colorToHSV(i3, fArr);
                float f5 = fArr[0];
                if (f5 >= 0.0f) {
                    double d7 = f5;
                    colorPickerView.f12428h = (float) ((Math.cos(Math.toRadians(d7)) * colorPickerView.f12429j) + colorPickerView.f12426f);
                    colorPickerView.i = (float) ((Math.sin(Math.toRadians(d7)) * colorPickerView.f12429j) + colorPickerView.f12427g);
                }
                float[] fArr2 = {0.0f, 1.0f, 1.0f};
                Color.colorToHSV(i3, fArr2);
                colorPickerView.f12436q = Color.HSVToColor(fArr2);
                colorPickerView.f12434o.setColor(i3);
                float[] fArr3 = new float[3];
                Color.colorToHSV(i3, fArr3);
                colorPickerView.f12437r = fArr3[1];
                float[] fArr4 = new float[3];
                Color.colorToHSV(i3, fArr4);
                colorPickerView.f12438s = fArr4[2];
                colorPickerView.invalidate();
                ne.c cVar = new ne.c();
                cVar.f8959c = i3;
                VarHandle.storeStoreFence();
                colorPickerView.post(cVar);
                break;
        }
    }
}
