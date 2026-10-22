package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: Future.kt */
/* JADX INFO: loaded from: classes4.dex */
final class l implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Future<?> f39433a;

    public l(Future<?> r3) {
        this.f39433a = (Future) ZeusTransformUtils.wrapperContextForParams(r3, Future.class, "com.obric.aiagent.plugin");
    }

    @Override // kotlinx.coroutines.m
    public void a(Throwable r1) {
        if (r1 == null) goto L5;
        this.f39433a.cancel(false);
        return;
    }

    public String toString() {
        return "CancelFutureOnCancel[" + this.f39433a + ']';
    }
}
