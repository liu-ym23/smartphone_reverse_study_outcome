package yb;

import java.lang.invoke.VarHandle;
import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class k {
    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static int b(int i, int i3) {
        if (i < i3) {
            return -1;
        }
        return i == i3 ? 0 : 1;
    }

    public static int c(long j10, long j11) {
        if (j10 < j11) {
            return -1;
        }
        return j10 == j11 ? 0 : 1;
    }

    public static final kb.b d(Object[] objArr) {
        objArr.getClass();
        kb.b bVar = new kb.b(2);
        bVar.f7386g = objArr;
        VarHandle.storeStoreFence();
        return bVar;
    }

    public static void e(RuntimeException runtimeException, String str) {
        StackTraceElement[] stackTrace = runtimeException.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i3 = 0; i3 < length; i3++) {
            if (str.equals(stackTrace[i3].getClassName())) {
                i = i3;
            }
        }
        runtimeException.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
    }

    public static void f(String str) {
        androidx.fragment.app.d dVar = new androidx.fragment.app.d(k0.a.C("lateinit property ", str, " has not been initialized"));
        e(dVar, k.class.getName());
        throw dVar;
    }
}
