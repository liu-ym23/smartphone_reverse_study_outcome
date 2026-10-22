package x8;

import java.util.Set;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name */
    public static final Set f11250b = ib.k.S(y8.a.CLASS);

    /* renamed from: c, reason: collision with root package name */
    public static final Set f11251c = d7.n.x0(new y8.a[]{y8.a.FILE_FACADE, y8.a.MULTIFILE_CLASS_PART});

    /* renamed from: d, reason: collision with root package name */
    public static final d9.f f11252d;

    /* renamed from: e, reason: collision with root package name */
    public static final d9.f f11253e;

    /* renamed from: a, reason: collision with root package name */
    public r9.i f11254a;

    static {
        new d9.f(new int[]{1, 1, 2}, false);
        f11252d = new d9.f(new int[]{1, 1, 11}, false);
        f11253e = new d9.f(new int[]{1, 1, 13}, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final t9.p a(f8.e0 r17, k8.c r18) {
        /*
            r16 = this;
            r1 = r16
            r2 = r18
            java.lang.String r3 = "Could not read data from "
            java.lang.String r0 = "kotlinClass"
            q7.k.e(r2, r0)
            gb.h r0 = r2.f5653b
            java.lang.Object r4 = r0.f4055e
            java.lang.String[] r4 = (java.lang.String[]) r4
            if (r4 != 0) goto L17
            java.lang.Object r4 = r0.f4056f
            java.lang.String[] r4 = (java.lang.String[]) r4
        L17:
            r5 = 0
            if (r4 == 0) goto L27
            java.lang.Object r6 = r0.f4053c
            y8.a r6 = (y8.a) r6
            java.util.Set r7 = x8.d.f11251c
            boolean r6 = r7.contains(r6)
            if (r6 == 0) goto L27
            goto L28
        L27:
            r4 = r5
        L28:
            if (r4 != 0) goto L2b
            goto L74
        L2b:
            java.lang.Object r6 = r0.f4054d
            r11 = r6
            d9.f r11 = (d9.f) r11
            java.lang.Object r0 = r0.f4057g
            java.lang.String[] r0 = (java.lang.String[]) r0
            if (r0 != 0) goto L37
            goto L74
        L37:
            c7.j r0 = d9.h.h(r4, r0)     // Catch: java.lang.Throwable -> L3c f9.r -> L3e
            goto L72
        L3c:
            r0 = move-exception
            goto L55
        L3e:
            r0 = move-exception
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L3c
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3c
            r6.<init>(r3)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r3 = r2.a()     // Catch: java.lang.Throwable -> L3c
            r6.append(r3)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r3 = r6.toString()     // Catch: java.lang.Throwable -> L3c
            r4.<init>(r3, r0)     // Catch: java.lang.Throwable -> L3c
            throw r4     // Catch: java.lang.Throwable -> L3c
        L55:
            r9.i r3 = r1.c()
            r9.j r3 = r3.f9049c
            r3.getClass()
            r9.i r3 = r1.c()
            r9.j r3 = r3.f9049c
            java.lang.String r4 = "<this>"
            q7.k.e(r3, r4)
            d9.f r3 = d9.f.f3008g
            boolean r3 = r11.b(r3)
            if (r3 != 0) goto Lb2
            r0 = r5
        L72:
            if (r0 != 0) goto L75
        L74:
            return r5
        L75:
            java.lang.Object r3 = r0.f1973f
            r10 = r3
            d9.g r10 = (d9.g) r10
            java.lang.Object r0 = r0.f1974g
            r9 = r0
            z8.b0 r9 = (z8.b0) r9
            x8.f r12 = new x8.f
            r1.d(r2)
            r1.e(r2)
            int r0 = r1.b(r2)
            r12.<init>(r2, r9, r10, r0)
            t9.p r7 = new t9.p
            r9.i r13 = r1.c()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "scope for "
            r0.<init>(r1)
            r0.append(r12)
            java.lang.String r1 = " in "
            r0.append(r1)
            r8 = r17
            r0.append(r8)
            java.lang.String r14 = r0.toString()
            x8.c r15 = x8.c.f11249g
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15)
            return r7
        Lb2:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: x8.d.a(f8.e0, k8.c):t9.p");
    }

    public final int b(k8.c cVar) {
        c().f9049c.getClass();
        int i2 = cVar.f5653b.f4052b;
        if ((i2 & 64) == 0 || (i2 & 32) != 0) {
            return ((i2 & 16) == 0 || (i2 & 32) != 0) ? 1 : 3;
        }
        return 2;
    }

    public final r9.i c() {
        r9.i iVar = this.f11254a;
        if (iVar != null) {
            return iVar;
        }
        q7.k.j("components");
        throw null;
    }

    public final r9.n d(k8.c cVar) {
        c().f9049c.getClass();
        d9.f fVar = (d9.f) cVar.f5653b.f4054d;
        q7.k.e(c().f9049c, "<this>");
        d9.f fVar2 = d9.f.f3008g;
        if (fVar.b(fVar2)) {
            return null;
        }
        d9.f fVar3 = (d9.f) cVar.f5653b.f4054d;
        q7.k.e(c().f9049c, "<this>");
        q7.k.e(c().f9049c, "<this>");
        boolean z4 = fVar3.f3010f;
        fVar2.getClass();
        d9.f fVar4 = z4 ? fVar2 : d9.f.f3009h;
        int i2 = fVar4.f1550b;
        int i10 = fVar2.f1550b;
        return new r9.n(fVar3, fVar2, fVar2, (i2 <= i10 && (i2 < i10 || fVar4.f1551c <= fVar2.f1551c)) ? fVar2 : fVar4, cVar.a(), l8.d.a(cVar.f5652a));
    }

    public final boolean e(k8.c cVar) {
        c().f9049c.getClass();
        c().f9049c.getClass();
        gb.h hVar = cVar.f5653b;
        return (hVar.f4052b & 2) != 0 && ((d9.f) hVar.f4054d).equals(f11252d);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final r9.d f(k8.c r7) {
        /*
            r6 = this;
            java.lang.String r0 = "Could not read data from "
            gb.h r1 = r7.f5653b
            java.lang.Object r2 = r1.f4055e
            java.lang.String[] r2 = (java.lang.String[]) r2
            if (r2 != 0) goto Le
            java.lang.Object r2 = r1.f4056f
            java.lang.String[] r2 = (java.lang.String[]) r2
        Le:
            r3 = 0
            if (r2 == 0) goto L1e
            java.lang.Object r4 = r1.f4053c
            y8.a r4 = (y8.a) r4
            java.util.Set r5 = x8.d.f11250b
            boolean r4 = r5.contains(r4)
            if (r4 == 0) goto L1e
            goto L1f
        L1e:
            r2 = r3
        L1f:
            if (r2 != 0) goto L22
            goto L6a
        L22:
            java.lang.Object r4 = r1.f4054d
            d9.f r4 = (d9.f) r4
            java.lang.Object r1 = r1.f4057g
            java.lang.String[] r1 = (java.lang.String[]) r1
            if (r1 != 0) goto L2d
            goto L6a
        L2d:
            c7.j r0 = d9.h.f(r2, r1)     // Catch: java.lang.Throwable -> L32 f9.r -> L34
            goto L68
        L32:
            r0 = move-exception
            goto L4b
        L34:
            r1 = move-exception
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L32
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L32
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L32
            java.lang.String r0 = r7.a()     // Catch: java.lang.Throwable -> L32
            r5.append(r0)     // Catch: java.lang.Throwable -> L32
            java.lang.String r0 = r5.toString()     // Catch: java.lang.Throwable -> L32
            r2.<init>(r0, r1)     // Catch: java.lang.Throwable -> L32
            throw r2     // Catch: java.lang.Throwable -> L32
        L4b:
            r9.i r1 = r6.c()
            r9.j r1 = r1.f9049c
            r1.getClass()
            r9.i r1 = r6.c()
            r9.j r1 = r1.f9049c
            java.lang.String r2 = "<this>"
            q7.k.e(r1, r2)
            d9.f r1 = d9.f.f3008g
            boolean r1 = r4.b(r1)
            if (r1 != 0) goto L88
            r0 = r3
        L68:
            if (r0 != 0) goto L6b
        L6a:
            return r3
        L6b:
            java.lang.Object r1 = r0.f1973f
            d9.g r1 = (d9.g) r1
            java.lang.Object r0 = r0.f1974g
            z8.i r0 = (z8.i) r0
            x8.n r2 = new x8.n
            r6.d(r7)
            r6.e(r7)
            int r6 = r6.b(r7)
            r2.<init>(r7, r6)
            r9.d r6 = new r9.d
            r6.<init>(r1, r0, r4, r2)
            return r6
        L88:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: x8.d.f(k8.c):r9.d");
    }
}
