package com.bytedance.android.gamecp.live_impl.utils;

import com.bytedance.android.livesdkapi.depend.log.LogFilterName;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public final class d {
    public static final String a(String r100) {
        Map r101 = com.bytedance.android.gamecp.common.track.b.b(LogFilterName.PAGE_SOURCE_LOG);
        if (r101 == null) goto L6;
        String r102 = (String) r101.get(r100);
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }
}
