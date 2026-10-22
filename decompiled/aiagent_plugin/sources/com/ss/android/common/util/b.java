package com.ss.android.common.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: BDNetworkTagManagerHelper.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {
    public static void a(Map<String, String> r2, boolean r3) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin")).put("x-tt-request-tag", "t=0;n=" + (r3 ? 1 : 0));
    }
}
