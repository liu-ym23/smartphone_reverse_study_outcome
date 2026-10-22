package com.bytedance.android.window.shop.innerflow;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.ec.core.utils.n;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements bf.c {
    public c() {
    }

    @Override // bf.c
    public final void a() {
    }

    @Override // bf.c
    public final String b() {
        return "goods/window/innerflow";
    }

    @Override // bf.c
    public final boolean c(final Context r100, final Uri r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        int r103 = ECWindowInnerFlowActivity.f189026o;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "schema");
        n.b(r100, r102, null, new ECWindowInnerFlowActivity$Companion$start$1(r101, r100), ECWindowInnerFlowActivity$Companion$start$2.INSTANCE);
        return true;
    }
}
