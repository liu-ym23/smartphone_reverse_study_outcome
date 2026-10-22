package com.stepos.stepclaw.base.net;

import c5.l;
import c5.n;
import c5.o;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.base.util.ALog;
import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
import d5.c;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k4.v;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import m0.f;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import u5.e;
import w5.k;
import x5.u;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 82\u00020\u0001:\u00018B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0004¢\u0006\u0004\b\u001f\u0010 J%\u0010$\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u0018¢\u0006\u0004\b$\u0010%J\u001d\u0010&\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b&\u0010'J#\u0010*\u001a\u00020\u000b2\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020(¢\u0006\u0004\b*\u0010+J%\u0010/\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u00182\u0006\u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u0012¢\u0006\u0004\b/\u00100R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00101R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u00102R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020\u0012038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107¨\u00069"}, d2 = {"Lcom/stepos/stepclaw/base/net/ProxyDiagnostics;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "clientId", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "captureUpstreamUsage", "<init>", "(Ljava/lang/String;Z)V", "Lorg/json/JSONArray;", "messages", ConfigIpcContract.KEY_MODEL, "Lb5/a0;", "logPreInjectSummary", "(Lorg/json/JSONArray;Ljava/lang/String;)V", "Lorg/json/JSONObject;", "msg", "summarizeMessage", "(Lorg/json/JSONObject;)Ljava/lang/String;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "mergeCapture", "()[B", "contentType", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "totalStreamBytes", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "captureBytes", "body", "logBffUsageFromCapture", "(Ljava/lang/String;JI[B)V", "bodyBytes", "enablePromptCache", "injectCacheControl", "([BZ)[B", "data", "offset", "length", "captureUpstreamChunk", "([BII)V", "flushUpstreamUsageLog", "(Ljava/lang/String;J)V", "Lkotlin/Function1;", "headerLookup", "logCacheResponseHeaders", "(Lp5/l;)V", "chunkCount", "readBytes", "buffer", "logChunkPreview", "(II[B)V", "Ljava/lang/String;", "Z", "Ljava/util/ArrayDeque;", "tailChunks", "Ljava/util/ArrayDeque;", "tailCaptureTotal", "I", "Companion", "step-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ProxyDiagnostics {
    private static final String TAG = "StepOSProxyServer";
    private static final int UPSTREAM_USAGE_CAPTURE_MAX_BYTES = 524288;
    private final boolean captureUpstreamUsage;
    private final String clientId;
    private int tailCaptureTotal;
    private final ArrayDeque<byte[]> tailChunks;
    private static final List<String> CACHE_HINT_HEADERS = n.k0("x-cache", "x-cache-status", "x-openai-cache", "x-dashscope-cache", "x-usage-cache");

    public ProxyDiagnostics(String clientId, boolean z) {
        p.e(clientId, "clientId");
        this.clientId = clientId;
        this.captureUpstreamUsage = z;
        this.tailChunks = new ArrayDeque<>();
    }

    private final void logBffUsageFromCapture(String contentType, long totalStreamBytes, int captureBytes, byte[] body) {
        String strConcat;
        if (body.length == 0) {
            ALog.d$default(TAG, f.d("[", this.clientId, "] bff-upstream: capture empty"), null, 4, null);
            return;
        }
        try {
            String str = new String(body, x5.a.f6276a);
            c cVarP = a.a.p();
            if (x5.n.g1(str, "cached_tokens", true)) {
                cVarP.add("cached_tokens");
            }
            if (x5.n.g1(str, "cache_creation", true)) {
                cVarP.add("cache_creation");
            }
            if (x5.n.g1(str, "prompt_tokens_details", true)) {
                cVarP.add("prompt_tokens_details");
            }
            if (x5.n.g1(str, "\"usage\"", true)) {
                cVarP.add("\"usage\"");
            }
            if (x5.n.g1(str, "cache_read", true)) {
                cVarP.add("cache_read");
            }
            if (x5.n.g1(str, "cache_write", true)) {
                cVarP.add("cache_write");
            }
            c cVarE = a.a.e(cVarP);
            StringBuilder sbV = a8.b.v("[", this.clientId, "] bff-upstream: contentType=", contentType, " streamBytes=");
            sbV.append(totalStreamBytes);
            sbV.append(" tailCaptureBytes=");
            sbV.append(captureBytes);
            sbV.append(" keywords=");
            sbV.append(cVarE);
            ALog.d$default(TAG, sbV.toString(), null, 4, null);
            Iterator it = x5.n.x1(str).iterator();
            String str2 = null;
            while (true) {
                x5.f fVar = (x5.f) it;
                if (!fVar.hasNext()) {
                    break;
                }
                String string = x5.n.T1((String) fVar.next()).toString();
                if (u.c1(string, "data:", true) && x5.n.g1(string, "\"usage\"", false)) {
                    str2 = string;
                }
            }
            if (str2 != null) {
                if (str2.length() > 4500) {
                    String strSubstring = str2.substring(0, 4500);
                    p.d(strSubstring, "substring(...)");
                    strConcat = strSubstring.concat("…(truncated)");
                } else {
                    strConcat = str2;
                }
                StringBuilder sbU = a8.b.u("[", str2.length(), this.clientId, "] bff-upstream: last SSE data: line containing usage (len=", "): ");
                sbU.append(strConcat);
                ALog.i$default(TAG, sbU.toString(), null, 4, null);
                return;
            }
            int iV1 = x5.n.v1(6, str, "\"usage\"");
            if (iV1 >= 0) {
                int iMin = Math.min(iV1 + 4500, str.length());
                String strSubstring2 = str.substring(iV1, iMin);
                p.d(strSubstring2, "substring(...)");
                ALog.i$default(TAG, a8.b.p("[", this.clientId, "] bff-upstream: tail JSON near \"usage\": ", strSubstring2.concat(iMin >= str.length() ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : "…(truncated)")), null, 4, null);
                return;
            }
            ALog.w$default(TAG, "[" + this.clientId + "] bff-upstream: no \"usage\" in captured tail (" + captureBytes + " bytes). Either BFF omitted usage, tail shorter than UPSTREAM_USAGE_CAPTURE_MAX_BYTES, or non-text body.", null, 4, null);
        } catch (Exception e9) {
            ALog.w$default(TAG, a8.b.p("[", this.clientId, "] bff-upstream: UTF-8 decode failed: ", e9.getMessage()), null, 4, null);
        }
    }

    private final void logPreInjectSummary(JSONArray messages, String model) {
        JSONObject jSONObjectOptJSONObject;
        String strOptString;
        u5.f fVarR0 = v.r0(0, Math.min(5, messages.length()));
        ArrayList arrayList = new ArrayList(o.n0(fVarR0, 10));
        Iterator it = fVarR0.iterator();
        while (it.hasNext()) {
            JSONObject jSONObjectOptJSONObject2 = messages.optJSONObject(((e) it).nextInt());
            String str = "?";
            if (jSONObjectOptJSONObject2 != null && (strOptString = jSONObjectOptJSONObject2.optString("role", "?")) != null) {
                str = strOptString;
            }
            arrayList.add(str);
        }
        StringBuilder sbU = a8.b.u("[", messages.length(), this.clientId, "] prompt-cache: messages.len=", " firstRoles=");
        sbU.append(arrayList);
        sbU.append(" model=");
        sbU.append(model);
        ALog.d$default(TAG, sbU.toString(), null, 4, null);
        JSONObject jSONObjectOptJSONObject3 = messages.optJSONObject(0);
        if (jSONObjectOptJSONObject3 != null) {
            ALog.d$default(TAG, a8.b.p("[", this.clientId, "] prompt-cache: pre-inject msg#0 ", summarizeMessage(jSONObjectOptJSONObject3)), null, 4, null);
        }
        if (messages.length() < 3 || (jSONObjectOptJSONObject = messages.optJSONObject(2)) == null) {
            return;
        }
        ALog.d$default(TAG, a8.b.p("[", this.clientId, "] prompt-cache: ref msg#2 ", summarizeMessage(jSONObjectOptJSONObject)), null, 4, null);
    }

    private final byte[] mergeCapture() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Iterator<byte[]> it = this.tailChunks.iterator();
        p.d(it, "iterator(...)");
        while (it.hasNext()) {
            byteArrayOutputStream.write(it.next());
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        p.d(byteArray, "toByteArray(...)");
        return byteArray;
    }

    private final String summarizeMessage(JSONObject msg) {
        String strOptString;
        String strOptString2;
        JSONObject jSONObjectOptJSONObject;
        String strOptString3 = msg.optString("role", "?");
        Object objOpt = msg.opt("content");
        if (objOpt instanceof String) {
            return "role=" + strOptString3 + " content=String(len=" + ((String) objOpt).length() + ")";
        }
        if (!(objOpt instanceof JSONArray)) {
            return objOpt == null ? f.d("role=", strOptString3, " content=null") : a8.b.p("role=", strOptString3, " content=", objOpt.getClass().getSimpleName());
        }
        JSONArray jSONArray = (JSONArray) objOpt;
        int length = jSONArray.length();
        JSONObject jSONObjectOptJSONObject2 = length > 0 ? jSONArray.optJSONObject(length - 1) : null;
        String str = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        if (jSONObjectOptJSONObject2 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("cache_control")) == null || (strOptString = jSONObjectOptJSONObject.optString("type", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID)) == null) {
            strOptString = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        if (jSONObjectOptJSONObject2 != null && (strOptString2 = jSONObjectOptJSONObject2.optString("type", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID)) != null) {
            str = strOptString2;
        }
        if (strOptString.length() == 0) {
            strOptString = "<none>";
        }
        StringBuilder sbU = a8.b.u("role=", length, strOptString3, " content=JSONArray(n=", " lastType=");
        sbU.append(str);
        sbU.append(" lastCacheControl=");
        sbU.append((Object) strOptString);
        sbU.append(")");
        return sbU.toString();
    }

    public final void captureUpstreamChunk(byte[] data, int offset, int length) {
        p.e(data, "data");
        if (!this.captureUpstreamUsage || length <= 0) {
            return;
        }
        this.tailChunks.addLast(l.Z(data, offset, offset + length));
        this.tailCaptureTotal += length;
        while (this.tailCaptureTotal > UPSTREAM_USAGE_CAPTURE_MAX_BYTES && !this.tailChunks.isEmpty()) {
            this.tailCaptureTotal -= this.tailChunks.removeFirst().length;
        }
    }

    public final void flushUpstreamUsageLog(String contentType, long totalStreamBytes) {
        p.e(contentType, "contentType");
        if (!this.captureUpstreamUsage || this.tailChunks.isEmpty()) {
            return;
        }
        byte[] bArrMergeCapture = mergeCapture();
        logBffUsageFromCapture(contentType, totalStreamBytes, bArrMergeCapture.length, bArrMergeCapture);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final byte[] injectCacheControl(byte[] bodyBytes, boolean enablePromptCache) throws JSONException {
        byte[] bArr;
        String str;
        int i8;
        JSONObject jSONObject;
        int i9;
        String str2;
        int i10;
        String str3 = "text";
        String str4 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        p.e(bodyBytes, "bodyBytes");
        if (!enablePromptCache) {
            ALog.d$default(TAG, f.d("[", this.clientId, "] prompt-cache: skip inject (enablePromptCache=false)"), null, 4, null);
            return bodyBytes;
        }
        if (bodyBytes.length == 0) {
            ALog.d$default(TAG, f.d("[", this.clientId, "] prompt-cache: skip inject (empty body)"), null, 4, null);
            return bodyBytes;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(new String(bodyBytes, x5.a.f6276a));
            if (!jSONObject2.has("messages")) {
                String str5 = this.clientId;
                Iterator<String> itKeys = jSONObject2.keys();
                p.d(itKeys, "keys(...)");
                ALog.d$default(TAG, "[" + str5 + "] prompt-cache: no top-level \"messages\" key, keys=" + k.x0(k.w0(itKeys)), null, 4, null);
                return bodyBytes;
            }
            JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray("messages");
            if (jSONArrayOptJSONArray == null) {
                ALog.d$default(TAG, "[" + this.clientId + "] prompt-cache: \"messages\" is null or not an array", null, 4, null);
                return bodyBytes;
            }
            String strOptString = jSONObject2.optString(ConfigIpcContract.KEY_MODEL, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
            p.d(strOptString, "optString(...)");
            logPreInjectSummary(jSONArrayOptJSONArray, strOptString);
            int length = jSONArrayOptJSONArray.length();
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            boolean z = false;
            int i14 = 0;
            int i15 = 0;
            while (i12 < length) {
                try {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i12);
                    if (jSONObjectOptJSONObject == null) {
                        str = str4;
                    } else {
                        String strOptString2 = jSONObjectOptJSONObject.optString("role", str4);
                        str = str4;
                        if (p.a(strOptString2, "system") || p.a(strOptString2, "developer")) {
                            int i16 = i13 + 1;
                            Object objOpt = jSONObjectOptJSONObject.opt("content");
                            i8 = length;
                            String simpleName = objOpt != null ? objOpt.getClass().getSimpleName() : AbstractJsonLexerKt.NULL;
                            jSONObject = jSONObject2;
                            i9 = i12;
                            ALog.d$default(TAG, "[" + this.clientId + "] prompt-cache: msg#" + i12 + " role=" + strOptString2 + " contentType=" + simpleName, null, 4, null);
                            if (objOpt instanceof String) {
                                JSONArray jSONArray = new JSONArray();
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put("type", str3);
                                jSONObject3.put(str3, objOpt);
                                str2 = str3;
                                jSONObject3.put("cache_control", new JSONObject().put("type", "ephemeral"));
                                jSONArray.put(jSONObject3);
                                jSONObjectOptJSONObject.put("content", jSONArray);
                                i11++;
                                ALog.d$default(TAG, "[" + this.clientId + "] prompt-cache: injected " + strOptString2 + " (string->array) textLen=" + ((String) objOpt).length(), null, 4, null);
                            } else {
                                str2 = str3;
                                if (!(objOpt instanceof JSONArray)) {
                                    i10 = i14;
                                    i15++;
                                    ALog.d$default(TAG, "[" + this.clientId + "] prompt-cache: skip " + strOptString2 + " (unsupported content shape: " + simpleName + ")", null, 4, null);
                                } else if (((JSONArray) objOpt).length() > 0) {
                                    JSONObject jSONObjectOptJSONObject2 = ((JSONArray) objOpt).optJSONObject(((JSONArray) objOpt).length() - 1);
                                    if (jSONObjectOptJSONObject2 == null) {
                                        i10 = i14;
                                        i15++;
                                        ALog.d$default(TAG, "[" + this.clientId + "] prompt-cache: skip " + strOptString2 + " (last content block not JSONObject)", null, 4, null);
                                    } else if (jSONObjectOptJSONObject2.has("cache_control")) {
                                        i14++;
                                        ALog.d$default(TAG, "[" + this.clientId + "] prompt-cache: skip " + strOptString2 + " (last block already has cache_control)", null, 4, null);
                                        i13 = i16;
                                    } else {
                                        jSONObjectOptJSONObject2.put("cache_control", new JSONObject().put("type", "ephemeral"));
                                        i11++;
                                        ALog.d$default(TAG, "[" + this.clientId + "] prompt-cache: injected " + strOptString2 + " (array last block)", null, 4, null);
                                        i14 = i14;
                                    }
                                } else {
                                    i10 = i14;
                                    ALog.d$default(TAG, "[" + this.clientId + "] prompt-cache: skip " + strOptString2 + " (empty content array)", null, 4, null);
                                    i15 = i15;
                                }
                                i14 = i10;
                                i13 = i16;
                            }
                            i13 = i16;
                            z = true;
                        }
                        i12 = i9 + 1;
                        str4 = str;
                        jSONObject2 = jSONObject;
                        length = i8;
                        str3 = str2;
                    }
                    str2 = str3;
                    i8 = length;
                    jSONObject = jSONObject2;
                    i9 = i12;
                    i12 = i9 + 1;
                    str4 = str;
                    jSONObject2 = jSONObject;
                    length = i8;
                    str3 = str2;
                } catch (Exception e9) {
                    e = e9;
                    bArr = bodyBytes;
                    ALog.w(TAG, a8.b.p("[", this.clientId, "] Failed to inject cache_control: ", e.getMessage()), e);
                    return bArr;
                }
            }
            JSONObject jSONObject4 = jSONObject2;
            int i17 = i14;
            int i18 = i15;
            if (i13 == 0) {
                ALog.d$default(TAG, "[" + this.clientId + "] prompt-cache: no system/developer messages in payload (OpenClaw may fold system into user or use another schema)", null, 4, null);
            }
            String str6 = this.clientId;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(str6);
            sb.append("] prompt-cache: summary systemDev=");
            sb.append(i13);
            sb.append(" injected=");
            sb.append(i11);
            sb.append(" skippedCached=");
            sb.append(i17);
            sb.append(" skippedUnknown=");
            sb.append(i18);
            sb.append(" modified=");
            sb.append(z);
            ALog.d$default(TAG, sb.toString(), null, 4, null);
            try {
                if (!z) {
                    ALog.w$default(TAG, "[" + this.clientId + "] prompt-cache: no cache_control changes applied (check roles/content types above; BFF may still ignore field)", null, 4, null);
                    return bodyBytes;
                }
                JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray.optJSONObject(0);
                if (jSONObjectOptJSONObject3 != null) {
                    ALog.d$default(TAG, "[" + this.clientId + "] prompt-cache: post-inject msg#0 " + summarizeMessage(jSONObjectOptJSONObject3), null, 4, null);
                }
                String string = jSONObject4.toString();
                p.d(string, "toString(...)");
                byte[] bytes = string.getBytes(x5.a.f6276a);
                p.d(bytes, "getBytes(...)");
                String str7 = this.clientId;
                ALog.i$default(TAG, "[" + str7 + "] cache_control injected, body size: " + bodyBytes.length + " -> " + bytes.length, null, 4, null);
                return bytes;
            } catch (Exception e10) {
                e = e10;
                bArr = sb;
                ALog.w(TAG, a8.b.p("[", this.clientId, "] Failed to inject cache_control: ", e.getMessage()), e);
                return bArr;
            }
        } catch (Exception e11) {
            e = e11;
            bArr = bodyBytes;
        }
    }

    public final void logCacheResponseHeaders(p5.l headerLookup) {
        p.e(headerLookup, "headerLookup");
        for (String str : CACHE_HINT_HEADERS) {
            String str2 = (String) headerLookup.invoke(str);
            if (str2 != null && !x5.n.t1(str2)) {
                StringBuilder sbV = a8.b.v("[", this.clientId, "] prompt-cache: response header ", str, "=");
                sbV.append(str2);
                ALog.d$default(TAG, sbV.toString(), null, 4, null);
            }
        }
    }

    public final void logChunkPreview(int chunkCount, int readBytes, byte[] buffer) {
        p.e(buffer, "buffer");
        String str = new String(buffer, 0, Math.min(readBytes, 500), x5.a.f6276a);
        StringBuilder sbU = a8.b.u("[", chunkCount, this.clientId, "] Chunk #", ": ");
        sbU.append(readBytes);
        sbU.append(" bytes, content: ");
        sbU.append(str);
        ALog.d$default(TAG, sbU.toString(), null, 4, null);
    }

    public /* synthetic */ ProxyDiagnostics(String str, boolean z, int i8, i iVar) {
        this(str, (i8 & 2) != 0 ? true : z);
    }
}
