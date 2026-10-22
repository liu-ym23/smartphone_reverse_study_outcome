package kotlinx.coroutines.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlinx.coroutines.internal.ai;
import kotlinx.coroutines.internal.al;

/* JADX INFO: compiled from: Semaphore.kt */
/* JADX INFO: loaded from: classes4.dex */
final class g extends ai<g> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ AtomicReferenceArray f39347b;

    public final /* synthetic */ AtomicReferenceArray a() {
        return this.f39347b;
    }

    public g(long r3, g r5, int r6) {
        super(r3, (ai) ZeusTransformUtils.preCheckCast(r5, ai.class, "com.obric.aiagent.plugin"), r6);
        this.f39347b = new AtomicReferenceArray(f.a());
    }

    @Override // kotlinx.coroutines.internal.ai
    public int b() {
        return f.a();
    }

    @Override // kotlinx.coroutines.internal.ai
    public void a(int r2, Throwable r3, d.c.g r4) {
        d.c.g r5 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r4, d.c.g.class, "com.obric.aiagent.plugin");
        al r6 = f.f();
        a().set(r2, r6);
        l();
    }

    public String toString() {
        return "SemaphoreSegment[id=" + this.f39364a + ", hashCode=" + hashCode() + ']';
    }
}
