package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.android.material.shadow.ShadowRenderer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ShapePath {
    protected static final float ANGLE_LEFT = 180.0f;
    private static final float ANGLE_UP = 270.0f;
    private boolean containsIncompatibleShadowOp;

    @Deprecated
    public float currentShadowAngle;

    @Deprecated
    public float endShadowAngle;

    @Deprecated
    public float endX;

    @Deprecated
    public float endY;
    private final List<PathOperation> operations;
    private final List<ShadowCompatOperation> shadowCompatOperations;

    @Deprecated
    public float startX;

    @Deprecated
    public float startY;

    public static class ArcShadowOperation extends ShadowCompatOperation {
        private final PathArcOperation operation;

        public ArcShadowOperation(PathArcOperation r10) {
            this.operation = r10;
        }

        @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
        public void draw(Matrix r10, @NonNull ShadowRenderer r11, int r12, @NonNull Canvas r13) {
            float r14 = PathArcOperation.access$800(this.operation);
            float r15 = PathArcOperation.access$900(this.operation);
            r11.drawCornerShadow(r13, r10, new RectF(PathArcOperation.access$1000(this.operation), PathArcOperation.access$1100(this.operation), PathArcOperation.access$1200(this.operation), PathArcOperation.access$1300(this.operation)), r12, r14, r15);
        }
    }

    public static class LineShadowOperation extends ShadowCompatOperation {
        private final PathLineOperation operation;
        private final float startX;
        private final float startY;

        public LineShadowOperation(PathLineOperation r10, float r11, float r12) {
            this.operation = r10;
            this.startX = r11;
            this.startY = r12;
        }

        @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
        public void draw(Matrix r10, @NonNull ShadowRenderer r11, int r12, @NonNull Canvas r13) {
            RectF r14 = new RectF(0.0f, 0.0f, (float) Math.hypot(PathLineOperation.access$100(this.operation) - this.startY, PathLineOperation.access$000(this.operation) - this.startX), 0.0f);
            Matrix r15 = new Matrix(r10);
            r15.preTranslate(this.startX, this.startY);
            r15.preRotate(getAngle());
            r11.drawEdgeShadow(r13, r15, r14, r12);
        }

        public float getAngle() {
            return (float) Math.toDegrees(Math.atan((PathLineOperation.access$100(this.operation) - this.startY) / (PathLineOperation.access$000(this.operation) - this.startX)));
        }
    }

    public static class PathArcOperation extends PathOperation {
        private static final RectF rectF = null;

        @Deprecated
        public float bottom;

        @Deprecated
        public float left;

        @Deprecated
        public float right;

        @Deprecated
        public float startAngle;

        @Deprecated
        public float sweepAngle;

        @Deprecated
        public float top;

        static {
            rectF = new RectF();
        }

        public PathArcOperation(float r10, float r11, float r12, float r13) {
            setLeft(r10);
            setTop(r11);
            setRight(r12);
            setBottom(r13);
        }

        public static /* synthetic */ float access$1000(PathArcOperation r10) {
            return r10.getLeft();
        }

        public static /* synthetic */ float access$1100(PathArcOperation r10) {
            return r10.getTop();
        }

        public static /* synthetic */ float access$1200(PathArcOperation r10) {
            return r10.getRight();
        }

        public static /* synthetic */ float access$1300(PathArcOperation r10) {
            return r10.getBottom();
        }

        public static /* synthetic */ void access$600(PathArcOperation r10, float r11) {
            r10.setStartAngle(r11);
        }

        public static /* synthetic */ void access$700(PathArcOperation r10, float r11) {
            r10.setSweepAngle(r11);
        }

        public static /* synthetic */ float access$800(PathArcOperation r10) {
            return r10.getStartAngle();
        }

        public static /* synthetic */ float access$900(PathArcOperation r10) {
            return r10.getSweepAngle();
        }

        private float getBottom() {
            return this.bottom;
        }

        private float getLeft() {
            return this.left;
        }

        private float getRight() {
            return this.right;
        }

        private float getStartAngle() {
            return this.startAngle;
        }

        private float getSweepAngle() {
            return this.sweepAngle;
        }

        private float getTop() {
            return this.top;
        }

        private void setBottom(float r10) {
            this.bottom = r10;
        }

        private void setLeft(float r10) {
            this.left = r10;
        }

        private void setRight(float r10) {
            this.right = r10;
        }

        private void setStartAngle(float r10) {
            this.startAngle = r10;
        }

        private void setSweepAngle(float r10) {
            this.sweepAngle = r10;
        }

        private void setTop(float r10) {
            this.top = r10;
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(@NonNull Matrix r10, @NonNull Path r11) {
            Matrix r12 = this.matrix;
            r10.invert(r12);
            r11.transform(r12);
            RectF r13 = rectF;
            r13.set(getLeft(), getTop(), getRight(), getBottom());
            r11.arcTo(r13, getStartAngle(), getSweepAngle(), false);
            r11.transform(r10);
        }
    }

    public static class PathCubicOperation extends PathOperation {
        private float controlX1;
        private float controlX2;
        private float controlY1;
        private float controlY2;
        private float endX;
        private float endY;

        public PathCubicOperation(float r10, float r11, float r12, float r13, float r14, float r15) {
            setControlX1(r10);
            setControlY1(r11);
            setControlX2(r12);
            setControlY2(r13);
            setEndX(r14);
            setEndY(r15);
        }

        private float getControlX1() {
            return this.controlX1;
        }

        private float getControlX2() {
            return this.controlX2;
        }

        private float getControlY1() {
            return this.controlY1;
        }

        private float getControlY2() {
            return this.controlY1;
        }

        private float getEndX() {
            return this.endX;
        }

        private float getEndY() {
            return this.endY;
        }

        private void setControlX1(float r10) {
            this.controlX1 = r10;
        }

        private void setControlX2(float r10) {
            this.controlX2 = r10;
        }

        private void setControlY1(float r10) {
            this.controlY1 = r10;
        }

        private void setControlY2(float r10) {
            this.controlY2 = r10;
        }

        private void setEndX(float r10) {
            this.endX = r10;
        }

        private void setEndY(float r10) {
            this.endY = r10;
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(@NonNull Matrix r10, @NonNull Path r11) {
            Matrix r12 = this.matrix;
            r10.invert(r12);
            r11.transform(r12);
            r11.cubicTo(this.controlX1, this.controlY1, this.controlX2, this.controlY2, this.endX, this.endY);
            r11.transform(r10);
        }
    }

    public static class PathLineOperation extends PathOperation {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private float f10328x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private float f10329y;

        public PathLineOperation() {
        }

        public static /* synthetic */ float access$000(PathLineOperation r10) {
            return r10.f10328x;
        }

        public static /* synthetic */ float access$002(PathLineOperation r10, float r11) {
            r10.f10328x = r11;
            return r11;
        }

        public static /* synthetic */ float access$100(PathLineOperation r10) {
            return r10.f10329y;
        }

        public static /* synthetic */ float access$102(PathLineOperation r10, float r11) {
            r10.f10329y = r11;
            return r11;
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(@NonNull Matrix r10, @NonNull Path r11) {
            Matrix r12 = this.matrix;
            r10.invert(r12);
            r11.transform(r12);
            r11.lineTo(this.f10328x, this.f10329y);
            r11.transform(r10);
        }
    }

    public static abstract class PathOperation {
        protected final Matrix matrix;

        public PathOperation() {
            this.matrix = new Matrix();
        }

        public abstract void applyToPath(Matrix r10, Path r11);
    }

    public static class PathQuadOperation extends PathOperation {

        @Deprecated
        public float controlX;

        @Deprecated
        public float controlY;

        @Deprecated
        public float endX;

        @Deprecated
        public float endY;

        public PathQuadOperation() {
        }

        public static /* synthetic */ void access$200(PathQuadOperation r10, float r11) {
            r10.setControlX(r11);
        }

        public static /* synthetic */ void access$300(PathQuadOperation r10, float r11) {
            r10.setControlY(r11);
        }

        public static /* synthetic */ void access$400(PathQuadOperation r10, float r11) {
            r10.setEndX(r11);
        }

        public static /* synthetic */ void access$500(PathQuadOperation r10, float r11) {
            r10.setEndY(r11);
        }

        private float getControlX() {
            return this.controlX;
        }

        private float getControlY() {
            return this.controlY;
        }

        private float getEndX() {
            return this.endX;
        }

        private float getEndY() {
            return this.endY;
        }

        private void setControlX(float r10) {
            this.controlX = r10;
        }

        private void setControlY(float r10) {
            this.controlY = r10;
        }

        private void setEndX(float r10) {
            this.endX = r10;
        }

        private void setEndY(float r10) {
            this.endY = r10;
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(@NonNull Matrix r10, @NonNull Path r11) {
            Matrix r12 = this.matrix;
            r10.invert(r12);
            r11.transform(r12);
            r11.quadTo(getControlX(), getControlY(), getEndX(), getEndY());
            r11.transform(r10);
        }
    }

    public static abstract class ShadowCompatOperation {
        static final Matrix IDENTITY_MATRIX = null;

        static {
            IDENTITY_MATRIX = new Matrix();
        }

        public ShadowCompatOperation() {
        }

        public abstract void draw(Matrix r10, ShadowRenderer r11, int r12, Canvas r13);

        public final void draw(ShadowRenderer r10, int r11, Canvas r12) {
            draw(IDENTITY_MATRIX, r10, r11, r12);
        }
    }

    public ShapePath() {
        this.operations = new ArrayList();
        this.shadowCompatOperations = new ArrayList();
        reset(0.0f, 0.0f);
    }

    private void addConnectingShadowIfNecessary(float r10) {
        if (getCurrentShadowAngle() != r10) goto L5;
        return;
    L5:
        float r11 = ((r10 - getCurrentShadowAngle()) + 360.0f) % 360.0f;
        if (r11 <= ANGLE_LEFT) goto L8;
        return;
    L8:
        PathArcOperation r12 = new PathArcOperation(getEndX(), getEndY(), getEndX(), getEndY());
        PathArcOperation.access$600(r12, getCurrentShadowAngle());
        PathArcOperation.access$700(r12, r11);
        this.shadowCompatOperations.add(new ArcShadowOperation(r12));
        setCurrentShadowAngle(r10);
    }

    private void addShadowCompatOperation(ShadowCompatOperation r10, float r11, float r12) {
        addConnectingShadowIfNecessary(r11);
        this.shadowCompatOperations.add(r10);
        setCurrentShadowAngle(r12);
    }

    private float getCurrentShadowAngle() {
        return this.currentShadowAngle;
    }

    private float getEndShadowAngle() {
        return this.endShadowAngle;
    }

    private void setCurrentShadowAngle(float r10) {
        this.currentShadowAngle = r10;
    }

    private void setEndShadowAngle(float r10) {
        this.endShadowAngle = r10;
    }

    private void setEndX(float r10) {
        this.endX = r10;
    }

    private void setEndY(float r10) {
        this.endY = r10;
    }

    private void setStartX(float r10) {
        this.startX = r10;
    }

    private void setStartY(float r10) {
        this.startY = r10;
    }

    public void addArc(float r10, float r11, float r12, float r13, float r14, float r15) {
        PathArcOperation r16 = new PathArcOperation(r10, r11, r12, r13);
        PathArcOperation.access$600(r16, r14);
        PathArcOperation.access$700(r16, r15);
        this.operations.add(r16);
        ArcShadowOperation r17 = new ArcShadowOperation(r16);
        float r18 = r14 + r15;
        if (r15 >= 0.0f) goto L5;
        boolean r19 = true;
    L7:
        if (r19 == false) goto L9;
        r14 = (r14 + ANGLE_LEFT) % 360.0f;
    L9:
        if (r19 == false) goto L11;
        float r20 = (ANGLE_LEFT + r18) % 360.0f;
    L12:
        addShadowCompatOperation(r17, r14, r20);
        double r21 = r18;
        setEndX(((r10 + r12) * 0.5f) + (((r12 - r10) / 2.0f) * ((float) Math.cos(Math.toRadians(r21)))));
        setEndY(((r11 + r13) * 0.5f) + (((r13 - r11) / 2.0f) * ((float) Math.sin(Math.toRadians(r21)))));
        return;
    L11:
        r20 = r18;
        goto L12
    L5:
        r19 = false;
        goto L7
    }

    public void applyToPath(Matrix r10, Path r11) {
        int r12 = this.operations.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        this.operations.get(r13).applyToPath(r10, r11);
        r13 = r13 + 1;
        goto L3
    }

    public boolean containsIncompatibleShadowOp() {
        return this.containsIncompatibleShadowOp;
    }

    @NonNull
    public ShadowCompatOperation createShadowCompatOperation(Matrix r10) {
        addConnectingShadowIfNecessary(getEndShadowAngle());
        final Matrix r11 = new Matrix(r10);
        final ArrayList r12 = new ArrayList(this.shadowCompatOperations);
        return new AnonymousClass1(this, r12, r11);
    }

    @RequiresApi(21)
    public void cubicToPoint(float r10, float r11, float r12, float r13, float r14, float r15) {
        PathCubicOperation r16 = new PathCubicOperation(r10, r11, r12, r13, r14, r15);
        this.operations.add(r16);
        this.containsIncompatibleShadowOp = true;
        setEndX(r14);
        setEndY(r15);
    }

    public float getEndX() {
        return this.endX;
    }

    public float getEndY() {
        return this.endY;
    }

    public float getStartX() {
        return this.startX;
    }

    public float getStartY() {
        return this.startY;
    }

    public void lineTo(float r10, float r11) {
        PathLineOperation r12 = new PathLineOperation();
        PathLineOperation.access$002(r12, r10);
        PathLineOperation.access$102(r12, r11);
        this.operations.add(r12);
        LineShadowOperation r13 = new LineShadowOperation(r12, getEndX(), getEndY());
        addShadowCompatOperation(r13, r13.getAngle() + ANGLE_UP, r13.getAngle() + ANGLE_UP);
        setEndX(r10);
        setEndY(r11);
    }

    @RequiresApi(21)
    public void quadToPoint(float r10, float r11, float r12, float r13) {
        PathQuadOperation r14 = new PathQuadOperation();
        PathQuadOperation.access$200(r14, r10);
        PathQuadOperation.access$300(r14, r11);
        PathQuadOperation.access$400(r14, r12);
        PathQuadOperation.access$500(r14, r13);
        this.operations.add(r14);
        this.containsIncompatibleShadowOp = true;
        setEndX(r12);
        setEndY(r13);
    }

    public void reset(float r10, float r11) {
        reset(r10, r11, ANGLE_UP, 0.0f);
    }

    public void reset(float r10, float r11, float r12, float r13) {
        setStartX(r10);
        setStartY(r11);
        setEndX(r10);
        setEndY(r11);
        setCurrentShadowAngle(r12);
        setEndShadowAngle((r12 + r13) % 360.0f);
        this.operations.clear();
        this.shadowCompatOperations.clear();
        this.containsIncompatibleShadowOp = false;
    }

    public ShapePath(float r10, float r11) {
        this.operations = new ArrayList();
        this.shadowCompatOperations = new ArrayList();
        reset(r10, r11);
    }
}
