package com.amap.api.col.s;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes28.dex */
public final class dh extends dn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ByteArrayOutputStream f26570a;

    public dh() {
        this.f26570a = new ByteArrayOutputStream();
    }

    public dh(dn r100) {
        super(r100);
        this.f26570a = new ByteArrayOutputStream();
    }

    @Override // com.amap.api.col.s.dn
    public final byte[] a(byte[] r100) {
        byte[] r101 = this.f26570a.toByteArray();
        this.f26570a.close();     // Catch: IOException -> L5
    L7:
        this.f26570a = new ByteArrayOutputStream();
        return r101;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    @Override // com.amap.api.col.s.dn
    public final void b(byte[] r100) {
        this.f26570a.write(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }
}
