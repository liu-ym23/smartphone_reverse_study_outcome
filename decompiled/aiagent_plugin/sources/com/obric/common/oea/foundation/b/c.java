package com.obric.common.oea.foundation.b;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: OEALogger.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    private static final String TAG = "OEA_SDK";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f32472a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f32473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final a f32474c = null;

    /* JADX INFO: compiled from: OEALogger.kt */
    public static final class a implements b {
        a() {
        }

        @Override // com.obric.common.oea.foundation.b.b
        public void a(String r1, String r2) {
            o.e(r1, "tag");
            o.e(r2, "msg");
            d(c.TAG, r1 + "->" + r2);
        }

        @Override // com.obric.common.oea.foundation.b.b
        public void b(String r1, String r2) {
            o.e(r1, "tag");
            o.e(r2, "msg");
            e(c.TAG, r1 + "->" + r2);
        }

        @Override // com.obric.common.oea.foundation.b.b
        public void c(String r1, String r2) {
            o.e(r1, "tag");
            o.e(r2, "msg");
            f(c.TAG, r1 + "->" + r2);
        }

        @Override // com.obric.common.oea.foundation.b.b
        public void a(String r1, String r2, Throwable r3) {
            o.e(r1, "tag");
            o.e(r2, "msg");
            b(c.TAG, r1 + "->" + r2, r3);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int d(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.v(r1, r2);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int e(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.d(r1, r2);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int f(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.i(r1, r2);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int b(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }
    }

    static {
        f32472a = new c();
        f32474c = new a();
    }

    private c() {
    }

    public final void a() {
        f32473b = (b) ZeusTransformUtils.preCheckCast(f32474c, b.class, "com.obric.aiagent.plugin");
    }

    public final void a(String r1, String r2) {
        o.e(r1, "tag");
        o.e(r2, "msg");
        b r0 = f32473b;
        if (r0 == null) goto L6;
        r0.a(r1, r2);
        return;
    }

    public final void b(String r1, String r2) {
        o.e(r1, "tag");
        o.e(r2, "msg");
        b r0 = f32473b;
        if (r0 == null) goto L6;
        r0.b(r1, r2);
        return;
    }

    public final void c(String r1, String r2) {
        o.e(r1, "tag");
        o.e(r2, "msg");
        b r0 = f32473b;
        if (r0 == null) goto L6;
        r0.c(r1, r2);
        return;
    }

    public static /* synthetic */ void a(c r0, String r1, String r2, Throwable r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.aiagent.plugin");
    L5:
        r0.a(r1, r2, r3);
    }

    public final void a(String r1, String r2, Throwable r3) {
        o.e(r1, "tag");
        o.e(r2, "msg");
        b r0 = f32473b;
        if (r0 == null) goto L6;
        if (r0 == null) goto L8;
        r0.a(r1, r2, r3);
        return;
    L8:
        return;
    L6:
        f32474c.a(r1, r2, r3);
    }

    public final void d(String r1, String r2) {
        o.e(r1, "tag");
        o.e(r2, "msg");
        b r0 = f32473b;
        if (r0 == null) goto L6;
        if (r0 == null) goto L8;
        r0.c(r1, r2);
        return;
    L8:
        return;
    L6:
        f32474c.c(r1, r2);
    }
}
