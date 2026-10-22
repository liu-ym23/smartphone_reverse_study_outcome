package com.obric.oui.utils;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.obric.oui.common.style.Shadow;
import com.obric.oui.common.style.SmoothCornerH;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.utils.log.L;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ViewUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0007J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011J&\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0004J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001e\u001a\u00020\u001fJB\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\"2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00112\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\bH\u0002J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0004H\u0007J\u0011\u0010+\u001a\u00020\f*\u00020,H\u0000¢\u0006\u0002\b-J\u0011\u0010.\u001a\u00020\f*\u00020,H\u0000¢\u0006\u0002\b/J\u0019\u00100\u001a\u00020)*\u0002012\u0006\u00102\u001a\u000203H\u0000¢\u0006\u0002\b4J1\u00105\u001a\u00020\f*\u0004\u0018\u0001012!\u00106\u001a\u001d\u0012\u0013\u0012\u001101¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020\f07H\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/obric/oui/utils/ViewUtil;", "", "()V", "LARGE_FONT_THRESHOLD", "", "TAG", "", "applyColorAlphaStrength", "", "color", "strength", "applyShadowStyleFromResource", "", "context", "Landroid/content/Context;", "shadowStyleRes", "baseShadow", "Lcom/obric/oui/common/style/Shadow;", "drawShadowLayer", "canvas", "Landroid/graphics/Canvas;", MaterialConfigFormatNames.SHADOW, "rect", "Landroid/graphics/RectF;", "radius", "getActivityContentView", "Landroid/view/ViewGroup;", "activity", "Landroid/app/Activity;", "getDialogContentView", "dialog", "Landroid/app/Dialog;", "initShadow", "typedArray", "Landroid/content/res/TypedArray;", "colorId", "radiusId", "offsetXId", "offsetYId", "spreadId", "isInLargeFont", "", "fontScale", "forceStartMarquee", "Landroid/widget/TextView;", "forceStartMarquee$OUI_standardRelease", "forceStopMarquee", "forceStopMarquee$OUI_standardRelease", "isEventOutsideView", "Landroid/view/View;", "ev", "Landroid/view/MotionEvent;", "isEventOutsideView$OUI_standardRelease", "traverseDescendants", "visitor", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "child", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ViewUtil {
    public static final ViewUtil INSTANCE = null;
    public static final float LARGE_FONT_THRESHOLD = 0.0f;
    private static final String TAG = "ViewUtil";

    private ViewUtil() {
    }

    @JvmStatic
    public static final void traverseDescendants(View r3, Function1<? super View, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "visitor");
        if (r3 != null) goto L6;
        return;
    L6:
        if ((r3 instanceof ViewGroup) == false) goto L14;
        ViewGroup r5 = (ViewGroup) r3;
        int r0 = r5.getChildCount();
        int r1 = 0;
    L8:
        if (r1 >= r0) goto L18;
        int r2 = r1 + 1;
        View r6 = r5.getChildAt(r1);
        if (r6 == null) goto L13;
        r4.invoke(r6);
    L13:
        r1 = r2;
        goto L8
    L18:
        return;
    }

    @JvmStatic
    public static final int applyColorAlphaStrength(int r3, float r4) {
        if (r4 != 1.0f) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        return r3;
    L8:
        float r5 = RangesKt.coerceIn(r4, 0.0f, 1.0f);
        return Color.argb((int) (Color.alpha(r3) * r5), Color.red(r3), Color.green(r3), Color.blue(r3));
    L5:
        r1 = false;
        goto L6
    }

    public final void forceStartMarquee$OUI_standardRelease(TextView r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.setSingleLine();
        r1.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        r1.setMarqueeRepeatLimit(-1);
        r1.setHorizontalFadingEdgeEnabled(true);
        r1.setSelected(true);
    }

    public final void forceStopMarquee$OUI_standardRelease(TextView r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.setSingleLine();
        r1.setEllipsize(TextUtils.TruncateAt.END);
        r1.setHorizontalFadingEdgeEnabled(false);
        r1.setSelected(false);
    }

    public final ViewGroup getActivityContentView(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        return (ViewGroup) r2.getWindow().getDecorView().findViewById(R.id.content);
    L5:
        e = move-exception;
        L.e(TAG, "getActivityContentView, error", e);
        ViewGroup r3 = (ViewGroup) null;
        return null;
    }

    public final ViewGroup getDialogContentView(Dialog r3) {
        Intrinsics.checkNotNullParameter(r3, "dialog");
        Window r4 = r3.getWindow();     // Catch: Exception -> L11
        if (r4 == null) goto L16;
        View r5 = r4.getDecorView();     // Catch: Exception -> L11
        if (r5 == null) goto L17;
        return (ViewGroup) r5.findViewById(R.id.content);
    L17:
        return null;
    L16:
        return null;
    L11:
        e = move-exception;
        L.e(TAG, "getDialogContentView, error", e);
        ViewGroup r6 = (ViewGroup) null;
        return null;
    }

    public final boolean isEventOutsideView$OUI_standardRelease(View r6, MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "ev");
        float r5 = r7.getRawX();
        float r8 = r7.getRawY();
        int[] r0 = new int[2];
        r6.getLocationOnScreen(r0);
        int r2 = r0[0];
        if (r5 < r2) goto L11;
        if (r8 < r0[1]) goto L11;
        if (r5 > (r2 + r6.getWidth())) goto L11;
        if (r8 > (r0[1] + r6.getHeight())) goto L11;
        return false;
    L11:
        return true;
    }

    public final void drawShadowLayer(Canvas r5, Shadow r6, RectF r7, float r8) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        Intrinsics.checkNotNullParameter(r6, MaterialConfigFormatNames.SHADOW);
        Intrinsics.checkNotNullParameter(r7, "rect");
        if (r6.getCornerRadius() <= 0.0f) goto L5;
        r8 = r6.getCornerRadius();
    L5:
        Path r4 = new Path();
        SmoothCornerH.INSTANCE.addRoundRect(r4, r7, r8);
        int r1 = r5.save();
        RectF r2 = new RectF(r7);
        r2.offset(r6.getOffsetX(), r6.getOffsetY());
        r2.inset(-r6.getSpread(), -r6.getSpread());
        r5.clipOutPath(r4);
        r6.getPaint().setColor(r6.getColor());
        if (r6.getRadius() <= 0.0f) goto L8;
        r6.getPaint().setMaskFilter(new BlurMaskFilter(r6.getRadius(), BlurMaskFilter.Blur.NORMAL));
    L8:
        SmoothCornerH.drawRoundRect(r5, r2, r8, r6.getPaint());
        r5.restoreToCount(r1);
    }

    public final void applyShadowStyleFromResource(Context r10, int r11, Shadow r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r12, "baseShadow");
        TypedArray r13 = r10.obtainStyledAttributes(r11, com.obric.common.oui.R.styleable.OUILayout);
        Intrinsics.checkNotNullExpressionValue(r13, "context.obtainStyledAttr…s, R.styleable.OUILayout)");
        initShadow(r13, r12, com.obric.common.oui.R.styleable.OUILayout_oui_firstShadowColor, com.obric.common.oui.R.styleable.OUILayout_oui_firstShadowBlur, com.obric.common.oui.R.styleable.OUILayout_oui_firstOffsetX, com.obric.common.oui.R.styleable.OUILayout_oui_firstOffsetY, com.obric.common.oui.R.styleable.OUILayout_oui_firstShadowSpread);
        r13.recycle();
    }

    private final void initShadow(TypedArray r1, Shadow r2, int r3, int r4, int r5, int r6, int r7) {
        if (r2 != null) goto L4;
        return;
    L4:
        r2.setColor(r1.getColor(r3, Color.parseColor("#00000000")));
        r2.setRadius(r1.getDimension(r4, 0.0f));
        r2.setOffsetX(r1.getDimension(r5, 0.0f));
        r2.setOffsetY(r1.getDimension(r6, 0.0f));
        r2.setSpread(r1.getDimension(r7, 0.0f));
    }

    static {
        INSTANCE = new ViewUtil();
        LARGE_FONT_THRESHOLD = 1.2f;
    }

    @JvmStatic
    public static final boolean isInLargeFont(float r1) {
        if (r1 < LARGE_FONT_THRESHOLD) goto L5;
        return true;
    L5:
        return false;
    }
}
