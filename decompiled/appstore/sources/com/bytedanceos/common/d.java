package com.bytedanceos.common;

import com.bytedanceos.common.model.AppInfo;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {
    public static final String a(AppInfo r10) {
        if (r10 != null) goto L6;
        return "null";
    L6:
        return " [pkg=" + r10.appPackageName + " n=" + r10.appName + " dlId=" + r10.downloadId + " dlStatus=" + r10.downloadStatus + " status=" + r10.mStatus + " dlProg=" + r10.downloadProgress + ", ostate=" + r10.debugODownloadState + "] ";
    }
}
