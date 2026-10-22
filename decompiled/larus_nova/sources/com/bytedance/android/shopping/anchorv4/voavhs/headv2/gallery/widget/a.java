package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.TextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f169467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f169468b;

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        Paint r101 = new Paint(1);
        r101.setStyle(Paint.Style.FILL);
        r101.setColor(-1);
        Unit r102 = Unit.INSTANCE;
        this.f169468b = r101;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        if (this.f169467a == true) goto L5;
        return;
    L5:
        if (getWidth() <= com.bytedance.android.shopping.extensions.b.a(63)) goto L7;
        int r100 = com.bytedance.android.shopping.extensions.b.a(63);
    L8:
        float r101 = r100;
        float r102 = com.bytedance.android.shopping.extensions.b.a(2);
        float r103 = 2;
        r110.drawRoundRect((getWidth() - r101) / r103, getHeight() - r102, (getWidth() + r101) / r103, getHeight(), r102, r102, this.f169468b);
        return;
    L7:
        r100 = com.bytedance.android.shopping.extensions.b.a(20);
        goto L8
    }
}
