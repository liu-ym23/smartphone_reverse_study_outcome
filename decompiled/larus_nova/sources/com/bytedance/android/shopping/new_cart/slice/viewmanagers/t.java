package com.bytedance.android.shopping.new_cart.slice.viewmanagers;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class t extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f179181a;

    public t(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        Paint r101 = new Paint(1);
        this.f179181a = r101;
        r101.setShadowLayer(10.0f, 0.0f, -com.bytedance.android.shopping.extensions.b.a(4), com.bytedance.android.shopping.extensions.k.o("#0D161823"));
        setLayerType(1, r101);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        this.f179181a.setStyle(Paint.Style.FILL);
        this.f179181a.setColor(0);
        r100.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f179181a);
    }
}
