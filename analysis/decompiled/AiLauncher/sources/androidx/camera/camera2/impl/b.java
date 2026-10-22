package androidx.camera.camera2.impl;

import K.AbstractC0889l;
import K.E0;
import Y8.h;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraExtensionSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import androidx.camera.camera2.pipe.t;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import o.C4983o;
import o.C4985q;
import p.C5020b;
import p.C5021c;
import p9.InterfaceC5063a;
import t.C5472a0;
import t.f0;
import w.J;
import w.K;
import w.Q;
import w.w;
import w.x;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0004\b\u0007\u0018\u0000 D2\u00020\u0001:\u00019B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J/\u0010\u0019\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001d\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010!\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\u00102\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J'\u0010)\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b+\u0010,J\u001f\u0010-\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b-\u0010.J'\u00101\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b1\u00102J\u001f\u00104\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u0005H\u0016¢\u0006\u0004\b4\u00105J'\u00107\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u00100\u001a\u000206H\u0016¢\u0006\u0004\b7\u00102R \u0010;\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000e088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u001b\u0010@\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\"\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000e0A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010:¨\u0006E"}, d2 = {"Landroidx/camera/camera2/impl/b;", "Landroidx/camera/camera2/pipe/t$a;", "<init>", "()V", "Lw/K;", "", "z", "(Lw/K;)I", "requestMetadata", "Landroid/hardware/camera2/CameraCaptureSession;", "y", "(Lw/K;)Landroid/hardware/camera2/CameraCaptureSession;", "LK/l;", "callback", "Ljava/util/concurrent/Executor;", "executor", "LY8/t;", "x", "(LK/l;Ljava/util/concurrent/Executor;)V", "Lw/y;", "frameNumber", "Lw/Q;", "streamId", "Lw/G;", "outputId", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lw/K;JII)V", "Lw/w;", "result", "g0", "(Lw/K;JLw/w;)V", "Lw/J;", "requestFailure", "Y", "(Lw/K;JLw/J;)V", "Landroidx/camera/camera2/pipe/t;", "request", "G", "(Landroidx/camera/camera2/pipe/t;)V", "Lw/x;", "captureResult", "D0", "(Lw/K;JLw/x;)V", "I0", "(Lw/K;)V", "m", "(Lw/K;J)V", "Lw/r;", "timestamp", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lw/K;JJ)V", "progress", "v0", "(Lw/K;I)V", "Lw/O;", Const.INTENT_KEY_BACKGROUND_COMMAND, "", Const.INTENT_KEY_APIKEY, "Ljava/util/Map;", "callbackMap", Const.INTENT_KEY_PKGNAME, "LY8/h;", "B", "()Landroid/hardware/camera2/CameraCaptureSession;", "rejectOperationCameraCaptureSession", "", "c", "callbacks", Const.INTENT_KEY_UMID, "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class b implements t.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Map<AbstractC0889l, Executor> callbackMap = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final h rejectOperationCameraCaptureSession = C4848b.b(new InterfaceC5063a() { // from class: t.i
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return androidx.camera.camera2.impl.b.T();
        }
    });

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public volatile Map<AbstractC0889l, ? extends Executor> callbacks = kotlin.collections.a.i();

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\n\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/camera/camera2/impl/b$a;", "", "<init>", "()V", "", "LK/l;", "callbacks", "Ljava/util/concurrent/Executor;", "executor", "Landroidx/camera/camera2/impl/b;", Const.INTENT_KEY_APIKEY, "(Ljava/util/Collection;Ljava/util/concurrent/Executor;)Landroidx/camera/camera2/impl/b;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.impl.b$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final b a(Collection<? extends AbstractC0889l> callbacks, Executor executor) {
            p.i(callbacks, "callbacks");
            p.i(executor, "executor");
            b bVar = new b();
            Iterator<T> it = callbacks.iterator();
            while (it.hasNext()) {
                bVar.x((AbstractC0889l) it.next(), executor);
            }
            return bVar;
        }

        public Companion() {
        }
    }

    public static final void C(AbstractC0889l abstractC0889l, int i10) {
        abstractC0889l.a(i10);
    }

    public static final void D(AbstractC0889l abstractC0889l, CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, Surface surface, long j10) {
        C5020b.a(((C4983o.a) abstractC0889l).getCaptureCallback(), cameraCaptureSession, captureRequest, surface, j10);
    }

    public static final void E(AbstractC0889l abstractC0889l, CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
        ((C4983o.a) abstractC0889l).getCaptureCallback().onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult);
    }

    public static final void F(AbstractC0889l abstractC0889l, b bVar, K k10, int i10) {
        abstractC0889l.d(bVar.z(k10), i10);
    }

    public static final void H(AbstractC0889l abstractC0889l, CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        ((C4983o.a) abstractC0889l).getCaptureCallback().onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
    }

    public static final void I(AbstractC0889l abstractC0889l, b bVar, K k10, C4985q c4985q) {
        abstractC0889l.b(bVar.z(k10), c4985q);
    }

    public static final void K(AbstractC0889l abstractC0889l, CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
        ((C4983o.a) abstractC0889l).getCaptureCallback().onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
    }

    public static final void L(AbstractC0889l abstractC0889l, b bVar, K k10, CameraCaptureFailure cameraCaptureFailure) {
        abstractC0889l.c(bVar.z(k10), cameraCaptureFailure);
    }

    public static final void M(AbstractC0889l abstractC0889l, CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
        ((C4983o.a) abstractC0889l).getCaptureCallback().onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult);
    }

    public static final void N(AbstractC0889l abstractC0889l, CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j10, long j11) {
        C5021c.a(((C4983o.a) abstractC0889l).getCaptureCallback(), cameraCaptureSession, captureRequest, j10, j11);
    }

    public static final void O(AbstractC0889l abstractC0889l, CameraCaptureSession cameraCaptureSession) {
        ((C4983o.a) abstractC0889l).getCaptureCallback().onCaptureSequenceAborted(cameraCaptureSession, -1);
    }

    public static final void P(AbstractC0889l abstractC0889l, b bVar, K k10) {
        abstractC0889l.a(bVar.z(k10));
    }

    public static final void Q(AbstractC0889l abstractC0889l, CameraCaptureSession cameraCaptureSession, long j10) {
        ((C4983o.a) abstractC0889l).getCaptureCallback().onCaptureSequenceCompleted(cameraCaptureSession, -1, j10);
    }

    public static final void R(AbstractC0889l abstractC0889l, CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j10, long j11) {
        ((C4983o.a) abstractC0889l).getCaptureCallback().onCaptureStarted(cameraCaptureSession, captureRequest, j10, j11);
    }

    public static final void S(AbstractC0889l abstractC0889l, b bVar, K k10) {
        abstractC0889l.e(bVar.z(k10));
    }

    public static final C5472a0 T() {
        return new C5472a0();
    }

    @Override // androidx.camera.camera2.pipe.t.a
    public void A(final K requestMetadata, final long frameNumber, final long timestamp) {
        p.i(requestMetadata, "requestMetadata");
        for (Map.Entry<AbstractC0889l, ? extends Executor> entry : this.callbacks.entrySet()) {
            final AbstractC0889l key = entry.getKey();
            Executor value = entry.getValue();
            if (key instanceof C4983o.a) {
                final CameraCaptureSession cameraCaptureSessionY = y(requestMetadata);
                final CaptureRequest captureRequest = (CaptureRequest) requestMetadata.R0(kotlin.jvm.internal.t.b(CaptureRequest.class));
                if (cameraCaptureSessionY != null && captureRequest != null) {
                    value.execute(new Runnable() { // from class: t.r
                        @Override // java.lang.Runnable
                        public final void run() {
                            androidx.camera.camera2.impl.b.R(key, cameraCaptureSessionY, captureRequest, timestamp, frameNumber);
                        }
                    });
                }
            } else {
                value.execute(new Runnable() { // from class: t.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        androidx.camera.camera2.impl.b.S(key, this, requestMetadata);
                    }
                });
            }
        }
    }

    public final CameraCaptureSession B() {
        return (CameraCaptureSession) this.rejectOperationCameraCaptureSession.getValue();
    }

    @Override // androidx.camera.camera2.pipe.t.a
    public void D0(K requestMetadata, long frameNumber, x captureResult) {
        p.i(requestMetadata, "requestMetadata");
        p.i(captureResult, "captureResult");
        for (Map.Entry<AbstractC0889l, ? extends Executor> entry : this.callbacks.entrySet()) {
            final AbstractC0889l key = entry.getKey();
            Executor value = entry.getValue();
            if (key instanceof C4983o.a) {
                final CameraCaptureSession cameraCaptureSession = (CameraCaptureSession) requestMetadata.R0(kotlin.jvm.internal.t.b(CameraCaptureSession.class));
                final CaptureRequest captureRequest = (CaptureRequest) requestMetadata.R0(kotlin.jvm.internal.t.b(CaptureRequest.class));
                final CaptureResult captureResult2 = (CaptureResult) captureResult.R0(kotlin.jvm.internal.t.b(CaptureResult.class));
                if (cameraCaptureSession != null && captureRequest != null && captureResult2 != null) {
                    value.execute(new Runnable() { // from class: t.n
                        @Override // java.lang.Runnable
                        public final void run() {
                            androidx.camera.camera2.impl.b.M(key, cameraCaptureSession, captureRequest, captureResult2);
                        }
                    });
                }
            }
        }
    }

    @Override // androidx.camera.camera2.pipe.t.a
    public void G(t request) {
        p.i(request, "request");
        for (Map.Entry<AbstractC0889l, ? extends Executor> entry : this.callbacks.entrySet()) {
            final AbstractC0889l key = entry.getKey();
            Executor value = entry.getValue();
            Object obj = request.b().get(f0.a());
            E0 e02 = obj instanceof E0 ? (E0) obj : null;
            Object objD = e02 != null ? e02.d("CAPTURE_CONFIG_ID_KEY") : null;
            Integer num = objD instanceof Integer ? (Integer) objD : null;
            final int iIntValue = num != null ? num.intValue() : -1;
            value.execute(new Runnable() { // from class: t.c
                @Override // java.lang.Runnable
                public final void run() {
                    androidx.camera.camera2.impl.b.C(key, iIntValue);
                }
            });
        }
    }

    @Override // androidx.camera.camera2.pipe.t.a
    public void I0(final K requestMetadata) {
        p.i(requestMetadata, "requestMetadata");
        for (Map.Entry<AbstractC0889l, ? extends Executor> entry : this.callbacks.entrySet()) {
            final AbstractC0889l key = entry.getKey();
            Executor value = entry.getValue();
            if (key instanceof C4983o.a) {
                final CameraCaptureSession cameraCaptureSession = (CameraCaptureSession) requestMetadata.R0(kotlin.jvm.internal.t.b(CameraCaptureSession.class));
                CaptureRequest captureRequest = (CaptureRequest) requestMetadata.R0(kotlin.jvm.internal.t.b(CaptureRequest.class));
                if (cameraCaptureSession != null && captureRequest != null) {
                    value.execute(new Runnable() { // from class: t.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            androidx.camera.camera2.impl.b.O(key, cameraCaptureSession);
                        }
                    });
                }
            } else {
                value.execute(new Runnable() { // from class: t.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        androidx.camera.camera2.impl.b.P(key, this, requestMetadata);
                    }
                });
            }
        }
    }

    @Override // androidx.camera.camera2.pipe.t.a
    public void Y(final K requestMetadata, long frameNumber, J requestFailure) {
        p.i(requestMetadata, "requestMetadata");
        p.i(requestFailure, "requestFailure");
        for (Map.Entry<AbstractC0889l, ? extends Executor> entry : this.callbacks.entrySet()) {
            final AbstractC0889l key = entry.getKey();
            Executor value = entry.getValue();
            if (key instanceof C4983o.a) {
                final CameraCaptureSession cameraCaptureSessionY = y(requestMetadata);
                final CaptureRequest captureRequest = (CaptureRequest) requestMetadata.R0(kotlin.jvm.internal.t.b(CaptureRequest.class));
                final CaptureFailure captureFailure = (CaptureFailure) requestFailure.R0(kotlin.jvm.internal.t.b(CaptureFailure.class));
                if (cameraCaptureSessionY != null && captureRequest != null && captureFailure != null) {
                    value.execute(new Runnable() { // from class: t.l
                        @Override // java.lang.Runnable
                        public final void run() {
                            androidx.camera.camera2.impl.b.K(key, cameraCaptureSessionY, captureRequest, captureFailure);
                        }
                    });
                }
            } else {
                final CameraCaptureFailure cameraCaptureFailure = new CameraCaptureFailure(CameraCaptureFailure.Reason.ERROR);
                value.execute(new Runnable() { // from class: t.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        androidx.camera.camera2.impl.b.L(key, this, requestMetadata, cameraCaptureFailure);
                    }
                });
            }
        }
    }

    @Override // androidx.camera.camera2.pipe.t.a
    public void g(K requestMetadata, final long frameNumber, final long timestamp) {
        p.i(requestMetadata, "requestMetadata");
        for (Map.Entry<AbstractC0889l, ? extends Executor> entry : this.callbacks.entrySet()) {
            final AbstractC0889l key = entry.getKey();
            Executor value = entry.getValue();
            if (key instanceof C4983o.a) {
                final CameraCaptureSession cameraCaptureSession = (CameraCaptureSession) requestMetadata.R0(kotlin.jvm.internal.t.b(CameraCaptureSession.class));
                final CaptureRequest captureRequest = (CaptureRequest) requestMetadata.R0(kotlin.jvm.internal.t.b(CaptureRequest.class));
                if (cameraCaptureSession != null && captureRequest != null) {
                    value.execute(new Runnable() { // from class: t.o
                        @Override // java.lang.Runnable
                        public final void run() {
                            androidx.camera.camera2.impl.b.N(key, cameraCaptureSession, captureRequest, timestamp, frameNumber);
                        }
                    });
                }
            }
        }
    }

    @Override // androidx.camera.camera2.pipe.t.a
    public void g0(final K requestMetadata, long frameNumber, w result) {
        p.i(requestMetadata, "requestMetadata");
        p.i(result, "result");
        for (Map.Entry<AbstractC0889l, ? extends Executor> entry : this.callbacks.entrySet()) {
            final AbstractC0889l key = entry.getKey();
            Executor value = entry.getValue();
            if (key instanceof C4983o.a) {
                final CameraCaptureSession cameraCaptureSessionY = y(requestMetadata);
                final CaptureRequest captureRequest = (CaptureRequest) requestMetadata.R0(kotlin.jvm.internal.t.b(CaptureRequest.class));
                final TotalCaptureResult totalCaptureResult = (TotalCaptureResult) result.R0(kotlin.jvm.internal.t.b(TotalCaptureResult.class));
                if (cameraCaptureSessionY != null && captureRequest != null && totalCaptureResult != null) {
                    value.execute(new Runnable() { // from class: t.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            androidx.camera.camera2.impl.b.H(key, cameraCaptureSessionY, captureRequest, totalCaptureResult);
                        }
                    });
                }
            } else {
                final C4985q c4985q = new C4985q(requestMetadata, frameNumber, result, null);
                value.execute(new Runnable() { // from class: t.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        androidx.camera.camera2.impl.b.I(key, this, requestMetadata, c4985q);
                    }
                });
            }
        }
    }

    @Override // androidx.camera.camera2.pipe.t.a
    public void i(K requestMetadata, final long frameNumber, int streamId, int outputId) {
        p.i(requestMetadata, "requestMetadata");
        for (Map.Entry<AbstractC0889l, ? extends Executor> entry : this.callbacks.entrySet()) {
            final AbstractC0889l key = entry.getKey();
            Executor value = entry.getValue();
            if (key instanceof C4983o.a) {
                final CameraCaptureSession cameraCaptureSession = (CameraCaptureSession) requestMetadata.R0(kotlin.jvm.internal.t.b(CameraCaptureSession.class));
                final CaptureRequest captureRequest = (CaptureRequest) requestMetadata.R0(kotlin.jvm.internal.t.b(CaptureRequest.class));
                final Surface surface = requestMetadata.d().get(Q.a(streamId));
                if (cameraCaptureSession != null && captureRequest != null && surface != null) {
                    value.execute(new Runnable() { // from class: t.p
                        @Override // java.lang.Runnable
                        public final void run() {
                            androidx.camera.camera2.impl.b.D(key, cameraCaptureSession, captureRequest, surface, frameNumber);
                        }
                    });
                }
            }
        }
    }

    @Override // androidx.camera.camera2.pipe.t.a
    public void m(K requestMetadata, final long frameNumber) {
        p.i(requestMetadata, "requestMetadata");
        for (Map.Entry<AbstractC0889l, ? extends Executor> entry : this.callbacks.entrySet()) {
            final AbstractC0889l key = entry.getKey();
            Executor value = entry.getValue();
            if (key instanceof C4983o.a) {
                final CameraCaptureSession cameraCaptureSessionY = y(requestMetadata);
                CaptureRequest captureRequest = (CaptureRequest) requestMetadata.R0(kotlin.jvm.internal.t.b(CaptureRequest.class));
                if (cameraCaptureSessionY != null && captureRequest != null) {
                    value.execute(new Runnable() { // from class: t.q
                        @Override // java.lang.Runnable
                        public final void run() {
                            androidx.camera.camera2.impl.b.Q(key, cameraCaptureSessionY, frameNumber);
                        }
                    });
                }
            }
        }
    }

    @Override // androidx.camera.camera2.pipe.t.a
    public void v0(final K requestMetadata, final int progress) {
        p.i(requestMetadata, "requestMetadata");
        for (Map.Entry<AbstractC0889l, ? extends Executor> entry : this.callbacks.entrySet()) {
            final AbstractC0889l key = entry.getKey();
            Executor value = entry.getValue();
            if (key instanceof C4983o.a) {
                final CameraCaptureSession cameraCaptureSession = (CameraCaptureSession) requestMetadata.R0(kotlin.jvm.internal.t.b(CameraCaptureSession.class));
                final CaptureRequest captureRequest = (CaptureRequest) requestMetadata.R0(kotlin.jvm.internal.t.b(CaptureRequest.class));
                final CaptureResult captureResult = (CaptureResult) requestMetadata.R0(kotlin.jvm.internal.t.b(CaptureResult.class));
                if (cameraCaptureSession != null && captureRequest != null && captureResult != null) {
                    value.execute(new Runnable() { // from class: t.j
                        @Override // java.lang.Runnable
                        public final void run() {
                            androidx.camera.camera2.impl.b.E(key, cameraCaptureSession, captureRequest, captureResult);
                        }
                    });
                }
            } else {
                value.execute(new Runnable() { // from class: t.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        androidx.camera.camera2.impl.b.F(key, this, requestMetadata, progress);
                    }
                });
            }
        }
    }

    public final void x(AbstractC0889l callback, Executor executor) {
        p.i(callback, "callback");
        p.i(executor, "executor");
        if (this.callbacks.containsKey(callback)) {
            throw new IllegalStateException((callback + " was already registered!").toString());
        }
        synchronized (this.callbackMap) {
            this.callbackMap.put(callback, executor);
            this.callbacks = kotlin.collections.a.A(this.callbackMap);
            Y8.t tVar = Y8.t.f7040a;
        }
    }

    public final CameraCaptureSession y(K requestMetadata) {
        CameraCaptureSession cameraCaptureSession = (CameraCaptureSession) requestMetadata.R0(kotlin.jvm.internal.t.b(CameraCaptureSession.class));
        if (cameraCaptureSession != null) {
            return cameraCaptureSession;
        }
        if (((CameraExtensionSession) requestMetadata.R0(kotlin.jvm.internal.t.b(CameraExtensionSession.class))) != null) {
            return B();
        }
        return null;
    }

    public final int z(K k10) {
        E0 e02 = (E0) k10.a(f0.a());
        Object objD = e02 != null ? e02.d("CAPTURE_CONFIG_ID_KEY") : null;
        Integer num = objD instanceof Integer ? (Integer) objD : null;
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }
}
