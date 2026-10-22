package com.bytedance.android.shopping.orderlist.common.widgets.bubble;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/widgets/bubble/BubbleTriangleView;", "Landroid/view/View;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BubbleTriangleView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f179997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f179998b;

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        this.f179997a.setColor(-1);
        this.f179997a.setStyle(Paint.Style.FILL);
        this.f179998b.reset();
        this.f179998b.moveTo(0.0f, getHeight());
        this.f179998b.lineTo(getWidth(), getHeight());
        this.f179998b.lineTo(getWidth() / 2.0f, 0.0f);
        this.f179998b.close();
        r100.drawPath(this.f179998b, this.f179997a);
    }

    public BubbleTriangleView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f179997a = new Paint(1);
        this.f179998b = new Path();
    }
}
