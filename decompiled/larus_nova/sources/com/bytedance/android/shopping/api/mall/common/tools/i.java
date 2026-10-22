package com.bytedance.android.shopping.api.mall.common.tools;

import android.content.Context;
import android.graphics.Typeface;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class i implements yj.r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i f170440b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ yj.r f170441a;

    @Override // yj.r
    public final Typeface a(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "fontName");
        return this.f170441a.a(r100, r101);
    }

    @Override // yj.r
    public final void showToast(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "content");
        this.f170441a.showToast(r100, r101);
    }

    static {
        f170440b = new i();
    }

    public i() {
        this.f170441a = h.f170438b.getIHybridHostUIService();
    }
}
