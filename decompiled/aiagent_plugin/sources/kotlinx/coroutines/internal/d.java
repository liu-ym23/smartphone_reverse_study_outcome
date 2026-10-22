package kotlinx.coroutines.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* JADX INFO: compiled from: Concurrent.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Method f39390a = null;

    static {
        Method r0 = ScheduledThreadPoolExecutor.class.getMethod("setRemoveOnCancelPolicy", new Class[]{Boolean.TYPE});     // Catch: Throwable -> L4
    L5:
        f39390a = r0;
        return;
    L4:
        r0 = null;
        goto L5
    }

    public static final boolean a(Executor r5) {
        Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.aiagent.plugin");
    L14:
        return false;
    L4:
        if (ZeusTransformUtils.instanceOf(r6, ScheduledThreadPoolExecutor.class) == false) goto L6;
        ScheduledThreadPoolExecutor r7 = (ScheduledThreadPoolExecutor) ZeusTransformUtils.preCheckCast(r6, ScheduledThreadPoolExecutor.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
    L7:
        if (r7 != null) goto L9;
        return false;
    L9:
        Method r1 = f39390a;     // Catch: Throwable -> L14
        if (r1 != null) goto L12;
        return false;
    L12:
        r1.invoke(r7, new Object[]{true});     // Catch: Throwable -> L14
        return true;
    L6:
        r7 = null;
        goto L7
    }
}
