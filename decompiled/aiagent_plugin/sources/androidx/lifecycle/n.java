package androidx.lifecycle;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.cx;

/* JADX INFO: compiled from: Lifecycle.kt */
/* JADX INFO: loaded from: classes.dex */
public final class n {
    public static final k a(i r6) {
        d.h.b.o.e(r6, "<this>");
    L3:
        LifecycleCoroutineScopeImpl r0 = (LifecycleCoroutineScopeImpl) ZeusTransformUtils.preCheckCast(r6.a().get(), LifecycleCoroutineScopeImpl.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        LifecycleCoroutineScopeImpl r1 = new LifecycleCoroutineScopeImpl(r6, cx.a(null, 1, null).plus((d.c.g) ZeusTransformUtils.preCheckCast(bd.b().a(), d.c.g.class, "com.obric.aiagent.plugin")));
        if (r6.a().compareAndSet(null, r1) == false) goto L3;
        r1.c();
        return (k) ZeusTransformUtils.preCheckCast(r1, k.class, "com.obric.aiagent.plugin");
    L6:
        return (k) ZeusTransformUtils.preCheckCast(r0, k.class, "com.obric.aiagent.plugin");
    }
}
