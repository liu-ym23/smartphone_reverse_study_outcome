package u5;

import com.stepos.account.oauth.OAuthConstants;
import d7.a0;
import d7.e0;
import d7.h0;
import fi.iki.elonen.NanoHTTPD;
import ia.a2;
import ia.d0;
import ia.f1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import o4.j0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: j, reason: collision with root package name */
    public static final ga.i f10164j = new ga.i("^/v1/channels/([A-Za-z0-9]+)/chat$");

    /* renamed from: k, reason: collision with root package name */
    public static final ga.i f10165k = new ga.i("^/v1/channels/([A-Za-z0-9]+)/events$");

    /* renamed from: l, reason: collision with root package name */
    public static final ga.i f10166l = new ga.i("^/v1/channels/([A-Za-z0-9]+)/cancel$");

    /* renamed from: m, reason: collision with root package name */
    public static final ga.i f10167m = new ga.i("^/v1/nodes/([A-Za-z0-9]+)/invokes$");

    /* renamed from: n, reason: collision with root package name */
    public static final ga.i f10168n = new ga.i("^/v1/nodes/([A-Za-z0-9]+)/invokes/([A-Za-z0-9_-]+)/result$");

    /* renamed from: a, reason: collision with root package name */
    public final int f10169a;

    /* renamed from: b, reason: collision with root package name */
    public final v4.k f10170b;

    /* renamed from: c, reason: collision with root package name */
    public final k5.a f10171c;

    /* renamed from: d, reason: collision with root package name */
    public final k5.t f10172d;

    /* renamed from: e, reason: collision with root package name */
    public final m f10173e;

    /* renamed from: f, reason: collision with root package name */
    public final c5.d f10174f;

    /* renamed from: g, reason: collision with root package name */
    public final d5.l f10175g;

    /* renamed from: h, reason: collision with root package name */
    public final ConcurrentHashMap f10176h;

    /* renamed from: i, reason: collision with root package name */
    public final na.d f10177i;

    public s(int i2, v4.k kVar, k5.a aVar, k5.g gVar, a7.d dVar) {
        q7.k.e(aVar, "dispatchers");
        q7.k.e(gVar, "logger");
        q7.k.e(dVar, "internalBus");
        this.f10169a = i2;
        this.f10170b = kVar;
        this.f10171c = aVar;
        this.f10172d = gVar;
        this.f10173e = new m(this, i2);
        this.f10174f = new c5.d();
        this.f10175g = kVar.f10441k;
        this.f10176h = new ConcurrentHashMap();
        this.f10177i = d0.b(f1.plus(d0.c(), aVar.f5616a));
    }

    public static NanoHTTPD.Response g(NanoHTTPD.Response.Status status, String str) throws UnsupportedEncodingException {
        NanoHTTPD.Response responseNewFixedLengthResponse = NanoHTTPD.newFixedLengthResponse(status, "application/json", str);
        q7.k.d(responseNewFixedLengthResponse, "newFixedLengthResponse(...)");
        return responseNewFixedLengthResponse;
    }

    public static NanoHTTPD.Response j(String str) throws UnsupportedEncodingException {
        NanoHTTPD.Response responseNewFixedLengthResponse = NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.OK, "application/json", str);
        q7.k.d(responseNewFixedLengthResponse, "newFixedLengthResponse(...)");
        return responseNewFixedLengthResponse;
    }

    public static JSONObject l(NanoHTTPD.IHTTPSession iHTTPSession) throws IOException {
        String str = iHTTPSession.getHeaders().get("content-length");
        if (str == null) {
            str = "0";
        }
        Integer numI0 = ga.r.i0(str);
        int iIntValue = numI0 != null ? numI0.intValue() : 0;
        if (iIntValue <= 0) {
            return new JSONObject();
        }
        byte[] bArr = new byte[iIntValue];
        int i2 = 0;
        while (i2 < iIntValue) {
            int i10 = iHTTPSession.getInputStream().read(bArr, i2, iIntValue - i2);
            if (i10 < 0) {
                break;
            }
            i2 += i10;
        }
        return new JSONObject(new String(bArr, 0, i2, ga.a.f4005a));
    }

    public static JSONObject o(y4.n nVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("enabled", nVar.f11623a);
        jSONObject.put("operatorState", nVar.f11624b);
        jSONObject.put("nodeState", nVar.f11625c);
        String str = nVar.f11626d;
        if (str != null) {
            jSONObject.put("operatorLastFailureReason", str);
        }
        Long l6 = nVar.f11627e;
        if (l6 != null) {
            jSONObject.put("operatorLastFailureAtMs", l6.longValue());
        }
        String str2 = nVar.f11628f;
        if (str2 != null) {
            jSONObject.put("nodeLastFailureReason", str2);
        }
        Long l10 = nVar.f11629g;
        if (l10 != null) {
            jSONObject.put("nodeLastFailureAtMs", l10.longValue());
        }
        return jSONObject;
    }

    public final NanoHTTPD.Response a(NanoHTTPD.IHTTPSession iHTTPSession) throws JSONException, IOException {
        long j2;
        JSONObject jSONObjectL = l(iHTTPSession);
        String strOptString = jSONObjectL.optString("task");
        q7.k.b(strOptString);
        if (strOptString.length() <= 0) {
            strOptString = null;
        }
        if (strOptString == null) {
            return g(NanoHTTPD.Response.Status.BAD_REQUEST, "{\"error\":\"task required (String)\"}");
        }
        long jOptLong = jSONObjectL.optLong("timeoutMs", 60000L);
        String strH = a1.a.h("agentcall-debug-", System.nanoTime());
        String strH2 = a1.a.h("ac-", System.nanoTime());
        try {
            try {
                j2 = jOptLong;
                try {
                    String string = ((JSONObject) d0.w(g7.m.f3866f, new i(j2, this, new c5.b("req", e0.U(new c7.j("type", "req"), new c7.j("id", strH2), new c7.j("method", "chat.send"), new c7.j("params", e0.U(new c7.j("sessionId", strH), new c7.j("text", strOptString), new c7.j("idempotencyKey", a1.a.w("ik-", strH2)))))), strH, null))).toString();
                    q7.k.d(string, "toString(...)");
                    return j(string);
                } catch (a2 unused) {
                    NanoHTTPD.Response.Status status = NanoHTTPD.Response.Status.REQUEST_TIMEOUT;
                    String string2 = new JSONObject().put("ok", false).put("error", new JSONObject().put("code", "AGENT_CALL_TIMEOUT").put(OAuthConstants.FACTOR_RESULT_MESSAGE, "agent.call timed out after " + j2 + "ms")).toString();
                    q7.k.d(string2, "toString(...)");
                    return g(status, string2);
                }
            } catch (a2 unused2) {
                j2 = jOptLong;
            }
        } catch (Throwable th) {
            k5.s.warn$default(this.f10172d, "RestApiServer", a1.a.w("agent.call debug failed: ", th.getMessage()), null, 4, null);
            NanoHTTPD.Response.Status status2 = NanoHTTPD.Response.Status.INTERNAL_ERROR;
            JSONObject jSONObjectPut = new JSONObject().put("ok", false);
            JSONObject jSONObjectPut2 = new JSONObject().put("code", "AGENT_CALL_FAILED");
            String message = th.getMessage();
            if (message == null) {
                message = "";
            }
            String string3 = jSONObjectPut.put("error", jSONObjectPut2.put(OAuthConstants.FACTOR_RESULT_MESSAGE, message)).toString();
            q7.k.d(string3, "toString(...)");
            return g(status2, string3);
        }
    }

    public final NanoHTTPD.Response b(NanoHTTPD.IHTTPSession iHTTPSession) throws JSONException, IOException {
        String str;
        String str2;
        HttpURLConnection httpURLConnection;
        OutputStream outputStream;
        String strW;
        String str3;
        Object objN;
        BufferedReader bufferedReader;
        String strW2;
        String str4;
        Object objN2;
        JSONObject jSONObjectL = l(iHTTPSession);
        String strOptString = jSONObjectL.optString("tool");
        q7.k.b(strOptString);
        if (strOptString.length() <= 0) {
            strOptString = null;
        }
        v4.k kVar = this.f10170b;
        if (strOptString != null) {
            long jOptLong = jSONObjectL.optLong("timeoutMs", 20000L);
            String strH = a1.a.h("tool-", System.nanoTime());
            String rootfsBase = kVar.f10423b.getResource().getRootfsBase();
            String strV = n7.o.v(ga.k.t0(rootfsBase) ? "/mnt/openclaw/rootfs" : rootfsBase);
            if (strV == null) {
                NanoHTTPD.Response.Status status = NanoHTTPD.Response.Status.BAD_REQUEST;
                String string = new JSONObject().put("invocationId", strH).put("ok", false).put("error", new JSONObject().put("code", "NO_GATEWAY_TOKEN").put(OAuthConstants.FACTOR_RESULT_MESSAGE, "gateway.auth.token unavailable; ensure stepclaw gateway is up")).toString();
                q7.k.d(string, "toString(...)");
                return g(status, string);
            }
            try {
                URLConnection uRLConnectionOpenConnection = new URL("http://127.0.0.1:18789/plugins/stepclaw-exec/run").openConnection();
                q7.k.c(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) uRLConnectionOpenConnection;
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setConnectTimeout(3000);
                httpURLConnection2.setReadTimeout((int) (jOptLong + NanoHTTPD.SOCKET_READ_TIMEOUT));
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setRequestProperty("Authorization", "Bearer ".concat(strV));
                httpURLConnection2.setRequestProperty("Content-Type", "application/json");
                outputStream = httpURLConnection2.getOutputStream();
                try {
                    String string2 = jSONObjectL.toString();
                    q7.k.d(string2, "toString(...)");
                    Charset charset = ga.a.f4005a;
                    byte[] bytes = string2.getBytes(charset);
                    q7.k.d(bytes, "getBytes(...)");
                    outputStream.write(bytes);
                    outputStream.close();
                    int responseCode = httpURLConnection2.getResponseCode();
                    InputStream errorStream = (200 > responseCode || responseCode >= 300) ? httpURLConnection2.getErrorStream() : httpURLConnection2.getInputStream();
                    if (errorStream != null) {
                        bufferedReader = new BufferedReader(new InputStreamReader(errorStream, charset), NanoHTTPD.HTTPSession.BUFSIZE);
                        try {
                            strW2 = n7.o.w(bufferedReader);
                            bufferedReader.close();
                        } finally {
                        }
                    } else {
                        strW2 = "";
                    }
                    JSONObject jSONObjectPut = new JSONObject().put("invocationId", strH);
                    if ((200 > responseCode || responseCode >= 300) && !o4.a.e(strW2)) {
                        j0 j0Var = o4.a.h(responseCode, strW2).f7436c;
                        JSONObject jSONObjectPut2 = jSONObjectPut.put("ok", false);
                        JSONObject jSONObjectPut3 = new JSONObject().put("code", j0Var != null ? j0Var.f7405a : "PLUGIN_REJECTED");
                        if (j0Var != null) {
                            str4 = j0Var.f7406b;
                        } else {
                            str4 = "HTTP " + responseCode;
                        }
                        jSONObjectPut2.put("error", jSONObjectPut3.put(OAuthConstants.FACTOR_RESULT_MESSAGE, str4));
                        NanoHTTPD.Response.Status statusLookup = NanoHTTPD.Response.Status.lookup(responseCode);
                        if (statusLookup == null) {
                            statusLookup = NanoHTTPD.Response.Status.INTERNAL_ERROR;
                        }
                        String string3 = jSONObjectPut.toString();
                        q7.k.d(string3, "toString(...)");
                        return g(statusLookup, string3);
                    }
                    try {
                        objN2 = new JSONObject(strW2);
                    } catch (Throwable th) {
                        objN2 = w7.e0.n(th);
                    }
                    if (c7.m.a(objN2) != null) {
                        objN2 = new JSONObject();
                    }
                    JSONObject jSONObject = (JSONObject) objN2;
                    boolean zOptBoolean = jSONObject.optBoolean("ok", true);
                    jSONObjectPut.put("ok", zOptBoolean);
                    if (zOptBoolean) {
                        jSONObjectPut.put("result", jSONObject);
                    } else {
                        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("error");
                        if (jSONObjectOptJSONObject == null) {
                            jSONObjectOptJSONObject = new JSONObject().put("code", "TOOL_FAILED");
                        }
                        jSONObjectPut.put("error", jSONObjectOptJSONObject);
                    }
                    String string4 = jSONObjectPut.toString();
                    q7.k.d(string4, "toString(...)");
                    return j(string4);
                } finally {
                }
            } catch (Throwable th2) {
                k5.s.warn$default(this.f10172d, "RestApiServer", a1.a.w("stepclaw-exec tool invoke failed: ", th2.getMessage()), null, 4, null);
                NanoHTTPD.Response.Status status2 = NanoHTTPD.Response.Status.INTERNAL_ERROR;
                JSONObject jSONObjectPut4 = new JSONObject().put("invocationId", strH).put("ok", false);
                JSONObject jSONObjectPut5 = new JSONObject().put("code", "PLUGIN_INVOKE_FAILED");
                String message = th2.getMessage();
                if (message == null) {
                    message = "";
                }
                String string5 = jSONObjectPut4.put("error", jSONObjectPut5.put(OAuthConstants.FACTOR_RESULT_MESSAGE, message)).toString();
                q7.k.d(string5, "toString(...)");
                return g(status2, string5);
            }
        } else {
            JSONArray jSONArrayOptJSONArray = jSONObjectL.optJSONArray("argv");
            if (jSONArrayOptJSONArray == null) {
                return g(NanoHTTPD.Response.Status.BAD_REQUEST, "{\"error\":\"argv required (JSONArray)\"}");
            }
            v7.d dVarN = nb.i.N(0, jSONArrayOptJSONArray.length());
            ArrayList arrayList = new ArrayList(d7.t.A0(dVarN, 10));
            Iterator it = dVarN.iterator();
            while (true) {
                v7.c cVar = (v7.c) it;
                Iterator it2 = it;
                if (!cVar.f10528h) {
                    break;
                }
                arrayList.add(jSONArrayOptJSONArray.getString(cVar.nextInt()));
                it = it2;
            }
            if (arrayList.isEmpty()) {
                return g(NanoHTTPD.Response.Status.BAD_REQUEST, "{\"error\":\"argv must not be empty\"}");
            }
            long jOptLong2 = jSONObjectL.optLong("timeoutMs", 30000L);
            String strH2 = a1.a.h("sysrun-", System.nanoTime());
            String rootfsBase2 = kVar.f10423b.getResource().getRootfsBase();
            if (ga.k.t0(rootfsBase2)) {
                rootfsBase2 = "/mnt/openclaw/rootfs";
            }
            String strV2 = n7.o.v(rootfsBase2);
            if (strV2 == null) {
                NanoHTTPD.Response.Status status3 = NanoHTTPD.Response.Status.BAD_REQUEST;
                String string6 = new JSONObject().put("invocationId", strH2).put("ok", false).put("error", new JSONObject().put("code", "NO_GATEWAY_TOKEN").put(OAuthConstants.FACTOR_RESULT_MESSAGE, "gateway.auth.token unavailable; ensure stepclaw gateway is up")).toString();
                q7.k.d(string6, "toString(...)");
                return g(status3, string6);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("command", new JSONArray((Collection) arrayList));
            jSONObject2.put("timeoutMs", jOptLong2);
            try {
                URLConnection uRLConnectionOpenConnection2 = new URL("http://127.0.0.1:18789/plugins/stepclaw-exec/run").openConnection();
                q7.k.c(uRLConnectionOpenConnection2, "null cannot be cast to non-null type java.net.HttpURLConnection");
                httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection2;
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setConnectTimeout(3000);
                httpURLConnection.setReadTimeout((int) (jOptLong2 + NanoHTTPD.SOCKET_READ_TIMEOUT));
                httpURLConnection.setDoOutput(true);
                str2 = "Authorization";
                httpURLConnection.setRequestProperty(str2, "Bearer " + strV2);
                str = "Content-Type";
                httpURLConnection.setRequestProperty(str, "application/json");
                outputStream = httpURLConnection.getOutputStream();
            } catch (Throwable th3) {
                th = th3;
                str = "stepclaw-exec-plugin";
                str2 = "via";
            }
            try {
                try {
                    String string7 = jSONObject2.toString();
                    q7.k.d(string7, "toString(...)");
                    Charset charset2 = ga.a.f4005a;
                    byte[] bytes2 = string7.getBytes(charset2);
                    str2 = "getBytes(...)";
                    q7.k.d(bytes2, str2);
                    outputStream.write(bytes2);
                    outputStream.close();
                    int responseCode2 = httpURLConnection.getResponseCode();
                    InputStream errorStream2 = (200 > responseCode2 || responseCode2 >= 300) ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream();
                    if (errorStream2 != null) {
                        bufferedReader = new BufferedReader(new InputStreamReader(errorStream2, charset2), NanoHTTPD.HTTPSession.BUFSIZE);
                        try {
                            strW = n7.o.w(bufferedReader);
                            bufferedReader.close();
                        } finally {
                            try {
                                throw th;
                            } finally {
                            }
                        }
                    } else {
                        strW = "";
                    }
                    str = "stepclaw-exec-plugin";
                    str2 = "via";
                    JSONObject jSONObjectPut6 = new JSONObject().put("invocationId", strH2).put(str2, str);
                    if ((200 > responseCode2 || responseCode2 >= 300) && !o4.a.e(strW)) {
                        j0 j0Var2 = o4.a.h(responseCode2, strW).f7436c;
                        JSONObject jSONObjectPut7 = jSONObjectPut6.put("ok", false);
                        JSONObject jSONObjectPut8 = new JSONObject().put("code", j0Var2 != null ? j0Var2.f7405a : "PLUGIN_REJECTED");
                        if (j0Var2 != null) {
                            str3 = j0Var2.f7406b;
                        } else {
                            str3 = "HTTP " + responseCode2;
                        }
                        jSONObjectPut7.put("error", jSONObjectPut8.put(OAuthConstants.FACTOR_RESULT_MESSAGE, str3));
                        NanoHTTPD.Response.Status statusLookup2 = NanoHTTPD.Response.Status.lookup(responseCode2);
                        if (statusLookup2 == null) {
                            statusLookup2 = NanoHTTPD.Response.Status.INTERNAL_ERROR;
                        }
                        String string8 = jSONObjectPut6.toString();
                        q7.k.d(string8, "toString(...)");
                        return g(statusLookup2, string8);
                    }
                    try {
                        objN = new JSONObject(strW);
                    } catch (Throwable th4) {
                        objN = w7.e0.n(th4);
                    }
                    if (c7.m.a(objN) != null) {
                        objN = new JSONObject();
                    }
                    jSONObjectPut6.put("ok", true).put("payload", (JSONObject) objN);
                    String string9 = jSONObjectPut6.toString();
                    q7.k.d(string9, "toString(...)");
                    return j(string9);
                } finally {
                }
            } catch (Throwable th5) {
                th = th5;
                k5.s.warn$default(this.f10172d, "RestApiServer", a1.a.w("stepclaw-exec plugin invoke failed: ", th.getMessage()), null, 4, null);
                NanoHTTPD.Response.Status status4 = NanoHTTPD.Response.Status.INTERNAL_ERROR;
                JSONObject jSONObjectPut9 = new JSONObject().put("invocationId", strH2).put("ok", false).put(str2, str);
                JSONObject jSONObjectPut10 = new JSONObject().put("code", "PLUGIN_INVOKE_FAILED");
                String message2 = th.getMessage();
                if (message2 == null) {
                    message2 = "";
                }
                String string10 = jSONObjectPut9.put("error", jSONObjectPut10.put(OAuthConstants.FACTOR_RESULT_MESSAGE, message2)).toString();
                q7.k.d(string10, "toString(...)");
                return g(status4, string10);
            }
        }
    }

    public final NanoHTTPD.Response c(NanoHTTPD.IHTTPSession iHTTPSession, String str) throws JSONException, IOException {
        ga.h hVarA = ga.i.a(f10166l, str);
        q7.k.b(hVarA);
        t tVar = (t) this.f10176h.get((String) ((h0) hVarA.a()).get(1));
        if (tVar == null) {
            throw new IllegalStateException("unknown token");
        }
        JSONObject jSONObjectL = l(iHTTPSession);
        d0.s(this.f10177i, null, null, new j(tVar, q5.r.a(a1.a.h("cancel-", System.nanoTime()), "stepclaw.agentbus.local", "stepclaw.invoke.cancel", e0.U(new c7.j("invocationId", jSONObjectL.getString("invocationId")), new c7.j("reason", jSONObjectL.optString("reason", "user.canceled"))), null, 112), null), 3);
        NanoHTTPD.Response responseNewFixedLengthResponse = NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.ACCEPTED, "application/json", "{}");
        q7.k.d(responseNewFixedLengthResponse, "newFixedLengthResponse(...)");
        return responseNewFixedLengthResponse;
    }

    public final NanoHTTPD.Response d(NanoHTTPD.IHTTPSession iHTTPSession, String str) throws JSONException, IOException {
        ga.h hVarA = ga.i.a(f10164j, str);
        q7.k.b(hVarA);
        t tVar = (t) this.f10176h.get((String) ((h0) hVarA.a()).get(1));
        if (tVar == null) {
            throw new IllegalStateException("unknown token");
        }
        JSONObject jSONObjectL = l(iHTTPSession);
        String string = jSONObjectL.getString("sessionId");
        String string2 = jSONObjectL.getString("text");
        String strOptString = jSONObjectL.optString("idempotencyKey");
        if (ga.k.t0(strOptString)) {
            strOptString = "rest-" + System.nanoTime() + "-ik";
        }
        String strH = a1.a.h("rest-", System.nanoTime());
        Map mapU = e0.U(new c7.j("sessionId", string), new c7.j("text", string2), new c7.j("idempotencyKey", strOptString));
        q7.k.e(strH, "id");
        c5.b bVar = new c5.b("req", e0.U(new c7.j("type", "req"), new c7.j("id", strH), new c7.j("method", "chat.send"), new c7.j("params", mapU)));
        d0.s(this.f10177i, null, null, new k(tVar, bVar, null), 3);
        NanoHTTPD.Response responseNewFixedLengthResponse = NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.ACCEPTED, "application/json", a1.a.j("{\"frameId\":\"", bVar.b(), "\"}"));
        q7.k.d(responseNewFixedLengthResponse, "newFixedLengthResponse(...)");
        return responseNewFixedLengthResponse;
    }

    public final NanoHTTPD.Response e(String str) {
        ga.h hVarA = ga.i.a(f10165k, str);
        q7.k.b(hVarA);
        t tVar = (t) this.f10176h.get((String) ((h0) hVarA.a()).get(1));
        if (tVar == null) {
            throw new IllegalStateException("unknown token");
        }
        PipedInputStream pipedInputStream = new PipedInputStream(65536);
        d0.s(this.f10177i, null, null, new l(tVar, this, new PrintWriter((OutputStream) new PipedOutputStream(pipedInputStream), true), null), 3);
        NanoHTTPD.Response responseNewChunkedResponse = NanoHTTPD.newChunkedResponse(NanoHTTPD.Response.Status.OK, "text/event-stream", pipedInputStream);
        responseNewChunkedResponse.addHeader("Cache-Control", "no-cache");
        responseNewChunkedResponse.addHeader("X-Accel-Buffering", "no");
        return responseNewChunkedResponse;
    }

    public final NanoHTTPD.Response f() throws JSONException {
        y4.o oVarK = this.f10170b.f10444l0.k();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cloud", o(oVarK.f11630a));
        jSONObject.put("edge", o(oVarK.f11631b));
        String string = jSONObject.toString();
        q7.k.d(string, "toString(...)");
        return j(string);
    }

    public final NanoHTTPD.Response h(String str) throws UnsupportedEncodingException {
        ga.h hVarA = ga.i.a(f10167m, str);
        q7.k.b(hVarA);
        t tVar = (t) this.f10176h.get((String) ((h0) hVarA.a()).get(1));
        if (tVar == null) {
            throw new IllegalStateException("unknown token");
        }
        c5.b bVar = (c5.b) d0.w(g7.m.f3866f, new n(tVar, null));
        if (bVar != null) {
            return j(this.f10174f.b(bVar));
        }
        NanoHTTPD.Response responseNewFixedLengthResponse = NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.NO_CONTENT, NanoHTTPD.MIME_PLAINTEXT, "");
        q7.k.d(responseNewFixedLengthResponse, "newFixedLengthResponse(...)");
        return responseNewFixedLengthResponse;
    }

    public final NanoHTTPD.Response i(NanoHTTPD.IHTTPSession iHTTPSession, String str) throws JSONException, IOException {
        c5.b bVarB;
        Map linkedHashMap;
        ga.h hVarA = ga.i.a(f10168n, str);
        q7.k.b(hVarA);
        String str2 = (String) ((h0) hVarA.a()).get(1);
        String str3 = (String) ((h0) hVarA.a()).get(2);
        t tVar = (t) this.f10176h.get(str2);
        if (tVar == null) {
            throw new IllegalStateException("unknown token");
        }
        String str4 = tVar.f10178a;
        JSONObject jSONObjectL = l(iHTTPSession);
        if (jSONObjectL.getBoolean("ok")) {
            JSONObject jSONObjectOptJSONObject = jSONObjectL.optJSONObject("payload");
            if (jSONObjectOptJSONObject != null) {
                linkedHashMap = new LinkedHashMap();
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                q7.k.d(itKeys, "keys(...)");
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    linkedHashMap.put(next, jSONObjectOptJSONObject.opt(next));
                }
            } else {
                linkedHashMap = a0.f2944f;
            }
            q7.k.e(str3, "invocationId");
            q7.k.e(str4, "nodeId");
            String strH = a1.a.h("iv-res-", System.nanoTime());
            Map mapU = e0.U(new c7.j("id", str3), new c7.j("nodeId", str4), new c7.j("ok", Boolean.TRUE), new c7.j("payload", linkedHashMap));
            q7.k.e(strH, "id");
            bVarB = new c5.b("req", e0.U(new c7.j("type", "req"), new c7.j("id", strH), new c7.j("method", "node.invoke.result"), new c7.j("params", mapU)));
        } else {
            JSONObject jSONObject = jSONObjectL.getJSONObject("error");
            String string = jSONObject.getString("code");
            q7.k.d(string, "getString(...)");
            String strOptString = jSONObject.optString(OAuthConstants.FACTOR_RESULT_MESSAGE);
            q7.k.d(strOptString, "optString(...)");
            bVarB = q5.r.b(str3, str4, string, strOptString, jSONObject.optBoolean("retryable", false));
        }
        d0.s(this.f10177i, null, null, new o(tVar, bVarB, null), 3);
        return j("{}");
    }

    public final NanoHTTPD.Response k(NanoHTTPD.IHTTPSession iHTTPSession) throws JSONException, IOException {
        JSONObject jSONObjectL = l(iHTTPSession);
        String strOptString = jSONObjectL.optString("text", "");
        JSONArray jSONArrayOptJSONArray = jSONObjectL.optJSONArray("attachments");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null) {
            int length = jSONArrayOptJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(i2);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Iterator<String> itKeys = jSONObject.keys();
                q7.k.d(itKeys, "keys(...)");
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    linkedHashMap.put(next, jSONObject.get(next));
                }
                arrayList.add(linkedHashMap);
            }
        }
        String strH = a1.a.h("rest-privacy-", System.nanoTime());
        Map mapU = e0.U(new c7.j("text", strOptString), new c7.j("attachments", arrayList));
        q7.k.e(strH, "id");
        try {
            return (NanoHTTPD.Response) d0.w(g7.m.f3866f, new q(this, new c5.b("req", e0.U(new c7.j("type", "req"), new c7.j("id", strH), new c7.j("method", "privacy.check"), new c7.j("params", mapU))), null));
        } catch (Exception e10) {
            NanoHTTPD.Response.Status status = NanoHTTPD.Response.Status.INTERNAL_ERROR;
            String string = new JSONObject().put("error", e10.getMessage()).toString();
            q7.k.d(string, "toString(...)");
            return g(status, string);
        }
    }

    public final NanoHTTPD.Response m(NanoHTTPD.IHTTPSession iHTTPSession) throws JSONException {
        String strOptString = l(iHTTPSession).optString("clientId");
        if (ga.k.t0(strOptString)) {
            strOptString = "rest.channel." + UUID.randomUUID();
        }
        String str = strOptString;
        String string = UUID.randomUUID().toString();
        q7.k.d(string, "toString(...)");
        String strL0 = ga.k.L0(24, ga.r.e0(string, "-", ""));
        t tVar = new t("rest-ch-".concat(strL0), d5.m.CHANNEL, str, this.f10170b, this.f10171c, this.f10172d);
        this.f10176h.put(strL0, tVar);
        tVar.j();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("token", strL0);
        jSONObject.put("eventsUrl", "/v1/channels/" + strL0 + "/events");
        String string2 = jSONObject.toString();
        q7.k.d(string2, "toString(...)");
        return j(string2);
    }

    public final NanoHTTPD.Response n(NanoHTTPD.IHTTPSession iHTTPSession) throws JSONException, IOException {
        JSONObject jSONObjectL = l(iHTTPSession);
        String string = jSONObjectL.getString("clientId");
        JSONArray jSONArray = jSONObjectL.getJSONArray("caps");
        v7.d dVarN = nb.i.N(0, jSONArray.length());
        ArrayList arrayList = new ArrayList(d7.t.A0(dVarN, 10));
        Iterator it = dVarN.iterator();
        while (true) {
            v7.c cVar = (v7.c) it;
            if (!cVar.f10528h) {
                String string2 = UUID.randomUUID().toString();
                q7.k.d(string2, "toString(...)");
                String strL0 = ga.k.L0(24, ga.r.e0(string2, "-", ""));
                String strConcat = "rest-node-".concat(strL0);
                d5.m mVar = d5.m.NODE;
                k5.a aVar = this.f10171c;
                k5.t tVar = this.f10172d;
                v4.k kVar = this.f10170b;
                t tVar2 = new t(strConcat, mVar, string, kVar, aVar, tVar);
                this.f10176h.put(strL0, tVar2);
                tVar2.j();
                kVar.f10443l.r(strConcat, arrayList);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("token", strL0);
                jSONObject.put("pollUrl", "/v1/nodes/" + strL0 + "/invokes");
                String string3 = jSONObject.toString();
                q7.k.d(string3, "toString(...)");
                return j(string3);
            }
            arrayList.add(jSONArray.getString(cVar.nextInt()));
        }
    }
}
