package com.stepos.ailauncher.sheet;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0010R\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0010R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/sheet/w0;", "", "", "stiffness", "", "dampingRatio", "startValue", "endValue", "startVelocity", "<init>", "(FDFFF)V", "", "timeMs", "Lkotlin/Pair;", Const.INTENT_KEY_APIKEY, "(J)Lkotlin/Pair;", "D", "F", "naturalFreq", "lastDisplacement", "lastVelocity", "gammaPlus", "gammaMinus", "dampedFreq", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class w0 {
    private final double dampedFreq;
    private final double dampingRatio;
    private final float endValue;
    private final double gammaMinus;
    private final double gammaPlus;
    private final double lastDisplacement;
    private final double lastVelocity;
    private final double naturalFreq;

    public w0(float f10, double d10, float f11, float f12, float f13) {
        this.dampingRatio = d10;
        this.endValue = f12;
        double dSqrt = Math.sqrt(f10);
        this.naturalFreq = dSqrt;
        this.lastDisplacement = f11 - f12;
        this.lastVelocity = f13;
        if (d10 > 1.0d) {
            double dSqrt2 = Math.sqrt((d10 * d10) - 1.0d) * dSqrt;
            this.gammaPlus = ((-d10) * dSqrt) + dSqrt2;
            this.gammaMinus = ((-d10) * dSqrt) - dSqrt2;
            this.dampedFreq = 0.0d;
            return;
        }
        if (d10 < 0.0d || d10 >= 1.0d) {
            this.gammaPlus = 0.0d;
            this.gammaMinus = 0.0d;
            this.dampedFreq = 0.0d;
        } else {
            this.gammaPlus = 0.0d;
            this.gammaMinus = 0.0d;
            this.dampedFreq = dSqrt * Math.sqrt(1.0d - (d10 * d10));
        }
    }

    public final Pair<Float, Float> a(long timeMs) {
        double dExp;
        double dExp2;
        double d10 = timeMs / 1000.0d;
        double d11 = this.dampingRatio;
        if (d11 > 1.0d) {
            double d12 = this.lastDisplacement;
            double d13 = this.gammaMinus;
            double d14 = this.lastVelocity;
            double d15 = this.gammaPlus;
            double d16 = d12 - (((d13 * d12) - d14) / (d13 - d15));
            double d17 = ((d12 * d13) - d14) / (d13 - d15);
            dExp = (Math.exp(d13 * d10) * d16) + (Math.exp(this.gammaPlus * d10) * d17);
            double d18 = this.gammaMinus;
            double dExp3 = d16 * d18 * Math.exp(d18 * d10);
            double d19 = this.gammaPlus;
            dExp2 = dExp3 + (d17 * d19 * Math.exp(d19 * d10));
        } else if (d11 == 1.0d) {
            double d20 = this.lastVelocity;
            double d21 = this.naturalFreq;
            double d22 = d20 + (this.lastDisplacement * d21);
            double dExp4 = Math.exp((-d21) * d10);
            double d23 = (this.lastDisplacement + (d10 * d22)) * dExp4;
            dExp2 = ((-this.naturalFreq) * d23) + (d22 * dExp4);
            dExp = d23;
        } else {
            double d24 = 1.0d / this.dampedFreq;
            double d25 = this.naturalFreq;
            double d26 = d24 * ((d11 * d25 * this.lastDisplacement) + this.lastVelocity);
            double dExp5 = Math.exp((-d11) * d25 * d10);
            double dCos = ((this.lastDisplacement * Math.cos(this.dampedFreq * d10)) + (Math.sin(this.dampedFreq * d10) * d26)) * dExp5;
            double d27 = (-this.naturalFreq) * dCos * this.dampingRatio;
            double d28 = this.dampedFreq;
            double dSin = (-d28) * this.lastDisplacement * Math.sin(d28 * d10);
            double d29 = this.dampedFreq;
            double dCos2 = d27 + (dExp5 * (dSin + (d26 * d29 * Math.cos(d29 * d10))));
            dExp = dCos;
            dExp2 = dCos2;
        }
        return Y8.j.a(Float.valueOf((float) (dExp + this.endValue)), Float.valueOf((float) dExp2));
    }
}
