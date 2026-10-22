package z8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class f extends f9.o {

    /* renamed from: l, reason: collision with root package name */
    public static final f f12124l;

    /* renamed from: m, reason: collision with root package name */
    public static final c9.a f12125m = new c9.a(5);

    /* renamed from: f, reason: collision with root package name */
    public final f9.d f12126f;

    /* renamed from: g, reason: collision with root package name */
    public int f12127g;

    /* renamed from: h, reason: collision with root package name */
    public int f12128h;

    /* renamed from: i, reason: collision with root package name */
    public List f12129i;

    /* renamed from: j, reason: collision with root package name */
    public byte f12130j;

    /* renamed from: k, reason: collision with root package name */
    public int f12131k;

    static {
        f fVar = new f();
        f12124l = fVar;
        fVar.f12128h = 0;
        fVar.f12129i = Collections.EMPTY_LIST;
    }

    public f() {
        this.f12130j = (byte) -1;
        this.f12131k = -1;
        this.f12126f = f9.d.f3536f;
    }

    @Override // f9.a
    public final int a() {
        int i2 = this.f12131k;
        if (i2 != -1) {
            return i2;
        }
        int iB = (this.f12127g & 1) == 1 ? f9.f.b(1, this.f12128h) : 0;
        for (int i10 = 0; i10 < this.f12129i.size(); i10++) {
            iB += f9.f.d(2, (f9.a) this.f12129i.get(i10));
        }
        int size = this.f12126f.size() + iB;
        this.f12131k = size;
        return size;
    }

    @Override // f9.a
    public final f9.j b() {
        e eVar = new e(0);
        eVar.f12107i = Collections.EMPTY_LIST;
        return eVar;
    }

    @Override // f9.a
    public final f9.j c() {
        e eVar = new e(0);
        eVar.f12107i = Collections.EMPTY_LIST;
        eVar.i(this);
        return eVar;
    }

    @Override // f9.a
    public final void d(f9.f fVar) throws IOException {
        a();
        if ((this.f12127g & 1) == 1) {
            fVar.m(1, this.f12128h);
        }
        for (int i2 = 0; i2 < this.f12129i.size(); i2++) {
            fVar.o(2, (f9.a) this.f12129i.get(i2));
        }
        fVar.r(this.f12126f);
    }

    @Override // f9.v
    public final boolean isInitialized() {
        byte b10 = this.f12130j;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        if ((this.f12127g & 1) != 1) {
            this.f12130j = (byte) 0;
            return false;
        }
        for (int i2 = 0; i2 < this.f12129i.size(); i2++) {
            if (!((d) this.f12129i.get(i2)).isInitialized()) {
                this.f12130j = (byte) 0;
                return false;
            }
        }
        this.f12130j = (byte) 1;
        return true;
    }

    public f(f9.e eVar, f9.h hVar) {
        this.f12130j = (byte) -1;
        this.f12131k = -1;
        boolean z4 = false;
        this.f12128h = 0;
        this.f12129i = Collections.EMPTY_LIST;
        f9.c cVar = new f9.c();
        f9.f fVarJ = f9.f.j(cVar, 1);
        char c10 = 0;
        while (!z4) {
            try {
                try {
                    try {
                        int iN = eVar.n();
                        if (iN != 0) {
                            if (iN == 8) {
                                this.f12127g |= 1;
                                this.f12128h = eVar.k();
                            } else if (iN != 18) {
                                if (!eVar.q(iN, fVarJ)) {
                                }
                            } else {
                                if ((c10 & 2) != 2) {
                                    this.f12129i = new ArrayList();
                                    c10 = 2;
                                }
                                this.f12129i.add(eVar.g(d.f12086m, hVar));
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
                if ((c10 & 2) == 2) {
                    this.f12129i = Collections.unmodifiableList(this.f12129i);
                }
                try {
                    fVarJ.i();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f12126f = cVar.d();
                    throw th2;
                }
                this.f12126f = cVar.d();
                throw th;
            }
        }
        if ((c10 & 2) == 2) {
            this.f12129i = Collections.unmodifiableList(this.f12129i);
        }
        try {
            fVarJ.i();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f12126f = cVar.d();
            throw th3;
        }
        this.f12126f = cVar.d();
    }

    public f(e eVar) {
        this.f12130j = (byte) -1;
        this.f12131k = -1;
        this.f12126f = eVar.f3565f;
    }
}
