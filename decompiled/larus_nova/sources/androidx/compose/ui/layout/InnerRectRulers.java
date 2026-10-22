package androidx.compose.ui.layout;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0018\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u0014\u0010\u0011\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/layout/InnerRectRulers;", "Landroidx/compose/ui/layout/RectRulers;", "rulers", "", "<init>", "([Landroidx/compose/ui/layout/RectRulers;)V", "[Landroidx/compose/ui/layout/RectRulers;", "left", "Landroidx/compose/ui/layout/VerticalRuler;", "getLeft", "()Landroidx/compose/ui/layout/VerticalRuler;", "top", "Landroidx/compose/ui/layout/HorizontalRuler;", "getTop", "()Landroidx/compose/ui/layout/HorizontalRuler;", "right", "getRight", "bottom", "getBottom", "toString", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class InnerRectRulers implements RectRulers {
    private final HorizontalRuler bottom;
    private final VerticalRuler left;
    private final VerticalRuler right;
    private final RectRulers[] rulers;
    private final HorizontalRuler top;

    public String toString() {
        return ArraysKt.joinToString$default(this.rulers, null, "innermostOf(", ")", 0, null, null, 57, null);
    }

    @Override // androidx.compose.ui.layout.RectRulers
    public HorizontalRuler getBottom() {
        return this.bottom;
    }

    @Override // androidx.compose.ui.layout.RectRulers
    public VerticalRuler getLeft() {
        return this.left;
    }

    @Override // androidx.compose.ui.layout.RectRulers
    public VerticalRuler getRight() {
        return this.right;
    }

    @Override // androidx.compose.ui.layout.RectRulers
    public HorizontalRuler getTop() {
        return this.top;
    }

    public InnerRectRulers(RectRulers[] r100) {
        this.rulers = r100;
        VerticalRuler.Companion r101 = VerticalRuler.Companion;
        int r102 = r100.length;
        VerticalRuler[] r103 = new VerticalRuler[r102];
        int r104 = 0;
        int r105 = 0;
    L3:
        if (r105 >= r102) goto L5;
        r103[r105] = this.rulers[r105].getLeft();
        r105 = r105 + 1;
        goto L3
    L5:
        this.left = r101.maxOf(r103);
        HorizontalRuler.Companion r106 = HorizontalRuler.Companion;
        int r107 = this.rulers.length;
        HorizontalRuler[] r108 = new HorizontalRuler[r107];
        int r109 = 0;
    L6:
        if (r109 >= r107) goto L8;
        r108[r109] = this.rulers[r109].getTop();
        r109 = r109 + 1;
        goto L6
    L8:
        this.top = r106.maxOf(r108);
        VerticalRuler.Companion r110 = VerticalRuler.Companion;
        int r111 = this.rulers.length;
        VerticalRuler[] r112 = new VerticalRuler[r111];
        int r113 = 0;
    L9:
        if (r113 >= r111) goto L11;
        r112[r113] = this.rulers[r113].getRight();
        r113 = r113 + 1;
        goto L9
    L11:
        this.right = r110.minOf(r112);
        HorizontalRuler.Companion r114 = HorizontalRuler.Companion;
        int r115 = this.rulers.length;
        HorizontalRuler[] r116 = new HorizontalRuler[r115];
    L12:
        if (r104 >= r115) goto L14;
        r116[r104] = this.rulers[r104].getBottom();
        r104 = r104 + 1;
        goto L12
    L14:
        this.bottom = r114.minOf(r116);
    }
}
