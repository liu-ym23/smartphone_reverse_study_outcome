package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.google.android.material.g.d;
import com.google.android.material.internal.j;
import com.google.android.material.internal.l;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class BadgeDrawable extends Drawable implements j.a {
    public static final int BOTTOM_END = 8388693;
    public static final int BOTTOM_START = 8388691;
    static final String DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX = "+";
    private static final int DEFAULT_STYLE = 0;
    private static final int DEFAULT_THEME_ATTR = 0;
    private static final int MAX_CIRCULAR_BADGE_NUMBER_COUNT = 9;
    public static final int TOP_END = 8388661;
    public static final int TOP_START = 8388659;
    private WeakReference<View> anchorViewRef;
    private final Rect badgeBounds;
    private float badgeCenterX;
    private float badgeCenterY;
    private final WeakReference<Context> contextRef;
    private float cornerRadius;
    private WeakReference<FrameLayout> customBadgeParentRef;
    private float halfBadgeHeight;
    private float halfBadgeWidth;
    private int maxBadgeNumber;
    private final MaterialShapeDrawable shapeDrawable;
    private final BadgeState state;
    private final j textDrawableHelper;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r1) {
    }

    static {
        DEFAULT_STYLE = ZeusTransformUtils.mapRes(R.style.Widget_MaterialComponents_Badge, "style", "Widget_MaterialComponents_Badge");
        DEFAULT_THEME_ATTR = ZeusTransformUtils.mapRes(R.attr.badgeStyle, "attr", "badgeStyle");
    }

    BadgeState.State getSavedState() {
        return this.state.a();
    }

    static BadgeDrawable createFromSavedState(Context r6, BadgeState.State r7) {
        return new BadgeDrawable((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin"), 0, DEFAULT_THEME_ATTR, DEFAULT_STYLE, r7);
    }

    public static BadgeDrawable create(Context r6) {
        return new BadgeDrawable((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin"), 0, DEFAULT_THEME_ATTR, DEFAULT_STYLE, null);
    }

    public static BadgeDrawable createFromResource(Context r6, int r7) {
        return new BadgeDrawable((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin"), r7, DEFAULT_THEME_ATTR, DEFAULT_STYLE, null);
    }

    public void setVisible(boolean r2) {
        this.state.a(r2);
        onVisibilityUpdated();
    }

    private void onVisibilityUpdated() {
        boolean r0 = this.state.b();
        setVisible(r0, false);
        if (a.f13204a == true) goto L5;
        return;
    L5:
        if (getCustomBadgeParent() == null) goto L10;
        if (r0 == true) goto L11;
        ((ViewGroup) ZeusTransformUtils.preCheckCast(getCustomBadgeParent().getParent(), ViewGroup.class, "com.obric.aiagent.plugin")).invalidate();
        return;
    L11:
        return;
    }

    private void restoreState() {
        onMaxCharacterCountUpdated();
        onNumberUpdated();
        onAlphaUpdated();
        onBackgroundColorUpdated();
        onBadgeTextColorUpdated();
        onBadgeGravityUpdated();
        updateCenterAndBounds();
        onVisibilityUpdated();
    }

    private BadgeDrawable(Context r7, int r8, int r9, int r10, BadgeState.State r11) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        this.contextRef = new WeakReference(r1);
        l.b(r1);
        this.badgeBounds = new Rect();
        this.shapeDrawable = new MaterialShapeDrawable();
        j r12 = new j(this);
        this.textDrawableHelper = r12;
        r12.a().setTextAlign(Paint.Align.CENTER);
        setTextAppearanceResource(ZeusTransformUtils.mapRes(R.style.TextAppearance_MaterialComponents_Badge, "style", "TextAppearance_MaterialComponents_Badge"));
        this.state = new BadgeState(r1, r8, r9, r10, r11);
        restoreState();
    }

    @Deprecated
    public void updateBadgeCoordinates(View r3, ViewGroup r4) {
        if (ZeusTransformUtils.instanceOf(r4, FrameLayout.class) == false) goto L7;
        updateBadgeCoordinates(r3, (FrameLayout) ZeusTransformUtils.preCheckCast(r4, FrameLayout.class, "com.obric.aiagent.plugin"));
        return;
    L7:
        throw new IllegalArgumentException("customBadgeParent must be a FrameLayout");
    }

    public void updateBadgeCoordinates(View r2) {
        updateBadgeCoordinates(r2, null);
    }

    public void updateBadgeCoordinates(View r2, FrameLayout r3) {
        this.anchorViewRef = new WeakReference(r2);
        if (a.f13204a == false) goto L6;
        if (r3 != null) goto L6;
        tryWrapAnchorInCompatParent(r2);
    L8:
        if (a.f13204a == true) goto L10;
        updateAnchorParentToNotClip(r2);
    L10:
        updateCenterAndBounds();
        invalidateSelf();
        return;
    L6:
        this.customBadgeParentRef = new WeakReference(r3);
        goto L8
    }

    public FrameLayout getCustomBadgeParent() {
        WeakReference<FrameLayout> r2 = this.customBadgeParentRef;
        if (r2 != null) goto L7;
        return null;
    L7:
        return (FrameLayout) ZeusTransformUtils.preCheckCast(r2.get(), FrameLayout.class, "com.obric.aiagent.plugin");
    }

    private void tryWrapAnchorInCompatParent(final View r8) {
        ViewGroup r0 = (ViewGroup) ZeusTransformUtils.preCheckCast(r8.getParent(), ViewGroup.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L6:
        WeakReference<FrameLayout> r4 = this.customBadgeParentRef;
        if (r4 != null) goto L9;
    L11:
        updateAnchorParentToNotClip(r8);
        final FrameLayout r5 = new FrameLayout((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        r5.setId(ZeusTransformUtils.mapRes(R.id.mtrl_anchor_parent, DbHelper.COL_ID, "mtrl_anchor_parent"));
        r5.setClipChildren(false);
        r5.setClipToPadding(false);
        r5.setLayoutParams(r8.getLayoutParams());
        r5.setMinimumWidth(r8.getWidth());
        r5.setMinimumHeight(r8.getHeight());
        int r1 = r0.indexOfChild(r8);
        r0.removeViewAt(r1);
        r8.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r5.addView(r8);
        r0.addView(r5, r1);
        this.customBadgeParentRef = new WeakReference(r5);
        r5.post(new AnonymousClass1(this, r8, r5));
        return;
    L9:
        if (r4.get() != r0) goto L11;
        return;
    L5:
        if (r0.getId() != ZeusTransformUtils.mapRes(R.id.mtrl_anchor_parent, DbHelper.COL_ID, "mtrl_anchor_parent")) goto L6;
    }

    private static void updateAnchorParentToNotClip(View r2) {
        ViewGroup r3 = (ViewGroup) ZeusTransformUtils.preCheckCast(r2.getParent(), ViewGroup.class, "com.obric.aiagent.plugin");
        r3.setClipChildren(false);
        r3.setClipToPadding(false);
    }

    public int getBackgroundColor() {
        return this.shapeDrawable.getFillColor().getDefaultColor();
    }

    public void setBackgroundColor(int r2) {
        this.state.d(r2);
        onBackgroundColorUpdated();
    }

    private void onBackgroundColorUpdated() {
        ColorStateList r0 = ColorStateList.valueOf(this.state.h());
        if (this.shapeDrawable.getFillColor() == r0) goto L6;
        this.shapeDrawable.setFillColor(r0);
        invalidateSelf();
        return;
    }

    public int getBadgeTextColor() {
        return this.textDrawableHelper.a().getColor();
    }

    public void setBadgeTextColor(int r2) {
        if (this.textDrawableHelper.a().getColor() == r2) goto L6;
        this.state.e(r2);
        onBadgeTextColorUpdated();
        return;
    }

    private void onBadgeTextColorUpdated() {
        this.textDrawableHelper.a().setColor(this.state.i());
        invalidateSelf();
    }

    public Locale getBadgeNumberLocale() {
        return this.state.t();
    }

    public void setBadgeNumberLocale(Locale r2) {
        if (r2.equals(this.state.t()) == true) goto L6;
        this.state.a(r2);
        invalidateSelf();
        return;
    }

    public boolean hasNumber() {
        return this.state.c();
    }

    public int getNumber() {
        if (hasNumber() == true) goto L7;
        return 0;
    L7:
        return this.state.d();
    }

    public void setNumber(int r2) {
        int r3 = Math.max(0, r2);
        if (this.state.d() == r3) goto L6;
        this.state.a(r3);
        onNumberUpdated();
        return;
    }

    public void clearNumber() {
        if (hasNumber() == false) goto L6;
        this.state.e();
        onNumberUpdated();
        return;
    }

    private void onNumberUpdated() {
        this.textDrawableHelper.a(true);
        updateCenterAndBounds();
        invalidateSelf();
    }

    public int getMaxCharacterCount() {
        return this.state.g();
    }

    public void setMaxCharacterCount(int r2) {
        if (this.state.g() == r2) goto L6;
        this.state.c(r2);
        onMaxCharacterCountUpdated();
        return;
    }

    private void onMaxCharacterCountUpdated() {
        updateMaxBadgeNumber();
        this.textDrawableHelper.a(true);
        updateCenterAndBounds();
        invalidateSelf();
    }

    public int getBadgeGravity() {
        return this.state.j();
    }

    public void setBadgeGravity(int r2) {
        if (this.state.j() == r2) goto L6;
        this.state.f(r2);
        onBadgeGravityUpdated();
        return;
    }

    private void onBadgeGravityUpdated() {
        WeakReference<View> r0 = this.anchorViewRef;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.get() == null) goto L13;
        View r1 = (View) ZeusTransformUtils.preCheckCast(this.anchorViewRef.get(), View.class, "com.obric.aiagent.plugin");
        WeakReference<FrameLayout> r2 = this.customBadgeParentRef;
        if (r2 == null) goto L9;
        FrameLayout r3 = (FrameLayout) ZeusTransformUtils.preCheckCast(r2.get(), FrameLayout.class, "com.obric.aiagent.plugin");
    L10:
        updateBadgeCoordinates(r1, r3);
        return;
    L9:
        r3 = null;
        goto L10
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.state.f();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        this.state.b(r2);
        onAlphaUpdated();
    }

    private void onAlphaUpdated() {
        this.textDrawableHelper.a().setAlpha(getAlpha());
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.badgeBounds.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.badgeBounds.width();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r2) {
        if (getBounds().isEmpty() == false) goto L5;
        return;
    L5:
        if (getAlpha() != 0) goto L7;
        return;
    L7:
        if (isVisible() == false) goto L16;
        this.shapeDrawable.draw(r2);
        if (hasNumber() == false) goto L15;
        drawText(r2);
        return;
    L15:
        return;
    }

    @Override // com.google.android.material.internal.j.a
    public void onTextSizeChange() {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.j.a
    public boolean onStateChange(int[] r1) {
        return super.onStateChange(r1);
    }

    public void setContentDescriptionNumberless(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.state.a(r4);
    }

    public void setContentDescriptionQuantityStringsResource(int r1) {
        this.state.m(r1);
    }

    public void setContentDescriptionExceedsMaxBadgeNumberStringResource(int r1) {
        this.state.n(r1);
    }

    public CharSequence getContentDescription() {
        if (isVisible() == true) goto L6;
        return null;
    L6:
        if (hasNumber() == false) goto L20;
        if (this.state.r() == 0) goto L18;
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(this.contextRef.get(), Context.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L13;
        return null;
    L13:
        if (getNumber() > this.maxBadgeNumber) goto L17;
        return ZeusTransformUtils.getResources(r0, "com.obric.aiagent.plugin").getQuantityString(this.state.r(), getNumber(), new Object[]{Integer.valueOf(getNumber())});
    L17:
        return r0.getString(this.state.s(), new Object[]{Integer.valueOf(this.maxBadgeNumber)});
    L18:
        return null;
    L20:
        return this.state.q();
    }

    public void setHorizontalOffset(int r1) {
        setHorizontalOffsetWithoutText(r1);
        setHorizontalOffsetWithText(r1);
    }

    public int getHorizontalOffset() {
        return this.state.k();
    }

    public void setHorizontalOffsetWithoutText(int r2) {
        this.state.g(r2);
        updateCenterAndBounds();
    }

    public int getHorizontalOffsetWithoutText() {
        return this.state.k();
    }

    public void setHorizontalOffsetWithText(int r2) {
        this.state.i(r2);
        updateCenterAndBounds();
    }

    public int getHorizontalOffsetWithText() {
        return this.state.m();
    }

    void setAdditionalHorizontalOffset(int r2) {
        this.state.k(r2);
        updateCenterAndBounds();
    }

    int getAdditionalHorizontalOffset() {
        return this.state.o();
    }

    public void setVerticalOffset(int r1) {
        setVerticalOffsetWithoutText(r1);
        setVerticalOffsetWithText(r1);
    }

    public int getVerticalOffset() {
        return this.state.l();
    }

    public void setVerticalOffsetWithoutText(int r2) {
        this.state.h(r2);
        updateCenterAndBounds();
    }

    public int getVerticalOffsetWithoutText() {
        return this.state.l();
    }

    public void setVerticalOffsetWithText(int r2) {
        this.state.j(r2);
        updateCenterAndBounds();
    }

    public int getVerticalOffsetWithText() {
        return this.state.n();
    }

    void setAdditionalVerticalOffset(int r2) {
        this.state.l(r2);
        updateCenterAndBounds();
    }

    int getAdditionalVerticalOffset() {
        return this.state.p();
    }

    private void setTextAppearanceResource(int r4) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(this.contextRef.get(), Context.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        setTextAppearance(new d(r0, r4));
    }

    private void setTextAppearance(d r4) {
        if (this.textDrawableHelper.b() != r4) goto L5;
        return;
    L5:
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(this.contextRef.get(), Context.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L8;
        return;
    L8:
        this.textDrawableHelper.a(r4, r0);
        updateCenterAndBounds();
    }

    private void updateCenterAndBounds() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(this.contextRef.get(), Context.class, "com.obric.aiagent.plugin");
        WeakReference<View> r1 = this.anchorViewRef;
        ViewGroup r3 = null;
        if (r1 == null) goto L5;
        View r2 = (View) ZeusTransformUtils.preCheckCast(r1.get(), View.class, "com.obric.aiagent.plugin");
    L6:
        if (r0 == null) goto L22;
        if (r2 == null) goto L24;
        Rect r4 = new Rect();
        r4.set(this.badgeBounds);
        Rect r5 = new Rect();
        r2.getDrawingRect(r5);
        WeakReference<FrameLayout> r6 = this.customBadgeParentRef;
        if (r6 == null) goto L12;
        r3 = (FrameLayout) ZeusTransformUtils.preCheckCast(r6.get(), FrameLayout.class, "com.obric.aiagent.plugin");
    L12:
        if (r3 == null) goto L14;
    L15:
        if (r3 != null) goto L17;
        r3 = (ViewGroup) ZeusTransformUtils.preCheckCast(r2.getParent(), ViewGroup.class, "com.obric.aiagent.plugin");
    L17:
        r3.offsetDescendantRectToMyCoords(r2, r5);
    L18:
        calculateCenterAndBounds(r0, r5, r2);
        a.a(this.badgeBounds, this.badgeCenterX, this.badgeCenterY, this.halfBadgeWidth, this.halfBadgeHeight);
        this.shapeDrawable.setCornerSize(this.cornerRadius);
        if (r4.equals(this.badgeBounds) == true) goto L23;
        this.shapeDrawable.setBounds(this.badgeBounds);
        return;
    L23:
        return;
    L14:
        if (a.f13204a == false) goto L18;
    L24:
        return;
    L22:
        return;
    L5:
        r2 = null;
        goto L6
    }

    private int getTotalVerticalOffsetForState() {
        if (hasNumber() == false) goto L5;
        int r0 = this.state.n();
    L7:
        return r0 + this.state.p();
    L5:
        r0 = this.state.l();
        goto L7
    }

    private int getTotalHorizontalOffsetForState() {
        if (hasNumber() == false) goto L5;
        int r0 = this.state.m();
    L7:
        return r0 + this.state.o();
    L5:
        r0 = this.state.k();
        goto L7
    }

    private void calculateCenterAndBounds(Context r6, Rect r7, View r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        int r0 = getTotalVerticalOffsetForState();
        int r2 = this.state.j();
        if (r2 != 8388691) goto L5;
    L7:
        this.badgeCenterY = r7.bottom - r0;
    L9:
        if (getNumber() <= 9) goto L11;
        float r1 = this.state.f13200b;
        this.cornerRadius = r1;
        this.halfBadgeHeight = r1;
        this.halfBadgeWidth = (this.textDrawableHelper.a(getBadgeText()) / 2.0f) + this.state.f13201c;
    L16:
        Resources r10 = ZeusTransformUtils.getResources(r9, "com.obric.aiagent.plugin");
        if (hasNumber() == false) goto L19;
        int r3 = ZeusTransformUtils.mapRes(R.dimen.mtrl_badge_text_horizontal_edge_offset, "dimen", "mtrl_badge_text_horizontal_edge_offset");
    L20:
        int r11 = r10.getDimensionPixelSize(r3);
        int r4 = getTotalHorizontalOffsetForState();
        int r5 = this.state.j();
        if (r5 == 8388659) goto L29;
        if (r5 == 8388691) goto L29;
        if (ViewCompat.i(r8) != 0) goto L26;
        float r12 = ((r7.right + this.halfBadgeWidth) - r11) - r4;
    L27:
        this.badgeCenterX = r12;
        return;
    L26:
        r12 = ((r7.left - this.halfBadgeWidth) + r11) + r4;
    L29:
        if (ViewCompat.i(r8) != 0) goto L31;
        float r13 = ((r7.left - this.halfBadgeWidth) + r11) + r4;
    L32:
        this.badgeCenterX = r13;
        return;
    L31:
        r13 = ((r7.right + this.halfBadgeWidth) - r11) - r4;
        goto L32
    L19:
        r3 = ZeusTransformUtils.mapRes(R.dimen.mtrl_badge_horizontal_edge_offset, "dimen", "mtrl_badge_horizontal_edge_offset");
        goto L20
    L11:
        if (hasNumber() == true) goto L13;
        float r14 = this.state.f13199a;
    L14:
        this.cornerRadius = r14;
        this.halfBadgeHeight = r14;
        this.halfBadgeWidth = r14;
        goto L16
    L13:
        r14 = this.state.f13200b;
        goto L14
    L5:
        if (r2 == 8388693) goto L7;
        this.badgeCenterY = r7.top + r0;
        goto L9
    }

    private void drawText(Canvas r6) {
        Rect r0 = new Rect();
        String r1 = getBadgeText();
        this.textDrawableHelper.a().getTextBounds(r1, 0, r1.length(), r0);
        r6.drawText(r1, this.badgeCenterX, this.badgeCenterY + (r0.height() / 2), this.textDrawableHelper.a());
    }

    private String getBadgeText() {
        if (getNumber() <= this.maxBadgeNumber) goto L5;
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(this.contextRef.get(), Context.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L11;
        return "";
    L11:
        return String.format(this.state.t(), r0.getString(ZeusTransformUtils.mapRes(R.string.mtrl_exceed_max_badge_number_suffix, WsChannelMultiProcessSharedProvider.STRING_TYPE, "mtrl_exceed_max_badge_number_suffix")), new Object[]{Integer.valueOf(this.maxBadgeNumber), DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX});
    L5:
        return NumberFormat.getInstance(this.state.t()).format(getNumber());
    }

    private void updateMaxBadgeNumber() {
        this.maxBadgeNumber = ((int) Math.pow(10.0d, ((double) getMaxCharacterCount()) - 1.0d)) - 1;
    }
}
