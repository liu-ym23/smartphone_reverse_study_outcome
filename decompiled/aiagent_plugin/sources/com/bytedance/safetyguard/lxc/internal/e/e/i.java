package com.bytedance.safetyguard.lxc.internal.e.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: LarkOpenApiForwarder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, String> f10827c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f10828d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, i.class) == true) goto L8;
        return false;
    L8:
        i r6 = (i) ZeusTransformUtils.preCheckCast(r5, i.class, "com.obric.aiagent.plugin");
        if (this.f10825a == r6.f10825a) goto L12;
        return false;
    L12:
        if (o.a(this.f10826b, r6.f10826b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f10827c, r6.f10827c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f10828d, r6.f10828d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.f10825a) * 31) + this.f10826b.hashCode()) * 31) + this.f10827c.hashCode()) * 31) + Arrays.hashCode(this.f10828d);
    }

    public String toString() {
        return "UpstreamResponse(statusCode=" + this.f10825a + ", reason=" + this.f10826b + ", headers=" + this.f10827c + ", body=" + Arrays.toString(this.f10828d) + ')';
    }

    public i(int r3, String r4, Map<String, String> r5, byte[] r6) {
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        o.e(r4, "reason");
        o.e(r7, "headers");
        o.e(r6, "body");
        this.f10825a = r3;
        this.f10826b = r4;
        this.f10827c = r7;
        this.f10828d = r6;
    }

    public final int a() {
        return this.f10825a;
    }

    public final String b() {
        return this.f10826b;
    }

    public final Map<String, String> c() {
        return this.f10827c;
    }

    public final byte[] d() {
        return this.f10828d;
    }
}
