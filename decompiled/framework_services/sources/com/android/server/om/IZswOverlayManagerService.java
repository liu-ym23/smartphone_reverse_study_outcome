package com.android.server.om;

import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public interface IZswOverlayManagerService {
    void readRandomThemeName_multheme(int r1);

    void updatePackageManagerLocked_multheme(HashSet<String> r1, boolean r2);

    boolean updateTargetPackagesLocked_multheme();
}
