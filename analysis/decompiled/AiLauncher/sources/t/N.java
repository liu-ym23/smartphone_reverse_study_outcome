package t;

import androidx.camera.camera2.pipe.t;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ'\u0010 \u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J'\u0010$\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b&\u0010'J\u001f\u0010(\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b*\u0010'J\u0017\u0010+\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b+\u0010'J'\u0010.\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b.\u0010/J'\u00101\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u001aH\u0016¢\u0006\u0004\b1\u0010\u001dR \u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0005028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R<\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0005062\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0005068\u0007@BX\u0086\u000e¢\u0006\f\n\u0004\b8\u00104\u001a\u0004\b9\u0010:¨\u0006<"}, d2 = {"Lt/N;", "Landroidx/camera/camera2/pipe/t$a;", "<init>", "()V", "listener", "Ljava/util/concurrent/Executor;", "executor", "LY8/t;", "s", "(Landroidx/camera/camera2/pipe/t$a;Ljava/util/concurrent/Executor;)V", "F", "(Landroidx/camera/camera2/pipe/t$a;)V", "Landroidx/camera/camera2/pipe/t;", "request", "G", "(Landroidx/camera/camera2/pipe/t;)V", "Lw/K;", "requestMetadata", "Lw/y;", "frameNumber", "Lw/Q;", "streamId", "Lw/G;", "outputId", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lw/K;JII)V", "Lw/w;", "result", "g0", "(Lw/K;JLw/w;)V", "Lw/J;", "requestFailure", "Y", "(Lw/K;JLw/J;)V", "Lw/x;", "captureResult", "D0", "(Lw/K;JLw/x;)V", "I0", "(Lw/K;)V", "m", "(Lw/K;J)V", "k0", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lw/r;", "timestamp", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lw/K;JJ)V", "totalCaptureResult", "N0", "", Const.INTENT_KEY_APIKEY, "Ljava/util/Map;", "requestListeners", "", UxipConstants.f30680s, Const.INTENT_KEY_PKGNAME, "getListeners", "()Ljava/util/Map;", "listeners", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class N implements t.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Map<t.a, Executor> requestListeners = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public volatile Map<t.a, ? extends Executor> listeners = kotlin.collections.a.i();

    public static final void B(t.a aVar, w.K k10) {
        aVar.k0(k10);
    }

    public static final void C(t.a aVar, w.K k10) {
        aVar.V(k10);
    }

    public static final void D(t.a aVar, w.K k10, long j10, long j11) {
        aVar.A(k10, j10, j11);
    }

    public static final void E(t.a aVar, w.K k10, long j10, w.w wVar) {
        aVar.N0(k10, j10, wVar);
    }

    public static final void t(t.a aVar, androidx.camera.camera2.pipe.t tVar) {
        aVar.G(tVar);
    }

    public static final void u(t.a aVar, w.K k10, long j10, int i10, int i11) {
        aVar.i(k10, j10, i10, i11);
    }

    public static final void v(t.a aVar, w.K k10, long j10, w.w wVar) {
        aVar.g0(k10, j10, wVar);
    }

    public static final void w(t.a aVar, w.K k10, long j10, w.J j11) {
        aVar.Y(k10, j10, j11);
    }

    public static final void x(t.a aVar, w.K k10, long j10, w.x xVar) {
        aVar.D0(k10, j10, xVar);
    }

    public static final void y(t.a aVar, w.K k10) {
        aVar.I0(k10);
    }

    public static final void z(t.a aVar, w.K k10, long j10) {
        aVar.m(k10, j10);
    }

    @Override // androidx.camera.camera2.pipe.t.a
    public void A(final w.K requestMetadata, final long frameNumber, final long timestamp) {
        kotlin.jvm.internal.p.i(requestMetadata, "requestMetadata");
        for (Map.Entry<t.a, ? extends Executor> entry : this.listeners.entrySet()) {
            final t.a key = entry.getKey();
            entry.getValue().execute(new Runnable() { // from class: t.L
                @Override // java.lang.Runnable
                public final void run() {
                    N.D(key, requestMetadata, frameNumber, timestamp);
                }
            });
        }
    }

    @Override // androidx.camera.camera2.pipe.t.a
    public void D0(final w.K requestMetadata, final long frameNumber, final w.x captureResult) {
        kotlin.jvm.internal.p.i(requestMetadata, "requestMetadata");
        kotlin.jvm.internal.p.i(captureResult, "captureResult");
        for (Map.Entry<t.a, ? extends Executor> entry : this.listeners.entrySet()) {
            final t.a key = entry.getKey();
            entry.getValue().execute(new Runnable() { // from class: t.J
                @Override // java.lang.Runnable
                public final void run() {
                    N.x(key, requestMetadata, frameNumber, captureResult);
                }
            });
        }
    }

    public final void F(t.a listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        synchronized (this.requestListeners) {
            this.requestListeners.remove(listener);
            this.listeners = kotlin.collections.a.A(this.requestListeners);
            Y8.t tVar = Y8.t.f7040a;
        }
    }

    @Override // androidx.camera.camera2.pipe.t.a
    public void G(final androidx.camera.camera2.pipe.t request) {
        kotlin.jvm.internal.p.i(request, "request");
        for (Map.Entry<t.a, ? extends Executor> entry : this.listeners.entrySet()) {
            final t.a key = entry.getKey();
            entry.getValue().execute(new Runnable() { // from class: t.C
                @Override // java.lang.Runnable
                public final void run() {
                    N.t(key, request);
                }
            });
        }
    }

    @Override // androidx.camera.camera2.pipe.t.a
    public void I0(final w.K requestMetadata) {
        kotlin.jvm.internal.p.i(requestMetadata, "requestMetadata");
        for (Map.Entry<t.a, ? extends Executor> entry : this.listeners.entrySet()) {
            final t.a key = entry.getKey();
            entry.getValue().execute(new Runnable() { // from class: t.E
                @Override // java.lang.Runnable
                public final void run() {
                    N.y(key, requestMetadata);
                }
            });
        }
    }

    @Override // androidx.camera.camera2.pipe.t.a
    public void N0(final w.K requestMetadata, final long frameNumber, final w.w totalCaptureResult) {
        kotlin.jvm.internal.p.i(requestMetadata, "requestMetadata");
        kotlin.jvm.internal.p.i(totalCaptureResult, "totalCaptureResult");
        for (Map.Entry<t.a, ? extends Executor> entry : this.listeners.entrySet()) {
            final t.a key = entry.getKey();
            entry.getValue().execute(new Runnable() { // from class: t.G
                @Override // java.lang.Runnable
                public final void run() {
                    N.E(key, requestMetadata, frameNumber, totalCaptureResult);
                }
            });
        }
    }

    @Override // androidx.camera.camera2.pipe.t.a
    public void V(final w.K requestMetadata) {
        kotlin.jvm.internal.p.i(requestMetadata, "requestMetadata");
        for (Map.Entry<t.a, ? extends Executor> entry : this.listeners.entrySet()) {
            final t.a key = entry.getKey();
            entry.getValue().execute(new Runnable() { // from class: t.M
                @Override // java.lang.Runnable
                public final void run() {
                    N.C(key, requestMetadata);
                }
            });
        }
    }

    @Override // androidx.camera.camera2.pipe.t.a
    public void Y(final w.K requestMetadata, final long frameNumber, final w.J requestFailure) {
        kotlin.jvm.internal.p.i(requestMetadata, "requestMetadata");
        kotlin.jvm.internal.p.i(requestFailure, "requestFailure");
        for (Map.Entry<t.a, ? extends Executor> entry : this.listeners.entrySet()) {
            final t.a key = entry.getKey();
            entry.getValue().execute(new Runnable() { // from class: t.H
                @Override // java.lang.Runnable
                public final void run() {
                    N.w(key, requestMetadata, frameNumber, requestFailure);
                }
            });
        }
    }

    @Override // androidx.camera.camera2.pipe.t.a
    public void g0(final w.K requestMetadata, final long frameNumber, final w.w result) {
        kotlin.jvm.internal.p.i(requestMetadata, "requestMetadata");
        kotlin.jvm.internal.p.i(result, "result");
        for (Map.Entry<t.a, ? extends Executor> entry : this.listeners.entrySet()) {
            final t.a key = entry.getKey();
            entry.getValue().execute(new Runnable() { // from class: t.D
                @Override // java.lang.Runnable
                public final void run() {
                    N.v(key, requestMetadata, frameNumber, result);
                }
            });
        }
    }

    @Override // androidx.camera.camera2.pipe.t.a
    public void i(final w.K requestMetadata, final long frameNumber, final int streamId, final int outputId) {
        kotlin.jvm.internal.p.i(requestMetadata, "requestMetadata");
        for (Map.Entry<t.a, ? extends Executor> entry : this.listeners.entrySet()) {
            final t.a key = entry.getKey();
            entry.getValue().execute(new Runnable() { // from class: t.I
                @Override // java.lang.Runnable
                public final void run() {
                    N.u(key, requestMetadata, frameNumber, streamId, outputId);
                }
            });
        }
    }

    @Override // androidx.camera.camera2.pipe.t.a
    public void k0(final w.K requestMetadata) {
        kotlin.jvm.internal.p.i(requestMetadata, "requestMetadata");
        for (Map.Entry<t.a, ? extends Executor> entry : this.listeners.entrySet()) {
            final t.a key = entry.getKey();
            entry.getValue().execute(new Runnable() { // from class: t.F
                @Override // java.lang.Runnable
                public final void run() {
                    N.B(key, requestMetadata);
                }
            });
        }
    }

    @Override // androidx.camera.camera2.pipe.t.a
    public void m(final w.K requestMetadata, final long frameNumber) {
        kotlin.jvm.internal.p.i(requestMetadata, "requestMetadata");
        for (Map.Entry<t.a, ? extends Executor> entry : this.listeners.entrySet()) {
            final t.a key = entry.getKey();
            entry.getValue().execute(new Runnable() { // from class: t.K
                @Override // java.lang.Runnable
                public final void run() {
                    N.z(key, requestMetadata, frameNumber);
                }
            });
        }
    }

    public final void s(t.a listener, Executor executor) {
        kotlin.jvm.internal.p.i(listener, "listener");
        kotlin.jvm.internal.p.i(executor, "executor");
        if (this.listeners.containsKey(listener)) {
            throw new IllegalStateException((listener + " was already registered!").toString());
        }
        synchronized (this.requestListeners) {
            this.requestListeners.put(listener, executor);
            this.listeners = kotlin.collections.a.A(this.requestListeners);
            Y8.t tVar = Y8.t.f7040a;
        }
    }
}
