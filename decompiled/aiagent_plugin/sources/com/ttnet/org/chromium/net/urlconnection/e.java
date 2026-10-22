package com.ttnet.org.chromium.net.urlconnection;

import com.ttnet.org.chromium.base.k;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: CronetInputStreamWithTTBuffer.java */
/* JADX INFO: loaded from: classes4.dex */
class e extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private h f38287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f38288d;

    e(CronetHttpURLConnection r1) {
        super(r1);
        this.f38288d = false;
    }

    private void a() {
        if (this.f38288d == true) goto L6;
        b();
        return;
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.d, java.io.InputStream
    public int read() {
        a();
        if (this.f38287c.f38297a > 0) goto L5;
        return -1;
    L5:
        return this.f38287c.b() & 255;
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.d, java.io.InputStream
    public int read(byte[] r2, int r3, int r4) {
        a();
        if (r2.length != 0) goto L7;
        return 0;
    L7:
        if (this.f38287c.f38297a > 0) goto L9;
        return -1;
    L9:
        return this.f38287c.a(r2, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.d, java.io.InputStream
    public int available() {
        a();
        if (this.f38287c.f38297a != 0) goto L10;
        if (this.f38284b != null) goto L7;
        return 0;
    L7:
        this.f38287c.c();
        throw this.f38284b;
    L10:
        if (this.f38287c.f38297a > 0) goto L12;
        return 0;
    L12:
        return this.f38287c.f38297a;
    }

    private void b() {
        if (this.f38288d == false) goto L6;
        return;
    L6:
        if (k.a() == false) goto L8;
        k.a("TTBuffer", "calling ensureReadFromCronetDone");
    L8:
        this.f38287c = new h();
    L9:
        Segment r0 = this.f38287c.a();
        ByteBuffer r2 = r0.getInnerBuffer();
        if (k.a() == false) goto L12;
        k.a("TTBuffer", "getMoreData");
    L12:
        int r3 = r2.position();
        this.f38283a.a(r2);
        if (this.f38284b != null) goto L40;
        int r4 = r2.position() - r3;
        if (r4 == 0) goto L16;
        this.f38287c.f38297a += r4;
        if (this.f38287c.f38297a > 5242880) goto L38;
        if (r0.isWritable() == true) goto L32;
        if (k.a() == false) goto L37;
        k.a("TTBuffer", "new data but full, will use new segment next " + this.f38287c.f38297a);
    L37:
        r0.completeRead();
        goto L9
    L32:
        if (k.a() == false) goto L9;
        k.a("TTBuffer", "new data, continue read with this segment " + this.f38287c.f38297a + " remaining: " + r2.remaining());
        goto L9
    L38:
        this.f38287c.c();
        throw new IOException("Download too large " + this.f38287c.f38297a + " 5242880");
    L16:
        if (r3 != 0) goto L22;
        if (k.a() == false) goto L20;
        k.a("TTBuffer", "no new data, release empty segment " + this.f38287c.f38297a);
    L20:
        r0.release();
    L25:
        this.f38288d = true;
        return;
    L22:
        if (k.a() == false) goto L24;
        k.a("TTBuffer", "no new data, save this segment " + this.f38287c.f38297a);
    L24:
        r0.completeRead();
        goto L25
    L40:
        this.f38287c.c();
        throw this.f38284b;
    }
}
