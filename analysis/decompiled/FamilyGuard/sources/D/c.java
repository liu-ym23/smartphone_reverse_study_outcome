package D;

import java.util.Objects;

/* loaded from: classes.dex */
public class c {
    public static boolean a(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    public static int b(Object... objArr) {
        return Objects.hash(objArr);
    }

    public static <T> T c(T t5) {
        t5.getClass();
        return t5;
    }

    public static <T> T d(T t5, String str) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(str);
    }
}
