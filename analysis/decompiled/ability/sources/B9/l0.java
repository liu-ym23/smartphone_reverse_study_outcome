package B9;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class l0 extends W {

    /* renamed from: a, reason: collision with root package name */
    public int[] f247a;
    public int b;

    @Override // B9.W
    public final Object a() {
        int[] iArrCopyOf = Arrays.copyOf(this.f247a, this.b);
        kotlin.jvm.internal.k.e(iArrCopyOf, "copyOf(...)");
        return new C7.l(iArrCopyOf);
    }

    @Override // B9.W
    public final void b(int i) {
        int[] iArr = this.f247a;
        if (iArr.length < i) {
            int length = iArr.length * 2;
            if (i < length) {
                i = length;
            }
            int[] iArrCopyOf = Arrays.copyOf(iArr, i);
            kotlin.jvm.internal.k.e(iArrCopyOf, "copyOf(...)");
            this.f247a = iArrCopyOf;
        }
    }

    @Override // B9.W
    public final int d() {
        return this.b;
    }
}
