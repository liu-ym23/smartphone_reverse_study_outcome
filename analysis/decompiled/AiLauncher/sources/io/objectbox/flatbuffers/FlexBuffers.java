package io.objectbox.flatbuffers;

import com.fasterxml.jackson.core.JsonFactory;

/* loaded from: classes4.dex */
public class FlexBuffers {

    /* renamed from: a, reason: collision with root package name */
    public static final S8.c f34338a = new S8.a(new byte[]{0}, 1);

    public static class FlexBufferException extends RuntimeException {
        public FlexBufferException(String str) {
            super(str);
        }
    }

    public static class a extends g {

        /* renamed from: e, reason: collision with root package name */
        public static final a f34339e = new a(FlexBuffers.f34338a, 1, 1);

        public a(S8.c cVar, int i10, int i11) {
            super(cVar, i10, i11);
        }

        public static a c() {
            return f34339e;
        }

        @Override // io.objectbox.flatbuffers.FlexBuffers.e
        public StringBuilder a(StringBuilder sb2) {
            sb2.append(JsonFactory.DEFAULT_QUOTE_CHAR);
            sb2.append(this.f34344a.d(this.f34345b, b()));
            sb2.append(JsonFactory.DEFAULT_QUOTE_CHAR);
            return sb2;
        }

        @Override // io.objectbox.flatbuffers.FlexBuffers.g
        public /* bridge */ /* synthetic */ int b() {
            return super.b();
        }

        public byte[] d() {
            int iB = b();
            byte[] bArr = new byte[iB];
            for (int i10 = 0; i10 < iB; i10++) {
                bArr[i10] = this.f34344a.get(this.f34345b + i10);
            }
            return bArr;
        }

        @Override // io.objectbox.flatbuffers.FlexBuffers.e
        public String toString() {
            return this.f34344a.d(this.f34345b, b());
        }
    }

    public static class b extends e {

        /* renamed from: d, reason: collision with root package name */
        public static final b f34340d = new b(FlexBuffers.f34338a, 0, 0);

        public b(S8.c cVar, int i10, int i11) {
            super(cVar, i10, i11);
        }

        public static b c() {
            return f34340d;
        }

        @Override // io.objectbox.flatbuffers.FlexBuffers.e
        public StringBuilder a(StringBuilder sb2) {
            sb2.append(toString());
            return sb2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return bVar.f34345b == this.f34345b && bVar.f34346c == this.f34346c;
        }

        public int hashCode() {
            return this.f34346c ^ this.f34345b;
        }

