package z8;

import com.stepos.account.oauth.OAuthConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class d0 extends f9.l {

    /* renamed from: o, reason: collision with root package name */
    public static final d0 f12093o;

    /* renamed from: p, reason: collision with root package name */
    public static final c9.a f12094p = new c9.a(16);

    /* renamed from: g, reason: collision with root package name */
    public final f9.d f12095g;

    /* renamed from: h, reason: collision with root package name */
    public int f12096h;

    /* renamed from: i, reason: collision with root package name */
    public k0 f12097i;

    /* renamed from: j, reason: collision with root package name */
    public j0 f12098j;

    /* renamed from: k, reason: collision with root package name */
    public b0 f12099k;

    /* renamed from: l, reason: collision with root package name */
    public List f12100l;

    /* renamed from: m, reason: collision with root package name */
    public byte f12101m;

    /* renamed from: n, reason: collision with root package name */
    public int f12102n;

    static {
        d0 d0Var = new d0();
        f12093o = d0Var;
        d0Var.f12097i = k0.f12234j;
        d0Var.f12098j = j0.f12219j;
        d0Var.f12099k = b0.f12034p;
        d0Var.f12100l = Collections.EMPTY_LIST;
    }

    public d0(c0 c0Var) {
        super(c0Var);
        this.f12101m = (byte) -1;
        this.f12102n = -1;
        this.f12095g = c0Var.f3565f;
    }

    @Override // f9.a
    public final int a() {
        int i2 = this.f12102n;
        if (i2 != -1) {
            return i2;
        }
        int iD = (this.f12096h & 1) == 1 ? f9.f.d(1, this.f12097i) : 0;
        if ((this.f12096h & 2) == 2) {
            iD += f9.f.d(2, this.f12098j);
        }
        if ((this.f12096h & 4) == 4) {
            iD += f9.f.d(3, this.f12099k);
        }
        for (int i10 = 0; i10 < this.f12100l.size(); i10++) {
            iD += f9.f.d(4, (f9.a) this.f12100l.get(i10));
        }
        int size = this.f12095g.size() + h() + iD;
        this.f12102n = size;
        return size;
    }

    @Override // f9.a
    public final f9.j b() {
        return c0.f();
    }

    @Override // f9.a
    public final f9.j c() {
        c0 c0VarF = c0.f();
        c0VarF.g(this);
        return c0VarF;
    }

    @Override // f9.a
    public final void d(f9.f fVar) throws IOException {
        a();
        q6.b bVar = new q6.b((f9.l) this);
        if ((this.f12096h & 1) == 1) {
            fVar.o(1, this.f12097i);
        }
        if ((this.f12096h & 2) == 2) {
            fVar.o(2, this.f12098j);
        }
        if ((this.f12096h & 4) == 4) {
            fVar.o(3, this.f12099k);
        }
        for (int i2 = 0; i2 < this.f12100l.size(); i2++) {
            fVar.o(4, (f9.a) this.f12100l.get(i2));
        }
        bVar.Q0(OAuthConstants.RESPONSE_CODE_OK, fVar);
        fVar.r(this.f12095g);
    }

    @Override // f9.v
    public final f9.a getDefaultInstanceForType() {
        return f12093o;
    }

    @Override // f9.v
    public final boolean isInitialized() {
        byte b10 = this.f12101m;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        if ((this.f12096h & 2) == 2 && !this.f12098j.isInitialized()) {
            this.f12101m = (byte) 0;
            return false;
        }
        if ((this.f12096h & 4) == 4 && !this.f12099k.isInitialized()) {
            this.f12101m = (byte) 0;
            return false;
        }
        for (int i2 = 0; i2 < this.f12100l.size(); i2++) {
            if (!((i) this.f12100l.get(i2)).isInitialized()) {
                this.f12101m = (byte) 0;
                return false;
            }
        }
        if (g()) {
            this.f12101m = (byte) 1;
            return true;
        }
        this.f12101m = (byte) 0;
        return false;
    }

    public d0() {
        this.f12101m = (byte) -1;
        this.f12102n = -1;
        this.f12095g = f9.d.f3536f;
    }

    public d0(f9.e eVar, f9.h hVar) {
        this.f12101m = (byte) -1;
        this.f12102n = -1;
        this.f12097i = k0.f12234j;
        this.f12098j = j0.f12219j;
        this.f12099k = b0.f12034p;
        this.f12100l = Collections.EMPTY_LIST;
        f9.c cVar = new f9.c();
        f9.f fVarJ = f9.f.j(cVar, 1);
        boolean z4 = false;
        char c10 = 0;
        while (!z4) {
            try {
                try {
                    int iN = eVar.n();
                    if (iN != 0) {
                        a0 a0VarF = null;
                        l lVar = null;
                        l lVar2 = null;
                        if (iN == 10) {
                            if ((this.f12096h & 1) == 1) {
                                k0 k0Var = this.f12097i;
                                k0Var.getClass();
                                lVar = new l(3);
                                lVar.f12242i = f9.s.f3598g;
                                lVar.j(k0Var);
                            }
                            k0 k0Var2 = (k0) eVar.g(k0.f12235k, hVar);
                            this.f12097i = k0Var2;
                            if (lVar != null) {
                                lVar.j(k0Var2);
                                this.f12097i = lVar.f();
                            }
                            this.f12096h |= 1;
                        } else if (iN == 18) {
                            if ((this.f12096h & 2) == 2) {
                                j0 j0Var = this.f12098j;
                                j0Var.getClass();
                                lVar2 = new l(1);
                                lVar2.f12242i = Collections.EMPTY_LIST;
                                lVar2.i(j0Var);
                            }
                            j0 j0Var2 = (j0) eVar.g(j0.f12220k, hVar);
                            this.f12098j = j0Var2;
                            if (lVar2 != null) {
                                lVar2.i(j0Var2);
                                this.f12098j = lVar2.e();
                            }
                            this.f12096h |= 2;
                        } else if (iN == 26) {
                            if ((this.f12096h & 4) == 4) {
                                b0 b0Var = this.f12099k;
                                b0Var.getClass();
                                a0VarF = a0.f();
                                a0VarF.g(b0Var);
                            }
                            b0 b0Var2 = (b0) eVar.g(b0.f12035q, hVar);
                            this.f12099k = b0Var2;
                            if (a0VarF != null) {
                                a0VarF.g(b0Var2);
                                this.f12099k = a0VarF.e();
                            }
                            this.f12096h |= 4;
                        } else if (iN != 34) {
                            if (!l(eVar, fVarJ, hVar, iN)) {
                            }
                        } else {
                            int i2 = (c10 == true ? 1 : 0) & '\b';
                            c10 = c10;
                            if (i2 != 8) {
                                this.f12100l = new ArrayList();
                                c10 = '\b';
                            }
                            this.f12100l.add(eVar.g(i.P, hVar));
                        }
                    }
                    z4 = true;
                } catch (f9.r e10) {
                    e10.f3597f = this;
                    throw e10;
                } catch (IOException e11) {
                    f9.r rVar = new f9.r(e11.getMessage());
                    rVar.f3597f = this;
                    throw rVar;
                }
            } catch (Throwable th) {
                if (((c10 == true ? 1 : 0) & '\b') == 8) {
                    this.f12100l = Collections.unmodifiableList(this.f12100l);
                }
                try {
                    fVarJ.i();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f12095g = cVar.d();
                    throw th2;
                }
                this.f12095g = cVar.d();
                k();
                throw th;
            }
        }
        if (((c10 == true ? 1 : 0) & '\b') == 8) {
            this.f12100l = Collections.unmodifiableList(this.f12100l);
        }
        try {
            fVarJ.i();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f12095g = cVar.d();
            throw th3;
        }
        this.f12095g = cVar.d();
        k();
    }
}
