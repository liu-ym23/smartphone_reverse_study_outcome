package androidx.compose.ui.graphics.shadow;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.LayoutDirection;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import g1.AbstractC1451a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\nJ\u0013\u0010\r\u001a\u00020\f*\u00020\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0018H\u0014¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001cR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001dR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u001fR\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010 R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010!R\u0014\u0010%\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006&"}, d2 = {"Landroidx/compose/ui/graphics/shadow/DropShadowPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "Landroidx/compose/ui/graphics/Shape;", "shape", "Landroidx/compose/ui/graphics/shadow/Shadow;", "shadow", "Landroidx/compose/ui/graphics/shadow/DropShadowRendererProvider;", "renderCreator", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/shadow/Shadow;Landroidx/compose/ui/graphics/shadow/DropShadowRendererProvider;)V", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/shadow/Shadow;)V", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "LC7/r;", "onDraw", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;)V", "", "alpha", "", "applyAlpha", "(F)Z", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "applyColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)Z", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "applyLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)Z", "Landroidx/compose/ui/graphics/Shape;", "Landroidx/compose/ui/graphics/shadow/Shadow;", "Landroidx/compose/ui/graphics/shadow/DropShadowRendererProvider;", "F", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/graphics/ColorFilter;", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "intrinsicSize", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DropShadowPainter extends Painter {
    private float alpha;
    private ColorFilter colorFilter;
    private LayoutDirection layoutDirection;
    private final DropShadowRendererProvider renderCreator;
    private final Shadow shadow;
    private final Shape shape;

    public DropShadowPainter(Shape shape, Shadow shadow, DropShadowRendererProvider dropShadowRendererProvider) {
        this.shape = shape;
        this.shadow = shadow;
        this.renderCreator = dropShadowRendererProvider;
        this.alpha = 1.0f;
        this.layoutDirection = LayoutDirection.Ltr;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public boolean applyAlpha(float alpha) {
        this.alpha = alpha;
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public boolean applyColorFilter(ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public boolean applyLayoutDirection(LayoutDirection layoutDirection) {
        this.layoutDirection = layoutDirection;
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    /* renamed from: getIntrinsicSize-NH-jbRc */
    public long getIntrinsicSize() {
        return Size.INSTANCE.m3972getUnspecifiedNHjbRc();
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public void onDraw(DrawScope drawScope) {
        DropShadowRenderer dropShadowRendererMo4834obtainDropShadowRenderereZhPAX0 = this.renderCreator.mo4834obtainDropShadowRenderereZhPAX0(this.shape, drawScope.mo4707getSizeNHjbRc(), drawScope.getLayoutDirection(), drawScope, this.shadow);
        float fMo381toPx0680j_4 = drawScope.mo381toPx0680j_4(DpOffset.m6905getXD9Ej5fM(this.shadow.getOffset()));
        float fMo381toPx0680j_42 = drawScope.mo381toPx0680j_4(DpOffset.m6907getYD9Ej5fM(this.shadow.getOffset()));
        drawScope.getDrawContext().getTransform().translate(fMo381toPx0680j_4, fMo381toPx0680j_42);
        try {
            dropShadowRendererMo4834obtainDropShadowRenderereZhPAX0.m4856drawShadowerFMhIw(drawScope, this.colorFilter, drawScope.mo4707getSizeNHjbRc(), dropShadowRendererMo4834obtainDropShadowRenderereZhPAX0.getShadow().getColor(), dropShadowRendererMo4834obtainDropShadowRenderereZhPAX0.getShadow().getBrush(), AbstractC1451a.t(this.alpha * dropShadowRendererMo4834obtainDropShadowRenderereZhPAX0.getShadow().getAlpha(), 0.0f, 1.0f), dropShadowRendererMo4834obtainDropShadowRenderereZhPAX0.getShadow().getBlendMode());
        } finally {
            drawScope.getDrawContext().getTransform().translate(-fMo381toPx0680j_4, -fMo381toPx0680j_42);
        }
    }

    public DropShadowPainter(Shape shape, Shadow shadow) {
        this(shape, shadow, DropShadowRendererProvider.INSTANCE.getDefault());
    }
}
