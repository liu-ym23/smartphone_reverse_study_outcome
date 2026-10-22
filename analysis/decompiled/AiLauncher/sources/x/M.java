package x;

import Ua.C1087w;
import Ua.InterfaceC1083u;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Trace;
import android.util.Log;
import android.view.Surface;
import androidx.camera.camera2.pipe.l;
import androidx.camera.camera2.pipe.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0081\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\t\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\t\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011\u0012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00150\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ/\u0010$\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 H\u0016¢\u0006\u0004\b$\u0010%J'\u0010&\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b&\u0010'J'\u0010*\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b*\u0010+J\u001f\u0010,\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b,\u0010-J/\u0010/\u001a\u00020#2\u0006\u0010.\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 H\u0016¢\u0006\u0004\b/\u0010%J'\u00102\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u00101\u001a\u000200H\u0016¢\u0006\u0004\b2\u00103J'\u00106\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u00101\u001a\u0002002\u0006\u00105\u001a\u000204H\u0016¢\u0006\u0004\b6\u00107J\u001f\u0010:\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u00109\u001a\u000208H\u0016¢\u0006\u0004\b:\u0010;J'\u0010>\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010=\u001a\u00020<H\u0016¢\u0006\u0004\b>\u0010?J\u001f\u0010@\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u00105\u001a\u000204H\u0016¢\u0006\u0004\b@\u0010AJ/\u0010D\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u00122\u0006\u0010C\u001a\u00020 H\u0016¢\u0006\u0004\bD\u0010EJ'\u0010G\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010F\u001a\u0002082\u0006\u0010\"\u001a\u00020 H\u0016¢\u0006\u0004\bG\u0010HJ\u001f\u0010I\u001a\u00020#2\u0006\u0010F\u001a\u0002082\u0006\u0010\"\u001a\u00020 H\u0016¢\u0006\u0004\bI\u0010JJ\u001f\u0010K\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010F\u001a\u000208H\u0016¢\u0006\u0004\bK\u0010LJ\u0017\u0010M\u001a\u00020#2\u0006\u0010F\u001a\u000208H\u0016¢\u0006\u0004\bM\u0010NJ\u0010\u0010O\u001a\u00020#H\u0080@¢\u0006\u0004\bO\u0010PJ\u000f\u0010R\u001a\u00020QH\u0016¢\u0006\u0004\bR\u0010SJ'\u0010W\u001a\u00020#2\u0006\u0010T\u001a\u00020\u000b2\u0006\u00105\u001a\u0002042\u0006\u0010V\u001a\u00020UH\u0002¢\u0006\u0004\bW\u0010XJ\u0019\u0010Y\u001a\u0004\u0018\u00010\u00132\u0006\u0010B\u001a\u00020\u0012H\u0002¢\u0006\u0004\bY\u0010ZJ\u0017\u0010[\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b[\u0010\\R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\bI\u0010]\u001a\u0004\b^\u0010SR\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\bM\u0010_\u001a\u0004\b`\u0010aR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b6\u0010b\u001a\u0004\bc\u0010dR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b:\u0010b\u001a\u0004\be\u0010dR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b@\u0010b\u001a\u0004\bf\u0010dR\u001a\u0010\u0010\u001a\u00020\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b&\u0010g\u001a\u0004\bh\u0010iR \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010jR \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00150\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010jR\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010kR\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010lR\u0014\u0010o\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\u001a\u0010r\u001a\b\u0012\u0004\u0012\u00020#0p8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010qR\u0018\u0010u\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010tR$\u0010x\u001a\u0002082\u0006\u0010v\u001a\u0002088V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bm\u0010w\"\u0004\bs\u0010N¨\u0006y"}, d2 = {"Lx/M;", "Lx/L;", "Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "Landroidx/camera/camera2/pipe/l;", "Landroid/hardware/camera2/CaptureRequest;", "Lw/n;", "cameraId", "", "repeating", "", "captureRequestList", "Lw/K;", "captureMetadataList", "Landroidx/camera/camera2/pipe/t$a;", "listeners", "Landroidx/camera/camera2/pipe/l$a;", "sequenceListener", "", "Landroid/view/Surface;", "Lw/Q;", "surfaceToStreamMap", "Lw/G;", "surfaceToOutputMap", "Landroidx/camera/camera2/pipe/v;", "streamGraph", "Lw/S;", "strictMode", "<init>", "(Ljava/lang/String;ZLjava/util/List;Ljava/util/List;Ljava/util/List;Landroidx/camera/camera2/pipe/l$a;Ljava/util/Map;Ljava/util/Map;Landroidx/camera/camera2/pipe/v;Lw/S;Lkotlin/jvm/internal/i;)V", "Landroid/hardware/camera2/CameraCaptureSession;", "captureSession", "captureRequest", "", "captureTimestamp", "captureFrameNumber", "LY8/t;", "onCaptureStarted", "(Landroid/hardware/camera2/CameraCaptureSession;Landroid/hardware/camera2/CaptureRequest;JJ)V", "f", "(Landroid/hardware/camera2/CaptureRequest;JJ)V", "Landroid/hardware/camera2/CaptureResult;", "partialCaptureResult", "onCaptureProgressed", "(Landroid/hardware/camera2/CameraCaptureSession;Landroid/hardware/camera2/CaptureRequest;Landroid/hardware/camera2/CaptureResult;)V", "r", "(Landroid/hardware/camera2/CaptureRequest;Landroid/hardware/camera2/CaptureResult;)V", "session", "onReadoutStarted", "Landroid/hardware/camera2/TotalCaptureResult;", "captureResult", "onCaptureCompleted", "(Landroid/hardware/camera2/CameraCaptureSession;Landroid/hardware/camera2/CaptureRequest;Landroid/hardware/camera2/TotalCaptureResult;)V", "Lw/y;", "frameNumber", "c", "(Landroid/hardware/camera2/CaptureRequest;Landroid/hardware/camera2/TotalCaptureResult;J)V", "", "progress", Const.INTENT_KEY_UMID, "(Landroid/hardware/camera2/CaptureRequest;I)V", "Landroid/hardware/camera2/CaptureFailure;", "captureFailure", "onCaptureFailed", "(Landroid/hardware/camera2/CameraCaptureSession;Landroid/hardware/camera2/CaptureRequest;Landroid/hardware/camera2/CaptureFailure;)V", "e", "(Landroid/hardware/camera2/CaptureRequest;J)V", "surface", "frameId", "onCaptureBufferLost", "(Landroid/hardware/camera2/CameraCaptureSession;Landroid/hardware/camera2/CaptureRequest;Landroid/view/Surface;J)V", "captureSequenceId", "onCaptureSequenceCompleted", "(Landroid/hardware/camera2/CameraCaptureSession;IJ)V", Const.INTENT_KEY_APIKEY, "(IJ)V", "onCaptureSequenceAborted", "(Landroid/hardware/camera2/CameraCaptureSession;I)V", Const.INTENT_KEY_PKGNAME, "(I)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Le9/c;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "request", "Lw/J;", "requestFailure", "q", "(Lw/K;JLw/J;)V", "p", "(Landroid/view/Surface;)Lw/Q;", "s", "(Landroid/hardware/camera2/CaptureRequest;)Lw/K;", "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Z", "l", "()Z", "Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Ljava/util/List;", "n", "o", "Landroidx/camera/camera2/pipe/l$a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Landroidx/camera/camera2/pipe/l$a;", "Ljava/util/Map;", "Landroidx/camera/camera2/pipe/v;", "Lw/S;", "k", "J", "debugId", "LUa/u;", "LUa/u;", "hasStarted", "m", "Ljava/lang/Integer;", "_sequenceNumber", UxipConstants.f30680s, "()I", "sequenceNumber", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class M extends CameraCaptureSession.CaptureCallback implements L, androidx.camera.camera2.pipe.l<CaptureRequest> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String cameraId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final boolean repeating;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final List<CaptureRequest> captureRequestList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final List<w.K> captureMetadataList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final List<t.a> listeners;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final l.a sequenceListener;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final Map<Surface, w.Q> surfaceToStreamMap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final Map<Surface, w.G> surfaceToOutputMap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.camera2.pipe.v streamGraph;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final w.S strictMode;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final long debugId;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC1083u<Y8.t> hasStarted;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public volatile Integer _sequenceNumber;

    public /* synthetic */ M(String str, boolean z10, List list, List list2, List list3, l.a aVar, Map map, Map map2, androidx.camera.camera2.pipe.v vVar, w.S s10, kotlin.jvm.internal.i iVar) {
        this(str, z10, list, list2, list3, aVar, map, map2, vVar, s10);
    }

    @Override // x.L
    public void a(int captureSequenceId, long captureFrameNumber) {
        z.h hVar = z.h.f44503a;
        Trace.beginSection("onCaptureSequenceCompleted");
        this.hasStarted.complete(Y8.t.f7040a);
        getSequenceListener().a(this);
        w.S s10 = this.strictMode;
        if (!(k() == captureSequenceId)) {
            String str = "onCaptureSequenceCompleted was invoked on " + k() + ", but expected " + captureSequenceId + '!';
            if (s10.getEnabled()) {
                throw new IllegalStateException(str);
            }
            if (z.k.f44508a.d()) {
                Log.w("CXCP", str);
            }
        }
        long jB = w.y.b(captureFrameNumber);
        androidx.camera.camera2.pipe.n nVar = androidx.camera.camera2.pipe.n.f11059a;
        Trace.beginSection("InvokeInternalListeners");
        int size = n().size();
        for (int i10 = 0; i10 < size; i10++) {
            w.K k10 = n().get(i10);
            int size2 = o().size();
            for (int i11 = 0; i11 < size2; i11++) {
                o().get(i11).m(k10, jB);
            }
        }
        z.h hVar2 = z.h.f44503a;
        Trace.endSection();
        Trace.beginSection("InvokeRequestListeners");
        int size3 = n().size();
        for (int i12 = 0; i12 < size3; i12++) {
            w.K k11 = n().get(i12);
            int size4 = k11.getRequest().d().size();
            for (int i13 = 0; i13 < size4; i13++) {
                k11.getRequest().d().get(i13).m(k11, jB);
            }
        }
        z.h hVar3 = z.h.f44503a;
        Trace.endSection();
        Trace.endSection();
    }

    @Override // x.L
    public void b(int captureSequenceId) {
        z.h hVar = z.h.f44503a;
        Trace.beginSection("onCaptureSequenceAborted");
        this.hasStarted.complete(Y8.t.f7040a);
        getSequenceListener().a(this);
        w.S s10 = this.strictMode;
        if (!(k() == captureSequenceId)) {
            String str = "onCaptureSequenceAborted was invoked on " + k() + ", but expected " + captureSequenceId + '!';
            if (s10.getEnabled()) {
                throw new IllegalStateException(str);
            }
            if (z.k.f44508a.d()) {
                Log.w("CXCP", str);
            }
        }
        androidx.camera.camera2.pipe.n nVar = androidx.camera.camera2.pipe.n.f11059a;
        Trace.beginSection("InvokeInternalListeners");
        int size = n().size();
        for (int i10 = 0; i10 < size; i10++) {
            w.K k10 = n().get(i10);
            int size2 = o().size();
            for (int i11 = 0; i11 < size2; i11++) {
                o().get(i11).I0(k10);
            }
        }
        z.h hVar2 = z.h.f44503a;
        Trace.endSection();
        Trace.beginSection("InvokeRequestListeners");
        int size3 = n().size();
        for (int i12 = 0; i12 < size3; i12++) {
            w.K k11 = n().get(i12);
            int size4 = k11.getRequest().d().size();
            for (int i13 = 0; i13 < size4; i13++) {
                k11.getRequest().d().get(i13).I0(k11);
            }
        }
        z.h hVar3 = z.h.f44503a;
        Trace.endSection();
        Trace.endSection();
    }

    @Override // x.L
    public void c(CaptureRequest captureRequest, TotalCaptureResult captureResult, long frameNumber) {
        kotlin.jvm.internal.p.i(captureRequest, "captureRequest");
        kotlin.jvm.internal.p.i(captureResult, "captureResult");
        z.h hVar = z.h.f44503a;
        Trace.beginSection("onCaptureCompleted");
        Trace.beginSection("onCaptureSequenceComplete");
        getSequenceListener().a(this);
        Trace.endSection();
        w.K kS = s(captureRequest);
        FrameInfo frameInfo = new FrameInfo(captureResult, getCameraId(), kS, null);
        Trace.beginSection("onTotalCaptureResult");
        androidx.camera.camera2.pipe.n nVar = androidx.camera.camera2.pipe.n.f11059a;
        Trace.beginSection("InvokeInternalListeners");
        int size = o().size();
        for (int i10 = 0; i10 < size; i10++) {
            o().get(i10).N0(kS, frameNumber, frameInfo);
        }
        z.h hVar2 = z.h.f44503a;
        Trace.endSection();
        Trace.beginSection("InvokeRequestListeners");
        int size2 = kS.getRequest().d().size();
        for (int i11 = 0; i11 < size2; i11++) {
            kS.getRequest().d().get(i11).N0(kS, frameNumber, frameInfo);
        }
        z.h hVar3 = z.h.f44503a;
        Trace.endSection();
        Trace.endSection();
        Trace.beginSection("onComplete");
        androidx.camera.camera2.pipe.n nVar2 = androidx.camera.camera2.pipe.n.f11059a;
        Trace.beginSection("InvokeInternalListeners");
        int size3 = o().size();
        for (int i12 = 0; i12 < size3; i12++) {
            o().get(i12).g0(kS, frameNumber, frameInfo);
        }
        z.h hVar4 = z.h.f44503a;
        Trace.endSection();
        Trace.beginSection("InvokeRequestListeners");
        int size4 = kS.getRequest().d().size();
        for (int i13 = 0; i13 < size4; i13++) {
            kS.getRequest().d().get(i13).g0(kS, frameNumber, frameInfo);
        }
        z.h hVar5 = z.h.f44503a;
        Trace.endSection();
        Trace.endSection();
        Trace.endSection();
    }

    @Override // x.L
    public void d(CaptureRequest captureRequest, int progress) {
        kotlin.jvm.internal.p.i(captureRequest, "captureRequest");
        z.h hVar = z.h.f44503a;
        Trace.beginSection("onCaptureProcessProgressed");
        w.K kS = s(captureRequest);
        androidx.camera.camera2.pipe.n nVar = androidx.camera.camera2.pipe.n.f11059a;
        Trace.beginSection("InvokeInternalListeners");
        int size = o().size();
        for (int i10 = 0; i10 < size; i10++) {
            o().get(i10).v0(kS, progress);
        }
        z.h hVar2 = z.h.f44503a;
        Trace.endSection();
        Trace.beginSection("InvokeRequestListeners");
        int size2 = kS.getRequest().d().size();
        for (int i11 = 0; i11 < size2; i11++) {
            kS.getRequest().d().get(i11).v0(kS, progress);
        }
        z.h hVar3 = z.h.f44503a;
        Trace.endSection();
        Trace.endSection();
    }

    @Override // x.L
    public void e(CaptureRequest captureRequest, long frameNumber) {
        kotlin.jvm.internal.p.i(captureRequest, "captureRequest");
        z.h hVar = z.h.f44503a;
        Trace.beginSection("onCaptureFailed");
        this.hasStarted.complete(Y8.t.f7040a);
        w.K kS = s(captureRequest);
        q(kS, frameNumber, new ExtensionRequestFailure(kS, false, frameNumber, 0, null));
        Trace.endSection();
    }

    @Override // x.L
    public void f(CaptureRequest captureRequest, long captureFrameNumber, long captureTimestamp) {
        kotlin.jvm.internal.p.i(captureRequest, "captureRequest");
        z.h hVar = z.h.f44503a;
        Trace.beginSection("onCaptureStarted");
        long jA = w.r.a(captureTimestamp);
        long jB = w.y.b(captureFrameNumber);
        this.hasStarted.complete(Y8.t.f7040a);
        w.K kS = s(captureRequest);
        androidx.camera.camera2.pipe.n nVar = androidx.camera.camera2.pipe.n.f11059a;
        Trace.beginSection("InvokeInternalListeners");
        int size = o().size();
        for (int i10 = 0; i10 < size; i10++) {
            o().get(i10).A(kS, jB, jA);
        }
        z.h hVar2 = z.h.f44503a;
        Trace.endSection();
        Trace.beginSection("InvokeRequestListeners");
        int size2 = kS.getRequest().d().size();
        for (int i11 = 0; i11 < size2; i11++) {
            kS.getRequest().d().get(i11).A(kS, jB, jA);
        }
        z.h hVar3 = z.h.f44503a;
        Trace.endSection();
        Trace.endSection();
    }

    public final Object g(InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        Object objA1 = this.hasStarted.a1(interfaceC4014c);
        return objA1 == C4063a.g() ? objA1 : Y8.t.f7040a;
    }

    /* renamed from: h, reason: from getter */
    public String getCameraId() {
        return this.cameraId;
    }

    public List<CaptureRequest> i() {
        return this.captureRequestList;
    }

    /* renamed from: j, reason: from getter */
    public l.a getSequenceListener() {
        return this.sequenceListener;
    }

    public int k() {
        int iIntValue;
        if (this._sequenceNumber != null) {
            Integer num = this._sequenceNumber;
            if (num != null) {
                return num.intValue();
            }
            throw new IllegalStateException(("SequenceNumber has not been set for " + this + '!').toString());
        }
        synchronized (this) {
            Integer num2 = this._sequenceNumber;
            if (num2 == null) {
                throw new IllegalStateException(("SequenceNumber has not been set for " + this + '!').toString());
            }
            iIntValue = num2.intValue();
        }
        return iIntValue;
    }

    @Override // androidx.camera.camera2.pipe.l
    /* renamed from: l, reason: from getter */
    public boolean getRepeating() {
        return this.repeating;
    }

    @Override // androidx.camera.camera2.pipe.l
    public void m(int i10) {
        this._sequenceNumber = Integer.valueOf(i10);
    }

    @Override // androidx.camera.camera2.pipe.l
    public List<w.K> n() {
        return this.captureMetadataList;
    }

    @Override // androidx.camera.camera2.pipe.l
    public List<t.a> o() {
        return this.listeners;
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureBufferLost(CameraCaptureSession captureSession, CaptureRequest captureRequest, Surface surface, long frameId) {
        kotlin.jvm.internal.p.i(captureSession, "captureSession");
        kotlin.jvm.internal.p.i(captureRequest, "captureRequest");
        kotlin.jvm.internal.p.i(surface, "surface");
        z.h hVar = z.h.f44503a;
        Trace.beginSection("onCaptureBufferLost");
        long jB = w.y.b(frameId);
        w.Q qP = p(surface);
        w.G g10 = this.surfaceToOutputMap.get(surface);
        if (qP == null) {
            throw new IllegalStateException(("Unable to find the streamId for " + surface + " on " + ((Object) w.y.f(jB))).toString());
        }
        if (g10 == null) {
            throw new IllegalStateException(("Unable to find the outputId for " + surface + " on " + ((Object) w.y.f(jB))).toString());
        }
        w.K kS = s(captureRequest);
        androidx.camera.camera2.pipe.n nVar = androidx.camera.camera2.pipe.n.f11059a;
        Trace.beginSection("InvokeInternalListeners");
        int size = o().size();
        for (int i10 = 0; i10 < size; i10++) {
            o().get(i10).e(kS, jB, qP.getValue());
        }
        z.h hVar2 = z.h.f44503a;
        Trace.endSection();
        Trace.beginSection("InvokeRequestListeners");
        int size2 = kS.getRequest().d().size();
        for (int i11 = 0; i11 < size2; i11++) {
            kS.getRequest().d().get(i11).e(kS, jB, qP.getValue());
        }
        z.h hVar3 = z.h.f44503a;
        Trace.endSection();
        androidx.camera.camera2.pipe.n nVar2 = androidx.camera.camera2.pipe.n.f11059a;
        Trace.beginSection("InvokeInternalListeners");
        int size3 = o().size();
        for (int i12 = 0; i12 < size3; i12++) {
            o().get(i12).i(kS, jB, qP.getValue(), g10.getValue());
        }
        z.h hVar4 = z.h.f44503a;
        Trace.endSection();
        Trace.beginSection("InvokeRequestListeners");
        int size4 = kS.getRequest().d().size();
        for (int i13 = 0; i13 < size4; i13++) {
            kS.getRequest().d().get(i13).i(kS, jB, qP.getValue(), g10.getValue());
        }
        z.h hVar5 = z.h.f44503a;
        Trace.endSection();
        Trace.endSection();
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureCompleted(CameraCaptureSession captureSession, CaptureRequest captureRequest, TotalCaptureResult captureResult) {
        kotlin.jvm.internal.p.i(captureSession, "captureSession");
        kotlin.jvm.internal.p.i(captureRequest, "captureRequest");
        kotlin.jvm.internal.p.i(captureResult, "captureResult");
        c(captureRequest, captureResult, w.y.b(captureResult.getFrameNumber()));
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureFailed(CameraCaptureSession captureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
        kotlin.jvm.internal.p.i(captureSession, "captureSession");
        kotlin.jvm.internal.p.i(captureRequest, "captureRequest");
        kotlin.jvm.internal.p.i(captureFailure, "captureFailure");
        z.h hVar = z.h.f44503a;
        Trace.beginSection("onCaptureFailed");
        this.hasStarted.complete(Y8.t.f7040a);
        w.K kS = s(captureRequest);
        q(kS, w.y.b(captureFailure.getFrameNumber()), new C5811e(kS, captureFailure));
        Trace.endSection();
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureProgressed(CameraCaptureSession captureSession, CaptureRequest captureRequest, CaptureResult partialCaptureResult) {
        kotlin.jvm.internal.p.i(captureSession, "captureSession");
        kotlin.jvm.internal.p.i(captureRequest, "captureRequest");
        kotlin.jvm.internal.p.i(partialCaptureResult, "partialCaptureResult");
        r(captureRequest, partialCaptureResult);
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureSequenceAborted(CameraCaptureSession captureSession, int captureSequenceId) {
        kotlin.jvm.internal.p.i(captureSession, "captureSession");
        b(captureSequenceId);
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureSequenceCompleted(CameraCaptureSession captureSession, int captureSequenceId, long captureFrameNumber) {
        kotlin.jvm.internal.p.i(captureSession, "captureSession");
        a(captureSequenceId, captureFrameNumber);
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureStarted(CameraCaptureSession captureSession, CaptureRequest captureRequest, long captureTimestamp, long captureFrameNumber) {
        kotlin.jvm.internal.p.i(captureSession, "captureSession");
        kotlin.jvm.internal.p.i(captureRequest, "captureRequest");
        f(captureRequest, captureFrameNumber, captureTimestamp);
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onReadoutStarted(CameraCaptureSession session, CaptureRequest captureRequest, long captureTimestamp, long captureFrameNumber) {
        kotlin.jvm.internal.p.i(session, "session");
        kotlin.jvm.internal.p.i(captureRequest, "captureRequest");
        z.h hVar = z.h.f44503a;
        Trace.beginSection("onReadoutStarted");
        long jA = w.O.a(captureTimestamp);
        long jB = w.y.b(captureFrameNumber);
        w.K kS = s(captureRequest);
        androidx.camera.camera2.pipe.n nVar = androidx.camera.camera2.pipe.n.f11059a;
        Trace.beginSection("InvokeInternalListeners");
        int size = o().size();
        for (int i10 = 0; i10 < size; i10++) {
            o().get(i10).g(kS, jB, jA);
        }
        z.h hVar2 = z.h.f44503a;
        Trace.endSection();
        Trace.beginSection("InvokeRequestListeners");
        int size2 = kS.getRequest().d().size();
        for (int i11 = 0; i11 < size2; i11++) {
            kS.getRequest().d().get(i11).g(kS, jB, jA);
        }
        z.h hVar3 = z.h.f44503a;
        Trace.endSection();
        Trace.endSection();
    }

    public final w.Q p(Surface surface) {
        androidx.camera.camera2.pipe.k kVarK;
        w.Q q10 = this.surfaceToStreamMap.get(surface);
        if (q10 != null) {
            return q10;
        }
        w.G g10 = this.surfaceToOutputMap.get(surface);
        androidx.camera.camera2.pipe.s sVarG = g10 != null ? this.streamGraph.g(g10.getValue()) : null;
        if (sVarG == null || (kVarK = sVarG.k()) == null) {
            return null;
        }
        return w.Q.a(kVarK.getId());
    }

    public final void q(w.K request, long frameNumber, w.J requestFailure) {
        getSequenceListener().a(this);
        androidx.camera.camera2.pipe.n nVar = androidx.camera.camera2.pipe.n.f11059a;
        z.h hVar = z.h.f44503a;
        Trace.beginSection("InvokeInternalListeners");
        int size = o().size();
        for (int i10 = 0; i10 < size; i10++) {
            o().get(i10).Y(request, frameNumber, requestFailure);
        }
        z.h hVar2 = z.h.f44503a;
        Trace.endSection();
        Trace.beginSection("InvokeRequestListeners");
        int size2 = request.getRequest().d().size();
        for (int i11 = 0; i11 < size2; i11++) {
            request.getRequest().d().get(i11).Y(request, frameNumber, requestFailure);
        }
        z.h hVar3 = z.h.f44503a;
        Trace.endSection();
    }

    public void r(CaptureRequest captureRequest, CaptureResult partialCaptureResult) {
        kotlin.jvm.internal.p.i(captureRequest, "captureRequest");
        kotlin.jvm.internal.p.i(partialCaptureResult, "partialCaptureResult");
        z.h hVar = z.h.f44503a;
        Trace.beginSection("onCaptureProgressed");
        long jB = w.y.b(partialCaptureResult.getFrameNumber());
        FrameMetadata frameMetadata = new FrameMetadata(partialCaptureResult, getCameraId(), null);
        w.K kS = s(captureRequest);
        androidx.camera.camera2.pipe.n nVar = androidx.camera.camera2.pipe.n.f11059a;
        Trace.beginSection("InvokeInternalListeners");
        int size = o().size();
        for (int i10 = 0; i10 < size; i10++) {
            o().get(i10).D0(kS, jB, frameMetadata);
        }
        z.h hVar2 = z.h.f44503a;
        Trace.endSection();
        Trace.beginSection("InvokeRequestListeners");
        int size2 = kS.getRequest().d().size();
        for (int i11 = 0; i11 < size2; i11++) {
            kS.getRequest().d().get(i11).D0(kS, jB, frameMetadata);
        }
        z.h hVar3 = z.h.f44503a;
        Trace.endSection();
        Trace.endSection();
    }

    public final w.K s(CaptureRequest captureRequest) {
        int size = i().size();
        for (int i10 = 0; i10 < size; i10++) {
            if (i().get(i10) == captureRequest) {
                return n().get(i10);
            }
        }
        throw new IllegalArgumentException("Failed to find CaptureRequest " + captureRequest + " in " + i());
    }

    public String toString() {
        return "Camera2CaptureSequence-" + this.debugId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public M(String cameraId, boolean z10, List<CaptureRequest> captureRequestList, List<? extends w.K> captureMetadataList, List<? extends t.a> listeners, l.a sequenceListener, Map<Surface, w.Q> surfaceToStreamMap, Map<Surface, w.G> surfaceToOutputMap, androidx.camera.camera2.pipe.v streamGraph, w.S strictMode) {
        kotlin.jvm.internal.p.i(cameraId, "cameraId");
        kotlin.jvm.internal.p.i(captureRequestList, "captureRequestList");
        kotlin.jvm.internal.p.i(captureMetadataList, "captureMetadataList");
        kotlin.jvm.internal.p.i(listeners, "listeners");
        kotlin.jvm.internal.p.i(sequenceListener, "sequenceListener");
        kotlin.jvm.internal.p.i(surfaceToStreamMap, "surfaceToStreamMap");
        kotlin.jvm.internal.p.i(surfaceToOutputMap, "surfaceToOutputMap");
        kotlin.jvm.internal.p.i(streamGraph, "streamGraph");
        kotlin.jvm.internal.p.i(strictMode, "strictMode");
        this.cameraId = cameraId;
        this.repeating = z10;
        this.captureRequestList = captureRequestList;
        this.captureMetadataList = captureMetadataList;
        this.listeners = listeners;
        this.sequenceListener = sequenceListener;
        this.surfaceToStreamMap = surfaceToStreamMap;
        this.surfaceToOutputMap = surfaceToOutputMap;
        this.streamGraph = streamGraph;
        this.strictMode = strictMode;
        this.debugId = O.a().c();
        this.hasStarted = C1087w.c(null, 1, null);
        if (i().size() != n().size()) {
            throw new IllegalStateException("CaptureRequestList and CaptureMetadataList must have a 1:1 mapping.");
        }
    }
}
