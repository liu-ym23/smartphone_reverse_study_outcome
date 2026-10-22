package kotlin.reflect.jvm.internal.impl.name;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: compiled from: NameUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class NameUtils {
    public static final NameUtils INSTANCE = null;
    private static final Regex SANITIZE_AS_JAVA_INVALID_CHARACTERS = null;

    private NameUtils() {
    }

    static {
        INSTANCE = new NameUtils();
        SANITIZE_AS_JAVA_INVALID_CHARACTERS = new Regex("[^\\p{L}\\p{Digit}]");
    }

    @JvmStatic
    public static final String sanitizeAsJavaIdentifier(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        return SANITIZE_AS_JAVA_INVALID_CHARACTERS.replace(r2, "_");
    }
}
