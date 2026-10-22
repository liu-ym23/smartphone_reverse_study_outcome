package Q0;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.LottieComposition;
import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final LottieComposition f1626a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f1627b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f1628c;

    /* renamed from: d, reason: collision with root package name */
    public final Interpolator f1629d;

    /* renamed from: e, reason: collision with root package name */
    public final float f1630e;

    /* renamed from: f, reason: collision with root package name */
    public Float f1631f;

    /* renamed from: g, reason: collision with root package name */
    public float f1632g;

    /* renamed from: h, reason: collision with root package name */
    public float f1633h;

    /* renamed from: i, reason: collision with root package name */
    public PointF f1634i;

    /* renamed from: j, reason: collision with root package name */
    public PointF f1635j;

    public a(LottieComposition lottieComposition, Object obj, Object obj2, Interpolator interpolator, float f4, Float f5) {
        this.f1632g = Float.MIN_VALUE;
        this.f1633h = Float.MIN_VALUE;
        this.f1634i = null;
        this.f1635j = null;
        this.f1626a = lottieComposition;
        this.f1627b = obj;
        this.f1628c = obj2;
        this.f1629d = interpolator;
        this.f1630e = f4;
        this.f1631f = f5;
    }

    public final float a() {
        LottieComposition lottieComposition = this.f1626a;
        if (lottieComposition == null) {
            return 1.0f;
        }
        if (this.f1633h == Float.MIN_VALUE) {
            if (this.f1631f == null) {
                this.f1633h = 1.0f;
            } else {
                this.f1633h = ((this.f1631f.floatValue() - this.f1630e) / lottieComposition.getDurationFrames()) + b();
            }
        }
        return this.f1633h;
    }

    public final float b() {
        LottieComposition lottieComposition = this.f1626a;
        if (lottieComposition == null) {
            return Property.DEFAULT_FLOAT_VALUE;
        }
        if (this.f1632g == Float.MIN_VALUE) {
            this.f1632g = (this.f1630e - lottieComposition.getStartFrame()) / lottieComposition.getDurationFrames();
        }
        return this.f1632g;
    }

    public final String toString() {
        return "Keyframe{startValue=" + this.f1627b + ", endValue=" + this.f1628c + ", startFrame=" + this.f1630e + ", endFrame=" + this.f1631f + ", interpolator=" + this.f1629d + '}';
    }

    public a(Object obj) {
        this.f1632g = Float.MIN_VALUE;
        this.f1633h = Float.MIN_VALUE;
        this.f1634i = null;
        this.f1635j = null;
        this.f1626a = null;
        this.f1627b = obj;
        this.f1628c = obj;
        this.f1629d = null;
        this.f1630e = Float.MIN_VALUE;
        this.f1631f = Float.valueOf(Float.MAX_VALUE);
    }
}
