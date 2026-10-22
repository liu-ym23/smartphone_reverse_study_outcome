package com.autonavi.aps.protocol.aps.common.e;

/* loaded from: classes.dex */
public class c {
    public static byte[] a(byte[] bArr) {
        for (int i10 = 0; i10 < bArr.length / 2; i10++) {
            byte b10 = bArr[(bArr.length - i10) - 1];
            bArr[(bArr.length - i10) - 1] = bArr[i10];
            bArr[i10] = b10;
        }
        return bArr;
    }
}
