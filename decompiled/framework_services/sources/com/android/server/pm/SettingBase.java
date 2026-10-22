package com.android.server.pm;

import com.android.server.pm.permission.LegacyPermissionState;
import com.android.server.pm.pkg.mutate.PackageStateMutator;
import com.android.server.utils.Snappable;
import com.android.server.utils.Watchable;
import com.android.server.utils.WatchableImpl;
import com.android.server.utils.Watcher;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SettingBase implements Watchable, Snappable {

    @Deprecated
    protected final LegacyPermissionState mLegacyPermissionsState;
    private int mPkgFlags;
    private int mPkgPrivateFlags;
    private final Watchable mWatchable;

    @Override // com.android.server.utils.Watchable
    public void registerObserver(Watcher observer) {
        this.mWatchable.registerObserver(observer);
    }

    @Override // com.android.server.utils.Watchable
    public void unregisterObserver(Watcher observer) {
        this.mWatchable.unregisterObserver(observer);
    }

    @Override // com.android.server.utils.Watchable
    public boolean isRegisteredObserver(Watcher observer) {
        return this.mWatchable.isRegisteredObserver(observer);
    }

    @Override // com.android.server.utils.Watchable
    public void dispatchChange(Watchable what) {
        this.mWatchable.dispatchChange(what);
    }

    public void onChanged() {
        PackageStateMutator.onPackageStateChanged();
        dispatchChange(this);
    }

    SettingBase(int pkgFlags, int pkgPrivateFlags) {
        this.mWatchable = new WatchableImpl();
        this.mLegacyPermissionsState = new LegacyPermissionState();
        setFlags(pkgFlags);
        setPrivateFlags(pkgPrivateFlags);
    }

    SettingBase(SettingBase orig) {
        this.mWatchable = new WatchableImpl();
        this.mLegacyPermissionsState = new LegacyPermissionState();
        if (orig == null) goto L6;
        copySettingBase(orig);
        return;
    }

    public final void copySettingBase(SettingBase orig) {
        this.mPkgFlags = orig.mPkgFlags;
        this.mPkgPrivateFlags = orig.mPkgPrivateFlags;
        this.mLegacyPermissionsState.copyFrom(orig.mLegacyPermissionsState);
        onChanged();
    }

    @Deprecated
    public LegacyPermissionState getLegacyPermissionState() {
        return this.mLegacyPermissionsState;
    }

    public SettingBase setFlags(int pkgFlags) {
        this.mPkgFlags = pkgFlags;
        onChanged();
        return this;
    }

    public SettingBase setPrivateFlags(int pkgPrivateFlags) {
        this.mPkgPrivateFlags = pkgPrivateFlags;
        onChanged();
        return this;
    }

    public int getFlags() {
        return this.mPkgFlags;
    }

    public int getPrivateFlags() {
        return this.mPkgPrivateFlags;
    }
}
