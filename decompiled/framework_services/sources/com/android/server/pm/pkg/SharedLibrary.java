package com.android.server.pm.pkg;

import android.annotation.SystemApi;
import android.content.pm.VersionedPackage;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@SystemApi(client = SystemApi.Client.SYSTEM_SERVER)
public interface SharedLibrary {
    List<String> getAllCodePaths();

    VersionedPackage getDeclaringPackage();

    List<SharedLibrary> getDependencies();

    List<VersionedPackage> getDependentPackages();

    String getName();

    String getPackageName();

    String getPath();

    int getType();

    long getVersion();

    boolean isNative();
}
