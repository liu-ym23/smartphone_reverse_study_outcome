package q7;

import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class z {
    public static Map a(Object obj) {
        if ((obj instanceof r7.a) && !(obj instanceof r7.d)) {
            g(obj, "kotlin.collections.MutableMap");
            throw null;
        }
        try {
            return (Map) obj;
        } catch (ClassCastException e10) {
            k.i(e10, z.class.getName());
            throw e10;
        }
    }

    public static Set b(Object obj) {
        if ((obj instanceof r7.a) && !(obj instanceof r7.e)) {
            g(obj, "kotlin.collections.MutableSet");
            throw null;
        }
        try {
            return (Set) obj;
        } catch (ClassCastException e10) {
            k.i(e10, z.class.getName());
            throw e10;
        }
    }

    public static void c(int i2, Object obj) {
        if (obj == null || d(i2, obj)) {
            return;
        }
        g(obj, "kotlin.jvm.functions.Function" + i2);
        throw null;
    }

    public static boolean d(int i2, Object obj) {
        int arity;
        if (obj instanceof c7.c) {
            if (obj instanceof g) {
                arity = ((g) obj).getArity();
            } else if (obj instanceof p7.a) {
                arity = 0;
            } else if (obj instanceof p7.k) {
                arity = 1;
            } else if (obj instanceof p7.n) {
                arity = 2;
            } else if (obj instanceof p7.o) {
                arity = 3;
            } else if (obj instanceof p7.p) {
                arity = 4;
            } else if (obj instanceof p7.q) {
                arity = 5;
            } else if (obj instanceof p7.r) {
                arity = 6;
            } else if (obj instanceof p7.s) {
                arity = 7;
            } else if (obj instanceof p7.t) {
                arity = 8;
            } else if (obj instanceof p7.u) {
                arity = 9;
            } else if (obj instanceof p7.b) {
                arity = 10;
            } else if (obj instanceof p7.c) {
                arity = 11;
            } else {
                boolean z4 = obj instanceof z7.f;
                arity = z4 ? 12 : obj instanceof p7.d ? 13 : obj instanceof p7.e ? 14 : obj instanceof p7.f ? 15 : obj instanceof p7.g ? 16 : obj instanceof p7.h ? 17 : obj instanceof p7.i ? 18 : obj instanceof p7.j ? 19 : obj instanceof p7.l ? 20 : obj instanceof p7.m ? 21 : z4 ? 22 : -1;
            }
            if (arity == i2) {
                return true;
            }
        }
        return false;
    }

    public static boolean e(Object obj) {
        if (obj instanceof List) {
            return !(obj instanceof r7.a) || (obj instanceof r7.c);
        }
        return false;
    }

    public static boolean f(Object obj) {
        if (obj instanceof Map) {
            return !(obj instanceof r7.a) || (obj instanceof r7.d);
        }
        return false;
    }

    public static void g(Object obj, String str) {
        ClassCastException classCastException = new ClassCastException(a1.a.x(obj == null ? "null" : obj.getClass().getName(), " cannot be cast to ", str));
        k.i(classCastException, z.class.getName());
        throw classCastException;
    }
}
