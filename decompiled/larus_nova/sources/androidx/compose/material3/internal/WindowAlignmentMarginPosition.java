package androidx.compose.material3.internal;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Landroidx/compose/material3/internal/WindowAlignmentMarginPosition;", "", "<init>", "()V", "Horizontal", "Vertical", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WindowAlignmentMarginPosition {
    public static final int $stable = 0;
    public static final WindowAlignmentMarginPosition INSTANCE = null;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0012\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÂ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/compose/material3/internal/WindowAlignmentMarginPosition$Horizontal;", "Landroidx/compose/material3/internal/MenuPosition$Horizontal;", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", GXTemplateKey.FLEXBOX_MARGIN, "", "<init>", "(Landroidx/compose/ui/Alignment$Horizontal;I)V", "position", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "menuWidth", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "position-95KtPRI", "(Landroidx/compose/ui/unit/IntRect;JILandroidx/compose/ui/unit/LayoutDirection;)I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Horizontal implements MenuPosition.Horizontal {
        public static final int $stable = 0;
        private final Alignment.Horizontal alignment;
        private final int margin;

        private final Alignment.Horizontal component1() {
            return this.alignment;
        }

        private final int component2() {
            return this.margin;
        }

        public static /* synthetic */ Horizontal copy$default(Horizontal r100, Alignment.Horizontal r101, int r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.alignment;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.margin;
        L9:
            return r100.copy(r101, r102);
        }

        public final Horizontal copy(Alignment.Horizontal r100, int r101) {
            return new Horizontal(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Horizontal) == true) goto L8;
            return false;
        L8:
            Horizontal r101 = (Horizontal) r100;
            if (Intrinsics.areEqual(this.alignment, r101.alignment) == true) goto L12;
            return false;
        L12:
            if (this.margin == r101.margin) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.alignment.hashCode() * 31) + this.margin;
        }

        public String toString() {
            return "Horizontal(alignment=" + this.alignment + ", margin=" + this.margin + ')';
        }

        public Horizontal(Alignment.Horizontal r100, int r101) {
            this.alignment = r100;
            this.margin = r101;
        }

        @Override // androidx.compose.material3.internal.MenuPosition.Horizontal
        /* JADX INFO: renamed from: position-95KtPRI */
        public int mo3121position95KtPRI(IntRect r100, long r101, int r102, LayoutDirection r103) {
            int r104 = (int) (r101 >> 32);
            if (r102 >= (r104 - (this.margin * 2))) goto L5;
            int r105 = this.alignment.align(r102, r104, r103);
            int r106 = this.margin;
            return RangesKt.coerceIn(r105, r106, (r104 - r106) - r102);
        L5:
            return Alignment.Companion.getCenterHorizontally().align(r102, r104, r103);
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÂ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/compose/material3/internal/WindowAlignmentMarginPosition$Vertical;", "Landroidx/compose/material3/internal/MenuPosition$Vertical;", "alignment", "Landroidx/compose/ui/Alignment$Vertical;", GXTemplateKey.FLEXBOX_MARGIN, "", "<init>", "(Landroidx/compose/ui/Alignment$Vertical;I)V", "position", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "menuHeight", "position-JVtK1S4", "(Landroidx/compose/ui/unit/IntRect;JI)I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Vertical implements MenuPosition.Vertical {
        public static final int $stable = 0;
        private final Alignment.Vertical alignment;
        private final int margin;

        private final Alignment.Vertical component1() {
            return this.alignment;
        }

        private final int component2() {
            return this.margin;
        }

        public static /* synthetic */ Vertical copy$default(Vertical r100, Alignment.Vertical r101, int r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.alignment;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.margin;
        L9:
            return r100.copy(r101, r102);
        }

        public final Vertical copy(Alignment.Vertical r100, int r101) {
            return new Vertical(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Vertical) == true) goto L8;
            return false;
        L8:
            Vertical r101 = (Vertical) r100;
            if (Intrinsics.areEqual(this.alignment, r101.alignment) == true) goto L12;
            return false;
        L12:
            if (this.margin == r101.margin) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.alignment.hashCode() * 31) + this.margin;
        }

        public String toString() {
            return "Vertical(alignment=" + this.alignment + ", margin=" + this.margin + ')';
        }

        public Vertical(Alignment.Vertical r100, int r101) {
            this.alignment = r100;
            this.margin = r101;
        }

        @Override // androidx.compose.material3.internal.MenuPosition.Vertical
        /* JADX INFO: renamed from: position-JVtK1S4 */
        public int mo3122positionJVtK1S4(IntRect r100, long r101, int r102) {
            int r103 = (int) (r101 & BodyPartID.bodyIdMax);
            if (r102 >= (r103 - (this.margin * 2))) goto L5;
            int r104 = this.alignment.align(r102, r103);
            int r105 = this.margin;
            return RangesKt.coerceIn(r104, r105, (r103 - r105) - r102);
        L5:
            return Alignment.Companion.getCenterVertically().align(r102, r103);
        }
    }

    static {
        INSTANCE = new WindowAlignmentMarginPosition();
    }

    private WindowAlignmentMarginPosition() {
    }
}
