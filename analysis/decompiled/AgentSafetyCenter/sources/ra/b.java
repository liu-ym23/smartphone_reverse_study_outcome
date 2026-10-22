package ra;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.stepos.statsrpk.h;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ua.c;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f10517a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b, reason: collision with root package name */
    public static String f10518b = null;

    /* renamed from: c, reason: collision with root package name */
    public static String f10519c = "";

    /* renamed from: d, reason: collision with root package name */
    public static String f10520d = "";

    /* renamed from: e, reason: collision with root package name */
    public static String f10521e = "";

    /* renamed from: f, reason: collision with root package name */
    public static String f10522f = "";

    /* renamed from: g, reason: collision with root package name */
    public static String f10523g = "";

    /* renamed from: h, reason: collision with root package name */
    public static String f10524h = "";
    public static int i = 0;

    /* renamed from: j, reason: collision with root package name */
    public static Boolean f10525j = null;

    /* renamed from: k, reason: collision with root package name */
    public static boolean f10526k = false;

    /* JADX WARN: Code restructure failed: missing block: B:59:0x00d6, code lost:
    
        r0 = r2.processName;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00e5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v23, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00a1 -> B:84:0x00a4). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(android.content.Context r5) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ra.b.a(android.content.Context):java.lang.String");
    }

    public static String b(byte[] bArr) {
        if (bArr != null && bArr.length >= 1) {
            try {
                byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(bArr);
                if (bArrDigest == null) {
                    return "";
                }
                char[] cArr = new char[bArrDigest.length * 2];
                int i3 = 0;
                for (byte b10 : bArrDigest) {
                    int i10 = i3 + 1;
                    char[] cArr2 = f10517a;
                    cArr[i3] = cArr2[(b10 >> 4) & 15];
                    i3 += 2;
                    cArr[i10] = cArr2[b10 & 15];
                }
                return new String(cArr);
            } catch (NoSuchAlgorithmException e10) {
                c.f("Utils", "Exception: " + e10.toString() + " - Cause: " + e10.getCause());
            }
        }
        return null;
    }

    public static int c(Context context, String str) throws PackageManager.NameNotFoundException {
        PackageManager packageManager;
        PackageInfo packageInfo;
        int i3 = i;
        if (i3 != 0) {
            return i3;
        }
        if (TextUtils.isEmpty(str) || context == null || (packageManager = context.getPackageManager()) == null) {
            return 0;
        }
        try {
            packageInfo = packageManager.getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e10) {
            c.f("StepOSUtils", "Exception: " + e10.getMessage() + " - Cause: " + e10.getCause());
            packageInfo = null;
        }
        if (packageInfo != null) {
            i = packageInfo.versionCode;
        }
        return i;
    }

    public static String d(Context context, String str) {
        PackageManager packageManager;
        PackageInfo packageInfo;
        if (!TextUtils.isEmpty(f10524h)) {
            return f10524h;
        }
        if (TextUtils.isEmpty(str) || context == null || (packageManager = context.getPackageManager()) == null) {
            return "";
        }
        try {
            packageInfo = packageManager.getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e10) {
            c.f("StepOSUtils", "Exception: " + e10.getMessage() + " - Cause: " + e10.getCause());
            packageInfo = null;
        }
        if (packageInfo != null) {
            f10524h = packageInfo.versionName;
        }
        return f10524h;
    }

    public static boolean e(Context context) {
        c.d("SharedPreferencesHelper", "init SharedPreferences, name: com.stepos.statsapp.v3.request_feq_restrict");
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.stepos.statsapp.v3.request_feq_restrict", 0);
        c.a("SharedPreferencesHelper", "com.stepos.statsapp.v3.request_feq_restrict structure complete");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH");
        String string = sharedPreferences.getString("date", "");
        String str = simpleDateFormat.format(new Date());
        if (!string.equals(str)) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("date", str);
            editorEdit.putLong("current_request", 1L);
            editorEdit.commit();
            c.a("RequestFreqRestrict", "isAllow true");
            return true;
        }
        long j10 = sharedPreferences.getLong("current_request", 0L);
        if (j10 > 10) {
            c.a("RequestFreqRestrict", "isAllow false");
            return false;
        }
        sharedPreferences.edit().putLong("current_request", j10 + 1).commit();
        c.a("RequestFreqRestrict", "isAllow true");
        return true;
    }

    public static boolean f(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            boolean z10 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
            c.a("NetInfoUtils", "isOnline:" + z10);
            return z10;
        } catch (SecurityException e10) {
            c.b("NetInfoUtils", "Security exception:" + e10.toString());
            return true;
        }
    }

    public static String g(String str, String str2, HashMap map) {
        String path;
        HashMap map2 = new HashMap(map);
        try {
            path = new URI(str2).getPath();
        } catch (URISyntaxException e10) {
            c.f("NetRequestUtil", "Exception: " + e10.toString() + " - Cause: " + e10.getCause());
            path = "";
        }
        map2.put("key", h.f2869g);
        ArrayList arrayList = new ArrayList(map2.keySet());
        Collections.sort(arrayList);
        StringBuilder sb2 = new StringBuilder();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            String str3 = (String) obj;
            sb2.append("&");
            sb2.append(j(str3));
            sb2.append("=");
            sb2.append(j((String) map2.get(str3)));
        }
        return b((str + "\n" + path + "\n" + sb2.toString().substring(1)).getBytes());
    }

    public static ArrayList h(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            Object objI = jSONArray.get(i3);
            if (objI instanceof JSONArray) {
                objI = h((JSONArray) objI);
            } else if (objI instanceof JSONObject) {
                objI = i((JSONObject) objI);
            }
            arrayList.add(objI);
        }
        return arrayList;
    }

    public static HashMap i(JSONObject jSONObject) {
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objI = jSONObject.get(next);
            if (objI == JSONObject.NULL) {
                objI = null;
            } else if (objI instanceof JSONArray) {
                objI = h((JSONArray) objI);
            } else if (objI instanceof JSONObject) {
                objI = i((JSONObject) objI);
            }
            map.put(next, objI);
        }
        return map;
    }

    public static String j(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLEncoder.encode(str, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }
}
