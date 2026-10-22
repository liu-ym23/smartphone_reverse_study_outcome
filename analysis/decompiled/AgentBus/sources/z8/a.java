package z8;

import fi.iki.elonen.NanoHTTPD;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class a extends f9.j implements f9.v {

    /* renamed from: g, reason: collision with root package name */
    public int f11996g;

    /* renamed from: h, reason: collision with root package name */
    public b f11997h;

    /* renamed from: i, reason: collision with root package name */
    public long f11998i;

    /* renamed from: j, reason: collision with root package name */
    public float f11999j;

    /* renamed from: k, reason: collision with root package name */
    public double f12000k;

    /* renamed from: l, reason: collision with root package name */
    public int f12001l;

    /* renamed from: m, reason: collision with root package name */
    public int f12002m;

    /* renamed from: n, reason: collision with root package name */
    public int f12003n;

    /* renamed from: o, reason: collision with root package name */
    public f f12004o;

    /* renamed from: p, reason: collision with root package name */
    public List f12005p;

    /* renamed from: q, reason: collision with root package name */
    public int f12006q;

    /* renamed from: r, reason: collision with root package name */
    public int f12007r;

    public static a e() {
        a aVar = new a();
        aVar.f11997h = b.BYTE;
        aVar.f12004o = f.f12124l;
        aVar.f12005p = Collections.EMPTY_LIST;
        return aVar;
    }

    @Override // f9.j
    public final f9.a a() {
        c cVarD = d();
        if (cVarD.isInitialized()) {
            return cVarD;
        }
        throw new a4.u(4);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001b  */
    @Override // f9.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final f9.j b(f9.e r3, f9.h r4) throws java.lang.Throwable {
        /*
            r2 = this;
            r0 = 0
            c9.a r1 = z8.c.f12058v     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            z8.c r1 = new z8.c     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r2.f(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            f9.a r4 = r3.f3597f     // Catch: java.lang.Throwable -> Lf
            z8.c r4 = (z8.c) r4     // Catch: java.lang.Throwable -> Lf
            throw r3     // Catch: java.lang.Throwable -> L17
        L17:
            r3 = move-exception
            r0 = r4
        L19:
            if (r0 == 0) goto L1e
            r2.f(r0)
        L1e:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: z8.a.b(f9.e, f9.h):f9.j");
    }

    @Override // f9.j
    public final /* bridge */ /* synthetic */ f9.j c(f9.o oVar) {
        f((c) oVar);
        return this;
    }

    public final Object clone() {
        a aVarE = e();
        aVarE.f(d());
        return aVarE;
    }

    public final c d() {
        c cVar = new c(this);
        int i2 = this.f11996g;
        int i10 = (i2 & 1) != 1 ? 0 : 1;
        cVar.f12061h = this.f11997h;
        if ((i2 & 2) == 2) {
            i10 |= 2;
        }
        cVar.f12062i = this.f11998i;
        if ((i2 & 4) == 4) {
            i10 |= 4;
        }
        cVar.f12063j = this.f11999j;
        if ((i2 & 8) == 8) {
            i10 |= 8;
        }
        cVar.f12064k = this.f12000k;
        if ((i2 & 16) == 16) {
            i10 |= 16;
        }
        cVar.f12065l = this.f12001l;
        if ((i2 & 32) == 32) {
            i10 |= 32;
        }
        cVar.f12066m = this.f12002m;
        if ((i2 & 64) == 64) {
            i10 |= 64;
        }
        cVar.f12067n = this.f12003n;
        if ((i2 & 128) == 128) {
            i10 |= 128;
        }
        cVar.f12068o = this.f12004o;
        if ((i2 & 256) == 256) {
            this.f12005p = Collections.unmodifiableList(this.f12005p);
            this.f11996g &= -257;
        }
        cVar.f12069p = this.f12005p;
        if ((i2 & 512) == 512) {
            i10 |= 256;
        }
        cVar.f12070q = this.f12006q;
        if ((i2 & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) == 1024) {
            i10 |= 512;
        }
        cVar.f12071r = this.f12007r;
        cVar.f12060g = i10;
        return cVar;
    }

    public final void f(c cVar) {
        f fVar;
        if (cVar == c.f12057u) {
            return;
        }
        if ((cVar.f12060g & 1) == 1) {
            b bVar = cVar.f12061h;
            bVar.getClass();
            this.f11996g = 1 | this.f11996g;
            this.f11997h = bVar;
        }
        int i2 = cVar.f12060g;
        if ((i2 & 2) == 2) {
            long j2 = cVar.f12062i;
            this.f11996g |= 2;
            this.f11998i = j2;
        }
        if ((i2 & 4) == 4) {
            float f10 = cVar.f12063j;
            this.f11996g = 4 | this.f11996g;
            this.f11999j = f10;
        }
        if ((i2 & 8) == 8) {
            double d6 = cVar.f12064k;
            this.f11996g |= 8;
            this.f12000k = d6;
        }
        if ((i2 & 16) == 16) {
            int i10 = cVar.f12065l;
            this.f11996g = 16 | this.f11996g;
            this.f12001l = i10;
        }
        if ((i2 & 32) == 32) {
            int i11 = cVar.f12066m;
            this.f11996g = 32 | this.f11996g;
            this.f12002m = i11;
        }
        if ((i2 & 64) == 64) {
            int i12 = cVar.f12067n;
            this.f11996g = 64 | this.f11996g;
            this.f12003n = i12;
        }
        if ((i2 & 128) == 128) {
            f fVar2 = cVar.f12068o;
            if ((this.f11996g & 128) != 128 || (fVar = this.f12004o) == f.f12124l) {
                this.f12004o = fVar2;
            } else {
                e eVar = new e(0);
                eVar.f12107i = Collections.EMPTY_LIST;
                eVar.i(fVar);
                eVar.i(fVar2);
                this.f12004o = eVar.e();
            }
            this.f11996g |= 128;
        }
        if (!cVar.f12069p.isEmpty()) {
            if (this.f12005p.isEmpty()) {
                this.f12005p = cVar.f12069p;
                this.f11996g &= -257;
            } else {
                if ((this.f11996g & 256) != 256) {
                    this.f12005p = new ArrayList(this.f12005p);
                    this.f11996g |= 256;
                }
                this.f12005p.addAll(cVar.f12069p);
            }
        }
        int i13 = cVar.f12060g;
        if ((i13 & 256) == 256) {
            int i14 = cVar.f12070q;
            this.f11996g |= 512;
            this.f12006q = i14;
        }
        if ((i13 & 512) == 512) {
            int i15 = cVar.f12071r;
            this.f11996g |= NanoHTTPD.HTTPSession.MAX_HEADER_SIZE;
            this.f12007r = i15;
        }
        this.f3565f = this.f3565f.f(cVar.f12059f);
    }
}
