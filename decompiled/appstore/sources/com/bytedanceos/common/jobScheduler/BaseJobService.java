package com.bytedanceos.common.jobScheduler;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.toolbox.j;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(21)
public abstract class BaseJobService extends JobService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Looper f9828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile a f9829b;

    public final class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseJobService f9830a;

        public a(BaseJobService r10, Looper r11) {
            this.f9830a = r10;
            super(r11);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            this.f9830a.a(r10);
            this.f9830a.jobFinished((JobParameters) r10.obj, false);
            j.n("JobService finish:" + r10.what);
        }
    }

    public BaseJobService() {
    }

    public abstract void a(Message r10);

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        HandlerThread r10 = new HandlerThread("AppJobTask");
        r10.start();
        this.f9828a = r10.getLooper();
        if (this.f9828a != null) goto L5;
        this.f9828a = Looper.getMainLooper();
        j.a("main looper");
    L5:
        this.f9829b = new a(this, this.f9828a);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f9828a.quit();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r10, int r11, int r12) {
        j.a("onStartCommand");
        return 2;
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters r10) {
        BaseApplication.u("BaseJobService", false);
        Message r11 = this.f9829b.obtainMessage();
        r11.what = r10.getJobId();
        r11.obj = r10;
        this.f9829b.sendMessage(r11);
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters r10) {
        BaseApplication.u("BaseJobService", true);
        j.t("onStopJob stop jobId " + r10.getJobId());
        return false;
    }
}
