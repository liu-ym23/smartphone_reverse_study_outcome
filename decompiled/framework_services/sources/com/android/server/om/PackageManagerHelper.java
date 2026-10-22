package com.android.server.om;

import android.content.om.OverlayableInfo;
import android.util.ArrayMap;
import com.android.server.pm.pkg.PackageState;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
interface PackageManagerHelper {
    boolean doesTargetDefineOverlayable(String r1, int r2) throws IOException;

    void enforcePermission(String r1, String r2) throws SecurityException;

    String getConfigSignaturePackage();

    Map<String, Map<String, String>> getNamedActors();

    OverlayableInfo getOverlayableForTarget(String r1, String r2, int r3) throws IOException;

    PackageState getPackageStateForUser(String r1, int r2);

    String[] getPackagesForUid(int r1);

    ArrayMap<String, PackageState> initializeForUser(int r1);

    boolean isInstantApp(String r1, int r2);

    boolean signaturesMatching(String r1, String r2, int r3);
}
