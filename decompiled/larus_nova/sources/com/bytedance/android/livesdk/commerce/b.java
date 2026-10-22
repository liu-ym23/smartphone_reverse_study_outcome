package com.bytedance.android.livesdk.commerce;

import com.bytedance.android.live.broadcastgame.api.interactgame.j;
import com.bytedance.android.live.broadcastgame.api.model.r;
import com.bytedance.android.livesdk.config.ux;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b {
    public static Boolean a(DataCenter r100) {
        boolean r101 = false;
        if (ux.f121407a.getValue().booleanValue() == false) goto L14;
        int r102 = j.f59311a;
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        if (((Boolean) r100.get("data_is_anchor", Boolean.FALSE)).booleanValue() == true) goto L10;
        r r103 = (r) r100.get("data_audience_interact_game", null);
        if (r103 == null) goto L10;
        boolean r104 = r103.E();
    L11:
        if (r104 == false) goto L14;
        r101 = true;
    L10:
        r104 = false;
    L14:
        return Boolean.valueOf(r101);
    }

    public static boolean b(DataCenter r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Boolean r101 = Boolean.FALSE;
        boolean r102 = ((Boolean) r100.get("enter_from_effect_ad", r101)).booleanValue();
        boolean r103 = ((Boolean) r100.get("enter_from_dou_plus", r101)).booleanValue();
        if (r102 == true) goto L8;
        if (r103 == true) goto L8;
        return false;
    L8:
        return true;
    }
}
