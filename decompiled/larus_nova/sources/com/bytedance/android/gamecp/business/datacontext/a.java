package com.bytedance.android.gamecp.business.datacontext;

import com.bytedance.live.datacontext.m;
import com.ss.android.common.applog.EventVerify;

/* JADX INFO: loaded from: classes44.dex */
public final class a {
    public static final String a(GameCpDataContext r100) {
        if (r100 == null) goto L7;
        m<String> r101 = r100.getMiniPlayStatus();
        if (r101 == null) goto L7;
        String r102 = r101.getValue();
        if (r102 == null) goto L7;
        return r102;
    L7:
        return EventVerify.TYPE_LAUNCH;
    }
}
