package androidx.compose.material3;

import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001a\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u001b\u0010\u001cJ%\u0010\u001d\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u001e\u0010\u001cJ%\u0010\u001f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b \u0010\u001cJ-\u0010!\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\"\u0010#J-\u0010$\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b%\u0010#R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006&"}, d2 = {"Landroidx/compose/material3/TooltipPositionProviderImpl;", "Landroidx/compose/ui/window/PopupPositionProvider;", "type", "Landroidx/compose/material3/TooltipAnchorPosition;", "tooltipAnchorSpacing", "", "<init>", "(IILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getType-lOKsHw4", "()I", "I", "getTooltipAnchorSpacing", "calculatePosition", "Landroidx/compose/ui/unit/IntOffset;", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "leftPositioning", "leftPositioning-oFUgxo0", "(Landroidx/compose/ui/unit/IntRect;J)J", "rightPositioning", "rightPositioning-uHY26d4", "(Landroidx/compose/ui/unit/IntRect;JJ)J", "abovePositioning", "abovePositioning-uHY26d4", "belowPositioning", "belowPositioning-uHY26d4", "startPositioning", "startPositioning-_JLpSYE", "(Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/IntRect;JJ)J", "endPositioning", "endPositioning-_JLpSYE", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class TooltipPositionProviderImpl implements PopupPositionProvider {
    private final int tooltipAnchorSpacing;
    private final int type;

    public /* synthetic */ TooltipPositionProviderImpl(int r100, int r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }

    public final int getTooltipAnchorSpacing() {
        return this.tooltipAnchorSpacing;
    }

    /* JADX INFO: renamed from: getType-lOKsHw4, reason: not valid java name */
    public final int m3041getTypelOKsHw4() {
        return this.type;
    }

    private TooltipPositionProviderImpl(int r100, int r101) {
        this.type = r100;
        this.tooltipAnchorSpacing = r101;
    }

    /* JADX INFO: renamed from: leftPositioning-oFUgxo0, reason: not valid java name */
    public final long m3042leftPositioningoFUgxo0(IntRect r100, long r101) {
        int r102 = r100.getLeft() - (((int) (r101 >> 32)) + this.tooltipAnchorSpacing);
        if (r102 >= 0) goto L5;
        r102 = r100.getRight() + this.tooltipAnchorSpacing;
    L5:
        int r103 = ((r100.getTop() + r100.getBottom()) - ((int) (r101 & BodyPartID.bodyIdMax))) / 2;
        return IntOffset.m7670constructorimpl((((long) r102) << 32) | (((long) r103) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: abovePositioning-uHY26d4, reason: not valid java name */
    public final long m3038abovePositioninguHY26d4(IntRect r100, long r101, long r102) {
        int r103 = (int) (r101 >> 32);
        int r104 = r100.getLeft() + ((r100.getWidth() - r103) / 2);
        if (r104 >= 0) goto L6;
        r104 = r100.getLeft();
    L8:
        int r105 = (r100.getTop() - ((int) (r101 & BodyPartID.bodyIdMax))) - this.tooltipAnchorSpacing;
        if (r105 >= 0) goto L12;
        r105 = r100.getBottom() + this.tooltipAnchorSpacing;
    L12:
        return IntOffset.m7670constructorimpl((((long) r104) << 32) | (((long) r105) & BodyPartID.bodyIdMax));
    L6:
        if ((r104 + r103) <= ((int) (r102 >> 32))) goto L8;
        r104 = r100.getRight() - r103;
        goto L8
    }

    /* JADX INFO: renamed from: belowPositioning-uHY26d4, reason: not valid java name */
    public final long m3039belowPositioninguHY26d4(IntRect r100, long r101, long r110) {
        int r102 = (int) (r101 >> 32);
        int r103 = r100.getLeft() + ((r100.getWidth() - r102) / 2);
        if (r103 >= 0) goto L6;
        r103 = r100.getLeft();
    L8:
        int r104 = r100.getBottom() + this.tooltipAnchorSpacing;
        int r111 = (int) (r101 & BodyPartID.bodyIdMax);
        if ((r104 + r111) <= ((int) (r110 & BodyPartID.bodyIdMax))) goto L12;
        r104 = (r100.getTop() - r111) - this.tooltipAnchorSpacing;
    L12:
        return IntOffset.m7670constructorimpl((((long) r103) << 32) | (((long) r104) & BodyPartID.bodyIdMax));
    L6:
        if ((r103 + r102) <= ((int) (r110 >> 32))) goto L8;
        r103 = r100.getRight() - r102;
        goto L8
    }

    /* JADX INFO: renamed from: rightPositioning-uHY26d4, reason: not valid java name */
    public final long m3043rightPositioninguHY26d4(IntRect r100, long r101, long r102) {
        int r103 = r100.getRight() + this.tooltipAnchorSpacing;
        int r104 = (int) (r101 >> 32);
        if ((r103 + r104) <= ((int) (r102 >> 32))) goto L5;
        r103 = r100.getLeft() - (r104 + this.tooltipAnchorSpacing);
    L5:
        int r105 = ((r100.getTop() + r100.getBottom()) - ((int) (r101 & BodyPartID.bodyIdMax))) / 2;
        return IntOffset.m7670constructorimpl((((long) r103) << 32) | (((long) r105) & BodyPartID.bodyIdMax));
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    /* JADX INFO: renamed from: calculatePosition-llwVHH4 */
    public long mo340calculatePositionllwVHH4(IntRect r100, long r101, LayoutDirection r110, long r111) {
        int r102 = this.type;
        TooltipAnchorPosition.Companion r103 = TooltipAnchorPosition.Companion;
        if (TooltipAnchorPosition.m3013equalsimpl0(r102, r103.m3020getLeftlOKsHw4()) == false) goto L6;
        return m3042leftPositioningoFUgxo0(r100, r111);
    L6:
        if (TooltipAnchorPosition.m3013equalsimpl0(r102, r103.m3021getRightlOKsHw4()) == false) goto L9;
        return m3043rightPositioninguHY26d4(r100, r111, r101);
    L9:
        if (TooltipAnchorPosition.m3013equalsimpl0(r102, r103.m3017getAbovelOKsHw4()) == false) goto L12;
        return m3038abovePositioninguHY26d4(r100, r111, r101);
    L12:
        if (TooltipAnchorPosition.m3013equalsimpl0(r102, r103.m3018getBelowlOKsHw4()) == false) goto L15;
        return m3039belowPositioninguHY26d4(r100, r111, r101);
    L15:
        if (TooltipAnchorPosition.m3013equalsimpl0(r102, r103.m3022getStartlOKsHw4()) == false) goto L18;
        return m3044startPositioning_JLpSYE(r110, r100, r111, r101);
    L18:
        if (TooltipAnchorPosition.m3013equalsimpl0(r102, r103.m3019getEndlOKsHw4()) == false) goto L21;
        return m3040endPositioning_JLpSYE(r110, r100, r111, r101);
    L21:
        return m3038abovePositioninguHY26d4(r100, r111, r101);
    }

    /* JADX INFO: renamed from: endPositioning-_JLpSYE, reason: not valid java name */
    public final long m3040endPositioning_JLpSYE(LayoutDirection r100, IntRect r101, long r102, long r110) {
        if (r100 != LayoutDirection.Ltr) goto L6;
        return m3043rightPositioninguHY26d4(r101, r102, r110);
    L6:
        return m3042leftPositioningoFUgxo0(r101, r102);
    }

    /* JADX INFO: renamed from: startPositioning-_JLpSYE, reason: not valid java name */
    public final long m3044startPositioning_JLpSYE(LayoutDirection r100, IntRect r101, long r102, long r110) {
        if (r100 != LayoutDirection.Ltr) goto L6;
        return m3042leftPositioningoFUgxo0(r101, r102);
    L6:
        return m3043rightPositioninguHY26d4(r101, r102, r110);
    }
}
