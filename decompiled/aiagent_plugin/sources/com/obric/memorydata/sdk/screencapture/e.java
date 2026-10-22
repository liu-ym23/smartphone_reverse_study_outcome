package com.obric.memorydata.sdk.screencapture;

import com.obric.aikernel.sdk.ext.CozeCloudExt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.util.List;

/* JADX INFO: compiled from: ScreenCaptureManager.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class e {
    public static /* synthetic */ x lambda$my7NeuaUSgQXEVWD_FQMEzBU4EA(c r0) {
        return a(r0);
    }

    public static final void a(List<c> r2, final c r3, d.h.a.b<? super d.h.a.a<x>, x> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r5, "pendingCaptureOperations");
        o.e(r3, "operation");
        o.e(r6, CozeCloudExt.API_KEY_HTTP_POST_METHOD);
        r5.remove(r3);
        r6.invoke(new $$Lambda$e$my7NeuaUSgQXEVWD_FQMEzBU4EA(r3));
    }

    private static final x a(c r1) {
        r1.c().invoke(null);
        return x.f38692a;
    }
}
