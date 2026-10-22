package com.bytedance.android.ecom.arch.slice.action;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {
    public static final Map<String, Object> a(Map<String, ? extends Object> r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "path");
        Intrinsics.checkNotNullParameter(r102, "separator");
        if (r100 == null) goto L6;
        Map<String, Object> r104 = MapsKt.toMutableMap(r100);
        if (r104 == null) goto L6;
    L7:
        String r105 = null;
        String r106 = mq.b.d(r104, SlcCommonAction.KEY_ACTION_CHAIN_PATH, null);
        boolean r107 = false;
        if (r106 != null) goto L10;
    L13:
        boolean r108 = true;
    L14:
        if (r108 == false) goto L16;
        r104.put(SlcCommonAction.KEY_ACTION_CHAIN_PATH, r101);
    L17:
        if (r103 != null) goto L19;
    L20:
        r107 = true;
    L22:
        if ((!r107) == false) goto L24;
        r105 = r103;
    L24:
        if (r105 != null) goto L26;
    L28:
        return r104;
    L26:
        if (r104.containsKey(SlcCommonAction.KEY_ACTION_MONITOR_ID) == true) goto L28;
        r104.put(SlcCommonAction.KEY_ACTION_MONITOR_ID, r103);
        goto L28
    L19:
        if (r103.length() != 0) goto L22;
    L16:
        r104.put(SlcCommonAction.KEY_ACTION_CHAIN_PATH, r106 + r102 + r101);
        goto L17
    L10:
        if (r106.length() == 0) goto L13;
        r108 = false;
    L6:
        r104 = new LinkedHashMap();
        goto L7
    }
}
