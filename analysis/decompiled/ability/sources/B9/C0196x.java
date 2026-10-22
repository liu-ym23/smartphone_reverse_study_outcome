package B9;

import java.util.Arrays;

/* renamed from: B9.x, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0196x extends W {

    /* renamed from: a, reason: collision with root package name */
    public float[] f263a;
    public int b;

    @Override // B9.W
    public final Object a() {
        float[] fArrCopyOf = Arrays.copyOf(this.f263a, this.b);
        kotlin.jvm.internal.k.e(fArrCopyOf, "copyOf(...)");
        return fArrCopyOf;
    }

    @Override // B9.W
    public final void b(int i) {
        float[] fArr = this.f263a;
        if (fArr.length < i) {
            int length = fArr.length * 2;
            if (i < length) {
                i = length;
            }
            float[] fArrCopyOf = Arrays.copyOf(fArr, i);
            kotlin.jvm.internal.k.e(fArrCopyOf, "copyOf(...)");
            this.f263a = fArrCopyOf;
        }
    }

    @Override // B9.W
    public final int d() {
        return this.b;
    }
}
