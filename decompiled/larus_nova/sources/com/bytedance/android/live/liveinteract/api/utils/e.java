package com.bytedance.android.live.liveinteract.api.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes46.dex */
public final class e {
    public static final boolean a(DataCenter r100) {
        if (r100 == null) goto L12;
        Integer r101 = (Integer) r100.get(IKtvService.KEY_OF_SUBSCENE_FOR_DATACENTER, -1);
        if (r101 == null) goto L12;
        int r102 = r101.intValue();
        if (r102 == 9) goto L10;
        ALogger.e("LinkMultiControlHelper", "feedSubScene isn't ktv:" + r102);
        return false;
    L10:
        return true;
    L12:
        return false;
    }
}
