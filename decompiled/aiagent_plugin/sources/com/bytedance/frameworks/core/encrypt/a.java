package com.bytedance.frameworks.core.encrypt;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.crash.general.HardwareInfo;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: RequestEncryptUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String TAG = "RequestEncryptUtils";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static InterfaceC0193a f8576a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f8577b = false;

    /* JADX INFO: renamed from: com.bytedance.frameworks.core.encrypt.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: RequestEncryptUtils.java */
    public interface InterfaceC0193a {
        boolean d();

        boolean e();

        boolean f();
    }

    static {
    }

    public static void a(InterfaceC0193a r2) {
        f8576a = (InterfaceC0193a) ZeusTransformUtils.wrapperContextForParams(r2, InterfaceC0193a.class, "com.obric.aiagent.plugin");
    }

    public static String a(String r12, List<Pair<String, String>> r13) {
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r12) == false) goto L6;
        return r12;
    L6:
        if (f8576a != null) goto L9;
        return r12;
    L9:
        if (f8577b == false) goto L11;
        return r12;
    L11:
        LinkedHashMap r1 = new LinkedHashMap();
        Uri r3 = Uri.parse(r12);     // Catch: Throwable -> L36
        a(r3, r1);     // Catch: Throwable -> L36
        LinkedList r4 = new LinkedList();     // Catch: Throwable -> L36
        a(r1, r4, "device_id");     // Catch: Throwable -> L36
        a(r1, r4, "device_type");     // Catch: Throwable -> L36
        a(r1, r4, HardwareInfo.KEY_HW_VENDOR_BRAND);     // Catch: Throwable -> L36
        a(r1, r4, "uuid");     // Catch: Throwable -> L36
        a(r1, r4, "openudid");     // Catch: Throwable -> L36
        String r5 = a(r4, false, "UTF-8");     // Catch: Throwable -> L36
        if (TextUtils.isEmpty(r5) == false) goto L15;
        return r12;
    L15:
        byte[] r6 = r5.getBytes();     // Catch: Throwable -> L36
        byte[] r7 = EncryptorUtil.a(r6, r6.length);     // Catch: Throwable -> L36
        if (r7 != null) goto L18;
        return r12;
    L18:
        String r8 = Base64.encodeToString(r7, 2);     // Catch: Throwable -> L36
        LinkedList r9 = new LinkedList();     // Catch: Throwable -> L36
        if (f8576a.d() == false) goto L22;
        LinkedList r10 = new LinkedList();     // Catch: Throwable -> L36
        r10.add(r8);     // Catch: Throwable -> L36
        r9.add(new Pair("ss_queries", r10));     // Catch: Throwable -> L36
    L22:
        if (f8576a.e() == false) goto L26;
        if (r14 == null) goto L26;
        r14.add(new Pair("X-SS-QUERIES", a(r8, "UTF-8")));     // Catch: Throwable -> L36
    L26:
        if (r1.isEmpty() == true) goto L34;
        Iterator r15 = r1.entrySet().iterator();     // Catch: Throwable -> L36
    L29:
        if (r15.hasNext() == false) goto L34;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r15.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L36
        if (r2 == null) goto L29;
        r9.add(new Pair(r2.getKey(), r2.getValue()));     // Catch: Throwable -> L36
    L34:
        String r11 = a(r9, true, "UTF-8");     // Catch: Throwable -> L36
        return a(r3.getScheme(), r3.getHost(), r3.getPort(), r3.getPath(), r11, r3.getFragment()).toString();
    L36:
        th = move-exception;
        th.printStackTrace();
        return r12;
    }

    private static boolean a(Map<String, List<String>> r2, List<Pair<String, List<String>>> r3, String r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return false;
    L5:
        if (r6 != null) goto L8;
        return false;
    L8:
        if (r5.containsKey(r4) == false) goto L14;
        r6.add(new Pair(r4, r5.get(r4)));
        if (f8576a.f() == true) goto L15;
        r5.remove(r4);
        return true;
    L15:
        return true;
    L14:
        return false;
    }

    public static void a(Uri r11, Map<String, List<String>> r12) {
        Map r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L26;
        if (r13 != null) goto L27;
        return;
    L27:
        String r14 = r11.getEncodedQuery();     // Catch: Throwable -> L21
        if (r14 == null) goto L32;
        String[] r15 = r14.split("&");     // Catch: Throwable -> L21
        int r2 = r15.length;     // Catch: Throwable -> L21
        int r4 = 0;
    L8:
        if (r4 >= r2) goto L33;
        String r5 = r15[r4];     // Catch: Throwable -> L21
        int r6 = r5.indexOf("=");     // Catch: Throwable -> L21
        if (r6 < 0) goto L16;
        String r8 = URLDecoder.decode(r5.substring(0, r6), "UTF-8");     // Catch: Throwable -> L21
        List r9 = (List) ZeusTransformUtils.preCheckCast(r13.get(r8), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        if (r9 != null) goto L15;
        r9 = new LinkedList();     // Catch: Throwable -> L21
    L15:
        r9.add(URLDecoder.decode(r5.substring(r6 + 1), "UTF-8"));     // Catch: Throwable -> L21
        r13.put(r8, r9);     // Catch: Throwable -> L21
    L20:
        r4 = r4 + 1;
        goto L8
    L16:
        String r7 = URLDecoder.decode(r5, "UTF-8");     // Catch: Throwable -> L21
        List r10 = (List) ZeusTransformUtils.preCheckCast(r13.get(r7), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        if (r10 != null) goto L19;
        r10 = new LinkedList();     // Catch: Throwable -> L21
    L19:
        r10.add("");     // Catch: Throwable -> L21
        r13.put(r7, r10);     // Catch: Throwable -> L21
        goto L20
    L33:
        return;
    L32:
        return;
    L21:
        th = move-exception;
        th.printStackTrace();
        throw new IOException("parseUrl url is null !!!");
    L26:
        throw new IOException("parseUrl url is null !!!");
    }

    private static Uri a(String r1, String r2, int r3, String r4, String r5, String r6) {
        StringBuilder r0 = new StringBuilder();
        if (r2 == null) goto L9;
        if (r1 == null) goto L6;
        r0.append(r1);
        r0.append("://");
    L6:
        r0.append(r2);
        if (r3 <= 0) goto L9;
        r0.append(':');
        r0.append(r3);
    L9:
        if (r4 != null) goto L11;
    L12:
        r0.append('/');
    L13:
        if (r4 == null) goto L15;
        r0.append(r4);
    L15:
        if (r5 == null) goto L17;
        r0.append('?');
        r0.append(r5);
    L17:
        if (r6 == null) goto L20;
        r0.append('#');
        r0.append(r6);
    L20:
        return Uri.parse(r0.toString());
    L11:
        if (r4.startsWith("/") == true) goto L13;
        goto L12
    }

    private static String a(List<Pair<String, List<String>>> r6, boolean r7, String r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        StringBuilder r0 = new StringBuilder();
        Iterator r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L25;
        Pair r2 = (Pair) ZeusTransformUtils.preCheckCast(r10.next(), Pair.class, "com.obric.aiagent.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.first, String.class, "com.obric.aiagent.plugin");
        if (r7 == false) goto L8;
        r3 = a((String) ZeusTransformUtils.preCheckCast(r2.first, String.class, "com.obric.aiagent.plugin"), r8);
    L8:
        List r4 = (List) ZeusTransformUtils.preCheckCast(r2.second, List.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L4;
        if (r4.size() <= 0) goto L4;
        Iterator r5 = r4.iterator();
    L14:
        if (r5.hasNext() == false) goto L4;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.aiagent.plugin");
        if (r7 == false) goto L21;
        if (r11 == null) goto L19;
        r11 = a(r11, r8);
        goto L21
    L19:
        r11 = "";
    L21:
        if (r0.length() <= 0) goto L23;
        r0.append("&");
    L23:
        r0.append(r3);
        r0.append("=");
        r0.append(r11);
        goto L14
    L25:
        return r0.toString();
    }

    private static String a(String r0, String r1) {
        if (r1 != null) goto L10;
        r1 = "ISO-8859-1";
    L10:
        return URLEncoder.encode(r0, r1);
    L7:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }
}
