package com.bytedance.android.gamecp.base.gamedetail;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class z implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f51682a;

    public z(float r100) {
        this.f51682a = r100;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.y
    public final Drawable a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        y0 r101 = y0.f51681a;
        if (this.f51682a != 4.0f) goto L5;
        int r102 = R.drawable.shape_bg_26ffffff_corner_4;
    L7:
        return r101.b(r102);
    L5:
        r102 = R.drawable.shape_bg_26ffffff_corner_8;
        goto L7
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.y
    public final Integer b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return Integer.valueOf(y0.f51681a.a(R.color.gamecp_57FFFFFF));
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.y
    public final Integer c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return Integer.valueOf(y0.f51681a.a(R.color.gamecp_white));
    }
}
