package p7;

import java.math.BigInteger;
import org.bouncycastle.asn1.BERTags;
import s7.w0;
import s7.z0;

/* loaded from: classes.dex */
public final class p extends r {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f4814g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p(h hVar, m mVar, m mVar2, int i8) {
        super(hVar, mVar, mVar2);
        this.f4814g = i8;
    }

    private final r A(r rVar) {
        m mVarJ;
        m mVarJ2;
        m mVarJ3;
        m mVarJ4;
        m mVar;
        m mVar2;
        if (k()) {
            return rVar;
        }
        if (rVar.k()) {
            return this;
        }
        m mVar3 = rVar.f4818b;
        m mVarJ5 = this.f4818b;
        boolean zI = mVarJ5.i();
        h hVar = this.f4817a;
        if (zI) {
            return mVar3.i() ? hVar.m() : rVar.a(this);
        }
        m mVar4 = this.d[0];
        m mVar5 = rVar.f4819c;
        m mVarI = rVar.i();
        boolean zH = mVar4.h();
        if (zH) {
            mVarJ = mVar3;
            mVarJ2 = mVar5;
        } else {
            mVarJ = mVar3.j(mVar4);
            mVarJ2 = mVar5.j(mVar4);
        }
        boolean zH2 = mVarI.h();
        m mVar6 = this.f4819c;
        if (zH2) {
            mVarJ3 = mVar6;
        } else {
            mVarJ5 = mVarJ5.j(mVarI);
            mVarJ3 = mVar6.j(mVarI);
        }
        m mVarA = mVarJ3.a(mVarJ2);
        m mVarA2 = mVarJ5.a(mVarJ);
        if (mVarA2.i()) {
            return mVarA.i() ? x() : hVar.m();
        }
        if (mVar3.i()) {
            r rVarO = o();
            m mVar7 = rVarO.f4818b;
            m mVarH = rVarO.h();
            m mVarD = mVarH.a(mVar5).d(mVar7);
            m mVarB = mVarD.o().a(mVarD).a(mVar7).b();
            if (mVarB.i()) {
                return new p(hVar, mVarB, hVar.f4799c.n(), 14);
            }
            m mVarA3 = mVarD.j(mVar7.a(mVarB)).a(mVarB).a(mVarH).d(mVarB).a(mVarB);
            mVarJ4 = hVar.j(a.f4758b);
            mVar = mVarA3;
            mVar2 = mVarB;
        } else {
            m mVarO = mVarA2.o();
            m mVarJ6 = mVarA.j(mVarJ5);
            m mVarJ7 = mVarA.j(mVarJ);
            m mVarJ8 = mVarJ6.j(mVarJ7);
            if (mVarJ8.i()) {
                return new p(hVar, mVarJ8, hVar.f4799c.n(), 14);
            }
            m mVarJ9 = mVarA.j(mVarO);
            mVarJ4 = !zH2 ? mVarJ9.j(mVarI) : mVarJ9;
            m mVarP = mVarJ7.a(mVarO).p(mVarJ4, mVar6.a(mVar4));
            if (!zH) {
                mVarJ4 = mVarJ4.j(mVar4);
            }
            mVar = mVarP;
            mVar2 = mVarJ8;
        }
        return new p(hVar, mVar2, mVar, new m[]{mVarJ4}, 14);
    }

    private final r B(r rVar) {
        m mVarJ;
        m mVarJ2;
        m mVarJ3;
        m mVarJ4;
        m mVar;
        m mVar2;
        if (k()) {
            return rVar;
        }
        if (rVar.k()) {
            return this;
        }
        m mVar3 = rVar.f4818b;
        m mVarJ5 = this.f4818b;
        boolean zI = mVarJ5.i();
        h hVar = this.f4817a;
        if (zI) {
            return mVar3.i() ? hVar.m() : rVar.a(this);
        }
        m mVar4 = this.d[0];
        m mVar5 = rVar.f4819c;
        m mVarI = rVar.i();
        boolean zH = mVar4.h();
        if (zH) {
            mVarJ = mVar3;
            mVarJ2 = mVar5;
        } else {
            mVarJ = mVar3.j(mVar4);
            mVarJ2 = mVar5.j(mVar4);
        }
        boolean zH2 = mVarI.h();
        m mVar6 = this.f4819c;
        if (zH2) {
            mVarJ3 = mVar6;
        } else {
            mVarJ5 = mVarJ5.j(mVarI);
            mVarJ3 = mVar6.j(mVarI);
        }
        m mVarA = mVarJ3.a(mVarJ2);
        m mVarA2 = mVarJ5.a(mVarJ);
        if (mVarA2.i()) {
            return mVarA.i() ? x() : hVar.m();
        }
        if (mVar3.i()) {
            r rVarO = o();
            m mVar7 = rVarO.f4818b;
            m mVarH = rVarO.h();
            m mVarD = mVarH.a(mVar5).d(mVar7);
            m mVarJ6 = m0.f.j(mVarD, mVarD, mVar7);
            if (mVarJ6.i()) {
                return new p(hVar, mVarJ6, hVar.f4799c, 15);
            }
            m mVarA3 = mVarD.j(mVar7.a(mVarJ6)).a(mVarJ6).a(mVarH).d(mVarJ6).a(mVarJ6);
            mVarJ4 = hVar.j(a.f4758b);
            mVar = mVarA3;
            mVar2 = mVarJ6;
        } else {
            m mVarO = mVarA2.o();
            m mVarJ7 = mVarA.j(mVarJ5);
            m mVarJ8 = mVarA.j(mVarJ);
            m mVarJ9 = mVarJ7.j(mVarJ8);
            if (mVarJ9.i()) {
                return new p(hVar, mVarJ9, hVar.f4799c, 15);
            }
            m mVarJ10 = mVarA.j(mVarO);
            mVarJ4 = !zH2 ? mVarJ10.j(mVarI) : mVarJ10;
            m mVarP = mVarJ8.a(mVarO).p(mVarJ4, mVar6.a(mVar4));
            if (!zH) {
                mVarJ4 = mVarJ4.j(mVar4);
            }
            mVar = mVarP;
            mVar2 = mVarJ9;
        }
        return new p(hVar, mVar2, mVar, new m[]{mVarJ4}, 15);
    }

    private final r C(r rVar) {
        m mVarJ;
        m mVarJ2;
        m mVarJ3;
        m mVarJ4;
        m mVar;
        m mVar2;
        if (k()) {
            return rVar;
        }
        if (rVar.k()) {
            return this;
        }
        m mVar3 = rVar.f4818b;
        m mVarJ5 = this.f4818b;
        boolean zI = mVarJ5.i();
        h hVar = this.f4817a;
        if (zI) {
            return mVar3.i() ? hVar.m() : rVar.a(this);
        }
        m mVar4 = this.d[0];
        m mVar5 = rVar.f4819c;
        m mVarI = rVar.i();
        boolean zH = mVar4.h();
        if (zH) {
            mVarJ = mVar3;
            mVarJ2 = mVar5;
        } else {
            mVarJ = mVar3.j(mVar4);
            mVarJ2 = mVar5.j(mVar4);
        }
        boolean zH2 = mVarI.h();
        m mVar6 = this.f4819c;
        if (zH2) {
            mVarJ3 = mVar6;
        } else {
            mVarJ5 = mVarJ5.j(mVarI);
            mVarJ3 = mVar6.j(mVarI);
        }
        m mVarA = mVarJ3.a(mVarJ2);
        m mVarA2 = mVarJ5.a(mVarJ);
        if (mVarA2.i()) {
            return mVarA.i() ? x() : hVar.m();
        }
        if (mVar3.i()) {
            r rVarO = o();
            m mVar7 = rVarO.f4818b;
            m mVarH = rVarO.h();
            m mVarD = mVarH.a(mVar5).d(mVar7);
            m mVarB = mVarD.o().a(mVarD).a(mVar7).b();
            if (mVarB.i()) {
                return new p(hVar, mVarB, hVar.f4799c.n(), 16);
            }
            m mVarA3 = mVarD.j(mVar7.a(mVarB)).a(mVarB).a(mVarH).d(mVarB).a(mVarB);
            mVarJ4 = hVar.j(a.f4758b);
            mVar = mVarA3;
            mVar2 = mVarB;
        } else {
            m mVarO = mVarA2.o();
            m mVarJ6 = mVarA.j(mVarJ5);
            m mVarJ7 = mVarA.j(mVarJ);
            m mVarJ8 = mVarJ6.j(mVarJ7);
            if (mVarJ8.i()) {
                return new p(hVar, mVarJ8, hVar.f4799c.n(), 16);
            }
            m mVarJ9 = mVarA.j(mVarO);
            mVarJ4 = !zH2 ? mVarJ9.j(mVarI) : mVarJ9;
            m mVarP = mVarJ7.a(mVarO).p(mVarJ4, mVar6.a(mVar4));
            if (!zH) {
                mVarJ4 = mVarJ4.j(mVar4);
            }
            mVar = mVarP;
            mVar2 = mVarJ8;
        }
        return new p(hVar, mVar2, mVar, new m[]{mVarJ4}, 16);
    }

    private final r D(r rVar) {
        char c3;
        long[] jArr;
        long[] jArr2;
        long[] jArr3;
        w0 w0Var;
        w0 w0Var2;
        w0 w0Var3;
        if (k()) {
            return rVar;
        }
        if (rVar.k()) {
            return this;
        }
        w0 w0Var4 = (w0) this.f4818b;
        w0 w0Var5 = (w0) rVar.f4818b;
        long[] jArr4 = w0Var4.f5372g;
        boolean Z = x.e.Z(jArr4);
        h hVar = this.f4817a;
        if (Z) {
            return x.e.Z(w0Var5.f5372g) ? hVar.m() : rVar.a(this);
        }
        w0 w0Var6 = (w0) this.f4819c;
        w0 w0Var7 = (w0) this.d[0];
        w0 w0Var8 = (w0) rVar.f4819c;
        w0 w0Var9 = (w0) rVar.i();
        long[] jArr5 = new long[9];
        long[] jArr6 = new long[9];
        long[] jArr7 = new long[9];
        long[] jArr8 = new long[9];
        boolean zH = w0Var7.h();
        long[] jArr9 = w0Var7.f5372g;
        long[] jArrV0 = zH ? null : s7.b.v0(jArr9);
        if (jArrV0 == null) {
            jArr2 = w0Var5.f5372g;
            c3 = 0;
            jArr = w0Var8.f5372g;
        } else {
            c3 = 0;
            s7.b.u0(w0Var5.f5372g, jArrV0, jArr6);
            s7.b.u0(w0Var8.f5372g, jArrV0, jArr8);
            jArr = jArr8;
            jArr2 = jArr6;
        }
        long[] jArrV02 = w0Var9.h() ? null : s7.b.v0(w0Var9.f5372g);
        if (jArrV02 == null) {
            jArr3 = w0Var6.f5372g;
        } else {
            s7.b.u0(jArr4, jArrV02, jArr5);
            s7.b.u0(w0Var6.f5372g, jArrV02, jArr7);
            jArr4 = jArr5;
            jArr3 = jArr7;
        }
        s7.b.b(jArr3, jArr, jArr7);
        s7.b.b(jArr4, jArr2, jArr8);
        if (x.e.Z(jArr8)) {
            return x.e.Z(jArr7) ? x() : hVar.m();
        }
        boolean Z2 = x.e.Z(w0Var5.f5372g);
        int i8 = 17;
        if (Z2) {
            r rVarO = o();
            w0 w0Var10 = (w0) rVarO.f4818b;
            m mVarH = rVarO.h();
            m mVarD = mVarH.a(w0Var8).d(w0Var10);
            w0 w0Var11 = (w0) mVarD.o().a(mVarD).a(w0Var10);
            if (x.e.Z(w0Var11.f5372g)) {
                return new p(hVar, w0Var11, hVar.f4799c, i8);
            }
            w0Var = (w0) mVarD.j(w0Var10.a(w0Var11)).a(w0Var11).a(mVarH).d(w0Var11).a(w0Var11);
            w0Var3 = (w0) hVar.j(a.f4758b);
            w0Var2 = w0Var11;
        } else {
            s7.b.e1(jArr8, jArr8);
            long[] jArrV03 = s7.b.v0(jArr7);
            s7.b.u0(jArr4, jArrV03, jArr5);
            s7.b.u0(jArr2, jArrV03, jArr6);
            w0 w0Var12 = new w0(jArr5);
            s7.b.j0(jArr5, jArr6, jArr5);
            if (x.e.Z(jArr5)) {
                return new p(hVar, w0Var12, hVar.f4799c, i8);
            }
            w0 w0Var13 = new w0(jArr7);
            s7.b.u0(jArr8, jArrV03, jArr7);
            if (jArrV02 != null) {
                s7.b.u0(jArr7, jArrV02, jArr7);
            }
            long[] jArr10 = new long[18];
            s7.b.b(jArr6, jArr8, jArr8);
            long[] jArr11 = new long[18];
            s7.b.V(jArr8, jArr11);
            s7.b.j(jArr10, jArr11, jArr10);
            s7.b.b(w0Var6.f5372g, jArr9, jArr8);
            s7.b.t0(jArr8, jArr7, jArr10);
            w0Var = new w0(jArr8);
            s7.b.E0(jArr10, jArr8);
            if (jArrV0 != null) {
                s7.b.u0(jArr7, jArrV0, jArr7);
            }
            w0Var2 = w0Var12;
            w0Var3 = w0Var13;
        }
        w0 w0Var14 = w0Var;
        m[] mVarArr = new m[1];
        mVarArr[c3] = w0Var3;
        return new p(hVar, w0Var2, w0Var14, mVarArr, 17);
    }

