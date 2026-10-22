package x;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraExtensionSession;
import android.hardware.camera2.CaptureRequest;
import android.view.Surface;
import androidx.camera.camera2.pipe.q;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Map;
import kotlin.Metadata;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0000\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0012\u0010\b\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012\u0012\u0010\t\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012\u0012\u0010\n\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J&\u0010\u001b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0096\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ+\u0010\u001e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00192\u0006\u0010\u001d\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ)\u0010\"\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0018*\u00020\u00072\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000 H\u0016¢\u0006\u0004\b\"\u0010#R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010$R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R \u0010\b\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010'R \u0010\t\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010'R \u0010\n\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010'R&\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b*\u0010'\u001a\u0004\b(\u0010+R\u001a\u0010\u000f\u001a\u00020\u000e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001a\u0010\u0011\u001a\u00020\u00108\u0016X\u0096\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001a\u0010\u0013\u001a\u00020\u00128\u0016X\u0096\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001a\u0010\u0015\u001a\u00020\u00148\u0016X\u0096\u0004¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;¨\u0006<"}, d2 = {"Lx/e0;", "Lw/K;", "Landroidx/camera/camera2/pipe/compat/o;", "cameraCaptureSessionWrapper", "Landroid/hardware/camera2/CaptureRequest;", "captureRequest", "", "", "defaultParameters", "graphParameters", "requiredParameters", "Lw/Q;", "Landroid/view/Surface;", "streams", "Lw/M;", M5.e.FAIL_TEMPLATE, "", "repeating", "Landroidx/camera/camera2/pipe/t;", "request", "Lw/L;", "requestNumber", "<init>", "(Landroidx/camera/camera2/pipe/compat/o;Landroid/hardware/camera2/CaptureRequest;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;IZLandroidx/camera/camera2/pipe/t;JLkotlin/jvm/internal/i;)V", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/camera/camera2/pipe/q$a;", "key", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/camera2/pipe/q$a;)Ljava/lang/Object;", "default", "c", "(Landroidx/camera/camera2/pipe/q$a;Ljava/lang/Object;)Ljava/lang/Object;", "Lw9/d;", "type", "R0", "(Lw9/d;)Ljava/lang/Object;", "Landroidx/camera/camera2/pipe/compat/o;", Const.INTENT_KEY_PKGNAME, "Landroid/hardware/camera2/CaptureRequest;", "Ljava/util/Map;", Const.INTENT_KEY_UMID, "e", "f", "()Ljava/util/Map;", Const.INTENT_KEY_BACKGROUND_COMMAND, "I", "getTemplate-fGx8uWA", "()I", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Z", "l", "()Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Landroidx/camera/camera2/pipe/t;", "getRequest", "()Landroidx/camera/camera2/pipe/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "J", "k0", "()J", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: x.e0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5812e0 implements w.K {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.camera2.pipe.compat.o cameraCaptureSessionWrapper;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final CaptureRequest captureRequest;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Map<?, Object> defaultParameters;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Map<?, Object> graphParameters;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Map<?, Object> requiredParameters;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final Map<w.Q, Surface> streams;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final int template;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final boolean repeating;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.camera2.pipe.t request;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final long requestNumber;

    public /* synthetic */ C5812e0(androidx.camera.camera2.pipe.compat.o oVar, CaptureRequest captureRequest, Map map, Map map2, Map map3, Map map4, int i10, boolean z10, androidx.camera.camera2.pipe.t tVar, long j10, kotlin.jvm.internal.i iVar) {
        this(oVar, captureRequest, map, map2, map3, map4, i10, z10, tVar, j10);
    }

    @Override // w.U
    public <T> T R0(InterfaceC5745d<T> type) {
        T t10;
        kotlin.jvm.internal.p.i(type, "type");
        if (kotlin.jvm.internal.p.d(type, kotlin.jvm.internal.t.b(CaptureRequest.class))) {
            T t11 = (T) this.captureRequest;
            kotlin.jvm.internal.p.g(t11, "null cannot be cast to non-null type T of androidx.camera.camera2.pipe.compat.Camera2RequestMetadata.unwrapAs");
            return t11;
        }
        if (kotlin.jvm.internal.p.d(type, kotlin.jvm.internal.t.b(CameraCaptureSession.class))) {
            T t12 = (T) this.cameraCaptureSessionWrapper.R0(kotlin.jvm.internal.t.b(CameraCaptureSession.class));
            if (t12 == null) {
                return null;
            }
            return t12;
        }
        if (!kotlin.jvm.internal.p.d(type, kotlin.jvm.internal.t.b(CameraExtensionSession.class)) || (t10 = (T) this.cameraCaptureSessionWrapper.R0(kotlin.jvm.internal.t.b(CameraExtensionSession.class))) == null) {
            return null;
        }
        return t10;
    }

    @Override // androidx.camera.camera2.pipe.q
    public <T> T a(q.a<T> key) {
        kotlin.jvm.internal.p.i(key, "key");
        return this.requiredParameters.containsKey(key) ? (T) this.requiredParameters.get(key) : getRequest().b().containsKey(key) ? (T) getRequest().b().get(key) : this.graphParameters.containsKey(key) ? (T) this.graphParameters.get(key) : (T) this.defaultParameters.get(key);
    }

    @Override // androidx.camera.camera2.pipe.q
    public <T> T c(q.a<T> key, T t10) {
        kotlin.jvm.internal.p.i(key, "key");
        T t11 = (T) a(key);
        return t11 == null ? t10 : t11;
    }

    @Override // w.K
    public Map<w.Q, Surface> d() {
        return this.streams;
    }

    @Override // w.K
    public androidx.camera.camera2.pipe.t getRequest() {
        return this.request;
    }

    @Override // w.K
    /* renamed from: k0, reason: from getter */
    public long getRequestNumber() {
        return this.requestNumber;
    }

    @Override // w.K
    /* renamed from: l, reason: from getter */
    public boolean getRepeating() {
        return this.repeating;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C5812e0(androidx.camera.camera2.pipe.compat.o cameraCaptureSessionWrapper, CaptureRequest captureRequest, Map<?, ? extends Object> defaultParameters, Map<?, ? extends Object> graphParameters, Map<?, ? extends Object> requiredParameters, Map<w.Q, ? extends Surface> streams, int i10, boolean z10, androidx.camera.camera2.pipe.t request, long j10) {
        kotlin.jvm.internal.p.i(cameraCaptureSessionWrapper, "cameraCaptureSessionWrapper");
        kotlin.jvm.internal.p.i(captureRequest, "captureRequest");
        kotlin.jvm.internal.p.i(defaultParameters, "defaultParameters");
        kotlin.jvm.internal.p.i(graphParameters, "graphParameters");
        kotlin.jvm.internal.p.i(requiredParameters, "requiredParameters");
        kotlin.jvm.internal.p.i(streams, "streams");
        kotlin.jvm.internal.p.i(request, "request");
        this.cameraCaptureSessionWrapper = cameraCaptureSessionWrapper;
        this.captureRequest = captureRequest;
        this.defaultParameters = defaultParameters;
        this.graphParameters = graphParameters;
        this.requiredParameters = requiredParameters;
        this.streams = streams;
        this.template = i10;
        this.repeating = z10;
        this.request = request;
        this.requestNumber = j10;
    }
}
