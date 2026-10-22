package com.bytedance.crash.upload;

import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.general.RomInfo;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: UploaderUrl.java */
/* JADX INFO: loaded from: classes.dex */
public class o {
    static String a(String r3, String r4) {
        if (TextUtils.isEmpty(new URL(r3).getQuery()) == false) goto L9;
        if (r3.endsWith("?") == true) goto L11;
        r3 = r3 + "?";     // Catch: Throwable -> L13
    L11:
        return r3 + r4;
    L9:
        if (r3.endsWith("&") == true) goto L11;
        r3 = r3 + "&";     // Catch: Throwable -> L13
    L16:
        return r3;
    }

    public static String a(String r3, com.bytedance.crash.monitor.f r4) {
        HashMap r0 = new HashMap();
        r0.put(WsConstants.KEY_APP_ID, r4.e());
        r0.put("version_code", String.valueOf(r4.i()));
        r0.put("update_version_code", String.valueOf(r4.j()));
        r0.put(WsConstants.KEY_APP_VERSION, String.valueOf(r4.l()));
        if (TextUtils.isEmpty(r4.f()) == true) goto L5;
        r0.put("channel", r4.f());
    L5:
        r0.put("device_id", r4.a("0"));
        return a(r3, new JSONObject(r0));
    }

    public static String a(String r3, JSONObject r4) {
        return a(r3, a(com.bytedance.crash.o.l.b(r4), new String[]{WsConstants.KEY_APP_ID, "4444", RomInfo.KEY_OS_TYPE, "Android", "update_version_code", "000000", "channel", SensitiveType.UNKNOWN, WsConstants.KEY_APP_VERSION, "0.0.0", "sdk_version", com.bytedance.crash.config.g.f7298a, "device_id", com.bytedance.crash.general.a.d()}));
    }

    public static Map<String, String> a(Map<String, Object> r4, String... r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        HashMap r0 = new HashMap();
        if (r5 != null) goto L5;
    L18:
        com.bytedance.crash.c.b.a(new IllegalArgumentException("err keyValuePair:" + Arrays.toString(r5)));
        return r0;
    L5:
        if (r5.length == 0) goto L18;
        if ((r5.length % 2) != 0) goto L18;
        int r1 = 0;
    L11:
        if (r1 >= r5.length) goto L17;
        String r2 = r5[r1];
        Object r3 = r6.get(r2);
        if (r3 == null) goto L15;
        String r7 = String.valueOf(r3);
    L16:
        r0.put(r2, r7);
        r1 = r1 + 2;
        goto L11
    L15:
        r7 = r5[r1 + 1];
        goto L16
    L17:
        return r0;
    }

    public static String a(String r4, String r5, String r6) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return r4;
    L5:
        if (TextUtils.isEmpty(r5) == true) goto L21;
        if (r6 == null) goto L22;
        StringBuilder r1 = new StringBuilder(r4);
        if (r4.contains("?") == true) goto L18;
        r1.append("?");
    L18:
        if (r1.toString().endsWith("?") == true) goto L14;
        r1.append("&");     // Catch: Exception -> L17
    L14:
        r1.append(URLEncoder.encode(r5, "UTF-8"));     // Catch: Exception -> L17
        r1.append("=");     // Catch: Exception -> L17
        r1.append(URLEncoder.encode(r6, "UTF-8"));     // Catch: Exception -> L17
        return r1.toString();
    L23:
        return r4;
    L22:
        return r4;
    L21:
        return r4;
    }

    public static String a(String r6, Map r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        if (TextUtils.isDigitsOnly(r6) == true) goto L31;
        if (r8 != null) goto L6;
        return r6;
    L6:
        if (r8.isEmpty() == true) goto L33;
        StringBuilder r1 = new StringBuilder(r6);
        if (r6.contains("?") == true) goto L24;
        r1.append("?");
    L24:
        Iterator r9 = r8.entrySet().iterator();     // Catch: Exception -> L23
    L12:
        if (r9.hasNext() == false) goto L22;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L23
        if (r4.getValue() == null) goto L12;
        if (r1.toString().endsWith("?") == true) goto L19;
        r1.append("&");     // Catch: Exception -> L23
    L19:
        r1.append(URLEncoder.encode(r4.getKey().toString(), "UTF-8"));     // Catch: Exception -> L23
        r1.append("=");     // Catch: Exception -> L23
        r1.append(URLEncoder.encode(r4.getValue().toString(), "UTF-8"));     // Catch: Exception -> L23
        goto L12
    L22:
        return r1.toString();
    L34:
        return r6;
    L33:
        return r6;
    L31:
        return r6;
    }

    static String a(CrashType r1) {
        if (r1 != CrashType.NATIVE) goto L7;
        return com.bytedance.crash.config.f.d();
    L7:
        if (r1 == CrashType.ANR) goto L32;
        if (r1 == CrashType.JAVA) goto L32;
        if (r1 == CrashType.DART) goto L32;
        if (r1 != CrashType.LAUNCH) goto L18;
        return com.bytedance.crash.config.f.e();
    L18:
        if (r1 != CrashType.ASAN) goto L22;
        return com.bytedance.crash.config.f.l();
    L22:
        if (r1 != CrashType.COREDUMP) goto L26;
        return com.bytedance.crash.config.f.k();
    L26:
        if (r1 != CrashType.NATIVE_CUSTOMIZE) goto L30;
        return com.bytedance.crash.config.f.h();
    L30:
        return com.bytedance.crash.config.f.j();
    L32:
        return com.bytedance.crash.config.f.j();
    }

    public static String a(CrashType r1, JSONObject r2) {
        String r3 = a(r1);
        if (com.bytedance.crash.o.l.a(r2) == false) goto L5;
        return r3;
    L5:
        return a(r3, r2);
    }

    public static String a(String r1, int r2, String r3, String r4, long r5) {
        return a(a(a(a(a(a(a(r1, WsConstants.KEY_APP_ID, String.valueOf(r2)), "device_id", r3), RomInfo.KEY_OS_TYPE, "Android"), "update_version_code", String.valueOf(r5)), "channel", SensitiveType.UNKNOWN), WsConstants.KEY_APP_VERSION, r4), "sdk_version", com.bytedance.crash.config.g.f7298a);
    }
}
