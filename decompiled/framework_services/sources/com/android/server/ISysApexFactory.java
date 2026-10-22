package com.android.server;

import android.content.Context;
import com.android.server.alarm.IAlarmManagerServiceOptEx;
import com.android.server.job.JobSchedulerService;
import com.android.server.job.restrictions.JobRestriction;

/* JADX INFO: loaded from: classes.dex */
public interface ISysApexFactory {
    default JobRestriction getPowerSaverRestriction(Context context, final JobSchedulerService service) {
        return new AnonymousClass1(this, service);
    }

    default IAlarmManagerServiceOptEx getAlarmMS() {
        return new AnonymousClass2(this);
    }

    default IDeviceIdleControllerOptEx getDeviceIdleController() {
        return new AnonymousClass3(this);
    }
}
