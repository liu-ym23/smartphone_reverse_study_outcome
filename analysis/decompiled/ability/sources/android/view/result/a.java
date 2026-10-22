package android.view.result;

import S7.k;
import androidx.compose.ui.graphics.colorspace.DoubleFunction;
import androidx.compose.ui.graphics.colorspace.Rgb;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements ActivityResultCallback, DoubleFunction {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1681a;
    public final /* synthetic */ k b;

    public /* synthetic */ a(k kVar, int i) {
        this.f1681a = i;
        this.b = kVar;
    }

    @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
    public double invoke(double d) {
        int i = this.f1681a;
        k kVar = this.b;
        switch (i) {
            case 2:
                return Rgb._init_$lambda$2(kVar, d);
            case 3:
                return Rgb._init_$lambda$3(kVar, d);
            case 4:
                return Rgb._init_$lambda$4(kVar, d);
            default:
                return Rgb._init_$lambda$5(kVar, d);
        }
    }

    @Override // android.view.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        int i = this.f1681a;
        k kVar = this.b;
        switch (i) {
            case 0:
                kVar.invoke(obj);
                break;
            default:
                kVar.invoke(obj);
                break;
        }
    }
}
