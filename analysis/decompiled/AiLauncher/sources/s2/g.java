package s2;

import java.io.Closeable;
import java.io.IOException;

@Deprecated
/* loaded from: classes2.dex */
public final class g {
    public static void a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
