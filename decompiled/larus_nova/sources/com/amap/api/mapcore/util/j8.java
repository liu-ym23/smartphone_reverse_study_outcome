package com.amap.api.mapcore.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes28.dex */
public class j8 extends p8 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ByteArrayOutputStream f27464c;

    public j8(p8 r100) {
        super(r100);
        this.f27464c = new ByteArrayOutputStream();
    }

    @Override // com.amap.api.mapcore.util.p8
    public void a(byte[] r100) {
        this.f27464c.write(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.amap.api.mapcore.util.p8
    public byte[] b(byte[] r100) {
        byte[] r101 = this.f27464c.toByteArray();
        this.f27464c.close();     // Catch: IOException -> L5
    L7:
        this.f27464c = new ByteArrayOutputStream();
        return r101;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }
}
