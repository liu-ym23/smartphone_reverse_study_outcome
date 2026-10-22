package com.bumptech.glide.signature;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.bumptech.glide.load.Key;
import com.larksuite.framework.utils.ApkUtil;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes39.dex */
public final class ApplicationVersionSignature {
    private static final ConcurrentMap<String, Key> PACKAGE_NAME_TO_KEY = null;
    private static final String TAG = "AppVersionSignature";

    static {
        PACKAGE_NAME_TO_KEY = new ConcurrentHashMap();
    }

    public static void reset() {
        PACKAGE_NAME_TO_KEY.clear();
    }

    private ApplicationVersionSignature() {
    }

    private static PackageInfo getPackageInfo(Context r100) {
        return r100.getPackageManager().getPackageInfo(r100.getPackageName(), 0);
    L4:
        r100.getPackageName();
        return null;
    }

    private static String getVersionCode(Context r100) {
        int r101 = ApkUtil.getAppVersionCode(r100);
        if (r101 == 0) goto L6;
        return String.valueOf(r101);
    L6:
        return UUID.randomUUID().toString();
    }

    public static Key obtain(Context r100) {
        String r101 = r100.getPackageName();
        ConcurrentMap<String, Key> r102 = PACKAGE_NAME_TO_KEY;
        Key r103 = r102.get(r101);
        if (r103 != null) goto L9;
        Key r104 = obtainVersionSignature(r100);
        Key r105 = r102.putIfAbsent(r101, r104);
        if (r105 != null) goto L8;
        return r104;
    L8:
        return r105;
    L9:
        return r103;
    }

    private static Key obtainVersionSignature(Context r100) {
        return new ObjectKey(getVersionCode(r100));
    }
}
