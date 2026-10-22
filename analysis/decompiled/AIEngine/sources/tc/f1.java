package tc;

import java.util.Arrays;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f1 extends s0<lb.h> {

    /* renamed from: a, reason: collision with root package name */
    public int[] f12979a;

    /* renamed from: b, reason: collision with root package name */
    public int f12980b;

    @Override // tc.s0
    public final lb.h a() {
        int[] iArrCopyOf = Arrays.copyOf(this.f12979a, this.f12980b);
        kotlin.jvm.internal.g.e(iArrCopyOf, "copyOf(...)");
        return new lb.h(iArrCopyOf);
    }

    @Override // tc.s0
    public final void b(int i10) {
        int[] iArr = this.f12979a;
        if (iArr.length < i10) {
            int length = iArr.length * 2;
            if (i10 < length) {
                i10 = length;
            }
            int[] iArrCopyOf = Arrays.copyOf(iArr, i10);
            kotlin.jvm.internal.g.e(iArrCopyOf, "copyOf(...)");
            this.f12979a = iArrCopyOf;
        }
    }

    @Override // tc.s0
    public final int d() {
        return this.f12980b;
    }
}
