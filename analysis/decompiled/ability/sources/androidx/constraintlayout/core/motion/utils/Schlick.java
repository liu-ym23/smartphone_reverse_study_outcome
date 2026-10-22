package androidx.constraintlayout.core.motion.utils;

/* loaded from: classes2.dex */
public class Schlick extends Easing {
    private static final boolean DEBUG = false;
    double mEps;
    double mS;
    double mT;

    public Schlick(String str) {
        this.mStr = str;
        int iIndexOf = str.indexOf(40);
        int iIndexOf2 = str.indexOf(44, iIndexOf);
        this.mS = Double.parseDouble(str.substring(iIndexOf + 1, iIndexOf2).trim());
        int i = iIndexOf2 + 1;
        this.mT = Double.parseDouble(str.substring(i, str.indexOf(44, i)).trim());
    }

    private double dfunc(double d) {
        double d6 = this.mT;
        if (d < d6) {
            double d10 = this.mS;
            return ((d10 * d6) * d6) / ((((d6 - d) * d10) + d) * (((d6 - d) * d10) + d));
        }
        double d11 = this.mS;
        return ((d6 - 1.0d) * ((d6 - 1.0d) * d11)) / (((((d6 - d) * (-d11)) - d) + 1.0d) * ((((d6 - d) * (-d11)) - d) + 1.0d));
    }

    private double func(double d) {
        double d6 = this.mT;
        if (d < d6) {
            return (d6 * d) / (((d6 - d) * this.mS) + d);
        }
        return ((d - 1.0d) * (1.0d - d6)) / ((1.0d - d) - ((d6 - d) * this.mS));
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double get(double d) {
        return func(d);
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double getDiff(double d) {
        return dfunc(d);
    }
}
