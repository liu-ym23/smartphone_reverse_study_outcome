package androidx.compose.ui.platform;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u000e\n\u0002\bA\b\u0081\b\u0018\u00002\u00020\u0001Bã\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u000b\u0012\u0006\u0010\u0018\u001a\u00020\u000b\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001b\u001a\u00020\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u000b\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\b\u0010\"\u001a\u0004\u0018\u00010!\u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b+\u0010*J\u0010\u0010,\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b,\u0010*J\u0010\u0010-\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b-\u0010*J\u0010\u0010.\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b.\u0010*J\u0010\u0010/\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b/\u0010*J\u0010\u00100\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b0\u00101J\u0010\u00102\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b2\u00101J\u0010\u00103\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b3\u00101J\u0010\u00104\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b4\u00101J\u0010\u00105\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b5\u00101J\u0010\u00106\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b6\u0010*J\u0010\u00107\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b7\u0010*J\u0010\u00108\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b8\u00101J\u0010\u00109\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b9\u00101J\u0010\u0010:\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b:\u00101J\u0010\u0010;\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b;\u00101J\u0010\u0010<\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b<\u00101J\u0010\u0010=\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b=\u00101J\u0010\u0010>\u001a\u00020\u0019HÆ\u0003¢\u0006\u0004\b>\u0010?J\u0010\u0010@\u001a\u00020\u0019HÆ\u0003¢\u0006\u0004\b@\u0010?J\u0010\u0010A\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\bA\u00101J\u0012\u0010B\u001a\u0004\u0018\u00010\u001dHÆ\u0003¢\u0006\u0004\bB\u0010CJ\u0010\u0010E\u001a\u00020\u001fHÆ\u0003¢\u0006\u0004\bD\u0010*J\u0012\u0010F\u001a\u0004\u0018\u00010!HÆ\u0003¢\u0006\u0004\bF\u0010GJ\u0010\u0010I\u001a\u00020#HÆ\u0003¢\u0006\u0004\bH\u0010*J¢\u0002\u0010L\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u000b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010 \u001a\u00020\u001f2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\b\b\u0002\u0010$\u001a\u00020#HÆ\u0001¢\u0006\u0004\bJ\u0010KJ\u0010\u0010N\u001a\u00020MHÖ\u0001¢\u0006\u0004\bN\u0010OJ\u0010\u0010P\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\bP\u0010*J\u001a\u0010R\u001a\u00020\u00192\b\u0010Q\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\bR\u0010SR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010T\u001a\u0004\bU\u0010(R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010V\u001a\u0004\bW\u0010*R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010V\u001a\u0004\bX\u0010*R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010V\u001a\u0004\bY\u0010*R\u0017\u0010\b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010V\u001a\u0004\bZ\u0010*R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010V\u001a\u0004\b[\u0010*R\u0017\u0010\n\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010V\u001a\u0004\b\\\u0010*R\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010]\u001a\u0004\b^\u00101\"\u0004\b_\u0010`R\"\u0010\r\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010]\u001a\u0004\ba\u00101\"\u0004\bb\u0010`R\"\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010]\u001a\u0004\bc\u00101\"\u0004\bd\u0010`R\"\u0010\u000f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010]\u001a\u0004\be\u00101\"\u0004\bf\u0010`R\"\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010]\u001a\u0004\bg\u00101\"\u0004\bh\u0010`R\"\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010V\u001a\u0004\bi\u0010*\"\u0004\bj\u0010kR\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010V\u001a\u0004\bl\u0010*\"\u0004\bm\u0010kR\"\u0010\u0013\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010]\u001a\u0004\bn\u00101\"\u0004\bo\u0010`R\"\u0010\u0014\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010]\u001a\u0004\bp\u00101\"\u0004\bq\u0010`R\"\u0010\u0015\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010]\u001a\u0004\br\u00101\"\u0004\bs\u0010`R\"\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010]\u001a\u0004\bt\u00101\"\u0004\bu\u0010`R\"\u0010\u0017\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010]\u001a\u0004\bv\u00101\"\u0004\bw\u0010`R\"\u0010\u0018\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010]\u001a\u0004\bx\u00101\"\u0004\by\u0010`R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010z\u001a\u0004\b{\u0010?\"\u0004\b|\u0010}R\"\u0010\u001b\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010z\u001a\u0004\b~\u0010?\"\u0004\b\u007f\u0010}R$\u0010\u001c\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b\u001c\u0010]\u001a\u0005\b\u0080\u0001\u00101\"\u0005\b\u0081\u0001\u0010`R(\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b\u001e\u0010\u0082\u0001\u001a\u0005\b\u0083\u0001\u0010C\"\u0006\b\u0084\u0001\u0010\u0085\u0001R$\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b \u0010V\u001a\u0005\b\u0086\u0001\u0010*\"\u0005\b\u0087\u0001\u0010kR(\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b\"\u0010\u0088\u0001\u001a\u0005\b\u0089\u0001\u0010G\"\u0006\b\u008a\u0001\u0010\u008b\u0001R$\u0010$\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b$\u0010V\u001a\u0005\b\u008c\u0001\u0010*\"\u0005\b\u008d\u0001\u0010k¨\u0006\u008e\u0001"}, d2 = {"Landroidx/compose/ui/platform/DeviceRenderNodeData;", "", "", "uniqueId", "", "left", "top", "right", "bottom", "width", "height", "", "scaleX", "scaleY", "translationX", "translationY", "elevation", "ambientShadowColor", "spotShadowColor", "rotationZ", "rotationX", "rotationY", "cameraDistance", "pivotX", "pivotY", "", "clipToOutline", "clipToBounds", "alpha", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "Landroidx/compose/ui/graphics/CompositingStrategy;", "compositingStrategy", AppAgent.CONSTRUCT, "(JIIIIIIFFFFFIIFFFFFFZZFLandroidx/compose/ui/graphics/RenderEffect;ILandroidx/compose/ui/graphics/ColorFilter;ILkotlin/jvm/internal/e;)V", "component1", "()J", "component2", "()I", "component3", "component4", "component5", "component6", "component7", "component8", "()F", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "()Z", "component22", "component23", "component24", "()Landroidx/compose/ui/graphics/RenderEffect;", "component25-0nO6VwU", "component25", "component26", "()Landroidx/compose/ui/graphics/ColorFilter;", "component27--NrFUSI", "component27", "copy-qCc9W8c", "(JIIIIIIFFFFFIIFFFFFFZZFLandroidx/compose/ui/graphics/RenderEffect;ILandroidx/compose/ui/graphics/ColorFilter;I)Landroidx/compose/ui/platform/DeviceRenderNodeData;", "copy", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "J", "getUniqueId", "I", "getLeft", "getTop", "getRight", "getBottom", "getWidth", "getHeight", "F", "getScaleX", "setScaleX", "(F)V", "getScaleY", "setScaleY", "getTranslationX", "setTranslationX", "getTranslationY", "setTranslationY", "getElevation", "setElevation", "getAmbientShadowColor", "setAmbientShadowColor", "(I)V", "getSpotShadowColor", "setSpotShadowColor", "getRotationZ", "setRotationZ", "getRotationX", "setRotationX", "getRotationY", "setRotationY", "getCameraDistance", "setCameraDistance", "getPivotX", "setPivotX", "getPivotY", "setPivotY", "Z", "getClipToOutline", "setClipToOutline", "(Z)V", "getClipToBounds", "setClipToBounds", "getAlpha", "setAlpha", "Landroidx/compose/ui/graphics/RenderEffect;", "getRenderEffect", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "getBlendMode-0nO6VwU", "setBlendMode-s9anfk8", "Landroidx/compose/ui/graphics/ColorFilter;", "getColorFilter", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "getCompositingStrategy--NrFUSI", "setCompositingStrategy-aDBOjCE", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DeviceRenderNodeData {
    public static final int $stable = 8;
    private float alpha;
    private int ambientShadowColor;
    private int blendMode;
    private final int bottom;
    private float cameraDistance;
    private boolean clipToBounds;
    private boolean clipToOutline;
    private ColorFilter colorFilter;
    private int compositingStrategy;
    private float elevation;
    private final int height;
    private final int left;
    private float pivotX;
    private float pivotY;
    private RenderEffect renderEffect;
    private final int right;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private float scaleX;
    private float scaleY;
    private int spotShadowColor;
    private final int top;
    private float translationX;
    private float translationY;
    private final long uniqueId;
    private final int width;

    public /* synthetic */ DeviceRenderNodeData(long j5, int i, int i6, int i10, int i11, int i12, int i13, float f, float f7, float f9, float f10, float f11, int i14, int i15, float f12, float f13, float f14, float f15, float f16, float f17, boolean z10, boolean z11, float f18, RenderEffect renderEffect, int i16, ColorFilter colorFilter, int i17, kotlin.jvm.internal.e eVar) {
        this(j5, i, i6, i10, i11, i12, i13, f, f7, f9, f10, f11, i14, i15, f12, f13, f14, f15, f16, f17, z10, z11, f18, renderEffect, i16, colorFilter, i17);
    }

    /* renamed from: copy-qCc9W8c$default, reason: not valid java name */
    public static /* synthetic */ DeviceRenderNodeData m6000copyqCc9W8c$default(DeviceRenderNodeData deviceRenderNodeData, long j5, int i, int i6, int i10, int i11, int i12, int i13, float f, float f7, float f9, float f10, float f11, int i14, int i15, float f12, float f13, float f14, float f15, float f16, float f17, boolean z10, boolean z11, float f18, RenderEffect renderEffect, int i16, ColorFilter colorFilter, int i17, int i18, Object obj) {
        int i19;
        ColorFilter colorFilter2;
        long j6 = (i18 & 1) != 0 ? deviceRenderNodeData.uniqueId : j5;
        int i20 = (i18 & 2) != 0 ? deviceRenderNodeData.left : i;
        int i21 = (i18 & 4) != 0 ? deviceRenderNodeData.top : i6;
        int i22 = (i18 & 8) != 0 ? deviceRenderNodeData.right : i10;
        int i23 = (i18 & 16) != 0 ? deviceRenderNodeData.bottom : i11;
        int i24 = (i18 & 32) != 0 ? deviceRenderNodeData.width : i12;
        int i25 = (i18 & 64) != 0 ? deviceRenderNodeData.height : i13;
        float f19 = (i18 & 128) != 0 ? deviceRenderNodeData.scaleX : f;
        float f20 = (i18 & 256) != 0 ? deviceRenderNodeData.scaleY : f7;
        float f21 = (i18 & 512) != 0 ? deviceRenderNodeData.translationX : f9;
        float f22 = (i18 & 1024) != 0 ? deviceRenderNodeData.translationY : f10;
        float f23 = (i18 & 2048) != 0 ? deviceRenderNodeData.elevation : f11;
        int i26 = (i18 & 4096) != 0 ? deviceRenderNodeData.ambientShadowColor : i14;
        long j10 = j6;
        int i27 = (i18 & 8192) != 0 ? deviceRenderNodeData.spotShadowColor : i15;
        float f24 = (i18 & 16384) != 0 ? deviceRenderNodeData.rotationZ : f12;
        float f25 = (i18 & 32768) != 0 ? deviceRenderNodeData.rotationX : f13;
        float f26 = (i18 & 65536) != 0 ? deviceRenderNodeData.rotationY : f14;
        float f27 = (i18 & 131072) != 0 ? deviceRenderNodeData.cameraDistance : f15;
        float f28 = (i18 & 262144) != 0 ? deviceRenderNodeData.pivotX : f16;
        float f29 = (i18 & 524288) != 0 ? deviceRenderNodeData.pivotY : f17;
        boolean z12 = (i18 & 1048576) != 0 ? deviceRenderNodeData.clipToOutline : z10;
        boolean z13 = (i18 & 2097152) != 0 ? deviceRenderNodeData.clipToBounds : z11;
        float f30 = (i18 & 4194304) != 0 ? deviceRenderNodeData.alpha : f18;
        RenderEffect renderEffect2 = (i18 & 8388608) != 0 ? deviceRenderNodeData.renderEffect : renderEffect;
        int i28 = (i18 & 16777216) != 0 ? deviceRenderNodeData.blendMode : i16;
        ColorFilter colorFilter3 = (i18 & 33554432) != 0 ? deviceRenderNodeData.colorFilter : colorFilter;
        if ((i18 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0) {
            colorFilter2 = colorFilter3;
            i19 = deviceRenderNodeData.compositingStrategy;
        } else {
            i19 = i17;
            colorFilter2 = colorFilter3;
        }
        return deviceRenderNodeData.m6003copyqCc9W8c(j10, i20, i21, i22, i23, i24, i25, f19, f20, f21, f22, f23, i26, i27, f24, f25, f26, f27, f28, f29, z12, z13, f30, renderEffect2, i28, colorFilter2, i19);
    }

    /* renamed from: component1, reason: from getter */
    public final long getUniqueId() {
        return this.uniqueId;
    }

    /* renamed from: component10, reason: from getter */
    public final float getTranslationX() {
        return this.translationX;
    }

    /* renamed from: component11, reason: from getter */
    public final float getTranslationY() {
        return this.translationY;
    }

    /* renamed from: component12, reason: from getter */
    public final float getElevation() {
        return this.elevation;
    }

    /* renamed from: component13, reason: from getter */
    public final int getAmbientShadowColor() {
        return this.ambientShadowColor;
    }

    /* renamed from: component14, reason: from getter */
    public final int getSpotShadowColor() {
        return this.spotShadowColor;
    }

    /* renamed from: component15, reason: from getter */
    public final float getRotationZ() {
        return this.rotationZ;
    }

    /* renamed from: component16, reason: from getter */
    public final float getRotationX() {
        return this.rotationX;
    }

    /* renamed from: component17, reason: from getter */
    public final float getRotationY() {
        return this.rotationY;
    }

    /* renamed from: component18, reason: from getter */
    public final float getCameraDistance() {
        return this.cameraDistance;
    }

    /* renamed from: component19, reason: from getter */
    public final float getPivotX() {
        return this.pivotX;
    }

    /* renamed from: component2, reason: from getter */
    public final int getLeft() {
        return this.left;
    }

    /* renamed from: component20, reason: from getter */
    public final float getPivotY() {
        return this.pivotY;
    }

    /* renamed from: component21, reason: from getter */
    public final boolean getClipToOutline() {
        return this.clipToOutline;
    }

    /* renamed from: component22, reason: from getter */
    public final boolean getClipToBounds() {
        return this.clipToBounds;
    }

    /* renamed from: component23, reason: from getter */
    public final float getAlpha() {
        return this.alpha;
    }

    /* renamed from: component24, reason: from getter */
    public final RenderEffect getRenderEffect() {
        return this.renderEffect;
    }

    /* renamed from: component25-0nO6VwU, reason: not valid java name and from getter */
    public final int getBlendMode() {
        return this.blendMode;
    }

    /* renamed from: component26, reason: from getter */
    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    /* renamed from: component27--NrFUSI, reason: not valid java name and from getter */
    public final int getCompositingStrategy() {
        return this.compositingStrategy;
    }

    /* renamed from: component3, reason: from getter */
    public final int getTop() {
        return this.top;
    }

    /* renamed from: component4, reason: from getter */
    public final int getRight() {
        return this.right;
    }

    /* renamed from: component5, reason: from getter */
    public final int getBottom() {
        return this.bottom;
    }

    /* renamed from: component6, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: component7, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: component8, reason: from getter */
    public final float getScaleX() {
        return this.scaleX;
    }

    /* renamed from: component9, reason: from getter */
    public final float getScaleY() {
        return this.scaleY;
    }

    /* renamed from: copy-qCc9W8c, reason: not valid java name */
    public final DeviceRenderNodeData m6003copyqCc9W8c(long uniqueId, int left, int top, int right, int bottom, int width, int height, float scaleX, float scaleY, float translationX, float translationY, float elevation, int ambientShadowColor, int spotShadowColor, float rotationZ, float rotationX, float rotationY, float cameraDistance, float pivotX, float pivotY, boolean clipToOutline, boolean clipToBounds, float alpha, RenderEffect renderEffect, int blendMode, ColorFilter colorFilter, int compositingStrategy) {
        return new DeviceRenderNodeData(uniqueId, left, top, right, bottom, width, height, scaleX, scaleY, translationX, translationY, elevation, ambientShadowColor, spotShadowColor, rotationZ, rotationX, rotationY, cameraDistance, pivotX, pivotY, clipToOutline, clipToBounds, alpha, renderEffect, blendMode, colorFilter, compositingStrategy, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceRenderNodeData)) {
            return false;
        }
        DeviceRenderNodeData deviceRenderNodeData = (DeviceRenderNodeData) other;
        return this.uniqueId == deviceRenderNodeData.uniqueId && this.left == deviceRenderNodeData.left && this.top == deviceRenderNodeData.top && this.right == deviceRenderNodeData.right && this.bottom == deviceRenderNodeData.bottom && this.width == deviceRenderNodeData.width && this.height == deviceRenderNodeData.height && Float.compare(this.scaleX, deviceRenderNodeData.scaleX) == 0 && Float.compare(this.scaleY, deviceRenderNodeData.scaleY) == 0 && Float.compare(this.translationX, deviceRenderNodeData.translationX) == 0 && Float.compare(this.translationY, deviceRenderNodeData.translationY) == 0 && Float.compare(this.elevation, deviceRenderNodeData.elevation) == 0 && this.ambientShadowColor == deviceRenderNodeData.ambientShadowColor && this.spotShadowColor == deviceRenderNodeData.spotShadowColor && Float.compare(this.rotationZ, deviceRenderNodeData.rotationZ) == 0 && Float.compare(this.rotationX, deviceRenderNodeData.rotationX) == 0 && Float.compare(this.rotationY, deviceRenderNodeData.rotationY) == 0 && Float.compare(this.cameraDistance, deviceRenderNodeData.cameraDistance) == 0 && Float.compare(this.pivotX, deviceRenderNodeData.pivotX) == 0 && Float.compare(this.pivotY, deviceRenderNodeData.pivotY) == 0 && this.clipToOutline == deviceRenderNodeData.clipToOutline && this.clipToBounds == deviceRenderNodeData.clipToBounds && Float.compare(this.alpha, deviceRenderNodeData.alpha) == 0 && kotlin.jvm.internal.k.b(this.renderEffect, deviceRenderNodeData.renderEffect) && BlendMode.m4049equalsimpl0(this.blendMode, deviceRenderNodeData.blendMode) && kotlin.jvm.internal.k.b(this.colorFilter, deviceRenderNodeData.colorFilter) && CompositingStrategy.m4224equalsimpl0(this.compositingStrategy, deviceRenderNodeData.compositingStrategy);
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final int getAmbientShadowColor() {
        return this.ambientShadowColor;
    }

    /* renamed from: getBlendMode-0nO6VwU, reason: not valid java name */
    public final int m6004getBlendMode0nO6VwU() {
        return this.blendMode;
    }

    public final int getBottom() {
        return this.bottom;
    }

    public final float getCameraDistance() {
        return this.cameraDistance;
    }

    public final boolean getClipToBounds() {
        return this.clipToBounds;
    }

    public final boolean getClipToOutline() {
        return this.clipToOutline;
    }

    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    /* renamed from: getCompositingStrategy--NrFUSI, reason: not valid java name */
    public final int m6005getCompositingStrategyNrFUSI() {
        return this.compositingStrategy;
    }

    public final float getElevation() {
        return this.elevation;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getLeft() {
        return this.left;
    }

    public final float getPivotX() {
        return this.pivotX;
    }

    public final float getPivotY() {
        return this.pivotY;
    }

    public final RenderEffect getRenderEffect() {
        return this.renderEffect;
    }

    public final int getRight() {
        return this.right;
    }

    public final float getRotationX() {
        return this.rotationX;
    }

    public final float getRotationY() {
        return this.rotationY;
    }

    public final float getRotationZ() {
        return this.rotationZ;
    }

    public final float getScaleX() {
        return this.scaleX;
    }

    public final float getScaleY() {
        return this.scaleY;
    }

    public final int getSpotShadowColor() {
        return this.spotShadowColor;
    }

    public final int getTop() {
        return this.top;
    }

    public final float getTranslationX() {
        return this.translationX;
    }

    public final float getTranslationY() {
        return this.translationY;
    }

    public final long getUniqueId() {
        return this.uniqueId;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        int iB = androidx.appfunctions.metadata.a.b(this.alpha, androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.b(this.pivotY, androidx.appfunctions.metadata.a.b(this.pivotX, androidx.appfunctions.metadata.a.b(this.cameraDistance, androidx.appfunctions.metadata.a.b(this.rotationY, androidx.appfunctions.metadata.a.b(this.rotationX, androidx.appfunctions.metadata.a.b(this.rotationZ, androidx.constraintlayout.core.dsl.a.a(this.spotShadowColor, androidx.constraintlayout.core.dsl.a.a(this.ambientShadowColor, androidx.appfunctions.metadata.a.b(this.elevation, androidx.appfunctions.metadata.a.b(this.translationY, androidx.appfunctions.metadata.a.b(this.translationX, androidx.appfunctions.metadata.a.b(this.scaleY, androidx.appfunctions.metadata.a.b(this.scaleX, androidx.constraintlayout.core.dsl.a.a(this.height, androidx.constraintlayout.core.dsl.a.a(this.width, androidx.constraintlayout.core.dsl.a.a(this.bottom, androidx.constraintlayout.core.dsl.a.a(this.right, androidx.constraintlayout.core.dsl.a.a(this.top, androidx.constraintlayout.core.dsl.a.a(this.left, Long.hashCode(this.uniqueId) * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31, this.clipToOutline), 31, this.clipToBounds), 31);
        RenderEffect renderEffect = this.renderEffect;
        int iM4050hashCodeimpl = (BlendMode.m4050hashCodeimpl(this.blendMode) + ((iB + (renderEffect == null ? 0 : renderEffect.hashCode())) * 31)) * 31;
        ColorFilter colorFilter = this.colorFilter;
        return CompositingStrategy.m4225hashCodeimpl(this.compositingStrategy) + ((iM4050hashCodeimpl + (colorFilter != null ? colorFilter.hashCode() : 0)) * 31);
    }

    public final void setAlpha(float f) {
        this.alpha = f;
    }

    public final void setAmbientShadowColor(int i) {
        this.ambientShadowColor = i;
    }

    /* renamed from: setBlendMode-s9anfk8, reason: not valid java name */
    public final void m6006setBlendModes9anfk8(int i) {
        this.blendMode = i;
    }

    public final void setCameraDistance(float f) {
        this.cameraDistance = f;
    }

    public final void setClipToBounds(boolean z10) {
        this.clipToBounds = z10;
    }

    public final void setClipToOutline(boolean z10) {
        this.clipToOutline = z10;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
    }

    /* renamed from: setCompositingStrategy-aDBOjCE, reason: not valid java name */
    public final void m6007setCompositingStrategyaDBOjCE(int i) {
        this.compositingStrategy = i;
    }

    public final void setElevation(float f) {
        this.elevation = f;
    }

    public final void setPivotX(float f) {
        this.pivotX = f;
    }

    public final void setPivotY(float f) {
        this.pivotY = f;
    }

    public final void setRenderEffect(RenderEffect renderEffect) {
        this.renderEffect = renderEffect;
    }

    public final void setRotationX(float f) {
        this.rotationX = f;
    }

    public final void setRotationY(float f) {
        this.rotationY = f;
    }

    public final void setRotationZ(float f) {
        this.rotationZ = f;
    }

    public final void setScaleX(float f) {
        this.scaleX = f;
    }

    public final void setScaleY(float f) {
        this.scaleY = f;
    }

    public final void setSpotShadowColor(int i) {
        this.spotShadowColor = i;
    }

    public final void setTranslationX(float f) {
        this.translationX = f;
    }

    public final void setTranslationY(float f) {
        this.translationY = f;
    }

    public String toString() {
        return "DeviceRenderNodeData(uniqueId=" + this.uniqueId + ", left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ", width=" + this.width + ", height=" + this.height + ", scaleX=" + this.scaleX + ", scaleY=" + this.scaleY + ", translationX=" + this.translationX + ", translationY=" + this.translationY + ", elevation=" + this.elevation + ", ambientShadowColor=" + this.ambientShadowColor + ", spotShadowColor=" + this.spotShadowColor + ", rotationZ=" + this.rotationZ + ", rotationX=" + this.rotationX + ", rotationY=" + this.rotationY + ", cameraDistance=" + this.cameraDistance + ", pivotX=" + this.pivotX + ", pivotY=" + this.pivotY + ", clipToOutline=" + this.clipToOutline + ", clipToBounds=" + this.clipToBounds + ", alpha=" + this.alpha + ", renderEffect=" + this.renderEffect + ", blendMode=" + ((Object) BlendMode.m4051toStringimpl(this.blendMode)) + ", colorFilter=" + this.colorFilter + ", compositingStrategy=" + ((Object) CompositingStrategy.m4226toStringimpl(this.compositingStrategy)) + ')';
    }

    private DeviceRenderNodeData(long j5, int i, int i6, int i10, int i11, int i12, int i13, float f, float f7, float f9, float f10, float f11, int i14, int i15, float f12, float f13, float f14, float f15, float f16, float f17, boolean z10, boolean z11, float f18, RenderEffect renderEffect, int i16, ColorFilter colorFilter, int i17) {
        this.uniqueId = j5;
        this.left = i;
        this.top = i6;
        this.right = i10;
        this.bottom = i11;
        this.width = i12;
        this.height = i13;
        this.scaleX = f;
        this.scaleY = f7;
        this.translationX = f9;
        this.translationY = f10;
        this.elevation = f11;
        this.ambientShadowColor = i14;
        this.spotShadowColor = i15;
        this.rotationZ = f12;
        this.rotationX = f13;
        this.rotationY = f14;
        this.cameraDistance = f15;
        this.pivotX = f16;
        this.pivotY = f17;
        this.clipToOutline = z10;
        this.clipToBounds = z11;
        this.alpha = f18;
        this.renderEffect = renderEffect;
        this.blendMode = i16;
        this.colorFilter = colorFilter;
        this.compositingStrategy = i17;
    }
}
