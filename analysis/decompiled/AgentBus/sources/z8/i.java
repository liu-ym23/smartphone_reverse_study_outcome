package z8;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class i extends f9.l {
    public static final i O;
    public static final c9.a P = new c9.a(8);
    public int A;
    public int B;
    public p0 C;
    public int D;
    public List E;
    public int F;
    public List G;
    public List H;
    public int I;
    public v0 J;
    public List K;
    public c1 L;
    public byte M;
    public int N;

    /* renamed from: g, reason: collision with root package name */
    public final f9.d f12186g;

    /* renamed from: h, reason: collision with root package name */
    public int f12187h;

    /* renamed from: i, reason: collision with root package name */
    public int f12188i;

    /* renamed from: j, reason: collision with root package name */
    public int f12189j;

    /* renamed from: k, reason: collision with root package name */
    public int f12190k;

    /* renamed from: l, reason: collision with root package name */
    public List f12191l;

    /* renamed from: m, reason: collision with root package name */
    public List f12192m;

    /* renamed from: n, reason: collision with root package name */
    public List f12193n;

    /* renamed from: o, reason: collision with root package name */
    public int f12194o;

    /* renamed from: p, reason: collision with root package name */
    public List f12195p;

    /* renamed from: q, reason: collision with root package name */
    public int f12196q;

    /* renamed from: r, reason: collision with root package name */
    public List f12197r;

    /* renamed from: s, reason: collision with root package name */
    public List f12198s;

    /* renamed from: t, reason: collision with root package name */
    public int f12199t;

    /* renamed from: u, reason: collision with root package name */
    public List f12200u;

    /* renamed from: v, reason: collision with root package name */
    public List f12201v;

    /* renamed from: w, reason: collision with root package name */
    public List f12202w;

    /* renamed from: x, reason: collision with root package name */
    public List f12203x;

    /* renamed from: y, reason: collision with root package name */
    public List f12204y;

    /* renamed from: z, reason: collision with root package name */
    public List f12205z;

    static {
        i iVar = new i();
        O = iVar;
        iVar.n();
    }

    public i(g gVar) {
        super(gVar);
        this.f12194o = -1;
        this.f12196q = -1;
        this.f12199t = -1;
        this.A = -1;
        this.F = -1;
        this.I = -1;
        this.M = (byte) -1;
        this.N = -1;
        this.f12186g = gVar.f3565f;
    }

    @Override // f9.a
    public final int a() {
        int i2 = this.N;
        if (i2 != -1) {
            return i2;
        }
        int iB = (this.f12187h & 1) == 1 ? f9.f.b(1, this.f12188i) : 0;
        int iC = 0;
        for (int i10 = 0; i10 < this.f12193n.size(); i10++) {
            iC += f9.f.c(((Integer) this.f12193n.get(i10)).intValue());
        }
        int iD = iB + iC;
        if (!this.f12193n.isEmpty()) {
            iD = iD + 1 + f9.f.c(iC);
        }
        this.f12194o = iC;
        if ((this.f12187h & 2) == 2) {
            iD += f9.f.b(3, this.f12189j);
        }
        if ((this.f12187h & 4) == 4) {
            iD += f9.f.b(4, this.f12190k);
        }
        for (int i11 = 0; i11 < this.f12191l.size(); i11++) {
            iD += f9.f.d(5, (f9.a) this.f12191l.get(i11));
        }
        for (int i12 = 0; i12 < this.f12192m.size(); i12++) {
            iD += f9.f.d(6, (f9.a) this.f12192m.get(i12));
        }
        int iC2 = 0;
        for (int i13 = 0; i13 < this.f12195p.size(); i13++) {
            iC2 += f9.f.c(((Integer) this.f12195p.get(i13)).intValue());
        }
        int iD2 = iD + iC2;
        if (!this.f12195p.isEmpty()) {
            iD2 = iD2 + 1 + f9.f.c(iC2);
        }
        this.f12196q = iC2;
        for (int i14 = 0; i14 < this.f12200u.size(); i14++) {
            iD2 += f9.f.d(8, (f9.a) this.f12200u.get(i14));
        }
        for (int i15 = 0; i15 < this.f12201v.size(); i15++) {
            iD2 += f9.f.d(9, (f9.a) this.f12201v.get(i15));
        }
        for (int i16 = 0; i16 < this.f12202w.size(); i16++) {
            iD2 += f9.f.d(10, (f9.a) this.f12202w.get(i16));
        }
        for (int i17 = 0; i17 < this.f12203x.size(); i17++) {
            iD2 += f9.f.d(11, (f9.a) this.f12203x.get(i17));
        }
        for (int i18 = 0; i18 < this.f12204y.size(); i18++) {
            iD2 += f9.f.d(13, (f9.a) this.f12204y.get(i18));
        }
        int iC3 = 0;
        for (int i19 = 0; i19 < this.f12205z.size(); i19++) {
            iC3 += f9.f.c(((Integer) this.f12205z.get(i19)).intValue());
        }
        int iD3 = iD2 + iC3;
        if (!this.f12205z.isEmpty()) {
            iD3 = iD3 + 2 + f9.f.c(iC3);
        }
        this.A = iC3;
        if ((this.f12187h & 8) == 8) {
            iD3 += f9.f.b(17, this.B);
        }
        if ((this.f12187h & 16) == 16) {
            iD3 += f9.f.d(18, this.C);
        }
        if ((this.f12187h & 32) == 32) {
            iD3 += f9.f.b(19, this.D);
        }
        for (int i20 = 0; i20 < this.f12197r.size(); i20++) {
            iD3 += f9.f.d(20, (f9.a) this.f12197r.get(i20));
        }
        int iC4 = 0;
        for (int i21 = 0; i21 < this.f12198s.size(); i21++) {
            iC4 += f9.f.c(((Integer) this.f12198s.get(i21)).intValue());
        }
        int iC5 = iD3 + iC4;
        if (!this.f12198s.isEmpty()) {
            iC5 = iC5 + 2 + f9.f.c(iC4);
        }
        this.f12199t = iC4;
        int iC6 = 0;
        for (int i22 = 0; i22 < this.E.size(); i22++) {
            iC6 += f9.f.c(((Integer) this.E.get(i22)).intValue());
        }
        int iD4 = iC5 + iC6;
        if (!this.E.isEmpty()) {
            iD4 = iD4 + 2 + f9.f.c(iC6);
        }
        this.F = iC6;
        for (int i23 = 0; i23 < this.G.size(); i23++) {
            iD4 += f9.f.d(23, (f9.a) this.G.get(i23));
        }
        int iC7 = 0;
        for (int i24 = 0; i24 < this.H.size(); i24++) {
            iC7 += f9.f.c(((Integer) this.H.get(i24)).intValue());
        }
        int iD5 = iD4 + iC7;
        if (!this.H.isEmpty()) {
            iD5 = iD5 + 2 + f9.f.c(iC7);
        }
        this.I = iC7;
        if ((this.f12187h & 64) == 64) {
            iD5 += f9.f.d(30, this.J);
        }
        int iC8 = 0;
        for (int i25 = 0; i25 < this.K.size(); i25++) {
            iC8 += f9.f.c(((Integer) this.K.get(i25)).intValue());
        }
        int size = (this.K.size() * 2) + iD5 + iC8;
        if ((this.f12187h & 128) == 128) {
            size += f9.f.d(32, this.L);
        }
        int size2 = this.f12186g.size() + h() + size;
        this.N = size2;
        return size2;
    }

    @Override // f9.a
    public final f9.j b() {
        return g.f();
    }

    @Override // f9.a
    public final f9.j c() {
        g gVarF = g.f();
        gVarF.g(this);
        return gVarF;
    }

    @Override // f9.a
    public final void d(f9.f fVar) throws IOException {
        a();
        q6.b bVar = new q6.b((f9.l) this);
        if ((this.f12187h & 1) == 1) {
            fVar.m(1, this.f12188i);
        }
        if (this.f12193n.size() > 0) {
            fVar.v(18);
            fVar.v(this.f12194o);
        }
        for (int i2 = 0; i2 < this.f12193n.size(); i2++) {
            fVar.n(((Integer) this.f12193n.get(i2)).intValue());
        }
        if ((this.f12187h & 2) == 2) {
            fVar.m(3, this.f12189j);
        }
        if ((this.f12187h & 4) == 4) {
            fVar.m(4, this.f12190k);
        }
        for (int i10 = 0; i10 < this.f12191l.size(); i10++) {
            fVar.o(5, (f9.a) this.f12191l.get(i10));
        }
        for (int i11 = 0; i11 < this.f12192m.size(); i11++) {
            fVar.o(6, (f9.a) this.f12192m.get(i11));
        }
        if (this.f12195p.size() > 0) {
            fVar.v(58);
            fVar.v(this.f12196q);
        }
        for (int i12 = 0; i12 < this.f12195p.size(); i12++) {
            fVar.n(((Integer) this.f12195p.get(i12)).intValue());
        }
        for (int i13 = 0; i13 < this.f12200u.size(); i13++) {
            fVar.o(8, (f9.a) this.f12200u.get(i13));
        }
        for (int i14 = 0; i14 < this.f12201v.size(); i14++) {
            fVar.o(9, (f9.a) this.f12201v.get(i14));
        }
        for (int i15 = 0; i15 < this.f12202w.size(); i15++) {
            fVar.o(10, (f9.a) this.f12202w.get(i15));
        }
        for (int i16 = 0; i16 < this.f12203x.size(); i16++) {
            fVar.o(11, (f9.a) this.f12203x.get(i16));
        }
        for (int i17 = 0; i17 < this.f12204y.size(); i17++) {
            fVar.o(13, (f9.a) this.f12204y.get(i17));
        }
        if (this.f12205z.size() > 0) {
            fVar.v(130);
            fVar.v(this.A);
        }
        for (int i18 = 0; i18 < this.f12205z.size(); i18++) {
            fVar.n(((Integer) this.f12205z.get(i18)).intValue());
        }
        if ((this.f12187h & 8) == 8) {
            fVar.m(17, this.B);
        }
        if ((this.f12187h & 16) == 16) {
            fVar.o(18, this.C);
        }
        if ((this.f12187h & 32) == 32) {
            fVar.m(19, this.D);
        }
        for (int i19 = 0; i19 < this.f12197r.size(); i19++) {
            fVar.o(20, (f9.a) this.f12197r.get(i19));
        }
        if (this.f12198s.size() > 0) {
            fVar.v(170);
            fVar.v(this.f12199t);
        }
        for (int i20 = 0; i20 < this.f12198s.size(); i20++) {
            fVar.n(((Integer) this.f12198s.get(i20)).intValue());
        }
        if (this.E.size() > 0) {
            fVar.v(178);
            fVar.v(this.F);
        }
        for (int i21 = 0; i21 < this.E.size(); i21++) {
            fVar.n(((Integer) this.E.get(i21)).intValue());
        }
        for (int i22 = 0; i22 < this.G.size(); i22++) {
            fVar.o(23, (f9.a) this.G.get(i22));
        }
        if (this.H.size() > 0) {
            fVar.v(194);
            fVar.v(this.I);
        }
        for (int i23 = 0; i23 < this.H.size(); i23++) {
            fVar.n(((Integer) this.H.get(i23)).intValue());
        }
        if ((this.f12187h & 64) == 64) {
            fVar.o(30, this.J);
        }
        for (int i24 = 0; i24 < this.K.size(); i24++) {
            fVar.m(31, ((Integer) this.K.get(i24)).intValue());
        }
        if ((this.f12187h & 128) == 128) {
            fVar.o(32, this.L);
        }
        bVar.Q0(19000, fVar);
        fVar.r(this.f12186g);
    }

    @Override // f9.v
    public final f9.a getDefaultInstanceForType() {
        return O;
    }

    @Override // f9.v
    public final boolean isInitialized() {
        byte b10 = this.M;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        if ((this.f12187h & 2) != 2) {
            this.M = (byte) 0;
            return false;
        }
        for (int i2 = 0; i2 < this.f12191l.size(); i2++) {
            if (!((u0) this.f12191l.get(i2)).isInitialized()) {
                this.M = (byte) 0;
                return false;
            }
        }
        for (int i10 = 0; i10 < this.f12192m.size(); i10++) {
            if (!((p0) this.f12192m.get(i10)).isInitialized()) {
                this.M = (byte) 0;
                return false;
            }
        }
        for (int i11 = 0; i11 < this.f12197r.size(); i11++) {
            if (!((p0) this.f12197r.get(i11)).isInitialized()) {
                this.M = (byte) 0;
                return false;
            }
        }
        for (int i12 = 0; i12 < this.f12200u.size(); i12++) {
            if (!((k) this.f12200u.get(i12)).isInitialized()) {
                this.M = (byte) 0;
                return false;
            }
        }
        for (int i13 = 0; i13 < this.f12201v.size(); i13++) {
            if (!((x) this.f12201v.get(i13)).isInitialized()) {
                this.M = (byte) 0;
                return false;
            }
        }
        for (int i14 = 0; i14 < this.f12202w.size(); i14++) {
            if (!((f0) this.f12202w.get(i14)).isInitialized()) {
                this.M = (byte) 0;
                return false;
            }
        }
        for (int i15 = 0; i15 < this.f12203x.size(); i15++) {
            if (!((r0) this.f12203x.get(i15)).isInitialized()) {
                this.M = (byte) 0;
                return false;
            }
        }
        for (int i16 = 0; i16 < this.f12204y.size(); i16++) {
            if (!((s) this.f12204y.get(i16)).isInitialized()) {
                this.M = (byte) 0;
                return false;
            }
        }
        if ((this.f12187h & 16) == 16 && !this.C.isInitialized()) {
            this.M = (byte) 0;
            return false;
        }
        for (int i17 = 0; i17 < this.G.size(); i17++) {
            if (!((p0) this.G.get(i17)).isInitialized()) {
                this.M = (byte) 0;
                return false;
            }
        }
        if ((this.f12187h & 64) == 64 && !this.J.isInitialized()) {
            this.M = (byte) 0;
            return false;
        }
        if (g()) {
            this.M = (byte) 1;
            return true;
        }
        this.M = (byte) 0;
        return false;
    }

    public final void n() {
        this.f12188i = 6;
        this.f12189j = 0;
        this.f12190k = 0;
        List list = Collections.EMPTY_LIST;
        this.f12191l = list;
        this.f12192m = list;
        this.f12193n = list;
        this.f12195p = list;
        this.f12197r = list;
        this.f12198s = list;
        this.f12200u = list;
        this.f12201v = list;
        this.f12202w = list;
        this.f12203x = list;
        this.f12204y = list;
        this.f12205z = list;
        this.B = 0;
        this.C = p0.f12298y;
        this.D = 0;
        this.E = list;
        this.G = list;
        this.H = list;
        this.J = v0.f12413l;
        this.K = list;
        this.L = c1.f12079j;
    }

    public i() {
        this.f12194o = -1;
        this.f12196q = -1;
        this.f12199t = -1;
        this.A = -1;
        this.F = -1;
        this.I = -1;
        this.M = (byte) -1;
        this.N = -1;
        this.f12186g = f9.d.f3536f;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004d  */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Type inference failed for: r7v35 */
    /* JADX WARN: Type inference failed for: r7v37 */
    /* JADX WARN: Type inference failed for: r7v39 */
    /* JADX WARN: Type inference failed for: r7v41 */
    /* JADX WARN: Type inference failed for: r7v43 */
    /* JADX WARN: Type inference failed for: r7v45 */
    /* JADX WARN: Type inference failed for: r7v47 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public i(f9.e r22, f9.h r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1756
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z8.i.<init>(f9.e, f9.h):void");
    }
}
