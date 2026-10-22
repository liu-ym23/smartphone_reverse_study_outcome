package androidx.camera.camera2.pipe.compat;

import B.f;
import Ua.C1060i;
import Ua.CoroutineName;
import Ua.L0;
import Ua.M;
import android.hardware.camera2.CameraManager;
import androidx.camera.camera2.pipe.core.Threads;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001b\u001a\n \u0018*\u0004\u0018\u00010\u00030\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00110$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R \u0010-\u001a\b\u0012\u0004\u0012\u00020\u00110(8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020\r0.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R \u00107\u001a\b\u0012\u0004\u0012\u00020\r028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010=\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006>"}, d2 = {"Landroidx/camera/camera2/pipe/compat/Camera2CameraStatusMonitor;", "LB/f;", "LX8/a;", "Landroid/hardware/camera2/CameraManager;", "cameraManager", "Landroidx/camera/camera2/pipe/core/Threads;", "threads", "Lw/n;", "cameraId", "Lkotlinx/coroutines/g;", "cameraPipeJob", "<init>", "(LX8/a;Landroidx/camera/camera2/pipe/core/Threads;Ljava/lang/String;Lkotlinx/coroutines/g;Lkotlin/jvm/internal/i;)V", "LY8/t;", "close", "()V", "LXa/b;", "LB/f$a;", "n", "()LXa/b;", Const.INTENT_KEY_APIKEY, "Landroidx/camera/camera2/pipe/core/Threads;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "kotlin.jvm.PlatformType", "c", "Landroid/hardware/camera2/CameraManager;", "manager", "LUa/M;", Const.INTENT_KEY_UMID, "LUa/M;", "scope", "LOa/a;", "e", "LOa/a;", AlipayXuiIsland.REASON_CLOSED, "LXa/k;", "f", "LXa/k;", "_cameraAvailability", "LXa/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "LXa/t;", "b0", "()LXa/t;", "cameraAvailability", "LXa/j;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "LXa/j;", "_cameraPriorities", "LXa/o;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "LXa/o;", "O", "()LXa/o;", "cameraPriorities", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "LXa/b;", "cameraStatus", "k", "Lkotlinx/coroutines/g;", "cameraStatusJob", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Camera2CameraStatusMonitor implements B.f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Threads threads;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String cameraId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final CameraManager manager;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final M scope;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Oa.a closed;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final Xa.k<f.a> _cameraAvailability;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final Xa.t<f.a> cameraAvailability;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final Xa.j<Y8.t> _cameraPriorities;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final Xa.o<Y8.t> cameraPriorities;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final Xa.b<f.a> cameraStatus;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final kotlinx.coroutines.g cameraStatusJob;

    public /* synthetic */ Camera2CameraStatusMonitor(X8.a aVar, Threads threads, String str, kotlinx.coroutines.g gVar, kotlin.jvm.internal.i iVar) {
        this(aVar, threads, str, gVar);
    }

    @Override // B.f
    public Xa.o<Y8.t> O() {
        return this.cameraPriorities;
    }

    @Override // B.f
    public Xa.t<f.a> b0() {
        return this.cameraAvailability;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        if (this.closed.a(false, true)) {
            kotlinx.coroutines.g.Y0(this.cameraStatusJob, null, 1, null);
            kotlinx.coroutines.d.e(this.scope, null, 1, null);
        }
    }

    public final Xa.b<f.a> n() {
        return Xa.d.f(new Camera2CameraStatusMonitor$cameraStatusFlow$1(this, null));
    }

    public Camera2CameraStatusMonitor(X8.a<CameraManager> cameraManager, Threads threads, String cameraId, kotlinx.coroutines.g cameraPipeJob) {
        kotlin.jvm.internal.p.i(cameraManager, "cameraManager");
        kotlin.jvm.internal.p.i(threads, "threads");
        kotlin.jvm.internal.p.i(cameraId, "cameraId");
        kotlin.jvm.internal.p.i(cameraPipeJob, "cameraPipeJob");
        this.threads = threads;
        this.cameraId = cameraId;
        this.manager = cameraManager.get();
        M mA = kotlinx.coroutines.d.a(L0.a(cameraPipeJob).plus(threads.getLightweightDispatcher().plus(new CoroutineName("CXCP-CameraStatusMonitor"))));
        this.scope = mA;
        this.closed = Oa.b.a(false);
        Xa.k<f.a> kVarA = Xa.u.a(f.a.d.f1402a);
        this._cameraAvailability = kVarA;
        this.cameraAvailability = Xa.d.c(kVarA);
        Xa.j<Y8.t> jVarB = Xa.p.b(0, 0, null, 7, null);
        this._cameraPriorities = jVarB;
        this.cameraPriorities = Xa.d.b(jVarB);
        this.cameraStatus = n();
        this.cameraStatusJob = C1060i.d(mA, null, null, new Camera2CameraStatusMonitor$cameraStatusJob$1(this, null), 3, null);
    }
}
