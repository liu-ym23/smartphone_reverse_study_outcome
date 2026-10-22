package androidx.compose.ui.graphics.layer;

import S7.k;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.view.View;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidBlendMode_androidKt;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidColorFilter_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.layer.CompositingStrategy;
import androidx.compose.ui.graphics.layer.view.DrawChildContainer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.WindowStateInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u0000 «\u00012\u00020\u0001:\u0002«\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0014\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u001a\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J;\u0010$\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00110!H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020\u00112\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0011H\u0016¢\u0006\u0004\b-\u0010.J\u0017\u00103\u001a\u00020\u00112\u0006\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b1\u00102J\u000f\u00104\u001a\u00020\u0011H\u0002¢\u0006\u0004\b4\u0010.J\u000f\u00106\u001a\u000205H\u0002¢\u0006\u0004\b6\u00107J\u000f\u00109\u001a\u000208H\u0002¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u000208H\u0002¢\u0006\u0004\b;\u0010:J\u000f\u0010<\u001a\u00020\u0011H\u0002¢\u0006\u0004\b<\u0010.J\u000f\u0010=\u001a\u00020\u0011H\u0002¢\u0006\u0004\b=\u0010.R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010>R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010?\u001a\u0004\b@\u0010AR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010B\u001a\u0004\bC\u0010DR\u0014\u0010F\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u001c\u0010J\u001a\n I*\u0004\u0018\u00010H0H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010M\u001a\u00020L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010O\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010R\u001a\u0004\u0018\u00010Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010T\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010V\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010BR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010WR\u0016\u0010\u000e\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010WR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010?R\u0016\u0010X\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\"\u0010Z\u001a\u0002088\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bZ\u0010Y\u001a\u0004\bZ\u0010:\"\u0004\b[\u0010\\R\u0016\u0010]\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010YR\u0016\u0010^\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010YR\u001a\u0010_\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b_\u0010?\u001a\u0004\b`\u0010AR*\u0010c\u001a\u00020a2\u0006\u0010b\u001a\u00020a8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bc\u0010W\u001a\u0004\bd\u0010e\"\u0004\bf\u00102R.\u0010h\u001a\u0004\u0018\u00010g2\b\u0010b\u001a\u0004\u0018\u00010g8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR*\u00100\u001a\u00020/2\u0006\u0010b\u001a\u00020/8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b0\u0010W\u001a\u0004\bn\u0010e\"\u0004\bo\u00102R*\u0010q\u001a\u00020p2\u0006\u0010b\u001a\u00020p8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\u0016\u0010w\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010YR*\u0010y\u001a\u00020x2\u0006\u0010b\u001a\u00020x8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\by\u0010?\u001a\u0004\bz\u0010A\"\u0004\b{\u0010|R*\u0010}\u001a\u00020p2\u0006\u0010b\u001a\u00020p8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b}\u0010r\u001a\u0004\b~\u0010t\"\u0004\b\u007f\u0010vR.\u0010\u0080\u0001\u001a\u00020p2\u0006\u0010b\u001a\u00020p8\u0016@VX\u0096\u000e¢\u0006\u0015\n\u0005\b\u0080\u0001\u0010r\u001a\u0005\b\u0081\u0001\u0010t\"\u0005\b\u0082\u0001\u0010vR.\u0010\u0083\u0001\u001a\u00020p2\u0006\u0010b\u001a\u00020p8\u0016@VX\u0096\u000e¢\u0006\u0015\n\u0005\b\u0083\u0001\u0010r\u001a\u0005\b\u0084\u0001\u0010t\"\u0005\b\u0085\u0001\u0010vR.\u0010\u0086\u0001\u001a\u00020p2\u0006\u0010b\u001a\u00020p8\u0016@VX\u0096\u000e¢\u0006\u0015\n\u0005\b\u0086\u0001\u0010r\u001a\u0005\b\u0087\u0001\u0010t\"\u0005\b\u0088\u0001\u0010vR.\u0010\u0089\u0001\u001a\u00020p2\u0006\u0010b\u001a\u00020p8\u0016@VX\u0096\u000e¢\u0006\u0015\n\u0005\b\u0089\u0001\u0010r\u001a\u0005\b\u008a\u0001\u0010t\"\u0005\b\u008b\u0001\u0010vR0\u0010\u008d\u0001\u001a\u00030\u008c\u00012\u0007\u0010b\u001a\u00030\u008c\u00018\u0016@VX\u0096\u000e¢\u0006\u0015\n\u0005\b\u008d\u0001\u0010?\u001a\u0005\b\u008e\u0001\u0010A\"\u0005\b\u008f\u0001\u0010|R0\u0010\u0090\u0001\u001a\u00030\u008c\u00012\u0007\u0010b\u001a\u00030\u008c\u00018\u0016@VX\u0096\u000e¢\u0006\u0015\n\u0005\b\u0090\u0001\u0010?\u001a\u0005\b\u0091\u0001\u0010A\"\u0005\b\u0092\u0001\u0010|R.\u0010\u0093\u0001\u001a\u00020p2\u0006\u0010b\u001a\u00020p8\u0016@VX\u0096\u000e¢\u0006\u0015\n\u0005\b\u0093\u0001\u0010r\u001a\u0005\b\u0094\u0001\u0010t\"\u0005\b\u0095\u0001\u0010vR.\u0010\u0096\u0001\u001a\u00020p2\u0006\u0010b\u001a\u00020p8\u0016@VX\u0096\u000e¢\u0006\u0015\n\u0005\b\u0096\u0001\u0010r\u001a\u0005\b\u0097\u0001\u0010t\"\u0005\b\u0098\u0001\u0010vR.\u0010\u0099\u0001\u001a\u00020p2\u0006\u0010b\u001a\u00020p8\u0016@VX\u0096\u000e¢\u0006\u0015\n\u0005\b\u0099\u0001\u0010r\u001a\u0005\b\u009a\u0001\u0010t\"\u0005\b\u009b\u0001\u0010vR7\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009c\u00012\t\u0010b\u001a\u0005\u0018\u00010\u009c\u00018\u0016@VX\u0096\u000e¢\u0006\u0018\n\u0006\b\u009d\u0001\u0010\u009e\u0001\u001a\u0006\b\u009f\u0001\u0010 \u0001\"\u0006\b¡\u0001\u0010¢\u0001R\u001d\u0010£\u0001\u001a\u0002088\u0016X\u0096\u0004¢\u0006\u000e\n\u0005\b£\u0001\u0010Y\u001a\u0005\b¤\u0001\u0010:R'\u0010§\u0001\u001a\u00020p2\u0006\u0010b\u001a\u00020p8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b¥\u0001\u0010t\"\u0005\b¦\u0001\u0010vR'\u0010ª\u0001\u001a\u0002082\u0006\u0010b\u001a\u0002088V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b¨\u0001\u0010:\"\u0005\b©\u0001\u0010\\¨\u0006¬\u0001"}, d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsViewLayer;", "Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "Landroidx/compose/ui/graphics/layer/view/DrawChildContainer;", "layerContainer", "", "ownerId", "Landroidx/compose/ui/graphics/CanvasHolder;", "canvasHolder", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "canvasDrawScope", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/graphics/layer/view/DrawChildContainer;JLandroidx/compose/ui/graphics/CanvasHolder;Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;)V", "", "x", "y", "Landroidx/compose/ui/unit/IntSize;", "size", "LC7/r;", "setPosition-H0pRuoY", "(IIJ)V", "setPosition", "Landroid/graphics/Outline;", "outline", "outlineSize", "setOutline-O0kMr_c", "(Landroid/graphics/Outline;J)V", "setOutline", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", WindowStateInfo.KEY_LAYER, "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "block", "record", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/layer/GraphicsLayer;LS7/k;)V", "Landroidx/compose/ui/graphics/Canvas;", "canvas", "draw", "(Landroidx/compose/ui/graphics/Canvas;)V", "Landroid/graphics/Matrix;", "calculateMatrix", "()Landroid/graphics/Matrix;", "discardDisplayList", "()V", "Landroidx/compose/ui/graphics/layer/CompositingStrategy;", "compositingStrategy", "applyCompositingLayer-Wpw9cng", "(I)V", "applyCompositingLayer", "updateLayerProperties", "Landroid/graphics/Paint;", "obtainLayerPaint", "()Landroid/graphics/Paint;", "", "requiresCompositingLayer", "()Z", "requiresLayerPaint", "recordDrawingOperations", "updateClipBounds", "Landroidx/compose/ui/graphics/layer/view/DrawChildContainer;", "J", "getOwnerId", "()J", "Landroidx/compose/ui/graphics/CanvasHolder;", "getCanvasHolder", "()Landroidx/compose/ui/graphics/CanvasHolder;", "Landroidx/compose/ui/graphics/layer/ViewLayer;", "viewLayer", "Landroidx/compose/ui/graphics/layer/ViewLayer;", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "resources", "Landroid/content/res/Resources;", "Landroid/graphics/Rect;", "clipRect", "Landroid/graphics/Rect;", "layerPaint", "Landroid/graphics/Paint;", "Landroid/graphics/Picture;", "picture", "Landroid/graphics/Picture;", "pictureDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "pictureCanvasHolder", "I", "clipBoundsInvalidated", "Z", "isInvalidated", "setInvalidated", "(Z)V", "outlineIsProvided", "clipToBounds", "layerId", "getLayerId", "Landroidx/compose/ui/graphics/BlendMode;", "value", "blendMode", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "getCompositingStrategy-ke2Ky5w", "setCompositingStrategy-Wpw9cng", "", "alpha", "F", "getAlpha", "()F", "setAlpha", "(F)V", "shouldManuallySetCenterPivot", "Landroidx/compose/ui/geometry/Offset;", "pivotOffset", "getPivotOffset-F1C5BW0", "setPivotOffset-k-4lQ0M", "(J)V", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "shadowElevation", "getShadowElevation", "setShadowElevation", "Landroidx/compose/ui/graphics/Color;", "ambientShadowColor", "getAmbientShadowColor-0d7_KjU", "setAmbientShadowColor-8_81llA", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "supportsSoftwareRendering", "getSupportsSoftwareRendering", "getCameraDistance", "setCameraDistance", "cameraDistance", "getClip", "setClip", "clip", "Companion", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GraphicsViewLayer implements GraphicsLayerImpl {
    private float alpha;
    private long ambientShadowColor;
    private int blendMode;
    private final CanvasHolder canvasHolder;
    private boolean clipBoundsInvalidated;
    private final Rect clipRect;
    private boolean clipToBounds;
    private ColorFilter colorFilter;
    private int compositingStrategy;
    private boolean isInvalidated;
    private final DrawChildContainer layerContainer;
    private final long layerId;
    private Paint layerPaint;
    private boolean outlineIsProvided;
    private final long ownerId;
    private final Picture picture;
    private final CanvasHolder pictureCanvasHolder;
    private final CanvasDrawScope pictureDrawScope;
    private long pivotOffset;
    private RenderEffect renderEffect;
    private final Resources resources;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private float scaleX;
    private float scaleY;
    private float shadowElevation;
    private boolean shouldManuallySetCenterPivot;
    private long size;
    private long spotShadowColor;
    private final boolean supportsSoftwareRendering;
    private float translationX;
    private float translationY;
    private final ViewLayer viewLayer;
    private int x;
    private int y;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final boolean mayRenderInSoftware = !SurfaceUtils.INSTANCE.isLockHardwareCanvasAvailable();
    private static final Canvas PlaceholderCanvas = new Canvas() { // from class: androidx.compose.ui.graphics.layer.GraphicsViewLayer$Companion$PlaceholderCanvas$1
        @Override // android.graphics.Canvas
        public boolean isHardwareAccelerated() {
            return true;
        }
    };

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsViewLayer$Companion;", "", AppAgent.CONSTRUCT, "()V", "mayRenderInSoftware", "", "getMayRenderInSoftware", "()Z", "PlaceholderCanvas", "Landroid/graphics/Canvas;", "getPlaceholderCanvas", "()Landroid/graphics/Canvas;", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final boolean getMayRenderInSoftware() {
            return GraphicsViewLayer.mayRenderInSoftware;
        }

        public final Canvas getPlaceholderCanvas() {
            return GraphicsViewLayer.PlaceholderCanvas;
        }

        private Companion() {
        }
    }

    public GraphicsViewLayer(DrawChildContainer drawChildContainer, long j5, CanvasHolder canvasHolder, CanvasDrawScope canvasDrawScope) {
        this.layerContainer = drawChildContainer;
        this.ownerId = j5;
        this.canvasHolder = canvasHolder;
        ViewLayer viewLayer = new ViewLayer(drawChildContainer, canvasHolder, canvasDrawScope);
        this.viewLayer = viewLayer;
        this.resources = drawChildContainer.getResources();
        this.clipRect = new Rect();
        boolean z10 = mayRenderInSoftware;
        this.picture = z10 ? new Picture() : null;
        this.pictureDrawScope = z10 ? new CanvasDrawScope() : null;
        this.pictureCanvasHolder = z10 ? new CanvasHolder() : null;
        drawChildContainer.addView(viewLayer);
        viewLayer.setClipBounds(null);
        this.size = IntSize.INSTANCE.m7020getZeroYbymL2g();
        this.isInvalidated = true;
        this.layerId = View.generateViewId();
        this.blendMode = BlendMode.INSTANCE.m4080getSrcOver0nO6VwU();
        this.compositingStrategy = CompositingStrategy.INSTANCE.m4787getAutoke2Ky5w();
        this.alpha = 1.0f;
        this.pivotOffset = Offset.INSTANCE.m3911getZeroF1C5BW0();
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        Color.Companion companion = Color.INSTANCE;
        this.ambientShadowColor = companion.m4165getBlack0d7_KjU();
        this.spotShadowColor = companion.m4165getBlack0d7_KjU();
        this.supportsSoftwareRendering = z10;
    }

    /* renamed from: applyCompositingLayer-Wpw9cng, reason: not valid java name */
    private final void m4824applyCompositingLayerWpw9cng(int compositingStrategy) {
        ViewLayer viewLayer = this.viewLayer;
        CompositingStrategy.Companion companion = CompositingStrategy.INSTANCE;
        boolean z10 = true;
        if (CompositingStrategy.m4783equalsimpl0(compositingStrategy, companion.m4789getOffscreenke2Ky5w())) {
            this.viewLayer.setLayerType(2, this.layerPaint);
        } else if (CompositingStrategy.m4783equalsimpl0(compositingStrategy, companion.m4788getModulateAlphake2Ky5w())) {
            this.viewLayer.setLayerType(0, this.layerPaint);
            z10 = false;
        } else {
            this.viewLayer.setLayerType(0, this.layerPaint);
        }
        viewLayer.setCanUseCompositingLayer$ui_graphics_release(z10);
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

    private final void recordDrawingOperations() {
        try {
            CanvasHolder canvasHolder = this.canvasHolder;
            Canvas canvas = PlaceholderCanvas;
            Canvas internalCanvas = canvasHolder.getAndroidCanvas().getInternalCanvas();
            canvasHolder.getAndroidCanvas().setInternalCanvas(canvas);
            AndroidCanvas androidCanvas = canvasHolder.getAndroidCanvas();
            DrawChildContainer drawChildContainer = this.layerContainer;
            ViewLayer viewLayer = this.viewLayer;
            drawChildContainer.drawChild$ui_graphics_release(androidCanvas, viewLayer, viewLayer.getDrawingTime());
            canvasHolder.getAndroidCanvas().setInternalCanvas(internalCanvas);
        } catch (ClassCastException unused) {
        }
    }

    private final boolean requiresCompositingLayer() {
        return CompositingStrategy.m4783equalsimpl0(getCompositingStrategy(), CompositingStrategy.INSTANCE.m4789getOffscreenke2Ky5w()) || requiresLayerPaint();
    }

    private final boolean requiresLayerPaint() {
        return (BlendMode.m4049equalsimpl0(getBlendMode(), BlendMode.INSTANCE.m4080getSrcOver0nO6VwU()) && getColorFilter() == null) ? false : true;
    }

    private final void updateClipBounds() {
        Rect rect;
        if (this.clipBoundsInvalidated) {
            ViewLayer viewLayer = this.viewLayer;
            if (!getClip() || this.outlineIsProvided) {
                rect = null;
            } else {
                rect = this.clipRect;
                rect.left = 0;
                rect.top = 0;
                rect.right = this.viewLayer.getWidth();
                rect.bottom = this.viewLayer.getHeight();
            }
            viewLayer.setClipBounds(rect);
        }
    }

    private final void updateLayerProperties() {
        if (requiresCompositingLayer()) {
            m4824applyCompositingLayerWpw9cng(CompositingStrategy.INSTANCE.m4789getOffscreenke2Ky5w());
        } else {
            m4824applyCompositingLayerWpw9cng(getCompositingStrategy());
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public Matrix calculateMatrix() {
        return this.viewLayer.getMatrix();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void discardDisplayList() {
        this.layerContainer.removeViewInLayout(this.viewLayer);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void draw(androidx.compose.ui.graphics.Canvas canvas) {
        updateClipBounds();
        Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        if (nativeCanvas.isHardwareAccelerated()) {
            DrawChildContainer drawChildContainer = this.layerContainer;
            ViewLayer viewLayer = this.viewLayer;
            drawChildContainer.drawChild$ui_graphics_release(canvas, viewLayer, viewLayer.getDrawingTime());
        } else {
            Picture picture = this.picture;
            if (picture != null) {
                nativeCanvas.drawPicture(picture);
            }
        }
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
        return this.viewLayer.getCameraDistance() / this.resources.getDisplayMetrics().densityDpi;
    }

    public final CanvasHolder getCanvasHolder() {
        return this.canvasHolder;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public boolean getClip() {
        return this.clipToBounds || this.viewLayer.getClipToOutline();
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
    public boolean getSupportsSoftwareRendering() {
        return this.supportsSoftwareRendering;
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
    public void record(Density density, LayoutDirection layoutDirection, GraphicsLayer layer, k block) throws Throwable {
        Picture picture;
        CanvasHolder canvasHolder;
        Canvas canvas;
        if (this.viewLayer.getParent() == null) {
            this.layerContainer.addView(this.viewLayer);
        }
        this.viewLayer.setDrawParams(density, layoutDirection, layer, block);
        if (!this.viewLayer.isAttachedToWindow()) {
            return;
        }
        this.viewLayer.setVisibility(4);
        this.viewLayer.setVisibility(0);
        recordDrawingOperations();
        Picture picture2 = this.picture;
        if (picture2 == null) {
            return;
        }
        long j5 = this.size;
        Canvas canvasBeginRecording = picture2.beginRecording((int) (j5 >> 32), (int) (j5 & 4294967295L));
        try {
            CanvasHolder canvasHolder2 = this.pictureCanvasHolder;
            if (canvasHolder2 != null) {
                Canvas internalCanvas = canvasHolder2.getAndroidCanvas().getInternalCanvas();
                canvasHolder2.getAndroidCanvas().setInternalCanvas(canvasBeginRecording);
                AndroidCanvas androidCanvas = canvasHolder2.getAndroidCanvas();
                CanvasDrawScope canvasDrawScope = this.pictureDrawScope;
                if (canvasDrawScope != null) {
                    long jM7027toSizeozmzZPI = IntSizeKt.m7027toSizeozmzZPI(this.size);
                    Density density2 = canvasDrawScope.getDrawContext().getDensity();
                    LayoutDirection layoutDirection2 = canvasDrawScope.getDrawContext().getLayoutDirection();
                    androidx.compose.ui.graphics.Canvas canvas2 = canvasDrawScope.getDrawContext().getCanvas();
                    canvasHolder = canvasHolder2;
                    canvas = internalCanvas;
                    long jMo4628getSizeNHjbRc = canvasDrawScope.getDrawContext().mo4628getSizeNHjbRc();
                    picture = picture2;
                    try {
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
                            drawContext2.setCanvas(canvas2);
                            drawContext2.mo4629setSizeuvyYCjk(jMo4628getSizeNHjbRc);
                            drawContext2.setGraphicsLayer(graphicsLayer);
                        } catch (Throwable th) {
                            androidCanvas.restore();
                            DrawContext drawContext3 = canvasDrawScope.getDrawContext();
                            drawContext3.setDensity(density2);
                            drawContext3.setLayoutDirection(layoutDirection2);
                            drawContext3.setCanvas(canvas2);
                            drawContext3.mo4629setSizeuvyYCjk(jMo4628getSizeNHjbRc);
                            drawContext3.setGraphicsLayer(graphicsLayer);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        picture.endRecording();
                        throw th;
                    }
                } else {
                    picture = picture2;
                    canvasHolder = canvasHolder2;
                    canvas = internalCanvas;
                }
                canvasHolder.getAndroidCanvas().setInternalCanvas(canvas);
            } else {
                picture = picture2;
            }
            picture.endRecording();
        } catch (Throwable th3) {
            th = th3;
            picture = picture2;
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setAlpha(float f) {
        this.alpha = f;
        this.viewLayer.setAlpha(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: setAmbientShadowColor-8_81llA */
    public void mo4815setAmbientShadowColor8_81llA(long j5) {
        this.ambientShadowColor = j5;
        ViewLayerVerificationHelper28.INSTANCE.setOutlineAmbientShadowColor(this.viewLayer, ColorKt.m4193toArgb8_81llA(j5));
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: setBlendMode-s9anfk8 */
    public void mo4816setBlendModes9anfk8(int i) {
        this.blendMode = i;
        obtainLayerPaint().setXfermode(new PorterDuffXfermode(AndroidBlendMode_androidKt.m3988toPorterDuffModes9anfk8(i)));
        updateLayerProperties();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setCameraDistance(float f) {
        this.viewLayer.setCameraDistance(f * this.resources.getDisplayMetrics().densityDpi);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setClip(boolean z10) {
        boolean z11 = false;
        this.clipToBounds = z10 && !this.outlineIsProvided;
        this.clipBoundsInvalidated = true;
        ViewLayer viewLayer = this.viewLayer;
        if (z10 && this.outlineIsProvided) {
            z11 = true;
        }
        viewLayer.setClipToOutline(z11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setColorFilter(ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
        obtainLayerPaint().setColorFilter(colorFilter != null ? AndroidColorFilter_androidKt.asAndroidColorFilter(colorFilter) : null);
        updateLayerProperties();
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
        boolean layerOutline = this.viewLayer.setLayerOutline(outline);
        if (getClip() && outline != null) {
            this.viewLayer.setClipToOutline(true);
            if (this.clipToBounds) {
                this.clipToBounds = false;
                this.clipBoundsInvalidated = true;
            }
        }
        this.outlineIsProvided = outline != null;
        if (layerOutline) {
            return;
        }
        this.viewLayer.invalidate();
        recordDrawingOperations();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: setPivotOffset-k-4lQ0M */
    public void mo4819setPivotOffsetk4lQ0M(long j5) {
        this.pivotOffset = j5;
        if ((9223372034707292159L & j5) == InlineClassHelperKt.UnspecifiedPackedFloats) {
            ViewLayerVerificationHelper28.INSTANCE.resetPivot(this.viewLayer);
            return;
        }
        this.shouldManuallySetCenterPivot = false;
        this.viewLayer.setPivotX(Float.intBitsToFloat((int) (j5 >> 32)));
        this.viewLayer.setPivotY(Float.intBitsToFloat((int) (j5 & 4294967295L)));
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: setPosition-H0pRuoY */
    public void mo4820setPositionH0pRuoY(int x10, int y, long size) {
        if (IntSize.m7013equalsimpl0(this.size, size)) {
            int i = this.x;
            if (i != x10) {
                this.viewLayer.offsetLeftAndRight(x10 - i);
            }
            int i6 = this.y;
            if (i6 != y) {
                this.viewLayer.offsetTopAndBottom(y - i6);
            }
        } else {
            if (getClip()) {
                this.clipBoundsInvalidated = true;
            }
            int i10 = (int) (size >> 32);
            int i11 = (int) (4294967295L & size);
            this.viewLayer.layout(x10, y, x10 + i10, y + i11);
            this.size = size;
            if (this.shouldManuallySetCenterPivot) {
                this.viewLayer.setPivotX(i10 / 2.0f);
                this.viewLayer.setPivotY(i11 / 2.0f);
            }
        }
        this.x = x10;
        this.y = y;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setRenderEffect(RenderEffect renderEffect) {
        this.renderEffect = renderEffect;
        ViewLayerVerificationHelper31.INSTANCE.setRenderEffect(this.viewLayer, renderEffect);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setRotationX(float f) {
        this.rotationX = f;
        this.viewLayer.setRotationX(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setRotationY(float f) {
        this.rotationY = f;
        this.viewLayer.setRotationY(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setRotationZ(float f) {
        this.rotationZ = f;
        this.viewLayer.setRotation(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setScaleX(float f) {
        this.scaleX = f;
        this.viewLayer.setScaleX(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setScaleY(float f) {
        this.scaleY = f;
        this.viewLayer.setScaleY(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setShadowElevation(float f) {
        this.shadowElevation = f;
        this.viewLayer.setElevation(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: setSpotShadowColor-8_81llA */
    public void mo4821setSpotShadowColor8_81llA(long j5) {
        this.spotShadowColor = j5;
        ViewLayerVerificationHelper28.INSTANCE.setOutlineSpotShadowColor(this.viewLayer, ColorKt.m4193toArgb8_81llA(j5));
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setTranslationX(float f) {
        this.translationX = f;
        this.viewLayer.setTranslationX(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setTranslationY(float f) {
        this.translationY = f;
        this.viewLayer.setTranslationY(f);
    }

    public /* synthetic */ GraphicsViewLayer(DrawChildContainer drawChildContainer, long j5, CanvasHolder canvasHolder, CanvasDrawScope canvasDrawScope, int i, e eVar) {
        this(drawChildContainer, j5, (i & 4) != 0 ? new CanvasHolder() : canvasHolder, (i & 8) != 0 ? new CanvasDrawScope() : canvasDrawScope);
    }
}
