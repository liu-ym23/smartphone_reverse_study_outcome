package com.obric.memorydata.sdk.screencapture;

import com.obric.aikernel.sdk.ext.CozeCloudExt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: ScreenCaptureManager.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.h.a.b<d.h.a.a<x>, x> f33848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.h.a.b<ScreenData, x> f33849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.a<x> f33850c;

    /* JADX INFO: renamed from: lambda$KmTa7iTVcHxV-LwUvhFB2jkkyS8, reason: not valid java name */
    public static /* synthetic */ x m962lambda$KmTa7iTVcHxVLwUvhFB2jkkyS8(a r0, ScreenData r1) {
        return a(r0, r1);
    }

    public a(d.h.a.b<? super d.h.a.a<x>, x> r3, d.h.a.b<? super ScreenData, x> r4, d.h.a.a<x> r5) {
        d.h.a.b<d.h.a.a<x>, x> r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b<ScreenData, x> r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.a<x> r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r6, CozeCloudExt.API_KEY_HTTP_POST_METHOD);
        o.e(r7, "callback");
        o.e(r8, "onComplete");
        this.f33848a = r6;
        this.f33849b = r7;
        this.f33850c = r8;
    }

    public final void a(final ScreenData r3) {
        this.f33848a.invoke(new $$Lambda$a$KmTa7iTVcHxVLwUvhFB2jkkyS8(this, r3));
    }

    private static final x a(a r1, ScreenData r2) {
        r1.f33849b.invoke(r2);     // Catch: Throwable -> L5
        r1.f33850c.invoke();
        return x.f38692a;
    L5:
        th = move-exception;
        r1.f33850c.invoke();
        throw th;
    }
}
