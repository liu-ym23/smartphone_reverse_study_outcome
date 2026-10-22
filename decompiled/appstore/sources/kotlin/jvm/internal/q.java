package kotlin.jvm.internal;

import com.bytedance.librarian.LibrarianImpl;
import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class q {

    public static class a {
    }

    public static boolean a(Float r10, Float r11) {
        if (r10 != null) goto L6;
        if (r11 == null) goto L11;
        return false;
    L11:
        return true;
    L6:
        if (r11 != null) goto L8;
        return false;
    L8:
        if (r10.floatValue() == r11.floatValue()) goto L11;
        return false;
    }

    public static boolean b(Object r10, Object r11) {
        if (r10 != null) goto L7;
        if (r11 != null) goto L5;
        return true;
    L5:
        return false;
    L7:
        return r10.equals(r11);
    }

    public static void c(Object r10, String r11) {
        if (r10 == null) goto L5;
        return;
    L5:
        throw ((IllegalStateException) n(new IllegalStateException(r11 + " must not be null")));
    }

    public static void d(Object r10) {
        if (r10 != null) goto L5;
        q();
        return;
    }

    public static void e(Object r10, String r11) {
        if (r10 != null) goto L5;
        r(r11);
        return;
    }

    public static void f(Object r10, String r11) {
        if (r10 == null) goto L5;
        return;
    L5:
        throw ((NullPointerException) n(new NullPointerException(r11 + " must not be null")));
    }

    public static void g(Object r10, String r11) {
        if (r10 != null) goto L5;
        u(r11);
        return;
    }

    public static void h(Object r10, String r11) {
        if (r10 != null) goto L5;
        t(r11);
        return;
    }

    public static int i(int r10, int r11) {
        if (r10 >= r11) goto L4;
        return -1;
    L4:
        if (r10 != r11) goto L6;
        return 0;
    L6:
        return 1;
    }

    public static int j(long r10, long r11) {
        if (r10 >= r11) goto L5;
        return -1;
    L5:
        if (r10 != r11) goto L7;
        return 0;
    L7:
        return 1;
    }

    public static String k(String r10) {
        StackTraceElement[] r11 = Thread.currentThread().getStackTrace();
        String r12 = q.class.getName();
        int r13 = 0;
    L4:
        if (r11[r13].getClassName().equals(r12) == true) goto L7;
        r13 = r13 + 1;
    L7:
        if (r11[r13].getClassName().equals(r12) == false) goto L9;
        r13 = r13 + 1;
        goto L7
    L9:
        StackTraceElement r14 = r11[r13];
        return "Parameter specified as non-null is null: method " + r14.getClassName() + LibrarianImpl.Constants.DOT + r14.getMethodName() + ", parameter " + r10;
    }

    public static void l() {
        v();
    }

    public static void m(int r10, String r11) {
        v();
    }

    public static Throwable n(Throwable r10) {
        return o(r10, q.class.getName());
    }

    public static Throwable o(Throwable r10, String r11) {
        StackTraceElement[] r12 = r10.getStackTrace();
        int r13 = r12.length;
        int r14 = -1;
        int r15 = 0;
    L3:
        if (r15 >= r13) goto L8;
        if (r11.equals(r12[r15].getClassName()) == false) goto L7;
        r14 = r15;
    L7:
        r15 = r15 + 1;
        goto L3
    L8:
        r10.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(r12, r14 + 1, r13));
        return r10;
    }

    public static String p(String r10, Object r11) {
        return r10 + r11;
    }

    public static void q() {
        throw ((NullPointerException) n(new NullPointerException()));
    }

    public static void r(String r10) {
        throw ((NullPointerException) n(new NullPointerException(r10)));
    }

    public static void s() {
        throw ((KotlinNullPointerException) n(new KotlinNullPointerException()));
    }

    public static void t(String r10) {
        throw ((IllegalArgumentException) n(new IllegalArgumentException(k(r10))));
    }

    public static void u(String r10) {
        throw ((NullPointerException) n(new NullPointerException(k(r10))));
    }

    public static void v() {
        w("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void w(String r10) {
        throw new UnsupportedOperationException(r10);
    }

    public static void x(String r10) {
        throw ((UninitializedPropertyAccessException) n(new UninitializedPropertyAccessException(r10)));
    }

    public static void y(String r10) {
        x("lateinit property " + r10 + " has not been initialized");
    }
}
