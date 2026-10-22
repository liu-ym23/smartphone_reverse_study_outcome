package androidx.camera.camera2.pipe.compat;

import A.StreamGraph;
import android.util.Log;
import android.view.Surface;
import androidx.camera.camera2.pipe.compat.r;
import androidx.camera.camera2.pipe.core.Threads;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import w.Q;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J3\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/camera/camera2/pipe/compat/e;", "Landroidx/camera/camera2/pipe/compat/r;", "LA/q;", "streamGraph", "Landroidx/camera/camera2/pipe/core/Threads;", "threads", "<init>", "(LA/q;Landroidx/camera/camera2/pipe/core/Threads;)V", "Landroidx/camera/camera2/pipe/compat/p;", "cameraDevice", "", "Lw/Q;", "Landroid/view/Surface;", "surfaces", "Landroidx/camera/camera2/pipe/compat/CaptureSessionState;", "captureSessionState", "Landroidx/camera/camera2/pipe/compat/r$a;", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/camera2/pipe/compat/p;Ljava/util/Map;Landroidx/camera/camera2/pipe/compat/CaptureSessionState;)Landroidx/camera/camera2/pipe/compat/r$a;", "LA/q;", Const.INTENT_KEY_PKGNAME, "Landroidx/camera/camera2/pipe/core/Threads;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class e implements r {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final StreamGraph streamGraph;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Threads threads;

    public e(StreamGraph streamGraph, Threads threads) {
        kotlin.jvm.internal.p.i(streamGraph, "streamGraph");
        kotlin.jvm.internal.p.i(threads, "threads");
        this.streamGraph = streamGraph;
        this.threads = threads;
    }

    @Override // androidx.camera.camera2.pipe.compat.r
    public r.a a(p cameraDevice, Map<Q, ? extends Surface> surfaces, CaptureSessionState captureSessionState) {
        kotlin.jvm.internal.p.i(cameraDevice, "cameraDevice");
        kotlin.jvm.internal.p.i(surfaces, "surfaces");
        kotlin.jvm.internal.p.i(captureSessionState, "captureSessionState");
        ArrayList arrayList = new ArrayList(surfaces.size());
        Iterator<Map.Entry<Q, ? extends Surface>> it = surfaces.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        if (cameraDevice.Y(arrayList, captureSessionState)) {
            return new r.a.Success(kotlin.collections.a.i(), s.c(surfaces, this.streamGraph));
        }
        if (z.k.f44508a.d()) {
            Log.w("CXCP", "Failed to create ConstrainedHighSpeedCaptureSession from " + cameraDevice + " for " + captureSessionState + '!');
        }
        captureSessionState.a();
        return r.a.C0137a.f10670a;
    }
}
