package com.obric.autoaction.app.launcherpage.detail.base;

import com.obric.eventkit.task.model.EventTaskResult;

/* JADX INFO: compiled from: EventTaskResultExt.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static final boolean a(EventTaskResult r1) {
        if (r1 != null) goto L5;
        return false;
    L5:
        if (r1.getCode() != 0) goto L9;
        return true;
    L9:
        return false;
    }
}
