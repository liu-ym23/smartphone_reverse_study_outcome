package j1;

import android.view.Choreographer;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class r0 implements Choreographer.FrameCallback, Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ s0 f5309f;

    public r0(s0 s0Var) {
        this.f5309f = s0Var;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j2) {
        this.f5309f.f5315i.removeCallbacks(this);
        s0.U(this.f5309f);
        s0 s0Var = this.f5309f;
        synchronized (s0Var.f5316j) {
            if (s0Var.f5321o) {
                s0Var.f5321o = false;
                ArrayList arrayList = s0Var.f5318l;
                s0Var.f5318l = s0Var.f5319m;
                s0Var.f5319m = arrayList;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((Choreographer.FrameCallback) arrayList.get(i2)).doFrame(j2);
                }
                arrayList.clear();
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        s0.U(this.f5309f);
        s0 s0Var = this.f5309f;
        synchronized (s0Var.f5316j) {
            if (s0Var.f5318l.isEmpty()) {
                s0Var.f5314h.removeFrameCallback(this);
                s0Var.f5321o = false;
            }
        }
    }
}
