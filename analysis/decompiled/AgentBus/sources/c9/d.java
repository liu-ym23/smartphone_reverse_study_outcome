package c9;

import f9.o;
import f9.r;
import java.io.IOException;

/* loaded from: classes.dex */
public final class d extends o {

    /* renamed from: l, reason: collision with root package name */
    public static final d f2100l;

    /* renamed from: m, reason: collision with root package name */
    public static final a f2101m = new a(1);

    /* renamed from: f, reason: collision with root package name */
    public final f9.d f2102f;

    /* renamed from: g, reason: collision with root package name */
    public int f2103g;

    /* renamed from: h, reason: collision with root package name */
    public int f2104h;

    /* renamed from: i, reason: collision with root package name */
    public int f2105i;

    /* renamed from: j, reason: collision with root package name */
    public byte f2106j;

    /* renamed from: k, reason: collision with root package name */
    public int f2107k;

    static {
        d dVar = new d();
        f2100l = dVar;
        dVar.f2104h = 0;
        dVar.f2105i = 0;
    }

    public d() {
        this.f2106j = (byte) -1;
        this.f2107k = -1;
        this.f2102f = f9.d.f3536f;
    }

    public static b g(d dVar) {
        b bVar = new b(1);
        bVar.g(dVar);
        return bVar;
    }

    @Override // f9.a
    public final int a() {
        int i2 = this.f2107k;
        if (i2 != -1) {
            return i2;
        }
        int iB = (this.f2103g & 1) == 1 ? f9.f.b(1, this.f2104h) : 0;
        if ((this.f2103g & 2) == 2) {
            iB += f9.f.b(2, this.f2105i);
        }
        int size = this.f2102f.size() + iB;
        this.f2107k = size;
        return size;
    }

    @Override // f9.a
    public final f9.j b() {
        return new b(1);
    }

    @Override // f9.a
    public final f9.j c() {
        return g(this);
    }

    @Override // f9.a
    public final void d(f9.f fVar) throws IOException {
        a();
        if ((this.f2103g & 1) == 1) {
            fVar.m(1, this.f2104h);
        }
        if ((this.f2103g & 2) == 2) {
            fVar.m(2, this.f2105i);
        }
        fVar.r(this.f2102f);
    }

    @Override // f9.v
    public final boolean isInitialized() {
        if (this.f2106j == 1) {
            return true;
        }
        this.f2106j = (byte) 1;
        return true;
    }

    public d(b bVar) {
        this.f2106j = (byte) -1;
        this.f2107k = -1;
        this.f2102f = bVar.f3565f;
    }

    public d(f9.e eVar) {
        this.f2106j = (byte) -1;
        this.f2107k = -1;
        boolean z4 = false;
        this.f2104h = 0;
        this.f2105i = 0;
        f9.c cVar = new f9.c();
        f9.f fVarJ = f9.f.j(cVar, 1);
        while (!z4) {
            try {
                try {
                    int iN = eVar.n();
                    if (iN != 0) {
                        if (iN == 8) {
                            this.f2103g |= 1;
                            this.f2104h = eVar.k();
                        } else if (iN != 16) {
                            if (!eVar.q(iN, fVarJ)) {
                            }
                        } else {
                            this.f2103g |= 2;
                            this.f2105i = eVar.k();
                        }
                    }
                    z4 = true;
                } catch (Throwable th) {
                    try {
                        fVarJ.i();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f2102f = cVar.d();
                        throw th2;
                    }
                    this.f2102f = cVar.d();
                    throw th;
                }
            } catch (r e10) {
                e10.f3597f = this;
                throw e10;
            } catch (IOException e11) {
                r rVar = new r(e11.getMessage());
                rVar.f3597f = this;
                throw rVar;
            }
        }
        try {
            fVarJ.i();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f2102f = cVar.d();
            throw th3;
        }
        this.f2102f = cVar.d();
    }
}
