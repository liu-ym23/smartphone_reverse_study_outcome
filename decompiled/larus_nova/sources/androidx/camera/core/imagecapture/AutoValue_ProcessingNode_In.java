package androidx.camera.core.imagecapture;

import androidx.camera.core.processing.Edge;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_ProcessingNode_In extends ProcessingNode.In {
    private final Edge<ProcessingNode.InputPacket> edge;
    private final int inputFormat;
    private final int outputFormat;
    private final Edge<ProcessingNode.InputPacket> postviewEdge;

    public int hashCode() {
        return ((((((this.edge.hashCode() ^ 1000003) * 1000003) ^ this.postviewEdge.hashCode()) * 1000003) ^ this.inputFormat) * 1000003) ^ this.outputFormat;
    }

    public String toString() {
        return "In{edge=" + this.edge + ", postviewEdge=" + this.postviewEdge + ", inputFormat=" + this.inputFormat + ", outputFormat=" + this.outputFormat + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.core.imagecapture.ProcessingNode.In
    public Edge<ProcessingNode.InputPacket> getEdge() {
        return this.edge;
    }

    @Override // androidx.camera.core.imagecapture.ProcessingNode.In
    public int getInputFormat() {
        return this.inputFormat;
    }

    @Override // androidx.camera.core.imagecapture.ProcessingNode.In
    public int getOutputFormat() {
        return this.outputFormat;
    }

    @Override // androidx.camera.core.imagecapture.ProcessingNode.In
    public Edge<ProcessingNode.InputPacket> getPostviewEdge() {
        return this.postviewEdge;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof ProcessingNode.In) == false) goto L18;
        ProcessingNode.In r101 = (ProcessingNode.In) r100;
        if (this.edge.equals(r101.getEdge()) == true) goto L10;
    L16:
        return false;
    L10:
        if (this.postviewEdge.equals(r101.getPostviewEdge()) == false) goto L16;
        if (this.inputFormat != r101.getInputFormat()) goto L16;
        if (this.outputFormat != r101.getOutputFormat()) goto L16;
        return true;
    L18:
        return false;
    }

    public AutoValue_ProcessingNode_In(Edge<ProcessingNode.InputPacket> r100, Edge<ProcessingNode.InputPacket> r101, int r102, int r103) {
        if (r100 == null) goto L11;
        this.edge = r100;
        if (r101 == null) goto L9;
        this.postviewEdge = r101;
        this.inputFormat = r102;
        this.outputFormat = r103;
        return;
    L9:
        throw new NullPointerException("Null postviewEdge");
    L11:
        throw new NullPointerException("Null edge");
    }
}
