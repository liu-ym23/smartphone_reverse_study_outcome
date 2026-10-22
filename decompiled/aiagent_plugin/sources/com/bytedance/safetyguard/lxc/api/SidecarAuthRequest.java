package com.bytedance.safetyguard.lxc.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: SidecarAuthApi.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SidecarAuthRequest {
    private final byte[] body;
    private final Map<String, String> headers;
    private final String method;
    private final String pathAndQuery;

    public static /* synthetic */ SidecarAuthRequest copy$default(SidecarAuthRequest r1, String r2, String r3, Map r4, byte[] r5, int r6, Object r7) {
        Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.method;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.pathAndQuery;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r8 = r1.headers;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r5 = r1.body;
    L15:
        return r1.copy(r2, r3, r8, r5);
    }

    public final String component1() {
        return this.method;
    }

    public final String component2() {
        return this.pathAndQuery;
    }

    public final Map<String, String> component3() {
        return this.headers;
    }

    public final byte[] component4() {
        return this.body;
    }

    public final SidecarAuthRequest copy(String r2, String r3, Map<String, String> r4, byte[] r5) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        o.e(r2, "method");
        o.e(r3, "pathAndQuery");
        o.e(r1, "headers");
        o.e(r5, "body");
        return new SidecarAuthRequest(r2, r3, r1, r5);
    }

    public String toString() {
        return "SidecarAuthRequest(method=" + this.method + ", pathAndQuery=" + this.pathAndQuery + ", headers=" + this.headers + ", body=" + Arrays.toString(this.body) + ')';
    }

    public SidecarAuthRequest(String r3, String r4, Map<String, String> r5, byte[] r6) {
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        o.e(r3, "method");
        o.e(r4, "pathAndQuery");
        o.e(r7, "headers");
        o.e(r6, "body");
        this.method = r3;
        this.pathAndQuery = r4;
        this.headers = r7;
        this.body = r6;
    }

    public final String getMethod() {
        return this.method;
    }

    public final String getPathAndQuery() {
        return this.pathAndQuery;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final byte[] getBody() {
        return this.body;
    }

    public boolean equals(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, SidecarAuthRequest.class) == true) goto L5;
    L13:
        return false;
    L5:
        if (o.a(this.method, ((SidecarAuthRequest) ZeusTransformUtils.preCheckCast(r5, SidecarAuthRequest.class, "com.obric.aiagent.plugin")).method) == false) goto L13;
        if (o.a(this.pathAndQuery, ((SidecarAuthRequest) ZeusTransformUtils.preCheckCast(r5, SidecarAuthRequest.class, "com.obric.aiagent.plugin")).pathAndQuery) == false) goto L13;
        if (o.a(this.headers, ((SidecarAuthRequest) ZeusTransformUtils.preCheckCast(r5, SidecarAuthRequest.class, "com.obric.aiagent.plugin")).headers) == false) goto L13;
        if (Arrays.equals(this.body, ((SidecarAuthRequest) ZeusTransformUtils.preCheckCast(r5, SidecarAuthRequest.class, "com.obric.aiagent.plugin")).body) == false) goto L13;
        return true;
    }

    public int hashCode() {
        return (((((this.method.hashCode() * 31) + this.pathAndQuery.hashCode()) * 31) + this.headers.hashCode()) * 31) + Arrays.hashCode(this.body);
    }
}
