package com.obric.oui.popover.v2;

import android.animation.ArgbEvaluator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.LinearLayout;
import androidx.core.graphics.e;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.obric.oui.d.i;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.k;
import com.obric.oui.material.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Objects;

/* JADX INFO: compiled from: OPopoverLayout.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OPopoverLayout extends LinearLayout {
    private static int ARROW_PADDING = 0;
    public static final int BOTTOM = 3;
    private static float CORNER_RADIUS_DP = 0.0f;
    public static final a Companion = null;
    private static int DEFAULT_HEIGHT = 0;
    public static final int LEFT = 1;
    private static float MIN_ARROW_DISTANCE_DP = 0.0f;
    public static final int RIGHT = 2;
    private static final String TAG = "OPopoverLayout";
    public static final int TOP = 0;
    private int appliedMaterialSrcType;
    private d.h.a.b<? super Boolean, com.obric.oui.material.c[]> appliedMaterials;
    private int borderColor;
    private int borderWidth;
    private final ArgbEvaluator colorEvaluator;
    private int coverColor;
    private int coverColorOnAnimStart;
    private boolean coverEnabled;
    private int currentCoverColor;
    private boolean enableMaterial;
    private boolean enableMaterialByUser;
    private ValueAnimator fillPaintAnimator;
    private int mBgColor;
    private float mCornerRadius;
    private Paint mFillPaint;
    private float mHeight;
    private Path mPath;
    private Rect mRoundRect;
    private RectF mRoundRectF;
    private float mWidth;
    private int pressStateColor;
    private Paint strokePaint;

    /* JADX INFO: compiled from: OPopoverLayout.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final float a() {
            return OPopoverLayout.access$getCORNER_RADIUS_DP$cp();
        }
    }

    /* JADX INFO: renamed from: lambda$-wPTje6La-MggAZN9p4dG9wbBYs, reason: not valid java name */
    public static /* synthetic */ void m1137lambda$wPTje6LaMggAZN9p4dG9wbBYs(OPopoverLayout r0, ValueAnimator r1) {
        m1138startFillPaintFadeIfNeeded$lambda2$lambda1(r0, r1);
    }

    public void applyDynamicTheme(int r1) {
    }

    public static final /* synthetic */ int access$getARROW_PADDING$cp() {
        return ARROW_PADDING;
    }

    public static final /* synthetic */ int access$getBorderWidth$p(OPopoverLayout r0) {
        return r0.borderWidth;
    }

    public static final /* synthetic */ float access$getCORNER_RADIUS_DP$cp() {
        return CORNER_RADIUS_DP;
    }

    public static final /* synthetic */ int access$getDEFAULT_HEIGHT$cp() {
        return DEFAULT_HEIGHT;
    }

    public static final /* synthetic */ float access$getMCornerRadius$p(OPopoverLayout r0) {
        return r0.mCornerRadius;
    }

    public static final /* synthetic */ float access$getMIN_ARROW_DISTANCE_DP$cp() {
        return MIN_ARROW_DISTANCE_DP;
    }

    public static final /* synthetic */ Rect access$getMRoundRect$p(OPopoverLayout r0) {
        return r0.mRoundRect;
    }

    public static final /* synthetic */ RectF access$getMRoundRectF$p(OPopoverLayout r0) {
        return r0.mRoundRectF;
    }

    public static final /* synthetic */ void access$setARROW_PADDING$cp(int r0) {
        ARROW_PADDING = r0;
    }

    public static final /* synthetic */ void access$setCORNER_RADIUS_DP$cp(float r0) {
        CORNER_RADIUS_DP = r0;
    }

    public static final /* synthetic */ void access$setDEFAULT_HEIGHT$cp(int r0) {
        DEFAULT_HEIGHT = r0;
    }

    public static final /* synthetic */ void access$setMIN_ARROW_DISTANCE_DP$cp(float r0) {
        MIN_ARROW_DISTANCE_DP = r0;
    }

    static {
        Companion = new a(null);
        CORNER_RADIUS_DP = 28.0f;
        DEFAULT_HEIGHT = 36;
    }

    public /* synthetic */ OPopoverLayout(Context r2, boolean r3, d.h.a.b r4, int r5, int r6, h r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        d.h.a.b<Boolean, com.obric.oui.material.c[]> r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r6 & 4) == 0) goto L6;
        r9 = MaterialToken.OUI_Bg_Popup;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = 3;
    L8:
        this(r8, r3, r9, r5);
    }

    public OPopoverLayout(Context r10, boolean r11, d.h.a.b<? super Boolean, com.obric.oui.material.c[]> r12, int r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        o.e(r7, "materials");
        this(r3, null, 0, r11, r7, r13);
    }

    public OPopoverLayout(Context r12, AttributeSet r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r13, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, true, null, 0, 48, null);
    }

    public OPopoverLayout(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7, r5);
        this.mCornerRadius = g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), CORNER_RADIUS_DP);
        this.coverColor = Color.parseColor("#20000000");
        this.coverColorOnAnimStart = this.currentCoverColor;
        this.colorEvaluator = new ArgbEvaluator();
        this.mRoundRect = new Rect();
        this.mRoundRectF = new RectF();
        this.enableMaterialByUser = true;
        this.appliedMaterials = MaterialToken.OUI_Bg_Popup;
        this.appliedMaterialSrcType = 3;
        init(r6, r7);
    }

    public /* synthetic */ OPopoverLayout(Context r10, AttributeSet r11, int r12, boolean r13, d.h.a.b r14, int r15, int r16, h r17) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        d.h.a.b<Boolean, com.obric.oui.material.c[]> r0 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r14, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r16 & 8) == 0) goto L5;
        boolean r6 = true;
    L7:
        if ((r16 & 16) == 0) goto L9;
        r0 = MaterialToken.OUI_Bg_Popup;
    L9:
        d.h.a.b<Boolean, com.obric.oui.material.c[]> r7 = r0;
        if ((r16 & 32) == 0) goto L12;
        int r8 = 3;
    L13:
        this(r3, r4, r12, r6, r7, r8);
        return;
    L12:
        r8 = r15;
        goto L13
    L5:
        r6 = r13;
        goto L7
    }

    public OPopoverLayout(Context r3, AttributeSet r4, int r5, boolean r6, d.h.a.b<? super Boolean, com.obric.oui.material.c[]> r7, int r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super Boolean, com.obric.oui.material.c[]> r11 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r9, "context");
        o.e(r11, "materials");
        super(r9, r10, r5);
        this.mCornerRadius = g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), CORNER_RADIUS_DP);
        this.coverColor = Color.parseColor("#20000000");
        this.coverColorOnAnimStart = this.currentCoverColor;
        this.colorEvaluator = new ArgbEvaluator();
        this.mRoundRect = new Rect();
        this.mRoundRectF = new RectF();
        this.enableMaterialByUser = true;
        this.appliedMaterials = MaterialToken.OUI_Bg_Popup;
        this.appliedMaterialSrcType = 3;
        this.enableMaterialByUser = r6;
        this.appliedMaterials = r11;
        this.appliedMaterialSrcType = r8;
        init(r9, r10);
    }

    public final float getMWidth() {
        return this.mWidth;
    }

    public final void setMWidth(float r1) {
        this.mWidth = r1;
    }

    public final float getMHeight() {
        return this.mHeight;
    }

    public final void setMHeight(float r1) {
        this.mHeight = r1;
    }

    public final void setMBgColor(int r1) {
        this.mBgColor = r1;
    }

    public final int getMBgColor() {
        int r0 = this.pressStateColor;
        if (r0 == 0) goto L6;
        return r0;
    L6:
        return this.mBgColor;
    }

    public final void init(Context r7, AttributeSet r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r9, "context");
        this.mFillPaint = new Paint();
        this.mPath = new Path();
        Paint r11 = this.mFillPaint;
        Paint r0 = null;
        if (r11 != null) goto L5;
        o.c("mFillPaint");
        r11 = null;
    L5:
        r11.setStyle(Paint.Style.FILL);
        Paint r12 = this.mFillPaint;
        if (r12 != null) goto L8;
        o.c("mFillPaint");
        r12 = null;
    L8:
        r12.setStrokeCap(Paint.Cap.BUTT);
        Paint r13 = this.mFillPaint;
        if (r13 != null) goto L11;
        o.c("mFillPaint");
        r13 = null;
    L11:
        boolean r3 = true;
        r13.setAntiAlias(true);
        Paint r14 = this.mFillPaint;
        if (r14 != null) goto L14;
        o.c("mFillPaint");
        r14 = null;
    L14:
        r14.setStrokeJoin(Paint.Join.MITER);
        if (getMBgColor() != 0) goto L17;
        this.mBgColor = androidx.core.content.a.c(r9, ZeusTransformUtils.mapRes(R.color.oui_bg_base_3, "color", "oui_bg_base_3"));
    L17:
        Paint r15 = this.mFillPaint;
        if (r15 != null) goto L20;
        o.c("mFillPaint");
    L21:
        r0.setColor(getMBgColor());
        setClipChildren(false);
        setOutlineProvider((ViewOutlineProvider) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), ViewOutlineProvider.class, "com.obric.aiagent.plugin"));
        setClipToOutline(true);
        setBackgroundColor(0);
        if (k.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin")) == true) goto L24;
    L26:
        r3 = false;
    L27:
        this.enableMaterial = r3;
        updateMaterial();
        return;
    L24:
        if (l.d() == false) goto L26;
    L20:
        r0 = r15;
        goto L21
    }

    public boolean isDarkTheme() {
        if (getMBgColor() != 0) goto L7;
        return i.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"));
    L7:
        return com.obric.oui.color.d.a(getMBgColor());
    }

    public final void setBgColor(int r2) {
        if (getMBgColor() != r2) goto L5;
        return;
    L5:
        this.mBgColor = r2;
        Paint r3 = this.mFillPaint;
        if (r3 != null) goto L8;
        o.c("mFillPaint");
        r3 = null;
    L8:
        r3.setColor(getMBgColor());
        updateMaterial();
    }

    private final void updateMaterial() {
        if (this.enableMaterialByUser == true) goto L6;
        return;
    L6:
        if (this.enableMaterial == true) goto L8;
        return;
    L8:
        com.obric.oui.material.c[] r4 = (com.obric.oui.material.c[]) ZeusTransformUtils.preCheckCast(this.appliedMaterials.invoke(Boolean.valueOf(!isDarkTheme())), com.obric.oui.material.c[].class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L13;
        k.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r4, false, this.appliedMaterialSrcType, null, 10, null);
        return;
    }

    private final void startFillPaintFadeIfNeeded() {
        if (this.enableMaterial == true) goto L5;
        return;
    L5:
        if (this.enableMaterialByUser == false) goto L20;
        int r0 = getMBgColor();
        int r1 = e.b(getMBgColor(), 0);
        ValueAnimator r3 = this.fillPaintAnimator;
        if (r3 == null) goto L11;
        r3.cancel();
    L11:
        if (r0 != r1) goto L17;
        Paint r6 = this.mFillPaint;
        if (r6 != null) goto L15;
        o.c("mFillPaint");
        r6 = null;
    L15:
        r6.setColor(r1);
        return;
    L17:
        ValueAnimator r2 = ValueAnimator.ofObject((TypeEvaluator) ZeusTransformUtils.preCheckCast(new ArgbEvaluator(), TypeEvaluator.class, "com.obric.aiagent.plugin"), new Object[]{Integer.valueOf(r0), Integer.valueOf(r1)});
        r2.setDuration(400);
        r2.addUpdateListener(new $$Lambda$OPopoverLayout$wPTje6LaMggAZN9p4dG9wbBYs(this));
        r2.start();
        this.fillPaintAnimator = r2;
        return;
    }

    /* JADX INFO: renamed from: startFillPaintFadeIfNeeded$lambda-2$lambda-1, reason: not valid java name */
    private static final void m1138startFillPaintFadeIfNeeded$lambda2$lambda1(OPopoverLayout r3, ValueAnimator r4) {
        o.e(r3, "this$0");
        o.e(r4, "animator");
        Paint r0 = r3.mFillPaint;
        if (r0 != null) goto L5;
        o.c("mFillPaint");
        r0 = null;
    L5:
        Object r5 = r4.getAnimatedValue();
        Objects.requireNonNull(r5, "null cannot be cast to non-null type kotlin.Int");
        r0.setColor(((Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.aiagent.plugin")).intValue());
        r3.invalidate();
    }

    public final void setCornerRadiusDp(float r3) {
        this.mCornerRadius = g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r3);
    }

    public final void setCornerRadius(float r1) {
        this.mCornerRadius = r1;
    }

    public final float getCornerRadius() {
        return this.mCornerRadius;
    }

    public final boolean isEnableMaterial() {
        if (this.enableMaterial == true) goto L5;
    L7:
        return false;
    L5:
        if (this.enableMaterialByUser == false) goto L7;
        return true;
    }

    public final void setBorderColor(int r2) {
        this.borderColor = r2;
        if (this.strokePaint != null) goto L5;
        this.strokePaint = new Paint(1);
    L5:
        Paint r3 = this.strokePaint;
        if (r3 == null) goto L10;
        r3.setColor(this.borderColor);
        return;
    }

    public final void setBorderWidth(int r4) {
        if (r4 > 0) goto L4;
        return;
    L4:
        this.borderWidth = r4;
        if (this.strokePaint != null) goto L7;
        this.strokePaint = new Paint(1);
    L7:
        Paint r5 = this.strokePaint;
        if (r5 == null) goto L12;
        r5.setStyle(Paint.Style.STROKE);
        r5.setStrokeWidth(this.borderWidth);
        r5.setStrokeCap(Paint.Cap.BUTT);
        r5.setStrokeJoin(Paint.Join.MITER);
        r5.setAntiAlias(true);
        r5.setXfermode((Xfermode) ZeusTransformUtils.preCheckCast(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER), Xfermode.class, "com.obric.aiagent.plugin"));
        r5.setColor(this.borderColor);
        return;
    }

    public final void setTransparentBg(boolean r2) {
        setClipToOutline(!r2);
        if (r2 == false) goto L5;
        this.mBgColor = 0;
    L5:
        invalidateOutline();
        invalidate();
    }

    public static /* synthetic */ void setCovered$default(OPopoverLayout r0, boolean r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = Color.parseColor("#20000000");
    L5:
        r0.setCovered(r1, r2);
    }

    public final void setCovered(boolean r1, int r2) {
        this.coverEnabled = r1;
        this.coverColor = r2;
        this.coverColorOnAnimStart = this.currentCoverColor;
        invalidate();
    }

    public final void updateCoverAnimFraction(float r4) {
        Object r5 = this.colorEvaluator.evaluate(r4, Integer.valueOf(this.coverColorOnAnimStart), Integer.valueOf(this.coverColor));
        Objects.requireNonNull(r5, "null cannot be cast to non-null type kotlin.Int");
        this.currentCoverColor = ((Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.aiagent.plugin")).intValue();
        invalidate();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r2) {
        if (this.coverEnabled == false) goto L5;
    L8:
        return true;
    L5:
        if (super.onInterceptTouchEvent(r2) == true) goto L8;
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r2) {
        if (this.coverEnabled == false) goto L6;
        return true;
    L6:
        return super.onTouchEvent(r2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r4) {
        o.e(r4, "canvas");
        super.dispatchDraw(r4);
        if (this.coverEnabled == true) goto L5;
        return;
    L5:
        RectF r0 = this.mRoundRectF;
        Paint r1 = new Paint(1);
        r1.setColor(this.currentCoverColor);
        float r3 = this.mCornerRadius;
        r4.drawRoundRect(r0, r3, r3, r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        l.b(this, this.appliedMaterialSrcType);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l.b(this, 0);
    }

    public final float getBubbleOffset(int r6) {
        float r0 = g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), MIN_ARROW_DISTANCE_DP);
        float r3 = Math.max(0.0f, r0);
        if (r6 == 0) goto L15;
        if (r6 == 1) goto L18;
        if (r6 == 2) goto L17;
        if (r6 == 3) goto L16;
        return 0.0f;
    L16:
        return Math.min(r3, (this.mWidth - g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), ARROW_PADDING)) - r0);
    L17:
        return Math.min(r3, (this.mHeight - g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), ARROW_PADDING)) - r0);
    L18:
        return Math.min(r3, (this.mHeight - g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), ARROW_PADDING)) - r0);
    L15:
        return Math.min(r3, (this.mWidth - g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), ARROW_PADDING)) - r0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas r6) {
        o.e(r6, "canvas");
        Paint r1 = null;
        if (this.enableMaterial == true) goto L12;
        Paint r0 = this.mFillPaint;
        if (r0 != null) goto L7;
        o.c("mFillPaint");
        r0 = null;
    L7:
        r0.setColor(getMBgColor());
        RectF r2 = this.mRoundRectF;
        float r3 = this.mCornerRadius;
        Paint r4 = this.mFillPaint;
        if (r4 != null) goto L10;
        o.c("mFillPaint");
    L11:
        r6.drawRoundRect(r2, r3, r3, r1);
    L17:
        Paint r5 = this.strokePaint;
        if (r5 != null) goto L21;
        return;
    L21:
        if (this.borderWidth <= 0) goto L24;
        RectF r7 = this.mRoundRectF;
        float r8 = this.mCornerRadius;
        r6.drawRoundRect(r7, r8, r8, r5);
        return;
    L24:
        return;
    L10:
        r1 = r4;
        goto L11
    L12:
        Paint r9 = this.mFillPaint;
        if (r9 != null) goto L15;
        o.c("mFillPaint");
    L16:
        r1.getAlpha();
        goto L17
    L15:
        r1 = r9;
        goto L16
    }

    public final int getPadding() {
        return ARROW_PADDING / 2;
    }

    public final int getArrowHeight() {
        return ARROW_PADDING;
    }
}
