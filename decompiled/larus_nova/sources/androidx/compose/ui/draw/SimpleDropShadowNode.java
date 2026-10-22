package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.shadow.DropShadowPainter;
import androidx.compose.ui.graphics.shadow.Shadow;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.ObserverModifierNode;
import com.alibaba.gaiax.render.view.GXViewKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\b\u0010\u000e\u001a\u00020\u000bH\u0002J\f\u0010\u000f\u001a\u00020\r*\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/draw/SimpleDropShadowNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/ObserverModifierNode;", "shape", "Landroidx/compose/ui/graphics/Shape;", GXViewKey.VIEW_TYPE_SHADOW_LAYOUT, "Landroidx/compose/ui/graphics/shadow/Shadow;", "<init>", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/shadow/Shadow;)V", "shadowPainter", "Landroidx/compose/ui/graphics/shadow/DropShadowPainter;", "update", "", "obtainPainter", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "onObservedReadsChanged", "equals", "", "other", "", "hashCode", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SimpleDropShadowNode extends Modifier.Node implements DrawModifierNode, ObserverModifierNode {
    public static final int $stable = 8;
    private Shadow shadow;
    private DropShadowPainter shadowPainter;
    private Shape shape;

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final /* synthetic */ void onMeasureResultChanged() {
        DrawModifierNode.CC.$default$onMeasureResultChanged(this);
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public void onObservedReadsChanged() {
        this.shadowPainter = null;
        DrawModifierNodeKt.invalidateDraw(this);
    }

    private final DropShadowPainter obtainPainter() {
        DropShadowPainter r100 = this.shadowPainter;
        if (r100 != null) goto L6;
        DropShadowPainter r101 = DelegatableNodeKt.requireGraphicsContext(this).getShadowContext().createDropShadowPainter(this.shape, this.shadow);
        this.shadowPainter = r101;
        return r101;
    L6:
        return r100;
    }

    public int hashCode() {
        return (this.shape.hashCode() * 31) + this.shadow.hashCode();
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope r100) {
        Painter.m5535drawx_KDEd0$default(obtainPainter(), r100, r100.mo5322getSizeNHjbRc(), 0.0f, null, 6, null);
        r100.drawContent();
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L17:
        return false;
    L8:
        if ((r100 instanceof SimpleDropShadowNode) == false) goto L17;
        SimpleDropShadowNode r101 = (SimpleDropShadowNode) r100;
        if (Intrinsics.areEqual(this.shape, r101.shape) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.shadow, r101.shadow) == true) goto L16;
        return false;
    L16:
        return true;
    }

    public SimpleDropShadowNode(Shape r100, Shadow r101) {
        this.shape = r100;
        this.shadow = r101;
    }

    public final void update(Shape r100, Shadow r101) {
        if (Intrinsics.areEqual(this.shape, r100) == true) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        this.shadowPainter = null;
    L11:
        this.shape = r100;
        this.shadow = r101;
        return;
    L5:
        if (Intrinsics.areEqual(this.shadow, r101) == false) goto L8;
        r102 = false;
        goto L9
    }
}
