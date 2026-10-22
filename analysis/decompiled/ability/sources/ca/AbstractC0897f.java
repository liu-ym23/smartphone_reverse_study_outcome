package ca;

import B9.AbstractC0175b;
import B9.T;
import D7.N;
import D7.w;
import D9.r;
import S7.n;
import a.AbstractC0291a;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.appfunctions.internal.AppSearchAppFunctionReader;
import androidx.autofill.HintConstants;
import androidx.core.graphics.drawable.DrawableCompat;
import com.apm.insight.g;
import com.bytedance.apm.insight.ApmInsightInitConfig;
import com.fasterxml.jackson.core.JsonPointer;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.volcengine.tos.comm.common.ACLType;
import com.volcengine.tos.comm.common.StorageClassType;
import com.volcengine.tos.model.acl.ACLConst;
import e2.C1404a;
import g1.AbstractC1451a;
import g8.C1468d;
import h8.InterfaceC1522e;
import j9.m;
import j9.t;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.p;
import m9.AbstractC1683A;
import m9.C1727t;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import r.C1871c;
import s.j;
import s9.o;
import stepai.aios.guiagent.config.GuiAgentConfigKt;
import w.h;
import x0.C2112a;
import x9.InterfaceC2123a;
import z8.C2196h;

/* renamed from: ca.f, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0897f {

    /* renamed from: A, reason: collision with root package name */
    public static String f2115A = null;

    /* renamed from: B, reason: collision with root package name */
    public static long f2116B = -1;

    /* renamed from: C, reason: collision with root package name */
    public static final A5.c[] f2117C;

    /* renamed from: a, reason: collision with root package name */
    public static C0896e f2118a = null;
    public static boolean b = false;
    public static long c = -1;
    public static long d;
    public static long e;
    public static long f;
    public static long g;
    public static long h;
    public static long i;

    /* renamed from: j, reason: collision with root package name */
    public static long f2119j;
    public static long k;
    public static long l;
    public static long m;
    public static long n;
    public static long o;
    public static long p;

    /* renamed from: q, reason: collision with root package name */
    public static long f2120q;

    /* renamed from: r, reason: collision with root package name */
    public static boolean f2121r;

    /* renamed from: s, reason: collision with root package name */
    public static String f2122s;

    /* renamed from: t, reason: collision with root package name */
    public static long f2123t;
    public static long u;

    /* renamed from: v, reason: collision with root package name */
    public static long f2124v;

    /* renamed from: w, reason: collision with root package name */
    public static long f2125w;

    /* renamed from: x, reason: collision with root package name */
    public static long f2126x;
    public static long y;

    /* renamed from: z, reason: collision with root package name */
    public static long f2127z;

    static {
        String str = "aid";
        Class<String> cls = String.class;
        A5.c cVar = new A5.c(str, str, cls, 15);
        String str2 = "google_aid";
        A5.c cVar2 = new A5.c(str2, str2, cls, 15);
        String str3 = "carrier";
        A5.c cVar3 = new A5.c(str3, str3, cls, 15);
        String str4 = "mcc_mnc";
        A5.c cVar4 = new A5.c(str4, str4, cls, 15);
        String str5 = "sim_region";
        A5.c cVar5 = new A5.c(str5, str5, cls, 15);
        String str6 = "device_id";
        A5.c cVar6 = new A5.c(str6, str6, cls, 15);
        String str7 = "bd_did";
        A5.c cVar7 = new A5.c(str7, str7, cls, 15);
        A5.c cVar8 = new A5.c("install_id", "iid", cls, 15);
        String str8 = "clientudid";
        A5.c cVar9 = new A5.c(str8, str8, cls, 15);
        String str9 = GuiAgentConfigKt.META_KEY_APP_NAME;
        A5.c cVar10 = new A5.c(str9, str9, cls, 15);
        A5.c cVar11 = new A5.c("app_version", "version_name", cls, 15);
        String str10 = "version_code";
        Class<Integer> cls2 = Integer.class;
        A5.c cVar12 = new A5.c(str10, str10, cls2, 15);
        String str11 = "manifest_version_code";
        A5.c cVar13 = new A5.c(str11, str11, cls2, 15);
        String str12 = "update_version_code";
        A5.c cVar14 = new A5.c(str12, str12, cls2, 15);
        String str13 = "sdk_version_code";
        f2117C = new A5.c[]{cVar, cVar2, cVar3, cVar4, cVar5, cVar6, cVar7, cVar8, cVar9, cVar10, cVar11, cVar12, cVar13, cVar14, new A5.c(str13, str13, cls2, 15)};
    }

    public static G8.b A(String string, boolean z10) {
        String strC0;
        k.f(string, "string");
        int iP0 = m.p0(string, '`', 0, 6);
        if (iP0 == -1) {
            iP0 = string.length();
        }
        int iU0 = m.u0(iP0, 4, string, "/");
        String str = "";
        if (iU0 == -1) {
            strC0 = t.c0(string, "`", "");
        } else {
            String strSubstring = string.substring(0, iU0);
            k.e(strSubstring, "substring(...)");
            String strB0 = t.b0(strSubstring, JsonPointer.SEPARATOR, '.');
            String strSubstring2 = string.substring(iU0 + 1);
            k.e(strSubstring2, "substring(...)");
            strC0 = t.c0(strSubstring2, "`", "");
            str = strB0;
        }
        return new G8.b(new G8.c(str), new G8.c(strC0), z10);
    }

    public static String B(Context context) {
        k.f(context, "context");
        int i6 = context.getResources().getDisplayMetrics().densityDpi;
        if (i6 <= 120) {
            return "ldpi";
        }
        if (i6 <= 160) {
            return "mdpi";
        }
        if (i6 <= 213) {
            return "tvdpi";
        }
        if (i6 <= 240) {
            return "hdpi";
        }
        if (i6 <= 320) {
            return "xhdpi";
        }
        if (i6 <= 480) {
            return "xxhdpi";
        }
        if (i6 <= 640) {
            return "xxxhdpi";
        }
        return i6 + "dpi";
    }

    public static String C(Context context) {
        k.f(context, "context");
        Object systemService = context.getSystemService("window");
        k.d(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.widthPixels + " x " + displayMetrics.heightPixels;
    }

    public static Object D(Future future) {
        Object obj;
        boolean z10 = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z10 = true;
            } catch (Throwable th) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    public static long E(Context context, String appName) {
        k.f(context, "context");
        k.f(appName, "appName");
        try {
            PackageManager packageManager = context.getPackageManager();
            List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
            k.e(installedPackages, "getInstalledPackages(...)");
            for (PackageInfo packageInfo : installedPackages) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                if (appName.equals(String.valueOf(applicationInfo != null ? applicationInfo.loadLabel(packageManager) : null))) {
                    return packageInfo.getLongVersionCode();
                }
            }
            return -1L;
        } catch (Exception e6) {
            e6.printStackTrace();
            return -1L;
        }
    }

    public static boolean F(char c2) {
        return Character.isWhitespace(c2) || Character.isSpaceChar(c2);
    }

    public static Object G(JsonElement jsonElement) {
        if (jsonElement.isJsonNull()) {
            return null;
        }
        if (jsonElement.isJsonPrimitive()) {
            JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
            if (asJsonPrimitive.isBoolean()) {
                return Boolean.valueOf(asJsonPrimitive.getAsBoolean());
            }
            if (!asJsonPrimitive.isNumber()) {
                return asJsonPrimitive.getAsString();
            }
            Number asNumber = asJsonPrimitive.getAsNumber();
            return asNumber.doubleValue() == ((double) asNumber.longValue()) ? Long.valueOf(asNumber.longValue()) : Double.valueOf(asNumber.doubleValue());
        }
        if (!jsonElement.isJsonArray()) {
            if (!jsonElement.isJsonObject()) {
                return null;
            }
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            k.e(asJsonObject, "getAsJsonObject(...)");
            return H(asJsonObject);
        }
        JsonArray asJsonArray = jsonElement.getAsJsonArray();
        k.e(asJsonArray, "getAsJsonArray(...)");
        ArrayList arrayList = new ArrayList(w.c0(asJsonArray, 10));
        for (JsonElement jsonElement2 : asJsonArray) {
            k.c(jsonElement2);
            arrayList.add(G(jsonElement2));
        }
        return arrayList;
    }

    public static LinkedHashMap H(JsonObject jsonObject) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            k.c(entry);
            String key = entry.getKey();
            JsonElement value = entry.getValue();
            k.c(value);
            linkedHashMap.put(key, G(value));
        }
        return linkedHashMap;
    }

    public static void I(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int[] drawableState = textInputLayout.getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] iArrCopyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, iArrCopyOf, length, drawableState2.length);
        int colorForState = colorStateList.getColorForState(iArrCopyOf, colorStateList.getDefaultColor());
        Drawable drawableMutate = DrawableCompat.wrap(drawable).mutate();
        drawableMutate.setTintList(ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(drawableMutate);
    }

    public static void J(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean zHasOnClickListeners = checkableImageButton.hasOnClickListeners();
        boolean z10 = onLongClickListener != null;
        boolean z11 = zHasOnClickListeners || z10;
        checkableImageButton.setFocusable(z11);
        checkableImageButton.setClickable(zHasOnClickListeners);
        checkableImageButton.setPressable(zHasOnClickListeners);
        checkableImageButton.setLongClickable(z10);
        checkableImageButton.setImportantForAccessibility(z11 ? 1 : 2);
    }

    public static final String K(InterfaceC1522e classDescriptor, String str) {
        k.f(classDescriptor, "classDescriptor");
        String str2 = C1468d.f4490a;
        G8.e eVarI = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.g(classDescriptor).i();
        k.e(eVarI, "toUnsafe(...)");
        G8.b bVarF = C1468d.f(eVarI);
        String internalName = bVarF != null ? O8.b.e(bVarF) : U7.a.s(classDescriptor, C2196h.d);
        k.f(internalName, "internalName");
        return internalName + '.' + str;
    }

    public static String[] L(String str) {
        int i6 = 0;
        if (str == null) {
            return new String[0];
        }
        if (str.isEmpty()) {
            return new String[]{""};
        }
        ArrayList arrayList = new ArrayList();
        while (i6 <= str.length()) {
            int iIndexOf = str.indexOf(47, i6);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            arrayList.add(str.substring(i6, iIndexOf));
            if (iIndexOf == str.length()) {
                break;
            }
            i6 = iIndexOf + 1;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static final Object M(o oVar, o oVar2, n nVar) {
        Object c1727t;
        Object objV;
        try {
            if (nVar instanceof BaseContinuationImpl) {
                p.e(2, nVar);
                c1727t = nVar.invoke(oVar2, oVar);
            } else {
                c1727t = U7.a.b0(nVar, oVar2, oVar);
            }
        } catch (Throwable th) {
            c1727t = new C1727t(th, false);
        }
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        if (c1727t == coroutineSingletons || (objV = oVar.V(c1727t)) == AbstractC1683A.e) {
            return coroutineSingletons;
        }
        if (objV instanceof C1727t) {
            throw ((C1727t) objV).f5333a;
        }
        return AbstractC1683A.u(objV);
    }

    public static G8.b N(G8.c topLevelFqName) {
        k.f(topLevelFqName, "topLevelFqName");
        G8.c cVarE = topLevelFqName.e();
        G8.f fVarF = topLevelFqName.f();
        k.e(fVarF, "shortName(...)");
        return new G8.b(cVarE, fVarF);
    }

    public static byte[] O(String str) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        List listD0 = m.D0(str, new String[]{":"}, 6);
        if (listD0.size() != 2) {
            throw new IllegalArgumentException("wrapped passphrase malformed");
        }
        byte[] bArrDecode = Base64.decode((String) listD0.get(0), 2);
        byte[] bArrDecode2 = Base64.decode((String) listD0.get(1), 2);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(2, P(), new GCMParameterSpec(128, bArrDecode));
        byte[] bArrDoFinal = cipher.doFinal(bArrDecode2);
        k.e(bArrDoFinal, "doFinal(...)");
        return bArrDoFinal;
    }

    public static SecretKey P() throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException, NoSuchProviderException, UnrecoverableEntryException, InvalidAlgorithmParameterException {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        KeyStore.Entry entry = keyStore.getEntry("ability_db_wrap", null);
        KeyStore.SecretKeyEntry secretKeyEntry = entry instanceof KeyStore.SecretKeyEntry ? (KeyStore.SecretKeyEntry) entry : null;
        if (secretKeyEntry != null) {
            SecretKey secretKey = secretKeyEntry.getSecretKey();
            k.e(secretKey, "getSecretKey(...)");
            return secretKey;
        }
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
        keyGenerator.init(new KeyGenParameterSpec.Builder("ability_db_wrap", 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(256).build());
        SecretKey secretKeyGenerateKey = keyGenerator.generateKey();
        k.e(secretKeyGenerateKey, "generateKey(...)");
        return secretKeyGenerateKey;
    }

    public static long a() {
        if (c == -1) {
            c = (AbstractC1451a.L() << 16) | Process.myPid();
        }
        return c;
    }

    public static Object b(JSONObject jSONObject, String str, String str2, Class cls) {
        Object objCast;
        Object objOpt = jSONObject.opt(str);
        if (objOpt != null) {
            try {
                objCast = cls.cast(objOpt);
            } catch (Throwable th) {
                h.b(th);
            }
        } else {
            objCast = null;
        }
        return objCast == null ? str2 : objCast;
    }

    public static String c(Context context, JSONObject jSONObject, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return str;
        }
        Uri uri = Uri.parse(str);
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        Uri.Builder builderBuildUpon = uri.buildUpon();
        HashMap map = new HashMap();
        map.put("_rticket", String.valueOf(System.currentTimeMillis()));
        map.put("device_platform", AppSearchAppFunctionReader.SYSTEM_PACKAGE_NAME);
        map.put("ssmix", "a");
        String str2 = D2.b.h;
        if (str2 == null || str2.length() == 0) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            int i6 = displayMetrics == null ? 0 : displayMetrics.widthPixels;
            DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
            int i10 = displayMetrics2 == null ? 0 : displayMetrics2.heightPixels;
            if (i6 > 0 && i10 > 0) {
                D2.b.h = i6 + "*" + i10;
            }
        }
        String str3 = D2.b.h;
        if (!TextUtils.isEmpty(str3)) {
            map.put("resolution", str3);
        }
        if (D2.b.i == -1) {
            D2.b.i = context.getApplicationContext().getResources().getDisplayMetrics().densityDpi;
        }
        int i11 = D2.b.i;
        if (i11 > 0) {
            map.put("dpi", String.valueOf(i11));
        }
        map.put("device_type", Build.MODEL);
        map.put("device_brand", Build.BRAND);
        map.put("language", context.getResources().getConfiguration().locale.getLanguage());
        map.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
        String strConcat = Build.VERSION.RELEASE;
        if (strConcat != null && !strConcat.contains(".")) {
            strConcat = strConcat.concat(".0");
        }
        map.put("os_version", strConcat);
        String strB = D2.b.b(D2.b.c(context));
        if (!TextUtils.isEmpty(strB)) {
            map.put("ac", strB);
        }
        for (int i12 = 0; i12 < 15; i12++) {
            A5.c cVar = f2117C[i12];
            Object objB = b(jSONObject, (String) cVar.b, null, (Class) cVar.d);
            if (objB != null) {
                map.put((String) cVar.c, objB.toString());
            }
        }
        String str4 = (String) b(jSONObject, "tweaked_channel", "", String.class);
        if (TextUtils.isEmpty(str4)) {
            str4 = (String) b(jSONObject, "channel", "", String.class);
        }
        if (!TextUtils.isEmpty(str4)) {
            map.put("channel", str4);
        }
        String str5 = (String) b(jSONObject, "cdid", null, String.class);
        if (!TextUtils.isEmpty(str5)) {
            map.put("cdid", str5);
        }
        if (!N.e) {
            ((SharedPreferences) N.f.b(context)).getBoolean("_install_started_v2", false);
        }
        String str6 = (String) b(jSONObject, "build_serial", null, String.class);
        if (!TextUtils.isEmpty(str6)) {
            map.put("build_serial", str6);
        }
        int i13 = C1404a.e;
        j.a(context);
        for (Map.Entry entry : map.entrySet()) {
            String str7 = (String) entry.getKey();
            String str8 = (String) entry.getValue();
            if (!queryParameterNames.contains(str7) && !TextUtils.isEmpty(str8)) {
                builderBuildUpon.appendQueryParameter(str7, (String) entry.getValue());
            }
        }
        return builderBuildUpon.build().toString();
    }

    public static JSONArray d(int i6) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        if (!o(i6)) {
            if (i6 != 3) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("module_name", "base");
                jSONObject.put("span_name", "activity_onCreate");
                jSONObject.put("start", f2119j);
                jSONObject.put("end", k);
                jSONArray.put(jSONObject);
            }
            if (i6 == 3) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("module_name", "base");
                jSONObject2.put("span_name", "activity_onRestart");
                jSONObject2.put("start", n);
                jSONObject2.put("end", o);
                jSONArray.put(jSONObject2);
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("module_name", "base");
            jSONObject3.put("span_name", "activity_onStart");
            jSONObject3.put("start", p);
            jSONObject3.put("end", f2120q);
            jSONArray.put(jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("module_name", "base");
            jSONObject4.put("span_name", "activity_onResume");
            jSONObject4.put("start", l);
            jSONObject4.put("end", m);
            jSONArray.put(jSONObject4);
            return jSONArray;
        }
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("module_name", "base");
        jSONObject5.put("span_name", "app_constructor");
        jSONObject5.put("start", d);
        jSONObject5.put("end", e);
        JSONObject jSONObject6 = new JSONObject();
        jSONObject6.put("module_name", "base");
        jSONObject6.put("span_name", "app_attachBaseContext");
        jSONObject6.put("start", f);
        jSONObject6.put("end", g);
        JSONObject jSONObject7 = new JSONObject();
        jSONObject7.put("module_name", "base");
        jSONObject7.put("span_name", "app_onCreate");
        jSONObject7.put("start", h);
        jSONObject7.put("end", i);
        jSONArray.put(jSONObject5);
        jSONArray.put(jSONObject6);
        jSONArray.put(jSONObject7);
        JSONObject jSONObject8 = new JSONObject();
        jSONObject8.put("module_name", "base");
        jSONObject8.put("span_name", "activity_onCreate");
        jSONObject8.put("start", f2123t);
        jSONObject8.put("end", u);
        jSONArray.put(jSONObject8);
        JSONObject jSONObject9 = new JSONObject();
        jSONObject9.put("module_name", "base");
        jSONObject9.put("span_name", "activity_onStart");
        jSONObject9.put("start", y);
        jSONObject9.put("end", f2127z);
        jSONArray.put(jSONObject9);
        JSONObject jSONObject10 = new JSONObject();
        jSONObject10.put("module_name", "base");
        jSONObject10.put("span_name", "activity_onResume");
        jSONObject10.put("start", f2124v);
        jSONObject10.put("end", f2125w);
        jSONArray.put(jSONObject10);
        return jSONArray;
    }

    public static JSONObject e() {
        long freeBytes;
        long totalBytes;
        long freeBytes2;
        JSONObject jSONObject = new JSONObject();
        long totalBytes2 = 0;
        try {
            freeBytes = new StatFs(Environment.getRootDirectory().getPath()).getFreeBytes();
        } catch (Throwable unused) {
            freeBytes = 0;
        }
        try {
            jSONObject.put("inner_free", freeBytes);
            try {
                totalBytes = new StatFs(Environment.getRootDirectory().getPath()).getTotalBytes();
            } catch (Throwable unused2) {
                totalBytes = 0;
            }
            jSONObject.put("inner_total", totalBytes);
            long freeSpace = "mounted".equals(Environment.getExternalStorageState()) ? Environment.getExternalStorageDirectory().getFreeSpace() : 0L;
            jSONObject.put("sdcard_free", freeSpace);
            long totalSpace = "mounted".equals(Environment.getExternalStorageState()) ? Environment.getExternalStorageDirectory().getTotalSpace() : 0L;
            jSONObject.put("sdcard_total", totalSpace);
            try {
                freeBytes2 = new StatFs(g.f2160a.getFilesDir().getPath()).getFreeBytes();
            } catch (Throwable unused3) {
                freeBytes2 = 0;
            }
            jSONObject.put("inner_free_real", freeBytes2);
            try {
                totalBytes2 = new StatFs(g.f2160a.getFilesDir().getPath()).getTotalBytes();
            } catch (Throwable unused4) {
            }
            jSONObject.put("inner_total_real", totalBytes2);
        } catch (Throwable unused5) {
        }
        return jSONObject;
    }

    public static JSONObject f(U0.a aVar) {
        if (aVar == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = aVar.f1263z;
            if (jSONObject2 != null) {
                jSONObject = S0.b.z0(jSONObject, jSONObject2);
            }
            if (!TextUtils.isEmpty(aVar.b)) {
                jSONObject.put("device_id", aVar.b);
            }
            JSONObject jSONObject3 = aVar.y;
            if (jSONObject3 != null) {
                jSONObject = S0.b.z0(jSONObject, jSONObject3);
            }
            jSONObject.put("version_code", aVar.g);
            jSONObject.put("version_name", aVar.h);
            jSONObject.put("manifest_version_code", aVar.f);
            jSONObject.put("update_version_code", aVar.d);
            jSONObject.put("app_version", aVar.e);
            jSONObject.put("os", aVar.f1255j);
            jSONObject.put("device_platform", aVar.k);
            jSONObject.put("os_version", aVar.l);
            jSONObject.put("os_api", aVar.m);
            jSONObject.put("device_model", aVar.n);
            jSONObject.put("device_brand", aVar.o);
            jSONObject.put("device_manufacturer", aVar.p);
            jSONObject.put("process_name", aVar.f1256q);
            jSONObject.put("sid", aVar.f1257r);
            jSONObject.put("rom_version", aVar.f1258s);
            jSONObject.put("package", aVar.f1259t);
            jSONObject.put("monitor_version", aVar.u);
            jSONObject.put("channel", aVar.c);
            jSONObject.put("aid", aVar.f1254a);
            jSONObject.put("uid", aVar.f1260v);
            jSONObject.put("phone_startup_time", aVar.f1261w);
            jSONObject.put("release_build", aVar.i);
            long j5 = aVar.f1252C;
            if (j5 != -1) {
                jSONObject.put("config_time", String.valueOf(j5));
            }
            if (!TextUtils.isEmpty(aVar.f1262x)) {
                jSONObject.put("verify_info", aVar.f1262x);
            }
            jSONObject.put("current_update_version_code", aVar.f1251B);
            long j6 = aVar.f1253D;
            if (j6 != -1) {
                jSONObject.put("ntp_time", j6);
            }
            long j10 = aVar.E;
            if (j10 != -1) {
                jSONObject.put("ntp_offset", j10);
            }
            JSONObject jSONObject4 = aVar.f1250A;
            if (jSONObject4 != null) {
                jSONObject.put("filters", jSONObject4);
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void g(int i6, boolean z10) {
        ApmInsightInitConfig apmInsightInitConfig = (ApmInsightInitConfig) C4.a.c().c;
        if (apmInsightInitConfig != null ? apmInsightInitConfig.enableStartMonitor() : true) {
            if ((!o(i6) || f2121r) && i6 != -1) {
                if (o(i6)) {
                    long j5 = (H.h.f720z ? f2126x : f2125w) - d;
                    if (j5 <= 0 || j5 > f2116B) {
                        return;
                    }
                } else if (i6 == 4) {
                    long j6 = m - f2119j;
                    if (j6 <= 0 || j6 > 5000) {
                        return;
                    }
                } else if (i6 == 3) {
                    long j10 = m - n;
                    if (j10 <= 0 || j10 > 5000) {
                        return;
                    }
                }
                if (!o(i6) || !H.h.f720z) {
                    q(i6);
                } else if (z10) {
                    q(i6);
                } else if (f2126x != 0) {
                    q(i6);
                }
            }
        }
    }

    public static boolean h(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static String[] i(C1871c c1871c, JSONObject jSONObject, boolean z10) {
        A5.c cVarF = c1871c.f();
        String[] strArr = z10 ? (String[]) cVarF.d : (String[]) cVarF.c;
        int length = strArr.length;
        String[] strArr2 = new String[length];
        int i6 = C1404a.e;
        for (int i10 = 0; i10 < length; i10++) {
            strArr2[i10] = strArr[i10];
            String strQ = B7.a.q(new StringBuilder(), strArr2[i10], "?tt_data=a");
            strArr2[i10] = strQ;
            String strC = c(c1871c.b, jSONObject, strQ);
            strArr2[i10] = strC;
            String[] strArr3 = AbstractC0291a.i;
            if (!TextUtils.isEmpty(strC)) {
                Uri uri = Uri.parse(strC);
                HashMap map = new HashMap(5);
                for (int i11 = 0; i11 < 5; i11++) {
                    String str = strArr3[i11];
                    String queryParameter = uri.getQueryParameter(str);
                    if (!TextUtils.isEmpty(queryParameter)) {
                        map.put(str, queryParameter);
                    }
                }
                Uri.Builder builderBuildUpon = uri.buildUpon();
                builderBuildUpon.clearQuery();
                for (String str2 : map.keySet()) {
                    builderBuildUpon.appendQueryParameter(str2, (String) map.get(str2));
                }
                strC = builderBuildUpon.build().toString();
            }
            strArr2[i10] = strC;
        }
        return strArr2;
    }

    public static boolean j(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                if (1 == activeNetworkInfo.getType()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static final void k(I9.a aVar, I9.c cVar, String str) {
        I9.e.i.fine(cVar.b + ' ' + String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1)) + ": " + aVar.f851a);
    }

    public static final void l(A9.f fVar) {
        k.f(fVar, "<this>");
        if ((fVar instanceof r ? (r) fVar : null) != null) {
            return;
        }
        throw new IllegalStateException(B7.a.t(kotlin.jvm.internal.m.f4928a, fVar.getClass(), new StringBuilder("This serializer can be used only with Json format.Expected Encoder to be JsonEncoder, got ")));
    }

    public static void m(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            if (colorStateList == null || !colorStateList.isStateful()) {
                drawable.setTintList(colorStateList);
            } else {
                int[] drawableState = textInputLayout.getDrawableState();
                int[] drawableState2 = checkableImageButton.getDrawableState();
                int length = drawableState.length;
                int[] iArrCopyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
                System.arraycopy(drawableState2, 0, iArrCopyOf, length, drawableState2.length);
                drawable.setTintList(ColorStateList.valueOf(colorStateList.getColorForState(iArrCopyOf, colorStateList.getDefaultColor())));
            }
            if (mode != null) {
                drawable.setTintMode(mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    public static final C9.j n(A9.e eVar) {
        k.f(eVar, "<this>");
        C9.j jVar = eVar instanceof C9.j ? (C9.j) eVar : null;
        if (jVar != null) {
            return jVar;
        }
        throw new IllegalStateException(B7.a.t(kotlin.jvm.internal.m.f4928a, eVar.getClass(), new StringBuilder("This serializer can be used only with Json format.Expected Decoder to be JsonDecoder, got ")));
    }

    public static boolean o(int i6) {
        return i6 == 2 || i6 == 1;
    }

    public static boolean p(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                if (1 == activeNetworkInfo.getType()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static void q(int i6) {
        try {
            JSONArray jSONArrayD = d(i6);
            I.a.a(jSONArrayD);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(HintConstants.AUTOFILL_HINT_NAME, "launch_stats");
            if (i6 == 1 || i6 == 2) {
                jSONObject.put("start", f);
                jSONObject.put("end", H.h.f720z ? f2126x : f2125w);
            } else if (i6 == 3) {
                jSONObject.put("start", n);
                jSONObject.put("end", m);
            } else if (i6 == 4) {
                jSONObject.put("start", f2119j);
                jSONObject.put("end", m);
            }
            jSONObject.put("spans", jSONArrayD);
            jSONObject.put("launch_mode", i6);
            jSONObject.put("collect_from", 1);
            if (!o(i6) || H.h.f720z) {
                jSONObject.put("page_name", f2122s);
            } else {
                jSONObject.put("page_name", f2115A);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("trace", jSONObject);
            if (H.h.b) {
                Log.i("testLog", "data: " + jSONObject2);
                Log.d("ApmInsight", U7.a.e(new String[]{"Receive:StartData"}));
            }
            P.e eVar = new P.e("start_trace", "", "", null, null, jSONObject2);
            JSONObject jSONObjectB = O0.a.a().b();
            if (o(i6) && H.h.f720z) {
                jSONObjectB.put("custom_launch", true);
            }
            eVar.f = jSONObjectB;
            O.a.g().c(eVar);
            JSONObject jSONObjectA = eVar.a();
            if (jSONObjectA != null) {
                C2112a.c.a(jSONObjectA.toString());
            }
        } catch (Throwable unused) {
        }
    }

    public static void r(int i6) {
        if (2 > i6 || i6 >= 37) {
            StringBuilder sbU = B7.a.u(i6, "radix ", " was not in valid range ");
            sbU.append(new Y7.f(2, 36, 1));
            throw new IllegalArgumentException(sbU.toString());
        }
    }

    public static ACLType s(String str) {
        if (str == null) {
            return null;
        }
        return str.equals(ACLConst.ACL_PRIVATE) ? ACLType.ACL_PRIVATE : str.equals(ACLConst.ACL_PUBLIC_READ) ? ACLType.ACL_PUBLIC_READ : str.equals(ACLConst.ACL_PUBLIC_READ_WRITE) ? ACLType.ACL_PUBLIC_READ_WRITE : str.equals(ACLConst.ACL_AUTH_READ) ? ACLType.ACL_AUTHENTICATED_READ : str.equals(ACLConst.ACL_BUCKET_OWNER_READ) ? ACLType.ACL_BUCKET_OWNER_READ : str.equals(ACLConst.ACL_BUCKET_OWNER_FULL_CONTROL) ? ACLType.ACL_BUCKET_OWNER_FULL_CONTROL : str.equals(ACLConst.ACL_LOG_DELIVERY_WRITE) ? ACLType.ACL_LOG_DELIVERY_WRITE : str.equals("bucket-owner-entrusted") ? ACLType.ACL_BUCKET_OWNER_ENTRUSTED : ACLType.ACL_UNKNOWN;
    }

    public static ImageView.ScaleType t(int i6) {
        return i6 != 0 ? i6 != 1 ? i6 != 2 ? i6 != 3 ? i6 != 5 ? i6 != 6 ? ImageView.ScaleType.CENTER : ImageView.ScaleType.CENTER_INSIDE : ImageView.ScaleType.CENTER_CROP : ImageView.ScaleType.FIT_END : ImageView.ScaleType.FIT_CENTER : ImageView.ScaleType.FIT_START : ImageView.ScaleType.FIT_XY;
    }

    public static StorageClassType u(String str) {
        if (str == null) {
            return null;
        }
        return str.equals("STANDARD") ? StorageClassType.STORAGE_CLASS_STANDARD : str.equals("IA") ? StorageClassType.STORAGE_CLASS_IA : str.equals("ARCHIVE_FR") ? StorageClassType.STORAGE_CLASS_ARCHIVE_FR : str.equals("INTELLIGENT_TIERING") ? StorageClassType.STORAGE_CLASS_INTELLIGENT_TIERING : str.equals("COLD_ARCHIVE") ? StorageClassType.STORAGE_CLASS_COLD_ARCHIVE : StorageClassType.STORAGE_CLASS_UNKNOWN;
    }

    public static int v(char c2) {
        int iDigit = Character.digit((int) c2, 10);
        if (iDigit >= 0) {
            return iDigit;
        }
        throw new IllegalArgumentException("Char " + c2 + " is not a decimal digit");
    }

    public static final boolean w(char c2, char c5, boolean z10) {
        if (c2 == c5) {
            return true;
        }
        if (!z10) {
            return false;
        }
        char upperCase = Character.toUpperCase(c2);
        char upperCase2 = Character.toUpperCase(c5);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    public static final InterfaceC2123a x(AbstractC0175b abstractC0175b, A9.c cVar, String str) {
        k.f(abstractC0175b, "<this>");
        InterfaceC2123a interfaceC2123aA = abstractC0175b.a(cVar, str);
        if (interfaceC2123aA != null) {
            return interfaceC2123aA;
        }
        T.h(str, abstractC0175b.c());
        throw null;
    }

    public static final x9.f y(AbstractC0175b abstractC0175b, A9.f fVar, Object value) {
        k.f(abstractC0175b, "<this>");
        k.f(value, "value");
        x9.f fVarB = abstractC0175b.b(fVar, value);
        if (fVarB != null) {
            return fVarB;
        }
        Z7.d dVarB = kotlin.jvm.internal.m.f4928a.b(value.getClass());
        Z7.d baseClass = abstractC0175b.c();
        k.f(baseClass, "baseClass");
        String strM = dVarB.m();
        if (strM == null) {
            strM = String.valueOf(dVarB);
        }
        T.h(strM, baseClass);
        throw null;
    }

    public static final String z(long j5) {
        String strE;
        if (j5 <= -999500000) {
            strE = androidx.constraintlayout.core.dsl.a.e((j5 - 500000000) / 1000000000, " s ", new StringBuilder());
        } else if (j5 <= -999500) {
            strE = androidx.constraintlayout.core.dsl.a.e((j5 - 500000) / 1000000, " ms", new StringBuilder());
        } else if (j5 <= 0) {
            strE = androidx.constraintlayout.core.dsl.a.e((j5 - 500) / 1000, " µs", new StringBuilder());
        } else if (j5 < 999500) {
            strE = androidx.constraintlayout.core.dsl.a.e((j5 + 500) / 1000, " µs", new StringBuilder());
        } else if (j5 < 999500000) {
            strE = androidx.constraintlayout.core.dsl.a.e((j5 + 500000) / 1000000, " ms", new StringBuilder());
        } else {
            strE = androidx.constraintlayout.core.dsl.a.e((j5 + 500000000) / 1000000000, " s ", new StringBuilder());
        }
        return String.format("%6s", Arrays.copyOf(new Object[]{strE}, 1));
    }
}
