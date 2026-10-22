package kotlinx.coroutines.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: compiled from: CoroutineExceptionHandlerImpl.common.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class j {
    public static final void a(d.c.g r4, Throwable r5) {
        d.c.g r6 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r4, d.c.g.class, "com.obric.aiagent.plugin");
        Iterator<CoroutineExceptionHandler> r0 = i.a().iterator();
    L4:
        if (r0.hasNext() == true) goto L17;
        d.a.a(r5, (Throwable) ZeusTransformUtils.preCheckCast(new l(r6), Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L14
    L12:
        i.a(r5);
        return;
    L17:
        ((CoroutineExceptionHandler) ZeusTransformUtils.preCheckCast(r0.next(), CoroutineExceptionHandler.class, "com.obric.aiagent.plugin")).handleException(r6, r5);     // Catch: Throwable -> L8 o -> L10
    L10:
        return;
    L8:
        th = move-exception;
        i.a(kotlinx.coroutines.aj.a(r5, th));
        goto L4
    }
}
