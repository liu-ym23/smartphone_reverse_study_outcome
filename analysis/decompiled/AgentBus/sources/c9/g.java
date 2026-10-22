package c9;

import f9.o;
import f9.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class g extends f9.j implements v {

    /* renamed from: g, reason: collision with root package name */
    public int f2125g;

    /* renamed from: h, reason: collision with root package name */
    public List f2126h;

    /* renamed from: i, reason: collision with root package name */
    public List f2127i;

    @Override // f9.j
    public final f9.a a() {
        k kVarD = d();
        kVarD.isInitialized();
        return kVarD;
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
            c9.a r1 = c9.k.f2155m     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            c9.k r1 = new c9.k     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r2.e(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            f9.a r4 = r3.f3597f     // Catch: java.lang.Throwable -> Lf
            c9.k r4 = (c9.k) r4     // Catch: java.lang.Throwable -> Lf
            throw r3     // Catch: java.lang.Throwable -> L17
        L17:
            r3 = move-exception
            r0 = r4
        L19:
            if (r0 == 0) goto L1e
            r2.e(r0)
        L1e:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: c9.g.b(f9.e, f9.h):f9.j");
    }

    @Override // f9.j
    public final /* bridge */ /* synthetic */ f9.j c(o oVar) {
        e((k) oVar);
        return this;
    }

    public final Object clone() {
        g gVar = new g();
        List list = Collections.EMPTY_LIST;
        gVar.f2126h = list;
        gVar.f2127i = list;
        gVar.e(d());
        return gVar;
    }

    public final k d() {
        k kVar = new k(this);
        if ((this.f2125g & 1) == 1) {
            this.f2126h = Collections.unmodifiableList(this.f2126h);
            this.f2125g &= -2;
        }
        kVar.f2157g = this.f2126h;
        if ((this.f2125g & 2) == 2) {
            this.f2127i = Collections.unmodifiableList(this.f2127i);
            this.f2125g &= -3;
        }
        kVar.f2158h = this.f2127i;
        return kVar;
    }

    public final void e(k kVar) {
        if (kVar == k.f2154l) {
            return;
        }
        if (!kVar.f2157g.isEmpty()) {
            if (this.f2126h.isEmpty()) {
                this.f2126h = kVar.f2157g;
                this.f2125g &= -2;
            } else {
                if ((this.f2125g & 1) != 1) {
                    this.f2126h = new ArrayList(this.f2126h);
                    this.f2125g |= 1;
                }
                this.f2126h.addAll(kVar.f2157g);
            }
        }
        if (!kVar.f2158h.isEmpty()) {
            if (this.f2127i.isEmpty()) {
                this.f2127i = kVar.f2158h;
                this.f2125g &= -3;
            } else {
                if ((this.f2125g & 2) != 2) {
                    this.f2127i = new ArrayList(this.f2127i);
                    this.f2125g |= 2;
                }
                this.f2127i.addAll(kVar.f2158h);
            }
        }
        this.f3565f = this.f3565f.f(kVar.f2156f);
    }
}
