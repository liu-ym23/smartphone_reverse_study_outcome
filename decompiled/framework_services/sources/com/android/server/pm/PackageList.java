package com.android.server.pm;

import android.content.pm.PackageManagerInternal;
import com.android.server.LocalServices;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PackageList implements PackageManagerInternal.PackageListObserver, AutoCloseable {
    private final List<String> mPackageNames;
    private final PackageManagerInternal.PackageListObserver mWrappedObserver;

    public PackageList(List<String> packageNames, PackageManagerInternal.PackageListObserver observer) {
        this.mPackageNames = packageNames;
        this.mWrappedObserver = observer;
    }

    @Override // android.content.pm.PackageManagerInternal.PackageListObserver
    public void onPackageAdded(String packageName, int uid) {
        if (this.mWrappedObserver == null) goto L6;
        this.mWrappedObserver.onPackageAdded(packageName, uid);
        return;
    }

    @Override // android.content.pm.PackageManagerInternal.PackageListObserver
    public void onPackageChanged(String packageName, int uid) {
        if (this.mWrappedObserver == null) goto L6;
        this.mWrappedObserver.onPackageChanged(packageName, uid);
        return;
    }

    @Override // android.content.pm.PackageManagerInternal.PackageListObserver
    public void onPackageRemoved(String packageName, int uid) {
        if (this.mWrappedObserver == null) goto L6;
        this.mWrappedObserver.onPackageRemoved(packageName, uid);
        return;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws Exception {
        ((PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class)).removePackageListObserver(this);
    }

    public List<String> getPackageNames() {
        return this.mPackageNames;
    }
}
