package hb;

import b0.h1;
import java.io.IOException;
import java.util.ArrayList;
import ob.e0;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    public final e0 f4269c;

    /* renamed from: f, reason: collision with root package name */
    public int f4272f;

    /* renamed from: g, reason: collision with root package name */
    public int f4273g;

    /* renamed from: a, reason: collision with root package name */
    public int f4267a = 4096;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f4268b = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public b[] f4270d = new b[8];

    /* renamed from: e, reason: collision with root package name */
    public int f4271e = 7;

    public c(s sVar) {
        this.f4269c = ob.b.c(sVar);
    }

    public final int a(int i2) {
        int i10;
        int i11 = 0;
        if (i2 > 0) {
            int length = this.f4270d.length;
            while (true) {
                length--;
                i10 = this.f4271e;
                if (length < i10 || i2 <= 0) {
                    break;
                }
                b bVar = this.f4270d[length];
                q7.k.b(bVar);
                int i12 = bVar.f4264c;
                i2 -= i12;
                this.f4273g -= i12;
                this.f4272f--;
                i11++;
            }
            b[] bVarArr = this.f4270d;
            System.arraycopy(bVarArr, i10 + 1, bVarArr, i10 + 1 + i11, this.f4272f);
            this.f4271e += i11;
        }
        return i11;
    }

    public final ob.k b(int i2) throws IOException {
        if (i2 >= 0) {
            b[] bVarArr = e.f4283a;
            if (i2 <= bVarArr.length - 1) {
                return bVarArr[i2].f4262a;
            }
        }
        int length = this.f4271e + 1 + (i2 - e.f4283a.length);
        if (length >= 0) {
            b[] bVarArr2 = this.f4270d;
            if (length < bVarArr2.length) {
                b bVar = bVarArr2[length];
                q7.k.b(bVar);
                return bVar.f4262a;
            }
        }
        throw new IOException("Header index too large " + (i2 + 1));
    }

    public final void c(b bVar) {
        this.f4268b.add(bVar);
        int i2 = bVar.f4264c;
        int i10 = this.f4267a;
        if (i2 > i10) {
            b[] bVarArr = this.f4270d;
            d7.n.d0(bVarArr, 0, bVarArr.length);
            this.f4271e = this.f4270d.length - 1;
            this.f4272f = 0;
            this.f4273g = 0;
            return;
        }
        a((this.f4273g + i2) - i10);
        int i11 = this.f4272f + 1;
        b[] bVarArr2 = this.f4270d;
        if (i11 > bVarArr2.length) {
            b[] bVarArr3 = new b[bVarArr2.length * 2];
            System.arraycopy(bVarArr2, 0, bVarArr3, bVarArr2.length, bVarArr2.length);
            this.f4271e = this.f4270d.length - 1;
            this.f4270d = bVarArr3;
        }
        int i12 = this.f4271e;
        this.f4271e = i12 - 1;
        this.f4270d[i12] = bVar;
        this.f4272f++;
        this.f4273g += i2;
    }

    public final ob.k d() {
        e0 e0Var = this.f4269c;
        byte b10 = e0Var.readByte();
        byte[] bArr = bb.b.f1659a;
        int i2 = b10 & 255;
        int i10 = 0;
        boolean z4 = (b10 & 128) == 128;
        long jE = e(i2, 127);
        if (!z4) {
            return e0Var.j(jE);
        }
        ob.h hVar = new ob.h();
        int[] iArr = z.f4384a;
        q7.k.e(e0Var, "source");
        h1 h1Var = z.f4386c;
        h1 h1Var2 = h1Var;
        int i11 = 0;
        for (long j2 = 0; j2 < jE; j2++) {
            byte b11 = e0Var.readByte();
            byte[] bArr2 = bb.b.f1659a;
            i10 = (i10 << 8) | (b11 & 255);
            i11 += 8;
            while (i11 >= 8) {
                h1[] h1VarArr = (h1[]) h1Var2.f1174h;
                q7.k.b(h1VarArr);
                h1Var2 = h1VarArr[(i10 >>> (i11 - 8)) & 255];
                q7.k.b(h1Var2);
                if (((h1[]) h1Var2.f1174h) == null) {
                    hVar.Q(h1Var2.f1172f);
                    i11 -= h1Var2.f1173g;
                    h1Var2 = h1Var;
                } else {
                    i11 -= 8;
                }
            }
        }
        while (i11 > 0) {
            h1[] h1VarArr2 = (h1[]) h1Var2.f1174h;
            q7.k.b(h1VarArr2);
            h1 h1Var3 = h1VarArr2[(i10 << (8 - i11)) & 255];
            q7.k.b(h1Var3);
            int i12 = h1Var3.f1173g;
            if (((h1[]) h1Var3.f1174h) != null || i12 > i11) {
                break;
            }
            hVar.Q(h1Var3.f1172f);
            i11 -= i12;
            h1Var2 = h1Var;
        }
        return hVar.j(hVar.f7993g);
    }

    public final int e(int i2, int i10) {
        int i11 = i2 & i10;
        if (i11 < i10) {
            return i11;
        }
        int i12 = 0;
        while (true) {
            byte b10 = this.f4269c.readByte();
            byte[] bArr = bb.b.f1659a;
            int i13 = b10 & 255;
            if ((b10 & 128) == 0) {
                return i10 + (i13 << i12);
            }
            i10 += (b10 & 127) << i12;
            i12 += 7;
        }
    }
}
