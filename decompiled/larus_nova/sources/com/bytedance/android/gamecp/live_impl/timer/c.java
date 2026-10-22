package com.bytedance.android.gamecp.live_impl.timer;

import com.bytedance.android.gamecp.host_api.model.introducecard.s;
import com.bytedance.android.gamecp.live_impl.RoomContext;
import com.bytedance.live.datacontext.m;
import wu.t3;

/* JADX INFO: loaded from: classes44.dex */
public final class c {
    public static final boolean a(RoomContext r100) {
        if (cs.a.a() == true) goto L5;
    L7:
        if (r100 == null) goto L15;
        m<s> r101 = r100.getUserIntroCardDisplayConfig();
        if (r101 == null) goto L15;
        s r102 = r101.getValue();
        if (r102 == null) goto L15;
        if (r102.timerCardSwitchOpen != true) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (t3.f561393a.getValue().d() == false) goto L7;
        return true;
    }
}
