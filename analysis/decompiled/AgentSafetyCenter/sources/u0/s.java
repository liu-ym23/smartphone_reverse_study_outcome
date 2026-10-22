package u0;

import java.util.HashMap;
import k0.i0;
import p.f0;
import p.g0;
import u1.o1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public xb.l f13689a;

    /* renamed from: b, reason: collision with root package name */
    public Object f13690b;

    /* renamed from: c, reason: collision with root package name */
    public p.z f13691c;

    /* renamed from: d, reason: collision with root package name */
    public int f13692d;

    /* renamed from: e, reason: collision with root package name */
    public f0 f13693e;

    /* renamed from: f, reason: collision with root package name */
    public f0 f13694f;

    /* renamed from: g, reason: collision with root package name */
    public g0 f13695g;

    /* renamed from: h, reason: collision with root package name */
    public m0.e f13696h;
    public k0.q i;

    /* renamed from: j, reason: collision with root package name */
    public int f13697j;

    /* renamed from: k, reason: collision with root package name */
    public f0 f13698k;

    /* renamed from: l, reason: collision with root package name */
    public HashMap f13699l;

    public final void a(o1 o1Var, a9.e eVar, xb.a aVar) {
        boolean z10;
        int i;
        int i3;
        Object obj = this.f13690b;
        p.z zVar = this.f13691c;
        int i10 = this.f13692d;
        this.f13690b = o1Var;
        this.f13691c = (p.z) this.f13694f.g(o1Var);
        if (this.f13692d == -1) {
            this.f13692d = Long.hashCode(m.k().g());
        }
        k0.q qVar = this.i;
        m0.e eVarP = k0.z.p();
        boolean z11 = true;
        try {
            eVarP.b(qVar);
            r.i(eVar, aVar);
            eVarP.k(eVarP.f8160g - 1);
            Object obj2 = this.f13690b;
            obj2.getClass();
            int i11 = this.f13692d;
            p.z zVar2 = this.f13691c;
            if (zVar2 != null) {
                long[] jArr = zVar2.f9650a;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i12 = 0;
                    while (true) {
                        long j10 = jArr[i12];
                        if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i13 = 8;
                            int i14 = 8 - ((~(i12 - length)) >>> 31);
                            z10 = z11;
                            int i15 = 0;
                            while (i15 < i14) {
                                if ((j10 & 255) < 128) {
                                    int i16 = (i12 << 3) + i15;
                                    i3 = i13;
                                    Object obj3 = zVar2.f9651b[i16];
                                    i = i15;
                                    boolean z12 = zVar2.f9652c[i16] != i11 ? z10 : false;
                                    if (z12) {
                                        d(obj2, obj3);
                                    }
                                    if (z12) {
                                        zVar2.g(i16);
                                    }
                                } else {
                                    i = i15;
                                    i3 = i13;
                                }
                                j10 >>= i3;
                                i15 = i + 1;
                                i13 = i3;
                            }
                            if (i14 != i13) {
                                break;
                            }
                        } else {
                            z10 = z11;
                        }
                        if (i12 == length) {
                            break;
                        }
                        i12++;
                        z11 = z10;
                    }
                }
            }
            this.f13690b = obj;
            this.f13691c = zVar;
            this.f13692d = i10;
        } catch (Throwable th) {
            eVarP.k(eVarP.f8160g - 1);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0294 A[PHI: r12
      0x0294: PHI (r12v44 boolean) = (r12v43 boolean), (r12v45 boolean) binds: [B:111:0x026c, B:119:0x0292] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x04c3 A[PHI: r12
      0x04c3: PHI (r12v14 boolean) = (r12v13 boolean), (r12v15 boolean) binds: [B:212:0x049b, B:220:0x04c1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:225:0x04d1  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x04db  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0520 A[EDGE_INSN: B:243:0x0520->B:321:0x0529 BREAK  A[LOOP:18: B:233:0x04ee->B:244:0x0522], PHI: r12
      0x0520: PHI (r12v5 boolean) = (r12v4 boolean), (r12v6 boolean) binds: [B:234:0x04f8, B:242:0x051e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0529 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0221 A[PHI: r12
      0x0221: PHI (r12v54 boolean) = (r12v53 boolean), (r12v55 boolean) binds: [B:87:0x01f9, B:95:0x021f] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(java.util.Set r46) {
        /*
            Method dump skipped, instructions count: 1549
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u0.s.b(java.util.Set):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(java.lang.Object r21, int r22, java.lang.Object r23, p.z r24) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r24
            int r4 = r0.f13697j
            if (r4 <= 0) goto Le
            goto La4
        Le:
            int r4 = r3.c(r1)
            if (r4 >= 0) goto L17
            int r4 = ~r4
            r6 = -1
            goto L1b
        L17:
            int[] r6 = r3.f9652c
            r6 = r6[r4]
        L1b:
            java.lang.Object[] r7 = r3.f9651b
            r7[r4] = r1
            int[] r3 = r3.f9652c
            r3[r4] = r2
            boolean r3 = r1 instanceof k0.i0
            r4 = 2
            if (r3 == 0) goto L90
            if (r6 == r2) goto L90
            r2 = r1
            k0.i0 r2 = (k0.i0) r2
            k0.h0 r2 = r2.h()
            java.util.HashMap r3 = r0.f13699l
            java.lang.Object r7 = r2.f6928f
            r3.put(r1, r7)
            p.z r2 = r2.f6927e
            p.f0 r3 = r0.f13698k
            h5.t.N(r3, r1)
            java.lang.Object[] r7 = r2.f9651b
            long[] r2 = r2.f9650a
            int r8 = r2.length
            int r8 = r8 - r4
            if (r8 < 0) goto L90
            r10 = 0
        L48:
            r11 = r2[r10]
            long r13 = ~r11
            r15 = 7
            long r13 = r13 << r15
            long r13 = r13 & r11
            r15 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r13 = r13 & r15
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 == 0) goto L8b
            int r13 = r10 - r8
            int r13 = ~r13
            int r13 = r13 >>> 31
            r14 = 8
            int r13 = 8 - r13
            r15 = 0
        L62:
            if (r15 >= r13) goto L89
            r16 = 255(0xff, double:1.26E-321)
            long r16 = r11 & r16
            r18 = 128(0x80, double:6.3E-322)
            int r16 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r16 >= 0) goto L85
            int r16 = r10 << 3
            int r16 = r16 + r15
            r16 = r7[r16]
            r9 = r16
            u0.v r9 = (u0.v) r9
            boolean r5 = r9 instanceof u0.w
            if (r5 == 0) goto L82
            r5 = r9
            u0.w r5 = (u0.w) r5
            r5.f(r4)
        L82:
            h5.t.l(r3, r9, r1)
        L85:
            long r11 = r11 >> r14
            int r15 = r15 + 1
            goto L62
        L89:
            if (r13 != r14) goto L90
        L8b:
            if (r10 == r8) goto L90
            int r10 = r10 + 1
            goto L48
        L90:
            r2 = -1
            if (r6 != r2) goto La4
            boolean r2 = r1 instanceof u0.w
            if (r2 == 0) goto L9d
            r2 = r1
            u0.w r2 = (u0.w) r2
            r2.f(r4)
        L9d:
            p.f0 r0 = r0.f13693e
            r2 = r23
            h5.t.l(r0, r1, r2)
        La4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u0.s.c(java.lang.Object, int, java.lang.Object, p.z):void");
    }

    public final void d(Object obj, Object obj2) {
        f0 f0Var = this.f13693e;
        h5.t.M(f0Var, obj2, obj);
        if (!(obj2 instanceof i0) || f0Var.c(obj2)) {
            return;
        }
        h5.t.N(this.f13698k, obj2);
        this.f13699l.remove(obj2);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e() {
        /*
            Method dump skipped, instructions count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u0.s.e():void");
    }
}
