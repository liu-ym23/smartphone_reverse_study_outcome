package androidx.compose.ui.graphics.layer;

import H7.c;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@RequiresApi(28)
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0096@¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Landroidx/compose/ui/graphics/layer/LayerSnapshotV28;", "Landroidx/compose/ui/graphics/layer/LayerSnapshotImpl;", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "graphicsLayer", "Landroid/graphics/Bitmap;", "toBitmap", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;LH7/c;)Ljava/lang/Object;", "GraphicsLayerPicture", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LayerSnapshotV28 implements LayerSnapshotImpl {
    public static final LayerSnapshotV28 INSTANCE = new LayerSnapshotV28();

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/graphics/layer/LayerSnapshotV28$GraphicsLayerPicture;", "Landroid/graphics/Picture;", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "graphicsLayer", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "", "width", "height", "Landroid/graphics/Canvas;", "beginRecording", "(II)Landroid/graphics/Canvas;", "LC7/r;", "endRecording", "()V", "getWidth", "()I", "getHeight", "", "requiresHardwareAcceleration", "()Z", "canvas", "draw", "(Landroid/graphics/Canvas;)V", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "getGraphicsLayer", "()Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class GraphicsLayerPicture extends Picture {
        private final GraphicsLayer graphicsLayer;

        public GraphicsLayerPicture(GraphicsLayer graphicsLayer) {
            this.graphicsLayer = graphicsLayer;
        }

        @Override // android.graphics.Picture
        public Canvas beginRecording(int width, int height) {
            return new Canvas();
        }

        @Override // android.graphics.Picture
        public void draw(Canvas canvas) {
            this.graphicsLayer.draw$ui_graphics_release(AndroidCanvas_androidKt.Canvas(canvas), null);
        }

        @Override // android.graphics.Picture
        public void endRecording() {
        }

        public final GraphicsLayer getGraphicsLayer() {
            return this.graphicsLayer;
        }

        @Override // android.graphics.Picture
        public int getHeight() {
            return (int) (this.graphicsLayer.getSize() & 4294967295L);
        }

        @Override // android.graphics.Picture
        public int getWidth() {
            return (int) (this.graphicsLayer.getSize() >> 32);
        }

        @Override // android.graphics.Picture
        public boolean requiresHardwareAcceleration() {
            return true;
        }
    }

    private LayerSnapshotV28() {
    }

    @Override // androidx.compose.ui.graphics.layer.LayerSnapshotImpl
    public Object toBitmap(GraphicsLayer graphicsLayer, c<? super Bitmap> cVar) {
        return Bitmap.createBitmap(new GraphicsLayerPicture(graphicsLayer));
    }
}