    private final r z(r rVar) {
        m mVarJ;
        m mVarJ2;
        m mVarJ3;
        m mVarJ4;
        m mVar;
        m mVar2;
        if (k()) {
            return rVar;
        }
        if (rVar.k()) {
            return this;
        }
        m mVar3 = rVar.f4818b;
        m mVarJ5 = this.f4818b;
        boolean zI = mVarJ5.i();
        h hVar = this.f4817a;
        if (zI) {
            return mVar3.i() ? hVar.m() : rVar.a(this);
        }
        m mVar4 = this.d[0];
        m mVar5 = rVar.f4819c;
        m mVarI = rVar.i();
        boolean zH = mVar4.h();
        if (zH) {
            mVarJ = mVar3;
            mVarJ2 = mVar5;
        } else {
            mVarJ = mVar3.j(mVar4);
            mVarJ2 = mVar5.j(mVar4);
        }
        boolean zH2 = mVarI.h();
        m mVar6 = this.f4819c;
        if (zH2) {
            mVarJ3 = mVar6;
        } else {
            mVarJ5 = mVarJ5.j(mVarI);
            mVarJ3 = mVar6.j(mVarI);
        }
        m mVarA = mVarJ3.a(mVarJ2);
        m mVarA2 = mVarJ5.a(mVarJ);
        if (mVarA2.i()) {
            return mVarA.i() ? x() : hVar.m();
        }
        if (mVar3.i()) {
            r rVarO = o();
            m mVar7 = rVarO.f4818b;
            m mVarH = rVarO.h();
            m mVarD = mVarH.a(mVar5).d(mVar7);
            m mVarJ6 = m0.f.j(mVarD, mVarD, mVar7);
            if (mVarJ6.i()) {
                return new p(hVar, mVarJ6, hVar.f4799c, 13);
            }
            m mVarA3 = mVarD.j(mVar7.a(mVarJ6)).a(mVarJ6).a(mVarH).d(mVarJ6).a(mVarJ6);
            mVarJ4 = hVar.j(a.f4758b);
            mVar = mVarA3;
            mVar2 = mVarJ6;
        } else {
            m mVarO = mVarA2.o();
            m mVarJ7 = mVarA.j(mVarJ5);
            m mVarJ8 = mVarA.j(mVarJ);
            m mVarJ9 = mVarJ7.j(mVarJ8);
            if (mVarJ9.i()) {
                return new p(hVar, mVarJ9, hVar.f4799c, 13);
            }
            m mVarJ10 = mVarA.j(mVarO);
            mVarJ4 = !zH2 ? mVarJ10.j(mVarI) : mVarJ10;
            m mVarP = mVarJ8.a(mVarO).p(mVarJ4, mVar6.a(mVar4));
            if (!zH) {
                mVarJ4 = mVarJ4.j(mVar4);
            }
            mVar = mVarP;
            mVar2 = mVarJ9;
        }
        return new p(hVar, mVar2, mVar, new m[]{mVarJ4}, 13);
    }

