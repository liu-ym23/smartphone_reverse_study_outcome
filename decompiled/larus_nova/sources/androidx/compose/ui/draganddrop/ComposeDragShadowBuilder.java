package androidx.compose.ui.draganddrop;

import android.graphics.Canvas;
import android.graphics.Point;
import android.view.View;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B0\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u001f\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/draganddrop/ComposeDragShadowBuilder;", "Landroid/view/View$DragShadowBuilder;", "density", "Landroidx/compose/ui/unit/Density;", "decorationSize", "Landroidx/compose/ui/geometry/Size;", "drawDragDecoration", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Landroidx/compose/ui/unit/Density;JLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "onProvideShadowMetrics", "outShadowSize", "Landroid/graphics/Point;", "outShadowTouchPoint", "onDrawShadow", "canvas", "Landroid/graphics/Canvas;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ComposeDragShadowBuilder extends View.DragShadowBuilder {
    public static final int $stable = 8;
    private final long decorationSize;
    private final Density density;
    private final Function1<DrawScope, Unit> drawDragDecoration;

    public /* synthetic */ ComposeDragShadowBuilder(Density r100, long r101, Function1 r102, DefaultConstructorMarker r103) {
        this(r100, r101, r102);
    }

    @Override // android.view.View.DragShadowBuilder
    public void onDrawShadow(Canvas r110) {
        CanvasDrawScope r100 = new CanvasDrawScope();
        Density r101 = this.density;
        long r102 = this.decorationSize;
        LayoutDirection r103 = LayoutDirection.Ltr;
        androidx.compose.ui.graphics.Canvas r111 = AndroidCanvas_androidKt.Canvas(r110);
        Function1<DrawScope, Unit> r104 = this.drawDragDecoration;
        CanvasDrawScope.DrawParams r105 = r100.getDrawParams();
        Density r106 = r105.component1();
        LayoutDirection r107 = r105.component2();
        androidx.compose.ui.graphics.Canvas r108 = r105.component3();
        long r112 = r105.m5325component4NHjbRc();
        CanvasDrawScope.DrawParams r109 = r100.getDrawParams();
        r109.setDensity(r101);
        r109.setLayoutDirection(r103);
        r109.setCanvas(r111);
        r109.m5328setSizeuvyYCjk(r102);
        r111.save();
        r104.invoke(r100);
        r111.restore();
        CanvasDrawScope.DrawParams r113 = r100.getDrawParams();
        r113.setDensity(r106);
        r113.setLayoutDirection(r107);
        r113.setCanvas(r108);
        r113.m5328setSizeuvyYCjk(r112);
    }

    @Override // android.view.View.DragShadowBuilder
    public void onProvideShadowMetrics(Point r100, Point r101) {
        Density r102 = this.density;
        r100.set(r102.mo365roundToPx0680j_4(r102.mo367toDpu2uoSUM(Float.intBitsToFloat((int) (this.decorationSize >> 32)))), r102.mo365roundToPx0680j_4(r102.mo367toDpu2uoSUM(Float.intBitsToFloat((int) (this.decorationSize & BodyPartID.bodyIdMax)))));
        r101.set(r100.x / 2, r100.y / 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ComposeDragShadowBuilder(Density r100, long r101, Function1<? super DrawScope, Unit> r102) {
        this.density = r100;
        this.decorationSize = r101;
        this.drawDragDecoration = r102;
    }
}
