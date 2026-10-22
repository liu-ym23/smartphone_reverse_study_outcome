package com.bytedance.safetyguard.lxc.internal.e.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: LarkOAuthHttpTransport.kt */
/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, List<String>> f10394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f10395c;

    public p(int r3, Map<String, ? extends List<String>> r4, byte[] r5) {
        Map<String, List<String>> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "headers");
        d.h.b.o.e(r5, "body");
        this.f10393a = r3;
        this.f10394b = r6;
        this.f10395c = r5;
    }

    public final int a() {
        return this.f10393a;
    }

    public final Map<String, List<String>> b() {
        return this.f10394b;
    }

    public final byte[] c() {
        return this.f10395c;
    }

    public String toString() {
        return "LarkOAuthHttpResponse(statusCode=" + this.f10393a + ", responseBytes=" + this.f10395c.length + ')';
    }
}
