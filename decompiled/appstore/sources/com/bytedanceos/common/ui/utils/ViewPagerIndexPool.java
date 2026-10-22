package com.bytedanceos.common.ui.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class ViewPagerIndexPool {
    private static final ViewPagerIndexPool INSTANCE = null;
    private static final String TAG_SPLIT = "=";
    private HashMap<String, Integer> mIndexMaps;

    static {
        INSTANCE = new ViewPagerIndexPool();
    }

    public ViewPagerIndexPool() {
        this.mIndexMaps = new HashMap();
    }

    public static ViewPagerIndexPool getInstance() {
        return INSTANCE;
    }

    public void clear(String r10) {
        Iterator<Map.Entry<String, Integer>> r11 = this.mIndexMaps.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L14;
        String r12 = r11.next().getKey();
        if (r12 == null) goto L4;
        String[] r13 = r12.split(TAG_SPLIT);
        if (r13.length < 2) goto L4;
        if (Objects.equals(r13[0], r10) == false) goto L4;
        r11.remove();
        goto L4
    }

    public int getCurrentPageIndex(String r10, int r11) {
        if (r10 != null) goto L5;
        return 0;
    L5:
        Integer r12 = this.mIndexMaps.get(r10 + TAG_SPLIT + r11);
        if (r12 != null) goto L9;
        return 0;
    L9:
        return r12.intValue();
    }

    public void updateIndexSparseArray(String r10, int r11, int r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.mIndexMaps.put(r10 + TAG_SPLIT + r11, Integer.valueOf(r12));
    }
}