    public final p E(int i8) {
        r rVarE;
        if (k()) {
            return this;
        }
        h hVar = this.f4817a;
        int i9 = hVar.f4801f;
        m mVar = this.f4819c;
        m mVar2 = this.f4818b;
        if (i9 == 0) {
            rVarE = hVar.e(mVar2.q(i8), mVar.q(i8));
        } else {
            if (i9 != 1) {
                if (i9 != 5) {
                    if (i9 != 6) {
                        throw new IllegalStateException("unsupported coordinate system");
                    }
                }
                rVarE = hVar.e(mVar2.q(i8), mVar.q(i8));
            }
            rVarE = hVar.f(mVar2.q(i8), mVar.q(i8), new m[]{this.d[0].q(i8)});
        }
        return (p) rVarE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:620:0x0f19, code lost:
    
        if (r6.i() != false) goto L621;
     */
    /* JADX WARN: Code restructure failed: missing block: B:655:0x1008, code lost:
    
        if (r4.i() != false) goto L621;
     */
    /* JADX WARN: Code restructure failed: missing block: B:669:0x1064, code lost:
    
        if (r2.i() != false) goto L621;
     */
    /* JADX WARN: Code restructure failed: missing block: B:767:?, code lost:
    
        return x();
     */
    @Override // p7.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final p7.r a(p7.r r19) {
        /*
            Method dump skipped, instructions count: 4278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p7.p.a(p7.r):p7.r");
    }

    @Override // p7.r
    public final boolean e() {
        switch (this.f4814g) {
            case 0:
                m mVar = this.f4818b;
                if (!mVar.i()) {
                    int iF = f();
                    m mVar2 = this.f4819c;
                    if (iF != 5 && iF != 6) {
                        break;
                    } else if (mVar2.s() != mVar.s()) {
                    }
                }
                break;
            case 1:
                m mVar3 = this.f4818b;
                if (!mVar3.i() && this.f4819c.s() != mVar3.s()) {
                }
                break;
            case 2:
                m mVar4 = this.f4818b;
                if (!mVar4.i() && this.f4819c.s() != mVar4.s()) {
                }
                break;
            case 3:
                m mVar5 = this.f4818b;
                if (!mVar5.i() && this.f4819c.s() != mVar5.s()) {
                }
                break;
            case 4:
                m mVar6 = this.f4818b;
                if (!mVar6.i() && this.f4819c.s() != mVar6.s()) {
                }
                break;
            case 5:
                m mVar7 = this.f4818b;
                if (!mVar7.i() && this.f4819c.s() != mVar7.s()) {
                }
                break;
            case 6:
                m mVar8 = this.f4818b;
                if (!mVar8.i() && this.f4819c.s() != mVar8.s()) {
                }
                break;
            case 7:
                m mVar9 = this.f4818b;
                if (!mVar9.i() && this.f4819c.s() != mVar9.s()) {
                }
                break;
            case 8:
                m mVar10 = this.f4818b;
                if (!mVar10.i() && this.f4819c.s() != mVar10.s()) {
                }
                break;
            case 9:
                m mVar11 = this.f4818b;
                if (!mVar11.i() && this.f4819c.s() != mVar11.s()) {
                }
                break;
            case 10:
                m mVar12 = this.f4818b;
                if (!mVar12.i() && this.f4819c.s() != mVar12.s()) {
                }
                break;
            case BERTags.EMBEDDED_PDV /* 11 */:
                m mVar13 = this.f4818b;
                if (!mVar13.i() && this.f4819c.s() != mVar13.s()) {
                }
                break;
            case 12:
                m mVar14 = this.f4818b;
                if (!mVar14.i() && this.f4819c.s() != mVar14.s()) {
                }
                break;
            case BERTags.RELATIVE_OID /* 13 */:
                m mVar15 = this.f4818b;
                if (!mVar15.i() && this.f4819c.s() != mVar15.s()) {
                }
                break;
            case BERTags.TIME /* 14 */:
                m mVar16 = this.f4818b;
                if (!mVar16.i() && this.f4819c.s() != mVar16.s()) {
                }
                break;
            case 15:
                m mVar17 = this.f4818b;
                if (!mVar17.i() && this.f4819c.s() != mVar17.s()) {
                }
                break;
            case 16:
                m mVar18 = this.f4818b;
                if (!mVar18.i() && this.f4819c.s() != mVar18.s()) {
                }
                break;
            case 17:
                m mVar19 = this.f4818b;
                if (!mVar19.i() && this.f4819c.s() != mVar19.s()) {
                }
                break;
            default:
                m mVar20 = this.f4818b;
                if (!mVar20.i() && this.f4819c.s() != mVar20.s()) {
                }
                break;
        }
        return false;
    }

    @Override // p7.r
    public final m h() {
        switch (this.f4814g) {
            case 0:
                int iF = f();
                m mVar = this.f4819c;
                if ((iF != 5 && iF != 6) || k()) {
                    return mVar;
                }
                m mVar2 = this.f4818b;
                if (mVar2.i()) {
                    return mVar;
                }
                m mVarJ = mVar.a(mVar2).j(mVar2);
                if (6 != iF) {
                    return mVarJ;
                }
                m mVar3 = this.d[0];
                return !mVar3.h() ? mVarJ.d(mVar3) : mVarJ;
            case 1:
                boolean zK = k();
                m mVar4 = this.f4819c;
                if (zK) {
                    return mVar4;
                }
                m mVar5 = this.f4818b;
                if (mVar5.i()) {
                    return mVar4;
                }
                m mVarJ2 = mVar4.a(mVar5).j(mVar5);
                m mVar6 = this.d[0];
                return !mVar6.h() ? mVarJ2.d(mVar6) : mVarJ2;
            case 2:
                boolean zK2 = k();
                m mVar7 = this.f4819c;
                if (zK2) {
                    return mVar7;
                }
                m mVar8 = this.f4818b;
                if (mVar8.i()) {
                    return mVar7;
                }
                m mVarJ3 = mVar7.a(mVar8).j(mVar8);
                m mVar9 = this.d[0];
                return !mVar9.h() ? mVarJ3.d(mVar9) : mVarJ3;
            case 3:
                boolean zK3 = k();
                m mVar10 = this.f4819c;
                if (zK3) {
                    return mVar10;
                }
                m mVar11 = this.f4818b;
                if (mVar11.i()) {
                    return mVar10;
                }
                m mVarJ4 = mVar10.a(mVar11).j(mVar11);
                m mVar12 = this.d[0];
                return !mVar12.h() ? mVarJ4.d(mVar12) : mVarJ4;
            case 4:
                boolean zK4 = k();
                m mVar13 = this.f4819c;
                if (zK4) {
                    return mVar13;
                }
                m mVar14 = this.f4818b;
                if (mVar14.i()) {
                    return mVar13;
                }
                m mVarJ5 = mVar13.a(mVar14).j(mVar14);
                m mVar15 = this.d[0];
                return !mVar15.h() ? mVarJ5.d(mVar15) : mVarJ5;
            case 5:
                boolean zK5 = k();
                m mVar16 = this.f4819c;
                if (zK5) {
                    return mVar16;
                }
                m mVar17 = this.f4818b;
                if (mVar17.i()) {
                    return mVar16;
                }
                m mVarJ6 = mVar16.a(mVar17).j(mVar17);
                m mVar18 = this.d[0];
                return !mVar18.h() ? mVarJ6.d(mVar18) : mVarJ6;
            case 6:
                boolean zK6 = k();
                m mVar19 = this.f4819c;
                if (zK6) {
                    return mVar19;
                }
                m mVar20 = this.f4818b;
                if (mVar20.i()) {
                    return mVar19;
                }
                m mVarJ7 = mVar19.a(mVar20).j(mVar20);
                m mVar21 = this.d[0];
                return !mVar21.h() ? mVarJ7.d(mVar21) : mVarJ7;
            case 7:
                boolean zK7 = k();
                m mVar22 = this.f4819c;
                if (zK7) {
                    return mVar22;
                }
                m mVar23 = this.f4818b;
                if (mVar23.i()) {
                    return mVar22;
                }
                m mVarJ8 = mVar22.a(mVar23).j(mVar23);
                m mVar24 = this.d[0];
                return !mVar24.h() ? mVarJ8.d(mVar24) : mVarJ8;
            case 8:
                boolean zK8 = k();
                m mVar25 = this.f4819c;
                if (zK8) {
                    return mVar25;
                }
                m mVar26 = this.f4818b;
                if (mVar26.i()) {
                    return mVar25;
                }
                m mVarJ9 = mVar25.a(mVar26).j(mVar26);
                m mVar27 = this.d[0];
                return !mVar27.h() ? mVarJ9.d(mVar27) : mVarJ9;
            case 9:
                boolean zK9 = k();
                m mVar28 = this.f4819c;
                if (zK9) {
                    return mVar28;
                }
                m mVar29 = this.f4818b;
                if (mVar29.i()) {
                    return mVar28;
                }
                m mVarJ10 = mVar28.a(mVar29).j(mVar29);
                m mVar30 = this.d[0];
                return !mVar30.h() ? mVarJ10.d(mVar30) : mVarJ10;
            case 10:
                boolean zK10 = k();
                m mVar31 = this.f4819c;
                if (zK10) {
                    return mVar31;
                }
                m mVar32 = this.f4818b;
                if (mVar32.i()) {
                    return mVar31;
                }
                m mVarJ11 = mVar31.a(mVar32).j(mVar32);
                m mVar33 = this.d[0];
                return !mVar33.h() ? mVarJ11.d(mVar33) : mVarJ11;
            case BERTags.EMBEDDED_PDV /* 11 */:
                boolean zK11 = k();
                m mVar34 = this.f4819c;
                if (zK11) {
                    return mVar34;
                }
                m mVar35 = this.f4818b;
                if (mVar35.i()) {
                    return mVar34;
                }
                m mVarJ12 = mVar34.a(mVar35).j(mVar35);
                m mVar36 = this.d[0];
                return !mVar36.h() ? mVarJ12.d(mVar36) : mVarJ12;
            case 12:
                boolean zK12 = k();
                m mVar37 = this.f4819c;
                if (zK12) {
                    return mVar37;
                }
                m mVar38 = this.f4818b;
                if (mVar38.i()) {
                    return mVar37;
                }
                m mVarJ13 = mVar37.a(mVar38).j(mVar38);
                m mVar39 = this.d[0];
                return !mVar39.h() ? mVarJ13.d(mVar39) : mVarJ13;
            case BERTags.RELATIVE_OID /* 13 */:
                boolean zK13 = k();
                m mVar40 = this.f4819c;
                if (zK13) {
                    return mVar40;
                }
                m mVar41 = this.f4818b;
                if (mVar41.i()) {
                    return mVar40;
                }
                m mVarJ14 = mVar40.a(mVar41).j(mVar41);
                m mVar42 = this.d[0];
                return !mVar42.h() ? mVarJ14.d(mVar42) : mVarJ14;
            case BERTags.TIME /* 14 */:
                boolean zK14 = k();
                m mVar43 = this.f4819c;
                if (zK14) {
                    return mVar43;
                }
                m mVar44 = this.f4818b;
                if (mVar44.i()) {
                    return mVar43;
                }
                m mVarJ15 = mVar43.a(mVar44).j(mVar44);
                m mVar45 = this.d[0];
                return !mVar45.h() ? mVarJ15.d(mVar45) : mVarJ15;
            case 15:
                boolean zK15 = k();
                m mVar46 = this.f4819c;
                if (zK15) {
                    return mVar46;
                }
                m mVar47 = this.f4818b;
                if (mVar47.i()) {
                    return mVar46;
                }
                m mVarJ16 = mVar46.a(mVar47).j(mVar47);
                m mVar48 = this.d[0];
                return !mVar48.h() ? mVarJ16.d(mVar48) : mVarJ16;
            case 16:
                boolean zK16 = k();
                m mVar49 = this.f4819c;
                if (zK16) {
                    return mVar49;
                }
                m mVar50 = this.f4818b;
                if (mVar50.i()) {
                    return mVar49;
                }
                m mVarJ17 = mVar49.a(mVar50).j(mVar50);
                m mVar51 = this.d[0];
                return !mVar51.h() ? mVarJ17.d(mVar51) : mVarJ17;
            case 17:
                boolean zK17 = k();
                m mVar52 = this.f4819c;
                if (zK17) {
                    return mVar52;
                }
                m mVar53 = this.f4818b;
                if (mVar53.i()) {
                    return mVar52;
                }
                m mVarJ18 = mVar52.a(mVar53).j(mVar53);
                m mVar54 = this.d[0];
                return !mVar54.h() ? mVarJ18.d(mVar54) : mVarJ18;
            default:
                boolean zK18 = k();
                m mVar55 = this.f4819c;
                if (zK18) {
                    return mVar55;
                }
                m mVar56 = this.f4818b;
                if (mVar56.i()) {
                    return mVar55;
                }
                m mVarJ19 = mVar55.a(mVar56).j(mVar56);
                m mVar57 = this.d[0];
                return !mVar57.h() ? mVarJ19.d(mVar57) : mVarJ19;
        }
    }

    @Override // p7.r
    public final r n() {
        p pVar;
        switch (this.f4814g) {
            case 0:
                if (k()) {
                    return this;
                }
                m mVar = this.f4818b;
                if (mVar.i()) {
                    return this;
                }
                int iF = f();
                h hVar = this.f4817a;
                m mVar2 = this.f4819c;
                if (iF == 0) {
                    return new p(hVar, mVar, mVar2.a(mVar), 0);
                }
                m[] mVarArr = this.d;
                if (iF == 1) {
                    pVar = new p(hVar, mVar, mVar2.a(mVar), new m[]{mVarArr[0]}, 0);
                } else {
                    if (iF == 5) {
                        return new p(hVar, mVar, mVar2.b(), 0);
                    }
                    if (iF != 6) {
                        throw new IllegalStateException("unsupported coordinate system");
                    }
                    m mVar3 = mVarArr[0];
                    pVar = new p(hVar, mVar, mVar2.a(mVar3), new m[]{mVar3}, 0);
                }
                return pVar;
            case 1:
                if (k()) {
                    return this;
                }
                m mVar4 = this.f4818b;
                if (mVar4.i()) {
                    return this;
                }
                m mVar5 = this.d[0];
                return new p(this.f4817a, mVar4, this.f4819c.a(mVar5), new m[]{mVar5}, 1);
            case 2:
                if (k()) {
                    return this;
                }
                m mVar6 = this.f4818b;
                if (mVar6.i()) {
                    return this;
                }
                m mVar7 = this.d[0];
                return new p(this.f4817a, mVar6, this.f4819c.a(mVar7), new m[]{mVar7}, 2);
            case 3:
                if (k()) {
                    return this;
                }
                m mVar8 = this.f4818b;
                if (mVar8.i()) {
                    return this;
                }
                m mVar9 = this.d[0];
                return new p(this.f4817a, mVar8, this.f4819c.a(mVar9), new m[]{mVar9}, 3);
            case 4:
                if (k()) {
                    return this;
                }
                m mVar10 = this.f4818b;
                if (mVar10.i()) {
                    return this;
                }
                m mVar11 = this.d[0];
                return new p(this.f4817a, mVar10, this.f4819c.a(mVar11), new m[]{mVar11}, 4);
            case 5:
                if (k()) {
                    return this;
                }
                m mVar12 = this.f4818b;
                if (mVar12.i()) {
                    return this;
                }
                m mVar13 = this.d[0];
                return new p(this.f4817a, mVar12, this.f4819c.a(mVar13), new m[]{mVar13}, 5);
            case 6:
                if (k()) {
                    return this;
                }
                m mVar14 = this.f4818b;
                if (mVar14.i()) {
                    return this;
                }
                m mVar15 = this.d[0];
                return new p(this.f4817a, mVar14, this.f4819c.a(mVar15), new m[]{mVar15}, 6);
            case 7:
                if (k()) {
                    return this;
                }
                m mVar16 = this.f4818b;
                if (mVar16.i()) {
                    return this;
                }
                m mVar17 = this.d[0];
                return new p(this.f4817a, mVar16, this.f4819c.a(mVar17), new m[]{mVar17}, 7);
            case 8:
                if (k()) {
                    return this;
                }
                m mVar18 = this.f4818b;
                if (mVar18.i()) {
                    return this;
                }
                m mVar19 = this.d[0];
                return new p(this.f4817a, mVar18, this.f4819c.a(mVar19), new m[]{mVar19}, 8);
            case 9:
                if (k()) {
                    return this;
                }
                m mVar20 = this.f4818b;
                if (mVar20.i()) {
                    return this;
                }
                m mVar21 = this.d[0];
                return new p(this.f4817a, mVar20, this.f4819c.a(mVar21), new m[]{mVar21}, 9);
            case 10:
                if (k()) {
                    return this;
                }
                m mVar22 = this.f4818b;
                if (mVar22.i()) {
                    return this;
                }
                m mVar23 = this.d[0];
                return new p(this.f4817a, mVar22, this.f4819c.a(mVar23), new m[]{mVar23}, 10);
            case BERTags.EMBEDDED_PDV /* 11 */:
                if (k()) {
                    return this;
                }
                m mVar24 = this.f4818b;
                if (mVar24.i()) {
                    return this;
                }
                m mVar25 = this.d[0];
                return new p(this.f4817a, mVar24, this.f4819c.a(mVar25), new m[]{mVar25}, 11);
            case 12:
                if (k()) {
                    return this;
                }
                m mVar26 = this.f4818b;
                if (mVar26.i()) {
                    return this;
                }
                m mVar27 = this.d[0];
                return new p(this.f4817a, mVar26, this.f4819c.a(mVar27), new m[]{mVar27}, 12);
            case BERTags.RELATIVE_OID /* 13 */:
                if (k()) {
                    return this;
                }
                m mVar28 = this.f4818b;
                if (mVar28.i()) {
                    return this;
                }
                m mVar29 = this.d[0];
                return new p(this.f4817a, mVar28, this.f4819c.a(mVar29), new m[]{mVar29}, 13);
            case BERTags.TIME /* 14 */:
                if (k()) {
                    return this;
                }
                m mVar30 = this.f4818b;
                if (mVar30.i()) {
                    return this;
                }
                m mVar31 = this.d[0];
                return new p(this.f4817a, mVar30, this.f4819c.a(mVar31), new m[]{mVar31}, 14);
            case 15:
                if (k()) {
                    return this;
                }
                m mVar32 = this.f4818b;
                if (mVar32.i()) {
                    return this;
                }
                m mVar33 = this.d[0];
                return new p(this.f4817a, mVar32, this.f4819c.a(mVar33), new m[]{mVar33}, 15);
            case 16:
                if (k()) {
                    return this;
                }
                m mVar34 = this.f4818b;
                if (mVar34.i()) {
                    return this;
                }
                m mVar35 = this.d[0];
                return new p(this.f4817a, mVar34, this.f4819c.a(mVar35), new m[]{mVar35}, 16);
            case 17:
                if (k()) {
                    return this;
                }
                m mVar36 = this.f4818b;
                if (mVar36.i()) {
                    return this;
                }
                m mVar37 = this.d[0];
                return new p(this.f4817a, mVar36, this.f4819c.a(mVar37), new m[]{mVar37}, 17);
            default:
                if (k()) {
                    return this;
                }
                m mVar38 = this.f4818b;
                if (mVar38.i()) {
                    return this;
                }
                m mVar39 = this.d[0];
                return new p(this.f4817a, mVar38, this.f4819c.a(mVar39), new m[]{mVar39}, 18);
        }
    }

    @Override // p7.r
    public final boolean q() {
        m mVarL;
        m mVarP;
        h hVar = this.f4817a;
        m mVarJ = hVar.f4798b;
        m mVarJ2 = hVar.f4799c;
        int i8 = hVar.f4801f;
        m[] mVarArr = this.d;
        m mVar = this.f4819c;
        m mVar2 = this.f4818b;
        if (i8 != 6) {
            m mVarJ3 = mVar.a(mVar2).j(mVar);
            if (i8 != 0) {
                if (i8 != 1) {
                    throw new IllegalStateException("unsupported coordinate system");
                }
                m mVar3 = mVarArr[0];
                if (!mVar3.h()) {
                    m mVarJ4 = mVar3.j(mVar3.o());
                    mVarJ3 = mVarJ3.j(mVar3);
                    mVarJ = mVarJ.j(mVar3);
                    mVarJ2 = mVarJ2.j(mVarJ4);
                }
            }
            return mVarJ3.equals(mVar2.a(mVarJ).j(mVar2.o()).a(mVarJ2));
        }
        m mVar4 = mVarArr[0];
        boolean zH = mVar4.h();
        if (mVar2.i()) {
            m mVarO = mVar.o();
            if (!zH) {
                mVarJ2 = mVarJ2.j(mVar4.o());
            }
            return mVarO.equals(mVarJ2);
        }
        m mVarO2 = mVar2.o();
        if (zH) {
            mVarL = m0.f.j(mVar, mVar, mVarJ);
            mVarP = mVarO2.o().a(mVarJ2);
        } else {
            m mVarO3 = mVar4.o();
            m mVarO4 = mVarO3.o();
            mVarL = mVar.a(mVar4).l(mVar, mVarJ, mVarO3);
            mVarP = mVarO2.p(mVarJ2, mVarO4);
        }
        return mVarL.j(mVarO2).equals(mVarP);
    }

    @Override // p7.r
    public final boolean r() {
        h hVar = this.f4817a;
        BigInteger bigInteger = hVar.f4800e;
        if (a.f4759c.equals(bigInteger)) {
            r rVarO = o();
            rVarO.b();
            return ((i) rVarO.f4818b).w() != 0;
        }
        if (!a.f4760e.equals(bigInteger)) {
            return super.r();
        }
        r rVarO2 = o();
        rVarO2.b();
        m mVar = rVarO2.f4818b;
        m mVarV = ((c) hVar).v(mVar.a(hVar.f4798b));
        if (mVarV == null) {
            return false;
        }
        return ((i) mVar.j(mVarV).a(rVarO2.d())).w() == 0;
    }

    @Override // p7.r
    public final r s(m mVar) {
        if (k()) {
            return this;
        }
        int iF = f();
        h hVar = this.f4817a;
        m[] mVarArr = this.d;
        m mVar2 = this.f4819c;
        m mVar3 = this.f4818b;
        if (iF == 5) {
            return hVar.f(mVar3, mVar2.a(mVar3).d(mVar).a(mVar3.j(mVar)), mVarArr);
        }
        if (iF != 6) {
            return super.s(mVar);
        }
        m mVar4 = mVarArr[0];
        m mVarJ = mVar3.j(mVar.o());
        return hVar.f(mVarJ, mVar2.a(mVar3).a(mVarJ), new m[]{mVar4.j(mVar)});
    }

    @Override // p7.r
    public final r t(m mVar) {
        if (k()) {
            return this;
        }
        int iF = f();
        if (iF != 5 && iF != 6) {
            return super.t(mVar);
        }
        m mVar2 = this.f4819c;
        m mVar3 = this.f4818b;
        return this.f4817a.f(mVar3, mVar2.a(mVar3).j(mVar).a(mVar3), this.d);
    }

    @Override // p7.r
    public final r u(r rVar) {
        return rVar.k() ? this : a(rVar.n());
    }

    @Override // p7.r
    public final r x() {
        p pVar;
        m mVarA;
        int i8 = this.f4814g;
        int i9 = 6;
        int i10 = 9;
        int i11 = 1;
        m[] mVarArr = this.d;
        m mVarJ = this.f4819c;
        m mVarJ2 = this.f4818b;
        int i12 = 0;
        switch (i8) {
            case 0:
                if (k()) {
                    return this;
                }
                boolean zI = mVarJ2.i();
                h hVar = this.f4817a;
                if (zI) {
                    return hVar.m();
                }
                int i13 = hVar.f4801f;
                if (i13 == 0) {
                    m mVarA2 = mVarJ.d(mVarJ2).a(mVarJ2);
                    m mVarA3 = mVarA2.o().a(mVarA2).a(hVar.f4798b);
                    return new p(hVar, mVarA3, mVarJ2.p(mVarA3, mVarA2.b()), i12);
                }
                if (i13 == 1) {
                    m mVar = mVarArr[0];
                    boolean zH = mVar.h();
                    m mVarJ3 = zH ? mVarJ2 : mVarJ2.j(mVar);
                    if (!zH) {
                        mVarJ = mVarJ.j(mVar);
                    }
                    m mVarO = mVarJ2.o();
                    m mVarA4 = mVarO.a(mVarJ);
                    m mVarO2 = mVarJ3.o();
                    m mVarA5 = mVarA4.a(mVarJ3);
                    m mVarL = mVarA5.l(mVarA4, mVarO2, hVar.f4798b);
                    pVar = new p(hVar, mVarJ3.j(mVarL), mVarO.o().l(mVarJ3, mVarL, mVarA5), new m[]{mVarJ3.j(mVarO2)}, 0);
                } else {
                    if (i13 != 6) {
                        throw new IllegalStateException("unsupported coordinate system");
                    }
                    m mVar2 = mVarArr[0];
                    boolean zH2 = mVar2.h();
                    m mVarJ4 = zH2 ? mVarJ : mVarJ.j(mVar2);
                    m mVarO3 = zH2 ? mVar2 : mVar2.o();
                    m mVar3 = hVar.f4798b;
                    m mVarJ5 = zH2 ? mVar3 : mVar3.j(mVarO3);
                    m mVarJ6 = m0.f.j(mVarJ, mVarJ4, mVarJ5);
                    if (mVarJ6.i()) {
                        return new p(hVar, mVarJ6, hVar.f4799c.n(), i12);
                    }
                    m mVarO4 = mVarJ6.o();
                    m mVarJ7 = zH2 ? mVarJ6 : mVarJ6.j(mVarO3);
                    m mVar4 = hVar.f4799c;
                    if (mVar4.c() < (hVar.l() >> 1)) {
                        m mVarO5 = mVarJ.a(mVarJ2).o();
                        mVarA = mVarO5.a(mVarJ6).a(mVarO3).j(mVarO5).a(mVar4.h() ? mVarJ5.a(mVarO3).o() : mVarJ5.p(mVar4, mVarO3.o())).a(mVarO4);
                        if (!mVar3.i()) {
                            if (!mVar3.h()) {
                                mVarA = mVarA.a(mVar3.b().j(mVarJ7));
                            }
                        }
                        pVar = new p(hVar, mVarO4, mVarA, new m[]{mVarJ7}, 0);
                    } else {
                        if (!zH2) {
                            mVarJ2 = mVarJ2.j(mVar2);
                        }
                        mVarA = mVarJ2.p(mVarJ6, mVarJ4).a(mVarO4);
                    }
                    mVarA = mVarA.a(mVarJ7);
                    pVar = new p(hVar, mVarO4, mVarA, new m[]{mVarJ7}, 0);
                }
                return pVar;
            case 1:
                if (k()) {
                    return this;
                }
                boolean zI2 = mVarJ2.i();
                h hVar2 = this.f4817a;
                if (zI2) {
                    return hVar2.m();
                }
                m mVar5 = mVarArr[0];
                boolean zH3 = mVar5.h();
                m mVarJ8 = zH3 ? mVarJ : mVarJ.j(mVar5);
                m mVarO6 = zH3 ? mVar5 : mVar5.o();
                m mVarJ9 = hVar2.f4798b;
                if (!zH3) {
                    mVarJ9 = mVarJ9.j(mVarO6);
                }
                m mVarJ10 = m0.f.j(mVarJ, mVarJ8, mVarJ9);
                if (mVarJ10.i()) {
                    return new p(hVar2, mVarJ10, hVar2.f4799c.n(), i11);
                }
                m mVarO7 = mVarJ10.o();
                m mVarJ11 = zH3 ? mVarJ10 : mVarJ10.j(mVarO6);
                if (!zH3) {
                    mVarJ2 = mVarJ2.j(mVar5);
                }
                return new p(hVar2, mVarO7, mVarJ2.p(mVarJ10, mVarJ8).a(mVarO7).a(mVarJ11), new m[]{mVarJ11}, 1);
            case 2:
                if (k()) {
                    return this;
                }
                boolean zI3 = mVarJ2.i();
                h hVar3 = this.f4817a;
                if (zI3) {
                    return hVar3.m();
                }
                m mVar6 = mVarArr[0];
                boolean zH4 = mVar6.h();
                m mVarJ12 = zH4 ? mVarJ : mVarJ.j(mVar6);
                m mVarO8 = zH4 ? mVar6 : mVar6.o();
                m mVarJ13 = hVar3.f4798b;
                if (!zH4) {
                    mVarJ13 = mVarJ13.j(mVarO8);
                }
                m mVarJ14 = m0.f.j(mVarJ, mVarJ12, mVarJ13);
                if (mVarJ14.i()) {
                    return new p(hVar3, mVarJ14, hVar3.f4799c.n(), 2);
                }
                m mVarO9 = mVarJ14.o();
                m mVarJ15 = zH4 ? mVarJ14 : mVarJ14.j(mVarO8);
                if (!zH4) {
                    mVarJ2 = mVarJ2.j(mVar6);
                }
                return new p(hVar3, mVarO9, mVarJ2.p(mVarJ14, mVarJ12).a(mVarO9).a(mVarJ15), new m[]{mVarJ15}, 2);
            case 3:
                if (k()) {
                    return this;
                }
                boolean zI4 = mVarJ2.i();
                h hVar4 = this.f4817a;
                if (zI4) {
                    return hVar4.m();
                }
                m mVar7 = mVarArr[0];
                boolean zH5 = mVar7.h();
                m mVarJ16 = zH5 ? mVarJ : mVarJ.j(mVar7);
                m mVarO10 = zH5 ? mVar7 : mVar7.o();
                m mVarJ17 = hVar4.f4798b;
                if (!zH5) {
                    mVarJ17 = mVarJ17.j(mVarO10);
                }
                m mVarJ18 = m0.f.j(mVarJ, mVarJ16, mVarJ17);
                if (mVarJ18.i()) {
                    return new p(hVar4, mVarJ18, hVar4.f4799c.n(), 3);
                }
                m mVarO11 = mVarJ18.o();
                m mVarJ19 = zH5 ? mVarJ18 : mVarJ18.j(mVarO10);
                if (!zH5) {
                    mVarJ2 = mVarJ2.j(mVar7);
                }
                return new p(hVar4, mVarO11, mVarJ2.p(mVarJ18, mVarJ16).a(mVarO11).a(mVarJ19), new m[]{mVarJ19}, 3);
            case 4:
                if (k()) {
                    return this;
                }
                boolean zI5 = mVarJ2.i();
                h hVar5 = this.f4817a;
                if (zI5) {
                    return hVar5.m();
                }
                m mVar8 = mVarArr[0];
                boolean zH6 = mVar8.h();
                m mVarJ20 = zH6 ? mVarJ : mVarJ.j(mVar8);
                m mVarO12 = zH6 ? mVar8 : mVar8.o();
                m mVarJ21 = hVar5.f4798b;
                if (!zH6) {
                    mVarJ21 = mVarJ21.j(mVarO12);
                }
                m mVarJ22 = m0.f.j(mVarJ, mVarJ20, mVarJ21);
                if (mVarJ22.i()) {
                    return new p(hVar5, mVarJ22, hVar5.f4799c.n(), 4);
                }
                m mVarO13 = mVarJ22.o();
                m mVarJ23 = zH6 ? mVarJ22 : mVarJ22.j(mVarO12);
                if (!zH6) {
                    mVarJ2 = mVarJ2.j(mVar8);
                }
                return new p(hVar5, mVarO13, mVarJ2.p(mVarJ22, mVarJ20).a(mVarO13).a(mVarJ23), new m[]{mVarJ23}, 4);
            case 5:
                if (k()) {
                    return this;
                }
                boolean zI6 = mVarJ2.i();
                h hVar6 = this.f4817a;
                if (zI6) {
                    return hVar6.m();
                }
                m mVarO14 = mVarArr[0];
                boolean zH7 = mVarO14.h();
                m mVarJ24 = zH7 ? mVarJ : mVarJ.j(mVarO14);
                if (!zH7) {
                    mVarO14 = mVarO14.o();
                }
                m mVarJ25 = m0.f.j(mVarJ, mVarJ24, mVarO14);
                if (mVarJ25.i()) {
                    return new p(hVar6, mVarJ25, hVar6.f4799c, 5);
                }
                m mVarO15 = mVarJ25.o();
                m mVarJ26 = zH7 ? mVarJ25 : mVarJ25.j(mVarO14);
                m mVarO16 = mVarJ.a(mVarJ2).o();
                return new p(hVar6, mVarO15, mVarO16.a(mVarJ25).a(mVarO14).j(mVarO16).a(mVarO15), new m[]{mVarJ26}, 5);
            case 6:
                if (k()) {
                    return this;
                }
                boolean zI7 = mVarJ2.i();
                h hVar7 = this.f4817a;
                if (zI7) {
                    return hVar7.m();
                }
                m mVar9 = mVarArr[0];
                boolean zH8 = mVar9.h();
                m mVarJ27 = zH8 ? mVarJ : mVarJ.j(mVar9);
                m mVarO17 = zH8 ? mVar9 : mVar9.o();
                m mVarJ28 = hVar7.f4798b;
                if (!zH8) {
                    mVarJ28 = mVarJ28.j(mVarO17);
                }
                m mVarJ29 = m0.f.j(mVarJ, mVarJ27, mVarJ28);
                if (mVarJ29.i()) {
                    return new p(hVar7, mVarJ29, hVar7.f4799c.n(), i9);
                }
                m mVarO18 = mVarJ29.o();
                m mVarJ30 = zH8 ? mVarJ29 : mVarJ29.j(mVarO17);
                if (!zH8) {
                    mVarJ2 = mVarJ2.j(mVar9);
                }
                return new p(hVar7, mVarO18, mVarJ2.p(mVarJ29, mVarJ27).a(mVarO18).a(mVarJ30), new m[]{mVarJ30}, 6);
            case 7:
                if (k()) {
                    return this;
                }
                boolean zI8 = mVarJ2.i();
                h hVar8 = this.f4817a;
                if (zI8) {
                    return hVar8.m();
                }
                m mVar10 = mVarArr[0];
                boolean zH9 = mVar10.h();
                m mVarJ31 = zH9 ? mVarJ : mVarJ.j(mVar10);
                m mVarO19 = zH9 ? mVar10 : mVar10.o();
                m mVarJ32 = m0.f.j(mVarJ, mVarJ31, mVarO19);
                if (mVarJ32.i()) {
                    return new p(hVar8, mVarJ32, hVar8.f4799c.n(), 7);
                }
                m mVarO20 = mVarJ32.o();
                m mVarJ33 = zH9 ? mVarJ32 : mVarJ32.j(mVarO19);
                if (!zH9) {
                    mVarJ2 = mVarJ2.j(mVar10);
                }
                return new p(hVar8, mVarO20, mVarJ2.p(mVarJ32, mVarJ31).a(mVarO20).a(mVarJ33), new m[]{mVarJ33}, 7);
            case 8:
                if (k()) {
                    return this;
                }
                boolean zI9 = mVarJ2.i();
                h hVar9 = this.f4817a;
                if (zI9) {
                    return hVar9.m();
                }
                m mVar11 = mVarArr[0];
                boolean zH10 = mVar11.h();
                m mVarJ34 = zH10 ? mVarJ : mVarJ.j(mVar11);
                m mVarO21 = zH10 ? mVar11 : mVar11.o();
                m mVarJ35 = hVar9.f4798b;
                if (!zH10) {
                    mVarJ35 = mVarJ35.j(mVarO21);
                }
                m mVarJ36 = m0.f.j(mVarJ, mVarJ34, mVarJ35);
                if (mVarJ36.i()) {
                    return new p(hVar9, mVarJ36, hVar9.f4799c.n(), 8);
                }
                m mVarO22 = mVarJ36.o();
                m mVarJ37 = zH10 ? mVarJ36 : mVarJ36.j(mVarO21);
                if (!zH10) {
                    mVarJ2 = mVarJ2.j(mVar11);
                }
                return new p(hVar9, mVarO22, mVarJ2.p(mVarJ36, mVarJ34).a(mVarO22).a(mVarJ37), new m[]{mVarJ37}, 8);
            case 9:
                if (k()) {
                    return this;
                }
                boolean zI10 = mVarJ2.i();
                h hVar10 = this.f4817a;
                if (zI10) {
                    return hVar10.m();
                }
                m mVar12 = mVarArr[0];
                boolean zH11 = mVar12.h();
                m mVarJ38 = zH11 ? mVarJ : mVarJ.j(mVar12);
                m mVarO23 = zH11 ? mVar12 : mVar12.o();
                m mVarJ39 = hVar10.f4798b;
                if (!zH11) {
                    mVarJ39 = mVarJ39.j(mVarO23);
                }
                m mVarJ40 = m0.f.j(mVarJ, mVarJ38, mVarJ39);
                if (mVarJ40.i()) {
                    return new p(hVar10, mVarJ40, hVar10.f4799c.n(), i10);
                }
                m mVarO24 = mVarJ40.o();
                m mVarJ41 = zH11 ? mVarJ40 : mVarJ40.j(mVarO23);
                if (!zH11) {
                    mVarJ2 = mVarJ2.j(mVar12);
                }
                return new p(hVar10, mVarO24, mVarJ2.p(mVarJ40, mVarJ38).a(mVarO24).a(mVarJ41), new m[]{mVarJ41}, 9);
            case 10:
                if (k()) {
                    return this;
                }
                boolean zI11 = mVarJ2.i();
                h hVar11 = this.f4817a;
                if (zI11) {
                    return hVar11.m();
                }
                m mVarO25 = mVarArr[0];
                boolean zH12 = mVarO25.h();
                m mVarO26 = zH12 ? mVarO25 : mVarO25.o();
                m mVarA6 = zH12 ? mVarJ.o().a(mVarJ) : mVarJ.a(mVarO25).j(mVarJ);
                if (mVarA6.i()) {
                    return new p(hVar11, mVarA6, hVar11.f4799c, 10);
                }
                m mVarO27 = mVarA6.o();
                m mVarJ42 = zH12 ? mVarA6 : mVarA6.j(mVarO26);
                m mVarO28 = mVarJ.a(mVarJ2).o();
                if (!zH12) {
                    mVarO25 = mVarO26.o();
                }
                return new p(hVar11, mVarO27, mVarO28.a(mVarA6).a(mVarO26).j(mVarO28).a(mVarO25).a(mVarO27).a(mVarJ42), new m[]{mVarJ42}, 10);
            case BERTags.EMBEDDED_PDV /* 11 */:
                if (k()) {
                    return this;
                }
                boolean zI12 = mVarJ2.i();
                h hVar12 = this.f4817a;
                if (zI12) {
                    return hVar12.m();
                }
                m mVar13 = mVarArr[0];
                boolean zH13 = mVar13.h();
                m mVarJ43 = zH13 ? mVarJ : mVarJ.j(mVar13);
                m mVarO29 = zH13 ? mVar13 : mVar13.o();
                m mVarJ44 = m0.f.j(mVarJ, mVarJ43, mVarO29);
                if (mVarJ44.i()) {
                    return new p(hVar12, mVarJ44, hVar12.f4799c.n(), 11);
                }
                m mVarO30 = mVarJ44.o();
                m mVarJ45 = zH13 ? mVarJ44 : mVarJ44.j(mVarO29);
                if (!zH13) {
                    mVarJ2 = mVarJ2.j(mVar13);
                }
                return new p(hVar12, mVarO30, mVarJ2.p(mVarJ44, mVarJ43).a(mVarO30).a(mVarJ45), new m[]{mVarJ45}, 11);
            case 12:
                if (k()) {
                    return this;
                }
                boolean zI13 = mVarJ2.i();
                h hVar13 = this.f4817a;
                if (zI13) {
                    return hVar13.m();
                }
                m mVarO31 = mVarArr[0];
                boolean zH14 = mVarO31.h();
                m mVarO32 = zH14 ? mVarO31 : mVarO31.o();
                m mVarA7 = zH14 ? mVarJ.o().a(mVarJ) : mVarJ.a(mVarO31).j(mVarJ);
                if (mVarA7.i()) {
                    return new p(hVar13, mVarA7, hVar13.f4799c, 12);
                }
                m mVarO33 = mVarA7.o();
                m mVarJ46 = zH14 ? mVarA7 : mVarA7.j(mVarO32);
                m mVarO34 = mVarJ.a(mVarJ2).o();
                if (!zH14) {
                    mVarO31 = mVarO32.o();
                }
                return new p(hVar13, mVarO33, mVarO34.a(mVarA7).a(mVarO32).j(mVarO34).a(mVarO31).a(mVarO33).a(mVarJ46), new m[]{mVarJ46}, 12);
            case BERTags.RELATIVE_OID /* 13 */:
                if (k()) {
                    return this;
                }
                boolean zI14 = mVarJ2.i();
                h hVar14 = this.f4817a;
                if (zI14) {
                    return hVar14.m();
                }
                m mVarO35 = mVarArr[0];
                boolean zH15 = mVarO35.h();
                m mVarO36 = zH15 ? mVarO35 : mVarO35.o();
                m mVarA8 = zH15 ? mVarJ.o().a(mVarJ) : mVarJ.a(mVarO35).j(mVarJ);
                if (mVarA8.i()) {
                    return new p(hVar14, mVarA8, hVar14.f4799c, 13);
                }
                m mVarO37 = mVarA8.o();
                m mVarJ47 = zH15 ? mVarA8 : mVarA8.j(mVarO36);
                m mVarO38 = mVarJ.a(mVarJ2).o();
                if (!zH15) {
                    mVarO35 = mVarO36.o();
                }
                return new p(hVar14, mVarO37, mVarO38.a(mVarA8).a(mVarO36).j(mVarO38).a(mVarO35).a(mVarO37).a(mVarJ47), new m[]{mVarJ47}, 13);
            case BERTags.TIME /* 14 */:
                if (k()) {
                    return this;
                }
                boolean zI15 = mVarJ2.i();
                h hVar15 = this.f4817a;
                if (zI15) {
                    return hVar15.m();
                }
                m mVar14 = mVarArr[0];
                boolean zH16 = mVar14.h();
                m mVarJ48 = zH16 ? mVarJ : mVarJ.j(mVar14);
                m mVarO39 = zH16 ? mVar14 : mVar14.o();
                m mVarJ49 = m0.f.j(mVarJ, mVarJ48, mVarO39);
                if (mVarJ49.i()) {
                    return new p(hVar15, mVarJ49, hVar15.f4799c.n(), 14);
                }
                m mVarO40 = mVarJ49.o();
                m mVarJ50 = zH16 ? mVarJ49 : mVarJ49.j(mVarO39);
                if (!zH16) {
                    mVarJ2 = mVarJ2.j(mVar14);
                }
                return new p(hVar15, mVarO40, mVarJ2.p(mVarJ49, mVarJ48).a(mVarO40).a(mVarJ50), new m[]{mVarJ50}, 14);
            case 15:
                if (k()) {
                    return this;
                }
                boolean zI16 = mVarJ2.i();
                h hVar16 = this.f4817a;
                if (zI16) {
                    return hVar16.m();
                }
                m mVarO41 = mVarArr[0];
                boolean zH17 = mVarO41.h();
                m mVarO42 = zH17 ? mVarO41 : mVarO41.o();
                m mVarA9 = zH17 ? mVarJ.o().a(mVarJ) : mVarJ.a(mVarO41).j(mVarJ);
                if (mVarA9.i()) {
                    return new p(hVar16, mVarA9, hVar16.f4799c, 15);
                }
                m mVarO43 = mVarA9.o();
                m mVarJ51 = zH17 ? mVarA9 : mVarA9.j(mVarO42);
                m mVarO44 = mVarJ.a(mVarJ2).o();
                if (!zH17) {
                    mVarO41 = mVarO42.o();
                }
                return new p(hVar16, mVarO43, mVarO44.a(mVarA9).a(mVarO42).j(mVarO44).a(mVarO41).a(mVarO43).a(mVarJ51), new m[]{mVarJ51}, 15);
            case 16:
                if (k()) {
                    return this;
                }
                boolean zI17 = mVarJ2.i();
                h hVar17 = this.f4817a;
                if (zI17) {
                    return hVar17.m();
                }
                m mVar15 = mVarArr[0];
                boolean zH18 = mVar15.h();
                m mVarJ52 = zH18 ? mVarJ : mVarJ.j(mVar15);
                m mVarO45 = zH18 ? mVar15 : mVar15.o();
                m mVarJ53 = m0.f.j(mVarJ, mVarJ52, mVarO45);
                if (mVarJ53.i()) {
                    return new p(hVar17, mVarJ53, hVar17.f4799c.n(), 16);
                }
                m mVarO46 = mVarJ53.o();
                m mVarJ54 = zH18 ? mVarJ53 : mVarJ53.j(mVarO45);
                if (!zH18) {
                    mVarJ2 = mVarJ2.j(mVar15);
                }
                return new p(hVar17, mVarO46, mVarJ2.p(mVarJ53, mVarJ52).a(mVarO46).a(mVarJ54), new m[]{mVarJ54}, 16);
            case 17:
                if (k()) {
                    return this;
                }
                boolean zI18 = mVarJ2.i();
                h hVar18 = this.f4817a;
                if (zI18) {
                    return hVar18.m();
                }
                m mVarO47 = mVarArr[0];
                boolean zH19 = mVarO47.h();
                m mVarO48 = zH19 ? mVarO47 : mVarO47.o();
                m mVarA10 = zH19 ? mVarJ.o().a(mVarJ) : mVarJ.a(mVarO47).j(mVarJ);
                if (mVarA10.i()) {
                    return new p(hVar18, mVarA10, hVar18.f4799c, 17);
                }
                m mVarO49 = mVarA10.o();
                m mVarJ55 = zH19 ? mVarA10 : mVarA10.j(mVarO48);
                m mVarO50 = mVarJ.a(mVarJ2).o();
                if (!zH19) {
                    mVarO47 = mVarO48.o();
                }
                return new p(hVar18, mVarO49, mVarO50.a(mVarA10).a(mVarO48).j(mVarO50).a(mVarO47).a(mVarO49).a(mVarJ55), new m[]{mVarJ55}, 17);
            default:
                if (k()) {
                    return this;
                }
                long[] jArr = ((w0) mVarJ2).f5372g;
                boolean Z = x.e.Z(jArr);
                h hVar19 = this.f4817a;
                if (Z) {
                    return hVar19.m();
                }
                w0 w0Var = (w0) mVarJ;
                w0 w0Var2 = (w0) mVarArr[0];
                long[] jArr2 = new long[9];
                long[] jArr3 = new long[9];
                boolean zH20 = w0Var2.h();
                long[] jArr4 = w0Var2.f5372g;
                long[] jArrV0 = zH20 ? null : s7.b.v0(jArr4);
                long[] jArr5 = w0Var.f5372g;
                if (jArrV0 != null) {
                    s7.b.u0(jArr5, jArrV0, jArr2);
                    s7.b.e1(jArr4, jArr3);
                    jArr5 = jArr2;
                    jArr4 = jArr3;
                }
                long[] jArr6 = new long[9];
                s7.b.e1(w0Var.f5372g, jArr6);
                s7.b.f(jArr5, jArr4, jArr6);
                int i14 = 18;
                if (x.e.Z(jArr6)) {
                    return new p(hVar19, new w0(jArr6), z0.f5386m, i14);
                }
                long[] jArr7 = new long[18];
                s7.b.t0(jArr6, jArr5, jArr7);
                w0 w0Var3 = new w0(jArr2);
                s7.b.e1(jArr6, jArr2);
                w0 w0Var4 = new w0(jArr6);
                if (jArrV0 != null) {
                    s7.b.j0(jArr6, jArr4, jArr6);
                }
                if (jArrV0 != null) {
                    s7.b.u0(jArr, jArrV0, jArr3);
                    jArr = jArr3;
                }
                long[] jArr8 = new long[18];
                s7.b.V(jArr, jArr8);
                s7.b.j(jArr7, jArr8, jArr7);
                s7.b.E0(jArr7, jArr3);
                s7.b.f(jArr2, jArr6, jArr3);
                return new p(hVar19, w0Var3, new w0(jArr3), new m[]{w0Var4}, 18);
        }
    }

    @Override // p7.r
    public final r y(r rVar) {
        int i8 = this.f4814g;
        int i9 = 6;
        int i10 = 9;
        int i11 = 1;
        m[] mVarArr = this.d;
        m mVar = this.f4819c;
        m mVar2 = this.f4818b;
        int i12 = 0;
        switch (i8) {
            case 0:
                if (!k()) {
                    if (rVar.k()) {
                        break;
                    } else if (!mVar2.i()) {
                        h hVar = this.f4817a;
                        if (hVar.f4801f == 6) {
                            m mVar3 = rVar.f4818b;
                            m mVar4 = rVar.d[0];
                            if (!mVar3.i() && mVar4.h()) {
                                m mVar5 = mVarArr[0];
                                m mVar6 = rVar.f4819c;
                                m mVarO = mVar2.o();
                                m mVarO2 = mVar.o();
                                m mVarO3 = mVar5.o();
                                m mVarA = hVar.f4798b.j(mVarO3).a(mVarO2).a(mVar.j(mVar5));
                                m mVarB = mVar6.b();
                                m mVarL = hVar.f4798b.a(mVarB).j(mVarO3).a(mVarO2).l(mVarA, mVarO, mVarO3);
                                m mVarJ = mVar3.j(mVarO3);
                                m mVarO4 = mVarJ.a(mVarA).o();
                                if (mVarO4.i()) {
                                    if (mVarL.i()) {
                                        break;
                                    } else {
                                        break;
                                    }
                                } else if (mVarL.i()) {
                                    break;
                                } else {
                                    m mVarJ2 = mVarL.o().j(mVarJ);
                                    m mVarJ3 = mVarL.j(mVarO4).j(mVarO3);
                                    break;
                                }
                            }
                        }
                        break;
                    }
                }
                break;
            case 1:
                if (!k()) {
                    if (rVar.k()) {
                        break;
                    } else if (!mVar2.i()) {
                        m mVar7 = rVar.f4818b;
                        m mVarI = rVar.i();
                        if (mVar7.i() || !mVarI.h()) {
                            break;
                        } else {
                            m mVar8 = mVarArr[0];
                            m mVar9 = rVar.f4819c;
                            m mVarO5 = mVar2.o();
                            m mVarO6 = mVar.o();
                            m mVarO7 = mVar8.o();
                            m mVarJ4 = mVar.j(mVar8);
                            h hVar2 = this.f4817a;
                            m mVarA2 = hVar2.f4798b.j(mVarO7).a(mVarO6).a(mVarJ4);
                            m mVarB2 = mVar9.b();
                            m mVarL2 = hVar2.f4798b.a(mVarB2).j(mVarO7).a(mVarO6).l(mVarA2, mVarO5, mVarO7);
                            m mVarJ5 = mVar7.j(mVarO7);
                            m mVarO8 = mVarJ5.a(mVarA2).o();
                            if (mVarO8.i()) {
                                if (mVarL2.i()) {
                                    break;
                                } else {
                                    break;
                                }
                            } else if (mVarL2.i()) {
                                break;
                            } else {
                                m mVarJ6 = mVarL2.o().j(mVarJ5);
                                m mVarJ7 = mVarL2.j(mVarO8).j(mVarO7);
                                break;
                            }
                        }
                    }
                }
                break;
            case 2:
                if (!k()) {
                    if (rVar.k()) {
                        break;
                    } else if (!mVar2.i()) {
                        m mVar10 = rVar.f4818b;
                        m mVarI2 = rVar.i();
                        if (mVar10.i() || !mVarI2.h()) {
                            break;
                        } else {
                            m mVar11 = mVarArr[0];
                            m mVar12 = rVar.f4819c;
                            m mVarO9 = mVar2.o();
                            m mVarO10 = mVar.o();
                            m mVarO11 = mVar11.o();
                            m mVarJ8 = mVar.j(mVar11);
                            h hVar3 = this.f4817a;
                            m mVarA3 = hVar3.f4798b.j(mVarO11).a(mVarO10).a(mVarJ8);
                            m mVarB3 = mVar12.b();
                            m mVarL3 = hVar3.f4798b.a(mVarB3).j(mVarO11).a(mVarO10).l(mVarA3, mVarO9, mVarO11);
                            m mVarJ9 = mVar10.j(mVarO11);
                            m mVarO12 = mVarJ9.a(mVarA3).o();
                            if (mVarO12.i()) {
                                if (mVarL3.i()) {
                                    break;
                                } else {
                                    break;
                                }
                            } else if (mVarL3.i()) {
                                break;
                            } else {
                                m mVarJ10 = mVarL3.o().j(mVarJ9);
                                m mVarJ11 = mVarL3.j(mVarO12).j(mVarO11);
                                break;
                            }
                        }
                    }
                }
                break;
            case 3:
                if (!k()) {
                    if (rVar.k()) {
                        break;
                    } else if (!mVar2.i()) {
                        m mVar13 = rVar.f4818b;
                        m mVarI3 = rVar.i();
                        if (mVar13.i() || !mVarI3.h()) {
                            break;
                        } else {
                            m mVar14 = mVarArr[0];
                            m mVar15 = rVar.f4819c;
                            m mVarO13 = mVar2.o();
                            m mVarO14 = mVar.o();
                            m mVarO15 = mVar14.o();
                            m mVarJ12 = mVar.j(mVar14);
                            h hVar4 = this.f4817a;
                            m mVarA4 = hVar4.f4798b.j(mVarO15).a(mVarO14).a(mVarJ12);
                            m mVarB4 = mVar15.b();
                            m mVarL4 = hVar4.f4798b.a(mVarB4).j(mVarO15).a(mVarO14).l(mVarA4, mVarO13, mVarO15);
                            m mVarJ13 = mVar13.j(mVarO15);
                            m mVarO16 = mVarJ13.a(mVarA4).o();
                            if (mVarO16.i()) {
                                if (mVarL4.i()) {
                                    break;
                                } else {
                                    break;
                                }
                            } else if (mVarL4.i()) {
                                break;
                            } else {
                                m mVarJ14 = mVarL4.o().j(mVarJ13);
                                m mVarJ15 = mVarL4.j(mVarO16).j(mVarO15);
                                break;
                            }
                        }
                    }
                }
                break;
            case 4:
                if (!k()) {
                    if (rVar.k()) {
                        break;
                    } else if (!mVar2.i()) {
                        m mVar16 = rVar.f4818b;
                        m mVarI4 = rVar.i();
                        if (mVar16.i() || !mVarI4.h()) {
                            break;
                        } else {
                            m mVar17 = mVarArr[0];
                            m mVar18 = rVar.f4819c;
                            m mVarO17 = mVar2.o();
                            m mVarO18 = mVar.o();
                            m mVarO19 = mVar17.o();
                            m mVarJ16 = mVar.j(mVar17);
                            h hVar5 = this.f4817a;
                            m mVarA5 = hVar5.f4798b.j(mVarO19).a(mVarO18).a(mVarJ16);
                            m mVarB5 = mVar18.b();
                            m mVarL5 = hVar5.f4798b.a(mVarB5).j(mVarO19).a(mVarO18).l(mVarA5, mVarO17, mVarO19);
                            m mVarJ17 = mVar16.j(mVarO19);
                            m mVarO20 = mVarJ17.a(mVarA5).o();
                            if (mVarO20.i()) {
                                if (mVarL5.i()) {
                                    break;
                                } else {
                                    break;
                                }
                            } else if (mVarL5.i()) {
                                break;
                            } else {
                                m mVarJ18 = mVarL5.o().j(mVarJ17);
                                m mVarJ19 = mVarL5.j(mVarO20).j(mVarO19);
                                break;
                            }
                        }
                    }
                }
                break;
            case 5:
                if (!k()) {
                    if (rVar.k()) {
                        break;
                    } else if (!mVar2.i()) {
                        m mVar19 = rVar.f4818b;
                        m mVarI5 = rVar.i();
                        if (mVar19.i() || !mVarI5.h()) {
                            break;
                        } else {
                            m mVar20 = mVarArr[0];
                            m mVar21 = rVar.f4819c;
                            m mVarO21 = mVar2.o();
                            m mVarO22 = mVar.o();
                            m mVarO23 = mVar20.o();
                            m mVarA6 = mVarO23.a(mVarO22).a(mVar.j(mVar20));
                            m mVarL6 = mVar21.j(mVarO23).a(mVarO22).l(mVarA6, mVarO21, mVarO23);
                            m mVarJ20 = mVar19.j(mVarO23);
                            m mVarO24 = mVarJ20.a(mVarA6).o();
                            boolean zI = mVarO24.i();
                            h hVar6 = this.f4817a;
                            boolean zI2 = mVarL6.i();
                            if (zI) {
                                if (zI2) {
                                    break;
                                } else {
                                    break;
                                }
                            } else if (zI2) {
                                break;
                            } else {
                                m mVarJ21 = mVarL6.o().j(mVarJ20);
                                m mVarJ22 = mVarL6.j(mVarO24).j(mVarO23);
                                break;
                            }
                        }
                    }
                }
                break;
            case 6:
                if (!k()) {
                    if (rVar.k()) {
                        break;
                    } else if (!mVar2.i()) {
                        m mVar22 = rVar.f4818b;
                        m mVarI6 = rVar.i();
                        if (mVar22.i() || !mVarI6.h()) {
                            break;
                        } else {
                            m mVar23 = mVarArr[0];
                            m mVar24 = rVar.f4819c;
                            m mVarO25 = mVar2.o();
                            m mVarO26 = mVar.o();
                            m mVarO27 = mVar23.o();
                            m mVarJ23 = mVar.j(mVar23);
                            h hVar7 = this.f4817a;
                            m mVarA7 = hVar7.f4798b.j(mVarO27).a(mVarO26).a(mVarJ23);
                            m mVarB6 = mVar24.b();
                            m mVarL7 = hVar7.f4798b.a(mVarB6).j(mVarO27).a(mVarO26).l(mVarA7, mVarO25, mVarO27);
                            m mVarJ24 = mVar22.j(mVarO27);
                            m mVarO28 = mVarJ24.a(mVarA7).o();
                            if (mVarO28.i()) {
                                if (mVarL7.i()) {
                                    break;
                                } else {
                                    break;
                                }
                            } else if (mVarL7.i()) {
                                break;
                            } else {
                                m mVarJ25 = mVarL7.o().j(mVarJ24);
                                m mVarJ26 = mVarL7.j(mVarO28).j(mVarO27);
                                break;
                            }
                        }
                    }
                }
                break;
            case 7:
                if (!k()) {
                    if (rVar.k()) {
                        break;
                    } else if (!mVar2.i()) {
                        m mVar25 = rVar.f4818b;
                        m mVarI7 = rVar.i();
                        if (mVar25.i() || !mVarI7.h()) {
                            break;
                        } else {
                            m mVar26 = mVarArr[0];
                            m mVar27 = rVar.f4819c;
                            m mVarO29 = mVar2.o();
                            m mVarO30 = mVar.o();
                            m mVarO31 = mVar26.o();
                            m mVarA8 = mVarO31.a(mVarO30).a(mVar.j(mVar26));
                            m mVarL8 = mVar27.j(mVarO31).a(mVarO30).l(mVarA8, mVarO29, mVarO31);
                            m mVarJ27 = mVar25.j(mVarO31);
                            m mVarO32 = mVarJ27.a(mVarA8).o();
                            boolean zI3 = mVarO32.i();
                            h hVar8 = this.f4817a;
                            boolean zI4 = mVarL8.i();
                            if (zI3) {
                                if (zI4) {
                                    break;
                                } else {
                                    break;
                                }
                            } else if (zI4) {
                                break;
                            } else {
                                m mVarJ28 = mVarL8.o().j(mVarJ27);
                                m mVarJ29 = mVarL8.j(mVarO32).j(mVarO31);
                                break;
                            }
                        }
                    }
                }
                break;
            case 8:
                if (!k()) {
                    if (rVar.k()) {
                        break;
                    } else if (!mVar2.i()) {
                        m mVar28 = rVar.f4818b;
                        m mVarI8 = rVar.i();
                        if (mVar28.i() || !mVarI8.h()) {
                            break;
                        } else {
                            m mVar29 = mVarArr[0];
                            m mVar30 = rVar.f4819c;
                            m mVarO33 = mVar2.o();
                            m mVarO34 = mVar.o();
                            m mVarO35 = mVar29.o();
                            m mVarJ30 = mVar.j(mVar29);
                            h hVar9 = this.f4817a;
                            m mVarA9 = hVar9.f4798b.j(mVarO35).a(mVarO34).a(mVarJ30);
                            m mVarB7 = mVar30.b();
                            m mVarL9 = hVar9.f4798b.a(mVarB7).j(mVarO35).a(mVarO34).l(mVarA9, mVarO33, mVarO35);
                            m mVarJ31 = mVar28.j(mVarO35);
                            m mVarO36 = mVarJ31.a(mVarA9).o();
                            if (mVarO36.i()) {
                                if (mVarL9.i()) {
                                    break;
                                } else {
                                    break;
                                }
                            } else if (mVarL9.i()) {
                                break;
                            } else {
                                m mVarJ32 = mVarL9.o().j(mVarJ31);
                                m mVarJ33 = mVarL9.j(mVarO36).j(mVarO35);
                                break;
                            }
                        }
                    }
                }
                break;
            case 9:
                if (!k()) {
                    if (rVar.k()) {
                        break;
                    } else if (!mVar2.i()) {
                        m mVar31 = rVar.f4818b;
                        m mVarI9 = rVar.i();
                        if (mVar31.i() || !mVarI9.h()) {
                            break;
                        } else {
                            m mVar32 = mVarArr[0];
                            m mVar33 = rVar.f4819c;
                            m mVarO37 = mVar2.o();
                            m mVarO38 = mVar.o();
                            m mVarO39 = mVar32.o();
                            m mVarJ34 = mVar.j(mVar32);
                            h hVar10 = this.f4817a;
                            m mVarA10 = hVar10.f4798b.j(mVarO39).a(mVarO38).a(mVarJ34);
                            m mVarB8 = mVar33.b();
                            m mVarL10 = hVar10.f4798b.a(mVarB8).j(mVarO39).a(mVarO38).l(mVarA10, mVarO37, mVarO39);
                            m mVarJ35 = mVar31.j(mVarO39);
                            m mVarO40 = mVarJ35.a(mVarA10).o();
                            if (mVarO40.i()) {
                                if (mVarL10.i()) {
                                    break;
                                } else {
                                    break;
                                }
                            } else if (mVarL10.i()) {
                                break;
                            } else {
                                m mVarJ36 = mVarL10.o().j(mVarJ35);
                                m mVarJ37 = mVarL10.j(mVarO40).j(mVarO39);
                                break;
                            }
                        }
                    }
                }
                break;
            case 10:
                if (!k()) {
                    if (rVar.k()) {
                        break;
                    } else if (!mVar2.i()) {
                        m mVar34 = rVar.f4818b;
                        m mVarI10 = rVar.i();
                        if (mVar34.i() || !mVarI10.h()) {
                            break;
                        } else {
                            m mVar35 = mVarArr[0];
                            m mVar36 = rVar.f4819c;
                            m mVarO41 = mVar2.o();
                            m mVarO42 = mVar.o();
                            m mVarO43 = mVar35.o();
                            m mVarA11 = mVarO42.a(mVar.j(mVar35));
                            m mVarB9 = mVar36.b();
                            m mVarL11 = mVarB9.j(mVarO43).a(mVarO42).l(mVarA11, mVarO41, mVarO43);
                            m mVarJ38 = mVar34.j(mVarO43);
                            m mVarO44 = mVarJ38.a(mVarA11).o();
                            boolean zI5 = mVarO44.i();
                            h hVar11 = this.f4817a;
                            boolean zI6 = mVarL11.i();
                            if (zI5) {
                                if (zI6) {
                                    break;
                                } else {
                                    break;
                                }
                            } else if (zI6) {
                                break;
                            } else {
                                m mVarJ39 = mVarL11.o().j(mVarJ38);
                                m mVarJ40 = mVarL11.j(mVarO44).j(mVarO43);
                                break;
                            }
                        }
                    }
                }
                break;
            case BERTags.EMBEDDED_PDV /* 11 */:
                if (!k()) {
                    if (rVar.k()) {
                        break;
                    } else if (!mVar2.i()) {
                        m mVar37 = rVar.f4818b;
                        m mVarI11 = rVar.i();
                        if (mVar37.i() || !mVarI11.h()) {
                            break;
                        } else {
                            m mVar38 = mVarArr[0];
                            m mVar39 = rVar.f4819c;
                            m mVarO45 = mVar2.o();
                            m mVarO46 = mVar.o();
                            m mVarO47 = mVar38.o();
                            m mVarA12 = mVarO47.a(mVarO46).a(mVar.j(mVar38));
                            m mVarL12 = mVar39.j(mVarO47).a(mVarO46).l(mVarA12, mVarO45, mVarO47);
                            m mVarJ41 = mVar37.j(mVarO47);
                            m mVarO48 = mVarJ41.a(mVarA12).o();
                            boolean zI7 = mVarO48.i();
                            h hVar12 = this.f4817a;
                            boolean zI8 = mVarL12.i();
                            if (zI7) {
                                if (zI8) {
                                    break;
                                } else {
                                    break;
                                }
                            } else if (zI8) {
                                break;
                            } else {
                                m mVarJ42 = mVarL12.o().j(mVarJ41);
                                m mVarJ43 = mVarL12.j(mVarO48).j(mVarO47);
                                break;
                            }
                        }
                    }
                }
                break;
            case 12:
                if (!k()) {
                    if (rVar.k()) {
                        break;
                    } else if (!mVar2.i()) {
                        m mVar40 = rVar.f4818b;
                        m mVarI12 = rVar.i();
                        if (mVar40.i() || !mVarI12.h()) {
                            break;
                        } else {
                            m mVar41 = mVarArr[0];
                            m mVar42 = rVar.f4819c;
                            m mVarO49 = mVar2.o();
                            m mVarO50 = mVar.o();
                            m mVarO51 = mVar41.o();
                            m mVarA13 = mVarO50.a(mVar.j(mVar41));
                            m mVarB10 = mVar42.b();
                            m mVarL13 = mVarB10.j(mVarO51).a(mVarO50).l(mVarA13, mVarO49, mVarO51);
                            m mVarJ44 = mVar40.j(mVarO51);
                            m mVarO52 = mVarJ44.a(mVarA13).o();
                            boolean zI9 = mVarO52.i();
                            h hVar13 = this.f4817a;
                            boolean zI10 = mVarL13.i();
                            if (zI9) {
                                if (zI10) {
                                    break;
                                } else {
                                    break;
                                }
                            } else if (zI10) {
                                break;
                            } else {
                                m mVarJ45 = mVarL13.o().j(mVarJ44);
                                m mVarJ46 = mVarL13.j(mVarO52).j(mVarO51);
                                break;
                            }
                        }
                    }
                }
                break;
            case BERTags.RELATIVE_OID /* 13 */:
                if (!k()) {
                    if (rVar.k()) {
                        break;
                    } else if (!mVar2.i()) {
                        m mVar43 = rVar.f4818b;
                        m mVarI13 = rVar.i();
                        if (mVar43.i() || !mVarI13.h()) {
                            break;
                        } else {
                            m mVar44 = mVarArr[0];
                            m mVar45 = rVar.f4819c;
                            m mVarO53 = mVar2.o();
                            m mVarO54 = mVar.o();
                            m mVarO55 = mVar44.o();
                            m mVarA14 = mVarO54.a(mVar.j(mVar44));
                            m mVarB11 = mVar45.b();
                            m mVarL14 = mVarB11.j(mVarO55).a(mVarO54).l(mVarA14, mVarO53, mVarO55);
                            m mVarJ47 = mVar43.j(mVarO55);
                            m mVarO56 = mVarJ47.a(mVarA14).o();
                            boolean zI11 = mVarO56.i();
                            h hVar14 = this.f4817a;
                            boolean zI12 = mVarL14.i();
                            if (zI11) {
                                if (zI12) {
                                    break;
                                } else {
                                    break;
                                }
                            } else if (zI12) {
                                break;
                            } else {
                                m mVarJ48 = mVarL14.o().j(mVarJ47);
                                m mVarJ49 = mVarL14.j(mVarO56).j(mVarO55);
                                break;
                            }
                        }
                    }
                }
                break;
            case BERTags.TIME /* 14 */:
                if (!k()) {
                    if (rVar.k()) {
                        break;
                    } else if (!mVar2.i()) {
                        m mVar46 = rVar.f4818b;
                        m mVarI14 = rVar.i();
                        if (mVar46.i() || !mVarI14.h()) {
                            break;
                        } else {
                            m mVar47 = mVarArr[0];
                            m mVar48 = rVar.f4819c;
                            m mVarO57 = mVar2.o();
                            m mVarO58 = mVar.o();
                            m mVarO59 = mVar47.o();
                            m mVarA15 = mVarO59.a(mVarO58).a(mVar.j(mVar47));
                            m mVarL15 = mVar48.j(mVarO59).a(mVarO58).l(mVarA15, mVarO57, mVarO59);
                            m mVarJ50 = mVar46.j(mVarO59);
                            m mVarO60 = mVarJ50.a(mVarA15).o();
                            boolean zI13 = mVarO60.i();
                            h hVar15 = this.f4817a;
                            boolean zI14 = mVarL15.i();
                            if (zI13) {
                                if (zI14) {
                                    break;
                                } else {
                                    break;
                                }
                            } else if (zI14) {
                                break;
                            } else {
                                m mVarJ51 = mVarL15.o().j(mVarJ50);
                                m mVarJ52 = mVarL15.j(mVarO60).j(mVarO59);
                                break;
                            }
                        }
                    }
                }
                break;
            case 15:
                if (!k()) {
                    if (rVar.k()) {
                        break;
                    } else if (!mVar2.i()) {
                        m mVar49 = rVar.f4818b;
                        m mVarI15 = rVar.i();
                        if (mVar49.i() || !mVarI15.h()) {
                            break;
                        } else {
                            m mVar50 = mVarArr[0];
                            m mVar51 = rVar.f4819c;
                            m mVarO61 = mVar2.o();
                            m mVarO62 = mVar.o();
                            m mVarO63 = mVar50.o();
                            m mVarA16 = mVarO62.a(mVar.j(mVar50));
                            m mVarB12 = mVar51.b();
                            m mVarL16 = mVarB12.j(mVarO63).a(mVarO62).l(mVarA16, mVarO61, mVarO63);
                            m mVarJ53 = mVar49.j(mVarO63);
                            m mVarO64 = mVarJ53.a(mVarA16).o();
                            boolean zI15 = mVarO64.i();
                            h hVar16 = this.f4817a;
                            boolean zI16 = mVarL16.i();
                            if (zI15) {
                                if (zI16) {
                                    break;
                                } else {
                                    break;
                                }
                            } else if (zI16) {
                                break;
                            } else {
                                m mVarJ54 = mVarL16.o().j(mVarJ53);
                                m mVarJ55 = mVarL16.j(mVarO64).j(mVarO63);
                                break;
                            }
                        }
                    }
                }
                break;
            case 16:
                if (!k()) {
                    if (rVar.k()) {
                        break;
                    } else if (!mVar2.i()) {
                        m mVar52 = rVar.f4818b;
                        m mVarI16 = rVar.i();
                        if (mVar52.i() || !mVarI16.h()) {
                            break;
                        } else {
                            m mVar53 = mVarArr[0];
                            m mVar54 = rVar.f4819c;
                            m mVarO65 = mVar2.o();
                            m mVarO66 = mVar.o();
                            m mVarO67 = mVar53.o();
                            m mVarA17 = mVarO67.a(mVarO66).a(mVar.j(mVar53));
                            m mVarL17 = mVar54.j(mVarO67).a(mVarO66).l(mVarA17, mVarO65, mVarO67);
                            m mVarJ56 = mVar52.j(mVarO67);
                            m mVarO68 = mVarJ56.a(mVarA17).o();
                            boolean zI17 = mVarO68.i();
                            h hVar17 = this.f4817a;
                            boolean zI18 = mVarL17.i();
                            if (zI17) {
                                if (zI18) {
                                    break;
                                } else {
                                    break;
                                }
                            } else if (zI18) {
                                break;
                            } else {
                                m mVarJ57 = mVarL17.o().j(mVarJ56);
                                m mVarJ58 = mVarL17.j(mVarO68).j(mVarO67);
                                break;
                            }
                        }
                    }
                }
                break;
            case 17:
                if (!k()) {
                    if (rVar.k()) {
                        break;
                    } else if (!mVar2.i()) {
                        m mVar55 = rVar.f4818b;
                        m mVarI17 = rVar.i();
                        if (mVar55.i() || !mVarI17.h()) {
                            break;
                        } else {
                            m mVar56 = mVarArr[0];
                            m mVar57 = rVar.f4819c;
                            m mVarO69 = mVar2.o();
                            m mVarO70 = mVar.o();
                            m mVarO71 = mVar56.o();
                            m mVarA18 = mVarO70.a(mVar.j(mVar56));
                            m mVarB13 = mVar57.b();
                            m mVarL18 = mVarB13.j(mVarO71).a(mVarO70).l(mVarA18, mVarO69, mVarO71);
                            m mVarJ59 = mVar55.j(mVarO71);
                            m mVarO72 = mVarJ59.a(mVarA18).o();
                            boolean zI19 = mVarO72.i();
                            h hVar18 = this.f4817a;
                            boolean zI20 = mVarL18.i();
                            if (zI19) {
                                if (zI20) {
                                    break;
                                } else {
                                    break;
                                }
                            } else if (zI20) {
                                break;
                            } else {
                                m mVarJ60 = mVarL18.o().j(mVarJ59);
                                m mVarJ61 = mVarL18.j(mVarO72).j(mVarO71);
                                break;
                            }
                        }
                    }
                }
                break;
            default:
                if (!k()) {
                    if (rVar.k()) {
                        break;
                    } else {
                        w0 w0Var = (w0) mVar2;
                        if (!x.e.Z(w0Var.f5372g)) {
                            w0 w0Var2 = (w0) rVar.f4818b;
                            w0 w0Var3 = (w0) rVar.i();
                            if (x.e.Z(w0Var2.f5372g) || !w0Var3.h()) {
                                break;
                            } else {
                                w0 w0Var4 = (w0) mVar;
                                w0 w0Var5 = (w0) mVarArr[0];
                                w0 w0Var6 = (w0) rVar.f4819c;
                                long[] jArr = new long[9];
                                long[] jArr2 = new long[9];
                                long[] jArr3 = new long[9];
                                long[] jArr4 = new long[9];
                                s7.b.e1(w0Var.f5372g, jArr);
                                s7.b.e1(w0Var4.f5372g, jArr2);
                                s7.b.e1(w0Var5.f5372g, jArr3);
                                s7.b.j0(w0Var4.f5372g, w0Var5.f5372g, jArr4);
                                s7.b.f(jArr3, jArr2, jArr4);
                                long[] jArrV0 = s7.b.v0(jArr3);
                                s7.b.u0(w0Var6.f5372g, jArrV0, jArr3);
                                s7.b.b(jArr3, jArr2, jArr3);
                                int i13 = 18;
                                long[] jArr5 = new long[18];
                                s7.b.t0(jArr3, jArr4, jArr5);
                                long[] jArr6 = new long[18];
                                s7.b.I(jArr, jArrV0, jArr6);
                                s7.b.j(jArr5, jArr6, jArr5);
                                s7.b.E0(jArr5, jArr3);
                                s7.b.u0(w0Var2.f5372g, jArrV0, jArr);
                                s7.b.b(jArr, jArr4, jArr2);
                                s7.b.e1(jArr2, jArr2);
                                boolean Z = x.e.Z(jArr2);
                                h hVar19 = this.f4817a;
                                boolean Z2 = x.e.Z(jArr3);
                                if (Z) {
                                    if (Z2) {
                                        break;
                                    } else {
                                        break;
                                    }
                                } else if (Z2) {
                                    break;
                                } else {
                                    w0 w0Var7 = new w0();
                                    long[] jArr7 = new long[9];
                                    w0Var7.f5372g = jArr7;
                                    s7.b.e1(jArr3, jArr7);
                                    s7.b.j0(jArr7, jArr, jArr7);
                                    w0 w0Var8 = new w0(jArr);
                                    s7.b.j0(jArr3, jArr2, jArr);
                                    s7.b.u0(jArr, jArrV0, jArr);
                                    w0 w0Var9 = new w0(jArr2);
                                    s7.b.b(jArr3, jArr2, jArr2);
                                    s7.b.e1(jArr2, jArr2);
                                    for (int i14 = 0; i14 < 18; i14++) {
                                        jArr5[i14] = 0;
                                    }
                                    s7.b.t0(w0Var9.f5372g, jArr4, jArr5);
                                    long[] jArr8 = w0Var6.f5372g;
                                    jArr4[0] = jArr8[0] ^ 1;
                                    for (int i15 = 1; i15 < 9; i15++) {
                                        jArr4[i15] = jArr8[i15];
                                    }
                                    s7.b.t0(jArr4, w0Var8.f5372g, jArr5);
                                    s7.b.E0(jArr5, w0Var9.f5372g);
                                    break;
                                }
                            }
                        }
                    }
                }
                break;
        }
        return x().a(rVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p(h hVar, m mVar, m mVar2, m[] mVarArr, int i8) {
        super(hVar, mVar, mVar2, mVarArr);
        this.f4814g = i8;
    }
}
