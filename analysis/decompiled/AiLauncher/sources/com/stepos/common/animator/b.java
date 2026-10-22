package com.stepos.common.animator;

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
import io.ktor.http.ContentDisposition;

/* loaded from: classes3.dex */
public class b {
    private static final boolean DEBUG = false;
    public static final int MIXTURE = 1;
    public static final int MONOCHROME = 0;
    private static final int MONOCHROME_SHADER_SWITCH_DURATION = 1000;
    private static final String TAG = "ShaderAnimator";

    /* renamed from: P, reason: collision with root package name */
    private final f f29503P;
    private long mAnimStartTime;
    private ValueAnimator mMixtureAnim;
    private ObjectAnimator mMonochromeAnim;
    private final RuntimeShader mShader;
    private ValueAnimator.AnimatorUpdateListener mUpdateListener;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (b.this.f29503P.mCallback != null) {
                b.this.f29503P.mCallback.a();
            }
        }
    }

    /* renamed from: com.stepos.common.animator.b$b, reason: collision with other inner class name */
    public class C0345b extends AnimatorListenerAdapter {
        public C0345b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            b.this.mAnimStartTime = SystemClock.uptimeMillis();
        }
    }

    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            b.this.mShader.setFloatUniform("time", (SystemClock.uptimeMillis() - b.this.mAnimStartTime) / 1000.0f);
            if (b.this.f29503P.mCallback != null) {
                b.this.f29503P.mCallback.a();
            }
        }
    }

    public static class d {

        /* renamed from: P, reason: collision with root package name */
        f f29504P = new f();

        public b a() {
            return new b(this.f29504P, null);
        }

        public d b(int i10) {
            this.f29504P.mAnimType = i10;
            return this;
        }

        public d c(e eVar) {
            this.f29504P.mCallback = eVar;
            return this;
        }

        public d d(String[] strArr) {
            this.f29504P.mColors = strArr;
            return this;
        }

        public d e(int i10) {
            this.f29504P.mCornerRadius = i10;
            return this;
        }

        public d f(int i10) {
            this.f29504P.mGlowRadius = i10;
            return this;
        }

        public d g(boolean z10) {
            this.f29504P.mInner = z10;
            return this;
        }

        public d h(float f10) {
            this.f29504P.mIntensity = f10;
            return this;
        }

        public d i(int i10) {
            this.f29504P.mSolidColor = i10;
            return this;
        }
    }

    public interface e {
        void a();
    }

    public static class f {
        int mAnimType = 1;
        e mCallback;
        String[] mColors;
        int mCornerRadius;
        int mGlowRadius;
        boolean mInner;
        float mIntensity;
        int mSolidColor;
    }

    public /* synthetic */ b(f fVar, a aVar) {
        this(fVar);
    }

    public RuntimeShader e() {
        return this.mShader;
    }

    public final void f() {
        ValueAnimator valueAnimator = new ValueAnimator();
        this.mMixtureAnim = valueAnimator;
        valueAnimator.setInterpolator(new LinearInterpolator());
        this.mMixtureAnim.addListener(new C0345b());
        this.mMixtureAnim.addUpdateListener(new c());
        String[] strArr = this.f29503P.mColors;
        if (strArr != null) {
            m(strArr);
        }
        this.mMixtureAnim.setFloatValues(0.0f, 1.0f);
        this.mMixtureAnim.setDuration(5000L);
        this.mMixtureAnim.setRepeatCount(-1);
        this.mMixtureAnim.setRepeatMode(1);
    }

    public final void g() {
        String[] strArr = this.f29503P.mColors;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        ObjectAnimator objectAnimator = this.mMonochromeAnim;
        boolean z10 = objectAnimator != null && objectAnimator.isRunning();
        i();
        String[] strArr2 = this.f29503P.mColors;
        int length = (strArr2.length - 1) * 1000;
        int length2 = strArr2.length;
        int[] iArr = new int[length2];
        int i10 = 0;
        while (true) {
            String[] strArr3 = this.f29503P.mColors;
            if (i10 >= strArr3.length) {
                break;
            }
            iArr[i10] = Color.parseColor(strArr3[i10]);
            i10++;
        }
        Keyframe[] keyframeArr = new Keyframe[length2];
        for (int i11 = 0; i11 < length2; i11++) {
            keyframeArr[i11] = Keyframe.ofInt(i11 / (length2 - 1), iArr[i11]);
        }
        PropertyValuesHolder propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe("monochrome", keyframeArr);
        propertyValuesHolderOfKeyframe.setEvaluator(new ArgbEvaluator());
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, propertyValuesHolderOfKeyframe);
        this.mMonochromeAnim = objectAnimatorOfPropertyValuesHolder;
        objectAnimatorOfPropertyValuesHolder.setDuration(length);
        this.mMonochromeAnim.setRepeatCount(-1);
        this.mMonochromeAnim.setRepeatMode(1);
        this.mMonochromeAnim.addUpdateListener(this.mUpdateListener);
        if (z10) {
            t();
        }
    }

    public boolean h() {
        ValueAnimator valueAnimator = this.mMixtureAnim;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    public void i() {
        ValueAnimator valueAnimator = this.mMixtureAnim;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ObjectAnimator objectAnimator = this.mMonochromeAnim;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public void j(int i10) {
        this.f29503P.mAnimType = i10;
        i();
        if (i10 == 0) {
            g();
        } else {
            f();
        }
    }

    public void k(String[] strArr) {
        this.f29503P.mColors = strArr;
        int[] iArr = new int[strArr.length];
        for (int i10 = 0; i10 < strArr.length; i10++) {
            iArr[i10] = Color.parseColor(strArr[i10]);
        }
        l(iArr);
    }

    public final void l(int[] iArr) {
        if (this.f29503P.mAnimType == 0) {
            g();
        } else {
            this.mShader.setInputShader("glowColors", new LinearGradient(0.0f, 0.0f, 1024.0f, 0.0f, iArr, (float[]) null, Shader.TileMode.CLAMP));
        }
    }

    public final void m(String[] strArr) {
        int[] iArr = new int[strArr.length];
        for (int i10 = 0; i10 < strArr.length; i10++) {
            iArr[i10] = Color.parseColor(strArr[i10]);
        }
        l(iArr);
    }

    public void n(float f10) {
        this.mShader.setFloatUniform("radius", f10);
    }

    public void o(boolean z10) {
        this.mShader.setFloatUniform("inner", z10 ? 1.0f : -1.0f);
    }

    public void p(float f10) {
        this.mShader.setFloatUniform("glowIntensity", f10);
    }

    public void q(int i10) {
        this.mShader.setFloatUniform("glowRadius", i10);
    }

    public void r(float f10, float f11) {
        this.mShader.setFloatUniform(ContentDisposition.Parameters.Size, f10, f11);
    }

    public void s(int i10) {
        this.mShader.setColorUniform("rectColor", i10);
    }

    public void t() {
        ObjectAnimator objectAnimator;
        ValueAnimator valueAnimator;
        if (this.f29503P.mAnimType == 1 && (valueAnimator = this.mMixtureAnim) != null && !valueAnimator.isRunning()) {
            this.mMixtureAnim.start();
        }
        if (this.f29503P.mAnimType != 0 || (objectAnimator = this.mMonochromeAnim) == null || objectAnimator.isRunning()) {
            return;
        }
        this.mMonochromeAnim.start();
    }

    public b(f fVar) {
        RuntimeShader runtimeShader = new RuntimeShader(ShadeBlurEntity.INSTANCE.getRuntimeShader());
        this.mShader = runtimeShader;
        this.mUpdateListener = new a();
        this.f29503P = fVar;
        runtimeShader.setFloatUniform("time", 0.0f);
        runtimeShader.setFloatUniform("glowRadius", fVar.mGlowRadius);
        runtimeShader.setFloatUniform("glowIntensity", fVar.mIntensity);
        runtimeShader.setFloatUniform("inner", fVar.mInner ? 1.0f : -1.0f);
        runtimeShader.setColorUniform("rectColor", fVar.mSolidColor);
        runtimeShader.setFloatUniform("radius", fVar.mCornerRadius);
        if (fVar.mAnimType == 0) {
            g();
        } else {
            f();
        }
    }
}
