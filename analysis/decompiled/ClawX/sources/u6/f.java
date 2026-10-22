package u6;

import java.io.EOFException;
import java.util.Arrays;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final c7.f f5693a;

    /* renamed from: c, reason: collision with root package name */
    public boolean f5695c;

    /* renamed from: g, reason: collision with root package name */
    public int f5698g;

    /* renamed from: h, reason: collision with root package name */
    public int f5699h;

    /* renamed from: b, reason: collision with root package name */
    public int f5694b = Integer.MAX_VALUE;
    public int d = 4096;

    /* renamed from: e, reason: collision with root package name */
    public d[] f5696e = new d[8];

    /* renamed from: f, reason: collision with root package name */
    public int f5697f = 7;

    public f(c7.f fVar) {
        this.f5693a = fVar;
    }

    public final void a(int i8) {
        int i9;
        if (i8 > 0) {
            int length = this.f5696e.length - 1;
            int i10 = 0;
            while (true) {
                i9 = this.f5697f;
                if (length < i9 || i8 <= 0) {
                    break;
                }
                d dVar = this.f5696e[length];
                kotlin.jvm.internal.p.b(dVar);
                i8 -= dVar.f5686c;
                int i11 = this.f5699h;
                d dVar2 = this.f5696e[length];
                kotlin.jvm.internal.p.b(dVar2);
                this.f5699h = i11 - dVar2.f5686c;
                this.f5698g--;
                i10++;
                length--;
            }
            d[] dVarArr = this.f5696e;
            int i12 = i9 + 1;
            System.arraycopy(dVarArr, i12, dVarArr, i12 + i10, this.f5698g);
            d[] dVarArr2 = this.f5696e;
            int i13 = this.f5697f + 1;
            Arrays.fill(dVarArr2, i13, i13 + i10, (Object) null);
            this.f5697f += i10;
        }
    }

    public final void b(d dVar) {
        int i8 = dVar.f5686c;
        int i9 = this.d;
        if (i8 > i9) {
            d[] dVarArr = this.f5696e;
            c5.l.c0(dVarArr, 0, dVarArr.length);
            this.f5697f = this.f5696e.length - 1;
            this.f5698g = 0;
            this.f5699h = 0;
            return;
        }
        a((this.f5699h + i8) - i9);
        int i10 = this.f5698g + 1;
        d[] dVarArr2 = this.f5696e;
        if (i10 > dVarArr2.length) {
            d[] dVarArr3 = new d[dVarArr2.length * 2];
            System.arraycopy(dVarArr2, 0, dVarArr3, dVarArr2.length, dVarArr2.length);
            this.f5697f = this.f5696e.length - 1;
            this.f5696e = dVarArr3;
        }
        int i11 = this.f5697f;
        this.f5697f = i11 - 1;
        this.f5696e[i11] = dVar;
        this.f5698g++;
        this.f5699h += i8;
    }

    public final void c(c7.i data) throws EOFException {
        kotlin.jvm.internal.p.e(data, "data");
        int[] iArr = x.f5777a;
        int iC = data.c();
        long j4 = 0;
        long j8 = 0;
        for (int i8 = 0; i8 < iC; i8++) {
            byte bF = data.f(i8);
            byte[] bArr = o6.d.f4327a;
            j8 += x.f5778b[bF & 255];
        }
        int i9 = (int) ((j8 + 7) >> 3);
        int iC2 = data.c();
        c7.f fVar = this.f5693a;
        if (i9 >= iC2) {
            e(data.c(), 127, 0);
            fVar.u(data);
            return;
        }
        c7.f fVar2 = new c7.f();
        int[] iArr2 = x.f5777a;
        int iC3 = data.c();
        int i10 = 0;
        for (int i11 = 0; i11 < iC3; i11++) {
            byte bF2 = data.f(i11);
            byte[] bArr2 = o6.d.f4327a;
            int i12 = bF2 & 255;
            int i13 = x.f5777a[i12];
            byte b9 = x.f5778b[i12];
            j4 = (j4 << b9) | i13;
            i10 += b9;
            while (i10 >= 8) {
                i10 -= 8;
                fVar2.A((int) (j4 >> i10));
            }
        }
        if (i10 > 0) {
            fVar2.A((int) ((j4 << (8 - i10)) | (255 >>> i10)));
        }
        c7.i iVarI = fVar2.i(fVar2.f1164b);
        e(iVarI.c(), 127, 128);
        fVar.u(iVarI);
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
        throw new UnsupportedOperationException("Method not decompiled: u6.f.d(java.util.ArrayList):void");
    }

    public final void e(int i8, int i9, int i10) {
        c7.f fVar = this.f5693a;
        if (i8 < i9) {
            fVar.A(i8 | i10);
            return;
        }
        fVar.A(i10 | i9);
        int i11 = i8 - i9;
        while (i11 >= 128) {
            fVar.A(128 | (i11 & 127));
            i11 >>>= 7;
        }
        fVar.A(i11);
    }
}
