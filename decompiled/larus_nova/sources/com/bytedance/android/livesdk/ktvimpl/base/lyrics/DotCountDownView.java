package com.bytedance.android.livesdk.ktvimpl.base.lyrics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\bR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/DotCountDownView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "dotCount", "", "dotRadius", "", "dotSpace", "paint", "Landroid/graphics/Paint;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "updateDotCount", "count", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DotCountDownView extends View {
    private int dotCount;
    private float dotRadius;
    private float dotSpace;
    private final Paint paint;

    @Override // android.view.View
    public void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        int r101 = this.dotCount;
        if (r101 >= 1) goto L5;
        return;
    L5:
        int r102 = r101 - 1;
    L6:
        if (r102 < 0) goto L10;
        if (r100 == null) goto L9;
        r100.drawCircle(this.dotRadius + (r102 * this.dotSpace), r100.getHeight() / 2, this.dotRadius, this.paint);
    L9:
        r102 = r102 - 1;
        goto L6
    }

    public final void updateDotCount(int r100) {
        this.dotCount = r100;
        invalidate();
    }

    public DotCountDownView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.dotCount = 3;
        this.dotSpace = UtilityKotlinExtentionsKt.h(10);
        this.dotRadius = UtilityKotlinExtentionsKt.h(2);
        Paint r102 = new Paint(1);
        r102.setStyle(Paint.Style.FILL);
        r102.setColor(ColorProtector.parseColor("#ffffff"));
        Unit r103 = Unit.INSTANCE;
        this.paint = r102;
    }
}
