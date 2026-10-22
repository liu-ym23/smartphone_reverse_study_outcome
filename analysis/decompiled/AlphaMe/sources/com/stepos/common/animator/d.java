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
import androidx.appcompat.widget.C0195d;
import com.stepos.alphame.suggest.AppSuggestStorable;
import com.stepos.alphame.utils.Property;
import com.stepos.common.drawble.ShadeBlurEntity;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final RuntimeShader f11284a;

    /* renamed from: b, reason: collision with root package name */
    public long f11285b;

    /* renamed from: c, reason: collision with root package name */
    public ValueAnimator f11286c;

    /* renamed from: d, reason: collision with root package name */
    public ObjectAnimator f11287d;

    /* renamed from: e, reason: collision with root package name */
    public final c f11288e;

    /* renamed from: f, reason: collision with root package name */
    public final b f11289f;

    public d(c cVar) {
        RuntimeShader runtimeShader = new RuntimeShader(ShadeBlurEntity.INSTANCE.getRuntimeShader());
        this.f11284a = runtimeShader;
        this.f11289f = new b(this, 0);
        this.f11288e = cVar;
        runtimeShader.setFloatUniform(AppSuggestStorable.COLUMN_TIME, Property.DEFAULT_FLOAT_VALUE);
        runtimeShader.setFloatUniform("glowRadius", cVar.f11279d);
        runtimeShader.setFloatUniform("glowIntensity", cVar.f11276a);
        runtimeShader.setFloatUniform("inner", cVar.f11278c ? 1.0f : -1.0f);
        runtimeShader.setColorUniform("rectColor", cVar.f11277b);
        runtimeShader.setFloatUniform("radius", cVar.f11280e);
        if (cVar.f11283h == 0) {
            b();
        } else {
            a();
        }
    }

    public final void a() {
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f11286c = valueAnimator;
        valueAnimator.setInterpolator(new LinearInterpolator());
        this.f11286c.addListener(new C0195d(10, this));
        this.f11286c.addUpdateListener(new b(this, 1));
        String[] strArr = this.f11288e.f11281f;
        if (strArr != null) {
            int[] iArr = new int[strArr.length];
            for (int i4 = 0; i4 < strArr.length; i4++) {
                iArr[i4] = Color.parseColor(strArr[i4]);
            }
            c(iArr);
        }
        this.f11286c.setFloatValues(Property.DEFAULT_FLOAT_VALUE, 1.0f);
        this.f11286c.setDuration(5000L);
        this.f11286c.setRepeatCount(-1);
        this.f11286c.setRepeatMode(1);
    }

    public final void b() {
        c cVar = this.f11288e;
        String[] strArr = cVar.f11281f;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        ObjectAnimator objectAnimator = this.f11287d;
        boolean z4 = objectAnimator != null && objectAnimator.isRunning();
        ValueAnimator valueAnimator = this.f11286c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.f11287d;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        String[] strArr2 = cVar.f11281f;
        int length = (strArr2.length - 1) * 1000;
        int length2 = strArr2.length;
        int[] iArr = new int[length2];
        int i4 = 0;
        while (true) {
            String[] strArr3 = cVar.f11281f;
            if (i4 >= strArr3.length) {
                break;
            }
            iArr[i4] = Color.parseColor(strArr3[i4]);
            i4++;
        }
        Keyframe[] keyframeArr = new Keyframe[length2];
        for (int i5 = 0; i5 < length2; i5++) {
            keyframeArr[i5] = Keyframe.ofInt(i5 / (length2 - 1), iArr[i5]);
        }
        PropertyValuesHolder propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe("monochrome", keyframeArr);
        propertyValuesHolderOfKeyframe.setEvaluator(new ArgbEvaluator());
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, propertyValuesHolderOfKeyframe);
        this.f11287d = objectAnimatorOfPropertyValuesHolder;
        objectAnimatorOfPropertyValuesHolder.setDuration(length);
        this.f11287d.setRepeatCount(-1);
        this.f11287d.setRepeatMode(1);
        this.f11287d.addUpdateListener(this.f11289f);
        if (z4) {
            d();
        }
    }

    public final void c(int[] iArr) {
        if (this.f11288e.f11283h == 0) {
            b();
        } else {
            this.f11284a.setInputShader("glowColors", new LinearGradient(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, 1024.0f, Property.DEFAULT_FLOAT_VALUE, iArr, (float[]) null, Shader.TileMode.CLAMP));
        }
    }

    public final void d() {
        ObjectAnimator objectAnimator;
        ValueAnimator valueAnimator;
        c cVar = this.f11288e;
        if (cVar.f11283h == 1 && (valueAnimator = this.f11286c) != null && !valueAnimator.isRunning()) {
            this.f11286c.start();
        }
        if (cVar.f11283h != 0 || (objectAnimator = this.f11287d) == null || objectAnimator.isRunning()) {
            return;
        }
        this.f11287d.start();
    }
}
