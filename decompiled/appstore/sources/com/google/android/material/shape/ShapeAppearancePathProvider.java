package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;

/* JADX INFO: loaded from: classes3.dex */
public class ShapeAppearancePathProvider {
    private final Path boundsPath;
    private final Path cornerPath;
    private final ShapePath[] cornerPaths;
    private final Matrix[] cornerTransforms;
    private boolean edgeIntersectionCheckEnabled;
    private final Path edgePath;
    private final Matrix[] edgeTransforms;
    private final Path overlappedEdgePath;
    private final PointF pointF;
    private final float[] scratch;
    private final float[] scratch2;
    private final ShapePath shapePath;

    public static class Lazy {
        static final ShapeAppearancePathProvider INSTANCE = null;

        static {
            INSTANCE = new ShapeAppearancePathProvider();
        }

        private Lazy() {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface PathListener {
        void onCornerPathCreated(ShapePath r10, Matrix r11, int r12);

        void onEdgePathCreated(ShapePath r10, Matrix r11, int r12);
    }

    public static final class ShapeAppearancePathSpec {

        @NonNull
        public final RectF bounds;
        public final float interpolation;

        @NonNull
        public final Path path;

        @Nullable
        public final PathListener pathListener;

        @NonNull
        public final ShapeAppearanceModel shapeAppearanceModel;

        public ShapeAppearancePathSpec(@NonNull ShapeAppearanceModel r10, float r11, RectF r12, @Nullable PathListener r13, Path r14) {
            this.pathListener = r13;
            this.shapeAppearanceModel = r10;
            this.interpolation = r11;
            this.bounds = r12;
            this.path = r14;
        }
    }

    public ShapeAppearancePathProvider() {
        this.cornerPaths = new ShapePath[4];
        this.cornerTransforms = new Matrix[4];
        this.edgeTransforms = new Matrix[4];
        this.pointF = new PointF();
        this.overlappedEdgePath = new Path();
        this.boundsPath = new Path();
        this.shapePath = new ShapePath();
        this.scratch = new float[2];
        this.scratch2 = new float[2];
        this.edgePath = new Path();
        this.cornerPath = new Path();
        this.edgeIntersectionCheckEnabled = true;
        int r10 = 0;
    L3:
        if (r10 >= 4) goto L5;
        this.cornerPaths[r10] = new ShapePath();
        this.cornerTransforms[r10] = new Matrix();
        this.edgeTransforms[r10] = new Matrix();
        r10 = r10 + 1;
        goto L3
    }

    private float angleOfEdge(int r10) {
        return (r10 + 1) * 90;
    }

    private void appendCornerPath(@NonNull ShapeAppearancePathSpec r10, int r11) {
        this.scratch[0] = this.cornerPaths[r11].getStartX();
        this.scratch[1] = this.cornerPaths[r11].getStartY();
        this.cornerTransforms[r11].mapPoints(this.scratch);
        if (r11 != 0) goto L5;
        Path r12 = r10.path;
        float[] r13 = this.scratch;
        r12.moveTo(r13[0], r13[1]);
    L6:
        this.cornerPaths[r11].applyToPath(this.cornerTransforms[r11], r10.path);
        PathListener r14 = r10.pathListener;
        if (r14 == null) goto L10;
        r14.onCornerPathCreated(this.cornerPaths[r11], this.cornerTransforms[r11], r11);
        return;
    L10:
        return;
    L5:
        Path r15 = r10.path;
        float[] r16 = this.scratch;
        r15.lineTo(r16[0], r16[1]);
        goto L6
    }

    private void appendEdgePath(@NonNull ShapeAppearancePathSpec r10, int r11) {
        int r12 = (r11 + 1) % 4;
        this.scratch[0] = this.cornerPaths[r11].getEndX();
        this.scratch[1] = this.cornerPaths[r11].getEndY();
        this.cornerTransforms[r11].mapPoints(this.scratch);
        this.scratch2[0] = this.cornerPaths[r12].getStartX();
        this.scratch2[1] = this.cornerPaths[r12].getStartY();
        this.cornerTransforms[r12].mapPoints(this.scratch2);
        float[] r13 = this.scratch;
        float r14 = r13[0];
        float[] r15 = this.scratch2;
        float r16 = Math.max(((float) Math.hypot(r14 - r15[0], r13[1] - r15[1])) - 0.001f, 0.0f);
        float r17 = getEdgeCenterForIndex(r10.bounds, r11);
        this.shapePath.reset(0.0f, 0.0f);
        EdgeTreatment r18 = getEdgeTreatmentForIndex(r11, r10.shapeAppearanceModel);
        r18.getEdgePath(r16, r17, r10.interpolation, this.shapePath);
        this.edgePath.reset();
        this.shapePath.applyToPath(this.edgeTransforms[r11], this.edgePath);
        if (this.edgeIntersectionCheckEnabled == true) goto L5;
    L11:
        this.shapePath.applyToPath(this.edgeTransforms[r11], r10.path);
    L12:
        PathListener r19 = r10.pathListener;
        if (r19 == null) goto L16;
        r19.onEdgePathCreated(this.shapePath, this.edgeTransforms[r11], r11);
        return;
    L16:
        return;
    L5:
        if (r18.forceIntersection() == false) goto L7;
    L10:
        Path r20 = this.edgePath;
        r20.op(r20, this.boundsPath, Path.Op.DIFFERENCE);
        this.scratch[0] = this.shapePath.getStartX();
        this.scratch[1] = this.shapePath.getStartY();
        this.edgeTransforms[r11].mapPoints(this.scratch);
        Path r21 = this.overlappedEdgePath;
        float[] r22 = this.scratch;
        r21.moveTo(r22[0], r22[1]);
        this.shapePath.applyToPath(this.edgeTransforms[r11], this.overlappedEdgePath);
        goto L12
    L7:
        if (pathOverlapsCorner(this.edgePath, r11) == true) goto L10;
        if (pathOverlapsCorner(this.edgePath, r12) == false) goto L11;
        goto L10
    }

    private void getCoordinatesOfCorner(int r10, @NonNull RectF r11, @NonNull PointF r12) {
        if (r10 != 1) goto L5;
        r12.set(r11.right, r11.bottom);
        return;
    L5:
        if (r10 != 2) goto L7;
        r12.set(r11.left, r11.bottom);
        return;
    L7:
        if (r10 == 3) goto L9;
        r12.set(r11.right, r11.top);
        return;
    L9:
        r12.set(r11.left, r11.top);
    }

    private CornerSize getCornerSizeForIndex(int r10, @NonNull ShapeAppearanceModel r11) {
        if (r10 == 1) goto L15;
        if (r10 == 2) goto L13;
        if (r10 == 3) goto L11;
        return r11.getTopRightCornerSize();
    L11:
        return r11.getTopLeftCornerSize();
    L13:
        return r11.getBottomLeftCornerSize();
    L15:
        return r11.getBottomRightCornerSize();
    }

    private CornerTreatment getCornerTreatmentForIndex(int r10, @NonNull ShapeAppearanceModel r11) {
        if (r10 == 1) goto L15;
        if (r10 == 2) goto L13;
        if (r10 == 3) goto L11;
        return r11.getTopRightCorner();
    L11:
        return r11.getTopLeftCorner();
    L13:
        return r11.getBottomLeftCorner();
    L15:
        return r11.getBottomRightCorner();
    }

    private float getEdgeCenterForIndex(@NonNull RectF r10, int r11) {
        float[] r12 = this.scratch;
        ShapePath r13 = this.cornerPaths[r11];
        r12[0] = r13.endX;
        r12[1] = r13.endY;
        this.cornerTransforms[r11].mapPoints(r12);
        if (r11 == 1) goto L9;
        if (r11 == 3) goto L9;
        return Math.abs(r10.centerY() - this.scratch[1]);
    L9:
        return Math.abs(r10.centerX() - this.scratch[0]);
    }

    private EdgeTreatment getEdgeTreatmentForIndex(int r10, @NonNull ShapeAppearanceModel r11) {
        if (r10 == 1) goto L15;
        if (r10 == 2) goto L13;
        if (r10 == 3) goto L11;
        return r11.getRightEdge();
    L11:
        return r11.getTopEdge();
    L13:
        return r11.getLeftEdge();
    L15:
        return r11.getBottomEdge();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @UiThread
    public static ShapeAppearancePathProvider getInstance() {
        return Lazy.INSTANCE;
    }

    @RequiresApi(19)
    private boolean pathOverlapsCorner(Path r10, int r11) {
        this.cornerPath.reset();
        this.cornerPaths[r11].applyToPath(this.cornerTransforms[r11], this.cornerPath);
        RectF r12 = new RectF();
        r10.computeBounds(r12, true);
        this.cornerPath.computeBounds(r12, true);
        r10.op(this.cornerPath, Path.Op.INTERSECT);
        r10.computeBounds(r12, true);
        if (r12.isEmpty() == true) goto L5;
        return true;
    L5:
        if (r12.width() > 1.0f) goto L7;
    L9:
        return false;
    L7:
        if (r12.height() <= 1.0f) goto L9;
        return true;
    }

    private void setCornerPathAndTransform(@NonNull ShapeAppearancePathSpec r10, int r11) {
        CornerSize r12 = getCornerSizeForIndex(r11, r10.shapeAppearanceModel);
        getCornerTreatmentForIndex(r11, r10.shapeAppearanceModel).getCornerPath(this.cornerPaths[r11], 90.0f, r10.interpolation, r10.bounds, r12);
        float r13 = angleOfEdge(r11);
        this.cornerTransforms[r11].reset();
        getCoordinatesOfCorner(r11, r10.bounds, this.pointF);
        Matrix r14 = this.cornerTransforms[r11];
        PointF r15 = this.pointF;
        r14.setTranslate(r15.x, r15.y);
        this.cornerTransforms[r11].preRotate(r13);
    }

    private void setEdgePathAndTransform(int r10) {
        this.scratch[0] = this.cornerPaths[r10].getEndX();
        this.scratch[1] = this.cornerPaths[r10].getEndY();
        this.cornerTransforms[r10].mapPoints(this.scratch);
        float r11 = angleOfEdge(r10);
        this.edgeTransforms[r10].reset();
        Matrix r12 = this.edgeTransforms[r10];
        float[] r13 = this.scratch;
        r12.setTranslate(r13[0], r13[1]);
        this.edgeTransforms[r10].preRotate(r11);
    }

    public void calculatePath(ShapeAppearanceModel r10, float r11, RectF r12, @NonNull Path r13) {
        calculatePath(r10, r11, r12, null, r13);
    }

    public void setEdgeIntersectionCheckEnable(boolean r10) {
        this.edgeIntersectionCheckEnabled = r10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void calculatePath(ShapeAppearanceModel r10, float r11, RectF r12, PathListener r13, @NonNull Path r14) {
        r14.rewind();
        this.overlappedEdgePath.rewind();
        this.boundsPath.rewind();
        this.boundsPath.addRect(r12, Path.Direction.CW);
        ShapeAppearancePathSpec r15 = new ShapeAppearancePathSpec(r10, r11, r12, r13, r14);
        int r16 = 0;
        int r17 = 0;
    L4:
        if (r17 >= 4) goto L6;
        setCornerPathAndTransform(r15, r17);
        setEdgePathAndTransform(r17);
        r17 = r17 + 1;
    L6:
        if (r16 >= 4) goto L8;
        appendCornerPath(r15, r16);
        appendEdgePath(r15, r16);
        r16 = r16 + 1;
        goto L6
    L8:
        r14.close();
        this.overlappedEdgePath.close();
        if (this.overlappedEdgePath.isEmpty() == true) goto L14;
        r14.op(this.overlappedEdgePath, Path.Op.UNION);
        return;
    }
}
