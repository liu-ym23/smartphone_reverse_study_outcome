package com.stepos.pps.common;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.IPackageDeleteObserver;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.pps.R;
import com.stepos.pps.reflect.ExceptionManagerStepOS;
import com.stepos.pps.reflect.NotificationStepOS;
import com.stepos.pps.reflect.SystemProperties;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class Utils {
    private static final String CHANNEL_ID = "003";
    private static String KEY_PPS_UPDATE_PROP = "persist.sys.pps_update";
    private static String TAG = "Utils";

    public static boolean isSetupWizardPrivacyConfirmed(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), "device_provisioned", 0) == 1;
    }

    private static void makeUninstallNotification(Context context) throws IllegalAccessException, IllegalArgumentException {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, context.getString(R.string.uninstall_pps), 3);
        Notification.Builder builder = new Notification.Builder(context);
        builder.setAutoCancel(true);
        builder.setShowWhen(true);
        Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
        bigTextStyle.bigText(context.getResources().getString(R.string.uninstall_pps_detail));
        bigTextStyle.setBigContentTitle(context.getResources().getString(R.string.uninstall_pps));
        builder.setStyle(bigTextStyle);
        builder.setContentIntent(buildSettingsPendingIntent(context));
        builder.setSmallIcon(R.mipmap.onemind);
        builder.setOngoing(true);
        builder.setAutoCancel(false);
        builder.setChannelId(CHANNEL_ID);
        Notification notificationBuild = builder.build();
        notificationBuild.flags |= 2;
        NotificationStepOS.setStepOSNotificationIcon(notificationBuild, R.drawable.high_performance_notificaion_icon);
        notificationManager.cancel(R.string.high_performance_notify_title);
        notificationManager.createNotificationChannel(notificationChannel);
        notificationManager.notify(R.string.high_performance_notify_title, notificationBuild);
    }

    private static PendingIntent buildSettingsPendingIntent(Context context) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts(ExceptionManagerStepOS.PACKAGE, context.getPackageName(), null));
        return PendingIntent.getActivity(context, 0, intent, 201326592);
    }

    private static boolean uninstallApk(Context context, String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            context.getClassLoader().loadClass("android.content.pm.PackageManager").getDeclaredMethod("deletePackage", String.class, IPackageDeleteObserver.class, Integer.TYPE).invoke(context.getPackageManager(), str, null, 2);
            return true;
        } catch (Exception e) {
            Log.e("Utils", "uninstall error!package:" + str);
            e.printStackTrace();
            return false;
        }
    }

    public static void checkAndSendUninstallNotification(Context context) throws IllegalAccessException, IllegalArgumentException {
        String[] strArrSplit;
        String str = SystemProperties.get("ro.build.inside.id");
        if (str == null) {
            Log.e(TAG, "get fireware date error!");
            return;
        }
        String str2 = SystemProperties.get("ro.build.stepos.version");
        if (TextUtils.isEmpty(str2)) {
            Log.e(TAG, "stepos verison is empty!");
            return;
        }
        int i = Integer.parseInt(str2);
        Integer numValueOf = Integer.valueOf(i);
        String[] strArrSplit2 = str.split("-");
        if (strArrSplit2 == null || strArrSplit2.length <= 1 || (strArrSplit = strArrSplit2[1].split("_")) == null || strArrSplit.length <= 0) {
            return;
        }
        Date date = getDate(strArrSplit[0]);
        Date date2 = getDate("20220601175846");
        if (date == null || date2 == null) {
            Log.e(TAG, "date:" + date + ",datelevel:" + date2 + ",is null!");
            return;
        }
        if (date2.getTime() - date.getTime() <= 0) {
            if (!isBlack()) {
                return;
            }
            numValueOf.getClass();
            if (i > 9) {
                return;
            }
        }
        Log.e(TAG, "DeletePackage and uninstall pps apk for old models");
        if (uninstallApk(context, context.getPackageName())) {
            return;
        }
        makeUninstallNotification(context);
    }

    private static Date getDate(String str) {
        try {
            return new SimpleDateFormat("yyMMddHHmmss").parse(str);
        } catch (Exception e) {
            Log.e(TAG, "get date error!");
            e.printStackTrace();
            return null;
        }
    }

    private static boolean isBlack() {
        String str = SystemProperties.get("ro.product.stepos.model");
        String str2 = SystemProperties.get(KEY_PPS_UPDATE_PROP);
        Log.d(TAG, "model:" + str + ",update_prop:" + str2);
        return TextUtils.equals(str, "M2081") || TextUtils.equals(str, "M2091") || TextUtils.equals(str, "M1971") || TextUtils.equals(str, "M1973") || TextUtils.equals(str, "M1928") || TextUtils.equals(str, "M1892") || TextUtils.equals(str, "M1882") || TextUtils.equals(str, "M1872");
    }
}
