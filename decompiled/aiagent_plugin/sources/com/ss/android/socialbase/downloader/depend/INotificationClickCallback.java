package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes4.dex */
public interface INotificationClickCallback {
    boolean onClickWhenInstalled(DownloadInfo r1);

    boolean onClickWhenSuccess(DownloadInfo r1);

    boolean onClickWhenUnSuccess(DownloadInfo r1);
}
