package kotlin.reflect.jvm.internal.impl.types.checker;

import Ca.g;
import Z8.C1173v;
import Z8.C1174w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import la.C4880c;
import ma.r;
import ya.AbstractC5974I;
import ya.AbstractC5990d0;
import ya.AbstractC6010p;
import ya.B0;
import ya.C5982Q;
import ya.H0;
import ya.J0;
import ya.K0;
import ya.S;
import ya.V;
import ya.v0;
import za.C6459e;
import za.C6464j;

/* loaded from: classes5.dex */
public abstract class KotlinTypePreparator extends AbstractC6010p {

    public static final class a extends KotlinTypePreparator {

        /* renamed from: a, reason: collision with root package name */
        public static final a f36096a = new a();
    }

    @Override // ya.AbstractC6010p
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public K0 a(g type) {
        K0 k0E;
        p.i(type, "type");
        if (!(type instanceof S)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        K0 K02 = ((S) type).K0();
        if (K02 instanceof AbstractC5990d0) {
            k0E = c((AbstractC5990d0) K02);
        } else {
            if (!(K02 instanceof AbstractC5974I)) {
                throw new NoWhenBranchMatchedException();
            }
            AbstractC5974I abstractC5974I = (AbstractC5974I) K02;
            AbstractC5990d0 abstractC5990d0C = c(abstractC5974I.P0());
            AbstractC5990d0 abstractC5990d0C2 = c(abstractC5974I.Q0());
            k0E = (abstractC5990d0C == abstractC5974I.P0() && abstractC5990d0C2 == abstractC5974I.Q0()) ? K02 : V.e(abstractC5990d0C, abstractC5990d0C2);
        }
        return J0.c(k0E, K02, new KotlinTypePreparator$prepareType$1(this));
    }

    public final AbstractC5990d0 c(AbstractC5990d0 abstractC5990d0) {
        S type;
        v0 v0VarH0 = abstractC5990d0.H0();
        C5982Q c5982qT = null;
        K0 = null;
        K0 K02 = null;
        if (v0VarH0 instanceof C4880c) {
            C4880c c4880c = (C4880c) v0VarH0;
            B0 b0C = c4880c.c();
            if (b0C.c() != Variance.IN_VARIANCE) {
                b0C = null;
            }
            if (b0C != null && (type = b0C.getType()) != null) {
                K02 = type.K0();
            }
            K0 k02 = K02;
            if (c4880c.i() == null) {
                B0 b0C2 = c4880c.c();
                Collection<S> collectionE = c4880c.e();
                ArrayList arrayList = new ArrayList(C1174w.x(collectionE, 10));
                Iterator<T> it = collectionE.iterator();
                while (it.hasNext()) {
                    arrayList.add(((S) it.next()).K0());
                }
                c4880c.k(new C6464j(b0C2, arrayList, null, 4, null));
            }
            CaptureStatus captureStatus = CaptureStatus.FOR_SUBTYPING;
            C6464j c6464jI = c4880c.i();
            p.f(c6464jI);
            return new C6459e(captureStatus, c6464jI, k02, abstractC5990d0.G0(), abstractC5990d0.I0(), false, 32, null);
        }
        boolean z10 = false;
        if (v0VarH0 instanceof r) {
            Collection<S> collectionE2 = ((r) v0VarH0).e();
            ArrayList arrayList2 = new ArrayList(C1174w.x(collectionE2, 10));
            Iterator<T> it2 = collectionE2.iterator();
            while (it2.hasNext()) {
                S sP = H0.p((S) it2.next(), abstractC5990d0.I0());
                p.h(sP, "makeNullableAsSpecified(...)");
                arrayList2.add(sP);
            }
            return V.o(abstractC5990d0.G0(), new C5982Q(arrayList2), C1173v.m(), false, abstractC5990d0.m());
        }
        if (!(v0VarH0 instanceof C5982Q) || !abstractC5990d0.I0()) {
            return abstractC5990d0;
        }
        C5982Q c5982q = (C5982Q) v0VarH0;
        Collection<S> collectionE3 = c5982q.e();
        ArrayList arrayList3 = new ArrayList(C1174w.x(collectionE3, 10));
        Iterator<T> it3 = collectionE3.iterator();
        while (it3.hasNext()) {
            arrayList3.add(Da.d.B((S) it3.next()));
            z10 = true;
        }
        if (z10) {
            S sN = c5982q.n();
            c5982qT = new C5982Q(arrayList3).t(sN != null ? Da.d.B(sN) : null);
        }
        if (c5982qT != null) {
            c5982q = c5982qT;
        }
        return c5982q.l();
    }
}
