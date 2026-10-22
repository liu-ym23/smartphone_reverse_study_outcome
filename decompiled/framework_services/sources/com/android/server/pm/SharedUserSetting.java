package com.android.server.pm;

import android.content.pm.SigningDetails;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.proto.ProtoOutputStream;
import com.android.internal.pm.parsing.pkg.AndroidPackageInternal;
import com.android.internal.pm.pkg.component.ComponentMutateUtils;
import com.android.internal.pm.pkg.component.ParsedProcess;
import com.android.internal.pm.pkg.component.ParsedProcessImpl;
import com.android.internal.util.ArrayUtils;
import com.android.server.pm.permission.LegacyPermissionState;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.pkg.SharedUserApi;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.utils.SnapshotCache;
import com.android.server.utils.WatchedArraySet;
import com.android.server.utils.Watcher;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import libcore.util.EmptyArray;

/* JADX INFO: loaded from: classes2.dex */
public final class SharedUserSetting extends SettingBase implements SharedUserApi {
    int mAppId;
    final WatchedArraySet<PackageSetting> mDisabledPackages;
    private final SnapshotCache<WatchedArraySet<PackageSetting>> mDisabledPackagesSnapshot;
    private final Watcher mObserver;
    private final WatchedArraySet<PackageSetting> mPackages;
    private final SnapshotCache<WatchedArraySet<PackageSetting>> mPackagesSnapshot;
    private final SnapshotCache<SharedUserSetting> mSnapshot;
    final String name;
    final ArrayMap<String, ParsedProcess> processes;
    int seInfoTargetSdkVersion;
    final PackageSignatures signatures;
    Boolean signaturesChanged;
    int uidFlags;
    int uidPrivateFlags;

    /* synthetic */ SharedUserSetting(SharedUserSetting r1, SharedUserSettingIA r2) {
        this(r1);
    }

    @Override // com.android.server.utils.Snappable
    public /* bridge */ /* synthetic */ Object snapshot() {
        return snapshot();
    }

    private SnapshotCache<SharedUserSetting> makeCache() {
        return new AnonymousClass2(this, this, this);
    }

    SharedUserSetting(String _name, int _pkgFlags, int _pkgPrivateFlags) {
        super(_pkgFlags, _pkgPrivateFlags);
        this.mObserver = new AnonymousClass1(this);
        this.signatures = new PackageSignatures();
        this.uidFlags = _pkgFlags;
        this.uidPrivateFlags = _pkgPrivateFlags;
        this.name = _name;
        this.seInfoTargetSdkVersion = 10000;
        this.mPackages = new WatchedArraySet();
        this.mPackagesSnapshot = new SnapshotCache.Auto(this.mPackages, this.mPackages, "SharedUserSetting.packages");
        this.mDisabledPackages = new WatchedArraySet();
        this.mDisabledPackagesSnapshot = new SnapshotCache.Auto(this.mDisabledPackages, this.mDisabledPackages, "SharedUserSetting.mDisabledPackages");
        this.processes = new ArrayMap();
        registerObservers();
        this.mSnapshot = makeCache();
    }

    private SharedUserSetting(SharedUserSetting orig) {
        super(orig);
        this.mObserver = new AnonymousClass1(this);
        this.signatures = new PackageSignatures();
        this.name = orig.name;
        this.mAppId = orig.mAppId;
        this.uidFlags = orig.uidFlags;
        this.uidPrivateFlags = orig.uidPrivateFlags;
        this.mPackages = orig.mPackagesSnapshot.snapshot();
        this.mPackagesSnapshot = new SnapshotCache.Sealed();
        this.mDisabledPackages = orig.mDisabledPackagesSnapshot.snapshot();
        this.mDisabledPackagesSnapshot = new SnapshotCache.Sealed();
        PackageSignatures r0 = this.signatures;
        r0.mSigningDetails = orig.signatures.mSigningDetails;
        this.signaturesChanged = orig.signaturesChanged;
        this.processes = new ArrayMap(orig.processes);
        this.mSnapshot = new SnapshotCache.Sealed();
    }

    private void registerObservers() {
        this.mPackages.registerObserver(this.mObserver);
        this.mDisabledPackages.registerObserver(this.mObserver);
    }

    @Override // com.android.server.utils.Snappable
    public SharedUserSetting snapshot() {
        return this.mSnapshot.snapshot();
    }

    public String toString() {
        return "SharedUserSetting{" + Integer.toHexString(System.identityHashCode(this)) + " " + this.name + SliceClientPermissions.SliceAuthority.DELIMITER + this.mAppId + "}";
    }

    public void dumpDebug(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        proto.write(1120986464257L, this.mAppId);
        proto.write(1138166333442L, this.name);
        proto.end(token);
    }

