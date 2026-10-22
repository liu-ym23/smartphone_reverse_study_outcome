package com.baidu.lbsapi.auth;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mapapi.http.wrapper.annotation.BodyData;
import com.baidu.mshield.x6.EngineImpl;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.stepos.activeview.utils.Constants;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.UUID;
import javax.crypto.NoSuchPaddingException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class LBSAuthManager {
    public static final int CODE_AUTHENTICATE_SUCC = 0;
    public static final int CODE_AUTHENTICATING = 602;
    public static final int CODE_INNER_ERROR = -1;
    public static final int CODE_KEY_NOT_EXIST = 101;
    public static final int CODE_NETWORK_FAILED = -11;
    public static final int CODE_NETWORK_INVALID = -10;
    public static final int CODE_UNAUTHENTICATE = 601;
    public static final String VERSION = "1.0.31";

    /* renamed from: a, reason: collision with root package name */
    private static Context f4900a = null;

    /* renamed from: b, reason: collision with root package name */
    private static String f4901b = null;

    /* renamed from: c, reason: collision with root package name */
    private static int f4902c = -1;

    /* renamed from: d, reason: collision with root package name */
    private static String f4903d;

    /* renamed from: e, reason: collision with root package name */
    private static String f4904e;

    /* renamed from: h, reason: collision with root package name */
    private static p f4905h;

    /* renamed from: i, reason: collision with root package name */
    private static int f4906i;

    /* renamed from: k, reason: collision with root package name */
    private static LBSAuthManager f4908k;

    /* renamed from: m, reason: collision with root package name */
    private byte[] f4917m;

    /* renamed from: j, reason: collision with root package name */
    private static Hashtable f4907j = new Hashtable();

    /* renamed from: n, reason: collision with root package name */
    private static String f4909n = "";

    /* renamed from: o, reason: collision with root package name */
    private static String f4910o = "";

    /* renamed from: p, reason: collision with root package name */
    private static String f4911p = "";

    /* renamed from: q, reason: collision with root package name */
    private static boolean f4912q = false;

    /* renamed from: r, reason: collision with root package name */
    private static String f4913r = null;

    /* renamed from: f, reason: collision with root package name */
    private e f4914f = null;

    /* renamed from: g, reason: collision with root package name */
    private g f4915g = null;

    /* renamed from: l, reason: collision with root package name */
    private boolean f4916l = false;

    /* renamed from: s, reason: collision with root package name */
    private final Handler f4918s = new l(this, Looper.getMainLooper());

    private LBSAuthManager(Context context) {
        f4900a = context;
        p pVar = f4905h;
        if (pVar != null && !pVar.isAlive()) {
            f4905h = null;
        }
        b.b("BaiduApiAuth SDK Version:1.0.31");
        h();
    }

    private int a(String str) throws JSONException {
        JSONObject jSONObject;
        int i4 = -1;
        try {
            jSONObject = new JSONObject(str);
            if (!jSONObject.has("status")) {
                jSONObject.put("status", -1);
            }
            i4 = jSONObject.getInt("status");
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        if (jSONObject.has("current") && i4 == 0) {
            long j4 = jSONObject.getLong("current");
            long jCurrentTimeMillis = System.currentTimeMillis();
            if ((jCurrentTimeMillis - j4) / 3600000.0d >= 24.0d) {
                i4 = 601;
            } else if (this.f4916l) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                if (!simpleDateFormat.format(Long.valueOf(jCurrentTimeMillis)).equals(simpleDateFormat.format(Long.valueOf(j4)))) {
                    i4 = 601;
                }
            }
            return i4;
        }
        if (jSONObject.has("current") && i4 == 602) {
            if ((System.currentTimeMillis() - jSONObject.getLong("current")) / 1000 > 180.0d) {
                return 601;
            }
        }
        return i4;
    }

    public static LBSAuthManager getInstance(Context context) {
        if (f4908k == null) {
            synchronized (LBSAuthManager.class) {
                try {
                    if (f4908k == null) {
                        f4908k = new LBSAuthManager(context);
                    }
                } finally {
                }
            }
        } else if (context != null) {
            f4900a = context;
        } else if (b.f4919a) {
            b.c("input context is null");
            new RuntimeException("here").printStackTrace();
        }
        return f4908k;
    }

    private void h() {
        synchronized (LBSAuthManager.class) {
            if (f4905h == null) {
                p pVar = new p("auth");
                f4905h = pVar;
                pVar.start();
                while (f4905h.f4961a == null) {
                    try {
                        b.a("wait for create auth thread.");
                        Thread.sleep(3L);
                    } catch (InterruptedException e4) {
                        e4.printStackTrace();
                    }
                }
            }
        }
    }

    public int authenticate(boolean z4, String str, Hashtable hashtable, LBSAuthManagerListener lBSAuthManagerListener) {
        synchronized (LBSAuthManager.class) {
            boolean z5 = false;
            if (hashtable != null) {
                try {
                    String str2 = (String) hashtable.get("zero_auth");
                    if (str2 != null && Integer.valueOf(str2).intValue() == 1) {
                        z5 = true;
                    }
                } finally {
                }
            }
            this.f4916l = z5;
            String str3 = System.currentTimeMillis() + "";
            if (lBSAuthManagerListener != null) {
                f4907j.put(str3, lBSAuthManagerListener);
            }
            String strA = a(f4900a, str3);
            if (strA != null && !strA.equals("")) {
                f4906i++;
                b.a(" mAuthCounter  ++ = " + f4906i);
                String strC = c(str);
                b.a("getAuthMessage from cache:" + strC);
                int iA = a(strC);
                if (iA == 601) {
                    try {
                        b(str, new JSONObject().put("status", 602).toString());
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                    }
                }
                h();
                p pVar = f4905h;
                if (pVar != null && pVar.f4961a != null) {
                    b.a("mThreadLooper.mHandler = " + f4905h.f4961a);
                    f4905h.f4961a.post(new m(this, iA, z4, str, str3, hashtable));
                    return iA;
                }
                return -1;
            }
            return 101;
        }
    }

    public String decodeAESMessage(String str) {
        byte[] bArr;
        if (str != null && str.length() > 0 && (bArr = this.f4917m) != null && bArr.length > 0) {
            try {
                Charset charset = StandardCharsets.UTF_8;
                byte[] bArrA = c.a(str.getBytes(charset));
                byte[] bArr2 = this.f4917m;
                return new String(a.a(bArr2, bArr2, bArrA), charset);
            } catch (Exception e4) {
                Log.e("LBSAuthManager", "decodeAESMessage", e4);
            }
        }
        return null;
    }

    public String getCUID() {
        if (!TextUtils.isEmpty(f4913r)) {
            return f4913r;
        }
        if (f4900a == null) {
            return "";
        }
        try {
            b.a("mIsPrivacyMode " + f4912q);
            if (f4912q) {
                com.baidu.a.a.a.a.a.a(!TextUtils.isEmpty(f4910o) ? f4910o : Settings.Secure.getString(f4900a.getContentResolver(), "android_id"));
                String strA = com.baidu.a.a.a.a.a.a(f4900a);
                f4913r = strA;
                b.a("getCUID: " + strA);
                return strA;
            }
            SharedPreferences sharedPreferences = f4900a.getSharedPreferences("Map_Privacy", 0);
            if (sharedPreferences.contains(EngineImpl.KEY_CUID)) {
                return sharedPreferences.getString(EngineImpl.KEY_CUID, "");
            }
            String str = q.a(UUID.randomUUID().toString().getBytes(), true) + "|MAPSDK001";
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString(EngineImpl.KEY_CUID, str);
            editorEdit.apply();
            return str;
        } catch (Exception e4) {
            e4.printStackTrace();
            return "";
        }
    }

    public String getKey() {
        Context context = f4900a;
        if (context == null) {
            return "";
        }
        try {
            return getPublicKey(context);
        } catch (PackageManager.NameNotFoundException e4) {
            e4.printStackTrace();
            return "";
        }
    }

    public String getMCode() {
        Context context = f4900a;
        return context == null ? "" : d.a(context);
    }

    public boolean getPrivacyMode() {
        return f4912q;
    }

    public String getPublicKey(Context context) throws PackageManager.NameNotFoundException {
        if (!TextUtils.isEmpty(f4909n)) {
            return f4909n;
        }
        return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("com.baidu.lbsapi.API_KEY");
    }

    public void setAndroidId(String str) {
        if (f4900a == null || TextUtils.isEmpty(str)) {
            return;
        }
        f4910o = str;
    }

    public void setHttpProxyUsernameAndPassword(String str, String str2) {
        f4903d = str;
        f4904e = str2;
    }

    public void setKey(String str) {
        if (f4900a == null || TextUtils.isEmpty(str)) {
            return;
        }
        f4909n = str;
    }

    public void setPackageName(String str) {
        f4911p = str;
    }

    public void setPrivacyMode(boolean z4) {
        Context context = f4900a;
        if (context == null) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("Map_Privacy", 0);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (!z4) {
            f4912q = sharedPreferences.getBoolean("privacyMode", false);
            return;
        }
        editorEdit.putBoolean("privacyMode", z4);
        editorEdit.apply();
        f4912q = z4;
    }

    public void setProxy(String str, int i4) {
        f4901b = str;
        f4902c = i4;
    }

    private String a(int i4) throws IOException {
        FileInputStream fileInputStream;
        byte[] bArr;
        int i5;
        try {
            try {
                fileInputStream = new FileInputStream("/proc/" + i4 + "/cmdline");
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            bArr = new byte[256];
            i5 = 0;
            while (true) {
                int i6 = fileInputStream.read();
                if (i6 <= 0 || i5 >= 256) {
                    break;
                }
                bArr[i5] = (byte) i6;
                i5++;
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                th.printStackTrace();
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return null;
            } catch (Throwable th3) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th3;
            }
        }
        if (i5 <= 0) {
            fileInputStream.close();
            return null;
        }
        String str = new String(bArr, 0, i5, Constants.UTF_8_CODE);
        try {
            fileInputStream.close();
        } catch (IOException e6) {
            e6.printStackTrace();
        }
        return str;
    }

    private String b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(c(str));
            return !jSONObject.has("extend") ? "" : jSONObject.getString("extend");
        } catch (JSONException unused) {
            return "";
        }
    }

    private String c(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "status";
        }
        return f4900a.getSharedPreferences("authStatus_" + a(f4900a), 0).getString(str, "{\"status\":601}");
    }

    private String a(Context context) {
        return Application.getProcessName();
    }

    private void b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "status";
        }
        f4900a.getSharedPreferences("authStatus_" + a(f4900a), 0).edit().putString(str, str2).apply();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0052 A[Catch: NameNotFoundException -> 0x0046, TRY_LEAVE, TryCatch #0 {NameNotFoundException -> 0x0046, blocks: (B:14:0x003f, B:18:0x0048, B:20:0x0052), top: B:27:0x003f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String a(android.content.Context r5, java.lang.String r6) {
        /*
            r4 = this;
            java.lang.String r4 = "无法在AndroidManifest.xml中获取com.baidu.android.lbs.API_KEY的值"
            java.lang.String r0 = ""
            java.lang.String r1 = com.baidu.lbsapi.auth.LBSAuthManager.f4909n
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto Lf
            java.lang.String r4 = com.baidu.lbsapi.auth.LBSAuthManager.f4909n
            return r4
        Lf:
            java.lang.String r1 = r5.getPackageName()
            r2 = 101(0x65, float:1.42E-43)
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L5b
            r3 = 128(0x80, float:1.8E-43)
            android.content.pm.ApplicationInfo r5 = r5.getApplicationInfo(r1, r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L5b
            android.os.Bundle r5 = r5.metaData     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L5b
            if (r5 != 0) goto L37
            java.util.Hashtable r5 = com.baidu.lbsapi.auth.LBSAuthManager.f4907j     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L5b
            java.lang.Object r5 = r5.get(r6)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L5b
            com.baidu.lbsapi.auth.LBSAuthManagerListener r5 = (com.baidu.lbsapi.auth.LBSAuthManagerListener) r5     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L5b
            if (r5 == 0) goto L6c
            java.lang.String r1 = "AndroidManifest.xml的application中没有meta-data标签"
            java.lang.String r1 = com.baidu.lbsapi.auth.ErrorMessage.a(r2, r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L5b
            r5.onAuthResult(r2, r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L5b
            goto L6c
        L37:
            java.lang.String r1 = "com.baidu.lbsapi.API_KEY"
            java.lang.String r5 = r5.getString(r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L5b
            if (r5 == 0) goto L48
            boolean r0 = r5.equals(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L46
            if (r0 == 0) goto L59
            goto L48
        L46:
            r0 = r5
            goto L5b
        L48:
            java.util.Hashtable r0 = com.baidu.lbsapi.auth.LBSAuthManager.f4907j     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L46
            java.lang.Object r0 = r0.get(r6)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L46
            com.baidu.lbsapi.auth.LBSAuthManagerListener r0 = (com.baidu.lbsapi.auth.LBSAuthManagerListener) r0     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L46
            if (r0 == 0) goto L59
            java.lang.String r1 = com.baidu.lbsapi.auth.ErrorMessage.a(r2, r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L46
            r0.onAuthResult(r2, r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L46
        L59:
            r0 = r5
            goto L6c
        L5b:
            java.util.Hashtable r5 = com.baidu.lbsapi.auth.LBSAuthManager.f4907j
            java.lang.Object r5 = r5.get(r6)
            com.baidu.lbsapi.auth.LBSAuthManagerListener r5 = (com.baidu.lbsapi.auth.LBSAuthManagerListener) r5
            if (r5 == 0) goto L6c
            java.lang.String r4 = com.baidu.lbsapi.auth.ErrorMessage.a(r2, r4)
            r5.onAuthResult(r2, r4)
        L6c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.lbsapi.auth.LBSAuthManager.a(android.content.Context, java.lang.String):java.lang.String");
    }

    private void b(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        if (jSONObject.has("ck")) {
            jSONObject.remove("ck");
        }
        if (jSONObject.has("en")) {
            jSONObject.remove("en");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3) {
        p pVar;
        synchronized (LBSAuthManager.class) {
            if (str2 == null) {
                try {
                    str2 = c(str);
                } catch (Throwable th) {
                    throw th;
                }
            }
            Message messageObtainMessage = this.f4918s.obtainMessage();
            int i4 = -1;
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (!jSONObject.has("status")) {
                    jSONObject.put("status", -1);
                }
                if (!jSONObject.has("current")) {
                    jSONObject.put("current", System.currentTimeMillis());
                }
                b(str, jSONObject.toString());
                if (jSONObject.has("current")) {
                    jSONObject.remove("current");
                }
                i4 = jSONObject.getInt("status");
                messageObtainMessage.what = i4;
                messageObtainMessage.obj = jSONObject;
                Bundle bundle = new Bundle();
                bundle.putString("listenerKey", str3);
                messageObtainMessage.setData(bundle);
                this.f4918s.sendMessage(messageObtainMessage);
            } catch (JSONException e4) {
                e4.printStackTrace();
                messageObtainMessage.what = i4;
                messageObtainMessage.obj = new JSONObject();
                Bundle bundle2 = new Bundle();
                bundle2.putString("listenerKey", str3);
                messageObtainMessage.setData(bundle2);
                this.f4918s.sendMessage(messageObtainMessage);
            }
            p pVar2 = f4905h;
            if (pVar2 != null) {
                pVar2.c();
            }
            f4906i--;
            b.a("httpRequest called mAuthCounter-- = " + f4906i);
            if (f4906i == 0 && (pVar = f4905h) != null) {
                pVar.a();
                f4905h = null;
            }
        }
    }

    private void a(HashMap map, String str, String str2) {
        if (map == null || map.size() <= 0 || str == null || str.length() <= 0 || str2 == null || str2.length() <= 0) {
            return;
        }
        try {
            String strA = r.a(str2);
            if (strA == null || strA.length() <= 0) {
                map.put(str, str2);
            } else {
                map.put(str, strA);
            }
        } catch (Exception e4) {
            map.put(str, str2);
            Log.e("LBSAuthManager", "encodeAuthParam", e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null || jSONObject.length() <= 0 || !jSONObject.has("en")) {
            return;
        }
        if (jSONObject.optInt("en", 0) == 0) {
            if (jSONObject.optString("ck").length() > 0) {
                this.f4917m = c.a(jSONObject.optString("ck").getBytes(StandardCharsets.UTF_8));
            }
        } else {
            a(jSONObject, "ak");
            a(jSONObject, "ck");
            a(jSONObject, "sk");
            a(jSONObject, "uid");
            b(jSONObject);
        }
    }

    private void a(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject == null || jSONObject.length() <= 0 || str == null || str.length() <= 0 || !jSONObject.has(str)) {
            return;
        }
        try {
            byte[] bArrB = r.b(jSONObject.optString(str));
            if (bArrB != null && bArrB.length > 0) {
                jSONObject.put(str, new String(bArrB, StandardCharsets.UTF_8));
                if ("ck".equals(str)) {
                    this.f4917m = bArrB;
                    return;
                }
                return;
            }
            jSONObject.put(str, "");
            jSONObject.put("decode_status", -1);
        } catch (Exception e4) {
            Log.e("LBSAuthManager", " decodeAuthResult ", e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z4, String str, Hashtable hashtable, String str2, String str3, int i4, String str4, String str5) throws NoSuchAlgorithmException {
        String strA;
        String strA2 = a(f4900a, str2);
        if (strA2 == null || strA2.equals("")) {
            return;
        }
        HashMap map = new HashMap();
        r.a();
        map.put("pk", r.b() != null ? r.b() : "");
        map.put(MapBundleKey.MapObjKey.OBJ_URL, "https://api.map.baidu.com/sdkcs/verify");
        b.a("url:https://api.map.baidu.com/sdkcs/verify");
        map.put("output", BodyData.TYPE_JSON);
        a(map, "ak", strA2);
        b.a("ak:" + ((String) map.get("ak")));
        a(map, "mcode", d.a(f4900a));
        map.put("from", "lbs_yunsdk");
        if (hashtable != null && hashtable.size() > 0) {
            for (Map.Entry entry : hashtable.entrySet()) {
                String str6 = (String) entry.getKey();
                String str7 = (String) entry.getValue();
                if (!TextUtils.isEmpty(str6) && !TextUtils.isEmpty(str7)) {
                    map.put(str6, str7);
                }
            }
        }
        String cuid = !TextUtils.isEmpty(f4910o) ? getCUID() : f4913r;
        b.a("cuid:" + f4913r);
        if (TextUtils.isEmpty(cuid)) {
            map.put(EngineImpl.KEY_CUID, "");
        } else {
            map.put(EngineImpl.KEY_CUID, cuid);
        }
        map.put("pcn", f4900a.getPackageName());
        map.put(Constants.JSON_KEY_VERSION, VERSION);
        map.put("macaddr", "");
        try {
            strA = d.a();
        } catch (Exception unused) {
            strA = "";
        }
        if (TextUtils.isEmpty(strA)) {
            map.put("language", "");
        } else {
            map.put("language", strA);
        }
        if (z4) {
            map.put("force", z4 ? "1" : "0");
        }
        if (str == null) {
            map.put("from_service", "");
        } else {
            map.put("from_service", str);
        }
        String strB = b(str);
        if (!TextUtils.isEmpty(strB)) {
            map.put("extend", strB);
        }
        e eVar = new e(f4900a);
        this.f4914f = eVar;
        eVar.a(map, str3, i4, str4, str5, new n(this, str, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z4, String str, Hashtable hashtable, String[] strArr, String str2, String str3, int i4, String str4, String str5) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        String strA;
        String strA2 = a(f4900a, str2);
        if (strA2 == null || strA2.equals("")) {
            return;
        }
        HashMap map = new HashMap();
        r.a();
        map.put("pk", r.b() != null ? r.b() : "");
        map.put(MapBundleKey.MapObjKey.OBJ_URL, "https://api.map.baidu.com/sdkcs/verify");
        map.put("output", BodyData.TYPE_JSON);
        a(map, "ak", strA2);
        map.put("from", "lbs_yunsdk");
        if (hashtable != null && hashtable.size() > 0) {
            for (Map.Entry entry : hashtable.entrySet()) {
                String str6 = (String) entry.getKey();
                String str7 = (String) entry.getValue();
                if (!TextUtils.isEmpty(str6) && !TextUtils.isEmpty(str7)) {
                    map.put(str6, str7);
                }
            }
        }
        String cuid = !TextUtils.isEmpty(f4910o) ? getCUID() : f4913r;
        b.a(B0.g.m("sendAuthRequests : cuid: ", cuid));
        if (TextUtils.isEmpty(cuid)) {
            map.put(EngineImpl.KEY_CUID, "");
        } else {
            map.put(EngineImpl.KEY_CUID, cuid);
        }
        map.put("pcn", f4900a.getPackageName());
        map.put(Constants.JSON_KEY_VERSION, VERSION);
        map.put("macaddr", "");
        try {
            strA = d.a();
        } catch (Exception unused) {
            strA = "";
        }
        if (TextUtils.isEmpty(strA)) {
            map.put("language", "");
        } else {
            map.put("language", strA);
        }
        if (z4) {
            map.put("force", z4 ? "1" : "0");
        }
        if (str == null) {
            map.put("from_service", "");
        } else {
            map.put("from_service", str);
        }
        String strB = b(str);
        if (!TextUtils.isEmpty(strB)) {
            map.put("extend", strB);
        }
        String[] strArr2 = new String[strArr.length];
        for (int i5 = 0; i5 < strArr.length; i5++) {
            String strA3 = r.a(strArr[i5]);
            if (strA3 == null || strA3.length() <= 0) {
                strArr2[i5] = strArr[i5];
            } else {
                strArr2[i5] = strA3;
            }
        }
        g gVar = new g(f4900a);
        this.f4915g = gVar;
        gVar.a(map, strArr2, str3, i4, str4, str5, new o(this, str, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, String str2) throws JSONException {
        String string;
        JSONObject jSONObject;
        String strA = a(f4900a, str2);
        try {
            jSONObject = new JSONObject(c(str));
        } catch (JSONException e4) {
            e4.printStackTrace();
            string = "";
        }
        if (!jSONObject.has("ak")) {
            return true;
        }
        if (jSONObject.has("en") && jSONObject.getInt("en") == 1) {
            a(jSONObject, "ak");
        }
        string = jSONObject.getString("ak");
        return (strA == null || string == null || strA.equals(string)) ? false : true;
    }
}
