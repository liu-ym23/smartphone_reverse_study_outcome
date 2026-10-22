package com.ss.android.deviceregister.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.general.HardwareInfo;
import com.bytedance.crash.general.RomInfo;
import com.ss.android.common.util.ToolUtils;
import com.ss.android.deviceregister.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: RegistrationHeaderHelper.java */
/* JADX INFO: loaded from: classes4.dex */
public class v {
    private static final String TAG = "RegistrationHeaderHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f37400a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static com.ss.android.common.a f37401b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f37402c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f37403d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f37404e = 0;
    private static int f = 0;
    private static String g = null;
    private static String h = "2.15.0";
    private static ConcurrentHashMap<String, Object> i;
    private static boolean j;
    private static volatile JSONObject k;
    private static String l;
    private static String m;
    private static String n;
    private static String o;
    private static final Object p = null;
    private static com.ss.android.deviceregister.a.d q;
    private static j r;
    private static boolean s;
    private static String t;
    private static volatile com.ss.android.deviceregister.d u;
    private static String v;
    private static volatile boolean w;
    private static volatile boolean x;
    private static ConcurrentHashMap<String, Object> y;

    static {
        i = new ConcurrentHashMap();
        j = false;
        p = new Object();
        s = false;
        x = true;
    }

    public static String a() {
        return v;
    }

