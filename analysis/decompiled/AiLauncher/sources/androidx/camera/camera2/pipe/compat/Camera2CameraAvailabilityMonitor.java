package androidx.camera.camera2.pipe.compat;

import android.hardware.camera2.CameraManager;
import androidx.camera.camera2.pipe.compat.n;
import androidx.camera.camera2.pipe.core.Threads;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import w.C5708n;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B)\b\u0007\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Landroidx/camera/camera2/pipe/compat/Camera2CameraAvailabilityMonitor;", "Landroidx/camera/camera2/pipe/compat/n;", "LX8/a;", "Landroid/hardware/camera2/CameraManager;", "cameraManager", "Landroidx/camera/camera2/pipe/core/Threads;", "threads", "Lkotlinx/coroutines/g;", "cameraPipeJob", "<init>", "(LX8/a;Landroidx/camera/camera2/pipe/core/Threads;Lkotlinx/coroutines/g;)V", "Lw/n;", "cameraId", "Landroidx/camera/camera2/pipe/compat/n$a;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "LX8/a;", Const.INTENT_KEY_PKGNAME, "Landroidx/camera/camera2/pipe/core/Threads;", "c", "Lkotlinx/coroutines/g;", "LXa/b;", Const.INTENT_KEY_UMID, "LXa/b;", "availableCameraFlow", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Camera2CameraAvailabilityMonitor implements n {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final X8.a<CameraManager> cameraManager;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Threads threads;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final kotlinx.coroutines.g cameraPipeJob;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Xa.b<C5708n> availableCameraFlow;

    public Camera2CameraAvailabilityMonitor(X8.a<CameraManager> cameraManager, Threads threads, kotlinx.coroutines.g cameraPipeJob) {
        kotlin.jvm.internal.p.i(cameraManager, "cameraManager");
        kotlin.jvm.internal.p.i(threads, "threads");
        kotlin.jvm.internal.p.i(cameraPipeJob, "cameraPipeJob");
        this.cameraManager = cameraManager;
        this.threads = threads;
        this.cameraPipeJob = cameraPipeJob;
        this.availableCameraFlow = Xa.d.f(new Camera2CameraAvailabilityMonitor$availableCameraFlow$1(this, null));
    }

    @Override // androidx.camera.camera2.pipe.compat.n
    public Object a(String str, InterfaceC4014c<? super n.a> interfaceC4014c) {
        return new Camera2CameraAvailabilityMonitor$startMonitoring$2(this, str);
    }
}
