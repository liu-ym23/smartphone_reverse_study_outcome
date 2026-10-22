package androidx.compose.ui.graphics.layer;

import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.view.DisplayListCanvas;
import android.view.RenderNode;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidBlendMode_androidKt;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidColorFilter_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.layer.CompositingStrategy;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.WindowStateInfo;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@RequiresApi(23)
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0001\u0018\u0000  \u00012\u00020\u0001:\u0002 \u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0014\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u001a\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J;\u0010$\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00110!H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020\u00112\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0011H\u0016¢\u0006\u0004\b-\u0010.J\u000f\u00100\u001a\u00020\u0011H\u0000¢\u0006\u0004\b/\u0010.J\u000f\u00102\u001a\u000201H\u0002¢\u0006\u0004\b2\u00103J\u0017\u00108\u001a\u00020\u00112\u0006\u00105\u001a\u000204H\u0002¢\u0006\u0004\b6\u00107J\u000f\u0010:\u001a\u000209H\u0002¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u0011H\u0002¢\u0006\u0004\b<\u0010.J\u000f\u0010=\u001a\u00020\u0011H\u0002¢\u0006\u0004\b=\u0010.J\u0017\u0010@\u001a\u00020\u00112\u0006\u0010?\u001a\u00020>H\u0002¢\u0006\u0004\b@\u0010AR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010B\u001a\u0004\bC\u0010DR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010ER\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010FR\u0014\u0010?\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010GR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010BR\u0018\u0010H\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010J\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010L\u001a\u0002098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010\u0017\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010BR*\u00105\u001a\u0002042\u0006\u0010N\u001a\u0002048\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b5\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u00107R*\u0010T\u001a\u00020S2\u0006\u0010N\u001a\u00020S8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bT\u0010O\u001a\u0004\bU\u0010Q\"\u0004\bV\u00107R.\u0010X\u001a\u0004\u0018\u00010W2\b\u0010N\u001a\u0004\u0018\u00010W8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R*\u0010_\u001a\u00020^2\u0006\u0010N\u001a\u00020^8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u0016\u0010e\u001a\u0002098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010MR*\u0010g\u001a\u00020f2\u0006\u0010N\u001a\u00020f8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bg\u0010B\u001a\u0004\bh\u0010D\"\u0004\bi\u0010jR*\u0010k\u001a\u00020^2\u0006\u0010N\u001a\u00020^8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bk\u0010`\u001a\u0004\bl\u0010b\"\u0004\bm\u0010dR*\u0010n\u001a\u00020^2\u0006\u0010N\u001a\u00020^8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bn\u0010`\u001a\u0004\bo\u0010b\"\u0004\bp\u0010dR*\u0010q\u001a\u00020^2\u0006\u0010N\u001a\u00020^8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bq\u0010`\u001a\u0004\br\u0010b\"\u0004\bs\u0010dR*\u0010t\u001a\u00020^2\u0006\u0010N\u001a\u00020^8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bt\u0010`\u001a\u0004\bu\u0010b\"\u0004\bv\u0010dR*\u0010w\u001a\u00020^2\u0006\u0010N\u001a\u00020^8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bw\u0010`\u001a\u0004\bx\u0010b\"\u0004\by\u0010dR*\u0010{\u001a\u00020z2\u0006\u0010N\u001a\u00020z8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b{\u0010B\u001a\u0004\b|\u0010D\"\u0004\b}\u0010jR+\u0010~\u001a\u00020z2\u0006\u0010N\u001a\u00020z8\u0016@VX\u0096\u000e¢\u0006\u0013\n\u0004\b~\u0010B\u001a\u0004\b\u007f\u0010D\"\u0005\b\u0080\u0001\u0010jR.\u0010\u0081\u0001\u001a\u00020^2\u0006\u0010N\u001a\u00020^8\u0016@VX\u0096\u000e¢\u0006\u0015\n\u0005\b\u0081\u0001\u0010`\u001a\u0005\b\u0082\u0001\u0010b\"\u0005\b\u0083\u0001\u0010dR.\u0010\u0084\u0001\u001a\u00020^2\u0006\u0010N\u001a\u00020^8\u0016@VX\u0096\u000e¢\u0006\u0015\n\u0005\b\u0084\u0001\u0010`\u001a\u0005\b\u0085\u0001\u0010b\"\u0005\b\u0086\u0001\u0010dR.\u0010\u0087\u0001\u001a\u00020^2\u0006\u0010N\u001a\u00020^8\u0016@VX\u0096\u000e¢\u0006\u0015\n\u0005\b\u0087\u0001\u0010`\u001a\u0005\b\u0088\u0001\u0010b\"\u0005\b\u0089\u0001\u0010dR.\u0010\u008a\u0001\u001a\u00020^2\u0006\u0010N\u001a\u00020^8\u0016@VX\u0096\u000e¢\u0006\u0015\n\u0005\b\u008a\u0001\u0010`\u001a\u0005\b\u008b\u0001\u0010b\"\u0005\b\u008c\u0001\u0010dR/\u0010\u008d\u0001\u001a\u0002092\u0006\u0010N\u001a\u0002098\u0016@VX\u0096\u000e¢\u0006\u0016\n\u0005\b\u008d\u0001\u0010M\u001a\u0005\b\u008e\u0001\u0010;\"\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0018\u0010\u0091\u0001\u001a\u0002098\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0091\u0001\u0010MR\u0018\u0010\u0092\u0001\u001a\u0002098\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0092\u0001\u0010MR,\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0093\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b\u0094\u0001\u0010\u0095\u0001\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001\"\u0006\b\u0098\u0001\u0010\u0099\u0001R'\u0010\u009a\u0001\u001a\u0002098\u0016@\u0016X\u0096\u000e¢\u0006\u0016\n\u0005\b\u009a\u0001\u0010M\u001a\u0005\b\u009a\u0001\u0010;\"\u0006\b\u009b\u0001\u0010\u0090\u0001R\u001d\u0010\u009c\u0001\u001a\u00020\u00048\u0016X\u0096D¢\u0006\u000e\n\u0005\b\u009c\u0001\u0010B\u001a\u0005\b\u009d\u0001\u0010DR\u0016\u0010\u009f\u0001\u001a\u0002098VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u009e\u0001\u0010;¨\u0006¡\u0001"}, d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsLayerV23;", "Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "Landroid/view/View;", "ownerView", "", "ownerId", "Landroidx/compose/ui/graphics/CanvasHolder;", "canvasHolder", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "canvasDrawScope", AppAgent.CONSTRUCT, "(Landroid/view/View;JLandroidx/compose/ui/graphics/CanvasHolder;Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;)V", "", "x", "y", "Landroidx/compose/ui/unit/IntSize;", "size", "LC7/r;", "setPosition-H0pRuoY", "(IIJ)V", "setPosition", "Landroid/graphics/Outline;", "outline", "outlineSize", "setOutline-O0kMr_c", "(Landroid/graphics/Outline;J)V", "setOutline", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", WindowStateInfo.KEY_LAYER, "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "block", "record", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/layer/GraphicsLayer;LS7/k;)V", "Landroidx/compose/ui/graphics/Canvas;", "canvas", "draw", "(Landroidx/compose/ui/graphics/Canvas;)V", "Landroid/graphics/Matrix;", "calculateMatrix", "()Landroid/graphics/Matrix;", "discardDisplayList", "()V", "discardDisplayListInternal$ui_graphics_release", "discardDisplayListInternal", "Landroid/graphics/Paint;", "obtainLayerPaint", "()Landroid/graphics/Paint;", "Landroidx/compose/ui/graphics/layer/CompositingStrategy;", "compositingStrategy", "applyCompositingStrategy-Wpw9cng", "(I)V", "applyCompositingStrategy", "", "requiresCompositingLayer", "()Z", "updateLayerProperties", "applyClip", "Landroid/view/RenderNode;", "renderNode", "verifyShadowColorProperties", "(Landroid/view/RenderNode;)V", "J", "getOwnerId", "()J", "Landroidx/compose/ui/graphics/CanvasHolder;", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "Landroid/view/RenderNode;", "layerPaint", "Landroid/graphics/Paint;", "matrix", "Landroid/graphics/Matrix;", "outlineIsProvided", "Z", "value", "I", "getCompositingStrategy-ke2Ky5w", "()I", "setCompositingStrategy-Wpw9cng", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "getBlendMode-0nO6VwU", "setBlendMode-s9anfk8", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "", "alpha", "F", "getAlpha", "()F", "setAlpha", "(F)V", "shouldManuallySetCenterPivot", "Landroidx/compose/ui/geometry/Offset;", "pivotOffset", "getPivotOffset-F1C5BW0", "setPivotOffset-k-4lQ0M", "(J)V", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "shadowElevation", "getShadowElevation", "setShadowElevation", "Landroidx/compose/ui/graphics/Color;", "ambientShadowColor", "getAmbientShadowColor-0d7_KjU", "setAmbientShadowColor-8_81llA", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "cameraDistance", "getCameraDistance", "setCameraDistance", "clip", "getClip", "setClip", "(Z)V", "clipToBounds", "clipToOutline", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "isInvalidated", "setInvalidated", "layerId", "getLayerId", "getHasDisplayList", "hasDisplayList", "Companion", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GraphicsLayerV23 implements GraphicsLayerImpl {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AtomicBoolean needToValidateAccess = new AtomicBoolean(true);
    private static boolean testFailCreateRenderNode;
    private float alpha;
    private long ambientShadowColor;
    private int blendMode;
    private float cameraDistance;
    private final CanvasDrawScope canvasDrawScope;
    private final CanvasHolder canvasHolder;
    private boolean clip;
    private boolean clipToBounds;
    private boolean clipToOutline;
    private ColorFilter colorFilter;
    private int compositingStrategy;
    private boolean isInvalidated;
    private final long layerId;
    private Paint layerPaint;
    private Matrix matrix;
    private boolean outlineIsProvided;
    private long outlineSize;
    private final long ownerId;
    private long pivotOffset;
    private RenderEffect renderEffect;
    private final RenderNode renderNode;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private float scaleX;
    private float scaleY;
    private float shadowElevation;
    private boolean shouldManuallySetCenterPivot;
    private long size;
    private long spotShadowColor;
    private float translationX;
    private float translationY;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsLayerV23$Companion;", "", AppAgent.CONSTRUCT, "()V", "testFailCreateRenderNode", "", "getTestFailCreateRenderNode$ui_graphics_release", "()Z", "setTestFailCreateRenderNode$ui_graphics_release", "(Z)V", "needToValidateAccess", "Ljava/util/concurrent/atomic/AtomicBoolean;", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final boolean getTestFailCreateRenderNode$ui_graphics_release() {
            return GraphicsLayerV23.testFailCreateRenderNode;
        }

        public final void setTestFailCreateRenderNode$ui_graphics_release(boolean z10) {
            GraphicsLayerV23.testFailCreateRenderNode = z10;
        }

        private Companion() {
        }
    }

    public GraphicsLayerV23(View view, long j5, CanvasHolder canvasHolder, CanvasDrawScope canvasDrawScope) {
        this.ownerId = j5;
        this.canvasHolder = canvasHolder;
        this.canvasDrawScope = canvasDrawScope;
        RenderNode renderNodeCreate = RenderNode.create("Compose", view);
        this.renderNode = renderNodeCreate;
        IntSize.Companion companion = IntSize.INSTANCE;
        this.size = companion.m7020getZeroYbymL2g();
        this.outlineSize = companion.m7020getZeroYbymL2g();
        if (needToValidateAccess.getAndSet(false)) {
            renderNodeCreate.setScaleX(renderNodeCreate.getScaleX());
            renderNodeCreate.setScaleY(renderNodeCreate.getScaleY());
            renderNodeCreate.setTranslationX(renderNodeCreate.getTranslationX());
            renderNodeCreate.setTranslationY(renderNodeCreate.getTranslationY());
            renderNodeCreate.setElevation(renderNodeCreate.getElevation());
            renderNodeCreate.setRotation(renderNodeCreate.getRotation());
            renderNodeCreate.setRotationX(renderNodeCreate.getRotationX());
            renderNodeCreate.setRotationY(renderNodeCreate.getRotationY());
            renderNodeCreate.setCameraDistance(renderNodeCreate.getCameraDistance());
            renderNodeCreate.setPivotX(renderNodeCreate.getPivotX());
            renderNodeCreate.setPivotY(renderNodeCreate.getPivotY());
            renderNodeCreate.setClipToOutline(renderNodeCreate.getClipToOutline());
            renderNodeCreate.setClipToBounds(false);
            renderNodeCreate.setAlpha(renderNodeCreate.getAlpha());
            renderNodeCreate.isValid();
            renderNodeCreate.setLeftTopRightBottom(0, 0, 0, 0);
            renderNodeCreate.offsetLeftAndRight(0);
            renderNodeCreate.offsetTopAndBottom(0);
            verifyShadowColorProperties(renderNodeCreate);
            discardDisplayListInternal$ui_graphics_release();
            renderNodeCreate.setLayerType(0);
            renderNodeCreate.setHasOverlappingRendering(renderNodeCreate.hasOverlappingRendering());
        }
        if (testFailCreateRenderNode) {
            throw new NoClassDefFoundError();
        }
        renderNodeCreate.setClipToBounds(false);
        CompositingStrategy.Companion companion2 = CompositingStrategy.INSTANCE;
        m4822applyCompositingStrategyWpw9cng(companion2.m4787getAutoke2Ky5w());
        this.compositingStrategy = companion2.m4787getAutoke2Ky5w();
        this.blendMode = BlendMode.INSTANCE.m4080getSrcOver0nO6VwU();
        this.alpha = 1.0f;
        this.pivotOffset = Offset.INSTANCE.m3910getUnspecifiedF1C5BW0();
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        Color.Companion companion3 = Color.INSTANCE;
        this.ambientShadowColor = companion3.m4165getBlack0d7_KjU();
        this.spotShadowColor = companion3.m4165getBlack0d7_KjU();
        this.cameraDistance = 8.0f;
        this.isInvalidated = true;
    }

    private final void applyClip() {
        boolean z10 = false;
        boolean z11 = getClip() && !this.outlineIsProvided;
        if (getClip() && this.outlineIsProvided) {
            z10 = true;
        }
        if (z11 != this.clipToBounds) {
            this.clipToBounds = z11;
            this.renderNode.setClipToBounds(z11);
        }
        if (z10 != this.clipToOutline) {
            this.clipToOutline = z10;
            this.renderNode.setClipToOutline(z10);
        }
    }

    /* renamed from: applyCompositingStrategy-Wpw9cng, reason: not valid java name */
    private final void m4822applyCompositingStrategyWpw9cng(int compositingStrategy) {
        RenderNode renderNode = this.renderNode;
        CompositingStrategy.Companion companion = CompositingStrategy.INSTANCE;
        if (CompositingStrategy.m4783equalsimpl0(compositingStrategy, companion.m4789getOffscreenke2Ky5w())) {
            renderNode.setLayerType(2);
            renderNode.setLayerPaint(this.layerPaint);
            renderNode.setHasOverlappingRendering(true);
        } else if (CompositingStrategy.m4783equalsimpl0(compositingStrategy, companion.m4788getModulateAlphake2Ky5w())) {
            renderNode.setLayerType(0);
            renderNode.setLayerPaint(this.layerPaint);
            renderNode.setHasOverlappingRendering(false);
        } else {
            renderNode.setLayerType(0);
            renderNode.setLayerPaint(this.layerPaint);
            renderNode.setHasOverlappingRendering(true);
        }
    }

    private final Paint obtainLayerPaint() {
        Paint paint = this.layerPaint;
        if (paint != null) {
            return paint;
        }
        Paint paint2 = new Paint();
        this.layerPaint = paint2;
        return paint2;
    }

    private final boolean requiresCompositingLayer() {
        return (!CompositingStrategy.m4783equalsimpl0(getCompositingStrategy(), CompositingStrategy.INSTANCE.m4789getOffscreenke2Ky5w()) && BlendMode.m4049equalsimpl0(getBlendMode(), BlendMode.INSTANCE.m4080getSrcOver0nO6VwU()) && getColorFilter() == null) ? false : true;
    }

    private final void updateLayerProperties() {
        if (requiresCompositingLayer()) {
            m4822applyCompositingStrategyWpw9cng(CompositingStrategy.INSTANCE.m4789getOffscreenke2Ky5w());
        } else {
            m4822applyCompositingStrategyWpw9cng(getCompositingStrategy());
        }
    }

    private final void verifyShadowColorProperties(RenderNode renderNode) {
        RenderNodeVerificationHelper28 renderNodeVerificationHelper28 = RenderNodeVerificationHelper28.INSTANCE;
        renderNodeVerificationHelper28.setAmbientShadowColor(renderNode, renderNodeVerificationHelper28.getAmbientShadowColor(renderNode));
        renderNodeVerificationHelper28.setSpotShadowColor(renderNode, renderNodeVerificationHelper28.getSpotShadowColor(renderNode));
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public Matrix calculateMatrix() {
        Matrix matrix = this.matrix;
        if (matrix == null) {
            matrix = new Matrix();
            this.matrix = matrix;
        }
        this.renderNode.getMatrix(matrix);
        return matrix;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void discardDisplayList() {
        discardDisplayListInternal$ui_graphics_release();
    }

    public final void discardDisplayListInternal$ui_graphics_release() {
        RenderNodeVerificationHelper24.INSTANCE.discardDisplayList(this.renderNode);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void draw(Canvas canvas) {
        DisplayListCanvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        k.d(nativeCanvas, "null cannot be cast to non-null type android.view.DisplayListCanvas");
        nativeCanvas.drawRenderNode(this.renderNode);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getAlpha() {
        return this.alpha;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: getAmbientShadowColor-0d7_KjU, reason: from getter */
    public long getAmbientShadowColor() {
        return this.ambientShadowColor;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: getBlendMode-0nO6VwU, reason: from getter */
    public int getBlendMode() {
        return this.blendMode;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getCameraDistance() {
        return this.cameraDistance;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public boolean getClip() {
        return this.clip;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: getCompositingStrategy-ke2Ky5w, reason: from getter */
    public int getCompositingStrategy() {
        return this.compositingStrategy;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public boolean getHasDisplayList() {
        return this.renderNode.isValid();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public long getLayerId() {
        return this.layerId;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public long getOwnerId() {
        return this.ownerId;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: getPivotOffset-F1C5BW0, reason: from getter */
    public long getPivotOffset() {
        return this.pivotOffset;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public RenderEffect getRenderEffect() {
        return this.renderEffect;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getRotationX() {
        return this.rotationX;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getRotationY() {
        return this.rotationY;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getRotationZ() {
        return this.rotationZ;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getScaleX() {
        return this.scaleX;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getScaleY() {
        return this.scaleY;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getShadowElevation() {
        return this.shadowElevation;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: getSpotShadowColor-0d7_KjU, reason: from getter */
    public long getSpotShadowColor() {
        return this.spotShadowColor;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getTranslationX() {
        return this.translationX;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getTranslationY() {
        return this.translationY;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: isInvalidated, reason: from getter */
    public boolean getIsInvalidated() {
        return this.isInvalidated;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void record(Density density, LayoutDirection layoutDirection, GraphicsLayer layer, S7.k block) {
        android.graphics.Canvas canvasStart = this.renderNode.start(Math.max((int) (this.size >> 32), (int) (this.outlineSize >> 32)), Math.max((int) (this.size & 4294967295L), (int) (this.outlineSize & 4294967295L)));
        try {
            CanvasHolder canvasHolder = this.canvasHolder;
            android.graphics.Canvas internalCanvas = canvasHolder.getAndroidCanvas().getInternalCanvas();
            canvasHolder.getAndroidCanvas().setInternalCanvas(canvasStart);
            AndroidCanvas androidCanvas = canvasHolder.getAndroidCanvas();
            CanvasDrawScope canvasDrawScope = this.canvasDrawScope;
            long jM7027toSizeozmzZPI = IntSizeKt.m7027toSizeozmzZPI(this.size);
            Density density2 = canvasDrawScope.getDrawContext().getDensity();
            LayoutDirection layoutDirection2 = canvasDrawScope.getDrawContext().getLayoutDirection();
            Canvas canvas = canvasDrawScope.getDrawContext().getCanvas();
            long jMo4628getSizeNHjbRc = canvasDrawScope.getDrawContext().mo4628getSizeNHjbRc();
            GraphicsLayer graphicsLayer = canvasDrawScope.getDrawContext().getGraphicsLayer();
            DrawContext drawContext = canvasDrawScope.getDrawContext();
            drawContext.setDensity(density);
            drawContext.setLayoutDirection(layoutDirection);
            drawContext.setCanvas(androidCanvas);
            drawContext.mo4629setSizeuvyYCjk(jM7027toSizeozmzZPI);
            drawContext.setGraphicsLayer(layer);
            androidCanvas.save();
            try {
                block.invoke(canvasDrawScope);
                androidCanvas.restore();
                DrawContext drawContext2 = canvasDrawScope.getDrawContext();
                drawContext2.setDensity(density2);
                drawContext2.setLayoutDirection(layoutDirection2);
                drawContext2.setCanvas(canvas);
                drawContext2.mo4629setSizeuvyYCjk(jMo4628getSizeNHjbRc);
                drawContext2.setGraphicsLayer(graphicsLayer);
                canvasHolder.getAndroidCanvas().setInternalCanvas(internalCanvas);
                this.renderNode.end(canvasStart);
                setInvalidated(false);
            } catch (Throwable th) {
                androidCanvas.restore();
                DrawContext drawContext3 = canvasDrawScope.getDrawContext();
                drawContext3.setDensity(density2);
                drawContext3.setLayoutDirection(layoutDirection2);
                drawContext3.setCanvas(canvas);
                drawContext3.mo4629setSizeuvyYCjk(jMo4628getSizeNHjbRc);
                drawContext3.setGraphicsLayer(graphicsLayer);
                throw th;
            }
        } catch (Throwable th2) {
            this.renderNode.end(canvasStart);
            throw th2;
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setAlpha(float f) {
        this.alpha = f;
        this.renderNode.setAlpha(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: setAmbientShadowColor-8_81llA */
    public void mo4815setAmbientShadowColor8_81llA(long j5) {
        this.ambientShadowColor = j5;
        RenderNodeVerificationHelper28.INSTANCE.setAmbientShadowColor(this.renderNode, ColorKt.m4193toArgb8_81llA(j5));
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: setBlendMode-s9anfk8 */
    public void mo4816setBlendModes9anfk8(int i) {
        if (BlendMode.m4049equalsimpl0(this.blendMode, i)) {
            return;
        }
        this.blendMode = i;
        obtainLayerPaint().setXfermode(new PorterDuffXfermode(AndroidBlendMode_androidKt.m3988toPorterDuffModes9anfk8(i)));
        updateLayerProperties();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setCameraDistance(float f) {
        this.cameraDistance = f;
        this.renderNode.setCameraDistance(-f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setClip(boolean z10) {
        this.clip = z10;
        applyClip();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setColorFilter(ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
        if (colorFilter == null) {
            updateLayerProperties();
            return;
        }
        m4822applyCompositingStrategyWpw9cng(CompositingStrategy.INSTANCE.m4789getOffscreenke2Ky5w());
        RenderNode renderNode = this.renderNode;
        Paint paintObtainLayerPaint = obtainLayerPaint();
        paintObtainLayerPaint.setColorFilter(AndroidColorFilter_androidKt.asAndroidColorFilter(colorFilter));
        renderNode.setLayerPaint(paintObtainLayerPaint);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: setCompositingStrategy-Wpw9cng */
    public void mo4817setCompositingStrategyWpw9cng(int i) {
        this.compositingStrategy = i;
        updateLayerProperties();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setInvalidated(boolean z10) {
        this.isInvalidated = z10;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: setOutline-O0kMr_c */
    public void mo4818setOutlineO0kMr_c(Outline outline, long outlineSize) {
        this.outlineSize = outlineSize;
        this.renderNode.setOutline(outline);
        this.outlineIsProvided = outline != null;
        applyClip();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: setPivotOffset-k-4lQ0M */
    public void mo4819setPivotOffsetk4lQ0M(long j5) {
        this.pivotOffset = j5;
        if ((9223372034707292159L & j5) == InlineClassHelperKt.UnspecifiedPackedFloats) {
            this.shouldManuallySetCenterPivot = true;
            this.renderNode.setPivotX(((int) (this.size >> 32)) / 2.0f);
            this.renderNode.setPivotY(((int) (4294967295L & this.size)) / 2.0f);
        } else {
            this.shouldManuallySetCenterPivot = false;
            this.renderNode.setPivotX(Float.intBitsToFloat((int) (j5 >> 32)));
            this.renderNode.setPivotY(Float.intBitsToFloat((int) (j5 & 4294967295L)));
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: setPosition-H0pRuoY */
    public void mo4820setPositionH0pRuoY(int x10, int y, long size) {
        int i = (int) (size >> 32);
        int i6 = (int) (4294967295L & size);
        this.renderNode.setLeftTopRightBottom(x10, y, x10 + i, y + i6);
        if (IntSize.m7013equalsimpl0(this.size, size)) {
            return;
        }
        if (this.shouldManuallySetCenterPivot) {
            this.renderNode.setPivotX(i / 2.0f);
            this.renderNode.setPivotY(i6 / 2.0f);
        }
        this.size = size;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setRenderEffect(RenderEffect renderEffect) {
        this.renderEffect = renderEffect;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setRotationX(float f) {
        this.rotationX = f;
        this.renderNode.setRotationX(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setRotationY(float f) {
        this.rotationY = f;
        this.renderNode.setRotationY(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setRotationZ(float f) {
        this.rotationZ = f;
        this.renderNode.setRotation(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setScaleX(float f) {
        this.scaleX = f;
        this.renderNode.setScaleX(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setScaleY(float f) {
        this.scaleY = f;
        this.renderNode.setScaleY(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setShadowElevation(float f) {
        this.shadowElevation = f;
        this.renderNode.setElevation(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: setSpotShadowColor-8_81llA */
    public void mo4821setSpotShadowColor8_81llA(long j5) {
        this.spotShadowColor = j5;
        RenderNodeVerificationHelper28.INSTANCE.setSpotShadowColor(this.renderNode, ColorKt.m4193toArgb8_81llA(j5));
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setTranslationX(float f) {
        this.translationX = f;
        this.renderNode.setTranslationX(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setTranslationY(float f) {
        this.translationY = f;
        this.renderNode.setTranslationY(f);
    }

    public /* synthetic */ GraphicsLayerV23(View view, long j5, CanvasHolder canvasHolder, CanvasDrawScope canvasDrawScope, int i, e eVar) {
        this(view, j5, (i & 4) != 0 ? new CanvasHolder() : canvasHolder, (i & 8) != 0 ? new CanvasDrawScope() : canvasDrawScope);
    }
}
