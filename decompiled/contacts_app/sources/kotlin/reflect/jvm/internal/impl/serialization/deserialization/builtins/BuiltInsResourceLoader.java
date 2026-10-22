package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BuiltInsResourceLoader.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class BuiltInsResourceLoader {
    public BuiltInsResourceLoader() {
    }

    public final InputStream loadResource(String r2) {
        Intrinsics.checkNotNullParameter(r2, "path");
        ClassLoader r1 = getClass().getClassLoader();
        if (r1 == null) goto L5;
        URL r3 = r1.getResource(r2);
        if (r3 != null) goto L10;
        return null;
    L10:
        URLConnection r4 = r3.openConnection();
        r4.setUseCaches(false);
        return r4.getInputStream();
    L5:
        return ClassLoader.getSystemResourceAsStream(r2);
    }
}
