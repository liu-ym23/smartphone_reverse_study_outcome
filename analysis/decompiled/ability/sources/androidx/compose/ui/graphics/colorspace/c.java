package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.colorspace.Rgb;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements DoubleFunction {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1831a;
    public final /* synthetic */ TransferParameters b;

    public /* synthetic */ c(TransferParameters transferParameters, int i) {
        this.f1831a = i;
        this.b = transferParameters;
    }

    @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
    public final double invoke(double d) {
        int i = this.f1831a;
        TransferParameters transferParameters = this.b;
        switch (i) {
            case 0:
                return Rgb.Companion.generateEotf$lambda$4(transferParameters, d);
            case 1:
                return Rgb.Companion.generateEotf$lambda$5(transferParameters, d);
            case 2:
                return Rgb.Companion.generateEotf$lambda$6(transferParameters, d);
            case 3:
                return Rgb.Companion.generateEotf$lambda$7(transferParameters, d);
            case 4:
                return Rgb.Companion.generateOetf$lambda$0(transferParameters, d);
            case 5:
                return Rgb.Companion.generateOetf$lambda$1(transferParameters, d);
            case 6:
                return Rgb.Companion.generateOetf$lambda$2(transferParameters, d);
            default:
                return Rgb.Companion.generateOetf$lambda$3(transferParameters, d);
        }
    }
}
