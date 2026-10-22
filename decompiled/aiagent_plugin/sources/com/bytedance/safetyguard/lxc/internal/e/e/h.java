package com.bytedance.safetyguard.lxc.internal.e.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.net.Proxy;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: LarkOpenApiForwarder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, String> f10822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f10823d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Proxy f10824e;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
        return false;
    L8:
        h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.aiagent.plugin");
        if (o.a(this.f10820a, r6.f10820a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f10821b, r6.f10821b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f10822c, r6.f10822c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f10823d, r6.f10823d) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f10824e, r6.f10824e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.f10820a.hashCode() * 31) + this.f10821b.hashCode()) * 31) + this.f10822c.hashCode()) * 31) + Arrays.hashCode(this.f10823d)) * 31) + this.f10824e.hashCode();
    }

    public String toString() {
        return "UpstreamRequest(method=" + this.f10820a + ", url=" + this.f10821b + ", headers=" + this.f10822c + ", body=" + Arrays.toString(this.f10823d) + ", proxy=" + this.f10824e + ')';
    }

    public h(String r3, String r4, Map<String, String> r5, byte[] r6, Proxy r7) {
        Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        o.e(r3, "method");
        o.e(r4, "url");
        o.e(r8, "headers");
        o.e(r6, "body");
        o.e(r7, "proxy");
        this.f10820a = r3;
        this.f10821b = r4;
        this.f10822c = r8;
        this.f10823d = r6;
        this.f10824e = r7;
    }

    public final String a() {
        return this.f10820a;
    }

    public final String b() {
        return this.f10821b;
    }

    public final Map<String, String> c() {
        return this.f10822c;
    }

    public final byte[] d() {
        return this.f10823d;
    }

    public final Proxy e() {
        return this.f10824e;
    }
}
