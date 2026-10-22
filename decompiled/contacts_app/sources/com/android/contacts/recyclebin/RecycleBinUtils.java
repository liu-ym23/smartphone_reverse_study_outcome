package com.android.contacts.recyclebin;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.LruCache;

/* JADX INFO: loaded from: classes2.dex */
public class RecycleBinUtils {
    private static LruCache<String, String> sApplicationLabelCache;

    public RecycleBinUtils() {
    }

    static {
        sApplicationLabelCache = new LruCache(15);
    }

    public static String getApplicationLabelForPackageName(Context r4, String r5) {
        if (r4 != null) goto L5;
        return "";
    L5:
        if (TextUtils.isEmpty(r5) == true) goto L20;
        String r1 = sApplicationLabelCache.get(r5);
        if (TextUtils.isEmpty(r1) == false) goto L14;
        ApplicationInfo r2 = r4.getPackageManager().getApplicationInfo(r5, 0);     // Catch: PackageManager.NameNotFoundException -> L15
        if (r2 == null) goto L14;
        String r6 = (String) r4.getPackageManager().getApplicationLabel(r2);     // Catch: PackageManager.NameNotFoundException -> L15
        sApplicationLabelCache.put(r5, r6);     // Catch: PackageManager.NameNotFoundException -> L15
        return r6;
    L21:
        return "";
    L14:
        return r1;
    L20:
        return "";
    }
}
