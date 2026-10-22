package d.g;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AutoCloseableJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static final void a(AutoCloseable r2, Throwable r3) {
        AutoCloseable r4 = (AutoCloseable) ZeusTransformUtils.wrapperContextForParams(r2, AutoCloseable.class, "com.obric.aiagent.plugin");
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
