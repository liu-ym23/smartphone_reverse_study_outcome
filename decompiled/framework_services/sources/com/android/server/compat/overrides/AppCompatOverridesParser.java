package com.android.server.compat.overrides;

import android.app.compat.PackageOverride;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.KeyValueListParser;
import android.util.Pair;
import android.util.Slog;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import libcore.util.HexEncoding;

/* JADX INFO: loaded from: classes.dex */
final class AppCompatOverridesParser {
    private static final Pattern BOOLEAN_PATTERN = null;
    static final String FLAG_OWNED_CHANGE_IDS = "owned_change_ids";
    static final String FLAG_REMOVE_OVERRIDES = "remove_overrides";
    private static final String TAG = "AppCompatOverridesParser";
    private static final String WILDCARD_NO_OWNED_CHANGE_IDS_WARNING = "Wildcard can't be used in 'remove_overrides' flag with an empty owned_change_ids' flag";
    private static final String WILDCARD_SYMBOL = "*";
    private final PackageManager mPackageManager;

    private static final class PackageOverrideComparator implements Comparator<PackageOverride> {
        private final long mVersionCode;

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(PackageOverride r1, PackageOverride r2) {
            return compare2(r1, r2);
        }

        PackageOverrideComparator(long versionCode) {
            this.mVersionCode = versionCode;
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(PackageOverride o1, PackageOverride o2) {
            boolean isVersionInRange1 = isVersionInRange(o1, this.mVersionCode);
            boolean isVersionInRange2 = isVersionInRange(o2, this.mVersionCode);
            if (isVersionInRange1 == isVersionInRange2) goto L7;
            if (isVersionInRange1 == true) goto L6;
            return 1;
        L6:
            return -1;
        L7:
            boolean isVersionAfterRange1 = isVersionAfterRange(o1, this.mVersionCode);
            boolean isVersionAfterRange2 = isVersionAfterRange(o2, this.mVersionCode);
            if (isVersionAfterRange1 == isVersionAfterRange2) goto L13;
            if (isVersionAfterRange1 == true) goto L11;
            return 1;
        L11:
            return -1;
        L13:
            return Long.compare(getVersionProximity(o1, this.mVersionCode), getVersionProximity(o2, this.mVersionCode));
        }

        private static boolean isVersionInRange(PackageOverride override, long versionCode) {
            if (override.getMinVersionCode() <= versionCode) goto L5;
        L7:
            return false;
        L5:
            if (versionCode > override.getMaxVersionCode()) goto L7;
            return true;
        }

        private static boolean isVersionAfterRange(PackageOverride override, long versionCode) {
            if (override.getMaxVersionCode() >= versionCode) goto L5;
            return true;
        L5:
            return false;
        }

        private static boolean isVersionBeforeRange(PackageOverride override, long versionCode) {
            if (override.getMinVersionCode() <= versionCode) goto L5;
            return true;
        L5:
            return false;
        }

        private static long getVersionProximity(PackageOverride override, long versionCode) {
            if (isVersionAfterRange(override, versionCode) == false) goto L7;
            return versionCode - override.getMaxVersionCode();
        L7:
            if (isVersionBeforeRange(override, versionCode) == true) goto L9;
            return 0;
        L9:
            return override.getMinVersionCode() - versionCode;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$M_G4bbRk3S38rnJGRaj7-Moh80U, reason: not valid java name */
    public static /* synthetic */ Set m3043$r8$lambda$M_G4bbRk3S38rnJGRaj7Moh80U(String r0) {
        return lambda$parseRemoveOverrides$0(r0);
    }

    static {
        BOOLEAN_PATTERN = Pattern.compile("true|false", 2);
    }

    AppCompatOverridesParser(PackageManager packageManager) {
        this.mPackageManager = packageManager;
    }

    Map<String, Set<Long>> parseRemoveOverrides(String configStr, Set<Long> ownedChangeIds) {
        Set<Long> r2 = ownedChangeIds;
        if (configStr.isEmpty() == true) goto L5;
        Map<String, Set<Long>> result = new ArrayMap();
        if (configStr.equals("*") == true) goto L9;
        KeyValueListParser parser = new KeyValueListParser(',');
        parser.setString(configStr);     // Catch: IllegalArgumentException -> L40
        int i = 0;
    L21:
        if (i >= parser.size()) goto L39;
        String packageName = parser.keyAt(i);
        String changeIdsStr = parser.getString(packageName, "");
        if (changeIdsStr.equals("*") == true) goto L25;
        String[] r12 = changeIdsStr.split(":");
        int r13 = r12.length;
        int r14 = 0;
    L29:
        if (r14 >= r13) goto L37;
        String changeIdStr = r12[r14];
        long changeId = Long.parseLong(changeIdStr);     // Catch: NumberFormatException -> L33
        result.computeIfAbsent(packageName, new AppCompatOverridesParser$$ExternalSyntheticLambda0()).add(Long.valueOf(changeId));     // Catch: NumberFormatException -> L33
    L35:
        r14 = r14 + 1;
        result = result;
    L33:
        e = move-exception;
        Slog.w(TAG, "Invalid change ID in 'remove_overrides' flag: " + changeIdStr, e);
    L37:
        i = i + 1;
        r2 = ownedChangeIds;
        result = result;
        goto L21
    L25:
        if (r2.isEmpty() == false) goto L27;
        Slog.w(TAG, WILDCARD_NO_OWNED_CHANGE_IDS_WARNING);
        goto L37
    L27:
        result.put(packageName, r2);
        goto L37
    L39:
        return result;
    L40:
        e = move-exception;
        Slog.w(TAG, "Invalid format in 'remove_overrides' flag: " + configStr, e);
        return Collections.emptyMap();
    L9:
        if (r2.isEmpty() == false) goto L12;
        Slog.w(TAG, WILDCARD_NO_OWNED_CHANGE_IDS_WARNING);
        return Collections.emptyMap();
    L12:
        List<ApplicationInfo> installedApps = this.mPackageManager.getInstalledApplications(4194304);
        Iterator<ApplicationInfo> r4 = installedApps.iterator();
    L14:
        if (r4.hasNext() == false) goto L16;
        ApplicationInfo appInfo = r4.next();
        result.put(appInfo.packageName, r2);
        goto L14
    L16:
        return result;
    L5:
        return Collections.emptyMap();
    }

    private static /* synthetic */ Set lambda$parseRemoveOverrides$0(String k) {
        return new ArraySet();
    }

    static Set<Long> parseOwnedChangeIds(String configStr) {
        if (configStr.isEmpty() == true) goto L5;
        Set<Long> result = new ArraySet();
        String[] r1 = configStr.split(",");
        int r2 = r1.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L14;
        String changeIdStr = r1[r3];
        result.add(Long.valueOf(Long.parseLong(changeIdStr)));     // Catch: NumberFormatException -> L11
    L13:
        r3 = r3 + 1;
    L11:
        e = move-exception;
        Slog.w(TAG, "Invalid change ID in 'owned_change_ids' flag: " + changeIdStr, e);
        goto L13
    L14:
        return result;
    L5:
        return Collections.emptySet();
    }

    Map<Long, PackageOverride> parsePackageOverrides(String configStr, String packageName, long versionCode, Set<Long> changeIdsToSkip) {
        if (configStr.isEmpty() == true) goto L5;
        PackageOverrideComparator comparator = new PackageOverrideComparator(versionCode);
        Map<Long, PackageOverride> overridesToAdd = new ArrayMap();
        Pair<String, String> signatureAndConfig = extractSignatureFromConfig(configStr);
        if (signatureAndConfig == null) goto L9;
        String signature = (String) signatureAndConfig.first;
        String overridesConfig = (String) signatureAndConfig.second;
        if (verifySignature(packageName, signature) == false) goto L13;
        String[] r10 = overridesConfig.split(",");
        int r11 = r10.length;
        int r13 = 0;
    L15:
        if (r13 >= r11) goto L55;
        String overrideEntryString = r10[r13];
        List<String> changeIdAndVersions = Arrays.asList(overrideEntryString.split(":", 4));
        if (changeIdAndVersions.size() == 4) goto L60;
        Slog.w(TAG, "Invalid change override entry: " + overrideEntryString);
        Pair<String, String> signatureAndConfig2 = signatureAndConfig;
        String signature2 = signature;
        String overridesConfig2 = overridesConfig;
    L54:
        r13 = r13 + 1;
        signatureAndConfig = signatureAndConfig2;
        signature = signature2;
        overridesConfig = overridesConfig2;
        goto L15
    L60:
        long changeId = Long.parseLong(changeIdAndVersions.get(0));     // Catch: NumberFormatException -> L52
        if (changeIdsToSkip.contains(Long.valueOf(changeId)) == false) goto L24;
        signatureAndConfig2 = signatureAndConfig;
        signature2 = signature;
        overridesConfig2 = overridesConfig;
        goto L54
    L24:
        String minVersionCodeStr = changeIdAndVersions.get(1);
        String maxVersionCodeStr = changeIdAndVersions.get(2);
        String enabledStr = changeIdAndVersions.get(3);
        if (BOOLEAN_PATTERN.matcher(enabledStr).matches() == true) goto L27;
        Slog.w(TAG, "Invalid enabled string in override entry: " + overrideEntryString);
        signatureAndConfig2 = signatureAndConfig;
        signature2 = signature;
        overridesConfig2 = overridesConfig;
        goto L54
    L27:
        boolean enabled = Boolean.parseBoolean(enabledStr);
        signatureAndConfig2 = signatureAndConfig;
        PackageOverride.Builder overrideBuilder = new PackageOverride.Builder().setEnabled(enabled);
        if (minVersionCodeStr.isEmpty() == true) goto L34;
        signature2 = signature;
        overridesConfig2 = overridesConfig;
        overrideBuilder.setMinVersionCode(Long.parseLong(minVersionCodeStr));     // Catch: NumberFormatException -> L32
    L36:
        if (maxVersionCodeStr.isEmpty() == true) goto L56;
        overrideBuilder.setMaxVersionCode(Long.parseLong(maxVersionCodeStr));     // Catch: NumberFormatException -> L32
    L56:
        PackageOverride override = overrideBuilder.build();     // Catch: IllegalArgumentException -> L44
        if (overridesToAdd.containsKey(Long.valueOf(changeId)) == true) goto L42;
    L46:
        overridesToAdd.put(Long.valueOf(changeId), override);     // Catch: IllegalArgumentException -> L44
        goto L54
    L42:
        if (comparator.compare2(override, overridesToAdd.get(Long.valueOf(changeId))) >= 0) goto L54;
    L44:
        e = move-exception;
        Slog.w(TAG, "Failed to build PackageOverride", e);
    L32:
        e = e;
    L51:
        Slog.w(TAG, "Invalid min/max version code in override entry: " + overrideEntryString, e);
        goto L54
    L34:
        signature2 = signature;
        overridesConfig2 = overridesConfig;
    L49:
        e = e;
        signature2 = signature;
        overridesConfig2 = overridesConfig;
    L52:
        e = move-exception;
        signatureAndConfig2 = signatureAndConfig;
        signature2 = signature;
        overridesConfig2 = overridesConfig;
        Slog.w(TAG, "Invalid change ID in override entry: " + overrideEntryString, e);
        goto L54
    L55:
        return overridesToAdd;
    L13:
        return Collections.emptyMap();
    L9:
        return Collections.emptyMap();
    L5:
        return Collections.emptyMap();
    }

    private static Pair<String, String> extractSignatureFromConfig(String configStr) {
        List<String> signatureAndConfig = Arrays.asList(configStr.split("~"));
        if (signatureAndConfig.size() != 1) goto L7;
        return Pair.create("", configStr);
    L7:
        if (signatureAndConfig.size() <= 2) goto L11;
        Slog.w(TAG, "Only one signature per config is supported. Config: " + configStr);
        return null;
    L11:
        return Pair.create(signatureAndConfig.get(0), signatureAndConfig.get(1));
    }

    private boolean verifySignature(String packageName, String signature) {
        boolean signatureValid = true;
        if (signature.isEmpty() == false) goto L6;
    L13:
        if (signatureValid == true) goto L15;
        Slog.w(TAG, packageName + " did not have expected signature: " + signature);     // Catch: IllegalArgumentException -> L9
    L15:
        return signatureValid;
    L6:
        if (this.mPackageManager.hasSigningCertificate(packageName, HexEncoding.decode(signature), 1) == true) goto L13;
        signatureValid = false;
    L9:
        e = move-exception;
        Slog.w(TAG, "Unable to verify signature " + signature + " for " + packageName, e);
        return false;
    }
}
