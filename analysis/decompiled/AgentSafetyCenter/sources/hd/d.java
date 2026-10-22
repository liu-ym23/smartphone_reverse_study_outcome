package hd;

import java.io.EOFException;
import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public od.i f5483a;

    /* renamed from: b, reason: collision with root package name */
    public int f5484b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f5485c;

    /* renamed from: d, reason: collision with root package name */
    public int f5486d;

    /* renamed from: e, reason: collision with root package name */
    public b[] f5487e;

    /* renamed from: f, reason: collision with root package name */
    public int f5488f;

    /* renamed from: g, reason: collision with root package name */
    public int f5489g;

    /* renamed from: h, reason: collision with root package name */
    public int f5490h;

    public final void a(int i) {
        int i3;
        if (i > 0) {
            int length = this.f5487e.length - 1;
            int i10 = 0;
            while (true) {
                i3 = this.f5488f;
                if (length < i3 || i <= 0) {
                    break;
                }
                b bVar = this.f5487e[length];
                bVar.getClass();
                i -= bVar.f5475c;
                int i11 = this.f5490h;
                b bVar2 = this.f5487e[length];
                bVar2.getClass();
                this.f5490h = i11 - bVar2.f5475c;
                this.f5489g--;
                i10++;
                length--;
            }
            b[] bVarArr = this.f5487e;
            int i12 = i3 + 1;
            System.arraycopy(bVarArr, i12, bVarArr, i12 + i10, this.f5489g);
            b[] bVarArr2 = this.f5487e;
            int i13 = this.f5488f + 1;
            Arrays.fill(bVarArr2, i13, i13 + i10, (Object) null);
            this.f5488f += i10;
        }
    }

    public final void b(b bVar) {
        int i = bVar.f5475c;
        int i3 = this.f5486d;
        if (i > i3) {
            b[] bVarArr = this.f5487e;
            kb.k.m0(null, 0, bVarArr, bVarArr.length);
            this.f5488f = this.f5487e.length - 1;
            this.f5489g = 0;
            this.f5490h = 0;
            return;
        }
        a((this.f5490h + i) - i3);
        int i10 = this.f5489g + 1;
        b[] bVarArr2 = this.f5487e;
        if (i10 > bVarArr2.length) {
            b[] bVarArr3 = new b[bVarArr2.length * 2];
            System.arraycopy(bVarArr2, 0, bVarArr3, bVarArr2.length, bVarArr2.length);
            this.f5488f = this.f5487e.length - 1;
            this.f5487e = bVarArr3;
        }
        int i11 = this.f5488f;
        this.f5488f = i11 - 1;
        this.f5487e[i11] = bVar;
        this.f5489g++;
        this.f5490h += i;
    }

    public final void c(od.l lVar) throws EOFException {
        od.i iVar = this.f5483a;
        lVar.getClass();
        int[] iArr = x.f5584a;
        int iC = lVar.c();
        long j10 = 0;
        long j11 = 0;
        for (int i = 0; i < iC; i++) {
            byte bH = lVar.h(i);
            byte[] bArr = bd.b.f2074a;
            j11 += x.f5585b[bH & 255];
        }
        if (((int) ((j11 + 7) >> 3)) >= lVar.c()) {
            e(lVar.c(), 127, 0);
            iVar.Z(lVar);
            return;
        }
        od.i iVar2 = new od.i();
        int[] iArr2 = x.f5584a;
        int iC2 = lVar.c();
        int i3 = 0;
        for (int i10 = 0; i10 < iC2; i10++) {
            byte bH2 = lVar.h(i10);
            byte[] bArr2 = bd.b.f2074a;
            int i11 = bH2 & 255;
            int i12 = x.f5584a[i11];
            byte b10 = x.f5585b[i11];
            j10 = (j10 << b10) | i12;
            i3 += b10;
            while (i3 >= 8) {
                i3 -= 8;
                iVar2.b0((int) (j10 >> i3));
            }
        }
        if (i3 > 0) {
            iVar2.b0((int) ((j10 << (8 - i3)) | (255 >>> i3)));
        }
        od.l lVarP = iVar2.P(iVar2.f9454f);
        e(lVarP.c(), 127, 128);
        iVar.Z(lVarP);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(java.util.ArrayList r14) throws java.io.EOFException {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: hd.d.d(java.util.ArrayList):void");
    }

    public final void e(int i, int i3, int i10) {
        od.i iVar = this.f5483a;
        if (i < i3) {
            iVar.b0(i | i10);
            return;
        }
        iVar.b0(i10 | i3);
        int i11 = i - i3;
        while (i11 >= 128) {
            iVar.b0(128 | (i11 & 127));
            i11 >>>= 7;
        }
        iVar.b0(i11);
    }
}
