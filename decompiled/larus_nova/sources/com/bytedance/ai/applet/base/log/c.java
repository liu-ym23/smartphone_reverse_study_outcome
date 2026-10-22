package com.bytedance.ai.applet.base.log;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c implements b {
    public c() {
    }

    @Override // com.bytedance.ai.applet.base.log.b
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        h.a(r101);
    }

    @Override // com.bytedance.ai.applet.base.log.b
    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        h.a(r101);
    }

    @Override // com.bytedance.ai.applet.base.log.b
    public final void e(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (r102 == null) goto L5;
        h.a(r101);
        return;
    L5:
        h.a(r101);
    }

    @Override // com.bytedance.ai.applet.base.log.b
    public final void w(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (r102 == null) goto L5;
        h.a(r101);
        return;
    L5:
        h.a(r101);
    }
}
