package com.bytedance.bdtracker;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.applog.InitConfig;
import com.bytedance.applog.log.EventBus;
import com.bytedance.applog.log.LogUtils;
import com.bytedance.applog.network.RangersHttpException;
import com.stepos.cloudsdk.Constants;
import com.stepos.pps.reflect.ExceptionManagerStepOS;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import okio.Segment;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import stepos.com.android.os.StatsLogEnums;

/* loaded from: classes.dex */
public class z3 {
    public static JSONObject d;
    public String a = "https://databyterangers.com.cn";
    public final d b;
    public final g5 c;

    public class a implements EventBus.DataFetcher {
        public final /* synthetic */ JSONObject a;

        public a(JSONObject jSONObject) {
            this.a = jSONObject;
        }

        @Override // com.bytedance.applog.log.EventBus.DataFetcher
        public Object fetch() {
            JSONObject jSONObject = new JSONObject();
            r.c(this.a, jSONObject);
            try {
                jSONObject.put("appId", z3.this.b.m);
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    public class b implements EventBus.DataFetcher {
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ byte[] c;
        public final /* synthetic */ String d;
        public final /* synthetic */ long e;
        public final /* synthetic */ HttpURLConnection f;

        public b(String str, int i, byte[] bArr, String str2, long j, HttpURLConnection httpURLConnection) {
            this.a = str;
            this.b = i;
            this.c = bArr;
            this.d = str2;
            this.e = j;
            this.f = httpURLConnection;
        }

        @Override // com.bytedance.applog.log.EventBus.DataFetcher
        public Object fetch() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appId", z3.this.b.m);
                jSONObject.put("nid", this.a);
                jSONObject.put("statusCode", this.b);
                jSONObject.put("responseByte", this.c);
                jSONObject.put("responseString", this.d);
                jSONObject.put("time", this.e);
                jSONObject.put("header", z3.this.a(this.f));
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    public z3(d dVar) {
        this.b = dVar;
        this.c = new g5(dVar);
    }

    public static String a(String str, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Uri uri = Uri.parse(str);
        HashMap map = new HashMap(strArr.length);
        for (String str2 : strArr) {
            String queryParameter = uri.getQueryParameter(str2);
            if (!TextUtils.isEmpty(queryParameter)) {
                map.put(str2, queryParameter);
            }
        }
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.clearQuery();
        for (String str3 : map.keySet()) {
            builderBuildUpon.appendQueryParameter(str3, (String) map.get(str3));
        }
        return builderBuildUpon.build().toString();
    }

    public static JSONObject a(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("aid", str);
        jSONObject.put("os", "Android");
        jSONObject.put("os_version", String.valueOf(Build.VERSION.SDK_INT));
        jSONObject.put("sdk_version", "6.17.4");
        jSONObject.put("app_version", str2);
        return jSONObject;
    }

    public static void a(StringBuilder sb, String str, String str2) {
        if (sb == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        sb.append(sb.toString().indexOf(63) < 0 ? "?" : "&");
        sb.append(str);
        sb.append("=");
        sb.append(Uri.encode(str2));
    }

    public static JSONObject b(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("magic_tag", "ss_app_log");
        jSONObject2.put("header", jSONObject);
        jSONObject2.put("_gen_time", System.currentTimeMillis());
        return jSONObject2;
    }

    public final HashMap<String, String> a() {
        HashMap map = new HashMap(2);
        InitConfig initConfig = this.b.getInitConfig();
        if (initConfig != null) {
            Map<String, String> httpHeaders = initConfig.getHttpHeaderCallback() != null ? initConfig.getHttpHeaderCallback().get() : initConfig.getHttpHeaders();
            if (httpHeaders != null && !httpHeaders.isEmpty()) {
                map.putAll(httpHeaders);
            }
        }
        return g5.a((HashMap<String, String>) map, this.b);
    }

    public final JSONObject a(String str) {
        if (str == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            a(jSONObject);
            return jSONObject;
        } catch (Throwable th) {
            this.b.D.error(11, "JSON handle failed", th, new Object[0]);
            return null;
        }
    }

    public final JSONObject a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return null;
        }
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        if (headerFields.isEmpty()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : headerFields.keySet()) {
            if (r.d(str)) {
                try {
                    jSONObject.put(str, headerFields.get(str));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONObject;
    }

    public final void a(String str, int i, byte[] bArr, String str2, long j, HttpURLConnection httpURLConnection) {
        if (LogUtils.isDisabled()) {
            return;
        }
        LogUtils.sendJsonFetcher("do_request_end", new b(str, i, bArr, str2, j, httpURLConnection));
    }

    public final void a(JSONObject jSONObject) throws JSONException {
        try {
            long jOptLong = jSONObject.optLong("server_time");
            if (jOptLong > 0) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("server_time", jOptLong);
                jSONObject2.put("local_time", System.currentTimeMillis() / 1000);
                d = jSONObject2;
                if (LogUtils.isDisabled()) {
                    return;
                }
                LogUtils.sendJsonFetcher("server_time_sync", new a(jSONObject2));
            }
        } catch (Exception unused) {
        }
    }

    public JSONObject b(String str, JSONObject jSONObject) {
        Exception exc;
        String str2;
        this.b.D.debug(11, "Start to report oaid to uri:{} with request:{}...", str, jSONObject);
        try {
            str2 = new String(this.b.getNetClient().execute((byte) 1, this.c.a(str), jSONObject, a(), (byte) 0, true, 60000));
        } catch (Exception e) {
            exc = e;
            str2 = null;
        }
        try {
            this.b.D.debug(11, "reportOaid success: {}", str2);
        } catch (Exception e2) {
            exc = e2;
            this.b.D.error(11, "reportOaid error", exc, new Object[0]);
            return a(str2);
        }
        return a(str2);
    }

    public JSONObject a(String str, JSONObject jSONObject) {
        Throwable th;
        String str2;
        this.b.D.debug(11, "Start to register to uri:{} with request:{}...", str, jSONObject);
        try {
            str2 = new String(this.b.getNetClient().execute((byte) 1, this.c.a(str), jSONObject, a(), (byte) 0, true, 60000));
        } catch (Throwable th2) {
            th = th2;
            str2 = null;
        }
        try {
            this.b.D.debug(11, "request register success: {}", str2);
        } catch (Throwable th3) {
            th = th3;
            this.b.D.error(11, "request register error", th, new Object[0]);
            return a(str2);
        }
        return a(str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [boolean, byte] */
    /* JADX WARN: Type inference failed for: r6v4 */
    public final String a(JSONObject jSONObject, String str, Map<String, String> map, int i) throws Throwable {
        GZIPInputStream gZIPInputStream;
        ByteArrayInputStream byteArrayInputStream;
        byte[] byteArray;
        String strOptString = jSONObject.optString(Constants.COLUMN_KEY);
        String strOptString2 = jSONObject.optString("iv");
        boolean z = true;
        ?? r6 = (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) ? 0 : 1;
        this.b.D.debug("requestWithKeyIv, {}", Boolean.valueOf((boolean) r6));
        byte[] bArrExecute = this.b.getNetClient().execute((byte) 1, str, jSONObject, map, r6, true, i);
        if (r6 == 0) {
            return new String(bArrExecute);
        }
        String str2 = null;
        str2 = null;
        ByteArrayInputStream byteArrayInputStream2 = null;
        if (bArrExecute != null) {
            byte[] bArrA = g5.a(bArrExecute, strOptString, strOptString2);
            if (bArrA != null) {
                if (bArrA.length <= 0) {
                    byteArray = null;
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byteArrayInputStream = new ByteArrayInputStream(bArrA);
                        try {
                            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                        } catch (IOException unused) {
                            gZIPInputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            gZIPInputStream = null;
                        }
                    } catch (IOException unused2) {
                        gZIPInputStream = null;
                        byteArrayInputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        gZIPInputStream = null;
                    }
                    try {
                        byte[] bArr = new byte[Segment.SHARE_MINIMUM];
                        while (true) {
                            int i2 = gZIPInputStream.read(bArr);
                            if (i2 < 0) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i2);
                        }
                    } catch (IOException unused3) {
                    } catch (Throwable th3) {
                        th = th3;
                        byteArrayInputStream2 = byteArrayInputStream;
                        r.a((Closeable) gZIPInputStream);
                        r.a((Closeable) byteArrayInputStream2);
                        throw th;
                    }
                    r.a((Closeable) gZIPInputStream);
                    r.a((Closeable) byteArrayInputStream);
                    byteArray = byteArrayOutputStream.toByteArray();
                }
                if (byteArray != null) {
                    str2 = new String(byteArray);
                }
            } else {
                str2 = new String(bArrExecute);
            }
            z = false;
        }
        return z ? new String(this.b.getNetClient().execute((byte) 1, str, jSONObject, map, (byte) 0, true, 60000)) : str2;
    }

    public int a(String[] strArr, JSONObject jSONObject, u1 u1Var) {
        int i;
        int responseCode;
        int i2;
        HashMap<String, String> mapA = a();
        int length = strArr.length;
        JSONObject jSONObject2 = null;
        int i3 = 0;
        int i4 = StatsLogEnums.InvalidConfigReasonEnum.INVALID_CONFIG_REASON_VALUE_METRIC_HIST_GENERATED_BINS_INVALID_MIN_MAX_VALUE;
        while (true) {
            if (i3 >= length) {
                i = 200;
                responseCode = i4;
                break;
            }
            try {
                i = 200;
                i2 = i3;
                try {
                    String str = new String(this.b.getNetClient().execute((byte) 1, strArr[i3], jSONObject, mapA, (byte) 0, true, 60000));
                    if (TextUtils.isEmpty(str)) {
                        continue;
                    } else {
                        JSONObject jSONObject3 = new JSONObject(str);
                        try {
                            a(jSONObject3);
                            if (!"ss_app_log".equals(jSONObject3.optString("magic_tag"))) {
                                jSONObject2 = jSONObject3;
                                i4 = StatsLogEnums.InvalidConfigReasonEnum.INVALID_CONFIG_REASON_VALUE_METRIC_HIST_GENERATED_BINS_INVALID_MIN_MAX_VALUE;
                            } else {
                                if ("success".equals(jSONObject3.optString("message"))) {
                                    jSONObject2 = jSONObject3;
                                    responseCode = 200;
                                    break;
                                }
                                i4 = StatsLogEnums.InvalidConfigReasonEnum.INVALID_CONFIG_REASON_VALUE_METRIC_HIST_MISSING_GENERATED_BINS_ARGS_VALUE;
                                jSONObject2 = jSONObject3;
                            }
                        } catch (Exception e) {
                            e = e;
                            jSONObject2 = jSONObject3;
                            if (e instanceof RangersHttpException) {
                                responseCode = ((RangersHttpException) e).getResponseCode();
                                if (u1Var.c.isCongestionControlEnable() && responseCode >= 500 && responseCode < 600) {
                                    if (responseCode == i) {
                                        u1Var.a(jSONObject2);
                                        o1 o1Var = u1Var.s;
                                        o1Var.a(jSONObject2, "blocklist");
                                        o1Var.a(jSONObject2, "whitelist");
                                    }
                                    return responseCode;
                                }
                                i4 = responseCode;
                            } else {
                                this.b.D.error(11, "Send to server failed", e, new Object[0]);
                            }
                            i3 = i2 + 1;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
                i2 = i3;
                i = 200;
            }
            i3 = i2 + 1;
        }
        if (responseCode == i && jSONObject2 != null) {
            u1Var.a(jSONObject2);
            o1 o1Var2 = u1Var.s;
            o1Var2.a(jSONObject2, "blocklist");
            o1Var2.a(jSONObject2, "whitelist");
        }
        return responseCode;
    }

    public boolean a(JSONObject jSONObject, String str) {
        this.b.D.debug(11, "Start to send event:{} with cookie:{} to et...", jSONObject, str);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("header", this.b.getHeader());
            if (jSONObject != null) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                jSONObject2.put("event_v3", jSONArray);
            }
        } catch (Throwable th) {
            this.b.D.error(11, "JSON handle failed", th, new Object[0]);
        }
        HashMap<String, String> mapA = a();
        mapA.put("Cookie", str);
        try {
            String str2 = new String(this.b.getNetClient().execute((byte) 1, this.a + "/simulator/mobile/log", jSONObject2, mapA, (byte) 0, true, com.stepos.pps.data.util.Constants.LOGCAT_MAX_LINES));
            if (!new JSONObject(str2).getJSONObject(ExceptionManagerStepOS.USER_CONFIG_BUNDLE_DATA).optBoolean("keep", false)) {
                this.b.setRangersEventVerifyEnable(false, str);
            }
            this.b.D.debug(11, "Send event to et with response:{}", str2);
            return true;
        } catch (Throwable th2) {
            this.b.D.error(11, "Post to event verify failed", th2, new Object[0]);
            return false;
        }
    }
}
