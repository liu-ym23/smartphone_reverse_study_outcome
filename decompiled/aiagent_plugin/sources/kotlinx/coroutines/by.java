package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes4.dex */
final class by extends cc {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f39176b = null;
    private volatile /* synthetic */ int _invoked$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bw f39177a;

    static {
        f39176b = AtomicIntegerFieldUpdater.newUpdater(by.class, "_invoked$volatile");
    }

    private static final /* synthetic */ AtomicIntegerFieldUpdater k() {
        return f39176b;
    }

    public by(bw r3) {
        this.f39177a = (bw) ZeusTransformUtils.wrapperContextForParams(r3, bw.class, "com.obric.aiagent.plugin");
    }

    @Override // kotlinx.coroutines.bw
    public void a(Throwable r4) {
        if (k().compareAndSet(this, 0, 1) == false) goto L6;
        this.f39177a.a(r4);
        return;
    }
}
