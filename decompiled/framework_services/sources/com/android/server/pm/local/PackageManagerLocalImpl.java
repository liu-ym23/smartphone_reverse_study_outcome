package com.android.server.pm.local;

import android.content.pm.SigningDetails;
import android.os.Binder;
import android.os.Build;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.apk.ApkSignatureVerifier;
import com.android.server.pm.Computer;
import com.android.server.pm.PackageManagerLocal;
import com.android.server.pm.PackageManagerService;
import com.android.server.pm.pkg.PackageState;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.pkg.SharedUserApi;
import com.android.server.pm.snapshot.PackageDataSnapshot;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class PackageManagerLocalImpl implements PackageManagerLocal {
    private final PackageManagerService mService;

    private static abstract class BaseSnapshotImpl implements AutoCloseable {
        private boolean mClosed;
        protected Computer mSnapshot;

        /* synthetic */ BaseSnapshotImpl(PackageDataSnapshot r1, PackageManagerLocalImplIA r2) {
            this(r1);
        }

        private BaseSnapshotImpl(PackageDataSnapshot snapshot) {
            this.mSnapshot = (Computer) snapshot;
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            this.mClosed = true;
            this.mSnapshot = null;
        }

        protected void checkClosed() {
            if (this.mClosed == true) goto L6;
            return;
        L6:
            throw new IllegalStateException("Snapshot already closed");
        }
    }

    private static class FilteredSnapshotImpl extends BaseSnapshotImpl implements PackageManagerLocal.FilteredSnapshot {
        private final int mCallingUid;
        private Map<String, PackageState> mFilteredPackageStates;
        private final UnfilteredSnapshotImpl mParentSnapshot;
        private final PackageState mUncommitPackageState;
        private final int mUserId;

        /* synthetic */ FilteredSnapshotImpl(int r1, UserHandle r2, PackageDataSnapshot r3, UnfilteredSnapshotImpl r4, PackageState r5, PackageManagerLocalImplIA r6) {
            this(r1, r2, r3, r4, r5);
        }

        private FilteredSnapshotImpl(int callingUid, UserHandle user, PackageDataSnapshot snapshot, UnfilteredSnapshotImpl parentSnapshot, PackageState uncommittedPs) {
            super(snapshot, null);
            this.mCallingUid = callingUid;
            this.mUserId = user.getIdentifier();
            this.mParentSnapshot = parentSnapshot;
            this.mUncommitPackageState = uncommittedPs;
        }

        @Override // com.android.server.pm.local.PackageManagerLocalImpl.BaseSnapshotImpl
        protected void checkClosed() {
            if (this.mParentSnapshot == null) goto L5;
            this.mParentSnapshot.checkClosed();
        L5:
            super.checkClosed();
        }

        @Override // com.android.server.pm.local.PackageManagerLocalImpl.BaseSnapshotImpl, java.lang.AutoCloseable
        public void close() {
            super.close();
            this.mFilteredPackageStates = null;
        }

        @Override // com.android.server.pm.PackageManagerLocal.FilteredSnapshot
        public PackageState getPackageState(String packageName) {
            checkClosed();
            if (this.mUncommitPackageState == null) goto L9;
            if (packageName.equals(this.mUncommitPackageState.getPackageName()) == false) goto L9;
            return this.mUncommitPackageState;
        L9:
            return this.mSnapshot.getPackageStateFiltered(packageName, this.mCallingUid, this.mUserId);
        }

        @Override // com.android.server.pm.PackageManagerLocal.FilteredSnapshot
        public Map<String, PackageState> getPackageStates() {
            checkClosed();
            if (this.mFilteredPackageStates != null) goto L17;
            ArrayMap<String, ? extends PackageStateInternal> packageStates = this.mSnapshot.getPackageStates();
            ArrayMap<String, PackageState> filteredPackageStates = new ArrayMap();
            int index = 0;
            int size = packageStates.size();
        L5:
            if (index >= size) goto L15;
            PackageStateInternal packageState = packageStates.valueAt(index);
            if (this.mUncommitPackageState == null) goto L12;
            if (packageState.getPackageName().equals(this.mUncommitPackageState.getPackageName()) == false) goto L12;
            packageState = (PackageStateInternal) this.mUncommitPackageState;
        L12:
            if (this.mSnapshot.shouldFilterApplication(packageState, this.mCallingUid, this.mUserId) == true) goto L14;
            filteredPackageStates.put(packageStates.keyAt(index), packageState);
        L14:
            index = index + 1;
            goto L5
        L15:
            this.mFilteredPackageStates = Collections.unmodifiableMap(filteredPackageStates);
        L17:
            return this.mFilteredPackageStates;
        }
    }

    private static class UnfilteredSnapshotImpl extends BaseSnapshotImpl implements PackageManagerLocal.UnfilteredSnapshot {
        private Map<String, PackageState> mCachedUnmodifiableDisabledSystemPackageStates;
        private Map<String, PackageState> mCachedUnmodifiablePackageStates;
        private Map<String, SharedUserApi> mCachedUnmodifiableSharedUsers;

        /* synthetic */ UnfilteredSnapshotImpl(PackageDataSnapshot r1, PackageManagerLocalImplIA r2) {
            this(r1);
        }

        private UnfilteredSnapshotImpl(PackageDataSnapshot snapshot) {
            super(snapshot, null);
        }

        @Override // com.android.server.pm.PackageManagerLocal.UnfilteredSnapshot
        public PackageManagerLocal.FilteredSnapshot filtered(int callingUid, UserHandle user) {
            return new FilteredSnapshotImpl(callingUid, user, this.mSnapshot, this, null, null);
        }

        @Override // com.android.server.pm.PackageManagerLocal.UnfilteredSnapshot
        public Map<String, PackageState> getPackageStates() {
            checkClosed();
            if (this.mCachedUnmodifiablePackageStates != null) goto L6;
            this.mCachedUnmodifiablePackageStates = Collections.unmodifiableMap(this.mSnapshot.getPackageStates());
        L6:
            return this.mCachedUnmodifiablePackageStates;
        }

        @Override // com.android.server.pm.PackageManagerLocal.UnfilteredSnapshot
        public Map<String, SharedUserApi> getSharedUsers() {
            checkClosed();
            if (this.mCachedUnmodifiableSharedUsers != null) goto L6;
            this.mCachedUnmodifiableSharedUsers = Collections.unmodifiableMap(this.mSnapshot.getSharedUsers());
        L6:
            return this.mCachedUnmodifiableSharedUsers;
        }

        @Override // com.android.server.pm.PackageManagerLocal.UnfilteredSnapshot
        public Map<String, PackageState> getDisabledSystemPackageStates() {
            checkClosed();
            if (this.mCachedUnmodifiableDisabledSystemPackageStates != null) goto L6;
            this.mCachedUnmodifiableDisabledSystemPackageStates = Collections.unmodifiableMap(this.mSnapshot.getDisabledSystemPackageStates());
        L6:
            return this.mCachedUnmodifiableDisabledSystemPackageStates;
        }

        @Override // com.android.server.pm.local.PackageManagerLocalImpl.BaseSnapshotImpl, java.lang.AutoCloseable
        public void close() {
            super.close();
            this.mCachedUnmodifiablePackageStates = null;
            this.mCachedUnmodifiableDisabledSystemPackageStates = null;
        }
    }

    @Override // com.android.server.pm.PackageManagerLocal
    public /* bridge */ /* synthetic */ PackageManagerLocal.FilteredSnapshot withFilteredSnapshot() {
        return withFilteredSnapshot();
    }

    @Override // com.android.server.pm.PackageManagerLocal
    public /* bridge */ /* synthetic */ PackageManagerLocal.FilteredSnapshot withFilteredSnapshot(int r1, UserHandle r2) {
        return withFilteredSnapshot(r1, r2);
    }

    @Override // com.android.server.pm.PackageManagerLocal
    public /* bridge */ /* synthetic */ PackageManagerLocal.UnfilteredSnapshot withUnfilteredSnapshot() {
        return withUnfilteredSnapshot();
    }

    public PackageManagerLocalImpl(PackageManagerService service) {
        this.mService = service;
    }

    @Override // com.android.server.pm.PackageManagerLocal
    public void reconcileSdkData(String volumeUuid, String packageName, List<String> subDirNames, int userId, int appId, int previousAppId, String seInfo, int flags) throws IOException {
        this.mService.reconcileSdkData(volumeUuid, packageName, subDirNames, userId, appId, previousAppId, seInfo, flags);
    }

    @Override // com.android.server.pm.PackageManagerLocal
    public UnfilteredSnapshotImpl withUnfilteredSnapshot() {
        return new UnfilteredSnapshotImpl(this.mService.snapshotComputer(false), null);
    }

    @Override // com.android.server.pm.PackageManagerLocal
    public FilteredSnapshotImpl withFilteredSnapshot() {
        return withFilteredSnapshot(Binder.getCallingUid(), Binder.getCallingUserHandle());
    }

    @Override // com.android.server.pm.PackageManagerLocal
    public FilteredSnapshotImpl withFilteredSnapshot(int callingUid, UserHandle user) {
        return withFilteredSnapshot(callingUid, user, null);
    }

    public static FilteredSnapshotImpl withFilteredSnapshot(PackageManagerLocal pm, PackageState uncommittedPs) {
        return ((PackageManagerLocalImpl) pm).withFilteredSnapshot(Binder.getCallingUid(), Binder.getCallingUserHandle(), uncommittedPs);
    }

    private FilteredSnapshotImpl withFilteredSnapshot(int callingUid, UserHandle user, PackageState uncommittedPs) {
        return new FilteredSnapshotImpl(callingUid, user, this.mService.snapshotComputer(false), null, uncommittedPs, null);
    }

    @Override // com.android.server.pm.PackageManagerLocal
    public void addOverrideSigningDetails(SigningDetails oldSigningDetails, SigningDetails newSigningDetails) {
        if (Build.isDebuggable() == false) goto L7;
        ApkSignatureVerifier.addOverrideSigningDetails(oldSigningDetails, newSigningDetails);
        return;
    L7:
        throw new SecurityException("This test API is only available on debuggable builds");
    }

    @Override // com.android.server.pm.PackageManagerLocal
    public void removeOverrideSigningDetails(SigningDetails oldSigningDetails) {
        if (Build.isDebuggable() == false) goto L7;
        ApkSignatureVerifier.removeOverrideSigningDetails(oldSigningDetails);
        return;
    L7:
        throw new SecurityException("This test API is only available on debuggable builds");
    }

    @Override // com.android.server.pm.PackageManagerLocal
    public void clearOverrideSigningDetails() {
        if (Build.isDebuggable() == false) goto L7;
        ApkSignatureVerifier.clearOverrideSigningDetails();
        return;
    L7:
        throw new SecurityException("This test API is only available on debuggable builds");
    }
}
