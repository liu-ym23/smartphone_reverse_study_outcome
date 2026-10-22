package B9;

import java.util.Arrays;

/* renamed from: B9.l, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0185l extends W {

    /* renamed from: a, reason: collision with root package name */
    public char[] f246a;
    public int b;

    @Override // B9.W
    public final Object a() {
        char[] cArrCopyOf = Arrays.copyOf(this.f246a, this.b);
        kotlin.jvm.internal.k.e(cArrCopyOf, "copyOf(...)");
        return cArrCopyOf;
    }

    @Override // B9.W
    public final void b(int i) {
        char[] cArr = this.f246a;
        if (cArr.length < i) {
            int length = cArr.length * 2;
            if (i < length) {
                i = length;
            }
            char[] cArrCopyOf = Arrays.copyOf(cArr, i);
            kotlin.jvm.internal.k.e(cArrCopyOf, "copyOf(...)");
            this.f246a = cArrCopyOf;
        }
    }

    @Override // B9.W
    public final int d() {
        return this.b;
    }
}
