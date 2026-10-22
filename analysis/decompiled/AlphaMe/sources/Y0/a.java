package Y0;

import android.content.Context;
import android.content.SharedPreferences;
import com.stepos.statsrpk.c;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final ReentrantLock f2115c = new ReentrantLock();

    /* renamed from: d, reason: collision with root package name */
    public static a f2116d;

    /* renamed from: a, reason: collision with root package name */
    public final ReentrantLock f2117a = new ReentrantLock();

    /* renamed from: b, reason: collision with root package name */
    public final SharedPreferences f2118b;

    public a(Context context) {
        this.f2118b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static a a(Context context) {
        c.l(context);
        ReentrantLock reentrantLock = f2115c;
        reentrantLock.lock();
        try {
            if (f2116d == null) {
                f2116d = new a(context.getApplicationContext());
            }
            a aVar = f2116d;
            reentrantLock.unlock();
            return aVar;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final String b(String str) {
        ReentrantLock reentrantLock = this.f2117a;
        reentrantLock.lock();
        try {
            return this.f2118b.getString(str, null);
        } finally {
            reentrantLock.unlock();
        }
    }
}
