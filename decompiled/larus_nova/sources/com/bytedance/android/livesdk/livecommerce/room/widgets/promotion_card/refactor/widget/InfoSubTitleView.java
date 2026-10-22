package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/widgets/promotion_card/refactor/widget/InfoSubTitleView;", "Landroid/widget/TextView;", "", "show", "", "setShowDeleteLine", "Landroid/graphics/Paint;", "b", "Lkotlin/Lazy;", "getDeleteLinePaint", "()Landroid/graphics/Paint;", "deleteLinePaint", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InfoSubTitleView extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f152512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f152513b;

    public InfoSubTitleView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public InfoSubTitleView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final Paint getDeleteLinePaint() {
        return (Paint) this.f152513b.getValue();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        if (this.f152512a == false) goto L6;
        getDeleteLinePaint().setColor(getCurrentTextColor());
        r100.drawLine(0.0f, getHeight() * 0.625f, getWidth(), getHeight() * 0.625f, getDeleteLinePaint());
        return;
    }

    public final void setShowDeleteLine(boolean r100) {
        this.f152512a = r100;
        invalidate();
    }

    public InfoSubTitleView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f152513b = LazyKt.lazy(InfoSubTitleView$deleteLinePaint$2.INSTANCE);
    }

    public /* synthetic */ InfoSubTitleView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
