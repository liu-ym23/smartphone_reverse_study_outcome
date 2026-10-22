package com.baidu.platform.comapi.map.c0;

import android.util.Pair;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.camera.video.AudioStats;
import com.baidu.platform.comapi.JNIInitializer;

/* JADX INFO: loaded from: classes39.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private VelocityTracker f33190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f33191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f33192c;

    public void a() {
        VelocityTracker r100 = this.f33190a;
        if (r100 == null) goto L6;
        r100.recycle();
        this.f33190a = null;
        return;
    }

    public Pair<a.d, a.d> c() {
        VelocityTracker r100 = this.f33190a;
        if (r100 == null) goto L5;
        r100.computeCurrentVelocity(1000, this.f33191b);
        return new Pair(new a.d(this.f33190a.getXVelocity(0), this.f33190a.getYVelocity(0)), new a.d(this.f33190a.getXVelocity(1), this.f33190a.getYVelocity(1)));
    L5:
        return new Pair(new a.d(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE), new a.d(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE));
    }

    public d() {
        if (JNIInitializer.getCachedContext() != null) goto L5;
        this.f33192c = ViewConfiguration.getMinimumFlingVelocity();
        this.f33191b = ViewConfiguration.getMaximumFlingVelocity();
        return;
    L5:
        ViewConfiguration r100 = ViewConfiguration.get(JNIInitializer.getCachedContext());
        if (r100 != null) goto L8;
        this.f33192c = ViewConfiguration.getMinimumFlingVelocity();
        this.f33191b = ViewConfiguration.getMaximumFlingVelocity();
        return;
    L8:
        this.f33192c = r100.getScaledMinimumFlingVelocity();
        this.f33191b = r100.getScaledMaximumFlingVelocity();
    }

    public void b() {
        this.f33190a = VelocityTracker.obtain();
    }

    public void a(MotionEvent r100) {
        VelocityTracker r101 = this.f33190a;
        if (r101 != null) goto L5;
        this.f33190a = VelocityTracker.obtain();
        return;
    L5:
        r101.addMovement(r100);
    }
}
