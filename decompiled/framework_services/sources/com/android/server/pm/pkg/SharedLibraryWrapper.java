package com.android.server.pm.pkg;

import android.content.pm.SharedLibraryInfo;
import android.content.pm.VersionedPackage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SharedLibraryWrapper implements SharedLibrary {
    private List<SharedLibrary> cachedDependenciesList;
    private final SharedLibraryInfo mInfo;

    public SharedLibraryWrapper(SharedLibraryInfo info) {
        this.mInfo = info;
    }

    public SharedLibraryInfo getInfo() {
        return this.mInfo;
    }

    @Override // com.android.server.pm.pkg.SharedLibrary
    public String getPath() {
        return this.mInfo.getPath();
    }

    @Override // com.android.server.pm.pkg.SharedLibrary
    public String getPackageName() {
        return this.mInfo.getPackageName();
    }

    @Override // com.android.server.pm.pkg.SharedLibrary
    public String getName() {
        return this.mInfo.getName();
    }

    @Override // com.android.server.pm.pkg.SharedLibrary
    public List<String> getAllCodePaths() {
        return Collections.unmodifiableList(this.mInfo.getAllCodePaths());
    }

    @Override // com.android.server.pm.pkg.SharedLibrary
    public long getVersion() {
        return this.mInfo.getLongVersion();
    }

    @Override // com.android.server.pm.pkg.SharedLibrary
    public int getType() {
        return this.mInfo.getType();
    }

    @Override // com.android.server.pm.pkg.SharedLibrary
    public boolean isNative() {
        return this.mInfo.isNative();
    }

    @Override // com.android.server.pm.pkg.SharedLibrary
    public VersionedPackage getDeclaringPackage() {
        return this.mInfo.getDeclaringPackage();
    }

    @Override // com.android.server.pm.pkg.SharedLibrary
    public List<VersionedPackage> getDependentPackages() {
        return Collections.unmodifiableList(this.mInfo.getDependentPackages());
    }

    @Override // com.android.server.pm.pkg.SharedLibrary
    public List<SharedLibrary> getDependencies() {
        if (this.cachedDependenciesList != null) goto L13;
        List<SharedLibraryInfo> dependencies = this.mInfo.getDependencies();
        if (dependencies != null) goto L7;
        this.cachedDependenciesList = Collections.emptyList();
        goto L13
    L7:
        ArrayList<SharedLibrary> list = new ArrayList();
        int index = 0;
    L9:
        if (index >= dependencies.size()) goto L11;
        list.add(new SharedLibraryWrapper(dependencies.get(index)));
        index = index + 1;
        goto L9
    L11:
        this.cachedDependenciesList = Collections.unmodifiableList(list);
    L13:
        return this.cachedDependenciesList;
    }
}
