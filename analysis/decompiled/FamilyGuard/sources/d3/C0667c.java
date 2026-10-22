package d3;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import g3.C0742e;

/* renamed from: d3.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0667c {
    public static String a(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        } catch (Exception e6) {
            C0742e.l("NetInfoUtils", "getNetworkType exception: " + e6 + " - Cause: " + e6.getCause());
        }
        if (activeNetworkInfo == null) {
            return "unknown";
        }
        if (!activeNetworkInfo.isAvailable()) {
            return "off";
        }
        int type = activeNetworkInfo.getType();
        if (type == 1) {
            return "wifi";
        }
        if (type == 9) {
            return "ethernet";
        }
        int iB = b(context);
        if (iB == -1 && type == 0) {
            iB = activeNetworkInfo.getSubtype();
        }
        if (iB == 18) {
            return "4g";
        }
        if (iB == 20) {
            return "5g";
        }
        switch (iB) {
            case 1:
            case 2:
            case 4:
            case 7:
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT /* 11 */:
                return "2g";
            case 3:
            case 5:
            case 6:
            case 8:
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER /* 12 */:
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER_WITH_ARROW /* 14 */:
            case 15:
                return "3g";
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT_WITH_ARROW /* 13 */:
                return "4g";
            default:
                return "unknown";
        }
    }

    private static int b(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
        } catch (Exception e6) {
            C0742e.l("NetInfoUtils", "getTelephonyNetworkType exception: " + e6.getMessage());
            return -1;
        }
    }

    public static boolean c(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            boolean z5 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
            C0742e.c("NetInfoUtils", "isOnline:" + z5);
            return z5;
        } catch (SecurityException e6) {
            C0742e.d("NetInfoUtils", "Security exception:" + e6.toString());
            return true;
        }
    }
}
