package com.android.server.notification;

import android.content.Context;
import android.os.SystemProperties;

/* JADX INFO: loaded from: classes2.dex */
public class PropConfig {
    private static final String UNSET = "UNSET";

    public PropConfig() {
    }

    public static int getInt(Context context, String propName, int resId) {
        return SystemProperties.getInt(propName, context.getResources().getInteger(resId));
    }

    public static String[] getStringArray(Context context, String propName, int resId) {
        String prop = SystemProperties.get(propName, UNSET);
        if (UNSET.equals(prop) == true) goto L6;
        return prop.split(",");
    L6:
        return context.getResources().getStringArray(resId);
    }
}
