package tc;

import java.util.Arrays;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class p extends s0<double[]> {

    /* renamed from: a, reason: collision with root package name */
    public double[] f13028a;

    /* renamed from: b, reason: collision with root package name */
    public int f13029b;

    @Override // tc.s0
    public final double[] a() {
        double[] dArrCopyOf = Arrays.copyOf(this.f13028a, this.f13029b);
        kotlin.jvm.internal.g.e(dArrCopyOf, "copyOf(...)");
        return dArrCopyOf;
    }

    @Override // tc.s0
    public final void b(int i10) {
        double[] dArr = this.f13028a;
        if (dArr.length < i10) {
            int length = dArr.length * 2;
            if (i10 < length) {
                i10 = length;
            }
            double[] dArrCopyOf = Arrays.copyOf(dArr, i10);
            kotlin.jvm.internal.g.e(dArrCopyOf, "copyOf(...)");
            this.f13028a = dArrCopyOf;
        }
    }

    @Override // tc.s0
    public final int d() {
        return this.f13029b;
    }
}
