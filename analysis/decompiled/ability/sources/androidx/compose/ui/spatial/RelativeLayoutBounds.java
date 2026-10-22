package androidx.compose.ui.spatial;

import H4.o;
import androidx.appfunctions.metadata.a;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.e;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0007\u0018\u00002\u00020\u0001BC\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0000¢\u0006\u0004\b\u0015\u0010\u0016J-\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010$\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010#J\u001a\u0010'\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0017H\u0016¢\u0006\u0004\b)\u0010*R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010+R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010+R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010+R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010+R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010+R\u0016\u0010\n\u001a\u0004\u0018\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010,R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010-R\u0011\u00100\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0011\u00102\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b1\u0010/R\u0011\u00104\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b3\u0010/R\u0011\u00106\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b5\u0010*R\u0011\u00108\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b7\u0010*R\u0011\u0010;\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0011\u0010=\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b<\u0010:R\u0011\u0010?\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b>\u0010:¨\u0006@"}, d2 = {"Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "", "", "topLeft", "bottomRight", "Landroidx/compose/ui/unit/IntOffset;", "windowOffset", "screenOffset", "windowSize", "Landroidx/compose/ui/graphics/Matrix;", "viewToWindowMatrix", "Landroidx/compose/ui/node/DelegatableNode;", "node", AppAgent.CONSTRUCT, "(JJJJJ[FLandroidx/compose/ui/node/DelegatableNode;Lkotlin/jvm/internal/e;)V", "", "Landroidx/compose/ui/unit/IntRect;", "calculateOcclusions", "()Ljava/util/List;", "viewport", "", "fractionVisibleIn", "(Landroidx/compose/ui/spatial/RelativeLayoutBounds;)F", "", "left", "top", "right", "bottom", "fractionVisibleInRect", "(IIII)F", "fractionVisibleInWindow", "()F", "topLeftInset", "bottomRightInset", "fractionVisibleInWindowWithInsets-E1MhUcY", "(JJ)F", "fractionVisibleInWindowWithInsets", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "J", "[F", "Landroidx/compose/ui/node/DelegatableNode;", "getPositionInRoot-nOcc-ac", "()J", "positionInRoot", "getPositionInWindow-nOcc-ac", "positionInWindow", "getPositionInScreen-nOcc-ac", "positionInScreen", "getWidth", "width", "getHeight", "height", "getBoundsInRoot", "()Landroidx/compose/ui/unit/IntRect;", "boundsInRoot", "getBoundsInWindow", "boundsInWindow", "getBoundsInScreen", "boundsInScreen", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RelativeLayoutBounds {
    public static final int $stable = 8;
    private final long bottomRight;
    private final DelegatableNode node;
    private final long screenOffset;
    private final long topLeft;
    private final float[] viewToWindowMatrix;
    private final long windowOffset;
    private final long windowSize;

    public /* synthetic */ RelativeLayoutBounds(long j5, long j6, long j10, long j11, long j12, float[] fArr, DelegatableNode delegatableNode, e eVar) {
        this(j5, j6, j10, j11, j12, fArr, delegatableNode);
    }

    public final List<IntRect> calculateOcclusions() {
        int i;
        int i6;
        RectManager rectManager = DelegatableNodeKt.requireOwner(this.node).getRectManager();
        int semanticsId = DelegatableNodeKt.requireLayoutNode(this.node).getSemanticsId();
        RectList rects = rectManager.getRects();
        int iIndexOf = rects.indexOf(semanticsId);
        if (iIndexOf < 0) {
            return EmptyList.f4893a;
        }
        ListBuilder listBuilderY = o.y();
        long[] jArr = rects.items;
        int i10 = rects.itemsSize;
        long j5 = jArr[iIndexOf];
        long j6 = jArr[iIndexOf + 1];
        int i11 = 0;
        while (i11 < jArr.length - 2 && i11 < i10) {
            if (i11 == iIndexOf) {
                i11 += 3;
            } else {
                long j10 = jArr[i11];
                long j11 = jArr[i11 + 1];
                if (((((j6 - j10) - InlineClassHelperKt.Uint64Low32) | ((j11 - j5) - InlineClassHelperKt.Uint64Low32)) & (-9223372034707292160L)) == 0) {
                    i = i10;
                    i6 = iIndexOf;
                    int i12 = (int) (j10 >> 32);
                    int i13 = (int) j10;
                    int i14 = (int) (j11 >> 32);
                    int i15 = (int) j11;
                    if (rectManager.isTargetDrawnFirst$ui_release(semanticsId, ((int) jArr[i11 + 2]) & RectListKt.Lower26Bits)) {
                        listBuilderY.add(new IntRect(i12, i13, i14, i15));
                    }
                } else {
                    i = i10;
                    i6 = iIndexOf;
                }
                i11 += 3;
                iIndexOf = i6;
                i10 = i;
            }
        }
        return o.q(listBuilderY);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r6 != r7) goto L4
            return r0
        L4:
            r1 = 0
            if (r7 == 0) goto L65
            java.lang.Class<androidx.compose.ui.spatial.RelativeLayoutBounds> r2 = androidx.compose.ui.spatial.RelativeLayoutBounds.class
            java.lang.Class r3 = r7.getClass()
            if (r2 == r3) goto L10
            goto L65
        L10:
            androidx.compose.ui.spatial.RelativeLayoutBounds r7 = (androidx.compose.ui.spatial.RelativeLayoutBounds) r7
            long r2 = r6.topLeft
            long r4 = r7.topLeft
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L1b
            return r1
        L1b:
            long r2 = r6.bottomRight
            long r4 = r7.bottomRight
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L24
            return r1
        L24:
            long r2 = r6.windowSize
            long r4 = r7.windowSize
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L2d
            return r1
        L2d:
            long r2 = r6.windowOffset
            long r4 = r7.windowOffset
            boolean r2 = androidx.compose.ui.unit.IntOffset.m6971equalsimpl0(r2, r4)
            if (r2 != 0) goto L38
            return r1
        L38:
            long r2 = r6.screenOffset
            long r4 = r7.screenOffset
            boolean r2 = androidx.compose.ui.unit.IntOffset.m6971equalsimpl0(r2, r4)
            if (r2 != 0) goto L43
            return r1
        L43:
            float[] r2 = r6.viewToWindowMatrix
            float[] r3 = r7.viewToWindowMatrix
            if (r2 != 0) goto L4f
            if (r3 != 0) goto L4d
            r2 = r0
            goto L56
        L4d:
            r2 = r1
            goto L56
        L4f:
            if (r3 != 0) goto L52
            goto L4d
        L52:
            boolean r2 = androidx.compose.ui.graphics.Matrix.m4382equalsimpl0(r2, r3)
        L56:
            if (r2 != 0) goto L59
            return r1
        L59:
            androidx.compose.ui.node.DelegatableNode r6 = r6.node
            androidx.compose.ui.node.DelegatableNode r7 = r7.node
            boolean r6 = kotlin.jvm.internal.k.b(r6, r7)
            if (r6 != 0) goto L64
            return r1
        L64:
            return r0
        L65:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.spatial.RelativeLayoutBounds.equals(java.lang.Object):boolean");
    }

    public final float fractionVisibleIn(RelativeLayoutBounds viewport) {
        long j5 = viewport.topLeft;
        long j6 = viewport.bottomRight;
        return fractionVisibleInRect((int) (j5 >> 32), (int) j5, (int) (j6 >> 32), (int) j6);
    }

    public final float fractionVisibleInRect(int left, int top, int right, int bottom) {
        int iMin = Math.min(Math.max((int) (this.topLeft >> 32), left), right);
        int iMin2 = Math.min(Math.max((int) this.topLeft, top), bottom);
        int iMax = Math.max(Math.min((int) (this.bottomRight >> 32), right), left);
        int iMax2 = Math.max(Math.min((int) this.bottomRight, bottom), top);
        return Math.max((iMax2 - iMin2) * (iMax - iMin), 0) / Math.min((bottom - top) * (right - left), (r8 - r3) * (r2 - r0));
    }

    public final float fractionVisibleInWindow() {
        long j5 = this.windowSize;
        return fractionVisibleInRect(0, 0, (int) (j5 >> 32), (int) j5);
    }

    /* renamed from: fractionVisibleInWindowWithInsets-E1MhUcY, reason: not valid java name */
    public final float m6110fractionVisibleInWindowWithInsetsE1MhUcY(long topLeftInset, long bottomRightInset) {
        long j5 = this.windowSize;
        int iM6972getXimpl = IntOffset.m6972getXimpl(this.windowOffset);
        int iM6973getYimpl = IntOffset.m6973getYimpl(this.windowOffset);
        return fractionVisibleInRect(IntOffset.m6972getXimpl(topLeftInset) + iM6972getXimpl, IntOffset.m6973getYimpl(topLeftInset) + iM6973getYimpl, (iM6972getXimpl + ((int) (j5 >> 32))) - IntOffset.m6972getXimpl(bottomRightInset), (iM6973getYimpl + ((int) j5)) - IntOffset.m6973getYimpl(bottomRightInset));
    }

    public final IntRect getBoundsInRoot() {
        long j5 = this.topLeft;
        long j6 = this.bottomRight;
        return new IntRect((int) (j5 >> 32), (int) j5, (int) (j6 >> 32), (int) j6);
    }

    public final IntRect getBoundsInScreen() {
        if (this.viewToWindowMatrix == null) {
            long j5 = this.topLeft;
            int i = (int) (j5 >> 32);
            long j6 = this.bottomRight;
            int i6 = (int) (j6 >> 32);
            int i10 = (int) j6;
            int iM6972getXimpl = IntOffset.m6972getXimpl(this.screenOffset);
            int iM6973getYimpl = IntOffset.m6973getYimpl(this.screenOffset);
            return new IntRect(i + iM6972getXimpl, ((int) j5) + iM6973getYimpl, i6 + iM6972getXimpl, i10 + iM6973getYimpl);
        }
        IntRect boundsInWindow = getBoundsInWindow();
        long j10 = this.windowOffset;
        return new IntRect(IntOffset.m6972getXimpl(j10) + boundsInWindow.getLeft(), IntOffset.m6973getYimpl(j10) + boundsInWindow.getTop(), IntOffset.m6972getXimpl(j10) + boundsInWindow.getRight(), IntOffset.m6973getYimpl(j10) + boundsInWindow.getBottom());
    }

    public final IntRect getBoundsInWindow() {
        long j5 = this.topLeft;
        int i = (int) (j5 >> 32);
        int i6 = (int) j5;
        long j6 = this.bottomRight;
        int i10 = (int) (j6 >> 32);
        int i11 = (int) j6;
        float[] fArr = this.viewToWindowMatrix;
        if (fArr != null) {
            return IntRectKt.roundToIntRect(Matrix.m4387mapimpl(fArr, new Rect(i, i6, i10, i11)));
        }
        int iM6972getXimpl = IntOffset.m6972getXimpl(this.screenOffset) - IntOffset.m6972getXimpl(this.windowOffset);
        int iM6973getYimpl = IntOffset.m6973getYimpl(this.screenOffset) - IntOffset.m6973getYimpl(this.windowOffset);
        return new IntRect(i + iM6972getXimpl, i6 + iM6973getYimpl, i10 + iM6972getXimpl, i11 + iM6973getYimpl);
    }

    public final int getHeight() {
        return ((int) this.bottomRight) - ((int) this.topLeft);
    }

    /* renamed from: getPositionInRoot-nOcc-ac, reason: not valid java name */
    public final long m6111getPositionInRootnOccac() {
        return IntOffset.m6966constructorimpl(this.topLeft);
    }

    /* renamed from: getPositionInScreen-nOcc-ac, reason: not valid java name */
    public final long m6112getPositionInScreennOccac() {
        int iM6972getXimpl = IntOffset.m6972getXimpl(this.screenOffset);
        int iM6973getYimpl = IntOffset.m6973getYimpl(this.screenOffset);
        long j5 = this.topLeft;
        return IntOffset.m6966constructorimpl(((((int) (j5 >> 32)) + iM6972getXimpl) << 32) | ((((int) j5) + iM6973getYimpl) & 4294967295L));
    }

    /* renamed from: getPositionInWindow-nOcc-ac, reason: not valid java name */
    public final long m6113getPositionInWindownOccac() {
        int iM6972getXimpl = IntOffset.m6972getXimpl(this.screenOffset) - IntOffset.m6972getXimpl(this.windowOffset);
        int iM6973getYimpl = IntOffset.m6973getYimpl(this.screenOffset) - IntOffset.m6973getYimpl(this.windowOffset);
        long j5 = this.topLeft;
        return IntOffset.m6966constructorimpl(((((int) (j5 >> 32)) + iM6972getXimpl) << 32) | ((((int) j5) + iM6973getYimpl) & 4294967295L));
    }

    public final int getWidth() {
        return ((int) (this.bottomRight >> 32)) - ((int) (this.topLeft >> 32));
    }

    public int hashCode() {
        int iM6974hashCodeimpl = (IntOffset.m6974hashCodeimpl(this.screenOffset) + ((IntOffset.m6974hashCodeimpl(this.windowOffset) + a.c(a.c(Long.hashCode(this.topLeft) * 31, 31, this.bottomRight), 31, this.windowSize)) * 31)) * 31;
        float[] fArr = this.viewToWindowMatrix;
        return this.node.hashCode() + ((iM6974hashCodeimpl + (fArr != null ? Matrix.m4384hashCodeimpl(fArr) : 0)) * 31);
    }

    private RelativeLayoutBounds(long j5, long j6, long j10, long j11, long j12, float[] fArr, DelegatableNode delegatableNode) {
        this.topLeft = j5;
        this.bottomRight = j6;
        this.windowOffset = j10;
        this.screenOffset = j11;
        this.windowSize = j12;
        this.viewToWindowMatrix = fArr;
        this.node = delegatableNode;
    }
}
