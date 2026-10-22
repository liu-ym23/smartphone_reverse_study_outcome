package tc;

import java.util.Arrays;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a0 extends s0<int[]> {

    /* renamed from: a, reason: collision with root package name */
    public int[] f12959a;

    /* renamed from: b, reason: collision with root package name */
    public int f12960b;

    @Override // tc.s0
    public final int[] a() {
        int[] iArrCopyOf = Arrays.copyOf(this.f12959a, this.f12960b);
        kotlin.jvm.internal.g.e(iArrCopyOf, "copyOf(...)");
        return iArrCopyOf;
    }

    @Override // tc.s0
    public final void b(int i10) {
        int[] iArr = this.f12959a;
        if (iArr.length < i10) {
            int length = iArr.length * 2;
            if (i10 < length) {
                i10 = length;
            }
            int[] iArrCopyOf = Arrays.copyOf(iArr, i10);
            kotlin.jvm.internal.g.e(iArrCopyOf, "copyOf(...)");
            this.f12959a = iArrCopyOf;
        }
    }

    @Override // tc.s0
    public final int d() {
        return this.f12960b;
    }
}
