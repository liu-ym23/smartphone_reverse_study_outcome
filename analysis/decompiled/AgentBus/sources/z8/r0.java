package z8;

import com.stepos.account.oauth.OAuthConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class r0 extends f9.l {

    /* renamed from: t, reason: collision with root package name */
    public static final r0 f12340t;

    /* renamed from: u, reason: collision with root package name */
    public static final c9.a f12341u = new c9.a(23);

    /* renamed from: g, reason: collision with root package name */
    public final f9.d f12342g;

    /* renamed from: h, reason: collision with root package name */
    public int f12343h;

    /* renamed from: i, reason: collision with root package name */
    public int f12344i;

    /* renamed from: j, reason: collision with root package name */
    public int f12345j;

    /* renamed from: k, reason: collision with root package name */
    public List f12346k;

    /* renamed from: l, reason: collision with root package name */
    public p0 f12347l;

    /* renamed from: m, reason: collision with root package name */
    public int f12348m;

    /* renamed from: n, reason: collision with root package name */
    public p0 f12349n;

    /* renamed from: o, reason: collision with root package name */
    public int f12350o;

    /* renamed from: p, reason: collision with root package name */
    public List f12351p;

    /* renamed from: q, reason: collision with root package name */
    public List f12352q;

    /* renamed from: r, reason: collision with root package name */
    public byte f12353r;

    /* renamed from: s, reason: collision with root package name */
    public int f12354s;

    static {
        r0 r0Var = new r0();
        f12340t = r0Var;
        r0Var.f12344i = 6;
        r0Var.f12345j = 0;
        List list = Collections.EMPTY_LIST;
        r0Var.f12346k = list;
        p0 p0Var = p0.f12298y;
        r0Var.f12347l = p0Var;
        r0Var.f12348m = 0;
        r0Var.f12349n = p0Var;
        r0Var.f12350o = 0;
        r0Var.f12351p = list;
        r0Var.f12352q = list;
    }

    public r0(q0 q0Var) {
        super(q0Var);
        this.f12353r = (byte) -1;
        this.f12354s = -1;
        this.f12342g = q0Var.f3565f;
    }

    @Override // f9.a
    public final int a() {
        int i2 = this.f12354s;
        if (i2 != -1) {
            return i2;
        }
        int iB = (this.f12343h & 1) == 1 ? f9.f.b(1, this.f12344i) : 0;
        if ((this.f12343h & 2) == 2) {
            iB += f9.f.b(2, this.f12345j);
        }
        for (int i10 = 0; i10 < this.f12346k.size(); i10++) {
            iB += f9.f.d(3, (f9.a) this.f12346k.get(i10));
        }
        if ((this.f12343h & 4) == 4) {
            iB += f9.f.d(4, this.f12347l);
        }
        if ((this.f12343h & 8) == 8) {
            iB += f9.f.b(5, this.f12348m);
        }
        if ((this.f12343h & 16) == 16) {
            iB += f9.f.d(6, this.f12349n);
        }
        if ((this.f12343h & 32) == 32) {
            iB += f9.f.b(7, this.f12350o);
        }
        for (int i11 = 0; i11 < this.f12351p.size(); i11++) {
            iB += f9.f.d(8, (f9.a) this.f12351p.get(i11));
        }
        int iC = 0;
        for (int i12 = 0; i12 < this.f12352q.size(); i12++) {
            iC += f9.f.c(((Integer) this.f12352q.get(i12)).intValue());
        }
        int size = this.f12342g.size() + h() + (this.f12352q.size() * 2) + iB + iC;
        this.f12354s = size;
        return size;
    }

    @Override // f9.a
    public final f9.j b() {
        return q0.f();
    }

    @Override // f9.a
    public final f9.j c() {
        q0 q0VarF = q0.f();
        q0VarF.g(this);
        return q0VarF;
    }

    @Override // f9.a
    public final void d(f9.f fVar) throws IOException {
        a();
        q6.b bVar = new q6.b((f9.l) this);
        if ((this.f12343h & 1) == 1) {
            fVar.m(1, this.f12344i);
        }
        if ((this.f12343h & 2) == 2) {
            fVar.m(2, this.f12345j);
        }
        for (int i2 = 0; i2 < this.f12346k.size(); i2++) {
            fVar.o(3, (f9.a) this.f12346k.get(i2));
        }
        if ((this.f12343h & 4) == 4) {
            fVar.o(4, this.f12347l);
        }
        if ((this.f12343h & 8) == 8) {
            fVar.m(5, this.f12348m);
        }
        if ((this.f12343h & 16) == 16) {
            fVar.o(6, this.f12349n);
        }
        if ((this.f12343h & 32) == 32) {
            fVar.m(7, this.f12350o);
        }
        for (int i10 = 0; i10 < this.f12351p.size(); i10++) {
            fVar.o(8, (f9.a) this.f12351p.get(i10));
        }
        for (int i11 = 0; i11 < this.f12352q.size(); i11++) {
            fVar.m(31, ((Integer) this.f12352q.get(i11)).intValue());
        }
        bVar.Q0(OAuthConstants.RESPONSE_CODE_OK, fVar);
        fVar.r(this.f12342g);
    }

    @Override // f9.v
    public final f9.a getDefaultInstanceForType() {
        return f12340t;
    }

    @Override // f9.v
    public final boolean isInitialized() {
        byte b10 = this.f12353r;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        if ((this.f12343h & 2) != 2) {
            this.f12353r = (byte) 0;
            return false;
        }
        for (int i2 = 0; i2 < this.f12346k.size(); i2++) {
            if (!((u0) this.f12346k.get(i2)).isInitialized()) {
                this.f12353r = (byte) 0;
                return false;
            }
        }
        if ((this.f12343h & 4) == 4 && !this.f12347l.isInitialized()) {
            this.f12353r = (byte) 0;
            return false;
        }
        if ((this.f12343h & 16) == 16 && !this.f12349n.isInitialized()) {
            this.f12353r = (byte) 0;
            return false;
        }
        for (int i10 = 0; i10 < this.f12351p.size(); i10++) {
            if (!((f) this.f12351p.get(i10)).isInitialized()) {
                this.f12353r = (byte) 0;
                return false;
            }
        }
        if (g()) {
            this.f12353r = (byte) 1;
            return true;
        }
        this.f12353r = (byte) 0;
        return false;
    }

    public r0() {
        this.f12353r = (byte) -1;
        this.f12354s = -1;
        this.f12342g = f9.d.f3536f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
    public r0(f9.e eVar, f9.h hVar) {
        this.f12353r = (byte) -1;
        this.f12354s = -1;
        this.f12344i = 6;
        boolean z4 = false;
        this.f12345j = 0;
        List list = Collections.EMPTY_LIST;
        this.f12346k = list;
        p0 p0Var = p0.f12298y;
        this.f12347l = p0Var;
        this.f12348m = 0;
        this.f12349n = p0Var;
        this.f12350o = 0;
        this.f12351p = list;
        this.f12352q = list;
        f9.c cVar = new f9.c();
        f9.f fVarJ = f9.f.j(cVar, 1);
        int i2 = 0;
        while (true) {
            ?? L = 128;
            if (!z4) {
                try {
                    try {
                        try {
                            int iN = eVar.n();
                            o0 o0VarP = null;
                            switch (iN) {
                                case 0:
                                    z4 = true;
                                case 8:
                                    this.f12343h |= 1;
                                    this.f12344i = eVar.k();
                                case 16:
                                    this.f12343h |= 2;
                                    this.f12345j = eVar.k();
                                case 26:
                                    if ((i2 & 4) != 4) {
                                        this.f12346k = new ArrayList();
                                        i2 |= 4;
                                    }
                                    this.f12346k.add(eVar.g(u0.f12388s, hVar));
                                case 34:
                                    if ((this.f12343h & 4) == 4) {
                                        p0 p0Var2 = this.f12347l;
                                        p0Var2.getClass();
                                        o0VarP = p0.p(p0Var2);
                                    }
                                    p0 p0Var3 = (p0) eVar.g(p0.f12299z, hVar);
                                    this.f12347l = p0Var3;
                                    if (o0VarP != null) {
                                        o0VarP.g(p0Var3);
                                        this.f12347l = o0VarP.e();
                                    }
                                    this.f12343h |= 4;
                                case com.google.protobuf.a1.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                                    this.f12343h |= 8;
                                    this.f12348m = eVar.k();
                                case 50:
                                    if ((this.f12343h & 16) == 16) {
                                        p0 p0Var4 = this.f12349n;
                                        p0Var4.getClass();
                                        o0VarP = p0.p(p0Var4);
                                    }
                                    p0 p0Var5 = (p0) eVar.g(p0.f12299z, hVar);
                                    this.f12349n = p0Var5;
                                    if (o0VarP != null) {
                                        o0VarP.g(p0Var5);
                                        this.f12349n = o0VarP.e();
                                    }
                                    this.f12343h |= 16;
                                case 56:
                                    this.f12343h |= 32;
                                    this.f12350o = eVar.k();
                                case 66:
                                    if ((i2 & 128) != 128) {
                                        this.f12351p = new ArrayList();
                                        i2 |= 128;
                                    }
                                    this.f12351p.add(eVar.g(f.f12125m, hVar));
                                case 248:
                                    if ((i2 & 256) != 256) {
                                        this.f12352q = new ArrayList();
                                        i2 |= 256;
                                    }
                                    this.f12352q.add(Integer.valueOf(eVar.k()));
                                case 250:
                                    int iD = eVar.d(eVar.k());
                                    if ((i2 & 256) != 256 && eVar.b() > 0) {
                                        this.f12352q = new ArrayList();
                                        i2 |= 256;
                                    }
                                    while (eVar.b() > 0) {
                                        this.f12352q.add(Integer.valueOf(eVar.k()));
                                    }
                                    eVar.c(iD);
                                    break;
                                default:
                                    L = l(eVar, fVarJ, hVar, iN);
                                    if (L == 0) {
                                        z4 = true;
                                    }
                            }
                        } catch (IOException e10) {
                            f9.r rVar = new f9.r(e10.getMessage());
                            rVar.f3597f = this;
                            throw rVar;
                        }
                    } catch (f9.r e11) {
                        e11.f3597f = this;
                        throw e11;
                    }
                } catch (Throwable th) {
                    if ((i2 & 4) == 4) {
                        this.f12346k = Collections.unmodifiableList(this.f12346k);
                    }
                    if ((i2 & 128) == L) {
                        this.f12351p = Collections.unmodifiableList(this.f12351p);
                    }
                    if ((i2 & 256) == 256) {
                        this.f12352q = Collections.unmodifiableList(this.f12352q);
                    }
                    try {
                        fVarJ.i();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f12342g = cVar.d();
                        throw th2;
                    }
                    this.f12342g = cVar.d();
                    k();
                    throw th;
                }
            } else {
                if ((i2 & 4) == 4) {
                    this.f12346k = Collections.unmodifiableList(this.f12346k);
                }
                if ((i2 & 128) == 128) {
                    this.f12351p = Collections.unmodifiableList(this.f12351p);
                }
                if ((i2 & 256) == 256) {
                    this.f12352q = Collections.unmodifiableList(this.f12352q);
                }
                try {
                    fVarJ.i();
                } catch (IOException unused2) {
                } catch (Throwable th3) {
                    this.f12342g = cVar.d();
                    throw th3;
                }
                this.f12342g = cVar.d();
                k();
                return;
            }
        }
    }
}
