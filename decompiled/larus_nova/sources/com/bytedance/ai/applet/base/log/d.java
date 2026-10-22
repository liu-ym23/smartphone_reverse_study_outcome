package com.bytedance.ai.applet.base.log;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicInteger f34519d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f34520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f34521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f34522c;

    public static final class a {
    }

    static {
        f34519d = new AtomicInteger(0);
    }

    public final String b(String r100) {
        if (this.f34521b == null) goto L6;
        return "[" + this.f34521b + "][" + this.f34522c + "] " + r100;
    L6:
        return "[" + this.f34522c + "] " + r100;
    }

    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        b r101 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.c(this.f34520a, b(r100));
    }

    public d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        this.f34520a = r100;
        this.f34521b = r101;
        this.f34522c = f34519d.incrementAndGet();
    }

    public static void d(d r100, String r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "msg");
        b r102 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.d(r100.f34520a, r100.b(r101), null);
    }

    public final void a(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        b r102 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.b(this.f34520a, b(r100), r101);
    }
}
