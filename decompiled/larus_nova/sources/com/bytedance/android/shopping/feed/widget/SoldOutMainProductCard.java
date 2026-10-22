package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.widget.RoundedFrameLayout;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/SoldOutMainProductCard;", "Lcom/bytedance/android/ec/core/widget/RoundedFrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SoldOutMainProductCard extends RoundedFrameLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FlowTinyProductView f175996b;

    public static DisplayMetrics y(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public SoldOutMainProductCard(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        float r103 = 8;
        setRadius(MathKt.roundToInt(TypedValue.applyDimension(1, r103, y(Resources.getSystem()))));
        FlowTinyProductView r104 = new FlowTinyProductView(r100, null, 6, 0);
        r104.setLayoutParams(new FrameLayout.LayoutParams(-1, MathKt.roundToInt(TypedValue.applyDimension(1, 110, y(Resources.getSystem())))));
        float r105 = 6;
        r104.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r105, y(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r103, y(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r105, y(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r103, y(Resources.getSystem()))));
        r104.setStyle(4);
        Unit r106 = Unit.INSTANCE;
        this.f175996b = r104;
        addView(r104);
        setBackgroundColor(-1);
    }
}
