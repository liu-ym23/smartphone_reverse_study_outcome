package com.ss.android.socialbase.downloader.notification;

import android.content.Intent;
import android.os.IBinder;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.volcengine.zeus.service.PluginService;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadNotificationService extends PluginService {
    public IBinder onBind(Intent r1) {
        return null;
    }

    public DownloadNotificationService() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate() {
        super/*android.app.Service*/.onCreate();
        DownloadComponentManager.setAppContext(this);
        DownloadNotificationServiceImpl.getInstance().init();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDestroy() {
        super/*android.app.Service*/.onDestroy();
        DownloadNotificationServiceImpl.getInstance().onDestroy();
    }

    public int onStartCommand(Intent r1, int r2, int r3) {
        DownloadNotificationServiceImpl.getInstance().handleIntent(r1);
        return 2;
    }
}
