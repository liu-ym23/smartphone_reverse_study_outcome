package org.bouncycastle.asn1.x9;

import java.math.BigInteger;
import p7.h;
import p7.m;

/* loaded from: classes.dex */
public class X9IntegerConverter {
    public int getByteLength(h hVar) {
        return hVar.k();
    }

    public byte[] integerToBytes(BigInteger bigInteger, int i8) {
        byte[] byteArray = bigInteger.toByteArray();
        if (i8 < byteArray.length) {
            byte[] bArr = new byte[i8];
            System.arraycopy(byteArray, byteArray.length - i8, bArr, 0, i8);
            return bArr;
        }
        if (i8 <= byteArray.length) {
            return byteArray;
        }
        byte[] bArr2 = new byte[i8];
        System.arraycopy(byteArray, 0, bArr2, i8 - byteArray.length, byteArray.length);
        return bArr2;
    }

    public int getByteLength(m mVar) {
        return (mVar.f() + 7) / 8;
    }
}
