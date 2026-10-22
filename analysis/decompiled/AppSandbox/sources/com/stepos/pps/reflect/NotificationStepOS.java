package com.stepos.pps.reflect;

import android.app.Notification;
import android.util.Log;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public class NotificationStepOS {
    private static final String TAG = "NotificationStepOS";
    private static Field mField;
    private static Field mFieldExt;
    private static Class<?> mNotification;
    private static Class<?> mNotificationExt;

    public static void setStepOSNotificationIcon(Notification notification, int i) throws IllegalAccessException, IllegalArgumentException {
        try {
            if (mNotification == null) {
                mNotification = Notification.class;
            }
            if (mNotificationExt == null) {
                mNotificationExt = Class.forName("android.app.NotificationExt");
            }
            if (mField == null) {
                mField = mNotification.getDeclaredField("mStepOSNotification");
            }
            if (mFieldExt == null) {
                mFieldExt = mNotificationExt.getDeclaredField("notificationIcon");
            }
            mFieldExt.set(mField.get(notification), Integer.valueOf(i));
        } catch (Exception e) {
            Log.e(TAG, "setStepOSNotificationIcon failed: " + e);
        }
    }
}
