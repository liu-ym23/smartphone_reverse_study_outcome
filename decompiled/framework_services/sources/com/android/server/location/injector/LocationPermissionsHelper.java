package com.android.server.location.injector;

import android.location.util.identity.CallerIdentity;
import com.android.server.location.LocationPermissions;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class LocationPermissionsHelper {
    private final AppOpsHelper mAppOps;
    private final CopyOnWriteArrayList<LocationPermissionsListener> mListeners;

    public interface LocationPermissionsListener {
        void onLocationPermissionsChanged(int r1);

        void onLocationPermissionsChanged(String r1);
    }

    public static /* synthetic */ void $r8$lambda$WoTjr4sbCqNtECb33nGPjU7MTXA(LocationPermissionsHelper r0, String r1) {
        r0.onAppOpsChanged(r1);
    }

    protected abstract boolean hasPermission(String r1, CallerIdentity r2);

    public LocationPermissionsHelper(AppOpsHelper appOps) {
        this.mListeners = new CopyOnWriteArrayList();
        this.mAppOps = appOps;
        this.mAppOps.addListener(new LocationPermissionsHelper$$ExternalSyntheticLambda0(this));
    }

    protected final void notifyLocationPermissionsChanged(String packageName) {
        Iterator<LocationPermissionsListener> r0 = this.mListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        LocationPermissionsListener listener = r0.next();
        listener.onLocationPermissionsChanged(packageName);
        goto L4
    }

    protected final void notifyLocationPermissionsChanged(int uid) {
        Iterator<LocationPermissionsListener> r0 = this.mListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        LocationPermissionsListener listener = r0.next();
        listener.onLocationPermissionsChanged(uid);
        goto L4
    }

    private void onAppOpsChanged(String packageName) {
        notifyLocationPermissionsChanged(packageName);
    }

    public final void addListener(LocationPermissionsListener listener) {
        this.mListeners.add(listener);
    }

    public final void removeListener(LocationPermissionsListener listener) {
        this.mListeners.remove(listener);
    }

    public final boolean hasLocationPermissions(int permissionLevel, CallerIdentity identity) {
        if (permissionLevel != 0) goto L6;
        return false;
    L6:
        if (hasPermission(LocationPermissions.asPermission(permissionLevel), identity) == true) goto L9;
        return false;
    L9:
        return this.mAppOps.checkOpNoThrow(LocationPermissions.asAppOp(permissionLevel), identity);
    }
}
