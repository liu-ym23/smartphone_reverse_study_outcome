package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes39.dex */
public final class c0 implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f31826a;

    public c0(v r100) {
        this.f31826a = r100;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.o
    public final InputStream b() {
        return new j0(this.f31826a);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p1
    public final r a() throws IOException {
        InputStream r100 = b();
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        byte[] r102 = new byte[4096];
    L3:
        int r103 = r100.read(r102, 0, 4096);
        if (r103 < 0) goto L7;
        r101.write(r102, 0, r103);
        goto L3
    L7:
        return new b0(r101.toByteArray());
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.d
    public final r c() {
        return a();
    L4:
        e = move-exception;
        StringBuilder r100 = com.baidu.mapauto.auth.b.a("IOException converting stream to byte array: ");
        r100.append(e.getMessage());
        throw new q(r100.toString(), e);
    }
}
