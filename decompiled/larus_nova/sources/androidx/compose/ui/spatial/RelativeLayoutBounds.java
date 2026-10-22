package androidx.compose.ui.spatial;

import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001BC\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001f0'J\u000e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0000J&\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u0019J\u0006\u00100\u001a\u00020)J\u001d\u00101\u001a\u00020)2\u0006\u00102\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u0006¢\u0006\u0004\b4\u00105J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00109\u001a\u00020\u0019H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0010\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\u001e\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b#\u0010!R\u0011\u0010$\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b%\u0010!¨\u0006:"}, d2 = {"Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "", "topLeft", "", "bottomRight", "windowOffset", "Landroidx/compose/ui/unit/IntOffset;", "screenOffset", "windowSize", "viewToWindowMatrix", "Landroidx/compose/ui/graphics/Matrix;", "node", "Landroidx/compose/ui/node/DelegatableNode;", "<init>", "(JJJJJ[FLandroidx/compose/ui/node/DelegatableNode;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "[F", "positionInRoot", "getPositionInRoot-nOcc-ac", "()J", "positionInWindow", "getPositionInWindow-nOcc-ac", "positionInScreen", "getPositionInScreen-nOcc-ac", "width", "", "getWidth", "()I", "height", "getHeight", "boundsInRoot", "Landroidx/compose/ui/unit/IntRect;", "getBoundsInRoot", "()Landroidx/compose/ui/unit/IntRect;", "boundsInWindow", "getBoundsInWindow", "boundsInScreen", "getBoundsInScreen", "calculateOcclusions", "", "fractionVisibleIn", "", "viewport", "fractionVisibleInRect", "left", "top", "right", "bottom", "fractionVisibleInWindow", "fractionVisibleInWindowWithInsets", "topLeftInset", "bottomRightInset", "fractionVisibleInWindowWithInsets-E1MhUcY", "(JJ)F", "equals", "", "other", "hashCode", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RelativeLayoutBounds {
    public static final int $stable = 8;
    private final long bottomRight;
    private final DelegatableNode node;
    private final long screenOffset;
    private final long topLeft;
    private final float[] viewToWindowMatrix;
    private final long windowOffset;
    private final long windowSize;

    public /* synthetic */ RelativeLayoutBounds(long r100, long r101, long r102, long r103, long r104, float[] r110, DelegatableNode r111, DefaultConstructorMarker r112) {
        this(r100, r101, r102, r103, r104, r110, r111);
    }

    public final List<IntRect> calculateOcclusions() {
        RectManager r100 = DelegatableNodeKt.requireOwner(this.node).getRectManager();
        int r101 = DelegatableNodeKt.requireLayoutNode(this.node).getSemanticsId();
        RectList r102 = r100.getRects();
        int r103 = r102.indexOf(r101);
        if (r103 < 0) goto L5;
        List r104 = CollectionsKt.createListBuilder();
        long[] r105 = r102.items;
        int r106 = r102.itemsSize;
        long r107 = r105[r103];
        long r108 = r105[r103 + 1];
        int r110 = 0;
    L8:
        if (r110 >= (r105.length - 2)) goto L23;
        if (r110 >= r106) goto L23;
        if (r110 == r103) goto L11;
        long r111 = r105[r110 + 0];
        int r112 = r110;
        long r113 = r105[r110 + 1];
        if (((((r108 - r111) - InlineClassHelperKt.Uint64Low32) | ((r113 - r107) - InlineClassHelperKt.Uint64Low32)) & (-9223372034707292160L)) != 0) goto L15;
        boolean r114 = true;
    L16:
        if (r114 == false) goto L20;
        int r115 = r106;
        int r116 = r103;
        int r109 = (int) (r111 >> 32);
        int r117 = (int) r111;
        int r118 = (int) (r113 >> 32);
        int r119 = (int) r113;
        long r120 = r107;
        if (r100.isTargetDrawnFirst$ui_release(r101, 67108863 & ((int) r105[r112 + 2])) == false) goto L21;
        r104.add(new IntRect(r109, r117, r118, r119));
    L21:
        r110 = r112 + 3;
        r103 = r116;
        r106 = r115;
        r107 = r120;
        goto L8
    L20:
        r115 = r106;
        r116 = r103;
        r120 = r107;
        goto L21
    L15:
        r114 = false;
        goto L16
    L11:
        r110 = r110 + 3;
    L23:
        return CollectionsKt.build(r104);
    L5:
        return CollectionsKt.emptyList();
    }

    public final float fractionVisibleInWindow() {
        long r100 = this.windowSize;
        return fractionVisibleInRect(0, 0, (int) (r100 >> 32), (int) r100);
    }

    public final IntRect getBoundsInRoot() {
        long r100 = this.topLeft;
        long r101 = this.bottomRight;
        return new IntRect((int) (r100 >> 32), (int) r100, (int) (r101 >> 32), (int) r101);
    }

    public final IntRect getBoundsInScreen() {
        if (this.viewToWindowMatrix == null) goto L6;
        IntRect r100 = getBoundsInWindow();
        long r101 = this.windowOffset;
        return new IntRect(r100.getLeft() + IntOffset.m7676getXimpl(r101), r100.getTop() + IntOffset.m7677getYimpl(r101), r100.getRight() + IntOffset.m7676getXimpl(r101), r100.getBottom() + IntOffset.m7677getYimpl(r101));
    L6:
        long r102 = this.topLeft;
        int r103 = (int) (r102 >> 32);
        int r104 = (int) r102;
        long r105 = this.bottomRight;
        int r106 = (int) (r105 >> 32);
        int r107 = (int) r105;
        int r108 = IntOffset.m7676getXimpl(this.screenOffset);
        int r109 = IntOffset.m7677getYimpl(this.screenOffset);
        return new IntRect(r103 + r108, r104 + r109, r106 + r108, r107 + r109);
    }

    public final IntRect getBoundsInWindow() {
        long r100 = this.topLeft;
        int r101 = (int) (r100 >> 32);
        int r102 = (int) r100;
        long r103 = this.bottomRight;
        int r104 = (int) (r103 >> 32);
        int r105 = (int) r103;
        float[] r106 = this.viewToWindowMatrix;
        if (r106 != null) goto L5;
        int r107 = IntOffset.m7676getXimpl(this.screenOffset) - IntOffset.m7676getXimpl(this.windowOffset);
        int r108 = IntOffset.m7677getYimpl(this.screenOffset) - IntOffset.m7677getYimpl(this.windowOffset);
        return new IntRect(r101 + r107, r102 + r108, r104 + r107, r105 + r108);
    L5:
        return IntRectKt.roundToIntRect(Matrix.m5084mapimpl(r106, new Rect(r101, r102, r104, r105)));
    }

    public final int getHeight() {
        int r100 = (int) this.topLeft;
        return ((int) this.bottomRight) - r100;
    }

    /* JADX INFO: renamed from: getPositionInRoot-nOcc-ac, reason: not valid java name */
    public final long m6798getPositionInRootnOccac() {
        return IntOffset.m7670constructorimpl(this.topLeft);
    }

    /* JADX INFO: renamed from: getPositionInScreen-nOcc-ac, reason: not valid java name */
    public final long m6799getPositionInScreennOccac() {
        int r100 = IntOffset.m7676getXimpl(this.screenOffset);
        int r101 = IntOffset.m7677getYimpl(this.screenOffset);
        long r102 = this.topLeft;
        return IntOffset.m7670constructorimpl((((long) (((int) (r102 >> 32)) + r100)) << 32) | (((long) (((int) r102) + r101)) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: getPositionInWindow-nOcc-ac, reason: not valid java name */
    public final long m6800getPositionInWindownOccac() {
        int r100 = IntOffset.m7676getXimpl(this.screenOffset) - IntOffset.m7676getXimpl(this.windowOffset);
        int r101 = IntOffset.m7677getYimpl(this.screenOffset) - IntOffset.m7677getYimpl(this.windowOffset);
        long r102 = this.topLeft;
        return IntOffset.m7670constructorimpl((((long) (((int) (r102 >> 32)) + r100)) << 32) | (((long) (((int) r102) + r101)) & BodyPartID.bodyIdMax));
    }

    public final int getWidth() {
        int r100 = (int) (this.topLeft >> 32);
        return ((int) (this.bottomRight >> 32)) - r100;
    }

    public int hashCode() {
        long r100 = this.topLeft;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.bottomRight;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.windowSize;
        int r105 = (((((r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31) + IntOffset.m7678hashCodeimpl(this.windowOffset)) * 31) + IntOffset.m7678hashCodeimpl(this.screenOffset)) * 31;
        float[] r106 = this.viewToWindowMatrix;
        if (r106 == null) goto L5;
        int r107 = Matrix.m5081hashCodeimpl(r106);
    L7:
        return ((r105 + r107) * 31) + this.node.hashCode();
    L5:
        r107 = 0;
        goto L7
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L38:
        return false;
    L8:
        if (RelativeLayoutBounds.class != r100.getClass()) goto L38;
        RelativeLayoutBounds r101 = (RelativeLayoutBounds) r100;
        if (this.topLeft == r101.topLeft) goto L14;
        return false;
    L14:
        if (this.bottomRight == r101.bottomRight) goto L17;
        return false;
    L17:
        if (this.windowSize == r101.windowSize) goto L20;
        return false;
    L20:
        if (IntOffset.m7675equalsimpl0(this.windowOffset, r101.windowOffset) == true) goto L23;
        return false;
    L23:
        if (IntOffset.m7675equalsimpl0(this.screenOffset, r101.screenOffset) == true) goto L25;
        return false;
    L25:
        float[] r102 = this.viewToWindowMatrix;
        float[] r103 = r101.viewToWindowMatrix;
        if (r102 != null) goto L29;
        if (r103 != null) goto L30;
        boolean r104 = true;
    L32:
        if (r104 == true) goto L35;
        return false;
    L35:
        if (Intrinsics.areEqual(this.node, r101.node) == true) goto L37;
        return false;
    L37:
        return true;
    L30:
        r104 = false;
        goto L32
    L29:
        if (r103 == null) goto L30;
        r104 = Matrix.m5079equalsimpl0(r102, r103);
        goto L32
    }

    public final float fractionVisibleIn(RelativeLayoutBounds r100) {
        long r101 = r100.topLeft;
        long r102 = r100.bottomRight;
        return fractionVisibleInRect((int) (r101 >> 32), (int) r101, (int) (r102 >> 32), (int) r102);
    }

    /* JADX INFO: renamed from: fractionVisibleInWindowWithInsets-E1MhUcY, reason: not valid java name */
    public final float m6797fractionVisibleInWindowWithInsetsE1MhUcY(long r100, long r110) {
        long r101 = this.windowSize;
        int r102 = IntOffset.m7676getXimpl(this.windowOffset);
        int r103 = IntOffset.m7677getYimpl(this.windowOffset);
        return fractionVisibleInRect(IntOffset.m7676getXimpl(r100) + r102, IntOffset.m7677getYimpl(r100) + r103, (r102 + ((int) (r101 >> 32))) - IntOffset.m7676getXimpl(r110), (r103 + ((int) r101)) - IntOffset.m7677getYimpl(r110));
    }

    public final float fractionVisibleInRect(int r100, int r110, int r111, int r112) {
        int r101 = (int) (this.topLeft >> 32);
        int r102 = Math.min(Math.max(r101, r100), r111);
        int r103 = (int) this.topLeft;
        int r104 = Math.min(Math.max(r103, r110), r112);
        int r105 = (int) (this.bottomRight >> 32);
        int r106 = Math.max(Math.min(r105, r111), r100);
        int r107 = (int) this.bottomRight;
        return Math.max((r106 - r102) * (Math.max(Math.min(r107, r112), r110) - r104), 0) / Math.min((r111 - r100) * (r112 - r110), (r105 - r101) * (r107 - r103));
    }

    private RelativeLayoutBounds(long r100, long r101, long r102, long r103, long r104, float[] r110, DelegatableNode r111) {
        this.topLeft = r100;
        this.bottomRight = r101;
        this.windowOffset = r102;
        this.screenOffset = r103;
        this.windowSize = r104;
        this.viewToWindowMatrix = r110;
        this.node = r111;
    }
}
