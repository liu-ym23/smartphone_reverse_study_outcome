package B9;

import java.util.Arrays;

/* renamed from: B9.h, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0181h extends W {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f241a;
    public int b;

    @Override // B9.W
    public final Object a() {
        byte[] bArrCopyOf = Arrays.copyOf(this.f241a, this.b);
        kotlin.jvm.internal.k.e(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    @Override // B9.W
    public final void b(int i) {
        byte[] bArr = this.f241a;
        if (bArr.length < i) {
            int length = bArr.length * 2;
            if (i < length) {
                i = length;
            }
            byte[] bArrCopyOf = Arrays.copyOf(bArr, i);
            kotlin.jvm.internal.k.e(bArrCopyOf, "copyOf(...)");
            this.f241a = bArrCopyOf;
        }
    }

    @Override // B9.W
    public final int d() {
        return this.b;
    }
}
