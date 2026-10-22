package com.bytedance.android.gamecp.business.gamedetail.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.bytedance.android.gamecp.base.gamedetail.s0;
import com.bytedance.android.gamecp.base.gamedetail.x;
import com.bytedance.android.gamecp.common.utils.y0;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class i implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s0 f55876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f55877b;

    public i(s0 r100) {
        Intrinsics.checkNotNullParameter(r100, "universalConfig");
        this.f55876a = r100;
        this.f55877b = 15.0f;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.x
    public final Drawable a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        GradientDrawable r101 = new GradientDrawable();
        r101.setShape(0);
        r101.setCornerRadius(y0.b(8.0f));
        r101.setColor(this.f55876a.a(r100));
        return r101;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.x
    public final Integer b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return 0;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.x
    public final Integer c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return Integer.valueOf(this.f55876a.c(r100));
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.x
    public final String d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f55876a.d(r100);
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.x
    public final float e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f55877b;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.x
    public final Rect f(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = y0.b(6.0f);
        return new Rect(r101, 0, r101, 0);
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.x
    public final void g(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }
}
