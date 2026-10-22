package q7;

import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class k {
    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void b(Object obj) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException();
        i(nullPointerException, k.class.getName());
        throw nullPointerException;
    }

    public static void c(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(str);
        i(nullPointerException, k.class.getName());
        throw nullPointerException;
    }

    public static void d(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(str.concat(" must not be null"));
        i(nullPointerException, k.class.getName());
        throw nullPointerException;
    }

    public static void e(Object obj, String str) {
        if (obj == null) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String name = k.class.getName();
            int i2 = 0;
            while (!stackTrace[i2].getClassName().equals(name)) {
                i2++;
            }
            while (stackTrace[i2].getClassName().equals(name)) {
                i2++;
            }
            StackTraceElement stackTraceElement = stackTrace[i2];
            StringBuilder sbP = a1.a.p("Parameter specified as non-null is null: method ", stackTraceElement.getClassName(), ".", stackTraceElement.getMethodName(), ", parameter ");
            sbP.append(str);
            NullPointerException nullPointerException = new NullPointerException(sbP.toString());
            i(nullPointerException, k.class.getName());
            throw nullPointerException;
        }
    }

    public static int f(int i2, int i10) {
        if (i2 < i10) {
            return -1;
        }
        return i2 == i10 ? 0 : 1;
    }

    public static int g(long j2, long j4) {
        if (j2 < j4) {
            return -1;
        }
        return j2 == j4 ? 0 : 1;
    }

    public static final d7.c h(Object[] objArr) {
        e(objArr, "array");
        return new d7.c(objArr);
    }

    public static void i(RuntimeException runtimeException, String str) {
        StackTraceElement[] stackTrace = runtimeException.getStackTrace();
        int length = stackTrace.length;
        int i2 = -1;
        for (int i10 = 0; i10 < length; i10++) {
            if (str.equals(stackTrace[i10].getClassName())) {
                i2 = i10;
            }
        }
        runtimeException.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i2 + 1, length));
    }

    public static void j(String str) {
        a4.u uVar = new a4.u(a1.a.j("lateinit property ", str, " has not been initialized"));
        i(uVar, k.class.getName());
        throw uVar;
    }
}
