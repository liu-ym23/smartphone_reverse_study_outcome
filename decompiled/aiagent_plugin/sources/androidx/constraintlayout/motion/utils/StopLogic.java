package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.a.a.a.k;
import androidx.constraintlayout.a.a.a.m;
import androidx.constraintlayout.a.a.a.n;
import androidx.constraintlayout.motion.widget.MotionInterpolator;

/* JADX INFO: loaded from: classes.dex */
public class StopLogic extends MotionInterpolator {
    private m mEngine;
    private k mSpringStopEngine;
    private n mStopLogicEngine;

    public StopLogic() {
        n r0 = new n();
        this.mStopLogicEngine = r0;
        this.mEngine = r0;
    }

    public String debug(String r1, float r2) {
        return this.mEngine.a(r1, r2);
    }

    public float getVelocity(float r1) {
        return this.mEngine.a(r1);
    }

    public void config(float r8, float r9, float r10, float r11, float r12, float r13) {
        n r0 = this.mStopLogicEngine;
        this.mEngine = r0;
        r0.a(r8, r9, r10, r11, r12, r13);
    }

    public void springConfig(float r12, float r13, float r14, float r15, float r16, float r17, float r18, int r19) {
        if (this.mSpringStopEngine != null) goto L5;
        this.mSpringStopEngine = new k();
    L5:
        k r2 = this.mSpringStopEngine;
        this.mEngine = r2;
        r2.a(r12, r13, r14, r15, r16, r17, r18, r19);
    }

    @Override // androidx.constraintlayout.motion.widget.MotionInterpolator, android.animation.TimeInterpolator
    public float getInterpolation(float r1) {
        return this.mEngine.b(r1);
    }

    @Override // androidx.constraintlayout.motion.widget.MotionInterpolator
    public float getVelocity() {
        return this.mEngine.a();
    }

    public boolean isStopped() {
        return this.mEngine.b();
    }
}
