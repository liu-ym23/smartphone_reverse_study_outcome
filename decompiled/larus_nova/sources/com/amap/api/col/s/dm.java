package com.amap.api.col.s;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/* JADX INFO: loaded from: classes28.dex */
public final class dm extends dn {
    public dm() {
    }

    public dm(dn r100) {
        super(r100);
    }

    @Override // com.amap.api.col.s.dn
    public final byte[] a(byte[] r100) {
        StringBuffer r101 = new StringBuffer();
        r101.append(new SimpleDateFormat("yyyyMMdd HHmmss").format(new Date()));
        r101.append(" ");
        r101.append(UUID.randomUUID().toString());
        r101.append(" ");
        if (r101.length() != 53) goto L5;
        byte[] r102 = bs.a(r101.toString());
        byte[] r103 = new byte[r102.length + r100.length];
        System.arraycopy(r102, 0, r103, 0, r102.length);
        System.arraycopy(r100, 0, r103, r102.length, r100.length);
        return r103;
    L5:
        return new byte[0];
    }
}
