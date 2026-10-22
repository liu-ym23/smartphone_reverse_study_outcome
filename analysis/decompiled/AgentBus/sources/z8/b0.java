package z8;

import com.stepos.account.oauth.OAuthConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class b0 extends f9.l {

    /* renamed from: p, reason: collision with root package name */
    public static final b0 f12034p;

    /* renamed from: q, reason: collision with root package name */
    public static final c9.a f12035q = new c9.a(15);

    /* renamed from: g, reason: collision with root package name */
    public final f9.d f12036g;

    /* renamed from: h, reason: collision with root package name */
    public int f12037h;

    /* renamed from: i, reason: collision with root package name */
    public List f12038i;

    /* renamed from: j, reason: collision with root package name */
    public List f12039j;

    /* renamed from: k, reason: collision with root package name */
    public List f12040k;

    /* renamed from: l, reason: collision with root package name */
    public v0 f12041l;

    /* renamed from: m, reason: collision with root package name */
    public c1 f12042m;

    /* renamed from: n, reason: collision with root package name */
    public byte f12043n;

    /* renamed from: o, reason: collision with root package name */
    public int f12044o;

    static {
        b0 b0Var = new b0();
        f12034p = b0Var;
        List list = Collections.EMPTY_LIST;
        b0Var.f12038i = list;
        b0Var.f12039j = list;
        b0Var.f12040k = list;
        b0Var.f12041l = v0.f12413l;
        b0Var.f12042m = c1.f12079j;
    }

    public b0(a0 a0Var) {
        super(a0Var);
        this.f12043n = (byte) -1;
        this.f12044o = -1;
        this.f12036g = a0Var.f3565f;
    }

    @Override // f9.a
    public final int a() {
        int i2 = this.f12044o;
        if (i2 != -1) {
            return i2;
        }
        int iD = 0;
        for (int i10 = 0; i10 < this.f12038i.size(); i10++) {
            iD += f9.f.d(3, (f9.a) this.f12038i.get(i10));
        }
        for (int i11 = 0; i11 < this.f12039j.size(); i11++) {
            iD += f9.f.d(4, (f9.a) this.f12039j.get(i11));
        }
        for (int i12 = 0; i12 < this.f12040k.size(); i12++) {
            iD += f9.f.d(5, (f9.a) this.f12040k.get(i12));
        }
        if ((this.f12037h & 1) == 1) {
            iD += f9.f.d(30, this.f12041l);
        }
        if ((this.f12037h & 2) == 2) {
            iD += f9.f.d(32, this.f12042m);
        }
        int size = this.f12036g.size() + h() + iD;
        this.f12044o = size;
        return size;
    }

    @Override // f9.a
    public final f9.j b() {
        return a0.f();
    }

    @Override // f9.a
    public final f9.j c() {
        a0 a0VarF = a0.f();
        a0VarF.g(this);
        return a0VarF;
    }

    @Override // f9.a
    public final void d(f9.f fVar) throws IOException {
        a();
        q6.b bVar = new q6.b((f9.l) this);
        for (int i2 = 0; i2 < this.f12038i.size(); i2++) {
            fVar.o(3, (f9.a) this.f12038i.get(i2));
        }
        for (int i10 = 0; i10 < this.f12039j.size(); i10++) {
            fVar.o(4, (f9.a) this.f12039j.get(i10));
        }
        for (int i11 = 0; i11 < this.f12040k.size(); i11++) {
            fVar.o(5, (f9.a) this.f12040k.get(i11));
        }
        if ((this.f12037h & 1) == 1) {
            fVar.o(30, this.f12041l);
        }
        if ((this.f12037h & 2) == 2) {
            fVar.o(32, this.f12042m);
        }
        bVar.Q0(OAuthConstants.RESPONSE_CODE_OK, fVar);
        fVar.r(this.f12036g);
    }

    @Override // f9.v
    public final f9.a getDefaultInstanceForType() {
        return f12034p;
    }

    @Override // f9.v
    public final boolean isInitialized() {
        byte b10 = this.f12043n;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        for (int i2 = 0; i2 < this.f12038i.size(); i2++) {
            if (!((x) this.f12038i.get(i2)).isInitialized()) {
                this.f12043n = (byte) 0;
                return false;
            }
        }
        for (int i10 = 0; i10 < this.f12039j.size(); i10++) {
            if (!((f0) this.f12039j.get(i10)).isInitialized()) {
                this.f12043n = (byte) 0;
                return false;
            }
        }
        for (int i11 = 0; i11 < this.f12040k.size(); i11++) {
            if (!((r0) this.f12040k.get(i11)).isInitialized()) {
                this.f12043n = (byte) 0;
                return false;
            }
        }
        if ((this.f12037h & 1) == 1 && !this.f12041l.isInitialized()) {
            this.f12043n = (byte) 0;
            return false;
        }
        if (g()) {
            this.f12043n = (byte) 1;
            return true;
        }
        this.f12043n = (byte) 0;
        return false;
    }

    public b0() {
        this.f12043n = (byte) -1;
        this.f12044o = -1;
        this.f12036g = f9.d.f3536f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8 */
    public b0(f9.e eVar, f9.h hVar) {
        this.f12043n = (byte) -1;
        this.f12044o = -1;
        List list = Collections.EMPTY_LIST;
        this.f12038i = list;
        this.f12039j = list;
        this.f12040k = list;
        this.f12041l = v0.f12413l;
        this.f12042m = c1.f12079j;
        f9.c cVar = new f9.c();
        f9.f fVarJ = f9.f.j(cVar, 1);
        boolean z4 = false;
        char c10 = 0;
        while (!z4) {
            try {
                try {
                    int iN = eVar.n();
                    if (iN != 0) {
                        if (iN == 26) {
                            int i2 = (c10 == true ? 1 : 0) & 1;
                            c10 = c10;
                            if (i2 != 1) {
                                this.f12038i = new ArrayList();
                                c10 = (c10 == true ? 1 : 0) | 1;
                            }
                            this.f12038i.add(eVar.g(x.A, hVar));
                        } else if (iN == 34) {
                            int i10 = (c10 == true ? 1 : 0) & 2;
                            c10 = c10;
                            if (i10 != 2) {
                                this.f12039j = new ArrayList();
                                c10 = (c10 == true ? 1 : 0) | 2;
                            }
                            this.f12039j.add(eVar.g(f0.A, hVar));
                        } else if (iN != 42) {
                            l lVar = null;
                            e eVarG = null;
                            if (iN == 242) {
                                if ((this.f12037h & 1) == 1) {
                                    v0 v0Var = this.f12041l;
                                    v0Var.getClass();
                                    eVarG = v0.g(v0Var);
                                }
                                v0 v0Var2 = (v0) eVar.g(v0.f12414m, hVar);
                                this.f12041l = v0Var2;
                                if (eVarG != null) {
                                    eVarG.j(v0Var2);
                                    this.f12041l = eVarG.f();
                                }
                                this.f12037h |= 1;
                            } else if (iN != 258) {
                                if (!l(eVar, fVarJ, hVar, iN)) {
                                }
                            } else {
                                if ((this.f12037h & 2) == 2) {
                                    c1 c1Var = this.f12042m;
                                    c1Var.getClass();
                                    lVar = new l(2);
                                    lVar.f12242i = Collections.EMPTY_LIST;
                                    lVar.k(c1Var);
                                }
                                c1 c1Var2 = (c1) eVar.g(c1.f12080k, hVar);
                                this.f12042m = c1Var2;
                                if (lVar != null) {
                                    lVar.k(c1Var2);
                                    this.f12042m = lVar.g();
                                }
                                this.f12037h |= 2;
                            }
                        } else {
                            int i11 = (c10 == true ? 1 : 0) & 4;
                            c10 = c10;
                            if (i11 != 4) {
                                this.f12040k = new ArrayList();
                                c10 = (c10 == true ? 1 : 0) | 4;
                            }
                            this.f12040k.add(eVar.g(r0.f12341u, hVar));
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
                if (((c10 == true ? 1 : 0) & 1) == 1) {
                    this.f12038i = Collections.unmodifiableList(this.f12038i);
                }
                if (((c10 == true ? 1 : 0) & 2) == 2) {
                    this.f12039j = Collections.unmodifiableList(this.f12039j);
                }
                if (((c10 == true ? 1 : 0) & 4) == 4) {
                    this.f12040k = Collections.unmodifiableList(this.f12040k);
                }
                try {
                    fVarJ.i();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f12036g = cVar.d();
                    throw th2;
                }
                this.f12036g = cVar.d();
                k();
                throw th;
            }
        }
        if (((c10 == true ? 1 : 0) & 1) == 1) {
            this.f12038i = Collections.unmodifiableList(this.f12038i);
        }
        if (((c10 == true ? 1 : 0) & 2) == 2) {
            this.f12039j = Collections.unmodifiableList(this.f12039j);
        }
        if (((c10 == true ? 1 : 0) & 4) == 4) {
            this.f12040k = Collections.unmodifiableList(this.f12040k);
        }
        try {
            fVarJ.i();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f12036g = cVar.d();
            throw th3;
        }
        this.f12036g = cVar.d();
        k();
    }
}
