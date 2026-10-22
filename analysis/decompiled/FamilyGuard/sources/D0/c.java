package D0;

import D0.l;
import java.util.Queue;

/* loaded from: classes.dex */
abstract class c<T extends l> {

    /* renamed from: a, reason: collision with root package name */
    private final Queue<T> f1004a = X0.k.f(20);

    c() {
    }

    abstract T a();

    T b() {
        T tPoll = this.f1004a.poll();
        return tPoll == null ? (T) a() : tPoll;
    }

    public void c(T t5) {
        if (this.f1004a.size() < 20) {
            this.f1004a.offer(t5);
        }
    }
}
