package com.bytedance.frameworks.baselib.network.http.b;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.wschannel.WsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: CookieUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    static boolean a(String r4, String r5) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
    L18:
        return false;
    L5:
        if (TextUtils.isEmpty(r5) == true) goto L18;
        String r6 = r5.toLowerCase(Locale.US);
        String r7 = r4.toLowerCase(Locale.US);
        if (r7.startsWith(".") == false) goto L11;
        r7 = r7.substring(1);
    L11:
        if (r6.equals(r7) == false) goto L14;
        return true;
    L14:
        if (b(r7) == true) goto L17;
        return false;
    L17:
        return r6.endsWith("." + r7);
    }

    private static boolean b(String r3) {
        int r0 = r3.indexOf(46);
        if (r0 == (-1)) goto L8;
        if (r0 == 0) goto L8;
        if (r0 >= (r3.length() - 1)) goto L8;
        return true;
    L8:
        return false;
    }

    static boolean a(String r2, String r3, boolean r4) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
    L22:
        return false;
    L5:
        if (TextUtils.isEmpty(r2) == true) goto L22;
        String r5 = r2.toLowerCase(Locale.US);
        String r6 = r3.toLowerCase(Locale.US);
        if (r4 == true) goto L13;
        if (r6.startsWith(".") == true) goto L13;
        r6 = "." + r6;
    L13:
        if (r6.startsWith(".") == false) goto L21;
        if (r5.endsWith(r6) == false) goto L17;
    L18:
        return true;
    L17:
        if (r6.equals("." + r5) == true) goto L18;
        return false;
    L21:
        return r5.equals(r6);
    }

    static boolean b(String r4, String r5) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        r4 = "/";
    L6:
        if (TextUtils.isEmpty(r5) == false) goto L9;
        r5 = "/";
    L9:
        if (r4.equals(r5) == false) goto L12;
        return true;
    L12:
        if (r5.startsWith(r4) == true) goto L14;
        return false;
    L14:
        if (r4.endsWith("/") == false) goto L17;
        return true;
    L17:
        if (r5.length() <= r4.length()) goto L22;
        if (r5.charAt(r4.length()) != '/') goto L22;
        return true;
    L22:
        return false;
    }

    static boolean a(f r0, URI r1) {
        if (r0.e() == true) goto L5;
    L8:
        return true;
    L5:
        if ("https".equalsIgnoreCase(r1.getScheme()) == true) goto L8;
        return false;
    }

    public static HashSet<String> a(String r2) {
        HashSet<String> r0 = new HashSet();
        if (TextUtils.isEmpty(r2) == false) goto L12;
        return r0;
    L12:
        String[] r3 = r2.split(";\\s*");     // Catch: Throwable -> L9
        if (r3.length <= 0) goto L11;
        r0.addAll(Arrays.asList(r3));     // Catch: Throwable -> L9
    L11:
        return r0;
    L9:
        th = move-exception;
        th.printStackTrace();
        goto L11
    }

    public static String a(URI r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        String r0 = r2.getHost();
        if (TextUtils.isEmpty(r0) == false) goto L13;
        return r2.toURL().getHost();
    L10:
        return r2.getAuthority();
    L13:
        return r0;
    }

    public static Pair<Boolean, Double> a(Set<String> r22, Map<String, Set<f>> r23, JSONObject r24) {
        Set r0 = (Set) ZeusTransformUtils.wrapperContextForParams(r22, Set.class, "com.obric.aiagent.plugin");
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.aiagent.plugin");
        HashSet r6 = new HashSet();     // Catch: Throwable -> L79
        HashSet r7 = new HashSet();     // Catch: Throwable -> L79
        JSONArray r8 = new JSONArray();     // Catch: Throwable -> L79
        JSONArray r9 = new JSONArray();     // Catch: Throwable -> L79
        Iterator r10 = r0.iterator();     // Catch: Throwable -> L79
        long r13 = 0;
        boolean r15 = false;
    L86:
    L77:
        th = th;
        double r1 = 100.0d;
        boolean r3 = r15;
    L81:
        th.printStackTrace();
        double r4 = r1;
    L83:
        return new Pair(Boolean.valueOf(r3), Double.valueOf(r4));
    L7:
        if (r10.hasNext() == false) goto L34;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
        if (TextUtils.isEmpty(r5) == true) goto L86;
        Set r11 = (Set) ZeusTransformUtils.preCheckCast(r2.remove(r5), Set.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
        if (com.bytedance.common.utility.collection.a.a(r11) == false) goto L13;
        r8.put(r5);     // Catch: Throwable -> L31
        String r12 = r5.split("=")[0];     // Catch: Throwable -> L84
        if (TextUtils.isEmpty(r12) == true) goto L86;
        r6.add(r12);     // Catch: Throwable -> L84
        goto L86
    L13:
        r13 = r13 + 1;     // Catch: Throwable -> L31
        Iterator r14 = r11.iterator();     // Catch: Throwable -> L31
    L15:
        if (r14.hasNext() == false) goto L86;
        f r16 = (f) ZeusTransformUtils.preCheckCast(r14.next(), f.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
        if (r16 == null) goto L15;
        if (r16.h() <= 0) goto L15;
        if ((System.currentTimeMillis() - r16.h()) > WsConstants.EXIT_DELAY_TIME) goto L15;
        r15 = true;
    L31:
        th = th;
        r3 = r15;
    L33:
        r1 = 100.0d;
        goto L81
    L34:
        Iterator r17 = r2.entrySet().iterator();     // Catch: Throwable -> L77
        r3 = r15;
    L98:
    L75:
        th = th;
        goto L33
    L37:
        if (r17.hasNext() == false) goto L51;
        Set r18 = (Set) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r17.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), Set.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L75
        if (com.bytedance.common.utility.collection.a.a(r18) == true) goto L98;
        Iterator r19 = r18.iterator();     // Catch: Throwable -> L75
    L42:
        if (r19.hasNext() == false) goto L98;
        f r20 = (f) ZeusTransformUtils.preCheckCast(r19.next(), f.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L75
        if (r20 == null) goto L42;
        r7.add(r20.c());     // Catch: Throwable -> L75
        r9.put(r20.k());     // Catch: Throwable -> L75
        if (r20.h() <= 0) goto L42;
        if ((System.currentTimeMillis() - r20.h()) > WsConstants.EXIT_DELAY_TIME) goto L42;
        r3 = true;
        goto L42
    L51:
        JSONObject r21 = new JSONObject();     // Catch: Throwable -> L75
        if (r6.isEmpty() == true) goto L55;
        r21.put("only_sys", new JSONArray(r6));     // Catch: Throwable -> L75
    L55:
        if (r7.isEmpty() == true) goto L58;
        r21.put("only_tt", new JSONArray(r7));     // Catch: Throwable -> L75
    L58:
        if (r8.length() <= 0) goto L61;
        r21.put("o_sys_dtl", r8);     // Catch: Throwable -> L75
    L61:
        if (r9.length() <= 0) goto L64;
        r21.put("o_tt_dtl", r9);     // Catch: Throwable -> L75
    L64:
        if (r21.length() <= 0) goto L66;
        r24.put("diff", r21);     // Catch: Throwable -> L75
    L66:
        long r25 = r0.size();     // Catch: Throwable -> L75
        if (r25 <= 0) goto L70;
        r1 = 100.0d;
        double r26 = (r13 / r25) * 100.0d;
    L94:
        r4 = new BigDecimal(r26).setScale(3, RoundingMode.HALF_UP).doubleValue();     // Catch: Throwable -> L73
    L73:
        th = th;
        goto L81
    L70:
        r1 = 100.0d;
        r26 = 100.0d;
    L79:
        th = th;
        r1 = 100.0d;
        r3 = false;
        goto L81
    }
}
