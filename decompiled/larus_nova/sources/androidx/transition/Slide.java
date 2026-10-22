package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.core.content.res.TypedArrayUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes17.dex */
public class Slide extends Visibility {
    private static final String PROPNAME_SCREEN_POSITION = "android:slide:screenPosition";
    private static final TimeInterpolator sAccelerate = null;
    private static final CalculateSlide sCalculateBottom = null;
    private static final CalculateSlide sCalculateEnd = null;
    private static final CalculateSlide sCalculateLeft = null;
    private static final CalculateSlide sCalculateRight = null;
    private static final CalculateSlide sCalculateStart = null;
    private static final CalculateSlide sCalculateTop = null;
    private static final TimeInterpolator sDecelerate = null;
    private CalculateSlide mSlideCalculator;
    private int mSlideEdge;

    public interface CalculateSlide {
        float getGoneX(ViewGroup r100, View r101);

        float getGoneY(ViewGroup r100, View r101);
    }

    public static abstract class CalculateSlideHorizontal implements CalculateSlide {
        private CalculateSlideHorizontal() {
        }

        public /* synthetic */ CalculateSlideHorizontal(AnonymousClass1 r100) {
            this();
        }

        @Override // androidx.transition.Slide.CalculateSlide
        public float getGoneY(ViewGroup r100, View r101) {
            return r101.getTranslationY();
        }
    }

    public static abstract class CalculateSlideVertical implements CalculateSlide {
        private CalculateSlideVertical() {
        }

        public /* synthetic */ CalculateSlideVertical(AnonymousClass1 r100) {
            this();
        }

        @Override // androidx.transition.Slide.CalculateSlide
        public float getGoneX(ViewGroup r100, View r101) {
            return r101.getTranslationX();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface GravityFlag {
    }

    static {
        sDecelerate = new DecelerateInterpolator();
        sAccelerate = new AccelerateInterpolator();
        sCalculateLeft = new AnonymousClass1();
        sCalculateStart = new AnonymousClass2();
        sCalculateTop = new AnonymousClass3();
        sCalculateRight = new AnonymousClass4();
        sCalculateEnd = new AnonymousClass5();
        sCalculateBottom = new AnonymousClass6();
    }

    public Slide() {
        this.mSlideCalculator = sCalculateBottom;
        this.mSlideEdge = 80;
        setSlideEdge(80);
    }

    public int getSlideEdge() {
        return this.mSlideEdge;
    }

    public Slide(int r100) {
        this.mSlideCalculator = sCalculateBottom;
        this.mSlideEdge = 80;
        setSlideEdge(r100);
    }

    private void captureValues(TransitionValues r100) {
        int[] r101 = new int[2];
        r100.view.getLocationOnScreen(r101);
        r100.values.put(PROPNAME_SCREEN_POSITION, r101);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureEndValues(TransitionValues r100) {
        super.captureEndValues(r100);
        captureValues(r100);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(TransitionValues r100) {
        super.captureStartValues(r100);
        captureValues(r100);
    }

    public void setSlideEdge(int r100) {
        if (r100 != 3) goto L5;
        this.mSlideCalculator = sCalculateLeft;
    L22:
        this.mSlideEdge = r100;
        SidePropagation r101 = new SidePropagation();
        r101.setSide(r100);
        setPropagation(r101);
        return;
    L5:
        if (r100 != 5) goto L7;
        this.mSlideCalculator = sCalculateRight;
        goto L22
    L7:
        if (r100 != 48) goto L9;
        this.mSlideCalculator = sCalculateTop;
        goto L22
    L9:
        if (r100 != 80) goto L11;
        this.mSlideCalculator = sCalculateBottom;
        goto L22
    L11:
        if (r100 != 8388611) goto L13;
        this.mSlideCalculator = sCalculateStart;
        goto L22
    L13:
        if (r100 != 8388613) goto L16;
        this.mSlideCalculator = sCalculateEnd;
        goto L22
    L16:
        throw new IllegalArgumentException("Invalid slide direction");
    }

    public Slide(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.mSlideCalculator = sCalculateBottom;
        this.mSlideEdge = 80;
        TypedArray r102 = r100.obtainStyledAttributes(r101, Styleable.SLIDE);
        int r103 = TypedArrayUtils.getNamedInt(r102, (XmlPullParser) r101, "slideEdge", 0, 80);
        r102.recycle();
        setSlideEdge(r103);
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup r110, View r111, TransitionValues r112, TransitionValues r113) {
        if (r113 != null) goto L5;
        return null;
    L5:
        int[] r114 = (int[]) r113.values.get(PROPNAME_SCREEN_POSITION);
        float r100 = r111.getTranslationX();
        float r101 = r111.getTranslationY();
        float r102 = this.mSlideCalculator.getGoneX(r110, r111);
        float r103 = this.mSlideCalculator.getGoneY(r110, r111);
        return TranslationAnimationCreator.createAnimation(r111, r113, r114[0], r114[1], r102, r103, r100, r101, sDecelerate);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup r110, View r111, TransitionValues r112, TransitionValues r113) {
        if (r112 != null) goto L5;
        return null;
    L5:
        int[] r114 = (int[]) r112.values.get(PROPNAME_SCREEN_POSITION);
        float r100 = r111.getTranslationX();
        float r101 = r111.getTranslationY();
        float r102 = this.mSlideCalculator.getGoneX(r110, r111);
        float r103 = this.mSlideCalculator.getGoneY(r110, r111);
        return TranslationAnimationCreator.createAnimation(r111, r112, r114[0], r114[1], r100, r101, r102, r103, sAccelerate);
    }
}
