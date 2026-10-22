package com.bytedance.android.livesdk.chatroom.replay.castscreen.bytecast;

import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;

/* JADX INFO: loaded from: classes7.dex */
public final class d {
    public static final boolean a(DataCenter r100) {
        m<Boolean> r101 = r.b().castScreenMode(r100);
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.getValue().booleanValue() != true) goto L7;
        return true;
    }

    public static final boolean b(DataCenter r100) {
        m<Boolean> r101 = r.b().c(r100);
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.getValue().booleanValue() != true) goto L7;
        return true;
    }
}
