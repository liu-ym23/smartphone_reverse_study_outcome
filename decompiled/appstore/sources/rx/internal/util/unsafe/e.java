package rx.internal.util.unsafe;

import rx.internal.util.atomic.LinkedQueueNode;

/* JADX INFO: loaded from: classes4.dex */
public abstract class e extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f24433a = 0;
    protected LinkedQueueNode<Object> producerNode;

    static {
        f24433a = e0.a(e.class, "producerNode");
    }

    public e() {
    }

    public final LinkedQueueNode a() {
        return (LinkedQueueNode) e0.f24434a.getObjectVolatile(this, f24433a);
    }

    public final void b(LinkedQueueNode r10) {
        this.producerNode = r10;
    }
}
