package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: Executors.kt */
/* JADX INFO: loaded from: classes4.dex */
final class bc implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ai f39143a;

    public bc(ai r1) {
        this.f39143a = r1;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r5) {
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.aiagent.plugin");
        if (this.f39143a.a((d.c.g) ZeusTransformUtils.preCheckCast(d.c.h.f38423a, d.c.g.class, "com.obric.aiagent.plugin")) == false) goto L5;
        this.f39143a.a((d.c.g) ZeusTransformUtils.preCheckCast(d.c.h.f38423a, d.c.g.class, "com.obric.aiagent.plugin"), r6);
        return;
    L5:
        r6.run();
    }

    public String toString() {
        return this.f39143a.toString();
    }
}
