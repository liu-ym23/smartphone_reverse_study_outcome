package com.stepos.policy.sdk.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class PolicySdkNetworkUtil {
    private static final String KEY_OF_NET_TYPE = "net_type";
    private static final String KEY_OF_TARGET_PACKAGE = "target_package";
    private static final int NET_STATUS_OFF = 2;
    private static final int NET_STATUS_ON = 1;
    private static final int NET_TYPE_ALL = 3;
    private static final String VALUE_OF_TARGET_PACKAGE = "target_value";
    private static final String VALUE_OF_TARGET_PACKAGE_QUERY = "query_result";
    Handler mHandle = new Handler(Looper.getMainLooper());

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) ? false : true;
    }
}
