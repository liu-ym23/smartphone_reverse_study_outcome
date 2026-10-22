package tc;

import java.util.Arrays;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class l extends s0<char[]> {

    /* renamed from: a, reason: collision with root package name */
    public char[] f13005a;

    /* renamed from: b, reason: collision with root package name */
    public int f13006b;

    @Override // tc.s0
    public final char[] a() {
        char[] cArrCopyOf = Arrays.copyOf(this.f13005a, this.f13006b);
        kotlin.jvm.internal.g.e(cArrCopyOf, "copyOf(...)");
        return cArrCopyOf;
    }

    @Override // tc.s0
    public final void b(int i10) {
        char[] cArr = this.f13005a;
        if (cArr.length < i10) {
            int length = cArr.length * 2;
            if (i10 < length) {
                i10 = length;
            }
            char[] cArrCopyOf = Arrays.copyOf(cArr, i10);
            kotlin.jvm.internal.g.e(cArrCopyOf, "copyOf(...)");
            this.f13005a = cArrCopyOf;
        }
    }

    @Override // tc.s0
    public final int d() {
        return this.f13006b;
    }
}
