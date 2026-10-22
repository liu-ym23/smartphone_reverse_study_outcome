package E0;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, a> f1278a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final b f1279b = new b();

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        final Lock f1280a = new ReentrantLock();

        /* renamed from: b, reason: collision with root package name */
        int f1281b;

        a() {
        }
    }

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private final Queue<a> f1282a = new ArrayDeque();

        b() {
        }

        a a() {
            a aVarPoll;
            synchronized (this.f1282a) {
                aVarPoll = this.f1282a.poll();
            }
            return aVarPoll == null ? new a() : aVarPoll;
        }

        void b(a aVar) {
            synchronized (this.f1282a) {
                try {
                    if (this.f1282a.size() < 10) {
                        this.f1282a.offer(aVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    c() {
    }

    void a(String str) {
        a aVarA;
        synchronized (this) {
            try {
                aVarA = this.f1278a.get(str);
                if (aVarA == null) {
                    aVarA = this.f1279b.a();
                    this.f1278a.put(str, aVarA);
                }
                aVarA.f1281b++;
            } catch (Throwable th) {
                throw th;
            }
        }
        aVarA.f1280a.lock();
    }

    void b(String str) {
        a aVar;
        synchronized (this) {
            try {
                aVar = (a) X0.j.d(this.f1278a.get(str));
                int i5 = aVar.f1281b;
                if (i5 < 1) {
                    throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.f1281b);
                }
                int i6 = i5 - 1;
                aVar.f1281b = i6;
                if (i6 == 0) {
                    a aVarRemove = this.f1278a.remove(str);
                    if (!aVarRemove.equals(aVar)) {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + aVarRemove + ", safeKey: " + str);
                    }
                    this.f1279b.b(aVarRemove);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        aVar.f1280a.unlock();
    }
}
