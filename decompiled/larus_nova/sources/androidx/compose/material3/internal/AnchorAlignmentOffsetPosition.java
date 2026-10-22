package androidx.compose.material3.internal;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Landroidx/compose/material3/internal/AnchorAlignmentOffsetPosition;", "", "<init>", "()V", "Horizontal", "Vertical", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AnchorAlignmentOffsetPosition {
    public static final int $stable = 0;
    public static final AnchorAlignmentOffsetPosition INSTANCE = null;

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0013\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÂ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/compose/material3/internal/AnchorAlignmentOffsetPosition$Horizontal;", "Landroidx/compose/material3/internal/MenuPosition$Horizontal;", "menuAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "anchorAlignment", "offset", "", "<init>", "(Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Horizontal;I)V", "position", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "menuWidth", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "position-95KtPRI", "(Landroidx/compose/ui/unit/IntRect;JILandroidx/compose/ui/unit/LayoutDirection;)I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Horizontal implements MenuPosition.Horizontal {
        public static final int $stable = 0;
        private final Alignment.Horizontal anchorAlignment;
        private final Alignment.Horizontal menuAlignment;
        private final int offset;

        private final Alignment.Horizontal component1() {
            return this.menuAlignment;
        }

        private final Alignment.Horizontal component2() {
            return this.anchorAlignment;
        }

        private final int component3() {
            return this.offset;
        }

        public static /* synthetic */ Horizontal copy$default(Horizontal r100, Alignment.Horizontal r101, Alignment.Horizontal r102, int r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.menuAlignment;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.anchorAlignment;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.offset;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final Horizontal copy(Alignment.Horizontal r100, Alignment.Horizontal r101, int r102) {
            return new Horizontal(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Horizontal) == true) goto L8;
            return false;
        L8:
            Horizontal r101 = (Horizontal) r100;
            if (Intrinsics.areEqual(this.menuAlignment, r101.menuAlignment) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.anchorAlignment, r101.anchorAlignment) == true) goto L15;
            return false;
        L15:
            if (this.offset == r101.offset) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.menuAlignment.hashCode() * 31) + this.anchorAlignment.hashCode()) * 31) + this.offset;
        }

        public String toString() {
            return "Horizontal(menuAlignment=" + this.menuAlignment + ", anchorAlignment=" + this.anchorAlignment + ", offset=" + this.offset + ')';
        }

        public Horizontal(Alignment.Horizontal r100, Alignment.Horizontal r101, int r102) {
            this.menuAlignment = r100;
            this.anchorAlignment = r101;
            this.offset = r102;
        }

        @Override // androidx.compose.material3.internal.MenuPosition.Horizontal
        /* JADX INFO: renamed from: position-95KtPRI, reason: not valid java name */
        public int mo3121position95KtPRI(IntRect r100, long r101, int r102, LayoutDirection r103) {
            int r104 = this.anchorAlignment.align(0, r100.getWidth(), r103);
            int r105 = -this.menuAlignment.align(0, r102, r103);
            if (r103 != LayoutDirection.Ltr) goto L5;
            int r106 = this.offset;
        L7:
            return ((r100.getLeft() + r104) + r105) + r106;
        L5:
            r106 = -this.offset;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0011\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÂ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/compose/material3/internal/AnchorAlignmentOffsetPosition$Vertical;", "Landroidx/compose/material3/internal/MenuPosition$Vertical;", "menuAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "anchorAlignment", "offset", "", "<init>", "(Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/Alignment$Vertical;I)V", "position", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "menuHeight", "position-JVtK1S4", "(Landroidx/compose/ui/unit/IntRect;JI)I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Vertical implements MenuPosition.Vertical {
        public static final int $stable = 0;
        private final Alignment.Vertical anchorAlignment;
        private final Alignment.Vertical menuAlignment;
        private final int offset;

        private final Alignment.Vertical component1() {
            return this.menuAlignment;
        }

        private final Alignment.Vertical component2() {
            return this.anchorAlignment;
        }

        private final int component3() {
            return this.offset;
        }

        public static /* synthetic */ Vertical copy$default(Vertical r100, Alignment.Vertical r101, Alignment.Vertical r102, int r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.menuAlignment;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.anchorAlignment;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.offset;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final Vertical copy(Alignment.Vertical r100, Alignment.Vertical r101, int r102) {
            return new Vertical(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Vertical) == true) goto L8;
            return false;
        L8:
            Vertical r101 = (Vertical) r100;
            if (Intrinsics.areEqual(this.menuAlignment, r101.menuAlignment) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.anchorAlignment, r101.anchorAlignment) == true) goto L15;
            return false;
        L15:
            if (this.offset == r101.offset) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.menuAlignment.hashCode() * 31) + this.anchorAlignment.hashCode()) * 31) + this.offset;
        }

        public String toString() {
            return "Vertical(menuAlignment=" + this.menuAlignment + ", anchorAlignment=" + this.anchorAlignment + ", offset=" + this.offset + ')';
        }

        public Vertical(Alignment.Vertical r100, Alignment.Vertical r101, int r102) {
            this.menuAlignment = r100;
            this.anchorAlignment = r101;
            this.offset = r102;
        }

        @Override // androidx.compose.material3.internal.MenuPosition.Vertical
        /* JADX INFO: renamed from: position-JVtK1S4, reason: not valid java name */
        public int mo3122positionJVtK1S4(IntRect r100, long r101, int r102) {
            int r103 = this.anchorAlignment.align(0, r100.getHeight());
            int r104 = -this.menuAlignment.align(0, r102);
            return ((r100.getTop() + r103) + r104) + this.offset;
        }
    }

    static {
        INSTANCE = new AnchorAlignmentOffsetPosition();
    }

    private AnchorAlignmentOffsetPosition() {
    }
}
