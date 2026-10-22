package P0;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.Choreographer;
import com.airbnb.lottie.LottieComposition;
import com.stepos.alphame.utils.Property;
import f1.AbstractC0557a;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes.dex */
public final class a extends ValueAnimator implements Choreographer.FrameCallback {

    /* renamed from: j, reason: collision with root package name */
    public LottieComposition f1555j;

    /* renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArraySet f1546a = new CopyOnWriteArraySet();

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArraySet f1547b = new CopyOnWriteArraySet();

    /* renamed from: c, reason: collision with root package name */
    public float f1548c = 1.0f;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1549d = false;

    /* renamed from: e, reason: collision with root package name */
    public long f1550e = 0;

    /* renamed from: f, reason: collision with root package name */
    public float f1551f = Property.DEFAULT_FLOAT_VALUE;

    /* renamed from: g, reason: collision with root package name */
    public int f1552g = 0;

    /* renamed from: h, reason: collision with root package name */
    public float f1553h = -2.1474836E9f;

    /* renamed from: i, reason: collision with root package name */
    public float f1554i = 2.1474836E9f;

    /* renamed from: k, reason: collision with root package name */
    public boolean f1556k = false;

    @Override // android.animation.Animator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void addListener(Animator.AnimatorListener animatorListener) {
        this.f1547b.add(animatorListener);
    }

    @Override // android.animation.ValueAnimator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f1546a.add(animatorUpdateListener);
    }

    public final float c() {
        LottieComposition lottieComposition = this.f1555j;
        return lottieComposition == null ? Property.DEFAULT_FLOAT_VALUE : (this.f1551f - lottieComposition.getStartFrame()) / (this.f1555j.getEndFrame() - this.f1555j.getStartFrame());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final void cancel() {
        Iterator it = this.f1547b.iterator();
        while (it.hasNext()) {
            ((Animator.AnimatorListener) it.next()).onAnimationCancel(this);
        }
        j(true);
    }

    public final float d() {
        LottieComposition lottieComposition = this.f1555j;
        if (lottieComposition == null) {
            return Property.DEFAULT_FLOAT_VALUE;
        }
        float f4 = this.f1554i;
        return f4 == 2.1474836E9f ? lottieComposition.getEndFrame() : f4;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j4) {
        boolean z4 = false;
        if (this.f1556k) {
            j(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
        if (this.f1555j == null || !this.f1556k) {
            return;
        }
        long jNanoTime = System.nanoTime();
        long j5 = jNanoTime - this.f1550e;
        LottieComposition lottieComposition = this.f1555j;
        float frameRate = j5 / (lottieComposition == null ? Float.MAX_VALUE : (1.0E9f / lottieComposition.getFrameRate()) / Math.abs(this.f1548c));
        float f4 = this.f1551f;
        if (g()) {
            frameRate = -frameRate;
        }
        float f5 = f4 + frameRate;
        this.f1551f = f5;
        float fE = e();
        float fD = d();
        if (f5 >= fE && f5 <= fD) {
            z4 = true;
        }
        boolean z5 = !z4;
        this.f1551f = AbstractC0557a.p(this.f1551f, e(), d());
        this.f1550e = jNanoTime;
        Iterator it = this.f1546a.iterator();
        while (it.hasNext()) {
            ((ValueAnimator.AnimatorUpdateListener) it.next()).onAnimationUpdate(this);
        }
        if (z5) {
            int repeatCount = getRepeatCount();
            CopyOnWriteArraySet copyOnWriteArraySet = this.f1547b;
            if (repeatCount == -1 || this.f1552g < getRepeatCount()) {
                Iterator it2 = copyOnWriteArraySet.iterator();
                while (it2.hasNext()) {
                    ((Animator.AnimatorListener) it2.next()).onAnimationRepeat(this);
                }
                this.f1552g++;
                if (getRepeatMode() == 2) {
                    this.f1549d = !this.f1549d;
                    this.f1548c = -this.f1548c;
                } else {
                    this.f1551f = g() ? d() : e();
                }
                this.f1550e = jNanoTime;
            } else {
                this.f1551f = d();
                j(true);
                boolean zG = g();
                Iterator it3 = copyOnWriteArraySet.iterator();
                while (it3.hasNext()) {
                    ((Animator.AnimatorListener) it3.next()).onAnimationEnd(this, zG);
                }
            }
        }
        if (this.f1555j == null) {
            return;
        }
        float f6 = this.f1551f;
        if (f6 < this.f1553h || f6 > this.f1554i) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.f1553h), Float.valueOf(this.f1554i), Float.valueOf(this.f1551f)));
        }
    }

    public final float e() {
        LottieComposition lottieComposition = this.f1555j;
        if (lottieComposition == null) {
            return Property.DEFAULT_FLOAT_VALUE;
        }
        float f4 = this.f1553h;
        return f4 == -2.1474836E9f ? lottieComposition.getStartFrame() : f4;
    }

    public final long f() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    public final boolean g() {
        return this.f1548c < Property.DEFAULT_FLOAT_VALUE;
    }

    @Override // android.animation.ValueAnimator
    public final float getAnimatedFraction() {
        float fE;
        float fD;
        float fE2;
        if (this.f1555j == null) {
            return Property.DEFAULT_FLOAT_VALUE;
        }
        if (g()) {
            fE = d() - this.f1551f;
            fD = d();
            fE2 = e();
        } else {
            fE = this.f1551f - e();
            fD = d();
            fE2 = e();
        }
        return fE / (fD - fE2);
    }

    @Override // android.animation.ValueAnimator
    public final Object getAnimatedValue() {
        return Float.valueOf(c());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final long getDuration() {
        LottieComposition lottieComposition = this.f1555j;
        if (lottieComposition == null) {
            return 0L;
        }
        return (long) lottieComposition.getDuration();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final /* bridge */ /* synthetic */ long getStartDelay() {
        f();
        throw null;
    }

    @Override // android.animation.Animator
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public final void removeAllListeners() {
        this.f1547b.clear();
    }

    @Override // android.animation.ValueAnimator
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public final void removeAllUpdateListeners() {
        this.f1546a.clear();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final boolean isRunning() {
        return this.f1556k;
    }

    public final void j(boolean z4) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z4) {
            this.f1556k = false;
        }
    }

    @Override // android.animation.Animator
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public final void removeListener(Animator.AnimatorListener animatorListener) {
        this.f1547b.remove(animatorListener);
    }

    @Override // android.animation.ValueAnimator
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f1546a.remove(animatorUpdateListener);
    }

    public final ValueAnimator m(long j4) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }

    public final void n(int i4) {
        float f4 = i4;
        if (this.f1551f == f4) {
            return;
        }
        this.f1551f = AbstractC0557a.p(f4, e(), d());
        this.f1550e = System.nanoTime();
        Iterator it = this.f1546a.iterator();
        while (it.hasNext()) {
            ((ValueAnimator.AnimatorUpdateListener) it.next()).onAnimationUpdate(this);
        }
    }

    public final void o(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    public final void p(int i4, int i5) {
        LottieComposition lottieComposition = this.f1555j;
        float startFrame = lottieComposition == null ? -3.4028235E38f : lottieComposition.getStartFrame();
        LottieComposition lottieComposition2 = this.f1555j;
        float endFrame = lottieComposition2 == null ? Float.MAX_VALUE : lottieComposition2.getEndFrame();
        float f4 = i4;
        this.f1553h = AbstractC0557a.p(f4, startFrame, endFrame);
        float f5 = i5;
        this.f1554i = AbstractC0557a.p(f5, startFrame, endFrame);
        n((int) AbstractC0557a.p(this.f1551f, f4, f5));
    }

    public final void q(long j4) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final /* bridge */ /* synthetic */ ValueAnimator setDuration(long j4) {
        m(j4);
        throw null;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final /* bridge */ /* synthetic */ void setInterpolator(TimeInterpolator timeInterpolator) {
        o(timeInterpolator);
        throw null;
    }

    @Override // android.animation.ValueAnimator
    public final void setRepeatMode(int i4) {
        super.setRepeatMode(i4);
        if (i4 == 2 || !this.f1549d) {
            return;
        }
        this.f1549d = false;
        this.f1548c = -this.f1548c;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final /* bridge */ /* synthetic */ void setStartDelay(long j4) {
        q(j4);
        throw null;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final /* bridge */ /* synthetic */ Animator setDuration(long j4) {
        m(j4);
        throw null;
    }
}
