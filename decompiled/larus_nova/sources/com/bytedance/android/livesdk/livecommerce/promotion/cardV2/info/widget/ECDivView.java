package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.c0;
import com.bytedance.android.ec.core.widget.VerticalDashLineView;
import com.bytedance.android.ec.model.DivLinePattern;
import com.bytedance.android.ec.model.DivLineStyle;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.ec.model.TextPattern;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0005B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\t\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000e\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/info/widget/ECDivView;", "Landroid/widget/FrameLayout;", "", "getViewWidth", "Lcom/bytedance/android/ec/core/widget/VerticalDashLineView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getDivLineView", "()Lcom/bytedance/android/ec/core/widget/VerticalDashLineView;", "divLineView", "Landroid/widget/TextView;", "b", "getDivTextView", "()Landroid/widget/TextView;", "divTextView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECDivView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f150604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f150605b;

    public static final class a {
    }

    static {
    }

    public ECDivView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECDivView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final VerticalDashLineView getDivLineView() {
        return (VerticalDashLineView) this.f150604a.getValue();
    }

    private final TextView getDivTextView() {
        return (TextView) this.f150605b.getValue();
    }

    public final float getViewWidth() {
        View r100 = getChildAt(0);
        if ((r100 instanceof VerticalDashLineView) == false) goto L6;
        return UtilityKotlinExtentionsKt.c(2);
    L6:
        if ((r100 instanceof TextView) == true) goto L22;
        return 0.0f;
    L22:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L14
        ((TextView) r100).getPaddingLeft();     // Catch: Throwable -> L14
        ((TextView) r100).getPaddingRight();     // Catch: Throwable -> L14
        TextPaint r102 = getDivTextView().getPaint();     // Catch: Throwable -> L14
        CharSequence r103 = getDivTextView().getText();     // Catch: Throwable -> L14
        if (r103 == null) goto L11;
        String r104 = r103.toString();     // Catch: Throwable -> L14
        if (r104 == null) goto L11;
    L12:
        Object r105 = Result.m9449constructorimpl(Float.valueOf(r102.measureText(r104)));     // Catch: Throwable -> L14
    L16:
        Float r106 = Float.valueOf(0.0f);
        if (Result.m9455isFailureimpl(r105) == false) goto L25;
        r105 = r106;
    L25:
        return ((Number) r105).floatValue();
    L11:
        r104 = "";
    L14:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    public final void a(PromotionBenefitLabel r100) {
        Intrinsics.checkNotNullParameter(r100, "label");
        DivLinePattern r101 = r100.getDivLinePattern();
        int r102 = 0;
        View r103 = getChildAt(0);
        if (r101 == null) goto L5;
        boolean r104 = true;
        if (r101.getStyle() != DivLineStyle.CHARACTER_LINE.getStyle()) goto L28;
        if ((r103 instanceof TextView) == true) goto L13;
        removeAllViews();
        addView(getDivTextView());
    L13:
        TextView r105 = getDivTextView();
        String r106 = r101.getDivLineCharacter();
        if (r106 != null) goto L17;
        r106 = "";
    L17:
        r105.setText(r106);
        Integer r107 = r101.getDivLineFontSize();
        if (r107 == null) goto L20;
        r105.setTextSize(1, r107.intValue());
    L20:
        int r108 = com.bytedance.android.ec.core.utils.s.f45717a;
        Integer r109 = com.bytedance.android.ec.core.utils.s.b(r101.getDivLineColor());
        if (r109 == null) goto L23;
        r105.setTextColor(r109.intValue());
    L23:
        Integer r110 = r101.getDivLineFontWeight();
        if (r110 == null) goto L26;
        c0.b(r105, r110.intValue());
    L26:
        r105.setPadding(UtilityKotlinExtentionsKt.d(Integer.valueOf(r101.getDivLinePadding())), 0, UtilityKotlinExtentionsKt.d(Integer.valueOf(r101.getDivLinePadding())), 0);
        return;
    L28:
        if ((r103 instanceof VerticalDashLineView) == true) goto L30;
        removeAllViews();
        addView(getDivLineView());
    L30:
        VerticalDashLineView r111 = getDivLineView();
        if (r101.getStyle() == 1) goto L34;
        r104 = false;
    L34:
        float r112 = 0.0f;
        if (r104 == false) goto L37;
        float r113 = UtilityKotlinExtentionsKt.c(Double.valueOf(0.5d));
    L38:
        if (r104 == false) goto L40;
        r112 = UtilityKotlinExtentionsKt.c(Double.valueOf(0.5d));
    L40:
        float r114 = 2;
        r111.a(2.0f, r113, r112, (UtilityKotlinExtentionsKt.c(Double.valueOf(0.5d)) / r114) + r114);
        int r115 = com.bytedance.android.ec.core.utils.s.f45717a;
        Integer r116 = com.bytedance.android.ec.core.utils.s.b(r101.getDivLineColor());
        if (r116 == null) goto L45;
        int r117 = r116.intValue();
        r111.setDashLineColor(r117);
        if (r117 != 0) goto L45;
        getDivLineView().setVisibility(8);
    L45:
        int r118 = r101.getDivLineHeight();
        TextPattern r119 = r100.getTextPattern();
        if (r119 != null) goto L48;
    L50:
        getLayoutParams().height = UtilityKotlinExtentionsKt.d(Integer.valueOf(r101.getDivLineHeight())) - r102;
        requestLayout();
        return;
    L48:
        if (r118 != r119.getHeight()) goto L50;
        r102 = 4;
        goto L50
    L37:
        r113 = 0.0f;
        goto L38
    L5:
        if ((r103 instanceof VerticalDashLineView) == true) goto L52;
        removeAllViews();
        addView(getDivLineView());
        return;
    }

    public ECDivView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f150604a = LazyKt.lazy(new ECDivView$divLineView$2(r100));
        this.f150605b = LazyKt.lazy(new ECDivView$divTextView$2(r100));
    }

    public /* synthetic */ ECDivView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
