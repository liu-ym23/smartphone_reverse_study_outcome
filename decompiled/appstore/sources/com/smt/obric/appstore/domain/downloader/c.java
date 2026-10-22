package com.smt.obric.appstore.domain.downloader;

import com.obric.download.base.DownloadInfo;
import com.obric.download.base.TaskOperateResult;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class c {
    public static final String a(DownloadInfo r10) {
        q.g(r10, "<this>");
        return " DownloadInfo @ [id=" + r10.getId() + " title=" + r10.getTitle() + " s=" + r10.getStatus() + " p=" + r10.getProgress() + " errorCode=" + r10.getErrorCode() + " errorMsg=" + r10.getErrorMsg() + "] ";
    }

    public static final String b(TaskOperateResult r10) {
        q.g(r10, "<this>");
        return " TaskOperateResult @ [id=" + r10.getId() + " errorCode=" + r10.getErrorCode() + " errorMsg=" + r10.getErrorMsg() + "] ";
    }
}
