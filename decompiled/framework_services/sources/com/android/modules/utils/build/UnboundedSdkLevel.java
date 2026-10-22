package com.android.modules.utils.build;

import android.os.Build;
import android.util.ArraySet;
import android.util.SparseArray;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class UnboundedSdkLevel {
    private static final SparseArray<Set<String>> PREVIOUS_CODENAMES = null;
    private static final UnboundedSdkLevel sInstance = null;
    private final String mCodename;
    private final boolean mIsReleaseBuild;
    private final Set<String> mKnownCodenames;
    private final int mSdkInt;

    public static boolean isAtLeast(String version) {
        return sInstance.isAtLeastInternal(version);
    }

    public static boolean isAtMost(String version) {
        return sInstance.isAtMostInternal(version);
    }

    static {
        PREVIOUS_CODENAMES = new SparseArray(4);
        PREVIOUS_CODENAMES.put(29, setOf(new String[]{"Q"}));
        PREVIOUS_CODENAMES.put(30, setOf(new String[]{"Q", "R"}));
        PREVIOUS_CODENAMES.put(31, setOf(new String[]{"Q", "R", "S"}));
        PREVIOUS_CODENAMES.put(32, setOf(new String[]{"Q", "R", "S", "Sv2"}));
        int r1 = Build.VERSION.SDK_INT;
        String r2 = Build.VERSION.CODENAME;
        if (SdkLevel.isAtLeastT() == false) goto L5;
        Set<String> r3 = Build.VERSION.KNOWN_CODENAMES;
    L6:
        sInstance = new UnboundedSdkLevel(r1, r2, r3);
        return;
    L5:
        r3 = PREVIOUS_CODENAMES.get(Build.VERSION.SDK_INT);
        goto L6
    }

    private static Set<String> setOf(String... contents) {
        if (SdkLevel.isAtLeastR() == true) goto L5;
        Set<String> set = new ArraySet(contents.length);
        int r1 = contents.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L9;
        String codename = contents[r2];
        set.add(codename);
        r2 = r2 + 1;
        goto L7
    L9:
        return set;
    L5:
        return Set.of(contents);
    }

    UnboundedSdkLevel(int sdkInt, String codename, Set<String> knownCodenames) {
        this.mSdkInt = sdkInt;
        this.mCodename = codename;
        this.mIsReleaseBuild = "REL".equals(codename);
        this.mKnownCodenames = knownCodenames;
    }

    boolean isAtLeastInternal(String version) {
        String version2 = removeFingerprint(version);
        if (this.mIsReleaseBuild == false) goto L17;
        if (isCodename(version2) == false) goto L12;
        if (this.mKnownCodenames.contains(version2) == true) goto L10;
        return false;
    L10:
        throw new IllegalArgumentException("Artifact with a known codename " + version2 + " must be recompiled with a finalized integer version.");
    L12:
        if (this.mSdkInt < Integer.parseInt(version2)) goto L15;
        return true;
    L15:
        return false;
    L17:
        if (isCodename(version2) == false) goto L21;
        return this.mKnownCodenames.contains(version2);
    L21:
        if (this.mSdkInt < Integer.parseInt(version2)) goto L24;
        return true;
    L24:
        return false;
    }

    boolean isAtMostInternal(String version) {
        String version2 = removeFingerprint(version);
        if (this.mIsReleaseBuild == false) goto L16;
        if (isCodename(version2) == false) goto L12;
        if (this.mKnownCodenames.contains(version2) == true) goto L10;
        return true;
    L10:
        throw new IllegalArgumentException("Artifact with a known codename " + version2 + " must be recompiled with a finalized integer version.");
    L12:
        if (this.mSdkInt <= Integer.parseInt(version2)) goto L14;
        return false;
    L14:
        return true;
    L16:
        if (isCodename(version2) == false) goto L24;
        if (this.mKnownCodenames.contains(version2) == false) goto L22;
        if (this.mCodename.equals(version2) == true) goto L22;
        return false;
    L22:
        return true;
    L24:
        if (this.mSdkInt < Integer.parseInt(version2)) goto L26;
        return false;
    L26:
        return true;
    }

    String removeFingerprint(String version) {
        if (isCodename(version) == false) goto L8;
        int index = version.indexOf(46);
        if (index == (-1)) goto L8;
        return version.substring(0, index);
    L8:
        return version;
    }

    private boolean isCodename(String version) {
        if (version.length() == 0) goto L7;
        return Character.isUpperCase(version.charAt(0));
    L7:
        throw new IllegalArgumentException();
    }
}
