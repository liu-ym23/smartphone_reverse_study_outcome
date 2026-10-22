package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: Executors.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class br {
    public static final bp a(ExecutorService r3) {
        return (bp) ZeusTransformUtils.preCheckCast(new bq((Executor) ZeusTransformUtils.preCheckCast((ExecutorService) ZeusTransformUtils.wrapperContextForParams(r3, ExecutorService.class, "com.obric.aiagent.plugin"), Executor.class, "com.obric.aiagent.plugin")), bp.class, "com.obric.aiagent.plugin");
    }

    public static final Executor a(ai r2) {
        if (ZeusTransformUtils.instanceOf(r2, bp.class) == false) goto L5;
        bp r0 = (bp) ZeusTransformUtils.preCheckCast(r2, bp.class, "com.obric.aiagent.plugin");
    L6:
        if (r0 == null) goto L10;
        Executor r1 = r0.a();
        if (r1 == null) goto L10;
        return r1;
    L10:
        return (Executor) ZeusTransformUtils.preCheckCast(new bc(r2), Executor.class, "com.obric.aiagent.plugin");
    L5:
        r0 = null;
        goto L6
    }
}
