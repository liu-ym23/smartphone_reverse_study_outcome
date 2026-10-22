package tc;

import java.util.Arrays;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e extends s0<boolean[]> {

    /* renamed from: a, reason: collision with root package name */
    public boolean[] f12972a;

    /* renamed from: b, reason: collision with root package name */
    public int f12973b;

    @Override // tc.s0
    public final boolean[] a() {
        boolean[] zArrCopyOf = Arrays.copyOf(this.f12972a, this.f12973b);
        kotlin.jvm.internal.g.e(zArrCopyOf, "copyOf(...)");
        return zArrCopyOf;
    }

    @Override // tc.s0
    public final void b(int i10) {
        boolean[] zArr = this.f12972a;
        if (zArr.length < i10) {
            int length = zArr.length * 2;
            if (i10 < length) {
                i10 = length;
            }
            boolean[] zArrCopyOf = Arrays.copyOf(zArr, i10);
            kotlin.jvm.internal.g.e(zArrCopyOf, "copyOf(...)");
            this.f12972a = zArrCopyOf;
        }
    }

    @Override // tc.s0
    public final int d() {
        return this.f12973b;
    }
}
