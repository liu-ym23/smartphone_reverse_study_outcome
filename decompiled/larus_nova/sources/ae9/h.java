package ae9;

import com.larus.im.internal.database.delegate.ParticipantDaoSource;
import hd9.k;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes29.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ReentrantLock f3124a = null;

    static {
        f3124a = new ReentrantLock();
    }

    public static final be9.e a() {
        ReentrantLock r100 = f3124a;
        r100.lock();
        k r101 = (k) d.f3121a.getValue();     // Catch: Throwable -> L9
        if (r101 == null) goto L6;
        r101.a();     // Catch: Throwable -> L9
    L6:
        ParticipantDaoSource r102 = new ParticipantDaoSource();     // Catch: Throwable -> L9
        r100.unlock();
        return r102;
    L9:
        th = move-exception;
        r100.unlock();
        throw th;
    }
}
