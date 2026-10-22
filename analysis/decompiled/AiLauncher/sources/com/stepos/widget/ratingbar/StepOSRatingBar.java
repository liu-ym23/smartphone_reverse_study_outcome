package com.stepos.widget.ratingbar;

import Z8.C1168p;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import androidx.appcompat.widget.r;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.R;
import f.C4027a;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import u0.C5566a;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0015\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0010\b\u0016\u0018\u0000 \u008d\u00012\u00020\u00012\u00020\u0002:\u0002\u008d\u0001B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0013\u0010\u000fJ/\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J?\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0007H\u0002¢\u0006\u0004\b#\u0010$J9\u0010)\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\b\b\u0001\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u001dH\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010-\u001a\u00020\u00072\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u000bH\u0002¢\u0006\u0004\b/\u0010\rJ\u0017\u00101\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u0007H\u0002¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u0007H\u0002¢\u0006\u0004\b3\u00102J\u001f\u00106\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u0007H\u0002¢\u0006\u0004\b6\u00107J\u001f\u0010:\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u0007H\u0014¢\u0006\u0004\b:\u00107J\u0017\u0010;\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0014¢\u0006\u0004\b;\u0010<J\u0019\u0010?\u001a\u00020\u000b2\b\u0010>\u001a\u0004\u0018\u00010=H\u0007¢\u0006\u0004\b?\u0010@J\u0019\u0010B\u001a\u00020\u000b2\b\b\u0001\u0010A\u001a\u00020\u0007H\u0007¢\u0006\u0004\bB\u00102J\u0017\u0010D\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020\u0007H\u0016¢\u0006\u0004\bD\u00102J\u0017\u0010F\u001a\u00020\u000b2\u0006\u0010E\u001a\u00020\u001dH\u0016¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\u001dH\u0016¢\u0006\u0004\bH\u0010IJ\u0017\u0010J\u001a\u00020\u00102\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\bJ\u0010KJ\u0017\u0010M\u001a\u00020\u00102\u0006\u0010L\u001a\u00020+H\u0016¢\u0006\u0004\bM\u0010KJ\u0017\u0010N\u001a\u00020\u000b2\u0006\u0010L\u001a\u00020+H\u0016¢\u0006\u0004\bN\u0010OJ\u0017\u0010P\u001a\u00020\u00102\u0006\u0010L\u001a\u00020+H\u0016¢\u0006\u0004\bP\u0010KJ1\u0010U\u001a\u00020\u00102\b\u0010Q\u001a\u0004\u0018\u00010+2\u0006\u0010R\u001a\u00020+2\u0006\u0010S\u001a\u00020\u001d2\u0006\u0010T\u001a\u00020\u001dH\u0016¢\u0006\u0004\bU\u0010VJ\u0017\u0010W\u001a\u00020\u000b2\u0006\u0010L\u001a\u00020+H\u0016¢\u0006\u0004\bW\u0010OJ1\u0010Z\u001a\u00020\u00102\b\u0010Q\u001a\u0004\u0018\u00010+2\u0006\u0010R\u001a\u00020+2\u0006\u0010X\u001a\u00020\u001d2\u0006\u0010Y\u001a\u00020\u001dH\u0016¢\u0006\u0004\bZ\u0010VR\u0016\u0010[\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010]\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010\\R\u0016\u0010^\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010a\u001a\u00020`8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010c\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010e\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\be\u0010\\R\u0016\u0010f\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bf\u0010\\R\u0016\u0010g\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bg\u0010\\R\u0014\u0010h\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010\\R\u0014\u0010i\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010\\R\u0014\u0010j\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010\\R\u0014\u0010k\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010lR\u0014\u0010n\u001a\u00020m8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010oR\u0018\u0010q\u001a\u0004\u0018\u00010p8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010s\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010_R\u0014\u0010u\u001a\u00020t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010vR\u0018\u0010x\u001a\u0004\u0018\u00010w8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010yR\u0014\u0010{\u001a\u00020z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b{\u0010|R\u0014\u0010}\u001a\u00020z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b}\u0010|R\u0017\u0010\u007f\u001a\u00020~8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u0019\u0010\u0081\u0001\u001a\u00020~8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0080\u0001R\u0016\u0010\u0083\u0001\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0082\u0001\u0010\u000fR.\u0010\u0089\u0001\u001a\u0004\u0018\u00010p2\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010p8G@GX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R)\u0010\u008a\u0001\u001a\u00020\u00102\u0007\u0010\u0084\u0001\u001a\u00020\u00108G@GX\u0086\u000e¢\u0006\u000f\u001a\u0005\b\u008a\u0001\u0010\u0012\"\u0006\b\u008b\u0001\u0010\u008c\u0001¨\u0006\u008e\u0001"}, d2 = {"Lcom/stepos/widget/ratingbar/StepOSRatingBar;", "Landroidx/appcompat/widget/r;", "Landroid/view/GestureDetector$OnGestureListener;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LY8/t;", "initScales", "()V", "starsWidth", "()I", "", "shouldShowLabel", "()Z", "labelBlockHeight", "contentLeft", "starsW", "index", "isRtl", "starLeft", "(IIIZ)I", "Landroid/graphics/Canvas;", "canvas", "contentTop", "", "fillCount", "clipFilled", "(Landroid/graphics/Canvas;IIIFZ)V", "filledColorFor", "(I)I", "scaleAt", "(I)F", "left", "top", "color", ConstConfig.KEY_VIEW_SCALE_PROPERTY, "drawStar", "(Landroid/graphics/Canvas;IIIF)V", "Landroid/view/MotionEvent;", "event", "calculateCurrentIndex", "(Landroid/view/MotionEvent;)I", "startAnimation", "range", "setEnd", "(I)V", "backUpRange", "start", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "resetBackUp", "(II)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "onDraw", "(Landroid/graphics/Canvas;)V", "", "colors", "setStarColors", "([I)V", "arrayResId", "setStarColorsResource", "numStars", "setNumStars", "rating", "setRating", "(F)V", "getRating", "()F", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "e", "onDown", "onShowPress", "(Landroid/view/MotionEvent;)V", "onSingleTapUp", "e1", "e2", "distanceX", "distanceY", "onScroll", "(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z", "onLongPress", "velocityX", "velocityY", "onFling", "currentIndex", "I", "lastIndex", "hasInitialNum", "Z", "Landroid/graphics/drawable/Drawable;", "starDrawable", "Landroid/graphics/drawable/Drawable;", "starColors", "[I", "filledColor", "emptyColor", "labelColor", "starSizePx", "starGapPx", "textGapPx", "labelLineHeightPx", "F", "Landroid/text/TextPaint;", "labelPaint", "Landroid/text/TextPaint;", "", "ratingText", "Ljava/lang/CharSequence;", "ratingTextVisible", "Landroid/view/GestureDetector;", "gestureDetector", "Landroid/view/GestureDetector;", "Landroid/animation/ValueAnimator;", "scaleAnimator", "Landroid/animation/ValueAnimator;", "Landroid/view/animation/PathInterpolator;", "scaleUpInterpolator", "Landroid/view/animation/PathInterpolator;", "scaleDownInterpolator", "", "scales", "[F", "backScales", "getStarStepPx", "starStepPx", UxipConstants.f30680s, "getRatingLabel", "()Ljava/lang/CharSequence;", "setRatingLabel", "(Ljava/lang/CharSequence;)V", "ratingLabel", "isRatingLabelVisible", "setRatingLabelVisible", "(Z)V", "Companion", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public class StepOSRatingBar extends r implements GestureDetector.OnGestureListener {
    private static final Companion Companion = new Companion(null);
    private static final int SCALE_DOWN_TIME = 280;
    private static final int SCALE_UP_TIME = 220;
    private float[] backScales;
    private int currentIndex;
    private int emptyColor;
    private int filledColor;
    private final GestureDetector gestureDetector;
    private boolean hasInitialNum;
    private int labelColor;
    private final float labelLineHeightPx;
    private final TextPaint labelPaint;
    private int lastIndex;
    private CharSequence ratingText;
    private boolean ratingTextVisible;
    private ValueAnimator scaleAnimator;
    private final PathInterpolator scaleDownInterpolator;
    private final PathInterpolator scaleUpInterpolator;
    private float[] scales;
    private int[] starColors;
    private Drawable starDrawable;
    private final int starGapPx;
    private final int starSizePx;
    private final int textGapPx;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/stepos/widget/ratingbar/StepOSRatingBar$Companion;", "", "<init>", "()V", "SCALE_UP_TIME", "", "SCALE_DOWN_TIME", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSRatingBar(Context context) {
        this(context, null, 0, 6, null);
        p.i(context, "context");
    }

    private final void backUpRange(int range) {
        int iMin = Math.min(range, this.scales.length);
        for (int i10 = 0; i10 < iMin; i10++) {
            this.backScales[i10] = this.scales[i10];
        }
    }

    private final int calculateCurrentIndex(MotionEvent event) {
        if (getNumStars() <= 0) {
            return 0;
        }
        int iF = C5685n.f(getStarStepPx(), 1);
        float width = getLayoutDirection() == 1 ? (getWidth() - getPaddingRight()) - event.getX() : event.getX() - getPaddingLeft();
        if (width <= 0.0f) {
            return 0;
        }
        return Math.min(((int) (width / iF)) + 1, getNumStars());
    }

    private final void clipFilled(Canvas canvas, int contentLeft, int contentTop, int starsW, float fillCount, boolean isRtl) {
        float f10;
        int iN = C5685n.n((int) fillCount, 0, getNumStars());
        float fM = C5685n.m(fillCount - iN, 0.0f, 1.0f);
        if (iN <= 0) {
            f10 = fM * this.starSizePx;
        } else if (iN >= getNumStars()) {
            f10 = starsW;
        } else {
            f10 = (fM * this.starSizePx) + (iN * r1) + ((iN - 1) * this.starGapPx);
        }
        if (isRtl) {
            float f11 = contentLeft + starsW;
            canvas.clipRect(f11 - f10, contentTop, f11, contentTop + this.starSizePx);
        } else {
            float f12 = contentLeft;
            canvas.clipRect(f12, contentTop, f10 + f12, contentTop + this.starSizePx);
        }
    }

    private final void drawStar(Canvas canvas, int left, int top, int color, float scale) {
        Drawable drawable = this.starDrawable;
        C5566a.n(drawable, color);
        C5566a.p(drawable, PorterDuff.Mode.SRC_IN);
        int i10 = this.starSizePx;
        drawable.setBounds(left, top, left + i10, i10 + top);
        canvas.save();
        if (scale != 1.0f) {
            canvas.scale(scale, scale, (left + r6) / 2.0f, (top + r2) / 2.0f);
        }
        drawable.draw(canvas);
        canvas.restore();
    }

    private final int filledColorFor(int index) {
        int[] iArr = this.starColors;
        return (iArr == null || iArr.length == 0) ? this.filledColor : index < iArr.length ? iArr[index] : iArr[Z8.r.d0(iArr)];
    }

    private final int getStarStepPx() {
        return this.starSizePx + this.starGapPx;
    }

    private final void initScales() {
        int numStars = getNumStars();
        float[] fArr = this.scales;
        if (fArr.length == numStars) {
            C1168p.y(fArr, 0.0f, 0, 0, 6, null);
        } else {
            this.scales = new float[numStars];
            this.backScales = new float[numStars];
        }
    }

    private final int labelBlockHeight() {
        if (shouldShowLabel()) {
            return this.textGapPx + ((int) Math.ceil(this.labelLineHeightPx));
        }
        return 0;
    }

    private final void resetBackUp(int start, int end) {
        if (start == end) {
            return;
        }
        int iMin = Math.min(end, this.backScales.length);
        for (int iMin2 = Math.min(start, this.backScales.length); iMin2 < iMin; iMin2++) {
            this.backScales[iMin2] = 0.0f;
        }
    }

    private final float scaleAt(int index) {
        if (index >= 0) {
            float[] fArr = this.scales;
            if (index < fArr.length) {
                float f10 = fArr[index];
                return f10 < 220.0f ? (this.scaleUpInterpolator.getInterpolation(f10 / SCALE_UP_TIME) * 0.92999995f) + 0.1f : ((1.0f - this.scaleDownInterpolator.getInterpolation((f10 - SCALE_UP_TIME) / 280)) * 0.03f) + 1.0f;
            }
        }
        return 1.0f;
    }

    private final void setEnd(int range) {
        int iMin = Math.min(range, this.scales.length);
        for (int i10 = 0; i10 < iMin; i10++) {
            this.scales[i10] = (i10 * 16) + 500;
        }
    }

    private final boolean shouldShowLabel() {
        return this.ratingTextVisible && !TextUtils.isEmpty(this.ratingText);
    }

    private final int starLeft(int contentLeft, int starsW, int index, boolean isRtl) {
        return isRtl ? ((contentLeft + starsW) - ((index + 1) * this.starSizePx)) - (index * this.starGapPx) : contentLeft + (index * getStarStepPx());
    }

    private final int starsWidth() {
        int numStars = getNumStars();
        if (numStars <= 0) {
            return 0;
        }
        return (this.starSizePx * numStars) + ((numStars - 1) * this.starGapPx);
    }

    private final void startAnimation() {
        ValueAnimator valueAnimator = this.scaleAnimator;
        if (valueAnimator == null) {
            int numStars = (getNumStars() * 16) + 500;
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, numStars);
            valueAnimatorOfInt.setDuration(numStars);
            valueAnimatorOfInt.setInterpolator(new LinearInterpolator());
            valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.widget.ratingbar.a
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    StepOSRatingBar.startAnimation$lambda$2$lambda$1(this.f31310a, valueAnimator2);
                }
            });
            this.scaleAnimator = valueAnimatorOfInt;
            valueAnimator = valueAnimatorOfInt;
        }
        valueAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAnimation$lambda$2$lambda$1(StepOSRatingBar stepOSRatingBar, ValueAnimator animation) {
        p.i(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        p.g(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        float fIntValue = ((Integer) animatedValue).intValue();
        int numStars = stepOSRatingBar.getNumStars();
        for (int i10 = 0; i10 < numStars; i10++) {
            if (i10 >= 0) {
                float[] fArr = stepOSRatingBar.scales;
                if (i10 < fArr.length && i10 >= 0) {
                    float[] fArr2 = stepOSRatingBar.backScales;
                    if (i10 < fArr2.length) {
                        fArr[i10] = Math.min(Math.max(0.0f, (fArr2[i10] + fIntValue) - (i10 * 16.0f)), 500.0f);
                    }
                }
            }
        }
        stepOSRatingBar.invalidate();
    }

    @Override // android.widget.RatingBar
    public float getRating() {
        float rating = super.getRating();
        return this.hasInitialNum ? rating : (float) Math.ceil(rating);
    }

    /* renamed from: getRatingLabel, reason: from getter */
    public final CharSequence getRatingText() {
        return this.ratingText;
    }

    /* renamed from: isRatingLabelVisible, reason: from getter */
    public final boolean getRatingTextVisible() {
        return this.ratingTextVisible;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent e10) {
        p.i(e10, "e");
        if (isIndicator()) {
            return false;
        }
        if (this.hasInitialNum) {
            setEnd(Math.min(this.lastIndex, getNumStars()));
        }
        backUpRange(this.lastIndex);
        resetBackUp(Math.min(this.lastIndex, getNumStars()), getNumStars());
        int iCalculateCurrentIndex = calculateCurrentIndex(e10);
        this.currentIndex = iCalculateCurrentIndex;
        this.lastIndex = iCalculateCurrentIndex;
        this.hasInitialNum = false;
        startAnimation();
        return false;
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void onDraw(Canvas canvas) {
        CharSequence charSequence;
        p.i(canvas, "canvas");
        super.onDraw(canvas);
        int numStars = getNumStars();
        if (numStars <= 0) {
            return;
        }
        boolean z10 = getLayoutDirection() == 1;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int iStarsWidth = starsWidth();
        for (int i10 = 0; i10 < numStars; i10++) {
            drawStar(canvas, starLeft(paddingLeft, iStarsWidth, i10, z10), paddingTop, this.emptyColor, 1.0f);
        }
        float rating = this.hasInitialNum ? getRating() : this.currentIndex;
        if (rating > 0.0f) {
            canvas.save();
            clipFilled(canvas, paddingLeft, paddingTop, iStarsWidth, rating, z10);
            for (int i11 = 0; i11 < numStars; i11++) {
                drawStar(canvas, starLeft(paddingLeft, iStarsWidth, i11, z10), paddingTop, filledColorFor(i11), this.hasInitialNum ? 1.0f : scaleAt(i11));
            }
            canvas.restore();
        }
        if (!shouldShowLabel() || (charSequence = this.ratingText) == null) {
            return;
        }
        Paint.FontMetrics fontMetrics = this.labelPaint.getFontMetrics();
        float f10 = (((paddingTop + this.starSizePx) + this.textGapPx) + (this.labelLineHeightPx / 2.0f)) - ((fontMetrics.ascent + fontMetrics.descent) / 2.0f);
        this.labelPaint.setColor(this.labelColor);
        canvas.drawText(charSequence.toString(), paddingLeft + (iStarsWidth / 2.0f), f10, this.labelPaint);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent e12, MotionEvent e22, float velocityX, float velocityY) {
        p.i(e22, "e2");
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent e10) {
        p.i(e10, "e");
    }

    @Override // androidx.appcompat.widget.r, android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(View.resolveSize(getPaddingLeft() + starsWidth() + getPaddingRight(), widthMeasureSpec), View.resolveSize(getPaddingTop() + this.starSizePx + labelBlockHeight() + getPaddingBottom(), heightMeasureSpec));
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent e12, MotionEvent e22, float distanceX, float distanceY) {
        p.i(e22, "e2");
        if (isIndicator()) {
            return false;
        }
        int iCalculateCurrentIndex = calculateCurrentIndex(e22);
        int i10 = this.lastIndex;
        if (iCalculateCurrentIndex - i10 > 0) {
            backUpRange(i10);
            resetBackUp(Math.min(iCalculateCurrentIndex - 1, getNumStars()), getNumStars());
            initScales();
            ValueAnimator valueAnimator = this.scaleAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            this.currentIndex = iCalculateCurrentIndex;
            this.lastIndex = iCalculateCurrentIndex;
            this.hasInitialNum = false;
            startAnimation();
        } else {
            backUpRange(iCalculateCurrentIndex);
            resetBackUp(Math.min(this.lastIndex, getNumStars()), getNumStars());
            this.currentIndex = iCalculateCurrentIndex;
            this.lastIndex = iCalculateCurrentIndex;
            this.hasInitialNum = false;
            invalidate();
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent e10) {
        p.i(e10, "e");
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent e10) {
        p.i(e10, "e");
        return false;
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        p.i(event, "event");
        boolean zOnTouchEvent = super.onTouchEvent(event);
        this.gestureDetector.onTouchEvent(event);
        if (!isIndicator() && (event.getActionMasked() == 1 || event.getActionMasked() == 3)) {
            int iCalculateCurrentIndex = calculateCurrentIndex(event);
            this.currentIndex = iCalculateCurrentIndex;
            this.lastIndex = iCalculateCurrentIndex;
            this.hasInitialNum = false;
            float f10 = iCalculateCurrentIndex;
            if (super.getRating() != f10) {
                super.setRating(f10);
            }
            invalidate();
        }
        return zOnTouchEvent;
    }

    @Override // android.widget.RatingBar
    public void setNumStars(int numStars) {
        super.setNumStars(numStars);
        initScales();
        requestLayout();
    }

    @Override // android.widget.RatingBar
    public void setRating(float rating) {
        super.setRating(rating);
        this.hasInitialNum = true;
        int iMin = Math.min(getNumStars(), (int) Math.ceil(rating));
        this.lastIndex = iMin;
        this.currentIndex = iMin;
        invalidate();
    }

    public final void setRatingLabel(CharSequence charSequence) {
        if (p.d(this.ratingText, charSequence)) {
            return;
        }
        this.ratingText = charSequence;
        requestLayout();
        invalidate();
    }

    public final void setRatingLabelVisible(boolean z10) {
        if (this.ratingTextVisible != z10) {
            this.ratingTextVisible = z10;
            requestLayout();
            invalidate();
        }
    }

    public final void setStarColors(int[] colors) {
        this.starColors = colors;
        invalidate();
    }

    public final void setStarColorsResource(int arrayResId) {
        this.starColors = arrayResId != 0 ? getResources().getIntArray(arrayResId) : null;
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSRatingBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        p.i(context, "context");
    }

    public /* synthetic */ StepOSRatingBar(Context context, AttributeSet attributeSet, int i10, int i11, i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? R.attr.steposRatingBarStyle : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSRatingBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        p.i(context, "context");
        TextPaint textPaint = new TextPaint(1);
        this.labelPaint = textPaint;
        this.ratingTextVisible = true;
        this.gestureDetector = new GestureDetector(context, this);
        this.scaleUpInterpolator = new PathInterpolator(0.2f, 0.04f, 0.08f, 1.0f);
        this.scaleDownInterpolator = new PathInterpolator(0.35f, 0.56f, 0.0f, 1.0f);
        this.scales = new float[getNumStars()];
        this.backScales = new float[getNumStars()];
        this.starSizePx = getResources().getDimensionPixelSize(R.dimen.stepos_ratingbar_star_size);
        this.starGapPx = getResources().getDimensionPixelSize(R.dimen.stepos_ratingbar_star_gap);
        this.textGapPx = getResources().getDimensionPixelSize(R.dimen.stepos_ratingbar_text_gap);
        this.labelLineHeightPx = getResources().getDimension(R.dimen.stepos_ratingbar_text_line_height);
        this.filledColor = context.getColor(R.color.stepos_ratingbar_star_filled);
        this.emptyColor = context.getColor(R.color.stepos_ratingbar_star_empty);
        int color = context.getColor(R.color.stepos_ratingbar_text);
        this.labelColor = color;
        textPaint.setColor(color);
        textPaint.setTextSize(getResources().getDimension(R.dimen.stepos_ratingbar_text_size));
        textPaint.setTextAlign(Paint.Align.CENTER);
        int[] StepOSRatingBar = R.styleable.StepOSRatingBar;
        p.h(StepOSRatingBar, "StepOSRatingBar");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, StepOSRatingBar, i10, R.style.StepOSWidget_RatingBar);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.StepOSRatingBar_steposStarColors, 0);
        if (resourceId != 0) {
            this.starColors = typedArrayObtainStyledAttributes.getResources().getIntArray(resourceId);
        }
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.StepOSRatingBar_steposStarDrawable);
        this.ratingText = typedArrayObtainStyledAttributes.getText(R.styleable.StepOSRatingBar_steposRatingBarText);
        this.ratingTextVisible = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSRatingBar_steposRatingBarTextVisible, true);
        typedArrayObtainStyledAttributes.recycle();
        if (drawable == null && (drawable = C4027a.b(context, R.drawable.stepos_icon_ratingbar_star)) == null) {
            throw new IllegalStateException("stepos_icon_ratingbar_star missing");
        }
        this.starDrawable = drawable.mutate();
        if (getRating() != 0.0f) {
            int rating = (int) getRating();
            this.lastIndex = rating;
            this.currentIndex = rating;
            this.hasInitialNum = true;
        }
        initScales();
    }
}
