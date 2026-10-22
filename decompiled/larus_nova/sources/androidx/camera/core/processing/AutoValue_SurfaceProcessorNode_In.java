package androidx.camera.core.processing;

import androidx.camera.core.processing.util.OutConfig;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_SurfaceProcessorNode_In extends SurfaceProcessorNode.In {
    private final List<OutConfig> outConfigs;
    private final SurfaceEdge surfaceEdge;

    public int hashCode() {
        return ((this.surfaceEdge.hashCode() ^ 1000003) * 1000003) ^ this.outConfigs.hashCode();
    }

    public String toString() {
        return "In{surfaceEdge=" + this.surfaceEdge + ", outConfigs=" + this.outConfigs + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorNode.In
    public List<OutConfig> getOutConfigs() {
        return this.outConfigs;
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorNode.In
    public SurfaceEdge getSurfaceEdge() {
        return this.surfaceEdge;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof SurfaceProcessorNode.In) == false) goto L14;
        SurfaceProcessorNode.In r101 = (SurfaceProcessorNode.In) r100;
        if (this.surfaceEdge.equals(r101.getSurfaceEdge()) == true) goto L10;
    L12:
        return false;
    L10:
        if (this.outConfigs.equals(r101.getOutConfigs()) == false) goto L12;
        return true;
    L14:
        return false;
    }

    public AutoValue_SurfaceProcessorNode_In(SurfaceEdge r100, List<OutConfig> r101) {
        if (r100 == null) goto L11;
        this.surfaceEdge = r100;
        if (r101 == null) goto L9;
        this.outConfigs = r101;
        return;
    L9:
        throw new NullPointerException("Null outConfigs");
    L11:
        throw new NullPointerException("Null surfaceEdge");
    }
}
