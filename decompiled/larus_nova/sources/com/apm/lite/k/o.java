package com.apm.lite.k;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;

/* JADX INFO: loaded from: classes39.dex */
public final class o {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f30015a = null;

        static {
            int[] r100 = new int[com.apm.lite.j.e.b.values().length];
            f30015a = r100;
            r100[com.apm.lite.j.e.b.f29966e.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f30015a[com.apm.lite.j.e.b.f29964c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f30015a[com.apm.lite.j.e.b.f29965d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f30015a[com.apm.lite.j.e.b.f29967f.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f30015a[com.apm.lite.j.e.b.f29963b.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f30015a[com.apm.lite.j.e.b.f29968g.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public static boolean b(Context r100) {
        ConnectivityManager r101 = (ConnectivityManager) r100.getSystemService("connectivity");     // Catch: Exception -> L12
        if (r101 != null) goto L6;
        return false;
    L6:
        NetworkInfo r102 = r101.getActiveNetworkInfo();     // Catch: Exception -> L12
        if (r102 == null) goto L15;
        if (r102.isAvailable() == false) goto L16;
        return true;
    L16:
        return false;
    L15:
        return false;
    L17:
        return false;
    }

    public static String a(Context r100) {
        ConnectivityManager r101 = (ConnectivityManager) r100.getSystemService("connectivity");     // Catch: Throwable -> L29
        if (r101 != null) goto L5;
    L4:
        com.apm.lite.j.e.b r102 = com.apm.lite.j.e.b.f29962a;     // Catch: Throwable -> L29
    L43:
    L46:
        switch(a.f30015a[r102.ordinal()]) {
            case 1: goto L38;
            case 2: goto L52;
            case 3: goto L51;
            case 4: goto L50;
            case 5: goto L49;
            case 6: goto L48;
            default: goto L40;
        };     // Catch: Exception -> L42
    L38:
        return "wifi";
    L48:
        return CJPayBasicUtils.NETWORK_MOBILE;
    L49:
        return "mobile";
    L50:
        return CJPayBasicUtils.NETWORK_4G;
    L51:
        return CJPayBasicUtils.NETWORK_3G;
    L52:
        return CJPayBasicUtils.NETWORK_2G;
    L40:
        return "";
    L5:
        NetworkInfo r103 = r101.getActiveNetworkInfo();     // Catch: Throwable -> L29
        if (r103 == null) goto L4;
        if (r103.isAvailable() == false) goto L4;
        int r104 = r103.getType();     // Catch: Throwable -> L29
        if (1 != r104) goto L13;
        r102 = com.apm.lite.j.e.b.f29966e;     // Catch: Throwable -> L29
        goto L43
    L13:
        if (r104 != 0) goto L24;
        int r105 = ((TelephonyManager) r100.getSystemService("phone")).getNetworkType();     // Catch: Throwable -> L29
        if (r105 != 3) goto L17;
    L27:
        r102 = com.apm.lite.j.e.b.f29965d;     // Catch: Throwable -> L29
        goto L43
    L17:
        if (r105 != 20) goto L19;
        r102 = com.apm.lite.j.e.b.f29968g;     // Catch: Throwable -> L29
        goto L43
    L19:
        if (r105 == 5) goto L27;
        if (r105 == 6) goto L27;
        switch(r105) {
            case 8: goto L27;
            case 9: goto L27;
            case 10: goto L27;
            default: goto L23;
        };     // Catch: Throwable -> L29
    L23:
        switch(r105) {
            case 12: goto L27;
            case 13: goto L25;
            case 14: goto L27;
            case 15: goto L27;
            default: goto L24;
        };     // Catch: Throwable -> L29
    L25:
        r102 = com.apm.lite.j.e.b.f29967f;     // Catch: Throwable -> L29
    L24:
        r102 = com.apm.lite.j.e.b.f29963b;     // Catch: Throwable -> L29
    L29:
        r102 = com.apm.lite.j.e.b.f29963b;
        goto L46
    }
}
