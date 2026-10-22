package com.bytedance.ai.applet.render.core.lynx;

import com.lynx.tasm.provider.LynxResourceCallback;
import com.lynx.tasm.provider.LynxResourceRequest;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class s extends d8a.k<Object, byte[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f35160a;

    public static final class a {
    }

    static {
    }

    public s(o r100) {
        Intrinsics.checkNotNullParameter(r100, "loader");
        this.f35160a = r100;
    }

    @Override // d8a.k
    public final void request(final LynxResourceRequest<Object> r100, final LynxResourceCallback<byte[]> r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "callback");
        com.bytedance.ai.applet.base.log.b r102 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.c("RenderExternalJSProvider", "request: start to load " + r100.f383547a);
        this.f35160a.b(r100.f383547a, new q(r100, r101), new r(r100, r101));
    }
}
