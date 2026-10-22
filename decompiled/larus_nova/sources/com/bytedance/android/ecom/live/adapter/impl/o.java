package com.bytedance.android.ecom.live.adapter.impl;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.PopupWindow;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.live.adapter.impl.views.ECStatusView;
import com.bytedance.android.live.core.utils.f2;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class o implements oj.a {
    public o() {
    }

    @Override // oj.a
    public final Typeface a(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "fontName");
        return null;
    }

    @Override // oj.a
    public final void b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // oj.a
    public final PopupWindow c(Activity r100, View r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "anchorView");
        Intrinsics.checkNotNullParameter(r102, "params");
        return null;
    }

    @Override // oj.a
    public final oj.b d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new ECStatusView(r100);
    }

    @Override // oj.a
    public final void e(Context r100, String r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r101, "content");
        if (ECAppInfoService.f48114e.n() == false) goto L6;
        f2.c(r101, r102 ? 1 : 0);
        return;
    L6:
        f2.i(r100, r101, r102 ? 1 : 0);
    }
}
