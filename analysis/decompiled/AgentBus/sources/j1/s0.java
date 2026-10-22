package j1;

import android.os.Handler;
import android.view.Choreographer;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class s0 extends ia.x {

    /* renamed from: r, reason: collision with root package name */
    public static final c7.o f5312r = s7.a.H(l0.f5225m);

    /* renamed from: s, reason: collision with root package name */
    public static final fb.c f5313s = new fb.c(6);

    /* renamed from: h, reason: collision with root package name */
    public final Choreographer f5314h;

    /* renamed from: i, reason: collision with root package name */
    public final Handler f5315i;

    /* renamed from: n, reason: collision with root package name */
    public boolean f5320n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f5321o;

    /* renamed from: q, reason: collision with root package name */
    public final b0.q1 f5323q;

    /* renamed from: j, reason: collision with root package name */
    public final Object f5316j = new Object();

    /* renamed from: k, reason: collision with root package name */
    public final d7.m f5317k = new d7.m();

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f5318l = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f5319m = new ArrayList();

    /* renamed from: p, reason: collision with root package name */
    public final r0 f5322p = new r0(this);

    public s0(Choreographer choreographer, Handler handler) {
        this.f5314h = choreographer;
        this.f5315i = handler;
        this.f5323q = new b0.q1(choreographer, this);
    }

    public static final void U(s0 s0Var) {
        Runnable runnable;
        boolean z4;
        do {
            synchronized (s0Var.f5316j) {
                d7.m mVar = s0Var.f5317k;
                runnable = (Runnable) (mVar.isEmpty() ? null : mVar.removeFirst());
            }
            while (runnable != null) {
                runnable.run();
                synchronized (s0Var.f5316j) {
                    d7.m mVar2 = s0Var.f5317k;
                    runnable = (Runnable) (mVar2.isEmpty() ? null : mVar2.removeFirst());
                }
            }
            synchronized (s0Var.f5316j) {
                if (s0Var.f5317k.isEmpty()) {
                    z4 = false;
                    s0Var.f5320n = false;
                } else {
                    z4 = true;
                }
            }
        } while (z4);
    }

    @Override // ia.x
    public final void R(g7.l lVar, Runnable runnable) {
        synchronized (this.f5316j) {
            this.f5317k.addLast(runnable);
            if (!this.f5320n) {
                this.f5320n = true;
                this.f5315i.post(this.f5322p);
                if (!this.f5321o) {
                    this.f5321o = true;
                    this.f5314h.postFrameCallback(this.f5322p);
                }
            }
        }
    }
}
