package androidx.compose.ui.draw;

import C7.r;
import S7.a;
import S7.k;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.shadow.ShadowContext;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJC\u0010\u0015\u001a\u00020\u0011*\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0018\u001a\u00020\u00172\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00110\u000f¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001a\u001a\u00020\u00172\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f¢\u0006\u0004\b\u001a\u0010\u0019R\"\u0010\u001c\u001a\u00020\u001b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010\"\u001a\u0004\u0018\u00010\u00178\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010(\u001a\u0004\u0018\u00010\u00108\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R*\u00100\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010.8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0011\u0010\u000e\u001a\u0002068F¢\u0006\u0006\u001a\u0004\b7\u00108R\u0011\u0010\f\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0014\u0010\n\u001a\u00020;8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0014\u0010?\u001a\u00020;8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010=¨\u0006@"}, d2 = {"Landroidx/compose/ui/draw/CacheDrawScope;", "Landroidx/compose/ui/unit/Density;", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "obtainGraphicsLayer", "()Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "Landroidx/compose/ui/graphics/shadow/ShadowContext;", "obtainShadowContext", "()Landroidx/compose/ui/graphics/shadow/ShadowContext;", "density", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "Landroidx/compose/ui/unit/IntSize;", "size", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "LC7/r;", "block", "record-TdoYBX4", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;JLS7/k;)V", "record", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/draw/DrawResult;", "onDrawBehind", "(LS7/k;)Landroidx/compose/ui/draw/DrawResult;", "onDrawWithContent", "Landroidx/compose/ui/draw/BuildDrawCacheParams;", "cacheParams", "Landroidx/compose/ui/draw/BuildDrawCacheParams;", "getCacheParams$ui_release", "()Landroidx/compose/ui/draw/BuildDrawCacheParams;", "setCacheParams$ui_release", "(Landroidx/compose/ui/draw/BuildDrawCacheParams;)V", "drawResult", "Landroidx/compose/ui/draw/DrawResult;", "getDrawResult$ui_release", "()Landroidx/compose/ui/draw/DrawResult;", "setDrawResult$ui_release", "(Landroidx/compose/ui/draw/DrawResult;)V", "contentDrawScope", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "getContentDrawScope$ui_release", "()Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "setContentDrawScope$ui_release", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;)V", "Lkotlin/Function0;", "Landroidx/compose/ui/graphics/GraphicsContext;", "graphicsContextProvider", "LS7/a;", "getGraphicsContextProvider$ui_release", "()LS7/a;", "setGraphicsContextProvider$ui_release", "(LS7/a;)V", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "()J", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "", "getDensity", "()F", "getFontScale", "fontScale", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CacheDrawScope implements Density {
    public static final int $stable = 0;
    private BuildDrawCacheParams cacheParams = EmptyBuildDrawCacheParams.INSTANCE;
    private ContentDrawScope contentDrawScope;
    private DrawResult drawResult;
    private a graphicsContextProvider;

    /* renamed from: record-TdoYBX4$default, reason: not valid java name */
    public static /* synthetic */ void m3675recordTdoYBX4$default(CacheDrawScope cacheDrawScope, GraphicsLayer graphicsLayer, Density density, LayoutDirection layoutDirection, long j5, k kVar, int i, Object obj) {
        if ((i & 1) != 0) {
            density = cacheDrawScope;
        }
        if ((i & 2) != 0) {
            layoutDirection = cacheDrawScope.getLayoutDirection();
        }
        if ((i & 4) != 0) {
            j5 = IntSizeKt.m7026toIntSizeuvyYCjk(cacheDrawScope.m3676getSizeNHjbRc());
        }
        cacheDrawScope.m3677recordTdoYBX4(graphicsLayer, density, layoutDirection, j5, kVar);
    }

    /* renamed from: getCacheParams$ui_release, reason: from getter */
    public final BuildDrawCacheParams getCacheParams() {
        return this.cacheParams;
    }

    /* renamed from: getContentDrawScope$ui_release, reason: from getter */
    public final ContentDrawScope getContentDrawScope() {
        return this.contentDrawScope;
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.cacheParams.getDensity().getDensity();
    }

    /* renamed from: getDrawResult$ui_release, reason: from getter */
    public final DrawResult getDrawResult() {
        return this.drawResult;
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float getFontScale() {
        return this.cacheParams.getDensity().getFontScale();
    }

    /* renamed from: getGraphicsContextProvider$ui_release, reason: from getter */
    public final a getGraphicsContextProvider() {
        return this.graphicsContextProvider;
    }

    public final LayoutDirection getLayoutDirection() {
        return this.cacheParams.getLayoutDirection();
    }

    /* renamed from: getSize-NH-jbRc, reason: not valid java name */
    public final long m3676getSizeNHjbRc() {
        return this.cacheParams.mo3673getSizeNHjbRc();
    }

    public final GraphicsLayer obtainGraphicsLayer() {
        a aVar = this.graphicsContextProvider;
        kotlin.jvm.internal.k.c(aVar);
        return ((GraphicsContext) aVar.invoke()).createGraphicsLayer();
    }

    public final ShadowContext obtainShadowContext() {
        a aVar = this.graphicsContextProvider;
        kotlin.jvm.internal.k.c(aVar);
        return ((GraphicsContext) aVar.invoke()).getShadowContext();
    }

    public final DrawResult onDrawBehind(final k block) {
        return onDrawWithContent(new k() { // from class: androidx.compose.ui.draw.CacheDrawScope.onDrawBehind.1
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContentDrawScope) obj);
                return r.f317a;
            }

            public final void invoke(ContentDrawScope contentDrawScope) {
                block.invoke(contentDrawScope);
                contentDrawScope.drawContent();
            }
        });
    }

    public final DrawResult onDrawWithContent(k block) {
        DrawResult drawResult = new DrawResult(block);
        this.drawResult = drawResult;
        return drawResult;
    }

    /* renamed from: record-TdoYBX4, reason: not valid java name */
    public final void m3677recordTdoYBX4(GraphicsLayer graphicsLayer, final Density density, final LayoutDirection layoutDirection, long j5, final k kVar) {
        final ContentDrawScope contentDrawScope = this.contentDrawScope;
        kotlin.jvm.internal.k.c(contentDrawScope);
        final Density density2 = contentDrawScope.getDrawContext().getDensity();
        final LayoutDirection layoutDirection2 = contentDrawScope.getDrawContext().getLayoutDirection();
        contentDrawScope.mo4708recordJVtK1S4(graphicsLayer, j5, new k() { // from class: androidx.compose.ui.draw.CacheDrawScope$record$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DrawScope) obj);
                return r.f317a;
            }

            public final void invoke(DrawScope drawScope) {
                DrawContext drawContext = drawScope.getDrawContext();
                Density density3 = density;
                LayoutDirection layoutDirection3 = layoutDirection;
                drawContext.setDensity(density3);
                drawContext.setLayoutDirection(layoutDirection3);
                try {
                    kVar.invoke(contentDrawScope);
                } finally {
                    DrawContext drawContext2 = drawScope.getDrawContext();
                    Density density4 = density2;
                    LayoutDirection layoutDirection4 = layoutDirection2;
                    drawContext2.setDensity(density4);
                    drawContext2.setLayoutDirection(layoutDirection4);
                }
            }
        });
    }

    public final void setCacheParams$ui_release(BuildDrawCacheParams buildDrawCacheParams) {
        this.cacheParams = buildDrawCacheParams;
    }

    public final void setContentDrawScope$ui_release(ContentDrawScope contentDrawScope) {
        this.contentDrawScope = contentDrawScope;
    }

    public final void setDrawResult$ui_release(DrawResult drawResult) {
        this.drawResult = drawResult;
    }

    public final void setGraphicsContextProvider$ui_release(a aVar) {
        this.graphicsContextProvider = aVar;
    }
}
