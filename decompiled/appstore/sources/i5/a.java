package i5;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.apm.constant.PerfConsts;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Class f20500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Field f20501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Object f20502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Object f20503d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Set f20504e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Class f20505f;

    /* JADX INFO: renamed from: i5.a$a, reason: collision with other inner class name */
    public static class RunnableC0268a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f20506a;

        public RunnableC0268a(Object r10) {
            this.f20506a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.a(f.h(a.b(), "currentActivityThread", new Object[0]));     // Catch: Throwable -> L11 Exception -> L20
            Object r10 = this.f20506a;
            monitor-enter(r10);
            this.f20506a.notify();     // Catch: Throwable -> L8
            monitor-exit(r10);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        L11:
            th = move-exception;
            monitor-enter(this.f20506a);
            this.f20506a.notify();     // Catch: Throwable -> L17
            throw th;
        L17:
            th = move-exception;
            throw th;
        L21:
            monitor-enter(this.f20506a);
            this.f20506a.notify();     // Catch: Throwable -> L25
            return;
        L25:
            th = move-exception;
            throw th;
        }
    }

    static {
        HashSet r10 = new HashSet();
        f20504e = r10;
        r10.add(113);
        f20504e.add(114);
        f20504e.add(115);
        f20504e.add(116);
        f20504e.add(121);
        f20504e.add(122);
        f20504e.add(100);
        f20504e.add(159);
        f20504e.add(123);
    }

    public static /* synthetic */ Object a(Object r10) {
        f20502c = r10;
        return r10;
    }

    public static /* synthetic */ Class b() {
        return f20505f;
    }

    public static Object c() {
        if (f20502c != null) goto L37;
        monitor-enter(a.class);     // Catch: Exception -> L34
    L11:
        th = move-exception;
        throw th;     // Catch: Exception -> L34
    L7:
        if (f20502c != null) goto L15;
        if (f20505f != null) goto L13;
        f20505f = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L11
    L13:
        f20502c = f.h(f20505f, "currentActivityThread", new Object[0]);     // Catch: Throwable -> L11
    L15:
        if (f20502c == null) goto L17;
    L30:
        monitor-exit(a.class);     // Catch: Throwable -> L11
        goto L37
    L17:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L30;
        Object r10 = new Object();     // Catch: Throwable -> L11
        new Handler(Looper.getMainLooper()).post(new RunnableC0268a(r10));     // Catch: Throwable -> L11
        if (f20502c != null) goto L30;
        monitor-enter(r10);     // Catch: Throwable -> L11
        r10.wait(PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS);     // Catch: Throwable -> L24 InterruptedException -> L38
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L26:
        monitor-exit(r10);     // Catch: Throwable -> L24
    L34:
        e = move-exception;
        e.printStackTrace();
    L37:
        return f20502c;
    }

    public static synchronized Class d() {
        monitor-enter(a.class);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (f20500a == null) goto L19;
    L12:
        Class r10 = f20500a;     // Catch: Throwable -> L8
        monitor-exit(a.class);
        return r10;
    L19:
        f20500a = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L8 ClassNotFoundException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
        goto L12
    }

    public static synchronized Field e() {
        monitor-enter(a.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (f20501b != null) goto L9;
        f20501b = b.a(d(), "mH");     // Catch: Throwable -> L7
    L9:
        Field r10 = f20501b;     // Catch: Throwable -> L7
        monitor-exit(a.class);
        return r10;
    }

    public static synchronized Object f() {
        monitor-enter(a.class);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (f20503d == null) goto L19;
    L12:
        Object r10 = f20503d;     // Catch: Throwable -> L8
        monitor-exit(a.class);
        return r10;
    L19:
        f20503d = e().get(g());     // Catch: Throwable -> L8 IllegalAccessException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
        goto L12
    }

    public static synchronized Object g() {
        monitor-enter(a.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (f20502c != null) goto L9;
        f20502c = f.h(d(), "currentActivityThread", new Object[0]);     // Catch: Throwable -> L7 Throwable -> L14
    L9:
        Object r10 = f20502c;     // Catch: Throwable -> L7 Throwable -> L14
        monitor-exit(a.class);
        return r10;
    L15:
        return null;
    }

    public static boolean h(Message r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if (f20504e.contains(Integer.valueOf(r10.what)) == false) goto L9;
        return true;
    L9:
        return false;
    }
}
