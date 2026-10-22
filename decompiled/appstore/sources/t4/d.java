package t4;

import com.bytedance.common.utility.Logger;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f24725a = "d";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f24726b = "2001:4860:4860::8888";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static AtomicBoolean f24727c;

    static {
        f24727c = new AtomicBoolean(false);
    }

    public static void a() {
        Logger.d(f24725a, "detectIpv6Reachable");
        f24727c.set(c());
    }

    public static AtomicBoolean b() {
        return f24727c;
    }

    public static boolean c() {
        boolean r10 = false;
        DatagramSocket r11 = null;
        DatagramSocket r12 = new DatagramSocket();     // Catch: Throwable -> L14 IOException -> L21
        r12.connect(new InetSocketAddress(f24726b, 53));     // Catch: Throwable -> L10 IOException -> L12
        InetAddress r13 = r12.getLocalAddress();     // Catch: Throwable -> L10 IOException -> L12
        if ((r13 instanceof Inet6Address) == false) goto L13;
        boolean r14 = !r13.isLinkLocalAddress();     // Catch: Throwable -> L10 IOException -> L12
        if (r13.getHostAddress().startsWith("2001:0000") == true) goto L13;
        r10 = r14;
        goto L13
    L13:
        r12.close();
    L20:
        return r10;
    L12:
        r11 = r12;
    L10:
        th = th;
        r11 = r12;
    L15:
        if (r11 == null) goto L17;
        r11.close();
    L17:
        throw th;
    L14:
        th = th;
    L18:
        if (r11 == null) goto L20;
        r11.close();
        goto L20
    }
}
