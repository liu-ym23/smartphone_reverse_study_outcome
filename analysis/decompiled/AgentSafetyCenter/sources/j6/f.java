package j6;

import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f extends LinkedBlockingQueue {

    /* renamed from: c, reason: collision with root package name */
    public volatile g f6603c;

    /* renamed from: f, reason: collision with root package name */
    public final int f6604f = 0;

    public f(int i) {
    }

    @Override // java.util.concurrent.LinkedBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final boolean offer(Runnable runnable) {
        if (this.f6604f > size() || this.f6603c == null || this.f6603c.getPoolSize() >= this.f6603c.getMaximumPoolSize()) {
            return super.offer(runnable);
        }
        return false;
    }
}
