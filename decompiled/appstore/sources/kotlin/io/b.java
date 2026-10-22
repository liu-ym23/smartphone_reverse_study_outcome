package kotlin.io;

import java.io.Closeable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b {
    public static final void a(Closeable r10, Throwable r11) {
        if (r10 == null) goto L12;
        if (r11 != null) goto L10;
        r10.close();
        return;
    L10:
        r10.close();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        kotlin.a.a(r11, th);
        return;
    }
}
