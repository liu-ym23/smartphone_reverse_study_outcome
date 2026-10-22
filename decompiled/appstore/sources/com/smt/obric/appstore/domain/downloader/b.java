package com.smt.obric.appstore.domain.downloader;

import com.bytedanceos.common.model.AppInfo;
import com.obric.download.base.DownloadInfo;
import com.smt.obric.appstore.domain.app.l;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b {
    public static final int a(DownloadInfo r10) {
        q.g(r10, "<this>");
        switch(r10.getStatus()) {
            case -8: goto L12;
            case -7: goto L11;
            case -6: goto L10;
            case -5: goto L14;
            case -4: goto L8;
            case -3: goto L10;
            case -2: goto L14;
            case -1: goto L6;
            case 0: goto L12;
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L11;
            case 4: goto L11;
            case 5: goto L11;
            case 6: goto L11;
            case 7: goto L11;
            case 8: goto L11;
            case 9: goto L11;
            case 10: goto L11;
            case 11: goto L11;
            default: goto L11;
        };
    L6:
        return 16;
    L8:
        return 0;
    L10:
        return 8;
    L11:
        return 2;
    L12:
        return 1;
    L14:
        return 4;
    }

    public static final AppInfo b(DownloadInfo r16) {
        q.g(r16, "<this>");
        l r10 = l.f18037a;
        String r11 = r16.getExtraInfo();
        if (r11 != null) goto L5;
        r11 = "";
    L5:
        long r12 = r16.getId();
        long r13 = r16.getStatus();
        int r14 = a(r16);
        String r15 = r16.getTargetFilePath();
        String r17 = r16.getUrl();
        long r18 = r16.getTotalBytes();
        long r19 = r16.getCurBytes();
        Integer r110 = r16.getErrorCode();
        if (r110 == null) goto L8;
        Long r111 = Long.valueOf(r110.intValue());
    L10:
        return r10.a(r11, r12, r13, r14, r15, r17, r18, r19, r111, r16.getLastModifiedTime());
    L8:
        r111 = null;
        goto L10
    }
}
