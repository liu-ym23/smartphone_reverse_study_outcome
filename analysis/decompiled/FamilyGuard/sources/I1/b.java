package I1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.RuntimeShader;
import android.graphics.Shader;
import android.os.SystemClock;
import android.view.animation.LinearInterpolator;
import com.stepos.common.drawble.ShadeBlurEntity;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final RuntimeShader f2907a;

    /* renamed from: b, reason: collision with root package name */
    private long f2908b;

    /* renamed from: c, reason: collision with root package name */
    private ValueAnimator f2909c;

    /* renamed from: d, reason: collision with root package name */
    private ObjectAnimator f2910d;

    /* renamed from: e, reason: collision with root package name */
    private final f f2911e;

    /* renamed from: f, reason: collision with root package name */
    private ValueAnimator.AnimatorUpdateListener f2912f;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (b.this.f2911e.f2923g != null) {
                b.this.f2911e.f2923g.a();
            }
        }
    }

    /* renamed from: I1.b$b, reason: collision with other inner class name */
    class C0038b extends AnimatorListenerAdapter {
        C0038b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            b.this.f2908b = SystemClock.uptimeMillis();
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            b.this.f2907a.setFloatUniform("time", (SystemClock.uptimeMillis() - b.this.f2908b) / 1000.0f);
            if (b.this.f2911e.f2923g != null) {
                b.this.f2911e.f2923g.a();
            }
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        f f2916a = new f();

        public b a() {
            return new b(this.f2916a, null);
        }

        public d b(int i5) {
            this.f2916a.f2924h = i5;
            return this;
        }

        public d c(e eVar) {
            this.f2916a.f2923g = eVar;
            return this;
        }

        public d d(String[] strArr) {
            this.f2916a.f2922f = strArr;
            return this;
        }

        public d e(int i5) {
            this.f2916a.f2921e = i5;
            return this;
        }

        public d f(int i5) {
            this.f2916a.f2920d = i5;
            return this;
        }

        public d g(boolean z5) {
            this.f2916a.f2919c = z5;
            return this;
        }

        public d h(float f5) {
            this.f2916a.f2917a = f5;
            return this;
        }

        public d i(int i5) {
            this.f2916a.f2918b = i5;
            return this;
        }
    }

    public interface e {
        void a();
    }

    public static class f {

        /* renamed from: a, reason: collision with root package name */
        float f2917a;

        /* renamed from: b, reason: collision with root package name */
        int f2918b;

        /* renamed from: c, reason: collision with root package name */
        boolean f2919c;

        /* renamed from: d, reason: collision with root package name */
        int f2920d;

        /* renamed from: e, reason: collision with root package name */
        int f2921e;

        /* renamed from: f, reason: collision with root package name */
        String[] f2922f;

        /* renamed from: g, reason: collision with root package name */
        e f2923g;

        /* renamed from: h, reason: collision with root package name */
        int f2924h = 1;
    }

    /* synthetic */ b(f fVar, a aVar) {
        this(fVar);
    }

    private void f() {
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f2909c = valueAnimator;
        valueAnimator.setInterpolator(new LinearInterpolator());
        this.f2909c.addListener(new C0038b());
        this.f2909c.addUpdateListener(new c());
        String[] strArr = this.f2911e.f2922f;
        if (strArr != null) {
            m(strArr);
        }
        this.f2909c.setFloatValues(0.0f, 1.0f);
        this.f2909c.setDuration(5000L);
        this.f2909c.setRepeatCount(-1);
        this.f2909c.setRepeatMode(1);
    }

    private void g() {
        String[] strArr = this.f2911e.f2922f;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        ObjectAnimator objectAnimator = this.f2910d;
        boolean z5 = objectAnimator != null && objectAnimator.isRunning();
        i();
        String[] strArr2 = this.f2911e.f2922f;
        int length = (strArr2.length - 1) * 1000;
        int length2 = strArr2.length;
        int[] iArr = new int[length2];
        int i5 = 0;
        while (true) {
            String[] strArr3 = this.f2911e.f2922f;
            if (i5 >= strArr3.length) {
                break;
            }
            iArr[i5] = Color.parseColor(strArr3[i5]);
            i5++;
        }
        Keyframe[] keyframeArr = new Keyframe[length2];
        for (int i6 = 0; i6 < length2; i6++) {
            keyframeArr[i6] = Keyframe.ofInt(i6 / (length2 - 1), iArr[i6]);
        }
        PropertyValuesHolder propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe("monochrome", keyframeArr);
        propertyValuesHolderOfKeyframe.setEvaluator(new ArgbEvaluator());
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, propertyValuesHolderOfKeyframe);
        this.f2910d = objectAnimatorOfPropertyValuesHolder;
        objectAnimatorOfPropertyValuesHolder.setDuration(length);
        this.f2910d.setRepeatCount(-1);
        this.f2910d.setRepeatMode(1);
        this.f2910d.addUpdateListener(this.f2912f);
        if (z5) {
            t();
        }
    }

    private void l(int[] iArr) {
        if (this.f2911e.f2924h == 0) {
            g();
        } else {
            this.f2907a.setInputShader("glowColors", new LinearGradient(0.0f, 0.0f, 1024.0f, 0.0f, iArr, (float[]) null, Shader.TileMode.CLAMP));
        }
    }

    private void m(String[] strArr) {
        int[] iArr = new int[strArr.length];
        for (int i5 = 0; i5 < strArr.length; i5++) {
            iArr[i5] = Color.parseColor(strArr[i5]);
        }
        l(iArr);
    }

    public RuntimeShader e() {
        return this.f2907a;
    }

    public boolean h() {
        ValueAnimator valueAnimator = this.f2909c;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    public void i() {
        ValueAnimator valueAnimator = this.f2909c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ObjectAnimator objectAnimator = this.f2910d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public void j(int i5) {
        this.f2911e.f2924h = i5;
        i();
        if (i5 == 0) {
            g();
        } else {
            f();
        }
    }

    public void k(String[] strArr) {
        this.f2911e.f2922f = strArr;
        int[] iArr = new int[strArr.length];
        for (int i5 = 0; i5 < strArr.length; i5++) {
            iArr[i5] = Color.parseColor(strArr[i5]);
        }
        l(iArr);
    }

    public void n(float f5) {
        this.f2907a.setFloatUniform("radius", f5);
    }

    public void o(boolean z5) {
        this.f2907a.setFloatUniform("inner", z5 ? 1.0f : -1.0f);
    }

    public void p(float f5) {
        this.f2907a.setFloatUniform("glowIntensity", f5);
    }

    public void q(int i5) {
        this.f2907a.setFloatUniform("glowRadius", i5);
    }

    public void r(float f5, float f6) {
        this.f2907a.setFloatUniform("size", f5, f6);
    }

    public void s(int i5) {
        this.f2907a.setColorUniform("rectColor", i5);
    }

    public void t() {
        ObjectAnimator objectAnimator;
        ValueAnimator valueAnimator;
        if (this.f2911e.f2924h == 1 && (valueAnimator = this.f2909c) != null && !valueAnimator.isRunning()) {
            this.f2909c.start();
        }
        if (this.f2911e.f2924h != 0 || (objectAnimator = this.f2910d) == null || objectAnimator.isRunning()) {
            return;
        }
        this.f2910d.start();
    }

    private b(f fVar) {
        RuntimeShader runtimeShader = new RuntimeShader(ShadeBlurEntity.INSTANCE.getRuntimeShader());
        this.f2907a = runtimeShader;
        this.f2912f = new a();
        this.f2911e = fVar;
        runtimeShader.setFloatUniform("time", 0.0f);
        runtimeShader.setFloatUniform("glowRadius", fVar.f2920d);
        runtimeShader.setFloatUniform("glowIntensity", fVar.f2917a);
        runtimeShader.setFloatUniform("inner", fVar.f2919c ? 1.0f : -1.0f);
        runtimeShader.setColorUniform("rectColor", fVar.f2918b);
        runtimeShader.setFloatUniform("radius", fVar.f2921e);
        if (fVar.f2924h == 0) {
            g();
        } else {
            f();
        }
    }
}
