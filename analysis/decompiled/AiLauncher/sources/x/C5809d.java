package x;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraExtensionSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Log;
import android.view.Surface;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import w.C5706l;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0011\u0018\u00002\u00020\u0001:\u0001)B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0013\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J'\u0010\u001a\u001a\u0004\u0018\u00010\u00102\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u00182\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\u001c\u001a\u0004\u0018\u00010\u00102\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u00182\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001c\u0010\u001bJ\u001d\u0010\u001f\u001a\u00020\u00142\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0018H\u0016¢\u0006\u0004\b\u001f\u0010 J)\u0010$\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u001c*\u00020!2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\"H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u001a\u00108\u001a\u0002038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0014\u0010;\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010:R \u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020=0<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u0004\u0018\u00010A8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010C¨\u0006E"}, d2 = {"Lx/d;", "Landroidx/camera/camera2/pipe/compat/q;", "Landroidx/camera/camera2/pipe/compat/p;", Parameters.DEVICE, "Landroid/hardware/camera2/CameraExtensionSession;", "cameraExtensionSession", "LB/c;", "cameraErrorListener", "Ljava/util/concurrent/Executor;", "callbackExecutor", "<init>", "(Landroidx/camera/camera2/pipe/compat/p;Landroid/hardware/camera2/CameraExtensionSession;LB/c;Ljava/util/concurrent/Executor;)V", "Landroid/hardware/camera2/CaptureRequest;", "request", "Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "listener", "", "F0", "(Landroid/hardware/camera2/CaptureRequest;Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;)Ljava/lang/Integer;", "q0", "", "stopRepeating", "()Z", "f", "", "requests", "p", "(Ljava/util/List;Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;)Ljava/lang/Integer;", ExifInterface.GPS_DIRECTION_TRUE, "Lx/w0;", "outputConfigs", "f0", "(Ljava/util/List;)Z", "", "Lw9/d;", "type", "R0", "(Lw9/d;)Ljava/lang/Object;", "LY8/t;", "close", "()V", Const.INTENT_KEY_APIKEY, "Landroidx/camera/camera2/pipe/compat/p;", "getDevice", "()Landroidx/camera/camera2/pipe/compat/p;", Const.INTENT_KEY_PKGNAME, "Landroid/hardware/camera2/CameraExtensionSession;", "c", "LB/c;", Const.INTENT_KEY_UMID, "Ljava/util/concurrent/Executor;", "Landroidx/camera/camera2/pipe/f$a;", "e", "I", "w", "()I", "id", "LOa/d;", "LOa/d;", "frameNumbers", "", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "Ljava/util/Map;", "extensionSessionMap", "Landroid/view/Surface;", "getInputSurface", "()Landroid/view/Surface;", "inputSurface", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: x.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C5809d implements androidx.camera.camera2.pipe.compat.q {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.camera2.pipe.compat.p device;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final CameraExtensionSession cameraExtensionSession;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final B.c cameraErrorListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Executor callbackExecutor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final int id;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final Oa.d frameNumbers;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final Map<CameraExtensionSession, Long> extensionSessionMap;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\u0010J\u001f\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0019\u0010\u0018J'\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b \u0010\u001fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\n0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010#¨\u0006%"}, d2 = {"Lx/d$a;", "Landroid/hardware/camera2/CameraExtensionSession$ExtensionCaptureCallback;", "Lx/L;", "captureCallback", "<init>", "(Lx/d;Lx/L;)V", "Landroid/hardware/camera2/CameraExtensionSession;", "session", "Landroid/hardware/camera2/CaptureRequest;", "request", "", "timestamp", "LY8/t;", "onCaptureStarted", "(Landroid/hardware/camera2/CameraExtensionSession;Landroid/hardware/camera2/CaptureRequest;J)V", "onCaptureProcessStarted", "(Landroid/hardware/camera2/CameraExtensionSession;Landroid/hardware/camera2/CaptureRequest;)V", "", "progress", "onCaptureProcessProgressed", "(Landroid/hardware/camera2/CameraExtensionSession;Landroid/hardware/camera2/CaptureRequest;I)V", "onCaptureFailed", "sequenceId", "onCaptureSequenceCompleted", "(Landroid/hardware/camera2/CameraExtensionSession;I)V", "onCaptureSequenceAborted", "Landroid/hardware/camera2/TotalCaptureResult;", "result", "onCaptureResultAvailable", "(Landroid/hardware/camera2/CameraExtensionSession;Landroid/hardware/camera2/CaptureRequest;Landroid/hardware/camera2/TotalCaptureResult;)V", Const.INTENT_KEY_PKGNAME, "(Landroid/hardware/camera2/CameraExtensionSession;)J", Const.INTENT_KEY_APIKEY, "Lx/L;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "frameQueue", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: x.d$a */
    public final class a extends CameraExtensionSession.ExtensionCaptureCallback {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final L captureCallback;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final ConcurrentLinkedQueue<Long> frameQueue;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ C5809d f43379c;

        public a(C5809d c5809d, L captureCallback) {
            kotlin.jvm.internal.p.i(captureCallback, "captureCallback");
            this.f43379c = c5809d;
            this.captureCallback = captureCallback;
            this.frameQueue = new ConcurrentLinkedQueue<>();
        }

        public final long a(CameraExtensionSession session) {
            if (this.frameQueue.isEmpty()) {
                b(session);
            }
            Long lRemove = this.frameQueue.remove();
            kotlin.jvm.internal.p.h(lRemove, "remove(...)");
            return lRemove.longValue();
        }

        public final long b(CameraExtensionSession session) {
            long jC = this.f43379c.frameNumbers.c();
            this.f43379c.extensionSessionMap.put(session, Long.valueOf(jC));
            this.frameQueue.add(Long.valueOf(jC));
            return jC;
        }

        @Override // android.hardware.camera2.CameraExtensionSession.ExtensionCaptureCallback
        public void onCaptureFailed(CameraExtensionSession session, CaptureRequest request) {
            kotlin.jvm.internal.p.i(session, "session");
            kotlin.jvm.internal.p.i(request, "request");
            this.captureCallback.e(request, w.y.b(a(session)));
        }

        @Override // android.hardware.camera2.CameraExtensionSession.ExtensionCaptureCallback
        public void onCaptureProcessProgressed(CameraExtensionSession session, CaptureRequest request, int progress) {
            kotlin.jvm.internal.p.i(session, "session");
            kotlin.jvm.internal.p.i(request, "request");
            this.captureCallback.d(request, progress);
        }

        @Override // android.hardware.camera2.CameraExtensionSession.ExtensionCaptureCallback
        public void onCaptureProcessStarted(CameraExtensionSession session, CaptureRequest request) {
            kotlin.jvm.internal.p.i(session, "session");
            kotlin.jvm.internal.p.i(request, "request");
        }

        @Override // android.hardware.camera2.CameraExtensionSession.ExtensionCaptureCallback
        public void onCaptureResultAvailable(CameraExtensionSession session, CaptureRequest request, TotalCaptureResult result) {
            kotlin.jvm.internal.p.i(session, "session");
            kotlin.jvm.internal.p.i(request, "request");
            kotlin.jvm.internal.p.i(result, "result");
            this.captureCallback.c(request, result, w.y.b(a(session)));
        }

        @Override // android.hardware.camera2.CameraExtensionSession.ExtensionCaptureCallback
        public void onCaptureSequenceAborted(CameraExtensionSession session, int sequenceId) {
            kotlin.jvm.internal.p.i(session, "session");
            this.captureCallback.b(sequenceId);
        }

        @Override // android.hardware.camera2.CameraExtensionSession.ExtensionCaptureCallback
        public void onCaptureSequenceCompleted(CameraExtensionSession session, int sequenceId) {
            kotlin.jvm.internal.p.i(session, "session");
            Long l10 = (Long) this.f43379c.extensionSessionMap.get(session);
            L l11 = this.captureCallback;
            kotlin.jvm.internal.p.f(l10);
            l11.a(sequenceId, l10.longValue());
        }

        @Override // android.hardware.camera2.CameraExtensionSession.ExtensionCaptureCallback
        public void onCaptureStarted(CameraExtensionSession session, CaptureRequest request, long timestamp) {
            kotlin.jvm.internal.p.i(session, "session");
            kotlin.jvm.internal.p.i(request, "request");
            this.captureCallback.f(request, b(session), timestamp);
        }
    }

    public C5809d(androidx.camera.camera2.pipe.compat.p device, CameraExtensionSession cameraExtensionSession, B.c cameraErrorListener, Executor callbackExecutor) {
        kotlin.jvm.internal.p.i(device, "device");
        kotlin.jvm.internal.p.i(cameraExtensionSession, "cameraExtensionSession");
        kotlin.jvm.internal.p.i(cameraErrorListener, "cameraErrorListener");
        kotlin.jvm.internal.p.i(callbackExecutor, "callbackExecutor");
        this.device = device;
        this.cameraExtensionSession = cameraExtensionSession;
        this.cameraErrorListener = cameraErrorListener;
        this.callbackExecutor = callbackExecutor;
        this.id = androidx.camera.camera2.pipe.f.a();
        this.frameNumbers = Oa.b.e(0L);
        this.extensionSessionMap = new HashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.camera.camera2.pipe.compat.o
    public Integer F0(CaptureRequest request, CameraCaptureSession.CaptureCallback listener) throws Exception {
        kotlin.jvm.internal.p.i(request, "request");
        kotlin.jvm.internal.p.i(listener, "listener");
        String strG = getDevice().g();
        B.c cVar = this.cameraErrorListener;
        try {
            return Integer.valueOf(this.cameraExtensionSession.capture(request, this.callbackExecutor, new a(this, (L) listener)));
        } catch (Exception e10) {
            if (e10 instanceof CameraAccessException) {
                if (z.k.f44508a.d()) {
                    Log.w("CXCP", "Failed to execute call: Camera encountered an error: " + e10.getMessage());
                }
                cVar.a(strG, C5706l.INSTANCE.b((CameraAccessException) e10), true);
                return null;
            }
            if (!(e10 instanceof IllegalArgumentException) && !(e10 instanceof SecurityException) && !(e10 instanceof UnsupportedOperationException) && !(e10 instanceof NullPointerException)) {
                if (!(e10 instanceof IllegalStateException)) {
                    throw e10;
                }
                if (!z.k.f44508a.a()) {
                    return null;
                }
                Log.d("CXCP", "Failed to execute call: Camera may be closed");
                return null;
            }
            if (z.k.f44508a.d()) {
                Log.w("CXCP", "Failed to execute call: Unexpected exception: " + e10.getMessage());
            }
            cVar.a(strG, C5706l.INSTANCE.m(), false);
            return null;
        }
    }

    @Override // w.U
    public <T> T R0(InterfaceC5745d<T> type) {
        kotlin.jvm.internal.p.i(type, "type");
        if (kotlin.jvm.internal.p.d(type, kotlin.jvm.internal.t.b(CameraExtensionSession.class))) {
            return (T) this.cameraExtensionSession;
        }
        return null;
    }

    @Override // androidx.camera.camera2.pipe.compat.o
    public Integer T(List<CaptureRequest> requests, CameraCaptureSession.CaptureCallback listener) {
        kotlin.jvm.internal.p.i(requests, "requests");
        kotlin.jvm.internal.p.i(listener, "listener");
        if (requests.size() == 1) {
            return q0((CaptureRequest) Z8.F.X0(requests), listener);
        }
        throw new IllegalStateException("CameraExtensionSession does not support setRepeatingBurst for more than oneCaptureRequest");
    }

    @Override // java.lang.AutoCloseable
    public void close() throws CameraAccessException {
        this.cameraExtensionSession.close();
    }

    @Override // androidx.camera.camera2.pipe.compat.o
    public boolean f() {
        return false;
    }

    @Override // androidx.camera.camera2.pipe.compat.o
    public boolean f0(List<? extends w0> outputConfigs) {
        kotlin.jvm.internal.p.i(outputConfigs, "outputConfigs");
        if (!z.k.f44508a.d()) {
            return false;
        }
        Log.w("CXCP", "CameraExtensionSession does not support finalizeOutputConfigurations()");
        return false;
    }

    @Override // androidx.camera.camera2.pipe.compat.o
    public androidx.camera.camera2.pipe.compat.p getDevice() {
        return this.device;
    }

    @Override // androidx.camera.camera2.pipe.compat.o
    public Surface getInputSurface() {
        return null;
    }

    @Override // androidx.camera.camera2.pipe.compat.o
    public Integer p(List<CaptureRequest> requests, CameraCaptureSession.CaptureCallback listener) throws Exception {
        kotlin.jvm.internal.p.i(requests, "requests");
        kotlin.jvm.internal.p.i(listener, "listener");
        Iterator<T> it = requests.iterator();
        while (it.hasNext()) {
            F0((CaptureRequest) it.next(), listener);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.camera.camera2.pipe.compat.o
    public Integer q0(CaptureRequest request, CameraCaptureSession.CaptureCallback listener) throws Exception {
        kotlin.jvm.internal.p.i(request, "request");
        kotlin.jvm.internal.p.i(listener, "listener");
        String strG = getDevice().g();
        B.c cVar = this.cameraErrorListener;
        try {
            return Integer.valueOf(this.cameraExtensionSession.setRepeatingRequest(request, this.callbackExecutor, new a(this, (L) listener)));
        } catch (Exception e10) {
            if (e10 instanceof CameraAccessException) {
                if (z.k.f44508a.d()) {
                    Log.w("CXCP", "Failed to execute call: Camera encountered an error: " + e10.getMessage());
                }
                cVar.a(strG, C5706l.INSTANCE.b((CameraAccessException) e10), true);
                return null;
            }
            if (!(e10 instanceof IllegalArgumentException) && !(e10 instanceof SecurityException) && !(e10 instanceof UnsupportedOperationException) && !(e10 instanceof NullPointerException)) {
                if (!(e10 instanceof IllegalStateException)) {
                    throw e10;
                }
                if (!z.k.f44508a.a()) {
                    return null;
                }
                Log.d("CXCP", "Failed to execute call: Camera may be closed");
                return null;
            }
            if (z.k.f44508a.d()) {
                Log.w("CXCP", "Failed to execute call: Unexpected exception: " + e10.getMessage());
            }
            cVar.a(strG, C5706l.INSTANCE.m(), false);
            return null;
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.o
    public boolean stopRepeating() throws Exception {
        Y8.t tVar;
        String strG = getDevice().g();
        B.c cVar = this.cameraErrorListener;
        try {
            this.cameraExtensionSession.stopRepeating();
            tVar = Y8.t.f7040a;
        } catch (Exception e10) {
            if (e10 instanceof CameraAccessException) {
                if (z.k.f44508a.d()) {
                    Log.w("CXCP", "Failed to execute call: Camera encountered an error: " + e10.getMessage());
                }
                cVar.a(strG, C5706l.INSTANCE.b((CameraAccessException) e10), true);
            } else if ((e10 instanceof IllegalArgumentException) || (e10 instanceof SecurityException) || (e10 instanceof UnsupportedOperationException) || (e10 instanceof NullPointerException)) {
                if (z.k.f44508a.d()) {
                    Log.w("CXCP", "Failed to execute call: Unexpected exception: " + e10.getMessage());
                }
                cVar.a(strG, C5706l.INSTANCE.m(), false);
            } else {
                if (!(e10 instanceof IllegalStateException)) {
                    throw e10;
                }
                if (z.k.f44508a.a()) {
                    Log.d("CXCP", "Failed to execute call: Camera may be closed");
                }
            }
            tVar = null;
        }
        return tVar != null;
    }

    @Override // androidx.camera.camera2.pipe.compat.o
    /* renamed from: w, reason: from getter */
    public int getId() {
        return this.id;
    }
}
