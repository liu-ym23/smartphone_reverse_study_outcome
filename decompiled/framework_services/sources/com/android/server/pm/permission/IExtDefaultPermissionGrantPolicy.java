package com.android.server.pm.permission;

import android.pico.utils.IExtBase;
import com.android.server.pm.PackageSetting;

/* JADX INFO: loaded from: classes2.dex */
public interface IExtDefaultPermissionGrantPolicy extends IExtBase {
    default void onPackageAdded(PackageSetting pkgSetting) {
    }
}
