package J9;

import kotlin.jvm.internal.p;

/* loaded from: classes5.dex */
public final class e {
    public static final Class<?> a(ClassLoader classLoader, String fqName) {
        p.i(classLoader, "<this>");
        p.i(fqName, "fqName");
        try {
            return Class.forName(fqName, false, classLoader);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
