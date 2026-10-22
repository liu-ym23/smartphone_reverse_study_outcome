package m5;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    static {
    }

    public static String a(Context r10) {
        ConnectivityManager r11 = (ConnectivityManager) r10.getSystemService("connectivity");     // Catch: Exception -> L6
        LinkProperties r12 = r11.getLinkProperties(r11.getActiveNetwork());     // Catch: Exception -> L6
        if (r12 != null) goto L8;
        return "EmptyLp";
    L8:
        Class<?> r13 = Class.forName("android.net.LinkProperties");     // Catch: Exception -> L6
        Method r14 = r13.getDeclaredMethod("hasIpv4Address", null);     // Catch: Exception -> L6
        Method r15 = r13.getDeclaredMethod("hasIpv4DefaultRoute", null);     // Catch: Exception -> L6
        Method r16 = r13.getDeclaredMethod("hasGlobalIpv6Address", null);     // Catch: Exception -> L6
        Method r17 = r13.getDeclaredMethod("hasIpv6DefaultRoute", null);     // Catch: Exception -> L6
        boolean r18 = true;
        r14.setAccessible(true);     // Catch: Exception -> L6
        r15.setAccessible(true);     // Catch: Exception -> L6
        r16.setAccessible(true);     // Catch: Exception -> L6
        r17.setAccessible(true);     // Catch: Exception -> L6
        if (((Boolean) r14.invoke(r12, null)).booleanValue() == true) goto L11;
    L13:
        boolean r19 = false;
    L15:
        if (((Boolean) r16.invoke(r12, null)).booleanValue() == false) goto L19;
        if (((Boolean) r17.invoke(r12, null)).booleanValue() == false) goto L19;
    L20:
        if (r19 == false) goto L24;
        if (r18 == false) goto L24;
        return "Ipv4Ipv6";
    L24:
        if (r19 == false) goto L28;
        if (r18 == true) goto L28;
        return "Ipv4Only";
    L28:
        if (r19 == true) goto L32;
        if (r18 == false) goto L38;
        return "Ipv6Only";
    L38:
        return "NoV4V6";
    L32:
        return "NoV4V6";
    L19:
        r18 = false;
        goto L20
    L11:
        if (((Boolean) r15.invoke(r12, null)).booleanValue() == false) goto L13;
        r19 = true;
    L6:
        e = move-exception;
        e.printStackTrace();
        return "UNKNOWN";
    }
}
