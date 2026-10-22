package com.baidu.mapauto.auth.org.spongycastle.util.encoders;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f7801a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f7802b = new byte[128];

    public e() {
        a();
    }

    public final void a() {
        int i4 = 0;
        int i5 = 0;
        while (true) {
            byte[] bArr = this.f7802b;
            if (i5 >= bArr.length) {
                break;
            }
            bArr[i5] = -1;
            i5++;
        }
        while (true) {
            byte[] bArr2 = this.f7801a;
            if (i4 >= bArr2.length) {
                byte[] bArr3 = this.f7802b;
                bArr3[65] = bArr3[97];
                bArr3[66] = bArr3[98];
                bArr3[67] = bArr3[99];
                bArr3[68] = bArr3[100];
                bArr3[69] = bArr3[101];
                bArr3[70] = bArr3[102];
                return;
            }
            this.f7802b[bArr2[i4]] = (byte) i4;
            i4++;
        }
    }
}
