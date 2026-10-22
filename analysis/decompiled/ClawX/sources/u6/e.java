package u6;

import java.io.IOException;
import java.util.ArrayList;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: c, reason: collision with root package name */
    public final c7.p f5689c;

    /* renamed from: f, reason: collision with root package name */
    public int f5691f;

    /* renamed from: g, reason: collision with root package name */
    public int f5692g;

    /* renamed from: a, reason: collision with root package name */
    public int f5687a = 4096;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f5688b = new ArrayList();
    public d[] d = new d[8];

    /* renamed from: e, reason: collision with root package name */
    public int f5690e = 7;

    public e(q qVar) {
        this.f5689c = c7.b.b(qVar);
    }

    public final int a(int i8) {
        int i9;
        int i10 = 0;
        if (i8 > 0) {
            int length = this.d.length;
            while (true) {
                length--;
                i9 = this.f5690e;
                if (length < i9 || i8 <= 0) {
                    break;
                }
                d dVar = this.d[length];
                kotlin.jvm.internal.p.b(dVar);
                int i11 = dVar.f5686c;
                i8 -= i11;
                this.f5692g -= i11;
                this.f5691f--;
                i10++;
            }
            d[] dVarArr = this.d;
            System.arraycopy(dVarArr, i9 + 1, dVarArr, i9 + 1 + i10, this.f5691f);
            this.f5690e += i10;
        }
        return i10;
    }

    public final c7.i b(int i8) throws IOException {
        if (i8 >= 0) {
            d[] dVarArr = g.f5700a;
            if (i8 <= dVarArr.length - 1) {
                return dVarArr[i8].f5684a;
            }
        }
        int length = this.f5690e + 1 + (i8 - g.f5700a.length);
        if (length >= 0) {
            d[] dVarArr2 = this.d;
            if (length < dVarArr2.length) {
                d dVar = dVarArr2[length];
                kotlin.jvm.internal.p.b(dVar);
                return dVar.f5684a;
            }
        }
        throw new IOException("Header index too large " + (i8 + 1));
    }

    public final void c(d dVar) {
        this.f5688b.add(dVar);
        int i8 = dVar.f5686c;
        int i9 = this.f5687a;
        if (i8 > i9) {
            d[] dVarArr = this.d;
            c5.l.c0(dVarArr, 0, dVarArr.length);
            this.f5690e = this.d.length - 1;
            this.f5691f = 0;
            this.f5692g = 0;
            return;
        }
        a((this.f5692g + i8) - i9);
        int i10 = this.f5691f + 1;
        d[] dVarArr2 = this.d;
        if (i10 > dVarArr2.length) {
            d[] dVarArr3 = new d[dVarArr2.length * 2];
            System.arraycopy(dVarArr2, 0, dVarArr3, dVarArr2.length, dVarArr2.length);
            this.f5690e = this.d.length - 1;
            this.d = dVarArr3;
        }
        int i11 = this.f5690e;
        this.f5690e = i11 - 1;
        this.d[i11] = dVar;
        this.f5691f++;
        this.f5692g += i8;
    }

    public final c7.i d() {
        c7.p source = this.f5689c;
        byte b9 = source.readByte();
        byte[] bArr = o6.d.f4327a;
        int i8 = b9 & 255;
        int i9 = 0;
        boolean z = (b9 & 128) == 128;
        long jE = e(i8, 127);
        if (!z) {
            return source.i(jE);
        }
        c7.f fVar = new c7.f();
        int[] iArr = x.f5777a;
        kotlin.jvm.internal.p.e(source, "source");
        f1.b bVar = x.f5779c;
        f1.b bVar2 = bVar;
        int i10 = 0;
        for (long j4 = 0; j4 < jE; j4++) {
            byte b10 = source.readByte();
            byte[] bArr2 = o6.d.f4327a;
            i9 = (i9 << 8) | (b10 & 255);
            i10 += 8;
            while (i10 >= 8) {
                f1.b[] bVarArr = (f1.b[]) bVar2.f2548c;
                kotlin.jvm.internal.p.b(bVarArr);
                bVar2 = bVarArr[(i9 >>> (i10 - 8)) & 255];
                kotlin.jvm.internal.p.b(bVar2);
                if (((f1.b[]) bVar2.f2548c) == null) {
                    fVar.A(bVar2.f2546a);
                    i10 -= bVar2.f2547b;
                    bVar2 = bVar;
                } else {
                    i10 -= 8;
                }
            }
        }
        while (i10 > 0) {
            f1.b[] bVarArr2 = (f1.b[]) bVar2.f2548c;
            kotlin.jvm.internal.p.b(bVarArr2);
            f1.b bVar3 = bVarArr2[(i9 << (8 - i10)) & 255];
            kotlin.jvm.internal.p.b(bVar3);
            int i11 = bVar3.f2547b;
            if (((f1.b[]) bVar3.f2548c) != null || i11 > i10) {
                break;
            }
            fVar.A(bVar3.f2546a);
            i10 -= i11;
            bVar2 = bVar;
        }
        return fVar.i(fVar.f1164b);
    }

    public final int e(int i8, int i9) {
        int i10 = i8 & i9;
        if (i10 < i9) {
            return i10;
        }
        int i11 = 0;
        while (true) {
            byte b9 = this.f5689c.readByte();
            byte[] bArr = o6.d.f4327a;
            int i12 = b9 & 255;
            if ((b9 & 128) == 0) {
                return i9 + (i12 << i11);
            }
            i9 += (b9 & AbstractJsonLexerKt.TC_INVALID) << i11;
            i11 += 7;
        }
    }
}
