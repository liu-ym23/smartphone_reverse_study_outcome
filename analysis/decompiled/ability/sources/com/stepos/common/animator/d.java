package com.stepos.common.animator;

import android.animation.ArgbEvaluator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.RuntimeShader;
import android.graphics.Shader;
import android.view.animation.LinearInterpolator;
import com.stepos.common.drawble.ShadeBlurEntity;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final RuntimeShader f3562a;
    public long b;
    public ValueAnimator c;
    public ObjectAnimator d;
    public final c e;
    public final b f;

    public d(c cVar) {
        RuntimeShader runtimeShader = new RuntimeShader(ShadeBlurEntity.INSTANCE.getRuntimeShader());
        this.f3562a = runtimeShader;
        this.f = new b(this, 0);
        this.e = cVar;
        runtimeShader.setFloatUniform("time", 0.0f);
        runtimeShader.setFloatUniform("glowRadius", cVar.d);
        runtimeShader.setFloatUniform("glowIntensity", cVar.f3561a);
        runtimeShader.setFloatUniform("inner", cVar.c ? 1.0f : -1.0f);
        runtimeShader.setColorUniform("rectColor", cVar.b);
        runtimeShader.setFloatUniform("radius", cVar.e);
        if (cVar.h == 0) {
            b();
        } else {
            a();
        }
    }

    public final void a() {
        ValueAnimator valueAnimator = new ValueAnimator();
        this.c = valueAnimator;
        valueAnimator.setInterpolator(new LinearInterpolator());
        this.c.addListener(new A6.m(this, 7));
        this.c.addUpdateListener(new b(this, 1));
        String[] strArr = this.e.f;
        if (strArr != null) {
            int[] iArr = new int[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                iArr[i] = Color.parseColor(strArr[i]);
            }
            c(iArr);
        }
        this.c.setFloatValues(0.0f, 1.0f);
        this.c.setDuration(5000L);
        this.c.setRepeatCount(-1);
        this.c.setRepeatMode(1);
    }

    public final void b() {
        c cVar = this.e;
        String[] strArr = cVar.f;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        ObjectAnimator objectAnimator = this.d;
        boolean z10 = objectAnimator != null && objectAnimator.isRunning();
        ValueAnimator valueAnimator = this.c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.d;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        String[] strArr2 = cVar.f;
        int length = (strArr2.length - 1) * 1000;
        int length2 = strArr2.length;
        int[] iArr = new int[length2];
        int i = 0;
        while (true) {
            String[] strArr3 = cVar.f;
            if (i >= strArr3.length) {
                break;
            }
            iArr[i] = Color.parseColor(strArr3[i]);
            i++;
        }
        Keyframe[] keyframeArr = new Keyframe[length2];
        for (int i6 = 0; i6 < length2; i6++) {
            keyframeArr[i6] = Keyframe.ofInt(i6 / (length2 - 1), iArr[i6]);
        }
        PropertyValuesHolder propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe("monochrome", keyframeArr);
        propertyValuesHolderOfKeyframe.setEvaluator(new ArgbEvaluator());
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, propertyValuesHolderOfKeyframe);
        this.d = objectAnimatorOfPropertyValuesHolder;
        objectAnimatorOfPropertyValuesHolder.setDuration(length);
        this.d.setRepeatCount(-1);
        this.d.setRepeatMode(1);
        this.d.addUpdateListener(this.f);
        if (z10) {
            d();
        }
    }

    public final void c(int[] iArr) {
        if (this.e.h == 0) {
            b();
        } else {
            this.f3562a.setInputShader("glowColors", new LinearGradient(0.0f, 0.0f, 1024.0f, 0.0f, iArr, (float[]) null, Shader.TileMode.CLAMP));
        }
    }

    public final void d() {
        ObjectAnimator objectAnimator;
        ValueAnimator valueAnimator;
        c cVar = this.e;
        if (cVar.h == 1 && (valueAnimator = this.c) != null && !valueAnimator.isRunning()) {
            this.c.start();
        }
        if (cVar.h != 0 || (objectAnimator = this.d) == null || objectAnimator.isRunning()) {
            return;
        }
        this.d.start();
    }
}
