package j4;

import java.util.Arrays;

/* loaded from: classes.dex */
public class k {
    private k() {
    }

    public static boolean a(Float f5, float f6) {
        return f5 != null && f5.floatValue() == f6;
    }

    public static boolean b(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void c(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((IllegalStateException) k(new IllegalStateException(str + " must not be null")));
    }

    public static void d(Object obj) {
        if (obj == null) {
            n();
        }
    }

    public static void e(Object obj, String str) {
        if (obj == null) {
            o(str);
        }
    }

    public static void f(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((NullPointerException) k(new NullPointerException(str + " must not be null")));
    }

    public static void g(Object obj, String str) {
        if (obj == null) {
            r(str);
        }
    }

    public static void h(Object obj, String str) {
        if (obj == null) {
            q(str);
        }
    }

    public static int i(int i5, int i6) {
        if (i5 < i6) {
            return -1;
        }
        return i5 == i6 ? 0 : 1;
    }

    private static String j(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = k.class.getName();
        int i5 = 0;
        while (!stackTrace[i5].getClassName().equals(name)) {
            i5++;
        }
        while (stackTrace[i5].getClassName().equals(name)) {
            i5++;
        }
        StackTraceElement stackTraceElement = stackTrace[i5];
        return "Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str;
    }

    private static <T extends Throwable> T k(T t5) {
        return (T) l(t5, k.class.getName());
    }

    static <T extends Throwable> T l(T t5, String str) {
        StackTraceElement[] stackTrace = t5.getStackTrace();
        int length = stackTrace.length;
        int i5 = -1;
        for (int i6 = 0; i6 < length; i6++) {
            if (str.equals(stackTrace[i6].getClassName())) {
                i5 = i6;
            }
        }
        t5.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i5 + 1, length));
        return t5;
    }

    public static String m(String str, Object obj) {
        return str + obj;
    }

    public static void n() {
        throw ((NullPointerException) k(new NullPointerException()));
    }

    public static void o(String str) {
        throw ((NullPointerException) k(new NullPointerException(str)));
    }

    public static void p() {
        throw ((V3.e) k(new V3.e()));
    }

    private static void q(String str) {
        throw ((IllegalArgumentException) k(new IllegalArgumentException(j(str))));
    }

    private static void r(String str) {
        throw ((NullPointerException) k(new NullPointerException(j(str))));
    }

    public static void s(String str) {
        throw ((V3.u) k(new V3.u(str)));
    }

    public static void t(String str) {
        s("lateinit property " + str + " has not been initialized");
    }
}
