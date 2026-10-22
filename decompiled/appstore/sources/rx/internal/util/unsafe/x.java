package rx.internal.util.unsafe;

import rx.internal.util.atomic.LinkedQueueNode;

/* JADX INFO: loaded from: classes4.dex */
public final class x extends a {
    public x() {
        b(new LinkedQueueNode());
        d(this.producerNode);
        this.consumerNode.soNext(null);
    }

    @Override // java.util.Queue
    public boolean offer(Object r10) {
        if (r10 == null) goto L6;
        LinkedQueueNode<Object> r11 = new LinkedQueueNode(r10);
        this.producerNode.soNext(r11);
        this.producerNode = r11;
        return true;
    L6:
        throw new NullPointerException("null elements not allowed");
    }

    @Override // java.util.Queue
    public Object peek() {
        LinkedQueueNode<Object> r10 = this.consumerNode.lvNext();
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.lpValue();
    }

    @Override // java.util.Queue
    public Object poll() {
        LinkedQueueNode<Object> r10 = this.consumerNode.lvNext();
        if (r10 == null) goto L6;
        Object r11 = r10.getAndNullValue();
        this.consumerNode = r10;
        return r11;
    L6:
        return null;
    }
}
