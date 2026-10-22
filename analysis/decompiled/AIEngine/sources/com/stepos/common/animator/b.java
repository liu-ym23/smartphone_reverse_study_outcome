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
import com.stepos.common.drawble.SurroundShaderDrawable;
import com.stepos.core.common.cloud.FileStorageUploader;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final RuntimeShader f6450a;

    /* renamed from: b, reason: collision with root package name */
    public long f6451b;

    /* renamed from: c, reason: collision with root package name */
    public ValueAnimator f6452c;

    /* renamed from: d, reason: collision with root package name */
    public ObjectAnimator f6453d;

    /* renamed from: e, reason: collision with root package name */
    public final d f6454e;

    /* renamed from: f, reason: collision with root package name */
    public final a f6455f;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            com.google.android.material.button.a aVar = b.this.f6454e.f6465g;
            if (aVar != null) {
                ((SurroundShaderDrawable) aVar.f4761g).invalidateSelf();
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: com.stepos.common.animator.b$b, reason: collision with other inner class name */
    public class C0045b extends AnimatorListenerAdapter {
        public C0045b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            b.this.f6451b = SystemClock.uptimeMillis();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            b bVar = b.this;
            bVar.f6450a.setFloatUniform("time", (jUptimeMillis - bVar.f6451b) / 1000.0f);
            com.google.android.material.button.a aVar = bVar.f6454e.f6465g;
            if (aVar != null) {
                ((SurroundShaderDrawable) aVar.f4761g).invalidateSelf();
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public float f6459a;

        /* renamed from: b, reason: collision with root package name */
        public int f6460b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f6461c;

        /* renamed from: d, reason: collision with root package name */
        public int f6462d;

        /* renamed from: e, reason: collision with root package name */
        public int f6463e;

        /* renamed from: f, reason: collision with root package name */
        public String[] f6464f;

        /* renamed from: g, reason: collision with root package name */
        public com.google.android.material.button.a f6465g;
        public int h;
    }

    public b(d dVar) {
        RuntimeShader runtimeShader = new RuntimeShader(ShadeBlurEntity.INSTANCE.getRuntimeShader());
        this.f6450a = runtimeShader;
        this.f6455f = new a();
        this.f6454e = dVar;
        runtimeShader.setFloatUniform("time", 0.0f);
        runtimeShader.setFloatUniform("glowRadius", dVar.f6462d);
        runtimeShader.setFloatUniform("glowIntensity", dVar.f6459a);
        runtimeShader.setFloatUniform("inner", dVar.f6461c ? 1.0f : -1.0f);
        runtimeShader.setColorUniform("rectColor", dVar.f6460b);
        runtimeShader.setFloatUniform("radius", dVar.f6463e);
        if (dVar.h == 0) {
            b();
        } else {
            a();
        }
    }

    public final void a() {
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f6452c = valueAnimator;
        valueAnimator.setInterpolator(new LinearInterpolator());
        this.f6452c.addListener(new C0045b());
        this.f6452c.addUpdateListener(new c());
        String[] strArr = this.f6454e.f6464f;
        if (strArr != null) {
            int[] iArr = new int[strArr.length];
            for (int i10 = 0; i10 < strArr.length; i10++) {
                iArr[i10] = Color.parseColor(strArr[i10]);
            }
            c(iArr);
        }
        this.f6452c.setFloatValues(0.0f, 1.0f);
        this.f6452c.setDuration(FileStorageUploader.LOG_HEARTBEAT_MS);
        this.f6452c.setRepeatCount(-1);
        this.f6452c.setRepeatMode(1);
    }

    public final void b() {
        d dVar = this.f6454e;
        String[] strArr = dVar.f6464f;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        ObjectAnimator objectAnimator = this.f6453d;
        boolean z = objectAnimator != null && objectAnimator.isRunning();
        ValueAnimator valueAnimator = this.f6452c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.f6453d;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        String[] strArr2 = dVar.f6464f;
        int length = (strArr2.length - 1) * 1000;
        int length2 = strArr2.length;
        int[] iArr = new int[length2];
        int i10 = 0;
        while (true) {
            String[] strArr3 = dVar.f6464f;
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
        this.f6453d = objectAnimatorOfPropertyValuesHolder;
        objectAnimatorOfPropertyValuesHolder.setDuration(length);
        this.f6453d.setRepeatCount(-1);
        this.f6453d.setRepeatMode(1);
        this.f6453d.addUpdateListener(this.f6455f);
        if (z) {
            d();
        }
    }

    public final void c(int[] iArr) {
        if (this.f6454e.h == 0) {
            b();
        } else {
            this.f6450a.setInputShader("glowColors", new LinearGradient(0.0f, 0.0f, 1024.0f, 0.0f, iArr, (float[]) null, Shader.TileMode.CLAMP));
        }
    }

    public final void d() {
        ObjectAnimator objectAnimator;
        ValueAnimator valueAnimator;
        d dVar = this.f6454e;
        if (dVar.h == 1 && (valueAnimator = this.f6452c) != null && !valueAnimator.isRunning()) {
            this.f6452c.start();
        }
        if (dVar.h != 0 || (objectAnimator = this.f6453d) == null || objectAnimator.isRunning()) {
            return;
        }
        this.f6453d.start();
    }
}
