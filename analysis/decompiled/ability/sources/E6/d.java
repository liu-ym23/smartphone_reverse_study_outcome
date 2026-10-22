package E6;

import C7.r;
import S7.k;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final View f479a;
    public int b = -1;
    public boolean c;
    public float d;
    public float e;
    public boolean f;
    public float g;
    public float h;
    public long i;

    /* renamed from: j, reason: collision with root package name */
    public float f480j;
    public float k;
    public float l;
    public float m;
    public float n;
    public final FloatValueHolder o;
    public final FloatValueHolder p;

    /* renamed from: q, reason: collision with root package name */
    public final FloatValueHolder f481q;

    /* renamed from: r, reason: collision with root package name */
    public final SpringAnimation f482r;

    /* renamed from: s, reason: collision with root package name */
    public final SpringAnimation f483s;

    /* renamed from: t, reason: collision with root package name */
    public final SpringAnimation f484t;

    public d(View view) {
        this.f479a = view;
        FloatValueHolder floatValueHolder = new FloatValueHolder(0.0f);
        this.o = floatValueHolder;
        FloatValueHolder floatValueHolder2 = new FloatValueHolder(0.0f);
        this.p = floatValueHolder2;
        FloatValueHolder floatValueHolder3 = new FloatValueHolder(0.0f);
        this.f481q = floatValueHolder3;
        final int i = 0;
        this.f482r = c.b(floatValueHolder, 320.0f, 0.001f, new k(this) { // from class: E6.a
            public final /* synthetic */ d b;

            {
                this.b = this;
            }

            @Override // S7.k
            public final Object invoke(Object obj) {
                int i6 = i;
                float fFloatValue = ((Float) obj).floatValue();
                switch (i6) {
                    case 0:
                        d dVar = this.b;
                        dVar.l = fFloatValue;
                        dVar.b();
                        break;
                    case 1:
                        d dVar2 = this.b;
                        dVar2.m = fFloatValue;
                        dVar2.b();
                        break;
                    default:
                        d dVar3 = this.b;
                        dVar3.n = fFloatValue;
                        dVar3.b();
                        break;
                }
                return r.f317a;
            }
        });
        final int i6 = 1;
        this.f483s = c.b(floatValueHolder2, 300.0f, 0.5f, new k(this) { // from class: E6.a
            public final /* synthetic */ d b;

            {
                this.b = this;
            }

            @Override // S7.k
            public final Object invoke(Object obj) {
                int i62 = i6;
                float fFloatValue = ((Float) obj).floatValue();
                switch (i62) {
                    case 0:
                        d dVar = this.b;
                        dVar.l = fFloatValue;
                        dVar.b();
                        break;
                    case 1:
                        d dVar2 = this.b;
                        dVar2.m = fFloatValue;
                        dVar2.b();
                        break;
                    default:
                        d dVar3 = this.b;
                        dVar3.n = fFloatValue;
                        dVar3.b();
                        break;
                }
                return r.f317a;
            }
        });
        final int i10 = 2;
        this.f484t = c.b(floatValueHolder3, 300.0f, 0.5f, new k(this) { // from class: E6.a
            public final /* synthetic */ d b;

            {
                this.b = this;
            }

            @Override // S7.k
            public final Object invoke(Object obj) {
                int i62 = i10;
                float fFloatValue = ((Float) obj).floatValue();
                switch (i62) {
                    case 0:
                        d dVar = this.b;
                        dVar.l = fFloatValue;
                        dVar.b();
                        break;
                    case 1:
                        d dVar2 = this.b;
                        dVar2.m = fFloatValue;
                        dVar2.b();
                        break;
                    default:
                        d dVar3 = this.b;
                        dVar3.n = fFloatValue;
                        dVar3.b();
                        break;
                }
                return r.f317a;
            }
        });
    }

    public final void a() {
        ViewParent parent = this.f479a.getParent();
        for (int i = 0; (parent instanceof ViewGroup) && i < 2; i++) {
            ViewGroup viewGroup = (ViewGroup) parent;
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
            parent = viewGroup.getParent();
        }
    }

    public final void b() {
        View view = this.f479a;
        if (view.getWidth() <= 0 || view.getHeight() <= 0) {
            return;
        }
        if (!this.c && Math.abs(this.l) < 5.0E-4f && Math.abs(this.m) < 0.05f && Math.abs(this.n) < 0.05f) {
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            return;
        }
        float f = view.getResources().getDisplayMetrics().density;
        float f7 = 60.0f * f;
        float f9 = f * 40.0f;
        float f10 = (this.l * 0.049999952f) + 1.0f;
        float fA = c.a(Math.abs(this.m), f7) * 0.3f;
        float fA2 = c.a(Math.abs(this.n), f7) * 0.3f;
        view.setPivotX(view.getWidth() / 2.0f);
        view.setPivotY(view.getHeight() / 2.0f);
        view.setScaleX((1.0f - (fA2 * 0.8f)) * (fA + 1.0f) * f10);
        view.setScaleY((1.0f - (fA * 0.8f)) * (fA2 + 1.0f) * f10);
        float fHypot = (float) Math.hypot(this.m, this.n);
        if (fHypot < 1.0E-4f || f9 <= 0.0f) {
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
        } else {
            float fExp = (1.0f - ((float) Math.exp((-fHypot) / f9))) * f9;
            view.setTranslationX((this.m / fHypot) * fExp);
            view.setTranslationY((this.n / fHypot) * fExp);
        }
    }

    public final void c() {
        if (this.c || this.b != -1) {
            this.c = false;
            this.f = false;
            this.b = -1;
            ViewParent parent = this.f479a.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(false);
            }
            this.o.setValue(this.l);
            this.f482r.animateToFinalPosition(0.0f);
            float f = this.m;
            float f7 = this.f480j;
            SpringAnimation springAnimation = this.f483s;
            springAnimation.cancel();
            this.p.setValue(f);
            springAnimation.setStartVelocity(f7 * 0.45f);
            springAnimation.animateToFinalPosition(0.0f);
            float f9 = this.n;
            float f10 = this.k;
            SpringAnimation springAnimation2 = this.f484t;
            springAnimation2.cancel();
            this.f481q.setValue(f9);
            springAnimation2.setStartVelocity(f10 * 0.45f);
            springAnimation2.animateToFinalPosition(0.0f);
            this.f480j = 0.0f;
            this.k = 0.0f;
        }
    }

    public final void d(MotionEvent motionEvent) {
        int iFindPointerIndex;
        int actionMasked = motionEvent.getActionMasked();
        SpringAnimation springAnimation = this.f484t;
        SpringAnimation springAnimation2 = this.f483s;
        if (actionMasked == 0) {
            this.b = motionEvent.getPointerId(0);
            this.c = true;
            this.d = motionEvent.getRawX();
            this.e = motionEvent.getRawY();
            this.f = false;
            this.i = motionEvent.getEventTime();
            this.f480j = 0.0f;
            this.k = 0.0f;
            ViewParent parent = this.f479a.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            springAnimation2.cancel();
            springAnimation.cancel();
            this.o.setValue(this.l);
            this.f482r.animateToFinalPosition(1.0f);
            return;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                if (this.c && (iFindPointerIndex = motionEvent.findPointerIndex(this.b)) >= 0) {
                    float rawX = (motionEvent.getRawX(iFindPointerIndex) - this.d) * 0.1f;
                    float rawY = (motionEvent.getRawY(iFindPointerIndex) - this.e) * 0.1f;
                    if (this.f) {
                        long eventTime = motionEvent.getEventTime() - this.i;
                        if (eventTime < 1) {
                            eventTime = 1;
                        }
                        float f = eventTime / 1000.0f;
                        this.f480j = (rawX - this.g) / f;
                        this.k = (rawY - this.h) / f;
                    } else {
                        this.f = true;
                        this.f480j = 0.0f;
                        this.k = 0.0f;
                    }
                    this.g = rawX;
                    this.h = rawY;
                    this.i = motionEvent.getEventTime();
                    springAnimation2.cancel();
                    springAnimation.cancel();
                    this.m = rawX;
                    this.n = rawY;
                    this.p.setValue(rawX);
                    this.f481q.setValue(rawY);
                    b();
                    return;
                }
                return;
            }
            if (actionMasked != 3) {
                if (actionMasked == 6 && motionEvent.getPointerId(motionEvent.getActionIndex()) == this.b) {
                    c();
                    return;
                }
                return;
            }
        }
        c();
    }

    public final void e() {
        this.c = false;
        this.f = false;
        this.b = -1;
        this.f482r.cancel();
        this.f483s.cancel();
        this.f484t.cancel();
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = 0.0f;
        this.f480j = 0.0f;
        this.k = 0.0f;
        this.o.setValue(0.0f);
        this.p.setValue(0.0f);
        this.f481q.setValue(0.0f);
        View view = this.f479a;
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }
}
