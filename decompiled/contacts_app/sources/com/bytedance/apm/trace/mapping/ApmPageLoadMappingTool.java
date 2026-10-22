package com.bytedance.apm.trace.mapping;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class ApmPageLoadMappingTool {
    private static HashMap<String, Integer> sPageViewIdMap;

    public ApmPageLoadMappingTool() {
    }

    static {
        sPageViewIdMap = new HashMap();
        initMap();
    }

    public static void put(String r1, int r2) {
        sPageViewIdMap.put(r1, Integer.valueOf(r2));
    }

    private static void initMap() {
        put("xx", 12334);
    }

    public static HashMap<String, Integer> getsPageViewIdMap() {
        return sPageViewIdMap;
    }

    public static Integer queryViewId(String r1) {
        return sPageViewIdMap.get(r1);
    }
}
