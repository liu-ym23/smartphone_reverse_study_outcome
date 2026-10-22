package com.bytedance.apm6.consumer.slardar.d;

import android.app.Application;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.apm.doctor.DoctorManager;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.services.apm.api.k;
import com.bytedance.services.apm.api.l;
import com.bytedance.services.slardar.config.IConfigManager;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: NetworkSender.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    private static HashMap<f, e> f;
    private static volatile int h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f5157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f5158c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f5159d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Boolean f5160e;
    private List<String> g;
    private k i;
    private l j;
    private int k;

    static {
        f = new HashMap();
    }

    private e(f r3) {
        f r4 = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.aiagent.plugin");
        this.f5159d = null;
        this.k = 0;
        this.g = r4.b();
    }

    public static e a(f r4) {
        f r5 = (f) ZeusTransformUtils.wrapperContextForParams(r4, f.class, "com.obric.aiagent.plugin");
        if (f.containsKey(r5) == true) goto L5;
        f.put(r5, new e(r5));
        return (e) ZeusTransformUtils.preCheckCast(f.get(r5), e.class, "com.obric.aiagent.plugin");
    L5:
        return (e) ZeusTransformUtils.preCheckCast(f.get(r5), e.class, "com.obric.aiagent.plugin");
    }

    public static void a(int r4) {
        if (r4 != 2) goto L8;
        long r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm6.foundation.context.a.getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getSharedPreferences("dict_interval", 0).getLong("force_zstd_timestamp", 0);
        if ((System.currentTimeMillis() - r0) > DownloadConstants.HOUR) goto L8;
        h = 1;
        return;
    L8:
        h = r4;
    }

    private void a(String r4) {
        if (this.j != null) goto L6;
        this.j = (l) ZeusTransformUtils.preCheckCast(com.bytedance.apm6.service.c.a(l.class), l.class, "com.obric.aiagent.plugin");
    L6:
        if (this.j == null) goto L12;
        URL r0 = new URL(r4);     // Catch: MalformedURLException -> L9
        this.j.a(r0.getHost());     // Catch: MalformedURLException -> L9
        return;
    L13:
        return;
    }

    byte[] a(byte[] r4) {
        JSONObject r3 = new JSONObject(new String(r4));
        IConfigManager r5 = (IConfigManager) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IConfigManager.class), IConfigManager.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L10;
        JSONObject r6 = r5.retrieveSettingsParams();
        JSONObject r0 = new JSONObject();
        String r1 = String.valueOf(com.bytedance.apm6.foundation.context.a.g());
        if (TextUtils.isEmpty(r1) == true) goto L10;
        if (r1.equals("0") == true) goto L10;
        r0.put(r1, r6);
        r3.put("settings_params", r0);
    L10:
        return r3.toString().getBytes();
    }

    boolean b(byte[] r22) {
        if (r22 == null) goto L115;
        if (r22.length == 0) goto L115;
        String r7 = a();     // Catch: Throwable -> L111
        a(r7);     // Catch: Throwable -> L111
        byte[] r0 = a(r22);     // Catch: JSONException -> L11 Throwable -> L111
    L14:
        com.bytedance.apm6.service.c.a r2 = a(r7, r0, false);     // Catch: Throwable -> L111
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L18;
        DoctorManager.getInstance().a("APM_SEND_DATA", "url:" + r2.f5447a + " header:" + r2.f5448b);     // Catch: Throwable -> L111
        com.bytedance.apm6.util.c.b.a(com.bytedance.apm6.consumer.slardar.a.f5054a, "sendLog createRequest: origin Bytes=" + r0.length + " compressed Bytes=" + r2.f5449c.length + " url=" + r2.f5447a + " headers=" + r2.f5448b);     // Catch: Throwable -> L111
    L18:
        com.bytedance.services.apm.api.c r8 = com.bytedance.apm6.foundation.context.a.a(r2.f5447a, r2.f5448b, r2.f5449c);     // Catch: Throwable -> L111
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L25;
        String r10 = com.bytedance.apm6.consumer.slardar.a.f5054a;     // Catch: Throwable -> L111
        StringBuilder r11 = new StringBuilder().append("http result:");     // Catch: Throwable -> L111
        if (r8 != null) goto L23;
        Object r9 = -1;     // Catch: Throwable -> L111
    L24:
        com.bytedance.apm6.util.c.b.a(r10, r11.append(r9).toString());     // Catch: Throwable -> L111
        goto L25
    L23:
        r9 = r8.a() + " header:" + r8.c();     // Catch: Throwable -> L111
    L25:
        this.f5156a = null;     // Catch: Throwable -> L111
        this.f5159d = null;     // Catch: Throwable -> L111
        if (r8 != null) goto L28;
    L103:
        this.f5157b = true;     // Catch: Throwable -> L111
        Boolean r1 = this.f5160e;     // Catch: Throwable -> L111
        if (r1 != null) goto L106;
    L108:
        this.f5160e = true;     // Catch: Throwable -> L111
        return false;
    L106:
        if (r1.booleanValue() == false) goto L108;
        c.a().c();     // Catch: Throwable -> L111
        goto L108
    L28:
        if (r8.a() <= 0) goto L103;
        this.f5157b = false;     // Catch: Throwable -> L111
        if (500 <= r8.a()) goto L33;
    L41:
        JSONObject r12 = a(r8);     // Catch: Throwable -> L111
        if (r12 != null) goto L44;
    L101:
        this.f5160e = true;     // Catch: Throwable -> L111
        return false;
    L44:
        if (r8.a() != 200) goto L101;
        String r13 = r12.optString("message");     // Catch: Throwable -> L111
        String r14 = r12.optString("redirect");     // Catch: Throwable -> L111
        long r15 = r12.optLong("delay");     // Catch: Throwable -> L111
        if (r12.optLong("server_code", 0) == 10001) goto L50;
    L57:
        JSONObject r3 = r12.optJSONObject("settings_info");     // Catch: Throwable -> L111
        if (r3 == null) goto L65;
        IConfigManager r16 = (IConfigManager) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IConfigManager.class), IConfigManager.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L111
        if (r16 == null) goto L65;
        JSONObject r4 = r3.optJSONObject(String.valueOf(com.bytedance.apm6.foundation.context.a.g()));     // Catch: Throwable -> L111
        if (r4 == null) goto L65;
        r16.updateWithSpecificAidResult(r4);     // Catch: Throwable -> L111
    L65:
        if ("success".equals(r13) == false) goto L67;
        c.a().d();     // Catch: Throwable -> L111
        this.f5159d = r7;     // Catch: Throwable -> L111
        this.f5160e = false;     // Catch: Throwable -> L111
        boolean r6 = true;
        boolean r5 = false;
    L120:
    L86:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L111
    L88:
        JSONObject r17 = r12.optJSONObject("downgrade_rule");     // Catch: Throwable -> L111
        if (r17 == null) goto L91;
        com.bytedance.apm6.consumer.slardar.d.a.a.a().a(com.bytedance.apm6.consumer.slardar.d.a.c.a(r17), true);     // Catch: Throwable -> L111
    L91:
        this.f5156a = r14;     // Catch: Throwable -> L111
        if (r15 <= 0) goto L94;
        c.a().a(r15);     // Catch: Throwable -> L111
    L94:
        if (r5 == false) goto L99;
        c.a().f();     // Catch: Throwable -> L111
        if (r8.c() == null) goto L98;
        b.a().a((String) ZeusTransformUtils.preCheckCast(r8.c().get("x-tt-logid"), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L111
    L98:
        b.a().a(System.currentTimeMillis());     // Catch: Throwable -> L111
    L100:
        return r6;
    L99:
        c.a().g();     // Catch: Throwable -> L111
        goto L100
    L72:
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L88;
        JSONObject r18 = new JSONObject();     // Catch: Throwable -> L86
        r18.put("RESPONSE_DATA_URL", r2.f5447a);     // Catch: Throwable -> L86
        if (r8.c() == null) goto L84;
        JSONObject r19 = new JSONObject();     // Catch: Throwable -> L86
        Iterator<Map.Entry<String, String>> r110 = r8.c().entrySet().iterator();     // Catch: Throwable -> L86
    L77:
        if (r110.hasNext() == false) goto L83;
        Map.Entry r20 = (Map.Entry) ZeusTransformUtils.preCheckCast(r110.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L86
        if (r20.getKey() == null) goto L77;
        r19.put((String) ZeusTransformUtils.preCheckCast(r20.getKey(), String.class, "com.obric.aiagent.plugin"), r20.getValue());     // Catch: Throwable -> L116
        goto L77
    L83:
        r18.put("RESPONSE_DATA_HEADERS", r19);     // Catch: Throwable -> L86
    L84:
        r18.put("RESPONSE_DATA_BODY_TEXT", r12);     // Catch: Throwable -> L86
        com.bytedance.apm.doctor.a.a(r0, r18);     // Catch: Throwable -> L86
    L67:
        this.f5160e = true;     // Catch: Throwable -> L111
        r5 = "drop data".equals(r13);     // Catch: Throwable -> L111
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L70;
        com.bytedance.apm6.util.c.b.a(com.bytedance.apm6.consumer.slardar.a.f5054a, "responseMessage:" + r13);     // Catch: Throwable -> L111
    L70:
        r6 = false;
        goto L120
    L50:
        if (h != 2) goto L57;
        if (this.i == null) goto L57;
        if (this.k != 0) goto L57;
        h = 1;     // Catch: Throwable -> L111
        ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm6.foundation.context.a.getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getSharedPreferences("dict_interval", 0).edit().putLong("dict_interval", 0).putLong("force_zstd_timestamp", System.currentTimeMillis()).commit();     // Catch: Throwable -> L111
        this.k++;     // Catch: Throwable -> L111
        boolean r21 = b(r0);     // Catch: Throwable -> L111
        this.k--;     // Catch: Throwable -> L111
        return r21;
    L33:
        if (r8.a() > 600) goto L41;
        Boolean r23 = this.f5160e;     // Catch: Throwable -> L111
        if (r23 != null) goto L37;
    L39:
        this.f5160e = true;     // Catch: Throwable -> L111
        return false;
    L37:
        if (r23.booleanValue() == false) goto L39;
        c.a().b();     // Catch: Throwable -> L111
        goto L39
    L11:
        e = move-exception;
        com.bytedance.services.apm.api.a.a(e, "NetworkSender->sendLog(byte[] bytes)");     // Catch: Throwable -> L111
        com.bytedance.apm6.util.c.b.d(com.bytedance.apm6.consumer.slardar.a.f5054a, " appendSettingsParams wrong ");     // Catch: Throwable -> L111
        r0 = r22;
    L111:
        th = move-exception;
        com.bytedance.apm6.util.c.b.b(com.bytedance.apm6.consumer.slardar.a.f5054a, "sendLog failed.", th);
        return false;
    L115:
        return true;
    }

    private JSONObject a(com.bytedance.services.apm.api.c r8) {
        JSONObject r4 = new JSONObject(new String(r8.b()));     // Catch: Exception -> L26
        Map<String, String> r9 = r8.c();     // Catch: Exception -> L26
        if (r9 != null) goto L6;
    L11:
        String r5 = null;
    L12:
        boolean r10 = true;
        String r1 = r4.optString("data");     // Catch: Throwable -> L24
        if (r1.isEmpty() == false) goto L16;
    L19:
        a(r4);     // Catch: Throwable -> L24
        if (r10 == true) goto L23;
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L24
        r7.put("message", "success");     // Catch: Throwable -> L24
        return r7;
    L23:
        return r4;
    L16:
        if (TextUtils.isEmpty(r5) == true) goto L18;
        String r2 = a(r1.getBytes(), r5);     // Catch: Throwable -> L24
        r4 = new JSONObject(r2);     // Catch: Throwable -> L24
        r10 = true ^ TextUtils.isEmpty(r2);     // Catch: Throwable -> L24
        goto L19
    L18:
        r4 = new JSONObject(new String(r1.getBytes()));     // Catch: Throwable -> L24
    L24:
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L26
        r11.put("message", "success");     // Catch: Exception -> L26
        return r11;
    L6:
        if (r9.isEmpty() == true) goto L11;
        r5 = (String) ZeusTransformUtils.preCheckCast(r9.get("ran"), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L26
        if (TextUtils.isEmpty(r5) == false) goto L12;
        r5 = (String) ZeusTransformUtils.preCheckCast(r9.get("Ran"), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L26
    L26:
        return null;
    }

    private String a() {
        List<String> r0 = this.g;
        if (TextUtils.isEmpty(this.f5156a) == true) goto L13;
        if (r0 != null) goto L7;
    L11:
        return null;
    L7:
        if (r0.size() <= 0) goto L11;
        return "https://" + this.f5156a + new URL((String) ZeusTransformUtils.preCheckCast(r0.get(0), String.class, "com.obric.aiagent.plugin")).getPath();
    L13:
        if (TextUtils.isEmpty(this.f5159d) == true) goto L17;
        return this.f5159d;
    L17:
        if (this.f5157b == false) goto L19;
        this.f5158c++;
    L19:
        int r1 = r0.size();
        int r4 = this.f5158c;
        if (r1 <= r4) goto L23;
        if (r4 < 0) goto L23;
        return (String) ZeusTransformUtils.preCheckCast(r0.get(r4), String.class, "com.obric.aiagent.plugin");
    L23:
        this.f5158c = 0;
        return (String) ZeusTransformUtils.preCheckCast(r0.get(0), String.class, "com.obric.aiagent.plugin");
    }

    private com.bytedance.apm6.service.c.a a(String r11, byte[] r12, boolean r13) {
        HashMap r0 = new HashMap();
        HashMap r1 = new HashMap(com.bytedance.apm6.foundation.context.a.t());
        r0.put(DownloadHelper.ACCEPT_ENCODING, DownloadHelper.GZIP);
        byte[] r4 = null;
        if (r12.length > 128) goto L5;
    L38:
        if (r4 == null) goto L41;
        r12 = r4;
    L41:
        r0.put(DownloadHelper.CONTENT_TYPE, "application/json; charset=utf-8");
        if (c.a().l() == false) goto L56;
        byte[] r2 = d(r12);
        if (r2 == null) goto L55;
        r1.put("tt_data", "a");
        String r14 = com.bytedance.apm6.util.k.a(r11, r1);
        r0.put(DownloadHelper.CONTENT_TYPE, "application/octet-stream;tt-data=a");
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L48;
        com.bytedance.apm6.util.c.b.a(com.bytedance.apm6.consumer.slardar.a.f5054a, "before encrypt url:" + r14);
    L48:
        LinkedList r15 = new LinkedList();
        String r10 = a(r14, r15);
        if (TextUtils.isEmpty(r10) == true) goto L52;
        r14 = r10;
    L52:
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L54;
        com.bytedance.apm6.util.c.b.a(com.bytedance.apm6.consumer.slardar.a.f5054a, "after encrypt url:" + r14);
    L54:
        r0.putAll(com.bytedance.apm6.util.f.b(r15));
        r12 = r2;
    L57:
        r0.put("Version-Code", "1");
        return new com.bytedance.apm6.service.c.a(r14, r0, r12);
    L55:
        r14 = com.bytedance.apm6.util.k.a(r11, r1);
        goto L57
    L56:
        r14 = com.bytedance.apm6.util.k.a(r11, r1);
        goto L57
    L5:
        if (r13 == false) goto L7;
    L34:
        if (r4 != null) goto L38;
        r4 = c(r12);
        if (r4 == null) goto L38;
        r0.put(DownloadHelper.CONTENT_ENCODING, DownloadHelper.GZIP);
        goto L38
    L7:
        if (this.i != null) goto L10;
        this.i = (k) ZeusTransformUtils.preCheckCast(com.bytedance.apm6.service.c.a(k.class), k.class, "com.obric.aiagent.plugin");
    L10:
        if (h != 1) goto L18;
        k r16 = this.i;
        if (r16 == null) goto L18;
        byte[] r17 = r16.a(r12, 15);
        if (r17 == null) goto L16;
        r0.put(DownloadHelper.CONTENT_ENCODING, "zstd");
        r0.put("Content-Encoding-Level", String.valueOf(15));
    L16:
        r4 = r17;
    L18:
        if (h != 2) goto L34;
        if (this.i == null) goto L34;
        if (this.j != null) goto L24;
        this.j = (l) ZeusTransformUtils.preCheckCast(com.bytedance.apm6.service.c.a(l.class), l.class, "com.obric.aiagent.plugin");
    L24:
        l r18 = this.j;
        if (r18 == null) goto L29;
        Pair<byte[], String> r19 = r18.a();
        byte[] r6 = (byte[]) ZeusTransformUtils.preCheckCast(r19.first, byte[].class, "com.obric.aiagent.plugin");
        String r110 = (String) ZeusTransformUtils.preCheckCast(r19.second, String.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L30;
        r4 = this.i.a(r12, r6, 15);
    L30:
        if (r4 == null) goto L34;
        r0.put(DownloadHelper.CONTENT_ENCODING, "zstd/dict_monitor");
        r0.put("Content-Encoding-Level", String.valueOf(15));
        if (TextUtils.isEmpty(r110) == true) goto L34;
        r0.put("slardar-zstd-version", r110);
        r1.put("slardar-zstd-version", r110);
        goto L34
    L29:
        r110 = null;
        goto L30
    }

    private byte[] c(byte[] r3) {
        ByteArrayOutputStream r2 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r0 = null;
        GZIPOutputStream r1 = new GZIPOutputStream(r2);     // Catch: Throwable -> L9 IOException -> L12
        r1.write(r3);     // Catch: Throwable -> L7 IOException -> L15
        com.bytedance.apm6.util.d.a(r1);
        return r2.toByteArray();
    L7:
        th = th;
        r0 = r1;
    L10:
        com.bytedance.apm6.util.d.a(r0);
        throw th;
    L13:
        com.bytedance.apm6.util.d.a(r1);
        return null;
    L12:
        r1 = null;
    L9:
        th = th;
        goto L10
    }

    private byte[] d(byte[] r3) {
        com.bytedance.services.apm.api.e r2 = (com.bytedance.services.apm.api.e) ZeusTransformUtils.preCheckCast(com.bytedance.apm6.service.c.a(com.bytedance.services.apm.api.e.class), com.bytedance.services.apm.api.e.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
        return null;
    L5:
        return r2.a(r3);
    }

    private String a(String r3, List<Pair<String, String>> r4) {
        List<Pair<String, String>> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        com.bytedance.apm6.service.b.a r5 = (com.bytedance.apm6.service.b.a) ZeusTransformUtils.preCheckCast(com.bytedance.apm6.service.c.a(com.bytedance.apm6.service.b.a.class), com.bytedance.apm6.service.b.a.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.a(r3, r2);
    }

    private String a(byte[] r3, String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L12;
        return "";
    L12:
        SecretKeySpec r2 = new SecretKeySpec(r4.getBytes(), CryptoConst.ALGORITHM_AES);     // Catch: Throwable -> L7
        Cipher r5 = Cipher.getInstance("AES/ECB/NoPadding");     // Catch: Throwable -> L7
        r5.init(2, r2);     // Catch: Throwable -> L7
        return new String(r5.doFinal(Base64.decode(r3, 0))).replaceAll("\\$+$", "");
    L7:
        th = move-exception;
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L11;
        com.bytedance.apm6.util.c.b.b(com.bytedance.apm6.consumer.slardar.a.f5054a, "decodeData", th);
    L11:
        return "";
    }

    private void a(JSONObject r3) {
        if (com.bytedance.apm6.util.e.a(r3) == false) goto L5;
        return;
    L5:
        JSONObject r2 = r3.optJSONObject("configs");
        if (com.bytedance.apm6.util.e.a(r2) == false) goto L8;
        return;
    L8:
        com.bytedance.apm6.consumer.slardar.g r4 = (com.bytedance.apm6.consumer.slardar.g) ZeusTransformUtils.preCheckCast(com.bytedance.apm6.service.c.a(com.bytedance.apm6.consumer.slardar.g.class), com.bytedance.apm6.consumer.slardar.g.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L12;
        r4.a(r2);
        return;
    }
}
