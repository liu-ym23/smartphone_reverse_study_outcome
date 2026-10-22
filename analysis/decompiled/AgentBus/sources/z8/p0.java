package z8;

import com.stepos.account.oauth.OAuthConstants;
import fi.iki.elonen.NanoHTTPD;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class p0 extends f9.l {

    /* renamed from: y, reason: collision with root package name */
    public static final p0 f12298y;

    /* renamed from: z, reason: collision with root package name */
    public static final c9.a f12299z = new c9.a(21);

    /* renamed from: g, reason: collision with root package name */
    public final f9.d f12300g;

    /* renamed from: h, reason: collision with root package name */
    public int f12301h;

    /* renamed from: i, reason: collision with root package name */
    public List f12302i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f12303j;

    /* renamed from: k, reason: collision with root package name */
    public int f12304k;

    /* renamed from: l, reason: collision with root package name */
    public p0 f12305l;

    /* renamed from: m, reason: collision with root package name */
    public int f12306m;

    /* renamed from: n, reason: collision with root package name */
    public int f12307n;

    /* renamed from: o, reason: collision with root package name */
    public int f12308o;

    /* renamed from: p, reason: collision with root package name */
    public int f12309p;

    /* renamed from: q, reason: collision with root package name */
    public int f12310q;

    /* renamed from: r, reason: collision with root package name */
    public p0 f12311r;

    /* renamed from: s, reason: collision with root package name */
    public int f12312s;

    /* renamed from: t, reason: collision with root package name */
    public p0 f12313t;

    /* renamed from: u, reason: collision with root package name */
    public int f12314u;

    /* renamed from: v, reason: collision with root package name */
    public int f12315v;

    /* renamed from: w, reason: collision with root package name */
    public byte f12316w;

    /* renamed from: x, reason: collision with root package name */
    public int f12317x;

    static {
        p0 p0Var = new p0();
        f12298y = p0Var;
        p0Var.o();
    }

    public p0(o0 o0Var) {
        super(o0Var);
        this.f12316w = (byte) -1;
        this.f12317x = -1;
        this.f12300g = o0Var.f3565f;
    }

    public static o0 p(p0 p0Var) {
        o0 o0VarF = o0.f();
        o0VarF.g(p0Var);
        return o0VarF;
    }

    @Override // f9.a
    public final int a() {
        int i2 = this.f12317x;
        if (i2 != -1) {
            return i2;
        }
        int iB = (this.f12301h & 4096) == 4096 ? f9.f.b(1, this.f12315v) : 0;
        for (int i10 = 0; i10 < this.f12302i.size(); i10++) {
            iB += f9.f.d(2, (f9.a) this.f12302i.get(i10));
        }
        if ((this.f12301h & 1) == 1) {
            iB += f9.f.h(3) + 1;
        }
        if ((this.f12301h & 2) == 2) {
            iB += f9.f.b(4, this.f12304k);
        }
        if ((this.f12301h & 4) == 4) {
            iB += f9.f.d(5, this.f12305l);
        }
        if ((this.f12301h & 16) == 16) {
            iB += f9.f.b(6, this.f12307n);
        }
        if ((this.f12301h & 32) == 32) {
            iB += f9.f.b(7, this.f12308o);
        }
        if ((this.f12301h & 8) == 8) {
            iB += f9.f.b(8, this.f12306m);
        }
        if ((this.f12301h & 64) == 64) {
            iB += f9.f.b(9, this.f12309p);
        }
        if ((this.f12301h & 256) == 256) {
            iB += f9.f.d(10, this.f12311r);
        }
        if ((this.f12301h & 512) == 512) {
            iB += f9.f.b(11, this.f12312s);
        }
        if ((this.f12301h & 128) == 128) {
            iB += f9.f.b(12, this.f12310q);
        }
        if ((this.f12301h & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) == 1024) {
            iB += f9.f.d(13, this.f12313t);
        }
        if ((this.f12301h & 2048) == 2048) {
            iB += f9.f.b(14, this.f12314u);
        }
        int size = this.f12300g.size() + h() + iB;
        this.f12317x = size;
        return size;
    }

    @Override // f9.a
    public final f9.j b() {
        return o0.f();
    }

    @Override // f9.a
    public final void d(f9.f fVar) throws IOException {
        a();
        q6.b bVar = new q6.b((f9.l) this);
        if ((this.f12301h & 4096) == 4096) {
            fVar.m(1, this.f12315v);
        }
        for (int i2 = 0; i2 < this.f12302i.size(); i2++) {
            fVar.o(2, (f9.a) this.f12302i.get(i2));
        }
        if ((this.f12301h & 1) == 1) {
            boolean z4 = this.f12303j;
            fVar.x(3, 0);
            fVar.q(z4 ? 1 : 0);
        }
        if ((this.f12301h & 2) == 2) {
            fVar.m(4, this.f12304k);
        }
        if ((this.f12301h & 4) == 4) {
            fVar.o(5, this.f12305l);
        }
        if ((this.f12301h & 16) == 16) {
            fVar.m(6, this.f12307n);
        }
        if ((this.f12301h & 32) == 32) {
            fVar.m(7, this.f12308o);
        }
        if ((this.f12301h & 8) == 8) {
            fVar.m(8, this.f12306m);
        }
        if ((this.f12301h & 64) == 64) {
            fVar.m(9, this.f12309p);
        }
        if ((this.f12301h & 256) == 256) {
            fVar.o(10, this.f12311r);
        }
        if ((this.f12301h & 512) == 512) {
            fVar.m(11, this.f12312s);
        }
        if ((this.f12301h & 128) == 128) {
            fVar.m(12, this.f12310q);
        }
        if ((this.f12301h & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) == 1024) {
            fVar.o(13, this.f12313t);
        }
        if ((this.f12301h & 2048) == 2048) {
            fVar.m(14, this.f12314u);
        }
        bVar.Q0(OAuthConstants.RESPONSE_CODE_OK, fVar);
        fVar.r(this.f12300g);
    }

    @Override // f9.v
    public final f9.a getDefaultInstanceForType() {
        return f12298y;
    }

    @Override // f9.v
    public final boolean isInitialized() {
        byte b10 = this.f12316w;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        for (int i2 = 0; i2 < this.f12302i.size(); i2++) {
            if (!((n0) this.f12302i.get(i2)).isInitialized()) {
                this.f12316w = (byte) 0;
                return false;
            }
        }
        if ((this.f12301h & 4) == 4 && !this.f12305l.isInitialized()) {
            this.f12316w = (byte) 0;
            return false;
        }
        if ((this.f12301h & 256) == 256 && !this.f12311r.isInitialized()) {
            this.f12316w = (byte) 0;
            return false;
        }
        if ((this.f12301h & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) == 1024 && !this.f12313t.isInitialized()) {
            this.f12316w = (byte) 0;
            return false;
        }
        if (g()) {
            this.f12316w = (byte) 1;
            return true;
        }
        this.f12316w = (byte) 0;
        return false;
    }

    public final boolean n() {
        return (this.f12301h & 16) == 16;
    }

    public final void o() {
        this.f12302i = Collections.EMPTY_LIST;
        this.f12303j = false;
        this.f12304k = 0;
        p0 p0Var = f12298y;
        this.f12305l = p0Var;
        this.f12306m = 0;
        this.f12307n = 0;
        this.f12308o = 0;
        this.f12309p = 0;
        this.f12310q = 0;
        this.f12311r = p0Var;
        this.f12312s = 0;
        this.f12313t = p0Var;
        this.f12314u = 0;
        this.f12315v = 0;
    }

    @Override // f9.a
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public final o0 c() {
        return p(this);
    }

    public p0() {
        this.f12316w = (byte) -1;
        this.f12317x = -1;
        this.f12300g = f9.d.f3536f;
    }

    public p0(f9.e eVar, f9.h hVar) {
        this.f12316w = (byte) -1;
        this.f12317x = -1;
        o();
        f9.c cVar = new f9.c();
        f9.f fVarJ = f9.f.j(cVar, 1);
        boolean z4 = false;
        boolean z10 = false;
        while (!z4) {
            try {
                try {
                    int iN = eVar.n();
                    c9.a aVar = f12299z;
                    o0 o0VarP = null;
                    switch (iN) {
                        case 0:
                            break;
                        case 8:
                            this.f12301h |= 4096;
                            this.f12315v = eVar.k();
                            continue;
                        case com.google.protobuf.a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                            if (!z10) {
                                this.f12302i = new ArrayList();
                                z10 = true;
                            }
                            this.f12302i.add(eVar.g(n0.f12265n, hVar));
                            continue;
                        case 24:
                            this.f12301h |= 1;
                            this.f12303j = eVar.l() != 0;
                            continue;
                        case 32:
                            this.f12301h |= 2;
                            this.f12304k = eVar.k();
                            continue;
                        case 42:
                            if ((this.f12301h & 4) == 4) {
                                p0 p0Var = this.f12305l;
                                p0Var.getClass();
                                o0VarP = p(p0Var);
                            }
                            p0 p0Var2 = (p0) eVar.g(aVar, hVar);
                            this.f12305l = p0Var2;
                            if (o0VarP != null) {
                                o0VarP.g(p0Var2);
                                this.f12305l = o0VarP.e();
                            }
                            this.f12301h |= 4;
                            continue;
                        case 48:
                            this.f12301h |= 16;
                            this.f12307n = eVar.k();
                            continue;
                        case 56:
                            this.f12301h |= 32;
                            this.f12308o = eVar.k();
                            continue;
                        case 64:
                            this.f12301h |= 8;
                            this.f12306m = eVar.k();
                            continue;
                        case 72:
                            this.f12301h |= 64;
                            this.f12309p = eVar.k();
                            continue;
                        case 82:
                            if ((this.f12301h & 256) == 256) {
                                p0 p0Var3 = this.f12311r;
                                p0Var3.getClass();
                                o0VarP = p(p0Var3);
                            }
                            p0 p0Var4 = (p0) eVar.g(aVar, hVar);
                            this.f12311r = p0Var4;
                            if (o0VarP != null) {
                                o0VarP.g(p0Var4);
                                this.f12311r = o0VarP.e();
                            }
                            this.f12301h |= 256;
                            continue;
                        case 88:
                            this.f12301h |= 512;
                            this.f12312s = eVar.k();
                            continue;
                        case 96:
                            this.f12301h |= 128;
                            this.f12310q = eVar.k();
                            continue;
                        case 106:
                            if ((this.f12301h & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) == 1024) {
                                p0 p0Var5 = this.f12313t;
                                p0Var5.getClass();
                                o0VarP = p(p0Var5);
                            }
                            p0 p0Var6 = (p0) eVar.g(aVar, hVar);
                            this.f12313t = p0Var6;
                            if (o0VarP != null) {
                                o0VarP.g(p0Var6);
                                this.f12313t = o0VarP.e();
                            }
                            this.f12301h |= NanoHTTPD.HTTPSession.MAX_HEADER_SIZE;
                            continue;
                        case 112:
                            this.f12301h |= 2048;
                            this.f12314u = eVar.k();
                            continue;
                        default:
                            if (!l(eVar, fVarJ, hVar, iN)) {
                                break;
                            }
                    }
                    z4 = true;
                } catch (Throwable th) {
                    if (z10) {
                        this.f12302i = Collections.unmodifiableList(this.f12302i);
                    }
                    try {
                        fVarJ.i();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f12300g = cVar.d();
                        throw th2;
                    }
                    this.f12300g = cVar.d();
                    k();
                    throw th;
                }
            } catch (f9.r e10) {
                e10.f3597f = this;
                throw e10;
            } catch (IOException e11) {
                f9.r rVar = new f9.r(e11.getMessage());
                rVar.f3597f = this;
                throw rVar;
            }
        }
        if (z10) {
            this.f12302i = Collections.unmodifiableList(this.f12302i);
        }
        try {
            fVarJ.i();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f12300g = cVar.d();
            throw th3;
        }
        this.f12300g = cVar.d();
        k();
    }
}
