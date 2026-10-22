package com.google.android.material.shape;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class ShapePathModel extends ShapeAppearanceModel {
    public ShapePathModel() {
    }

    @Deprecated
    public void setAllCorners(CornerTreatment r10) {
        this.topLeftCorner = r10;
        this.topRightCorner = r10;
        this.bottomRightCorner = r10;
        this.bottomLeftCorner = r10;
    }

    @Deprecated
    public void setAllEdges(EdgeTreatment r10) {
        this.leftEdge = r10;
        this.topEdge = r10;
        this.rightEdge = r10;
        this.bottomEdge = r10;
    }

    @Deprecated
    public void setBottomEdge(EdgeTreatment r10) {
        this.bottomEdge = r10;
    }

    @Deprecated
    public void setBottomLeftCorner(CornerTreatment r10) {
        this.bottomLeftCorner = r10;
    }

    @Deprecated
    public void setBottomRightCorner(CornerTreatment r10) {
        this.bottomRightCorner = r10;
    }

    @Deprecated
    public void setCornerTreatments(CornerTreatment r10, CornerTreatment r11, CornerTreatment r12, CornerTreatment r13) {
        this.topLeftCorner = r10;
        this.topRightCorner = r11;
        this.bottomRightCorner = r12;
        this.bottomLeftCorner = r13;
    }

    @Deprecated
    public void setEdgeTreatments(EdgeTreatment r10, EdgeTreatment r11, EdgeTreatment r12, EdgeTreatment r13) {
        this.leftEdge = r10;
        this.topEdge = r11;
        this.rightEdge = r12;
        this.bottomEdge = r13;
    }

    @Deprecated
    public void setLeftEdge(EdgeTreatment r10) {
        this.leftEdge = r10;
    }

    @Deprecated
    public void setRightEdge(EdgeTreatment r10) {
        this.rightEdge = r10;
    }

    @Deprecated
    public void setTopEdge(EdgeTreatment r10) {
        this.topEdge = r10;
    }

    @Deprecated
    public void setTopLeftCorner(CornerTreatment r10) {
        this.topLeftCorner = r10;
    }

    @Deprecated
    public void setTopRightCorner(CornerTreatment r10) {
        this.topRightCorner = r10;
    }
}
