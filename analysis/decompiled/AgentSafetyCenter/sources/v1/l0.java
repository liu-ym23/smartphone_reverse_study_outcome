package v1;

import android.view.Choreographer;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l0 implements Choreographer.FrameCallback, Runnable {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ m0 f14488c;

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j10) {
        this.f14488c.f14495g.removeCallbacks(this);
        m0.Q(this.f14488c);
        m0 m0Var = this.f14488c;
        synchronized (m0Var.f14496h) {
            if (m0Var.f14500m) {
                m0Var.f14500m = false;
                ArrayList arrayList = m0Var.f14497j;
                m0Var.f14497j = m0Var.f14498k;
                m0Var.f14498k = arrayList;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((Choreographer.FrameCallback) arrayList.get(i)).doFrame(j10);
                }
                arrayList.clear();
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        m0.Q(this.f14488c);
        m0 m0Var = this.f14488c;
        synchronized (m0Var.f14496h) {
            if (m0Var.f14497j.isEmpty()) {
                m0Var.f14494f.removeFrameCallback(this);
                m0Var.f14500m = false;
            }
        }
    }
}
