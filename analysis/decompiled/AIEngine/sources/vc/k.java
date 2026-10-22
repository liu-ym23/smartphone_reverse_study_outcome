package vc;

import kotlinx.serialization.json.internal.WriteMode;
import mb.y;
import tc.t0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class k implements uc.k, sc.e, sc.c {

    /* renamed from: a, reason: collision with root package name */
    public final hb.c f13506a;

    /* renamed from: b, reason: collision with root package name */
    public final uc.a f13507b;

    /* renamed from: c, reason: collision with root package name */
    public final WriteMode f13508c;

    /* renamed from: d, reason: collision with root package name */
    public final uc.k[] f13509d;

    /* renamed from: e, reason: collision with root package name */
    public final androidx.datastore.preferences.protobuf.f f13510e;

    /* renamed from: f, reason: collision with root package name */
    public final uc.e f13511f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f13512g;
    public String h;

    /* renamed from: i, reason: collision with root package name */
    public String f13513i;

    public k(hb.c composer, uc.a aVar, WriteMode writeMode, uc.k[] kVarArr) {
        kotlin.jvm.internal.g.f(composer, "composer");
        this.f13506a = composer;
        this.f13507b = aVar;
        this.f13508c = writeMode;
        this.f13509d = kVarArr;
        this.f13510e = aVar.f13195b;
        this.f13511f = aVar.f13194a;
        int iOrdinal = writeMode.ordinal();
        if (kVarArr != null) {
            uc.k kVar = kVarArr[iOrdinal];
            if (kVar == null && kVar == this) {
                return;
            }
            kVarArr[iOrdinal] = this;
        }
    }

    @Override // sc.c
    public final void A(t0 descriptor, int i10, char c9) {
        kotlin.jvm.internal.g.f(descriptor, "descriptor");
        D(descriptor, i10);
        t(c9);
    }

    @Override // sc.e
    public final void B(String value) {
        kotlin.jvm.internal.g.f(value, "value");
        this.f13506a.k(value);
    }

    public final sc.c C(rc.e descriptor) {
        kotlin.jvm.internal.g.f(descriptor, "descriptor");
        return b(descriptor);
    }

    public final void D(rc.e descriptor, int i10) {
        kotlin.jvm.internal.g.f(descriptor, "descriptor");
        int iOrdinal = this.f13508c.ordinal();
        hb.c cVar = this.f13506a;
        boolean z = true;
        if (iOrdinal == 1) {
            if (!cVar.f9386a) {
                cVar.f(',');
            }
            cVar.d();
            return;
        }
        if (iOrdinal == 2) {
            if (cVar.f9386a) {
                this.f13512g = true;
                cVar.d();
                return;
            }
            if (i10 % 2 == 0) {
                cVar.f(',');
                cVar.d();
            } else {
                cVar.f(':');
                cVar.l();
                z = false;
            }
            this.f13512g = z;
            return;
        }
        if (iOrdinal != 3) {
            if (!cVar.f9386a) {
                cVar.f(',');
            }
            cVar.d();
            h.b(descriptor, this.f13507b);
            B(descriptor.f(i10));
            cVar.f(':');
            cVar.l();
            return;
        }
        if (i10 == 0) {
            this.f13512g = true;
        }
        if (i10 == 1) {
            cVar.f(',');
            cVar.l();
            this.f13512g = false;
        }
    }

    @Override // sc.c
    public final void a(rc.e descriptor) {
        kotlin.jvm.internal.g.f(descriptor, "descriptor");
        hb.c cVar = this.f13506a;
        cVar.getClass();
        cVar.f9386a = false;
        cVar.f(this.f13508c.f10142b);
    }

    @Override // sc.e
    public final sc.c b(rc.e descriptor) {
        uc.k kVar;
        kotlin.jvm.internal.g.f(descriptor, "descriptor");
        uc.a aVar = this.f13507b;
        WriteMode writeModeB = o.b(descriptor, aVar);
        char c9 = writeModeB.f10141a;
        hb.c cVar = this.f13506a;
        cVar.f(c9);
        cVar.f9386a = true;
        String str = this.h;
        if (str != null) {
            String strI = this.f13513i;
            if (strI == null) {
                strI = descriptor.i();
            }
            cVar.d();
            B(str);
            cVar.f(':');
            B(strI);
            this.h = null;
            this.f13513i = null;
        }
        if (this.f13508c == writeModeB) {
            return this;
        }
        uc.k[] kVarArr = this.f13509d;
        return (kVarArr == null || (kVar = kVarArr[writeModeB.ordinal()]) == null) ? new k(cVar, aVar, writeModeB, kVarArr) : kVar;
    }

    @Override // sc.e
    public final void c(double d8) {
        boolean z = this.f13512g;
        hb.c cVar = this.f13506a;
        if (z) {
            B(String.valueOf(d8));
        } else {
            ((l5.a) cVar.f9387b).k(String.valueOf(d8));
        }
        if (Double.isInfinite(d8) || Double.isNaN(d8)) {
            throw y.a(Double.valueOf(d8), ((l5.a) cVar.f9387b).toString());
        }
    }

    @Override // sc.e
    public final void d(byte b10) {
        if (this.f13512g) {
            B(String.valueOf((int) b10));
        } else {
            this.f13506a.e(b10);
        }
    }

    @Override // sc.c
    public final void e(rc.e descriptor, int i10, pc.a aVar, Object obj) {
        kotlin.jvm.internal.g.f(descriptor, "descriptor");
        if (obj != null || this.f13511f.f13205c) {
            kotlin.jvm.internal.g.f(descriptor, "descriptor");
            D(descriptor, i10);
            if (aVar.d().b()) {
                q(aVar, obj);
            } else if (obj == null) {
                k();
            } else {
                q(aVar, obj);
            }
        }
    }

    @Override // sc.c
    public final void f(t0 descriptor, int i10, int i11) {
        kotlin.jvm.internal.g.f(descriptor, "descriptor");
        D(descriptor, i10);
        w(i11);
    }

    @Override // sc.c
    public final void g(rc.e descriptor, int i10, pc.c serializer, Object obj) {
        kotlin.jvm.internal.g.f(descriptor, "descriptor");
        kotlin.jvm.internal.g.f(serializer, "serializer");
        D(descriptor, i10);
        q(serializer, obj);
    }

    @Override // sc.c
    public final void h(t0 descriptor, int i10, double d8) {
        kotlin.jvm.internal.g.f(descriptor, "descriptor");
        D(descriptor, i10);
        c(d8);
    }

    @Override // sc.e
    public final void i(long j10) {
        if (this.f13512g) {
            B(String.valueOf(j10));
        } else {
            this.f13506a.h(j10);
        }
    }

    @Override // sc.c
    public final void j(t0 descriptor, int i10, short s8) {
        kotlin.jvm.internal.g.f(descriptor, "descriptor");
        D(descriptor, i10);
        m(s8);
    }

    @Override // sc.e
    public final void k() {
        this.f13506a.i("null");
    }

    @Override // sc.c
    public final void l(t0 descriptor, int i10, byte b10) {
        kotlin.jvm.internal.g.f(descriptor, "descriptor");
        D(descriptor, i10);
        d(b10);
    }

    @Override // sc.e
    public final void m(short s8) {
        if (this.f13512g) {
            B(String.valueOf((int) s8));
        } else {
            this.f13506a.j(s8);
        }
    }

    @Override // sc.c
    public final void n(t0 descriptor, int i10, float f8) {
        kotlin.jvm.internal.g.f(descriptor, "descriptor");
        D(descriptor, i10);
        r(f8);
    }

    @Override // sc.e
    public final void o(boolean z) {
        if (this.f13512g) {
            B(String.valueOf(z));
        } else {
            ((l5.a) this.f13506a.f9387b).k(String.valueOf(z));
        }
    }

    @Override // sc.c
    public final void p(t0 descriptor, int i10, boolean z) {
        kotlin.jvm.internal.g.f(descriptor, "descriptor");
        D(descriptor, i10);
        o(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0044  */
    @Override // sc.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <T> void q(pc.c<? super T> r8, T r9) {
        /*
            r7 = this;
            java.lang.String r0 = "serializer"
            kotlin.jvm.internal.g.f(r8, r0)
            uc.a r0 = r7.f13507b
            uc.e r1 = r0.f13194a
            boolean r2 = r8 instanceof tc.b
            java.lang.String r3 = "<this>"
            r4 = 0
            if (r2 == 0) goto L17
            kotlinx.serialization.json.ClassDiscriminatorMode r1 = r1.h
            kotlinx.serialization.json.ClassDiscriminatorMode r5 = kotlinx.serialization.json.ClassDiscriminatorMode.f10122a
            if (r1 == r5) goto L6f
            goto L44
        L17:
            kotlinx.serialization.json.ClassDiscriminatorMode r1 = r1.h
            int r1 = r1.ordinal()
            if (r1 == 0) goto L6f
            r5 = 1
            if (r1 == r5) goto L2c
            r0 = 2
            if (r1 != r0) goto L26
            goto L6f
        L26:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        L2c:
            rc.e r1 = r8.d()
            rc.i r1 = r1.d()
            rc.j$a r5 = rc.j.a.f11801a
            boolean r5 = kotlin.jvm.internal.g.b(r1, r5)
            if (r5 != 0) goto L44
            rc.j$d r5 = rc.j.d.f11804a
            boolean r1 = kotlin.jvm.internal.g.b(r1, r5)
            if (r1 == 0) goto L6f
        L44:
            rc.e r1 = r8.d()
            kotlin.jvm.internal.g.f(r1, r3)
            java.util.List r1 = r1.getAnnotations()
            java.util.Iterator r1 = r1.iterator()
        L53:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L6a
            java.lang.Object r5 = r1.next()
            java.lang.annotation.Annotation r5 = (java.lang.annotation.Annotation) r5
            boolean r6 = r5 instanceof uc.d
            if (r6 == 0) goto L53
            uc.d r5 = (uc.d) r5
            java.lang.String r0 = r5.discriminator()
            goto L70
        L6a:
            uc.e r0 = r0.f13194a
            java.lang.String r0 = r0.f13208f
            goto L70
        L6f:
            r0 = r4
        L70:
            if (r2 == 0) goto Lc9
            r1 = r8
            tc.b r1 = (tc.b) r1
            r9.getClass()
            pc.c r1 = jd.b.q(r1, r7, r9)
            if (r0 == 0) goto L96
            boolean r8 = r8 instanceof pc.b
            if (r8 != 0) goto L83
            goto L96
        L83:
            rc.e r8 = r1.d()
            kotlin.jvm.internal.g.f(r8, r3)
            java.util.Set r8 = tc.p0.b(r8)
            boolean r8 = r8.contains(r0)
            if (r8 != 0) goto L95
            goto L96
        L95:
            throw r4
        L96:
            rc.e r8 = r1.d()
            rc.i r8 = r8.d()
            java.lang.String r2 = "kind"
            kotlin.jvm.internal.g.f(r8, r2)
            boolean r2 = r8 instanceof rc.i.b
            if (r2 != 0) goto Lc1
            boolean r2 = r8 instanceof rc.d
            if (r2 != 0) goto Lb9
            boolean r8 = r8 instanceof rc.c
            if (r8 != 0) goto Lb1
            r8 = r1
            goto Lc9
        Lb1:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Actual serializer for polymorphic cannot be polymorphic itself"
            r7.<init>(r8)
            throw r7
        Lb9:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Primitives cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead"
            r7.<init>(r8)
            throw r7
        Lc1:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Enums cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead"
            r7.<init>(r8)
            throw r7
        Lc9:
            if (r0 == 0) goto Ld7
            rc.e r1 = r8.d()
            java.lang.String r1 = r1.i()
            r7.h = r0
            r7.f13513i = r1
        Ld7:
            r8.a(r7, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: vc.k.q(pc.c, java.lang.Object):void");
    }

    @Override // sc.e
    public final void r(float f8) {
        boolean z = this.f13512g;
        hb.c cVar = this.f13506a;
        if (z) {
            B(String.valueOf(f8));
        } else {
            ((l5.a) cVar.f9387b).k(String.valueOf(f8));
        }
        if (Float.isInfinite(f8) || Float.isNaN(f8)) {
            throw y.a(Float.valueOf(f8), ((l5.a) cVar.f9387b).toString());
        }
    }

    @Override // sc.e
    public final androidx.datastore.preferences.protobuf.f s() {
        return this.f13510e;
    }

    @Override // sc.e
    public final void t(char c9) {
        B(String.valueOf(c9));
    }

    @Override // sc.c
    public final void u(rc.e descriptor, int i10, String value) {
        kotlin.jvm.internal.g.f(descriptor, "descriptor");
        kotlin.jvm.internal.g.f(value, "value");
        D(descriptor, i10);
        B(value);
    }

    @Override // sc.c
    public final sc.e v(t0 descriptor, int i10) {
        kotlin.jvm.internal.g.f(descriptor, "descriptor");
        D(descriptor, i10);
        return z(descriptor.h(i10));
    }

    @Override // sc.e
    public final void w(int i10) {
        if (this.f13512g) {
            B(String.valueOf(i10));
        } else {
            this.f13506a.g(i10);
        }
    }

    @Override // sc.c
    public final boolean x(rc.e descriptor) {
        kotlin.jvm.internal.g.f(descriptor, "descriptor");
        return false;
    }

    @Override // sc.c
    public final void y(rc.e descriptor, int i10, long j10) {
        kotlin.jvm.internal.g.f(descriptor, "descriptor");
        D(descriptor, i10);
        i(j10);
    }

    @Override // sc.e
    public final sc.e z(rc.e descriptor) {
        kotlin.jvm.internal.g.f(descriptor, "descriptor");
        boolean zA = l.a(descriptor);
        WriteMode writeMode = this.f13508c;
        uc.a aVar = this.f13507b;
        hb.c dVar = this.f13506a;
        if (zA) {
            if (!(dVar instanceof e)) {
                dVar = new e((l5.a) dVar.f9387b, this.f13512g);
            }
            return new k(dVar, aVar, writeMode, null);
        }
        if (descriptor.isInline() && descriptor.equals(uc.h.f13210a)) {
            if (!(dVar instanceof d)) {
                dVar = new d((l5.a) dVar.f9387b, this.f13512g);
            }
            return new k(dVar, aVar, writeMode, null);
        }
        if (this.h != null) {
            this.f13513i = descriptor.i();
        }
        return this;
    }
}
