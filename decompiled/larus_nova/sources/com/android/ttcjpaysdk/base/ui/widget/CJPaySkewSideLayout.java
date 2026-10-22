package com.android.ttcjpaysdk.base.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u00011B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"H\u0016J\u0006\u0010#\u001a\u00020\fJ\u001c\u0010$\u001a\u00020\u001f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0006\u0010%\u001a\u00020\u000eJ\b\u0010&\u001a\u00020\u001fH\u0002J\u0012\u0010'\u001a\u00020\u000e2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0012\u0010*\u001a\u00020\u000e2\b\u0010+\u001a\u0004\u0018\u00010)H\u0016J\u000e\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\fJ\u000e\u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u000200R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/widget/CJPaySkewSideLayout;", "Landroid/widget/RelativeLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "cornerLength", "", "cornerLengthRatio", "defaultSkewDegree", "", "mClearSkew", "", "mCornerRadius", "mHeight", "mPaint", "Landroid/graphics/Paint;", "mPath", "Landroid/graphics/Path;", "mRectF", "Landroid/graphics/RectF;", "mRegion", "Landroid/graphics/Region;", "mShouldRefresh", "mSkewDegree", "mSkewSide", "", "mWidth", "clear", "", "draw", "canvas", "Landroid/graphics/Canvas;", "getSkewDegree", "init", "isClear", "makePath", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "event", "setSkewDegree", "degree", "setSkewSide", "side", "Lcom/android/ttcjpaysdk/base/ui/widget/CJPaySkewSideLayout$Side;", "Side", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPaySkewSideLayout extends RelativeLayout {
    private float cornerLength;
    private float cornerLengthRatio;
    private final int defaultSkewDegree;
    private boolean mClearSkew;
    private float mCornerRadius;
    private int mHeight;
    private Paint mPaint;
    private Path mPath;
    private RectF mRectF;
    private Region mRegion;
    private boolean mShouldRefresh;
    private int mSkewDegree;
    private String mSkewSide;
    private int mWidth;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/widget/CJPaySkewSideLayout$Side;", "", "(Ljava/lang/String;I)V", "Left", "Right", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum Side extends Enum<Side> {
        private static final /* synthetic */ Side[] $VALUES = null;
        public static final Side Left = null;
        public static final Side Right = null;

        private static final /* synthetic */ Side[] $values() {
            return new Side[]{Left, Right};
        }

        public static Side valueOf(String r100) {
            return (Side) a.a(Side.class, r100);
        }

        public static Side[] values() {
            return (Side[]) $VALUES.clone();
        }

        static {
            Left = new Side("Left", 0);
            Right = new Side("Right", 1);
            $VALUES = $values();
        }

        private Side(String r100, int r101) {
            super(r100, r101);
        }
    }

    private final void makePath() {
        if (this.mShouldRefresh == true) goto L10;
        if (getWidth() != this.mWidth) goto L10;
        if (getHeight() != this.mHeight) goto L10;
        return;
    L10:
        if (Intrinsics.areEqual(this.mSkewSide, "none") == false) goto L12;
        return;
    L12:
        this.mWidth = getWidth();
        int r100 = getHeight();
        this.mHeight = r100;
        this.mShouldRefresh = false;
        this.cornerLength = r100 / this.cornerLengthRatio;
        double r101 = (((double) this.mSkewDegree) * 3.141592653589793d) / ((double) 180);
        double r102 = Math.cos(r101);
        double r103 = Math.sin(r101);
        double r104 = Math.tan(r101);
        Path r105 = this.mPath;
        if (r105 == null) goto L16;
        r105.reset();
    L16:
        if (Intrinsics.areEqual(this.mSkewSide, "left") == false) goto L21;
        Path r106 = this.mPath;
        if (r106 == null) goto L25;
        float r110 = this.cornerLength;
        r106.moveTo((float) (((double) r110) * r102), (float) (((double) this.mHeight) - (((double) r110) * r103)));
        int r111 = this.mHeight;
        r106.quadTo(0.0f, r111, this.cornerLength, r111);
        r106.lineTo(this.mWidth - this.mCornerRadius, this.mHeight);
        int r112 = this.mWidth;
        float r113 = 2;
        float r114 = this.mCornerRadius;
        int r115 = this.mHeight;
        r106.arcTo(new RectF(r112 - (r113 * r114), r115 - (r114 * r113), r112, r115), 90.0f, -90.0f);
        r106.lineTo(this.mWidth, this.mCornerRadius);
        int r116 = this.mWidth;
        float r117 = this.mCornerRadius;
        r106.arcTo(new RectF(r116 - (r113 * r117), 0.0f, r116, r117 * 2.0f), 0.0f, -90.0f);
        r106.lineTo((float) (((double) this.cornerLength) + (((double) this.mHeight) / r104)), 0.0f);
        float r107 = (float) (((double) this.mHeight) / Math.tan(r101));
        double r108 = ((double) this.mHeight) / r104;
        float r109 = this.cornerLength;
        r106.quadTo(r107, 0.0f, (float) (r108 - (((double) r109) * r102)), (float) (((double) r109) * r103));
        r106.close();
    L25:
        Path r118 = this.mPath;
        if (r118 == null) goto L28;
        r118.computeBounds(this.mRectF, true);
    L28:
        Path r119 = this.mPath;
        if (r119 == null) goto L32;
        Region r120 = this.mRegion;
        RectF r121 = this.mRectF;
        r120.setPath(r119, new Region((int) r121.left, (int) r121.top, (int) r121.right, (int) r121.bottom));
        return;
    L32:
        return;
    L21:
        if (Intrinsics.areEqual(this.mSkewSide, "right") == false) goto L25;
        Path r122 = this.mPath;
        if (r122 == null) goto L25;
        r122.moveTo(this.mCornerRadius, 0.0f);
        r122.lineTo(this.mWidth - this.cornerLength, 0.0f);
        int r123 = this.mWidth;
        float r124 = r123;
        double r125 = r123;
        float r126 = this.cornerLength;
        r122.quadTo(r124, 0.0f, (float) (r125 - (((double) r126) * r102)), r126 * ((float) r103));
        double r127 = this.mWidth;
        float r128 = this.cornerLength;
        int r129 = this.mHeight;
        r122.lineTo((float) ((r127 + (((double) r128) * r102)) - (((double) r129) * r102)), (float) (((double) r129) - (((double) r128) * r103)));
        int r130 = this.mWidth;
        int r131 = this.mHeight;
        r122.quadTo((float) (((double) r130) - (((double) r131) * r102)), r131, (float) (((double) (r130 - this.cornerLength)) - (((double) r131) * r102)), r131);
        r122.lineTo(this.mCornerRadius, this.mHeight);
        int r132 = this.mHeight;
        float r133 = this.mCornerRadius;
        r122.arcTo(new RectF(0.0f, r132 - (2 * r133), r133 * 2.0f, r132), 90.0f, 90.0f);
        r122.lineTo(0.0f, this.mCornerRadius);
        float r134 = this.mCornerRadius;
        r122.arcTo(new RectF(0.0f, 0.0f, r134 * 2.0f, r134 * 2.0f), 180.0f, 90.0f);
        r122.close();
        goto L25
    }

    public final void clear() {
        this.mSkewSide = "none";
        this.mClearSkew = true;
        this.mShouldRefresh = true;
        requestLayout();
    }

    public final boolean isClear() {
        return Intrinsics.areEqual(this.mSkewSide, "none");
    }

    public final int getSkewDegree() {
        return this.mSkewDegree;
    }

    public CJPaySkewSideLayout(Context r100) {
        super(r100);
        this.defaultSkewDegree = 77;
        this.mSkewDegree = 77;
        this.mSkewSide = "none";
        this.mPaint = new Paint();
        this.mRegion = new Region();
        this.mRectF = new RectF();
        this.cornerLengthRatio = 8.0f;
        init(r100, null);
    }

    @Override // android.view.View
    public void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.mClearSkew == true) goto L7;
        makePath();
        Path r101 = this.mPath;
        if (r101 == null) goto L7;
        r100.clipPath(r101);
    L7:
        super.draw(r100);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r100) {
        if (Intrinsics.areEqual(this.mSkewSide, "left") == false) goto L5;
    L9:
        if (r100 == null) goto L16;
        if (this.mRegion.contains((int) r100.getX(), (int) r100.getY()) == true) goto L17;
        return true;
    L17:
        return super.onInterceptTouchEvent(r100);
    L16:
        return super.onInterceptTouchEvent(r100);
    L5:
        if (Intrinsics.areEqual(this.mSkewSide, "right") == true) goto L9;
        return super.onInterceptTouchEvent(r100);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        if (Intrinsics.areEqual(this.mSkewSide, "left") == true) goto L10;
        if (Intrinsics.areEqual(this.mSkewSide, "right") == true) goto L10;
        return super.onTouchEvent(r100);
    L10:
        if (r100 != null) goto L12;
        return false;
    L12:
        if (this.mRegion.contains((int) r100.getX(), (int) r100.getY()) == true) goto L14;
        return false;
    L14:
        return super.onTouchEvent(r100);
    }

    public final void setSkewDegree(int r100) {
        this.mSkewDegree = r100;
        this.mShouldRefresh = true;
        requestLayout();
    }

    public final void setSkewSide(Side r100) {
        Intrinsics.checkNotNullParameter(r100, "side");
        this.mClearSkew = false;
        this.mShouldRefresh = true;
        if (r100 != Side.Left) goto L6;
        String r101 = "left";
    L9:
        this.mSkewSide = r101;
        requestLayout();
        return;
    L6:
        if (r100 != Side.Right) goto L8;
        r101 = "right";
        goto L9
    L8:
        r101 = "none";
        goto L9
    }

    public CJPaySkewSideLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.defaultSkewDegree = 77;
        this.mSkewDegree = 77;
        this.mSkewSide = "none";
        this.mPaint = new Paint();
        this.mRegion = new Region();
        this.mRectF = new RectF();
        this.cornerLengthRatio = 8.0f;
        init(r100, r101);
    }

    private final void init(Context r100, AttributeSet r101) {
        Path r102 = new Path();
        r102.setFillType(Path.FillType.EVEN_ODD);
        this.mPath = r102;
        if (r100 == null) goto L5;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.cornerRadius, R.attr.skewDegree, R.attr.skewSide});
    L7:
        if (r103 == null) goto L12;
        this.mSkewDegree = r103.getInteger(1, this.defaultSkewDegree);
        String r104 = r103.getString(2);
        if (r104 != null) goto L11;
        r104 = "none";
    L11:
        this.mSkewSide = r104;
        this.mCornerRadius = r103.getDimension(0, 0.0f);
    L12:
        if (r103 == null) goto L14;
        r103.recycle();
    L14:
        setWillNotDraw(false);
        this.mPaint.setColor(ColorProtector.parseColor("#00ff00"));
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setAntiAlias(true);
        return;
    L5:
        r103 = null;
        goto L7
    }
}
