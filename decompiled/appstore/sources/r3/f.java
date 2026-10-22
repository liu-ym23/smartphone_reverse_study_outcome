package r3;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import androidx.core.content.ContextCompat;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {
    public static int a(Context r10) {
        ConnectivityManager r11 = (ConnectivityManager) r10.getSystemService("connectivity");     // Catch: Throwable -> L16
        if (ContextCompat.a(r10, "android.permission.ACCESS_NETWORK_STATE") != 0) goto L6;
        NetworkInfo r12 = r11.getActiveNetworkInfo();     // Catch: Throwable -> L16
    L7:
        if (r12 == null) goto L15;
        if (r12.isAvailable() == false) goto L15;
        if (r12.getType() != 0) goto L15;
        return ((TelephonyManager) r10.getSystemService("phone")).getNetworkType();
    L6:
        r12 = null;
    L15:
        return -10000;
    }
}
