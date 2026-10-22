package com.bytedance.android.gamecp.base.gamedetail;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class r0 implements y {
    public r0() {
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.y
    public final Drawable a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return y0.f51681a.b(R.drawable.shape_bg_0d161823_corner_8);
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.y
    public final Integer b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return Integer.valueOf(y0.f51681a.a(R.color.gamecp_text_black));
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.y
    public final Integer c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return Integer.valueOf(y0.f51681a.a(R.color.gamecp_text_black));
    }
}
