package com.ss.android.socialbase.downloader.exception;

import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadOutOfSpaceException extends BaseException {
    private final long avaliableSpaceBytes;
    private final long requiredSpaceBytes;

    public DownloadOutOfSpaceException(long r7, long r9) {
        super(1006, String.format(Locale.US, "space is not enough required space is : %d but available space is :%d", new Object[]{Long.valueOf(r9), Long.valueOf(DownloadUtils.getReportableSpaceMB(r7) * 1048576)}));
        this.avaliableSpaceBytes = r7;
        this.requiredSpaceBytes = r9;
    }

    public long getAvaliableSpaceBytes() {
        return this.avaliableSpaceBytes;
    }

    public long getRequiredSpaceBytes() {
        return this.requiredSpaceBytes;
    }
}
