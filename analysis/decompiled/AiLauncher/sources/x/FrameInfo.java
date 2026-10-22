package x;

import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Trace;
import android.util.ArrayMap;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import java.util.Map;
import kotlin.Metadata;
import w.C5708n;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ)\u0010\u000e\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u000b*\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR \u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020 0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lx/g;", "Lw/w;", "Landroid/hardware/camera2/TotalCaptureResult;", "totalCaptureResult", "Lw/n;", C3081a.CAMERA_FOCUS, "Lw/K;", "requestMetadata", "<init>", "(Landroid/hardware/camera2/TotalCaptureResult;Ljava/lang/String;Lw/K;Lkotlin/jvm/internal/i;)V", "", ExifInterface.GPS_DIRECTION_TRUE, "Lw9/d;", "type", "R0", "(Lw9/d;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Landroid/hardware/camera2/TotalCaptureResult;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "c", "Lw/K;", "getRequestMetadata", "()Lw/K;", "Lx/h;", Const.INTENT_KEY_UMID, "Lx/h;", "result", "", "Lw/x;", "e", "Ljava/util/Map;", "physicalResults", "getMetadata", "()Lw/x;", "metadata", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: x.g, reason: case insensitive filesystem and from toString */
/* loaded from: classes.dex */
public final class FrameInfo implements w.w {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final TotalCaptureResult totalCaptureResult;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String camera;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final w.K requestMetadata;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final FrameMetadata result;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Map<C5708n, w.x> physicalResults;

    public /* synthetic */ FrameInfo(TotalCaptureResult totalCaptureResult, String str, w.K k10, kotlin.jvm.internal.i iVar) {
        this(totalCaptureResult, str, k10);
    }

    @Override // w.U
    public <T> T R0(InterfaceC5745d<T> type) {
        T t10;
        kotlin.jvm.internal.p.i(type, "type");
        if (kotlin.jvm.internal.p.d(type, kotlin.jvm.internal.t.b(CaptureResult.class))) {
            T t11 = (T) this.totalCaptureResult;
            kotlin.jvm.internal.p.g(t11, "null cannot be cast to non-null type T of androidx.camera.camera2.pipe.compat.AndroidFrameInfo.unwrapAs");
            return t11;
        }
        if (!kotlin.jvm.internal.p.d(type, kotlin.jvm.internal.t.b(TotalCaptureResult.class)) || (t10 = (T) this.totalCaptureResult) == null) {
            return null;
        }
        return t10;
    }

    /* renamed from: b, reason: from getter */
    public String getCamera() {
        return this.camera;
    }

    @Override // w.w
    public w.x getMetadata() {
        return this.result;
    }

    public String toString() {
        return "FrameInfo(camera: " + ((Object) C5708n.f(this.result.getCamera())) + ", frameNumber: " + this.result.m1() + ')';
    }

    public FrameInfo(TotalCaptureResult totalCaptureResult, String camera, w.K requestMetadata) {
        Map<C5708n, w.x> mapI;
        kotlin.jvm.internal.p.i(totalCaptureResult, "totalCaptureResult");
        kotlin.jvm.internal.p.i(camera, "camera");
        kotlin.jvm.internal.p.i(requestMetadata, "requestMetadata");
        this.totalCaptureResult = totalCaptureResult;
        this.camera = camera;
        this.requestMetadata = requestMetadata;
        this.result = new FrameMetadata(totalCaptureResult, getCamera(), null);
        z.h hVar = z.h.f44503a;
        try {
            Trace.beginSection("physicalCaptureResults");
            Map<String, CaptureResult> mapD = C5828n.d(this.totalCaptureResult);
            kotlin.jvm.internal.p.g(mapD, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, android.hardware.camera2.CaptureResult>");
            if (mapD == null || mapD.isEmpty()) {
                mapI = kotlin.collections.a.i();
            } else {
                mapI = new ArrayMap<>(mapD.size());
                for (Map.Entry<String, CaptureResult> entry : mapD.entrySet()) {
                    String strB = C5708n.b(entry.getKey());
                    mapI.put(C5708n.a(strB), new FrameMetadata(entry.getValue(), strB, null));
                }
            }
            Trace.endSection();
            this.physicalResults = mapI;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }
}
