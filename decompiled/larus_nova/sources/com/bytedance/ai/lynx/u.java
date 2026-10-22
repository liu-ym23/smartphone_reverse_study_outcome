package com.bytedance.ai.lynx;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class u extends com.bytedance.ai.applet.render.core.lynx.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ai.applet.render.core.lynx.o f36686b;

    public static final class a {
    }

    static {
    }

    public u(Context r100, com.bytedance.ai.applet.render.core.lynx.o r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f36686b = r101;
    }

    @Override // com.bytedance.ai.applet.render.core.lynx.b
    public final void d(final String r100, final e8a.a<h8a.b> r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        com.bytedance.ai.applet.render.core.lynx.o r102 = this.f36686b;
        if (r102 != null) goto L6;
        com.bytedance.ai.applet.base.log.b r103 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.b("RenderTemplateResourceFetcher", "fetchRemoteTemplate: loader is null, url = " + r100, null);
        r101.onResponse(com.bytedance.ai.applet.render.core.lynx.b.c(new IllegalArgumentException("unsupported template url: " + r100)));
        return;
    L6:
        com.bytedance.ai.applet.base.log.b r104 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.c("RenderTemplateResourceFetcher", "fetchRemoteTemplate: start to load " + r100);
        r102.b(r100, new s(r100, r101), new t(r101, this));
    }
}
