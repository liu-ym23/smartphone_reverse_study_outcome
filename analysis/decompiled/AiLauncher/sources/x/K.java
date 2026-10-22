package x;

import android.annotation.SuppressLint;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Trace;
import androidx.camera.camera2.pipe.core.Threads;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import w.C5708n;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ \u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0097@¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lx/K;", "Lx/h0;", "LX8/a;", "Landroid/hardware/camera2/CameraManager;", "cameraManager", "Landroidx/camera/camera2/pipe/core/Threads;", "threads", "<init>", "(LX8/a;Landroidx/camera/camera2/pipe/core/Threads;)V", "Lw/n;", "cameraId", "Landroid/hardware/camera2/CameraDevice$StateCallback;", "stateCallback", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Landroid/hardware/camera2/CameraDevice$StateCallback;Le9/c;)Ljava/lang/Object;", "LX8/a;", Const.INTENT_KEY_PKGNAME, "Landroidx/camera/camera2/pipe/core/Threads;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class K implements InterfaceC5818h0 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final X8.a<CameraManager> cameraManager;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Threads threads;

    public K(X8.a<CameraManager> cameraManager, Threads threads) {
        kotlin.jvm.internal.p.i(cameraManager, "cameraManager");
        kotlin.jvm.internal.p.i(threads, "threads");
        this.cameraManager = cameraManager;
        this.threads = threads;
    }

    @Override // x.InterfaceC5818h0
    @SuppressLint({"MissingPermission"})
    public Object a(String str, CameraDevice.StateCallback stateCallback, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        CameraManager cameraManager = this.cameraManager.get();
        z.h hVar = z.h.f44503a;
        try {
            Trace.beginSection(((Object) C5708n.f(str)) + "#openCamera");
            kotlin.jvm.internal.p.f(cameraManager);
            C5823k.g(cameraManager, str, this.threads.h(), stateCallback);
            Y8.t tVar = Y8.t.f7040a;
            Trace.endSection();
            return Y8.t.f7040a;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }
}
