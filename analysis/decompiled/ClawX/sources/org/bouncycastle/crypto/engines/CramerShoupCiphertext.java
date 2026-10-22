package org.bouncycastle.crypto.engines;

import java.math.BigInteger;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public class CramerShoupCiphertext {

    /* renamed from: e, reason: collision with root package name */
    BigInteger f4453e;

    /* renamed from: u1, reason: collision with root package name */
    BigInteger f4454u1;

    /* renamed from: u2, reason: collision with root package name */
    BigInteger f4455u2;

    /* renamed from: v, reason: collision with root package name */
    BigInteger f4456v;

    public CramerShoupCiphertext() {
    }

    public BigInteger getE() {
        return this.f4453e;
    }

    public BigInteger getU1() {
        return this.f4454u1;
    }

    public BigInteger getU2() {
        return this.f4455u2;
    }

    public BigInteger getV() {
        return this.f4456v;
    }

    public void setE(BigInteger bigInteger) {
        this.f4453e = bigInteger;
    }

    public void setU1(BigInteger bigInteger) {
        this.f4454u1 = bigInteger;
    }

    public void setU2(BigInteger bigInteger) {
        this.f4455u2 = bigInteger;
    }

    public void setV(BigInteger bigInteger) {
        this.f4456v = bigInteger;
    }

    public byte[] toByteArray() {
        byte[] byteArray = this.f4454u1.toByteArray();
        int length = byteArray.length;
        byte[] byteArray2 = this.f4455u2.toByteArray();
        int length2 = byteArray2.length;
        byte[] byteArray3 = this.f4453e.toByteArray();
        int length3 = byteArray3.length;
        byte[] byteArray4 = this.f4456v.toByteArray();
        int length4 = byteArray4.length;
        byte[] bArr = new byte[length + length2 + length3 + length4 + 16];
        Pack.intToBigEndian(length, bArr, 0);
        System.arraycopy(byteArray, 0, bArr, 4, length);
        Pack.intToBigEndian(length2, bArr, 4 + length);
        int i8 = length + 8;
        System.arraycopy(byteArray2, 0, bArr, i8, length2);
        int i9 = i8 + length2;
        Pack.intToBigEndian(length3, bArr, i9);
        int i10 = i9 + 4;
        System.arraycopy(byteArray3, 0, bArr, i10, length3);
        int i11 = i10 + length3;
        Pack.intToBigEndian(length4, bArr, i11);
        System.arraycopy(byteArray4, 0, bArr, i11 + 4, length4);
        return bArr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("u1: " + this.f4454u1.toString());
        sb.append("\nu2: " + this.f4455u2.toString());
        sb.append("\ne: " + this.f4453e.toString());
        sb.append("\nv: " + this.f4456v.toString());
        return sb.toString();
    }

    public CramerShoupCiphertext(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.f4454u1 = bigInteger;
        this.f4455u2 = bigInteger2;
        this.f4453e = bigInteger3;
        this.f4456v = bigInteger4;
    }

    public CramerShoupCiphertext(byte[] bArr) {
        int iBigEndianToInt = Pack.bigEndianToInt(bArr, 0);
        int i8 = 4 + iBigEndianToInt;
        this.f4454u1 = new BigInteger(Arrays.copyOfRange(bArr, 4, i8));
        int i9 = iBigEndianToInt + 8;
        int iBigEndianToInt2 = Pack.bigEndianToInt(bArr, i8) + i9;
        this.f4455u2 = new BigInteger(Arrays.copyOfRange(bArr, i9, iBigEndianToInt2));
        int iBigEndianToInt3 = Pack.bigEndianToInt(bArr, iBigEndianToInt2);
        int i10 = iBigEndianToInt2 + 4;
        int i11 = iBigEndianToInt3 + i10;
        this.f4453e = new BigInteger(Arrays.copyOfRange(bArr, i10, i11));
        int iBigEndianToInt4 = Pack.bigEndianToInt(bArr, i11);
        int i12 = i11 + 4;
        this.f4456v = new BigInteger(Arrays.copyOfRange(bArr, i12, iBigEndianToInt4 + i12));
    }
}
