package j4;

import i4.InterfaceC0761a;
import i4.InterfaceC0762b;
import i4.InterfaceC0763c;
import i4.InterfaceC0764d;
import i4.InterfaceC0765e;
import i4.InterfaceC0766f;
import i4.InterfaceC0767g;
import i4.InterfaceC0768h;
import i4.InterfaceC0769i;
import i4.InterfaceC0770j;
import i4.InterfaceC0771k;
import i4.InterfaceC0772l;
import i4.InterfaceC0773m;
import i4.InterfaceC0774n;
import java.util.Collection;
import k4.InterfaceC0814a;
import k4.InterfaceC0815b;

/* loaded from: classes.dex */
public class z {
    public static Collection a(Object obj) {
        if ((obj instanceof InterfaceC0814a) && !(obj instanceof InterfaceC0815b)) {
            h(obj, "kotlin.collections.MutableCollection");
        }
        return c(obj);
    }

    public static Object b(Object obj, int i5) {
        if (obj != null && !e(obj, i5)) {
            h(obj, "kotlin.jvm.functions.Function" + i5);
        }
        return obj;
    }

    public static Collection c(Object obj) {
        try {
            return (Collection) obj;
        } catch (ClassCastException e6) {
            throw g(e6);
        }
    }

    public static int d(Object obj) {
        if (obj instanceof h) {
            return ((h) obj).getArity();
        }
        if (obj instanceof InterfaceC0761a) {
            return 0;
        }
        if (obj instanceof InterfaceC0772l) {
            return 1;
        }
        if (obj instanceof i4.p) {
            return 2;
        }
        if (obj instanceof i4.q) {
            return 3;
        }
        if (obj instanceof i4.r) {
            return 4;
        }
        if (obj instanceof i4.s) {
            return 5;
        }
        if (obj instanceof i4.t) {
            return 6;
        }
        if (obj instanceof i4.u) {
            return 7;
        }
        if (obj instanceof i4.v) {
            return 8;
        }
        if (obj instanceof i4.w) {
            return 9;
        }
        if (obj instanceof InterfaceC0762b) {
            return 10;
        }
        if (obj instanceof InterfaceC0763c) {
            return 11;
        }
        if (obj instanceof InterfaceC0764d) {
            return 12;
        }
        if (obj instanceof InterfaceC0765e) {
            return 13;
        }
        if (obj instanceof InterfaceC0766f) {
            return 14;
        }
        if (obj instanceof InterfaceC0767g) {
            return 15;
        }
        if (obj instanceof InterfaceC0768h) {
            return 16;
        }
        if (obj instanceof InterfaceC0769i) {
            return 17;
        }
        if (obj instanceof InterfaceC0770j) {
            return 18;
        }
        if (obj instanceof InterfaceC0771k) {
            return 19;
        }
        if (obj instanceof InterfaceC0773m) {
            return 20;
        }
        if (obj instanceof InterfaceC0774n) {
            return 21;
        }
        return obj instanceof i4.o ? 22 : -1;
    }

    public static boolean e(Object obj, int i5) {
        return (obj instanceof V3.c) && d(obj) == i5;
    }

    private static <T extends Throwable> T f(T t5) {
        return (T) k.l(t5, z.class.getName());
    }

    public static ClassCastException g(ClassCastException classCastException) {
        throw ((ClassCastException) f(classCastException));
    }

    public static void h(Object obj, String str) {
        i((obj == null ? "null" : obj.getClass().getName()) + " cannot be cast to " + str);
    }

    public static void i(String str) {
        throw g(new ClassCastException(str));
    }
}
