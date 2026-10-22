package f9;

import com.bytedance.frameworks.baselib.network.http.exception.ClientProtocolException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NoHttpResponseException;
import com.bytedance.frameworks.baselib.network.http.util.DownloadFileTooLargeException;
import com.bytedanceos.common.toolbox.i;
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

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {
    public static int a(Throwable r10, String[] r11) {
        int r12 = 1;
        if (r10 != null) goto L5;
        return 1;
    L5:
        if (r11 != null) goto L8;
        r11 = new String[1];
    L8:
        if ((r10 instanceof HttpResponseException) == false) goto L11;
        r12 = ((HttpResponseException) r10).getStatusCode();
    L134:
        if (r12 != 2) goto L67;
        String r13 = r10.getMessage();     // Catch: Exception -> L133
        i.a("ConvertIOException", "SC_CONNECT_TIMEOUT " + r13);     // Catch: Exception -> L133
        Matcher r14 = Pattern.compile("Connect to +([\\w\\.\\-]+)?/(\\[([a-zA-Z0-9:]+)\\]|(\\d{1,3}(\\.\\d{1,3}){3,3})):(\\d+) +timed out").matcher(r13);     // Catch: Exception -> L133
        if (r14.matches() == true) goto L61;
    L66:
        i.a("ConvertIOException", "SC_CONNECT_TIMEOUT ip " + r11[0]);     // Catch: Exception -> L133
        return r12;
    L61:
        if (r14.group(3) == null) goto L64;
        r11[0] = r14.group(3);     // Catch: Exception -> L133
        goto L66
    L64:
        if (r14.group(4) == null) goto L66;
        r11[0] = r14.group(4);     // Catch: Exception -> L133
        goto L66
    L67:
        if (r12 != 8) goto L102;
        Throwable r15 = r10.getCause();     // Catch: Exception -> L133
        if (r15 != null) goto L71;
        return r12;
    L71:
        if ((r15 instanceof ConnectException) == false) goto L137;
        String r16 = r15.getMessage();     // Catch: Exception -> L133
        i.a("ConvertIOException", "SC_CONNECT_EXCEPTION " + r16);     // Catch: Exception -> L133
        Matcher r17 = Pattern.compile("failed to connect to +([\\w\\.\\-]+)?/(\\[([a-zA-Z0-9:]+)\\]|(\\d{1,3}(\\.\\d{1,3}){3,3})) \\(port \\d+\\)( +after \\d+ms)?: +\\w+ failed: (E[A-Z]+) .*").matcher(r16);     // Catch: Exception -> L133
        if (r17.matches() == true) goto L75;
        String r18 = null;
    L101:
        i.a("ConvertIOException", "SC_CONNECT_EXCEPTION ip " + r11[0] + " " + r18);     // Catch: Exception -> L133
        return r12;
    L75:
        if (r17.group(3) == null) goto L78;
        r11[0] = r17.group(3);     // Catch: Exception -> L133
    L80:
        r18 = r17.group(7);     // Catch: Exception -> L133
        if (r18 == null) goto L101;
        if ("ECONNRESET".equals(r18) == false) goto L86;
        r12 = 12;
        goto L101
    L86:
        if ("ECONNREFUSED".equals(r18) == false) goto L89;
        r12 = 13;
        goto L101
    L89:
        if ("EHOSTUNREACH".equals(r18) == false) goto L92;
        r12 = 14;
        goto L101
    L92:
        if ("ENETUNREACH".equals(r18) == false) goto L95;
        r12 = 15;
        goto L101
    L95:
        if ("EADDRNOTAVAIL".equals(r18) == false) goto L98;
        r12 = 16;
        goto L101
    L98:
        if ("EADDRINUSE".equals(r18) == false) goto L101;
        r12 = 17;
        goto L101
    L78:
        if (r17.group(4) == null) goto L80;
        r11[0] = r17.group(4);     // Catch: Exception -> L133
        goto L80
    L137:
        return r12;
    L102:
        if (r12 != 4) goto L139;
        String r19 = r10.getMessage();     // Catch: Exception -> L133
        if (r19.indexOf(" EIO (I/O error)") <= 0) goto L107;
        return 37;
    L107:
        if ((r10 instanceof FileNotFoundException) == false) goto L110;
    L141:
        return 33;
    L110:
        if (r19.indexOf(" ENOENT ") > 0) goto L141;
        if (r19.indexOf("No such file or directory") > 0) goto L141;
        if (r19.indexOf(" ENOSPC ") <= 0) goto L117;
    L131:
        return 32;
    L117:
        if (r19.indexOf("No space left on device") > 0) goto L131;
        if (r19.indexOf(" EDQUOT ") <= 0) goto L123;
        return 34;
    L123:
        if (r19.indexOf(" EROFS ") <= 0) goto L126;
        return 35;
    L126:
        if (r19.indexOf(" EACCES ") <= 0) goto L129;
        return 36;
    L129:
        if (r19.indexOf("ERR_TTNET_REQUEST_TIMED_OUT") <= 0) goto L145;
        return 38;
    L145:
        return r12;
    L139:
        return r12;
    L147:
        return r12;
    L11:
        if ((r10 instanceof DownloadFileTooLargeException) == false) goto L14;
        r12 = 20;
        goto L134
    L14:
        if ((r10 instanceof ConnectTimeoutException) == false) goto L17;
    L15:
        r12 = 2;
        goto L134
    L17:
        if ((r10 instanceof SocketTimeoutException) == false) goto L25;
        if (com.bytedance.common.utility.e.b(r10.getMessage()) == false) goto L21;
    L23:
        r12 = 3;
        goto L134
    L21:
        if (r10.getMessage().contains("connect timed out") == false) goto L23;
    L25:
        if ((r10 instanceof BindException) == false) goto L28;
        r12 = 7;
        goto L134
    L28:
        if ((r10 instanceof ConnectException) == false) goto L31;
        r12 = 8;
        goto L134
    L31:
        if ((r10 instanceof NoRouteToHostException) == false) goto L34;
        r12 = 9;
        goto L134
    L34:
        if ((r10 instanceof PortUnreachableException) == false) goto L37;
        r12 = 10;
        goto L134
    L37:
        if ((r10 instanceof SocketException) == false) goto L45;
        String r20 = r10.getMessage();
        if (r20 != null) goto L41;
    L43:
        r12 = 5;
        goto L134
    L41:
        if (r20.indexOf("reset by peer") < 0) goto L43;
        r12 = 6;
        goto L134
    L45:
        if ((r10 instanceof UnknownHostException) == false) goto L48;
        r12 = 11;
        goto L134
    L48:
        if ((r10 instanceof NoHttpResponseException) == false) goto L51;
        r12 = 18;
        goto L134
    L51:
        if ((r10 instanceof ClientProtocolException) == false) goto L54;
        r12 = 19;
        goto L134
    L54:
        if ((r10 instanceof IOException) == false) goto L134;
        r12 = 4;
        goto L134
    }
}
