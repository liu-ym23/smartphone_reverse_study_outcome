package com.bytedance.retrofit2;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedanceos.common.networkv2.params.NetKey;
import com.obric.capabilitykit.common.Ext;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class RetrofitMetrics {
    public long A;
    public long B;
    public long C;
    public long D;
    public long E;
    public long F;
    public long G;
    public long H;
    public long I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public long f7893J;
    public long K;
    public long L;
    public long M;
    public Map N;
    public String O;
    public JSONArray P;
    public Map Q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f7895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f7896c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f7897d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f7898e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f7899f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f7900g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f7901h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f7902i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f7903j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f7904k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f7905l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f7906m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f7907n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f7908o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f7909p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f7910q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f7911r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f7912s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f7913t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f7914u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f7915v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f7916w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Map f7917x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Map f7918y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f7919z;

    public interface ExtraKeys {
        public static final String RECEIVED_BYTE_COUNT = "receivedByteCount";
        public static final String SENT_BYTE_COUNT = "sentByteCount";
        public static final String STREAM_READ_BYTE_COUNT = "streamReadByteCount";
        public static final String STREAM_READ_TIME = "streamReadTime";
    }

    public RetrofitMetrics() {
        this.f7894a = -1;
        this.f7895b = "";
        this.f7917x = new HashMap();
        this.f7918y = new HashMap();
        this.f7919z = -1;
        this.A = -1;
        this.B = -1;
        this.C = -1;
        this.D = -1;
        this.E = -1;
        this.F = -1;
        this.G = -1;
        this.H = -1;
        this.I = -1;
        this.f7893J = -1;
        this.K = -1;
        this.L = -1;
        this.M = -1;
        this.N = new HashMap();
        this.O = "";
        this.Q = new ConcurrentHashMap();
    }

    public final JSONObject a() {
        JSONObject r10 = new JSONObject();
        r10.put("fallback", this.f7894a);     // Catch: JSONException -> L6
        if (TextUtils.isEmpty(this.f7895b) == true) goto L8;
        r10.put("fallbackMessage", this.f7895b);     // Catch: JSONException -> L6
    L8:
        r10.put("createRetrofitTime", this.f7899f);     // Catch: JSONException -> L6
        r10.put("appRequestStartTime", this.f7900g);     // Catch: JSONException -> L6
        r10.put("beforeAllInterceptTime", this.f7901h);     // Catch: JSONException -> L6
        r10.put("callServerInterceptTime", this.f7902i);     // Catch: JSONException -> L6
        r10.put("callExecuteStartTime", this.f7903j);     // Catch: JSONException -> L6
        r10.put("reportTime", this.f7904k);     // Catch: JSONException -> L6
        r10.put("delayWait", this.f7909p);     // Catch: JSONException -> L6
        r10.put("injectInterceptorTime", c());     // Catch: JSONException -> L6
        if (TextUtils.isEmpty(this.f7897d) == true) goto L13;
        r10.put("transactionId", this.f7897d);     // Catch: JSONException -> L6
    L13:
        boolean r11 = g(r10, "loadServiceMethod", this.f7905l, this.f7906m, true);
        long r12 = this.f7907n;
        if (r12 <= 0) goto L17;
        boolean r13 = g(r10, "enqueueWait", r12, this.f7910q, r11);
    L16:
        boolean r14 = r13;
        boolean r15 = g(r10, "executeCall", this.f7913t, this.f7914u, r14);
        boolean r16 = g(r10, "requestParse", this.f7911r, this.f7912s, r15);
        g(r10, "responseParse", this.f7915v, this.f7916w, r16);
        return r10;
    L17:
        r13 = g(r10, "executeWait", this.f7908o, this.f7910q, r11);
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    public final JSONObject b() {
        JSONObject r10 = new JSONObject();
        r10.put("filterUrl", this.f7919z);     // Catch: JSONException -> L7
        r10.put("addCommonParam", this.A);     // Catch: JSONException -> L7
        r10.put("requestVerify", this.B);     // Catch: JSONException -> L7
        r10.put("encryptRequest", this.D);     // Catch: JSONException -> L7
        r10.put("genReqTicket", this.E);     // Catch: JSONException -> L7
        r10.put("checkReqTicket", this.F);     // Catch: JSONException -> L7
        r10.put("preCdnVerify", this.G);     // Catch: JSONException -> L7
        r10.put("postCdnVerify", this.f7893J);     // Catch: JSONException -> L7
        r10.put("addClientKey", this.H);     // Catch: JSONException -> L7
        r10.put("updateClientKey", this.I);     // Catch: JSONException -> L7
        r10.put("commandListener", this.K);     // Catch: JSONException -> L7
        r10.put("filterDupQuery", this.C);     // Catch: JSONException -> L7
        r10.put("queryFilter", this.L);     // Catch: JSONException -> L7
        long r11 = this.M;     // Catch: JSONException -> L7
        if (r11 < 0) goto L9;
        r10.put("bodyEncrypt", r11);     // Catch: JSONException -> L7
    L9:
        return r10;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    public final JSONObject c() {
        JSONObject r10 = new JSONObject();
        Iterator r11 = this.Q.entrySet().iterator();     // Catch: JSONException -> L8
    L5:
        if (r11.hasNext() == false) goto L10;
        Map.Entry r12 = (Map.Entry) r11.next();     // Catch: JSONException -> L8
        r10.put((String) r12.getKey(), r12.getValue());     // Catch: JSONException -> L8
    L10:
        return r10;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public final JSONObject d() {
        JSONObject r10 = new JSONObject();
    L9:
        e = move-exception;
        e.printStackTrace();
    L21:
        return r10;
    L4:
        if (this.f7917x.isEmpty() == true) goto L13;
        JSONObject r11 = new JSONObject();     // Catch: JSONException -> L9
        Iterator r12 = this.f7917x.entrySet().iterator();     // Catch: JSONException -> L9
    L7:
        if (r12.hasNext() == false) goto L11;
        Map.Entry r13 = (Map.Entry) r12.next();     // Catch: JSONException -> L9
        r11.put((String) r13.getKey(), r13.getValue());     // Catch: JSONException -> L9
        goto L7
    L11:
        r10.put(Ext.KEY_REQUEST, r11);     // Catch: JSONException -> L9
    L13:
        if (this.f7918y.isEmpty() == true) goto L21;
        JSONObject r14 = new JSONObject();     // Catch: JSONException -> L9
        Iterator r15 = this.f7918y.entrySet().iterator();     // Catch: JSONException -> L9
    L16:
        if (r15.hasNext() == false) goto L18;
        Map.Entry r16 = (Map.Entry) r15.next();     // Catch: JSONException -> L9
        r14.put((String) r16.getKey(), r16.getValue());     // Catch: JSONException -> L9
        goto L16
    L18:
        r10.put("response", r14);     // Catch: JSONException -> L9
        goto L21
    }

    public final JSONObject e() {
        JSONObject r10 = new JSONObject();
        r10.put(NetKey.MODEL, Build.MODEL);     // Catch: JSONException -> L8
        String r11 = "";
        String[] r12 = Build.SUPPORTED_ABIS;     // Catch: JSONException -> L8
        if (r12 != null) goto L6;
    L10:
        r10.put("abis", r11);     // Catch: JSONException -> L8
    L13:
        return r10;
    L6:
        if (r12.length <= 0) goto L10;
        r11 = Arrays.asList(r12).toString();     // Catch: JSONException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    public String f() {
        JSONObject r10 = new JSONObject();
    L6:
        e = move-exception;
        e.printStackTrace();
    L17:
        return r10.toString();
    L4:
        if (this.f7894a == (-1)) goto L8;
        r10.put(NetKey.MODEL, e());     // Catch: JSONException -> L6
    L8:
        JSONObject r11 = this.f7896c;     // Catch: JSONException -> L6
        if (r11 == null) goto L11;
        r10.put("concurrentRequest", r11);     // Catch: JSONException -> L6
    L11:
        r10.put("concurrent", this.f7898e);     // Catch: JSONException -> L6
        r10.put(TraceStatsConsts.STATS_BASE_MODULE, a());     // Catch: JSONException -> L6
        r10.put("callback", b());     // Catch: JSONException -> L6
        r10.put("interceptor", d());     // Catch: JSONException -> L6
        r10.put("ttnetVersion", this.O);     // Catch: JSONException -> L6
        JSONArray r12 = this.P;     // Catch: JSONException -> L6
        if (r12 == null) goto L17;
        r10.put("actionInfo", r12);     // Catch: JSONException -> L6
        goto L17
    }

    public final boolean g(JSONObject r10, String r11, long r12, long r13, boolean r14) {
        if (r14 == true) goto L5;
    L12:
        r10.put(r11, -1);     // Catch: JSONException -> L10
        return false;
    L5:
        if (r12 > r13) goto L12;
        r10.put(r11, r13 - r12);     // Catch: JSONException -> L10
        return true;
    L10:
        e = move-exception;
        e.printStackTrace();
        return false;
    }
}
