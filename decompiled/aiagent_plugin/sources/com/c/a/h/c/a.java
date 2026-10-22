package com.c.a.h.c;

import android.text.TextUtils;
import com.bytedance.apm.util.m;
import com.bytedance.common.wschannel.WsConstants;
import com.c.a.h.b.b;
import com.c.a.i.e;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: CloudMessageUploadService.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f11944a = "https://mon.zijieapi.com/monitor/collect/c/cloudcontrol/file";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f11945b = "UTF-8";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Map<String, String> f11946c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final String f11947d = null;

    static {
        f11946c = new HashMap();
        f11947d = "cloudMessage" + UUID.randomUUID().toString();
    }

    public static boolean a(com.c.a.h.b.a r15) {
        int r1 = 0;
        boolean r2 = false;
    L4:
        if (r1 >= r15.g().size()) goto L27;
        File r3 = new File((String) ZeusTransformUtils.preCheckCast(r15.g().get(r1), String.class, "com.obric.aiagent.plugin"));
        if (r3.exists() == false) goto L26;
        if (r1 >= (r15.g().size() - 1)) goto L11;
        int r4 = 1;
    L13:
        if (r15.h() == false) goto L15;
        r4 = r15.l();
    L15:
        boolean r5 = a(f11944a, r3, null, r4, r15.a(), r15.k(), r15.m(), r15.n(), r15.o());
        if (r5 == true) goto L18;
    L20:
        if (r1 != 0) goto L22;
        r2 = r5;
        goto L26
    L22:
        if (r2 == false) goto L25;
        if (r5 == false) goto L25;
        r2 = true;
    L25:
        r2 = false;
        goto L26
    L18:
        if (r15.d() == false) goto L20;
        r3.delete();
        goto L20
    L11:
        r4 = 2;
    L26:
        r1 = r1 + 1;
        goto L4
    L27:
        return r2;
    }

    public static boolean a(b r8) {
        return a(f11944a, null, r8.l(), r8.k(), r8.m(), r8.n(), r8.o());
    }

    public static boolean a(File r10, int r11, String r12, String r13, String r14, long r15, HashMap<String, String> r17) {
        return a(f11944a, r10, null, r11, r12, r13, r14, r15, r17);
    }

    private static boolean a(String r14, File r15, Map<String, String> r16, int r17, String r18, String r19, String r20, long r21, HashMap<String, String> r23) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r16, Map.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r14) == true) goto L81;
        if (r15 == null) goto L81;
        if (r15.exists() == false) goto L81;
        HttpURLConnection r6 = null;
        HttpURLConnection r8 = m.a(r14);     // Catch: Throwable -> L59
        r8.setReadTimeout(30000);     // Catch: Throwable -> L56
        r8.setConnectTimeout(30000);     // Catch: Throwable -> L56
        r8.setDoInput(true);     // Catch: Throwable -> L56
        r8.setDoOutput(true);     // Catch: Throwable -> L56
        r8.setUseCaches(false);     // Catch: Throwable -> L56
        r8.setRequestMethod("POST");     // Catch: Throwable -> L56
        r8.setRequestProperty("Charset", f11945b);     // Catch: Throwable -> L56
        r8.setRequestProperty(WsConstants.KEY_CONNECTION, "keep-alive");     // Catch: Throwable -> L56
        r8.setRequestProperty(DownloadHelper.CONTENT_TYPE, "multipart/form-data;boundary=" + f11947d);     // Catch: Throwable -> L56
        Map<String, String> r10 = f11946c;     // Catch: Throwable -> L56
        if (r10 != null) goto L13;
    L23:
        a(r8);     // Catch: Throwable -> L56
        DataOutputStream r7 = new DataOutputStream(r8.getOutputStream());     // Catch: Throwable -> L56
        StringBuffer r9 = new StringBuffer();     // Catch: Throwable -> L54
        r9.append("--");     // Catch: Throwable -> L54
        String r11 = f11947d;     // Catch: Throwable -> L54
        r9.append(r11);     // Catch: Throwable -> L54
        r9.append("\r\n");     // Catch: Throwable -> L54
        r9.append("Content-Disposition: form-data; name=\"status\"\r\n\r\n" + r17 + "\r\n--" + r11 + "\r\n");     // Catch: Throwable -> L54
        r9.append("Content-Disposition: form-data; name=\"cid\"\r\n\r\n" + r19 + "\r\n--" + r11 + "\r\n");     // Catch: Throwable -> L54
        r9.append("Content-Disposition: form-data; name=\"err_msg\"\r\n\r\n" + r20 + "\r\n--" + r11 + "\r\n");     // Catch: Throwable -> L54
        r9.append("Content-Disposition: form-data; name=\"operate_time\"\r\n\r\n" + r21 + "\r\n--" + r11 + "\r\n");     // Catch: Throwable -> L54
        StringBuilder r12 = new StringBuilder().append("Content-Disposition: form-data; name=\"aid\"\r\n\r\n");     // Catch: Throwable -> L54
        com.c.a.a.a();     // Catch: Throwable -> L54
        r9.append(r12.append(com.c.a.a.e()).append("\r\n").append("--").append(r11).append("\r\n").toString());     // Catch: Throwable -> L54
        StringBuilder r13 = new StringBuilder().append("Content-Disposition: form-data; name=\"update_version_code\"\r\n\r\n");     // Catch: Throwable -> L54
        com.c.a.a.a();     // Catch: Throwable -> L54
        r9.append(r13.append(com.c.a.a.f()).append("\r\n").append("--").append(r11).append("\r\n").toString());     // Catch: Throwable -> L54
        StringBuilder r110 = new StringBuilder().append("Content-Disposition: form-data; name=\"uid\"\r\n\r\n");     // Catch: Throwable -> L54
        com.c.a.a.a();     // Catch: Throwable -> L54
        r9.append(r110.append(com.c.a.a.d()).append("\r\n").append("--").append(r11).append("\r\n").toString());     // Catch: Throwable -> L54
        if (r17 != 2) goto L27;
    L32:
        r7.write(r9.toString().getBytes());     // Catch: Throwable -> L54
        a(r7, r23);     // Catch: Throwable -> L54
        r9.setLength(0);     // Catch: Throwable -> L54
    L33:
        r9.append("Content-Disposition: form-data; name=\"file\"; filetype=\"" + r18 + "\"; filename=\"" + r15.getName() + "\"\r\n");     // Catch: Throwable -> L54
        r9.append("Content-Type: text/plain\r\n");     // Catch: Throwable -> L54
        r9.append("\r\n");     // Catch: Throwable -> L54
        r7.write(r9.toString().getBytes());     // Catch: Throwable -> L54
        FileInputStream r1 = new FileInputStream(r15);     // Catch: Throwable -> L54
        byte[] r0 = new byte[1024];     // Catch: Throwable -> L54
    L34:
        int r2 = r1.read(r0);     // Catch: Throwable -> L54
        if (r2 == (-1)) goto L37;
        r7.write(r0, 0, r2);     // Catch: Throwable -> L54
        goto L34
    L37:
        r1.close();     // Catch: Throwable -> L54
        r7.write("\r\n".getBytes());     // Catch: Throwable -> L54
        r7.write(("--" + f11947d + "--\r\n").getBytes());     // Catch: Throwable -> L54
        r7.flush();     // Catch: Throwable -> L54
        r7.close();     // Catch: Throwable -> L54
        if (r8.getResponseCode() != 200) goto L47;
        if (r8 == null) goto L86;
        r8.disconnect();
    L86:
        r7.close();     // Catch: Throwable -> L44
    L46:
        return true;
    L44:
        th = move-exception;
        th.printStackTrace();
        goto L46
    L47:
        if (r8 == null) goto L84;
        r8.disconnect();
    L84:
        r7.close();     // Catch: Throwable -> L51
    L53:
        return false;
    L51:
        th = move-exception;
        th.printStackTrace();
        goto L53
    L27:
        if (r17 == 3) goto L32;
        if (r17 != 0) goto L33;
        if (r23 == null) goto L33;
        if (r23.isEmpty() == true) goto L33;
    L54:
        th = th;
    L58:
        r6 = r8;
    L88:
        th.printStackTrace();     // Catch: Throwable -> L70
        if (r6 == null) goto L64;
        r6.disconnect();
    L64:
        if (r7 != null) goto L94;
    L69:
        return false;
    L94:
        r7.close();     // Catch: Throwable -> L67
    L67:
        th = move-exception;
        th.printStackTrace();
    L70:
        th = move-exception;
        if (r6 == null) goto L74;
        r6.disconnect();
    L74:
        if (r7 == null) goto L107;
        r7.close();     // Catch: Throwable -> L77
        throw th;
    L77:
        th = move-exception;
        th.printStackTrace();
        throw th;
    L107:
        throw th;
    L13:
        if (r10.isEmpty() == true) goto L23;
        Iterator<Map.Entry<String, String>> r111 = f11946c.entrySet().iterator();     // Catch: Throwable -> L56
    L16:
        if (r111.hasNext() == false) goto L23;
        Map.Entry r112 = (Map.Entry) ZeusTransformUtils.preCheckCast(r111.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L56
        String r113 = (String) ZeusTransformUtils.preCheckCast(r112.getKey(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L56
        String r114 = (String) ZeusTransformUtils.preCheckCast(r112.getValue(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L56
        if (TextUtils.isEmpty(r113) == true) goto L16;
        if (TextUtils.isEmpty(r114) == true) goto L16;
        r8.setRequestProperty(r113, r114);     // Catch: Throwable -> L56
    L56:
        th = th;
        r7 = null;
    L59:
        th = th;
        r7 = null;
    L81:
        throw new IllegalArgumentException("url and file not be null ");
    }

    private static void a(DataOutputStream r5, HashMap<String, String> r6) {
        if (com.c.a.a.a().h() != null) goto L5;
    L7:
        if (r6 != null) goto L9;
        return;
    L9:
        if (r6.size() == 0) goto L13;
        r5.write(("Content-Disposition: form-data; name=\"fileSpecific\"; filetype=\"command_specificparams\"; filename=\"specific_params.txt\"\r\nContent-Type: text/plain\r\n\r\n").getBytes());
        r5.write(e.a(r6).getBytes());
        r5.write("\r\n".getBytes());
        r5.write(new StringBuilder().append("--").append(f11947d).append("\r\n").toString().getBytes());
        r5.flush();
        return;
    L13:
        return;
    L5:
        if (com.c.a.a.a().h().size() == 0) goto L7;
        r5.write(("Content-Disposition: form-data; name=\"fileCommon\"; filetype=\"command_commonparams\"; filename=\"common_params.txt\"\r\nContent-Type: text/plain\r\n\r\n").getBytes());
        r5.write(e.a(com.c.a.a.a().h()).getBytes());
        r5.write("\r\n".getBytes());
        r5.write(new StringBuilder().append("--").append(f11947d).append("\r\n").toString().getBytes());
        r5.flush();
        goto L7
    }

    private static boolean a(String r13, Map<String, String> r14, int r15, String r16, String r17, long r18, HashMap<String, String> r20) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.aiagent.plugin");
        HttpURLConnection r5 = null;
        HttpURLConnection r7 = m.a(r13);     // Catch: Throwable -> L50
        r7.setReadTimeout(30000);     // Catch: Throwable -> L47
        r7.setConnectTimeout(30000);     // Catch: Throwable -> L47
        r7.setDoInput(true);     // Catch: Throwable -> L47
        r7.setDoOutput(true);     // Catch: Throwable -> L47
        r7.setUseCaches(false);     // Catch: Throwable -> L47
        r7.setRequestMethod("POST");     // Catch: Throwable -> L47
        r7.setRequestProperty("Charset", f11945b);     // Catch: Throwable -> L47
        r7.setRequestProperty(WsConstants.KEY_CONNECTION, "keep-alive");     // Catch: Throwable -> L47
        r7.setRequestProperty(DownloadHelper.CONTENT_TYPE, "multipart/form-data;boundary=" + f11947d);     // Catch: Throwable -> L47
        Map<String, String> r9 = f11946c;     // Catch: Throwable -> L47
        if (r9 != null) goto L8;
    L18:
        a(r7);     // Catch: Throwable -> L47
        DataOutputStream r6 = new DataOutputStream(r7.getOutputStream());     // Catch: Throwable -> L47
        StringBuffer r8 = new StringBuffer();     // Catch: Throwable -> L45
        r8.append("--");     // Catch: Throwable -> L45
        String r10 = f11947d;     // Catch: Throwable -> L45
        r8.append(r10);     // Catch: Throwable -> L45
        r8.append("\r\n");     // Catch: Throwable -> L45
        r8.append("Content-Disposition: form-data; name=\"status\"\r\n\r\n" + r15 + "\r\n--" + r10 + "\r\n");     // Catch: Throwable -> L45
        r8.append("Content-Disposition: form-data; name=\"cid\"\r\n\r\n" + r16 + "\r\n--" + r10 + "\r\n");     // Catch: Throwable -> L45
        r8.append("Content-Disposition: form-data; name=\"err_msg\"\r\n\r\n" + r17 + "\r\n--" + r10 + "\r\n");     // Catch: Throwable -> L45
        StringBuilder r11 = new StringBuilder().append("Content-Disposition: form-data; name=\"aid\"\r\n\r\n");     // Catch: Throwable -> L45
        com.c.a.a.a();     // Catch: Throwable -> L45
        r8.append(r11.append(com.c.a.a.e()).append("\r\n").append("--").append(r10).append("\r\n").toString());     // Catch: Throwable -> L45
        StringBuilder r12 = new StringBuilder().append("Content-Disposition: form-data; name=\"update_version_code\"\r\n\r\n");     // Catch: Throwable -> L45
        com.c.a.a.a();     // Catch: Throwable -> L45
        r8.append(r12.append(com.c.a.a.f()).append("\r\n").append("--").append(r10).append("\r\n").toString());     // Catch: Throwable -> L45
        r8.append("Content-Disposition: form-data; name=\"operate_time\"\r\n\r\n" + r18 + "\r\n--" + r10 + "\r\n");     // Catch: Throwable -> L45
        if (r15 != 2) goto L22;
    L27:
        r6.write(r8.toString().getBytes());     // Catch: Throwable -> L45
        a(r6, r20);     // Catch: Throwable -> L45
        r8.setLength(0);     // Catch: Throwable -> L45
    L28:
        StringBuilder r0 = new StringBuilder().append("Content-Disposition: form-data; name=\"uid\"\r\n\r\n");     // Catch: Throwable -> L45
        com.c.a.a.a();     // Catch: Throwable -> L45
        r8.append(r0.append(com.c.a.a.d()).append("\r\n").append("--").append(r10).append("\r\n").toString());     // Catch: Throwable -> L45
        r6.write(r8.toString().getBytes());     // Catch: Throwable -> L45
        r6.flush();     // Catch: Throwable -> L45
        r6.close();     // Catch: Throwable -> L45
        if (r7.getResponseCode() != 200) goto L38;
        if (r7 == null) goto L81;
        r7.disconnect();
    L81:
        r6.close();     // Catch: Throwable -> L35
    L37:
        return true;
    L35:
        th = move-exception;
        th.printStackTrace();
        goto L37
    L38:
        if (r7 == null) goto L79;
        r7.disconnect();
    L79:
        r6.close();     // Catch: Throwable -> L42
    L44:
        return false;
    L42:
        th = move-exception;
        th.printStackTrace();
        goto L44
    L22:
        if (r15 == 3) goto L27;
        if (r15 != 0) goto L28;
        if (r20 == null) goto L28;
        if (r20.isEmpty() == true) goto L28;
    L45:
        th = th;
    L49:
        r5 = r7;
    L83:
        th.printStackTrace();     // Catch: Throwable -> L61
        if (r5 == null) goto L55;
        r5.disconnect();
    L55:
        if (r6 != null) goto L73;
    L60:
        return false;
    L73:
        r6.close();     // Catch: Throwable -> L58
    L58:
        th = move-exception;
        th.printStackTrace();
    L61:
        th = move-exception;
        if (r5 == null) goto L65;
        r5.disconnect();
    L65:
        if (r6 == null) goto L95;
        r6.close();     // Catch: Throwable -> L68
        throw th;
    L68:
        th = move-exception;
        th.printStackTrace();
        throw th;
    L95:
        throw th;
    L8:
        if (r9.isEmpty() == true) goto L18;
        Iterator<Map.Entry<String, String>> r19 = f11946c.entrySet().iterator();     // Catch: Throwable -> L47
    L11:
        if (r19.hasNext() == false) goto L18;
        Map.Entry r110 = (Map.Entry) ZeusTransformUtils.preCheckCast(r19.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L47
        String r111 = (String) ZeusTransformUtils.preCheckCast(r110.getKey(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L47
        String r112 = (String) ZeusTransformUtils.preCheckCast(r110.getValue(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L47
        if (TextUtils.isEmpty(r111) == true) goto L11;
        if (TextUtils.isEmpty(r112) == true) goto L11;
        r7.setRequestProperty(r111, r112);     // Catch: Throwable -> L47
    L47:
        th = th;
        r6 = null;
    L50:
        th = th;
        r6 = null;
        goto L83
    }

    @Skip({"com.obric.aiagent.okhttp"})
    public static void a(HttpURLConnection r4) {
        if (ZeusTransformUtils.instanceOf(r4, HttpURLConnection.class) == false) goto L11;
        URL r0 = ((HttpURLConnection) ZeusTransformUtils.preCheckCast(r4, HttpURLConnection.class, "com.obric.aiagent.plugin")).getURL();
        if (r0 == null) goto L11;
        String r1 = r0.getHost();
        String r2 = r0.getPath();
        if (com.obric.aiagent.a.b.a(r1, r2) == false) goto L11;
        ILogDepend.Companion.i("AiAgentHucConnect", "huc connect drop " + r1 + r2);
        com.obric.aiagent.a.b.a(com.obric.aiagent.a.b.b(r1, r2), r1, r2);
        throw new IOException("[NetGuard] dropped ");
    L11:
        r4.connect();
    }
}
