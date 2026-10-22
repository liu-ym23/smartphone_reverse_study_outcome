package com.bytedance.safetyguard.lxc.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.h;
import d.h.b.o;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: SidecarAuthApi.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SidecarAuthResponse {
    private final byte[] body;
    private final Map<String, String> headers;
    private final String reason;
    private final int statusCode;

    public static /* synthetic */ SidecarAuthResponse copy$default(SidecarAuthResponse r1, int r2, String r3, Map r4, byte[] r5, int r6, Object r7) {
        Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.statusCode;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.reason;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r8 = r1.headers;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r5 = r1.body;
    L15:
        return r1.copy(r2, r3, r8, r5);
    }

    public final int component1() {
        return this.statusCode;
    }

    public final String component2() {
        return this.reason;
    }

    public final Map<String, String> component3() {
        return this.headers;
    }

    public final byte[] component4() {
        return this.body;
    }

    public final SidecarAuthResponse copy(int r2, String r3, Map<String, String> r4, byte[] r5) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        o.e(r3, "reason");
        o.e(r1, "headers");
        o.e(r5, "body");
        return new SidecarAuthResponse(r2, r3, r1, r5);
    }

    public String toString() {
        return "SidecarAuthResponse(statusCode=" + this.statusCode + ", reason=" + this.reason + ", headers=" + this.headers + ", body=" + Arrays.toString(this.body) + ')';
    }

    public SidecarAuthResponse(int r3, String r4, Map<String, String> r5, byte[] r6) {
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        o.e(r4, "reason");
        o.e(r7, "headers");
        o.e(r6, "body");
        this.statusCode = r3;
        this.reason = r4;
        this.headers = r7;
        this.body = r6;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final String getReason() {
        return this.reason;
    }

    public /* synthetic */ SidecarAuthResponse(int r2, String r3, Map r4, byte[] r5, int r6, h r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        if ((r6 & 4) == 0) goto L6;
        r8 = ao.b();
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = new byte[0];
    L8:
        this(r2, r3, r8, r5);
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final byte[] getBody() {
        return this.body;
    }

    public boolean equals(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, SidecarAuthResponse.class) == true) goto L5;
    L13:
        return false;
    L5:
        if (this.statusCode != ((SidecarAuthResponse) ZeusTransformUtils.preCheckCast(r5, SidecarAuthResponse.class, "com.obric.aiagent.plugin")).statusCode) goto L13;
        if (o.a(this.reason, ((SidecarAuthResponse) ZeusTransformUtils.preCheckCast(r5, SidecarAuthResponse.class, "com.obric.aiagent.plugin")).reason) == false) goto L13;
        if (o.a(this.headers, ((SidecarAuthResponse) ZeusTransformUtils.preCheckCast(r5, SidecarAuthResponse.class, "com.obric.aiagent.plugin")).headers) == false) goto L13;
        if (Arrays.equals(this.body, ((SidecarAuthResponse) ZeusTransformUtils.preCheckCast(r5, SidecarAuthResponse.class, "com.obric.aiagent.plugin")).body) == false) goto L13;
        return true;
    }

    public int hashCode() {
        return (((((this.statusCode * 31) + this.reason.hashCode()) * 31) + this.headers.hashCode()) * 31) + Arrays.hashCode(this.body);
    }
}
