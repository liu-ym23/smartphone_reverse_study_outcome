package a1;

import a2.p;
import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.room.a0;
import androidx.work.impl.WorkDatabase;
import b0.x;
import com.google.crypto.tink.shaded.protobuf.Reader;
import d2.m;
import h5.r;
import java.io.File;
import java.lang.invoke.VarHandle;
import java.util.UUID;
import jb.v;
import l5.k;
import s1.m0;
import t.d0;
import u0.q;
import u1.c1;
import u1.e0;
import u1.g0;
import u1.h0;
import u1.k0;
import u1.p0;
import u1.t0;
import u1.v1;
import v1.n1;
import v1.o0;
import yb.l;
import yb.u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends l implements xb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f9f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f10g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(x xVar, d2.e eVar, o0 o0Var) {
        super(0);
        this.f8c = 2;
        this.f9f = eVar;
        this.f10g = o0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v51, types: [xb.a, yb.l] */
    /* JADX WARN: Type inference failed for: r0v54, types: [xb.a, yb.l] */
    /* JADX WARN: Type inference failed for: r3v11, types: [xb.a, yb.l] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v2, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v21, types: [xb.a, yb.l] */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [m0.e] */
    @Override // xb.a
    public final Object invoke() {
        d2.g gVarE;
        p pVar;
        g0 g0Var;
        int i = 8;
        int i3 = 0;
        switch (this.f8c) {
            case 0:
                ((c) this.f9f).f13u.invoke((d) this.f10g);
                return v.f6774a;
            case 1:
                x xVar = (x) this.f9f;
                if (xVar != null) {
                    q qVar = xVar.f1797d;
                    if (qVar.isEmpty()) {
                        gVarE = xVar.f1796c;
                    } else {
                        d2.d dVar = new d2.d();
                        dVar.b(xVar.f1794a);
                        b0.p pVar2 = new b0.p();
                        pVar2.f1775a = dVar;
                        VarHandle.storeStoreFence();
                        int size = qVar.size();
                        while (i3 < size) {
                            ((xb.l) qVar.get(i3)).invoke(pVar2);
                            i3++;
                        }
                        gVarE = dVar.e();
                    }
                    xVar.f1796c = gVarE;
                    if (gVarE != null) {
                        return gVarE;
                    }
                }
                return (d2.g) this.f10g;
            case 2:
                m mVar = (m) ((d2.e) this.f9f).f3077a;
                o0 o0Var = (o0) this.f10g;
                if (mVar instanceof d2.l) {
                    try {
                        o0Var.a(((d2.l) mVar).f3137a);
                    } catch (IllegalArgumentException unused) {
                    }
                }
                return v.f6774a;
            case 3:
                ((u) this.f9f).f16098c = ((b1.q) this.f10g).C0();
                return v.f6774a;
            case 4:
                g5.u.d().a(k.f7750a, "NetworkRequestConstraintController unregister callback");
                ((l5.e) this.f9f).f7738a.unregisterNetworkCallback((l5.d) this.f10g);
                return v.f6774a;
            case 5:
                n5.e eVar = ((m5.b) this.f9f).f8240a;
                m5.a aVar = (m5.a) this.f10g;
                eVar.getClass();
                synchronized (eVar.f8767c) {
                    if (eVar.f8768d.remove(aVar) && eVar.f8768d.isEmpty()) {
                        eVar.d();
                    }
                }
                return v.f6774a;
            case 6:
                ((o1.d) this.f9f).d((w0.l) this.f10g);
                return v.f6774a;
            case 7:
                r rVar = (r) this.f9f;
                WorkDatabase workDatabase = rVar.f5372c;
                workDatabase.getClass();
                UUID uuid = (UUID) this.f10g;
                a0 a0Var = new a0(i);
                a0Var.f1506f = rVar;
                a0Var.f1507g = uuid;
                VarHandle.storeStoreFence();
                workDatabase.u(a0Var);
                h5.i.b(rVar.f5371b, rVar.f5372c, rVar.f5374e);
                return v.f6774a;
            case 8:
                String str = (String) this.f9f;
                r rVar2 = (r) this.f10g;
                id.k.r(rVar2, str);
                h5.i.b(rVar2.f5371b, rVar2.f5372c, rVar2.f5374e);
                return v.f6774a;
            case 9:
                return ((o1.f) this.f9f).invoke((WorkDatabase) this.f10g);
            case 10:
                ((u) this.f9f).f16098c = u1.f.h((d0) this.f10g, m0.f11267a);
                return v.f6774a;
            case 11:
                c1 c1Var = ((g0) this.f9f).H;
                u uVar = (u) this.f10g;
                if ((c1Var.f13746f.f15117h & 8) != 0) {
                    for (w0.l lVar = c1Var.f13745e; lVar != null; lVar = lVar.i) {
                        if ((lVar.f15116g & 8) != 0) {
                            u1.m mVarE = lVar;
                            ?? eVar2 = 0;
                            while (mVarE != 0) {
                                if (mVarE instanceof v1) {
                                    v1 v1Var = (v1) mVarE;
                                    if (v1Var.B()) {
                                        a2.k kVar = new a2.k();
                                        uVar.f16098c = kVar;
                                        kVar.f78h = true;
                                    }
                                    if (v1Var.o0()) {
                                        ((a2.k) uVar.f16098c).f77g = true;
                                    }
                                    v1Var.f0((a2.k) uVar.f16098c);
                                } else if ((mVarE.f15116g & 8) != 0 && (mVarE instanceof u1.m)) {
                                    w0.l lVar2 = mVarE.f13866t;
                                    int i10 = 0;
                                    mVarE = mVarE;
                                    eVar2 = eVar2;
                                    while (lVar2 != null) {
                                        if ((lVar2.f15116g & 8) != 0) {
                                            i10++;
                                            eVar2 = eVar2;
                                            if (i10 == 1) {
                                                mVarE = lVar2;
                                            } else {
                                                if (eVar2 == 0) {
                                                    eVar2 = new m0.e(new w0.l[16]);
                                                }
                                                if (mVarE != 0) {
                                                    eVar2.b(mVarE);
                                                    mVarE = 0;
                                                }
                                                eVar2.b(lVar2);
                                            }
                                        }
                                        lVar2 = lVar2.f15118j;
                                        mVarE = mVarE;
                                        eVar2 = eVar2;
                                    }
                                    if (i10 == 1) {
                                    }
                                }
                                mVarE = u1.f.e(eVar2);
                            }
                        }
                    }
                }
                return v.f6774a;
            case 12:
                t0 t0Var = (t0) this.f9f;
                k0 k0Var = t0Var.f13921j;
                k0Var.f13850h = 0;
                m0.e eVarX = k0Var.f13843a.x();
                Object[] objArr = eVarX.f8158c;
                int i11 = eVarX.f8160g;
                for (int i12 = 0; i12 < i11; i12++) {
                    t0 t0Var2 = ((g0) objArr[i12]).I.f13858q;
                    t0Var2.getClass();
                    t0Var2.f13923l = t0Var2.f13924m;
                    t0Var2.f13924m = Reader.READ_DONE;
                    if (t0Var2.f13925n == e0.f13766f) {
                        t0Var2.f13925n = e0.f13767g;
                    }
                }
                g0 g0Var2 = k0Var.f13843a;
                g0 g0Var3 = k0Var.f13843a;
                m0.e eVarX2 = g0Var2.x();
                Object[] objArr2 = eVarX2.f8158c;
                int i13 = eVarX2.f8160g;
                for (int i14 = 0; i14 < i13; i14++) {
                    t0 t0Var3 = ((g0) objArr2[i14]).I.f13858q;
                    t0Var3.getClass();
                    t0Var3.f13933v.f13825d = false;
                }
                u1.r rVar3 = t0Var.f().S;
                if (rVar3 != null) {
                    boolean z10 = rVar3.f13882o;
                    m0.b bVar = (m0.b) g0Var3.m();
                    int i15 = bVar.f8152c.f8160g;
                    for (int i16 = 0; i16 < i15; i16++) {
                        p0 p0VarF0 = ((g0) bVar.get(i16)).H.f13744d.F0();
                        if (p0VarF0 != null) {
                            p0VarF0.f13882o = z10;
                        }
                    }
                }
                ((p0) this.f10g).p0().c();
                if (t0Var.f().S != null) {
                    m0.b bVar2 = (m0.b) g0Var3.m();
                    int i17 = bVar2.f8152c.f8160g;
                    for (int i18 = 0; i18 < i17; i18++) {
                        p0 p0VarF02 = ((g0) bVar2.get(i18)).H.f13744d.F0();
                        if (p0VarF02 != null) {
                            p0VarF02.f13882o = false;
                        }
                    }
                }
                m0.e eVarX3 = g0Var3.x();
                Object[] objArr3 = eVarX3.f8158c;
                int i19 = eVarX3.f8160g;
                for (int i20 = 0; i20 < i19; i20++) {
                    t0 t0Var4 = ((g0) objArr3[i20]).I.f13858q;
                    t0Var4.getClass();
                    int i21 = t0Var4.f13923l;
                    int i22 = t0Var4.f13924m;
                    if (i21 != i22 && i22 == Integer.MAX_VALUE) {
                        t0Var4.Z(true);
                    }
                }
                m0.e eVarX4 = g0Var3.x();
                Object[] objArr4 = eVarX4.f8158c;
                int i23 = eVarX4.f8160g;
                while (i3 < i23) {
                    t0 t0Var5 = ((g0) objArr4[i3]).I.f13858q;
                    t0Var5.getClass();
                    h0 h0Var = t0Var5.f13933v;
                    h0Var.f13826e = h0Var.f13825d;
                    i3++;
                }
                return v.f6774a;
            case 13:
                return Boolean.valueOf(super/*android.view.ViewGroup*/.dispatchKeyEvent((KeyEvent) this.f10g));
            case 14:
                return Boolean.valueOf(super/*android.view.View*/.dispatchGenericMotionEvent((MotionEvent) this.f10g));
            case 15:
                v1.a0 a0Var2 = (v1.a0) this.f10g;
                n1 n1Var = (n1) this.f9f;
                a2.h hVar = n1Var.i;
                a2.h hVar2 = n1Var.f14515j;
                Float f5 = n1Var.f14513g;
                Float f10 = n1Var.f14514h;
                float fFloatValue = (hVar == null || f5 == null) ? 0.0f : ((Number) hVar.f46a.invoke()).floatValue() - f5.floatValue();
                float fFloatValue2 = (hVar2 == null || f10 == null) ? 0.0f : ((Number) hVar2.f46a.invoke()).floatValue() - f10.floatValue();
                if (fFloatValue != 0.0f || fFloatValue2 != 0.0f) {
                    int iR = a0Var2.r(n1Var.f14511c);
                    a2.q qVar2 = (a2.q) a0Var2.k().b(a0Var2.f14340k);
                    if (qVar2 != null) {
                        try {
                            o3.e eVar3 = a0Var2.f14342m;
                            if (eVar3 != null) {
                                eVar3.f9149a.setBoundsInScreen(a0Var2.b(qVar2));
                            }
                        } catch (IllegalStateException unused2) {
                        }
                    }
                    a2.q qVar3 = (a2.q) a0Var2.k().b(a0Var2.f14341l);
                    if (qVar3 != null) {
                        try {
                            o3.e eVar4 = a0Var2.f14343n;
                            if (eVar4 != null) {
                                eVar4.f9149a.setBoundsInScreen(a0Var2.b(qVar3));
                            }
                        } catch (IllegalStateException unused3) {
                        }
                    }
                    a0Var2.f14331a.invalidate();
                    a2.q qVar4 = (a2.q) a0Var2.k().b(iR);
                    if (qVar4 != null && (pVar = qVar4.f92a) != null && (g0Var = pVar.f87c) != null) {
                        if (hVar != null) {
                            a0Var2.f14345p.h(iR, hVar);
                        }
                        if (hVar2 != null) {
                            a0Var2.f14346q.h(iR, hVar2);
                        }
                        a0Var2.n(g0Var);
                    }
                }
                if (hVar != null) {
                    n1Var.f14513g = (Float) hVar.f46a.invoke();
                }
                if (hVar2 != null) {
                    n1Var.f14514h = (Float) hVar2.f46a.invoke();
                }
                return v.f6774a;
            default:
                return new File(((Context) this.f9f).getApplicationContext().getFilesDir(), "datastore/".concat(((x3.b) this.f10g).f15568a.concat(".preferences_pb")));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(int i, Object obj, Object obj2) {
        super(0);
        this.f8c = i;
        this.f9f = obj;
        this.f10g = obj2;
    }
}
