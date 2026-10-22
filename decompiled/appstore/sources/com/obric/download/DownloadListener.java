package com.obric.download;

import com.bytedanceos.common.toolbox.ServerElements;
import com.obric.download.base.DownloadInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0005H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0005H&J \u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J \u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u0016"}, d2 = {"Lcom/obric/download/DownloadListener;", "", "onDownloadCancel", "", ServerElements.INFO, "Lcom/obric/download/base/DownloadInfo;", "onDownloadFailed", "errorCode", "", "errorMsg", "", "onDownloadFinish", "onDownloadPause", "onDownloadPending", "onDownloadStart", "onDownloading", "onExtraInfoUpdate", "onFirstStart", "entity", "onFirstSuccess", "onRetry", "onRetryDelay", "sdk_release"}, k = 1, mv = {1, 4, 3})
public interface DownloadListener {
    void onDownloadCancel(@NotNull DownloadInfo r10);

    void onDownloadFailed(@NotNull DownloadInfo r10, int r11, @NotNull String r12);

    void onDownloadFinish(@NotNull DownloadInfo r10);

    void onDownloadPause(@NotNull DownloadInfo r10);

    void onDownloadPending(@NotNull DownloadInfo r10);

    void onDownloadStart(@NotNull DownloadInfo r10);

    void onDownloading(@NotNull DownloadInfo r10);

    void onExtraInfoUpdate(@NotNull DownloadInfo r10);

    void onFirstStart(@NotNull DownloadInfo r10);

    void onFirstSuccess(@NotNull DownloadInfo r10);

    void onRetry(@NotNull DownloadInfo r10, int r11, @NotNull String r12);

    void onRetryDelay(@NotNull DownloadInfo r10, int r11, @NotNull String r12);
}
