package io.objectbox.flatbuffers;

import S8.d;
import io.objectbox.flatbuffers.FlexBuffers;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final d f34357a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList<b> f34358b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap<String, Integer> f34359c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap<String, Integer> f34360d;

    /* renamed from: e, reason: collision with root package name */
    public final int f34361e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f34362f;

    /* renamed from: g, reason: collision with root package name */
    public Comparator<b> f34363g;

    /* renamed from: io.objectbox.flatbuffers.a$a, reason: collision with other inner class name */
    public class C0420a implements Comparator<b> {
        public C0420a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b bVar, b bVar2) {
            byte b10;
            byte b11;
            int i10 = bVar.f34369e;
            int i11 = bVar2.f34369e;
            do {
                b10 = a.this.f34357a.get(i10);
                b11 = a.this.f34357a.get(i11);
                if (b10 == 0) {
                    return b10 - b11;
                }
                i10++;
                i11++;
            } while (b10 == b11);
            return b10 - b11;
        }
    }

    public a(int i10) {
        this(new S8.a(i10), 1);
    }

    public static int B(long j10) {
        if (j10 <= FlexBuffers.i.a((byte) -1)) {
            return 0;
        }
        if (j10 <= FlexBuffers.i.c((short) -1)) {
            return 1;
        }
        return j10 <= FlexBuffers.i.b(-1) ? 2 : 3;
    }

    public int A() {
        return this.f34358b.size();
    }

    public final void C(b bVar, int i10) {
        int i11 = bVar.f34365a;
        if (i11 != 0 && i11 != 1 && i11 != 2) {
            if (i11 == 3) {
                E(bVar.f34367c, i10);
                return;
            } else if (i11 != 26) {
                G(bVar.f34368d, i10);
                return;
            }
        }
        F(bVar.f34368d, i10);
    }

    public final b D(int i10, byte[] bArr, int i11, boolean z10) {
        int iB = B(bArr.length);
        F(bArr.length, b(iB));
        int iE = this.f34357a.e();
        this.f34357a.j(bArr, 0, bArr.length);
        if (z10) {
            this.f34357a.g((byte) 0);
        }
        return b.f(i10, iE, i11, iB);
    }

    public final void E(double d10, int i10) {
        if (i10 == 4) {
            this.f34357a.f((float) d10);
        } else if (i10 == 8) {
            this.f34357a.b(d10);
        }
    }

    public final void F(long j10, int i10) {
        if (i10 == 1) {
            this.f34357a.g((byte) j10);
            return;
        }
        if (i10 == 2) {
            this.f34357a.h((short) j10);
        } else if (i10 == 4) {
            this.f34357a.i((int) j10);
        } else {
            if (i10 != 8) {
                return;
            }
            this.f34357a.k(j10);
        }
    }

    public final void G(long j10, int i10) {
        F((int) (this.f34357a.e() - j10), i10);
    }

    public final b H(int i10, String str) {
        return D(i10, str.getBytes(StandardCharsets.UTF_8), 5, true);
    }

    public final int b(int i10) {
        int i11 = 1 << i10;
        int iR = b.r(this.f34357a.e(), i11);
        while (true) {
            int i12 = iR - 1;
            if (iR == 0) {
                return i11;
            }
            this.f34357a.g((byte) 0);
            iR = i12;
        }
    }

    public void c() {
        this.f34357a.clear();
        this.f34358b.clear();
        this.f34359c.clear();
        this.f34360d.clear();
        this.f34362f = false;
    }

    public final b d(int i10, int i11) {
        long j10 = i11;
        int iMax = Math.max(0, B(j10));
        int i12 = i10;
        while (i12 < this.f34358b.size()) {
            int i13 = i12 + 1;
            iMax = Math.max(iMax, b.i(4, 0, this.f34358b.get(i12).f34369e, this.f34357a.e(), i13));
            i12 = i13;
        }
        int iB = b(iMax);
        F(j10, iB);
        int iE = this.f34357a.e();
        while (i10 < this.f34358b.size()) {
            int i14 = this.f34358b.get(i10).f34369e;
            G(this.f34358b.get(i10).f34369e, iB);
            i10++;
        }
        return new b(-1, FlexBuffers.p(4, 0), iMax, iE);
    }

    public final b e(int i10, int i11, int i12, boolean z10, boolean z11, b bVar) {
        int i13;
        int iP;
        if (z11 && (!z10)) {
            throw new UnsupportedOperationException("Untyped fixed vector is not supported");
        }
        int i14 = i12;
        long j10 = i14;
        int iMax = Math.max(0, B(j10));
        if (bVar != null) {
            iMax = Math.max(iMax, bVar.h(this.f34357a.e(), 0));
            i13 = 3;
        } else {
            i13 = 1;
        }
        int i15 = 4;
        int iMax2 = iMax;
        for (int i16 = i11; i16 < this.f34358b.size(); i16++) {
            iMax2 = Math.max(iMax2, this.f34358b.get(i16).h(this.f34357a.e(), i16 + i13));
            if (z10 && i16 == i11) {
                i15 = this.f34358b.get(i16).f34365a;
                if (!FlexBuffers.k(i15)) {
                    throw new FlexBuffers.FlexBufferException("TypedVector does not support this element type");
                }
            }
        }
        int i17 = i11;
        int iB = b(iMax2);
        if (bVar != null) {
            G(bVar.f34368d, iB);
            F(1 << bVar.f34366b, iB);
        }
        if (!z11) {
            F(j10, iB);
        }
        int iE = this.f34357a.e();
        for (int i18 = i17; i18 < this.f34358b.size(); i18++) {
            C(this.f34358b.get(i18), iB);
        }
        if (!z10) {
            while (i17 < this.f34358b.size()) {
                this.f34357a.g(this.f34358b.get(i17).t(iMax2));
                i17++;
            }
        }
        if (bVar != null) {
            iP = 9;
        } else if (z10) {
            if (!z11) {
                i14 = 0;
            }
            iP = FlexBuffers.p(i15, i14);
        } else {
            iP = 10;
        }
        return new b(i10, iP, iMax2, iE);
    }

    public int f(String str, int i10) {
        int iU = u(str);
        ArrayList<b> arrayList = this.f34358b;
        Collections.sort(arrayList.subList(i10, arrayList.size()), this.f34363g);
        b bVarE = e(iU, i10, this.f34358b.size() - i10, false, false, d(i10, this.f34358b.size() - i10));
        while (this.f34358b.size() > i10) {
            this.f34358b.remove(r8.size() - 1);
        }
        this.f34358b.add(bVarE);
        return (int) bVarE.f34368d;
    }

    public int g(String str, int i10, boolean z10, boolean z11) {
        b bVarE = e(u(str), i10, this.f34358b.size() - i10, z10, z11, null);
        while (this.f34358b.size() > i10) {
            this.f34358b.remove(r8.size() - 1);
        }
        this.f34358b.add(bVarE);
        return (int) bVarE.f34368d;
    }

    public ByteBuffer h() {
        int iB = b(this.f34358b.get(0).h(this.f34357a.e(), 0));
        C(this.f34358b.get(0), iB);
        this.f34357a.g(this.f34358b.get(0).s());
        this.f34357a.g((byte) iB);
        this.f34362f = true;
        return ByteBuffer.wrap(this.f34357a.c(), 0, this.f34357a.e());
    }

    public int i(String str, byte[] bArr) {
        b bVarD = D(u(str), bArr, 25, false);
        this.f34358b.add(bVarD);
        return (int) bVarD.f34368d;
    }

    public int j(byte[] bArr) {
        return i(null, bArr);
    }

    public void k(String str, boolean z10) {
        this.f34358b.add(b.g(u(str), z10));
    }

    public void l(boolean z10) {
        k(null, z10);
    }

    public void m(double d10) {
        o(null, d10);
    }

    public void n(float f10) {
        p(null, f10);
    }

    public void o(String str, double d10) {
        this.f34358b.add(b.k(u(str), d10));
    }

    public void p(String str, float f10) {
        this.f34358b.add(b.j(u(str), f10));
    }

    public void q(int i10) {
        s(null, i10);
    }

    public void r(long j10) {
        t(null, j10);
    }

    public void s(String str, int i10) {
        t(str, i10);
    }

    public void t(String str, long j10) {
        int iU = u(str);
        if (-128 <= j10 && j10 <= 127) {
            this.f34358b.add(b.o(iU, (int) j10));
            return;
        }
        if (-32768 <= j10 && j10 <= 32767) {
            this.f34358b.add(b.l(iU, (int) j10));
        } else if (-2147483648L > j10 || j10 > 2147483647L) {
            this.f34358b.add(b.n(iU, j10));
        } else {
            this.f34358b.add(b.m(iU, (int) j10));
        }
    }

    public final int u(String str) {
        if (str == null) {
            return -1;
        }
        int iE = this.f34357a.e();
        if ((this.f34361e & 1) == 0) {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            this.f34357a.j(bytes, 0, bytes.length);
            this.f34357a.g((byte) 0);
            this.f34359c.put(str, Integer.valueOf(iE));
            return iE;
        }
        Integer num = this.f34359c.get(str);
        if (num != null) {
            return num.intValue();
        }
        byte[] bytes2 = str.getBytes(StandardCharsets.UTF_8);
        this.f34357a.j(bytes2, 0, bytes2.length);
        this.f34357a.g((byte) 0);
        this.f34359c.put(str, Integer.valueOf(iE));
        return iE;
    }

    public void v() {
        w(null);
    }

    public void w(String str) {
        this.f34358b.add(b.p(u(str)));
    }

    public int x(String str) {
        return y(null, str);
    }

    public int y(String str, String str2) {
        int iU = u(str);
        if ((this.f34361e & 2) == 0) {
            b bVarH = H(iU, str2);
            this.f34358b.add(bVarH);
            return (int) bVarH.f34368d;
        }
        Integer num = this.f34360d.get(str2);
        if (num != null) {
            this.f34358b.add(b.f(iU, num.intValue(), 5, B(str2.length())));
            return num.intValue();
        }
        b bVarH2 = H(iU, str2);
        this.f34360d.put(str2, Integer.valueOf((int) bVarH2.f34368d));
        this.f34358b.add(bVarH2);
        return (int) bVarH2.f34368d;
    }

    public int z() {
        return this.f34358b.size();
    }

    public a() {
        this(256);
    }

    public a(d dVar, int i10) {
        this.f34358b = new ArrayList<>();
        this.f34359c = new HashMap<>();
        this.f34360d = new HashMap<>();
        this.f34362f = false;
        this.f34363g = new C0420a();
        this.f34357a = dVar;
        this.f34361e = i10;
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f34365a;

        /* renamed from: b, reason: collision with root package name */
        public final int f34366b;

        /* renamed from: c, reason: collision with root package name */
        public final double f34367c;

        /* renamed from: d, reason: collision with root package name */
        public long f34368d;

        /* renamed from: e, reason: collision with root package name */
        public int f34369e;

        public b(int i10, int i11, int i12, long j10) {
            this.f34369e = i10;
            this.f34365a = i11;
            this.f34366b = i12;
            this.f34368d = j10;
            this.f34367c = Double.MIN_VALUE;
        }

        public static b f(int i10, int i11, int i12, int i13) {
            return new b(i10, i12, i13, i11);
        }

        public static b g(int i10, boolean z10) {
            return new b(i10, 26, 0, z10 ? 1L : 0L);
        }

        public static int i(int i10, int i11, long j10, int i12, int i13) {
            if (FlexBuffers.i(i10)) {
                return i11;
            }
            for (int i14 = 1; i14 <= 32; i14 *= 2) {
                int iB = a.B(((r(i12, i14) + i12) + (i13 * i14)) - j10);
                if ((1 << iB) == i14) {
                    return iB;
                }
            }
            return 3;
        }

        public static b j(int i10, float f10) {
            return new b(i10, 3, 2, f10);
        }

        public static b k(int i10, double d10) {
            return new b(i10, 3, 3, d10);
        }

        public static b l(int i10, int i11) {
            return new b(i10, 1, 1, i11);
        }

        public static b m(int i10, int i11) {
            return new b(i10, 1, 2, i11);
        }

        public static b n(int i10, long j10) {
            return new b(i10, 1, 3, j10);
        }

        public static b o(int i10, int i11) {
            return new b(i10, 1, 0, i11);
        }

        public static b p(int i10) {
            return new b(i10, 0, 0, 0L);
        }

        public static byte q(int i10, int i11) {
            return (byte) (i10 | (i11 << 2));
        }

        public static int r(int i10, int i11) {
            return ((~i10) + 1) & (i11 - 1);
        }

        public final int h(int i10, int i11) {
            return i(this.f34365a, this.f34366b, this.f34368d, i10, i11);
        }

        public final byte s() {
            return t(0);
        }

        public final byte t(int i10) {
            return q(u(i10), this.f34365a);
        }

        public final int u(int i10) {
            return FlexBuffers.i(this.f34365a) ? Math.max(this.f34366b, i10) : this.f34366b;
        }

        public b(int i10, int i11, int i12, double d10) {
            this.f34369e = i10;
            this.f34365a = i11;
            this.f34366b = i12;
            this.f34367c = d10;
            this.f34368d = Long.MIN_VALUE;
        }
    }
}
