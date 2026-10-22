package com.android.ttcjpaysdk.base.ui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.TextViewCompat;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.byted.cast.common.CastMonitor;
import com.bytedance.android.service.manager.alliance.IAllianceService;
import com.bytedance.crash.dumper.Scraps;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 M2\u00020\u0001:\u0001MB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010.\u001a\u00020/H\u0002J\u0006\u00100\u001a\u00020\u0007J0\u00101\u001a\u00020/2\u0006\u00102\u001a\u00020#2\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u0007H\u0014J\u0018\u00107\u001a\u00020/2\u0006\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u0007H\u0014J\u000e\u0010:\u001a\u00020/2\u0006\u0010;\u001a\u00020#J\u000e\u0010<\u001a\u00020/2\u0006\u0010\u000e\u001a\u00020\nJ\u000e\u0010=\u001a\u00020/2\u0006\u0010>\u001a\u00020#J\u000e\u0010?\u001a\u00020/2\u0006\u0010>\u001a\u00020#J\u000e\u0010@\u001a\u00020/2\u0006\u0010A\u001a\u00020#J\u000e\u0010B\u001a\u00020/2\u0006\u0010C\u001a\u00020\u0007J\u000e\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020FJ\u000e\u0010D\u001a\u00020/2\u0006\u0010G\u001a\u00020\u0007J\u0016\u0010H\u001a\u00020/2\u0006\u0010I\u001a\u00020\u00072\u0006\u0010J\u001a\u00020+J\u0010\u0010K\u001a\u00020/2\b\u0010L\u001a\u0004\u0018\u00010\u000fR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\u001d\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010%\u001a\u0004\u0018\u00010$2\b\u0010\u000e\u001a\u0004\u0018\u00010$8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0011\u0010*\u001a\u00020+8F¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u0006N"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/widget/CJBadgeTextView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", IAllianceService.CONTENT_TYPE_BADGE, "Lcom/android/ttcjpaysdk/base/ui/widget/CJBadge;", "badgeTextView", "Landroidx/appcompat/widget/AppCompatTextView;", "contentTextView", "value", "Landroid/graphics/Typeface;", "contentTypeface", "getContentTypeface", "()Landroid/graphics/Typeface;", "setContentTypeface", "(Landroid/graphics/Typeface;)V", "dotView", "Landroid/view/View;", "layout", "Landroid/text/Layout;", "getLayout", "()Landroid/text/Layout;", "lineCount", "getLineCount", "()I", "maxLines", "getMaxLines", "setMaxLines", "(I)V", "measureBadgeWithoutWidthLimit", "", "", "text", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "textSize", "", "getTextSize", "()F", "applyBadge", "", "getBadgeRightInSelf", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setAllCaps", "allCaps", "setBadge", "setContentFakeBoldText", "enabled", "setMeasureBadgeWithoutWidthLimit", "setSelectedText", "selected", "setTextAppearance", "resId", "setTextColor", "colors", "Landroid/content/res/ColorStateList;", "color", "setTextSize", Scraps.INNER_UNIT, "size", "setTypeface", "typeface", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJBadgeTextView extends FrameLayout {
    public static final int BADGE_COLOR = -119723;
    public static final float BADGE_CORNER_RADIUS_DP = 999.0f;
    public static final float BADGE_DOT_OFFSET_X_DP = 0.0f;
    public static final float BADGE_DOT_OFFSET_Y_DP = 8.0f;
    public static final float BADGE_DOT_SIZE_DP = 8.0f;
    public static final float BADGE_HORIZONTAL_PADDING_DP = 4.0f;
    public static final float BADGE_TEXT_OFFSET_X_DP = -7.0f;
    public static final float BADGE_TEXT_OFFSET_Y_DP = 7.0f;
    public static final float BADGE_TEXT_SIZE_SP = 10.0f;
    public static final float BADGE_VERTICAL_PADDING_DP = 1.0f;
    private static final Companion Companion = null;
    private CJBadge badge;
    private final AppCompatTextView badgeTextView;
    private final AppCompatTextView contentTextView;
    private final View dotView;
    private boolean measureBadgeWithoutWidthLimit;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/widget/CJBadgeTextView$Companion;", "", "()V", "BADGE_COLOR", "", "BADGE_CORNER_RADIUS_DP", "", "BADGE_DOT_OFFSET_X_DP", "BADGE_DOT_OFFSET_Y_DP", "BADGE_DOT_SIZE_DP", "BADGE_HORIZONTAL_PADDING_DP", "BADGE_TEXT_OFFSET_X_DP", "BADGE_TEXT_OFFSET_Y_DP", "BADGE_TEXT_SIZE_SP", "BADGE_VERTICAL_PADDING_DP", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CJBadgeTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 6, null);
    }

    public CJBadgeTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 4, null);
    }

    private final void applyBadge() {
        CJBadge r100 = this.badge;
        if (Intrinsics.areEqual(r100, CJBadge.None.INSTANCE) == false) goto L6;
        this.dotView.setVisibility(8);
        this.badgeTextView.setVisibility(8);
    L11:
        requestLayout();
        invalidate();
        return;
    L6:
        if (Intrinsics.areEqual(r100, CJBadge.Dot.INSTANCE) == false) goto L9;
        this.dotView.setVisibility(0);
        this.badgeTextView.setVisibility(8);
        goto L11
    L9:
        if ((r100 instanceof CJBadge.Text) == false) goto L11;
        this.badgeTextView.setText(((CJBadge.Text) r100).getValue());
        this.badgeTextView.setVisibility(0);
        this.dotView.setVisibility(8);
        goto L11
    }

    public final int getBadgeRightInSelf() {
        CJBadge r100 = this.badge;
        Integer r101 = null;
        boolean r102 = true;
        if (Intrinsics.areEqual(r100, CJBadge.Dot.INSTANCE) == false) goto L14;
        Integer r103 = Integer.valueOf(this.dotView.getRight());
        if (r103.intValue() > 0) goto L8;
        r102 = false;
    L8:
        if (r102 == false) goto L10;
        r101 = r103;
    L10:
        if (r101 == null) goto L31;
        return r101.intValue();
    L31:
        return this.dotView.getMeasuredWidth();
    L14:
        if ((r100 instanceof CJBadge.Text) == false) goto L25;
        Integer r104 = Integer.valueOf(this.badgeTextView.getRight());
        if (r104.intValue() > 0) goto L19;
        r102 = false;
    L19:
        if (r102 == false) goto L21;
        r101 = r104;
    L21:
        if (r101 == null) goto L33;
        return r101.intValue();
    L33:
        return this.badgeTextView.getMeasuredWidth();
    L25:
        if (Intrinsics.areEqual(r100, CJBadge.None.INSTANCE) == false) goto L29;
        return getMeasuredWidth();
    L29:
        throw new NoWhenBranchMatchedException();
    }

    public final Typeface getContentTypeface() {
        return this.contentTextView.getTypeface();
    }

    public final Layout getLayout() {
        return this.contentTextView.getLayout();
    }

    public final int getLineCount() {
        return this.contentTextView.getLineCount();
    }

    public final int getMaxLines() {
        return this.contentTextView.getMaxLines();
    }

    public final CharSequence getText() {
        return this.contentTextView.getText();
    }

    public final float getTextSize() {
        return this.contentTextView.getTextSize();
    }

    public final void setAllCaps(boolean r100) {
        this.contentTextView.setAllCaps(r100);
    }

    public final void setBadge(CJBadge r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if (Intrinsics.areEqual(this.badge, r100) == false) goto L5;
        return;
    L5:
        this.badge = r100;
        applyBadge();
    }

    public final void setContentFakeBoldText(boolean r100) {
        this.contentTextView.getPaint().setFakeBoldText(r100);
        this.contentTextView.invalidate();
    }

    public final void setContentTypeface(Typeface r100) {
        this.contentTextView.setTypeface(r100);
    }

    public final void setMaxLines(int r100) {
        this.contentTextView.setMaxLines(r100);
    }

    public final void setMeasureBadgeWithoutWidthLimit(boolean r100) {
        if (this.measureBadgeWithoutWidthLimit == r100) goto L6;
        this.measureBadgeWithoutWidthLimit = r100;
        requestLayout();
        return;
    }

    public final void setSelectedText(boolean r100) {
        setSelected(r100);
        this.contentTextView.setSelected(r100);
    }

    public final void setText(CharSequence r100) {
        this.contentTextView.setText(r100);
    }

    public final void setTextAppearance(int r100) {
        TextViewCompat.setTextAppearance(this.contentTextView, r100);
    }

    public final void setTextColor(ColorStateList r100) {
        Intrinsics.checkNotNullParameter(r100, "colors");
        this.contentTextView.setTextColor(r100);
    }

    public final void setTypeface(Typeface r100) {
        setContentTypeface(r100);
    }

    public final void setTextColor(int r100) {
        this.contentTextView.setTextColor(r100);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r100, int r101) {
        measureChildWithMargins(this.contentTextView, r100, 0, r101, 0);
        if (this.measureBadgeWithoutWidthLimit == false) goto L5;
        int r102 = View.MeasureSpec.makeMeasureSpec(0, 0);
    L6:
        int r103 = r102;
        measureChildWithMargins(this.dotView, r103, 0, r101, 0);
        measureChildWithMargins(this.badgeTextView, r103, 0, r101, 0);
        int r104 = this.contentTextView.getMeasuredWidth();
        int r105 = this.contentTextView.getMeasuredHeight();
        setMeasuredDimension(FrameLayout.resolveSize(r104, r100), FrameLayout.resolveSize(r105, r101));
        return;
    L5:
        r102 = r100;
        goto L6
    }

    public final void setTextSize(int r100, float r101) {
        this.contentTextView.setTextSize(r100, r101);
    }

    public CJBadgeTextView(Context r100, AttributeSet r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r110, r111);
        this.badge = CJBadge.None.INSTANCE;
        AppCompatTextView r112 = new AppCompatTextView(r100);
        FrameLayout.LayoutParams r113 = new FrameLayout.LayoutParams(-2, -2);
        r113.gravity = 17;
        r112.setLayoutParams(r113);
        r112.setGravity(17);
        r112.setEllipsize(TextUtils.TruncateAt.END);
        r112.setMaxLines(1);
        this.contentTextView = r112;
        View r101 = new View(r100);
        r101.setLayoutParams(new FrameLayout.LayoutParams(CJPayBasicExtensionKt.dip2px(8.0f, r100), CJPayBasicExtensionKt.dip2px(8.0f, r100)));
        GradientDrawable r102 = new GradientDrawable();
        r102.setShape(1);
        r102.setColor(BADGE_COLOR);
        r101.setBackground(r102);
        r101.setVisibility(8);
        this.dotView = r101;
        AppCompatTextView r103 = new AppCompatTextView(r100);
        r103.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        r103.setTextColor(-1);
        r103.setTextSize(10.0f);
        r103.setTypeface(Typeface.DEFAULT_BOLD);
        r103.setIncludeFontPadding(false);
        r103.setGravity(17);
        r103.setEllipsize(TextUtils.TruncateAt.END);
        r103.setMaxLines(1);
        r103.setPadding(CJPayBasicExtensionKt.dip2px(4.0f, r100), CJPayBasicExtensionKt.dip2px(1.0f, r100), CJPayBasicExtensionKt.dip2px(4.0f, r100), CJPayBasicExtensionKt.dip2px(1.0f, r100));
        GradientDrawable r114 = new GradientDrawable();
        r114.setShape(0);
        r114.setCornerRadius(CJPayBasicExtensionKt.dip2px(999.0f, r100));
        r114.setColor(BADGE_COLOR);
        r103.setBackground(r114);
        r103.setVisibility(8);
        this.badgeTextView = r103;
        setClipChildren(false);
        setClipToPadding(false);
        addView(r112);
        addView(r101);
        addView(r103);
        applyBadge();
    }

    public /* synthetic */ CJBadgeTextView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        AppCompatTextView r105 = this.contentTextView;
        r105.layout(0, 0, r105.getMeasuredWidth() + 0, this.contentTextView.getMeasuredHeight() + 0);
        CJBadge r106 = this.badge;
        if (Intrinsics.areEqual(r106, CJBadge.None.INSTANCE) == false) goto L6;
        this.dotView.layout(0, 0, 0, 0);
        this.badgeTextView.layout(0, 0, 0, 0);
        return;
    L6:
        if (Intrinsics.areEqual(r106, CJBadge.Dot.INSTANCE) == false) goto L9;
        int r107 = this.dotView.getMeasuredWidth();
        int r108 = this.contentTextView.getRight() + CJPayBasicExtensionKt.dip2px(0.0f, getContext());
        int r109 = (0 - r107) + CJPayBasicExtensionKt.dip2px(8.0f, getContext());
        this.dotView.layout(r108, r109, r108 + r107, r107 + r109);
        this.badgeTextView.layout(0, 0, 0, 0);
        return;
    L9:
        if ((r106 instanceof CJBadge.Text) == false) goto L14;
        int r110 = this.contentTextView.getRight() + CJPayBasicExtensionKt.dip2px(-7.0f, getContext());
        int r111 = (0 - this.badgeTextView.getMeasuredHeight()) + CJPayBasicExtensionKt.dip2px(7.0f, getContext());
        AppCompatTextView r112 = this.badgeTextView;
        r112.layout(r110, r111, r112.getMeasuredWidth() + r110, this.badgeTextView.getMeasuredHeight() + r111);
        this.dotView.layout(0, 0, 0, 0);
        return;
    }
}
