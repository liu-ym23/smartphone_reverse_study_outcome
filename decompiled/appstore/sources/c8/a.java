package c8;

import android.app.job.JobInfo;
import com.bytedanceos.appstore.job.AppStoreJobService;
import com.bytedanceos.common.download.IJobScheduler;

/* JADX INFO: loaded from: classes2.dex */
public class a extends t8.a implements IJobScheduler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f6066a;

    public a() {
    }

    public static JobInfo j(long r10) {
        return t8.a.c(t8.a.g(AppStoreJobService.class, 4401).setRequiredNetworkType(1).setMinimumLatency(r10).setOverrideDeadline(1800000));
    }

    public static JobInfo k(int r10) {
        return t8.a.e(t8.a.g(AppStoreJobService.class, 4399), r10);
    }

    public static JobInfo l(int r10) {
        return t8.a.e(t8.a.g(AppStoreJobService.class, 4402), r10);
    }

    public static JobInfo m(int r10, long r11) {
        if (r10 != 134) goto L5;
        int r12 = 4396;
        int r13 = 1;
    L6:
        JobInfo.Builder r14 = t8.a.g(AppStoreJobService.class, r12);
        if (r11 <= 0) goto L10;
        r14.setMinimumLatency(r11);
    L10:
        return t8.a.h(r14, r13);
    L5:
        r12 = 4397;
        r13 = 2;
        goto L6
    }

    public static JobInfo n() {
        return t8.a.h(t8.a.g(AppStoreJobService.class, 4395), 1);
    }

    public static JobInfo o() {
        return t8.a.h(t8.a.g(AppStoreJobService.class, 4398), 1);
    }

    public static JobInfo p() {
        return t8.a.f(t8.a.g(AppStoreJobService.class, 4394), 1, 86400000);
    }

    public static JobInfo q() {
        return t8.a.h(t8.a.g(AppStoreJobService.class, 4393), 2);
    }

    public static a r() {
        if (f6066a != null) goto L6;
        f6066a = new a();
    L6:
        return f6066a;
    }

    public static boolean s() {
        if (t8.a.i(4396) == false) goto L5;
    L8:
        return true;
    L5:
        if (t8.a.i(4397) == true) goto L8;
        return false;
    }

    @Override // com.bytedanceos.common.download.IJobScheduler
    public void addAdsReportScheduler(long r10) {
        t8.a.a(j(r10));
    }

    @Override // com.bytedanceos.common.download.IJobScheduler
    public void addUploadInstalledAppsScheduler() {
        t8.a.a(p());
    }

    @Override // com.bytedanceos.common.download.IJobScheduler
    public void downloadNext() {
        t8.a.a(o());
    }
}
