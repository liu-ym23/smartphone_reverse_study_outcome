package l0;

import b0.i0;
import i1.l1;
import java.util.HashMap;
import k.b0;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final p7.k f5787a;

    /* renamed from: b, reason: collision with root package name */
    public Object f5788b;

    /* renamed from: c, reason: collision with root package name */
    public k.y f5789c;

    /* renamed from: j, reason: collision with root package name */
    public int f5796j;

    /* renamed from: d, reason: collision with root package name */
    public int f5790d = -1;

    /* renamed from: e, reason: collision with root package name */
    public final k.a0 f5791e = ib.c.r();

    /* renamed from: f, reason: collision with root package name */
    public final k.a0 f5792f = new k.a0();

    /* renamed from: g, reason: collision with root package name */
    public final b0 f5793g = new b0();

    /* renamed from: h, reason: collision with root package name */
    public final d0.e f5794h = new d0.e(new i0[16]);

    /* renamed from: i, reason: collision with root package name */
    public final b0.n f5795i = new b0.n(1, this);

    /* renamed from: k, reason: collision with root package name */
    public final k.a0 f5797k = ib.c.r();

    /* renamed from: l, reason: collision with root package name */
    public final HashMap f5798l = new HashMap();

    public s(p7.k kVar) {
        this.f5787a = kVar;
    }

    public final void a(l1 l1Var, a5.a aVar, p7.a aVar2) {
        Object obj;
        int i2;
        boolean z4;
        Object obj2;
        int i10;
        int i11;
        int i12;
        Object obj3 = this.f5788b;
        k.y yVar = this.f5789c;
        int i13 = this.f5790d;
        this.f5788b = l1Var;
        this.f5789c = (k.y) this.f5792f.g(l1Var);
        if (this.f5790d == -1) {
            this.f5790d = Long.hashCode(m.k().g());
        }
        b0.n nVar = this.f5795i;
        d0.e eVarI = b0.b.i();
        boolean z10 = true;
        try {
            eVarI.b(nVar);
            r.h(aVar2, aVar);
            eVarI.j(eVarI.f2751h - 1);
            Object obj4 = this.f5788b;
            q7.k.b(obj4);
            int i14 = this.f5790d;
            k.y yVar2 = this.f5789c;
            if (yVar2 != null) {
                long[] jArr = yVar2.f5550a;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i15 = 0;
                    while (true) {
                        long j2 = jArr[i15];
                        if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i16 = 8;
                            int i17 = 8 - ((~(i15 - length)) >>> 31);
                            z4 = z10;
                            int i18 = 0;
                            while (i18 < i17) {
                                if ((j2 & 255) < 128) {
                                    int i19 = (i15 << 3) + i18;
                                    i12 = i16;
                                    Object obj5 = yVar2.f5551b[i19];
                                    i11 = i18;
                                    boolean z11 = yVar2.f5552c[i19] != i14 ? z4 : false;
                                    if (z11) {
                                        i10 = i14;
                                        k.a0 a0Var = this.f5791e;
                                        ib.c.K(a0Var, obj5, obj4);
                                        obj2 = obj4;
                                        if ((obj5 instanceof i0) && !a0Var.c(obj5)) {
                                            ib.c.L(this.f5797k, obj5);
                                            this.f5798l.remove(obj5);
                                        }
                                    } else {
                                        obj2 = obj4;
                                        i10 = i14;
                                    }
                                    if (z11) {
                                        yVar2.g(i19);
                                    }
                                } else {
                                    obj2 = obj4;
                                    i10 = i14;
                                    i11 = i18;
                                    i12 = i16;
                                }
                                j2 >>= i12;
                                i18 = i11 + 1;
                                i16 = i12;
                                i14 = i10;
                                obj4 = obj2;
                            }
                            obj = obj4;
                            i2 = i14;
                            if (i17 != i16) {
                                break;
                            }
                        } else {
                            obj = obj4;
                            i2 = i14;
                            z4 = z10;
                        }
                        if (i15 == length) {
                            break;
                        }
                        i15++;
                        z10 = z4;
                        i14 = i2;
                        obj4 = obj;
                    }
                }
            }
            this.f5788b = obj3;
            this.f5789c = yVar;
            this.f5790d = i13;
        } catch (Throwable th) {
            eVarI.j(eVarI.f2751h - 1);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0278 A[PHI: r12
      0x0278: PHI (r12v46 boolean) = (r12v45 boolean), (r12v47 boolean) binds: [B:103:0x024d, B:111:0x0276] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x03b1 A[PHI: r12
      0x03b1: PHI (r12v28 boolean) = (r12v27 boolean), (r12v29 boolean) binds: [B:159:0x0386, B:167:0x03af] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0473 A[PHI: r12
      0x0473: PHI (r12v15 boolean) = (r12v14 boolean), (r12v16 boolean) binds: [B:193:0x044c, B:201:0x0471] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0481  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x04dc A[EDGE_INSN: B:226:0x04dc->B:306:0x04e5 BREAK  A[LOOP:18: B:216:0x04ab->B:227:0x04de], PHI: r12
      0x04dc: PHI (r12v5 boolean) = (r12v4 boolean), (r12v6 boolean) binds: [B:217:0x04b5, B:225:0x04da] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0130 A[PHI: r31
      0x0130: PHI (r31v13 boolean) = (r31v12 boolean), (r31v14 boolean) binds: [B:44:0x0105, B:53:0x012e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0203 A[PHI: r12
      0x0203: PHI (r12v56 boolean) = (r12v55 boolean), (r12v57 boolean) binds: [B:79:0x01d8, B:87:0x0201] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0213  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(java.util.Set r45) {
        /*
            Method dump skipped, instructions count: 1476
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l0.s.b(java.util.Set):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(java.lang.Object r21, int r22, java.lang.Object r23, k.y r24) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r24
            int r4 = r0.f5796j
            if (r4 <= 0) goto Le
            goto La4
        Le:
            int r4 = r3.c(r1)
            if (r4 >= 0) goto L17
            int r4 = ~r4
            r6 = -1
            goto L1b
        L17:
            int[] r6 = r3.f5552c
            r6 = r6[r4]
        L1b:
            java.lang.Object[] r7 = r3.f5551b
            r7[r4] = r1
            int[] r3 = r3.f5552c
            r3[r4] = r2
            boolean r3 = r1 instanceof b0.i0
            r4 = 2
            if (r3 == 0) goto L90
            if (r6 == r2) goto L90
            r2 = r1
            b0.i0 r2 = (b0.i0) r2
            b0.h0 r2 = r2.g()
            java.util.HashMap r3 = r0.f5798l
            java.lang.Object r7 = r2.f1170f
            r3.put(r1, r7)
            k.y r2 = r2.f1169e
            k.a0 r3 = r0.f5797k
            ib.c.L(r3, r1)
            java.lang.Object[] r7 = r2.f5551b
            long[] r2 = r2.f5550a
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
            l0.v r9 = (l0.v) r9
            boolean r5 = r9 instanceof l0.w
            if (r5 == 0) goto L82
            r5 = r9
            l0.w r5 = (l0.w) r5
            r5.d(r4)
        L82:
            ib.c.g(r3, r9, r1)
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
            boolean r2 = r1 instanceof l0.w
            if (r2 == 0) goto L9d
            r2 = r1
            l0.w r2 = (l0.w) r2
            r2.d(r4)
        L9d:
            k.a0 r0 = r0.f5791e
            r2 = r23
            ib.c.g(r0, r1, r2)
        La4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l0.s.c(java.lang.Object, int, java.lang.Object, k.y):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d() {
        /*
            Method dump skipped, instructions count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l0.s.d():void");
    }
}
