package ea;

import android.text.TextUtils;
import com.bytedance.apm.util.k;
import com.bytedance.common.wschannel.WsConstants;
import com.monitor.cloudmessage.utils.d;
import da.b;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f19329a = "https://mon.zijieapi.com/monitor/collect/c/cloudcontrol/file";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f19330b = "UTF-8";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Map f19331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f19332d = null;

    static {
        f19331c = new HashMap();
        f19332d = "cloudMessage" + UUID.randomUUID().toString();
    }

    public static boolean a(String r14, File r15, Map r16, int r17, String r18, String r19, String r20, long r21, HashMap r23) {
        if (TextUtils.isEmpty(r14) == true) goto L80;
        if (r15 == null) goto L80;
        if (r15.exists() == false) goto L80;
        HttpURLConnection r10 = null;
        HttpURLConnection r11 = k.a(r14);     // Catch: Throwable -> L58
        r11.setReadTimeout(30000);     // Catch: Throwable -> L23
        r11.setConnectTimeout(30000);     // Catch: Throwable -> L23
        r11.setDoInput(true);     // Catch: Throwable -> L23
        r11.setDoOutput(true);     // Catch: Throwable -> L23
        r11.setUseCaches(false);     // Catch: Throwable -> L23
        r11.setRequestMethod("POST");     // Catch: Throwable -> L23
        r11.setRequestProperty("Charset", f19330b);     // Catch: Throwable -> L23
        r11.setRequestProperty(WsConstants.KEY_CONNECTION, "keep-alive");     // Catch: Throwable -> L23
        r11.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + f19332d);     // Catch: Throwable -> L23
        Map r12 = f19331c;     // Catch: Throwable -> L23
        if (r12 != null) goto L13;
    L26:
        r11.connect();     // Catch: Throwable -> L23
        DataOutputStream r13 = new DataOutputStream(r11.getOutputStream());     // Catch: Throwable -> L23
        StringBuffer r22 = new StringBuffer();     // Catch: Throwable -> L36
        r22.append("--");     // Catch: Throwable -> L36
        String r110 = f19332d;     // Catch: Throwable -> L36
        r22.append(r110);     // Catch: Throwable -> L36
        r22.append("\r\n");     // Catch: Throwable -> L36
        r22.append("Content-Disposition: form-data; name=\"status\"\r\n\r\n" + r17 + "\r\n--" + r110 + "\r\n");     // Catch: Throwable -> L36
        r22.append("Content-Disposition: form-data; name=\"cid\"\r\n\r\n" + r19 + "\r\n--" + r110 + "\r\n");     // Catch: Throwable -> L36
        r22.append("Content-Disposition: form-data; name=\"err_msg\"\r\n\r\n" + r20 + "\r\n--" + r110 + "\r\n");     // Catch: Throwable -> L36
        r22.append("Content-Disposition: form-data; name=\"operate_time\"\r\n\r\n" + r21 + "\r\n--" + r110 + "\r\n");     // Catch: Throwable -> L36
        StringBuilder r111 = new StringBuilder();     // Catch: Throwable -> L36
        r111.append("Content-Disposition: form-data; name=\"aid\"\r\n\r\n");     // Catch: Throwable -> L36
        v9.a.k();     // Catch: Throwable -> L36
        r111.append(v9.a.f());     // Catch: Throwable -> L36
        r111.append("\r\n");     // Catch: Throwable -> L36
        r111.append("--");     // Catch: Throwable -> L36
        r111.append(r110);     // Catch: Throwable -> L36
        r111.append("\r\n");     // Catch: Throwable -> L36
        r22.append(r111.toString());     // Catch: Throwable -> L36
        StringBuilder r112 = new StringBuilder();     // Catch: Throwable -> L36
        r112.append("Content-Disposition: form-data; name=\"update_version_code\"\r\n\r\n");     // Catch: Throwable -> L36
        v9.a.k();     // Catch: Throwable -> L36
        r112.append(v9.a.n());     // Catch: Throwable -> L36
        r112.append("\r\n");     // Catch: Throwable -> L36
        r112.append("--");     // Catch: Throwable -> L36
        r112.append(r110);     // Catch: Throwable -> L36
        r112.append("\r\n");     // Catch: Throwable -> L36
        r22.append(r112.toString());     // Catch: Throwable -> L36
        StringBuilder r113 = new StringBuilder();     // Catch: Throwable -> L36
        r113.append("Content-Disposition: form-data; name=\"uid\"\r\n\r\n");     // Catch: Throwable -> L36
        v9.a.k();     // Catch: Throwable -> L36
        r113.append(v9.a.m());     // Catch: Throwable -> L36
        r113.append("\r\n");     // Catch: Throwable -> L36
        r113.append("--");     // Catch: Throwable -> L36
        r113.append(r110);     // Catch: Throwable -> L36
        r113.append("\r\n");     // Catch: Throwable -> L36
        r22.append(r113.toString());     // Catch: Throwable -> L36
        if (r17 != 2) goto L30;
    L38:
        r13.write(r22.toString().getBytes());     // Catch: Throwable -> L36
        f(r13, r23);     // Catch: Throwable -> L36
        r22.setLength(0);     // Catch: Throwable -> L36
    L39:
        r22.append("Content-Disposition: form-data; name=\"file\"; filetype=\"" + r18 + "\"; filename=\"" + r15.getName() + "\"\r\n");     // Catch: Throwable -> L36
        r22.append("Content-Type: text/plain\r\n");     // Catch: Throwable -> L36
        r22.append("\r\n");     // Catch: Throwable -> L36
        r13.write(r22.toString().getBytes());     // Catch: Throwable -> L36
        FileInputStream r24 = new FileInputStream(r15);     // Catch: Throwable -> L36
        byte[] r25 = new byte[1024];     // Catch: Throwable -> L36
    L40:
        int r26 = r24.read(r25);     // Catch: Throwable -> L36
        if (r26 == (-1)) goto L43;
        r13.write(r25, 0, r26);     // Catch: Throwable -> L36
        goto L40
    L43:
        r24.close();     // Catch: Throwable -> L36
        r13.write("\r\n".getBytes());     // Catch: Throwable -> L36
        r13.write(("--" + f19332d + "--\r\n").getBytes());     // Catch: Throwable -> L36
        r13.flush();     // Catch: Throwable -> L36
        r13.close();     // Catch: Throwable -> L36
        if (r11.getResponseCode() != 200) goto L52;
        r11.disconnect();
        r13.close();     // Catch: Throwable -> L49
    L51:
        return true;
    L49:
        th = move-exception;
        th.printStackTrace();
        goto L51
    L52:
        r11.disconnect();
        r13.close();     // Catch: Throwable -> L55
    L57:
        return false;
    L55:
        th = move-exception;
        th.printStackTrace();
        goto L57
    L30:
        if (r17 == 3) goto L38;
        if (r17 != 0) goto L39;
        if (r23 == null) goto L39;
        if (r23.isEmpty() == true) goto L39;
    L36:
        th = th;
    L25:
        r10 = r11;
    L95:
        th.printStackTrace();     // Catch: Throwable -> L69
        if (r10 == null) goto L63;
        r10.disconnect();
    L63:
        if (r13 != null) goto L89;
    L68:
        return false;
    L89:
        r13.close();     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        th.printStackTrace();
    L69:
        th = move-exception;
        if (r10 == null) goto L73;
        r10.disconnect();
    L73:
        if (r13 == null) goto L106;
        r13.close();     // Catch: Throwable -> L76
        throw th;
    L76:
        th = move-exception;
        th.printStackTrace();
        throw th;
    L106:
        throw th;
    L13:
        if (r12.isEmpty() == true) goto L26;
        Iterator r27 = f19331c.entrySet().iterator();     // Catch: Throwable -> L23
    L16:
        if (r27.hasNext() == false) goto L26;
        Map.Entry r114 = (Map.Entry) r27.next();     // Catch: Throwable -> L23
        String r115 = (String) r114.getKey();     // Catch: Throwable -> L23
        String r116 = (String) r114.getValue();     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r115) == true) goto L16;
        if (TextUtils.isEmpty(r116) == true) goto L16;
        r11.setRequestProperty(r115, r116);     // Catch: Throwable -> L23
    L23:
        th = th;
        r13 = null;
    L58:
        th = th;
        r13 = null;
    L80:
        throw new IllegalArgumentException("url and file not be null ");
    }

    public static boolean b(String r10, Map r11, int r12, String r13, String r14, long r15, HashMap r16) {
        HttpURLConnection r17 = null;
        HttpURLConnection r18 = k.a(r10);     // Catch: Throwable -> L49
        r18.setReadTimeout(30000);     // Catch: Throwable -> L18
        r18.setConnectTimeout(30000);     // Catch: Throwable -> L18
        r18.setDoInput(true);     // Catch: Throwable -> L18
        r18.setDoOutput(true);     // Catch: Throwable -> L18
        r18.setUseCaches(false);     // Catch: Throwable -> L18
        r18.setRequestMethod("POST");     // Catch: Throwable -> L18
        r18.setRequestProperty("Charset", f19330b);     // Catch: Throwable -> L18
        r18.setRequestProperty(WsConstants.KEY_CONNECTION, "keep-alive");     // Catch: Throwable -> L18
        r18.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + f19332d);     // Catch: Throwable -> L18
        Map r19 = f19331c;     // Catch: Throwable -> L18
        if (r19 != null) goto L8;
    L21:
        r18.connect();     // Catch: Throwable -> L18
        DataOutputStream r20 = new DataOutputStream(r18.getOutputStream());     // Catch: Throwable -> L18
        StringBuffer r21 = new StringBuffer();     // Catch: Throwable -> L31
        r21.append("--");     // Catch: Throwable -> L31
        String r22 = f19332d;     // Catch: Throwable -> L31
        r21.append(r22);     // Catch: Throwable -> L31
        r21.append("\r\n");     // Catch: Throwable -> L31
        r21.append("Content-Disposition: form-data; name=\"status\"\r\n\r\n" + r12 + "\r\n--" + r22 + "\r\n");     // Catch: Throwable -> L31
        r21.append("Content-Disposition: form-data; name=\"cid\"\r\n\r\n" + r13 + "\r\n--" + r22 + "\r\n");     // Catch: Throwable -> L31
        r21.append("Content-Disposition: form-data; name=\"err_msg\"\r\n\r\n" + r14 + "\r\n--" + r22 + "\r\n");     // Catch: Throwable -> L31
        StringBuilder r110 = new StringBuilder();     // Catch: Throwable -> L31
        r110.append("Content-Disposition: form-data; name=\"aid\"\r\n\r\n");     // Catch: Throwable -> L31
        v9.a.k();     // Catch: Throwable -> L31
        r110.append(v9.a.f());     // Catch: Throwable -> L31
        r110.append("\r\n");     // Catch: Throwable -> L31
        r110.append("--");     // Catch: Throwable -> L31
        r110.append(r22);     // Catch: Throwable -> L31
        r110.append("\r\n");     // Catch: Throwable -> L31
        r21.append(r110.toString());     // Catch: Throwable -> L31
        StringBuilder r111 = new StringBuilder();     // Catch: Throwable -> L31
        r111.append("Content-Disposition: form-data; name=\"update_version_code\"\r\n\r\n");     // Catch: Throwable -> L31
        v9.a.k();     // Catch: Throwable -> L31
        r111.append(v9.a.n());     // Catch: Throwable -> L31
        r111.append("\r\n");     // Catch: Throwable -> L31
        r111.append("--");     // Catch: Throwable -> L31
        r111.append(r22);     // Catch: Throwable -> L31
        r111.append("\r\n");     // Catch: Throwable -> L31
        r21.append(r111.toString());     // Catch: Throwable -> L31
        r21.append("Content-Disposition: form-data; name=\"operate_time\"\r\n\r\n" + r15 + "\r\n--" + r22 + "\r\n");     // Catch: Throwable -> L31
        if (r12 != 2) goto L25;
    L33:
        r20.write(r21.toString().getBytes());     // Catch: Throwable -> L31
        f(r20, r16);     // Catch: Throwable -> L31
        r21.setLength(0);     // Catch: Throwable -> L31
    L34:
        StringBuilder r112 = new StringBuilder();     // Catch: Throwable -> L31
        r112.append("Content-Disposition: form-data; name=\"uid\"\r\n\r\n");     // Catch: Throwable -> L31
        v9.a.k();     // Catch: Throwable -> L31
        r112.append(v9.a.m());     // Catch: Throwable -> L31
        r112.append("\r\n");     // Catch: Throwable -> L31
        r112.append("--");     // Catch: Throwable -> L31
        r112.append(r22);     // Catch: Throwable -> L31
        r112.append("\r\n");     // Catch: Throwable -> L31
        r21.append(r112.toString());     // Catch: Throwable -> L31
        r20.write(r21.toString().getBytes());     // Catch: Throwable -> L31
        r20.flush();     // Catch: Throwable -> L31
        r20.close();     // Catch: Throwable -> L31
        if (r18.getResponseCode() != 200) goto L43;
        r18.disconnect();
        r20.close();     // Catch: Throwable -> L40
    L42:
        return true;
    L40:
        th = move-exception;
        th.printStackTrace();
        goto L42
    L43:
        r18.disconnect();
        r20.close();     // Catch: Throwable -> L46
    L48:
        return false;
    L46:
        th = move-exception;
        th.printStackTrace();
        goto L48
    L25:
        if (r12 == 3) goto L33;
        if (r12 != 0) goto L34;
        if (r16 == null) goto L34;
        if (r16.isEmpty() == true) goto L34;
    L31:
        th = th;
    L20:
        r17 = r18;
    L79:
        th.printStackTrace();     // Catch: Throwable -> L60
        if (r17 == null) goto L54;
        r17.disconnect();
    L54:
        if (r20 != null) goto L69;
    L59:
        return false;
    L69:
        r20.close();     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        th.printStackTrace();
    L60:
        th = move-exception;
        if (r17 == null) goto L63;
        r17.disconnect();
    L63:
        if (r20 != null) goto L73;
    L68:
        throw th;
    L73:
        r20.close();     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        th.printStackTrace();
        goto L68
    L8:
        if (r19.isEmpty() == true) goto L21;
        Iterator r23 = f19331c.entrySet().iterator();     // Catch: Throwable -> L18
    L11:
        if (r23.hasNext() == false) goto L21;
        Map.Entry r24 = (Map.Entry) r23.next();     // Catch: Throwable -> L18
        String r25 = (String) r24.getKey();     // Catch: Throwable -> L18
        String r26 = (String) r24.getValue();     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r25) == true) goto L11;
        if (TextUtils.isEmpty(r26) == true) goto L11;
        r18.setRequestProperty(r25, r26);     // Catch: Throwable -> L18
    L18:
        th = th;
        r20 = null;
    L49:
        th = th;
        r20 = null;
        goto L79
    }

    public static boolean c(b r10) {
        return b(f19329a, null, r10.a(), r10.b(), r10.c(), r10.e(), r10.f());
    }

    public static boolean d(da.a r15) {
        int r10 = 0;
        boolean r11 = false;
    L4:
        if (r10 >= r15.l().size()) goto L27;
        File r12 = new File((String) r15.l().get(r10));
        if (r12.exists() == false) goto L26;
        if (r10 >= (r15.l().size() - 1)) goto L11;
        int r13 = 1;
    L13:
        if (r15.o() == false) goto L15;
        r13 = r15.a();
    L15:
        boolean r14 = a(f19329a, r12, null, r13, r15.k(), r15.b(), r15.c(), r15.e(), r15.f());
        if (r14 == true) goto L18;
    L20:
        if (r10 != 0) goto L22;
        r11 = r14;
        goto L26
    L22:
        if (r11 == false) goto L25;
        if (r14 == false) goto L25;
        r11 = true;
    L25:
        r11 = false;
        goto L26
    L18:
        if (r15.m() == false) goto L20;
        r12.delete();
        goto L20
    L11:
        r13 = 2;
    L26:
        r10 = r10 + 1;
        goto L4
    L27:
        return r11;
    }

    public static boolean e(File r10, int r11, String r12, String r13, String r14, long r15, HashMap r17) {
        return a(f19329a, r10, null, r11, r12, r13, r14, r15, r17);
    }

    public static void f(DataOutputStream r10, HashMap r11) {
        if (v9.a.k().h() != null) goto L5;
    L7:
        if (r11 != null) goto L9;
        return;
    L9:
        if (r11.size() == 0) goto L13;
        r10.write(("Content-Disposition: form-data; name=\"fileSpecific\"; filetype=\"command_specificparams\"; filename=\"specific_params.txt\"\r\nContent-Type: text/plain\r\n\r\n").getBytes());
        r10.write(d.b(r11).getBytes());
        r10.write("\r\n".getBytes());
        r10.write(("--" + f19332d + "\r\n").getBytes());
        r10.flush();
        return;
    L13:
        return;
    L5:
        if (v9.a.k().h().size() == 0) goto L7;
        r10.write(("Content-Disposition: form-data; name=\"fileCommon\"; filetype=\"command_commonparams\"; filename=\"common_params.txt\"\r\nContent-Type: text/plain\r\n\r\n").getBytes());
        r10.write(d.b(v9.a.k().h()).getBytes());
        r10.write("\r\n".getBytes());
        r10.write(("--" + f19332d + "\r\n").getBytes());
        r10.flush();
        goto L7
    }
}
