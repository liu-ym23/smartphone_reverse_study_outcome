package C3;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class f {

    /* renamed from: f, reason: collision with root package name */
    public static final f f1718f = new f(g.f1724b, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f1719a;

    /* renamed from: b, reason: collision with root package name */
    public final g f1720b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1721c;

    /* renamed from: d, reason: collision with root package name */
    public final int f1722d;

    /* renamed from: e, reason: collision with root package name */
    public final int f1723e;

    public f(g gVar, int i10, int i11, int i12) {
        this.f1720b = gVar;
        this.f1719a = i10;
        this.f1721c = i11;
        this.f1722d = i12;
        this.f1723e = c(i11);
    }

    public static int c(int i10) {
        if (i10 > 62) {
            return 21;
        }
        if (i10 > 31) {
            return 20;
        }
        return i10 > 0 ? 10 : 0;
    }

    public f a(int i10) {
        g gVarA = this.f1720b;
        int i11 = this.f1719a;
        int i12 = this.f1722d;
        if (i11 == 4 || i11 == 2) {
            int i13 = d.f1710d[i11][0];
            int i14 = 65535 & i13;
            int i15 = i13 >> 16;
            gVarA = gVarA.a(i14, i15);
            i12 += i15;
            i11 = 0;
        }
        int i16 = this.f1721c;
        f fVar = new f(gVarA, i11, i16 + 1, i12 + ((i16 == 0 || i16 == 31) ? 18 : i16 == 62 ? 9 : 8));
        return fVar.f1721c == 2078 ? fVar.d(i10 + 1) : fVar;
    }

    public f b(int i10) {
        g gVarA;
        g gVar = j(4, 0).f1720b;
        int length = 3;
        if (i10 < 0) {
            gVarA = gVar.a(0, 3);
        } else {
            if (i10 > 999999) {
                throw new IllegalArgumentException("ECI code must be between 0 and 999999");
            }
            byte[] bytes = Integer.toString(i10).getBytes(StandardCharsets.ISO_8859_1);
            g gVarA2 = gVar.a(bytes.length, 3);
            for (byte b10 : bytes) {
                gVarA2 = gVarA2.a(b10 - 46, 4);
            }
            length = 3 + (bytes.length * 4);
            gVarA = gVarA2;
        }
        return new f(gVarA, this.f1719a, 0, this.f1722d + length);
    }

    public f d(int i10) {
        int i11 = this.f1721c;
        return i11 == 0 ? this : new f(this.f1720b.b(i10 - i11, i11), this.f1719a, 0, this.f1722d);
    }

    public int e() {
        return this.f1721c;
    }

    public int f() {
        return this.f1722d;
    }

    public int g() {
        return this.f1719a;
    }

    public boolean h(f fVar) {
        int i10 = this.f1722d + (d.f1710d[this.f1719a][fVar.f1719a] >> 16);
        int i11 = this.f1721c;
        int i12 = fVar.f1721c;
        if (i11 < i12) {
            i10 += fVar.f1723e - this.f1723e;
        } else if (i11 > i12 && i12 > 0) {
            i10 += 10;
        }
        return i10 <= fVar.f1722d;
    }

    public f i(int i10, int i11) {
        int i12 = this.f1722d;
        g gVarA = this.f1720b;
        int i13 = this.f1719a;
        if (i10 != i13) {
            int i14 = d.f1710d[i13][i10];
            int i15 = 65535 & i14;
            int i16 = i14 >> 16;
            gVarA = gVarA.a(i15, i16);
            i12 += i16;
        }
        int i17 = i10 == 2 ? 4 : 5;
        return new f(gVarA.a(i11, i17), i10, 0, i12 + i17);
    }

    public f j(int i10, int i11) {
        g gVar = this.f1720b;
        int i12 = this.f1719a;
        int i13 = i12 == 2 ? 4 : 5;
        return new f(gVar.a(d.f1712f[i12][i10], i13).a(i11, 5), this.f1719a, 0, this.f1722d + i13 + 5);
    }

    public D3.a k(byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        for (g gVarD = d(bArr.length).f1720b; gVarD != null; gVarD = gVarD.d()) {
            arrayList.add(gVarD);
        }
        D3.a aVar = new D3.a();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((g) arrayList.get(size)).c(aVar, bArr);
        }
        return aVar;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", d.f1709c[this.f1719a], Integer.valueOf(this.f1722d), Integer.valueOf(this.f1721c));
    }
}
