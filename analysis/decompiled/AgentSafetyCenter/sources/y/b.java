package y;

import android.view.Choreographer;
import android.view.View;
import java.lang.invoke.VarHandle;
import k0.a2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements a2, Runnable, Choreographer.FrameCallback {

    /* renamed from: k, reason: collision with root package name */
    public static long f15722k;

    /* renamed from: c, reason: collision with root package name */
    public View f15723c;

    /* renamed from: f, reason: collision with root package name */
    public m0.e f15724f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f15725g;

    /* renamed from: h, reason: collision with root package name */
    public Choreographer f15726h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public long f15727j;

    @Override // k0.a2
    public final void b() {
        this.i = false;
        this.f15723c.removeCallbacks(this);
        this.f15726h.removeFrameCallback(this);
    }

    @Override // k0.a2
    public final void c() {
        this.i = true;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j10) {
        if (this.i) {
            this.f15727j = j10;
            this.f15723c.post(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        m0.e eVar = this.f15724f;
        if (eVar.f8160g == 0 || !this.f15725g || !this.i || this.f15723c.getWindowVisibility() != 0) {
            this.f15725g = false;
            return;
        }
        long j10 = this.f15727j + f15722k;
        a aVar = new a();
        aVar.f15719a = j10;
        VarHandle.storeStoreFence();
        boolean z10 = false;
        while (eVar.f8160g != 0 && !z10) {
            if (aVar.a() <= 0 || ((n0) eVar.f8158c[0]).b(aVar)) {
                z10 = true;
            } else {
                eVar.k(0);
            }
        }
        if (z10) {
            this.f15726h.postFrameCallback(this);
        } else {
            this.f15725g = false;
        }
    }

    @Override // k0.a2
    public final void a() {
    }
}
