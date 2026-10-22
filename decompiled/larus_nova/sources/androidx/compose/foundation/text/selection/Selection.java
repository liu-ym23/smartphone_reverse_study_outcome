package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001:\u0001\u001dB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0000J\r\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001e"}, d2 = {"Landroidx/compose/foundation/text/selection/Selection;", "", "start", "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "end", "handlesCrossed", "", "<init>", "(Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;Z)V", "getStart", "()Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "getEnd", "getHandlesCrossed", "()Z", "merge", "other", "toTextRange", "Landroidx/compose/ui/text/TextRange;", "toTextRange-d9O1mEE", "()J", "component1", "component2", "component3", "copy", "equals", "hashCode", "", "toString", "", "AnchorInfo", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Selection {
    public static final int $stable = 0;
    private final AnchorInfo end;
    private final boolean handlesCrossed;
    private final AnchorInfo start;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "offset", "", "selectableId", "", "<init>", "(Landroidx/compose/ui/text/style/ResolvedTextDirection;IJ)V", "getDirection", "()Landroidx/compose/ui/text/style/ResolvedTextDirection;", "getOffset", "()I", "getSelectableId", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AnchorInfo {
        public static final int $stable = 0;
        private final ResolvedTextDirection direction;
        private final int offset;
        private final long selectableId;

        public static /* synthetic */ AnchorInfo copy$default(AnchorInfo r100, ResolvedTextDirection r101, int r102, long r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.direction;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.offset;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.selectableId;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final ResolvedTextDirection component1() {
            return this.direction;
        }

        public final int component2() {
            return this.offset;
        }

        public final long component3() {
            return this.selectableId;
        }

        public final AnchorInfo copy(ResolvedTextDirection r100, int r101, long r102) {
            return new AnchorInfo(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof AnchorInfo) == true) goto L8;
            return false;
        L8:
            AnchorInfo r101 = (AnchorInfo) r100;
            if (this.direction == r101.direction) goto L12;
            return false;
        L12:
            if (this.offset == r101.offset) goto L15;
            return false;
        L15:
            if (this.selectableId == r101.selectableId) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r100 = ((this.direction.hashCode() * 31) + this.offset) * 31;
            long r101 = this.selectableId;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public String toString() {
            return "AnchorInfo(direction=" + this.direction + ", offset=" + this.offset + ", selectableId=" + this.selectableId + ')';
        }

        public final ResolvedTextDirection getDirection() {
            return this.direction;
        }

        public final int getOffset() {
            return this.offset;
        }

        public final long getSelectableId() {
            return this.selectableId;
        }

        public AnchorInfo(ResolvedTextDirection r100, int r101, long r102) {
            this.direction = r100;
            this.offset = r101;
            this.selectableId = r102;
        }
    }

    public static /* synthetic */ Selection copy$default(Selection r100, AnchorInfo r101, AnchorInfo r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.start;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.end;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.handlesCrossed;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final AnchorInfo component1() {
        return this.start;
    }

    public final AnchorInfo component2() {
        return this.end;
    }

    public final boolean component3() {
        return this.handlesCrossed;
    }

    public final Selection copy(AnchorInfo r100, AnchorInfo r101, boolean r102) {
        return new Selection(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Selection) == true) goto L8;
        return false;
    L8:
        Selection r101 = (Selection) r100;
        if (Intrinsics.areEqual(this.start, r101.start) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.end, r101.end) == true) goto L15;
        return false;
    L15:
        if (this.handlesCrossed == r101.handlesCrossed) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.start.hashCode() * 31) + this.end.hashCode()) * 31;
        if (this.handlesCrossed == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public String toString() {
        return "Selection(start=" + this.start + ", end=" + this.end + ", handlesCrossed=" + this.handlesCrossed + ')';
    }

    /* JADX INFO: renamed from: toTextRange-d9O1mEE, reason: not valid java name */
    public final long m1455toTextRanged9O1mEE() {
        return TextRangeKt.TextRange(this.start.getOffset(), this.end.getOffset());
    }

    public final AnchorInfo getEnd() {
        return this.end;
    }

    public final boolean getHandlesCrossed() {
        return this.handlesCrossed;
    }

    public final AnchorInfo getStart() {
        return this.start;
    }

    public final Selection merge(Selection r100) {
        if (r100 != null) goto L4;
        return this;
    L4:
        boolean r101 = this.handlesCrossed;
        if (r101 == true) goto L11;
        if (r100.handlesCrossed == true) goto L11;
        return copy$default(this, null, r100.end, false, 5, null);
    L11:
        if (r100.handlesCrossed == false) goto L13;
        AnchorInfo r102 = r100.start;
    L14:
        if (r101 == false) goto L16;
        AnchorInfo r103 = this.end;
    L18:
        return new Selection(r102, r103, true);
    L16:
        r103 = this.start;
        goto L18
    L13:
        r102 = r100.end;
        goto L14
    }

    public Selection(AnchorInfo r100, AnchorInfo r101, boolean r102) {
        this.start = r100;
        this.end = r101;
        this.handlesCrossed = r102;
    }

    public /* synthetic */ Selection(AnchorInfo r100, AnchorInfo r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = false;
    L5:
        this(r100, r101, r102);
    }
}
