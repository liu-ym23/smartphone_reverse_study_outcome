package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public OutputStream f7749a;

    public class a extends p {

        /* renamed from: b, reason: collision with root package name */
        public boolean f7750b;

        public a(OutputStream outputStream) {
            super(outputStream);
            this.f7750b = true;
        }

        @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p
        public final void a(int i4) throws IOException {
            if (this.f7750b) {
                this.f7750b = false;
            } else {
                this.f7749a.write(i4);
            }
        }
    }

    public p(OutputStream outputStream) {
        this.f7749a = outputStream;
    }

    public x0 a() {
        return new x0(this.f7749a);
    }

    public p b() {
        return new k1(this.f7749a);
    }

    public void a(int i4) throws IOException {
        this.f7749a.write(i4);
    }

    public final void b(int i4) throws IOException {
        if (i4 <= 127) {
            a((byte) i4);
            return;
        }
        int i5 = i4;
        int i6 = 1;
        while (true) {
            i5 >>>= 8;
            if (i5 == 0) {
                break;
            } else {
                i6++;
            }
        }
        a((byte) (i6 | 128));
        for (int i7 = (i6 - 1) * 8; i7 >= 0; i7 -= 8) {
            a((byte) (i4 >> i7));
        }
    }

    public void a(d dVar) throws IOException {
        if (dVar == null) {
            throw new IOException("null object detected");
        }
        dVar.c().a(this);
    }

    public final void a(r rVar) throws IOException {
        rVar.a(new a(this.f7749a));
    }

    public final void a(byte[] bArr, int i4) throws IOException {
        a(i4);
        b(bArr.length);
        this.f7749a.write(bArr);
    }

    public final void a(int i4, int i5) throws IOException {
        if (i5 < 31) {
            a(i4 | i5);
            return;
        }
        a(i4 | 31);
        if (i5 < 128) {
            a(i5);
            return;
        }
        byte[] bArr = new byte[5];
        int i6 = 4;
        bArr[4] = (byte) (i5 & 127);
        do {
            i5 >>= 7;
            i6--;
            bArr[i6] = (byte) ((i5 & 127) | 128);
        } while (i5 > 127);
        this.f7749a.write(bArr, i6, 5 - i6);
    }
}
