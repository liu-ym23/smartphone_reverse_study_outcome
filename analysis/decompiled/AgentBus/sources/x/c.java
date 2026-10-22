package x;

import i1.h0;
import k.a0;
import o4.d0;

/* loaded from: classes.dex */
public final class c extends p {
    public final a0 D;

    public c(q.i iVar, boolean z4, float f10, d0 d0Var, y.m mVar) {
        super(iVar, z4, f10, d0Var, mVar);
        this.D = new a0();
    }

    @Override // n0.l
    public final void e0() {
        this.D.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0056  */
    @Override // x.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l0(q.k r19, long r20, float r22) {
        /*
            r18 = this;
            r2 = r18
            r3 = r19
            k.a0 r0 = r2.D
            java.lang.Object[] r1 = r0.f5447b
            java.lang.Object[] r4 = r0.f5448c
            long[] r5 = r0.f5446a
            int r6 = r5.length
            int r6 = r6 + (-2)
            if (r6 < 0) goto L5b
            r8 = 0
        L12:
            r9 = r5[r8]
            long r11 = ~r9
            r13 = 7
            long r11 = r11 << r13
            long r11 = r11 & r9
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r11 = r11 & r13
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 == 0) goto L56
            int r11 = r8 - r6
            int r11 = ~r11
            int r11 = r11 >>> 31
            r12 = 8
            int r11 = 8 - r11
            r13 = 0
        L2c:
            if (r13 >= r11) goto L54
            r14 = 255(0xff, double:1.26E-321)
            long r14 = r14 & r9
            r16 = 128(0x80, double:6.3E-322)
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 >= 0) goto L50
            int r14 = r8 << 3
            int r14 = r14 + r13
            r15 = r1[r14]
            r14 = r4[r14]
            x.j r14 = (x.j) r14
            q.k r15 = (q.k) r15
            b0.o1 r15 = r14.f11030k
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            r15.setValue(r7)
            ia.s r7 = r14.f11028i
            c7.r r14 = c7.r.f1986a
            r7.X(r14)
        L50:
            long r9 = r9 >> r12
            int r13 = r13 + 1
            goto L2c
        L54:
            if (r11 != r12) goto L5b
        L56:
            if (r8 == r6) goto L5b
            int r8 = r8 + 1
            goto L12
        L5b:
            r4 = 0
            boolean r1 = r2.f11046u
            if (r1 == 0) goto L68
            long r5 = r3.f8616a
            t0.b r7 = new t0.b
            r7.<init>(r5)
            goto L69
        L68:
            r7 = r4
        L69:
            x.j r5 = new x.j
            r6 = r22
            r5.<init>(r7, r6, r1)
            r0.l(r3, r5)
            ia.b0 r6 = r2.Z()
            b0.f2 r0 = new b0.f2
            r1 = r5
            r5 = 22
            r0.<init>(r1, r2, r3, r4, r5)
            r1 = 3
            ia.d0.s(r6, r4, r4, r0, r1)
            i1.l.l(r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: x.c.l0(q.k, long, float):void");
    }

    @Override // x.p
    public final void m0(h0 h0Var) {
        w0.b bVar;
        Object[] objArr;
        Object[] objArr2;
        int i2;
        int i10;
        w0.b bVar2;
        Object[] objArr3;
        Object[] objArr4;
        int i11;
        c cVar = this;
        w0.b bVar3 = h0Var.f4489f;
        cVar.f11049x.c();
        float f10 = 0.1f;
        if (0.1f == 0.0f) {
            return;
        }
        a0 a0Var = cVar.D;
        Object[] objArr5 = a0Var.f5447b;
        Object[] objArr6 = a0Var.f5448c;
        long[] jArr = a0Var.f5446a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i12 = 0;
        while (true) {
            long j2 = jArr[i12];
            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i13 = 8;
                int i14 = 8 - ((~(i12 - length)) >>> 31);
                long j4 = j2;
                int i15 = 0;
                while (i15 < i14) {
                    if ((j4 & 255) < 128) {
                        int i16 = (i12 << 3) + i15;
                        Object obj = objArr5[i16];
                        j jVar = (j) objArr6[i16];
                        long jB = u0.m.b(f10, cVar.f11048w.L());
                        n.c cVar2 = jVar.f11027h;
                        if (jVar.f11023d == null) {
                            long jD = bVar3.d();
                            float f11 = k.f11031a;
                            jVar.f11023d = Float.valueOf(Math.max(t0.e.d(jD), t0.e.b(jD)) * 0.3f);
                        }
                        if (jVar.f11020a == null) {
                            jVar.f11020a = new t0.b(bVar3.D());
                        }
                        if (jVar.f11024e == null) {
                            jVar.f11024e = new t0.b(n7.b.b(t0.e.d(bVar3.d()) / 2.0f, t0.e.b(bVar3.d()) / 2.0f));
                        }
                        float fFloatValue = (!((Boolean) jVar.f11030k.getValue()).booleanValue() || ((Boolean) jVar.f11029j.getValue()).booleanValue()) ? ((Number) jVar.f11025f.c()).floatValue() : 1.0f;
                        Float f12 = jVar.f11023d;
                        q7.k.b(f12);
                        float fFloatValue2 = f12.floatValue();
                        float f13 = jVar.f11021b;
                        float fFloatValue3 = ((Number) jVar.f11026g.c()).floatValue();
                        float f14 = fFloatValue;
                        float f15 = 1;
                        float f16 = (fFloatValue3 * f13) + ((f15 - fFloatValue3) * fFloatValue2);
                        t0.b bVar4 = jVar.f11020a;
                        q7.k.b(bVar4);
                        float fD = t0.b.d(bVar4.f9654a);
                        t0.b bVar5 = jVar.f11024e;
                        q7.k.b(bVar5);
                        float fD2 = t0.b.d(bVar5.f9654a);
                        float fFloatValue4 = ((Number) cVar2.c()).floatValue();
                        float f17 = (fFloatValue4 * fD2) + ((f15 - fFloatValue4) * fD);
                        t0.b bVar6 = jVar.f11020a;
                        q7.k.b(bVar6);
                        int i17 = i14;
                        float fE = t0.b.e(bVar6.f9654a);
                        t0.b bVar7 = jVar.f11024e;
                        q7.k.b(bVar7);
                        float fE2 = t0.b.e(bVar7.f9654a);
                        float fFloatValue5 = ((Number) cVar2.c()).floatValue();
                        long jB2 = n7.b.b(f17, (fFloatValue5 * fE2) + ((f15 - fFloatValue5) * fE));
                        long jB3 = u0.m.b(u0.m.d(jB) * f14, jB);
                        if (jVar.f11022c) {
                            float fD3 = t0.e.d(bVar3.d());
                            float fB = t0.e.b(bVar3.d());
                            u5.h hVar = bVar3.f10630g;
                            long jB4 = hVar.b();
                            hVar.a().h();
                            ((u5.h) ((d0) hVar.f10129a).f7326g).a().e(0.0f, 0.0f, fD3, fB, 1);
                            i2 = i15;
                            objArr3 = objArr5;
                            objArr4 = objArr6;
                            i10 = i17;
                            bVar2 = bVar3;
                            i11 = 8;
                            w0.d.H(h0Var, jB3, f16, jB2, 120);
                            hVar.a().g();
                            hVar.j(jB4);
                        } else {
                            i2 = i15;
                            objArr3 = objArr5;
                            objArr4 = objArr6;
                            i10 = i17;
                            bVar2 = bVar3;
                            i11 = 8;
                            w0.d.H(h0Var, jB3, f16, jB2, 120);
                        }
                    } else {
                        i2 = i15;
                        i10 = i14;
                        bVar2 = bVar3;
                        objArr3 = objArr5;
                        objArr4 = objArr6;
                        i11 = i13;
                    }
                    j4 >>= i11;
                    i15 = i2 + 1;
                    i14 = i10;
                    i13 = i11;
                    objArr5 = objArr3;
                    objArr6 = objArr4;
                    bVar3 = bVar2;
                    f10 = 0.1f;
                    cVar = this;
                }
                bVar = bVar3;
                objArr = objArr5;
                objArr2 = objArr6;
                if (i14 != i13) {
                    return;
                }
            } else {
                bVar = bVar3;
                objArr = objArr5;
                objArr2 = objArr6;
            }
            if (i12 == length) {
                return;
            }
            i12++;
            cVar = this;
            objArr5 = objArr;
            objArr6 = objArr2;
            bVar3 = bVar;
            f10 = 0.1f;
        }
    }

    @Override // x.p
    public final void o0(q.k kVar) {
        j jVar = (j) this.D.g(kVar);
        if (jVar != null) {
            jVar.f11030k.setValue(Boolean.TRUE);
            jVar.f11028i.X(c7.r.f1986a);
        }
    }
}
