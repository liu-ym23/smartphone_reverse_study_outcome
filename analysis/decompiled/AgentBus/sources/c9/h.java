package c9;

import f9.o;
import f9.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class h extends f9.j implements v {

    /* renamed from: g, reason: collision with root package name */
    public int f2128g;

    /* renamed from: h, reason: collision with root package name */
    public int f2129h;

    /* renamed from: i, reason: collision with root package name */
    public int f2130i;

    /* renamed from: j, reason: collision with root package name */
    public Object f2131j;

    /* renamed from: k, reason: collision with root package name */
    public i f2132k;

    /* renamed from: l, reason: collision with root package name */
    public List f2133l;

    /* renamed from: m, reason: collision with root package name */
    public List f2134m;

    public static h e() {
        h hVar = new h();
        hVar.f2129h = 1;
        hVar.f2131j = "";
        hVar.f2132k = i.NONE;
        List list = Collections.EMPTY_LIST;
        hVar.f2133l = list;
        hVar.f2134m = list;
        return hVar;
    }

    @Override // f9.j
    public final f9.a a() {
        j jVarD = d();
        jVarD.isInitialized();
        return jVarD;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001b  */
    @Override // f9.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final f9.j b(f9.e r2, f9.h r3) throws java.lang.Throwable {
        /*
            r1 = this;
            r3 = 0
            c9.a r0 = c9.j.f2141s     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r0.getClass()     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            c9.j r0 = new c9.j     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r0.<init>(r2)     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r1.f(r0)
            return r1
        Lf:
            r2 = move-exception
            goto L19
        L11:
            r2 = move-exception
            f9.a r0 = r2.f3597f     // Catch: java.lang.Throwable -> Lf
            c9.j r0 = (c9.j) r0     // Catch: java.lang.Throwable -> Lf
            throw r2     // Catch: java.lang.Throwable -> L17
        L17:
            r2 = move-exception
            r3 = r0
        L19:
            if (r3 == 0) goto L1e
            r1.f(r3)
        L1e:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: c9.h.b(f9.e, f9.h):f9.j");
    }

    @Override // f9.j
    public final /* bridge */ /* synthetic */ f9.j c(o oVar) {
        f((j) oVar);
        return this;
    }

    public final Object clone() {
        h hVarE = e();
        hVarE.f(d());
        return hVarE;
    }

    public final j d() {
        j jVar = new j(this);
        int i2 = this.f2128g;
        int i10 = (i2 & 1) != 1 ? 0 : 1;
        jVar.f2144h = this.f2129h;
        if ((i2 & 2) == 2) {
            i10 |= 2;
        }
        jVar.f2145i = this.f2130i;
        if ((i2 & 4) == 4) {
            i10 |= 4;
        }
        jVar.f2146j = this.f2131j;
        if ((i2 & 8) == 8) {
            i10 |= 8;
        }
        jVar.f2147k = this.f2132k;
        if ((i2 & 16) == 16) {
            this.f2133l = Collections.unmodifiableList(this.f2133l);
            this.f2128g &= -17;
        }
        jVar.f2148l = this.f2133l;
        if ((this.f2128g & 32) == 32) {
            this.f2134m = Collections.unmodifiableList(this.f2134m);
            this.f2128g &= -33;
        }
        jVar.f2150n = this.f2134m;
        jVar.f2143g = i10;
        return jVar;
    }

    public final void f(j jVar) {
        if (jVar == j.f2140r) {
            return;
        }
        int i2 = jVar.f2143g;
        if ((i2 & 1) == 1) {
            int i10 = jVar.f2144h;
            this.f2128g = 1 | this.f2128g;
            this.f2129h = i10;
        }
        if ((i2 & 2) == 2) {
            int i11 = jVar.f2145i;
            this.f2128g = 2 | this.f2128g;
            this.f2130i = i11;
        }
        if ((i2 & 4) == 4) {
            this.f2128g |= 4;
            this.f2131j = jVar.f2146j;
        }
        if ((i2 & 8) == 8) {
            i iVar = jVar.f2147k;
            iVar.getClass();
            this.f2128g = 8 | this.f2128g;
            this.f2132k = iVar;
        }
        if (!jVar.f2148l.isEmpty()) {
            if (this.f2133l.isEmpty()) {
                this.f2133l = jVar.f2148l;
                this.f2128g &= -17;
            } else {
                if ((this.f2128g & 16) != 16) {
                    this.f2133l = new ArrayList(this.f2133l);
                    this.f2128g |= 16;
                }
                this.f2133l.addAll(jVar.f2148l);
            }
        }
        if (!jVar.f2150n.isEmpty()) {
            if (this.f2134m.isEmpty()) {
                this.f2134m = jVar.f2150n;
                this.f2128g &= -33;
            } else {
                if ((this.f2128g & 32) != 32) {
                    this.f2134m = new ArrayList(this.f2134m);
                    this.f2128g |= 32;
                }
                this.f2134m.addAll(jVar.f2150n);
            }
        }
        this.f3565f = this.f3565f.f(jVar.f2142f);
    }
}
