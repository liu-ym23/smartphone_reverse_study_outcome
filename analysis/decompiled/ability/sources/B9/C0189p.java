package B9;

import java.util.Arrays;

/* renamed from: B9.p, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0189p extends W {

    /* renamed from: a, reason: collision with root package name */
    public double[] f252a;
    public int b;

    @Override // B9.W
    public final Object a() {
        double[] dArrCopyOf = Arrays.copyOf(this.f252a, this.b);
        kotlin.jvm.internal.k.e(dArrCopyOf, "copyOf(...)");
        return dArrCopyOf;
    }

    @Override // B9.W
    public final void b(int i) {
        double[] dArr = this.f252a;
        if (dArr.length < i) {
            int length = dArr.length * 2;
            if (i < length) {
                i = length;
            }
            double[] dArrCopyOf = Arrays.copyOf(dArr, i);
            kotlin.jvm.internal.k.e(dArrCopyOf, "copyOf(...)");
            this.f252a = dArrCopyOf;
        }
    }

    @Override // B9.W
    public final int d() {
        return this.b;
    }
}
