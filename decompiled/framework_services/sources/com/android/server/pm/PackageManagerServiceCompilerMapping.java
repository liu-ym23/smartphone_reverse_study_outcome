package com.android.server.pm;

import android.os.SystemProperties;
import dalvik.system.DexFile;

/* JADX INFO: loaded from: classes2.dex */
public class PackageManagerServiceCompilerMapping {
    static final int REASON_SHARED_INDEX = 0;
    public static final String[] REASON_STRINGS = null;

    public PackageManagerServiceCompilerMapping() {
    }

    static {
        REASON_STRINGS = new String[]{"first-boot", "boot-after-ota", "post-boot", "install", "install-fast", "install-bulk", "install-bulk-secondary", "install-bulk-downgraded", "install-bulk-secondary-downgraded", "bg-dexopt", "ab-ota", "inactive", "cmdline", "boot-after-mainline-update", "shared"};
        REASON_SHARED_INDEX = REASON_STRINGS.length - 1;
        if (15 != REASON_STRINGS.length) goto L10;
        if ("shared".equals(REASON_STRINGS[REASON_SHARED_INDEX]) == false) goto L8;
        return;
    L8:
        throw new IllegalStateException("REASON_STRINGS not correct because of shared index");
    L10:
        throw new IllegalStateException("REASON_STRINGS not correct");
    }

    private static String getSystemPropertyName(int reason) {
        if (reason < 0) goto L8;
        if (reason >= REASON_STRINGS.length) goto L8;
        return "pm.dexopt." + REASON_STRINGS[reason];
    L8:
        throw new IllegalArgumentException("reason " + reason + " invalid");
    }

    private static String getAndCheckValidity(int reason) {
        String sysPropValue = SystemProperties.get(getSystemPropertyName(reason));
        if (sysPropValue == null) goto L16;
        if (sysPropValue.isEmpty() == true) goto L16;
        if (sysPropValue.equals("skip") == true) goto L11;
        if (DexFile.isValidCompilerFilter(sysPropValue) == false) goto L16;
    L11:
        if (isFilterAllowedForReason(reason, sysPropValue) == false) goto L14;
        return sysPropValue;
    L14:
        throw new IllegalStateException("Value \"" + sysPropValue + "\" not allowed (reason " + REASON_STRINGS[reason] + ")");
    L16:
        throw new IllegalStateException("Value \"" + sysPropValue + "\" not valid (reason " + REASON_STRINGS[reason] + ")");
    }

    private static boolean isFilterAllowedForReason(int reason, String filter) {
        if (reason == REASON_SHARED_INDEX) goto L5;
    L8:
        return true;
    L5:
        if (DexFile.isProfileGuidedCompilerFilter(filter) == false) goto L8;
        return false;
    }

    static void checkProperties() {
        RuntimeException toThrow = null;
        int reason = 0;
    L4:
        if (reason > 14) goto L20;
        String sysPropName = getSystemPropertyName(reason);     // Catch: Exception -> L10
        if (sysPropName == null) goto L13;
        if (sysPropName.isEmpty() == true) goto L13;
        getAndCheckValidity(reason);     // Catch: Exception -> L10
    L18:
        reason = reason + 1;
    L13:
        throw new IllegalStateException("Reason system property name \"" + sysPropName + "\" for reason " + REASON_STRINGS[reason]);     // Catch: Exception -> L10
    L10:
        exc = move-exception;
        if (toThrow != null) goto L17;
        toThrow = new IllegalStateException("PMS compiler filter settings are bad.");
    L17:
        toThrow.addSuppressed(exc);
        goto L18
    L20:
        if (toThrow != null) goto L22;
        return;
    L22:
        throw toThrow;
    }

    public static String getCompilerFilterForReason(int reason) {
        return getAndCheckValidity(reason);
    }

    public static String getDefaultCompilerFilter() {
        String value = SystemProperties.get("dalvik.vm.dex2oat-filter");
        if (value != null) goto L5;
    L14:
        return "speed";
    L5:
        if (value.isEmpty() == true) goto L14;
        if (DexFile.isValidCompilerFilter(value) == true) goto L10;
    L13:
        return "speed";
    L10:
        if (DexFile.isProfileGuidedCompilerFilter(value) == true) goto L13;
        return value;
    }

    public static String getReasonName(int reason) {
        if (reason < 0) goto L8;
        if (reason >= REASON_STRINGS.length) goto L8;
        return REASON_STRINGS[reason];
    L8:
        throw new IllegalArgumentException("reason " + reason + " invalid");
    }
}
