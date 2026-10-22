package com.bytedance.android.shopping.track;

import cl.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class TrackCatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f187025a = null;

    public static final class a {
        public static TrackCatcher a() {
            return (TrackCatcher) TrackCatcher.f187025a.getValue();
        }
    }

    public TrackCatcher() {
    }

    static {
        f187025a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, TrackCatcher$Companion$instance$2.INSTANCE);
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pageId");
        d.f24079a.getClass();
        d r101 = d.a.b();
        if (r101 == null) goto L6;
        r101.f();
        return;
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pageId");
        d.f24079a.getClass();
        d r101 = d.a.b();
        if (r101 == null) goto L6;
        r101.f();
        return;
    }

    public static void c(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "pageId");
        Intrinsics.checkNotNullParameter(r101, "eventName");
        Intrinsics.checkNotNullParameter(r102, "btm");
        d.f24079a.getClass();
        d r103 = d.a.b();
        if (r103 == null) goto L6;
        r103.f();
        return;
    }
}
