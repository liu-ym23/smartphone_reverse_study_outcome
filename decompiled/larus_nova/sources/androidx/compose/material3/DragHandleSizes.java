package androidx.compose.material3;

import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\t¨\u0006\u0012"}, d2 = {"Landroidx/compose/material3/DragHandleSizes;", "", "size", "Landroidx/compose/ui/unit/DpSize;", "pressedSize", "draggedSize", "<init>", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSize-MYxV2XQ", "()J", "J", "getPressedSize-MYxV2XQ", "getDraggedSize-MYxV2XQ", "equals", "", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DragHandleSizes {
    public static final int $stable = 0;
    private final long draggedSize;
    private final long pressedSize;
    private final long size;

    public /* synthetic */ DragHandleSizes(long r100, long r101, long r102, DefaultConstructorMarker r103) {
        this(r100, r101, r102);
    }

    public int hashCode() {
        return (((DpSize.m7644hashCodeimpl(this.size) * 31) + DpSize.m7644hashCodeimpl(this.pressedSize)) * 31) + DpSize.m7644hashCodeimpl(this.draggedSize);
    }

    /* JADX INFO: renamed from: getDraggedSize-MYxV2XQ, reason: not valid java name */
    public final long m2183getDraggedSizeMYxV2XQ() {
        return this.draggedSize;
    }

    /* JADX INFO: renamed from: getPressedSize-MYxV2XQ, reason: not valid java name */
    public final long m2184getPressedSizeMYxV2XQ() {
        return this.pressedSize;
    }

    /* JADX INFO: renamed from: getSize-MYxV2XQ, reason: not valid java name */
    public final long m2185getSizeMYxV2XQ() {
        return this.size;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L20:
        return false;
    L8:
        if ((r100 instanceof DragHandleSizes) == false) goto L20;
        DragHandleSizes r101 = (DragHandleSizes) r100;
        if (DpSize.m7639equalsimpl0(this.size, r101.size) == true) goto L14;
        return false;
    L14:
        if (DpSize.m7639equalsimpl0(this.pressedSize, r101.pressedSize) == true) goto L17;
        return false;
    L17:
        if (DpSize.m7639equalsimpl0(this.draggedSize, r101.draggedSize) == true) goto L19;
        return false;
    L19:
        return true;
    }

    private DragHandleSizes(long r100, long r101, long r102) {
        this.size = r100;
        this.pressedSize = r101;
        this.draggedSize = r102;
    }
}
