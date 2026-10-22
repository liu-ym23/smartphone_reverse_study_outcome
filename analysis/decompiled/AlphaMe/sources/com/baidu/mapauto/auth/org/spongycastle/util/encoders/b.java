package com.baidu.mapauto.auth.org.spongycastle.util.encoders;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f7797a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f7798b = new byte[128];

    public b() {
        a();
    }

    public final void a() {
        int i4 = 0;
        int i5 = 0;
        while (true) {
            byte[] bArr = this.f7798b;
            if (i5 >= bArr.length) {
                break;
            }
            bArr[i5] = -1;
            i5++;
        }
        while (true) {
            byte[] bArr2 = this.f7797a;
            if (i4 >= bArr2.length) {
                return;
            }
            this.f7798b[bArr2[i4]] = (byte) i4;
            i4++;
        }
    }
}
