package com.android.server.pm.dex;

import android.util.Log;
import com.android.server.art.model.DexoptParams;
import com.android.server.pm.PackageManagerServiceCompilerMapping;
import dalvik.system.DexFile;

/* JADX INFO: loaded from: classes2.dex */
public final class DexoptOptions {
    public static final int DEXOPT_AS_SHARED_LIBRARY = 64;
    public static final int DEXOPT_BOOT_COMPLETE = 4;
    public static final int DEXOPT_CHECK_FOR_PROFILES_UPDATES = 1;
    public static final int DEXOPT_DOWNGRADE = 32;
    public static final int DEXOPT_FORCE = 2;
    public static final int DEXOPT_FOR_RESTORE = 2048;
    public static final int DEXOPT_IDLE_BACKGROUND_JOB = 512;
    public static final int DEXOPT_INSTALL_WITH_DEX_METADATA_FILE = 1024;
    public static final int DEXOPT_ONLY_SECONDARY_DEX = 8;
    private static final String TAG = "DexoptOptions";
    private final int mCompilationReason;
    private final String mCompilerFilter;
    private final int mFlags;
    private final String mPackageName;
    private final String mSplitName;

    public DexoptOptions(String packageName, String compilerFilter, int flags) {
        this(packageName, -1, compilerFilter, null, flags);
    }

    public DexoptOptions(String packageName, int compilationReason, int flags) {
        this(packageName, compilationReason, PackageManagerServiceCompilerMapping.getCompilerFilterForReason(compilationReason), null, flags);
    }

    public DexoptOptions(String packageName, int compilationReason, String compilerFilter, String splitName, int flags) {
        if (((~3695) & flags) != 0) goto L7;
        this.mPackageName = packageName;
        this.mCompilerFilter = compilerFilter;
        this.mFlags = flags;
        this.mSplitName = splitName;
        this.mCompilationReason = compilationReason;
        return;
    L7:
        throw new IllegalArgumentException("Invalid flags : " + Integer.toHexString(flags));
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public boolean isCheckForProfileUpdates() {
        if ((this.mFlags & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public String getCompilerFilter() {
        return this.mCompilerFilter;
    }

    public boolean isForce() {
        if ((this.mFlags & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBootComplete() {
        if ((this.mFlags & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isDexoptOnlySecondaryDex() {
        if ((this.mFlags & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isDowngrade() {
        if ((this.mFlags & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isDexoptAsSharedLibrary() {
        if ((this.mFlags & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isDexoptIdleBackgroundJob() {
        if ((this.mFlags & 512) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isDexoptInstallWithDexMetadata() {
        if ((this.mFlags & 1024) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isDexoptInstallForRestore() {
        if ((this.mFlags & 2048) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public String getSplitName() {
        return this.mSplitName;
    }

    public int getFlags() {
        return this.mFlags;
    }

    public int getCompilationReason() {
        return this.mCompilationReason;
    }

    public DexoptOptions overrideCompilerFilter(String newCompilerFilter) {
        return new DexoptOptions(this.mPackageName, this.mCompilationReason, newCompilerFilter, this.mSplitName, this.mFlags);
    }

    public static String convertToArtServiceDexoptReason(int pmDexoptReason) {
        switch(pmDexoptReason) {
            case 0: goto L29;
            case 1: goto L27;
            case 2: goto L26;
            case 3: goto L23;
            case 4: goto L21;
            case 5: goto L19;
            case 6: goto L17;
            case 7: goto L15;
            case 8: goto L13;
            case 9: goto L11;
            case 10: goto L26;
            case 11: goto L9;
            case 12: goto L7;
            case 13: goto L5;
            case 14: goto L26;
            default: goto L4;
        };
    L5:
        return "boot-after-mainline-update";
    L7:
        return "cmdline";
    L9:
        return "inactive";
    L11:
        return "bg-dexopt";
    L13:
        return "install-bulk-secondary-downgraded";
    L15:
        return "install-bulk-downgraded";
    L17:
        return "install-bulk-secondary";
    L19:
        return "install-bulk";
    L21:
        return "install-fast";
    L23:
        return "install";
    L27:
        return "boot-after-ota";
    L29:
        return "first-boot";
    L4:
        throw new IllegalArgumentException("Invalid compilation reason " + pmDexoptReason);
    L26:
        throw new UnsupportedOperationException("ART Service unsupported compilation reason " + pmDexoptReason);
    }

    public DexoptParams convertToDexoptParams(int extraFlags) {
        if (this.mSplitName != null) goto L37;
        int flags = extraFlags;
        if ((this.mFlags & 1) != 0) goto L12;
        if (DexFile.isProfileGuidedCompilerFilter(this.mCompilerFilter) == false) goto L12;
        throw new IllegalArgumentException("DEXOPT_CHECK_FOR_PROFILES_UPDATES must be set with profile guided filter");
    L12:
        if ((this.mFlags & 2) == 0) goto L15;
        flags = flags | 16;
    L15:
        if ((this.mFlags & 8) == 0) goto L17;
        int flags2 = flags | 2;
    L19:
        if ((this.mFlags & 32) == 0) goto L22;
        flags2 = flags2 | 8;
    L22:
        if ((this.mFlags & 1024) != 0) goto L25;
        Log.w(TAG, "DEXOPT_INSTALL_WITH_DEX_METADATA_FILE not set in request to optimise " + this.mPackageName + " - ART Service will unconditionally use a DM file if present.");
    L25:
        if ((this.mFlags & 4) != 0) goto L27;
        int priority = 100;
    L35:
        return new DexoptParams.Builder(convertToArtServiceDexoptReason(this.mCompilationReason), flags2).setCompilerFilter(this.mCompilerFilter).setPriorityClass(priority).build();
    L27:
        if ((this.mFlags & 2048) == 0) goto L29;
        priority = 80;
        goto L35
    L29:
        int priority2 = this.mFlags;
        if ((priority2 & 512) == 0) goto L32;
        priority = 40;
        goto L35
    L32:
        priority = 60;
        goto L35
    L17:
        flags2 = flags | 1;
        goto L19
    L37:
        throw new UnsupportedOperationException("Request to optimize only split " + this.mSplitName + " for " + this.mPackageName);
    }
}
