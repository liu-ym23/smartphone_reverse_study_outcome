package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: Executors.kt */
/* JADX INFO: loaded from: classes4.dex */
final class be implements bf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Future<?> f39148a;

    public be(Future<?> r3) {
        this.f39148a = (Future) ZeusTransformUtils.wrapperContextForParams(r3, Future.class, "com.obric.aiagent.plugin");
    }

    @Override // kotlinx.coroutines.bf
    public void dispose() {
        this.f39148a.cancel(false);
    }

    public String toString() {
        return "DisposableFutureHandle[" + this.f39148a + ']';
    }
}
