package androidx.compose.foundation;

import android.graphics.Rect;
import android.view.View;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNode_androidKt;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b!\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0017H&J\u0016\u0010\u0018\u001a\u00020\u00132\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u0017H&J\u0012\u0010\u001a\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\rH\u0002J\u0018\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0006H\u0002R(\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Landroidx/compose/foundation/RectListNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", SVGRenderEngine.RECT, "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/geometry/Rect;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getRect", "()Lkotlin/jvm/functions/Function1;", "setRect", "androidRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "onGloballyPositioned", "", "coordinates", "onDetach", "currentRects", "Landroidx/compose/runtime/collection/MutableVector;", "updateRects", "rects", "replaceRect", "newRect", "calcBounds", "layoutCoordinates", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class RectListNode extends Modifier.Node implements GlobalPositionAwareModifierNode {
    public static final int $stable = 8;
    private Rect androidRect;
    private Function1<? super LayoutCoordinates, androidx.compose.ui.geometry.Rect> rect;

    public abstract MutableVector<Rect> currentRects();

    public abstract void updateRects(MutableVector<Rect> r100);

    public final View getView() {
        return DelegatableNode_androidKt.requireView(this);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        super.onDetach();
        replaceRect(null);
    }

    public Function1<LayoutCoordinates, androidx.compose.ui.geometry.Rect> getRect() {
        return this.rect;
    }

    public RectListNode(Function1<? super LayoutCoordinates, androidx.compose.ui.geometry.Rect> r100) {
        this.rect = r100;
    }

    private final void replaceRect(Rect r100) {
        MutableVector<Rect> r101 = currentRects();
        Rect r102 = this.androidRect;
        if (r102 == null) goto L5;
        r101.remove(r102);
    L5:
        boolean r103 = false;
        if (r100 != null) goto L8;
    L10:
        if (r103 == false) goto L12;
        r101.add(r100);
    L12:
        updateRects(r101);
        this.androidRect = r100;
        return;
    L8:
        if (r100.isEmpty() == true) goto L10;
        r103 = true;
        goto L10
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public void onGloballyPositioned(LayoutCoordinates r100) {
        if (getRect() != null) goto L5;
        androidx.compose.ui.geometry.Rect r101 = LayoutCoordinatesKt.boundsInRoot(r100);
        Rect r102 = new Rect(MathKt.roundToInt(r101.getLeft()), MathKt.roundToInt(r101.getTop()), MathKt.roundToInt(r101.getRight()), MathKt.roundToInt(r101.getBottom()));
    L6:
        replaceRect(r102);
        return;
    L5:
        Function1<LayoutCoordinates, androidx.compose.ui.geometry.Rect> r103 = getRect();
        Intrinsics.checkNotNull(r103);
        r102 = calcBounds(r100, r103.invoke(r100));
        goto L6
    }

    public void setRect(Function1<? super LayoutCoordinates, androidx.compose.ui.geometry.Rect> r100) {
        this.rect = r100;
    }

    private final Rect calcBounds(LayoutCoordinates r210, androidx.compose.ui.geometry.Rect r211) {
        LayoutCoordinates r100 = LayoutCoordinatesKt.findRootCoordinates(r210);
        long r101 = r100.mo6259localPositionOfR5De75A(r210, r211.m4617getTopLeftF1C5BW0());
        long r102 = r100.mo6259localPositionOfR5De75A(r210, r211.m4618getTopRightF1C5BW0());
        long r103 = r100.mo6259localPositionOfR5De75A(r210, r211.m4610getBottomLeftF1C5BW0());
        long r104 = r100.mo6259localPositionOfR5De75A(r210, r211.m4611getBottomRightF1C5BW0());
        int r110 = (int) (r101 >> 32);
        int r111 = (int) (r102 >> 32);
        int r112 = (int) (r103 >> 32);
        int r105 = (int) (r104 >> 32);
        float r106 = ComparisonsKt.minOf(Float.intBitsToFloat(r110), new float[]{Float.intBitsToFloat(r111), Float.intBitsToFloat(r112), Float.intBitsToFloat(r105)});
        int r107 = (int) (r101 & BodyPartID.bodyIdMax);
        float r108 = Float.intBitsToFloat(r107);
        int r109 = (int) (r102 & BodyPartID.bodyIdMax);
        int r113 = (int) (r103 & BodyPartID.bodyIdMax);
        int r114 = (int) (r104 & BodyPartID.bodyIdMax);
        return new Rect(MathKt.roundToInt(r106), MathKt.roundToInt(ComparisonsKt.minOf(r108, new float[]{Float.intBitsToFloat(r109), Float.intBitsToFloat(r113), Float.intBitsToFloat(r114)})), MathKt.roundToInt(ComparisonsKt.maxOf(Float.intBitsToFloat(r110), new float[]{Float.intBitsToFloat(r111), Float.intBitsToFloat(r112), Float.intBitsToFloat(r105)})), MathKt.roundToInt(ComparisonsKt.maxOf(Float.intBitsToFloat(r107), new float[]{Float.intBitsToFloat(r109), Float.intBitsToFloat(r113), Float.intBitsToFloat(r114)})));
    }
}
