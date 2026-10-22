package com.bytedance.android.shopping.mall.homepage.card.live;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/live/AdTagView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AdTagView extends AppCompatTextView {
    public final void y() {
        GradientDrawable r100 = new GradientDrawable();
        float r101 = 4;
        r100.setCornerRadii(new float[]{0.0f, 0.0f, TypedValue.applyDimension(1, r101, x(Resources.getSystem())), TypedValue.applyDimension(1, r101, x(Resources.getSystem())), 0.0f, 0.0f, TypedValue.applyDimension(1, r101, x(Resources.getSystem())), TypedValue.applyDimension(1, r101, x(Resources.getSystem()))});
        r100.setColor(ColorProtector.parseColor("#1F161823"));
        Unit r102 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(this, "$this$setBackgroundCompat");
        setBackground(r100);
    }

    public AdTagView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        setText("广告");
        setTextSize(8.0f);
        setTextColor(ColorProtector.parseColor("#BFFFFFFF"));
        setPadding(b0.c(1), b0.c(1), b0.c(1), b0.c(1));
        GradientDrawable r101 = new GradientDrawable();
        r101.setCornerRadius(TypedValue.applyDimension(1, 2, x(Resources.getSystem())));
        r101.setColor(ColorProtector.parseColor("#1F161823"));
        Unit r102 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(this, "$this$setBackgroundCompat");
        setBackground(r101);
    }

    public static DisplayMetrics x(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public AdTagView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        setText("广告");
        setTextSize(8.0f);
        setTextColor(ColorProtector.parseColor("#BFFFFFFF"));
        setPadding(b0.c(1), b0.c(1), b0.c(1), b0.c(1));
        GradientDrawable r102 = new GradientDrawable();
        r102.setCornerRadius(TypedValue.applyDimension(1, 2, x(Resources.getSystem())));
        r102.setColor(ColorProtector.parseColor("#1F161823"));
        Unit r103 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(this, "$this$setBackgroundCompat");
        setBackground(r102);
    }

    public AdTagView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setText("广告");
        setTextSize(8.0f);
        setTextColor(ColorProtector.parseColor("#BFFFFFFF"));
        setPadding(b0.c(1), b0.c(1), b0.c(1), b0.c(1));
        GradientDrawable r103 = new GradientDrawable();
        r103.setCornerRadius(TypedValue.applyDimension(1, 2, x(Resources.getSystem())));
        r103.setColor(ColorProtector.parseColor("#1F161823"));
        Unit r104 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(this, "$this$setBackgroundCompat");
        setBackground(r103);
    }
}
