package o5;

import n7.o;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final o f7754a;

    /* renamed from: b, reason: collision with root package name */
    public final o f7755b;

    /* renamed from: c, reason: collision with root package name */
    public final o f7756c;

    /* renamed from: d, reason: collision with root package name */
    public final o f7757d;

    /* renamed from: e, reason: collision with root package name */
    public final o f7758e;

    /* renamed from: f, reason: collision with root package name */
    public final o f7759f;

    /* renamed from: g, reason: collision with root package name */
    public final a f7760g;

    public f(o oVar, o oVar2, o oVar3, o oVar4, o oVar5, o oVar6, a aVar) {
        this.f7754a = oVar;
        this.f7755b = oVar2;
        this.f7756c = oVar3;
        this.f7757d = oVar4;
        this.f7758e = oVar5;
        this.f7759f = oVar6;
        this.f7760g = aVar;
    }

    public static f a(f fVar, o oVar, o oVar2, a aVar, int i2) {
        if ((i2 & 1) != 0) {
            oVar = fVar.f7754a;
        }
        o oVar3 = oVar;
        o oVar4 = fVar.f7755b;
        o oVar5 = fVar.f7756c;
        o oVar6 = fVar.f7757d;
        o oVar7 = fVar.f7758e;
        if ((i2 & 32) != 0) {
            oVar2 = fVar.f7759f;
        }
        o oVar8 = oVar2;
        if ((i2 & 64) != 0) {
            aVar = fVar.f7760g;
        }
        return new f(oVar3, oVar4, oVar5, oVar6, oVar7, oVar8, aVar);
    }

    public final boolean b(f fVar) {
        q7.k.e(fVar, "prev");
        if (!(this.f7755b instanceof i) && (fVar.f7755b instanceof i)) {
            return true;
        }
        if (!(this.f7756c instanceof i) && (fVar.f7756c instanceof i)) {
            return true;
        }
        if (!(this.f7757d instanceof i) && (fVar.f7757d instanceof i)) {
            return true;
        }
        if ((this.f7758e instanceof i) || !(fVar.f7758e instanceof i)) {
            return !(this.f7759f instanceof i) && (fVar.f7759f instanceof i);
        }
        return true;
    }

    public final boolean c(f fVar) {
        q7.k.e(fVar, "other");
        return this.f7754a.y(fVar.f7754a) && this.f7755b.y(fVar.f7755b) && this.f7756c.y(fVar.f7756c) && this.f7757d.y(fVar.f7757d) && this.f7758e.y(fVar.f7758e) && this.f7759f.y(fVar.f7759f) && q7.k.a(this.f7760g, fVar.f7760g);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final o5.f d(boolean r6, o5.a r7) {
        /*
            r5 = this;
            if (r6 != 0) goto L3
            return r5
        L3:
            if (r7 != 0) goto Lc
            o5.a r6 = new o5.a
            r0 = 0
            r6.<init>(r0, r0, r0)
            goto Ld
        Lc:
            r6 = r7
        Ld:
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 0
            if (r7 == 0) goto L3b
            boolean r3 = r7.f7729b
            boolean r4 = r7.f7728a
            if (r4 != 0) goto L1b
            goto L3b
        L1b:
            if (r4 == 0) goto L29
            if (r3 == 0) goto L29
            boolean r7 = r7.f7730c
            if (r7 == 0) goto L29
            o5.g r7 = new o5.g
            r7.<init>(r2)
            goto L44
        L29:
            if (r3 == 0) goto L31
            o5.h r7 = new o5.h
            r7.<init>(r0)
            goto L44
        L31:
            o5.i r7 = new o5.i
            java.lang.String r3 = "bff ws disconnected"
            o5.j r4 = o5.j.Auto
            r7.<init>(r3, r0, r4)
            goto L44
        L3b:
            o5.i r7 = new o5.i
            java.lang.String r3 = "bff bridge disabled"
            o5.j r4 = o5.j.Permanent
            r7.<init>(r3, r0, r4)
        L44:
            r0 = 31
            o5.f r5 = a(r5, r2, r7, r6, r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: o5.f.d(boolean, o5.a):o5.f");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return q7.k.a(this.f7754a, fVar.f7754a) && q7.k.a(this.f7755b, fVar.f7755b) && q7.k.a(this.f7756c, fVar.f7756c) && q7.k.a(this.f7757d, fVar.f7757d) && q7.k.a(this.f7758e, fVar.f7758e) && q7.k.a(this.f7759f, fVar.f7759f) && q7.k.a(this.f7760g, fVar.f7760g);
    }

    public final int hashCode() {
        return this.f7760g.hashCode() + ((this.f7759f.hashCode() + ((this.f7758e.hashCode() + ((this.f7757d.hashCode() + ((this.f7756c.hashCode() + ((this.f7755b.hashCode() + (this.f7754a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "HealthSnapshot(service=" + this.f7754a + ", chat=" + this.f7755b + ", tools=" + this.f7756c + ", channel=" + this.f7757d + ", upstream=" + this.f7758e + ", bff=" + this.f7759f + ", bffProbe=" + this.f7760g + ")";
    }
}
