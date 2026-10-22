package com.bytedance.safetyguard.lxc.internal.service;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: AppGatewayServiceProxySession.kt */
/* JADX INFO: loaded from: classes.dex */
public final class z implements AutoCloseable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InputStream f11121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final OutputStream f11122b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, z.class) == true) goto L8;
        return false;
    L8:
        z r6 = (z) ZeusTransformUtils.preCheckCast(r5, z.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f11121a, r6.f11121a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f11122b, r6.f11122b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f11121a.hashCode() * 31) + this.f11122b.hashCode();
    }

    public String toString() {
        return "ServiceGatewayIo(input=" + this.f11121a + ", output=" + this.f11122b + ')';
    }

    public z(InputStream r2, OutputStream r3) {
        d.h.b.o.e(r2, "input");
        d.h.b.o.e(r3, "output");
        this.f11121a = r2;
        this.f11122b = r3;
    }

    public final InputStream a() {
        return this.f11121a;
    }

    public final OutputStream b() {
        return this.f11122b;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L5
        ((z) ZeusTransformUtils.preCheckCast(this, z.class, "com.obric.aiagent.plugin")).f11121a.close();     // Catch: Throwable -> L5
        d.n.f(d.x.f38692a);     // Catch: Throwable -> L5
    L12:
        d.n.a r3 = d.n.f38560a;     // Catch: Throwable -> L9
        ((z) ZeusTransformUtils.preCheckCast(this, z.class, "com.obric.aiagent.plugin")).f11122b.close();     // Catch: Throwable -> L9
        d.n.f(d.x.f38692a);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        d.n.a r0 = d.n.f38560a;
        d.n.f(d.o.a(th));
        return;
    L5:
        th = move-exception;
        d.n.a r4 = d.n.f38560a;
        d.n.f(d.o.a(th));
        goto L12
    }
}
