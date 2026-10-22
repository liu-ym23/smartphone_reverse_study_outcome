package rx.internal.util.unsafe;

import rx.internal.util.atomic.LinkedQueueNode;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f24428b = 0;
    protected LinkedQueueNode<Object> consumerNode;

    static {
        f24428b = e0.a(b.class, "consumerNode");
    }

    public b() {
    }

    public final LinkedQueueNode c() {
        return (LinkedQueueNode) e0.f24434a.getObjectVolatile(this, f24428b);
    }

    public final void d(LinkedQueueNode r10) {
        this.consumerNode = r10;
    }
}
