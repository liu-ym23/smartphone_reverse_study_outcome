package com.bytedance.android.gamecp.base.gamedetail;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class u implements y {
    public u() {
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.y
    public final Drawable a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return y0.f51681a.b(R.drawable.shape_border_33161823_corner_4);
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.y
    public final Integer b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return Integer.valueOf(y0.f51681a.a(R.color.gamecp_game_57161823));
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.y
    public final Integer c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return Integer.valueOf(y0.f51681a.a(R.color.gamecp_game_57161823));
    }
}
