package com.obric.oui.popover;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.style.l;
import com.obric.oui.common.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: OPopoverLayout.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OPopoverLayout extends LinearLayout {
    private static int ADDITIONAL_HEIGHT_DP = 0;
    private static int ARROW_PADDING_DP = 0;
    public static final int BOTTOM = 3;
    private static int CORNER_RADIUS_DOUBLE_DP = 0;
    private static int CORNER_RADIUS_DP = 0;
    private static int CORNER_RADIUS_SINGLE_DP = 0;
    public static final a Companion = null;
    private static int DEFAULT_HEIGHT_DP = 0;
    private static int DEFAULT_PADDING_DP = 0;
    private static int DEFAULT_WIDTH_DP = 0;
    public static final int LEFT = 1;
    private static int MAX_WIDTH_DP = 0;
    private static int MIN_ARROW_DISTANCE_DP = 0;
    public static final int RIGHT = 2;
    private static final String TAG = "OPopoverLayout";
    public static final int TOP = 0;
    private int additionalHeight;
    private int arrowPadding;
    private int borderColor;
    private int borderWidth;
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
    private float mCornerRadius;
    private Paint mFillPaint;
    private float mHeight;
    private boolean mNeedArrow;
    private boolean mNeedShadow;
    private int mPadding;
    private Path mPath;
    private RectF mRoundRect;
    private String mSubTitle;
    private float mWidth;
    private int maxWidth;
    private float minArrowDistance;
    private int pressStateColor;
    private b shadowConfig;
    private Paint strokePaint;
    private final Path tempArrowPath;
    private final Path tempRectPath;
    private boolean useDefaultView;

    /* JADX INFO: compiled from: OPopoverLayout.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final int a() {
            return OPopoverLayout.access$getCORNER_RADIUS_DP$cp();
        }

        public final int b() {
            return OPopoverLayout.access$getCORNER_RADIUS_SINGLE_DP$cp();
        }

        public final int c() {
            return OPopoverLayout.access$getCORNER_RADIUS_DOUBLE_DP$cp();
        }
    }

    /* JADX INFO: compiled from: OPopoverLayout.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f35990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f35991b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f35992c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f35993d;

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
            if (o.a(Float.valueOf(this.f35990a), Float.valueOf(r6.f35990a)) == true) goto L12;
            return false;
        L12:
            if (o.a(Float.valueOf(this.f35991b), Float.valueOf(r6.f35991b)) == true) goto L15;
            return false;
        L15:
            if (o.a(Float.valueOf(this.f35992c), Float.valueOf(r6.f35992c)) == true) goto L18;
            return false;
        L18:
            if (this.f35993d == r6.f35993d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((Float.hashCode(this.f35990a) * 31) + Float.hashCode(this.f35991b)) * 31) + Float.hashCode(this.f35992c)) * 31) + Integer.hashCode(this.f35993d);
        }

        public String toString() {
            return "ShadowConfig(radius=" + this.f35990a + ", dx=" + this.f35991b + ", dy=" + this.f35992c + ", color=" + this.f35993d + ')';
        }

        public b(float r1, float r2, float r3, int r4) {
            this.f35990a = r1;
            this.f35991b = r2;
            this.f35992c = r3;
            this.f35993d = r4;
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

        public final float a() {
            return this.f35990a;
        }

        public final void a(float r1) {
            this.f35990a = r1;
        }

        public final float b() {
            return this.f35991b;
        }

        public final void b(float r1) {
            this.f35991b = r1;
        }

        public final float c() {
            return this.f35992c;
        }

        public final void c(float r1) {
            this.f35992c = r1;
        }

        public final void a(int r1) {
            this.f35993d = r1;
        }

        public final int d() {
            return this.f35993d;
        }
    }

    public static final /* synthetic */ int access$getADDITIONAL_HEIGHT_DP$cp() {
        return ADDITIONAL_HEIGHT_DP;
    }

    public static final /* synthetic */ int access$getARROW_PADDING_DP$cp() {
        return ARROW_PADDING_DP;
    }

    public static final /* synthetic */ int access$getCORNER_RADIUS_DOUBLE_DP$cp() {
        return CORNER_RADIUS_DOUBLE_DP;
    }

    public static final /* synthetic */ int access$getCORNER_RADIUS_DP$cp() {
        return CORNER_RADIUS_DP;
    }

    public static final /* synthetic */ int access$getCORNER_RADIUS_SINGLE_DP$cp() {
        return CORNER_RADIUS_SINGLE_DP;
    }

    public static final /* synthetic */ int access$getDEFAULT_HEIGHT_DP$cp() {
        return DEFAULT_HEIGHT_DP;
    }

    public static final /* synthetic */ int access$getDEFAULT_PADDING_DP$cp() {
        return DEFAULT_PADDING_DP;
    }

    public static final /* synthetic */ int access$getDEFAULT_WIDTH_DP$cp() {
        return DEFAULT_WIDTH_DP;
    }

    public static final /* synthetic */ int access$getMAX_WIDTH_DP$cp() {
        return MAX_WIDTH_DP;
    }

    public static final /* synthetic */ int access$getMIN_ARROW_DISTANCE_DP$cp() {
        return MIN_ARROW_DISTANCE_DP;
    }

    public static final /* synthetic */ void access$setADDITIONAL_HEIGHT_DP$cp(int r0) {
        ADDITIONAL_HEIGHT_DP = r0;
    }

    public static final /* synthetic */ void access$setARROW_PADDING_DP$cp(int r0) {
        ARROW_PADDING_DP = r0;
    }

    public static final /* synthetic */ void access$setCORNER_RADIUS_DOUBLE_DP$cp(int r0) {
        CORNER_RADIUS_DOUBLE_DP = r0;
    }

    public static final /* synthetic */ void access$setCORNER_RADIUS_DP$cp(int r0) {
        CORNER_RADIUS_DP = r0;
    }

    public static final /* synthetic */ void access$setCORNER_RADIUS_SINGLE_DP$cp(int r0) {
        CORNER_RADIUS_SINGLE_DP = r0;
    }

    public static final /* synthetic */ void access$setDEFAULT_HEIGHT_DP$cp(int r0) {
        DEFAULT_HEIGHT_DP = r0;
    }

    public static final /* synthetic */ void access$setDEFAULT_PADDING_DP$cp(int r0) {
        DEFAULT_PADDING_DP = r0;
    }

    public static final /* synthetic */ void access$setDEFAULT_WIDTH_DP$cp(int r0) {
        DEFAULT_WIDTH_DP = r0;
    }

    public static final /* synthetic */ void access$setMAX_WIDTH_DP$cp(int r0) {
        MAX_WIDTH_DP = r0;
    }

    public static final /* synthetic */ void access$setMIN_ARROW_DISTANCE_DP$cp(int r0) {
        MIN_ARROW_DISTANCE_DP = r0;
    }

    static {
        Companion = new a(null);
        ARROW_PADDING_DP = 7;
        CORNER_RADIUS_DP = 28;
        CORNER_RADIUS_SINGLE_DP = 99;
        CORNER_RADIUS_DOUBLE_DP = 12;
        MIN_ARROW_DISTANCE_DP = 18;
        DEFAULT_WIDTH_DP = 40;
        DEFAULT_HEIGHT_DP = 36;
        ADDITIONAL_HEIGHT_DP = 20;
        DEFAULT_PADDING_DP = 12;
        MAX_WIDTH_DP = 276;
    }

    public final String getMSubTitle() {
        return this.mSubTitle;
    }

    public final void setMSubTitle(String r2) {
        o.e(r2, "<set-?>");
        this.mSubTitle = r2;
    }

    public final int getMPadding() {
        return this.mPadding;
    }

    public final void setMPadding(int r1) {
        this.mPadding = r1;
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

    public OPopoverLayout(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this(r4, null);
    }

    public OPopoverLayout(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        this(r5, r6, 0);
    }

    public OPopoverLayout(Context r8, AttributeSet r9, int r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r12 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r11, "context");
        super(r11, r12, r10);
        this.mSubTitle = "";
        this.shadowConfig = new b(0.0f, 0.0f, 0.0f, 0, 15, null);
        this.mBubbleArrowOffset = 0.75f;
        this.mBubbleOrientation = 1;
        this.mNeedArrow = true;
        this.useDefaultView = true;
        this.tempRectPath = new Path();
        this.tempArrowPath = new Path();
        init(r11, r12);
    }

    public final void init(Context r5, AttributeSet r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        this.arrowPadding = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), ARROW_PADDING_DP);
        this.minArrowDistance = g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), MIN_ARROW_DISTANCE_DP);
        this.defaultWidth = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), DEFAULT_WIDTH_DP);
        this.defaultHeight = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), DEFAULT_HEIGHT_DP);
        this.additionalHeight = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), ADDITIONAL_HEIGHT_DP);
        this.mPadding = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), DEFAULT_PADDING_DP);
        this.maxWidth = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), MAX_WIDTH_DP);
        this.mFillPaint = new Paint();
        this.mPath = new Path();
        this.mBubbleArrowPath = new Path();
        Paint r9 = this.mFillPaint;
        Paint r0 = null;
        if (r9 != null) goto L5;
        o.c("mFillPaint");
        r9 = null;
    L5:
        r9.setStyle(Paint.Style.FILL);
        Paint r10 = this.mFillPaint;
        if (r10 != null) goto L8;
        o.c("mFillPaint");
        r10 = null;
    L8:
        r10.setStrokeCap(Paint.Cap.BUTT);
        Paint r11 = this.mFillPaint;
        if (r11 != null) goto L11;
        o.c("mFillPaint");
        r11 = null;
    L11:
        r11.setAntiAlias(true);
        Paint r12 = this.mFillPaint;
        if (r12 != null) goto L14;
        o.c("mFillPaint");
        r12 = null;
    L14:
        r12.setStrokeJoin(Paint.Join.MITER);
        if (getMBgColor() != 0) goto L17;
        this.mBgColor = androidx.core.content.a.c(r7, ZeusTransformUtils.mapRes(R.color.SDPrimary, "color", "SDPrimary"));
    L17:
        Paint r13 = this.mFillPaint;
        if (r13 != null) goto L20;
        o.c("mFillPaint");
    L21:
        r0.setColor(getMBgColor());
        renderBubbleLegPrototype();
        setBackgroundColor(0);
        setClipChildren(false);
        return;
    L20:
        r0 = r13;
        goto L21
    }

    public final void setCornerRadiusDp(int r3) {
        this.mCornerRadius = g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r3);
    }

    public final void setCornerRadius(float r1) {
        this.mCornerRadius = r1;
    }

    public final float getCornerRadius() {
        return this.mCornerRadius;
    }

    public final void setSubText(String r2) {
        o.e(r2, "str");
        this.mSubTitle = r2;
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

    public final void setTransparentBg(boolean r1) {
        if (r1 == false) goto L5;
        this.mBgColor = 0;
        return;
    }

    private final void renderBubbleLegPrototype() {
        Path r0 = this.mBubbleArrowPath;
        Path r1 = null;
        if (r0 != null) goto L5;
        o.c("mBubbleArrowPath");
        r0 = null;
    L5:
        r0.moveTo(0.0f, 0.0f);
        float r2 = this.arrowPadding / 7.0f;
        Path r5 = this.mBubbleArrowPath;
        if (r5 != null) goto L8;
        o.c("mBubbleArrowPath");
        Path r6 = null;
    L9:
        float r13 = r2 * 0.0f;
        float r3 = r2 * 7.0f;
        r6.cubicTo(r13, r2 * (-2.5f), r3, r2 * (-4.0f), r3, r2 * (-10.0f));
        Path r4 = this.mBubbleArrowPath;
        if (r4 != null) goto L12;
        o.c("mBubbleArrowPath");
        r4 = null;
    L12:
        r4.lineTo(r3, 10.0f * r2);
        Path r7 = this.mBubbleArrowPath;
        if (r7 != null) goto L15;
        o.c("mBubbleArrowPath");
        Path r8 = null;
    L16:
        r8.cubicTo(r3, r2 * 4.0f, r13, r2 * 2.5f, r13, r13);
        Path r14 = this.mBubbleArrowPath;
        if (r14 != null) goto L19;
        o.c("mBubbleArrowPath");
    L20:
        r1.close();
        return;
    L19:
        r1 = r14;
        goto L20
    L15:
        r8 = r7;
        goto L16
    L8:
        r6 = r5;
        goto L9
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
        l r13 = l.f34562a;
        Path r14 = this.tempRectPath;
        RectF r15 = this.mRoundRect;
        if (r15 != null) goto L21;
        o.c("mRoundRect");
        r15 = null;
    L21:
        r13.a(r14, r15, this.mCornerRadius);
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
        int r0 = 0;
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
        int r5 = measureTextViewWidth(r2);
        int r6 = this.maxWidth;
        if (r5 > r6) goto L12;
        r6 = measureTextViewWidth(r2);
    L12:
        int r7 = (r6 + r2.getPaddingLeft()) + r2.getPaddingRight();
    L15:
        if (this.useDefaultView == false) goto L24;
        int r12 = this.defaultWidth;
        if (r7 <= r12) goto L19;
        r12 = (this.mPadding * 2) + r7;
    L19:
        int r13 = this.arrowPadding;
        int r14 = this.borderWidth;
        int r15 = (r12 + (r13 * 2)) + (r14 * 2);
        int r16 = (this.defaultHeight + (r13 * 2)) + (r14 * 2);
        if (o.a(this.mSubTitle, "") == true) goto L23;
        r0 = this.additionalHeight;
    L23:
        int r17 = r16 + r0;
    L26:
        if (r3 != Integer.MIN_VALUE) goto L29;
        if (r4 != Integer.MIN_VALUE) goto L29;
        setMeasuredDimension(r15, r17);
    L34:
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        return;
    L29:
        if (r3 != Integer.MIN_VALUE) goto L31;
        setMeasuredDimension(r15, r11);
        goto L34
    L31:
        if (r4 != Integer.MIN_VALUE) goto L33;
        setMeasuredDimension(r10, r17);
        goto L34
    L33:
        setMeasuredDimension(r10, r11);
        goto L34
    L24:
        PopupWindow r18 = new PopupWindow(getChildAt(0), -2, -2, true);
        r18.getContentView().measure(0, 0);
        r15 = (this.arrowPadding * 2) + r18.getContentView().getMeasuredWidth();
        r17 = r18.getContentView().getMeasuredHeight() + (this.arrowPadding * 2);
        goto L26
    L13:
        r7 = getMeasuredWidth();
        goto L15
    L5:
        r2 = null;
        goto L6
    }

    private final int measureTextViewWidth(TextView r14) {
        String r13 = r14.getText().toString();
        TextPaint r15 = r14.getPaint();
        Objects.requireNonNull(r15, "null cannot be cast to non-null type android.text.TextPaint");
        int r6 = 0;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L5;
        Iterator r16 = d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin"), new String[]{"\n"}, false, 0, 6, null).iterator();
    L8:
        if (r16.hasNext() == false) goto L12;
        int r0 = (int) r15.measureText((String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.aiagent.plugin"));
        if (r0 <= r6) goto L8;
        r6 = r0;
        goto L8
    L12:
        return r6;
    L5:
        return (int) r15.measureText(r13);
    }

    @Override // android.view.View
    public void onSizeChanged(int r5, int r6, int r7, int r8) {
        super.onSizeChanged(r5, r6, r7, r8);
        if (r5 <= 0) goto L17;
        if (r6 <= 0) goto L18;
        Bitmap r0 = this.mBitmap;
        if (r0 != null) goto L8;
        return;
    L8:
        if (getMeasuredWidth() != 0) goto L10;
        return;
    L10:
        if (getMeasuredHeight() != 0) goto L12;
        return;
    L12:
        if (r0.getHeight() == getMeasuredHeight()) goto L14;
    L15:
        Bitmap r1 = Bitmap.createBitmap(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDisplayMetrics(), getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        this.mCanvas = new Canvas(r1);
        this.mBitmap = r1;
        com.obric.oui.d.a.b.d(TAG, "onSizeChanged, init new bg, w: " + r5 + ", h: " + r6 + ", oldw: " + r7 + ", oldh: " + r8);
        return;
    L14:
        if (r0.getWidth() != getMeasuredWidth()) goto L15;
        return;
    L18:
        return;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas r8) {
        o.e(r8, "canvas");
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
        calculateBubbleArrowMatrix(this.mWidth, this.mHeight);
        if (this.mNeedShadow == false) goto L14;
        Paint r2 = this.mFillPaint;
        if (r2 != null) goto L13;
        o.c("mFillPaint");
        r2 = null;
    L13:
        r2.setShadowLayer(this.shadowConfig.a(), this.shadowConfig.b(), this.shadowConfig.c(), this.shadowConfig.d());
    L14:
        Canvas r3 = this.mCanvas;
        if (r3 != null) goto L17;
        o.c("mCanvas");
        r3 = null;
    L17:
        Path r4 = this.mPath;
        if (r4 != null) goto L20;
        o.c("mPath");
        r4 = null;
    L20:
        Paint r6 = this.mFillPaint;
        if (r6 != null) goto L23;
        o.c("mFillPaint");
        r6 = null;
    L23:
        r3.drawPath(r4, r6);
        if (this.strokePaint == null) goto L35;
        if (this.borderWidth <= 0) goto L35;
        Canvas r5 = this.mCanvas;
        if (r5 != null) goto L30;
        o.c("mCanvas");
        r5 = null;
    L30:
        Path r7 = this.mPath;
        if (r7 != null) goto L33;
        o.c("mPath");
        r7 = null;
    L33:
        Paint r9 = this.strokePaint;
        o.a(r9);
        r5.drawPath(r7, r9);
    L35:
        if (this.mArrowPressedPaint == null) goto L40;
        Canvas r10 = this.mCanvas;
        if (r10 != null) goto L39;
        o.c("mCanvas");
        r10 = null;
    L39:
        Path r11 = this.tempArrowPath;
        Paint r12 = this.mArrowPressedPaint;
        o.a(r12);
        r10.drawPath(r11, r12);
    L40:
        Bitmap r13 = this.mBitmap;
        o.a(r13);
        r8.drawBitmap(r13, 0.0f, 0.0f, null);
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

    public final int getPadding() {
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
}
