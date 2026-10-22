package kotlin.reflect.jvm.internal.impl.resolve.constants;

import C9.j;
import E9.InterfaceC0799d;
import E9.InterfaceC0819y;
import E9.b0;
import Y8.h;
import Z8.C1172u;
import Z8.C1173v;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import h9.InterfaceC4149a;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.C4848b;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.c;
import ma.o;
import ma.v;
import ya.AbstractC5990d0;
import ya.D0;
import ya.F0;
import ya.S;
import ya.V;
import ya.s0;
import ya.v0;

/* loaded from: classes5.dex */
public final class IntegerLiteralTypeConstructor implements v0 {

    /* renamed from: f, reason: collision with root package name */
    public static final Companion f35995f = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    public final long f35996a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0819y f35997b;

    /* renamed from: c, reason: collision with root package name */
    public final Set<S> f35998c;

    /* renamed from: d, reason: collision with root package name */
    public final AbstractC5990d0 f35999d;

    /* renamed from: e, reason: collision with root package name */
    public final h f36000e;

    public static final class Companion {

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        public static final class Mode {
            private static final /* synthetic */ InterfaceC4149a $ENTRIES;
            private static final /* synthetic */ Mode[] $VALUES;
            public static final Mode COMMON_SUPER_TYPE = new Mode("COMMON_SUPER_TYPE", 0);
            public static final Mode INTERSECTION_TYPE = new Mode("INTERSECTION_TYPE", 1);

            private static final /* synthetic */ Mode[] $values() {
                return new Mode[]{COMMON_SUPER_TYPE, INTERSECTION_TYPE};
            }

            static {
                Mode[] modeArr$values = $values();
                $VALUES = modeArr$values;
                $ENTRIES = kotlin.enums.a.a(modeArr$values);
            }

            private Mode(String str, int i10) {
            }

            public static Mode valueOf(String str) {
                return (Mode) Enum.valueOf(Mode.class, str);
            }

            public static Mode[] values() {
                return (Mode[]) $VALUES.clone();
            }
        }

        public static final /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f36001a;

            static {
                int[] iArr = new int[Mode.values().length];
                try {
                    iArr[Mode.COMMON_SUPER_TYPE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Mode.INTERSECTION_TYPE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f36001a = iArr;
            }
        }

        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final AbstractC5990d0 a(Collection<? extends AbstractC5990d0> collection, Mode mode) {
            if (collection.isEmpty()) {
                return null;
            }
            Iterator<T> it = collection.iterator();
            if (!it.hasNext()) {
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
            Object next = it.next();
            while (it.hasNext()) {
                AbstractC5990d0 abstractC5990d0 = (AbstractC5990d0) it.next();
                next = IntegerLiteralTypeConstructor.f35995f.e((AbstractC5990d0) next, abstractC5990d0, mode);
            }
            return (AbstractC5990d0) next;
        }

        public final AbstractC5990d0 b(Collection<? extends AbstractC5990d0> types) {
            p.i(types, "types");
            return a(types, Mode.INTERSECTION_TYPE);
        }

        public final AbstractC5990d0 c(IntegerLiteralTypeConstructor integerLiteralTypeConstructor, IntegerLiteralTypeConstructor integerLiteralTypeConstructor2, Mode mode) {
            Set setW0;
            int i10 = a.f36001a[mode.ordinal()];
            if (i10 == 1) {
                setW0 = F.w0(integerLiteralTypeConstructor.l(), integerLiteralTypeConstructor2.l());
            } else {
                if (i10 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                setW0 = F.s1(integerLiteralTypeConstructor.l(), integerLiteralTypeConstructor2.l());
            }
            return V.f(s0.f44124b.k(), new IntegerLiteralTypeConstructor(integerLiteralTypeConstructor.f35996a, integerLiteralTypeConstructor.f35997b, setW0, null), false);
        }

        public final AbstractC5990d0 d(IntegerLiteralTypeConstructor integerLiteralTypeConstructor, AbstractC5990d0 abstractC5990d0) {
            if (integerLiteralTypeConstructor.l().contains(abstractC5990d0)) {
                return abstractC5990d0;
            }
            return null;
        }

        public final AbstractC5990d0 e(AbstractC5990d0 abstractC5990d0, AbstractC5990d0 abstractC5990d02, Mode mode) {
            if (abstractC5990d0 != null && abstractC5990d02 != null) {
                v0 v0VarH0 = abstractC5990d0.H0();
                v0 v0VarH02 = abstractC5990d02.H0();
                boolean z10 = v0VarH0 instanceof IntegerLiteralTypeConstructor;
                if (z10 && (v0VarH02 instanceof IntegerLiteralTypeConstructor)) {
                    return c((IntegerLiteralTypeConstructor) v0VarH0, (IntegerLiteralTypeConstructor) v0VarH02, mode);
                }
                if (z10) {
                    return d((IntegerLiteralTypeConstructor) v0VarH0, abstractC5990d02);
                }
                if (v0VarH02 instanceof IntegerLiteralTypeConstructor) {
                    return d((IntegerLiteralTypeConstructor) v0VarH02, abstractC5990d0);
                }
            }
            return null;
        }

        public Companion() {
        }
    }

    public /* synthetic */ IntegerLiteralTypeConstructor(long j10, InterfaceC0819y interfaceC0819y, Set set, i iVar) {
        this(j10, interfaceC0819y, set);
    }

    private final List<S> m() {
        return (List) this.f36000e.getValue();
    }

    public static final List o(IntegerLiteralTypeConstructor integerLiteralTypeConstructor) {
        AbstractC5990d0 abstractC5990d0N = integerLiteralTypeConstructor.g().y().n();
        p.h(abstractC5990d0N, "getDefaultType(...)");
        List listS = C1173v.s(F0.f(abstractC5990d0N, C1172u.e(new D0(Variance.IN_VARIANCE, integerLiteralTypeConstructor.f35999d)), null, 2, null));
        if (!integerLiteralTypeConstructor.n()) {
            listS.add(integerLiteralTypeConstructor.g().M());
        }
        return listS;
    }

    public static final CharSequence q(S it) {
        p.i(it, "it");
        return it.toString();
    }

    @Override // ya.v0
    public v0 a(c kotlinTypeRefiner) {
        p.i(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // ya.v0
    public InterfaceC0799d d() {
        return null;
    }

    @Override // ya.v0
    public Collection<S> e() {
        return m();
    }

    @Override // ya.v0
    public boolean f() {
        return false;
    }

    @Override // ya.v0
    public j g() {
        return this.f35997b.g();
    }

    @Override // ya.v0
    public List<b0> getParameters() {
        return C1173v.m();
    }

    public final Set<S> l() {
        return this.f35998c;
    }

    public final boolean n() {
        Collection<S> collectionA = v.a(this.f35997b);
        if ((collectionA instanceof Collection) && collectionA.isEmpty()) {
            return true;
        }
        Iterator<T> it = collectionA.iterator();
        while (it.hasNext()) {
            if (this.f35998c.contains((S) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final String p() {
        return '[' + F.A0(this.f35998c, Const.STR_MART_COMMA, null, null, 0, null, ma.p.f37201a, 30, null) + ']';
    }

    public String toString() {
        return "IntegerLiteralType" + p();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public IntegerLiteralTypeConstructor(long j10, InterfaceC0819y interfaceC0819y, Set<? extends S> set) {
        this.f35999d = V.f(s0.f44124b.k(), this, false);
        this.f36000e = C4848b.b(new o(this));
        this.f35996a = j10;
        this.f35997b = interfaceC0819y;
        this.f35998c = set;
    }
}
