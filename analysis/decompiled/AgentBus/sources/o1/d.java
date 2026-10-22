package o1;

import android.graphics.Rect;
import android.os.CancellationSignal;
import android.view.ScrollCaptureCallback;
import android.view.ScrollCaptureSession;
import c1.w;
import ia.d0;
import ia.f1;
import ia.g1;
import ia.r1;
import ia.w1;
import j1.p1;
import j1.y;
import java.util.concurrent.CancellationException;
import java.util.function.Consumer;
import la.a0;
import p1.n;
import u0.z;

/* loaded from: classes.dex */
public final class d implements ScrollCaptureCallback {

    /* renamed from: a, reason: collision with root package name */
    public final n f7201a;

    /* renamed from: b, reason: collision with root package name */
    public final d2.j f7202b;

    /* renamed from: c, reason: collision with root package name */
    public final p1 f7203c;

    /* renamed from: d, reason: collision with root package name */
    public final y f7204d;

    /* renamed from: e, reason: collision with root package name */
    public final na.d f7205e;

    /* renamed from: f, reason: collision with root package name */
    public final h f7206f;

    public d(n nVar, d2.j jVar, na.d dVar, p1 p1Var, y yVar) {
        this.f7201a = nVar;
        this.f7202b = jVar;
        this.f7203c = p1Var;
        this.f7204d = yVar;
        this.f7205e = new na.d(dVar.f6896f.Q(f.f7208f));
        this.f7206f = new h(jVar.f2791d - jVar.f2789b, new c(this, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(o1.d r11, android.view.ScrollCaptureSession r12, d2.j r13, i7.c r14) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.d.a(o1.d, android.view.ScrollCaptureSession, d2.j, i7.c):java.lang.Object");
    }

    public final void onScrollCaptureEnd(Runnable runnable) {
        d0.s(this.f7205e, r1.f4998g, null, new a5.b(this, runnable, null, 20), 2);
    }

    public final void onScrollCaptureImageRequest(ScrollCaptureSession scrollCaptureSession, CancellationSignal cancellationSignal, Rect rect, Consumer consumer) {
        final w1 w1VarS = d0.s(this.f7205e, null, null, new a0(this, scrollCaptureSession, rect, consumer, null, 3), 3);
        w1VarS.t(new w(23, cancellationSignal));
        cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: o1.e
            @Override // android.os.CancellationSignal.OnCancelListener
            public final void onCancel() {
                f1.cancel$default((g1) w1VarS, (CancellationException) null, 1, (Object) null);
            }
        });
    }

    public final void onScrollCaptureSearch(CancellationSignal cancellationSignal, Consumer consumer) {
        consumer.accept(z.n(this.f7202b));
    }

    public final void onScrollCaptureStart(ScrollCaptureSession scrollCaptureSession, CancellationSignal cancellationSignal, Runnable runnable) {
        this.f7206f.f7214c = 0.0f;
        this.f7203c.f5296a.setValue(Boolean.TRUE);
        runnable.run();
    }
}
