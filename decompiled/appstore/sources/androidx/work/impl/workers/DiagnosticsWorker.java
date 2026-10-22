package androidx.work.impl.workers;

import android.content.Context;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.h;
import androidx.work.i;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.c0;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.model.o;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import m0.d;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/work/impl/workers/DiagnosticsWorker;", "Landroidx/work/Worker;", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "parameters", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Landroidx/work/h$a;", "n", "()Landroidx/work/h$a;", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DiagnosticsWorker extends Worker {
    public DiagnosticsWorker(@NotNull Context r10, @NotNull WorkerParameters r11) {
        q.g(r10, "context");
        q.g(r11, "parameters");
        super(r10, r11);
    }

    @Override // androidx.work.Worker
    public h.a n() {
        c0 r10 = c0.l(a());
        q.f(r10, "getInstance(applicationContext)");
        WorkDatabase r11 = r10.q();
        q.f(r11, "workManager.workDatabase");
        WorkSpecDao r12 = r11.L();
        WorkNameDao r13 = r11.J();
        WorkTagDao r14 = r11.M();
        SystemIdInfoDao r15 = r11.I();
        List<o> r16 = r12.getRecentlyCompletedWork(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1));
        List<o> r17 = r12.getRunningWork();
        List<o> r18 = r12.getAllEligibleWorkSpecsForScheduling(200);
        if (r16.isEmpty() == true) goto L6;
        i.e().f(d.a(), "Recently completed work:\n\n");
        i.e().f(d.a(), d.b(r13, r14, r15, r16));
    L6:
        if (r17.isEmpty() == true) goto L9;
        i.e().f(d.a(), "Running work:\n\n");
        i.e().f(d.a(), d.b(r13, r14, r15, r17));
    L9:
        if (r18.isEmpty() == true) goto L11;
        i.e().f(d.a(), "Enqueued work:\n\n");
        i.e().f(d.a(), d.b(r13, r14, r15, r18));
    L11:
        h.a r19 = h.a.c();
        q.f(r19, "success()");
        return r19;
    }
}
