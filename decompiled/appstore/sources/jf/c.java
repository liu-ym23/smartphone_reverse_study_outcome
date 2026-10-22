package jf;

import android.content.pm.PackageInfo;
import android.net.LinkProperties;

/* JADX INFO: loaded from: classes4.dex */
public abstract class c {
    public static long a(PackageInfo r10) {
        return r10.getLongVersionCode();
    }

    public static String b(LinkProperties r10) {
        return r10.getPrivateDnsServerName();
    }

    public static boolean c(LinkProperties r10) {
        return r10.isPrivateDnsActive();
    }
}
