package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class j0 extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    public final v f7728a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f7729b = true;

    /* renamed from: c, reason: collision with root package name */
    public InputStream f7730c;

    public j0(v vVar) {
        this.f7728a = vVar;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        o oVar;
        if (this.f7730c == null) {
            if (!this.f7729b || (oVar = (o) this.f7728a.a()) == null) {
                return -1;
            }
            this.f7729b = false;
            this.f7730c = oVar.b();
        }
        while (true) {
            int i4 = this.f7730c.read();
            if (i4 >= 0) {
                return i4;
            }
            o oVar2 = (o) this.f7728a.a();
            if (oVar2 == null) {
                this.f7730c = null;
                return -1;
            }
            this.f7730c = oVar2.b();
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i4, int i5) throws IOException {
        o oVar;
        int i6 = 0;
        if (this.f7730c == null) {
            if (!this.f7729b || (oVar = (o) this.f7728a.a()) == null) {
                return -1;
            }
            this.f7729b = false;
            this.f7730c = oVar.b();
        }
        while (true) {
            int i7 = this.f7730c.read(bArr, i4 + i6, i5 - i6);
            if (i7 >= 0) {
                i6 += i7;
                if (i6 == i5) {
                    return i6;
                }
            } else {
                o oVar2 = (o) this.f7728a.a();
                if (oVar2 == null) {
                    this.f7730c = null;
                    if (i6 < 1) {
                        return -1;
                    }
                    return i6;
                }
                this.f7730c = oVar2.b();
            }
        }
    }
}
