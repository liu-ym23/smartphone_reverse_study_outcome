package androidx.compose.foundation.draganddrop;

import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/compose/foundation/draganddrop/CacheDrawScopeDragShadowCallback;", "", "<init>", "()V", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "drawDragShadow", "", "drawScope", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "cachePicture", "Landroidx/compose/ui/draw/DrawResult;", "scope", "Landroidx/compose/ui/draw/CacheDrawScope;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CacheDrawScopeDragShadowCallback {
    public static final int $stable = 8;
    private GraphicsLayer graphicsLayer;

    public CacheDrawScopeDragShadowCallback() {
    }

    public static /* synthetic */ Unit a(CacheDrawScopeDragShadowCallback r100, ContentDrawScope r101) {
        return cachePicture$lambda$4$lambda$3(r100, r101);
    }

    public static /* synthetic */ Unit b(ContentDrawScope r100) {
        return cachePicture$lambda$4$lambda$2$lambda$1(r100);
    }

    private static final Unit cachePicture$lambda$4$lambda$2$lambda$1(ContentDrawScope r100) {
        r100.drawContent();
        return Unit.INSTANCE;
    }

    public final DrawResult cachePicture(CacheDrawScope r110) {
        GraphicsLayer r100 = r110.obtainGraphicsLayer();
        CacheDrawScope.m4365recordTdoYBX4$default(r110, r100, null, null, 0, new a(), 7, null);
        this.graphicsLayer = r100;
        return r110.onDrawWithContent(new b(this));
    }

    public final void drawDragShadow(DrawScope r100) {
        GraphicsLayer r101 = this.graphicsLayer;
        if (r101 == null) goto L7;
        GraphicsLayerKt.drawLayer(r100, r101);
        return;
    L7:
        throw new IllegalArgumentException("No cached drag shadow. Check if the drag source node was rendered first");
    }

    private static final Unit cachePicture$lambda$4$lambda$3(CacheDrawScopeDragShadowCallback r100, ContentDrawScope r101) {
        GraphicsLayer r102 = r100.graphicsLayer;
        Intrinsics.checkNotNull(r102);
        GraphicsLayerKt.drawLayer(r101, r102);
        return Unit.INSTANCE;
    }
}
