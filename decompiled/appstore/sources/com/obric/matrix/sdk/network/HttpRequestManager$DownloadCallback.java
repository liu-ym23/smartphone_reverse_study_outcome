package com.obric.matrix.sdk.network;

import com.bytedance.apm.constant.PerfConsts;
import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"com/obric/matrix/sdk/network/HttpRequestManager$DownloadCallback", "", "", "progress", PerfConsts.PERF_DISK_TOTAL, "", "onProgress", "(JJ)V", "Ljava/io/File;", "file", "onSuccess", "(Ljava/io/File;)V", "", "e", "onError", "(Ljava/lang/Throwable;)V", "sdk_network_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface HttpRequestManager$DownloadCallback {
    void onError(@NotNull Throwable r10);

    void onProgress(long r10, long r11);

    void onSuccess(@NotNull File r10);
}
