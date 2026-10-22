package tc;

import java.util.Arrays;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class u extends s0<float[]> {

    /* renamed from: a, reason: collision with root package name */
    public float[] f13056a;

    /* renamed from: b, reason: collision with root package name */
    public int f13057b;

    @Override // tc.s0
    public final float[] a() {
        float[] fArrCopyOf = Arrays.copyOf(this.f13056a, this.f13057b);
        kotlin.jvm.internal.g.e(fArrCopyOf, "copyOf(...)");
        return fArrCopyOf;
    }

    @Override // tc.s0
    public final void b(int i10) {
        float[] fArr = this.f13056a;
        if (fArr.length < i10) {
            int length = fArr.length * 2;
            if (i10 < length) {
                i10 = length;
            }
            float[] fArrCopyOf = Arrays.copyOf(fArr, i10);
            kotlin.jvm.internal.g.e(fArrCopyOf, "copyOf(...)");
            this.f13056a = fArrCopyOf;
        }
    }

    @Override // tc.s0
    public final int d() {
        return this.f13057b;
    }
}
