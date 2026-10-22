package com.android.server.uri;

import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.IBinder;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
public interface UriGrantsManagerInternal {
    boolean checkAuthorityGrants(int r1, ProviderInfo r2, int r3, boolean r4);

    int checkGrantUriPermission(int r1, String r2, Uri r3, int r4, int r5);

    NeededUriGrants checkGrantUriPermissionFromIntent(Intent r1, int r2, String r3, int r4);

    NeededUriGrants checkGrantUriPermissionFromIntent(Intent r1, int r2, String r3, int r4, int r5, int r6);

    boolean checkUriPermission(GrantUri r1, int r2, int r3, boolean r4);

    void dump(PrintWriter r1, boolean r2, String r3);

    void grantUriPermissionUncheckedFromIntent(NeededUriGrants r1, UriPermissionOwner r2);

    IBinder newUriPermissionOwner(String r1);

    void notifyActivityLaunchRequestCompleted(int r1, boolean r2, String r3, int r4, String r5, int r6, String r7, boolean r8);

    void onSystemReady();

    void removeUriPermissionIfNeeded(UriPermission r1);

    void removeUriPermissionsForPackage(String r1, int r2, boolean r3, boolean r4);

    void revokeUriPermission(String r1, int r2, GrantUri r3, int r4);

    void revokeUriPermissionFromOwner(IBinder r1, Uri r2, int r3, int r4);

    void revokeUriPermissionFromOwner(IBinder r1, Uri r2, int r3, int r4, String r5, int r6);
}
