package com.bytedanceos.appstore.PreloadInstall;

import android.os.Message;
import com.bytedanceos.common.jobScheduler.BaseJobService;
import com.bytedanceos.common.toolbox.j;

/* JADX INFO: loaded from: classes2.dex */
public class SyncPreloadInstallAppsJobService extends BaseJobService {
    public SyncPreloadInstallAppsJobService() {
    }

    @Override // com.bytedanceos.common.jobScheduler.BaseJobService
    public void a(Message r10) {
        j.e("AppStoreJobService handleMessage =" + r10.what);
        if (r10.what != 4404) goto L7;
        b.a().c();
        return;
    }
}
