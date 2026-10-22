package va;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import kotlin.jvm.internal.p;

/* renamed from: va.b, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5687b {
    public final InputStream a(String path) throws IOException {
        p.i(path, "path");
        ClassLoader classLoader = C5687b.class.getClassLoader();
        if (classLoader == null) {
            return ClassLoader.getSystemResourceAsStream(path);
        }
        URL resource = classLoader.getResource(path);
        if (resource == null) {
            return null;
        }
        URLConnection uRLConnectionOpenConnection = resource.openConnection();
        uRLConnectionOpenConnection.setUseCaches(false);
        return uRLConnectionOpenConnection.getInputStream();
    }
}
