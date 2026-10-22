package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.TextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f169469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f169470b;

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        Paint r101 = new Paint(1);
        r101.setStyle(Paint.Style.FILL);
        r101.setColor(-1);
        Unit r102 = Unit.INSTANCE;
        this.f169470b = r101;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        if (this.f169469a == false) goto L6;
        float r100 = com.bytedance.android.shopping.extensions.b.a(16);
        float r101 = com.bytedance.android.shopping.extensions.b.a(2);
        float r102 = 2;
        r110.drawRoundRect((getWidth() - r100) / r102, getHeight() - r101, (getWidth() + r100) / r102, getHeight(), r101, r101, this.f169470b);
        return;
    }
}
