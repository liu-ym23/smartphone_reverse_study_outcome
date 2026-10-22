package r9;

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
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public RuntimeShader f10494a;

    /* renamed from: b, reason: collision with root package name */
    public long f10495b;

    /* renamed from: c, reason: collision with root package name */
    public ValueAnimator f10496c;

    /* renamed from: d, reason: collision with root package name */
    public ObjectAnimator f10497d;

    /* renamed from: e, reason: collision with root package name */
    public c f10498e;

    /* renamed from: f, reason: collision with root package name */
    public b f10499f;

    public final void a() {
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f10496c = valueAnimator;
        valueAnimator.setInterpolator(new LinearInterpolator());
        this.f10496c.addListener(new bb.d(this, 7));
        ValueAnimator valueAnimator2 = this.f10496c;
        b bVar = new b(1);
        bVar.f10485b = this;
        VarHandle.storeStoreFence();
        valueAnimator2.addUpdateListener(bVar);
        String[] strArr = this.f10498e.f10491f;
        if (strArr != null) {
            int[] iArr = new int[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                iArr[i] = Color.parseColor(strArr[i]);
            }
            c(iArr);
        }
        this.f10496c.setFloatValues(0.0f, 1.0f);
        this.f10496c.setDuration(5000L);
        this.f10496c.setRepeatCount(-1);
        this.f10496c.setRepeatMode(1);
    }

    public final void b() {
        c cVar = this.f10498e;
        String[] strArr = cVar.f10491f;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        ObjectAnimator objectAnimator = this.f10497d;
        boolean z10 = objectAnimator != null && objectAnimator.isRunning();
        ValueAnimator valueAnimator = this.f10496c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.f10497d;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        String[] strArr2 = cVar.f10491f;
        int length = (strArr2.length - 1) * 1000;
        int length2 = strArr2.length;
        int[] iArr = new int[length2];
        int i = 0;
        while (true) {
            String[] strArr3 = cVar.f10491f;
            if (i >= strArr3.length) {
                break;
            }
            iArr[i] = Color.parseColor(strArr3[i]);
            i++;
        }
        Keyframe[] keyframeArr = new Keyframe[length2];
        for (int i3 = 0; i3 < length2; i3++) {
            keyframeArr[i3] = Keyframe.ofInt(i3 / (length2 - 1), iArr[i3]);
        }
        PropertyValuesHolder propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe("monochrome", keyframeArr);
        propertyValuesHolderOfKeyframe.setEvaluator(new ArgbEvaluator());
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, propertyValuesHolderOfKeyframe);
        this.f10497d = objectAnimatorOfPropertyValuesHolder;
        objectAnimatorOfPropertyValuesHolder.setDuration(length);
        this.f10497d.setRepeatCount(-1);
        this.f10497d.setRepeatMode(1);
        this.f10497d.addUpdateListener(this.f10499f);
        if (z10) {
            d();
        }
    }

    public final void c(int[] iArr) {
        if (this.f10498e.f10493h == 0) {
            b();
        } else {
            this.f10494a.setInputShader("glowColors", new LinearGradient(0.0f, 0.0f, 1024.0f, 0.0f, iArr, (float[]) null, Shader.TileMode.CLAMP));
        }
    }

    public final void d() {
        ObjectAnimator objectAnimator;
        ValueAnimator valueAnimator;
        c cVar = this.f10498e;
        if (cVar.f10493h == 1 && (valueAnimator = this.f10496c) != null && !valueAnimator.isRunning()) {
            this.f10496c.start();
        }
        if (cVar.f10493h != 0 || (objectAnimator = this.f10497d) == null || objectAnimator.isRunning()) {
            return;
        }
        this.f10497d.start();
    }
}
