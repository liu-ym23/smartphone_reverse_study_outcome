package com.obric.aiagent.ttnet.b;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.j;
import com.bytedance.frameworks.baselib.network.http.c.f;
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
public final class d {
    public static int a(Throwable r8, String[] r9) {
        int r0 = 1;
        if (r8 != null) goto L5;
        return 1;
    L5:
        if (r9 != null) goto L8;
        r9 = new String[1];
    L8:
        if (ZeusTransformUtils.instanceOf(r8, com.bytedance.frameworks.baselib.network.http.c.d.class) == false) goto L11;
        r0 = ((com.bytedance.frameworks.baselib.network.http.c.d) ZeusTransformUtils.preCheckCast(r8, com.bytedance.frameworks.baselib.network.http.c.d.class, "com.obric.aiagent.plugin")).a();
    L144:
        if (r0 != 2) goto L71;
        String r10 = r8.getMessage();     // Catch: Exception -> L143
        if (Logger.debug() == false) goto L60;
        Logger.d("ConvertIOException", "SC_CONNECT_TIMEOUT " + r10);     // Catch: Exception -> L143
    L60:
        Matcher r11 = Pattern.compile("Connect to +([\\w\\.\\-]+)?/(\\[([a-zA-Z0-9:]+)\\]|(\\d{1,3}(\\.\\d{1,3}){3,3})):(\\d+) +timed out").matcher(r10);     // Catch: Exception -> L143
        if (r11.matches() == false) goto L69;
        if (r11.group(3) == null) goto L66;
        r9[0] = r11.group(3);     // Catch: Exception -> L143
        goto L69
    L66:
        if (r11.group(4) == null) goto L69;
        r9[0] = r11.group(4);     // Catch: Exception -> L143
    L69:
        if (Logger.debug() == false) goto L142;
        Logger.d("ConvertIOException", "SC_CONNECT_TIMEOUT ip " + r9[0]);     // Catch: Exception -> L143
        return r0;
    L142:
        return r0;
    L71:
        if (r0 != 8) goto L111;
        Throwable r12 = r8.getCause();     // Catch: Exception -> L143
        if (r12 != null) goto L75;
        return r0;
    L75:
        if (ZeusTransformUtils.instanceOf(r12, ConnectException.class) == false) goto L147;
        String r13 = r12.getMessage();     // Catch: Exception -> L143
        if (Logger.debug() == false) goto L79;
        Logger.d("ConvertIOException", "SC_CONNECT_EXCEPTION " + r13);     // Catch: Exception -> L143
    L79:
        Matcher r14 = Pattern.compile("failed to connect to +([\\w\\.\\-]+)?/(\\[([a-zA-Z0-9:]+)\\]|(\\d{1,3}(\\.\\d{1,3}){3,3})) \\(port \\d+\\)( +after \\d+ms)?: +\\w+ failed: (E[A-Z]+) .*").matcher(r13);     // Catch: Exception -> L143
        String r3 = null;
        if (r14.matches() == false) goto L109;
        if (r14.group(3) == null) goto L85;
        r9[0] = r14.group(3);     // Catch: Exception -> L143
    L87:
        r3 = r14.group(7);     // Catch: Exception -> L143
        if (r3 == null) goto L109;
        if ("ECONNRESET".equals(r3) == false) goto L94;
        int r15 = 12;
    L92:
        r0 = r15;
        goto L109
    L94:
        if ("ECONNREFUSED".equals(r3) == false) goto L97;
        r15 = 13;
        goto L92
    L97:
        if ("EHOSTUNREACH".equals(r3) == false) goto L100;
        r15 = 14;
        goto L92
    L100:
        if ("ENETUNREACH".equals(r3) == false) goto L103;
        r15 = 15;
        goto L92
    L103:
        if ("EADDRNOTAVAIL".equals(r3) == false) goto L106;
        r15 = 16;
        goto L92
    L106:
        if ("EADDRINUSE".equals(r3) == false) goto L109;
        r15 = 17;
        goto L92
    L85:
        if (r14.group(4) == null) goto L87;
        r9[0] = r14.group(4);     // Catch: Exception -> L143
    L109:
        if (Logger.debug() == false) goto L148;
        Logger.d("ConvertIOException", "SC_CONNECT_EXCEPTION ip " + r9[0] + " " + r3);     // Catch: Exception -> L143
        return r0;
    L148:
        return r0;
    L147:
        return r0;
    L111:
        if (r0 != 4) goto L150;
        String r16 = r8.getMessage();     // Catch: Exception -> L143
        if (r16.indexOf(" EIO (I/O error)") <= 0) goto L117;
        int r17 = 37;
    L151:
        return r17;
    L117:
        if (ZeusTransformUtils.instanceOf(r8, FileNotFoundException.class) == false) goto L120;
    L152:
        return 33;
    L120:
        if (r16.indexOf(" ENOENT ") > 0) goto L152;
        if (r16.indexOf("No such file or directory") > 0) goto L152;
        if (r16.indexOf(" ENOSPC ") <= 0) goto L127;
    L141:
        r17 = 32;
        goto L151
    L127:
        if (r16.indexOf("No space left on device") > 0) goto L141;
        if (r16.indexOf(" EDQUOT ") <= 0) goto L133;
        r17 = 34;
        goto L151
    L133:
        if (r16.indexOf(" EROFS ") <= 0) goto L136;
        r17 = 35;
        goto L151
    L136:
        if (r16.indexOf(" EACCES ") <= 0) goto L139;
        r17 = 36;
        goto L151
    L139:
        if (r16.indexOf("ERR_TTNET_REQUEST_TIMED_OUT") <= 0) goto L153;
        r17 = 38;
        goto L151
    L153:
        return r0;
    L150:
        return r0;
    L154:
        return r0;
    L11:
        if (ZeusTransformUtils.instanceOf(r8, com.bytedance.frameworks.baselib.network.http.i.d.class) == false) goto L14;
        r0 = 20;
        goto L144
    L14:
        if (ZeusTransformUtils.instanceOf(r8, ConnectTimeoutException.class) == false) goto L17;
    L15:
        r0 = 2;
        goto L144
    L17:
        if (ZeusTransformUtils.instanceOf(r8, SocketTimeoutException.class) == false) goto L25;
        if (j.a(r8.getMessage()) == false) goto L21;
    L23:
        r0 = 3;
        goto L144
    L21:
        if (r8.getMessage().contains("connect timed out") == false) goto L23;
    L25:
        if (ZeusTransformUtils.instanceOf(r8, BindException.class) == false) goto L28;
        r0 = 7;
        goto L144
    L28:
        if (ZeusTransformUtils.instanceOf(r8, ConnectException.class) == false) goto L31;
        r0 = 8;
        goto L144
    L31:
        if (ZeusTransformUtils.instanceOf(r8, NoRouteToHostException.class) == false) goto L34;
        r0 = 9;
        goto L144
    L34:
        if (ZeusTransformUtils.instanceOf(r8, PortUnreachableException.class) == false) goto L37;
        r0 = 10;
        goto L144
    L37:
        if (ZeusTransformUtils.instanceOf(r8, SocketException.class) == false) goto L44;
        r0 = 5;
        String r1 = r8.getMessage();
        if (r1 == null) goto L144;
        if (r1.indexOf("reset by peer") < 0) goto L144;
        r0 = 6;
        goto L144
    L44:
        if (ZeusTransformUtils.instanceOf(r8, UnknownHostException.class) == false) goto L47;
        r0 = 11;
        goto L144
    L47:
        if (ZeusTransformUtils.instanceOf(r8, f.class) == false) goto L50;
        r0 = 18;
        goto L144
    L50:
        if (ZeusTransformUtils.instanceOf(r8, com.bytedance.frameworks.baselib.network.http.c.b.class) == false) goto L53;
        r0 = 19;
        goto L144
    L53:
        if (ZeusTransformUtils.instanceOf(r8, IOException.class) == false) goto L144;
        r0 = 4;
        goto L144
    }
}
