package z8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class c extends f9.o {

    /* renamed from: u, reason: collision with root package name */
    public static final c f12057u;

    /* renamed from: v, reason: collision with root package name */
    public static final c9.a f12058v = new c9.a(7);

    /* renamed from: f, reason: collision with root package name */
    public final f9.d f12059f;

    /* renamed from: g, reason: collision with root package name */
    public int f12060g;

    /* renamed from: h, reason: collision with root package name */
    public b f12061h;

    /* renamed from: i, reason: collision with root package name */
    public long f12062i;

    /* renamed from: j, reason: collision with root package name */
    public float f12063j;

    /* renamed from: k, reason: collision with root package name */
    public double f12064k;

    /* renamed from: l, reason: collision with root package name */
    public int f12065l;

    /* renamed from: m, reason: collision with root package name */
    public int f12066m;

    /* renamed from: n, reason: collision with root package name */
    public int f12067n;

    /* renamed from: o, reason: collision with root package name */
    public f f12068o;

    /* renamed from: p, reason: collision with root package name */
    public List f12069p;

    /* renamed from: q, reason: collision with root package name */
    public int f12070q;

    /* renamed from: r, reason: collision with root package name */
    public int f12071r;

    /* renamed from: s, reason: collision with root package name */
    public byte f12072s;

    /* renamed from: t, reason: collision with root package name */
    public int f12073t;

    static {
        c cVar = new c();
        f12057u = cVar;
        cVar.g();
    }

    public c() {
        this.f12072s = (byte) -1;
        this.f12073t = -1;
        this.f12059f = f9.d.f3536f;
    }

    @Override // f9.a
    public final int a() {
        int i2 = this.f12073t;
        if (i2 != -1) {
            return i2;
        }
        int iA = (this.f12060g & 1) == 1 ? f9.f.a(1, this.f12061h.f12033f) : 0;
        if ((this.f12060g & 2) == 2) {
            long j2 = this.f12062i;
            iA += f9.f.g((j2 >> 63) ^ (j2 << 1)) + f9.f.h(2);
        }
        if ((this.f12060g & 4) == 4) {
            iA += f9.f.h(3) + 4;
        }
        if ((this.f12060g & 8) == 8) {
            iA += f9.f.h(4) + 8;
        }
        if ((this.f12060g & 16) == 16) {
            iA += f9.f.b(5, this.f12065l);
        }
        if ((this.f12060g & 32) == 32) {
            iA += f9.f.b(6, this.f12066m);
        }
        if ((this.f12060g & 64) == 64) {
            iA += f9.f.b(7, this.f12067n);
        }
        if ((this.f12060g & 128) == 128) {
            iA += f9.f.d(8, this.f12068o);
        }
        for (int i10 = 0; i10 < this.f12069p.size(); i10++) {
            iA += f9.f.d(9, (f9.a) this.f12069p.get(i10));
        }
        if ((this.f12060g & 512) == 512) {
            iA += f9.f.b(10, this.f12071r);
        }
        if ((this.f12060g & 256) == 256) {
            iA += f9.f.b(11, this.f12070q);
        }
        int size = this.f12059f.size() + iA;
        this.f12073t = size;
        return size;
    }

    @Override // f9.a
    public final f9.j b() {
        return a.e();
    }

    @Override // f9.a
    public final f9.j c() {
        a aVarE = a.e();
        aVarE.f(this);
        return aVarE;
    }

    @Override // f9.a
    public final void d(f9.f fVar) throws IOException {
        a();
        if ((this.f12060g & 1) == 1) {
            fVar.l(1, this.f12061h.f12033f);
        }
        if ((this.f12060g & 2) == 2) {
            long j2 = this.f12062i;
            fVar.x(2, 0);
            fVar.w((j2 >> 63) ^ (j2 << 1));
        }
        if ((this.f12060g & 4) == 4) {
            float f10 = this.f12063j;
            fVar.x(3, 5);
            fVar.t(Float.floatToRawIntBits(f10));
        }
        if ((this.f12060g & 8) == 8) {
            double d6 = this.f12064k;
            fVar.x(4, 1);
            fVar.u(Double.doubleToRawLongBits(d6));
        }
        if ((this.f12060g & 16) == 16) {
            fVar.m(5, this.f12065l);
        }
        if ((this.f12060g & 32) == 32) {
            fVar.m(6, this.f12066m);
        }
        if ((this.f12060g & 64) == 64) {
            fVar.m(7, this.f12067n);
        }
        if ((this.f12060g & 128) == 128) {
            fVar.o(8, this.f12068o);
        }
        for (int i2 = 0; i2 < this.f12069p.size(); i2++) {
            fVar.o(9, (f9.a) this.f12069p.get(i2));
        }
        if ((this.f12060g & 512) == 512) {
            fVar.m(10, this.f12071r);
        }
        if ((this.f12060g & 256) == 256) {
            fVar.m(11, this.f12070q);
        }
        fVar.r(this.f12059f);
    }

    public final void g() {
        this.f12061h = b.BYTE;
        this.f12062i = 0L;
        this.f12063j = 0.0f;
        this.f12064k = 0.0d;
        this.f12065l = 0;
        this.f12066m = 0;
        this.f12067n = 0;
        this.f12068o = f.f12124l;
        this.f12069p = Collections.EMPTY_LIST;
        this.f12070q = 0;
        this.f12071r = 0;
    }

    @Override // f9.v
    public final boolean isInitialized() {
        byte b10 = this.f12072s;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        if ((this.f12060g & 128) == 128 && !this.f12068o.isInitialized()) {
            this.f12072s = (byte) 0;
            return false;
        }
        for (int i2 = 0; i2 < this.f12069p.size(); i2++) {
            if (!((c) this.f12069p.get(i2)).isInitialized()) {
                this.f12072s = (byte) 0;
                return false;
            }
        }
        this.f12072s = (byte) 1;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
    public c(f9.e eVar, f9.h hVar) {
        e eVar2;
        this.f12072s = (byte) -1;
        this.f12073t = -1;
        g();
        f9.c cVar = new f9.c();
        f9.f fVarJ = f9.f.j(cVar, 1);
        boolean z4 = false;
        char c10 = 0;
        while (true) {
            ?? Q = 256;
            if (!z4) {
                try {
                    try {
                        int iN = eVar.n();
                        switch (iN) {
                            case 0:
                                z4 = true;
                            case 8:
                                int iK = eVar.k();
                                b bVarA = b.a(iK);
                                if (bVarA == null) {
                                    fVarJ.v(iN);
                                    fVarJ.v(iK);
                                } else {
                                    this.f12060g |= 1;
                                    this.f12061h = bVarA;
                                }
                            case 16:
                                this.f12060g |= 2;
                                long jL = eVar.l();
                                this.f12062i = (-(jL & 1)) ^ (jL >>> 1);
                            case 29:
                                this.f12060g |= 4;
                                this.f12063j = Float.intBitsToFloat(eVar.i());
                            case 33:
                                this.f12060g |= 8;
                                this.f12064k = Double.longBitsToDouble(eVar.j());
                            case com.google.protobuf.a1.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                                this.f12060g |= 16;
                                this.f12065l = eVar.k();
                            case 48:
                                this.f12060g |= 32;
                                this.f12066m = eVar.k();
                            case 56:
                                this.f12060g |= 64;
                                this.f12067n = eVar.k();
                            case 66:
                                if ((this.f12060g & 128) == 128) {
                                    f fVar = this.f12068o;
                                    fVar.getClass();
                                    eVar2 = new e(0);
                                    eVar2.f12107i = Collections.EMPTY_LIST;
                                    eVar2.i(fVar);
                                } else {
                                    eVar2 = null;
                                }
                                f fVar2 = (f) eVar.g(f.f12125m, hVar);
                                this.f12068o = fVar2;
                                if (eVar2 != null) {
                                    eVar2.i(fVar2);
                                    this.f12068o = eVar2.e();
                                }
                                this.f12060g |= 128;
                            case 74:
                                if ((c10 & 256) != 256) {
                                    this.f12069p = new ArrayList();
                                    c10 = 256;
                                }
                                this.f12069p.add(eVar.g(f12058v, hVar));
                            case 80:
                                this.f12060g |= 512;
                                this.f12071r = eVar.k();
                            case 88:
                                this.f12060g |= 256;
                                this.f12070q = eVar.k();
                            default:
                                Q = eVar.q(iN, fVarJ);
                                if (Q == 0) {
                                    z4 = true;
                                }
                        }
                    } catch (Throwable th) {
                        if ((c10 & 256) == Q) {
                            this.f12069p = Collections.unmodifiableList(this.f12069p);
                        }
                        try {
                            fVarJ.i();
                        } catch (IOException unused) {
                        } catch (Throwable th2) {
                            this.f12059f = cVar.d();
                            throw th2;
                        }
                        this.f12059f = cVar.d();
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
            } else {
                if ((c10 & 256) == 256) {
                    this.f12069p = Collections.unmodifiableList(this.f12069p);
                }
                try {
                    fVarJ.i();
                } catch (IOException unused2) {
                } catch (Throwable th3) {
                    this.f12059f = cVar.d();
                    throw th3;
                }
                this.f12059f = cVar.d();
                return;
            }
        }
    }

    public c(a aVar) {
        this.f12072s = (byte) -1;
        this.f12073t = -1;
        this.f12059f = aVar.f3565f;
    }
}
