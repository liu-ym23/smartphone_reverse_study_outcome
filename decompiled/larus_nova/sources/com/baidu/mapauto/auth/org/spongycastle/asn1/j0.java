package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes39.dex */
public final class j0 extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f31848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f31849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InputStream f31850c;

    public j0(v r100) {
        this.f31849b = true;
        this.f31848a = r100;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (this.f31850c != null) goto L11;
        if (this.f31849b == true) goto L7;
        return -1;
    L7:
        o r100 = (o) this.f31848a.a();
        if (r100 != null) goto L10;
        return -1;
    L10:
        this.f31849b = false;
        this.f31850c = r100.b();
    L11:
        int r101 = this.f31850c.read();
        if (r101 >= 0) goto L13;
        o r102 = (o) this.f31848a.a();
        if (r102 == null) goto L16;
        this.f31850c = r102.b();
        goto L11
    L16:
        this.f31850c = null;
        return -1;
    L13:
        return r101;
    }

    @Override // java.io.InputStream
    public final int read(byte[] r100, int r101, int r102) throws IOException {
        int r103 = 0;
        if (this.f31850c != null) goto L11;
        if (this.f31849b == true) goto L7;
        return -1;
    L7:
        o r104 = (o) this.f31848a.a();
        if (r104 != null) goto L10;
        return -1;
    L10:
        this.f31849b = false;
        this.f31850c = r104.b();
    L11:
        int r105 = this.f31850c.read(r100, r101 + r103, r102 - r103);
        if (r105 >= 0) goto L13;
        o r106 = (o) this.f31848a.a();
        if (r106 == null) goto L18;
        this.f31850c = r106.b();
        goto L11
    L18:
        this.f31850c = null;
        if (r103 >= 1) goto L22;
        return -1;
    L22:
        return r103;
    L13:
        r103 = r103 + r105;
        if (r103 != r102) goto L11;
        return r103;
    }
}
