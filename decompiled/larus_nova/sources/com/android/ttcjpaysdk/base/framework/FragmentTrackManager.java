package com.android.ttcjpaysdk.base.framework;

import androidx.fragment.app.Fragment;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public class FragmentTrackManager {
    private static LinkedHashMap<String, Fragment> maps;
    private static Field tail;

    public FragmentTrackManager() {
    }

    static {
        maps = new LinkedHashMap();
        tail = null;
    }

    public static BaseFragment getTop() {
        if (maps.isEmpty() == false) goto L13;
        return null;
    L13:
    L10:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("FragmentTrackManager#getTop", e);
        CJBasicCommonUtils.logCatch("CJCatch", "FragmentTrackManager#getTop", e);
        return null;
    L6:
        if (tail != null) goto L8;
        Field r100 = maps.getClass().getDeclaredField("tail");     // Catch: Exception -> L10
        tail = r100;     // Catch: Exception -> L10
        r100.setAccessible(true);     // Catch: Exception -> L10
    L8:
        return (BaseFragment) ((Map.Entry) tail.get(maps)).getValue();
    }

    public static void remove(String r100) {
        maps.remove(r100);
    }

    public static void add(String r100, Fragment r101) {
        maps.put(r100, r101);
    }

    public static boolean isTop(String r100, Fragment r101) {
        if (r101 != getTop()) goto L5;
        return true;
    L5:
        return false;
    }
}
