package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.AbsNotificationItem;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbsNotificationListener extends AbsDownloadListener implements IDownloadExtListener {
    public abstract AbsNotificationItem createNotificationItem();

    public AbsNotificationListener() {
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPrepare(DownloadInfo r3) {
        super.onPrepare(r3);
        addNotificationItem(r3);
        updateNotification(1, r3, null, true);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onStart(DownloadInfo r4) {
        super.onStart(r4);
        updateNotification(2, r4, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onProgress(DownloadInfo r1) {
        super.onProgress(r1);
        updateNotificationProgress(r1);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPause(DownloadInfo r4) {
        super.onPause(r4);
        updateNotification(-2, r4, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onSuccessed(DownloadInfo r4) {
        super.onSuccessed(r4);
        updateNotification(-3, r4, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFailed(DownloadInfo r3, BaseException r4) {
        super.onFailed(r3, r4);
        updateNotification(-1, r3, r4, false);
    }

    private void addNotificationItem(DownloadInfo r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.canShowNotification() == false) goto L13;
        AbsNotificationItem r0 = DownloadNotificationManager.getInstance().getNotificationItem(r3.getId());
        if (r0 != null) goto L9;
        AbsNotificationItem r2 = createNotificationItem();
        DownloadNotificationManager.getInstance().addNotification(r2);
        return;
    L9:
        r0.updateNotificationItem(r3);
        return;
    }

    private void updateNotification(int r4, DownloadInfo r5, BaseException r6, boolean r7) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.canShowNotification() == true) goto L7;
        return;
    L7:
        if (r4 == 4) goto L19;
        AbsNotificationItem r0 = DownloadNotificationManager.getInstance().getNotificationItem(r5.getId());
        if (r0 != null) goto L12;
        r0 = createNotificationItem();
    L12:
        r0.setTotalBytes(r5.getTotalBytes());
        if (r4 != (-3)) goto L15;
        r0.setCurBytes(r5.getTotalBytes());
    L16:
        r0.refreshStatus(r4, r6, r7);
        return;
    L15:
        r0.setCurBytes(r5.getCurBytes());
        goto L16
    }

    private void updateNotificationProgress(DownloadInfo r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.canShowNotification() == true) goto L6;
        return;
    L6:
        if (r4.getStatus() != 4) goto L15;
        AbsNotificationItem r0 = DownloadNotificationManager.getInstance().getNotificationItem(r4.getId());
        if (r0 != null) goto L11;
        r0 = createNotificationItem();
    L11:
        r0.refreshProgress(r4.getCurBytes(), r4.getTotalBytes());
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadExtListener
    public void onWaitingDownloadCompleteHandler(DownloadInfo r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.isAutoInstallWithoutNotification() == true) goto L9;
        updateNotification(11, r4, null, true);
        return;
    }
}
