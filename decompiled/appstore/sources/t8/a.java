package t8;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.PersistableBundle;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.ad.common.AdConstant;
import com.bytedanceos.common.toolbox.j;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public a() {
    }

    public static void a(JobInfo r10) {
        b(r10, "");
    }

    public static void b(JobInfo r10, String r11) {
        JobScheduler r12 = (JobScheduler) BaseApplication.c().getSystemService("jobscheduler");
        if (i(r10.getId()) == true) goto L5;
        j.n(r11 + ": register Scheduler: schedule" + r10.getId());
        r12.schedule(r10);
        return;
    L5:
        j.n(r11 + ": register Scheduler:  hasScheduler" + r10.getId());
    }

    public static JobInfo c(JobInfo.Builder r10) {
        return r10.setPersisted(true).build();
    }

    public static void d(int r10) {
        JobScheduler r11 = (JobScheduler) BaseApplication.c().getSystemService("jobscheduler");
        if (i(r10) == false) goto L6;
        r11.cancel(r10);
        j.n("cancel job scheduler:" + r10);
        return;
    }

    public static JobInfo e(JobInfo.Builder r10, int r11) {
        long r12 = ((long) (1 - r11)) * 1800000;
        long r13 = 300000 + r12;
        r10.setMinimumLatency(r13);
        r10.setOverrideDeadline(r12 + AdConstant.SPLASH_AD_INTERVAL);
        PersistableBundle r14 = new PersistableBundle();
        r14.putInt("retry_time", r11);
        r10.setExtras(r14);
        j.n("[AutoUpdate][JOB] createAutoUpdateJob id=" + r10.build().getId() + ", inLatencyMillis =" + r13);
        return h(r10, 2);
    }

    public static JobInfo f(JobInfo.Builder r10, int r11, long r12) {
        return c(r10.setPeriodic(r12).setRequiredNetworkType(r11));
    }

    public static JobInfo.Builder g(Class r10, int r11) {
        return new JobInfo.Builder(r11, new ComponentName(BaseApplication.c(), r10));
    }

    public static JobInfo h(JobInfo.Builder r10, int r11) {
        return c(r10.setRequiredNetworkType(r11));
    }

    public static boolean i(int r10) {
        List<JobInfo> r11 = ((JobScheduler) BaseApplication.c().getSystemService("jobscheduler")).getAllPendingJobs();     // Catch: IllegalArgumentException -> L5
    L7:
        if (r11 == null) goto L15;
        Iterator<JobInfo> r12 = r11.iterator();
    L10:
        if (r12.hasNext() == false) goto L22;
        JobInfo r13 = r12.next();
        if (r13.getId() != r10) goto L10;
        j.e("Repeat Scheduler has exsited:" + r10 + ", job interval time " + r13.getIntervalMillis());
        return true;
    L22:
        return false;
    L15:
        return false;
    L5:
        e = move-exception;
        e.printStackTrace();
        r11 = null;
        goto L7
    }
}
