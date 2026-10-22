package r9;

import com.bytedance.common.wschannel.WsConstants;
import com.media.cache.http.Method;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import javax.net.ssl.SSLException;

/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BufferedInputStream f23791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f23792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f23793c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap f23794d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HashMap f23795e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Method f23796f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f23797g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f23798h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f23799i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f23800j;

    public c(InputStream r10, InetAddress r11) {
        this.f23791a = new BufferedInputStream(r10);
        if (r11.isLoopbackAddress() == false) goto L5;
    L8:
        String r12 = "127.0.0.1";
    L9:
        this.f23792b = r12;
        if (r11.isLoopbackAddress() == false) goto L12;
    L15:
        String r13 = "localhost";
    L16:
        this.f23793c = r13;
        this.f23794d = new HashMap();
        return;
    L12:
        if (r11.isAnyLocalAddress() == true) goto L15;
        r13 = r11.getHostName();
        goto L16
    L5:
        if (r11.isAnyLocalAddress() == true) goto L8;
        r12 = r11.getHostAddress();
        goto L9
    }

    public final void a(BufferedReader r10, Map r11, Map r12, Map r13) {
        String r14 = r10.readLine();     // Catch: IOException -> L15
        if (r14 != null) goto L5;
        return;
    L5:
        StringTokenizer r15 = new StringTokenizer(r14);     // Catch: IOException -> L15
        if (r15.hasMoreTokens() == false) goto L37;
        r11.put("method", r15.nextToken());     // Catch: IOException -> L15
        if (r15.hasMoreTokens() == false) goto L35;
        String r16 = r15.nextToken();     // Catch: IOException -> L15
        int r17 = r16.indexOf(63);     // Catch: IOException -> L15
        if (r17 >= 0) goto L13;
    L17:
        String r18 = u9.d.d(r16);     // Catch: IOException -> L15
    L19:
        if (r15.hasMoreTokens() == false) goto L21;
        this.f23798h = r15.nextToken();     // Catch: IOException -> L15
    L22:
        String r19 = r10.readLine();     // Catch: IOException -> L15
    L23:
        if (r19 == null) goto L32;
        if (r19.trim().isEmpty() == true) goto L32;
        int r20 = r19.indexOf(58);     // Catch: IOException -> L15
        if (r20 < 0) goto L31;
        if (r20 >= r19.length()) goto L31;
        r13.put(r19.substring(0, r20).trim().toLowerCase(Locale.US), r19.substring(r20 + 1).trim());     // Catch: IOException -> L15
    L31:
        r19 = r10.readLine();     // Catch: IOException -> L15
    L32:
        r11.put("uri", r18);     // Catch: IOException -> L15
        return;
    L21:
        this.f23798h = "HTTP/1.1";     // Catch: IOException -> L15
        goto L22
    L13:
        if (r17 >= r16.length()) goto L17;
        b(r16.substring(r17 + 1), r12);     // Catch: IOException -> L15
        r18 = u9.d.d(r16.substring(0, r17));     // Catch: IOException -> L15
        goto L19
    L35:
        throw new Exception("Bad request, syntax error, correct format: GET /example/file.html");     // Catch: IOException -> L15
    L37:
        throw new Exception("Bad request, syntax error, correct format: GET /example/file.html");     // Catch: IOException -> L15
    L15:
        e = move-exception;
        throw new Exception("Parsing Header Exception: " + e.getMessage(), e);
    }

    public final void b(String r10, Map r11) {
        if (r10 != null) goto L6;
        this.f23800j = "";
        return;
    L6:
        this.f23800j = r10;
        StringTokenizer r12 = new StringTokenizer(r10, "&");
    L8:
        if (r12.hasMoreTokens() == false) goto L15;
        String r13 = r12.nextToken();
        int r14 = r13.indexOf(61);
        if (r14 < 0) goto L14;
        if (r14 >= r13.length()) goto L14;
        r11.put(u9.d.d(r13.substring(0, r14)).trim(), u9.d.d(r13.substring(r14 + 1)));
    L14:
        r11.put(u9.d.d(r13).trim(), "");
        goto L8
    }

    public final int c(byte[] r10, int r11) {
        int r12 = 0;
    L3:
        int r13 = r12 + 1;
        if (r13 >= r11) goto L23;
        byte r14 = r10[r12];
        if (r14 == 13) goto L8;
    L17:
        if (r14 != 10) goto L22;
        if (r10[r13] != 10) goto L22;
        return r12 + 2;
    L22:
        r12 = r13;
        goto L3
    L8:
        if (r10[r13] != 10) goto L17;
        int r15 = r12 + 3;
        if (r15 >= r11) goto L17;
        if (r10[r12 + 2] != 13) goto L17;
        if (r10[r15] != 10) goto L17;
        return r12 + 4;
    L23:
        return 0;
    }

    public String d() {
        return "video/mpeg";
    }

    public String e() {
        return this.f23798h;
    }

    public String f() {
        return String.valueOf(this.f23797g);
    }

    public boolean g() {
        return this.f23799i;
    }

    public void h() {
        byte[] r10 = new byte[8192];
        this.f23791a.mark(8192);
        boolean r11 = false;
        int r12 = this.f23791a.read(r10, 0, 8192);     // Catch: SSLException -> L31 IOException -> L33
    L5:
        if (r12 == (-1)) goto L29;
        int r13 = 0;
        int r14 = 0;
    L7:
        if (r12 <= 0) goto L12;
        r13 = r13 + r12;
        r14 = c(r10, r13);
        if (r14 > 0) goto L12;
        r12 = this.f23791a.read(r10, r13, 8192 - r13);
    L12:
        if (r14 >= r13) goto L14;
        this.f23791a.reset();
        this.f23791a.skip(r14);
    L14:
        this.f23795e = new HashMap();
        this.f23794d.clear();
        BufferedReader r15 = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(r10, 0, r13)));
        HashMap r16 = new HashMap();
        a(r15, r16, this.f23795e, this.f23794d);
        String r17 = this.f23792b;
        if (r17 == null) goto L17;
        this.f23794d.put("remote-addr", r17);
        this.f23794d.put("http-client-ip", this.f23792b);
    L17:
        Method r18 = Method.lookup((String) r16.get("method"));
        this.f23796f = r18;
        if (r18 == null) goto L28;
        this.f23797g = (String) r16.get("uri");
        String r19 = (String) this.f23794d.get(WsConstants.KEY_CONNECTION);
        if ("HTTP/1.1".equals(this.f23798h) == false) goto L25;
        if (r19 != null) goto L23;
    L24:
        r11 = true;
        goto L25
    L23:
        if (r19.matches("(?i).*close.*") == false) goto L24;
    L25:
        this.f23799i = r11;
        return;
    L28:
        throw new Exception("BAD REQUEST: Syntax error. HTTP verb " + ((String) r16.get("method")) + " unhandled.");
    L29:
        u9.d.b(this.f23791a);
        throw new SocketException("Can't read inputStream");
    L31:
        e = move-exception;
        throw e;
    L33:
        u9.d.b(this.f23791a);
        throw new SocketException("Socket Shutdown");
    }

    public Method i() {
        return this.f23796f;
    }
}
