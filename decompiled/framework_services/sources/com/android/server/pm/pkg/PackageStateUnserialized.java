package com.android.server.pm.pkg;

import android.content.pm.SharedLibraryInfo;
import android.text.TextUtils;
import com.android.internal.util.CollectionUtils;
import com.android.server.pm.PackageSetting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PackageStateUnserialized {
    private boolean apkInUpdatedApex;
    private boolean hiddenUntilInstalled;
    private volatile long[] lastPackageUsageTimeInMills;
    private String mApexModuleName;
    private final PackageSetting mPackageSetting;
    private String overrideSeInfo;
    private String seInfo;
    private boolean updatedSystemApp;
    private List<String> usesLibraryFiles;
    private List<SharedLibraryWrapper> usesLibraryInfos;

    public PackageStateUnserialized(PackageSetting packageSetting) {
        this.usesLibraryInfos = Collections.emptyList();
        this.usesLibraryFiles = Collections.emptyList();
        this.mPackageSetting = packageSetting;
    }

    public PackageStateUnserialized addUsesLibraryInfo(SharedLibraryWrapper value) {
        this.usesLibraryInfos = CollectionUtils.add(this.usesLibraryInfos, value);
        return this;
    }

    public PackageStateUnserialized addUsesLibraryFile(String value) {
        this.usesLibraryFiles = CollectionUtils.add(this.usesLibraryFiles, value);
        return this;
    }

    private long[] lazyInitLastPackageUsageTimeInMills() {
        return new long[8];
    }

    public PackageStateUnserialized setLastPackageUsageTimeInMills(int reason, long time) {
        if (reason >= 0) goto L5;
        return this;
    L5:
        if (reason < 8) goto L7;
        return this;
    L7:
        getLastPackageUsageTimeInMills()[reason] = time;
        return this;
    }

    public long getLatestPackageUseTimeInMills() {
        long latestUse = 0;
        long[] r2 = getLastPackageUsageTimeInMills();
        int r3 = r2.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L5;
        long use = r2[r4];
        latestUse = Math.max(latestUse, use);
        r4 = r4 + 1;
        goto L3
    L5:
        return latestUse;
    }

    public long getLatestForegroundPackageUseTimeInMills() {
        int r1 = 0;
        int[] foregroundReasons = {0, 2};
        long latestUse = 0;
        int r4 = foregroundReasons.length;
    L3:
        if (r1 >= r4) goto L5;
        int reason = foregroundReasons[r1];
        latestUse = Math.max(latestUse, getLastPackageUsageTimeInMills()[reason]);
        r1 = r1 + 1;
        goto L3
    L5:
        return latestUse;
    }

    public void updateFrom(PackageStateUnserialized other) {
        this.hiddenUntilInstalled = other.hiddenUntilInstalled;
        if (other.usesLibraryInfos.isEmpty() == true) goto L6;
        this.usesLibraryInfos = new ArrayList(other.usesLibraryInfos);
    L6:
        if (other.usesLibraryFiles.isEmpty() == true) goto L8;
        this.usesLibraryFiles = new ArrayList(other.usesLibraryFiles);
    L8:
        this.updatedSystemApp = other.updatedSystemApp;
        this.apkInUpdatedApex = other.apkInUpdatedApex;
        this.lastPackageUsageTimeInMills = other.lastPackageUsageTimeInMills;
        this.overrideSeInfo = other.overrideSeInfo;
        this.seInfo = other.seInfo;
        this.mApexModuleName = other.mApexModuleName;
        this.mPackageSetting.onChanged();
    }

    public List<SharedLibraryInfo> getNonNativeUsesLibraryInfos() {
        ArrayList<SharedLibraryInfo> list = new ArrayList();
        this.usesLibraryInfos = getUsesLibraryInfos();
        int index = 0;
    L4:
        if (index >= this.usesLibraryInfos.size()) goto L10;
        SharedLibraryWrapper library = this.usesLibraryInfos.get(index);
        if (library.isNative() == true) goto L8;
        list.add(library.getInfo());
    L8:
        index = index + 1;
        goto L4
    L10:
        return list;
    }

    public PackageStateUnserialized setHiddenUntilInstalled(boolean value) {
        this.hiddenUntilInstalled = value;
        this.mPackageSetting.onChanged();
        return this;
    }

    public PackageStateUnserialized setUsesLibraryInfos(List<SharedLibraryInfo> value) {
        ArrayList<SharedLibraryWrapper> list = new ArrayList();
        int index = 0;
    L4:
        if (index >= value.size()) goto L6;
        list.add(new SharedLibraryWrapper(value.get(index)));
        index = index + 1;
        goto L4
    L6:
        this.usesLibraryInfos = list;
        this.mPackageSetting.onChanged();
        return this;
    }

    public PackageStateUnserialized setUsesLibraryFiles(List<String> value) {
        this.usesLibraryFiles = value;
        this.mPackageSetting.onChanged();
        return this;
    }

    public PackageStateUnserialized setUpdatedSystemApp(boolean value) {
        this.updatedSystemApp = value;
        this.mPackageSetting.onChanged();
        return this;
    }

    public PackageStateUnserialized setApkInUpdatedApex(boolean value) {
        this.apkInUpdatedApex = value;
        this.mPackageSetting.onChanged();
        return this;
    }

    public PackageStateUnserialized setLastPackageUsageTimeInMills(long... value) {
        this.lastPackageUsageTimeInMills = value;
        this.mPackageSetting.onChanged();
        return this;
    }

    public PackageStateUnserialized setOverrideSeInfo(String value) {
        this.overrideSeInfo = value;
        this.mPackageSetting.onChanged();
        return this;
    }

    public PackageStateUnserialized setSeInfo(String value) {
        this.seInfo = TextUtils.safeIntern(value);
        this.mPackageSetting.onChanged();
        return this;
    }

    public PackageStateUnserialized setApexModuleName(String value) {
        this.mApexModuleName = value;
        this.mPackageSetting.onChanged();
        return this;
    }

    public boolean isHiddenUntilInstalled() {
        return this.hiddenUntilInstalled;
    }

    public List<SharedLibraryWrapper> getUsesLibraryInfos() {
        return this.usesLibraryInfos;
    }

    public List<String> getUsesLibraryFiles() {
        return this.usesLibraryFiles;
    }

    public boolean isUpdatedSystemApp() {
        return this.updatedSystemApp;
    }

    public boolean isApkInUpdatedApex() {
        return this.apkInUpdatedApex;
    }

    public long[] getLastPackageUsageTimeInMills() {
        long[] _lastPackageUsageTimeInMills = this.lastPackageUsageTimeInMills;
        if (_lastPackageUsageTimeInMills != null) goto L14;
        monitor-enter(this);
        _lastPackageUsageTimeInMills = this.lastPackageUsageTimeInMills;     // Catch: Throwable -> L8
        if (_lastPackageUsageTimeInMills != null) goto L10;
        long[] r1 = lazyInitLastPackageUsageTimeInMills();     // Catch: Throwable -> L8
        this.lastPackageUsageTimeInMills = r1;     // Catch: Throwable -> L8
        _lastPackageUsageTimeInMills = r1;
    L10:
        monitor-exit(this);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    L14:
        return _lastPackageUsageTimeInMills;
    }

    public String getOverrideSeInfo() {
        return this.overrideSeInfo;
    }

    public String getSeInfo() {
        return this.seInfo;
    }

    public PackageSetting getPackageSetting() {
        return this.mPackageSetting;
    }

    public String getApexModuleName() {
        return this.mApexModuleName;
    }

    @Deprecated
    private void __metadata() {
    }
}
