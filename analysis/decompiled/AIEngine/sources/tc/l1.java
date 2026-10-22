package tc;

import java.util.Arrays;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class l1 extends s0<lb.m> {

    /* renamed from: a, reason: collision with root package name */
    public short[] f13010a;

    /* renamed from: b, reason: collision with root package name */
    public int f13011b;

    @Override // tc.s0
    public final lb.m a() {
        short[] sArrCopyOf = Arrays.copyOf(this.f13010a, this.f13011b);
        kotlin.jvm.internal.g.e(sArrCopyOf, "copyOf(...)");
        return new lb.m(sArrCopyOf);
    }

    @Override // tc.s0
    public final void b(int i10) {
        short[] sArr = this.f13010a;
        if (sArr.length < i10) {
            int length = sArr.length * 2;
            if (i10 < length) {
                i10 = length;
            }
            short[] sArrCopyOf = Arrays.copyOf(sArr, i10);
            kotlin.jvm.internal.g.e(sArrCopyOf, "copyOf(...)");
            this.f13010a = sArrCopyOf;
        }
    }

    @Override // tc.s0
    public final int d() {
        return this.f13011b;
    }
}
