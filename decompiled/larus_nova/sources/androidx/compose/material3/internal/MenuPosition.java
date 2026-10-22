package androidx.compose.material3.internal;

import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bÁ\u0002\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0007J\u0010\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0007J\u0010\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\n\u001a\u00020\u0007J\u0010\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\n\u001a\u00020\u0007¨\u0006\u0014"}, d2 = {"Landroidx/compose/material3/internal/MenuPosition;", "", "<init>", "()V", "startToAnchorStart", "Landroidx/compose/material3/internal/MenuPosition$Horizontal;", "offset", "", "endToAnchorEnd", "leftToWindowLeft", GXTemplateKey.FLEXBOX_MARGIN, "rightToWindowRight", "topToAnchorBottom", "Landroidx/compose/material3/internal/MenuPosition$Vertical;", "bottomToAnchorTop", "centerToAnchorTop", "topToWindowTop", "bottomToWindowBottom", "Vertical", "Horizontal", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MenuPosition {
    public static final int $stable = 0;
    public static final MenuPosition INSTANCE = null;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bç\u0080\u0001\u0018\u00002\u00020\u0001J/\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Landroidx/compose/material3/internal/MenuPosition$Horizontal;", "", "position", "", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "menuWidth", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "position-95KtPRI", "(Landroidx/compose/ui/unit/IntRect;JILandroidx/compose/ui/unit/LayoutDirection;)I", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Horizontal {
        /* JADX INFO: renamed from: position-95KtPRI */
        int mo3121position95KtPRI(IntRect r100, long r101, int r102, LayoutDirection r103);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bç\u0080\u0001\u0018\u00002\u00020\u0001J'\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Landroidx/compose/material3/internal/MenuPosition$Vertical;", "", "position", "", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "menuHeight", "position-JVtK1S4", "(Landroidx/compose/ui/unit/IntRect;JI)I", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Vertical {
        /* JADX INFO: renamed from: position-JVtK1S4 */
        int mo3122positionJVtK1S4(IntRect r100, long r101, int r102);
    }

    static {
        INSTANCE = new MenuPosition();
    }

    private MenuPosition() {
    }

    public final Vertical bottomToAnchorTop(int r100) {
        Alignment.Companion r101 = Alignment.Companion;
        return new AnchorAlignmentOffsetPosition.Vertical(r101.getBottom(), r101.getTop(), r100);
    }

    public final Vertical bottomToWindowBottom(int r100) {
        return new WindowAlignmentMarginPosition.Vertical(Alignment.Companion.getBottom(), r100);
    }

    public final Vertical centerToAnchorTop(int r100) {
        Alignment.Companion r101 = Alignment.Companion;
        return new AnchorAlignmentOffsetPosition.Vertical(r101.getCenterVertically(), r101.getTop(), r100);
    }

    public final Horizontal endToAnchorEnd(int r100) {
        Alignment.Companion r101 = Alignment.Companion;
        return new AnchorAlignmentOffsetPosition.Horizontal(r101.getEnd(), r101.getEnd(), r100);
    }

    public final Horizontal leftToWindowLeft(int r100) {
        return new WindowAlignmentMarginPosition.Horizontal(AbsoluteAlignment.INSTANCE.getLeft(), r100);
    }

    public final Horizontal rightToWindowRight(int r100) {
        return new WindowAlignmentMarginPosition.Horizontal(AbsoluteAlignment.INSTANCE.getRight(), r100);
    }

    public final Horizontal startToAnchorStart(int r100) {
        Alignment.Companion r101 = Alignment.Companion;
        return new AnchorAlignmentOffsetPosition.Horizontal(r101.getStart(), r101.getStart(), r100);
    }

    public final Vertical topToAnchorBottom(int r100) {
        Alignment.Companion r101 = Alignment.Companion;
        return new AnchorAlignmentOffsetPosition.Vertical(r101.getTop(), r101.getBottom(), r100);
    }

    public final Vertical topToWindowTop(int r100) {
        return new WindowAlignmentMarginPosition.Vertical(Alignment.Companion.getTop(), r100);
    }

    public static /* synthetic */ Vertical bottomToAnchorTop$default(MenuPosition r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = 0;
    L6:
        return r100.bottomToAnchorTop(r101);
    }

    public static /* synthetic */ Vertical bottomToWindowBottom$default(MenuPosition r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = 0;
    L6:
        return r100.bottomToWindowBottom(r101);
    }

    public static /* synthetic */ Vertical centerToAnchorTop$default(MenuPosition r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = 0;
    L6:
        return r100.centerToAnchorTop(r101);
    }

    public static /* synthetic */ Horizontal endToAnchorEnd$default(MenuPosition r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = 0;
    L6:
        return r100.endToAnchorEnd(r101);
    }

    public static /* synthetic */ Horizontal leftToWindowLeft$default(MenuPosition r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = 0;
    L6:
        return r100.leftToWindowLeft(r101);
    }

    public static /* synthetic */ Horizontal rightToWindowRight$default(MenuPosition r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = 0;
    L6:
        return r100.rightToWindowRight(r101);
    }

    public static /* synthetic */ Horizontal startToAnchorStart$default(MenuPosition r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = 0;
    L6:
        return r100.startToAnchorStart(r101);
    }

    public static /* synthetic */ Vertical topToAnchorBottom$default(MenuPosition r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = 0;
    L6:
        return r100.topToAnchorBottom(r101);
    }

    public static /* synthetic */ Vertical topToWindowTop$default(MenuPosition r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = 0;
    L6:
        return r100.topToWindowTop(r101);
    }
}
