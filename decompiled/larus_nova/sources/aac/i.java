package aac;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes38.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f2397a;

    public final void a() {
        Log.i("UserSettingService", "unInit user setting service");
        Object r100 = f.f2385c;
        f r101 = f.c.f2388a;
        g.a r102 = this.f2397a.f2391c;
        if (r102 != null) goto L5;
        r101.getClass();
    L6:
        b r103 = this.f2397a.f2389a;
        r103.getClass();
        ((ReentrantReadWriteLock) r103.f2380b).writeLock().lock();     // Catch: Throwable -> L10
        r103.f2379a = null;     // Catch: Throwable -> L10
        ((ReentrantReadWriteLock) r103.f2380b).writeLock().unlock();
        this.f2397a.f2390b.set(false);
        return;
    L10:
        th = move-exception;
        ((ReentrantReadWriteLock) r103.f2380b).writeLock().unlock();
        throw th;
    L5:
        ((ConcurrentHashMap) r101.f2387b).remove(r102);
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public i(g r100) {
        this.f2397a = r100;
    }
}
