package z8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class k extends f9.l {

    /* renamed from: n, reason: collision with root package name */
    public static final k f12225n;

    /* renamed from: o, reason: collision with root package name */
    public static final c9.a f12226o = new c9.a(9);

    /* renamed from: g, reason: collision with root package name */
    public final f9.d f12227g;

    /* renamed from: h, reason: collision with root package name */
    public int f12228h;

    /* renamed from: i, reason: collision with root package name */
    public int f12229i;

    /* renamed from: j, reason: collision with root package name */
    public List f12230j;

    /* renamed from: k, reason: collision with root package name */
    public List f12231k;

    /* renamed from: l, reason: collision with root package name */
    public byte f12232l;

    /* renamed from: m, reason: collision with root package name */
    public int f12233m;

    static {
        k kVar = new k();
        f12225n = kVar;
        kVar.f12229i = 6;
        List list = Collections.EMPTY_LIST;
        kVar.f12230j = list;
        kVar.f12231k = list;
    }

    public k(j jVar) {
        super(jVar);
        this.f12232l = (byte) -1;
        this.f12233m = -1;
        this.f12227g = jVar.f3565f;
    }

    @Override // f9.a
    public final int a() {
        int i2 = this.f12233m;
        if (i2 != -1) {
            return i2;
        }
        int iB = (this.f12228h & 1) == 1 ? f9.f.b(1, this.f12229i) : 0;
        for (int i10 = 0; i10 < this.f12230j.size(); i10++) {
            iB += f9.f.d(2, (f9.a) this.f12230j.get(i10));
        }
        int iC = 0;
        for (int i11 = 0; i11 < this.f12231k.size(); i11++) {
            iC += f9.f.c(((Integer) this.f12231k.get(i11)).intValue());
        }
        int size = this.f12227g.size() + h() + (this.f12231k.size() * 2) + iB + iC;
        this.f12233m = size;
        return size;
    }

    @Override // f9.a
    public final f9.j b() {
        return j.f();
    }

    @Override // f9.a
    public final f9.j c() {
        j jVarF = j.f();
        jVarF.g(this);
        return jVarF;
    }

    @Override // f9.a
    public final void d(f9.f fVar) throws IOException {
        a();
        q6.b bVar = new q6.b((f9.l) this);
        if ((this.f12228h & 1) == 1) {
            fVar.m(1, this.f12229i);
        }
        for (int i2 = 0; i2 < this.f12230j.size(); i2++) {
            fVar.o(2, (f9.a) this.f12230j.get(i2));
        }
        for (int i10 = 0; i10 < this.f12231k.size(); i10++) {
            fVar.m(31, ((Integer) this.f12231k.get(i10)).intValue());
        }
        bVar.Q0(19000, fVar);
        fVar.r(this.f12227g);
    }

    @Override // f9.v
    public final f9.a getDefaultInstanceForType() {
        return f12225n;
    }

    @Override // f9.v
    public final boolean isInitialized() {
        byte b10 = this.f12232l;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        for (int i2 = 0; i2 < this.f12230j.size(); i2++) {
            if (!((x0) this.f12230j.get(i2)).isInitialized()) {
                this.f12232l = (byte) 0;
                return false;
            }
        }
        if (g()) {
            this.f12232l = (byte) 1;
            return true;
        }
        this.f12232l = (byte) 0;
        return false;
    }

    public k() {
        this.f12232l = (byte) -1;
        this.f12233m = -1;
        this.f12227g = f9.d.f3536f;
    }

    public k(f9.e eVar, f9.h hVar) {
        this.f12232l = (byte) -1;
        this.f12233m = -1;
        this.f12229i = 6;
        List list = Collections.EMPTY_LIST;
        this.f12230j = list;
        this.f12231k = list;
        f9.c cVar = new f9.c();
        f9.f fVarJ = f9.f.j(cVar, 1);
        boolean z4 = false;
        int i2 = 0;
        while (!z4) {
            try {
                try {
                    int iN = eVar.n();
                    if (iN != 0) {
                        if (iN == 8) {
                            this.f12228h |= 1;
                            this.f12229i = eVar.k();
                        } else if (iN == 18) {
                            if ((i2 & 2) != 2) {
                                this.f12230j = new ArrayList();
                                i2 |= 2;
                            }
                            this.f12230j.add(eVar.g(x0.f12464r, hVar));
                        } else if (iN == 248) {
                            if ((i2 & 4) != 4) {
                                this.f12231k = new ArrayList();
                                i2 |= 4;
                            }
                            this.f12231k.add(Integer.valueOf(eVar.k()));
                        } else if (iN != 250) {
                            if (!l(eVar, fVarJ, hVar, iN)) {
                            }
                        } else {
                            int iD = eVar.d(eVar.k());
                            if ((i2 & 4) != 4 && eVar.b() > 0) {
                                this.f12231k = new ArrayList();
                                i2 |= 4;
                            }
                            while (eVar.b() > 0) {
                                this.f12231k.add(Integer.valueOf(eVar.k()));
                            }
                            eVar.c(iD);
                        }
                    }
                    z4 = true;
                } catch (Throwable th) {
                    if ((i2 & 2) == 2) {
                        this.f12230j = Collections.unmodifiableList(this.f12230j);
                    }
                    if ((i2 & 4) == 4) {
                        this.f12231k = Collections.unmodifiableList(this.f12231k);
                    }
                    try {
                        fVarJ.i();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f12227g = cVar.d();
                        throw th2;
                    }
                    this.f12227g = cVar.d();
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
        if ((i2 & 2) == 2) {
            this.f12230j = Collections.unmodifiableList(this.f12230j);
        }
        if ((i2 & 4) == 4) {
            this.f12231k = Collections.unmodifiableList(this.f12231k);
        }
        try {
            fVarJ.i();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f12227g = cVar.d();
            throw th3;
        }
        this.f12227g = cVar.d();
        k();
    }
}
