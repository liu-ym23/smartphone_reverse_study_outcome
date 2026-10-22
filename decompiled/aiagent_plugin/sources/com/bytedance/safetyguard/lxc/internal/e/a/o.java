package com.bytedance.safetyguard.lxc.internal.e.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URL;
import java.util.Map;

/* JADX INFO: compiled from: LarkOAuthHttpTransport.kt */
/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final URL f10389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, String> f10390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f10391d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f10392e;
    private final int f;

    public o(String r3, URL r4, Map<String, String> r5, byte[] r6, int r7, int r8) {
        Map<String, String> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "method");
        d.h.b.o.e(r4, "url");
        d.h.b.o.e(r9, "headers");
        d.h.b.o.e(r6, "body");
        this.f10388a = r3;
        this.f10389b = r4;
        this.f10390c = r9;
        this.f10391d = r6;
        this.f10392e = r7;
        this.f = r8;
    }

    public final String a() {
        return this.f10388a;
    }

    public final URL b() {
        return this.f10389b;
    }

    public final Map<String, String> c() {
        return this.f10390c;
    }

    public final byte[] d() {
        return this.f10391d;
    }

    public final int e() {
        return this.f10392e;
    }

    public final int f() {
        return this.f;
    }

    public String toString() {
        return "LarkOAuthHttpRequest(method=" + this.f10388a + ", host=" + this.f10389b.getHost() + ", path=" + this.f10389b.getPath() + ", requestBytes=" + this.f10391d.length + ')';
    }
}
