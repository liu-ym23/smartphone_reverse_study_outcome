package B9;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class i0 extends W {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f243a;
    public int b;

    @Override // B9.W
    public final Object a() {
        byte[] bArrCopyOf = Arrays.copyOf(this.f243a, this.b);
        kotlin.jvm.internal.k.e(bArrCopyOf, "copyOf(...)");
        return new C7.j(bArrCopyOf);
    }

    @Override // B9.W
    public final void b(int i) {
        byte[] bArr = this.f243a;
        if (bArr.length < i) {
            int length = bArr.length * 2;
            if (i < length) {
                i = length;
            }
            byte[] bArrCopyOf = Arrays.copyOf(bArr, i);
            kotlin.jvm.internal.k.e(bArrCopyOf, "copyOf(...)");
            this.f243a = bArrCopyOf;
        }
    }

    @Override // B9.W
    public final int d() {
        return this.b;
    }
}
