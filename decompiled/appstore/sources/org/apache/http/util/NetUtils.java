package org.apache.http.util;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/* JADX INFO: loaded from: classes4.dex */
public final class NetUtils {
    public NetUtils() {
    }

    public static void formatAddress(StringBuilder r10, SocketAddress r11) {
        Args.notNull(r10, "Buffer");
        Args.notNull(r11, "Socket address");
        if ((r11 instanceof InetSocketAddress) == false) goto L8;
        InetSocketAddress r12 = (InetSocketAddress) r11;
        InetAddress r13 = r12.getAddress();
        Object r14 = r13;
        if (r13 == null) goto L7;
        r14 = r13.getHostAddress();
    L7:
        r10.append(r14);
        r10.append(':');
        r10.append(r12.getPort());
        return;
    L8:
        r10.append(r11);
    }
}
