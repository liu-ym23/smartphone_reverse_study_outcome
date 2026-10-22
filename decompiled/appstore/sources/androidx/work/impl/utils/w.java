package androidx.work.impl.utils;

import android.content.Context;
import android.content.Intent;
import androidx.work.ForegroundUpdater;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class w implements ForegroundUpdater {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f5867d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TaskExecutor f5868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ForegroundProcessor f5869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WorkSpecDao f5870c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.work.impl.utils.futures.a f5871a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ UUID f5872b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ androidx.work.d f5873c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f5874d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ w f5875e;

        public a(w r10, androidx.work.impl.utils.futures.a r11, UUID r12, androidx.work.d r13, Context r14) {
            this.f5875e = r10;
            this.f5871a = r11;
            this.f5872b = r12;
            this.f5873c = r13;
            this.f5874d = r14;
        }

        @Override // java.lang.Runnable
        public void run() {
        L9:
            th = move-exception;
            this.f5871a.q(th);
            return;
        L3:
            if (this.f5871a.isCancelled() == true) goto L13;
            String r10 = this.f5872b.toString();     // Catch: Throwable -> L9
            androidx.work.impl.model.o r11 = this.f5875e.f5870c.getWorkSpec(r10);     // Catch: Throwable -> L9
            if (r11 == null) goto L12;
            if (r11.f5671b.isFinished() == true) goto L12;
            this.f5875e.f5869b.startForeground(r10, this.f5873c);     // Catch: Throwable -> L9
            Intent r12 = SystemForegroundDispatcher.b(this.f5874d, androidx.work.impl.model.q.a(r11), this.f5873c);     // Catch: Throwable -> L9
            this.f5874d.startService(r12);     // Catch: Throwable -> L9
        L12:
            throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");     // Catch: Throwable -> L9
        L13:
            this.f5871a.p(null);     // Catch: Throwable -> L9
        }
    }

    static {
        f5867d = androidx.work.i.i("WMFgUpdater");
    }

    public w(WorkDatabase r10, ForegroundProcessor r11, TaskExecutor r12) {
        this.f5869b = r11;
        this.f5868a = r12;
        this.f5870c = r10.L();
    }

    @Override // androidx.work.ForegroundUpdater
    public ListenableFuture setForegroundAsync(Context r10, UUID r11, androidx.work.d r12) {
        androidx.work.impl.utils.futures.a r13 = androidx.work.impl.utils.futures.a.t();
        this.f5868a.executeOnTaskThread(new a(this, r13, r11, r12, r10));
        return r13;
    }
}
