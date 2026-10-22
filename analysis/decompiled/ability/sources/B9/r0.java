package B9;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class r0 extends W {

    /* renamed from: a, reason: collision with root package name */
    public short[] f255a;
    public int b;

    @Override // B9.W
    public final Object a() {
        short[] sArrCopyOf = Arrays.copyOf(this.f255a, this.b);
        kotlin.jvm.internal.k.e(sArrCopyOf, "copyOf(...)");
        return new C7.q(sArrCopyOf);
    }

    @Override // B9.W
    public final void b(int i) {
        short[] sArr = this.f255a;
        if (sArr.length < i) {
            int length = sArr.length * 2;
            if (i < length) {
                i = length;
            }
            short[] sArrCopyOf = Arrays.copyOf(sArr, i);
            kotlin.jvm.internal.k.e(sArrCopyOf, "copyOf(...)");
            this.f255a = sArrCopyOf;
        }
    }

    @Override // B9.W
    public final int d() {
        return this.b;
    }
}