    public static boolean a(Context r13, JSONObject r14, boolean r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        HashMap r0 = new HashMap();
        Object r1 = p;
        monitor-enter(r1);
    L301:
        th = move-exception;
        throw th;
    L5:
        if (k != null) goto L7;
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L301
        boolean r2 = com.ss.android.deviceregister.g.f();
        JSONObject r3 = new JSONObject();
        boolean r4 = false;
        String r5 = r16.getPackageName();     // Catch: Exception -> L298
        Bundle r6 = r16.getPackageManager().getApplicationInfo(r5, 128).metaData;     // Catch: Exception -> L30
        String r7 = f37400a;     // Catch: Exception -> L30
        if (r7 == null) goto L20;
        if (r7.length() <= 0) goto L20;
        r0.put("channel", f37400a);     // Catch: Exception -> L30
    L25:
        if (r6 == null) goto L33;
        if (TextUtils.isEmpty("UMENG_APPKEY") == true) goto L33;
        r0.put("appkey", r6.getString("UMENG_APPKEY"));     // Catch: Exception -> L30
    L33:
        if (TextUtils.isEmpty(v) == true) goto L35;
        r0.put("package", v);     // Catch: Exception -> L298
        Bundle r8 = new Bundle();     // Catch: Exception -> L298
        r8.putString("real_package_name", r16.getPackageName());     // Catch: Exception -> L298
        com.ss.android.deviceregister.g.a(r8);     // Catch: Exception -> L298
    L36:
        com.ss.android.common.a r9 = f37401b;     // Catch: Exception -> L298
        if (r9 == null) goto L40;
        f37402c = r9.b();     // Catch: Exception -> L298
    L40:
        if (com.bytedance.common.utility.j.a(f37403d) == true) goto L42;
        f37402c = f37403d;     // Catch: Exception -> L298
    L42:
        r0.put(WsConstants.KEY_APP_VERSION, f37402c);     // Catch: Exception -> L298
        com.ss.android.common.a r10 = f37401b;     // Catch: Exception -> L298
        if (r10 == null) goto L45;
        f37404e = r10.e();     // Catch: Exception -> L298
    L45:
        PackageInfo r11 = r16.getPackageManager().getPackageInfo(r5, 0);     // Catch: Exception -> L298
        if (r11.applicationInfo == null) goto L50;
        int r12 = r11.applicationInfo.labelRes;     // Catch: Exception -> L298
        if (r12 <= 0) goto L50;
        r3.put("display_name", r16.getString(r12));     // Catch: Exception -> L298
    L50:
        com.ss.android.common.a r17 = f37401b;     // Catch: Exception -> L298
        if (r17 == null) goto L62;
        int r18 = r17.g();     // Catch: Exception -> L298
        if (r18 <= 0) goto L55;
        r3.put("update_version_code", r18);     // Catch: Exception -> L298
    L55:
        int r19 = f37401b.h();     // Catch: Exception -> L298
        if (r19 <= 0) goto L59;
        r3.put("manifest_version_code", r19);     // Catch: Exception -> L298
    L59:
        if (TextUtils.isEmpty(com.ss.android.deviceregister.g.d()) == true) goto L61;
        r3.put("app_version_minor", com.ss.android.deviceregister.g.d());     // Catch: Exception -> L298
        goto L62
    L61:
        r3.put("app_version_minor", "");     // Catch: Exception -> L298
    L62:
        String[] r20 = {"channel", "appkey", "package", WsConstants.KEY_APP_VERSION};
    L85:
        e = move-exception;
        a(e);
    L328:
        DisplayMetrics r21 = ZeusTransformUtils.getResources(r16, "com.obric.aiagent.plugin").getDisplayMetrics();     // Catch: Exception -> L99
        int r22 = r21.densityDpi;     // Catch: Exception -> L99
        r3.put(HardwareInfo.KEY_HW_DENSITY_DPI, r22);     // Catch: Exception -> L99
        if (r22 != 120) goto L90;
        String r23 = "ldpi";
    L97:
        r3.put(HardwareInfo.KEY_HW_DISPLAY_DENSITY, r23);     // Catch: Exception -> L99
        r3.put(HardwareInfo.KEY_HW_DISPLAY_RESOLUTION, r21.heightPixels + "x" + r21.widthPixels);     // Catch: Exception -> L99
    L101:
        SharedPreferences r24 = b.a(r16);
        String r25 = ZeusTransformUtils.getResources(r16, "com.obric.aiagent.plugin").getConfiguration().locale.getLanguage();     // Catch: Exception -> L115
        if (com.bytedance.common.utility.j.a(r25) == true) goto L105;
        r3.put("language", r25);     // Catch: Exception -> L115
    L105:
        float r26 = (TimeZone.getDefault().getRawOffset() * 1.0f) / 3600000.0f;     // Catch: Exception -> L115
        if (r26 >= (-12.0f)) goto L109;
        r26 = -12.0f;
    L109:
        if (r26 <= 12.0f) goto L111;
        r26 = 12.0f;
    L111:
        r3.put("timezone", r26);     // Catch: Exception -> L115
        String r27 = com.bytedance.common.utility.i.f(r16);     // Catch: Exception -> L115
        if (r27 == null) goto L319;
        r3.put("access", r27);     // Catch: Exception -> L115
    L319:
    L132:
        e = move-exception;
        a(e);
        e.printStackTrace();
    L334:
        String r28 = com.ss.android.deviceregister.c.c.e(r16);     // Catch: Exception -> L141
        String r29 = com.ss.android.deviceregister.c.c.d(r16);     // Catch: Exception -> L141
        if (com.bytedance.common.utility.j.a(r28) == true) goto L138;
        r3.put("carrier", r28);     // Catch: Exception -> L141
    L138:
        if (com.bytedance.common.utility.j.a(r29) == true) goto L143;
        r3.put("mcc_mnc", r29);     // Catch: Exception -> L141
    L143:
        StringBuilder r30 = new StringBuilder();
    L160:
        th = move-exception;
        a(th);
    L326:
        String r31 = com.ss.android.deviceregister.c.e.a();     // Catch: Throwable -> L166
        if (com.bytedance.common.utility.j.a(r31) == true) goto L311;
        r3.put("rom_version", r31);     // Catch: Throwable -> L166
    L311:
        String r32 = com.ss.android.deviceregister.c.a.a(r16);     // Catch: Throwable -> L172
        if (com.bytedance.common.utility.j.a(r32) == true) goto L174;
        r3.put("cdid", r32);     // Catch: Throwable -> L172
    L174:
        a(r16, r3);
        String r33 = r24.getString("app_language", null);
        String r34 = r24.getString("app_region", null);
        String r35 = com.ss.android.a.a();     // Catch: Throwable -> L218
        String r36 = com.ss.android.a.b();     // Catch: Throwable -> L218
        if (r15 == true) goto L193;
        if (r2 == true) goto L193;
        Pair<String, Boolean> r37 = com.ss.android.deviceregister.j.a(r16);     // Catch: Throwable -> L218
        if (com.ss.android.deviceregister.g.b(r16) == true) goto L193;
        if (r37 == null) goto L193;
        if (r37.second != null) goto L184;
    L186:
        boolean r110 = false;
    L188:
        if (r110 == false) goto L190;
        int r111 = 1;
    L191:
        r3.put("gaid_limited", r111);     // Catch: Throwable -> L218
        r3.put("google_aid", r37.first);     // Catch: Throwable -> L218
        goto L193
    L190:
        r111 = 0;
        goto L191
    L184:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r37.second, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L186;
        r110 = true;
    L193:
        if (com.bytedance.common.utility.j.a(r35) == false) goto L195;
    L197:
        boolean r38 = false;
    L199:
        if (com.bytedance.common.utility.j.a(r33) == true) goto L202;
        r3.put("app_language", r33);     // Catch: Throwable -> L218
    L202:
        if (com.bytedance.common.utility.j.a(r36) == true) goto L207;
        if (r36.equals(r34) == true) goto L207;
        r4 = true;
        r34 = r36;
    L207:
        if (com.bytedance.common.utility.j.a(r34) == true) goto L209;
        r3.put("app_region", r34);     // Catch: Throwable -> L218
    L209:
        SharedPreferences.Editor r39 = r24.edit();     // Catch: Throwable -> L218
        if (r38 == false) goto L212;
        r39.putString("app_language", r33);     // Catch: Throwable -> L218
    L212:
        if (r4 == false) goto L214;
        r39.putString("app_region", r34);     // Catch: Throwable -> L218
    L214:
        if (r38 == true) goto L216;
        if (r4 == true) goto L216;
    L220:
        String r40 = r24.getString("app_track", "");
        o = r40;
    L225:
        th = move-exception;
        a(th);
        th.printStackTrace();
    L227:
        com.ss.android.deviceregister.a.d r41 = q;
        if (r41 == null) goto L249;
        String r42 = r41.g();     // Catch: Exception -> L246
        if (com.bytedance.common.utility.j.a(r42) == true) goto L232;
        r3.put("device_id", r42);     // Catch: Exception -> L246
    L232:
        if (r15 == true) goto L236;
        String r43 = q.i();     // Catch: Exception -> L246
        if (com.bytedance.common.utility.j.a(r43) == true) goto L236;
        r3.put("openudid", r43);     // Catch: Exception -> L246
    L236:
        String r44 = q.h();     // Catch: Exception -> L246
        if (com.bytedance.common.utility.j.a(r44) == true) goto L239;
        r3.put("install_id", r44);     // Catch: Exception -> L246
    L239:
        String r45 = q.k();     // Catch: Exception -> L246
        if (com.bytedance.common.utility.j.a(r45) == true) goto L242;
        r3.put("clientudid", r45);     // Catch: Exception -> L246
    L242:
        String r46 = q.n();     // Catch: Exception -> L246
        if (com.bytedance.common.utility.j.a(r46) == true) goto L249;
        r3.put("klink_egdi", r46);     // Catch: Exception -> L246
    L246:
        e = move-exception;
        a(e);
        e.printStackTrace();
    L249:
        if (com.ss.android.deviceregister.g.b(r16) == true) goto L309;
    L258:
        ConcurrentHashMap<String, Object> r47 = y;
        if (r47 == null) goto L315;
        Iterator<Map.Entry<String, Object>> r48 = r47.entrySet().iterator();
    L262:
        if (r48.hasNext() == false) goto L315;
        Map.Entry r49 = (Map.Entry) ZeusTransformUtils.preCheckCast(r48.next(), Map.Entry.class, "com.obric.aiagent.plugin");
    L268:
        e = move-exception;
        e.printStackTrace();
        goto L262
    L265:
        if (r49.getValue() == null) goto L262;
        r3.put((String) ZeusTransformUtils.preCheckCast(r49.getKey(), String.class, "com.obric.aiagent.plugin"), r49.getValue());     // Catch: JSONException -> L268
    L315:
        String r50 = com.ss.android.deviceregister.c.c.a();     // Catch: Throwable -> L280
        if (com.bytedance.common.utility.j.a(r50) == true) goto L273;
        r3.put("region", r50);     // Catch: Throwable -> L280
    L273:
        String r51 = Calendar.getInstance().getTimeZone().getID();     // Catch: Throwable -> L280
        if (com.bytedance.common.utility.j.a(r51) == true) goto L276;
        r3.put("tz_name", r51);     // Catch: Throwable -> L280
    L276:
        r3.put("tz_offset", Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()) / 1000);     // Catch: Throwable -> L280
        String r52 = com.ss.android.deviceregister.c.c.f(r16);     // Catch: Throwable -> L280
        if (com.bytedance.common.utility.j.a(r52) == true) goto L282;
        r3.put("sim_region", r52);     // Catch: Throwable -> L280
    L282:
        if (r15 == true) goto L285;
        f.a(r16, q, r3, f(), r2);
    L285:
        if (TextUtils.isEmpty(t) == false) goto L332;
    L290:
        Object r112 = p;
        monitor-enter(r112);
        k = r3;     // Catch: Throwable -> L295
        w = r15;     // Catch: Throwable -> L295
        a(r3, r14);     // Catch: Throwable -> L295
        monitor-exit(r112);     // Catch: Throwable -> L295
        return true;
    L295:
        th = move-exception;
        throw th;
    L332:
        r3.put("old_did", t);     // Catch: JSONException -> L288
    L288:
        e = move-exception;
        e.printStackTrace();
    L280:
        th = move-exception;
        a(th);
        goto L282
    L309:
    L256:
        e = move-exception;
        e.printStackTrace();
        goto L258
    L251:
        if (com.ss.android.deviceregister.c.b.b(com.ss.android.deviceregister.g.i()) == false) goto L253;
    L254:
        r3.put("new_user_mode", 1);     // Catch: JSONException -> L256
        goto L258
    L253:
        if (com.ss.android.deviceregister.c.b.b(com.ss.android.deviceregister.g.h()) == false) goto L258;
    L222:
        if (com.bytedance.common.utility.j.a(r40) == true) goto L227;
        r3.put("app_track", new JSONObject(o));     // Catch: Throwable -> L225
    L216:
        r39.commit();     // Catch: Throwable -> L218
        goto L220
    L195:
        if (r35.equals(r33) == true) goto L197;
        r33 = r35;
        r38 = true;
    L218:
        th = move-exception;
        a(th);
    L172:
        th = move-exception;
        a(th);
        th.printStackTrace();
    L166:
        th = move-exception;
        a(th);
        th.printStackTrace();
        goto L311
    L145:
        if (ToolUtils.b() == false) goto L148;
        r30.append("MIUI-");     // Catch: Throwable -> L160
    L156:
        r30.append(Build.VERSION.INCREMENTAL);     // Catch: Throwable -> L160
        if (r30.length() <= 0) goto L326;
        String r53 = r30.toString();     // Catch: Throwable -> L160
        n = r53;     // Catch: Throwable -> L160
        r3.put("rom", r53);     // Catch: Throwable -> L160
        goto L326
    L148:
        if (ToolUtils.c() == false) goto L150;
        r30.append("FLYME-");     // Catch: Throwable -> L160
        goto L156
    L150:
        String r54 = ToolUtils.a();     // Catch: Throwable -> L160
        if (com.ss.android.deviceregister.c.e.a(r54) == false) goto L154;
        r30.append("EMUI-");     // Catch: Throwable -> L160
    L154:
        if (TextUtils.isEmpty(r54) == true) goto L156;
        r30.append(r54).append("-");     // Catch: Throwable -> L160
    L141:
        e = move-exception;
        a(e);
        e.printStackTrace();
        goto L143
    L118:
        if (i.isEmpty() == true) goto L127;
        Iterator<Map.Entry<String, Object>> r55 = i.entrySet().iterator();     // Catch: Exception -> L132
    L121:
        if (r55.hasNext() == false) goto L127;
        Map.Entry r56 = (Map.Entry) ZeusTransformUtils.preCheckCast(r55.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L132
        if (r56 == null) goto L121;
        r3.put((String) ZeusTransformUtils.preCheckCast(r56.getKey(), String.class, "com.obric.aiagent.plugin"), r56.getValue());     // Catch: Exception -> L132
    L127:
        if (j == false) goto L129;
        int r57 = 1;
    L130:
        r3.put("not_request_sender", r57);     // Catch: Exception -> L132
        goto L334
    L129:
        r57 = 0;
    L115:
        e = move-exception;
        a(e);
        e.printStackTrace();
        goto L319
    L90:
        if (r22 != 240) goto L92;
        r23 = "hdpi";
        goto L97
    L92:
        if (r22 == 320) goto L94;
        r23 = "mdpi";
        goto L97
    L94:
        r23 = "xhdpi";
    L99:
        e = move-exception;
        a(e);
        goto L101
    L64:
        if (f != 0) goto L68;
        com.ss.android.common.a r58 = f37401b;     // Catch: Exception -> L85
        if (r58 == null) goto L68;
        f = r58.i();     // Catch: Exception -> L85
    L68:
        r3.put(WsConstants.KEY_APP_ID, f);     // Catch: Exception -> L85
        int r59 = 0;
    L69:
        if (r59 >= 4) goto L77;
        String r60 = r20[r59];     // Catch: Exception -> L85
        String r61 = (String) ZeusTransformUtils.preCheckCast(r0.get(r60), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L85
        if (com.bytedance.common.utility.j.a(r61) == false) goto L75;
        com.ss.android.common.util.e.d("RegistrationHeaderHelper init fail empty field: " + r60);     // Catch: Exception -> L85
        if ("appkey".equals(r60) == true) goto L76;
        return false;
    L76:
        r59 = r59 + 1;     // Catch: Exception -> L85
        goto L69
    L75:
        r3.put(r60, r61);     // Catch: Exception -> L85
        goto L76
    L77:
        r3.put("version_code", f37404e);     // Catch: Exception -> L85
        r3.put("sdk_version", h);     // Catch: Exception -> L85
        r3.put("sdk_target_version", 29);     // Catch: Exception -> L85
        r3.put("git_hash", BuildConfig.GIT_HASH);     // Catch: Exception -> L85
        r3.put(RomInfo.KEY_OS_TYPE, "Android");     // Catch: Exception -> L85
        r3.put(RomInfo.KEY_ROM_OS_VERSION, Build.VERSION.RELEASE);     // Catch: Exception -> L85
        r3.put(RomInfo.KEY_ROM_OS_API, Build.VERSION.SDK_INT);     // Catch: Exception -> L85
        r3.put(HardwareInfo.KEY_HW_VENDOR_MODEL, Build.MODEL);     // Catch: Exception -> L85
        r3.put(HardwareInfo.KEY_HW_VENDOR_BRAND, Build.BRAND);     // Catch: Exception -> L85
        r3.put(HardwareInfo.KEY_HW_VENDOR_MANUFACTURER, Build.MANUFACTURER);     // Catch: Exception -> L85
        if (u == null) goto L80;
        r3.put("device_category", u.a());     // Catch: Exception -> L85
    L80:
        r3.put(HardwareInfo.KEY_HW_CPU_ABI, Build.CPU_ABI);     // Catch: Exception -> L85
        String r62 = g;     // Catch: Exception -> L85
        if (r62 != null) goto L83;
        r62 = "";
    L83:
        r3.put("release_build", r62);     // Catch: Exception -> L85
        goto L328
    L35:
        r0.put("package", r16.getPackageName());     // Catch: Exception -> L298
    L20:
        if (r6 == null) goto L25;
        if (TextUtils.isEmpty("UMENG_CHANNEL") == true) goto L25;
        r0.put("channel", f.a(r6));     // Catch: Exception -> L30
    L30:
        e = move-exception;
        a(e);     // Catch: Exception -> L298
        e.printStackTrace();     // Catch: Exception -> L298
    L298:
        e = move-exception;
        com.ss.android.common.util.e.e("RegistrationHeaderHelper init exception: ", e);
        a(e);
        return false;
    L7:
        if (w != r15) goto L11;
        a(k, r14);     // Catch: Throwable -> L301
        monitor-exit(r1);     // Catch: Throwable -> L301
        return true;
    }

    private static void a(Throwable r4) {
        com.ss.android.common.a r0 = f37401b;
        if (r0 != null) goto L5;
        return;
    L5:
        j r1 = r;
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L19;
        if (r1 == null) goto L20;
        String r5 = Log.getStackTraceString(r4);
        if (com.bytedance.common.utility.j.a(r5) == true) goto L21;
        JSONObject r3 = new JSONObject();
        r3.put("stack", r5);     // Catch: JSONException -> L13
    L15:
        r1.a("device_register", r3);
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L21:
        return;
    L20:
        return;
    }

    private static void a(Context r2, JSONObject r3) {
        String r4 = a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"));
        if (r4 == null) goto L11;
        r3.put("sig_hash", r4);     // Catch: JSONException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static String a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (com.bytedance.common.utility.j.a(l) == false) goto L22;
        if (r3 == null) goto L22;
        PackageInfo r4 = r3.getPackageManager().getPackageInfo(r3.getPackageName(), 64);     // Catch: Exception -> L19
        if (r4 == null) goto L18;
        if (r4.signatures == null) goto L18;
        if (r4.signatures.length < 1) goto L18;
        Signature r5 = r4.signatures[0];     // Catch: Exception -> L19
        if (r5 == null) goto L15;
        l = com.bytedance.common.utility.d.b(r5.toByteArray());     // Catch: Exception -> L19
        goto L22
    L15:
        return l;
    L18:
        return l;
    L19:
        e = move-exception;
        com.ss.android.common.util.e.e("RegistrationHeaderHelperfailed to inst package sianature: ", e);
    L22:
        return l;
    }

    public static void a(JSONObject r4, JSONObject r5) {
        Iterator<String> r0 = r4.keys();
    L4:
        if (r0.hasNext() == false) goto L10;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");
        r5.put(r1, r4.opt(r1));     // Catch: JSONException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L4
    }

    public static int b() {
        if (f > 0) goto L8;
        com.ss.android.common.a r0 = f37401b;
        if (r0 == null) goto L8;
        r0.i();
    L8:
        return f;
    }

    public static int c() {
        if (f37404e > 0) goto L8;
        com.ss.android.common.a r0 = f37401b;
        if (r0 == null) goto L8;
        f37404e = r0.e();
    L8:
        return f37404e;
    }

    public static String b(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (com.bytedance.common.utility.j.a(m) == false) goto L6;
        m = b.a(r3).getString("user_agent", null);
    L6:
        return m;
    }

    public static void a(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (com.bytedance.common.utility.j.a(r3) == false) goto L5;
        return;
    L5:
        if (r3.equals(m) == true) goto L9;
        m = r3;
        SharedPreferences.Editor r5 = b.a(r4).edit();
        r5.putString("user_agent", r3);
        r5.commit();
        return;
    }

    public static String d() {
        return f37400a;
    }

    public static String c(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(f37400a) == false) goto L5;
        com.ss.android.common.a r0 = f37401b;
        if (r0 != null) goto L9;
        Bundle r4 = r3.getPackageManager().getApplicationInfo(r3.getPackageName(), 128).metaData;     // Catch: Throwable -> L14
        if (r4 == null) goto L20;
        f37400a = f.a(r4);     // Catch: Throwable -> L14
        return null;
    L20:
        return null;
    L14:
        th = move-exception;
        th.printStackTrace();
        return null;
    L9:
        return r0.d();
    L5:
        return f37400a;
    }

