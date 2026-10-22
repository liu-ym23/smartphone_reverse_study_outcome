package k2;

import android.app.job.JobParameters;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;

/* renamed from: k2.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class RunnableC4811c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final JobInfoSchedulerService f34593a;

    /* renamed from: b, reason: collision with root package name */
    public final JobParameters f34594b;

    public RunnableC4811c(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        this.f34593a = jobInfoSchedulerService;
        this.f34594b = jobParameters;
    }

    public static Runnable a(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        return new RunnableC4811c(jobInfoSchedulerService, jobParameters);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f34593a.jobFinished(this.f34594b, false);
    }
}
