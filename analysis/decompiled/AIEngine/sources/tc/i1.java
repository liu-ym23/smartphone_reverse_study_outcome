package tc;

import java.util.Arrays;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i1 extends s0<lb.j> {

    /* renamed from: a, reason: collision with root package name */
    public long[] f12994a;

    /* renamed from: b, reason: collision with root package name */
    public int f12995b;

    @Override // tc.s0
    public final lb.j a() {
        long[] jArrCopyOf = Arrays.copyOf(this.f12994a, this.f12995b);
        kotlin.jvm.internal.g.e(jArrCopyOf, "copyOf(...)");
        return new lb.j(jArrCopyOf);
    }

    @Override // tc.s0
    public final void b(int i10) {
        long[] jArr = this.f12994a;
        if (jArr.length < i10) {
            int length = jArr.length * 2;
            if (i10 < length) {
                i10 = length;
            }
            long[] jArrCopyOf = Arrays.copyOf(jArr, i10);
            kotlin.jvm.internal.g.e(jArrCopyOf, "copyOf(...)");
            this.f12994a = jArrCopyOf;
        }
    }

    @Override // tc.s0
    public final int d() {
        return this.f12995b;
    }
}
