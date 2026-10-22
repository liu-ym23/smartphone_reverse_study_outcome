package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes39.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OutputStream f31869a;

    public class a extends p {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f31870b;

        public a(OutputStream r100) {
            super(r100);
            this.f31870b = true;
        }

        @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p
        public final void a(int r100) throws IOException {
            if (this.f31870b == false) goto L5;
            this.f31870b = false;
            return;
        L5:
            this.f31869a.write(r100);
        }
    }

    public p(OutputStream r100) {
        this.f31869a = r100;
    }

    public x0 a() {
        return new x0(this.f31869a);
    }

    public void a(int r100) throws IOException {
        this.f31869a.write(r100);
    }

    public void a(d r100) throws IOException {
        if (r100 == null) goto L6;
        r100.c().a(this);
        return;
    L6:
        throw new IOException("null object detected");
    }

    public final void a(r r100) throws IOException {
        r100.a(new a(this.f31869a));
    }

    public p b() {
        return new k1(this.f31869a);
    }

    public final void b(int r100) throws IOException {
        if (r100 <= 127) goto L11;
        int r101 = r100;
        int r102 = 1;
    L5:
        r101 = r101 >>> 8;
        if (r101 == 0) goto L8;
        r102 = r102 + 1;
        goto L5
    L8:
        a((byte) (r102 | 128));
        int r103 = (r102 - 1) * 8;
    L9:
        if (r103 < 0) goto L15;
        a((byte) (r100 >> r103));
        r103 = r103 - 8;
        goto L9
    L15:
        return;
    L11:
        a((byte) r100);
    }

    public final void a(int r100, int r101) throws IOException {
        if (r101 >= 31) goto L5;
        a(r100 | r101);
        return;
    L5:
        a(r100 | 31);
        if (r101 >= 128) goto L8;
        a(r101);
        return;
    L8:
        byte[] r102 = new byte[5];
        int r103 = 4;
        r102[4] = (byte) (r101 & 127);
    L9:
        r101 = r101 >> 7;
        r103 = r103 - 1;
        r102[r103] = (byte) ((r101 & 127) | 128);
        if (r101 > 127) goto L9;
        this.f31869a.write(r102, r103, 5 - r103);
    }

    public final void a(byte[] r100, int r101) throws IOException {
        a(r101);
        b(r100.length);
        this.f31869a.write(r100);
    }
}
