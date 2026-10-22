package androidx.camera.core.processing.concurrent;

import androidx.camera.core.processing.SurfaceEdge;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_DualSurfaceProcessorNode_In extends DualSurfaceProcessorNode.In {
    private final List<DualOutConfig> outConfigs;
    private final SurfaceEdge primarySurfaceEdge;
    private final SurfaceEdge secondarySurfaceEdge;

    public int hashCode() {
        return ((((this.primarySurfaceEdge.hashCode() ^ 1000003) * 1000003) ^ this.secondarySurfaceEdge.hashCode()) * 1000003) ^ this.outConfigs.hashCode();
    }

    public String toString() {
        return "In{primarySurfaceEdge=" + this.primarySurfaceEdge + ", secondarySurfaceEdge=" + this.secondarySurfaceEdge + ", outConfigs=" + this.outConfigs + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.core.processing.concurrent.DualSurfaceProcessorNode.In
    public List<DualOutConfig> getOutConfigs() {
        return this.outConfigs;
    }

    @Override // androidx.camera.core.processing.concurrent.DualSurfaceProcessorNode.In
    public SurfaceEdge getPrimarySurfaceEdge() {
        return this.primarySurfaceEdge;
    }

    @Override // androidx.camera.core.processing.concurrent.DualSurfaceProcessorNode.In
    public SurfaceEdge getSecondarySurfaceEdge() {
        return this.secondarySurfaceEdge;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof DualSurfaceProcessorNode.In) == false) goto L16;
        DualSurfaceProcessorNode.In r101 = (DualSurfaceProcessorNode.In) r100;
        if (this.primarySurfaceEdge.equals(r101.getPrimarySurfaceEdge()) == true) goto L10;
    L14:
        return false;
    L10:
        if (this.secondarySurfaceEdge.equals(r101.getSecondarySurfaceEdge()) == false) goto L14;
        if (this.outConfigs.equals(r101.getOutConfigs()) == false) goto L14;
        return true;
    L16:
        return false;
    }

    public AutoValue_DualSurfaceProcessorNode_In(SurfaceEdge r100, SurfaceEdge r101, List<DualOutConfig> r102) {
        if (r100 == null) goto L15;
        this.primarySurfaceEdge = r100;
        if (r101 == null) goto L13;
        this.secondarySurfaceEdge = r101;
        if (r102 == null) goto L11;
        this.outConfigs = r102;
        return;
    L11:
        throw new NullPointerException("Null outConfigs");
    L13:
        throw new NullPointerException("Null secondarySurfaceEdge");
    L15:
        throw new NullPointerException("Null primarySurfaceEdge");
    }
}
