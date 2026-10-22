package o0;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static int a(Context r10) {
        NetworkInfo r11 = ((ConnectivityManager) r10.getSystemService("connectivity")).getActiveNetworkInfo();
        if (r11 != null) goto L5;
        return 0;
    L5:
        int r12 = r11.getType();
        if (r12 == 1) goto L27;
        if (r12 != 0) goto L28;
        int r13 = r11.getSubtype();
        TelephonyManager r14 = (TelephonyManager) r10.getSystemService("phone");
        int r15 = 3;
        if (r13 != 13) goto L15;
        if (r14.isNetworkRoaming() == true) goto L15;
    L29:
        return r15;
    L15:
        if (r13 != 3) goto L17;
        return 4;
    L17:
        if (r13 == 8) goto L31;
        r15 = 5;
        if (r13 == 5) goto L21;
    L23:
        if (r13 == 1) goto L29;
        if (r13 == 2) goto L29;
        if (r13 != 4) goto L29;
        r14.isNetworkRoaming();
        goto L29
    L21:
        if (r14.isNetworkRoaming() == true) goto L23;
        return 4;
    L31:
        return 4;
    L28:
        return 0;
    L27:
        return 2;
    }

    public static String b(Context r10) {
        int r11 = a(r10);
        if (r11 != 0) goto L6;
        return "NULL";
    L6:
        if (r11 != 2) goto L10;
        return "WIFI";
    L10:
        if (r11 != 3) goto L14;
        return "4G";
    L14:
        if (r11 != 4) goto L18;
        return "3G";
    L18:
        if (r11 != 5) goto L21;
        return "2G";
    L21:
        return "NULL";
    }
}
