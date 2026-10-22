package z1;

import a2.p;
import android.graphics.Rect;
import android.os.CancellationSignal;
import android.view.ScrollCaptureCallback;
import android.view.ScrollCaptureSession;
import androidx.lifecycle.i0;
import d1.f0;
import java.lang.invoke.VarHandle;
import java.util.function.Consumer;
import kc.h1;
import kc.w;
import kc.z;
import v1.k1;
import v1.t;
import y.a0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d implements ScrollCaptureCallback {

    /* renamed from: a, reason: collision with root package name */
    public p f16159a;

    /* renamed from: b, reason: collision with root package name */
    public o2.j f16160b;

    /* renamed from: c, reason: collision with root package name */
    public k1 f16161c;

    /* renamed from: d, reason: collision with root package name */
    public t f16162d;

    /* renamed from: e, reason: collision with root package name */
    public pc.c f16163e;

    /* renamed from: f, reason: collision with root package name */
    public h f16164f;

    /* JADX WARN: Removed duplicated region for block: B:44:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(z1.d r11, android.view.ScrollCaptureSession r12, o2.j r13, pb.c r14) {
        /*
            Method dump skipped, instructions count: 303
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z1.d.a(z1.d, android.view.ScrollCaptureSession, o2.j, pb.c):java.lang.Object");
    }

    @Override // android.view.ScrollCaptureCallback
    public final void onScrollCaptureEnd(Runnable runnable) {
        w.u(this.f16163e, h1.f7440c, null, new t5.e(this, runnable, null, 12), 2);
    }

    @Override // android.view.ScrollCaptureCallback
    public final void onScrollCaptureImageRequest(ScrollCaptureSession scrollCaptureSession, CancellationSignal cancellationSignal, Rect rect, Consumer consumer) {
        z zVarU = w.u(this.f16163e, null, null, new i0(this, scrollCaptureSession, rect, consumer, null, 10), 3);
        zVarU.g(new a0(cancellationSignal, 2));
        e eVar = new e();
        eVar.f16165a = zVarU;
        VarHandle.storeStoreFence();
        cancellationSignal.setOnCancelListener(eVar);
    }

    @Override // android.view.ScrollCaptureCallback
    public final void onScrollCaptureSearch(CancellationSignal cancellationSignal, Consumer consumer) {
        consumer.accept(f0.q(this.f16160b));
    }

    @Override // android.view.ScrollCaptureCallback
    public final void onScrollCaptureStart(ScrollCaptureSession scrollCaptureSession, CancellationSignal cancellationSignal, Runnable runnable) {
        this.f16164f.f16172c = 0.0f;
        this.f16161c.f14486a.setValue(Boolean.TRUE);
        runnable.run();
    }
}
