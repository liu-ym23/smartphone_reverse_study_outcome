package d.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;

/* JADX INFO: compiled from: Closeable.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    public static final void a(Closeable r2, Throwable r3) {
        Closeable r4 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r2, Closeable.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L13;
        if (r3 != null) goto L11;
        r4.close();
        return;
    L11:
        r4.close();     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        d.a.a(r3, th);
        return;
    }
}
