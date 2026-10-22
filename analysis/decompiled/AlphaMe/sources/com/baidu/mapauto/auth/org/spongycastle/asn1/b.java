package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class b extends r {

    /* renamed from: c, reason: collision with root package name */
    public static final char[] f7694c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f7695a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7696b;

    public b(byte[] bArr, int i4) {
        if (bArr == null) {
            throw new NullPointerException("data cannot be null");
        }
        if (bArr.length == 0 && i4 != 0) {
            throw new IllegalArgumentException("zero length data with non-zero pad bits");
        }
        if (i4 > 7 || i4 < 0) {
            throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
        }
        this.f7695a = com.baidu.mapauto.auth.org.spongycastle.util.a.a(bArr);
        this.f7696b = i4;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r rVar) {
        if (!(rVar instanceof b)) {
            return false;
        }
        b bVar = (b) rVar;
        int i4 = this.f7696b;
        if (i4 != bVar.f7696b) {
            return false;
        }
        byte[] bArr = this.f7695a;
        byte[] bArrA = com.baidu.mapauto.auth.org.spongycastle.util.a.a(bArr);
        if (i4 > 0) {
            int length = bArr.length - 1;
            bArrA[length] = (byte) ((255 << i4) & bArrA[length]);
        }
        byte[] bArr2 = bVar.f7695a;
        int i5 = bVar.f7696b;
        byte[] bArrA2 = com.baidu.mapauto.auth.org.spongycastle.util.a.a(bArr2);
        if (i5 > 0) {
            int length2 = bArr2.length - 1;
            bArrA2[length2] = (byte) ((255 << i5) & bArrA2[length2]);
        }
        return com.baidu.mapauto.auth.org.spongycastle.util.a.a(bArrA, bArrA2);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final r g() {
        return new m0(this.f7695a, this.f7696b);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final r h() {
        return new j1(this.f7695a, this.f7696b);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        int i4 = this.f7696b;
        byte[] bArr = this.f7695a;
        byte[] bArrA = com.baidu.mapauto.auth.org.spongycastle.util.a.a(bArr);
        if (i4 > 0) {
            int length = bArr.length - 1;
            bArrA[length] = (byte) (bArrA[length] & (255 << i4));
        }
        return com.baidu.mapauto.auth.org.spongycastle.util.a.b(bArrA) ^ i4;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer("#");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new p(byteArrayOutputStream).a((d) this);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            for (int i4 = 0; i4 != byteArray.length; i4++) {
                char[] cArr = f7694c;
                stringBuffer.append(cArr[(byteArray[i4] >>> 4) & 15]);
                stringBuffer.append(cArr[byteArray[i4] & 15]);
            }
            return stringBuffer.toString();
        } catch (IOException e4) {
            StringBuilder sbA = com.baidu.mapauto.auth.a.a("Internal error encoding BitString: ");
            sbA.append(e4.getMessage());
            throw new q(sbA.toString(), e4);
        }
    }
}
