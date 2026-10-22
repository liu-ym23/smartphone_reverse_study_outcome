package hb;

import java.io.EOFException;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final ob.h f4275a;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4277c;

    /* renamed from: g, reason: collision with root package name */
    public int f4281g;

    /* renamed from: h, reason: collision with root package name */
    public int f4282h;

    /* renamed from: b, reason: collision with root package name */
    public int f4276b = Integer.MAX_VALUE;

    /* renamed from: d, reason: collision with root package name */
    public int f4278d = 4096;

    /* renamed from: e, reason: collision with root package name */
    public b[] f4279e = new b[8];

    /* renamed from: f, reason: collision with root package name */
    public int f4280f = 7;

    public d(ob.h hVar) {
        this.f4275a = hVar;
    }

    public final void a(int i2) {
        int i10;
        if (i2 > 0) {
            int length = this.f4279e.length - 1;
            int i11 = 0;
            while (true) {
                i10 = this.f4280f;
                if (length < i10 || i2 <= 0) {
                    break;
                }
                b bVar = this.f4279e[length];
                q7.k.b(bVar);
                i2 -= bVar.f4264c;
                int i12 = this.f4282h;
                b bVar2 = this.f4279e[length];
                q7.k.b(bVar2);
                this.f4282h = i12 - bVar2.f4264c;
                this.f4281g--;
                i11++;
                length--;
            }
            b[] bVarArr = this.f4279e;
            int i13 = i10 + 1;
            System.arraycopy(bVarArr, i13, bVarArr, i13 + i11, this.f4281g);
            b[] bVarArr2 = this.f4279e;
            int i14 = this.f4280f + 1;
            Arrays.fill(bVarArr2, i14, i14 + i11, (Object) null);
            this.f4280f += i11;
        }
    }

    public final void b(b bVar) {
        int i2 = bVar.f4264c;
        int i10 = this.f4278d;
        if (i2 > i10) {
            b[] bVarArr = this.f4279e;
            d7.n.d0(bVarArr, 0, bVarArr.length);
            this.f4280f = this.f4279e.length - 1;
            this.f4281g = 0;
            this.f4282h = 0;
            return;
        }
        a((this.f4282h + i2) - i10);
        int i11 = this.f4281g + 1;
        b[] bVarArr2 = this.f4279e;
        if (i11 > bVarArr2.length) {
            b[] bVarArr3 = new b[bVarArr2.length * 2];
            System.arraycopy(bVarArr2, 0, bVarArr3, bVarArr2.length, bVarArr2.length);
            this.f4280f = this.f4279e.length - 1;
            this.f4279e = bVarArr3;
        }
        int i12 = this.f4280f;
        this.f4280f = i12 - 1;
        this.f4279e[i12] = bVar;
        this.f4281g++;
        this.f4282h += i2;
    }

    public final void c(ob.k kVar) throws EOFException {
        q7.k.e(kVar, "data");
        int[] iArr = z.f4384a;
        int iD = kVar.d();
        long j2 = 0;
        long j4 = 0;
        for (int i2 = 0; i2 < iD; i2++) {
            byte bI = kVar.i(i2);
            byte[] bArr = bb.b.f1659a;
            j4 += z.f4385b[bI & 255];
        }
        int i10 = (int) ((j4 + 7) >> 3);
        int iD2 = kVar.d();
        ob.h hVar = this.f4275a;
        if (i10 >= iD2) {
            e(kVar.d(), 127, 0);
            hVar.H(kVar);
            return;
        }
        ob.h hVar2 = new ob.h();
        int[] iArr2 = z.f4384a;
        int iD3 = kVar.d();
        int i11 = 0;
        for (int i12 = 0; i12 < iD3; i12++) {
            byte bI2 = kVar.i(i12);
            byte[] bArr2 = bb.b.f1659a;
            int i13 = bI2 & 255;
            int i14 = z.f4384a[i13];
            byte b10 = z.f4385b[i13];
            j2 = (j2 << b10) | i14;
            i11 += b10;
            while (i11 >= 8) {
                i11 -= 8;
                hVar2.Q((int) (j2 >> i11));
            }
        }
        if (i11 > 0) {
            hVar2.Q((int) ((j2 << (8 - i11)) | (255 >>> i11)));
        }
        ob.k kVarJ = hVar2.j(hVar2.f7993g);
        e(kVarJ.d(), 127, 128);
        hVar.H(kVarJ);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(java.util.ArrayList r14) throws java.io.EOFException {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: hb.d.d(java.util.ArrayList):void");
    }

    public final void e(int i2, int i10, int i11) {
        ob.h hVar = this.f4275a;
        if (i2 < i10) {
            hVar.Q(i2 | i11);
            return;
        }
        hVar.Q(i11 | i10);
        int i12 = i2 - i10;
        while (i12 >= 128) {
            hVar.Q(128 | (i12 & 127));
            i12 >>>= 7;
        }
        hVar.Q(i12);
    }
}
