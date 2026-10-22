package androidx.work.impl.utils;

import android.content.Context;
import android.os.Build;
import androidx.work.ForegroundUpdater;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
public class v implements Runnable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f5858g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.work.impl.utils.futures.a f5859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f5860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final androidx.work.impl.model.o f5861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.work.h f5862d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ForegroundUpdater f5863e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TaskExecutor f5864f;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.work.impl.utils.futures.a f5865a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v f5866b;

        public a(v r10, androidx.work.impl.utils.futures.a r11) {
            this.f5866b = r10;
            this.f5865a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f5866b.f5859a.isCancelled() == false) goto L14;
            return;
        L14:
            androidx.work.d r10 = (androidx.work.d) this.f5865a.get();     // Catch: Throwable -> L8
            if (r10 == null) goto L11;
            androidx.work.i.e().a(v.f5858g, "Updating notification for " + this.f5866b.f5861c.f5672c);     // Catch: Throwable -> L8
            v r11 = this.f5866b;     // Catch: Throwable -> L8
            r11.f5859a.r(r11.f5863e.setForegroundAsync(r11.f5860b, r11.f5862d.d(), r10));     // Catch: Throwable -> L8
            return;
        L11:
            throw new IllegalStateException("Worker was marked important (" + this.f5866b.f5861c.f5672c + ") but did not provide ForegroundInfo");     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            this.f5866b.f5859a.q(th);
        }
    }

    static {
        f5858g = androidx.work.i.i("WorkForegroundRunnable");
    }

    public v(Context r10, androidx.work.impl.model.o r11, androidx.work.h r12, ForegroundUpdater r13, TaskExecutor r14) {
        this.f5859a = androidx.work.impl.utils.futures.a.t();
        this.f5860b = r10;
        this.f5861c = r11;
        this.f5862d = r12;
        this.f5863e = r13;
        this.f5864f = r14;
    }

    public static /* synthetic */ void a(v r10, androidx.work.impl.utils.futures.a r11) {
        r10.c(r11);
    }

    public ListenableFuture b() {
        return this.f5859a;
    }

    public final /* synthetic */ void c(androidx.work.impl.utils.futures.a r10) {
        if (this.f5859a.isCancelled() == true) goto L5;
        r10.r(this.f5862d.c());
        return;
    L5:
        r10.cancel(true);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f5861c.f5686q == true) goto L5;
    L9:
        this.f5859a.p(null);
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 31) goto L9;
        final androidx.work.impl.utils.futures.a r10 = androidx.work.impl.utils.futures.a.t();
        this.f5864f.getMainThreadExecutor().execute(new u(this, r10));
        r10.addListener(new a(this, r10), this.f5864f.getMainThreadExecutor());
    }
}
