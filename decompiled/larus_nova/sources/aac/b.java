package aac;

import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.usersetting.base.UserSetting;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f2378d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile UserSetting f2379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReadWriteLock f2380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<a, Object> f2381c;

    public interface a {
        void a(UserSetting r100, UserSetting r101);
    }

    static {
        f2378d = new Object();
    }

    public final UserSetting a() {
        ((ReentrantReadWriteLock) this.f2380b).readLock().lock();     // Catch: Throwable -> L5
        UserSetting r100 = this.f2379a;     // Catch: Throwable -> L5
        ((ReentrantReadWriteLock) this.f2380b).readLock().unlock();
        return r100;
    L5:
        th = move-exception;
        ((ReentrantReadWriteLock) this.f2380b).readLock().unlock();
        throw th;
    }

    public b() {
        this.f2380b = new ReentrantReadWriteLock();
        this.f2381c = new ConcurrentHashMap();
    }

    public final void b(UserSetting r100) {
        if (r100 != null) goto L16;
        return;
    L16:
        ((ReentrantReadWriteLock) this.f2380b).writeLock().lock();     // Catch: Throwable -> L13
        if (this.f2379a != null) goto L7;
    L10:
        UserSetting r101 = this.f2379a;     // Catch: Throwable -> L13
        this.f2379a = r100;     // Catch: Throwable -> L13
        CoreThreadPool.getSerialTaskHandler().post(new aac.a(this, r101));     // Catch: Throwable -> L13
    L11:
        ((ReentrantReadWriteLock) this.f2380b).writeLock().unlock();
        return;
    L7:
        if (r100.compareTo2(this.f2379a) >= 0) goto L10;
        Log.e("UserSettingCache", "update user setting fail for older userSetting");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        ((ReentrantReadWriteLock) this.f2380b).writeLock().unlock();
        throw th;
    }
}
