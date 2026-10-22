package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CompletableDeferred.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class y {
    public static final <T> w<T> a(ca r2) {
        return (w) ZeusTransformUtils.preCheckCast(new x((ca) ZeusTransformUtils.wrapperContextForParams(r2, ca.class, "com.obric.aiagent.plugin")), w.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ w a(ca r1, int r2, Object r3) {
        ca r4 = (ca) ZeusTransformUtils.wrapperContextForParams(r1, ca.class, "com.obric.aiagent.plugin");
        if ((r2 & 1) == 0) goto L6;
        r4 = null;
    L6:
        return a(r4);
    }

    public static final <T> w<T> a(T r2) {
        x r0 = new x(null);
        r0.a(r2);
        return (w) ZeusTransformUtils.preCheckCast(r0, w.class, "com.obric.aiagent.plugin");
    }
}
