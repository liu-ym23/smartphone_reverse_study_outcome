package B9;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class o0 extends W {

    /* renamed from: a, reason: collision with root package name */
    public long[] f251a;
    public int b;

    @Override // B9.W
    public final Object a() {
        long[] jArrCopyOf = Arrays.copyOf(this.f251a, this.b);
        kotlin.jvm.internal.k.e(jArrCopyOf, "copyOf(...)");
        return new C7.n(jArrCopyOf);
    }

    @Override // B9.W
    public final void b(int i) {
        long[] jArr = this.f251a;
        if (jArr.length < i) {
            int length = jArr.length * 2;
            if (i < length) {
                i = length;
            }
            long[] jArrCopyOf = Arrays.copyOf(jArr, i);
            kotlin.jvm.internal.k.e(jArrCopyOf, "copyOf(...)");
            this.f251a = jArrCopyOf;
        }
    }

    @Override // B9.W
    public final int d() {
        return this.b;
    }
}