    void addProcesses(Map<String, ParsedProcess> newProcs) {
        if (newProcs == null) goto L19;
        Iterator<String> r0 = newProcs.keySet().iterator();
    L5:
        if (r0.hasNext() == false) goto L11;
        String key = r0.next();
        ParsedProcess newProc = newProcs.get(key);
        ParsedProcess proc = this.processes.get(newProc.getName());
        if (proc == null) goto L8;
        ComponentMutateUtils.addStateFrom(proc, newProc);
        goto L5
    L8:
        ParsedProcess proc2 = new ParsedProcessImpl(newProc);
        this.processes.put(newProc.getName(), proc2);
        goto L5
    L11:
        onChanged();
        return;
    }

    boolean removePackage(PackageSetting packageSetting) {
        if (this.mPackages.remove(packageSetting) == true) goto L7;
        return false;
    L7:
        if ((getFlags() & packageSetting.getFlags()) == 0) goto L13;
        int aggregatedFlags = this.uidFlags;
        int i = 0;
    L10:
        if (i >= this.mPackages.size()) goto L12;
        PackageSetting ps = this.mPackages.valueAt(i);
        aggregatedFlags = aggregatedFlags | ps.getFlags();
        i = i + 1;
        goto L10
    L12:
        setFlags(aggregatedFlags);
    L13:
        int aggregatedFlags2 = getPrivateFlags();
        if ((aggregatedFlags2 & packageSetting.getPrivateFlags()) == 0) goto L20;
        int aggregatedPrivateFlags = this.uidPrivateFlags;
        int i2 = 0;
    L17:
        if (i2 >= this.mPackages.size()) goto L19;
        PackageSetting ps2 = this.mPackages.valueAt(i2);
        aggregatedPrivateFlags = aggregatedPrivateFlags | ps2.getPrivateFlags();
        i2 = i2 + 1;
        goto L17
    L19:
        setPrivateFlags(aggregatedPrivateFlags);
    L20:
        updateProcesses();
        onChanged();
        return true;
    }

    void addPackage(PackageSetting packageSetting) {
        if (this.mPackages.size() != 0) goto L8;
        if (packageSetting.getPkg() == null) goto L8;
        this.seInfoTargetSdkVersion = packageSetting.getPkg().getTargetSdkVersion();
    L8:
        if (this.mPackages.add(packageSetting) == false) goto L11;
        setFlags(getFlags() | packageSetting.getFlags());
        setPrivateFlags(getPrivateFlags() | packageSetting.getPrivateFlags());
        onChanged();
    L11:
        if (packageSetting.getPkg() == null) goto L14;
        addProcesses(packageSetting.getPkg().getProcesses());
        return;
    }

    @Override // com.android.server.pm.pkg.SharedUserApi
    public List<AndroidPackage> getPackages() {
        if (this.mPackages == null) goto L20;
        if (this.mPackages.size() == 0) goto L20;
        ArrayList<AndroidPackage> pkgList = new ArrayList(this.mPackages.size());
        int i = 0;
    L9:
        if (i >= this.mPackages.size()) goto L18;
        PackageSetting ps = this.mPackages.valueAt(i);
        if (ps == null) goto L16;
        if (ps.getPkg() == null) goto L16;
        pkgList.add(ps.getPkg());
    L16:
        i = i + 1;
        goto L9
    L18:
        return pkgList;
    L20:
        return Collections.emptyList();
    }

