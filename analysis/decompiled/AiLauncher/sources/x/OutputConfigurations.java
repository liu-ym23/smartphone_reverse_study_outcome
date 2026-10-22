package x;

import android.view.Surface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0080\b\u0018\u00002\u00020\u0001BG\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001aR#\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00058\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u001dR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R#\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u00058\u0006¢\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b\u001e\u0010\u001d¨\u0006\""}, d2 = {"Lx/x0;", "", "", "Lx/w0;", "all", "", "Lw/Q;", "deferred", "postviewOutput", "Lw/G;", "Landroid/view/Surface;", "outputSurfaceMap", "<init>", "(Ljava/util/List;Ljava/util/Map;Lx/w0;Ljava/util/Map;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/util/List;", "()Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "Ljava/util/Map;", "()Ljava/util/Map;", "c", "Lx/w0;", Const.INTENT_KEY_UMID, "()Lx/w0;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: x.x0, reason: from toString */
/* loaded from: classes.dex */
public final /* data */ class OutputConfigurations {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final List<w0> all;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final Map<w.Q, w0> deferred;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final w0 postviewOutput;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final Map<w.G, Surface> outputSurfaceMap;

    /* JADX WARN: Multi-variable type inference failed */
    public OutputConfigurations(List<? extends w0> all, Map<w.Q, ? extends w0> deferred, w0 w0Var, Map<w.G, ? extends Surface> outputSurfaceMap) {
        kotlin.jvm.internal.p.i(all, "all");
        kotlin.jvm.internal.p.i(deferred, "deferred");
        kotlin.jvm.internal.p.i(outputSurfaceMap, "outputSurfaceMap");
        this.all = all;
        this.deferred = deferred;
        this.postviewOutput = w0Var;
        this.outputSurfaceMap = outputSurfaceMap;
    }

    public final List<w0> a() {
        return this.all;
    }

    public final Map<w.Q, w0> b() {
        return this.deferred;
    }

    public final Map<w.G, Surface> c() {
        return this.outputSurfaceMap;
    }

    /* renamed from: d, reason: from getter */
    public final w0 getPostviewOutput() {
        return this.postviewOutput;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OutputConfigurations)) {
            return false;
        }
        OutputConfigurations outputConfigurations = (OutputConfigurations) other;
        return kotlin.jvm.internal.p.d(this.all, outputConfigurations.all) && kotlin.jvm.internal.p.d(this.deferred, outputConfigurations.deferred) && kotlin.jvm.internal.p.d(this.postviewOutput, outputConfigurations.postviewOutput) && kotlin.jvm.internal.p.d(this.outputSurfaceMap, outputConfigurations.outputSurfaceMap);
    }

    public int hashCode() {
        int iHashCode = ((this.all.hashCode() * 31) + this.deferred.hashCode()) * 31;
        w0 w0Var = this.postviewOutput;
        return ((iHashCode + (w0Var == null ? 0 : w0Var.hashCode())) * 31) + this.outputSurfaceMap.hashCode();
    }

    public String toString() {
        return "OutputConfigurations(all=" + this.all + ", deferred=" + this.deferred + ", postviewOutput=" + this.postviewOutput + ", outputSurfaceMap=" + this.outputSurfaceMap + ')';
    }
}
