package M9;

import java.io.EOFException;
import java.util.Arrays;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final V9.g f978a;
    public boolean c;
    public int g;
    public int h;
    public int b = Integer.MAX_VALUE;
    public int d = 4096;
    public C0247a[] e = new C0247a[8];
    public int f = 7;

    public c(V9.g gVar) {
        this.f978a = gVar;
    }

    public final void a(int i) {
        int i6;
        if (i > 0) {
            int length = this.e.length - 1;
            int i10 = 0;
            while (true) {
                i6 = this.f;
                if (length < i6 || i <= 0) {
                    break;
                }
                C0247a c0247a = this.e[length];
                kotlin.jvm.internal.k.c(c0247a);
                i -= c0247a.c;
                int i11 = this.h;
                C0247a c0247a2 = this.e[length];
                kotlin.jvm.internal.k.c(c0247a2);
                this.h = i11 - c0247a2.c;
                this.g--;
                i10++;
                length--;
            }
            C0247a[] c0247aArr = this.e;
            int i12 = i6 + 1;
            System.arraycopy(c0247aArr, i12, c0247aArr, i12 + i10, this.g);
            C0247a[] c0247aArr2 = this.e;
            int i13 = this.f + 1;
            Arrays.fill(c0247aArr2, i13, i13 + i10, (Object) null);
            this.f += i10;
        }
    }

    public final void b(C0247a c0247a) {
        int i = c0247a.c;
        int i6 = this.d;
        if (i > i6) {
            C0247a[] c0247aArr = this.e;
            D7.q.f0(null, 0, c0247aArr, c0247aArr.length);
            this.f = this.e.length - 1;
            this.g = 0;
            this.h = 0;
            return;
        }
        a((this.h + i) - i6);
        int i10 = this.g + 1;
        C0247a[] c0247aArr2 = this.e;
        if (i10 > c0247aArr2.length) {
            C0247a[] c0247aArr3 = new C0247a[c0247aArr2.length * 2];
            System.arraycopy(c0247aArr2, 0, c0247aArr3, c0247aArr2.length, c0247aArr2.length);
            this.f = this.e.length - 1;
            this.e = c0247aArr3;
        }
        int i11 = this.f;
        this.f = i11 - 1;
        this.e[i11] = c0247a;
        this.g++;
        this.h += i;
    }

    public final void c(ByteString data) throws EOFException {
        kotlin.jvm.internal.k.f(data, "data");
        int[] iArr = z.f1002a;
        int iC = data.c();
        long j5 = 0;
        long j6 = 0;
        for (int i = 0; i < iC; i++) {
            byte bF = data.f(i);
            byte[] bArr = G9.b.f704a;
            j6 += z.b[bF & 255];
        }
        int i6 = (int) ((j6 + 7) >> 3);
        int iC2 = data.c();
        V9.g gVar = this.f978a;
        if (i6 >= iC2) {
            e(data.c(), 127, 0);
            gVar.K(data);
            return;
        }
        V9.g gVar2 = new V9.g();
        int[] iArr2 = z.f1002a;
        int iC3 = data.c();
        int i10 = 0;
        for (int i11 = 0; i11 < iC3; i11++) {
            byte bF2 = data.f(i11);
            byte[] bArr2 = G9.b.f704a;
            int i12 = bF2 & 255;
            int i13 = z.f1002a[i12];
            byte b = z.b[i12];
            j5 = (j5 << b) | i13;
            i10 += b;
            while (i10 >= 8) {
                i10 -= 8;
                gVar2.L((int) (j5 >> i10));
            }
        }
        if (i10 > 0) {
            gVar2.L((int) ((j5 << (8 - i10)) | (255 >>> i10)));
        }
        ByteString byteStringV = gVar2.v(gVar2.b);
        e(byteStringV.c(), 127, 128);
        gVar.K(byteStringV);
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
        throw new UnsupportedOperationException("Method not decompiled: M9.c.d(java.util.ArrayList):void");
    }

    public final void e(int i, int i6, int i10) {
        V9.g gVar = this.f978a;
        if (i < i6) {
            gVar.L(i | i10);
            return;
        }
        gVar.L(i10 | i6);
        int i11 = i - i6;
        while (i11 >= 128) {
            gVar.L(128 | (i11 & 127));
            i11 >>>= 7;
        }
        gVar.L(i11);
    }
}
