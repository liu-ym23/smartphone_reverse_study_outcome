package com.ss.android.common.applog;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.bdinstall.ar;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: NetUtil.java */
/* JADX INFO: loaded from: classes4.dex */
public class y {
    private static final String TAG = "AppLog";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.ss.android.common.a f37255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, String> f37256b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap<String, String> f37257c = null;

    /* JADX INFO: compiled from: NetUtil.java */
    public interface a {
        void a(Context r1, Map<String, String> r2);
    }

    /* JADX INFO: compiled from: NetUtil.java */
    public interface b {
        HashMap<String, String> a(ar r1);
    }

    public static String a(com.bytedance.applog.m r2, String r3, byte[] r4, boolean r5, String r6, boolean r7, Map<String, String> r8, boolean r9, boolean r10) {
        com.bytedance.applog.m r11 = (com.bytedance.applog.m) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.applog.m.class, "com.obric.aiagent.plugin");
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
        HashMap r0 = new HashMap();
        if (com.bytedance.common.utility.j.a(r6) == true) goto L5;
        r0.put(DownloadHelper.CONTENT_TYPE, r6);
    L5:
        if (r5 == true) goto L7;
    L27:
        if (r12 == null) goto L29;
        r0.putAll(r12);
    L29:
        if (r10 == true) goto L31;
        com.ss.android.common.util.b.a(r0, r9);
    L31:
        com.bytedance.common.utility.g.a r13 = new com.bytedance.common.utility.g.a();
        r13.f6725a = r7;
        return com.bytedance.common.utility.g.a().a(r3, r4, r0, r13);
    L7:
        if (r11 != null) goto L9;
    L20:
        boolean r14 = false;
    L21:
        if (r14 == true) goto L27;
        r4 = com.bytedance.common.utility.g.a(r4);     // Catch: Exception -> L24
        r0.put(DownloadHelper.CONTENT_ENCODING, DownloadHelper.GZIP);     // Catch: Exception -> L24
    L24:
        e = move-exception;
        throw new com.bytedance.common.utility.b(0, e.getMessage());
    L9:
        if (r3.contains("/service/2/app_log/") == false) goto L20;
        com.bytedance.applog.e r15 = r11.a(r4);
        if (r15 == null) goto L20;
        if (r15.a() == null) goto L20;
        r4 = r15.a();
        if (r15.c() != null) goto L17;
    L19:
        r14 = true;
        goto L21
    L17:
        if (r15.c().isEmpty() == true) goto L19;
        r0.putAll(r15.c());
        goto L19
    }

    static {
        f37256b = new ConcurrentHashMap();
        f37257c = new ConcurrentHashMap();
    }

    @Deprecated
    public static String a(String r1, boolean r2) {
        return a(r1, r2, ar.f6144a);
    }

    public static void a(StringBuilder r6, boolean r7, ar r8) {
        if (f37255a == null) goto L26;
        if (r6 == null) goto L27;
        String r0 = r6.toString();
        if (TextUtils.isEmpty(r0) == false) goto L9;
        return;
    L9:
        Uri r1 = Uri.parse(r0);
        Set<String> r2 = r1.getQueryParameterNames();
        Uri.Builder r3 = r1.buildUpon();
        LinkedHashMap r4 = new LinkedHashMap();
        a(r4, r7, r8);
        Iterator r9 = r4.entrySet().iterator();
    L11:
        if (r9.hasNext() == false) goto L17;
        Map.Entry r10 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r5 = (String) ZeusTransformUtils.preCheckCast(r10.getKey(), String.class, "com.obric.aiagent.plugin");
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10.getValue(), String.class, "com.obric.aiagent.plugin");
        if (r2.contains(r5) == true) goto L11;
        if (TextUtils.isEmpty(r11) == true) goto L11;
        r3.appendQueryParameter(r5, (String) ZeusTransformUtils.preCheckCast(r10.getValue(), String.class, "com.obric.aiagent.plugin"));
        goto L11
    L17:
        r6.delete(0, r6.length());
        r6.append(r3.build().toString());
        return;
    L27:
        return;
    }

    public static String a(String r2, boolean r3, ar r4) {
        com.ss.android.common.a r0 = f37255a;
        if (com.bytedance.common.utility.j.a(r2) == true) goto L8;
        if (r0 == null) goto L9;
        StringBuilder r1 = new StringBuilder(r2);
        a(r1, r3, r4);
        return r1.toString();
    L9:
        return r2;
    L8:
        return r2;
    }

    public static void a(StringBuilder r7, Map<String, String> r8) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
        Uri r0 = Uri.parse(r7.toString());
        Set<String> r2 = r0.getQueryParameterNames();
        Uri.Builder r1 = r0.buildUpon();
        Iterator r10 = r9.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.aiagent.plugin");
        String r5 = (String) ZeusTransformUtils.preCheckCast(r3.getValue(), String.class, "com.obric.aiagent.plugin");
        if (r2.contains(r4) == true) goto L4;
        if (TextUtils.isEmpty(r5) == true) goto L4;
        r1.appendQueryParameter(r4, (String) ZeusTransformUtils.preCheckCast(r3.getValue(), String.class, "com.obric.aiagent.plugin"));
        goto L4
    L10:
        r7.delete(0, r7.length());
        r7.append(r1.build().toString());
    }

    public static void a(Map<String, String> r3, boolean r4, ar r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        com.ss.android.common.a r0 = f37255a;
        if (r0 != null) goto L5;
        return;
    L5:
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (com.ss.android.deviceregister.g.a() == false) goto L8;
        com.bytedance.bdinstall.i.a(r1, r6, r4, r5);
        return;
    L8:
        z.a(r6, r4, r5);
    }

    public static boolean a(String r5) {
        if (com.bytedance.common.utility.j.a(r5) == false) goto L6;
        return true;
    L6:
        if (r5.equalsIgnoreCase(SensitiveType.UNKNOWN) == false) goto L9;
        return true;
    L9:
        if (r5.equalsIgnoreCase("None") == false) goto L11;
        return true;
    L11:
        int r2 = 0;
    L13:
        if (r2 >= r5.length()) goto L21;
        if (r5.charAt(r2) != '0') goto L18;
        r2 = r2 + 1;
        goto L13
    L18:
        return false;
    L21:
        return true;
    }

    public static String a() {
        return z.a();
    }

    public static String a(com.bytedance.applog.m r12, String r13, byte[] r14, Context r15, boolean r16, String[] r17, Map<String, String> r18, String r19, boolean r20, boolean r21) {
        return z.a((com.bytedance.applog.m) ZeusTransformUtils.wrapperContextForParams(r12, com.bytedance.applog.m.class, "com.obric.aiagent.plugin"), r13, r14, (Context) ZeusTransformUtils.wrapperContextForParams(r15, Context.class, "com.obric.aiagent.plugin"), r16, r17, (Map) ZeusTransformUtils.wrapperContextForParams(r18, Map.class, "com.obric.aiagent.plugin"), r19, r20, r21);
    }
}
