package bytekn.foundation.utils;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes28.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f21809a = 0;

    static {
    }

    public static String a(String r100) {
        InetAddress r101 = InetAddress.getByName(new URL(r100).getHost());     // Catch: MalformedURLException -> L9 UnknownHostException -> L11
        if (r101 == null) goto L7;
        String r102 = r101.getHostAddress();     // Catch: MalformedURLException -> L9 UnknownHostException -> L11
        if (r102 == null) goto L7;
        return r102;
    L7:
        return "";
    L9:
        e = move-exception;
        e.printStackTrace();
        return null;
    L11:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
