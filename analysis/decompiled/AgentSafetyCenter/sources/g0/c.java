package g0;

import p.f0;
import u1.i0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends q {
    public f0 C;

    /* JADX WARN: Removed duplicated region for block: B:14:0x0056  */
    @Override // g0.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void B0(v.m r19, long r20, float r22) {
        /*
            r18 = this;
            r2 = r18
            r3 = r19
            p.f0 r0 = r2.C
            java.lang.Object[] r1 = r0.f9553b
            java.lang.Object[] r4 = r0.f9554c
            long[] r5 = r0.f9552a
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
            g0.k r14 = (g0.k) r14
            v.m r15 = (v.m) r15
            k0.k1 r15 = r14.f4165k
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            r15.setValue(r7)
            kc.l r7 = r14.i
            jb.v r14 = jb.v.f6774a
            r7.O(r14)
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
            boolean r1 = r2.f4179t
            r4 = 0
            if (r1 == 0) goto L67
            long r5 = r3.f14314a
            c1.b r5 = c1.b.a(r5)
            goto L68
        L67:
            r5 = r4
        L68:
            g0.k r6 = new g0.k
            r6.<init>()
            r6.f4156a = r5
            r5 = r22
            r6.f4157b = r5
            r6.f4158c = r1
            s.c r1 = s.d.a()
            r6.f4161f = r1
            s.c r1 = s.d.a()
            r6.f4162g = r1
            s.c r1 = s.d.a()
            r6.f4163h = r1
            kc.l r1 = new kc.l
            r5 = 1
            r1.<init>(r5)
            r1.K(r4)
            r6.i = r1
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            k0.k1 r5 = k0.z.v(r1)
            r6.f4164j = r5
            k0.k1 r1 = k0.z.v(r1)
            r6.f4165k = r1
            java.lang.invoke.VarHandle.storeStoreFence()
            r0.m(r3, r6)
            kc.t r7 = r2.p0()
            androidx.lifecycle.l0 r0 = new androidx.lifecycle.l0
            r5 = 3
            r1 = r6
            r0.<init>(r1, r2, r3, r4, r5)
            r1 = 3
            kc.w.u(r7, r4, r4, r0, r1)
            u1.f.l(r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g0.c.B0(v.m, long, float):void");
    }

    @Override // g0.q
    public final void C0(i0 i0Var) {
        int i;
        f1.b bVar;
        Object[] objArr;
        Object[] objArr2;
        int i3;
        int i10;
        int i11;
        f1.b bVar2;
        Object[] objArr3;
        Object[] objArr4;
        int i12;
        c cVar = this;
        f1.b bVar3 = i0Var.f13838c;
        cVar.f4182w.invoke();
        float f5 = 0.1f;
        if (0.1f == 0.0f) {
            return;
        }
        f0 f0Var = cVar.C;
        Object[] objArr5 = f0Var.f9553b;
        Object[] objArr6 = f0Var.f9554c;
        long[] jArr = f0Var.f9552a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i13 = 0;
        while (true) {
            long j10 = jArr[i13];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i14 = 8;
                int i15 = 8 - ((~(i13 - length)) >>> 31);
                long j11 = j10;
                int i16 = 0;
                while (i16 < i15) {
                    if ((j11 & 255) < 128) {
                        int i17 = (i13 << 3) + i16;
                        Object obj = objArr5[i17];
                        k kVar = (k) objArr6[i17];
                        long jC = d1.p.c(f5, cVar.f4181v.e());
                        s.c cVar2 = kVar.f4163h;
                        if (kVar.f4159d == null) {
                            long jE = bVar3.e();
                            float f10 = l.f4166a;
                            kVar.f4159d = Float.valueOf(Math.max(c1.e.e(jE), c1.e.c(jE)) * 0.3f);
                        }
                        if (kVar.f4156a == null) {
                            kVar.f4156a = c1.b.a(bVar3.g0());
                        }
                        if (kVar.f4160e == null) {
                            kVar.f4160e = c1.b.a(id.k.d(c1.e.e(bVar3.e()) / 2.0f, c1.e.c(bVar3.e()) / 2.0f));
                        }
                        float fFloatValue = (!((Boolean) kVar.f4165k.getValue()).booleanValue() || ((Boolean) kVar.f4164j.getValue()).booleanValue()) ? ((Number) kVar.f4161f.d()).floatValue() : 1.0f;
                        Float f11 = kVar.f4159d;
                        f11.getClass();
                        float fFloatValue2 = f11.floatValue();
                        float f12 = kVar.f4157b;
                        float fFloatValue3 = ((Number) kVar.f4162g.d()).floatValue();
                        float f13 = 1;
                        float f14 = (fFloatValue3 * f12) + ((f13 - fFloatValue3) * fFloatValue2);
                        c1.b bVar4 = kVar.f4156a;
                        bVar4.getClass();
                        float fE = c1.b.e(bVar4.f2165a);
                        c1.b bVar5 = kVar.f4160e;
                        bVar5.getClass();
                        float fE2 = c1.b.e(bVar5.f2165a);
                        float fFloatValue4 = ((Number) cVar2.d()).floatValue();
                        float f15 = (fFloatValue4 * fE2) + ((f13 - fFloatValue4) * fE);
                        c1.b bVar6 = kVar.f4156a;
                        bVar6.getClass();
                        int i18 = i13;
                        i10 = i16;
                        float f16 = c1.b.f(bVar6.f2165a);
                        c1.b bVar7 = kVar.f4160e;
                        bVar7.getClass();
                        float f17 = c1.b.f(bVar7.f2165a);
                        float fFloatValue5 = ((Number) cVar2.d()).floatValue();
                        long jD = id.k.d(f15, (fFloatValue5 * f17) + ((f13 - fFloatValue5) * f16));
                        long jC2 = d1.p.c(d1.p.e(jC) * fFloatValue, jC);
                        if (kVar.f4158c) {
                            float fE3 = c1.e.e(bVar3.e());
                            float fC = c1.e.c(bVar3.e());
                            p5.m mVar = bVar3.f3859f;
                            long jD2 = mVar.D();
                            mVar.y().i();
                            ((p5.m) ((a1.g) mVar.f9741f).f19f).y().m(0.0f, 0.0f, fE3, fC, 1);
                            i11 = i15;
                            objArr3 = objArr5;
                            objArr4 = objArr6;
                            i3 = i18;
                            bVar2 = bVar3;
                            i12 = 8;
                            f1.d.s(i0Var, jC2, f14, jD, null, 120);
                            mVar.y().o();
                            mVar.R(jD2);
                        } else {
                            i11 = i15;
                            objArr3 = objArr5;
                            objArr4 = objArr6;
                            i3 = i18;
                            bVar2 = bVar3;
                            i12 = 8;
                            f1.d.s(i0Var, jC2, f14, jD, null, 120);
                        }
                    } else {
                        i3 = i13;
                        i10 = i16;
                        i11 = i15;
                        bVar2 = bVar3;
                        objArr3 = objArr5;
                        objArr4 = objArr6;
                        i12 = i14;
                    }
                    j11 >>= i12;
                    i16 = i10 + 1;
                    i15 = i11;
                    i14 = i12;
                    i13 = i3;
                    objArr5 = objArr3;
                    objArr6 = objArr4;
                    bVar3 = bVar2;
                    f5 = 0.1f;
                    cVar = this;
                }
                i = i13;
                bVar = bVar3;
                objArr = objArr5;
                objArr2 = objArr6;
                if (i15 != i14) {
                    return;
                }
            } else {
                i = i13;
                bVar = bVar3;
                objArr = objArr5;
                objArr2 = objArr6;
            }
            if (i == length) {
                return;
            }
            i13 = i + 1;
            cVar = this;
            objArr5 = objArr;
            objArr6 = objArr2;
            bVar3 = bVar;
            f5 = 0.1f;
        }
    }

    @Override // g0.q
    public final void E0(v.m mVar) {
        k kVar = (k) this.C.g(mVar);
        if (kVar != null) {
            kVar.f4165k.setValue(Boolean.TRUE);
            kVar.i.O(jb.v.f6774a);
        }
    }

    @Override // w0.l
    public final void u0() {
        this.C.a();
    }
}
