package com.obric.matrixpro.sdk.deviceinfoclient;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.r;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: MatrixProDeviceInfoClientLogger.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f33791a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static r<? super Integer, ? super String, ? super String, ? super Throwable, x> f33792b;

    static {
        f33791a = new b();
    }

    private b() {
    }

    public final void a(String r3, String r4) {
        o.e(r3, "tag");
        o.e(r4, "msg");
        a(4, r3, r4, null);
    }

    public final void a(String r2, String r3, Throwable r4) {
        o.e(r2, "tag");
        o.e(r3, "msg");
        a(6, r2, r3, r4);
    }

    private final void a(int r1, String r2, String r3, Throwable r4) {
        r<? super Integer, ? super String, ? super String, ? super Throwable, x> r0 = f33792b;
        if (r0 == null) goto L6;
        x r5 = (x) ZeusTransformUtils.preCheckCast(r0.a(Integer.valueOf(r1), r2, r3, r4), x.class, "com.obric.aiagent.plugin");
        return;
    }
}
