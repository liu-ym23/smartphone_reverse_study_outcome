package com.smt.obric.appstore.domain.downloader;

import com.obric.download.base.TaskOperateResult;

/* JADX INFO: loaded from: classes4.dex */
public abstract class d {
    public static final boolean a(TaskOperateResult r10) {
        if (r10 != null) goto L4;
    L6:
        if (r10 != null) goto L8;
    L10:
        return false;
    L8:
        if (r10.getErrorCode() != (-1)) goto L10;
    L9:
        return true;
    L4:
        if (r10.getErrorCode() != 0) goto L6;
        goto L6
    }

    public static final boolean b(Long r10) {
        if (r10 != null) goto L4;
    L6:
        return false;
    L4:
        if (r10.longValue() == 0) goto L6;
        return true;
    }
}
