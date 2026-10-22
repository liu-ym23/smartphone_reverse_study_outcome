package X0;

import android.text.TextUtils;
import java.util.Collection;

/* loaded from: classes.dex */
public final class j {
    public static void a(boolean z5, String str) {
        if (!z5) {
            throw new IllegalArgumentException(str);
        }
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must not be null or empty");
        }
        return str;
    }

    public static <T extends Collection<Y>, Y> T c(T t5) {
        if (t5.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        return t5;
    }

    public static <T> T d(T t5) {
        return (T) e(t5, "Argument must not be null");
    }

    public static <T> T e(T t5, String str) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(str);
    }
}
