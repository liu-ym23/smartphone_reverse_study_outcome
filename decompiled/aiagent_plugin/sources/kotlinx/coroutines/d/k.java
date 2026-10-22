package kotlinx.coroutines.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlinx.coroutines.ar;

/* JADX INFO: compiled from: Tasks.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class k extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f39241a;

    public k(Runnable r3, long r4, i r6) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        super(r4, (i) ZeusTransformUtils.wrapperContextForParams(r6, i.class, "com.obric.aiagent.plugin"));
        this.f39241a = r5;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f39241a.run();     // Catch: Throwable -> L5
        this.g.b();
        return;
    L5:
        th = move-exception;
        this.g.b();
        throw th;
    }

    public String toString() {
        return "Task[" + ar.b(this.f39241a) + '@' + ar.a(this.f39241a) + ", " + this.f + ", " + this.g + ']';
    }
}
