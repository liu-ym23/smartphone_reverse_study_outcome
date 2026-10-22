package w;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0080\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0014\u001a\u0004\b\u0016\u0010\u0015¨\u0006\u0017"}, d2 = {"Lw/s;", "", "", "Landroidx/camera/camera2/pipe/e;", "cameraGraphIds", "Lw/n;", "cameraIds", "<init>", "(Ljava/util/Set;Ljava/util/Set;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/util/Set;", "()Ljava/util/Set;", Const.INTENT_KEY_PKGNAME, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: w.s, reason: case insensitive filesystem and from toString */
/* loaded from: classes.dex */
public final /* data */ class ConcurrentCameraGraphs {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final Set<androidx.camera.camera2.pipe.e> cameraGraphIds;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final Set<C5708n> cameraIds;

    public ConcurrentCameraGraphs(Set<androidx.camera.camera2.pipe.e> cameraGraphIds, Set<C5708n> cameraIds) {
        kotlin.jvm.internal.p.i(cameraGraphIds, "cameraGraphIds");
        kotlin.jvm.internal.p.i(cameraIds, "cameraIds");
        this.cameraGraphIds = cameraGraphIds;
        this.cameraIds = cameraIds;
        if (cameraGraphIds.size() <= 1) {
            throw new IllegalStateException("Check failed.");
        }
        if (cameraGraphIds.size() != cameraIds.size()) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public final Set<androidx.camera.camera2.pipe.e> a() {
        return this.cameraGraphIds;
    }

    public final Set<C5708n> b() {
        return this.cameraIds;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConcurrentCameraGraphs)) {
            return false;
        }
        ConcurrentCameraGraphs concurrentCameraGraphs = (ConcurrentCameraGraphs) other;
        return kotlin.jvm.internal.p.d(this.cameraGraphIds, concurrentCameraGraphs.cameraGraphIds) && kotlin.jvm.internal.p.d(this.cameraIds, concurrentCameraGraphs.cameraIds);
    }

    public int hashCode() {
        return (this.cameraGraphIds.hashCode() * 31) + this.cameraIds.hashCode();
    }

    public String toString() {
        return "ConcurrentCameraGraphs(cameraGraphIds=" + this.cameraGraphIds + ", cameraIds=" + this.cameraIds + ')';
    }
}
