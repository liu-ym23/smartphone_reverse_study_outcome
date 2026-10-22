package com.ttnet.org.chromium.base.compat;

import android.content.pm.PackageInfo;
import android.net.LinkProperties;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;

/* JADX INFO: compiled from: ApiHelperForP.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d {
    public static boolean a(LinkProperties r0) {
        return r0.isPrivateDnsActive();
    }

    public static String b(LinkProperties r0) {
        return r0.getPrivateDnsServerName();
    }

    public static long a(PackageInfo r2) {
        return r2.getLongVersionCode();
    }

    public static SignalStrength a(TelephonyManager r0) {
        return r0.getSignalStrength();
    }
}
