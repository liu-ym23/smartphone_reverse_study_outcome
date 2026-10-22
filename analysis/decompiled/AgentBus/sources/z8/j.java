package z8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class j extends f9.k {

    /* renamed from: i, reason: collision with root package name */
    public int f12215i;

    /* renamed from: j, reason: collision with root package name */
    public int f12216j;

    /* renamed from: k, reason: collision with root package name */
    public List f12217k;

    /* renamed from: l, reason: collision with root package name */
    public List f12218l;

    public static j f() {
        j jVar = new j();
        jVar.f12216j = 6;
        List list = Collections.EMPTY_LIST;
        jVar.f12217k = list;
        jVar.f12218l = list;
        return jVar;
    }

    @Override // f9.j
    public final f9.a a() {
        k kVarE = e();
        if (kVarE.isInitialized()) {
            return kVarE;
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
            c9.a r1 = z8.k.f12226o     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            z8.k r1 = new z8.k     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r2.g(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            f9.a r4 = r3.f3597f     // Catch: java.lang.Throwable -> Lf
            z8.k r4 = (z8.k) r4     // Catch: java.lang.Throwable -> Lf
            throw r3     // Catch: java.lang.Throwable -> L17
        L17:
            r3 = move-exception
            r0 = r4
        L19:
            if (r0 == 0) goto L1e
            r2.g(r0)
        L1e:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: z8.j.b(f9.e, f9.h):f9.j");
    }

    @Override // f9.j
    public final /* bridge */ /* synthetic */ f9.j c(f9.o oVar) {
        g((k) oVar);
        return this;
    }

    public final Object clone() {
        j jVarF = f();
        jVarF.g(e());
        return jVarF;
    }

    public final k e() {
        k kVar = new k(this);
        int i2 = this.f12215i;
        int i10 = (i2 & 1) != 1 ? 0 : 1;
        kVar.f12229i = this.f12216j;
        if ((i2 & 2) == 2) {
            this.f12217k = Collections.unmodifiableList(this.f12217k);
            this.f12215i &= -3;
        }
        kVar.f12230j = this.f12217k;
        if ((this.f12215i & 4) == 4) {
            this.f12218l = Collections.unmodifiableList(this.f12218l);
            this.f12215i &= -5;
        }
        kVar.f12231k = this.f12218l;
        kVar.f12228h = i10;
        return kVar;
    }

    public final void g(k kVar) {
        if (kVar == k.f12225n) {
            return;
        }
        if ((kVar.f12228h & 1) == 1) {
            int i2 = kVar.f12229i;
            this.f12215i = 1 | this.f12215i;
            this.f12216j = i2;
        }
        if (!kVar.f12230j.isEmpty()) {
            if (this.f12217k.isEmpty()) {
                this.f12217k = kVar.f12230j;
                this.f12215i &= -3;
            } else {
                if ((this.f12215i & 2) != 2) {
                    this.f12217k = new ArrayList(this.f12217k);
                    this.f12215i |= 2;
                }
                this.f12217k.addAll(kVar.f12230j);
            }
        }
        if (!kVar.f12231k.isEmpty()) {
            if (this.f12218l.isEmpty()) {
                this.f12218l = kVar.f12231k;
                this.f12215i &= -5;
            } else {
                if ((this.f12215i & 4) != 4) {
                    this.f12218l = new ArrayList(this.f12218l);
                    this.f12215i |= 4;
                }
                this.f12218l.addAll(kVar.f12231k);
            }
        }
        d(kVar);
        this.f3565f = this.f3565f.f(kVar.f12227g);
    }
}
