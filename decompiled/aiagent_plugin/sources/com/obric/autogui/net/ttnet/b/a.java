package com.obric.autogui.net.ttnet.b;

import com.bytedance.common.utility.j;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: compiled from: ConvertIOException.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static int a(Throwable r9, String[] r10) {
        int r0 = 1;
        if (r9 != null) goto L5;
        return 1;
    L5:
        if (r10 != null) goto L8;
        r10 = new String[1];
    L8:
        if (ZeusTransformUtils.instanceOf(r9, com.bytedance.frameworks.baselib.network.http.c.d.class) == false) goto L11;
        r0 = ((com.bytedance.frameworks.baselib.network.http.c.d) ZeusTransformUtils.preCheckCast(r9, com.bytedance.frameworks.baselib.network.http.c.d.class, "com.obric.aiagent.plugin")).a();
    L133:
        if (r0 != 2) goto L66;
        String r11 = r9.getMessage();     // Catch: Exception -> L132
        Loog.INSTANCE.d("ConvertIOException", "SC_CONNECT_TIMEOUT " + r11);     // Catch: Exception -> L132
        Matcher r12 = Pattern.compile("Connect to +([\\w\\.\\-]+)?/(\\[([a-zA-Z0-9:]+)\\]|(\\d{1,3}(\\.\\d{1,3}){3,3})):(\\d+) +timed out").matcher(r11);     // Catch: Exception -> L132
        if (r12.matches() == true) goto L60;
    L65:
        Loog.INSTANCE.d("ConvertIOException", "SC_CONNECT_TIMEOUT ip " + r10[0]);     // Catch: Exception -> L132
        return r0;
    L60:
        if (r12.group(3) == null) goto L63;
        r10[0] = r12.group(3);     // Catch: Exception -> L132
        goto L65
    L63:
        if (r12.group(4) == null) goto L65;
        r10[0] = r12.group(4);     // Catch: Exception -> L132
        goto L65
    L66:
        if (r0 != 8) goto L100;
        Throwable r13 = r9.getCause();     // Catch: Exception -> L132
        if (r13 != null) goto L70;
        return r0;
    L70:
        if (ZeusTransformUtils.instanceOf(r13, ConnectException.class) == false) goto L135;
        String r14 = r13.getMessage();     // Catch: Exception -> L132
        Loog.INSTANCE.d("ConvertIOException", "SC_CONNECT_EXCEPTION " + r14);     // Catch: Exception -> L132
        Matcher r15 = Pattern.compile("failed to connect to +([\\w\\.\\-]+)?/(\\[([a-zA-Z0-9:]+)\\]|(\\d{1,3}(\\.\\d{1,3}){3,3})) \\(port \\d+\\)( +after \\d+ms)?: +\\w+ failed: (E[A-Z]+) .*").matcher(r14);     // Catch: Exception -> L132
        String r3 = null;
        if (r15.matches() == true) goto L74;
    L99:
        Loog.INSTANCE.d("ConvertIOException", "SC_CONNECT_EXCEPTION ip " + r10[0] + " " + r3);     // Catch: Exception -> L132
        return r0;
    L74:
        if (r15.group(3) == null) goto L77;
        r10[0] = r15.group(3);     // Catch: Exception -> L132
    L79:
        r3 = r15.group(7);     // Catch: Exception -> L132
        if (r3 == null) goto L99;
        if ("ECONNRESET".equals(r3) == false) goto L85;
        r0 = 12;
        goto L99
    L85:
        if ("ECONNREFUSED".equals(r3) == false) goto L88;
        r0 = 13;
        goto L99
    L88:
        if ("EHOSTUNREACH".equals(r3) == false) goto L91;
        r0 = 14;
        goto L99
    L91:
        if ("ENETUNREACH".equals(r3) == false) goto L94;
        r0 = 15;
        goto L99
    L94:
        if ("EADDRNOTAVAIL".equals(r3) == false) goto L97;
        r0 = 16;
        goto L99
    L97:
        if ("EADDRINUSE".equals(r3) == false) goto L99;
        r0 = 17;
        goto L99
    L77:
        if (r15.group(4) == null) goto L79;
        r10[0] = r15.group(4);     // Catch: Exception -> L132
        goto L79
    L135:
        return r0;
    L100:
        if (r0 != 4) goto L137;
        String r16 = r9.getMessage();     // Catch: Exception -> L132
        if (r16.indexOf(" EIO (I/O error)") <= 0) goto L106;
        int r17 = 37;
    L138:
        return r17;
    L106:
        if (ZeusTransformUtils.instanceOf(r9, FileNotFoundException.class) == false) goto L109;
    L139:
        return 33;
    L109:
        if (r16.indexOf(" ENOENT ") > 0) goto L139;
        if (r16.indexOf("No such file or directory") > 0) goto L139;
        if (r16.indexOf(" ENOSPC ") <= 0) goto L116;
    L130:
        r17 = 32;
        goto L138
    L116:
        if (r16.indexOf("No space left on device") > 0) goto L130;
        if (r16.indexOf(" EDQUOT ") <= 0) goto L122;
        r17 = 34;
        goto L138
    L122:
        if (r16.indexOf(" EROFS ") <= 0) goto L125;
        r17 = 35;
        goto L138
    L125:
        if (r16.indexOf(" EACCES ") <= 0) goto L128;
        r17 = 36;
        goto L138
    L128:
        if (r16.indexOf("ERR_TTNET_REQUEST_TIMED_OUT") <= 0) goto L140;
        r17 = 38;
        goto L138
    L140:
        return r0;
    L137:
        return r0;
    L141:
        return r0;
    L11:
        if (ZeusTransformUtils.instanceOf(r9, com.bytedance.frameworks.baselib.network.http.i.d.class) == false) goto L14;
        r0 = 20;
        goto L133
    L14:
        if (ZeusTransformUtils.instanceOf(r9, ConnectTimeoutException.class) == false) goto L17;
    L15:
        r0 = 2;
        goto L133
    L17:
        if (ZeusTransformUtils.instanceOf(r9, SocketTimeoutException.class) == false) goto L25;
        if (j.a(r9.getMessage()) == false) goto L21;
    L23:
        r0 = 3;
        goto L133
    L21:
        if (r9.getMessage().contains("connect timed out") == false) goto L23;
    L25:
        if (ZeusTransformUtils.instanceOf(r9, BindException.class) == false) goto L28;
        r0 = 7;
        goto L133
    L28:
        if (ZeusTransformUtils.instanceOf(r9, ConnectException.class) == false) goto L31;
        r0 = 8;
        goto L133
    L31:
        if (ZeusTransformUtils.instanceOf(r9, NoRouteToHostException.class) == false) goto L34;
        r0 = 9;
        goto L133
    L34:
        if (ZeusTransformUtils.instanceOf(r9, PortUnreachableException.class) == false) goto L37;
        r0 = 10;
        goto L133
    L37:
        if (ZeusTransformUtils.instanceOf(r9, SocketException.class) == false) goto L44;
        r0 = 5;
        String r1 = r9.getMessage();
        if (r1 == null) goto L133;
        if (r1.indexOf("reset by peer") < 0) goto L133;
        r0 = 6;
        goto L133
    L44:
        if (ZeusTransformUtils.instanceOf(r9, UnknownHostException.class) == false) goto L47;
        r0 = 11;
        goto L133
    L47:
        if (ZeusTransformUtils.instanceOf(r9, com.bytedance.frameworks.baselib.network.http.c.f.class) == false) goto L50;
        r0 = 18;
        goto L133
    L50:
        if (ZeusTransformUtils.instanceOf(r9, com.bytedance.frameworks.baselib.network.http.c.b.class) == false) goto L53;
        r0 = 19;
        goto L133
    L53:
        if (ZeusTransformUtils.instanceOf(r9, IOException.class) == false) goto L133;
        r0 = 4;
        goto L133
    }
}
