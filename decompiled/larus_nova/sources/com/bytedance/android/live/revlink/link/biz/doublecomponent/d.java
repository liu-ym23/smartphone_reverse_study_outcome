package com.bytedance.android.live.revlink.link.biz.doublecomponent;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d implements g41.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d f98202a;

    @Override // g41.a
    public final boolean a() {
        b03.a r100 = b03.a.f16857a;
        if (b03.a.b() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f98202a.r9() == true) goto L7;
        return true;
    }

    @Override // g41.a
    public final boolean isPortrait() {
        b03.a r100 = b03.a.f16857a;
        return b03.a.c();
    }

    public d(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f98202a = r100;
    }
}
