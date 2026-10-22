package com.stepos.core.ota.push;

import ad.j;
import ad.n;
import ad.t;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import com.stepos.core.common.device.OaidResolver;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.deepbinder.annotation.BaseConstantsKt;
import gc.q;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import kotlin.Result;
import kotlin.b;
import kotlin.c;
import kotlin.jvm.internal.g;
import lb.d;
import okhttp3.Response;
import okhttp3.h;
import okhttp3.logging.HttpLoggingInterceptor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaPushSubscribeClient {
    private static final int ENCRYPT_ENABLED = 1;
    private static final String NON_STEPOS_MODEL = "NON_STEPOS";
    private static final String PATH = "/subscription/registerWithSign";
    private static final String PROD_HOST = "https://upush.stepaos.com";
    private static final String SIGN_KEY = "5bdbbf945b54ca9cea8aa3212286bb4f";
    private static final int SUB_STATUS_ACTIVE = 1;
    private static final String TAG = "OtaPushSubscribe";
    private static final String TEST_HOST = "https://upush.t-stepos.com";
    private static volatile String cachedDeviceModel;
    public static final OtaPushSubscribeClient INSTANCE = new OtaPushSubscribeClient();
    private static final d httpClient$delegate = b.b(new a9.a(25));

    private OtaPushSubscribeClient() {
    }

    private final String androidVersion() {
        String str = Build.VERSION.RELEASE;
        if (str == null) {
            str = "";
        }
        return str.equals("Q") ? "10" : str.equals("R") ? "11" : str;
    }

    private final String baseUrl(Context context) {
        return isTestEnv(context) ? TEST_HOST : PROD_HOST;
    }

    private final String buildSubservicesJson(Context context) throws JSONException {
        Object objA;
        try {
            objA = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.e(LogModule.OTA, TAG, "subservices skipped: packageInfo unavailable", thB);
            return null;
        }
        PackageInfo packageInfo = (PackageInfo) objA;
        String str = packageInfo.versionName;
        int i10 = packageInfo.versionCode;
        if (str == null || q.t0(str) || i10 <= 0) {
            AIEngineLogger.e(LogModule.OTA, TAG, "subservices skipped: invalid versionName/versionCode");
            return null;
        }
        String strDeviceModel = deviceModel(context);
        String strAndroidVersion = androidVersion();
        String strSystemVersion = systemVersion();
        String str2 = Build.DISPLAY;
        if (str2 == null) {
            str2 = "";
        }
        if (q.t0(strDeviceModel) || q.t0(strAndroidVersion) || q.t0(strSystemVersion)) {
            AIEngineLogger.e(LogModule.OTA, TAG, "subservices skipped: deviceType/firmware/sysVer empty");
            return null;
        }
        String str3 = OaidResolver.INSTANCE.get(context);
        return new JSONObject().put("deviceType", strDeviceModel).put("firmware", strAndroidVersion).put("sysVer", strSystemVersion).put("displayId", str2).put("oaidV2", str3).put("services", new JSONArray().put(new JSONObject().put(BaseConstantsKt.KEY_SERVICE_NAME, context.getPackageName()).put("subStatus", 1).put("version", str).put("versionCode", i10).put("serviceToken", ""))).put("encrypt", 1).toString();
    }

    private final String deviceModel(Context context) {
        String strSystemProperty;
        if (isSystemIndependent(context)) {
            return NON_STEPOS_MODEL;
        }
        String str = cachedDeviceModel;
        if (str != null && !q.t0(str) && !str.equalsIgnoreCase("unknown")) {
            return str;
        }
        if (isStepOsAssociatedProduct()) {
            strSystemProperty = systemProperty("ro.vendor.stepos.product.model");
            if (strSystemProperty == null || q.t0(strSystemProperty) || strSystemProperty.equalsIgnoreCase("unknown")) {
                strSystemProperty = systemProperty("ro.product.model");
            }
            if (strSystemProperty == null || q.t0(strSystemProperty) || strSystemProperty.equalsIgnoreCase("unknown")) {
                strSystemProperty = reflectStaticString("android.os.BuildExt", "STEPOS_MODEL");
            }
        } else {
            strSystemProperty = null;
        }
        if (strSystemProperty == null || q.t0(strSystemProperty) || strSystemProperty.equalsIgnoreCase("unknown")) {
            String strSystemProperty2 = systemProperty("ro.stepos.product.model");
            if (strSystemProperty2 == null && (strSystemProperty2 = Build.MODEL) == null) {
                strSystemProperty2 = "";
            }
            strSystemProperty = strSystemProperty2;
        }
        cachedDeviceModel = strSystemProperty;
        return strSystemProperty;
    }

    private final n getHttpClient() {
        return (n) httpClient$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n httpClient_delegate$lambda$1() {
        n.a aVar = new n.a();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(0);
        httpLoggingInterceptor.f11305d = HttpLoggingInterceptor.Level.f11307b;
        aVar.a(httpLoggingInterceptor);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        aVar.b(5L, timeUnit);
        aVar.c(10L, timeUnit);
        return new n(aVar);
    }

    private final boolean isStepOsAssociatedProduct() {
        Object objA;
        Boolean bool;
        try {
            Object objInvoke = Class.forName("android.os.BuildExt").getMethod("isStepOSProduct", null).invoke(null, null);
            bool = objInvoke instanceof Boolean ? (Boolean) objInvoke : null;
        } catch (Throwable th) {
            objA = c.a(th);
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        Object objInvoke2 = Class.forName("android.os.BuildExt").getMethod("isStepOSRom", null).invoke(null, null);
        if ((objInvoke2 instanceof Boolean ? (Boolean) objInvoke2 : null) != null) {
            return !r2.booleanValue();
        }
        objA = Boolean.FALSE;
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        return ((Boolean) objA).booleanValue();
    }

    private final boolean isSystemIndependent(Context context) {
        Object objA;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), TraceIdKeys.MAX_LENGTH);
            g.e(applicationInfo, "getApplicationInfo(...)");
            Bundle bundle = applicationInfo.metaData;
            boolean z = false;
            if (bundle != null && bundle.getBoolean("system_independent", false)) {
                z = true;
            }
            objA = Boolean.valueOf(z);
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        return ((Boolean) objA).booleanValue();
    }

    private final boolean isTestEnv(Context context) {
        Object objA;
        try {
            objA = Boolean.valueOf(g.b(Settings.Secure.getString(context.getContentResolver(), "net_env"), "test"));
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        return ((Boolean) objA).booleanValue();
    }

    private final String md5Hex(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] bytes = str.getBytes(gc.a.f9106b);
        g.e(bytes, "getBytes(...)");
        byte[] bArrDigest = messageDigest.digest(bytes);
        g.e(bArrDigest, "digest(...)");
        StringBuilder sb2 = new StringBuilder();
        sb2.append((CharSequence) "");
        int i10 = 0;
        for (byte b10 : bArrDigest) {
            i10++;
            if (i10 > 1) {
                sb2.append((CharSequence) "");
            }
            sb2.append(md5Hex$lambda$13(b10));
        }
        sb2.append((CharSequence) "");
        return sb2.toString();
    }

    private static final CharSequence md5Hex$lambda$13(byte b10) {
        return String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b10)}, 1));
    }

    private final boolean parseSuccess(String str) {
        Object objA;
        try {
            objA = new JSONObject(str).getJSONObject("reply");
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.e(LogModule.OTA, TAG, "parse response failed", thB);
            return false;
        }
        JSONObject jSONObject = (JSONObject) objA;
        int iOptInt = jSONObject.optInt("code", -1);
        if (iOptInt == 200) {
            AIEngineLogger.i(LogModule.OTA, TAG, "subscribe ok");
            return true;
        }
        AIEngineLogger.e(LogModule.OTA, TAG, a0.a.g("subscribe failed: reply.code=", iOptInt, " message=", jSONObject.optString("message")));
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String reflectStaticString(java.lang.String r1, java.lang.String r2) {
        /*
            r0 = this;
            r0 = 0
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Throwable -> L1e
            java.lang.reflect.Field r1 = r1.getField(r2)     // Catch: java.lang.Throwable -> L1e
            java.lang.Object r1 = r1.get(r0)     // Catch: java.lang.Throwable -> L1e
            if (r1 == 0) goto L1c
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L1e
            if (r1 == 0) goto L1c
            boolean r2 = gc.q.t0(r1)     // Catch: java.lang.Throwable -> L1e
            if (r2 != 0) goto L1c
            goto L23
        L1c:
            r1 = r0
            goto L23
        L1e:
            r1 = move-exception
            kotlin.Result$Failure r1 = kotlin.c.a(r1)
        L23:
            boolean r2 = r1 instanceof kotlin.Result.Failure
            if (r2 == 0) goto L28
            goto L29
        L28:
            r0 = r1
        L29:
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.push.OtaPushSubscribeClient.reflectStaticString(java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String systemProperty(java.lang.String r4) {
        /*
            r3 = this;
            r3 = 0
            java.lang.String r0 = "android.os.SystemProperties"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.Throwable -> L2c
            java.lang.String r1 = "get"
            java.lang.Class<java.lang.String> r2 = java.lang.String.class
            java.lang.Class[] r2 = new java.lang.Class[]{r2}     // Catch: java.lang.Throwable -> L2c
            java.lang.reflect.Method r0 = r0.getMethod(r1, r2)     // Catch: java.lang.Throwable -> L2c
            java.lang.Object[] r4 = new java.lang.Object[]{r4}     // Catch: java.lang.Throwable -> L2c
            java.lang.Object r4 = r0.invoke(r3, r4)     // Catch: java.lang.Throwable -> L2c
            if (r4 == 0) goto L2a
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L2c
            if (r4 == 0) goto L2a
            boolean r0 = gc.q.t0(r4)     // Catch: java.lang.Throwable -> L2c
            if (r0 != 0) goto L2a
            goto L31
        L2a:
            r4 = r3
            goto L31
        L2c:
            r4 = move-exception
            kotlin.Result$Failure r4 = kotlin.c.a(r4)
        L31:
            boolean r0 = r4 instanceof kotlin.Result.Failure
            if (r0 == 0) goto L36
            goto L37
        L36:
            r3 = r4
        L37:
            java.lang.String r3 = (java.lang.String) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.push.OtaPushSubscribeClient.systemProperty(java.lang.String):java.lang.String");
    }

    private final String systemVersion() {
        String strSystemProperty = systemProperty("ro.build.mask.id");
        if (strSystemProperty == null || q.t0(strSystemProperty)) {
            strSystemProperty = systemProperty("ro.build.aios_version");
        }
        if (strSystemProperty == null || q.t0(strSystemProperty)) {
            strSystemProperty = systemProperty("ro.build.aios_version_suffix");
        }
        if ((strSystemProperty == null || q.t0(strSystemProperty)) && (strSystemProperty = Build.DISPLAY) == null) {
            strSystemProperty = "";
        }
        return strSystemProperty == null ? "" : strSystemProperty;
    }

    public final boolean subscribe(Context context) throws JSONException, NoSuchAlgorithmException {
        Object objA;
        g.f(context, "context");
        Context applicationContext = context.getApplicationContext();
        g.c(applicationContext);
        String strBuildSubservicesJson = buildSubservicesJson(applicationContext);
        if (strBuildSubservicesJson == null) {
            return false;
        }
        String strMd5Hex = md5Hex(strBuildSubservicesJson.concat("&5bdbbf945b54ca9cea8aa3212286bb4f"));
        j.a aVar = new j.a(0);
        aVar.a("subservices", strBuildSubservicesJson);
        aVar.a("sign", strMd5Hex);
        j jVar = new j(aVar.f98a, aVar.f99b);
        h.a aVar2 = new h.a();
        aVar2.e(baseUrl(applicationContext) + PATH);
        aVar2.c("POST", jVar);
        try {
            Response responseD = getHttpClient().a(new h(aVar2)).d();
            try {
                t tVar = responseD.f10893j;
                String strC = tVar != null ? tVar.C() : null;
                if (strC == null) {
                    strC = "";
                }
                boolean success = parseSuccess(strC);
                if (!success) {
                    AIEngineLogger.e(LogModule.OTA, TAG, "subscribe HTTP " + responseD.f10891d);
                }
                responseD.close();
                objA = Boolean.valueOf(success);
            } finally {
            }
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.e(LogModule.OTA, TAG, "subscribe network error", thB);
            objA = Boolean.FALSE;
        }
        return ((Boolean) objA).booleanValue();
    }
}
