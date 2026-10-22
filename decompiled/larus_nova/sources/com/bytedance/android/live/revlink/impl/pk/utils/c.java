package com.bytedance.android.live.revlink.impl.pk.utils;

import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes47.dex */
public final class c {
    public static final boolean a(DataCenter r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        boolean r101 = ((Boolean) r100.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        LiveMode r102 = LiveMode.VIDEO;
        LiveMode r103 = (LiveMode) r100.get("data_live_mode", r102);
        if (r101 == false) goto L10;
        if (r103 != r102) goto L11;
        return true;
    L11:
        return false;
    L10:
        return false;
    }
}
