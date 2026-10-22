package ae9;

import com.larus.im.internal.database.delegate.BotDaoSource;
import hd9.k;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ReentrantLock f3119a = null;

    static {
        f3119a = new ReentrantLock();
    }

    public static final be9.a a() {
        ReentrantLock r100 = f3119a;
        r100.lock();
        k r101 = (k) d.f3121a.getValue();     // Catch: Throwable -> L9
        if (r101 == null) goto L6;
        r101.c();     // Catch: Throwable -> L9
    L6:
        BotDaoSource r102 = new BotDaoSource();     // Catch: Throwable -> L9
        r100.unlock();
        return r102;
    L9:
        th = move-exception;
        r100.unlock();
        throw th;
    }
}
