package av7;

import java.io.Closeable;
import java.io.IOException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public final class d {
    public static void a(@Nullable Closeable r100) {
        if (r100 == null) goto L8;
        r100.close();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }
}
