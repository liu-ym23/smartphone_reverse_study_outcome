package c9;

import f9.o;
import f9.r;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class k extends o {

    /* renamed from: l, reason: collision with root package name */
    public static final k f2154l;

    /* renamed from: m, reason: collision with root package name */
    public static final a f2155m = new a(3);

    /* renamed from: f, reason: collision with root package name */
    public final f9.d f2156f;

    /* renamed from: g, reason: collision with root package name */
    public List f2157g;

    /* renamed from: h, reason: collision with root package name */
    public List f2158h;

    /* renamed from: i, reason: collision with root package name */
    public int f2159i;

    /* renamed from: j, reason: collision with root package name */
    public byte f2160j;

    /* renamed from: k, reason: collision with root package name */
    public int f2161k;

    static {
        k kVar = new k();
        f2154l = kVar;
        List list = Collections.EMPTY_LIST;
        kVar.f2157g = list;
        kVar.f2158h = list;
    }

    public k() {
        this.f2159i = -1;
        this.f2160j = (byte) -1;
        this.f2161k = -1;
        this.f2156f = f9.d.f3536f;
    }

    @Override // f9.a
    public final int a() {
        int i2 = this.f2161k;
        if (i2 != -1) {
            return i2;
        }
        int iD = 0;
        for (int i10 = 0; i10 < this.f2157g.size(); i10++) {
            iD += f9.f.d(1, (f9.a) this.f2157g.get(i10));
        }
        int iC = 0;
        for (int i11 = 0; i11 < this.f2158h.size(); i11++) {
            iC += f9.f.c(((Integer) this.f2158h.get(i11)).intValue());
        }
        int iC2 = iD + iC;
        if (!this.f2158h.isEmpty()) {
            iC2 = iC2 + 1 + f9.f.c(iC);
        }
        this.f2159i = iC;
        int size = this.f2156f.size() + iC2;
        this.f2161k = size;
        return size;
    }

    @Override // f9.a
    public final f9.j b() {
        g gVar = new g();
        List list = Collections.EMPTY_LIST;
        gVar.f2126h = list;
        gVar.f2127i = list;
        return gVar;
    }

    @Override // f9.a
    public final f9.j c() {
        g gVar = new g();
        List list = Collections.EMPTY_LIST;
        gVar.f2126h = list;
        gVar.f2127i = list;
        gVar.e(this);
        return gVar;
    }

    @Override // f9.a
    public final void d(f9.f fVar) throws IOException {
        a();
        for (int i2 = 0; i2 < this.f2157g.size(); i2++) {
            fVar.o(1, (f9.a) this.f2157g.get(i2));
        }
        if (this.f2158h.size() > 0) {
            fVar.v(42);
            fVar.v(this.f2159i);
        }
        for (int i10 = 0; i10 < this.f2158h.size(); i10++) {
            fVar.n(((Integer) this.f2158h.get(i10)).intValue());
        }
        fVar.r(this.f2156f);
    }

    @Override // f9.v
    public final boolean isInitialized() {
        if (this.f2160j == 1) {
            return true;
        }
        this.f2160j = (byte) 1;
        return true;
    }

    public k(g gVar) {
        this.f2159i = -1;
        this.f2160j = (byte) -1;
        this.f2161k = -1;
        this.f2156f = gVar.f3565f;
    }

    public k(f9.e eVar, f9.h hVar) {
        this.f2159i = -1;
        this.f2160j = (byte) -1;
        this.f2161k = -1;
        List list = Collections.EMPTY_LIST;
        this.f2157g = list;
        this.f2158h = list;
        f9.c cVar = new f9.c();
        f9.f fVarJ = f9.f.j(cVar, 1);
        boolean z4 = false;
        int i2 = 0;
        while (!z4) {
            try {
                try {
                    int iN = eVar.n();
                    if (iN != 0) {
                        if (iN == 10) {
                            if ((i2 & 1) != 1) {
                                this.f2157g = new ArrayList();
                                i2 |= 1;
                            }
                            this.f2157g.add(eVar.g(j.f2141s, hVar));
                        } else if (iN == 40) {
                            if ((i2 & 2) != 2) {
                                this.f2158h = new ArrayList();
                                i2 |= 2;
                            }
                            this.f2158h.add(Integer.valueOf(eVar.k()));
                        } else if (iN != 42) {
                            if (!eVar.q(iN, fVarJ)) {
                            }
                        } else {
                            int iD = eVar.d(eVar.k());
                            if ((i2 & 2) != 2 && eVar.b() > 0) {
                                this.f2158h = new ArrayList();
                                i2 |= 2;
                            }
                            while (eVar.b() > 0) {
                                this.f2158h.add(Integer.valueOf(eVar.k()));
                            }
                            eVar.c(iD);
                        }
                    }
                    z4 = true;
                } catch (r e10) {
                    e10.f3597f = this;
                    throw e10;
                } catch (IOException e11) {
                    r rVar = new r(e11.getMessage());
                    rVar.f3597f = this;
                    throw rVar;
                }
            } catch (Throwable th) {
                if ((i2 & 1) == 1) {
                    this.f2157g = Collections.unmodifiableList(this.f2157g);
                }
                if ((i2 & 2) == 2) {
                    this.f2158h = Collections.unmodifiableList(this.f2158h);
                }
                try {
                    fVarJ.i();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f2156f = cVar.d();
                    throw th2;
                }
                this.f2156f = cVar.d();
                throw th;
            }
        }
        if ((i2 & 1) == 1) {
            this.f2157g = Collections.unmodifiableList(this.f2157g);
        }
        if ((i2 & 2) == 2) {
            this.f2158h = Collections.unmodifiableList(this.f2158h);
        }
        try {
            fVarJ.i();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f2156f = cVar.d();
            throw th3;
        }
        this.f2156f = cVar.d();
    }
}
