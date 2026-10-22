package androidx.compose.ui.platform;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import androidx.annotation.RequiresApi;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@RequiresApi(29)
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b=\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\n\u0010\bJ\u0019\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001b\u0010\u001aJ5\u0010#\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u000e0 H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b)\u0010(J\u0017\u0010,\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00101\u001a\u000200H\u0016¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u000eH\u0016¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\u000eH\u0002¢\u0006\u0004\b5\u00104J\u000f\u00106\u001a\u00020\u0006H\u0002¢\u0006\u0004\b6\u0010\bJ\u000f\u00107\u001a\u00020\u0006H\u0002¢\u0006\u0004\b7\u0010\bJ\u000f\u00109\u001a\u000208H\u0002¢\u0006\u0004\b9\u0010:J\u001b\u0010@\u001a\u00020\u000e*\u00020;2\u0006\u0010=\u001a\u00020<H\u0002¢\u0006\u0004\b>\u0010?R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010A\u001a\u0004\bB\u0010CR\u0014\u0010D\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010G\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010I\u001a\u00020<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010K\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR*\u0010O\u001a\u00020M2\u0006\u0010N\u001a\u00020M8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bO\u0010J\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010\u001aR.\u0010T\u001a\u0004\u0018\u00010S2\b\u0010N\u001a\u0004\u0018\u00010S8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u0014\u0010]\u001a\u00020Z8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\\R\u0014\u0010\u0012\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b^\u0010QR\u0014\u0010\u0013\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b_\u0010QR\u0014\u0010\u0014\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b`\u0010QR\u0014\u0010\u0015\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\ba\u0010QR\u0014\u0010c\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bb\u0010QR\u0014\u0010e\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bd\u0010QR$\u0010k\u001a\u00020f2\u0006\u0010N\u001a\u00020f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR$\u0010n\u001a\u00020f2\u0006\u0010N\u001a\u00020f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bl\u0010h\"\u0004\bm\u0010jR$\u0010q\u001a\u00020f2\u0006\u0010N\u001a\u00020f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bo\u0010h\"\u0004\bp\u0010jR$\u0010t\u001a\u00020f2\u0006\u0010N\u001a\u00020f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\br\u0010h\"\u0004\bs\u0010jR$\u0010w\u001a\u00020f2\u0006\u0010N\u001a\u00020f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bu\u0010h\"\u0004\bv\u0010jR$\u0010z\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\u00118V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bx\u0010Q\"\u0004\by\u0010\u001aR$\u0010}\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\u00118V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b{\u0010Q\"\u0004\b|\u0010\u001aR%\u0010\u0080\u0001\u001a\u00020f2\u0006\u0010N\u001a\u00020f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b~\u0010h\"\u0004\b\u007f\u0010jR'\u0010\u0083\u0001\u001a\u00020f2\u0006\u0010N\u001a\u00020f8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0081\u0001\u0010h\"\u0005\b\u0082\u0001\u0010jR'\u0010\u0086\u0001\u001a\u00020f2\u0006\u0010N\u001a\u00020f8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0084\u0001\u0010h\"\u0005\b\u0085\u0001\u0010jR'\u0010\u0089\u0001\u001a\u00020f2\u0006\u0010N\u001a\u00020f8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0087\u0001\u0010h\"\u0005\b\u0088\u0001\u0010jR'\u0010\u008c\u0001\u001a\u00020f2\u0006\u0010N\u001a\u00020f8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u008a\u0001\u0010h\"\u0005\b\u008b\u0001\u0010jR'\u0010\u008f\u0001\u001a\u00020f2\u0006\u0010N\u001a\u00020f8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u008d\u0001\u0010h\"\u0005\b\u008e\u0001\u0010jR(\u0010\u0093\u0001\u001a\u00020\u00062\u0006\u0010N\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\u000f\u001a\u0005\b\u0090\u0001\u0010\b\"\u0006\b\u0091\u0001\u0010\u0092\u0001R(\u0010\u0096\u0001\u001a\u00020\u00062\u0006\u0010N\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\u000f\u001a\u0005\b\u0094\u0001\u0010\b\"\u0006\b\u0095\u0001\u0010\u0092\u0001R'\u0010\u0099\u0001\u001a\u00020f2\u0006\u0010N\u001a\u00020f8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0097\u0001\u0010h\"\u0005\b\u0098\u0001\u0010jR-\u0010\u009e\u0001\u001a\u0004\u0018\u00010F2\b\u0010N\u001a\u0004\u0018\u00010F8V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001\"\u0006\b\u009c\u0001\u0010\u009d\u0001R&\u0010=\u001a\u00020<2\u0006\u0010N\u001a\u00020<8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u009f\u0001\u0010Q\"\u0005\b \u0001\u0010\u001aR\u0016\u0010¢\u0001\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b¡\u0001\u0010\b¨\u0006£\u0001"}, d2 = {"Landroidx/compose/ui/platform/RenderNodeApi29;", "Landroidx/compose/ui/platform/DeviceRenderNode;", "Landroidx/compose/ui/platform/AndroidComposeView;", "ownerView", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/platform/AndroidComposeView;)V", "", "isUsingCompositingLayer$ui_release", "()Z", "isUsingCompositingLayer", "hasOverlappingRendering$ui_release", "hasOverlappingRendering", "Landroid/graphics/Outline;", "outline", "LC7/r;", "setOutline", "(Landroid/graphics/Outline;)V", "", "left", "top", "right", "bottom", "setPosition", "(IIII)Z", TypedValues.CycleType.S_WAVE_OFFSET, "offsetLeftAndRight", "(I)V", "offsetTopAndBottom", "Landroidx/compose/ui/graphics/CanvasHolder;", "canvasHolder", "Landroidx/compose/ui/graphics/Path;", "clipPath", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "drawBlock", "record", "(Landroidx/compose/ui/graphics/CanvasHolder;Landroidx/compose/ui/graphics/Path;LS7/k;)V", "Landroid/graphics/Matrix;", "matrix", "getMatrix", "(Landroid/graphics/Matrix;)V", "getInverseMatrix", "Landroid/graphics/Canvas;", "canvas", "drawInto", "(Landroid/graphics/Canvas;)V", "setHasOverlappingRendering", "(Z)Z", "Landroidx/compose/ui/platform/DeviceRenderNodeData;", "dumpRenderNodeData", "()Landroidx/compose/ui/platform/DeviceRenderNodeData;", "discardDisplayList", "()V", "updateLayerProperties", "requiresCompositingLayer", "requiresLayerPaint", "Landroidx/compose/ui/graphics/Paint;", "obtainLayerPaint", "()Landroidx/compose/ui/graphics/Paint;", "Landroid/graphics/RenderNode;", "Landroidx/compose/ui/graphics/CompositingStrategy;", "compositingStrategy", "applyCompositingStrategy-Qu9p0E8", "(Landroid/graphics/RenderNode;I)V", "applyCompositingStrategy", "Landroidx/compose/ui/platform/AndroidComposeView;", "getOwnerView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "renderNode", "Landroid/graphics/RenderNode;", "Landroidx/compose/ui/graphics/RenderEffect;", "internalRenderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "internalCompositingStrategy", "I", "layerPaint", "Landroidx/compose/ui/graphics/Paint;", "Landroidx/compose/ui/graphics/BlendMode;", "value", "blendMode", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "", "getUniqueId", "()J", "uniqueId", "getLeft", "getTop", "getRight", "getBottom", "getWidth", "width", "getHeight", "height", "", "getScaleX", "()F", "setScaleX", "(F)V", "scaleX", "getScaleY", "setScaleY", "scaleY", "getTranslationX", "setTranslationX", "translationX", "getTranslationY", "setTranslationY", "translationY", "getElevation", "setElevation", "elevation", "getAmbientShadowColor", "setAmbientShadowColor", "ambientShadowColor", "getSpotShadowColor", "setSpotShadowColor", "spotShadowColor", "getRotationZ", "setRotationZ", "rotationZ", "getRotationX", "setRotationX", "rotationX", "getRotationY", "setRotationY", "rotationY", "getCameraDistance", "setCameraDistance", "cameraDistance", "getPivotX", "setPivotX", "pivotX", "getPivotY", "setPivotY", "pivotY", "getClipToOutline", "setClipToOutline", "(Z)V", "clipToOutline", "getClipToBounds", "setClipToBounds", "clipToBounds", "getAlpha", "setAlpha", "alpha", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "renderEffect", "getCompositingStrategy--NrFUSI", "setCompositingStrategy-aDBOjCE", "getHasDisplayList", "hasDisplayList", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RenderNodeApi29 implements DeviceRenderNode {
    public static final int $stable = 8;
    private ColorFilter colorFilter;
    private RenderEffect internalRenderEffect;
    private Paint layerPaint;
    private final AndroidComposeView ownerView;
    private final RenderNode renderNode = new RenderNode("Compose");
    private int internalCompositingStrategy = CompositingStrategy.INSTANCE.m4228getAutoNrFUSI();
    private int blendMode = BlendMode.INSTANCE.m4080getSrcOver0nO6VwU();

    public RenderNodeApi29(AndroidComposeView androidComposeView) {
        this.ownerView = androidComposeView;
    }

    /* renamed from: applyCompositingStrategy-Qu9p0E8, reason: not valid java name */
    private final void m6052applyCompositingStrategyQu9p0E8(RenderNode renderNode, int i) {
        CompositingStrategy.Companion companion = CompositingStrategy.INSTANCE;
        if (CompositingStrategy.m4224equalsimpl0(i, companion.m4230getOffscreenNrFUSI())) {
            Paint paint = this.layerPaint;
            renderNode.setUseCompositingLayer(true, paint != null ? paint.getInternalPaint() : null);
            renderNode.setHasOverlappingRendering(true);
        } else if (CompositingStrategy.m4224equalsimpl0(i, companion.m4229getModulateAlphaNrFUSI())) {
            renderNode.setUseCompositingLayer(false, null);
            renderNode.setHasOverlappingRendering(false);
        } else {
            renderNode.setUseCompositingLayer(false, null);
            renderNode.setHasOverlappingRendering(true);
        }
    }

    private final Paint obtainLayerPaint() {
        Paint paint = this.layerPaint;
        if (paint != null) {
            return paint;
        }
        Paint Paint = AndroidPaint_androidKt.Paint();
        this.layerPaint = Paint;
        return Paint;
    }

    private final boolean requiresCompositingLayer() {
        return CompositingStrategy.m4224equalsimpl0(getInternalCompositingStrategy(), CompositingStrategy.INSTANCE.m4230getOffscreenNrFUSI()) || requiresLayerPaint();
    }

    private final boolean requiresLayerPaint() {
        return (BlendMode.m4049equalsimpl0(getBlendMode(), BlendMode.INSTANCE.m4080getSrcOver0nO6VwU()) && getColorFilter() == null) ? false : true;
    }

    private final void updateLayerProperties() {
        if (requiresCompositingLayer()) {
            m6052applyCompositingStrategyQu9p0E8(this.renderNode, CompositingStrategy.INSTANCE.m4230getOffscreenNrFUSI());
        } else {
            m6052applyCompositingStrategyQu9p0E8(this.renderNode, this.internalCompositingStrategy);
        }
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void discardDisplayList() {
        this.renderNode.discardDisplayList();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void drawInto(Canvas canvas) {
        canvas.drawRenderNode(this.renderNode);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public DeviceRenderNodeData dumpRenderNodeData() {
        return new DeviceRenderNodeData(this.renderNode.getUniqueId(), this.renderNode.getLeft(), this.renderNode.getTop(), this.renderNode.getRight(), this.renderNode.getBottom(), this.renderNode.getWidth(), this.renderNode.getHeight(), this.renderNode.getScaleX(), this.renderNode.getScaleY(), this.renderNode.getTranslationX(), this.renderNode.getTranslationY(), this.renderNode.getElevation(), this.renderNode.getAmbientShadowColor(), this.renderNode.getSpotShadowColor(), this.renderNode.getRotationZ(), this.renderNode.getRotationX(), this.renderNode.getRotationY(), this.renderNode.getCameraDistance(), this.renderNode.getPivotX(), this.renderNode.getPivotY(), this.renderNode.getClipToOutline(), this.renderNode.getClipToBounds(), this.renderNode.getAlpha(), this.internalRenderEffect, getBlendMode(), getColorFilter(), this.internalCompositingStrategy, null);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getAlpha() {
        return this.renderNode.getAlpha();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getAmbientShadowColor() {
        return this.renderNode.getAmbientShadowColor();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    /* renamed from: getBlendMode-0nO6VwU, reason: from getter */
    public int getBlendMode() {
        return this.blendMode;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getBottom() {
        return this.renderNode.getBottom();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getCameraDistance() {
        return this.renderNode.getCameraDistance();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean getClipToBounds() {
        return this.renderNode.getClipToBounds();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean getClipToOutline() {
        return this.renderNode.getClipToOutline();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    /* renamed from: getCompositingStrategy--NrFUSI, reason: from getter */
    public int getInternalCompositingStrategy() {
        return this.internalCompositingStrategy;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getElevation() {
        return this.renderNode.getElevation();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean getHasDisplayList() {
        return this.renderNode.hasDisplayList();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getHeight() {
        return this.renderNode.getHeight();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void getInverseMatrix(Matrix matrix) {
        this.renderNode.getInverseMatrix(matrix);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getLeft() {
        return this.renderNode.getLeft();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void getMatrix(Matrix matrix) {
        this.renderNode.getMatrix(matrix);
    }

    public final AndroidComposeView getOwnerView() {
        return this.ownerView;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getPivotX() {
        return this.renderNode.getPivotX();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getPivotY() {
        return this.renderNode.getPivotY();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    /* renamed from: getRenderEffect, reason: from getter */
    public RenderEffect getInternalRenderEffect() {
        return this.internalRenderEffect;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getRight() {
        return this.renderNode.getRight();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getRotationX() {
        return this.renderNode.getRotationX();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getRotationY() {
        return this.renderNode.getRotationY();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getRotationZ() {
        return this.renderNode.getRotationZ();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getScaleX() {
        return this.renderNode.getScaleX();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getScaleY() {
        return this.renderNode.getScaleY();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getSpotShadowColor() {
        return this.renderNode.getSpotShadowColor();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getTop() {
        return this.renderNode.getTop();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getTranslationX() {
        return this.renderNode.getTranslationX();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getTranslationY() {
        return this.renderNode.getTranslationY();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public long getUniqueId() {
        return this.renderNode.getUniqueId();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getWidth() {
        return this.renderNode.getWidth();
    }

    public final boolean hasOverlappingRendering$ui_release() {
        return this.renderNode.hasOverlappingRendering();
    }

    public final boolean isUsingCompositingLayer$ui_release() {
        return this.renderNode.getUseCompositingLayer();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void offsetLeftAndRight(int offset) {
        this.renderNode.offsetLeftAndRight(offset);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void offsetTopAndBottom(int offset) {
        this.renderNode.offsetTopAndBottom(offset);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void record(CanvasHolder canvasHolder, Path clipPath, S7.k drawBlock) {
        RecordingCanvas recordingCanvasBeginRecording = this.renderNode.beginRecording();
        Canvas internalCanvas = canvasHolder.getAndroidCanvas().getInternalCanvas();
        canvasHolder.getAndroidCanvas().setInternalCanvas(recordingCanvasBeginRecording);
        AndroidCanvas androidCanvas = canvasHolder.getAndroidCanvas();
        if (clipPath != null) {
            androidCanvas.save();
            androidx.compose.ui.graphics.Canvas.m4110clipPathmtrdDE$default(androidCanvas, clipPath, 0, 2, null);
        }
        drawBlock.invoke(androidCanvas);
        if (clipPath != null) {
            androidCanvas.restore();
        }
        canvasHolder.getAndroidCanvas().setInternalCanvas(internalCanvas);
        this.renderNode.endRecording();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setAlpha(float f) {
        this.renderNode.setAlpha(f);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setAmbientShadowColor(int i) {
        this.renderNode.setAmbientShadowColor(i);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    /* renamed from: setBlendMode-s9anfk8 */
    public void mo5998setBlendModes9anfk8(int i) {
        this.blendMode = i;
        obtainLayerPaint().mo4015setBlendModes9anfk8(i);
        updateLayerProperties();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setCameraDistance(float f) {
        this.renderNode.setCameraDistance(f);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setClipToBounds(boolean z10) {
        this.renderNode.setClipToBounds(z10);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setClipToOutline(boolean z10) {
        this.renderNode.setClipToOutline(z10);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setColorFilter(ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
        obtainLayerPaint().setColorFilter(colorFilter);
        updateLayerProperties();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    /* renamed from: setCompositingStrategy-aDBOjCE */
    public void mo5999setCompositingStrategyaDBOjCE(int i) {
        this.internalCompositingStrategy = i;
        updateLayerProperties();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setElevation(float f) {
        this.renderNode.setElevation(f);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean setHasOverlappingRendering(boolean hasOverlappingRendering) {
        return this.renderNode.setHasOverlappingRendering(hasOverlappingRendering);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setOutline(Outline outline) {
        this.renderNode.setOutline(outline);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setPivotX(float f) {
        this.renderNode.setPivotX(f);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setPivotY(float f) {
        this.renderNode.setPivotY(f);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean setPosition(int left, int top, int right, int bottom) {
        return this.renderNode.setPosition(left, top, right, bottom);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setRenderEffect(RenderEffect renderEffect) {
        this.internalRenderEffect = renderEffect;
        RenderNodeApi29VerificationHelper.INSTANCE.setRenderEffect(this.renderNode, renderEffect);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setRotationX(float f) {
        this.renderNode.setRotationX(f);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setRotationY(float f) {
        this.renderNode.setRotationY(f);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setRotationZ(float f) {
        this.renderNode.setRotationZ(f);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setScaleX(float f) {
        this.renderNode.setScaleX(f);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setScaleY(float f) {
        this.renderNode.setScaleY(f);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setSpotShadowColor(int i) {
        this.renderNode.setSpotShadowColor(i);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setTranslationX(float f) {
        this.renderNode.setTranslationX(f);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setTranslationY(float f) {
        this.renderNode.setTranslationY(f);
    }
}
