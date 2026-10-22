package com.baidu.platform.comapi.map.c0;

import android.util.Pair;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.baidu.platform.comapi.JNIInitializer;
import com.baidu.platform.comapi.map.c0.a;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private VelocityTracker f9085a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9086b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9087c;

    public d() {
        if (JNIInitializer.getCachedContext() == null) {
            this.f9087c = ViewConfiguration.getMinimumFlingVelocity();
            this.f9086b = ViewConfiguration.getMaximumFlingVelocity();
            return;
        }
        ViewConfiguration viewConfiguration = ViewConfiguration.get(JNIInitializer.getCachedContext());
        if (viewConfiguration == null) {
            this.f9087c = ViewConfiguration.getMinimumFlingVelocity();
            this.f9086b = ViewConfiguration.getMaximumFlingVelocity();
        } else {
            this.f9087c = viewConfiguration.getScaledMinimumFlingVelocity();
            this.f9086b = viewConfiguration.getScaledMaximumFlingVelocity();
        }
    }

    public void a() {
        VelocityTracker velocityTracker = this.f9085a;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f9085a = null;
        }
    }

    public void b() {
        this.f9085a = VelocityTracker.obtain();
    }

    public Pair<a.d, a.d> c() {
        VelocityTracker velocityTracker = this.f9085a;
        if (velocityTracker == null) {
            return new Pair<>(new a.d(0.0d, 0.0d), new a.d(0.0d, 0.0d));
        }
        velocityTracker.computeCurrentVelocity(1000, this.f9086b);
        return new Pair<>(new a.d(this.f9085a.getXVelocity(0), this.f9085a.getYVelocity(0)), new a.d(this.f9085a.getXVelocity(1), this.f9085a.getYVelocity(1)));
    }

    public void a(MotionEvent motionEvent) {
        VelocityTracker velocityTracker = this.f9085a;
        if (velocityTracker == null) {
            this.f9085a = VelocityTracker.obtain();
        } else {
            velocityTracker.addMovement(motionEvent);
        }
    }
}
