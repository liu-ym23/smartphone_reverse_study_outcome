package com.bumptech.glide.signature;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.Key;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationVersionSignature {
    private static final ConcurrentMap<String, Key> PACKAGE_NAME_TO_KEY = null;
    private static final String TAG = "AppVersionSignature";

    static {
        PACKAGE_NAME_TO_KEY = new ConcurrentHashMap();
    }

    private ApplicationVersionSignature() {
    }

    @Nullable
    private static PackageInfo getPackageInfo(@NonNull Context r10) {
        return r10.getPackageManager().getPackageInfo(r10.getPackageName(), 0);
    L4:
        e = move-exception;
        Log.e(TAG, "Cannot resolve info for" + r10.getPackageName(), e);
        return null;
    }

    @NonNull
    private static String getVersionCode(@Nullable PackageInfo r10) {
        if (r10 == null) goto L5;
        return String.valueOf(r10.versionCode);
    L5:
        return UUID.randomUUID().toString();
    }

    @NonNull
    public static Key obtain(@NonNull Context r10) {
        String r11 = r10.getPackageName();
        ConcurrentMap<String, Key> r12 = PACKAGE_NAME_TO_KEY;
        Key r13 = r12.get(r11);
        if (r13 != null) goto L9;
        Key r14 = obtainVersionSignature(r10);
        Key r15 = r12.putIfAbsent(r11, r14);
        if (r15 != null) goto L8;
        return r14;
    L8:
        return r15;
    L9:
        return r13;
    }

    @NonNull
    private static Key obtainVersionSignature(@NonNull Context r10) {
        return new ObjectKey(getVersionCode(getPackageInfo(r10)));
    }

    @VisibleForTesting
    public static void reset() {
        PACKAGE_NAME_TO_KEY.clear();
    }
}
