package Q2;

import T2.d;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import ch.qos.logback.core.joran.action.Action;
import com.stepos.activeview.utils.Constants;
import com.stepos.alphame.utils.Consts;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f1648a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b, reason: collision with root package name */
    public static String f1649b = "";

    /* renamed from: c, reason: collision with root package name */
    public static String f1650c = "";

    /* renamed from: d, reason: collision with root package name */
    public static String f1651d = "";

    /* renamed from: e, reason: collision with root package name */
    public static String f1652e = "";

    /* renamed from: f, reason: collision with root package name */
    public static String f1653f = "";

    /* renamed from: g, reason: collision with root package name */
    public static String f1654g = "";

    /* renamed from: h, reason: collision with root package name */
    public static int f1655h = 0;

    /* renamed from: i, reason: collision with root package name */
    public static Boolean f1656i = null;

    /* renamed from: j, reason: collision with root package name */
    public static boolean f1657j = false;

    public static String a(byte[] bArr) {
        if (bArr != null && bArr.length >= 1) {
            try {
                byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(bArr);
                if (bArrDigest == null) {
                    return "";
                }
                char[] cArr = new char[bArrDigest.length * 2];
                int i4 = 0;
                for (byte b4 : bArrDigest) {
                    int i5 = i4 + 1;
                    char[] cArr2 = f1648a;
                    cArr[i4] = cArr2[(b4 >> 4) & 15];
                    i4 += 2;
                    cArr[i5] = cArr2[b4 & 15];
                }
                return new String(cArr);
            } catch (NoSuchAlgorithmException e4) {
                d.f("Utils", "Exception: " + e4.toString() + " - Cause: " + e4.getCause());
            }
        }
        return null;
    }

    public static int b(Context context, String str) throws PackageManager.NameNotFoundException {
        PackageManager packageManager;
        PackageInfo packageInfo;
        int i4 = f1655h;
        if (i4 != 0) {
            return i4;
        }
        if (TextUtils.isEmpty(str) || (packageManager = context.getPackageManager()) == null) {
            return 0;
        }
        try {
            packageInfo = packageManager.getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e4) {
            d.f("StepOSUtils", "Exception: " + e4.getMessage() + " - Cause: " + e4.getCause());
            packageInfo = null;
        }
        if (packageInfo != null) {
            f1655h = packageInfo.versionCode;
        }
        return f1655h;
    }

    public static String c(Context context, String str) throws PackageManager.NameNotFoundException {
        PackageManager packageManager;
        PackageInfo packageInfo;
        if (!TextUtils.isEmpty(f1654g)) {
            return f1654g;
        }
        if (TextUtils.isEmpty(str) || (packageManager = context.getPackageManager()) == null) {
            return "";
        }
        try {
            packageInfo = packageManager.getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e4) {
            d.f("StepOSUtils", "Exception: " + e4.getMessage() + " - Cause: " + e4.getCause());
            packageInfo = null;
        }
        if (packageInfo != null) {
            f1654g = packageInfo.versionName;
        }
        return f1654g;
    }

    public static String d(String str, String str2, HashMap map) {
        String path;
        HashMap map2 = new HashMap(map);
        try {
            path = new URI(str2).getPath();
        } catch (URISyntaxException e4) {
            d.f("NetRequestUtil", "Exception: " + e4.toString() + " - Cause: " + e4.getCause());
            path = "";
        }
        map2.put(Action.KEY_ATTRIBUTE, com.stepos.statsrpk.c.f12363f);
        ArrayList arrayList = new ArrayList(map2.keySet());
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            String str3 = (String) obj;
            sb.append("&");
            sb.append(g(str3));
            sb.append(Consts.SPLITTER_EQUAL);
            sb.append(g((String) map2.get(str3)));
        }
        return a((str + "\n" + path + "\n" + sb.toString().substring(1)).getBytes());
    }

    public static ArrayList e(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            Object objF = jSONArray.get(i4);
            if (objF instanceof JSONArray) {
                objF = e((JSONArray) objF);
            } else if (objF instanceof JSONObject) {
                objF = f((JSONObject) objF);
            }
            arrayList.add(objF);
        }
        return arrayList;
    }

    public static HashMap f(JSONObject jSONObject) throws JSONException {
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objF = jSONObject.get(next);
            if (objF == JSONObject.NULL) {
                objF = null;
            } else if (objF instanceof JSONArray) {
                objF = e((JSONArray) objF);
            } else if (objF instanceof JSONObject) {
                objF = f((JSONObject) objF);
            }
            map.put(next, objF);
        }
        return map;
    }

    public static String g(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLEncoder.encode(str, Constants.UTF_8_CODE).replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }
}
