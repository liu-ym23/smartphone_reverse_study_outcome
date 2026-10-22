package tc;

import java.util.Arrays;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c1 extends s0<lb.f> {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f12968a;

    /* renamed from: b, reason: collision with root package name */
    public int f12969b;

    @Override // tc.s0
    public final lb.f a() {
        byte[] bArrCopyOf = Arrays.copyOf(this.f12968a, this.f12969b);
        kotlin.jvm.internal.g.e(bArrCopyOf, "copyOf(...)");
        return new lb.f(bArrCopyOf);
    }

    @Override // tc.s0
    public final void b(int i10) {
        byte[] bArr = this.f12968a;
        if (bArr.length < i10) {
            int length = bArr.length * 2;
            if (i10 < length) {
                i10 = length;
            }
            byte[] bArrCopyOf = Arrays.copyOf(bArr, i10);
            kotlin.jvm.internal.g.e(bArrCopyOf, "copyOf(...)");
            this.f12968a = bArrCopyOf;
        }
    }

    @Override // tc.s0
    public final int d() {
        return this.f12969b;
    }
}
