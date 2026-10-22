package androidx.compose.material3;

import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0011"}, d2 = {"Landroidx/compose/material3/DragHandleShapes;", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "pressedShape", "draggedShape", "<init>", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;)V", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "getPressedShape", "getDraggedShape", "equals", "", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DragHandleShapes {
    public static final int $stable = 0;
    private final Shape draggedShape;
    private final Shape pressedShape;
    private final Shape shape;

    public int hashCode() {
        return (((this.shape.hashCode() * 31) + this.pressedShape.hashCode()) * 31) + this.draggedShape.hashCode();
    }

    public final Shape getDraggedShape() {
        return this.draggedShape;
    }

    public final Shape getPressedShape() {
        return this.pressedShape;
    }

    public final Shape getShape() {
        return this.shape;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L20:
        return false;
    L8:
        if ((r100 instanceof DragHandleShapes) == false) goto L20;
        DragHandleShapes r101 = (DragHandleShapes) r100;
        if (Intrinsics.areEqual(this.shape, r101.shape) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.pressedShape, r101.pressedShape) == true) goto L17;
        return false;
    L17:
        if (Intrinsics.areEqual(this.draggedShape, r101.draggedShape) == true) goto L19;
        return false;
    L19:
        return true;
    }

    public DragHandleShapes(Shape r100, Shape r101, Shape r102) {
        this.shape = r100;
        this.pressedShape = r101;
        this.draggedShape = r102;
    }
}
