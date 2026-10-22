package com.android.server.textclassifier;

import android.net.Uri;
import android.util.ArrayMap;
import android.util.Log;
import com.android.server.pm.PackageManagerService;
import com.android.server.wm.ActivityTaskManagerInternal;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes3.dex */
public final class IconsUriHelper {
    public static final String AUTHORITY = "com.android.textclassifier.icons";
    private static final Supplier<String> DEFAULT_ID_SUPPLIER = null;
    private static final String TAG = "IconsUriHelper";
    private static final IconsUriHelper sSingleton = null;
    private final Supplier<String> mIdSupplier;
    private final Map<String, String> mPackageIds;

    public static final class ResourceInfo {
        public final int id;
        public final String packageName;

        /* synthetic */ ResourceInfo(String r1, int r2, IconsUriHelperIA r3) {
            this(r1, r2);
        }

        private ResourceInfo(String packageName, int id) {
            packageName.getClass();
            this.packageName = packageName;
            this.id = id;
        }
    }

    public static /* synthetic */ String $r8$lambda$HWl8t3YQCuh5S8qTuqc4zlNCQLg() {
        return lambda$static$0();
    }

    static {
        DEFAULT_ID_SUPPLIER = new IconsUriHelper$$ExternalSyntheticLambda0();
        sSingleton = new IconsUriHelper(null);
    }

    private static /* synthetic */ String lambda$static$0() {
        return UUID.randomUUID().toString();
    }

    private IconsUriHelper(Supplier<String> idSupplier) {
        this.mPackageIds = new ArrayMap();
        if (idSupplier == null) goto L5;
        Supplier<String> r0 = idSupplier;
    L6:
        this.mIdSupplier = r0;
        this.mPackageIds.put(PackageManagerService.PLATFORM_PACKAGE_NAME, PackageManagerService.PLATFORM_PACKAGE_NAME);
        return;
    L5:
        r0 = DEFAULT_ID_SUPPLIER;
        goto L6
    }

    public static IconsUriHelper newInstanceForTesting(Supplier<String> idSupplier) {
        return new IconsUriHelper(idSupplier);
    }

    static IconsUriHelper getInstance() {
        return sSingleton;
    }

    public Uri getContentUri(String packageName, int resId) {
        packageName.getClass();
        Map<String, String> r0 = this.mPackageIds;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mPackageIds.containsKey(packageName) == true) goto L9;
        this.mPackageIds.put(packageName, this.mIdSupplier.get());     // Catch: Throwable -> L7
    L9:
        Uri r1 = new Uri.Builder().scheme(ActivityTaskManagerInternal.ASSIST_KEY_CONTENT).authority(AUTHORITY).path(this.mPackageIds.get(packageName)).appendPath(Integer.toString(resId)).build();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    }

    public ResourceInfo getResourceInfo(Uri uri) {
        IconsUriHelperIA r1 = null;
        if (ActivityTaskManagerInternal.ASSIST_KEY_CONTENT.equals(uri.getScheme()) == true) goto L6;
        return null;
    L6:
        if (AUTHORITY.equals(uri.getAuthority()) == true) goto L8;
        return null;
    L8:
        List<String> pathItems = uri.getPathSegments();
        Map<String, String> r2 = this.mPackageIds;     // Catch: Exception -> L27
        monitor-enter(r2);     // Catch: Exception -> L27
        String packageId = pathItems.get(0);     // Catch: Throwable -> L20
        int resId = Integer.parseInt(pathItems.get(1));     // Catch: Throwable -> L20
        Iterator<String> r5 = this.mPackageIds.keySet().iterator();     // Catch: Throwable -> L20
    L14:
        if (r5.hasNext() == false) goto L23;
        String packageName = r5.next();     // Catch: Throwable -> L20
        if (packageId.equals(this.mPackageIds.get(packageName)) == false) goto L14;
        ResourceInfo r6 = new ResourceInfo(packageName, resId, r1);     // Catch: Throwable -> L20
        monitor-exit(r2);     // Catch: Throwable -> L20
        return r6;
    L23:
        monitor-exit(r2);     // Catch: Throwable -> L20
    L29:
        return null;
    L20:
        th = move-exception;
        throw th;     // Catch: Exception -> L27
    L27:
        e = move-exception;
        Log.v(TAG, "Could not get resource info. Reason: " + e.getMessage());
        goto L29
    }
}
