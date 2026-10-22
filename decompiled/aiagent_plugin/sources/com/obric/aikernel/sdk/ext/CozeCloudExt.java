package com.obric.aikernel.sdk.ext;

import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.o;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: CozeCloudExt.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CozeCloudExt {
    public static final String API_KEY_APP_ID = "app_id";
    public static final String API_KEY_BOE_ENV = "boe_env";
    public static final String API_KEY_BUSINESS_TYPE = "business_type";
    public static final String API_KEY_CLOUD_BODY_KEY = "cozeKeyBody";
    public static final String API_KEY_CLOUD_EXTEND_MAP = "extend";
    public static final String API_KEY_CLOUD_Header_KEY = "cozeKeyHeader";
    public static final String API_KEY_CLOUD_QUERY_KEY = "cozeKeyQuery";
    public static final String API_KEY_HTTP_METHOD = "method";
    public static final String API_KEY_HTTP_POST_METHOD = "post";
    public static final String API_KEY_HTTP_STREAM_METHOD = "stream";
    public static final String API_KEY_PAYLOAD = "payload";
    public static final String API_KEY_STATUS = "status";
    public static final CozeCloudExt INSTANCE = null;

    static {
        INSTANCE = new CozeCloudExt();
    }

    private CozeCloudExt() {
    }

    public static /* synthetic */ Bundle buildControlParams$default(CozeCloudExt r0, String r1, String r2, Bundle r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = "";
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = null;
    L9:
        return r0.buildControlParams(r1, r2, r3);
    }

    public final Bundle buildControlParams(String r2, String r3, Bundle r4) {
        o.e(r2, "method");
        o.e(r3, "boeEnv");
        Bundle r0 = new Bundle();
        r0.putString("method", r2);
        r0.putString(API_KEY_BOE_ENV, r3);
        if (r4 == null) goto L5;
        r0.putAll(r4);
    L5:
        return r0;
    }

    public static /* synthetic */ Map buildQueryParams$default(CozeCloudExt r1, String r2, Map r3, int r4, Object r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L6;
        r6 = ao.b();
    L6:
        return r1.buildQueryParams(r2, r6);
    }

    public final Map<String, String> buildQueryParams(String r3, Map<String, String> r4) {
        Map<? extends String, ? extends String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        o.e(r3, "businessType");
        o.e(r2, "extraParams");
        Map<String, String> r5 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        r5.put(API_KEY_BUSINESS_TYPE, r3);
        if ((!r2.isEmpty()) == false) goto L5;
        r5.putAll(r2);
    L5:
        return r5;
    }

    public static /* synthetic */ Map buildBodyParams$default(CozeCloudExt r1, int r2, String r3, Map r4, Map r5, int r6, Object r7) {
        Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        Map<String, String> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if ((r6 & 4) == 0) goto L6;
        r8 = ao.b();
    L6:
        if ((r6 & 8) == 0) goto L9;
        r9 = ao.b();
    L9:
        return r1.buildBodyParams(r2, r3, r8, r9);
    }

    public final Map<String, Object> buildBodyParams(int r4, String r5, Map<String, String> r6, Map<String, String> r7) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        Map<? extends String, ? extends Object> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        o.e(r5, "payLoad");
        o.e(r3, API_KEY_CLOUD_EXTEND_MAP);
        o.e(r8, "extraParams");
        Map<String, Object> r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        r0.put("payload", r5);
        r0.put("app_id", Integer.valueOf(r4));
        if ((!r3.isEmpty()) == false) goto L6;
        r0.put(API_KEY_CLOUD_EXTEND_MAP, r3);
    L6:
        if ((!r8.isEmpty()) == false) goto L8;
        r0.putAll(r8);
    L8:
        return r0;
    }

    public static /* synthetic */ Map buildHeaderParams$default(CozeCloudExt r1, Map r2, int r3, Object r4) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L6;
        r5 = ao.b();
    L6:
        return r1.buildHeaderParams(r5);
    }

    public final Map<String, String> buildHeaderParams(Map<String, String> r3) {
        Map<? extends String, ? extends String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        o.e(r2, "extraParams");
        Map<String, String> r4 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        if ((!r2.isEmpty()) == false) goto L5;
        r4.putAll(r2);
    L5:
        return r4;
    }

    public static /* synthetic */ Bundle buildCozeIPCBundle$default(CozeCloudExt r1, Bundle r2, Map r3, Map r4, Map r5, int r6, Object r7) {
        Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        Map<String, Object> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        Map<String, String> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if ((r6 & 4) == 0) goto L6;
        r10 = null;
    L6:
        return r1.buildCozeIPCBundle(r2, r8, r9, r10);
    }

    public final Bundle buildCozeIPCBundle(Bundle r2, Map<String, String> r3, Map<String, Object> r4, Map<String, String> r5) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        o.e(r2, "<this>");
        o.e(r1, "queryParams");
        o.e(r6, "bodyParams");
        r2.putSerializable(API_KEY_CLOUD_BODY_KEY, (Serializable) ZeusTransformUtils.preCheckCast(r6, Serializable.class, "com.obric.aiagent.plugin"));
        r2.putSerializable(API_KEY_CLOUD_QUERY_KEY, (Serializable) ZeusTransformUtils.preCheckCast(r1, Serializable.class, "com.obric.aiagent.plugin"));
        if (r7 == null) goto L5;
        r2.putSerializable(API_KEY_CLOUD_Header_KEY, (Serializable) ZeusTransformUtils.preCheckCast(r7, Serializable.class, "com.obric.aiagent.plugin"));
    L5:
        return r2;
    }
}
