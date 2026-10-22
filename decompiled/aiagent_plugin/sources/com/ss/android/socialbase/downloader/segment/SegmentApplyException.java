package com.ss.android.socialbase.downloader.segment;

import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.exception.BaseException;

/* JADX INFO: loaded from: classes4.dex */
class SegmentApplyException extends BaseException {
    public static final int ALREADY_APPLY_BY_OTHER = 1;
    public static final int BAD_SEGMENT = 6;
    public static final int CHANGE_SEGMENT = 5;
    public static final int PREV_END_ADJUST_FAIL = 4;
    public static final int PREV_OVERSTEP = 3;
    public static final int SEGMENT_NOT_EXIST = 2;
    private int applyCode;

    SegmentApplyException(int r3, String r4) {
        super(DownloadErrorCode.ERROR_SEGMENT_APPLY, "applyCode=" + r3 + ", " + r4);
        this.applyCode = r3;
    }

    public int getSegmentApplyErrorCode() {
        return this.applyCode;
    }
}
