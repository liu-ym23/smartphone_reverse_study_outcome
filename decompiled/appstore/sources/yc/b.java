package yc;

import com.obric.oui.constraintlayout.core.motion.utils.StopEngine;
import com.obric.oui.constraintlayout.motion.widget.m;
import vc.i;
import vc.k;

/* JADX INFO: loaded from: classes4.dex */
public class b extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f26232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f26233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public StopEngine f26234c;

    public b() {
        k r10 = new k();
        this.f26232a = r10;
        this.f26234c = r10;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.m
    public float a() {
        return this.f26234c.getVelocity();
    }

    public void b(float r10, float r11, float r12, float r13, float r14, float r15) {
        k r16 = this.f26232a;
        this.f26234c = r16;
        r16.b(r10, r11, r12, r13, r14, r15);
    }

    public boolean c() {
        return this.f26234c.isStopped();
    }

    public void d(float r12, float r13, float r14, float r15, float r16, float r17, float r18, int r19) {
        if (this.f26233b != null) goto L5;
        this.f26233b = new i();
    L5:
        i r10 = this.f26233b;
        this.f26234c = r10;
        r10.b(r12, r13, r14, r15, r16, r17, r18, r19);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r10) {
        return this.f26234c.getInterpolation(r10);
    }
}
