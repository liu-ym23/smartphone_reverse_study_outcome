package com.obric.autoaction.app.launcherpage.detail.base.b;

import com.obric.eventkit.task.model.EventTaskResult;

/* JADX INFO: compiled from: BaseDetailViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final String a(EventTaskResult r1) {
        if (r1 == null) goto L5;
        String r0 = r1.getDetailReason();
        if (r0 == null) goto L5;
        return r0;
    L5:
        if (r1 == null) goto L7;
        String r2 = r1.getMsg();
    L8:
        if (r2 != null) goto L14;
        if (r1 != null) goto L11;
        return "error, result is null";
    L11:
        return "";
    L14:
        return r2;
    L7:
        r2 = null;
        goto L8
    }
}
