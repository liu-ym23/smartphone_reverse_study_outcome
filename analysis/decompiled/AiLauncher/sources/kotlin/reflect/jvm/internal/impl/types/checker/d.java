package kotlin.reflect.jvm.internal.impl.types.checker;

import E9.b0;
import Z8.C1174w;
import Z8.F;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import ya.AbstractC5990d0;
import ya.B0;
import ya.K0;
import ya.S;
import ya.V;
import ya.w0;
import za.C6459e;

/* loaded from: classes5.dex */
public final class d {
    public static final List<B0> a(K0 k02, CaptureStatus captureStatus) {
        if (k02.F0().size() != k02.H0().getParameters().size()) {
            return null;
        }
        List<B0> listF0 = k02.F0();
        List<B0> list = listF0;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((B0) it.next()).c() != Variance.INVARIANT) {
                    List<b0> parameters = k02.H0().getParameters();
                    p.h(parameters, "getParameters(...)");
                    List<Pair> listW1 = F.w1(list, parameters);
                    ArrayList arrayList = new ArrayList(C1174w.x(listW1, 10));
                    for (Pair pair : listW1) {
                        B0 b0D = (B0) pair.a();
                        b0 b0Var = (b0) pair.b();
                        if (b0D.c() != Variance.INVARIANT) {
                            K0 K02 = (b0D.b() || b0D.c() != Variance.IN_VARIANCE) ? null : b0D.getType().K0();
                            p.f(b0Var);
                            b0D = Da.d.d(new C6459e(captureStatus, K02, b0D, b0Var));
                        }
                        arrayList.add(b0D);
                    }
                    TypeSubstitutor typeSubstitutorC = w0.f44131c.b(k02.H0(), arrayList).c();
                    int size = listF0.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        B0 b02 = listF0.get(i10);
                        B0 b03 = (B0) arrayList.get(i10);
                        if (b02.c() != Variance.INVARIANT) {
                            List<S> upperBounds = k02.H0().getParameters().get(i10).getUpperBounds();
                            p.h(upperBounds, "getUpperBounds(...)");
                            ArrayList arrayList2 = new ArrayList();
                            Iterator<T> it2 = upperBounds.iterator();
                            while (it2.hasNext()) {
                                arrayList2.add(KotlinTypePreparator.a.f36096a.a(typeSubstitutorC.o((S) it2.next(), Variance.INVARIANT).K0()));
                            }
                            if (!b02.b() && b02.c() == Variance.OUT_VARIANCE) {
                                arrayList2.add(KotlinTypePreparator.a.f36096a.a(b02.getType().K0()));
                            }
                            S type = b03.getType();
                            p.g(type, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedType");
                            ((C6459e) type).H0().p(arrayList2);
                        }
                    }
                    return arrayList;
                }
            }
        }
        return null;
    }

    public static final AbstractC5990d0 b(AbstractC5990d0 type, CaptureStatus status) {
        p.i(type, "type");
        p.i(status, "status");
        List<B0> listA = a(type, status);
        if (listA != null) {
            return c(type, listA);
        }
        return null;
    }

    public static final AbstractC5990d0 c(K0 k02, List<? extends B0> list) {
        return V.m(k02.G0(), k02.H0(), list, k02.I0(), null, 16, null);
    }
}
