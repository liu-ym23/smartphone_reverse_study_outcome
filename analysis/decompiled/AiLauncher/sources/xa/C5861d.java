package xa;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.p;

/* renamed from: xa.d, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5861d implements kotlin.reflect.jvm.internal.impl.storage.a {

    /* renamed from: b, reason: collision with root package name */
    public final Lock f43604b;

    public C5861d(Lock lock) {
        p.i(lock, "lock");
        this.f43604b = lock;
    }

    public final Lock a() {
        return this.f43604b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.a
    public void lock() {
        this.f43604b.lock();
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.a
    public void unlock() {
        this.f43604b.unlock();
    }

    public /* synthetic */ C5861d(Lock lock, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? new ReentrantLock() : lock);
    }
}
