package androidx.compose.ui.platform;

import C7.r;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.FrameRateCategory;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.Fields;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.MatrixKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.layout.GraphicLayerInfo;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002BK\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u000b0\t\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0017\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0019\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0018\u0010\u0016J\u000f\u0010\u001a\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001a\u0010\u0012J\u0017\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010$\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010(\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010,\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010'J!\u0010/\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\n2\b\u0010.\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u000bH\u0016¢\u0006\u0004\b1\u0010\u0012J\u000f\u00102\u001a\u00020\u000bH\u0016¢\u0006\u0004\b2\u0010\u0012J\u000f\u00103\u001a\u00020\u000bH\u0016¢\u0006\u0004\b3\u0010\u0012J\u001f\u00108\u001a\u00020\u001f2\u0006\u00104\u001a\u00020\u001f2\u0006\u00105\u001a\u00020!H\u0016¢\u0006\u0004\b6\u00107J\u001f\u0010;\u001a\u00020\u000b2\u0006\u0010:\u001a\u0002092\u0006\u00105\u001a\u00020!H\u0016¢\u0006\u0004\b;\u0010<J9\u0010=\u001a\u00020\u000b2\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u000b0\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0016¢\u0006\u0004\b=\u0010>J\u0017\u0010B\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u0014H\u0016¢\u0006\u0004\b@\u0010AJ\u0017\u0010D\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u0014H\u0016¢\u0006\u0004\bC\u0010AR\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010ER\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010FR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010GR,\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010HR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010IR\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010JR\u0016\u0010K\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010M\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010O\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010NR$\u0010Q\u001a\u00020!2\u0006\u0010P\u001a\u00020!8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\bQ\u0010L\"\u0004\bR\u0010SR\u0016\u0010U\u001a\u00020T8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010X\u001a\u00020W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010\u001c\u001a\u00020Z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010[R\u0016\u0010]\u001a\u00020\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010`\u001a\u00020_8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010JR\u0018\u0010b\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010d\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010LR\u0016\u0010e\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010LR\u0016\u0010f\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010LR\"\u0010h\u001a\u00020g8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\"\u0010n\u001a\u00020!8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bn\u0010L\u001a\u0004\bn\u0010o\"\u0004\bp\u0010SR\u0016\u0010q\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010LR \u0010t\u001a\u000e\u0012\u0004\u0012\u00020s\u0012\u0004\u0012\u00020\u000b0r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bt\u0010uR\u0014\u0010y\u001a\u00020v8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bw\u0010xR\u0014\u0010{\u001a\u00020v8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bz\u0010xR\u0014\u0010}\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b|\u0010\u0016¨\u0006~"}, d2 = {"Landroidx/compose/ui/platform/GraphicsLayerOwnerLayer;", "Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/layout/GraphicLayerInfo;", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "graphicsLayer", "Landroidx/compose/ui/graphics/GraphicsContext;", "context", "Landroidx/compose/ui/platform/AndroidComposeView;", "ownerView", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/Canvas;", "LC7/r;", "drawBlock", "Lkotlin/Function0;", "invalidateParentLayer", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;Landroidx/compose/ui/graphics/GraphicsContext;Landroidx/compose/ui/platform/AndroidComposeView;LS7/n;LS7/a;)V", "triggerRepaint", "()V", "updateOutline", "Landroidx/compose/ui/graphics/Matrix;", "getMatrix-sQKQjiQ", "()[F", "getMatrix", "getInverseMatrix-3i98HWw", "getInverseMatrix", "updateMatrix", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "scope", "updateLayerProperties", "(Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;)V", "Landroidx/compose/ui/geometry/Offset;", "position", "", "isInLayer-k-4lQ0M", "(J)Z", "isInLayer", "Landroidx/compose/ui/unit/IntOffset;", "move--gyyYBs", "(J)V", "move", "Landroidx/compose/ui/unit/IntSize;", "size", "resize-ozmzZPI", "resize", "canvas", "parentLayer", "drawLayer", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "updateDisplayList", "invalidate", "destroy", "point", "inverse", "mapOffset-8S9VItk", "(JZ)J", "mapOffset", "Landroidx/compose/ui/geometry/MutableRect;", "rect", "mapBounds", "(Landroidx/compose/ui/geometry/MutableRect;Z)V", "reuseLayer", "(LS7/n;LS7/a;)V", "matrix", "transform-58bKbWc", "([F)V", "transform", "inverseTransform-58bKbWc", "inverseTransform", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "Landroidx/compose/ui/graphics/GraphicsContext;", "Landroidx/compose/ui/platform/AndroidComposeView;", "LS7/n;", "LS7/a;", "J", "isDestroyed", "Z", "matrixCache", "[F", "inverseMatrixCache", "value", "isDirty", "setDirty", "(Z)V", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "", "mutatedFields", "I", "Landroidx/compose/ui/graphics/TransformOrigin;", "transformOrigin", "Landroidx/compose/ui/graphics/Outline;", "outline", "Landroidx/compose/ui/graphics/Outline;", "isMatrixDirty", "isInverseMatrixDirty", "isIdentity", "", "frameRate", "F", "getFrameRate", "()F", "setFrameRate", "(F)V", "isFrameRateFromParent", "()Z", "setFrameRateFromParent", "drawnWithEnabledZ", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "recordLambda", "LS7/k;", "", "getLayerId", "()J", "layerId", "getOwnerViewId", "ownerViewId", "getUnderlyingMatrix-sQKQjiQ", "underlyingMatrix", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GraphicsLayerOwnerLayer implements OwnedLayer, GraphicLayerInfo {
    public static final int $stable = 8;
    private final GraphicsContext context;
    private S7.n drawBlock;
    private boolean drawnWithEnabledZ;
    private float frameRate;
    private GraphicsLayer graphicsLayer;
    private S7.a invalidateParentLayer;
    private float[] inverseMatrixCache;
    private boolean isDestroyed;
    private boolean isDirty;
    private boolean isFrameRateFromParent;
    private boolean isInverseMatrixDirty;
    private boolean isMatrixDirty;
    private int mutatedFields;
    private Outline outline;
    private final AndroidComposeView ownerView;
    private long size;
    private final float[] matrixCache = Matrix.m4380constructorimpl$default(null, 1, null);
    private Density density = DensityKt.Density$default(1.0f, 0.0f, 2, null);
    private LayoutDirection layoutDirection = LayoutDirection.Ltr;
    private final CanvasDrawScope scope = new CanvasDrawScope();
    private long transformOrigin = TransformOrigin.INSTANCE.m4546getCenterSzJe1aQ();
    private boolean isIdentity = true;
    private final S7.k recordLambda = new S7.k() { // from class: androidx.compose.ui.platform.GraphicsLayerOwnerLayer$recordLambda$1
        {
            super(1);
        }

        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((DrawScope) obj);
            return r.f317a;
        }

        public final void invoke(DrawScope drawScope) {
            GraphicsLayerOwnerLayer graphicsLayerOwnerLayer = this.this$0;
            Canvas canvas = drawScope.getDrawContext().getCanvas();
            S7.n nVar = graphicsLayerOwnerLayer.drawBlock;
            if (nVar != null) {
                nVar.invoke(canvas, drawScope.getDrawContext().getGraphicsLayer());
            }
        }
    };

    public GraphicsLayerOwnerLayer(GraphicsLayer graphicsLayer, GraphicsContext graphicsContext, AndroidComposeView androidComposeView, S7.n nVar, S7.a aVar) {
        this.graphicsLayer = graphicsLayer;
        this.context = graphicsContext;
        this.ownerView = androidComposeView;
        this.drawBlock = nVar;
        this.invalidateParentLayer = aVar;
        long j5 = Integer.MAX_VALUE;
        this.size = IntSize.m7010constructorimpl((j5 & 4294967295L) | (j5 << 32));
    }

    /* renamed from: getInverseMatrix-3i98HWw, reason: not valid java name */
    private final float[] m6016getInverseMatrix3i98HWw() {
        float[] fArrM4380constructorimpl$default = this.inverseMatrixCache;
        if (fArrM4380constructorimpl$default == null) {
            fArrM4380constructorimpl$default = Matrix.m4380constructorimpl$default(null, 1, null);
            this.inverseMatrixCache = fArrM4380constructorimpl$default;
        }
        if (!this.isInverseMatrixDirty) {
            if (Float.isNaN(fArrM4380constructorimpl$default[0])) {
                return null;
            }
            return fArrM4380constructorimpl$default;
        }
        this.isInverseMatrixDirty = false;
        float[] fArrM6017getMatrixsQKQjiQ = m6017getMatrixsQKQjiQ();
        if (this.isIdentity) {
            return fArrM6017getMatrixsQKQjiQ;
        }
        if (InvertMatrixKt.m6018invertToJiSxe2E(fArrM6017getMatrixsQKQjiQ, fArrM4380constructorimpl$default)) {
            return fArrM4380constructorimpl$default;
        }
        fArrM4380constructorimpl$default[0] = Float.NaN;
        return null;
    }

    /* renamed from: getMatrix-sQKQjiQ, reason: not valid java name */
    private final float[] m6017getMatrixsQKQjiQ() {
        updateMatrix();
        return this.matrixCache;
    }

    private final void setDirty(boolean z10) {
        if (z10 != this.isDirty) {
            this.isDirty = z10;
            this.ownerView.notifyLayerIsDirty$ui_release(this, z10);
        }
    }

    private final void triggerRepaint() {
        WrapperRenderNodeLayerHelperMethods.INSTANCE.onDescendantInvalidated(this.ownerView);
    }

    private final void updateMatrix() {
        if (this.isMatrixDirty) {
            GraphicsLayer graphicsLayer = this.graphicsLayer;
            long jM3974getCenteruvyYCjk = (graphicsLayer.getPivotOffset() & 9223372034707292159L) == InlineClassHelperKt.UnspecifiedPackedFloats ? SizeKt.m3974getCenteruvyYCjk(IntSizeKt.m7027toSizeozmzZPI(this.size)) : graphicsLayer.getPivotOffset();
            Matrix.m4390resetToPivotedTransformimpl(this.matrixCache, Float.intBitsToFloat((int) (jM3974getCenteruvyYCjk >> 32)), Float.intBitsToFloat((int) (jM3974getCenteruvyYCjk & 4294967295L)), graphicsLayer.getTranslationX(), graphicsLayer.getTranslationY(), 1.0f, graphicsLayer.getRotationX(), graphicsLayer.getRotationY(), graphicsLayer.getRotationZ(), graphicsLayer.getScaleX(), graphicsLayer.getScaleY(), 1.0f);
            this.isMatrixDirty = false;
            this.isIdentity = MatrixKt.m4405isIdentity58bKbWc(this.matrixCache);
        }
    }

    private final void updateOutline() {
        Outline outline = this.outline;
        if (outline == null) {
            return;
        }
        GraphicsLayerKt.setOutline(this.graphicsLayer, outline);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void destroy() {
        setFrameRate(0.0f);
        setFrameRateFromParent(false);
        this.drawBlock = null;
        this.invalidateParentLayer = null;
        this.isDestroyed = true;
        setDirty(false);
        GraphicsContext graphicsContext = this.context;
        if (graphicsContext != null) {
            graphicsContext.releaseGraphicsLayer(this.graphicsLayer);
            this.ownerView.recycle$ui_release(this);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void drawLayer(Canvas canvas, GraphicsLayer parentLayer) {
        updateDisplayList();
        this.drawnWithEnabledZ = this.graphicsLayer.getShadowElevation() > 0.0f;
        DrawContext drawContext = this.scope.getDrawContext();
        drawContext.setCanvas(canvas);
        drawContext.setGraphicsLayer(parentLayer);
        GraphicsLayerKt.drawLayer(this.scope, this.graphicsLayer);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public float getFrameRate() {
        return this.frameRate;
    }

    @Override // androidx.compose.ui.layout.GraphicLayerInfo
    public long getLayerId() {
        return this.graphicsLayer.getLayerId();
    }

    @Override // androidx.compose.ui.layout.GraphicLayerInfo
    public long getOwnerViewId() {
        return this.graphicsLayer.getOwnerViewId();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: getUnderlyingMatrix-sQKQjiQ */
    public float[] mo5915getUnderlyingMatrixsQKQjiQ() {
        return m6017getMatrixsQKQjiQ();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void invalidate() {
        if (this.isDirty || this.isDestroyed) {
            return;
        }
        this.ownerView.invalidate();
        setDirty(true);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: inverseTransform-58bKbWc */
    public void mo5916inverseTransform58bKbWc(float[] matrix) {
        float[] fArrM6016getInverseMatrix3i98HWw = m6016getInverseMatrix3i98HWw();
        if (fArrM6016getInverseMatrix3i98HWw != null) {
            Matrix.m4399timesAssign58bKbWc(matrix, fArrM6016getInverseMatrix3i98HWw);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: isFrameRateFromParent, reason: from getter */
    public boolean getIsFrameRateFromParent() {
        return this.isFrameRateFromParent;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: isInLayer-k-4lQ0M */
    public boolean mo5917isInLayerk4lQ0M(long position) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (position >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (position & 4294967295L));
        if (this.graphicsLayer.getClip()) {
            return ShapeContainingUtilKt.isInOutline$default(this.graphicsLayer.getOutline(), fIntBitsToFloat, fIntBitsToFloat2, null, null, 24, null);
        }
        return true;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void mapBounds(MutableRect rect, boolean inverse) {
        float[] fArrM6016getInverseMatrix3i98HWw = inverse ? m6016getInverseMatrix3i98HWw() : m6017getMatrixsQKQjiQ();
        if (this.isIdentity) {
            return;
        }
        if (fArrM6016getInverseMatrix3i98HWw == null) {
            rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            Matrix.m4388mapimpl(fArrM6016getInverseMatrix3i98HWw, rect);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: mapOffset-8S9VItk */
    public long mo5918mapOffset8S9VItk(long point, boolean inverse) {
        float[] fArrM6017getMatrixsQKQjiQ;
        if (inverse) {
            fArrM6017getMatrixsQKQjiQ = m6016getInverseMatrix3i98HWw();
            if (fArrM6017getMatrixsQKQjiQ == null) {
                return Offset.INSTANCE.m3909getInfiniteF1C5BW0();
            }
        } else {
            fArrM6017getMatrixsQKQjiQ = m6017getMatrixsQKQjiQ();
        }
        return this.isIdentity ? point : Matrix.m4386mapMKHz9U(fArrM6017getMatrixsQKQjiQ, point);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: move--gyyYBs */
    public void mo5919movegyyYBs(long position) {
        if (this.ownerView.getIsArrEnabled()) {
            this.ownerView.voteFrameRate(FrameRateCategory.INSTANCE.m3621getHighNSsRyOo());
        }
        this.graphicsLayer.m4809setTopLeftgyyYBs(position);
        triggerRepaint();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: resize-ozmzZPI */
    public void mo5920resizeozmzZPI(long size) {
        if (IntSize.m7013equalsimpl0(size, this.size)) {
            return;
        }
        if (this.ownerView.getIsArrEnabled()) {
            this.ownerView.voteFrameRate(FrameRateCategory.INSTANCE.m3621getHighNSsRyOo());
        }
        this.size = size;
        invalidate();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void reuseLayer(S7.n drawBlock, S7.a invalidateParentLayer) {
        GraphicsContext graphicsContext = this.context;
        if (graphicsContext == null) {
            throw androidx.compose.foundation.b.x("currently reuse is only supported when we manage the layer lifecycle");
        }
        if (!this.graphicsLayer.getIsReleased()) {
            androidx.compose.ui.internal.InlineClassHelperKt.throwIllegalArgumentException("layer should have been released before reuse");
        }
        this.graphicsLayer = graphicsContext.createGraphicsLayer();
        this.isDestroyed = false;
        this.drawBlock = drawBlock;
        this.invalidateParentLayer = invalidateParentLayer;
        this.isMatrixDirty = false;
        this.isInverseMatrixDirty = false;
        this.isIdentity = true;
        Matrix.m4389resetimpl(this.matrixCache);
        float[] fArr = this.inverseMatrixCache;
        if (fArr != null) {
            Matrix.m4389resetimpl(fArr);
        }
        this.transformOrigin = TransformOrigin.INSTANCE.m4546getCenterSzJe1aQ();
        this.drawnWithEnabledZ = false;
        long j5 = Integer.MAX_VALUE;
        this.size = IntSize.m7010constructorimpl((j5 & 4294967295L) | (j5 << 32));
        this.outline = null;
        this.mutatedFields = 0;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void setFrameRate(float f) {
        this.frameRate = f;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void setFrameRateFromParent(boolean z10) {
        this.isFrameRateFromParent = z10;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: transform-58bKbWc */
    public void mo5921transform58bKbWc(float[] matrix) {
        Matrix.m4399timesAssign58bKbWc(matrix, m6017getMatrixsQKQjiQ());
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void updateDisplayList() {
        if (this.ownerView.getIsArrEnabled() && getFrameRate() != 0.0f) {
            this.ownerView.voteFrameRate(getFrameRate());
        }
        if (this.isDirty) {
            if (!TransformOrigin.m4540equalsimpl0(this.transformOrigin, TransformOrigin.INSTANCE.m4546getCenterSzJe1aQ()) && !IntSize.m7013equalsimpl0(this.graphicsLayer.getSize(), this.size)) {
                GraphicsLayer graphicsLayer = this.graphicsLayer;
                float fM4541getPivotFractionXimpl = TransformOrigin.m4541getPivotFractionXimpl(this.transformOrigin) * ((int) (this.size >> 32));
                float fM4542getPivotFractionYimpl = TransformOrigin.m4542getPivotFractionYimpl(this.transformOrigin) * ((int) (this.size & 4294967295L));
                graphicsLayer.m4805setPivotOffsetk4lQ0M(Offset.m3887constructorimpl((Float.floatToRawIntBits(fM4542getPivotFractionYimpl) & 4294967295L) | (Float.floatToRawIntBits(fM4541getPivotFractionXimpl) << 32)));
            }
            this.graphicsLayer.m4801recordmLhObY(this.density, this.layoutDirection, this.size, this.recordLambda);
            setDirty(false);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void updateLayerProperties(ReusableGraphicsLayerScope scope) {
        int iM4788getModulateAlphake2Ky5w;
        S7.a aVar;
        int mutatedFields = scope.getMutatedFields() | this.mutatedFields;
        this.layoutDirection = scope.getLayoutDirection();
        this.density = scope.getGraphicsDensity();
        int i = mutatedFields & 4096;
        if (i != 0) {
            this.transformOrigin = scope.getTransformOrigin();
        }
        if ((mutatedFields & 1) != 0) {
            this.graphicsLayer.setScaleX(scope.getScaleX());
        }
        if ((mutatedFields & 2) != 0) {
            this.graphicsLayer.setScaleY(scope.getScaleY());
        }
        if ((mutatedFields & 4) != 0) {
            this.graphicsLayer.setAlpha(scope.getAlpha());
        }
        if ((mutatedFields & 8) != 0) {
            this.graphicsLayer.setTranslationX(scope.getTranslationX());
        }
        if ((mutatedFields & 16) != 0) {
            this.graphicsLayer.setTranslationY(scope.getTranslationY());
        }
        if ((mutatedFields & 32) != 0) {
            this.graphicsLayer.setShadowElevation(scope.getShadowElevation());
            if (scope.getShadowElevation() > 0.0f && !this.drawnWithEnabledZ && (aVar = this.invalidateParentLayer) != null) {
                aVar.invoke();
            }
        }
        if ((mutatedFields & 64) != 0) {
            this.graphicsLayer.m4802setAmbientShadowColor8_81llA(scope.getAmbientShadowColor());
        }
        if ((mutatedFields & 128) != 0) {
            this.graphicsLayer.m4808setSpotShadowColor8_81llA(scope.getSpotShadowColor());
        }
        if ((mutatedFields & 1024) != 0) {
            this.graphicsLayer.setRotationZ(scope.getRotationZ());
        }
        if ((mutatedFields & 256) != 0) {
            this.graphicsLayer.setRotationX(scope.getRotationX());
        }
        if ((mutatedFields & 512) != 0) {
            this.graphicsLayer.setRotationY(scope.getRotationY());
        }
        if ((mutatedFields & 2048) != 0) {
            this.graphicsLayer.setCameraDistance(scope.getCameraDistance());
        }
        if (i != 0) {
            if (TransformOrigin.m4540equalsimpl0(this.transformOrigin, TransformOrigin.INSTANCE.m4546getCenterSzJe1aQ())) {
                this.graphicsLayer.m4805setPivotOffsetk4lQ0M(Offset.INSTANCE.m3910getUnspecifiedF1C5BW0());
            } else {
                GraphicsLayer graphicsLayer = this.graphicsLayer;
                float fM4541getPivotFractionXimpl = TransformOrigin.m4541getPivotFractionXimpl(this.transformOrigin) * ((int) (this.size >> 32));
                graphicsLayer.m4805setPivotOffsetk4lQ0M(Offset.m3887constructorimpl((Float.floatToRawIntBits(TransformOrigin.m4542getPivotFractionYimpl(this.transformOrigin) * ((int) (this.size & 4294967295L))) & 4294967295L) | (Float.floatToRawIntBits(fM4541getPivotFractionXimpl) << 32)));
            }
        }
        if ((mutatedFields & 16384) != 0) {
            this.graphicsLayer.setClip(scope.getClip());
        }
        if ((131072 & mutatedFields) != 0) {
            this.graphicsLayer.setRenderEffect(scope.getRenderEffect());
        }
        if ((262144 & mutatedFields) != 0) {
            this.graphicsLayer.setColorFilter(scope.getColorFilter());
        }
        if ((524288 & mutatedFields) != 0) {
            this.graphicsLayer.m4803setBlendModes9anfk8(scope.getBlendMode());
        }
        if ((32768 & mutatedFields) != 0) {
            GraphicsLayer graphicsLayer2 = this.graphicsLayer;
            int compositingStrategy = scope.getCompositingStrategy();
            CompositingStrategy.Companion companion = CompositingStrategy.INSTANCE;
            if (CompositingStrategy.m4224equalsimpl0(compositingStrategy, companion.m4228getAutoNrFUSI())) {
                iM4788getModulateAlphake2Ky5w = androidx.compose.ui.graphics.layer.CompositingStrategy.INSTANCE.m4787getAutoke2Ky5w();
            } else if (CompositingStrategy.m4224equalsimpl0(compositingStrategy, companion.m4230getOffscreenNrFUSI())) {
                iM4788getModulateAlphake2Ky5w = androidx.compose.ui.graphics.layer.CompositingStrategy.INSTANCE.m4789getOffscreenke2Ky5w();
            } else {
                if (!CompositingStrategy.m4224equalsimpl0(compositingStrategy, companion.m4229getModulateAlphaNrFUSI())) {
                    throw new IllegalStateException("Not supported composition strategy");
                }
                iM4788getModulateAlphake2Ky5w = androidx.compose.ui.graphics.layer.CompositingStrategy.INSTANCE.m4788getModulateAlphake2Ky5w();
            }
            graphicsLayer2.m4804setCompositingStrategyWpw9cng(iM4788getModulateAlphake2Ky5w);
        }
        boolean z10 = true;
        if ((mutatedFields & Fields.MatrixAffectingFields) != 0) {
            this.isMatrixDirty = true;
            this.isInverseMatrixDirty = true;
        }
        if (kotlin.jvm.internal.k.b(this.outline, scope.getOutline())) {
            z10 = false;
        } else {
            this.outline = scope.getOutline();
            updateOutline();
        }
        this.mutatedFields = scope.getMutatedFields();
        if (mutatedFields != 0 || z10) {
            triggerRepaint();
            if (this.ownerView.getIsArrEnabled()) {
                this.ownerView.voteFrameRate(getFrameRate());
            }
        }
    }
}
