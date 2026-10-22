package h1;

import android.animation.ValueAnimator;
import android.os.Build;
import android.util.AndroidRuntimeException;
import h1.a;
import h1.a.c;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f extends d<f> {

    /* renamed from: t, reason: collision with root package name */
    public g f9241t;

    /* renamed from: u, reason: collision with root package name */
    public float f9242u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f9243v;

    public f(e eVar) {
        super(eVar);
        this.f9241t = null;
        this.f9242u = Float.MAX_VALUE;
        this.f9243v = false;
    }

    public final void f() {
        if (!d.d().a()) {
            throw new AndroidRuntimeException("Animations may only be canceled from the same thread as the animation handler");
        }
        if (this.f9232f) {
            c(true);
        }
        float f8 = this.f9242u;
        if (f8 != Float.MAX_VALUE) {
            g gVar = this.f9241t;
            if (gVar == null) {
                this.f9241t = new g(f8);
            } else {
                gVar.f9251i = f8;
            }
            this.f9242u = Float.MAX_VALUE;
        }
    }

    public final void g() {
        if (this.f9241t.f9245b <= 0.0d) {
            throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
        }
        if (!d.d().a()) {
            throw new AndroidRuntimeException("Animations may only be started on the same thread as the animation handler");
        }
        if (this.f9232f) {
            this.f9243v = true;
        }
    }

    /* JADX WARN: Type inference failed for: r2v8, types: [android.animation.ValueAnimator$DurationScaleChangeListener, h1.b] */
    public final void h() {
        g gVar = this.f9241t;
        if (gVar == null) {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
        double d8 = (float) gVar.f9251i;
        if (d8 > Float.MAX_VALUE) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        float f8 = this.f9233g;
        if (d8 < f8) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        }
        double dAbs = Math.abs(this.f9234i * 0.75f);
        gVar.f9247d = dAbs;
        gVar.f9248e = dAbs * 62.5d;
        if (!d.d().a()) {
            throw new AndroidRuntimeException("Animations may only be started on the same thread as the animation handler");
        }
        boolean z = this.f9232f;
        if (z || z) {
            return;
        }
        this.f9232f = true;
        if (!this.f9229c) {
            this.f9228b = this.f9231e.f(this.f9230d);
        }
        float f9 = this.f9228b;
        if (f9 > Float.MAX_VALUE || f9 < f8) {
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
        a aVarD = d.d();
        ArrayList<a.b> arrayList = aVarD.f9207b;
        if (arrayList.size() == 0) {
            aVarD.f9210e.f9216a.postFrameCallback(new c(aVarD.f9209d));
            if (Build.VERSION.SDK_INT >= 33) {
                aVarD.f9212g = ValueAnimator.getDurationScale();
                if (aVarD.h == null) {
                    aVarD.h = aVarD.new c();
                }
                final a.c cVar = aVarD.h;
                if (cVar.f9214a == null) {
                    ?? r22 = new ValueAnimator.DurationScaleChangeListener() { // from class: h1.b
                        @Override // android.animation.ValueAnimator.DurationScaleChangeListener
                        public final void onChanged(float f10) {
                            a.this.f9212g = f10;
                        }
                    };
                    cVar.f9214a = r22;
                    ValueAnimator.registerDurationScaleChangeListener(r22);
                }
            }
        }
        if (arrayList.contains(this)) {
            return;
        }
        arrayList.add(this);
    }

    public <K> f(K k9, androidx.datastore.preferences.protobuf.f fVar) {
        super(k9, fVar);
        this.f9241t = null;
        this.f9242u = Float.MAX_VALUE;
        this.f9243v = false;
    }
}
