package bv5;

/* JADX INFO: loaded from: classes19.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f20892a = 0;

    static {
    }

    public static double[] a(double r100, double r110, double r111) {
        double r101 = Math.sin(r100);
        double r102 = Math.cos(r100);
        double r103 = Math.sin(r110);
        double r112 = Math.cos(r110);
        double r104 = 6378137.0d / Math.sqrt(1.0d - ((0.0066943799901413165d * r101) * r101));
        double r105 = (r104 + r111) * r102;
        return new double[]{r112 * r105, r105 * r103, ((r104 * 0.9933056200098587d) + r111) * r101};
    }
}
