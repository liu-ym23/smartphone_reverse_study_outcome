package com.obric.oui.popover;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Objects;

/* JADX INFO: compiled from: OMiddleArrowPopoverLayout.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OMiddleArrowPopoverLayout extends LinearLayout {
    public static final int BOTTOM = 3;
    public static final a Companion = null;
    public static final int LEFT = 1;
    public static final int RIGHT = 2;
    public static final int TOP = 0;
    private static int arrowPaddingDp;
    private static float cornerRadiusDp;
    private static int defaultHeightDp;
    private static int defaultPaddingDp;
    private static int defaultWidthDp;
    private static float minArrowDistanceDp;
    private int arrowPadding;
    private int borderColor;
    private int borderWidth;
    private float cornerRadius;
    private int defaultHeight;
    private int defaultWidth;
    private int mAdjustHeight;
    private Paint mArrowPressedPaint;
    private int mBgColor;
    private Bitmap mBitmap;
    private float mBubbleArrowOffset;
    private Path mBubbleArrowPath;
    private int mBubbleOrientation;
    private Canvas mCanvas;
    private Paint mFillPaint;
    private float mHeight;
    private boolean mNeedArrow;
    private boolean mNeedShadow;
    private Path mPath;
    private Drawable mPopoverGg;
    private RectF mRoundRect;
    private float mWidth;
    private float minArrowDistance;
    private float padding;
    private int pressStateColor;
    private b shadowConfig;
    private Paint strokePaint;
    private final Path tempArrowPath;
    private final Path tempRectPath;
    private boolean useDefaultView;

    /* JADX INFO: compiled from: OMiddleArrowPopoverLayout.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final void a(int r1) {
            OMiddleArrowPopoverLayout.access$setDefaultWidthDp$cp(r1);
        }

        public final void b(int r1) {
            OMiddleArrowPopoverLayout.access$setDefaultHeightDp$cp(r1);
        }

        public final float a() {
            return OMiddleArrowPopoverLayout.access$getCornerRadiusDp$cp();
        }
    }

    /* JADX INFO: compiled from: OMiddleArrowPopoverLayout.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f35978a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f35979b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f35980c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f35981d;

        public b() {
            this(0.0f, 0.0f, 0.0f, 0, 15, null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(Float.valueOf(this.f35978a), Float.valueOf(r6.f35978a)) == true) goto L12;
            return false;
        L12:
            if (o.a(Float.valueOf(this.f35979b), Float.valueOf(r6.f35979b)) == true) goto L15;
            return false;
        L15:
            if (o.a(Float.valueOf(this.f35980c), Float.valueOf(r6.f35980c)) == true) goto L18;
            return false;
        L18:
            if (this.f35981d == r6.f35981d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((Float.hashCode(this.f35978a) * 31) + Float.hashCode(this.f35979b)) * 31) + Float.hashCode(this.f35980c)) * 31) + Integer.hashCode(this.f35981d);
        }

        public String toString() {
            return "ShadowConfig(radius=" + this.f35978a + ", dx=" + this.f35979b + ", dy=" + this.f35980c + ", color=" + this.f35981d + ')';
        }

        public b(float r1, float r2, float r3, int r4) {
            this.f35978a = r1;
            this.f35979b = r2;
            this.f35980c = r3;
            this.f35981d = r4;
        }

        public /* synthetic */ b(float r2, float r3, float r4, int r5, int r6, h r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = 2.0f;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = 2.0f;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = 5.0f;
        L12:
            if ((r6 & 8) == 0) goto L14;
            r5 = -16777216;
        L14:
            this(r2, r3, r4, r5);
        }

        public final void a(float r1) {
            this.f35978a = r1;
        }

        public final void b(float r1) {
            this.f35979b = r1;
        }

        public final void c(float r1) {
            this.f35980c = r1;
        }

        public final void a(int r1) {
            this.f35981d = r1;
        }
    }

    public static final /* synthetic */ int access$getArrowPaddingDp$cp() {
        return arrowPaddingDp;
    }

    public static final /* synthetic */ float access$getCornerRadiusDp$cp() {
        return cornerRadiusDp;
    }

    public static final /* synthetic */ int access$getDefaultHeightDp$cp() {
        return defaultHeightDp;
    }

    public static final /* synthetic */ int access$getDefaultPaddingDp$cp() {
        return defaultPaddingDp;
    }

    public static final /* synthetic */ int access$getDefaultWidthDp$cp() {
        return defaultWidthDp;
    }

    public static final /* synthetic */ float access$getMinArrowDistanceDp$cp() {
        return minArrowDistanceDp;
    }

    public static final /* synthetic */ void access$setArrowPaddingDp$cp(int r0) {
        arrowPaddingDp = r0;
    }

    public static final /* synthetic */ void access$setCornerRadiusDp$cp(float r0) {
        cornerRadiusDp = r0;
    }

    public static final /* synthetic */ void access$setDefaultHeightDp$cp(int r0) {
        defaultHeightDp = r0;
    }

    public static final /* synthetic */ void access$setDefaultPaddingDp$cp(int r0) {
        defaultPaddingDp = r0;
    }

    public static final /* synthetic */ void access$setDefaultWidthDp$cp(int r0) {
        defaultWidthDp = r0;
    }

    public static final /* synthetic */ void access$setMinArrowDistanceDp$cp(float r0) {
        minArrowDistanceDp = r0;
    }

    static {
        Companion = new a(null);
        arrowPaddingDp = 9;
        minArrowDistanceDp = 18.0f;
        defaultWidthDp = 42;
        defaultHeightDp = 42;
        cornerRadiusDp = Integer.min(42, 42) / 2.0f;
        defaultPaddingDp = 12;
    }

    public final float getPadding() {
        return this.padding;
    }

    public final void setPadding(float r1) {
        this.padding = r1;
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

    public final boolean getMNeedShadow() {
        return this.mNeedShadow;
    }

    public final void setMNeedShadow(boolean r1) {
        this.mNeedShadow = r1;
    }

    public final boolean getMNeedArrow() {
        return this.mNeedArrow;
    }

    public final void setMNeedArrow(boolean r1) {
        this.mNeedArrow = r1;
    }

    public final boolean getUseDefaultView() {
        return this.useDefaultView;
    }

    public final void setUseDefaultView(boolean r1) {
        this.useDefaultView = r1;
    }

    public final int getMAdjustHeight() {
        return this.mAdjustHeight;
    }

    public final void setMAdjustHeight(int r1) {
        this.mAdjustHeight = r1;
    }

    public OMiddleArrowPopoverLayout(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this(r4, null);
    }

    public OMiddleArrowPopoverLayout(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        this(r5, r6, 0);
    }

    public OMiddleArrowPopoverLayout(Context r9, AttributeSet r10, int r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r13 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r12, "context");
        super(r12, r13, r11);
        this.shadowConfig = new b(0.0f, 0.0f, 0.0f, 0, 15, null);
        this.mBubbleArrowOffset = 0.75f;
        this.mBubbleOrientation = 1;
        this.mNeedArrow = true;
        this.useDefaultView = true;
        this.tempRectPath = new Path();
        this.tempArrowPath = new Path();
        init(r12, r13);
    }

    public final void init(Context r6, AttributeSet r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r8, "context");
        this.arrowPadding = g.a(r8, arrowPaddingDp);
        this.minArrowDistance = g.c(r8, minArrowDistanceDp);
        this.defaultWidth = g.a(r8, defaultWidthDp);
        this.defaultHeight = g.a(r8, defaultHeightDp);
        this.cornerRadius = g.c(r8, cornerRadiusDp);
        this.padding = g.b(r8, defaultPaddingDp);
        this.mFillPaint = new Paint();
        this.mPath = new Path();
        this.mBubbleArrowPath = new Path();
        Paint r10 = this.mFillPaint;
        if (r10 != null) goto L5;
        o.c("mFillPaint");
        r10 = null;
    L5:
        r10.setStyle(Paint.Style.FILL);
        Paint r11 = this.mFillPaint;
        if (r11 != null) goto L8;
        o.c("mFillPaint");
        r11 = null;
    L8:
        r11.setStrokeCap(Paint.Cap.BUTT);
        Paint r12 = this.mFillPaint;
        if (r12 != null) goto L11;
        o.c("mFillPaint");
        r12 = null;
    L11:
        r12.setAntiAlias(true);
        Paint r13 = this.mFillPaint;
        if (r13 != null) goto L14;
        o.c("mFillPaint");
        r13 = null;
    L14:
        r13.setStrokeJoin(Paint.Join.MITER);
        if (getMBgColor() != 0) goto L17;
        this.mBgColor = androidx.core.content.a.c(r8, ZeusTransformUtils.mapRes(R.color.SDPrimary, "color", "SDPrimary"));
    L17:
        Paint r14 = this.mFillPaint;
        if (r14 != null) goto L20;
        o.c("mFillPaint");
        r14 = null;
    L20:
        r14.setColor(getMBgColor());
        setLayerType(1, null);
        setBackgroundColor(0);
        setClipChildren(false);
        this.mPopoverGg = r8.getDrawable(ZeusTransformUtils.mapRes(R.drawable.o_bg_middle_arrow_popover, "drawable", "o_bg_middle_arrow_popover"));
    }

    public final void setCornerRadius(float r1) {
        this.cornerRadius = r1;
    }

    public final void setBorderColor(int r1) {
        this.borderColor = r1;
    }

    public final void setBorderWidth(int r4) {
        if (r4 > 0) goto L4;
        return;
    L4:
        this.borderWidth = r4;
        if (this.strokePaint != null) goto L7;
        this.strokePaint = new Paint();
    L7:
        Paint r5 = this.strokePaint;
        if (r5 == null) goto L11;
        r5.setStyle(Paint.Style.STROKE);
    L11:
        Paint r6 = this.strokePaint;
        if (r6 == null) goto L15;
        r6.setStrokeWidth(this.borderWidth);
    L15:
        Paint r7 = this.strokePaint;
        if (r7 == null) goto L19;
        r7.setStrokeCap(Paint.Cap.BUTT);
    L19:
        Paint r8 = this.strokePaint;
        if (r8 == null) goto L23;
        r8.setStrokeJoin(Paint.Join.MITER);
    L23:
        Paint r9 = this.strokePaint;
        if (r9 == null) goto L27;
        r9.setAntiAlias(true);
    L27:
        Paint r10 = this.strokePaint;
        if (r10 == null) goto L31;
        r10.setXfermode((Xfermode) ZeusTransformUtils.preCheckCast(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER), Xfermode.class, "com.obric.aiagent.plugin"));
    L31:
        Paint r11 = this.strokePaint;
        if (r11 == null) goto L35;
        r11.setColor(this.borderColor);
    L35:
        Paint r12 = this.mFillPaint;
        Paint r0 = null;
        if (r12 != null) goto L38;
        o.c("mFillPaint");
        r12 = null;
    L38:
        r12.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint r13 = this.mFillPaint;
        if (r13 != null) goto L41;
        o.c("mFillPaint");
    L42:
        r0.setStrokeWidth(this.borderWidth);
        return;
    L41:
        r0 = r13;
        goto L42
    }

    public final void setTransparentBg(boolean r3) {
        if (r3 == false) goto L5;
        this.mBgColor = 0;
        setLayerType(1, null);
        return;
    L5:
        setLayerType(1, null);
    }

    private final void initSimpleBubbleLegPrototype() {
        float r0 = this.arrowPadding;
        float r1 = this.mHeight;
        float r2 = (r0 + (r1 / 2.0f)) - ((r1 / 2.0f) / 1.63f);
        float r3 = (r1 / 2.0f) / 1.56f;
        Path r4 = this.mBubbleArrowPath;
        Path r5 = null;
        if (r4 != null) goto L5;
        o.c("mBubbleArrowPath");
        r4 = null;
    L5:
        r4.reset();
        Path r6 = this.mBubbleArrowPath;
        if (r6 != null) goto L8;
        o.c("mBubbleArrowPath");
        r6 = null;
    L8:
        r6.moveTo(0.0f, 0.0f);
        Path r7 = this.mBubbleArrowPath;
        if (r7 != null) goto L11;
        o.c("mBubbleArrowPath");
        r7 = null;
    L11:
        r7.lineTo(r2, -r3);
        Path r8 = this.mBubbleArrowPath;
        if (r8 != null) goto L14;
        o.c("mBubbleArrowPath");
        r8 = null;
    L14:
        r8.lineTo(r2, r3);
        Path r9 = this.mBubbleArrowPath;
        if (r9 != null) goto L17;
        o.c("mBubbleArrowPath");
        r9 = null;
    L17:
        r9.lineTo(0.0f, 0.0f);
        Path r10 = this.mBubbleArrowPath;
        if (r10 != null) goto L20;
        o.c("mBubbleArrowPath");
    L21:
        r5.close();
        return;
    L20:
        r5 = r10;
        goto L21
    }

    public final void setBubbleParams(int r1, float r2) {
        this.mBubbleArrowOffset = r2;
        this.mBubbleOrientation = r1;
    }

    public final void setBubbleOrientation(int r1) {
        this.mBubbleOrientation = r1;
    }

    public final Matrix calculateBubbleArrowMatrix(float r9, float r10) {
        float r0 = Math.max(this.mBubbleArrowOffset, this.minArrowDistance + this.arrowPadding);
        Matrix r1 = new Matrix();
        int r2 = this.borderWidth;
        int r3 = r2 / 2;
        int r4 = this.mBubbleOrientation;
        float r5 = 0.0f;
        if (r4 != 0) goto L5;
        r5 = Math.min(r0, (r9 - this.arrowPadding) - this.minArrowDistance);
        float r11 = this.borderWidth;
        r1.postRotate(90.0f);
        setPadding(0, r3, 0, 0);
    L15:
        setGravity(17);
        int r6 = this.arrowPadding;
        int r7 = this.borderWidth;
        this.mRoundRect = new RectF(r6 + (r7 / 2), r6 + (r7 / 2), (this.mWidth - r6) - r7, (this.mHeight - r6) - r7);
        r1.postTranslate(r5, r11);
        Path r12 = this.mPath;
        Path r8 = null;
        if (r12 != null) goto L18;
        o.c("mPath");
        r12 = null;
    L18:
        r12.reset();
        this.tempRectPath.reset();
        Path r13 = this.tempRectPath;
        RectF r14 = this.mRoundRect;
        if (r14 != null) goto L21;
        o.c("mRoundRect");
        r14 = null;
    L21:
        float r15 = this.cornerRadius;
        r13.addRoundRect(r14, r15, r15, Path.Direction.CW);
        if (this.mNeedArrow == false) goto L27;
        this.tempArrowPath.reset();
        Path r16 = this.tempArrowPath;
        Path r17 = this.mBubbleArrowPath;
        if (r17 != null) goto L26;
        o.c("mBubbleArrowPath");
        r17 = null;
    L26:
        r16.addPath(r17, r1);
        this.tempRectPath.op(this.tempArrowPath, Path.Op.UNION);
    L27:
        Path r18 = this.mPath;
        if (r18 != null) goto L30;
        o.c("mPath");
    L31:
        r8.addPath(this.tempRectPath);
        return r1;
    L30:
        r8 = r18;
        goto L31
    L5:
        if (r4 != 1) goto L7;
        r5 = r2;
        r11 = Math.min(r0, (r10 - this.arrowPadding) - this.minArrowDistance);
        setPadding(r3, 0, 0, 0);
        goto L15
    L7:
        if (r4 != 2) goto L9;
        r5 = r9 - r2;
        r11 = Math.min(r0, (r10 - this.arrowPadding) - this.minArrowDistance);
        r1.postRotate(180.0f);
        setPadding(0, 0, r3, 0);
        goto L15
    L9:
        if (r4 == 3) goto L11;
        r11 = 0.0f;
        goto L15
    L11:
        r5 = Math.min(r0, (r9 - this.arrowPadding) - this.minArrowDistance);
        r11 = r10 - this.borderWidth;
        r1.postRotate(270.0f);
        setPadding(0, 0, 0, r3);
        goto L15
    }

    public final float getBubbleOffset() {
        float r0 = Math.max(this.mBubbleArrowOffset, this.minArrowDistance);
        int r1 = this.mBubbleOrientation;
        if (r1 == 0) goto L15;
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L18;
        if (r1 == 3) goto L17;
        return 0.0f;
    L17:
        return Math.min(r0, (this.mWidth - this.arrowPadding) - this.minArrowDistance);
    L18:
        return Math.min(r0, (this.mHeight - this.arrowPadding) - this.minArrowDistance);
    L19:
        return Math.min(r0, (this.mHeight - this.arrowPadding) - this.minArrowDistance);
    L15:
        return Math.min(r0, (this.mWidth - this.arrowPadding) - this.minArrowDistance);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r8, int r9) {
        super.onMeasure(r8, r9);
        if (ZeusTransformUtils.instanceOf(getChildAt(0), TextView.class) == false) goto L5;
        View r1 = getChildAt(0);
        Objects.requireNonNull(r1, "null cannot be cast to non-null type android.widget.TextView");
        TextView r2 = (TextView) ZeusTransformUtils.preCheckCast(r1, TextView.class, "com.obric.aiagent.plugin");
    L6:
        int r3 = View.MeasureSpec.getMode(r8);
        int r10 = View.MeasureSpec.getSize(r8);
        int r4 = View.MeasureSpec.getMode(r9);
        int r11 = View.MeasureSpec.getSize(r9);
        if (r2 == null) goto L13;
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r5, "context");
        int r6 = g.a(r5, 276);
        if (((int) r2.getPaint().measureText(r2.getText().toString())) > r6) goto L12;
        r6 = (int) r2.getPaint().measureText(r2.getText().toString());
    L12:
        int r7 = (r6 + r2.getPaddingLeft()) + r2.getPaddingRight();
    L15:
        if (this.useDefaultView == false) goto L20;
        int r0 = this.defaultWidth;
        if (r7 <= r0) goto L19;
        r0 = (((int) this.padding) * 2) + r7;
    L19:
        int r12 = this.arrowPadding;
        int r13 = this.borderWidth;
        int r14 = (r0 + (r12 * 2)) + (r13 * 2);
        int r15 = (this.defaultHeight + (r12 * 2)) + (r13 * 2);
    L22:
        if (r3 != Integer.MIN_VALUE) goto L25;
        if (r4 != Integer.MIN_VALUE) goto L25;
        setMeasuredDimension(r14, r15);
    L29:
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        initSimpleBubbleLegPrototype();
        return;
    L25:
        if (r3 != Integer.MIN_VALUE) goto L27;
        setMeasuredDimension(r14, r11);
        goto L29
    L27:
        if (r4 != Integer.MIN_VALUE) goto L29;
        setMeasuredDimension(r10, r15);
        goto L29
    L20:
        PopupWindow r16 = new PopupWindow(getChildAt(0), -2, -2, true);
        r16.getContentView().measure(0, 0);
        r14 = r16.getContentView().getMeasuredWidth() + (arrowPaddingDp * 2);
        r15 = r16.getContentView().getMeasuredHeight() + (arrowPaddingDp * 2);
        goto L22
    L13:
        r7 = getMeasuredWidth();
        goto L15
    L5:
        r2 = null;
        goto L6
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas r10) {
        o.e(r10, "canvas");
        if (this.mBitmap != null) goto L5;
        this.mBitmap = Bitmap.createBitmap(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDisplayMetrics(), getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Bitmap r1 = this.mBitmap;
        o.a(r1);
        this.mCanvas = new Canvas(r1);
    L5:
        Paint r0 = this.mFillPaint;
        if (r0 != null) goto L8;
        o.c("mFillPaint");
        r0 = null;
    L8:
        r0.setColor(getMBgColor());
        Drawable r2 = this.mPopoverGg;
        if (r2 == null) goto L34;
        int r3 = this.mBubbleOrientation;
        if (r3 != 0) goto L14;
        float r4 = 270.0f;
    L21:
        int r5 = this.arrowPadding + ((int) getPadding());
        int r6 = this.arrowPadding;
        int r7 = (getHeight() - ((int) ((((getWidth() - r5) - r6) * r2.getIntrinsicHeight()) / r2.getIntrinsicWidth()))) / 2;
        r2.setBounds(r5, r7, getWidth() - r6, getHeight() - r7);
        Canvas r8 = this.mCanvas;
        if (r8 != null) goto L24;
        o.c("mCanvas");
        r8 = null;
    L24:
        r8.save();
        Canvas r9 = this.mCanvas;
        if (r9 != null) goto L27;
        o.c("mCanvas");
        r9 = null;
    L27:
        r9.rotate(r4, getWidth() / 2.0f, getHeight() / 2.0f);
        Canvas r11 = this.mCanvas;
        if (r11 != null) goto L30;
        o.c("mCanvas");
        r11 = null;
    L30:
        r2.draw(r11);
        Canvas r12 = this.mCanvas;
        if (r12 != null) goto L33;
        o.c("mCanvas");
        r12 = null;
    L33:
        r12.restore();
        goto L34
    L14:
        if (r3 != 1) goto L16;
        r4 = 180.0f;
        goto L21
    L16:
        if (r3 == 3) goto L18;
        r4 = 0.0f;
        goto L21
    L18:
        r4 = 90.0f;
    L34:
        Bitmap r13 = this.mBitmap;
        o.a(r13);
        r10.drawBitmap(r13, 0.0f, 0.0f, null);
    }

    public final void notifyPressed(boolean r2, int r3) {
        if (r2 == true) goto L4;
        Paint r1 = this.mArrowPressedPaint;
        if (r1 == null) goto L32;
        r1.setColor(0);
        return;
    L32:
        return;
    L4:
        if (this.mArrowPressedPaint != null) goto L21;
        Paint r4 = new Paint();
        this.mArrowPressedPaint = r4;
        if (r4 == null) goto L9;
        r4.setStyle(Paint.Style.FILL);
    L9:
        Paint r5 = this.mArrowPressedPaint;
        if (r5 == null) goto L13;
        r5.setStrokeCap(Paint.Cap.BUTT);
    L13:
        Paint r6 = this.mArrowPressedPaint;
        if (r6 == null) goto L17;
        r6.setStrokeJoin(Paint.Join.MITER);
    L17:
        Paint r7 = this.mArrowPressedPaint;
        if (r7 == null) goto L21;
        r7.setAntiAlias(true);
    L21:
        Paint r8 = this.mArrowPressedPaint;
        if (r8 == null) goto L31;
        r8.setColor(r3);
        return;
    }

    public final int arrowDirection() {
        return this.mBubbleOrientation;
    }

    /* JADX INFO: renamed from: getPadding, reason: collision with other method in class */
    public final int m1122getPadding() {
        return this.arrowPadding / 2;
    }

    public final int getArrowHeight() {
        return this.arrowPadding;
    }

    public final Path getFullPath() {
        Path r0 = this.mPath;
        if (r0 != null) goto L6;
        o.c("mPath");
        return null;
    L6:
        return r0;
    }

    public final b getShadowConfig() {
        return this.shadowConfig;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r4) {
        super.onConfigurationChanged(r4);
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r5, "context");
        this.arrowPadding = g.a(r5, arrowPaddingDp);
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r6, "context");
        this.minArrowDistance = g.c(r6, minArrowDistanceDp);
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r7, "context");
        this.defaultWidth = g.a(r7, defaultWidthDp);
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r8, "context");
        this.defaultHeight = g.a(r8, defaultHeightDp);
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r9, "context");
        this.cornerRadius = g.c(r9, cornerRadiusDp);
        Context r10 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r10, "context");
        this.padding = g.b(r10, defaultPaddingDp);
    }
}
