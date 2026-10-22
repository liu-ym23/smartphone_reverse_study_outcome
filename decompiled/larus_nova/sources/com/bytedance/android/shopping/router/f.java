package com.bytedance.android.shopping.router;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.shopping.anchorv3.ECAnchorV3Helper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class f implements bf.c {
    public f() {
    }

    @Override // bf.c
    public final void a() {
    }

    @Override // bf.c
    public final String b() {
        return "goods/detail/";
    }

    @Override // bf.c
    public final boolean c(Context r100, Uri r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        ECAnchorV3Helper r103 = ECAnchorV3Helper.f164389a;
        ECAnchorV3Helper.i(r100, r101.toString(), r102);
        return true;
    }
}
