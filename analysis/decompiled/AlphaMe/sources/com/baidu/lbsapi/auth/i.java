package com.baidu.lbsapi.auth;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.text.TextUtils;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.stepos.activeview.utils.Constants;
import com.stepos.alphame.suggest.AppSuggestStorable;
import com.stepos.alphame.utils.Consts;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private Context f4938a;

    /* renamed from: e, reason: collision with root package name */
    private String f4942e;

    /* renamed from: g, reason: collision with root package name */
    private String f4944g;

    /* renamed from: h, reason: collision with root package name */
    private String f4945h;

    /* renamed from: b, reason: collision with root package name */
    private String f4939b = null;

    /* renamed from: c, reason: collision with root package name */
    private HashMap f4940c = null;

    /* renamed from: d, reason: collision with root package name */
    private String f4941d = null;

    /* renamed from: f, reason: collision with root package name */
    private int f4943f = -1;

    public i(Context context) {
        this.f4938a = context;
    }

    private String a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities != null) {
                boolean zHasTransport = networkCapabilities.hasTransport(1);
                boolean zHasTransport2 = networkCapabilities.hasTransport(0);
                boolean zHasTransport3 = networkCapabilities.hasTransport(3);
                boolean zHasTransport4 = networkCapabilities.hasTransport(6);
                boolean zHasTransport5 = networkCapabilities.hasTransport(4);
                boolean zHasTransport6 = networkCapabilities.hasTransport(5);
                if (zHasTransport) {
                    return "WIFI";
                }
                if (zHasTransport2) {
                    return "CELLULAR";
                }
                if (zHasTransport3) {
                    return "ETHERNET";
                }
                if (zHasTransport4) {
                    return "LoWPAN";
                }
                if (zHasTransport5) {
                    return "VPN";
                }
                if (zHasTransport6) {
                    return "WifiAware";
                }
            }
            return AppSuggestStorable.COLUMN_WIFI;
        } catch (Exception e4) {
            if (b.f4919a) {
                e4.printStackTrace();
            }
            return null;
        }
    }

    private HashMap b(HashMap map) {
        HashMap map2 = new HashMap();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            String string = ((String) it.next()).toString();
            map2.put(string, map.get(string));
        }
        return map2;
    }

    private static String a(HashMap map) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        boolean z4 = true;
        for (Map.Entry entry : map.entrySet()) {
            if (z4) {
                z4 = false;
            } else {
                sb.append("&");
            }
            sb.append(URLEncoder.encode((String) entry.getKey(), Constants.UTF_8_CODE));
            sb.append(Consts.SPLITTER_EQUAL);
            sb.append(URLEncoder.encode((String) entry.getValue(), Constants.UTF_8_CODE));
        }
        return sb.toString();
    }

    private HttpsURLConnection b() throws IOException {
        String str;
        URLConnection uRLConnectionOpenConnection;
        try {
            URL url = new URL(this.f4939b);
            b.a("https URL: " + this.f4939b);
            String strA = a(this.f4938a);
            if (strA != null && !strA.equals("")) {
                if (TextUtils.isEmpty(this.f4942e) || this.f4943f == -1) {
                    b.a("checkNetwork = ".concat(strA));
                    uRLConnectionOpenConnection = url.openConnection();
                } else {
                    b.a("Proxy mProxyHost: = " + this.f4942e + " mProxyPort: " + this.f4943f);
                    Proxy proxy = new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(this.f4942e, this.f4943f));
                    Authenticator.setDefault(new j(this));
                    uRLConnectionOpenConnection = url.openConnection(proxy);
                }
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnectionOpenConnection;
                httpsURLConnection.setHostnameVerifier(new k(this));
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setRequestMethod("POST");
                httpsURLConnection.setConnectTimeout(SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH);
                httpsURLConnection.setReadTimeout(SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH);
                return httpsURLConnection;
            }
            b.c("Current network is not available.");
            this.f4941d = ErrorMessage.a(-10, "Current network is not available.");
            return null;
        } catch (MalformedURLException e4) {
            if (b.f4919a) {
                e4.printStackTrace();
                b.a(e4.getMessage());
            }
            str = "Auth server could not be parsed as a URL.";
            this.f4941d = ErrorMessage.a(-11, str);
            return null;
        } catch (Exception e5) {
            if (b.f4919a) {
                e5.printStackTrace();
                b.a(e5.getMessage());
            }
            str = "Init httpsurlconnection failed.";
            this.f4941d = ErrorMessage.a(-11, str);
            return null;
        }
    }

    public String a(HashMap map, String str, int i4, String str2, String str3) throws Throwable {
        HashMap mapB = b(map);
        this.f4940c = mapB;
        this.f4939b = (String) mapB.get(MapBundleKey.MapObjKey.OBJ_URL);
        this.f4942e = str;
        this.f4943f = i4;
        this.f4944g = str2;
        this.f4945h = str3;
        HttpsURLConnection httpsURLConnectionB = b();
        if (httpsURLConnectionB == null) {
            b.c("syncConnect failed,httpsURLConnection is null");
        } else {
            a(httpsURLConnectionB);
        }
        return this.f4941d;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0194 A[Catch: all -> 0x012d, TryCatch #9 {all -> 0x012d, blocks: (B:7:0x002b, B:80:0x0132, B:82:0x0136, B:83:0x0139, B:93:0x0162, B:95:0x0166, B:96:0x0169, B:106:0x0190, B:108:0x0194, B:109:0x0197), top: B:139:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01c1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0156 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0104 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0184 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00be A[Catch: all -> 0x00da, TryCatch #19 {all -> 0x00da, blocks: (B:48:0x00ba, B:50:0x00be, B:53:0x00dc), top: B:147:0x00ba }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x010e A[PHI: r5 r9 r13
      0x010e: PHI (r5v1 boolean) = (r5v0 boolean), (r5v0 boolean), (r5v0 boolean), (r5v3 boolean) binds: [B:89:0x015d, B:102:0x018b, B:115:0x01bb, B:63:0x010c] A[DONT_GENERATE, DONT_INLINE]
      0x010e: PHI (r9v6 int) = (r9v3 int), (r9v4 int), (r9v5 int), (r9v22 int) binds: [B:89:0x015d, B:102:0x018b, B:115:0x01bb, B:63:0x010c] A[DONT_GENERATE, DONT_INLINE]
      0x010e: PHI (r13v20 'e' java.io.IOException) = 
      (r13v8 'e' java.io.IOException)
      (r13v13 'e' java.io.IOException)
      (r13v18 'e' java.io.IOException)
      (r13v38 'e' java.io.IOException)
     binds: [B:89:0x015d, B:102:0x018b, B:115:0x01bb, B:63:0x010c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0115 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0136 A[Catch: all -> 0x012d, TryCatch #9 {all -> 0x012d, blocks: (B:7:0x002b, B:80:0x0132, B:82:0x0136, B:83:0x0139, B:93:0x0162, B:95:0x0166, B:96:0x0169, B:106:0x0190, B:108:0x0194, B:109:0x0197), top: B:139:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0166 A[Catch: all -> 0x012d, TryCatch #9 {all -> 0x012d, blocks: (B:7:0x002b, B:80:0x0132, B:82:0x0136, B:83:0x0139, B:93:0x0162, B:95:0x0166, B:96:0x0169, B:106:0x0190, B:108:0x0194, B:109:0x0197), top: B:139:0x002b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(javax.net.ssl.HttpsURLConnection r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 524
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.lbsapi.auth.i.a(javax.net.ssl.HttpsURLConnection):void");
    }

    public boolean a() {
        NetworkCapabilities networkCapabilities;
        b.a("checkNetwork start");
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f4938a.getSystemService("connectivity");
            if (connectivityManager != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())) != null && networkCapabilities.hasCapability(12)) {
                if (networkCapabilities.hasCapability(16)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e4) {
            if (b.f4919a) {
                e4.printStackTrace();
            }
            return false;
        }
    }
}
