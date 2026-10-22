package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbsNotificationItem {
    private AtomicInteger clickInstallTimes;
    private long curBytes;
    private String description;
    private long firstShowTime;
    private int id;
    protected Notification notification;
    private boolean ongoing;
    private int status;
    private String title;
    private long totalBytes;

    public abstract void updateNotification(BaseException r1, boolean r2);

    public AbsNotificationItem(int r3, String r4) {
        this.status = 0;
        this.clickInstallTimes = new AtomicInteger(0);
        this.id = r3;
        this.title = r4;
    }

    public void updateNotificationItem(DownloadInfo r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.id = r2.getId();
        this.title = r2.getTitle();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int r1) {
        this.id = r1;
    }

    public long getCurBytes() {
        return this.curBytes;
    }

    public void setCurBytes(long r1) {
        this.curBytes = r1;
    }

    public long getTotalBytes() {
        return this.totalBytes;
    }

    public void setTotalBytes(long r1) {
        this.totalBytes = r1;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String r1) {
        this.title = r1;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String r1) {
        this.description = r1;
    }

    public int getStatus() {
        return this.status;
    }

    public void refreshStatus(int r2, BaseException r3, boolean r4) {
        refreshStatus(r2, r3, r4, false);
    }

    public void refreshStatus(int r1, BaseException r2, boolean r3, boolean r4) {
        if (r4 == false) goto L4;
    L6:
        this.status = r1;
        updateNotification(r2, r3);
        return;
    L4:
        if (this.status != r1) goto L6;
    }

    public long getFirstShowTime() {
        if (this.firstShowTime != 0) goto L6;
        this.firstShowTime = System.currentTimeMillis();
    L6:
        return this.firstShowTime;
    }

    public void refreshProgress(long r1, long r3) {
        this.curBytes = r1;
        this.totalBytes = r3;
        this.status = 4;
        updateNotification(null, false);
    }

    public void notify(Notification r3) {
        if (this.id == 0) goto L8;
        if (r3 == null) goto L9;
        DownloadNotificationManager.getInstance().notifyByService(this.id, this.status, r3);
        return;
    L9:
        return;
    }

    public void cancel() {
        if (this.id != 0) goto L5;
        return;
    L5:
        DownloadNotificationManager.getInstance().cancel(this.id);
    }

    public void recordClickInstall() {
        this.clickInstallTimes.incrementAndGet();
    }

    public int getClickInstallTimes() {
        return this.clickInstallTimes.get();
    }

    public boolean isOngoing() {
        return this.ongoing;
    }

    public void setOngoing(boolean r1) {
        this.ongoing = r1;
    }

    public Notification getNotification() {
        return this.notification;
    }
}
