package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\t¨\u0006\u0012"}, d2 = {"Landroidx/compose/material3/DragHandleColors;", "", "color", "Landroidx/compose/ui/graphics/Color;", "pressedColor", "draggedColor", "<init>", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColor-0d7_KjU", "()J", "J", "getPressedColor-0d7_KjU", "getDraggedColor-0d7_KjU", "equals", "", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DragHandleColors {
    public static final int $stable = 0;
    private final long color;
    private final long draggedColor;
    private final long pressedColor;

    public /* synthetic */ DragHandleColors(long r100, long r101, long r102, DefaultConstructorMarker r103) {
        this(r100, r101, r102);
    }

    public int hashCode() {
        return (((Color.m4834hashCodeimpl(this.color) * 31) + Color.m4834hashCodeimpl(this.pressedColor)) * 31) + Color.m4834hashCodeimpl(this.draggedColor);
    }

    /* JADX INFO: renamed from: getColor-0d7_KjU, reason: not valid java name */
    public final long m2180getColor0d7_KjU() {
        return this.color;
    }

    /* JADX INFO: renamed from: getDraggedColor-0d7_KjU, reason: not valid java name */
    public final long m2181getDraggedColor0d7_KjU() {
        return this.draggedColor;
    }

    /* JADX INFO: renamed from: getPressedColor-0d7_KjU, reason: not valid java name */
    public final long m2182getPressedColor0d7_KjU() {
        return this.pressedColor;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L20:
        return false;
    L8:
        if ((r100 instanceof DragHandleColors) == false) goto L20;
        DragHandleColors r101 = (DragHandleColors) r100;
        if (Color.m4828equalsimpl0(this.color, r101.color) == true) goto L14;
        return false;
    L14:
        if (Color.m4828equalsimpl0(this.pressedColor, r101.pressedColor) == true) goto L17;
        return false;
    L17:
        if (Color.m4828equalsimpl0(this.draggedColor, r101.draggedColor) == true) goto L19;
        return false;
    L19:
        return true;
    }

    private DragHandleColors(long r100, long r101, long r102) {
        this.color = r100;
        this.pressedColor = r101;
        this.draggedColor = r102;
    }
}
