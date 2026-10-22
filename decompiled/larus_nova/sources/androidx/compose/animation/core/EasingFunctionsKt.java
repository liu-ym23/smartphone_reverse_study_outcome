package androidx.compose.animation.core;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\bE\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u0011\u0010\u0006\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0003\"\u0011\u0010\b\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0003\"\u0011\u0010\n\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0003\"\u0011\u0010\f\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0003\"\u0011\u0010\u000e\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0003\"\u0011\u0010\u0010\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0003\"\u0011\u0010\u0012\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0003\"\u0011\u0010\u0014\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0003\"\u0011\u0010\u0016\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0003\"\u0011\u0010\u0018\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0003\"\u0011\u0010\u001a\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0003\"\u0011\u0010\u001c\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0003\"\u0011\u0010\u001e\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0003\"\u0011\u0010 \u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0003\"\u0011\u0010\"\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0003\"\u0011\u0010$\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0003\"\u0011\u0010&\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0003\"\u0011\u0010(\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0003\"\u0011\u0010*\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0003\"\u0011\u0010,\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0003\"\u0011\u0010.\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0003\"\u0011\u00100\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0003\"\u0011\u00102\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0003\"\u0011\u00104\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0003\"\u0011\u00106\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0003\"\u0011\u00108\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0003\"\u0011\u0010:\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0003\"\u0011\u0010<\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0003\"\u0011\u0010>\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0003\"\u0011\u0010@\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u0003\"\u0011\u0010B\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u0003\"\u0011\u0010D\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\u0003¨\u0006F"}, d2 = {"Ease", "Landroidx/compose/animation/core/Easing;", "getEase", "()Landroidx/compose/animation/core/Easing;", "EaseOut", "getEaseOut", "EaseIn", "getEaseIn", "EaseInOut", "getEaseInOut", "EaseInSine", "getEaseInSine", "EaseOutSine", "getEaseOutSine", "EaseInOutSine", "getEaseInOutSine", "EaseInCubic", "getEaseInCubic", "EaseOutCubic", "getEaseOutCubic", "EaseInOutCubic", "getEaseInOutCubic", "EaseInQuint", "getEaseInQuint", "EaseOutQuint", "getEaseOutQuint", "EaseInOutQuint", "getEaseInOutQuint", "EaseInCirc", "getEaseInCirc", "EaseOutCirc", "getEaseOutCirc", "EaseInOutCirc", "getEaseInOutCirc", "EaseInQuad", "getEaseInQuad", "EaseOutQuad", "getEaseOutQuad", "EaseInOutQuad", "getEaseInOutQuad", "EaseInQuart", "getEaseInQuart", "EaseOutQuart", "getEaseOutQuart", "EaseInOutQuart", "getEaseInOutQuart", "EaseInExpo", "getEaseInExpo", "EaseOutExpo", "getEaseOutExpo", "EaseInOutExpo", "getEaseInOutExpo", "EaseInBack", "getEaseInBack", "EaseOutBack", "getEaseOutBack", "EaseInOutBack", "getEaseInOutBack", "EaseInElastic", "getEaseInElastic", "EaseOutElastic", "getEaseOutElastic", "EaseInOutElastic", "getEaseInOutElastic", "EaseOutBounce", "getEaseOutBounce", "EaseInBounce", "getEaseInBounce", "EaseInOutBounce", "getEaseInOutBounce", "animation-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class EasingFunctionsKt {
    private static final Easing Ease = null;
    private static final Easing EaseIn = null;
    private static final Easing EaseInBack = null;
    private static final Easing EaseInBounce = null;
    private static final Easing EaseInCirc = null;
    private static final Easing EaseInCubic = null;
    private static final Easing EaseInElastic = null;
    private static final Easing EaseInExpo = null;
    private static final Easing EaseInOut = null;
    private static final Easing EaseInOutBack = null;
    private static final Easing EaseInOutBounce = null;
    private static final Easing EaseInOutCirc = null;
    private static final Easing EaseInOutCubic = null;
    private static final Easing EaseInOutElastic = null;
    private static final Easing EaseInOutExpo = null;
    private static final Easing EaseInOutQuad = null;
    private static final Easing EaseInOutQuart = null;
    private static final Easing EaseInOutQuint = null;
    private static final Easing EaseInOutSine = null;
    private static final Easing EaseInQuad = null;
    private static final Easing EaseInQuart = null;
    private static final Easing EaseInQuint = null;
    private static final Easing EaseInSine = null;
    private static final Easing EaseOut = null;
    private static final Easing EaseOutBack = null;
    private static final Easing EaseOutBounce = null;
    private static final Easing EaseOutCirc = null;
    private static final Easing EaseOutCubic = null;
    private static final Easing EaseOutElastic = null;
    private static final Easing EaseOutExpo = null;
    private static final Easing EaseOutQuad = null;
    private static final Easing EaseOutQuart = null;
    private static final Easing EaseOutQuint = null;
    private static final Easing EaseOutSine = null;

    private static final float EaseOutBounce$lambda$3(float r100) {
        if (r100 >= 0.36363637f) goto L6;
        return (7.5625f * r100) * r100;
    L6:
        if (r100 >= 0.72727275f) goto L10;
        float r101 = r100 - 0.54545456f;
        float r102 = (7.5625f * r101) * r101;
        float r103 = 0.75f;
    L14:
        return r102 + r103;
    L10:
        if (r100 >= 0.90909094f) goto L12;
        float r104 = r100 - 0.8181818f;
        r102 = (7.5625f * r104) * r104;
        r103 = 0.9375f;
        goto L14
    L12:
        float r105 = r100 - 0.95454544f;
        r102 = (7.5625f * r105) * r105;
        r103 = 0.984375f;
        goto L14
    }

    public static /* synthetic */ float a(float r100) {
        return EaseInBounce$lambda$4(r100);
    }

    public static /* synthetic */ float b(float r100) {
        return EaseOutBounce$lambda$3(r100);
    }

    public static /* synthetic */ float c(float r100) {
        return EaseInOutElastic$lambda$2(r100);
    }

    public static /* synthetic */ float d(float r100) {
        return EaseInElastic$lambda$0(r100);
    }

    public static /* synthetic */ float e(float r100) {
        return EaseOutElastic$lambda$1(r100);
    }

    public static /* synthetic */ float f(float r100) {
        return EaseInOutBounce$lambda$5(r100);
    }

    static {
        Ease = new CubicBezierEasing(0.25f, 0.1f, 0.25f, 1.0f);
        EaseOut = new CubicBezierEasing(0.0f, 0.0f, 0.58f, 1.0f);
        EaseIn = new CubicBezierEasing(0.42f, 0.0f, 1.0f, 1.0f);
        EaseInOut = new CubicBezierEasing(0.42f, 0.0f, 0.58f, 1.0f);
        EaseInSine = new CubicBezierEasing(0.12f, 0.0f, 0.39f, 0.0f);
        EaseOutSine = new CubicBezierEasing(0.61f, 1.0f, 0.88f, 1.0f);
        EaseInOutSine = new CubicBezierEasing(0.37f, 0.0f, 0.63f, 1.0f);
        EaseInCubic = new CubicBezierEasing(0.32f, 0.0f, 0.67f, 0.0f);
        EaseOutCubic = new CubicBezierEasing(0.33f, 1.0f, 0.68f, 1.0f);
        EaseInOutCubic = new CubicBezierEasing(0.65f, 0.0f, 0.35f, 1.0f);
        EaseInQuint = new CubicBezierEasing(0.64f, 0.0f, 0.78f, 0.0f);
        EaseOutQuint = new CubicBezierEasing(0.22f, 1.0f, 0.36f, 1.0f);
        EaseInOutQuint = new CubicBezierEasing(0.83f, 0.0f, 0.17f, 1.0f);
        EaseInCirc = new CubicBezierEasing(0.55f, 0.0f, 1.0f, 0.45f);
        EaseOutCirc = new CubicBezierEasing(0.0f, 0.55f, 0.45f, 1.0f);
        EaseInOutCirc = new CubicBezierEasing(0.85f, 0.0f, 0.15f, 1.0f);
        EaseInQuad = new CubicBezierEasing(0.11f, 0.0f, 0.5f, 0.0f);
        EaseOutQuad = new CubicBezierEasing(0.5f, 1.0f, 0.89f, 1.0f);
        EaseInOutQuad = new CubicBezierEasing(0.45f, 0.0f, 0.55f, 1.0f);
        EaseInQuart = new CubicBezierEasing(0.5f, 0.0f, 0.75f, 0.0f);
        EaseOutQuart = new CubicBezierEasing(0.25f, 1.0f, 0.5f, 1.0f);
        EaseInOutQuart = new CubicBezierEasing(0.76f, 0.0f, 0.24f, 1.0f);
        EaseInExpo = new CubicBezierEasing(0.7f, 0.0f, 0.84f, 0.0f);
        EaseOutExpo = new CubicBezierEasing(0.16f, 1.0f, 0.3f, 1.0f);
        EaseInOutExpo = new CubicBezierEasing(0.87f, 0.0f, 0.13f, 1.0f);
        EaseInBack = new CubicBezierEasing(0.36f, 0.0f, 0.66f, -0.56f);
        EaseOutBack = new CubicBezierEasing(0.34f, 1.56f, 0.64f, 1.0f);
        EaseInOutBack = new CubicBezierEasing(0.68f, -0.6f, 0.32f, 1.6f);
        EaseInElastic = new e();
        EaseOutElastic = new f();
        EaseInOutElastic = new g();
        EaseOutBounce = new h();
        EaseInBounce = new i();
        EaseInOutBounce = new j();
    }

    public static final Easing getEase() {
        return Ease;
    }

    public static final Easing getEaseIn() {
        return EaseIn;
    }

    public static final Easing getEaseInBack() {
        return EaseInBack;
    }

    public static final Easing getEaseInBounce() {
        return EaseInBounce;
    }

    public static final Easing getEaseInCirc() {
        return EaseInCirc;
    }

    public static final Easing getEaseInCubic() {
        return EaseInCubic;
    }

    public static final Easing getEaseInElastic() {
        return EaseInElastic;
    }

    public static final Easing getEaseInExpo() {
        return EaseInExpo;
    }

    public static final Easing getEaseInOut() {
        return EaseInOut;
    }

    public static final Easing getEaseInOutBack() {
        return EaseInOutBack;
    }

    public static final Easing getEaseInOutBounce() {
        return EaseInOutBounce;
    }

    public static final Easing getEaseInOutCirc() {
        return EaseInOutCirc;
    }

    public static final Easing getEaseInOutCubic() {
        return EaseInOutCubic;
    }

    public static final Easing getEaseInOutElastic() {
        return EaseInOutElastic;
    }

    public static final Easing getEaseInOutExpo() {
        return EaseInOutExpo;
    }

    public static final Easing getEaseInOutQuad() {
        return EaseInOutQuad;
    }

    public static final Easing getEaseInOutQuart() {
        return EaseInOutQuart;
    }

    public static final Easing getEaseInOutQuint() {
        return EaseInOutQuint;
    }

    public static final Easing getEaseInOutSine() {
        return EaseInOutSine;
    }

    public static final Easing getEaseInQuad() {
        return EaseInQuad;
    }

    public static final Easing getEaseInQuart() {
        return EaseInQuart;
    }

    public static final Easing getEaseInQuint() {
        return EaseInQuint;
    }

    public static final Easing getEaseInSine() {
        return EaseInSine;
    }

    public static final Easing getEaseOut() {
        return EaseOut;
    }

    public static final Easing getEaseOutBack() {
        return EaseOutBack;
    }

    public static final Easing getEaseOutBounce() {
        return EaseOutBounce;
    }

    public static final Easing getEaseOutCirc() {
        return EaseOutCirc;
    }

    public static final Easing getEaseOutCubic() {
        return EaseOutCubic;
    }

    public static final Easing getEaseOutElastic() {
        return EaseOutElastic;
    }

    public static final Easing getEaseOutExpo() {
        return EaseOutExpo;
    }

    public static final Easing getEaseOutQuad() {
        return EaseOutQuad;
    }

    public static final Easing getEaseOutQuart() {
        return EaseOutQuart;
    }

    public static final Easing getEaseOutQuint() {
        return EaseOutQuint;
    }

    public static final Easing getEaseOutSine() {
        return EaseOutSine;
    }

    private static final float EaseInBounce$lambda$4(float r100) {
        return 1 - EaseOutBounce.transform(1.0f - r100);
    }

    private static final float EaseInElastic$lambda$0(float r100) {
        boolean r101 = true;
        if (r100 != 0.0f) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return 0.0f;
    L9:
        if (r100 == 1.0f) goto L12;
        r101 = false;
    L12:
        if (r101 == true) goto L17;
        float r103 = r100 * 10.0f;
        return (float) (((double) (-((float) Math.pow(2.0f, r103 - 10.0f)))) * Math.sin(((double) (r103 - 10.75f)) * 2.0943951023931953d));
    L17:
        return 1.0f;
    L5:
        r102 = false;
        goto L6
    }

    private static final float EaseInOutBounce$lambda$5(float r100) {
        if (r100 >= 0.5d) goto L5;
        float r101 = 1 - EaseOutBounce.transform(1.0f - (r100 * 2.0f));
    L7:
        return r101 / 2.0f;
    L5:
        r101 = 1 + EaseOutBounce.transform((r100 * 2.0f) - 1.0f);
        goto L7
    }

    private static final float EaseInOutElastic$lambda$2(float r110) {
        boolean r100 = true;
        if (r110 != 0.0f) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return 0.0f;
    L9:
        if (r110 != 1.0f) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L15;
        return 1.0f;
    L15:
        if (0.0f <= r110) goto L17;
    L19:
        r100 = false;
    L21:
        if (r100 == false) goto L23;
        double r103 = 2.0f;
        float r111 = r110 * 20.0f;
        return (float) ((-(((double) ((float) Math.pow(r103, r111 - 10.0f))) * Math.sin(((double) (r111 - 11.125f)) * 1.3962634015954636d))) / r103);
    L23:
        double r104 = 2.0f;
        return ((float) ((((double) ((float) Math.pow(r104, ((-20.0f) * r110) + 10.0f))) * Math.sin(((double) ((r110 * 20.0f) - 11.125f)) * 1.3962634015954636d)) / r104)) + 1.0f;
    L17:
        if (r110 > 0.5f) goto L19;
    L11:
        r102 = false;
        goto L12
    L5:
        r101 = false;
        goto L6
    }

    private static final float EaseOutElastic$lambda$1(float r100) {
        boolean r101 = true;
        if (r100 != 0.0f) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return 0.0f;
    L9:
        if (r100 == 1.0f) goto L12;
        r101 = false;
    L12:
        if (r101 == false) goto L15;
        return 1.0f;
    L15:
        return (float) ((((double) ((float) Math.pow(2.0f, (-10.0f) * r100))) * Math.sin(((double) ((r100 * 10.0f) - 0.75f)) * 2.0943951023931953d)) + ((double) 1.0f));
    L5:
        r102 = false;
        goto L6
    }
}
