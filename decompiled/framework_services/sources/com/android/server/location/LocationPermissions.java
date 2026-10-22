package com.android.server.location;

import android.content.Context;
import android.os.Binder;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
public final class LocationPermissions {
    public static final int PERMISSION_COARSE = 1;
    public static final int PERMISSION_FINE = 2;
    public static final int PERMISSION_NONE = 0;

    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface PermissionLevel {
    }

    public static String asPermission(int permissionLevel) {
        switch(permissionLevel) {
            case 1: goto L7;
            case 2: goto L5;
            default: goto L4;
        };
    L5:
        return "android.permission.ACCESS_FINE_LOCATION";
    L7:
        return "android.permission.ACCESS_COARSE_LOCATION";
    L4:
        throw new IllegalArgumentException();
    }

    public static int asAppOp(int permissionLevel) {
        switch(permissionLevel) {
            case 1: goto L7;
            case 2: goto L5;
            default: goto L4;
        };
    L5:
        return 1;
    L7:
        return 0;
    L4:
        throw new IllegalArgumentException();
    }

    public static void enforceCallingOrSelfLocationPermission(Context context, int requiredPermissionLevel) {
        enforceLocationPermission(Binder.getCallingUid(), getPermissionLevel(context, Binder.getCallingUid(), Binder.getCallingPid()), requiredPermissionLevel);
    }

    public static void enforceLocationPermission(Context context, int uid, int pid, int requiredPermissionLevel) {
        enforceLocationPermission(uid, getPermissionLevel(context, uid, pid), requiredPermissionLevel);
    }

    public static void enforceLocationPermission(int uid, int permissionLevel, int requiredPermissionLevel) {
        if (checkLocationPermission(permissionLevel, requiredPermissionLevel) == false) goto L6;
        return;
    L6:
        if (requiredPermissionLevel == 1) goto L13;
        if (requiredPermissionLevel == 2) goto L11;
        return;
    L11:
        throw new SecurityException("uid " + uid + " does not have android.permission.ACCESS_FINE_LOCATION.");
    L13:
        throw new SecurityException("uid " + uid + " does not have android.permission.ACCESS_COARSE_LOCATION or android.permission.ACCESS_FINE_LOCATION.");
    }

    public static void enforceCallingOrSelfBypassPermission(Context context) {
        enforceBypassPermission(context, Binder.getCallingUid(), Binder.getCallingPid());
    }

    public static void enforceBypassPermission(Context context, int uid, int pid) {
        if (context.checkPermission("android.permission.LOCATION_BYPASS", pid, uid) != 0) goto L6;
        return;
    L6:
        throw new SecurityException("uid" + uid + " does not have android.permission.LOCATION_BYPASS.");
    }

    public static boolean checkCallingOrSelfLocationPermission(Context context, int requiredPermissionLevel) {
        return checkLocationPermission(getCallingOrSelfPermissionLevel(context), requiredPermissionLevel);
    }

    public static boolean checkLocationPermission(Context context, int uid, int pid, int requiredPermissionLevel) {
        return checkLocationPermission(getPermissionLevel(context, uid, pid), requiredPermissionLevel);
    }

    public static boolean checkLocationPermission(int permissionLevel, int requiredPermissionLevel) {
        if (permissionLevel < requiredPermissionLevel) goto L4;
        return true;
    L4:
        return false;
    }

    public static int getCallingOrSelfPermissionLevel(Context context) {
        return getPermissionLevel(context, Binder.getCallingUid(), Binder.getCallingPid());
    }

    public static int getPermissionLevel(Context context, int uid, int pid) {
        if (context.checkPermission("android.permission.ACCESS_FINE_LOCATION", pid, uid) != 0) goto L7;
        return 2;
    L7:
        if (context.checkPermission("android.permission.ACCESS_COARSE_LOCATION", pid, uid) != 0) goto L10;
        return 1;
    L10:
        return 0;
    }

    private LocationPermissions() {
    }
}
