package C9;

import E9.C0810o;
import E9.W;
import H9.C0837p;
import H9.G;
import H9.U;
import Z8.C1172u;
import Z8.C1174w;
import Z8.F;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import xa.InterfaceC5869l;
import ya.AbstractC5990d0;
import ya.B0;
import ya.S;
import ya.V;
import ya.s0;
import ya.v0;

/* loaded from: classes5.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public static final G f1946a;

    static {
        C0837p c0837p = new C0837p(Aa.i.f1351a.i(), o.f1838s);
        ClassKind classKind = ClassKind.INTERFACE;
        ga.e eVarF = o.f1842w.f();
        W w10 = W.f2444a;
        InterfaceC5869l interfaceC5869l = LockBasedStorageManager.f36050e;
        G g10 = new G(c0837p, classKind, false, false, eVarF, w10, interfaceC5869l);
        g10.G0(Modality.ABSTRACT);
        g10.I0(C0810o.f2473e);
        g10.H0(C1172u.e(U.L0(g10, F9.g.f2609m0.b(), false, Variance.IN_VARIANCE, ga.e.j(ExifInterface.GPS_DIRECTION_TRUE), 0, interfaceC5869l)));
        g10.E0();
        f1946a = g10;
    }

    public static final AbstractC5990d0 a(S suspendFunType) {
        kotlin.jvm.internal.p.i(suspendFunType, "suspendFunType");
        i.s(suspendFunType);
        j jVarN = Da.d.n(suspendFunType);
        F9.g annotations = suspendFunType.getAnnotations();
        S sK = i.k(suspendFunType);
        List<S> listE = i.e(suspendFunType);
        List<B0> listM = i.m(suspendFunType);
        ArrayList arrayList = new ArrayList(C1174w.x(listM, 10));
        Iterator<T> it = listM.iterator();
        while (it.hasNext()) {
            arrayList.add(((B0) it.next()).getType());
        }
        s0 s0VarK = s0.f44124b.k();
        v0 v0VarJ = f1946a.j();
        kotlin.jvm.internal.p.h(v0VarJ, "getTypeConstructor(...)");
        List listT0 = F.T0(arrayList, V.m(s0VarK, v0VarJ, C1172u.e(Da.d.d(i.l(suspendFunType))), false, null, 16, null));
        AbstractC5990d0 abstractC5990d0J = Da.d.n(suspendFunType).J();
        kotlin.jvm.internal.p.h(abstractC5990d0J, "getNullableAnyType(...)");
        return i.b(jVarN, annotations, sK, listE, listT0, null, abstractC5990d0J, (128 & 128) != 0 ? false : false).L0(suspendFunType.I0());
    }
}
