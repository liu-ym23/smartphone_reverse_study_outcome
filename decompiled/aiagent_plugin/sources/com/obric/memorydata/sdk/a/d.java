package com.obric.memorydata.sdk.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: MLogger.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f33797a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile c f33798b;

    private d() {
    }

    static {
        f33797a = new d();
        f33798b = (c) ZeusTransformUtils.preCheckCast(new b(false), c.class, "com.obric.aiagent.plugin");
    }

    public final void a(c r2) {
        c r1 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L6;
        f33798b = r1;
        return;
    }

    public final void a(boolean r2) {
        if (ZeusTransformUtils.instanceOf(f33798b, b.class) == false) goto L6;
        f33798b = (c) ZeusTransformUtils.preCheckCast(new b(r2), c.class, "com.obric.aiagent.plugin");
        return;
    }

    public final void a(String r1, String r2) {
        o.e(r1, "tag");
        o.e(r2, "msg");
        f33798b.a(r1, r2);
    }

    public final void b(String r1, String r2) {
        o.e(r1, "tag");
        o.e(r2, "msg");
        f33798b.b(r1, r2);
    }

    public final void c(String r1, String r2) {
        o.e(r1, "tag");
        o.e(r2, "msg");
        f33798b.c(r1, r2);
    }

    public static /* synthetic */ void a(d r0, String r1, String r2, Throwable r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.a(r1, r2, r3);
    }

    public final void a(String r1, String r2, Throwable r3) {
        o.e(r1, "tag");
        o.e(r2, "msg");
        f33798b.a(r1, r2, r3);
    }
}
