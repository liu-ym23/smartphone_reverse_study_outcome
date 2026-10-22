package tc;

import java.util.Arrays;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g0 extends s0<long[]> {

    /* renamed from: a, reason: collision with root package name */
    public long[] f12983a;

    /* renamed from: b, reason: collision with root package name */
    public int f12984b;

    @Override // tc.s0
    public final long[] a() {
        long[] jArrCopyOf = Arrays.copyOf(this.f12983a, this.f12984b);
        kotlin.jvm.internal.g.e(jArrCopyOf, "copyOf(...)");
        return jArrCopyOf;
    }

    @Override // tc.s0
    public final void b(int i10) {
        long[] jArr = this.f12983a;
        if (jArr.length < i10) {
            int length = jArr.length * 2;
            if (i10 < length) {
                i10 = length;
            }
            long[] jArrCopyOf = Arrays.copyOf(jArr, i10);
            kotlin.jvm.internal.g.e(jArrCopyOf, "copyOf(...)");
            this.f12983a = jArrCopyOf;
        }
    }

    @Override // tc.s0
    public final int d() {
        return this.f12984b;
    }
}
