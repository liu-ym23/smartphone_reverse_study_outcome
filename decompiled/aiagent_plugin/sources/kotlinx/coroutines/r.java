package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: CompletionState.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class r extends ab {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f39440b = null;
    private volatile /* synthetic */ int _resumed$volatile;

    static {
        f39440b = AtomicIntegerFieldUpdater.newUpdater(r.class, "_resumed$volatile");
    }

    private static final /* synthetic */ AtomicIntegerFieldUpdater d() {
        return f39440b;
    }

    public r(d.c.d<?> r4, Throwable r5, boolean r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        r5 = (Throwable) ZeusTransformUtils.preCheckCast(new CancellationException("Continuation " + r7 + " was cancelled normally"), Throwable.class, "com.obric.aiagent.plugin");
    L5:
        super(r5, r6);
        this._resumed$volatile = 0;
    }

    public final boolean a() {
        return d().compareAndSet(this, 0, 1);
    }
}
