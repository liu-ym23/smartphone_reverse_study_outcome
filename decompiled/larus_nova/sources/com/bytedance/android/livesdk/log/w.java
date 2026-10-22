package com.bytedance.android.livesdk.log;

import com.bytedance.android.livehostapi.platform.IHostLog;
import com.bytedance.android.livesdk.config.h70;
import com.bytedance.android.livesdkapi.model.LiveLogFlushConfig;

/* JADX INFO: loaded from: classes10.dex */
public final class w {
    public static final void a(int r100) {
        if (r100 > 0) goto L4;
        return;
    L4:
        LiveLogFlushConfig r101 = h70.f120345a.getValue();
        if (r100 != 1) goto L7;
        boolean r102 = r101.mEnableDrawExitRoom;
    L11:
        if (r102 == false) goto L14;
        ((IHostLog) jc1.k.n(IHostLog.class)).flush();
        return;
    L14:
        return;
    L7:
        if (r100 == 2) goto L9;
        r102 = false;
        goto L11
    L9:
        r102 = r101.mEnableDrawDurationOnemin;
        goto L11
    }
}
