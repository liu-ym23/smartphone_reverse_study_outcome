package androidx.compose.foundation;

import N9.j;
import S7.k;
import android.graphics.Rect;
import android.view.View;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNode_androidKt;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u0016H&¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001a\u001a\u00020\u000b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u0016H&¢\u0006\u0004\b\u001a\u0010\u001bR0\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010\bR\u0018\u0010 \u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010%\u001a\u00020\"8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006&"}, d2 = {"Landroidx/compose/foundation/RectListNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/geometry/Rect;", "rect", AppAgent.CONSTRUCT, "(LS7/k;)V", "Landroid/graphics/Rect;", "newRect", "LC7/r;", "replaceRect", "(Landroid/graphics/Rect;)V", "layoutCoordinates", "calcBounds", "(Landroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/geometry/Rect;)Landroid/graphics/Rect;", "coordinates", "onGloballyPositioned", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "onDetach", "()V", "Landroidx/compose/runtime/collection/MutableVector;", "currentRects", "()Landroidx/compose/runtime/collection/MutableVector;", "rects", "updateRects", "(Landroidx/compose/runtime/collection/MutableVector;)V", "LS7/k;", "getRect", "()LS7/k;", "setRect", "androidRect", "Landroid/graphics/Rect;", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class RectListNode extends Modifier.Node implements GlobalPositionAwareModifierNode {
    public static final int $stable = 8;
    private Rect androidRect;
    private k rect;

    public RectListNode(k kVar) {
        this.rect = kVar;
    }

    private final Rect calcBounds(LayoutCoordinates layoutCoordinates, androidx.compose.ui.geometry.Rect rect) {
        LayoutCoordinates layoutCoordinatesFindRootCoordinates = LayoutCoordinatesKt.findRootCoordinates(layoutCoordinates);
        long jMo5558localPositionOfR5De75A = layoutCoordinatesFindRootCoordinates.mo5558localPositionOfR5De75A(layoutCoordinates, rect.m3930getTopLeftF1C5BW0());
        long jMo5558localPositionOfR5De75A2 = layoutCoordinatesFindRootCoordinates.mo5558localPositionOfR5De75A(layoutCoordinates, rect.m3931getTopRightF1C5BW0());
        long jMo5558localPositionOfR5De75A3 = layoutCoordinatesFindRootCoordinates.mo5558localPositionOfR5De75A(layoutCoordinates, rect.m3923getBottomLeftF1C5BW0());
        long jMo5558localPositionOfR5De75A4 = layoutCoordinatesFindRootCoordinates.mo5558localPositionOfR5De75A(layoutCoordinates, rect.m3924getBottomRightF1C5BW0());
        float fM3895getXimpl = Offset.m3895getXimpl(jMo5558localPositionOfR5De75A);
        float[] fArr = {Offset.m3895getXimpl(jMo5558localPositionOfR5De75A2), Offset.m3895getXimpl(jMo5558localPositionOfR5De75A3), Offset.m3895getXimpl(jMo5558localPositionOfR5De75A4)};
        for (int i = 0; i < 3; i++) {
            fM3895getXimpl = Math.min(fM3895getXimpl, fArr[i]);
        }
        float fM3896getYimpl = Offset.m3896getYimpl(jMo5558localPositionOfR5De75A);
        float[] fArr2 = {Offset.m3896getYimpl(jMo5558localPositionOfR5De75A2), Offset.m3896getYimpl(jMo5558localPositionOfR5De75A3), Offset.m3896getYimpl(jMo5558localPositionOfR5De75A4)};
        for (int i6 = 0; i6 < 3; i6++) {
            fM3896getYimpl = Math.min(fM3896getYimpl, fArr2[i6]);
        }
        return new Rect(U7.a.U(fM3895getXimpl), U7.a.U(fM3896getYimpl), U7.a.U(j.K(Offset.m3895getXimpl(jMo5558localPositionOfR5De75A), Offset.m3895getXimpl(jMo5558localPositionOfR5De75A2), Offset.m3895getXimpl(jMo5558localPositionOfR5De75A3), Offset.m3895getXimpl(jMo5558localPositionOfR5De75A4))), U7.a.U(j.K(Offset.m3896getYimpl(jMo5558localPositionOfR5De75A), Offset.m3896getYimpl(jMo5558localPositionOfR5De75A2), Offset.m3896getYimpl(jMo5558localPositionOfR5De75A3), Offset.m3896getYimpl(jMo5558localPositionOfR5De75A4))));
    }

    private final void replaceRect(Rect newRect) {
        MutableVector<Rect> mutableVectorCurrentRects = currentRects();
        Rect rect = this.androidRect;
        if (rect != null) {
            mutableVectorCurrentRects.remove(rect);
        }
        if (newRect != null && !newRect.isEmpty()) {
            mutableVectorCurrentRects.add(newRect);
        }
        updateRects(mutableVectorCurrentRects);
        this.androidRect = newRect;
    }

    public abstract MutableVector<Rect> currentRects();

    public k getRect() {
        return this.rect;
    }

    public final View getView() {
        return DelegatableNode_androidKt.requireView(this);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        super.onDetach();
        replaceRect(null);
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        Rect rectCalcBounds;
        if (getRect() == null) {
            androidx.compose.ui.geometry.Rect rectBoundsInRoot = LayoutCoordinatesKt.boundsInRoot(coordinates);
            rectCalcBounds = new Rect(U7.a.U(rectBoundsInRoot.getLeft()), U7.a.U(rectBoundsInRoot.getTop()), U7.a.U(rectBoundsInRoot.getRight()), U7.a.U(rectBoundsInRoot.getBottom()));
        } else {
            k rect = getRect();
            kotlin.jvm.internal.k.c(rect);
            rectCalcBounds = calcBounds(coordinates, (androidx.compose.ui.geometry.Rect) rect.invoke(coordinates));
        }
        replaceRect(rectCalcBounds);
    }

    public void setRect(k kVar) {
        this.rect = kVar;
    }

    public abstract void updateRects(MutableVector<Rect> rects);
}
