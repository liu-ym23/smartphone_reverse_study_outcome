package C;

import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.h;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"LC/i;", "LC/m;", "Landroidx/camera/camera2/pipe/core/Threads;", "threads", "Landroidx/camera/camera2/pipe/h$e;", "cameraPipeConfig", "<init>", "(Landroidx/camera/camera2/pipe/core/Threads;Landroidx/camera/camera2/pipe/h$e;)V", Const.INTENT_KEY_APIKEY, "Landroidx/camera/camera2/pipe/core/Threads;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class i implements m {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Threads threads;

    public i(Threads threads, h.Config cameraPipeConfig) {
        kotlin.jvm.internal.p.i(threads, "threads");
        kotlin.jvm.internal.p.i(cameraPipeConfig, "cameraPipeConfig");
        this.threads = threads;
        cameraPipeConfig.g();
    }
}
