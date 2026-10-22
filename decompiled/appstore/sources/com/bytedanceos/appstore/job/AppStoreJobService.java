package com.bytedanceos.appstore.job;

import android.app.job.JobParameters;
import android.os.Message;
import com.bytedanceos.appstore.network.b;
import com.bytedanceos.appstore.utils.a;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.jobScheduler.BaseJobService;
import com.bytedanceos.common.network.ads.AdsReportManager;
import com.bytedanceos.common.toolbox.j;

/* JADX INFO: loaded from: classes2.dex */
public class AppStoreJobService extends BaseJobService {
    public AppStoreJobService() {
    }

    @Override // com.bytedanceos.common.jobScheduler.BaseJobService
    public void a(Message r10) {
        JobParameters r11 = (JobParameters) r10.obj;
        j.n("[AppStatus] AppStoreJobService handleMessage =" + r10.what);
        switch(r10.what) {
            case 4393: goto L14;
            case 4394: goto L13;
            case 4395: goto L12;
            case 4396: goto L11;
            case 4397: goto L10;
            case 4398: goto L9;
            case 4399: goto L8;
            case 4400: goto L7;
            case 4401: goto L6;
            case 4402: goto L5;
            default: goto L25;
        };
    L5:
        a.D(r11.getExtras().getInt("retry_time"));
        return;
    L6:
        AdsReportManager.h().u();
        return;
    L7:
        a.m();
        return;
    L8:
        a.C(r11.getExtras().getInt("retry_time"));
        return;
    L9:
        a.u();
        return;
    L10:
        a.E(this, 133);
        return;
    L11:
        a.E(this, 134);
        return;
    L12:
        new Thread(new b(BaseApplication.c())).start();
        return;
    L13:
        b8.a.f(BaseApplication.c()).e();
        return;
    L14:
        a.G();
        return;
    }
}
