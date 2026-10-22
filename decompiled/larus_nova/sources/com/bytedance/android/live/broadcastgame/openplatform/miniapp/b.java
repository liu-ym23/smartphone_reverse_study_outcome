package com.bytedance.android.live.broadcastgame.openplatform.miniapp;

import android.content.Context;
import com.bytedance.ies.web.jsbridge2.f;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements io0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t10.a f61740a;

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f61740a = new t10.a(r100);
    }

    @Override // io0.a
    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        t10.a r101 = this.f61740a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "name");
        if (r101.f544136b.f249346f == true) goto L6;
        r101.f544136b.g(r100);
        return;
    }

    @Override // io0.a
    public final void registerMethod(String r100, f.b r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        t10.a r102 = this.f61740a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        if (r102.f544136b.f249346f == true) goto L6;
        r102.f544136b.c(r100, r101);
        return;
    }
}
