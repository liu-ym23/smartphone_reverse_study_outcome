package hd;

import java.io.IOException;
import java.util.ArrayList;
import od.c0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public int f5476a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f5477b;

    /* renamed from: c, reason: collision with root package name */
    public c0 f5478c;

    /* renamed from: d, reason: collision with root package name */
    public b[] f5479d;

    /* renamed from: e, reason: collision with root package name */
    public int f5480e;

    /* renamed from: f, reason: collision with root package name */
    public int f5481f;

    /* renamed from: g, reason: collision with root package name */
    public int f5482g;

    public final int a(int i) {
        int i3;
        int i10 = 0;
        if (i > 0) {
            int length = this.f5479d.length;
            while (true) {
                length--;
                i3 = this.f5480e;
                if (length < i3 || i <= 0) {
                    break;
                }
                b bVar = this.f5479d[length];
                bVar.getClass();
                int i11 = bVar.f5475c;
                i -= i11;
                this.f5482g -= i11;
                this.f5481f--;
                i10++;
            }
            b[] bVarArr = this.f5479d;
            System.arraycopy(bVarArr, i3 + 1, bVarArr, i3 + 1 + i10, this.f5481f);
            this.f5480e += i10;
        }
        return i10;
    }

    public final od.l b(int i) throws IOException {
        if (i >= 0) {
            b[] bVarArr = e.f5491a;
            if (i <= bVarArr.length - 1) {
                return bVarArr[i].f5473a;
            }
        }
        int length = this.f5480e + 1 + (i - e.f5491a.length);
        if (length >= 0) {
            b[] bVarArr2 = this.f5479d;
            if (length < bVarArr2.length) {
                b bVar = bVarArr2[length];
                bVar.getClass();
                return bVar.f5473a;
            }
        }
        g5.f.e(i + 1, "Header index too large ");
        return null;
    }

    public final void c(b bVar) {
        this.f5477b.add(bVar);
        int i = bVar.f5475c;
        int i3 = this.f5476a;
        if (i > i3) {
            b[] bVarArr = this.f5479d;
            kb.k.m0(null, 0, bVarArr, bVarArr.length);
            this.f5480e = this.f5479d.length - 1;
            this.f5481f = 0;
            this.f5482g = 0;
            return;
        }
        a((this.f5482g + i) - i3);
        int i10 = this.f5481f + 1;
        b[] bVarArr2 = this.f5479d;
        if (i10 > bVarArr2.length) {
            b[] bVarArr3 = new b[bVarArr2.length * 2];
            System.arraycopy(bVarArr2, 0, bVarArr3, bVarArr2.length, bVarArr2.length);
            this.f5480e = this.f5479d.length - 1;
            this.f5479d = bVarArr3;
        }
        int i11 = this.f5480e;
        this.f5480e = i11 - 1;
        this.f5479d[i11] = bVar;
        this.f5481f++;
        this.f5482g += i;
    }

    public final od.l d() {
        c0 c0Var = this.f5478c;
        byte bG = c0Var.g();
        byte[] bArr = bd.b.f2074a;
        int i = bG & 255;
        int i3 = 0;
        boolean z10 = (bG & 128) == 128;
        long jE = e(i, 127);
        if (!z10) {
            return c0Var.i(jE);
        }
        od.i iVar = new od.i();
        int[] iArr = x.f5584a;
        c0Var.getClass();
        b0.z zVar = x.f5586c;
        b0.z zVar2 = zVar;
        int i10 = 0;
        for (long j10 = 0; j10 < jE; j10++) {
            byte bG2 = c0Var.g();
            byte[] bArr2 = bd.b.f2074a;
            i3 = (i3 << 8) | (bG2 & 255);
            i10 += 8;
            while (i10 >= 8) {
                b0.z[] zVarArr = (b0.z[]) zVar2.f1803g;
                zVarArr.getClass();
                zVar2 = zVarArr[(i3 >>> (i10 - 8)) & 255];
                zVar2.getClass();
                if (((b0.z[]) zVar2.f1803g) == null) {
                    iVar.b0(zVar2.f1801c);
                    i10 -= zVar2.f1802f;
                    zVar2 = zVar;
                } else {
                    i10 -= 8;
                }
            }
        }
        while (i10 > 0) {
            b0.z[] zVarArr2 = (b0.z[]) zVar2.f1803g;
            zVarArr2.getClass();
            b0.z zVar3 = zVarArr2[(i3 << (8 - i10)) & 255];
            zVar3.getClass();
            int i11 = zVar3.f1802f;
            if (((b0.z[]) zVar3.f1803g) != null || i11 > i10) {
                break;
            }
            iVar.b0(zVar3.f1801c);
            i10 -= i11;
            zVar2 = zVar;
        }
        return iVar.P(iVar.f9454f);
    }

    public final int e(int i, int i3) {
        int i10 = i & i3;
        if (i10 < i3) {
            return i10;
        }
        int i11 = 0;
        while (true) {
            byte bG = this.f5478c.g();
            byte[] bArr = bd.b.f2074a;
            int i12 = bG & 255;
            if ((bG & 128) == 0) {
                return i3 + (i12 << i11);
            }
            i3 += (bG & 127) << i11;
            i11 += 7;
        }
    }
}
