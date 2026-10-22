package z8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class v0 extends f9.o {

    /* renamed from: l, reason: collision with root package name */
    public static final v0 f12413l;

    /* renamed from: m, reason: collision with root package name */
    public static final c9.a f12414m = new c9.a(25);

    /* renamed from: f, reason: collision with root package name */
    public final f9.d f12415f;

    /* renamed from: g, reason: collision with root package name */
    public int f12416g;

    /* renamed from: h, reason: collision with root package name */
    public List f12417h;

    /* renamed from: i, reason: collision with root package name */
    public int f12418i;

    /* renamed from: j, reason: collision with root package name */
    public byte f12419j;

    /* renamed from: k, reason: collision with root package name */
    public int f12420k;

    static {
        v0 v0Var = new v0();
        f12413l = v0Var;
        v0Var.f12417h = Collections.EMPTY_LIST;
        v0Var.f12418i = -1;
    }

    public v0() {
        this.f12419j = (byte) -1;
        this.f12420k = -1;
        this.f12415f = f9.d.f3536f;
    }

    public static e g(v0 v0Var) {
        e eVarG = e.g();
        eVarG.j(v0Var);
        return eVarG;
    }

    @Override // f9.a
    public final int a() {
        int i2 = this.f12420k;
        if (i2 != -1) {
            return i2;
        }
        int iB = 0;
        for (int i10 = 0; i10 < this.f12417h.size(); i10++) {
            iB += f9.f.d(1, (f9.a) this.f12417h.get(i10));
        }
        if ((this.f12416g & 1) == 1) {
            iB += f9.f.b(2, this.f12418i);
        }
        int size = this.f12415f.size() + iB;
        this.f12420k = size;
        return size;
    }

    @Override // f9.a
    public final f9.j b() {
        return e.g();
    }

    @Override // f9.a
    public final f9.j c() {
        return g(this);
    }

    @Override // f9.a
    public final void d(f9.f fVar) throws IOException {
        a();
        for (int i2 = 0; i2 < this.f12417h.size(); i2++) {
            fVar.o(1, (f9.a) this.f12417h.get(i2));
        }
        if ((this.f12416g & 1) == 1) {
            fVar.m(2, this.f12418i);
        }
        fVar.r(this.f12415f);
    }

    public final e h() {
        return g(this);
    }

    @Override // f9.v
    public final boolean isInitialized() {
        byte b10 = this.f12419j;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        for (int i2 = 0; i2 < this.f12417h.size(); i2++) {
            if (!((p0) this.f12417h.get(i2)).isInitialized()) {
                this.f12419j = (byte) 0;
                return false;
            }
        }
        this.f12419j = (byte) 1;
        return true;
    }

    public v0(f9.e eVar, f9.h hVar) {
        this.f12419j = (byte) -1;
        this.f12420k = -1;
        this.f12417h = Collections.EMPTY_LIST;
        this.f12418i = -1;
        f9.c cVar = new f9.c();
        f9.f fVarJ = f9.f.j(cVar, 1);
        boolean z4 = false;
        boolean z10 = false;
        while (!z4) {
            try {
                try {
                    try {
                        int iN = eVar.n();
                        if (iN != 0) {
                            if (iN == 10) {
                                if (!z10) {
                                    this.f12417h = new ArrayList();
                                    z10 = true;
                                }
                                this.f12417h.add(eVar.g(p0.f12299z, hVar));
                            } else if (iN != 16) {
                                if (!eVar.q(iN, fVarJ)) {
                                }
                            } else {
                                this.f12416g |= 1;
                                this.f12418i = eVar.k();
                            }
                        }
                        z4 = true;
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
                if (z10) {
                    this.f12417h = Collections.unmodifiableList(this.f12417h);
                }
                try {
                    fVarJ.i();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f12415f = cVar.d();
                    throw th2;
                }
                this.f12415f = cVar.d();
                throw th;
            }
        }
        if (z10) {
            this.f12417h = Collections.unmodifiableList(this.f12417h);
        }
        try {
            fVarJ.i();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f12415f = cVar.d();
            throw th3;
        }
        this.f12415f = cVar.d();
    }

    public v0(e eVar) {
        this.f12419j = (byte) -1;
        this.f12420k = -1;
        this.f12415f = eVar.f3565f;
    }
}
