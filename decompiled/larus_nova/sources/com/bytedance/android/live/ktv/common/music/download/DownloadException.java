package com.bytedance.android.live.ktv.common.music.download;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/ktv/common/music/download/DownloadException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorMsg", "", "toastMsg", "(Ljava/lang/String;Ljava/lang/String;)V", "getErrorMsg", "()Ljava/lang/String;", "getToastMsg", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DownloadException extends Exception {
    private final String errorMsg;
    private final String toastMsg;

    /* JADX WARN: Multi-variable type inference failed */
    public DownloadException() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final String getToastMsg() {
        return this.toastMsg;
    }

    public DownloadException(String r100, String r101) {
        super(r100);
        this.errorMsg = r100;
        this.toastMsg = r101;
    }

    public /* synthetic */ DownloadException(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