    public static String e() {
        if (TextUtils.isEmpty(f37402c) == false) goto L8;
        com.ss.android.common.a r0 = f37401b;
        if (r0 == null) goto L8;
        f37402c = r0.b();
    L8:
        return f37402c;
    }

    public static void a(com.ss.android.deviceregister.a.d r0) {
        q = r0;
    }

    public static void a(j r2) {
        r = (j) ZeusTransformUtils.wrapperContextForParams(r2, j.class, "com.obric.aiagent.plugin");
    }

    public static void a(boolean r1) {
        s = r1;
        if (k == null) goto L12;
        Object r2 = p;
        monitor-enter(r2);
        a(k);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static boolean f() {
        return !s;
    }

    public static void a(JSONObject r0) {
        f.a(r0);
    }

    public static void a(String r0) {
        h = r0;
    }

    public static void b(String r0) {
        t = r0;
    }

    public static void g() {
        k = null;
    }

    public static void a(String r3, String r4) {
        Object r0 = p;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (k != null) goto L15;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L15:
        k.put("device_id", r3);     // Catch: JSONException -> L8 Throwable -> L12
        k.put("install_id", r4);     // Catch: JSONException -> L8 Throwable -> L12
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L12
        goto L10
    }

    public static boolean h() {
        return x;
    }
}
