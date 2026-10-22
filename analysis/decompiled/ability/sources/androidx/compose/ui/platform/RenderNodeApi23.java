package androidx.compose.ui.platform;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.view.DisplayListCanvas;
import android.view.RenderNode;
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
@RequiresApi(23)
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b5\b\u0001\u0018\u0000 ª\u00012\u00020\u0001:\u0002ª\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\u00020\nH\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J/\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001c\u0010\u001bJ5\u0010$\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00100!H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020\u00102\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\u00102\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b*\u0010)J\u0017\u0010-\u001a\u00020\u00102\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b/\u00100J\u000f\u00102\u001a\u000201H\u0016¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0010H\u0016¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u0010H\u0002¢\u0006\u0004\b6\u00105J\u000f\u00107\u001a\u00020\nH\u0002¢\u0006\u0004\b7\u0010\fJ\u000f\u00108\u001a\u00020\nH\u0002¢\u0006\u0004\b8\u0010\fJ\u000f\u0010:\u001a\u000209H\u0002¢\u0006\u0004\b:\u0010;J\u001b\u0010A\u001a\u00020\u0010*\u00020<2\u0006\u0010>\u001a\u00020=H\u0002¢\u0006\u0004\b?\u0010@J\u000f\u0010B\u001a\u00020\u0010H\u0002¢\u0006\u0004\bB\u00105J\u0017\u0010D\u001a\u00020\u00102\u0006\u0010C\u001a\u00020<H\u0002¢\u0006\u0004\bD\u0010ER\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010F\u001a\u0004\bG\u0010HR\u0014\u0010C\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010IR\u0016\u0010J\u001a\u00020=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010L\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\"\u0010\u0013\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010K\u001a\u0004\bN\u0010\b\"\u0004\bO\u0010\u001bR\"\u0010\u0014\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010K\u001a\u0004\bP\u0010\b\"\u0004\bQ\u0010\u001bR\"\u0010\u0015\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010K\u001a\u0004\bR\u0010\b\"\u0004\bS\u0010\u001bR\"\u0010\u0016\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010K\u001a\u0004\bT\u0010\b\"\u0004\bU\u0010\u001bR$\u0010W\u001a\u0004\u0018\u00010V8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R*\u0010^\u001a\u00020\n2\u0006\u0010]\u001a\u00020\n8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010\f\"\u0004\ba\u0010bR*\u0010d\u001a\u00020c2\u0006\u0010]\u001a\u00020c8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bd\u0010K\u001a\u0004\be\u0010\b\"\u0004\bf\u0010\u001bR.\u0010h\u001a\u0004\u0018\u00010g2\b\u0010]\u001a\u0004\u0018\u00010g8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u0014\u0010q\u001a\u00020n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bo\u0010pR\u0014\u0010s\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\br\u0010\bR\u0014\u0010u\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bt\u0010\bR$\u0010{\u001a\u00020v2\u0006\u0010]\u001a\u00020v8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR$\u0010~\u001a\u00020v2\u0006\u0010]\u001a\u00020v8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b|\u0010x\"\u0004\b}\u0010zR&\u0010\u0081\u0001\u001a\u00020v2\u0006\u0010]\u001a\u00020v8V@VX\u0096\u000e¢\u0006\r\u001a\u0004\b\u007f\u0010x\"\u0005\b\u0080\u0001\u0010zR'\u0010\u0084\u0001\u001a\u00020v2\u0006\u0010]\u001a\u00020v8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0082\u0001\u0010x\"\u0005\b\u0083\u0001\u0010zR'\u0010\u0087\u0001\u001a\u00020v2\u0006\u0010]\u001a\u00020v8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0085\u0001\u0010x\"\u0005\b\u0086\u0001\u0010zR'\u0010\u008a\u0001\u001a\u00020\u00062\u0006\u0010]\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0088\u0001\u0010\b\"\u0005\b\u0089\u0001\u0010\u001bR'\u0010\u008d\u0001\u001a\u00020\u00062\u0006\u0010]\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u008b\u0001\u0010\b\"\u0005\b\u008c\u0001\u0010\u001bR'\u0010\u0090\u0001\u001a\u00020v2\u0006\u0010]\u001a\u00020v8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u008e\u0001\u0010x\"\u0005\b\u008f\u0001\u0010zR'\u0010\u0093\u0001\u001a\u00020v2\u0006\u0010]\u001a\u00020v8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0091\u0001\u0010x\"\u0005\b\u0092\u0001\u0010zR'\u0010\u0096\u0001\u001a\u00020v2\u0006\u0010]\u001a\u00020v8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0094\u0001\u0010x\"\u0005\b\u0095\u0001\u0010zR'\u0010\u0099\u0001\u001a\u00020v2\u0006\u0010]\u001a\u00020v8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0097\u0001\u0010x\"\u0005\b\u0098\u0001\u0010zR'\u0010\u009c\u0001\u001a\u00020v2\u0006\u0010]\u001a\u00020v8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u009a\u0001\u0010x\"\u0005\b\u009b\u0001\u0010zR'\u0010\u009f\u0001\u001a\u00020v2\u0006\u0010]\u001a\u00020v8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u009d\u0001\u0010x\"\u0005\b\u009e\u0001\u0010zR'\u0010¢\u0001\u001a\u00020\n2\u0006\u0010]\u001a\u00020\n8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b \u0001\u0010\f\"\u0005\b¡\u0001\u0010bR'\u0010¥\u0001\u001a\u00020v2\u0006\u0010]\u001a\u00020v8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b£\u0001\u0010x\"\u0005\b¤\u0001\u0010zR&\u0010>\u001a\u00020=2\u0006\u0010]\u001a\u00020=8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b¦\u0001\u0010\b\"\u0005\b§\u0001\u0010\u001bR\u0016\u0010©\u0001\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b¨\u0001\u0010\f¨\u0006«\u0001"}, d2 = {"Landroidx/compose/ui/platform/RenderNodeApi23;", "Landroidx/compose/ui/platform/DeviceRenderNode;", "Landroidx/compose/ui/platform/AndroidComposeView;", "ownerView", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/platform/AndroidComposeView;)V", "", "getLayerType$ui_release", "()I", "getLayerType", "", "hasOverlappingRendering$ui_release", "()Z", "hasOverlappingRendering", "Landroid/graphics/Outline;", "outline", "LC7/r;", "setOutline", "(Landroid/graphics/Outline;)V", "left", "top", "right", "bottom", "setPosition", "(IIII)Z", TypedValues.CycleType.S_WAVE_OFFSET, "offsetLeftAndRight", "(I)V", "offsetTopAndBottom", "Landroidx/compose/ui/graphics/CanvasHolder;", "canvasHolder", "Landroidx/compose/ui/graphics/Path;", "clipPath", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "drawBlock", "record", "(Landroidx/compose/ui/graphics/CanvasHolder;Landroidx/compose/ui/graphics/Path;LS7/k;)V", "Landroid/graphics/Matrix;", "matrix", "getMatrix", "(Landroid/graphics/Matrix;)V", "getInverseMatrix", "Landroid/graphics/Canvas;", "canvas", "drawInto", "(Landroid/graphics/Canvas;)V", "setHasOverlappingRendering", "(Z)Z", "Landroidx/compose/ui/platform/DeviceRenderNodeData;", "dumpRenderNodeData", "()Landroidx/compose/ui/platform/DeviceRenderNodeData;", "discardDisplayList", "()V", "updateLayerProperties", "requiresCompositingLayer", "requiresLayerPaint", "Landroidx/compose/ui/graphics/Paint;", "obtainLayerPaint", "()Landroidx/compose/ui/graphics/Paint;", "Landroid/view/RenderNode;", "Landroidx/compose/ui/graphics/CompositingStrategy;", "compositingStrategy", "applyCompositingStrategy-Qu9p0E8", "(Landroid/view/RenderNode;I)V", "applyCompositingStrategy", "discardDisplayListInternal", "renderNode", "verifyShadowColorProperties", "(Landroid/view/RenderNode;)V", "Landroidx/compose/ui/platform/AndroidComposeView;", "getOwnerView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "Landroid/view/RenderNode;", "internalCompositingStrategy", "I", "layerPaint", "Landroidx/compose/ui/graphics/Paint;", "getLeft", "setLeft", "getTop", "setTop", "getRight", "setRight", "getBottom", "setBottom", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "value", "clipToBounds", "Z", "getClipToBounds", "setClipToBounds", "(Z)V", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "getBlendMode-0nO6VwU", "setBlendMode-s9anfk8", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "", "getUniqueId", "()J", "uniqueId", "getWidth", "width", "getHeight", "height", "", "getScaleX", "()F", "setScaleX", "(F)V", "scaleX", "getScaleY", "setScaleY", "scaleY", "getTranslationX", "setTranslationX", "translationX", "getTranslationY", "setTranslationY", "translationY", "getElevation", "setElevation", "elevation", "getAmbientShadowColor", "setAmbientShadowColor", "ambientShadowColor", "getSpotShadowColor", "setSpotShadowColor", "spotShadowColor", "getRotationZ", "setRotationZ", "rotationZ", "getRotationX", "setRotationX", "rotationX", "getRotationY", "setRotationY", "rotationY", "getCameraDistance", "setCameraDistance", "cameraDistance", "getPivotX", "setPivotX", "pivotX", "getPivotY", "setPivotY", "pivotY", "getClipToOutline", "setClipToOutline", "clipToOutline", "getAlpha", "setAlpha", "alpha", "getCompositingStrategy--NrFUSI", "setCompositingStrategy-aDBOjCE", "getHasDisplayList", "hasDisplayList", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RenderNodeApi23 implements DeviceRenderNode {
    private static boolean testFailCreateRenderNode;
    private int blendMode;
    private int bottom;
    private boolean clipToBounds;
    private ColorFilter colorFilter;
    private int internalCompositingStrategy;
    private Paint layerPaint;
    private int left;
    private final AndroidComposeView ownerView;
    private RenderEffect renderEffect;
    private final RenderNode renderNode;
    private int right;
    private int top;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static boolean needToValidateAccess = true;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/platform/RenderNodeApi23$Companion;", "", AppAgent.CONSTRUCT, "()V", "testFailCreateRenderNode", "", "getTestFailCreateRenderNode$ui_release", "()Z", "setTestFailCreateRenderNode$ui_release", "(Z)V", "needToValidateAccess", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final boolean getTestFailCreateRenderNode$ui_release() {
            return RenderNodeApi23.testFailCreateRenderNode;
        }

        public final void setTestFailCreateRenderNode$ui_release(boolean z10) {
            RenderNodeApi23.testFailCreateRenderNode = z10;
        }

        private Companion() {
        }
    }

    public RenderNodeApi23(AndroidComposeView androidComposeView) {
        this.ownerView = androidComposeView;
        RenderNode renderNodeCreate = RenderNode.create("Compose", androidComposeView);
        this.renderNode = renderNodeCreate;
        this.internalCompositingStrategy = CompositingStrategy.INSTANCE.m4228getAutoNrFUSI();
        if (needToValidateAccess) {
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
            discardDisplayListInternal();
            renderNodeCreate.setLayerType(0);
            renderNodeCreate.setHasOverlappingRendering(renderNodeCreate.hasOverlappingRendering());
            needToValidateAccess = false;
        }
        if (testFailCreateRenderNode) {
            throw new NoClassDefFoundError();
        }
        this.blendMode = BlendMode.INSTANCE.m4080getSrcOver0nO6VwU();
    }

    /* renamed from: applyCompositingStrategy-Qu9p0E8, reason: not valid java name */
    private final void m6051applyCompositingStrategyQu9p0E8(RenderNode renderNode, int i) {
        CompositingStrategy.Companion companion = CompositingStrategy.INSTANCE;
        if (CompositingStrategy.m4224equalsimpl0(i, companion.m4230getOffscreenNrFUSI())) {
            renderNode.setLayerType(2);
            Paint paint = this.layerPaint;
            renderNode.setLayerPaint(paint != null ? paint.getInternalPaint() : null);
            renderNode.setHasOverlappingRendering(true);
            return;
        }
        if (CompositingStrategy.m4224equalsimpl0(i, companion.m4229getModulateAlphaNrFUSI())) {
            renderNode.setLayerType(0);
            renderNode.setHasOverlappingRendering(false);
        } else {
            renderNode.setLayerType(0);
            renderNode.setHasOverlappingRendering(true);
        }
    }

    private final void discardDisplayListInternal() {
        RenderNodeVerificationHelper24.INSTANCE.discardDisplayList(this.renderNode);
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
            m6051applyCompositingStrategyQu9p0E8(this.renderNode, CompositingStrategy.INSTANCE.m4230getOffscreenNrFUSI());
        } else {
            m6051applyCompositingStrategyQu9p0E8(this.renderNode, this.internalCompositingStrategy);
        }
    }

    private final void verifyShadowColorProperties(RenderNode renderNode) {
        RenderNodeVerificationHelper28 renderNodeVerificationHelper28 = RenderNodeVerificationHelper28.INSTANCE;
        renderNodeVerificationHelper28.setAmbientShadowColor(renderNode, renderNodeVerificationHelper28.getAmbientShadowColor(renderNode));
        renderNodeVerificationHelper28.setSpotShadowColor(renderNode, renderNodeVerificationHelper28.getSpotShadowColor(renderNode));
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void discardDisplayList() {
        discardDisplayListInternal();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void drawInto(Canvas canvas) {
        kotlin.jvm.internal.k.d(canvas, "null cannot be cast to non-null type android.view.DisplayListCanvas");
        ((DisplayListCanvas) canvas).drawRenderNode(this.renderNode);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public DeviceRenderNodeData dumpRenderNodeData() {
        return new DeviceRenderNodeData(0L, 0, 0, 0, 0, 0, 0, this.renderNode.getScaleX(), this.renderNode.getScaleY(), this.renderNode.getTranslationX(), this.renderNode.getTranslationY(), this.renderNode.getElevation(), getAmbientShadowColor(), getSpotShadowColor(), this.renderNode.getRotation(), this.renderNode.getRotationX(), this.renderNode.getRotationY(), this.renderNode.getCameraDistance(), this.renderNode.getPivotX(), this.renderNode.getPivotY(), this.renderNode.getClipToOutline(), getClipToBounds(), this.renderNode.getAlpha(), getRenderEffect(), getBlendMode(), getColorFilter(), this.internalCompositingStrategy, null);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getAlpha() {
        return this.renderNode.getAlpha();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getAmbientShadowColor() {
        return RenderNodeVerificationHelper28.INSTANCE.getAmbientShadowColor(this.renderNode);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    /* renamed from: getBlendMode-0nO6VwU, reason: from getter */
    public int getBlendMode() {
        return this.blendMode;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getBottom() {
        return this.bottom;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getCameraDistance() {
        return -this.renderNode.getCameraDistance();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean getClipToBounds() {
        return this.clipToBounds;
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
        return this.renderNode.isValid();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getHeight() {
        return getBottom() - getTop();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void getInverseMatrix(Matrix matrix) {
        this.renderNode.getInverseMatrix(matrix);
    }

    public final int getLayerType$ui_release() {
        return CompositingStrategy.m4224equalsimpl0(this.internalCompositingStrategy, CompositingStrategy.INSTANCE.m4230getOffscreenNrFUSI()) ? 2 : 0;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getLeft() {
        return this.left;
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
    public RenderEffect getRenderEffect() {
        return this.renderEffect;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getRight() {
        return this.right;
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
        return this.renderNode.getRotation();
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
        return RenderNodeVerificationHelper28.INSTANCE.getSpotShadowColor(this.renderNode);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getTop() {
        return this.top;
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
        return 0L;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getWidth() {
        return getRight() - getLeft();
    }

    public final boolean hasOverlappingRendering$ui_release() {
        return this.renderNode.hasOverlappingRendering();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void offsetLeftAndRight(int offset) {
        setLeft(getLeft() + offset);
        setRight(getRight() + offset);
        this.renderNode.offsetLeftAndRight(offset);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void offsetTopAndBottom(int offset) {
        setTop(getTop() + offset);
        setBottom(getBottom() + offset);
        this.renderNode.offsetTopAndBottom(offset);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void record(CanvasHolder canvasHolder, Path clipPath, S7.k drawBlock) {
        DisplayListCanvas displayListCanvasStart = this.renderNode.start(getWidth(), getHeight());
        Canvas internalCanvas = canvasHolder.getAndroidCanvas().getInternalCanvas();
        canvasHolder.getAndroidCanvas().setInternalCanvas((Canvas) displayListCanvasStart);
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
        this.renderNode.end(displayListCanvasStart);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setAlpha(float f) {
        this.renderNode.setAlpha(f);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setAmbientShadowColor(int i) {
        RenderNodeVerificationHelper28.INSTANCE.setAmbientShadowColor(this.renderNode, i);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    /* renamed from: setBlendMode-s9anfk8 */
    public void mo5998setBlendModes9anfk8(int i) {
        this.blendMode = i;
        obtainLayerPaint().mo4015setBlendModes9anfk8(i);
        updateLayerProperties();
    }

    public void setBottom(int i) {
        this.bottom = i;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setCameraDistance(float f) {
        this.renderNode.setCameraDistance(-f);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setClipToBounds(boolean z10) {
        this.clipToBounds = z10;
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

    public void setLeft(int i) {
        this.left = i;
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
        setLeft(left);
        setTop(top);
        setRight(right);
        setBottom(bottom);
        return this.renderNode.setLeftTopRightBottom(left, top, right, bottom);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setRenderEffect(RenderEffect renderEffect) {
        this.renderEffect = renderEffect;
    }

    public void setRight(int i) {
        this.right = i;
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
        this.renderNode.setRotation(f);
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
        RenderNodeVerificationHelper28.INSTANCE.setSpotShadowColor(this.renderNode, i);
    }

    public void setTop(int i) {
        this.top = i;
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
