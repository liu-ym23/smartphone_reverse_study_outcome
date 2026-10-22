package b0;

import android.graphics.Matrix;
import android.graphics.Path;
import androidx.compose.ui.input.pointer.PointerHoverIconModifierElement;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import d2.e0;
import d2.i0;
import d2.j0;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import k0.c1;
import k0.k1;
import k0.v1;
import v1.a1;
import v1.o0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public d2.g f1794a;

    /* renamed from: b, reason: collision with root package name */
    public k1 f1795b;

    /* renamed from: c, reason: collision with root package name */
    public d2.g f1796c;

    /* renamed from: d, reason: collision with root package name */
    public u0.q f1797d;

    public final void a(int i, k0.s sVar) {
        i0 i0Var;
        d1.h hVarG;
        o0 o0Var;
        v vVar;
        int i3;
        e0 e0Var;
        w0.m mVarG;
        sVar.Z(1154651354);
        int i10 = 2;
        int i11 = i | (sVar.h(this) ? 4 : 2);
        if ((i11 & 3) == 2 && sVar.B()) {
            sVar.S();
        } else {
            o0 o0Var2 = (o0) sVar.j(a1.f14372r);
            d2.g gVar = this.f1796c;
            List listA = gVar.a(gVar.f3101f.length());
            int size = listA.size();
            int i12 = 0;
            while (i12 < size) {
                d2.e eVar = (d2.e) listA.get(i12);
                if (((Boolean) new i(this, i10).invoke()).booleanValue() && (i0Var = (i0) this.f1795b.getValue()) != null) {
                    int i13 = eVar.f3078b;
                    int i14 = eVar.f3079c;
                    hVarG = i0Var.g(i13, i14);
                    c1.c cVarA = i0Var.a(i13);
                    long jD = id.k.d(i0Var.b(i13) == i0Var.b(i14) ? Math.min(i0Var.a(i14 - 1).f2167a, cVarA.f2167a) : 0.0f, cVarA.f2168b) ^ (-9223372034707292160L);
                    Matrix matrix = hVarG.f2993d;
                    if (matrix == null) {
                        hVarG.f2993d = new Matrix();
                    } else {
                        matrix.reset();
                    }
                    Matrix matrix2 = hVarG.f2993d;
                    matrix2.getClass();
                    o0Var = o0Var2;
                    matrix2.setTranslate(Float.intBitsToFloat((int) (jD >> 32)), Float.intBitsToFloat((int) (jD & 4294967295L)));
                    Path path = hVarG.f2990a;
                    Matrix matrix3 = hVarG.f2993d;
                    matrix3.getClass();
                    path.transform(matrix3);
                } else {
                    o0Var = o0Var2;
                    hVarG = null;
                }
                if (hVarG != null) {
                    vVar = new v();
                    vVar.f1792a = hVarG;
                    VarHandle.storeStoreFence();
                } else {
                    vVar = null;
                }
                w0.m mVar = w0.j.f15113c;
                if (vVar != null && (mVarG = com.stepos.statsrpk.h.g(mVar, vVar)) != null) {
                    mVar = mVarG;
                }
                Object objM = sVar.M();
                Object obj = k0.m.f6974a;
                if (objM == obj) {
                    objM = t0.a.a();
                    sVar.i0(objM);
                }
                v.k kVar = (v.k) objM;
                int i15 = eVar.f3078b;
                Object obj2 = eVar.f3077a;
                int i16 = eVar.f3079c;
                q qVar = new q();
                qVar.f1776a = this;
                qVar.f1777b = i15;
                qVar.f1778c = i16;
                VarHandle.storeStoreFence();
                a0 a0Var = new a0();
                a0Var.f1712c = qVar;
                VarHandle.storeStoreFence();
                w0.m mVarG2 = androidx.compose.foundation.a.g(mVar.d(a0Var), kVar);
                o1.o.f9066a.getClass();
                o1.a aVar = o1.q.f9068b;
                PointerHoverIconModifierElement pointerHoverIconModifierElement = new PointerHoverIconModifierElement();
                pointerHoverIconModifierElement.f968c = aVar;
                VarHandle.storeStoreFence();
                w0.m mVarD = mVarG2.d(pointerHoverIconModifierElement);
                o0Var2 = o0Var;
                boolean zH = sVar.h(this) | sVar.f(eVar) | sVar.h(o0Var2);
                Object objM2 = sVar.M();
                if (zH || objM2 == obj) {
                    objM2 = new a1.b(this, eVar, o0Var2);
                    sVar.i0(objM2);
                }
                w.p.a(androidx.compose.foundation.a.f(mVarD, kVar, (xb.a) objM2), sVar, 0);
                Object objM3 = sVar.M();
                if (objM3 == obj) {
                    objM3 = k0.z.v(Boolean.FALSE);
                    sVar.i0(objM3);
                }
                c1 c1Var = (c1) objM3;
                Object objM4 = sVar.M();
                if (objM4 == obj) {
                    objM4 = new v.g(kVar, c1Var, null, 1);
                    sVar.i0(objM4);
                }
                k0.z.h(kVar, sVar, (xb.p) objM4);
                Object objM5 = sVar.M();
                if (objM5 == obj) {
                    objM5 = k0.z.v(Boolean.FALSE);
                    sVar.i0(objM5);
                }
                c1 c1Var2 = (c1) objM5;
                Object objM6 = sVar.M();
                if (objM6 == obj) {
                    i3 = i11;
                    objM6 = new v.g(kVar, c1Var2, null, 0);
                    e0Var = null;
                    sVar.i0(objM6);
                } else {
                    i3 = i11;
                    e0Var = null;
                }
                k0.z.h(kVar, sVar, (xb.p) objM6);
                c1 c1VarC = t1.e.c(kVar, sVar);
                Boolean bool = (Boolean) c1Var.getValue();
                bool.getClass();
                Boolean bool2 = (Boolean) c1Var2.getValue();
                bool2.getClass();
                Boolean bool3 = (Boolean) c1VarC.getValue();
                bool3.getClass();
                d2.m mVar2 = (d2.m) obj2;
                j0 j0VarA = mVar2.a();
                e0 e0Var2 = j0VarA != null ? j0VarA.f3128a : e0Var;
                j0 j0VarA2 = mVar2.a();
                e0 e0Var3 = j0VarA2 != null ? j0VarA2.f3129b : e0Var;
                j0 j0VarA3 = mVar2.a();
                e0 e0Var4 = j0VarA3 != null ? j0VarA3.f3130c : e0Var;
                j0 j0VarA4 = mVar2.a();
                if (j0VarA4 != null) {
                    e0Var = j0VarA4.f3131d;
                }
                Object[] objArr = {bool, bool2, bool3, e0Var2, e0Var3, e0Var4, e0Var};
                boolean zH2 = sVar.h(this) | sVar.f(eVar) | sVar.f(c1Var2) | sVar.f(c1Var) | sVar.f(c1VarC);
                Object objM7 = sVar.M();
                if (zH2 || objM7 == obj) {
                    Object rVar = new r(this, eVar, c1Var2, c1Var, c1VarC);
                    sVar.i0(rVar);
                    objM7 = rVar;
                }
                b(objArr, (xb.l) objM7, sVar, (i3 << 6) & 896);
                i12++;
                i11 = i3;
                i10 = 2;
            }
        }
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new s(i, 0, this);
        }
    }

    public final void b(Object[] objArr, xb.l lVar, k0.s sVar, int i) {
        sVar.Z(-2083052099);
        int i3 = (i & 48) == 0 ? (sVar.h(lVar) ? 32 : 16) | i : i;
        if ((i & 384) == 0) {
            i3 |= sVar.h(this) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128;
        }
        sVar.T(Integer.valueOf(objArr.length), -416717687, 0, null);
        for (Object obj : objArr) {
            i3 |= sVar.h(obj) ? 4 : 0;
        }
        sVar.q(false);
        if ((i3 & 14) == 0) {
            i3 |= 2;
        }
        if ((i3 & 147) == 146 && sVar.B()) {
            sVar.S();
        } else {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(lVar);
            if (objArr.length > 0) {
                arrayList.ensureCapacity(arrayList.size() + objArr.length);
                Collections.addAll(arrayList, objArr);
            }
            Object[] array = arrayList.toArray(new Object[arrayList.size()]);
            boolean zH = sVar.h(this) | ((i3 & 112) == 32);
            Object objM = sVar.M();
            if (zH || objM == k0.m.f6974a) {
                objM = new h(this, lVar, 1);
                sVar.i0(objM);
            }
            k0.z.e(array, (xb.l) objM, sVar);
        }
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new u(this, objArr, lVar, i, 0);
        }
    }
}
