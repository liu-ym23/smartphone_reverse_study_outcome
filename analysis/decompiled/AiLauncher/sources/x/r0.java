package x;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.credential.api.AuthSessionDto;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import w.ConcurrentCameraGraphs;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000bR \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lx/r0;", "", "<init>", "()V", "Landroidx/camera/camera2/pipe/e;", "cameraGraphId", "Lw/s;", "concurrentCameraGraphs", "Lx/q0;", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/camera2/pipe/e;Lw/s;)Lx/q0;", "Ljava/lang/Object;", "lock", "", Const.INTENT_KEY_PKGNAME, "Ljava/util/Map;", "sequencers", "", "c", "Ljava/util/Set;", AuthSessionDto.STATUS_PENDING, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class r0 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Object lock = new Object();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Map<ConcurrentCameraGraphs, q0> sequencers = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Set<androidx.camera.camera2.pipe.e> pending = new LinkedHashSet();

    public final q0 a(androidx.camera.camera2.pipe.e cameraGraphId, ConcurrentCameraGraphs concurrentCameraGraphs) {
        q0 q0Var;
        kotlin.jvm.internal.p.i(cameraGraphId, "cameraGraphId");
        kotlin.jvm.internal.p.i(concurrentCameraGraphs, "concurrentCameraGraphs");
        synchronized (this.lock) {
            try {
                if (!this.sequencers.containsKey(concurrentCameraGraphs)) {
                    q0 q0Var2 = new q0();
                    this.sequencers.put(concurrentCameraGraphs, q0Var2);
                    this.pending.addAll(Z8.Z.n(concurrentCameraGraphs.a(), cameraGraphId));
                    return q0Var2;
                }
                this.pending.remove(cameraGraphId);
                Set<androidx.camera.camera2.pipe.e> setA = concurrentCameraGraphs.a();
                if (!(setA instanceof Collection) || !setA.isEmpty()) {
                    Iterator<T> it = setA.iterator();
                    while (it.hasNext()) {
                        if (this.pending.contains((androidx.camera.camera2.pipe.e) it.next())) {
                            q0 q0Var3 = this.sequencers.get(concurrentCameraGraphs);
                            if (q0Var3 == null) {
                                throw new IllegalStateException("Required value was null.");
                            }
                            q0Var = q0Var3;
                            return q0Var;
                        }
                    }
                }
                q0 q0VarRemove = this.sequencers.remove(concurrentCameraGraphs);
                if (q0VarRemove == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                q0Var = q0VarRemove;
                return q0Var;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
