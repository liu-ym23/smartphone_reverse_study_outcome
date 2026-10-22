package com.android.ttcjpaysdk.base.ui.component.pop;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.ui.component.base.StdUIbaseDraw;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0016\u0018\u0000 r2\u00020\u0001:\u0002rsB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010Q\u001a\u00020\tJ\u0018\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020\u00132\u0006\u0010U\u001a\u00020\u0013H\u0007J\u0006\u0010V\u001a\u00020\tJ\u0006\u0010W\u001a\u00020\u0013J\u0006\u0010X\u001a\u00020*J\u0006\u0010Y\u001a\u00020\tJ\u0006\u0010Z\u001a\u00020JJ\b\u0010[\u001a\u00020\\H\u0002J\u0018\u0010]\u001a\u00020^2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0016\u0010_\u001a\u00020^2\u0006\u0010`\u001a\u0002032\u0006\u0010a\u001a\u00020\tJ\u0010\u0010b\u001a\u00020^2\u0006\u0010c\u001a\u00020-H\u0015J\u0018\u0010d\u001a\u00020^2\u0006\u0010e\u001a\u00020\t2\u0006\u0010f\u001a\u00020\tH\u0015J\b\u0010g\u001a\u00020^H\u0002J\u000e\u0010h\u001a\u00020^2\u0006\u0010i\u001a\u00020\tJ\u000e\u0010j\u001a\u00020^2\u0006\u0010T\u001a\u00020\tJ\u000e\u0010k\u001a\u00020^2\u0006\u0010l\u001a\u00020\tJ\u0016\u0010m\u001a\u00020^2\u0006\u0010l\u001a\u00020\t2\u0006\u0010n\u001a\u00020\u0013J\u0016\u0010o\u001a\u00020^2\u0006\u0010T\u001a\u00020\t2\u0006\u0010U\u001a\u00020\tJ\u000e\u0010p\u001a\u00020^2\u0006\u0010q\u001a\u000203R\u001a\u0010\u000b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000fR\u001a\u0010\u001b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000fR\u001a\u0010\u001e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\r\"\u0004\b \u0010\u000fR\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u00020\t8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\r\"\u0004\b%\u0010\u000fR\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0015\"\u0004\b1\u0010\u0017R$\u00104\u001a\u0002032\u0006\u00102\u001a\u000203@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u000203X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00106\"\u0004\b;\u00108R\u001a\u0010<\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0015\"\u0004\b>\u0010\u0017R\u000e\u0010?\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010B\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0015\"\u0004\bD\u0010\u0017R\u001a\u0010E\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0015\"\u0004\bG\u0010\u0017R\u000e\u0010H\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020JX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010N\u001a\u000203X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u00106\"\u0004\bP\u00108¨\u0006t"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/pop/CJPopoverLayout;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "arrowPadding", "getArrowPadding", "()I", "setArrowPadding", "(I)V", "borderColor", "borderWidth", "cornerRadius", "", "getCornerRadius", "()F", "setCornerRadius", "(F)V", "defaultHeight", "getDefaultHeight", "setDefaultHeight", "defaultWidth", "getDefaultWidth", "setDefaultWidth", "mAdjustHeight", "getMAdjustHeight", "setMAdjustHeight", "mArrowPressedPaint", "Landroid/graphics/Paint;", "mBgColor", "getMBgColor", "setMBgColor", "mBitmap", "Landroid/graphics/Bitmap;", "mBubbleArrowOffset", "mBubbleArrowPath", "Landroid/graphics/Path;", "mBubbleOrientation", "mCanvas", "Landroid/graphics/Canvas;", "mFillPaint", "mHeight", "getMHeight", "setMHeight", "value", "", "mNeedArrow", "getMNeedArrow", "()Z", "setMNeedArrow", "(Z)V", "mNeedShadow", "getMNeedShadow", "setMNeedShadow", "mPadding", "getMPadding", "setMPadding", "mPath", "mRoundRect", "Landroid/graphics/RectF;", "mWidth", "getMWidth", "setMWidth", "minArrowDistance", "getMinArrowDistance", "setMinArrowDistance", "pressStateColor", "shadowConfig", "Lcom/android/ttcjpaysdk/base/ui/component/pop/CJPopoverLayout$ShadowConfig;", "strokePaint", "tempArrowPath", "tempRectPath", "useDefaultView", "getUseDefaultView", "setUseDefaultView", "arrowDirection", "calculateBubbleArrowMatrix", "Landroid/graphics/Matrix;", "width", "height", "getArrowHeight", "getBubbleOffset", "getFullPath", "getPadding", "getShadowConfig", "getTagName", "", "init", "", "notifyPressed", "pressed", "pressedColor", "onDraw", "canvas", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "renderBubbleLegPrototype", "setBorderColor", "color", "setBorderWidth", "setBubbleOrientation", "bubbleOrientation", "setBubbleParams", "bubbleArrowOffset", "setCustomSize", "setTransparentBg", ECPromotion.TRANSPARENT_BOTTON_ICON, "Companion", "ShadowConfig", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPopoverLayout extends LinearLayout {
    public static final int BOTTOM = 3;
    public static final Companion Companion = null;
    public static final int LEFT = 1;
    public static final int RIGHT = 2;
    public static final int TOP = 0;
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
    private float mPadding;
    private Path mPath;
    private RectF mRoundRect;
    private float mWidth;
    private float minArrowDistance;
    private int pressStateColor;
    private ShadowConfig shadowConfig;
    private Paint strokePaint;
    private final Path tempArrowPath;
    private final Path tempRectPath;
    private boolean useDefaultView;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/pop/CJPopoverLayout$Companion;", "", "()V", "BOTTOM", "", "LEFT", "RIGHT", "TOP", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010¨\u0006 "}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/pop/CJPopoverLayout$ShadowConfig;", "", "radius", "", "dx", "dy", "color", "", "(FFFI)V", "getColor", "()I", "setColor", "(I)V", "getDx", "()F", "setDx", "(F)V", "getDy", "setDy", "getRadius", "setRadius", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ShadowConfig {
        private int color;

        /* JADX INFO: renamed from: dx, reason: collision with root package name */
        private float f29365dx;

        /* JADX INFO: renamed from: dy, reason: collision with root package name */
        private float f29366dy;
        private float radius;

        public ShadowConfig() {
            this(0.0f, 0.0f, 0.0f, 0, 15, null);
        }

        public static /* synthetic */ ShadowConfig copy$default(ShadowConfig r100, float r101, float r102, float r103, int r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.radius;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.f29365dx;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.f29366dy;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.color;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final float component1() {
            return this.radius;
        }

        public final float component2() {
            return this.f29365dx;
        }

        public final float component3() {
            return this.f29366dy;
        }

        public final int component4() {
            return this.color;
        }

        public final ShadowConfig copy(float r100, float r101, float r102, int r103) {
            return new ShadowConfig(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ShadowConfig) == true) goto L8;
            return false;
        L8:
            ShadowConfig r101 = (ShadowConfig) r100;
            if (Float.compare(this.radius, r101.radius) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.f29365dx, r101.f29365dx) == 0) goto L15;
            return false;
        L15:
            if (Float.compare(this.f29366dy, r101.f29366dy) == 0) goto L18;
            return false;
        L18:
            if (this.color == r101.color) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.radius) * 31) + Float.floatToIntBits(this.f29365dx)) * 31) + Float.floatToIntBits(this.f29366dy)) * 31) + this.color;
        }

        public String toString() {
            return "ShadowConfig(radius=" + this.radius + ", dx=" + this.f29365dx + ", dy=" + this.f29366dy + ", color=" + this.color + ')';
        }

        public final int getColor() {
            return this.color;
        }

        public final float getDx() {
            return this.f29365dx;
        }

        public final float getDy() {
            return this.f29366dy;
        }

        public final float getRadius() {
            return this.radius;
        }

        public final void setColor(int r100) {
            this.color = r100;
        }

        public final void setDx(float r100) {
            this.f29365dx = r100;
        }

        public final void setDy(float r100) {
            this.f29366dy = r100;
        }

        public final void setRadius(float r100) {
            this.radius = r100;
        }

        public ShadowConfig(float r100, float r101, float r102, int r103) {
            this.radius = r100;
            this.f29365dx = r101;
            this.f29366dy = r102;
            this.color = r103;
        }

        public /* synthetic */ ShadowConfig(float r100, float r101, float r102, int r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 1) == 0) goto L6;
            r100 = 2.0f;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r101 = 2.0f;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r102 = 5.0f;
        L12:
            if ((r104 & 8) == 0) goto L14;
            r103 = -16777216;
        L14:
            this(r100, r101, r102, r103);
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final String getTagName() {
        return "pop";
    }

    private final void renderBubbleLegPrototype() {
        this.mBubbleArrowPath.moveTo(0.0f, 0.0f);
        float r100 = this.arrowPadding / 7.0f;
        float r110 = r100 * 0.0f;
        float r101 = r100 * 7.0f;
        this.mBubbleArrowPath.cubicTo(r110, r100 * (-2.5f), r101, r100 * (-4.0f), r101, r100 * (-10.0f));
        this.mBubbleArrowPath.lineTo(r101, 10.0f * r100);
        this.mBubbleArrowPath.cubicTo(r101, r100 * 4.0f, r110, r100 * 2.5f, r110, r110);
        this.mBubbleArrowPath.close();
    }

    public final float getBubbleOffset() {
        float r100 = Math.max(this.mBubbleArrowOffset, this.minArrowDistance);
        int r101 = this.mBubbleOrientation;
        if (r101 == 0) goto L15;
        if (r101 == 1) goto L19;
        if (r101 == 2) goto L18;
        if (r101 == 3) goto L17;
        return 0.0f;
    L17:
        return Math.min(r100, (this.mWidth - this.arrowPadding) - this.minArrowDistance);
    L18:
        return Math.min(r100, (this.mHeight - this.arrowPadding) - this.minArrowDistance);
    L19:
        return Math.min(r100, (this.mHeight - this.arrowPadding) - this.minArrowDistance);
    L15:
        return Math.min(r100, (this.mWidth - this.arrowPadding) - this.minArrowDistance);
    }

    public final int getMBgColor() {
        int r100 = this.pressStateColor;
        if (r100 == 0) goto L6;
        return r100;
    L6:
        return this.mBgColor;
    }

    public final int getPadding() {
        return this.arrowPadding / 2;
    }

    public final int arrowDirection() {
        return this.mBubbleOrientation;
    }

    public final int getArrowHeight() {
        return this.arrowPadding;
    }

    public final int getArrowPadding() {
        return this.arrowPadding;
    }

    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    public final int getDefaultHeight() {
        return this.defaultHeight;
    }

    public final int getDefaultWidth() {
        return this.defaultWidth;
    }

    public final Path getFullPath() {
        return this.mPath;
    }

    public final int getMAdjustHeight() {
        return this.mAdjustHeight;
    }

    public final float getMHeight() {
        return this.mHeight;
    }

    public final boolean getMNeedArrow() {
        return this.mNeedArrow;
    }

    public final boolean getMNeedShadow() {
        return this.mNeedShadow;
    }

    public final float getMPadding() {
        return this.mPadding;
    }

    public final float getMWidth() {
        return this.mWidth;
    }

    public final float getMinArrowDistance() {
        return this.minArrowDistance;
    }

    public final ShadowConfig getShadowConfig() {
        return this.shadowConfig;
    }

    public final boolean getUseDefaultView() {
        return this.useDefaultView;
    }

    public CJPopoverLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ui_component_pop_CJPopoverLayout_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Bitmap r101 = this.mBitmap;
        if (r101 == null) goto L7;
        if (r101 == null) goto L6;
        r101.recycle();
    L6:
        this.mBitmap = null;
    L7:
        Bitmap r102 = Bitmap.createBitmap(INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ui_component_pop_CJPopoverLayout_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(getContext().getResources()), getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        this.mBitmap = r102;
        Canvas r103 = this.mCanvas;
        if (r103 != null) goto L10;
        Bitmap r104 = this.mBitmap;
        Intrinsics.checkNotNull(r104);
        this.mCanvas = new Canvas(r104);
    L12:
        this.mFillPaint.setColor(getMBgColor());
        calculateBubbleArrowMatrix(this.mWidth, this.mHeight);
        if (this.mNeedShadow == false) goto L15;
        this.mFillPaint.setShadowLayer(this.shadowConfig.getRadius(), this.shadowConfig.getDx(), this.shadowConfig.getDy(), this.shadowConfig.getColor());
    L15:
        Canvas r105 = this.mCanvas;
        if (r105 == null) goto L18;
        r105.drawPath(this.mPath, this.mFillPaint);
    L18:
        Paint r106 = this.strokePaint;
        if (r106 != null) goto L21;
    L25:
        Paint r107 = this.mArrowPressedPaint;
        if (r107 == null) goto L30;
        Canvas r108 = this.mCanvas;
        if (r108 == null) goto L30;
        Path r109 = this.tempArrowPath;
        Intrinsics.checkNotNull(r107);
        r108.drawPath(r109, r107);
    L30:
        Bitmap r110 = this.mBitmap;
        Intrinsics.checkNotNull(r110);
        r100.drawBitmap(r110, 0.0f, 0.0f, null);
        StdUIbaseDraw.INSTANCE.draw(r100, getWidth(), getHeight(), getTagName());
        return;
    L21:
        if (this.borderWidth <= 0) goto L25;
        Canvas r111 = this.mCanvas;
        if (r111 == null) goto L25;
        Path r112 = this.mPath;
        Intrinsics.checkNotNull(r106);
        r111.drawPath(r112, r106);
        goto L25
    L10:
        if (r103 == null) goto L12;
        r103.setBitmap(r102);
        goto L12
    }

    public final void setArrowPadding(int r100) {
        this.arrowPadding = r100;
    }

    public final void setBorderColor(int r100) {
        this.borderColor = r100;
    }

    public final void setBorderWidth(int r100) {
        if (r100 > 0) goto L4;
        return;
    L4:
        this.borderWidth = r100;
        if (this.strokePaint != null) goto L7;
        this.strokePaint = new Paint();
    L7:
        Paint r101 = this.strokePaint;
        if (r101 == null) goto L11;
        r101.setStyle(Paint.Style.STROKE);
    L11:
        Paint r102 = this.strokePaint;
        if (r102 == null) goto L15;
        r102.setStrokeWidth(this.borderWidth);
    L15:
        Paint r103 = this.strokePaint;
        if (r103 == null) goto L19;
        r103.setStrokeCap(Paint.Cap.BUTT);
    L19:
        Paint r104 = this.strokePaint;
        if (r104 == null) goto L23;
        r104.setStrokeJoin(Paint.Join.MITER);
    L23:
        Paint r105 = this.strokePaint;
        if (r105 == null) goto L27;
        r105.setAntiAlias(true);
    L27:
        Paint r106 = this.strokePaint;
        if (r106 == null) goto L31;
        r106.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
    L31:
        Paint r107 = this.strokePaint;
        if (r107 == null) goto L35;
        r107.setColor(this.borderColor);
    L35:
        this.mFillPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mFillPaint.setStrokeWidth(this.borderWidth);
    }

    public final void setBubbleOrientation(int r100) {
        this.mBubbleOrientation = r100;
    }

    public final void setCornerRadius(float r100) {
        this.cornerRadius = r100;
    }

    public final void setDefaultHeight(int r100) {
        this.defaultHeight = r100;
    }

    public final void setDefaultWidth(int r100) {
        this.defaultWidth = r100;
    }

    public final void setMAdjustHeight(int r100) {
        this.mAdjustHeight = r100;
    }

    public final void setMBgColor(int r100) {
        this.mBgColor = r100;
    }

    public final void setMHeight(float r100) {
        this.mHeight = r100;
    }

    public final void setMNeedArrow(boolean r100) {
        this.mNeedArrow = r100;
        if (r100 == false) goto L5;
        this.arrowPadding = CJPayBasicExtensionKt.dp(5.0f);
        return;
    L5:
        this.arrowPadding = CJPayBasicExtensionKt.dp(0.0f);
    }

    public final void setMNeedShadow(boolean r100) {
        this.mNeedShadow = r100;
    }

    public final void setMPadding(float r100) {
        this.mPadding = r100;
    }

    public final void setMWidth(float r100) {
        this.mWidth = r100;
    }

    public final void setMinArrowDistance(float r100) {
        this.minArrowDistance = r100;
    }

    public final void setTransparentBg(boolean r100) {
        if (r100 == false) goto L5;
        this.mBgColor = 0;
        setLayerType(1, null);
        return;
    L5:
        setLayerType(1, null);
    }

    public final void setUseDefaultView(boolean r100) {
        this.useDefaultView = r100;
    }

    public CJPopoverLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public final Matrix calculateBubbleArrowMatrix(float r100, float r110) {
        float r101 = Math.max(this.mBubbleArrowOffset, this.minArrowDistance + this.arrowPadding);
        Matrix r102 = new Matrix();
        int r103 = this.borderWidth;
        int r104 = r103 / 2;
        int r105 = this.mBubbleOrientation;
        if (r105 != 0) goto L5;
        float r106 = Math.min(r101, (r100 - this.arrowPadding) - this.minArrowDistance);
        float r111 = this.borderWidth;
        r102.postRotate(90.0f);
        setPadding(0, r104, 0, 0);
    L15:
        setGravity(17);
        int r107 = this.arrowPadding;
        int r108 = this.borderWidth;
        this.mRoundRect = new RectF(r107 + (r108 / 2), r107 + (r108 / 2), (this.mWidth - r107) - r108, (this.mHeight - r107) - r108);
        r102.postTranslate(r106, r111);
        this.mPath.reset();
        this.tempRectPath.reset();
        Path r109 = this.tempRectPath;
        RectF r112 = this.mRoundRect;
        float r113 = this.cornerRadius;
        r109.addRoundRect(r112, r113, r113, Path.Direction.CW);
        if (this.mNeedArrow == false) goto L18;
        this.tempArrowPath.reset();
        this.tempArrowPath.addPath(this.mBubbleArrowPath, r102);
        this.tempRectPath.op(this.tempArrowPath, Path.Op.UNION);
    L18:
        this.mPath.addPath(this.tempRectPath);
        return r102;
    L5:
        if (r105 != 1) goto L7;
        r106 = r103;
        r111 = Math.min(r101, (r110 - this.arrowPadding) - this.minArrowDistance);
        setPadding(r104, 0, 0, 0);
        goto L15
    L7:
        if (r105 != 2) goto L9;
        r106 = r100 - r103;
        r111 = Math.min(r101, (r110 - this.arrowPadding) - this.minArrowDistance);
        r102.postRotate(180.0f);
        setPadding(0, 0, r104, 0);
        goto L15
    L9:
        if (r105 == 3) goto L11;
        r106 = 0.0f;
        r111 = 0.0f;
        goto L15
    L11:
        r106 = Math.min(r101, (r100 - this.arrowPadding) - this.minArrowDistance);
        r111 = r110 - this.borderWidth;
        r102.postRotate(270.0f);
        setPadding(0, 0, 0, r104);
        goto L15
    }

    public final void init(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.mFillPaint = new Paint();
        this.mPath = new Path();
        this.mBubbleArrowPath = new Path();
        this.mFillPaint.setStyle(Paint.Style.FILL);
        this.mFillPaint.setStrokeCap(Paint.Cap.BUTT);
        this.mFillPaint.setAntiAlias(true);
        this.mFillPaint.setStrokeJoin(Paint.Join.MITER);
        if (getMBgColor() != 0) goto L5;
        this.mBgColor = ContextCompat.getColor(r100, R.color.cj_pay_color_pop_view_sd_primary);
    L5:
        this.mFillPaint.setColor(getMBgColor());
        setLayerType(1, null);
        renderBubbleLegPrototype();
        setBackgroundColor(0);
        setClipChildren(false);
    }

    public final void notifyPressed(boolean r100, int r101) {
        if (r100 == true) goto L4;
        Paint r102 = this.mArrowPressedPaint;
        if (r102 == null) goto L28;
        r102.setColor(0);
        return;
    L28:
        return;
    L4:
        if (this.mArrowPressedPaint != null) goto L17;
        Paint r103 = new Paint();
        this.mArrowPressedPaint = r103;
        r103.setStyle(Paint.Style.FILL);
        Paint r104 = this.mArrowPressedPaint;
        if (r104 == null) goto L9;
        r104.setStrokeCap(Paint.Cap.BUTT);
    L9:
        Paint r105 = this.mArrowPressedPaint;
        if (r105 == null) goto L13;
        r105.setStrokeJoin(Paint.Join.MITER);
    L13:
        Paint r106 = this.mArrowPressedPaint;
        if (r106 == null) goto L17;
        r106.setAntiAlias(true);
    L17:
        Paint r107 = this.mArrowPressedPaint;
        if (r107 == null) goto L27;
        r107.setColor(r101);
        return;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if ((getChildAt(0) instanceof TextView) == false) goto L5;
        View r102 = getChildAt(0);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.widget.TextView");
        TextView r103 = (TextView) r102;
    L6:
        int r104 = View.MeasureSpec.getMode(r100);
        int r105 = View.MeasureSpec.getSize(r100);
        int r106 = View.MeasureSpec.getMode(r101);
        int r107 = View.MeasureSpec.getSize(r101);
        if (r103 != null) goto L9;
        int r108 = getMeasuredWidth();
    L15:
        if (this.useDefaultView == false) goto L20;
        int r109 = this.defaultWidth;
        if (r108 <= r109) goto L19;
        r109 = (CJPayBasicExtensionKt.dp(this.mPadding) * 2) + r108;
    L19:
        int r110 = this.arrowPadding;
        int r111 = this.borderWidth;
        int r112 = (r109 + (r110 * 2)) + (r111 * 2);
        int r113 = (this.defaultHeight + (r110 * 2)) + (r111 * 2);
    L22:
        if (r104 != Integer.MIN_VALUE) goto L25;
        if (r106 != Integer.MIN_VALUE) goto L25;
        setMeasuredDimension(r112, r113);
    L29:
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        return;
    L25:
        if (r104 != Integer.MIN_VALUE) goto L27;
        setMeasuredDimension(r112, r107);
        goto L29
    L27:
        if (r106 != Integer.MIN_VALUE) goto L29;
        setMeasuredDimension(r105, r113);
        goto L29
    L20:
        PopupWindow r114 = new PopupWindow(getChildAt(0), -2, -2, true);
        r114.getContentView().measure(0, 0);
        r112 = r114.getContentView().getMeasuredWidth() + (this.arrowPadding * 2);
        r113 = r114.getContentView().getMeasuredHeight() + (this.arrowPadding * 2);
        goto L22
    L9:
        if (((int) r103.getPaint().measureText(r103.getText().toString())) <= CJPayBasicExtensionKt.dp(276.0f)) goto L11;
        int r115 = CJPayBasicExtensionKt.dp(276.0f);
    L12:
        r108 = (r115 + r103.getPaddingLeft()) + r103.getPaddingRight();
        goto L15
    L11:
        r115 = (int) r103.getPaint().measureText(r103.getText().toString());
        goto L12
    L5:
        r103 = null;
        goto L6
    }

    public final void setBubbleParams(int r100, float r101) {
        this.mBubbleArrowOffset = r101;
        this.mBubbleOrientation = r100;
    }

    public final void setCustomSize(int r100, int r101) {
        float r102 = r100;
        this.mWidth = r102;
        float r103 = r101;
        this.mHeight = r103;
        calculateBubbleArrowMatrix(r102, r103);
        postInvalidate();
    }

    public CJPopoverLayout(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r110);
        this.arrowPadding = CJPayBasicExtensionKt.dp(5.0f);
        this.cornerRadius = CJPayBasicExtensionKt.dpF(8.0f);
        this.minArrowDistance = CJPayBasicExtensionKt.dpF(1.0f);
        this.defaultWidth = CJPayBasicExtensionKt.dp(40.0f);
        this.defaultHeight = CJPayBasicExtensionKt.dp(42.0f);
        this.shadowConfig = new ShadowConfig(0.0f, 0.0f, 0.0f, 0, 15, null);
        this.mPadding = 12.0f;
        this.mFillPaint = new Paint();
        this.mPath = new Path();
        this.mBubbleArrowPath = new Path();
        this.mRoundRect = new RectF();
        this.mBubbleArrowOffset = 0.75f;
        this.mBubbleOrientation = 1;
        this.mNeedArrow = true;
        this.useDefaultView = true;
        this.tempRectPath = new Path();
        this.tempArrowPath = new Path();
        init(r100, r101);
    }
}
