package J3;

import java.lang.reflect.Array;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final b[] f3705a;

    /* renamed from: b, reason: collision with root package name */
    public int f3706b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3707c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3708d;

    public a(int i10, int i11) {
        b[] bVarArr = new b[i10];
        this.f3705a = bVarArr;
        int length = bVarArr.length;
        for (int i12 = 0; i12 < length; i12++) {
            this.f3705a[i12] = new b(((i11 + 4) * 17) + 1);
        }
        this.f3708d = i11 * 17;
        this.f3707c = i10;
        this.f3706b = -1;
    }

    public b a() {
        return this.f3705a[this.f3706b];
    }

    public byte[][] b(int i10, int i11) {
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, this.f3707c * i11, this.f3708d * i10);
        int i12 = this.f3707c * i11;
        for (int i13 = 0; i13 < i12; i13++) {
            bArr[(i12 - i13) - 1] = this.f3705a[i13 / i11].b(i10);
        }
        return bArr;
    }

    public void c() {
        this.f3706b++;
    }
}
