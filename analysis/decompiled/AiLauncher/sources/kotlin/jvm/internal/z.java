package kotlin.jvm.internal;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p9.InterfaceC5063a;
import p9.InterfaceC5064b;
import p9.InterfaceC5065c;
import p9.InterfaceC5066d;
import p9.InterfaceC5067e;
import p9.InterfaceC5068f;
import p9.InterfaceC5069g;
import p9.InterfaceC5070h;
import p9.InterfaceC5071i;
import p9.InterfaceC5072j;
import p9.InterfaceC5073k;
import p9.InterfaceC5074l;
import p9.InterfaceC5075m;
import p9.InterfaceC5076n;
import q9.InterfaceC5162a;
import q9.InterfaceC5163b;
import q9.InterfaceC5164c;
import q9.InterfaceC5165d;
import q9.e;

/* loaded from: classes4.dex */
public class z {
    public static Collection a(Object obj) {
        if ((obj instanceof InterfaceC5162a) && !(obj instanceof InterfaceC5163b)) {
            t(obj, "kotlin.collections.MutableCollection");
        }
        return h(obj);
    }

    public static Iterable b(Object obj) {
        if ((obj instanceof InterfaceC5162a) && !(obj instanceof InterfaceC5164c)) {
            t(obj, "kotlin.collections.MutableIterable");
        }
        return i(obj);
    }

    public static List c(Object obj) {
        if ((obj instanceof InterfaceC5162a) && !(obj instanceof InterfaceC5165d)) {
            t(obj, "kotlin.collections.MutableList");
        }
        return j(obj);
    }

    public static Map d(Object obj) {
        if ((obj instanceof InterfaceC5162a) && !(obj instanceof q9.e)) {
            t(obj, "kotlin.collections.MutableMap");
        }
        return k(obj);
    }

    public static Map.Entry e(Object obj) {
        if ((obj instanceof InterfaceC5162a) && !(obj instanceof e.a)) {
            t(obj, "kotlin.collections.MutableMap.MutableEntry");
        }
        return l(obj);
    }

    public static Set f(Object obj) {
        if ((obj instanceof InterfaceC5162a) && !(obj instanceof q9.f)) {
            t(obj, "kotlin.collections.MutableSet");
        }
        return m(obj);
    }

    public static Object g(Object obj, int i10) {
        if (obj != null && !o(obj, i10)) {
            t(obj, "kotlin.jvm.functions.Function" + i10);
        }
        return obj;
    }

    public static Collection h(Object obj) {
        try {
            return (Collection) obj;
        } catch (ClassCastException e10) {
            throw s(e10);
        }
    }

    public static Iterable i(Object obj) {
        try {
            return (Iterable) obj;
        } catch (ClassCastException e10) {
            throw s(e10);
        }
    }

    public static List j(Object obj) {
        try {
            return (List) obj;
        } catch (ClassCastException e10) {
            throw s(e10);
        }
    }

    public static Map k(Object obj) {
        try {
            return (Map) obj;
        } catch (ClassCastException e10) {
            throw s(e10);
        }
    }

    public static Map.Entry l(Object obj) {
        try {
            return (Map.Entry) obj;
        } catch (ClassCastException e10) {
            throw s(e10);
        }
    }

    public static Set m(Object obj) {
        try {
            return (Set) obj;
        } catch (ClassCastException e10) {
            throw s(e10);
        }
    }

    public static int n(Object obj) {
        if (obj instanceof m) {
            return ((m) obj).getArity();
        }
        if (obj instanceof InterfaceC5063a) {
            return 0;
        }
        if (obj instanceof InterfaceC5074l) {
            return 1;
        }
        if (obj instanceof p9.p) {
            return 2;
        }
        if (obj instanceof p9.q) {
            return 3;
        }
        if (obj instanceof p9.r) {
            return 4;
        }
        if (obj instanceof p9.s) {
            return 5;
        }
        if (obj instanceof p9.t) {
            return 6;
        }
        if (obj instanceof p9.u) {
            return 7;
        }
        if (obj instanceof p9.v) {
            return 8;
        }
        if (obj instanceof p9.w) {
            return 9;
        }
        if (obj instanceof InterfaceC5064b) {
            return 10;
        }
        if (obj instanceof InterfaceC5065c) {
            return 11;
        }
        if (obj instanceof InterfaceC5066d) {
            return 12;
        }
        if (obj instanceof InterfaceC5067e) {
            return 13;
        }
        if (obj instanceof InterfaceC5068f) {
            return 14;
        }
        if (obj instanceof InterfaceC5069g) {
            return 15;
        }
        if (obj instanceof InterfaceC5070h) {
            return 16;
        }
        if (obj instanceof InterfaceC5071i) {
            return 17;
        }
        if (obj instanceof InterfaceC5072j) {
            return 18;
        }
        if (obj instanceof InterfaceC5073k) {
            return 19;
        }
        if (obj instanceof InterfaceC5075m) {
            return 20;
        }
        if (obj instanceof InterfaceC5076n) {
            return 21;
        }
        return obj instanceof p9.o ? 22 : -1;
    }

    public static boolean o(Object obj, int i10) {
        return (obj instanceof Y8.e) && n(obj) == i10;
    }

    public static boolean p(Object obj) {
        if (obj instanceof List) {
            return !(obj instanceof InterfaceC5162a) || (obj instanceof InterfaceC5165d);
        }
        return false;
    }

    public static boolean q(Object obj) {
        if (obj instanceof Map) {
            return !(obj instanceof InterfaceC5162a) || (obj instanceof q9.e);
        }
        return false;
    }

    public static <T extends Throwable> T r(T t10) {
        return (T) p.q(t10, z.class.getName());
    }

    public static ClassCastException s(ClassCastException classCastException) {
        throw ((ClassCastException) r(classCastException));
    }

    public static void t(Object obj, String str) {
        u((obj == null ? "null" : obj.getClass().getName()) + " cannot be cast to " + str);
    }

    public static void u(String str) {
        throw s(new ClassCastException(str));
    }
}
