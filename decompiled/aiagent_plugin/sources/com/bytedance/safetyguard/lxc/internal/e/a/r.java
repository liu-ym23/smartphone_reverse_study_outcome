package com.bytedance.safetyguard.lxc.internal.e.a;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: LarkOAuthHttpTransport.kt */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f10396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.safetyguard.lxc.internal.e.c.c f10397b;

    public r(byte[] r2, com.bytedance.safetyguard.lxc.internal.e.c.c r3) {
        d.h.b.o.e(r2, "body");
        d.h.b.o.e(r3, "diagnostics");
        this.f10396a = r2;
        this.f10397b = r3;
    }

    public final com.bytedance.safetyguard.lxc.internal.e.c.c a() {
        return this.f10397b;
    }

    public final String b() {
        byte[] r2 = this.f10396a;
        Charset r0 = StandardCharsets.UTF_8;
        d.h.b.o.c(r0, "UTF_8");
        return new String(r2, r0);
    }

    public String toString() {
        return "LarkOAuthProtocolResponse(responseBytes=" + this.f10396a.length + ", outcome=" + this.f10397b.a() + ')';
    }
}
