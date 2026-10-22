package androidx.work.impl.utils;

import android.content.Context;
import androidx.work.ProgressUpdater;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class x implements ProgressUpdater {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f5876c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WorkDatabase f5877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TaskExecutor f5878b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UUID f5879a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ androidx.work.c f5880b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ androidx.work.impl.utils.futures.a f5881c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ x f5882d;

        public a(x r10, UUID r11, androidx.work.c r12, androidx.work.impl.utils.futures.a r13) {
            this.f5882d = r10;
            this.f5879a = r11;
            this.f5880b = r12;
            this.f5881c = r13;
        }

        @Override // java.lang.Runnable
        public void run() {
            String r10 = this.f5879a.toString();
            androidx.work.i r11 = androidx.work.i.e();
            String r12 = x.f5876c;
            r11.a(r12, "Updating progress for " + this.f5879a + " (" + this.f5880b + ")");
            this.f5882d.f5877a.e();
            androidx.work.impl.model.o r13 = this.f5882d.f5877a.L().getWorkSpec(r10);     // Catch: Throwable -> L8
            if (r13 == null) goto L14;
            if (r13.f5671b != WorkInfo.State.RUNNING) goto L10;
            this.f5882d.f5877a.K().insert(new androidx.work.impl.model.l(r10, this.f5880b));     // Catch: Throwable -> L8
        L11:
            this.f5881c.p(null);     // Catch: Throwable -> L8
            this.f5882d.f5877a.D();     // Catch: Throwable -> L8
        L12:
            this.f5882d.f5877a.i();
            return;
        L10:
            androidx.work.i.e().k(r12, "Ignoring setProgressAsync(...). WorkSpec (" + r10 + ") is not in a RUNNING state.");     // Catch: Throwable -> L8
            goto L11
        L14:
            throw new IllegalStateException("Calls to setProgressAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            androidx.work.i.e().d(x.f5876c, "Error updating Worker progress", th);     // Catch: Throwable -> L18
            this.f5881c.q(th);     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            this.f5882d.f5877a.i();
            throw th;
        }
    }

    static {
        f5876c = androidx.work.i.i("WorkProgressUpdater");
    }

    public x(WorkDatabase r10, TaskExecutor r11) {
        this.f5877a = r10;
        this.f5878b = r11;
    }

    @Override // androidx.work.ProgressUpdater
    public ListenableFuture updateProgress(Context r10, UUID r11, androidx.work.c r12) {
        androidx.work.impl.utils.futures.a r13 = androidx.work.impl.utils.futures.a.t();
        this.f5878b.executeOnTaskThread(new a(this, r11, r12, r13));
        return r13;
    }
}
