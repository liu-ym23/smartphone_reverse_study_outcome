package L0;

import android.os.Message;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
public final class f {
    public static long h = 30000;

    /* renamed from: a, reason: collision with root package name */
    public volatile ExecutorService f926a;
    public final h b;
    public volatile boolean c = true;
    public final b d = new b(this, 0);
    public final b e = new b(this, 1);
    public final CopyOnWriteArraySet f = new CopyOnWriteArraySet();
    public final CopyOnWriteArraySet g = new CopyOnWriteArraySet();

    public f() {
        h hVar = new h(0);
        this.b = hVar;
        hVar.f928a.start();
    }

    public final void a(e eVar) {
        try {
            if (!this.c || this.f.contains(eVar)) {
                return;
            }
            this.f.add(eVar);
            this.b.a(this.d);
            this.b.b(this.d, 30000L);
        } catch (Throwable unused) {
        }
    }

    public final void b(Runnable runnable) {
        if (this.c) {
            h hVar = this.b;
            hVar.c(Message.obtain(hVar.d, runnable), 0L);
        }
    }

    public final void c(Runnable runnable) {
        if (this.f926a == null) {
            synchronized (this) {
                try {
                    if (this.f926a == null) {
                        this.f926a = Executors.newFixedThreadPool(1, new c());
                    }
                } finally {
                }
            }
        }
        this.f926a.submit(runnable);
    }
}
