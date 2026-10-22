package android.net.shared;

import android.net.InetAddresses;
import java.net.InetAddress;

/* JADX INFO: loaded from: classes.dex */
public final class IpConfigurationParcelableUtil {
    public IpConfigurationParcelableUtil() {
    }

    public static String parcelAddress(InetAddress addr) {
        if (addr != null) goto L6;
        return null;
    L6:
        return addr.getHostAddress();
    }

    public static InetAddress unparcelAddress(String addr) {
        if (addr != null) goto L6;
        return null;
    L6:
        return InetAddresses.parseNumericAddress(addr);
    }
}
