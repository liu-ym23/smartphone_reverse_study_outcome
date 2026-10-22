package com.baidu.a;

import com.stepos.activeview.utils.Constants;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
final class g {

    /* renamed from: a, reason: collision with root package name */
    private static volatile g f4668a = null;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f4669b = true;

    /* renamed from: g, reason: collision with root package name */
    private static c f4670g;

    /* renamed from: d, reason: collision with root package name */
    private String f4672d;

    /* renamed from: f, reason: collision with root package name */
    private String f4674f;

    /* renamed from: q, reason: collision with root package name */
    private int f4684q;

    /* renamed from: r, reason: collision with root package name */
    private int f4685r;

    /* renamed from: c, reason: collision with root package name */
    private String f4671c = "180.76.76.200";

    /* renamed from: e, reason: collision with root package name */
    private String f4673e = "[240c:4006::6666]";

    /* renamed from: h, reason: collision with root package name */
    private boolean f4675h = true;

    /* renamed from: i, reason: collision with root package name */
    private long f4676i = 0;

    /* renamed from: l, reason: collision with root package name */
    private final Object f4679l = new Object();

    /* renamed from: m, reason: collision with root package name */
    private ArrayList<String> f4680m = new ArrayList<>();

    /* renamed from: n, reason: collision with root package name */
    private String f4681n = "";

    /* renamed from: o, reason: collision with root package name */
    private String f4682o = "";

    /* renamed from: p, reason: collision with root package name */
    private boolean f4683p = false;

    /* renamed from: s, reason: collision with root package name */
    private int f4686s = 10;

    /* renamed from: k, reason: collision with root package name */
    private final Object f4678k = new Object();

    /* renamed from: j, reason: collision with root package name */
    private final HashSet<String> f4677j = new HashSet<>();

    public interface a {
        void a(int i4, d dVar, Map<String, e> map, String str);
    }

    public class b implements Runnable {

        /* renamed from: c, reason: collision with root package name */
        private String f4689c;

        /* renamed from: d, reason: collision with root package name */
        private d f4690d;

        /* renamed from: e, reason: collision with root package name */
        private a f4691e;

        /* renamed from: a, reason: collision with root package name */
        public boolean f4687a = false;

        /* renamed from: f, reason: collision with root package name */
        private boolean f4692f = false;

        public b(String str, d dVar, a aVar) {
            this.f4689c = str;
            this.f4690d = dVar;
            this.f4691e = aVar;
        }

        private String a(String str, int i4) {
            if (str == null || i4 >= 3) {
                return null;
            }
            this.f4692f = true;
            j.a("Using IDCServerIP(%s)", str);
            return str;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i4;
            a();
            if (this.f4687a) {
                j.a("Retry for %s(%s).", this.f4690d.toString(), this.f4689c);
                a();
            }
            synchronized (g.this.f4678k) {
                try {
                    if (!this.f4690d.equals(d.TAG_OF_HOSTS)) {
                        for (String str : this.f4689c.split(",")) {
                            g.this.f4677j.remove(str);
                        }
                    }
                } finally {
                }
            }
            synchronized (g.this.f4679l) {
                try {
                    if (this.f4690d.equals(d.DNLIST_HOSTS)) {
                        for (String str2 : this.f4689c.split(",")) {
                            g.this.f4680m.remove(str2);
                        }
                    }
                } finally {
                }
            }
        }

        private String a(String str, d dVar) {
            String strA;
            String str2;
            long jCurrentTimeMillis = (System.currentTimeMillis() / 1000) + 300 + g.this.f4676i;
            String strA2 = g.this.a(str, jCurrentTimeMillis);
            if (strA2 == null) {
                return null;
            }
            if (com.baidu.a.c.b()) {
                strA = a(g.this.f4672d, g.this.f4684q);
                if (strA == null) {
                    strA = g.this.f4671c;
                    this.f4692f = false;
                    j.a("Using BGPServerIp(%s)", g.this.f4671c);
                }
                str2 = com.baidu.a.c.c() ? "dual_stack" : "ipv4";
            } else {
                if (!com.baidu.a.c.c()) {
                    return null;
                }
                strA = a(g.this.f4674f, g.this.f4685r);
                if (strA == null) {
                    strA = g.this.f4673e;
                    this.f4692f = false;
                    j.a("Using BGPServerIp(%s)", g.this.f4673e);
                }
                str2 = "ipv6";
            }
            String str3 = str2;
            String str4 = strA;
            return (g.this.f4675h ? "https://" : "http://").concat(dVar.equals(d.TAG_OF_HOSTS) ? String.format("%s/v4/resolve?account_id=%s&tag=%s&sign=%s&t=%d&sdk_ver=%s&os_type=%s&alt_server_ip=true&type=%s", str4, g.this.f4681n, str, strA2, Long.valueOf(jCurrentTimeMillis), "1.3", "android", str3) : String.format("%s/v4/resolve?account_id=%s&dn=%s&sign=%s&t=%d&sdk_ver=%s&os_type=%s&alt_server_ip=true&type=%s", str4, g.this.f4681n, str, strA2, Long.valueOf(jCurrentTimeMillis), "1.3", "android", str3));
        }

