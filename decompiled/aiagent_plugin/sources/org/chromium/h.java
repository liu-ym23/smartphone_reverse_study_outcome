package org.chromium;

import com.ttnet.org.chromium.net.impl.NetworkExceptionImpl;
import com.ttnet.org.chromium.net.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: classes5.dex */
public class h {
    public static List a(Class r7) {
        if (r7 != null) goto L5;
        return null;
    L5:
        ArrayList r0 = new ArrayList();
    L6:
        if (r7 == null) goto L21;
        Class<?>[] r1 = r7.getInterfaces();
        int r2 = 0;
    L9:
        if (r2 >= r1.length) goto L20;
        if (r0.contains(r1[r2]) == true) goto L13;
        r0.add(r1[r2]);
    L13:
        Iterator r3 = a(r1[r2]).iterator();
    L15:
        if (r3.hasNext() == false) goto L19;
        Class r4 = (Class) ZeusTransformUtils.preCheckCast(r3.next(), Class.class, "com.obric.aiagent.plugin");
        if (r0.contains(r4) == true) goto L15;
        r0.add(r4);
        goto L15
    L19:
        r2 = r2 + 1;
        goto L9
    L20:
        r7 = r7.getSuperclass();
        goto L6
    L21:
        return r0;
    }

    public static int a(int r3) {
        switch(r3) {
            case 1: goto L26;
            case 2: goto L24;
            case 3: goto L22;
            case 4: goto L20;
            case 5: goto L18;
            case 6: goto L16;
            case 7: goto L14;
            case 8: goto L12;
            case 9: goto L10;
            case 10: goto L8;
            case 11: goto L6;
            default: goto L4;
        };
    L6:
        return 11;
    L8:
        return 10;
    L10:
        return 9;
    L12:
        return 8;
    L14:
        return 7;
    L16:
        return 6;
    L18:
        return 5;
    L20:
        return 4;
    L22:
        return 3;
    L24:
        return 2;
    L26:
        return 1;
    L4:
        if (d.a().loggerDebug() == false) goto L28;
        d.a().loggerD("monitor", "Unknown error code: " + r3);
        return r3;
    L28:
        return r3;
    }

    public static com.ttnet.org.chromium.net.e a(int r3, int r4, String r5) {
        return new NetworkExceptionImpl("Exception in CronetUrlRequest: " + r5, a(r3), r4);
    }

    public static IOException a(com.ttnet.org.chromium.net.e r3) {
        if (ZeusTransformUtils.instanceOf(r3, o.class) == true) goto L6;
        return r3;
    L6:
        switch(((o) ZeusTransformUtils.preCheckCast(r3, o.class, "com.obric.aiagent.plugin")).getErrorCode()) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L11;
            case 8: goto L9;
            case 9: goto L8;
            default: goto L17;
        };
    L8:
        IOException r0 = new NoRouteToHostException(r3.getMessage());
    L16:
        return r0;
    L9:
        r0 = new SocketException("reset by peer " + r3.getMessage());
        goto L16
    L10:
        r0 = new ConnectTimeoutException(r3.getMessage());
        goto L16
    L11:
        r0 = new ConnectException(r3.getMessage());
        goto L16
    L12:
        r0 = new SocketTimeoutException(r3.getMessage());
        goto L16
    L13:
        r0 = new ConnectException(r3.getMessage());
        goto L16
    L14:
        r0 = new UnknownHostException(r3.getMessage());
        goto L16
    L17:
        return r3;
    }
}
