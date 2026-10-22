package K;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0016\u0010\u0005\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ \u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u000f\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0010J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R'\u0010\u0005\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\rR#\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001b\u0010\rR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0010¨\u0006\u001e"}, d2 = {"LK/D0;", "", "", "Landroidx/camera/core/impl/z;", "Landroidx/camera/core/impl/y;", "useCaseStreamSpecs", "Landroidx/camera/core/impl/b;", "attachedSurfaceStreamSpecs", "", "maxSupportedFrameRate", "<init>", "(Ljava/util/Map;Ljava/util/Map;I)V", Const.INTENT_KEY_APIKEY, "()Ljava/util/Map;", Const.INTENT_KEY_PKGNAME, "c", "()I", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getUseCaseStreamSpecs", "getAttachedSurfaceStreamSpecs", "I", "getMaxSupportedFrameRate", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: K.D0, reason: from toString */
/* loaded from: classes.dex */
public final /* data */ class SurfaceStreamSpecQueryResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final Map<androidx.camera.core.impl.z<?>, androidx.camera.core.impl.y> useCaseStreamSpecs;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final Map<androidx.camera.core.impl.b, androidx.camera.core.impl.y> attachedSurfaceStreamSpecs;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final int maxSupportedFrameRate;

    /* JADX WARN: Multi-variable type inference failed */
    public SurfaceStreamSpecQueryResult(Map<androidx.camera.core.impl.z<?>, ? extends androidx.camera.core.impl.y> useCaseStreamSpecs, Map<androidx.camera.core.impl.b, ? extends androidx.camera.core.impl.y> attachedSurfaceStreamSpecs, int i10) {
        kotlin.jvm.internal.p.i(useCaseStreamSpecs, "useCaseStreamSpecs");
        kotlin.jvm.internal.p.i(attachedSurfaceStreamSpecs, "attachedSurfaceStreamSpecs");
        this.useCaseStreamSpecs = useCaseStreamSpecs;
        this.attachedSurfaceStreamSpecs = attachedSurfaceStreamSpecs;
        this.maxSupportedFrameRate = i10;
    }

    public final Map<androidx.camera.core.impl.z<?>, androidx.camera.core.impl.y> a() {
        return this.useCaseStreamSpecs;
    }

    public final Map<androidx.camera.core.impl.b, androidx.camera.core.impl.y> b() {
        return this.attachedSurfaceStreamSpecs;
    }

    /* renamed from: c, reason: from getter */
    public final int getMaxSupportedFrameRate() {
        return this.maxSupportedFrameRate;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SurfaceStreamSpecQueryResult)) {
            return false;
        }
        SurfaceStreamSpecQueryResult surfaceStreamSpecQueryResult = (SurfaceStreamSpecQueryResult) other;
        return kotlin.jvm.internal.p.d(this.useCaseStreamSpecs, surfaceStreamSpecQueryResult.useCaseStreamSpecs) && kotlin.jvm.internal.p.d(this.attachedSurfaceStreamSpecs, surfaceStreamSpecQueryResult.attachedSurfaceStreamSpecs) && this.maxSupportedFrameRate == surfaceStreamSpecQueryResult.maxSupportedFrameRate;
    }

    public int hashCode() {
        return (((this.useCaseStreamSpecs.hashCode() * 31) + this.attachedSurfaceStreamSpecs.hashCode()) * 31) + Integer.hashCode(this.maxSupportedFrameRate);
    }

    public String toString() {
        return "SurfaceStreamSpecQueryResult(useCaseStreamSpecs=" + this.useCaseStreamSpecs + ", attachedSurfaceStreamSpecs=" + this.attachedSurfaceStreamSpecs + ", maxSupportedFrameRate=" + this.maxSupportedFrameRate + ')';
    }
}
