package c9;

import f9.o;
import f9.r;
import java.io.IOException;

/* loaded from: classes.dex */
public final class c extends o {

    /* renamed from: l, reason: collision with root package name */
    public static final c f2092l;

    /* renamed from: m, reason: collision with root package name */
    public static final a f2093m = new a(0);

    /* renamed from: f, reason: collision with root package name */
    public final f9.d f2094f;

    /* renamed from: g, reason: collision with root package name */
    public int f2095g;

    /* renamed from: h, reason: collision with root package name */
    public int f2096h;

    /* renamed from: i, reason: collision with root package name */
    public int f2097i;

    /* renamed from: j, reason: collision with root package name */
    public byte f2098j;

    /* renamed from: k, reason: collision with root package name */
    public int f2099k;

    static {
        c cVar = new c();
        f2092l = cVar;
        cVar.f2096h = 0;
        cVar.f2097i = 0;
    }

    public c() {
        this.f2098j = (byte) -1;
        this.f2099k = -1;
        this.f2094f = f9.d.f3536f;
    }

    @Override // f9.a
    public final int a() {
        int i2 = this.f2099k;
        if (i2 != -1) {
            return i2;
        }
        int iB = (this.f2095g & 1) == 1 ? f9.f.b(1, this.f2096h) : 0;
        if ((this.f2095g & 2) == 2) {
            iB += f9.f.b(2, this.f2097i);
        }
        int size = this.f2094f.size() + iB;
        this.f2099k = size;
        return size;
    }

    @Override // f9.a
    public final f9.j b() {
        return new b(0);
    }

    @Override // f9.a
    public final f9.j c() {
        b bVar = new b(0);
        bVar.f(this);
        return bVar;
    }

    @Override // f9.a
    public final void d(f9.f fVar) throws IOException {
        a();
        if ((this.f2095g & 1) == 1) {
            fVar.m(1, this.f2096h);
        }
        if ((this.f2095g & 2) == 2) {
            fVar.m(2, this.f2097i);
        }
        fVar.r(this.f2094f);
    }

    @Override // f9.v
    public final boolean isInitialized() {
        if (this.f2098j == 1) {
            return true;
        }
        this.f2098j = (byte) 1;
        return true;
    }

    public c(b bVar) {
        this.f2098j = (byte) -1;
        this.f2099k = -1;
        this.f2094f = bVar.f3565f;
    }

    public c(f9.e eVar) {
        this.f2098j = (byte) -1;
        this.f2099k = -1;
        boolean z4 = false;
        this.f2096h = 0;
        this.f2097i = 0;
        f9.c cVar = new f9.c();
        f9.f fVarJ = f9.f.j(cVar, 1);
        while (!z4) {
            try {
                try {
                    int iN = eVar.n();
                    if (iN != 0) {
                        if (iN == 8) {
                            this.f2095g |= 1;
                            this.f2096h = eVar.k();
                        } else if (iN != 16) {
                            if (!eVar.q(iN, fVarJ)) {
                            }
                        } else {
                            this.f2095g |= 2;
                            this.f2097i = eVar.k();
                        }
                    }
                    z4 = true;
                } catch (Throwable th) {
                    try {
                        fVarJ.i();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f2094f = cVar.d();
                        throw th2;
                    }
                    this.f2094f = cVar.d();
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
            this.f2094f = cVar.d();
            throw th3;
        }
        this.f2094f = cVar.d();
    }
}
