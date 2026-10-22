package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.RunnableScheduler;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class WorkTimer {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f5784e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RunnableScheduler f5785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f5786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f5787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f5788d;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface TimeLimitExceededListener {
        void onTimeLimitExceeded(@NonNull androidx.work.impl.model.i r10);
    }

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WorkTimer f5789a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final androidx.work.impl.model.i f5790b;

        public a(WorkTimer r10, androidx.work.impl.model.i r11) {
            this.f5789a = r10;
            this.f5790b = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object r10 = this.f5789a.f5788d;
            monitor-enter(r10);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (((a) this.f5789a.f5786b.remove(this.f5790b)) == null) goto L11;
            TimeLimitExceededListener r11 = (TimeLimitExceededListener) this.f5789a.f5787c.remove(this.f5790b);     // Catch: Throwable -> L9
            if (r11 == null) goto L12;
            r11.onTimeLimitExceeded(this.f5790b);     // Catch: Throwable -> L9
        L12:
            monitor-exit(r10);     // Catch: Throwable -> L9
            return;
        L11:
            androidx.work.i.e().a("WrkTimerRunnable", String.format("Timer with %s is already marked as complete.", new Object[]{this.f5790b}));     // Catch: Throwable -> L9
            goto L12
        }
    }

    static {
        f5784e = androidx.work.i.i("WorkTimer");
    }

    public WorkTimer(RunnableScheduler r10) {
        this.f5786b = new HashMap();
        this.f5787c = new HashMap();
        this.f5788d = new Object();
        this.f5785a = r10;
    }

    public void a(androidx.work.impl.model.i r10, long r11, TimeLimitExceededListener r12) {
        Object r13 = this.f5788d;
        monitor-enter(r13);
        androidx.work.i.e().a(f5784e, "Starting timer for " + r10);     // Catch: Throwable -> L7
        b(r10);     // Catch: Throwable -> L7
        a r14 = new a(this, r10);     // Catch: Throwable -> L7
        this.f5786b.put(r10, r14);     // Catch: Throwable -> L7
        this.f5787c.put(r10, r12);     // Catch: Throwable -> L7
        this.f5785a.scheduleWithDelay(r11, r14);     // Catch: Throwable -> L7
        monitor-exit(r13);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void b(androidx.work.impl.model.i r10) {
        Object r11 = this.f5788d;
        monitor-enter(r11);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (((a) this.f5786b.remove(r10)) == null) goto L9;
        androidx.work.i.e().a(f5784e, "Stopping timer for " + r10);     // Catch: Throwable -> L7
        this.f5787c.remove(r10);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r11);     // Catch: Throwable -> L7
    }
}
