package kotlin.reflect.jvm.internal.impl.types.checker;

import Z8.C1174w;
import Z8.F;
import h9.InterfaceC4149a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import ya.AbstractC5990d0;
import ya.C5977L;
import ya.C5982Q;
import ya.C5998h0;
import ya.C6017x;
import ya.K0;
import ya.S;
import ya.m0;
import ya.s0;
import za.C6459e;
import za.C6466l;
import za.C6474t;

/* loaded from: classes5.dex */
public final class TypeIntersector {

    /* renamed from: a, reason: collision with root package name */
    public static final TypeIntersector f36097a = new TypeIntersector();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class ResultNullability {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ ResultNullability[] $VALUES;
        public static final ResultNullability START = new START("START", 0);
        public static final ResultNullability ACCEPT_NULL = new ACCEPT_NULL("ACCEPT_NULL", 1);
        public static final ResultNullability UNKNOWN = new UNKNOWN("UNKNOWN", 2);
        public static final ResultNullability NOT_NULL = new NOT_NULL("NOT_NULL", 3);

        public static final class ACCEPT_NULL extends ResultNullability {
            public ACCEPT_NULL(String str, int i10) {
                super(str, i10, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public ResultNullability combine(K0 nextType) {
                p.i(nextType, "nextType");
                return getResultNullability(nextType);
            }
        }

        public static final class NOT_NULL extends ResultNullability {
            public NOT_NULL(String str, int i10) {
                super(str, i10, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public NOT_NULL combine(K0 nextType) {
                p.i(nextType, "nextType");
                return this;
            }
        }

        public static final class START extends ResultNullability {
            public START(String str, int i10) {
                super(str, i10, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public ResultNullability combine(K0 nextType) {
                p.i(nextType, "nextType");
                return getResultNullability(nextType);
            }
        }

        public static final class UNKNOWN extends ResultNullability {
            public UNKNOWN(String str, int i10) {
                super(str, i10, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public ResultNullability combine(K0 nextType) {
                p.i(nextType, "nextType");
                ResultNullability resultNullability = getResultNullability(nextType);
                return resultNullability == ResultNullability.ACCEPT_NULL ? this : resultNullability;
            }
        }

        private static final /* synthetic */ ResultNullability[] $values() {
            return new ResultNullability[]{START, ACCEPT_NULL, UNKNOWN, NOT_NULL};
        }

        static {
            ResultNullability[] resultNullabilityArr$values = $values();
            $VALUES = resultNullabilityArr$values;
            $ENTRIES = kotlin.enums.a.a(resultNullabilityArr$values);
        }

        public /* synthetic */ ResultNullability(String str, int i10, i iVar) {
            this(str, i10);
        }

        public static ResultNullability valueOf(String str) {
            return (ResultNullability) Enum.valueOf(ResultNullability.class, str);
        }

        public static ResultNullability[] values() {
            return (ResultNullability[]) $VALUES.clone();
        }

        public abstract ResultNullability combine(K0 k02);

        public final ResultNullability getResultNullability(K0 k02) {
            p.i(k02, "<this>");
            if (k02.I0()) {
                return ACCEPT_NULL;
            }
            if ((k02 instanceof C6017x) && (((C6017x) k02).T0() instanceof m0)) {
                return NOT_NULL;
            }
            if (!(k02 instanceof m0) && C6466l.f45420a.a(k02)) {
                return NOT_NULL;
            }
            return UNKNOWN;
        }

        private ResultNullability(String str, int i10) {
        }
    }

    public static final String f(Set set) {
        return "This collections cannot be empty! input types: " + F.A0(set, null, null, null, 0, null, null, 63, null);
    }

    public final Collection<AbstractC5990d0> c(Collection<? extends AbstractC5990d0> collection, p9.p<? super AbstractC5990d0, ? super AbstractC5990d0, Boolean> pVar) {
        ArrayList arrayList = new ArrayList(collection);
        Iterator it = arrayList.iterator();
        p.h(it, "iterator(...)");
        while (it.hasNext()) {
            AbstractC5990d0 abstractC5990d0 = (AbstractC5990d0) it.next();
            if (!arrayList.isEmpty()) {
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    AbstractC5990d0 abstractC5990d02 = (AbstractC5990d0) it2.next();
                    if (abstractC5990d02 != abstractC5990d0) {
                        p.f(abstractC5990d02);
                        p.f(abstractC5990d0);
                        if (pVar.invoke(abstractC5990d02, abstractC5990d0).booleanValue()) {
                            it.remove();
                            break;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public final AbstractC5990d0 d(List<? extends AbstractC5990d0> types) {
        p.i(types, "types");
        types.size();
        ArrayList<AbstractC5990d0> arrayList = new ArrayList();
        for (AbstractC5990d0 abstractC5990d0 : types) {
            if (abstractC5990d0.H0() instanceof C5982Q) {
                Collection<S> collectionE = abstractC5990d0.H0().e();
                p.h(collectionE, "getSupertypes(...)");
                Collection<S> collection = collectionE;
                ArrayList arrayList2 = new ArrayList(C1174w.x(collection, 10));
                for (S s10 : collection) {
                    p.f(s10);
                    AbstractC5990d0 abstractC5990d0D = C5977L.d(s10);
                    if (abstractC5990d0.I0()) {
                        abstractC5990d0D = abstractC5990d0D.L0(true);
                    }
                    arrayList2.add(abstractC5990d0D);
                }
                arrayList.addAll(arrayList2);
            } else {
                arrayList.add(abstractC5990d0);
            }
        }
        ResultNullability resultNullabilityCombine = ResultNullability.START;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            resultNullabilityCombine = resultNullabilityCombine.combine((K0) it.next());
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (AbstractC5990d0 abstractC5990d0I : arrayList) {
            if (resultNullabilityCombine == ResultNullability.NOT_NULL) {
                if (abstractC5990d0I instanceof C6459e) {
                    abstractC5990d0I = C5998h0.k((C6459e) abstractC5990d0I);
                }
                abstractC5990d0I = C5998h0.i(abstractC5990d0I, false, 1, null);
            }
            linkedHashSet.add(abstractC5990d0I);
        }
        List<? extends AbstractC5990d0> list = types;
        ArrayList arrayList3 = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((AbstractC5990d0) it2.next()).G0());
        }
        Iterator it3 = arrayList3.iterator();
        if (!it3.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        Object next = it3.next();
        while (it3.hasNext()) {
            next = ((s0) next).m((s0) it3.next());
        }
        return e(linkedHashSet).N0((s0) next);
    }

    public final AbstractC5990d0 e(Set<? extends AbstractC5990d0> set) {
        if (set.size() == 1) {
            return (AbstractC5990d0) F.W0(set);
        }
        new C6474t(set);
        Set<? extends AbstractC5990d0> set2 = set;
        Collection<AbstractC5990d0> collectionC = c(set2, new TypeIntersector$intersectTypesWithoutIntersectionType$filteredEqualTypes$1(this));
        collectionC.isEmpty();
        AbstractC5990d0 abstractC5990d0B = IntegerLiteralTypeConstructor.f35995f.b(collectionC);
        if (abstractC5990d0B != null) {
            return abstractC5990d0B;
        }
        Collection<AbstractC5990d0> collectionC2 = c(collectionC, new TypeIntersector$intersectTypesWithoutIntersectionType$filteredSuperAndEqualTypes$1(e.f36100b.a()));
        collectionC2.isEmpty();
        return collectionC2.size() < 2 ? (AbstractC5990d0) F.W0(collectionC2) : new C5982Q(set2).l();
    }

    public final boolean g(S s10, S s11) {
        f fVarA = e.f36100b.a();
        return fVarA.b(s10, s11) && !fVarA.b(s11, s10);
    }
}
