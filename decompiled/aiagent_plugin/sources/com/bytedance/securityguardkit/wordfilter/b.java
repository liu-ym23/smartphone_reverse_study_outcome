package com.bytedance.securityguardkit.wordfilter;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.security.obric.guard.ObricSecurityGuardStub;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.securityguardkit.settingsevent.SettingsPolicyObserver;
import com.google.gson.Gson;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SensitiveWordFilter.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements SettingsPolicyObserver.a {
    private static final String TAG = "SensitiveWordFilter";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.securityguardkit.wordfilter.a f11160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f11161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bytedance.securityguardkit.wordfilter.a f11162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f11163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Set<String> f11164e;
    private final Object f;
    private final Context g;

    /* JADX INFO: compiled from: SensitiveWordFilter.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Map<String, Set<String>> f11165a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f11166b;

        a(Map<String, Set<String>> r3, int r4) {
            this.f11165a = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            this.f11166b = r4;
        }
    }

    public static /* synthetic */ void lambda$bsWI8NRFRUpc_dVDkMJXZDmq9fs(b r0) {
        r0.e();
    }

    public b(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        this.f11160a = null;
        this.f11161b = 0;
        this.f11162c = null;
        this.f11163d = 0;
        this.f11164e = null;
        this.f = new Object();
        this.g = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    }

    public void a() {
        if (this.f11160a == null) goto L5;
        return;
    L5:
        a r0 = a(this.g, "sens_words.json", null);
        if (r0 != null) goto L9;
        a(TAG, "解析敏感词库1失败");
        return;
    L9:
        Object r1 = this.f;
        monitor-enter(r1);
    L19:
        th = move-exception;
        throw th;
    L12:
        if (r0.f11165a.isEmpty() == false) goto L14;
        b(TAG, "敏感词库1为空");     // Catch: Throwable -> L19
        this.f11160a = null;     // Catch: Throwable -> L19
    L15:
        this.f11161b = r0.f11166b;     // Catch: Throwable -> L19
        monitor-exit(r1);     // Catch: Throwable -> L19
        c(TAG, "解析敏感词库1成功");
        return;
    L14:
        com.bytedance.securityguardkit.wordfilter.a r2 = new com.bytedance.securityguardkit.wordfilter.a();     // Catch: Throwable -> L19
        this.f11160a = r2;     // Catch: Throwable -> L19
        r2.a(r0.f11165a);     // Catch: Throwable -> L19
        goto L15
    }

    public boolean a(Set<String> r5) {
        Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.aiagent.plugin");
        a r0 = a(this.g, "sens_words_2.json", r6);
        if (r0 != null) goto L6;
        a(TAG, "解析敏感词库2失败");
        return false;
    L6:
        Object r1 = this.f;
        monitor-enter(r1);
    L16:
        th = move-exception;
        throw th;
    L9:
        if (r0.f11165a.isEmpty() == false) goto L11;
        b(TAG, "敏感词库2为空");     // Catch: Throwable -> L16
        this.f11162c = null;     // Catch: Throwable -> L16
    L12:
        this.f11164e = r6;     // Catch: Throwable -> L16
        this.f11163d = r0.f11166b;     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        c(TAG, "解析敏感词库2成功");
        return true;
    L11:
        com.bytedance.securityguardkit.wordfilter.a r2 = new com.bytedance.securityguardkit.wordfilter.a();     // Catch: Throwable -> L16
        this.f11162c = r2;     // Catch: Throwable -> L16
        r2.a(r0.f11165a);     // Catch: Throwable -> L16
        goto L12
    }

    public Set<String> c(String r4) {
        Object r0 = this.f;
        monitor-enter(r0);
        com.bytedance.securityguardkit.wordfilter.a r1 = this.f11160a;     // Catch: Throwable -> L18
        if (r1 == null) goto L10;
        Set<String> r2 = r1.a(r4).keySet();     // Catch: Throwable -> L18
        if (r2.isEmpty() == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L18
        return r2;
    L10:
        com.bytedance.securityguardkit.wordfilter.a r3 = this.f11162c;     // Catch: Throwable -> L18
        if (r3 == null) goto L15;
        Set<String> r5 = r3.a(r4).keySet();     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        return r5;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return null;
    L18:
        th = move-exception;
        throw th;
    }

    public Set<String> d(String r4) {
        Object r0 = this.f;
        monitor-enter(r0);
        com.bytedance.securityguardkit.wordfilter.a r1 = this.f11160a;     // Catch: Throwable -> L20
        if (r1 == null) goto L12;
        Set<String> r2 = r1.b(r4);     // Catch: Throwable -> L20
        if (r2 == null) goto L12;
        if (r2.isEmpty() == true) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L20
        return r2;
    L12:
        com.bytedance.securityguardkit.wordfilter.a r3 = this.f11162c;     // Catch: Throwable -> L20
        if (r3 == null) goto L17;
        Set<String> r5 = r3.b(r4);     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        return r5;
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L20
        return null;
    L20:
        th = move-exception;
        throw th;
    }

    public void b() {
        Object r0 = this.f;
        monitor-enter(r0);
        Set<String> r1 = this.f11164e;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.clear();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public JSONObject c() {
        JSONObject r0 = new JSONObject();
        r0.put("base_version", this.f11161b);     // Catch: JSONException -> L5
        r0.put("usr_version", this.f11163d);     // Catch: JSONException -> L5
    L7:
        return r0;
    L5:
        e = move-exception;
        a(TAG, "getSensitiveCapability JSONException", e);
        goto L7
    }

    @Override // com.bytedance.securityguardkit.settingsevent.SettingsPolicyObserver.a
    public void a(String r3) {
        c(TAG, "update sensitive word newVersion:" + r3);
        new Thread(new $$Lambda$b$bsWI8NRFRUpc_dVDkMJXZDmq9fs(this)).start();
    }

    private /* synthetic */ void e() {
        a r0 = a(this.g, "sens_words.json", null);
        a r1 = a(this.g, "sens_words_2.json", this.f11164e);
        Object r3 = this.f;
        monitor-enter(r3);
        if (r0 != null) goto L22;
    L12:
        if (r1 != null) goto L14;
    L18:
        monitor-exit(r3);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    L14:
        if (r1.f11165a.isEmpty() == false) goto L16;
        b(TAG, "敏感词库2为空");     // Catch: Throwable -> L10
        this.f11162c = null;     // Catch: Throwable -> L10
    L17:
        c(TAG, "usrSensitiveWord update success");     // Catch: Throwable -> L10
        goto L18
    L16:
        com.bytedance.securityguardkit.wordfilter.a r2 = new com.bytedance.securityguardkit.wordfilter.a();     // Catch: Throwable -> L10
        this.f11162c = r2;     // Catch: Throwable -> L10
        r2.a(r1.f11165a);     // Catch: Throwable -> L10
        this.f11163d = r1.f11166b;     // Catch: Throwable -> L10
        goto L17
    L22:
        if (r0.f11165a.isEmpty() == false) goto L8;
        b(TAG, "敏感词库1为空");     // Catch: Throwable -> L10
        this.f11160a = null;     // Catch: Throwable -> L10
    L9:
        c(TAG, "baseSensitiveWord update success");     // Catch: Throwable -> L10
        goto L12
    L8:
        com.bytedance.securityguardkit.wordfilter.a r4 = new com.bytedance.securityguardkit.wordfilter.a();     // Catch: Throwable -> L10
        this.f11160a = r4;     // Catch: Throwable -> L10
        r4.a(r0.f11165a);     // Catch: Throwable -> L10
        this.f11161b = r0.f11166b;     // Catch: Throwable -> L10
        goto L9
    }

    @Override // com.bytedance.securityguardkit.settingsevent.SettingsPolicyObserver.a
    public void b(String r2) {
        c(TAG, "update sensitive views newVersion:" + r2);
    }

    private a a(Context r9, String r10, Set<String> r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        Set r13 = (Set) ZeusTransformUtils.wrapperContextForParams(r11, Set.class, "com.obric.aiagent.plugin");
        String r14 = ObricSecurityGuardStub.getInstance().getSecurityPolicy(r10);     // Catch: Exception -> L35
        d(TAG, "sensitiveWords:" + r14);     // Catch: Exception -> L35
        if (TextUtils.isEmpty(r14) == false) goto L7;
        a(TAG, "敏感词库为空");     // Catch: Exception -> L35
        return null;
    L7:
        JSONObject r3 = new JSONObject(r14);     // Catch: Exception -> L35
        int r15 = r3.getInt("version");     // Catch: Exception -> L35
        if (r15 >= 0) goto L11;
        a(TAG, "敏感词库版本号错误");     // Catch: Exception -> L35
        return null;
    L11:
        JSONObject r16 = a(r12, r3);     // Catch: Exception -> L35
        if (r16 != null) goto L15;
        a(TAG, "解析敏感词表错误");     // Catch: Exception -> L35
        return null;
    L15:
        Gson r4 = new Gson();     // Catch: Exception -> L35
        if (r13 != null) goto L18;
    L32:
        Map<String, Set<String>> r8 = (Map) ZeusTransformUtils.preCheckCast(r4.fromJson(r16.toString(), new SensitiveWordFilter$1(this).getType()), Map.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L35
    L34:
        return new a(r8, r15);
    L18:
        if (r13.isEmpty() == true) goto L32;
        HashSet r5 = new HashSet();     // Catch: Exception -> L35
        Iterator<String> r6 = r16.keys();     // Catch: Exception -> L35
    L22:
        if (r6.hasNext() == false) goto L24;
        r5.add((String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L35
        goto L22
    L24:
        HashSet r7 = new HashSet();     // Catch: Exception -> L35
        Iterator r17 = r13.iterator();     // Catch: Exception -> L35
    L26:
        if (r17.hasNext() == false) goto L31;
        String r18 = (String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L35
        if (r5.contains(r18) == true) goto L29;
        b(TAG, "指定的敏感词类别不存在：" + r18);     // Catch: Exception -> L35
        goto L26
    L29:
        r7.add(r18);     // Catch: Exception -> L35
        goto L26
    L31:
        r8 = a(r16, r7);     // Catch: Exception -> L35
    L35:
        e = move-exception;
        a(TAG, "load sens word failed, " + e.getMessage());
        return null;
    }

    private Map<String, Set<String>> a(JSONObject r8, Set<String> r9) {
        Set r10 = (Set) ZeusTransformUtils.wrapperContextForParams(r9, Set.class, "com.obric.aiagent.plugin");
        HashMap r0 = new HashMap();
        Iterator r2 = r10.iterator();     // Catch: Exception -> L8
    L5:
        if (r2.hasNext() == false) goto L9;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L8
        r0.put(r3, (Set) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r8.getString(r3), new SensitiveWordFilter$2(this).getType()), Set.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L8
    L9:
        return r0;
    L8:
        b(TAG, "加载指定类别失败：" + r10);
        goto L9
    }

    private JSONObject a(Context r9, JSONObject r10) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        com.bytedance.securityguardkit.a.a.a r0 = com.bytedance.securityguardkit.a.a.a();
        if (r0 != null) goto L15;
        a(TAG, "PlatformKeyManager not available");
        return null;
    L15:
    L12:
        e = move-exception;
        a(TAG, "getSensitiveWords occur exception, " + e.getMessage());
        return null;
    L7:
        if (r10.getString("encrypt_type").equals(WsConstants.KEY_PLATFORM) == false) goto L11;
        String r2 = r10.getString("public_key");     // Catch: Exception -> L12
        String r3 = r10.getString("words_key");     // Catch: Exception -> L12
        return new JSONObject(e(r10.getString("words_cipher"), Base64.encodeToString(r0.a(r1, d(), Base64.decode(r3, 0), Base64.decode(r2, 0), new Bundle()), 0)));
    L11:
        return r10.getJSONObject("words");
    }

    private int d() {
        if (Build.SOC_MODEL.equalsIgnoreCase("SM7450") == false) goto L7;
        return -983039;
    L7:
        if (Build.SOC_MODEL.equalsIgnoreCase("SM8750") == false) goto L10;
        return -983038;
    L10:
        if (Build.SOC_MODEL.equalsIgnoreCase("SM8850") == false) goto L13;
        return -983037;
    L13:
        a(TAG, "unsupported platform: " + Build.SOC_MODEL);
        return -983038;
    }

    public static String e(String r5, String r6) {
        byte[] r7 = Base64.decode(r5, 0);
        byte[] r2 = new byte[12];
        int r3 = r7.length - 12;
        byte[] r4 = new byte[r3];
        System.arraycopy(r7, 0, r2, 0, 12);
        System.arraycopy(r7, 12, r4, 0, r3);
        SecretKeySpec r8 = new SecretKeySpec(Base64.decode(r6, 0), CryptoConst.ALGORITHM_AES);
        Cipher r9 = Cipher.getInstance("AES/GCM/NoPadding");
        r9.init(2, r8, new GCMParameterSpec(128, r2));
        return new String(r9.doFinal(r4), "UTF-8");
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int c(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
