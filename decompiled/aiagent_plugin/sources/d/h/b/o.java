package d.h.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: compiled from: Intrinsics.java */
/* JADX INFO: loaded from: classes4.dex */
public class o {

    /* JADX INFO: compiled from: Intrinsics.java */
    public static class a {
        private a() {
        }
    }

    public static int a(int r0, int r1) {
        if (r0 >= r1) goto L4;
        return -1;
    L4:
        if (r0 != r1) goto L6;
        return 0;
    L6:
        return 1;
    }

    public static int a(long r0, long r2) {
        if (r0 >= r2) goto L5;
        return -1;
    L5:
        if (r0 != r2) goto L7;
        return 0;
    L7:
        return 1;
    }

    private o() {
    }

    public static String a(String r1, Object r2) {
        return r1 + r2;
    }

    public static void a(Object r0) {
        if (r0 != null) goto L5;
        b();
        return;
    }

    public static void a(Object r0, String r1) {
        if (r0 != null) goto L5;
        a(r1);
        return;
    }

    public static void a() {
        throw ((d.e) ZeusTransformUtils.preCheckCast(a(new d.e()), d.e.class, "com.obric.aiagent.plugin"));
    }

    public static void b() {
        throw ((NullPointerException) ZeusTransformUtils.preCheckCast(a(new NullPointerException()), NullPointerException.class, "com.obric.aiagent.plugin"));
    }

    public static void a(String r2) {
        throw ((NullPointerException) ZeusTransformUtils.preCheckCast(a(new NullPointerException(r2)), NullPointerException.class, "com.obric.aiagent.plugin"));
    }

    public static void b(String r2) {
        throw ((d.w) ZeusTransformUtils.preCheckCast(a(new d.w(r2)), d.w.class, "com.obric.aiagent.plugin"));
    }

    public static void c(String r2) {
        b("lateinit property " + r2 + " has not been initialized");
    }

    public static void b(Object r1, String r2) {
        if (r1 == null) goto L5;
        return;
    L5:
        throw ((IllegalStateException) ZeusTransformUtils.preCheckCast(a(new IllegalStateException(r2 + " must not be null")), IllegalStateException.class, "com.obric.aiagent.plugin"));
    }

    public static void c(Object r1, String r2) {
        if (r1 == null) goto L5;
        return;
    L5:
        throw ((NullPointerException) ZeusTransformUtils.preCheckCast(a(new NullPointerException(r2 + " must not be null")), NullPointerException.class, "com.obric.aiagent.plugin"));
    }

    public static void d(Object r0, String r1) {
        if (r0 != null) goto L5;
        e(r1);
        return;
    }

    public static void e(Object r0, String r1) {
        if (r0 != null) goto L5;
        f(r1);
        return;
    }

    private static void e(String r2) {
        throw ((IllegalArgumentException) ZeusTransformUtils.preCheckCast(a(new IllegalArgumentException(g(r2))), IllegalArgumentException.class, "com.obric.aiagent.plugin"));
    }

    private static void f(String r2) {
        throw ((NullPointerException) ZeusTransformUtils.preCheckCast(a(new NullPointerException(g(r2))), NullPointerException.class, "com.obric.aiagent.plugin"));
    }

    private static String g(String r4) {
        StackTraceElement[] r0 = Thread.currentThread().getStackTrace();
        String r1 = o.class.getName();
        int r2 = 0;
    L4:
        if (r0[r2].getClassName().equals(r1) == true) goto L7;
        r2 = r2 + 1;
    L7:
        if (r0[r2].getClassName().equals(r1) == false) goto L9;
        r2 = r2 + 1;
        goto L7
    L9:
        StackTraceElement r3 = r0[r2];
        return "Parameter specified as non-null is null: method " + r3.getClassName() + "." + r3.getMethodName() + ", parameter " + r4;
    }

    public static boolean a(Object r0, Object r1) {
        if (r0 != null) goto L7;
        if (r1 != null) goto L5;
        return true;
    L5:
        return false;
    L7:
        return r0.equals(r1);
    }

    public static boolean a(Double r4, Double r5) {
        if (r4 != null) goto L6;
        if (r5 != null) goto L11;
        return true;
    L11:
        return false;
    L6:
        if (r5 == null) goto L11;
        if (r4.doubleValue() != r5.doubleValue()) goto L11;
        return true;
    }

    public static boolean a(Float r2, Float r3) {
        if (r2 != null) goto L6;
        if (r3 != null) goto L11;
        return true;
    L11:
        return false;
    L6:
        if (r3 == null) goto L11;
        if (r2.floatValue() != r3.floatValue()) goto L11;
        return true;
    }

    public static void c() {
        d("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void d(String r1) {
        throw new UnsupportedOperationException(r1);
    }

    public static void a(int r0, String r1) {
        c();
    }

    public static void d() {
        c();
    }

    private static <T extends Throwable> T a(T r1) {
        return (T) a(r1, o.class.getName());
    }

    static <T extends Throwable> T a(T r5, String r6) {
        StackTraceElement[] r0 = r5.getStackTrace();
        int r1 = r0.length;
        int r2 = -1;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L8;
        if (r6.equals(r0[r3].getClassName()) == false) goto L7;
        r2 = r3;
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        r5.setStackTrace((StackTraceElement[]) ZeusTransformUtils.preCheckCast(Arrays.copyOfRange(r0, r2 + 1, r1), StackTraceElement[].class, "com.obric.aiagent.plugin"));
        return r5;
    }
}
