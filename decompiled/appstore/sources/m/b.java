package m;

import androidx.constraintlayout.core.motion.utils.StopEngine;
import androidx.constraintlayout.motion.widget.m;
import p001j.i;
import p001j.k;

/* JADX INFO: loaded from: classes.dex */
public class b extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f21998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f21999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public StopEngine f22000c;

    public b() {
        k r10 = new k();
        this.f21998a = r10;
        this.f22000c = r10;
    }

    @Override // androidx.constraintlayout.motion.widget.m
    public float a() {
        return this.f22000c.getVelocity();
    }

    public void b(float r10, float r11, float r12, float r13, float r14, float r15) {
        k r16 = this.f21998a;
        this.f22000c = r16;
        r16.b(r10, r11, r12, r13, r14, r15);
    }

    public boolean c() {
        return this.f22000c.isStopped();
    }

    public void d(float r12, float r13, float r14, float r15, float r16, float r17, float r18, int r19) {
        if (this.f21999b != null) goto L5;
        this.f21999b = new i();
    L5:
        i r10 = this.f21999b;
        this.f22000c = r10;
        r10.b(r12, r13, r14, r15, r16, r17, r18, r19);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r10) {
        return this.f22000c.getInterpolation(r10);
    }
}
