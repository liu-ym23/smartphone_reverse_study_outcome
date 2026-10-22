package u5;

import android.os.Looper;
import com.bytedance.platform.godzilla.common.UncaughtExceptionConsumer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f24867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f24868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f24869c;

    public b() {
        this.f24869c = new LinkedList();
    }

    public boolean a(UncaughtExceptionConsumer r10) {
        List r11 = this.f24869c;
        monitor-enter(r11);
        boolean r12 = this.f24869c.add(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    public final void b(Thread r10, Throwable r11) {
        Thread.UncaughtExceptionHandler r12 = this.f24868b;
        if (r12 == null) goto L7;
        if (r12 == this) goto L8;
        r12.uncaughtException(r10, r11);
        return;
    L8:
        return;
    }

    public final boolean c(Thread r10, Throwable r11) {
        List r12 = this.f24869c;     // Catch: Throwable -> L20
        monitor-enter(r12);     // Catch: Throwable -> L20
        Iterator r13 = this.f24869c.iterator();     // Catch: Throwable -> L12
    L6:
        if (r13.hasNext() == false) goto L14;
        if (((UncaughtExceptionConsumer) r13.next()).consumeUncaughtException(r10, r11) == false) goto L6;
        monitor-exit(r12);     // Catch: Throwable -> L12
        return true;
    L14:
        monitor-exit(r12);     // Catch: Throwable -> L12
        return false;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L26:
        return false;
    }

    public final boolean d(Throwable r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        int r11 = 0;
    L6:
        if (r10 == null) goto L16;
        if ((r10 instanceof OutOfMemoryError) == true) goto L9;
        if (r11 > 20) goto L13;
        r11 = r11 + 1;     // Catch: Throwable -> L17
        r10 = r10.getCause();     // Catch: Throwable -> L17
    L13:
        return false;
    L9:
        return true;
    L16:
        return false;
    }

    public void e() {
        if (this.f24867a == false) goto L5;
        return;
    L5:
        Thread.UncaughtExceptionHandler r10 = Thread.getDefaultUncaughtExceptionHandler();
        this.f24868b = r10;
        if (r10 == this) goto L8;
        Thread.setDefaultUncaughtExceptionHandler(this);
    L9:
        this.f24867a = true;
        return;
    L8:
        this.f24868b = null;
        goto L9
    }

    public void f() {
        List r10 = this.f24869c;
        monitor-enter(r10);
        this.f24869c.clear();     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean g(UncaughtExceptionConsumer r10) {
        List r11 = this.f24869c;
        monitor-enter(r11);
        boolean r12 = this.f24869c.remove(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread r10, Throwable r11) {
    L11:
        th = move-exception;
        b(r10, th);
        return;
    L3:
        if (d(r11) == false) goto L5;
    L19:
        b(r10, r11);     // Catch: Throwable -> L11
        return;
    L5:
        if (c(r10, r11) == false) goto L19;
        if (r10 != null) goto L8;
        return;
    L8:
        if (r10.getName().equals("main") == false) goto L32;
    L23:
        Looper.loop();     // Catch: Throwable -> L11 Exception -> L13
    L13:
        e = move-exception;
        if (d(e) == true) goto L18;
        if (c(r10, e) == true) goto L23;
    L18:
        b(r10, e);     // Catch: Throwable -> L11
        return;
    }
}
