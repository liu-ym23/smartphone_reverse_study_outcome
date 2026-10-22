package z8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class c1 extends f9.o {

    /* renamed from: j, reason: collision with root package name */
    public static final c1 f12079j;

    /* renamed from: k, reason: collision with root package name */
    public static final c9.a f12080k = new c9.a(28);

    /* renamed from: f, reason: collision with root package name */
    public final f9.d f12081f;

    /* renamed from: g, reason: collision with root package name */
    public List f12082g;

    /* renamed from: h, reason: collision with root package name */
    public byte f12083h;

    /* renamed from: i, reason: collision with root package name */
    public int f12084i;

    static {
        c1 c1Var = new c1();
        f12079j = c1Var;
        c1Var.f12082g = Collections.EMPTY_LIST;
    }

    public c1() {
        this.f12083h = (byte) -1;
        this.f12084i = -1;
        this.f12081f = f9.d.f3536f;
    }

    @Override // f9.a
    public final int a() {
        int i2 = this.f12084i;
        if (i2 != -1) {
            return i2;
        }
        int iD = 0;
        for (int i10 = 0; i10 < this.f12082g.size(); i10++) {
            iD += f9.f.d(1, (f9.a) this.f12082g.get(i10));
        }
        int size = this.f12081f.size() + iD;
        this.f12084i = size;
        return size;
    }

    @Override // f9.a
    public final f9.j b() {
        l lVar = new l(2);
        lVar.f12242i = Collections.EMPTY_LIST;
        return lVar;
    }

    @Override // f9.a
    public final f9.j c() {
        l lVar = new l(2);
        lVar.f12242i = Collections.EMPTY_LIST;
        lVar.k(this);
        return lVar;
    }

    @Override // f9.a
    public final void d(f9.f fVar) throws IOException {
        a();
        for (int i2 = 0; i2 < this.f12082g.size(); i2++) {
            fVar.o(1, (f9.a) this.f12082g.get(i2));
        }
        fVar.r(this.f12081f);
    }

    public final l g() {
        l lVar = new l(2);
        lVar.f12242i = Collections.EMPTY_LIST;
        lVar.k(this);
        return lVar;
    }

    @Override // f9.v
    public final boolean isInitialized() {
        if (this.f12083h == 1) {
            return true;
        }
        this.f12083h = (byte) 1;
        return true;
    }

    public c1(f9.e eVar, f9.h hVar) {
        this.f12083h = (byte) -1;
        this.f12084i = -1;
        this.f12082g = Collections.EMPTY_LIST;
        f9.c cVar = new f9.c();
        f9.f fVarJ = f9.f.j(cVar, 1);
        boolean z4 = false;
        boolean z10 = false;
        while (!z4) {
            try {
                try {
                    int iN = eVar.n();
                    if (iN != 0) {
                        if (iN != 10) {
                            if (!eVar.q(iN, fVarJ)) {
                            }
                        } else {
                            if (!z10) {
                                this.f12082g = new ArrayList();
                                z10 = true;
                            }
                            this.f12082g.add(eVar.g(b1.f12046q, hVar));
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
                if (z10) {
                    this.f12082g = Collections.unmodifiableList(this.f12082g);
                }
                try {
                    fVarJ.i();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f12081f = cVar.d();
                    throw th2;
                }
                this.f12081f = cVar.d();
                throw th;
            }
        }
        if (z10) {
            this.f12082g = Collections.unmodifiableList(this.f12082g);
        }
        try {
            fVarJ.i();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f12081f = cVar.d();
            throw th3;
        }
        this.f12081f = cVar.d();
    }

    public c1(l lVar) {
        this.f12083h = (byte) -1;
        this.f12084i = -1;
        this.f12081f = lVar.f3565f;
    }
}
