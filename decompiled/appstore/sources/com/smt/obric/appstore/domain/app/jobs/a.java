package com.smt.obric.appstore.domain.app.jobs;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.os.PersistableBundle;
import com.bytedance.apm.constant.PerfTraceConsts;
import com.bytedanceos.common.toolbox.j;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.c;
import kotlin.collections.k0;
import kotlin.d;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18032a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f18033b = null;

    static {
        f18032a = new a();
        f18033b = k0.j(new Pair[]{d.a(200001, "AppInstallRetryJob"), d.a(200002, "AppWifiDownloadJob")});
    }

    public a() {
    }

    public final JobInfo a(Context r10) {
        JobInfo.Builder r11 = new JobInfo.Builder(200001, AppInstallJobService.f18027e.b(r10)).setPersisted(true).setMinimumLatency(60000).setOverrideDeadline(180000).setBackoffCriteria(PerfTraceConsts.LAUNCH_TRACE_COLLECT_INFO_TIME_MS, 0);
        PersistableBundle r12 = new PersistableBundle();
        r12.putString("job_name", (String) f18033b.get(200001));
        JobInfo r13 = r11.setExtras(r12).build();
        q.f(r13, "build(...)");
        return r13;
    }

    public final JobInfo b(Context r10) {
        JobInfo.Builder r11 = new JobInfo.Builder(200002, AppInstallJobService.f18027e.b(r10)).setPersisted(true).setRequiredNetworkType(2);
        PersistableBundle r12 = new PersistableBundle();
        r12.putString("job_name", (String) f18033b.get(200002));
        JobInfo r13 = r11.setExtras(r12).build();
        q.f(r13, "build(...)");
        return r13;
    }

    public final void c(Context r11, JobInfo r12) {
        JobScheduler r10 = com.smt.obric.appstore.ktx.a.c(r11);
        int r13 = r12.getId();
        JobInfo r14 = r10.getPendingJob(r12.getId());
        Object r15 = null;
        if (r14 == null) goto L32;
        StringBuilder r16 = new StringBuilder();
        r16.append("[AppStatus][Job] scheduleAppInstallRetryJob: schedule skip: exist: id=");
        r16.append(r13);
        r16.append(", name=");
        r16.append((String) f18033b.get(Integer.valueOf(r13)));
        r16.append(", minLatency=");
        if (r14 == null) goto L7;
        Long r17 = Long.valueOf(r14.getMinLatencyMillis());
    L8:
        r16.append(r17);
        r16.append(", maxExecutionDelayMillis=");
        if (r14 == null) goto L11;
        r15 = Long.valueOf(r14.getMaxExecutionDelayMillis());
    L11:
        r16.append(r15);
        r16.append('}');
        j.n(r16.toString());
        return;
    L7:
        r17 = null;
        goto L8
    L32:
        Result.a r18 = Result.Companion;     // Catch: Throwable -> L15
        Object r19 = Result.m35constructorimpl(Integer.valueOf(r10.schedule(r12)));     // Catch: Throwable -> L15
    L17:
        Throwable r20 = Result.m38exceptionOrNullimpl(r19);
        if (r20 == null) goto L21;
        j.q("[AppStatus][Job] scheduleAppInstallRetryJob: schedule fail: id=" + r13 + ", name=" + ((String) f18033b.get(Integer.valueOf(r13))), r20);
    L21:
        if (Result.m41isFailureimpl(r19) == true) goto L24;
        r15 = r19;
    L24:
        Integer r21 = (Integer) r15;
        if (r21 != null) goto L28;
    L29:
        j.p("[AppStatus][Job] scheduleAppInstallRetryJob: schedule fail: id=" + r13 + ", name=" + ((String) f18033b.get(Integer.valueOf(r13))) + ", result=" + r21);
    L30:
        j.n("[AppStatus][Job] scheduleAppInstallRetryJob: schedule success: id=" + r13 + ", name=" + ((String) f18033b.get(Integer.valueOf(r13))) + ", minLatency=" + r12.getMinLatencyMillis() + ", maxExecutionDelayMillis=" + r12.getMaxExecutionDelayMillis() + '}');
        return;
    L28:
        if (r21.intValue() == 1) goto L30;
    L15:
        th = move-exception;
        Result.a r22 = Result.Companion;
        r19 = Result.m35constructorimpl(c.a(th));
        goto L17
    }

    public final JobInfo d(Context r10) {
        q.g(r10, "context");
        JobInfo r11 = a(r10);
        c(r10, r11);
        return r11;
    }

    public final JobInfo e(Context r10) {
        q.g(r10, "context");
        JobInfo r11 = b(r10);
        c(r10, r11);
        return r11;
    }
}