        @Override // io.objectbox.flatbuffers.FlexBuffers.e
        public String toString() {
            int i10 = this.f34345b;
            while (this.f34344a.get(i10) != 0) {
                i10++;
            }
            int i11 = this.f34345b;
            return this.f34344a.d(i11, i10 - i11);
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final h f34341a;

        public c(h hVar) {
            this.f34341a = hVar;
        }

        public b a(int i10) {
            if (i10 >= b()) {
                return b.f34340d;
            }
            h hVar = this.f34341a;
            int i11 = hVar.f34345b + (i10 * hVar.f34346c);
            h hVar2 = this.f34341a;
            S8.c cVar = hVar2.f34344a;
            return new b(cVar, FlexBuffers.h(cVar, i11, hVar2.f34346c), 1);
        }

        public int b() {
            return this.f34341a.b();
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('[');
            for (int i10 = 0; i10 < this.f34341a.b(); i10++) {
                this.f34341a.d(i10).v(sb2);
                if (i10 != this.f34341a.b() - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }
    }

    public static class d extends j {

        /* renamed from: g, reason: collision with root package name */
        public static final d f34342g = new d(FlexBuffers.f34338a, 1, 1);

        /* renamed from: f, reason: collision with root package name */
        public final byte[] f34343f;

        public d(S8.c cVar, int i10, int i11) {
            super(cVar, i10, i11);
            this.f34343f = new byte[4];
        }

        public static d e() {
            return f34342g;
        }

        @Override // io.objectbox.flatbuffers.FlexBuffers.j, io.objectbox.flatbuffers.FlexBuffers.e
        public StringBuilder a(StringBuilder sb2) {
            sb2.append("{ ");
            c cVarF = f();
            int iB = b();
            j jVarG = g();
            for (int i10 = 0; i10 < iB; i10++) {
                sb2.append(JsonFactory.DEFAULT_QUOTE_CHAR);
                sb2.append(cVarF.a(i10).toString());
                sb2.append("\" : ");
                sb2.append(jVarG.d(i10).toString());
                if (i10 != iB - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append(" }");
            return sb2;
        }

        public c f() {
            int i10 = this.f34345b - (this.f34346c * 3);
            S8.c cVar = this.f34344a;
            int iH = FlexBuffers.h(cVar, i10, this.f34346c);
            S8.c cVar2 = this.f34344a;
            int i11 = this.f34346c;
            return new c(new h(cVar, iH, FlexBuffers.m(cVar2, i10 + i11, i11), 4));
        }

        public j g() {
            return new j(this.f34344a, this.f34345b, this.f34346c);
        }
    }

    public static abstract class e {

        /* renamed from: a, reason: collision with root package name */
        public S8.c f34344a;

        /* renamed from: b, reason: collision with root package name */
        public int f34345b;

        /* renamed from: c, reason: collision with root package name */
        public int f34346c;

        public e(S8.c cVar, int i10, int i11) {
            this.f34344a = cVar;
            this.f34345b = i10;
            this.f34346c = i11;
        }

        public abstract StringBuilder a(StringBuilder sb2);

        public String toString() {
            return a(new StringBuilder(128)).toString();
        }
    }

    public static class f {

        /* renamed from: f, reason: collision with root package name */
        public static final f f34347f = new f(FlexBuffers.f34338a, 0, 1, 0);

        /* renamed from: a, reason: collision with root package name */
        public S8.c f34348a;

        /* renamed from: b, reason: collision with root package name */
        public int f34349b;

        /* renamed from: c, reason: collision with root package name */
        public int f34350c;

        /* renamed from: d, reason: collision with root package name */
        public int f34351d;

        /* renamed from: e, reason: collision with root package name */
        public int f34352e;

        public f(S8.c cVar, int i10, int i11, int i12) {
            this(cVar, i10, i11, 1 << (i12 & 3), i12 >> 2);
        }

        public a b() {
            if (!m() && !t()) {
                return a.c();
            }
            S8.c cVar = this.f34348a;
            return new a(cVar, FlexBuffers.h(cVar, this.f34349b, this.f34350c), this.f34351d);
        }

        public boolean c() {
            return n() ? this.f34348a.get(this.f34349b) != 0 : j() != 0;
        }

        public double d() {
            int i10 = this.f34352e;
            if (i10 == 3) {
                return FlexBuffers.l(this.f34348a, this.f34349b, this.f34350c);
            }
            if (i10 == 1) {
                return FlexBuffers.m(this.f34348a, this.f34349b, this.f34350c);
            }
            if (i10 != 2) {
                if (i10 == 5) {
                    return Double.parseDouble(i());
                }
                if (i10 == 6) {
                    S8.c cVar = this.f34348a;
                    return FlexBuffers.m(cVar, FlexBuffers.h(cVar, this.f34349b, this.f34350c), this.f34351d);
                }
                if (i10 == 7) {
                    S8.c cVar2 = this.f34348a;
                    return FlexBuffers.o(cVar2, FlexBuffers.h(cVar2, this.f34349b, this.f34350c), this.f34351d);
                }
                if (i10 == 8) {
                    S8.c cVar3 = this.f34348a;
                    return FlexBuffers.l(cVar3, FlexBuffers.h(cVar3, this.f34349b, this.f34350c), this.f34351d);
                }
                if (i10 == 10) {
                    return k().b();
                }
                if (i10 != 26) {
                    return 0.0d;
                }
            }
            return FlexBuffers.o(this.f34348a, this.f34349b, this.f34350c);
        }

        public int e() {
            int i10 = this.f34352e;
            if (i10 == 1) {
                return FlexBuffers.m(this.f34348a, this.f34349b, this.f34350c);
            }
            if (i10 == 2) {
                return (int) FlexBuffers.o(this.f34348a, this.f34349b, this.f34350c);
            }
            if (i10 == 3) {
                return (int) FlexBuffers.l(this.f34348a, this.f34349b, this.f34350c);
            }
            if (i10 == 5) {
                return Integer.parseInt(i());
            }
            if (i10 == 6) {
                S8.c cVar = this.f34348a;
                return FlexBuffers.m(cVar, FlexBuffers.h(cVar, this.f34349b, this.f34350c), this.f34351d);
            }
            if (i10 == 7) {
                S8.c cVar2 = this.f34348a;
                return (int) FlexBuffers.o(cVar2, FlexBuffers.h(cVar2, this.f34349b, this.f34350c), this.f34350c);
            }
            if (i10 == 8) {
                S8.c cVar3 = this.f34348a;
                return (int) FlexBuffers.l(cVar3, FlexBuffers.h(cVar3, this.f34349b, this.f34350c), this.f34351d);
            }
            if (i10 == 10) {
                return k().b();
            }
            if (i10 != 26) {
                return 0;
            }
            return FlexBuffers.m(this.f34348a, this.f34349b, this.f34350c);
        }

        public b f() {
            if (!q()) {
                return b.c();
            }
            S8.c cVar = this.f34348a;
            return new b(cVar, FlexBuffers.h(cVar, this.f34349b, this.f34350c), this.f34351d);
        }

        public long g() {
            int i10 = this.f34352e;
            if (i10 == 1) {
                return FlexBuffers.n(this.f34348a, this.f34349b, this.f34350c);
            }
            if (i10 == 2) {
                return FlexBuffers.o(this.f34348a, this.f34349b, this.f34350c);
            }
            if (i10 == 3) {
                return (long) FlexBuffers.l(this.f34348a, this.f34349b, this.f34350c);
            }
            if (i10 == 5) {
                try {
                    return Long.parseLong(i());
                } catch (NumberFormatException unused) {
                    return 0L;
                }
            }
            if (i10 == 6) {
                S8.c cVar = this.f34348a;
                return FlexBuffers.n(cVar, FlexBuffers.h(cVar, this.f34349b, this.f34350c), this.f34351d);
            }
            if (i10 == 7) {
                S8.c cVar2 = this.f34348a;
                return FlexBuffers.o(cVar2, FlexBuffers.h(cVar2, this.f34349b, this.f34350c), this.f34350c);
            }
            if (i10 == 8) {
                S8.c cVar3 = this.f34348a;
                return (long) FlexBuffers.l(cVar3, FlexBuffers.h(cVar3, this.f34349b, this.f34350c), this.f34351d);
            }
            if (i10 == 10) {
                return k().b();
            }
            if (i10 != 26) {
                return 0L;
            }
            return FlexBuffers.m(this.f34348a, this.f34349b, this.f34350c);
        }

        public d h() {
            if (!r()) {
                return d.e();
            }
            S8.c cVar = this.f34348a;
            return new d(cVar, FlexBuffers.h(cVar, this.f34349b, this.f34350c), this.f34351d);
        }

        public String i() {
            if (t()) {
                int iH = FlexBuffers.h(this.f34348a, this.f34349b, this.f34350c);
                S8.c cVar = this.f34348a;
                int i10 = this.f34351d;
                return this.f34348a.d(iH, (int) FlexBuffers.o(cVar, iH - i10, i10));
            }
            if (!q()) {
                return "";
            }
            int iH2 = FlexBuffers.h(this.f34348a, this.f34349b, this.f34351d);
            int i11 = iH2;
            while (this.f34348a.get(i11) != 0) {
                i11++;
            }
            return this.f34348a.d(iH2, i11 - iH2);
        }

        public long j() {
            int i10 = this.f34352e;
            if (i10 == 2) {
                return FlexBuffers.o(this.f34348a, this.f34349b, this.f34350c);
            }
            if (i10 == 1) {
                return FlexBuffers.n(this.f34348a, this.f34349b, this.f34350c);
            }
            if (i10 == 3) {
                return (long) FlexBuffers.l(this.f34348a, this.f34349b, this.f34350c);
            }
            if (i10 == 10) {
                return k().b();
            }
            if (i10 == 26) {
                return FlexBuffers.m(this.f34348a, this.f34349b, this.f34350c);
            }
            if (i10 == 5) {
                return Long.parseLong(i());
            }
            if (i10 == 6) {
                S8.c cVar = this.f34348a;
                return FlexBuffers.n(cVar, FlexBuffers.h(cVar, this.f34349b, this.f34350c), this.f34351d);
            }
            if (i10 == 7) {
                S8.c cVar2 = this.f34348a;
                return FlexBuffers.o(cVar2, FlexBuffers.h(cVar2, this.f34349b, this.f34350c), this.f34351d);
            }
            if (i10 != 8) {
                return 0L;
            }
            S8.c cVar3 = this.f34348a;
            return (long) FlexBuffers.l(cVar3, FlexBuffers.h(cVar3, this.f34349b, this.f34350c), this.f34350c);
        }

        public j k() {
            if (u()) {
                S8.c cVar = this.f34348a;
                return new j(cVar, FlexBuffers.h(cVar, this.f34349b, this.f34350c), this.f34351d);
            }
            int i10 = this.f34352e;
            if (i10 == 15) {
                S8.c cVar2 = this.f34348a;
                return new h(cVar2, FlexBuffers.h(cVar2, this.f34349b, this.f34350c), this.f34351d, 4);
            }
            if (!FlexBuffers.j(i10)) {
                return j.c();
            }
            S8.c cVar3 = this.f34348a;
            return new h(cVar3, FlexBuffers.h(cVar3, this.f34349b, this.f34350c), this.f34351d, FlexBuffers.q(this.f34352e));
        }

        public int l() {
            return this.f34352e;
        }

        public boolean m() {
            return this.f34352e == 25;
        }

        public boolean n() {
            return this.f34352e == 26;
        }

        public boolean o() {
            int i10 = this.f34352e;
            return i10 == 3 || i10 == 8;
        }

        public boolean p() {
            int i10 = this.f34352e;
            return i10 == 1 || i10 == 6;
        }

        public boolean q() {
            return this.f34352e == 4;
        }

        public boolean r() {
            return this.f34352e == 9;
        }

        public boolean s() {
            return this.f34352e == 0;
        }

        public boolean t() {
            return this.f34352e == 5;
        }

        public String toString() {
            return v(new StringBuilder(128)).toString();
        }

        public boolean u() {
            int i10 = this.f34352e;
            return i10 == 10 || i10 == 9;
        }

        public StringBuilder v(StringBuilder sb2) {
            int i10 = this.f34352e;
            if (i10 != 36) {
                switch (i10) {
                    case 0:
                        sb2.append("null");
                        return sb2;
                    case 1:
                    case 6:
                        sb2.append(g());
                        return sb2;
                    case 2:
                    case 7:
                        sb2.append(j());
                        return sb2;
                    case 3:
                    case 8:
                        sb2.append(d());
                        return sb2;
                    case 4:
                        b bVarF = f();
                        sb2.append(JsonFactory.DEFAULT_QUOTE_CHAR);
                        StringBuilder sbA = bVarF.a(sb2);
                        sbA.append(JsonFactory.DEFAULT_QUOTE_CHAR);
                        return sbA;
                    case 5:
                        sb2.append(JsonFactory.DEFAULT_QUOTE_CHAR);
                        sb2.append(i());
                        sb2.append(JsonFactory.DEFAULT_QUOTE_CHAR);
                        return sb2;
                    case 9:
                        return h().a(sb2);
                    case 10:
                        return k().a(sb2);
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        break;
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                        throw new FlexBufferException("not_implemented:" + this.f34352e);
                    case 25:
                        return b().a(sb2);
                    case 26:
                        sb2.append(c());
                        return sb2;
                    default:
                        return sb2;
                }
            }
            sb2.append(k());
            return sb2;
        }

        public f(S8.c cVar, int i10, int i11, int i12, int i13) {
            this.f34348a = cVar;
            this.f34349b = i10;
            this.f34350c = i11;
            this.f34351d = i12;
            this.f34352e = i13;
        }
    }

    public static abstract class g extends e {

        /* renamed from: d, reason: collision with root package name */
        public final int f34353d;

        public g(S8.c cVar, int i10, int i11) {
            super(cVar, i10, i11);
            this.f34353d = (int) FlexBuffers.o(this.f34344a, i10 - i11, i11);
        }

        public int b() {
            return this.f34353d;
        }
    }

    public static class h extends j {

        /* renamed from: g, reason: collision with root package name */
        public static final h f34354g = new h(FlexBuffers.f34338a, 1, 1, 1);

        /* renamed from: f, reason: collision with root package name */
        public final int f34355f;

        public h(S8.c cVar, int i10, int i11, int i12) {
            super(cVar, i10, i11);
            this.f34355f = i12;
        }

        @Override // io.objectbox.flatbuffers.FlexBuffers.j
        public f d(int i10) {
            if (i10 >= b()) {
                return f.f34347f;
            }
            return new f(this.f34344a, this.f34345b + (i10 * this.f34346c), this.f34346c, 1, this.f34355f);
        }
    }

    public static class i {
        public static int a(byte b10) {
            return b10 & 255;
        }

        public static long b(int i10) {
            return i10 & 4294967295L;
        }

        public static int c(short s10) {
            return s10 & 65535;
        }
    }

    public static class j extends g {

        /* renamed from: e, reason: collision with root package name */
        public static final j f34356e = new j(FlexBuffers.f34338a, 1, 1);

        public j(S8.c cVar, int i10, int i11) {
            super(cVar, i10, i11);
        }

        public static j c() {
            return f34356e;
        }

        @Override // io.objectbox.flatbuffers.FlexBuffers.e
        public StringBuilder a(StringBuilder sb2) {
            sb2.append("[ ");
            int iB = b();
            for (int i10 = 0; i10 < iB; i10++) {
                d(i10).v(sb2);
                if (i10 != iB - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append(" ]");
            return sb2;
        }

        @Override // io.objectbox.flatbuffers.FlexBuffers.g
        public /* bridge */ /* synthetic */ int b() {
            return super.b();
        }

        public f d(int i10) {
            long jB = b();
            long j10 = i10;
            if (j10 >= jB) {
                return f.f34347f;
            }
            return new f(this.f34344a, this.f34345b + (i10 * this.f34346c), this.f34346c, i.a(this.f34344a.get((int) (this.f34345b + (jB * this.f34346c) + j10))));
        }

        @Override // io.objectbox.flatbuffers.FlexBuffers.e
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }
    }

    public static f g(S8.c cVar) {
        int iA = cVar.a();
        byte b10 = cVar.get(iA - 1);
        int i10 = iA - 2;
        return new f(cVar, i10 - b10, b10, i.a(cVar.get(i10)));
    }

    public static int h(S8.c cVar, int i10, int i11) {
        return (int) (i10 - o(cVar, i10, i11));
    }

    public static boolean i(int i10) {
        return i10 <= 3 || i10 == 26;
    }

    public static boolean j(int i10) {
        return (i10 >= 11 && i10 <= 15) || i10 == 36;
    }

    public static boolean k(int i10) {
        return (i10 >= 1 && i10 <= 4) || i10 == 26;
    }

    public static double l(S8.c cVar, int i10, int i11) {
        if (i11 == 4) {
            return cVar.getFloat(i10);
        }
        if (i11 != 8) {
            return -1.0d;
        }
        return cVar.getDouble(i10);
    }

    public static int m(S8.c cVar, int i10, int i11) {
        return (int) n(cVar, i10, i11);
    }

    public static long n(S8.c cVar, int i10, int i11) {
        int i12;
        if (i11 == 1) {
            i12 = cVar.get(i10);
        } else if (i11 == 2) {
            i12 = cVar.getShort(i10);
        } else {
            if (i11 != 4) {
                if (i11 != 8) {
                    return -1L;
                }
                return cVar.getLong(i10);
            }
            i12 = cVar.getInt(i10);
        }
        return i12;
    }

    public static long o(S8.c cVar, int i10, int i11) {
        if (i11 == 1) {
            return i.a(cVar.get(i10));
        }
        if (i11 == 2) {
            return i.c(cVar.getShort(i10));
        }
        if (i11 == 4) {
            return i.b(cVar.getInt(i10));
        }
        if (i11 != 8) {
            return -1L;
        }
        return cVar.getLong(i10);
    }

    public static int p(int i10, int i11) {
        if (i11 == 0) {
            return i10 + 10;
        }
        if (i11 == 2) {
            return i10 + 15;
        }
        if (i11 == 3) {
            return i10 + 18;
        }
        if (i11 != 4) {
            return 0;
        }
        return i10 + 21;
    }

    public static int q(int i10) {
        return i10 - 10;
    }
}
