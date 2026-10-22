package androidx.compose.ui.graphics;

import androidx.compose.runtime.RememberObserver;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/graphics/GraphicsContextObserver;", "Landroidx/compose/runtime/RememberObserver;", "Landroidx/compose/ui/graphics/GraphicsContext;", "graphicsContext", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/graphics/GraphicsContext;)V", "LC7/r;", "onRemembered", "()V", "onForgotten", "onAbandoned", "Landroidx/compose/ui/graphics/GraphicsContext;", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "getGraphicsLayer", "()Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class GraphicsContextObserver implements RememberObserver {
    private final GraphicsContext graphicsContext;
    private final GraphicsLayer graphicsLayer;

    public GraphicsContextObserver(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
        this.graphicsLayer = graphicsContext.createGraphicsLayer();
    }

    public final GraphicsLayer getGraphicsLayer() {
        return this.graphicsLayer;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
        this.graphicsContext.releaseGraphicsLayer(this.graphicsLayer);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        this.graphicsContext.releaseGraphicsLayer(this.graphicsLayer);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
    }
}
