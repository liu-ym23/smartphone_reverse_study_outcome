package com.amap.api.col.jmsl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/* renamed from: com.amap.api.col.jmsl.m0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1579m0 extends AbstractC1614v0 {
    public C1579m0(AbstractC1614v0 abstractC1614v0) {
        super(abstractC1614v0);
    }

    @Override // com.amap.api.col.jmsl.AbstractC1614v0
    public byte[] c(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(new SimpleDateFormat("yyyyMMdd HHmmss").format(new Date()));
        stringBuffer.append(" ");
        stringBuffer.append(UUID.randomUUID().toString());
        stringBuffer.append(" ");
        if (stringBuffer.length() != 53) {
            return new byte[0];
        }
        byte[] bArrT = C1604s2.t(stringBuffer.toString());
        byte[] bArr2 = new byte[bArrT.length + bArr.length];
        System.arraycopy(bArrT, 0, bArr2, 0, bArrT.length);
        System.arraycopy(bArr, 0, bArr2, bArrT.length, bArr.length);
        return bArr2;
    }
}