    @Override // com.android.server.pm.pkg.SharedUserApi
    public boolean isPrivileged() {
        if ((getPrivateFlags() & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isSingleUser() {
        if (this.mPackages.size() == 1) goto L6;
        return false;
    L6:
        if (this.mDisabledPackages.size() <= 1) goto L9;
        return false;
    L9:
        if (this.mDisabledPackages.size() != 1) goto L16;
        AndroidPackageInternal r0 = this.mDisabledPackages.valueAt(0).getPkg();
        if (r0 != null) goto L13;
        return false;
    L13:
        if (r0.isLeavingSharedUser() == true) goto L15;
        return false;
    L15:
        return true;
    L16:
        return true;
    }

    public void fixSeInfoLocked() {
        if (this.mPackages != null) goto L5;
        return;
    L5:
        if (this.mPackages.size() == 0) goto L41;
        int i = 0;
    L9:
        if (i >= this.mPackages.size()) goto L19;
        PackageSetting ps = this.mPackages.valueAt(i);
        if (ps == null) goto L18;
        if (ps.getPkg() == null) goto L18;
        if (ps.getPkg().getTargetSdkVersion() >= this.seInfoTargetSdkVersion) goto L18;
        this.seInfoTargetSdkVersion = ps.getPkg().getTargetSdkVersion();
        onChanged();
    L18:
        i = i + 1;
        goto L9
    L19:
        int i2 = 0;
    L21:
        if (i2 >= this.mPackages.size()) goto L30;
        PackageSetting ps2 = this.mPackages.valueAt(i2);
        if (ps2 == null) goto L28;
        if (ps2.getPkg() == null) goto L28;
        boolean isPrivileged = isPrivileged() | ps2.isPrivileged();
        ps2.getPkgState().setOverrideSeInfo(SELinuxMMAC.getSeInfo(ps2, ps2.getPkg(), isPrivileged, this.seInfoTargetSdkVersion));
        onChanged();
    L28:
        i2 = i2 + 1;
        goto L21
    L30:
        return;
    }

    public void updateProcesses() {
        this.processes.clear();
        int i = this.mPackages.size() - 1;
    L3:
        if (i < 0) goto L9;
        AndroidPackageInternal r1 = this.mPackages.valueAt(i).getPkg();
        if (r1 == null) goto L7;
        addProcesses(r1.getProcesses());
    L7:
        i = i - 1;
        goto L3
    }

    public int[] getNotInstalledUserIds() {
        int[] excludedUserIds = null;
        int i = 0;
    L4:
        if (i >= this.mPackages.size()) goto L18;
        PackageSetting ps = this.mPackages.valueAt(i);
        int[] userIds = ps.getNotInstalledUserIds();
        if (excludedUserIds != null) goto L8;
        excludedUserIds = userIds;
    L16:
        i = i + 1;
        goto L4
    L8:
        int r4 = excludedUserIds.length;
        int r5 = 0;
        int[] excludedUserIds2 = excludedUserIds;
    L10:
        if (r5 >= r4) goto L15;
        int userId = excludedUserIds[r5];
        if (ArrayUtils.contains(userIds, userId) == true) goto L14;
        excludedUserIds2 = ArrayUtils.removeInt(excludedUserIds2, userId);
    L14:
        r5 = r5 + 1;
        goto L10
    L15:
        excludedUserIds = excludedUserIds2;
        goto L16
    L18:
        if (excludedUserIds != null) goto L21;
        return EmptyArray.INT;
    L21:
        return excludedUserIds;
    }

    public SharedUserSetting updateFrom(SharedUserSetting sharedUser) {
        super.copySettingBase(sharedUser);
        this.mAppId = sharedUser.mAppId;
        this.uidFlags = sharedUser.uidFlags;
        this.uidPrivateFlags = sharedUser.uidPrivateFlags;
        this.seInfoTargetSdkVersion = sharedUser.seInfoTargetSdkVersion;
        this.mPackages.clear();
        this.mPackages.addAll(sharedUser.mPackages);
        this.signaturesChanged = sharedUser.signaturesChanged;
        if (sharedUser.processes == null) goto L8;
        int numProcs = sharedUser.processes.size();
        this.processes.clear();
        this.processes.ensureCapacity(numProcs);
        int i = 0;
    L5:
        if (i >= numProcs) goto L9;
        ParsedProcess proc = new ParsedProcessImpl(sharedUser.processes.valueAt(i));
        this.processes.put(proc.getName(), proc);
        i = i + 1;
    L9:
        onChanged();
        return this;
    L8:
        this.processes.clear();
        goto L9
    }

    @Override // com.android.server.pm.pkg.SharedUserApi
    public String getName() {
        return this.name;
    }

    @Override // com.android.server.pm.pkg.SharedUserApi
    public int getAppId() {
        return this.mAppId;
    }

    @Override // com.android.server.pm.pkg.SharedUserApi
    public int getUidFlags() {
        return this.uidFlags;
    }

    @Override // com.android.server.pm.pkg.SharedUserApi
    public int getPrivateUidFlags() {
        return this.uidPrivateFlags;
    }

    @Override // com.android.server.pm.pkg.SharedUserApi
    public int getSeInfoTargetSdkVersion() {
        return this.seInfoTargetSdkVersion;
    }

    public WatchedArraySet<PackageSetting> getPackageSettings() {
        return this.mPackages;
    }

    public WatchedArraySet<PackageSetting> getDisabledPackageSettings() {
        return this.mDisabledPackages;
    }

    @Override // com.android.server.pm.pkg.SharedUserApi
    public ArraySet<? extends PackageStateInternal> getPackageStates() {
        return this.mPackages.untrackedStorage();
    }

    @Override // com.android.server.pm.pkg.SharedUserApi
    public ArraySet<? extends PackageStateInternal> getDisabledPackageStates() {
        return this.mDisabledPackages.untrackedStorage();
    }

    @Override // com.android.server.pm.pkg.SharedUserApi
    public SigningDetails getSigningDetails() {
        return this.signatures.mSigningDetails;
    }

    @Override // com.android.server.pm.pkg.SharedUserApi
    public ArrayMap<String, ParsedProcess> getProcesses() {
        return this.processes;
    }

    @Override // com.android.server.pm.pkg.SharedUserApi
    public LegacyPermissionState getSharedUserLegacyPermissionState() {
        return super.getLegacyPermissionState();
    }
}
