package com.baidu.mapauto.auth.org.spongycastle.asn1;

import com.alibaba.fastjson.util.UTF8Decoder;
import java.io.IOException;
import kotlin.UByte;

/* loaded from: classes.dex */
public final class f1 extends r {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f7713a;

    public f1(byte[] bArr) {
        this.f7713a = bArr;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        pVar.a(this.f7713a, 12);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() throws IOException {
        return u1.a(this.f7713a.length) + 1 + this.f7713a.length;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        return com.baidu.mapauto.auth.org.spongycastle.util.a.b(this.f7713a);
    }

    public final String toString() {
        char c4;
        byte[] bArr = this.f7713a;
        int i4 = com.baidu.mapauto.auth.org.spongycastle.util.d.f7795a;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i6 < bArr.length) {
            int i8 = i7 + 1;
            byte b4 = bArr[i6];
            if ((b4 & 240) == 240) {
                i7 += 2;
                i6 += 4;
            } else {
                i6 = (b4 & 224) == 224 ? i6 + 3 : (b4 & 192) == 192 ? i6 + 2 : i6 + 1;
                i7 = i8;
            }
        }
        char[] cArr = new char[i7];
        int i9 = 0;
        while (i5 < bArr.length) {
            byte b5 = bArr[i5];
            if ((b5 & 240) == 240) {
                int i10 = (((((b5 & 3) << 18) | ((bArr[i5 + 1] & 63) << 12)) | ((bArr[i5 + 2] & 63) << 6)) | (bArr[i5 + 3] & 63)) - UTF8Decoder.Surrogate.UCS4_MIN;
                char c5 = (char) ((i10 >> 10) | 55296);
                c4 = (char) ((i10 & 1023) | 56320);
                cArr[i9] = c5;
                i5 += 4;
                i9++;
            } else if ((b5 & 224) == 224) {
                c4 = (char) (((b5 & 15) << 12) | ((bArr[i5 + 1] & 63) << 6) | (bArr[i5 + 2] & 63));
                i5 += 3;
            } else if ((b5 & 208) == 208 || (b5 & 192) == 192) {
                int i11 = (b5 & 31) << 6;
                byte b6 = bArr[i5 + 1];
                c4 = (char) (i11 | (b6 & 63));
                i5 += 2;
            } else {
                c4 = (char) (b5 & UByte.MAX_VALUE);
                i5++;
            }
            cArr[i9] = c4;
            i9++;
        }
        return new String(cArr);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r rVar) {
        if (rVar instanceof f1) {
            return com.baidu.mapauto.auth.org.spongycastle.util.a.a(this.f7713a, ((f1) rVar).f7713a);
        }
        return false;
    }
}
