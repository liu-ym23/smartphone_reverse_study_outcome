package com.android.server.pm.pkg;

import android.content.pm.SigningDetails;
import android.util.ArrayMap;
import android.util.ArraySet;
import com.android.internal.pm.pkg.component.ParsedProcess;
import com.android.server.pm.permission.LegacyPermissionState;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface SharedUserApi {
    int getAppId();

    ArraySet<? extends PackageStateInternal> getDisabledPackageStates();

    String getName();

    ArraySet<? extends PackageStateInternal> getPackageStates();

    List<AndroidPackage> getPackages();

    int getPrivateUidFlags();

    ArrayMap<String, ParsedProcess> getProcesses();

    int getSeInfoTargetSdkVersion();

    LegacyPermissionState getSharedUserLegacyPermissionState();

    SigningDetails getSigningDetails();

    int getUidFlags();

    boolean isPrivileged();
}
