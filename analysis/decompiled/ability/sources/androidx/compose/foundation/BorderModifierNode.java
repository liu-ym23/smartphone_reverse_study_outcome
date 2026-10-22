package androidx.compose.foundation;

import C7.r;
import S7.k;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.draw.CacheDrawModifierNode;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.unit.Dp;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.e;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ3\u0010\u0013\u001a\u00020\u0012*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014JF\u0010\u001c\u001a\u00020\u0012*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR0\u0010!\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00028\u0006@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R*\u0010\u000b\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00048\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R*\u0010,\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00065"}, d2 = {"Landroidx/compose/foundation/BorderModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/unit/Dp;", "widthParameter", "Landroidx/compose/ui/graphics/Brush;", "brushParameter", "Landroidx/compose/ui/graphics/Shape;", "shapeParameter", AppAgent.CONSTRUCT, "(FLandroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/internal/e;)V", "Landroidx/compose/ui/draw/CacheDrawScope;", "brush", "Landroidx/compose/ui/graphics/Outline$Generic;", "outline", "", "fillArea", "", "strokeWidth", "Landroidx/compose/ui/draw/DrawResult;", "drawGenericBorder", "(Landroidx/compose/ui/draw/CacheDrawScope;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Outline$Generic;ZF)Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/graphics/Outline$Rounded;", "Landroidx/compose/ui/geometry/Offset;", "topLeft", "Landroidx/compose/ui/geometry/Size;", "borderSize", "drawRoundRectBorder-JqoCqck", "(Landroidx/compose/ui/draw/CacheDrawScope;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Outline$Rounded;JJZF)Landroidx/compose/ui/draw/DrawResult;", "drawRoundRectBorder", "Landroidx/compose/foundation/BorderCache;", "borderCache", "Landroidx/compose/foundation/BorderCache;", "value", "width", "F", "getWidth-D9Ej5fM", "()F", "setWidth-0680j_4", "(F)V", "Landroidx/compose/ui/graphics/Brush;", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "setBrush", "(Landroidx/compose/ui/graphics/Brush;)V", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "Landroidx/compose/ui/draw/CacheDrawModifierNode;", "drawWithCacheModifierNode", "Landroidx/compose/ui/draw/CacheDrawModifierNode;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BorderModifierNode extends DelegatingNode {
    public static final int $stable = 8;
    private BorderCache borderCache;
    private Brush brush;
    private final CacheDrawModifierNode drawWithCacheModifierNode;
    private Shape shape;
    private float width;

    public /* synthetic */ BorderModifierNode(float f, Brush brush, Shape shape, e eVar) {
        this(f, brush, shape);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.compose.ui.draw.DrawResult drawGenericBorder(androidx.compose.ui.draw.CacheDrawScope r39, final androidx.compose.ui.graphics.Brush r40, final androidx.compose.ui.graphics.Outline.Generic r41, boolean r42, float r43) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 691
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.BorderModifierNode.drawGenericBorder(androidx.compose.ui.draw.CacheDrawScope, androidx.compose.ui.graphics.Brush, androidx.compose.ui.graphics.Outline$Generic, boolean, float):androidx.compose.ui.draw.DrawResult");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawRoundRectBorder-JqoCqck, reason: not valid java name */
    public final DrawResult m258drawRoundRectBorderJqoCqck(CacheDrawScope cacheDrawScope, final Brush brush, Outline.Rounded rounded, final long j5, final long j6, final boolean z10, final float f) {
        if (RoundRectKt.isSimple(rounded.getRoundRect())) {
            final long jM3945getTopLeftCornerRadiuskKHJgLs = rounded.getRoundRect().m3945getTopLeftCornerRadiuskKHJgLs();
            final float f7 = f / 2;
            final Stroke stroke = new Stroke(f, 0.0f, 0, 0, null, 30, null);
            return cacheDrawScope.onDrawWithContent(new k() { // from class: androidx.compose.foundation.BorderModifierNode$drawRoundRectBorder$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((ContentDrawScope) obj);
                    return r.f317a;
                }

                public final void invoke(ContentDrawScope contentDrawScope) {
                    contentDrawScope.drawContent();
                    if (z10) {
                        DrawScope.m4702drawRoundRectZuiqVtQ$default(contentDrawScope, brush, 0L, 0L, jM3945getTopLeftCornerRadiuskKHJgLs, 0.0f, null, null, 0, 246, null);
                        return;
                    }
                    float fM3855getXimpl = CornerRadius.m3855getXimpl(jM3945getTopLeftCornerRadiuskKHJgLs);
                    float f9 = f7;
                    if (fM3855getXimpl >= f9) {
                        DrawScope.m4702drawRoundRectZuiqVtQ$default(contentDrawScope, brush, j5, j6, BorderKt.m256shrinkKibmq7A(jM3945getTopLeftCornerRadiuskKHJgLs, f9), 0.0f, stroke, null, 0, 208, null);
                        return;
                    }
                    float f10 = f;
                    float fM3964getWidthimpl = Size.m3964getWidthimpl(contentDrawScope.mo4707getSizeNHjbRc()) - f;
                    float fM3961getHeightimpl = Size.m3961getHeightimpl(contentDrawScope.mo4707getSizeNHjbRc()) - f;
                    int iM4127getDifferencertfAjoo = ClipOp.INSTANCE.m4127getDifferencertfAjoo();
                    Brush brush2 = brush;
                    long j10 = jM3945getTopLeftCornerRadiuskKHJgLs;
                    DrawContext drawContext = contentDrawScope.getDrawContext();
                    long jMo4628getSizeNHjbRc = drawContext.mo4628getSizeNHjbRc();
                    drawContext.getCanvas().save();
                    try {
                        drawContext.getTransform().mo4631clipRectN_I0leg(f10, f10, fM3964getWidthimpl, fM3961getHeightimpl, iM4127getDifferencertfAjoo);
                        DrawScope.m4702drawRoundRectZuiqVtQ$default(contentDrawScope, brush2, 0L, 0L, j10, 0.0f, null, null, 0, 246, null);
                    } finally {
                        androidx.appfunctions.metadata.a.A(drawContext, jMo4628getSizeNHjbRc);
                    }
                }
            });
        }
        if (this.borderCache == null) {
            this.borderCache = new BorderCache(null, null, null, null, 15, null);
        }
        BorderCache borderCache = this.borderCache;
        kotlin.jvm.internal.k.c(borderCache);
        final Path pathCreateRoundRectPath = BorderKt.createRoundRectPath(borderCache.obtainPath(), rounded.getRoundRect(), f, z10);
        return cacheDrawScope.onDrawWithContent(new k() { // from class: androidx.compose.foundation.BorderModifierNode$drawRoundRectBorder$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContentDrawScope) obj);
                return r.f317a;
            }

            public final void invoke(ContentDrawScope contentDrawScope) {
                contentDrawScope.drawContent();
                DrawScope.m4696drawPathGBMwjPU$default(contentDrawScope, pathCreateRoundRectPath, brush, 0.0f, null, null, 0, 60, null);
            }
        });
    }

    public final Brush getBrush() {
        return this.brush;
    }

    public final Shape getShape() {
        return this.shape;
    }

    /* renamed from: getWidth-D9Ej5fM, reason: not valid java name and from getter */
    public final float getWidth() {
        return this.width;
    }

    public final void setBrush(Brush brush) {
        if (kotlin.jvm.internal.k.b(this.brush, brush)) {
            return;
        }
        this.brush = brush;
        this.drawWithCacheModifierNode.invalidateDrawCache();
    }

    public final void setShape(Shape shape) {
        if (kotlin.jvm.internal.k.b(this.shape, shape)) {
            return;
        }
        this.shape = shape;
        this.drawWithCacheModifierNode.invalidateDrawCache();
    }

    /* renamed from: setWidth-0680j_4, reason: not valid java name */
    public final void m260setWidth0680j_4(float f) {
        if (Dp.m6849equalsimpl0(this.width, f)) {
            return;
        }
        this.width = f;
        this.drawWithCacheModifierNode.invalidateDrawCache();
    }

    private BorderModifierNode(float f, Brush brush, Shape shape) {
        this.width = f;
        this.brush = brush;
        this.shape = shape;
        this.drawWithCacheModifierNode = (CacheDrawModifierNode) delegate(DrawModifierKt.CacheDrawModifierNode(new k() { // from class: androidx.compose.foundation.BorderModifierNode$drawWithCacheModifierNode$1
            {
                super(1);
            }

            @Override // S7.k
            public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                if (cacheDrawScope.mo381toPx0680j_4(this.this$0.getWidth()) < 0.0f || Size.m3963getMinDimensionimpl(cacheDrawScope.m3676getSizeNHjbRc()) <= 0.0f) {
                    return BorderKt.drawContentWithoutBorder(cacheDrawScope);
                }
                float f7 = 2;
                float fMin = Math.min(Dp.m6849equalsimpl0(this.this$0.getWidth(), Dp.INSTANCE.m6862getHairlineD9Ej5fM()) ? 1.0f : (float) Math.ceil(cacheDrawScope.mo381toPx0680j_4(this.this$0.getWidth())), (float) Math.ceil(Size.m3963getMinDimensionimpl(cacheDrawScope.m3676getSizeNHjbRc()) / f7));
                float f9 = fMin / f7;
                long jOffset = OffsetKt.Offset(f9, f9);
                long jSize = SizeKt.Size(Size.m3964getWidthimpl(cacheDrawScope.m3676getSizeNHjbRc()) - fMin, Size.m3961getHeightimpl(cacheDrawScope.m3676getSizeNHjbRc()) - fMin);
                boolean z10 = f7 * fMin > Size.m3963getMinDimensionimpl(cacheDrawScope.m3676getSizeNHjbRc());
                Outline outlineMo289createOutlinePq9zytI = this.this$0.getShape().mo289createOutlinePq9zytI(cacheDrawScope.m3676getSizeNHjbRc(), cacheDrawScope.getLayoutDirection(), cacheDrawScope);
                if (outlineMo289createOutlinePq9zytI instanceof Outline.Generic) {
                    BorderModifierNode borderModifierNode = this.this$0;
                    return borderModifierNode.drawGenericBorder(cacheDrawScope, borderModifierNode.getBrush(), (Outline.Generic) outlineMo289createOutlinePq9zytI, z10, fMin);
                }
                if (outlineMo289createOutlinePq9zytI instanceof Outline.Rounded) {
                    BorderModifierNode borderModifierNode2 = this.this$0;
                    return borderModifierNode2.m258drawRoundRectBorderJqoCqck(cacheDrawScope, borderModifierNode2.getBrush(), (Outline.Rounded) outlineMo289createOutlinePq9zytI, jOffset, jSize, z10, fMin);
                }
                if (outlineMo289createOutlinePq9zytI instanceof Outline.Rectangle) {
                    return BorderKt.m255drawRectBorderNsqcLGU(cacheDrawScope, this.this$0.getBrush(), jOffset, jSize, z10, fMin);
                }
                throw new NoWhenBranchMatchedException();
            }
        }));
    }
}
