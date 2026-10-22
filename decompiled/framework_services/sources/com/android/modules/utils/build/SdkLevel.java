package com.android.modules.utils.build;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class SdkLevel {
    private SdkLevel() {
    }

    public static boolean isAtLeastR() {
        return true;
    }

    public static boolean isAtLeastS() {
        return true;
    }

    public static boolean isAtLeastSv2() {
        return true;
    }

    public static boolean isAtLeastT() {
        return true;
    }

    public static boolean isAtLeastU() {
        return true;
    }

    public static boolean isAtLeastV() {
        return true;
    }

    public static boolean isAtLeastB() {
        return true;
    }

    private static boolean isAtLeastPreReleaseCodename(String codename) {
        if ("REL".equals(Build.VERSION.CODENAME) == false) goto L6;
        return false;
    L6:
        if (Build.VERSION.CODENAME.compareTo(codename) < 0) goto L9;
        return true;
    L9:
        return false;
    }
}
