package com.airbnb.lottie;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Choreographer;
import android.view.View;
import androidx.appcompat.widget.C0238z;
import com.stepos.alphame.utils.Property;
import f1.AbstractC0557a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class v extends Drawable implements Drawable.Callback, Animatable {

    /* renamed from: a, reason: collision with root package name */
    public final Matrix f4574a = new Matrix();

    /* renamed from: b, reason: collision with root package name */
    public LottieComposition f4575b;

    /* renamed from: c, reason: collision with root package name */
    public final P0.a f4576c;

    /* renamed from: d, reason: collision with root package name */
    public float f4577d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f4578e;

    /* renamed from: f, reason: collision with root package name */
    public I0.a f4579f;

    /* renamed from: g, reason: collision with root package name */
    public String f4580g;

    /* renamed from: h, reason: collision with root package name */
    public C0238z f4581h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f4582i;

    /* renamed from: j, reason: collision with root package name */
    public M0.c f4583j;

    /* renamed from: k, reason: collision with root package name */
    public int f4584k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f4585l;

    public v() {
        P0.a aVar = new P0.a();
        this.f4576c = aVar;
        this.f4577d = 1.0f;
        new HashSet();
        this.f4578e = new ArrayList();
        this.f4584k = 255;
        aVar.addUpdateListener(new q(0, this));
    }

    public final void a(J0.e eVar, Object obj, Q0.b bVar) {
        if (this.f4583j == null) {
            this.f4578e.add(new p(this, eVar, obj, bVar));
            return;
        }
        J0.f fVar = eVar.f873b;
        if (fVar != null) {
            fVar.f(obj, bVar);
        } else {
            List listF = f(eVar);
            for (int i4 = 0; i4 < listF.size(); i4++) {
                ((J0.e) listF.get(i4)).f873b.f(obj, bVar);
            }
            if (!(!listF.isEmpty())) {
                return;
            }
        }
        invalidateSelf();
        if (obj == z.f4606s) {
            n(this.f4576c.c());
        }
    }

    public final void b() {
        LottieComposition lottieComposition = this.f4575b;
        Rect bounds = lottieComposition.getBounds();
        this.f4583j = new M0.c(this, new M0.e(Collections.emptyList(), lottieComposition, "__container", -1L, 1, -1L, null, Collections.emptyList(), new K0.c(new stepos.support.v7.app.palette.b(2), new stepos.support.v7.app.palette.b(2), new K0.a(4), new K0.b(), new K0.a(2), new K0.b(), new K0.b()), 0, 0, 0, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, bounds.width(), bounds.height(), null, null, Collections.emptyList(), 1, null), this.f4575b.getLayers(), this.f4575b);
    }

    public final void c() {
        I0.a aVar = this.f4579f;
        if (aVar != null) {
            aVar.b();
        }
        P0.a aVar2 = this.f4576c;
        if (aVar2.f1556k) {
            aVar2.cancel();
        }
        this.f4575b = null;
        this.f4583j = null;
        this.f4579f = null;
        aVar2.f1555j = null;
        aVar2.f1553h = -2.1474836E9f;
        aVar2.f1554i = 2.1474836E9f;
        invalidateSelf();
    }

    public final I0.a d() {
        if (getCallback() == null) {
            return null;
        }
        I0.a aVar = this.f4579f;
        if (aVar != null) {
            Drawable.Callback callback = getCallback();
            Context context = (callback != null && (callback instanceof View)) ? ((View) callback).getContext() : null;
            Context context2 = aVar.f832a;
            if ((context != null || context2 != null) && !context2.equals(context)) {
                this.f4579f.b();
                this.f4579f = null;
            }
        }
        if (this.f4579f == null) {
            this.f4579f = new I0.a(getCallback(), this.f4580g, this.f4575b.getImages());
        }
        return this.f4579f;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        float f4;
        HashSet hashSet = AbstractC0398c.f4541a;
        if (this.f4583j == null) {
            return;
        }
        float f5 = this.f4577d;
        float fMin = Math.min(canvas.getWidth() / this.f4575b.getBounds().width(), canvas.getHeight() / this.f4575b.getBounds().height());
        if (f5 > fMin) {
            f4 = this.f4577d / fMin;
        } else {
            fMin = f5;
            f4 = 1.0f;
        }
        if (f4 > 1.0f) {
            canvas.save();
            float fWidth = this.f4575b.getBounds().width() / 2.0f;
            float fHeight = this.f4575b.getBounds().height() / 2.0f;
            float f6 = fWidth * fMin;
            float f7 = fHeight * fMin;
            float f8 = this.f4577d;
            canvas.translate((fWidth * f8) - f6, (f8 * fHeight) - f7);
            canvas.scale(f4, f4, f6, f7);
        }
        Matrix matrix = this.f4574a;
        matrix.reset();
        matrix.preScale(fMin, fMin);
        this.f4583j.d(canvas, matrix, this.f4584k);
        AbstractC0398c.a();
        if (f4 > 1.0f) {
            canvas.restore();
        }
    }

    public final void e() {
        if (this.f4583j == null) {
            this.f4578e.add(new r(this));
            return;
        }
        P0.a aVar = this.f4576c;
        aVar.f1556k = true;
        boolean zG = aVar.g();
        Iterator it = aVar.f1547b.iterator();
        while (it.hasNext()) {
            ((Animator.AnimatorListener) it.next()).onAnimationStart(aVar, zG);
        }
        aVar.n((int) (aVar.g() ? aVar.d() : aVar.e()));
        aVar.f1550e = System.nanoTime();
        aVar.f1552g = 0;
        if (aVar.f1556k) {
            aVar.j(false);
            Choreographer.getInstance().postFrameCallback(aVar);
        }
    }

    public final List f(J0.e eVar) {
        if (this.f4583j == null) {
            Log.w("LOTTIE", "Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.f4583j.g(eVar, 0, arrayList, new J0.e(new String[0]));
        return arrayList;
    }

    public final void g(int i4) {
        if (this.f4575b == null) {
            this.f4578e.add(new n(this, i4, 0));
        } else {
            this.f4576c.n(i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f4584k;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        if (this.f4575b == null) {
            return -1;
        }
        return (int) (r0.getBounds().height() * this.f4577d);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        if (this.f4575b == null) {
            return -1;
        }
        return (int) (r0.getBounds().width() * this.f4577d);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public final void h(int i4) {
        if (this.f4575b == null) {
            this.f4578e.add(new n(this, i4, 2));
        } else {
            P0.a aVar = this.f4576c;
            aVar.p((int) aVar.f1553h, i4);
        }
    }

    public final void i(float f4) {
        LottieComposition lottieComposition = this.f4575b;
        if (lottieComposition == null) {
            this.f4578e.add(new o(this, f4, 2));
        } else {
            h((int) AbstractC0557a.M(lottieComposition.getStartFrame(), this.f4575b.getEndFrame(), f4));
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.f4576c.f1556k;
    }

    public final void j(int i4, int i5) {
        if (this.f4575b == null) {
            this.f4578e.add(new s(this, i4, i5));
        } else {
            this.f4576c.p(i4, i5);
        }
    }

    public final void k(float f4, float f5) {
        LottieComposition lottieComposition = this.f4575b;
        if (lottieComposition == null) {
            this.f4578e.add(new t(this, f4, f5));
        } else {
            j((int) AbstractC0557a.M(lottieComposition.getStartFrame(), this.f4575b.getEndFrame(), f4), (int) AbstractC0557a.M(this.f4575b.getStartFrame(), this.f4575b.getEndFrame(), f5));
        }
    }

    public final void l(int i4) {
        if (this.f4575b == null) {
            this.f4578e.add(new n(this, i4, 1));
        } else {
            P0.a aVar = this.f4576c;
            aVar.p(i4, (int) aVar.f1554i);
        }
    }

    public final void m(float f4) {
        LottieComposition lottieComposition = this.f4575b;
        if (lottieComposition == null) {
            this.f4578e.add(new o(this, f4, 1));
        } else {
            l((int) AbstractC0557a.M(lottieComposition.getStartFrame(), this.f4575b.getEndFrame(), f4));
        }
    }

    public final void n(float f4) {
        LottieComposition lottieComposition = this.f4575b;
        if (lottieComposition == null) {
            this.f4578e.add(new o(this, f4, 0));
        } else {
            g((int) AbstractC0557a.M(lottieComposition.getStartFrame(), this.f4575b.getEndFrame(), f4));
        }
    }

    public final void o() {
        if (this.f4575b == null) {
            return;
        }
        float f4 = this.f4577d;
        setBounds(0, 0, (int) (r0.getBounds().width() * f4), (int) (this.f4575b.getBounds().height() * f4));
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j4) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j4);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i4) {
        this.f4584k = i4;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Log.w("LOTTIE", "Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        e();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.f4578e.clear();
        P0.a aVar = this.f4576c;
        aVar.j(true);
        boolean zG = aVar.g();
        Iterator it = aVar.f1547b.iterator();
        while (it.hasNext()) {
            ((Animator.AnimatorListener) it.next()).onAnimationEnd(aVar, zG);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }
}