        private void a() {
            String strA = a(this.f4689c, this.f4690d);
            j.a("Request url is :%s", strA);
            if (strA != null) {
                a(strA);
            } else {
                this.f4691e.a(-1, this.f4690d, null, this.f4689c);
                j.a("Httpdns request failed for  %s(%s), get url error", this.f4690d.toString(), this.f4689c);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:56:0x015b  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0162  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x019d A[PHI: r1 r7
          0x019d: PHI (r1v8 java.net.HttpURLConnection) = (r1v22 java.net.HttpURLConnection), (r1v23 java.net.HttpURLConnection), (r1v24 java.net.HttpURLConnection) binds: [B:61:0x019b, B:67:0x01d2, B:69:0x01ff] A[DONT_GENERATE, DONT_INLINE]
          0x019d: PHI (r7v7 java.lang.Boolean) = (r7v4 java.lang.Boolean), (r7v5 java.lang.Boolean), (r7v8 java.lang.Boolean) binds: [B:61:0x019b, B:67:0x01d2, B:69:0x01ff] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:72:0x0204  */
        /* JADX WARN: Type inference failed for: r10v3, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Boolean, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v25 */
        /* JADX WARN: Type inference failed for: r1v26 */
        /* JADX WARN: Type inference failed for: r1v27 */
        /* JADX WARN: Type inference failed for: r1v28 */
        /* JADX WARN: Type inference failed for: r1v4, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r7v26, types: [com.baidu.a.g] */
        /* JADX WARN: Type inference failed for: r9v9, types: [java.lang.Object] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void a(java.lang.String r14) {
            /*
                Method dump skipped, instructions count: 582
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.a.g.b.a(java.lang.String):void");
        }
    }

    public class c implements HostnameVerifier {
        private c() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return HttpsURLConnection.getDefaultHostnameVerifier().verify("httpdns.baidubce.com", sSLSession);
        }
    }

    public enum d {
        DNLIST_HOSTS,
        TAG_OF_HOSTS
    }

    public class e {

        /* renamed from: b, reason: collision with root package name */
        private final ArrayList<String> f4698b;

        /* renamed from: c, reason: collision with root package name */
        private final ArrayList<String> f4699c;

        /* renamed from: d, reason: collision with root package name */
        private final long f4700d;

        public e(ArrayList<String> arrayList, ArrayList<String> arrayList2, long j4) {
            this.f4698b = arrayList;
            this.f4699c = arrayList2;
            this.f4700d = j4;
        }

        public ArrayList<String> a() {
            return this.f4698b;
        }

        public ArrayList<String> b() {
            return this.f4699c;
        }

        public long c() {
            return this.f4700d;
        }
    }

    private g() {
        f4670g = new c();
    }

    public int d() {
        return this.f4686s;
    }

    private long a(String str, JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        long j4;
        if (jSONObject != null) {
            try {
                j4 = jSONObject.getLong("ttl");
            } catch (JSONException e4) {
                e4.printStackTrace();
                j.a("Httpdns request failed, host(%s), response has no ttl, will use defaults ttl(60s)", str);
                return -1L;
            }
        } else {
            j4 = -1;
        }
        long j5 = jSONObject2 != null ? jSONObject2.getLong("ttl") : -1L;
        if (j4 > 0 && j5 > 0) {
            return j4 < j5 ? j4 : j5;
        }
        if (j4 > 0) {
            return j4;
        }
        if (j5 > 0) {
            return j5;
        }
        return -1L;
    }

    private String b(String str, String str2, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString("msg");
        } catch (JSONException e4) {
            e4.printStackTrace();
            j.a("Httpdns request failed, host(%s), response has no msg in %s ", str2, str);
            return null;
        }
    }

    public ArrayList c() {
        return this.f4680m;
    }

    public String e() {
        boolean z4 = f4669b;
        String str = this.f4682o;
        return !z4 ? str : com.baidu.a.d.g(str);
    }

    public boolean f() {
        return this.f4683p;
    }

    public static g a() {
        if (f4668a == null) {
            synchronized (g.class) {
                try {
                    if (f4668a == null) {
                        f4668a = new g();
                    }
                } finally {
                }
            }
        }
        return f4668a;
    }

    public void c(String str) {
        this.f4681n = str;
    }

    public void d(String str) {
        String strF = com.baidu.a.d.f(str);
        this.f4682o = strF;
        if (strF == null) {
            this.f4682o = str;
            f4669b = false;
        }
    }

    public void b() {
        this.f4684q = 0;
        this.f4685r = 0;
        this.f4672d = null;
        this.f4674f = null;
    }

    public void b(boolean z4) {
        this.f4683p = z4;
    }

    public static boolean b(String str) {
        try {
            new JSONObject(str);
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(InputStream inputStream, HttpURLConnection httpURLConnection) throws IOException {
        String contentEncoding = httpURLConnection.getContentEncoding();
        if (contentEncoding != null) {
            try {
                if (contentEncoding.contains("gzip")) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    int contentLength = httpURLConnection.getContentLength();
                    if (contentLength <= 0) {
                        contentLength = 1024;
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i4 = inputStream.read(bArr);
                            if (-1 == i4) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i4);
                        }
                    } else {
                        byte[] bArr2 = new byte[contentLength];
                        inputStream.read(bArr2);
                        byteArrayOutputStream.write(bArr2, 0, contentLength);
                    }
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    return a(byteArrayOutputStream.toByteArray(), contentLength);
                }
            } catch (UnsupportedEncodingException e4) {
                e4.printStackTrace();
                return null;
            } catch (IOException e5) {
                e5.printStackTrace();
                return null;
            }
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Constants.UTF_8_CODE));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                bufferedReader.close();
                return sb.toString();
            }
            sb.append(line);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, long j4) {
        return com.baidu.a.d.e(String.format("%s-%s-%d", str, e(), Long.valueOf(j4)));
    }

    private String a(byte[] bArr, int i4) throws IOException {
        byte[] bArr2 = new byte[i4];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr), i4);
            do {
                int i5 = gZIPInputStream.read(bArr2, 0, i4);
                byteArrayOutputStream.write(bArr2, 0, i5);
                if (i5 == -1) {
                    break;
                }
            } while (!b(byteArrayOutputStream.toString()));
            gZIPInputStream.close();
            return byteArrayOutputStream.toString();
        } catch (IOException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private ArrayList<String> a(String str, String str2, JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ip");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
            j.a("Httpdns request warning, host(%s), response has no ip field in %s", str2, str);
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
            String strOptString = jSONArrayOptJSONArray.optString(i4);
            if (strOptString == null || strOptString.isEmpty()) {
                j.a("Httpdns request warning, host(%s), response of data get ip error in %s", str2, str);
            } else if (com.baidu.a.d.a(strOptString) || com.baidu.a.d.b(strOptString)) {
                arrayList.add(strOptString);
            } else {
                j.a("Httpdns request warning, host(%s), response of data get invalid ip(%s) in %s", str2, strOptString, str);
            }
        }
        return arrayList;
    }

    public Map a(String str, String str2) throws JSONException {
        ArrayList<String> arrayListA;
        ArrayList<String> arrayListA2;
        HashMap map = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("serverip")) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("serverip");
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("ipv4");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    this.f4672d = jSONArrayOptJSONArray.optString(0);
                }
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("ipv6");
                if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                    this.f4674f = "[" + jSONArrayOptJSONArray2.optString(0) + "]";
                }
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject2 == null) {
                j.a("Httpdns request failed, hostsOrTag(%s), response has empty data", str2);
                return null;
            }
            Iterator<String> itKeys = jSONObjectOptJSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject(next);
                JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject3.optJSONObject("ipv4");
                JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject3.optJSONObject("ipv6");
                long jA = a(next, jSONObjectOptJSONObject4, jSONObjectOptJSONObject5);
                if (jA >= 0) {
                    String strB = b("ipv4Obj", next, jSONObjectOptJSONObject4);
                    String strB2 = b("ipv6Obj", next, jSONObjectOptJSONObject5);
                    if (strB == null || strB.isEmpty()) {
                        j.a("Host(%s) ipv4Msg(%s), will deprecated the ipv4List result", next, strB);
                        arrayListA = null;
                    } else {
                        arrayListA = a("ipv4Obj", next, jSONObjectOptJSONObject4);
                    }
                    if (strB2 == null || strB2.isEmpty()) {
                        j.a("Host(%s) ipv6Msg(%s), will deprecated the ipv6List result", next, strB2);
                        arrayListA2 = null;
                    } else {
                        arrayListA2 = a("ipv6Obj", next, jSONObjectOptJSONObject5);
                    }
                    if ((arrayListA == null || arrayListA.isEmpty()) && (arrayListA2 == null || arrayListA2.isEmpty())) {
                        j.a("Httpdns request failed, host(%s), response has no valid ip", next);
                    } else {
                        map.put(next, new e(arrayListA, arrayListA2, jA));
                    }
                }
                map.put(next, null);
            }
            return map;
        } catch (JSONException e4) {
            e4.printStackTrace();
            j.a("Httpdns request failed, hostsOrTag(%s), response parse data json error", str2);
            return null;
        }
    }

    public Map a(String str, String str2, d dVar) {
        HashMap map = new HashMap();
        Boolean bool = Boolean.FALSE;
        map.put("isMsgOK", bool);
        map.put("isSignExpired", bool);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("msg");
            if (strOptString == null || strOptString.isEmpty()) {
                j.a("Httpdns request failed for %s(%s), response lack of msg", dVar.toString(), str2);
                return map;
            }
            if (!"SignatureExpired".equals(strOptString)) {
                if ("ok".equals(strOptString)) {
                    map.put("isMsgOK", Boolean.TRUE);
                    return map;
                }
                j.a("Httpdns request failed for %s(%s), response msg(%s) is not ok", dVar.toString(), str2, strOptString);
                return map;
            }
            int iOptInt = jSONObject.optInt("timestamp");
            if (iOptInt == 0) {
                j.a("Httpdns request failed for %s(%s), response get invalid timestamp", dVar.toString(), str2);
            } else {
                this.f4676i = iOptInt - (System.currentTimeMillis() / 1000);
                map.put("isSignExpired", Boolean.TRUE);
            }
            return map;
        } catch (JSONException e4) {
            e4.printStackTrace();
            j.a("Httpdns request failed for %s(%s), response parse json error", dVar.toString(), str2);
            return map;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(Boolean bool) {
        try {
            if (bool.booleanValue()) {
                if (com.baidu.a.c.b()) {
                    int i4 = this.f4684q + 1;
                    this.f4684q = i4;
                    j.a("requestV4IDCFailNum: %s", Integer.valueOf(i4));
                } else if (com.baidu.a.c.c()) {
                    int i5 = this.f4685r + 1;
                    this.f4685r = i5;
                    j.a("requestV6IDCFailNum: %s", Integer.valueOf(i5));
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void a(String str) {
        synchronized (this.f4679l) {
            try {
                if (!this.f4680m.contains(str)) {
                    this.f4680m.add(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(String str, d dVar, a aVar) {
        if (str == null || str.isEmpty()) {
            return;
        }
        synchronized (this.f4678k) {
            try {
                if (dVar.equals(d.DNLIST_HOSTS)) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(Arrays.asList(str.split(",")));
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        String str2 = (String) it.next();
                        if (this.f4677j.contains(str2)) {
                            j.a("Httpdns request request for host(%s) is in processing，will exclude it.", str2);
                            it.remove();
                        } else {
                            this.f4677j.add(str2);
                        }
                    }
                    StringBuilder sb = new StringBuilder();
                    for (int i4 = 0; i4 < arrayList.size(); i4++) {
                        sb.append((String) arrayList.get(i4));
                        sb.append(",");
                    }
                    str = sb.toString().replaceAll("^,*|,*$", "");
                }
                if (str != null && !str.isEmpty()) {
                    try {
                        k.a().b().execute(new b(str, dVar, aVar));
                    } catch (RejectedExecutionException e4) {
                        e4.printStackTrace();
                        j.a("Httpdns request failed, host(%s), async tasks has exceed the maximum thread limit.", str);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(ArrayList<String> arrayList, a aVar) {
        ArrayList arrayList2 = new ArrayList(new HashSet(arrayList));
        int i4 = 0;
        int i5 = 0;
        while (i4 < arrayList2.size()) {
            String strR = "";
            int i6 = 0;
            while (true) {
                int i7 = this.f4686s;
                if (i6 >= i7 || (i4 = (i7 * i5) + i6) >= arrayList2.size()) {
                    break;
                }
                strR = B0.g.r(B0.g.s(strR), (String) arrayList2.get(i4), ",");
                i6++;
            }
            i5++;
            if (strR != null && !strR.isEmpty()) {
                String strSubstring = strR.substring(0, strR.length() - 1);
                j.a("Hosts for httpdns request is (%s) ", strSubstring);
                a(strSubstring, d.DNLIST_HOSTS, aVar);
            }
        }
    }

    public void a(boolean z4) {
        this.f4675h = z4;
    }
}
