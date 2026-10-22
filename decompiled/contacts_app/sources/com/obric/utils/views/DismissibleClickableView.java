package com.obric.utils.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.content.res.ResourcesCompat;
import com.android.contacts.R;
import com.obric.oui.button.OButton;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialExtBaseKt;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.text.OTextView;
import com.obric.oui.utils.ViewUtilKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: DismissibleClickableView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0010\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0014J\u0012\u0010\u0016\u001a\u00020\u00152\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u000e\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0018\u0010\u001e\u001a\u00020\u000f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eJ\u0016\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/utils/views/DismissibleClickableView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clickableView", "Lcom/obric/oui/layout/OUILinearLayout;", "textView", "Lcom/obric/oui/text/OTextView;", "viewClickAction", "Lkotlin/Function0;", "", "dismiss", "enableMaterialEffect", "backdropTarget", "Landroid/view/View;", "generateDefaultLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "generateLayoutParams", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "setShowText", "showText", "", "setViewClickAction", "setViewPosition", MaterialConfigFormatNames.X, MaterialConfigFormatNames.Y, "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DismissibleClickableView extends FrameLayout {
    private OUILinearLayout clickableView;
    private final OTextView textView;
    private Function0<Unit> viewClickAction;

    public static /* synthetic */ void $r8$lambda$F8SFD0vrkoWPfsrunjkt70tceUE(DismissibleClickableView r0, View r1) {
        clickableView$lambda$2$lambda$1$lambda$0(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$kOQzg04XObYMw-iPL02cZ5KOxfI, reason: not valid java name */
    public static /* synthetic */ void m783$r8$lambda$kOQzg04XObYMwiPL02cZ5KOxfI(DismissibleClickableView r0, int r1, int r2) {
        setViewPosition$lambda$4(r0, r1, r2);
    }

    public DismissibleClickableView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public DismissibleClickableView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ DismissibleClickableView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateLayoutParams(r1);
    }

    public DismissibleClickableView(Context r11, AttributeSet r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, r12, r13);
        OTextView r7 = new OTextView(r11, null, 0, null, 14, null);
        this.textView = r7;
        OUILinearLayout r8 = new OUILinearLayout(r11, null, 0, null, 14, null);
        r8.setShadowStyle(R.style.OUIShadow_3);
        r8.setOrientation(0);
        r8.setBackgroundResource(R.drawable.dismissble_click_view_radius_bg);
        r8.setEnableShadowWidthRadius(true);
        r8.setShadowCornerRadius(MathKt.roundToInt(TypedValue.applyDimension(1, 24, Resources.getSystem().getDisplayMetrics())));
        r8.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        float r3 = 8;
        r8.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, 20, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r3, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r3, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r3, Resources.getSystem().getDisplayMetrics())));
        r8.addView(r7);
        r7.setPadding(r7.getLeft(), r7.getTop() + MathKt.roundToInt(TypedValue.applyDimension(1, 2, Resources.getSystem().getDisplayMetrics())), r7.getRight() + MathKt.roundToInt(TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics())), r7.getBottom() + MathKt.roundToInt(TypedValue.applyDimension(1, 1, Resources.getSystem().getDisplayMetrics())));
        r7.setTextColor(ResourcesCompat.getColor(r8.getResources(), R.color.oui_basic_text_1, null));
        r7.setTextAppearance(R.style.Subtitle_3_Regular);
        r7.setIncludeFontPadding(false);
        OButton r1 = OButton.Companion.createNeutralButton(r11, r8);
        r1.setBackgroundColor(ResourcesCompat.getColor(r1.getResources(), R.color.oui_basic_fill_element_2, null));
        r1.setTextColor(ResourcesCompat.getColor(r1.getResources(), R.color.oui_basic_text_1, null));
        r1.setTextAppearance(R.style.Button_1_Medium);
        r1.setText(r1.getResources().getString(R.string.dismissible_clickable_view_btn_text));
        r1.setOnClickListener(new DismissibleClickableView$$ExternalSyntheticLambda0(this));
        this.clickableView = r8;
        setClipChildren(false);
        setClipToPadding(false);
        setBackgroundColor(0);
        addView(this.clickableView);
    }

    private static final void clickableView$lambda$2$lambda$1$lambda$0(DismissibleClickableView r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        Function0<Unit> r2 = r0.viewClickAction;
        if (r2 == null) goto L5;
        r2.invoke();
    L5:
        r0.dismiss();
    }

    public final void setShowText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "showText");
        this.textView.setText(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setViewClickAction$default(DismissibleClickableView r0, Function0 r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.setViewClickAction(r1);
    }

    public final void setViewClickAction(Function0<Unit> r1) {
        this.viewClickAction = r1;
    }

    public final void enableMaterialEffect(View r9) {
        if (OMaterialHelper.isMaterialEffectEnabled(getContext()) == true) goto L5;
        return;
    L5:
        OMaterialExtBaseKt.materials$default(this.clickableView, MaterialToken.OUI_Bg_Modal.invoke(Boolean.valueOf(!ViewUtilKt.isDarkMode(this.clickableView))), false, 0, null, 14, null);
        if (r9 == null) goto L9;
        OMaterialExtBaseKt.setMaterialBackdropTarget(this.clickableView, r9);
        return;
    }

    public final void setViewPosition(final int r3, final int r4) {
        this.clickableView.post(new DismissibleClickableView$$ExternalSyntheticLambda1(this, r3, r4));
    }

    private static final void setViewPosition$lambda$4(DismissibleClickableView r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        ViewGroup.LayoutParams r0 = r2.clickableView.getLayoutParams();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0;
        r1.leftMargin = r3 - (r2.clickableView.getMeasuredWidth() / 2);
        r1.topMargin = r4 - r2.clickableView.getMeasuredHeight();
        r2.clickableView.setLayoutParams(r1);
    }

    public final void dismiss() {
        ViewParent r0 = getParent();
        if ((r0 instanceof FrameLayout) == false) goto L5;
        FrameLayout r1 = (FrameLayout) r0;
    L6:
        if (r1 == null) goto L9;
        r1.removeView(this);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        if (r4.getAction() != 0) goto L9;
        Rect r0 = new Rect();
        this.clickableView.getHitRect(r0);
        if (r0.contains((int) r4.getX(), (int) r4.getY()) == false) goto L8;
        return true;
    L8:
        dismiss();
    L9:
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet r2) {
        return new FrameLayout.LayoutParams(getContext(), r2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected FrameLayout.LayoutParams generateDefaultLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }
}
