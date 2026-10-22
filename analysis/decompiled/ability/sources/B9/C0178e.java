package B9;

import java.util.Arrays;

/* renamed from: B9.e, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0178e extends W {

    /* renamed from: a, reason: collision with root package name */
    public boolean[] f237a;
    public int b;

    @Override // B9.W
    public final Object a() {
        boolean[] zArrCopyOf = Arrays.copyOf(this.f237a, this.b);
        kotlin.jvm.internal.k.e(zArrCopyOf, "copyOf(...)");
        return zArrCopyOf;
    }

    @Override // B9.W
    public final void b(int i) {
        boolean[] zArr = this.f237a;
        if (zArr.length < i) {
            int length = zArr.length * 2;
            if (i < length) {
                i = length;
            }
            boolean[] zArrCopyOf = Arrays.copyOf(zArr, i);
            kotlin.jvm.internal.k.e(zArrCopyOf, "copyOf(...)");
            this.f237a = zArrCopyOf;
        }
    }

    @Override // B9.W
    public final int d() {
        return this.b;
    }
}
