package S9;

import E9.AbstractC0808m;
import E9.AbstractC0811p;
import E9.C0810o;
import E9.InterfaceC0803h;
import E9.InterfaceC0807l;
import E9.m0;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import java.util.HashMap;
import java.util.Map;
import ka.C4828h;
import sa.InterfaceC5460g;

/* loaded from: classes5.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    public static final AbstractC0811p f5776a;

    /* renamed from: b, reason: collision with root package name */
    public static final AbstractC0811p f5777b;

    /* renamed from: c, reason: collision with root package name */
    public static final AbstractC0811p f5778c;

    /* renamed from: d, reason: collision with root package name */
    public static final Map<m0, AbstractC0811p> f5779d;

    public static class a extends AbstractC0808m {
        public a(m0 m0Var) {
            super(m0Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1) {
                objArr[0] = "from";
            } else if (i10 == 2) {
                objArr[0] = "fromPackage";
            } else if (i10 != 3) {
                objArr[0] = "what";
            } else {
                objArr[0] = "myPackage";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$1";
            if (i10 == 2 || i10 == 3) {
                objArr[2] = "visibleFromPackage";
            } else {
                objArr[2] = "isVisible";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // E9.AbstractC0811p
        public boolean e(InterfaceC5460g interfaceC5460g, InterfaceC0807l interfaceC0807l, InterfaceC0803h interfaceC0803h, boolean z10) {
            if (interfaceC0807l == null) {
                g(0);
            }
            if (interfaceC0803h == null) {
                g(1);
            }
            return v.d(interfaceC0807l, interfaceC0803h);
        }
    }

    public static class b extends AbstractC0808m {
        public b(m0 m0Var) {
            super(m0Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$2";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // E9.AbstractC0811p
        public boolean e(InterfaceC5460g interfaceC5460g, InterfaceC0807l interfaceC0807l, InterfaceC0803h interfaceC0803h, boolean z10) {
            if (interfaceC0807l == null) {
                g(0);
            }
            if (interfaceC0803h == null) {
                g(1);
            }
            return v.e(interfaceC5460g, interfaceC0807l, interfaceC0803h);
        }
    }

    public static class c extends AbstractC0808m {
        public c(m0 m0Var) {
            super(m0Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$3";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // E9.AbstractC0811p
        public boolean e(InterfaceC5460g interfaceC5460g, InterfaceC0807l interfaceC0807l, InterfaceC0803h interfaceC0803h, boolean z10) {
            if (interfaceC0807l == null) {
                g(0);
            }
            if (interfaceC0803h == null) {
                g(1);
            }
            return v.e(interfaceC5460g, interfaceC0807l, interfaceC0803h);
        }
    }

    static {
        a aVar = new a(I9.a.f3395c);
        f5776a = aVar;
        b bVar = new b(I9.c.f3397c);
        f5777b = bVar;
        c cVar = new c(I9.b.f3396c);
        f5778c = cVar;
        f5779d = new HashMap();
        f(aVar);
        f(bVar);
        f(cVar);
    }

    public static /* synthetic */ void a(int i10) {
        String str = (i10 == 5 || i10 == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 5 || i10 == 6) ? 2 : 3];
        switch (i10) {
            case 1:
                objArr[0] = "from";
                break;
            case 2:
                objArr[0] = AMapLocationStaticsEntity.FIRST_LOCATE;
                break;
            case 3:
                objArr[0] = "second";
                break;
            case 4:
                objArr[0] = "visibility";
                break;
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
                break;
            default:
                objArr[0] = "what";
                break;
        }
        if (i10 == 5 || i10 == 6) {
            objArr[1] = "toDescriptorVisibility";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
        }
        if (i10 == 2 || i10 == 3) {
            objArr[2] = "areInSamePackage";
        } else if (i10 == 4) {
            objArr[2] = "toDescriptorVisibility";
        } else if (i10 != 5 && i10 != 6) {
            objArr[2] = "isVisibleForProtectedAndPackage";
        }
        String str2 = String.format(str, objArr);
        if (i10 != 5 && i10 != 6) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static boolean d(InterfaceC0803h interfaceC0803h, InterfaceC0803h interfaceC0803h2) {
        if (interfaceC0803h == null) {
            a(2);
        }
        if (interfaceC0803h2 == null) {
            a(3);
        }
        E9.E e10 = (E9.E) C4828h.r(interfaceC0803h, E9.E.class, false);
        E9.E e11 = (E9.E) C4828h.r(interfaceC0803h2, E9.E.class, false);
        return (e11 == null || e10 == null || !e10.f().equals(e11.f())) ? false : true;
    }

    public static boolean e(InterfaceC5460g interfaceC5460g, InterfaceC0807l interfaceC0807l, InterfaceC0803h interfaceC0803h) {
        if (interfaceC0807l == null) {
            a(0);
        }
        if (interfaceC0803h == null) {
            a(1);
        }
        if (d(C4828h.M(interfaceC0807l), interfaceC0803h)) {
            return true;
        }
        return C0810o.f2471c.e(interfaceC5460g, interfaceC0807l, interfaceC0803h, false);
    }

    public static void f(AbstractC0811p abstractC0811p) {
        f5779d.put(abstractC0811p.b(), abstractC0811p);
    }

    public static AbstractC0811p g(m0 m0Var) {
        if (m0Var == null) {
            a(4);
        }
        AbstractC0811p abstractC0811p = f5779d.get(m0Var);
        if (abstractC0811p != null) {
            return abstractC0811p;
        }
        AbstractC0811p abstractC0811pJ = C0810o.j(m0Var);
        if (abstractC0811pJ == null) {
            a(5);
        }
        return abstractC0811pJ;
    }
}
