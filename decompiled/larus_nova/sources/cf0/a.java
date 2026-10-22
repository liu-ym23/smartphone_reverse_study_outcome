package cf0;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes46.dex */
public final class a<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentLinkedQueue<E> f23496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f23497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f23498c;

    public final String toString() {
        return this.f23496a.toString();
    }

    public a() {
        this.f23498c = 8;
        this.f23496a = new ConcurrentLinkedQueue();
        this.f23497b = new AtomicInteger(0);
    }
}
