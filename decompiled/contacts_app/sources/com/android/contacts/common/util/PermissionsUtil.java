package com.android.contacts.common.util;

import android.app.AppOpsManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

/* JADX INFO: loaded from: classes.dex */
public class PermissionsUtil {
    public static final String CONTACTS = "android.permission.READ_CONTACTS";
    public static final String LOCATION = "android.permission.ACCESS_FINE_LOCATION";
    public static final String PHONE = "android.permission.CALL_PHONE";

    public PermissionsUtil() {
    }

    public static boolean hasPhonePermissions(Context r1) {
        return hasPermission(r1, PHONE);
    }

    public static boolean hasContactsPermissions(Context r1) {
        return hasPermission(r1, CONTACTS);
    }

    public static boolean hasLocationPermissions(Context r1) {
        return hasPermission(r1, LOCATION);
    }

    public static boolean hasPermission(Context r0, String r1) {
        if (ContextCompat.checkSelfPermission(r0, r1) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean hasAppOp(Context r2, String r3) {
        if (((AppOpsManager) r2.getSystemService("appops")).checkOpNoThrow(r3, Process.myUid(), r2.getPackageName()) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static void registerPermissionReceiver(Context r1, BroadcastReceiver r2, String r3) {
        IntentFilter r0 = new IntentFilter(r3);
        LocalBroadcastManager.getInstance(r1).registerReceiver(r2, r0);
    }

    public static void unregisterPermissionReceiver(Context r0, BroadcastReceiver r1) {
        LocalBroadcastManager.getInstance(r0).unregisterReceiver(r1);
    }

    public static void notifyPermissionGranted(Context r1, String r2) {
        Intent r0 = new Intent(r2);
        LocalBroadcastManager.getInstance(r1).sendBroadcast(r0);
    }
}
