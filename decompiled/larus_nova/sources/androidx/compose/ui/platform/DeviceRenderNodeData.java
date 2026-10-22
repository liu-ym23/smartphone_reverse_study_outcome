package androidx.compose.ui.platform;

import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.RenderEffect;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\ba\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001Bã\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\f\u0012\u0006\u0010\u0014\u001a\u00020\f\u0012\u0006\u0010\u0015\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\f\u0012\u0006\u0010\u0018\u001a\u00020\f\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001c\u001a\u00020\f\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\u0006\u0010\u001f\u001a\u00020 \u0012\b\u0010!\u001a\u0004\u0018\u00010\"\u0012\u0006\u0010#\u001a\u00020$¢\u0006\u0004\b%\u0010&J\t\u0010b\u001a\u00020\u0003HÆ\u0003J\t\u0010c\u001a\u00020\u0005HÆ\u0003J\t\u0010d\u001a\u00020\u0005HÆ\u0003J\t\u0010e\u001a\u00020\u0005HÆ\u0003J\t\u0010f\u001a\u00020\u0005HÆ\u0003J\t\u0010g\u001a\u00020\u0005HÆ\u0003J\t\u0010h\u001a\u00020\u0005HÆ\u0003J\t\u0010i\u001a\u00020\fHÆ\u0003J\t\u0010j\u001a\u00020\fHÆ\u0003J\t\u0010k\u001a\u00020\fHÆ\u0003J\t\u0010l\u001a\u00020\fHÆ\u0003J\t\u0010m\u001a\u00020\fHÆ\u0003J\t\u0010n\u001a\u00020\u0005HÆ\u0003J\t\u0010o\u001a\u00020\u0005HÆ\u0003J\t\u0010p\u001a\u00020\fHÆ\u0003J\t\u0010q\u001a\u00020\fHÆ\u0003J\t\u0010r\u001a\u00020\fHÆ\u0003J\t\u0010s\u001a\u00020\fHÆ\u0003J\t\u0010t\u001a\u00020\fHÆ\u0003J\t\u0010u\u001a\u00020\fHÆ\u0003J\t\u0010v\u001a\u00020\u001aHÆ\u0003J\t\u0010w\u001a\u00020\u001aHÆ\u0003J\t\u0010x\u001a\u00020\fHÆ\u0003J\u000b\u0010y\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\u0010\u0010z\u001a\u00020 HÆ\u0003¢\u0006\u0004\b{\u0010*J\u000b\u0010|\u001a\u0004\u0018\u00010\"HÆ\u0003J\u0010\u0010}\u001a\u00020$HÆ\u0003¢\u0006\u0004\b~\u0010*J¤\u0002\u0010\u007f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\f2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\f2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$HÆ\u0001¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u0015\u0010\u0082\u0001\u001a\u00020\u001a2\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0084\u0001\u001a\u00020\u0005HÖ\u0001J\u000b\u0010\u0085\u0001\u001a\u00030\u0086\u0001HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010*R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010*R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010*R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010*R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010*R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u0010\r\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00101\"\u0004\b5\u00103R\u001a\u0010\u000e\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00101\"\u0004\b7\u00103R\u001a\u0010\u000f\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00101\"\u0004\b9\u00103R\u001a\u0010\u0010\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00101\"\u0004\b;\u00103R\u001a\u0010\u0011\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010*\"\u0004\b=\u0010>R\u001a\u0010\u0012\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010*\"\u0004\b@\u0010>R\u001a\u0010\u0013\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u00101\"\u0004\bB\u00103R\u001a\u0010\u0014\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u00101\"\u0004\bD\u00103R\u001a\u0010\u0015\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u00101\"\u0004\bF\u00103R\u001a\u0010\u0016\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u00101\"\u0004\bH\u00103R\u001a\u0010\u0017\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u00101\"\u0004\bJ\u00103R\u001a\u0010\u0018\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u00101\"\u0004\bL\u00103R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001a\u0010\u001b\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010N\"\u0004\bR\u0010PR\u001a\u0010\u001c\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u00101\"\u0004\bT\u00103R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001c\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u0010\n\u0002\u0010[\u001a\u0004\bY\u0010*\"\u0004\bZ\u0010>R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u001c\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u0010\n\u0002\u0010[\u001a\u0004\b`\u0010*\"\u0004\ba\u0010>¨\u0006\u0087\u0001"}, d2 = {"Landroidx/compose/ui/platform/DeviceRenderNodeData;", "", "uniqueId", "", "left", "", "top", "right", "bottom", "width", "height", LiveDegradeFpsAnimator.SCALE_X, "", LiveDegradeFpsAnimator.SCALE_Y, LiveDegradeFpsAnimator.TRANSLATION_X, LiveDegradeFpsAnimator.TRANSLATION_Y, "elevation", "ambientShadowColor", "spotShadowColor", "rotationZ", "rotationX", "rotationY", "cameraDistance", "pivotX", "pivotY", "clipToOutline", "", "clipToBounds", "alpha", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "compositingStrategy", "Landroidx/compose/ui/graphics/CompositingStrategy;", "<init>", "(JIIIIIIFFFFFIIFFFFFFZZFLandroidx/compose/ui/graphics/RenderEffect;ILandroidx/compose/ui/graphics/ColorFilter;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getUniqueId", "()J", "getLeft", "()I", "getTop", "getRight", "getBottom", "getWidth", "getHeight", "getScaleX", "()F", "setScaleX", "(F)V", "getScaleY", "setScaleY", "getTranslationX", "setTranslationX", "getTranslationY", "setTranslationY", "getElevation", "setElevation", "getAmbientShadowColor", "setAmbientShadowColor", "(I)V", "getSpotShadowColor", "setSpotShadowColor", "getRotationZ", "setRotationZ", "getRotationX", "setRotationX", "getRotationY", "setRotationY", "getCameraDistance", "setCameraDistance", "getPivotX", "setPivotX", "getPivotY", "setPivotY", "getClipToOutline", "()Z", "setClipToOutline", "(Z)V", "getClipToBounds", "setClipToBounds", "getAlpha", "setAlpha", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "getBlendMode-0nO6VwU", "setBlendMode-s9anfk8", "I", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "getCompositingStrategy--NrFUSI", "setCompositingStrategy-aDBOjCE", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component25-0nO6VwU", "component26", "component27", "component27--NrFUSI", "copy", "copy-qCc9W8c", "(JIIIIIIFFFFFIIFFFFFFZZFLandroidx/compose/ui/graphics/RenderEffect;ILandroidx/compose/ui/graphics/ColorFilter;I)Landroidx/compose/ui/platform/DeviceRenderNodeData;", "equals", "other", "hashCode", "toString", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DeviceRenderNodeData {
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

    public /* synthetic */ DeviceRenderNodeData(long r100, int r101, int r102, int r103, int r104, int r105, int r106, float r107, float r110, float r111, float r112, float r113, int r114, int r115, float r116, float r117, float r118, float r119, float r210, float r211, boolean r212, boolean r213, float r214, RenderEffect r215, int r216, ColorFilter r217, int r218, DefaultConstructorMarker r219) {
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r210, r211, r212, r213, r214, r215, r216, r217, r218);
    }

    /* JADX INFO: renamed from: copy-qCc9W8c$default, reason: not valid java name */
    public static /* synthetic */ DeviceRenderNodeData m6692copyqCc9W8c$default(DeviceRenderNodeData r110, long r111, int r210, int r211, int r212, int r213, int r214, int r215, float r216, float r217, float r218, float r219, float r310, int r311, int r312, float r313, float r314, float r315, float r316, float r317, float r318, boolean r319, boolean r410, float r411, RenderEffect r412, int r413, ColorFilter r414, int r415, int r416, Object r417) {
        if ((r416 & 1) == 0) goto L5;
        long r100 = r110.uniqueId;
    L7:
        if ((r416 & 2) == 0) goto L9;
        int r101 = r110.left;
    L11:
        if ((r416 & 4) == 0) goto L13;
        int r102 = r110.top;
    L15:
        if ((r416 & 8) == 0) goto L17;
        int r103 = r110.right;
    L19:
        if ((r416 & 16) == 0) goto L21;
        int r104 = r110.bottom;
    L23:
        if ((r416 & 32) == 0) goto L25;
        int r105 = r110.width;
    L27:
        if ((r416 & 64) == 0) goto L29;
        int r106 = r110.height;
    L31:
        if ((r416 & 128) == 0) goto L33;
        float r112 = r110.scaleX;
    L35:
        if ((r416 & 256) == 0) goto L37;
        float r113 = r110.scaleY;
    L39:
        if ((r416 & 512) == 0) goto L41;
        float r114 = r110.translationX;
    L43:
        if ((r416 & 1024) == 0) goto L45;
        float r115 = r110.translationY;
    L47:
        if ((r416 & 2048) == 0) goto L49;
        float r116 = r110.elevation;
    L51:
        if ((r416 & 4096) == 0) goto L53;
        int r117 = r110.ambientShadowColor;
    L54:
        int r320 = r117;
        if ((r416 & 8192) == 0) goto L57;
        int r118 = r110.spotShadowColor;
    L58:
        int r321 = r118;
        if ((r416 & 16384) == 0) goto L61;
        float r119 = r110.rotationZ;
    L62:
        float r322 = r119;
        if ((r416 & 32768) == 0) goto L65;
        float r120 = r110.rotationX;
    L66:
        float r323 = r120;
        if ((r416 & 65536) == 0) goto L69;
        float r121 = r110.rotationY;
    L70:
        float r324 = r121;
        if ((r416 & 131072) == 0) goto L73;
        float r122 = r110.cameraDistance;
    L74:
        float r325 = r122;
        if ((r416 & 262144) == 0) goto L77;
        float r123 = r110.pivotX;
    L78:
        float r326 = r123;
        if ((r416 & 524288) == 0) goto L81;
        float r124 = r110.pivotY;
    L82:
        float r327 = r124;
        if ((r416 & 1048576) == 0) goto L85;
        boolean r125 = r110.clipToOutline;
    L86:
        boolean r328 = r125;
        if ((r416 & 2097152) == 0) goto L89;
        boolean r126 = r110.clipToBounds;
    L90:
        boolean r418 = r126;
        if ((r416 & 4194304) == 0) goto L93;
        float r127 = r110.alpha;
    L94:
        float r419 = r127;
        if ((r416 & 8388608) == 0) goto L97;
        RenderEffect r128 = r110.renderEffect;
    L98:
        RenderEffect r420 = r128;
        if ((r416 & 16777216) == 0) goto L101;
        int r129 = r110.blendMode;
    L102:
        int r421 = r129;
        if ((r416 & 33554432) == 0) goto L105;
        ColorFilter r130 = r110.colorFilter;
    L107:
        if ((r416 & 67108864) == 0) goto L109;
        int r107 = r110.compositingStrategy;
    L111:
        return r110.m6695copyqCc9W8c(r100, r101, r102, r103, r104, r105, r106, r112, r113, r114, r115, r116, r320, r321, r322, r323, r324, r325, r326, r327, r328, r418, r419, r420, r421, r130, r107);
    L109:
        r107 = r415;
        goto L111
    L105:
        r130 = r414;
        goto L107
    L101:
        r129 = r413;
        goto L102
    L97:
        r128 = r412;
        goto L98
    L93:
        r127 = r411;
        goto L94
    L89:
        r126 = r410;
        goto L90
    L85:
        r125 = r319;
        goto L86
    L81:
        r124 = r318;
        goto L82
    L77:
        r123 = r317;
        goto L78
    L73:
        r122 = r316;
        goto L74
    L69:
        r121 = r315;
        goto L70
    L65:
        r120 = r314;
        goto L66
    L61:
        r119 = r313;
        goto L62
    L57:
        r118 = r312;
        goto L58
    L53:
        r117 = r311;
        goto L54
    L49:
        r116 = r310;
        goto L51
    L45:
        r115 = r219;
        goto L47
    L41:
        r114 = r218;
        goto L43
    L37:
        r113 = r217;
        goto L39
    L33:
        r112 = r216;
        goto L35
    L29:
        r106 = r215;
        goto L31
    L25:
        r105 = r214;
        goto L27
    L21:
        r104 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final long component1() {
        return this.uniqueId;
    }

    public final float component10() {
        return this.translationX;
    }

    public final float component11() {
        return this.translationY;
    }

    public final float component12() {
        return this.elevation;
    }

    public final int component13() {
        return this.ambientShadowColor;
    }

    public final int component14() {
        return this.spotShadowColor;
    }

    public final float component15() {
        return this.rotationZ;
    }

    public final float component16() {
        return this.rotationX;
    }

    public final float component17() {
        return this.rotationY;
    }

    public final float component18() {
        return this.cameraDistance;
    }

    public final float component19() {
        return this.pivotX;
    }

    public final int component2() {
        return this.left;
    }

    public final float component20() {
        return this.pivotY;
    }

    public final boolean component21() {
        return this.clipToOutline;
    }

    public final boolean component22() {
        return this.clipToBounds;
    }

    public final float component23() {
        return this.alpha;
    }

    public final RenderEffect component24() {
        return this.renderEffect;
    }

    /* JADX INFO: renamed from: component25-0nO6VwU, reason: not valid java name */
    public final int m6693component250nO6VwU() {
        return this.blendMode;
    }

    public final ColorFilter component26() {
        return this.colorFilter;
    }

    /* JADX INFO: renamed from: component27--NrFUSI, reason: not valid java name */
    public final int m6694component27NrFUSI() {
        return this.compositingStrategy;
    }

    public final int component3() {
        return this.top;
    }

    public final int component4() {
        return this.right;
    }

    public final int component5() {
        return this.bottom;
    }

    public final int component6() {
        return this.width;
    }

    public final int component7() {
        return this.height;
    }

    public final float component8() {
        return this.scaleX;
    }

    public final float component9() {
        return this.scaleY;
    }

    /* JADX INFO: renamed from: copy-qCc9W8c, reason: not valid java name */
    public final DeviceRenderNodeData m6695copyqCc9W8c(long r310, int r311, int r312, int r313, int r314, int r315, int r316, float r410, float r411, float r412, float r413, float r414, int r415, int r416, float r417, float r418, float r419, float r510, float r511, float r512, boolean r513, boolean r514, float r515, RenderEffect r516, int r517, ColorFilter r518, int r519) {
        return new DeviceRenderNodeData(r310, r311, r312, r313, r314, r315, r316, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, null);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DeviceRenderNodeData) == true) goto L8;
        return false;
    L8:
        DeviceRenderNodeData r101 = (DeviceRenderNodeData) r100;
        if (this.uniqueId == r101.uniqueId) goto L12;
        return false;
    L12:
        if (this.left == r101.left) goto L15;
        return false;
    L15:
        if (this.top == r101.top) goto L18;
        return false;
    L18:
        if (this.right == r101.right) goto L21;
        return false;
    L21:
        if (this.bottom == r101.bottom) goto L24;
        return false;
    L24:
        if (this.width == r101.width) goto L27;
        return false;
    L27:
        if (this.height == r101.height) goto L30;
        return false;
    L30:
        if (Float.compare(this.scaleX, r101.scaleX) == 0) goto L33;
        return false;
    L33:
        if (Float.compare(this.scaleY, r101.scaleY) == 0) goto L36;
        return false;
    L36:
        if (Float.compare(this.translationX, r101.translationX) == 0) goto L39;
        return false;
    L39:
        if (Float.compare(this.translationY, r101.translationY) == 0) goto L42;
        return false;
    L42:
        if (Float.compare(this.elevation, r101.elevation) == 0) goto L45;
        return false;
    L45:
        if (this.ambientShadowColor == r101.ambientShadowColor) goto L48;
        return false;
    L48:
        if (this.spotShadowColor == r101.spotShadowColor) goto L51;
        return false;
    L51:
        if (Float.compare(this.rotationZ, r101.rotationZ) == 0) goto L54;
        return false;
    L54:
        if (Float.compare(this.rotationX, r101.rotationX) == 0) goto L57;
        return false;
    L57:
        if (Float.compare(this.rotationY, r101.rotationY) == 0) goto L60;
        return false;
    L60:
        if (Float.compare(this.cameraDistance, r101.cameraDistance) == 0) goto L63;
        return false;
    L63:
        if (Float.compare(this.pivotX, r101.pivotX) == 0) goto L66;
        return false;
    L66:
        if (Float.compare(this.pivotY, r101.pivotY) == 0) goto L69;
        return false;
    L69:
        if (this.clipToOutline == r101.clipToOutline) goto L72;
        return false;
    L72:
        if (this.clipToBounds == r101.clipToBounds) goto L75;
        return false;
    L75:
        if (Float.compare(this.alpha, r101.alpha) == 0) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.renderEffect, r101.renderEffect) == true) goto L81;
        return false;
    L81:
        if (BlendMode.m4737equalsimpl0(this.blendMode, r101.blendMode) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.colorFilter, r101.colorFilter) == true) goto L87;
        return false;
    L87:
        if (CompositingStrategy.m4912equalsimpl0(this.compositingStrategy, r101.compositingStrategy) == true) goto L89;
        return false;
    L89:
        return true;
    }

    public int hashCode() {
        long r100 = this.uniqueId;
        int r101 = ((((((((((((((((((((((((((((((((((((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.left) * 31) + this.top) * 31) + this.right) * 31) + this.bottom) * 31) + this.width) * 31) + this.height) * 31) + Float.floatToIntBits(this.scaleX)) * 31) + Float.floatToIntBits(this.scaleY)) * 31) + Float.floatToIntBits(this.translationX)) * 31) + Float.floatToIntBits(this.translationY)) * 31) + Float.floatToIntBits(this.elevation)) * 31) + this.ambientShadowColor) * 31) + this.spotShadowColor) * 31) + Float.floatToIntBits(this.rotationZ)) * 31) + Float.floatToIntBits(this.rotationX)) * 31) + Float.floatToIntBits(this.rotationY)) * 31) + Float.floatToIntBits(this.cameraDistance)) * 31) + Float.floatToIntBits(this.pivotX)) * 31) + Float.floatToIntBits(this.pivotY)) * 31;
        int r102 = 1231;
        if (this.clipToOutline == false) goto L5;
        int r103 = 1231;
    L6:
        int r104 = (r101 + r103) * 31;
        if (this.clipToBounds == true) goto L10;
        r102 = 1237;
    L10:
        int r105 = (((r104 + r102) * 31) + Float.floatToIntBits(this.alpha)) * 31;
        RenderEffect r106 = this.renderEffect;
        int r107 = 0;
        if (r106 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((r105 + r108) * 31) + BlendMode.m4738hashCodeimpl(this.blendMode)) * 31;
        ColorFilter r110 = this.colorFilter;
        if (r110 == null) goto L19;
        r107 = r110.hashCode();
    L19:
        return ((r109 + r107) * 31) + CompositingStrategy.m4913hashCodeimpl(this.compositingStrategy);
    L13:
        r108 = r106.hashCode();
        goto L14
    L5:
        r103 = 1237;
        goto L6
    }

    public String toString() {
        return "DeviceRenderNodeData(uniqueId=" + this.uniqueId + ", left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ", width=" + this.width + ", height=" + this.height + ", scaleX=" + this.scaleX + ", scaleY=" + this.scaleY + ", translationX=" + this.translationX + ", translationY=" + this.translationY + ", elevation=" + this.elevation + ", ambientShadowColor=" + this.ambientShadowColor + ", spotShadowColor=" + this.spotShadowColor + ", rotationZ=" + this.rotationZ + ", rotationX=" + this.rotationX + ", rotationY=" + this.rotationY + ", cameraDistance=" + this.cameraDistance + ", pivotX=" + this.pivotX + ", pivotY=" + this.pivotY + ", clipToOutline=" + this.clipToOutline + ", clipToBounds=" + this.clipToBounds + ", alpha=" + this.alpha + ", renderEffect=" + this.renderEffect + ", blendMode=" + BlendMode.m4739toStringimpl(this.blendMode) + ", colorFilter=" + this.colorFilter + ", compositingStrategy=" + CompositingStrategy.m4914toStringimpl(this.compositingStrategy) + ')';
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final int getAmbientShadowColor() {
        return this.ambientShadowColor;
    }

    /* JADX INFO: renamed from: getBlendMode-0nO6VwU, reason: not valid java name */
    public final int m6696getBlendMode0nO6VwU() {
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

    /* JADX INFO: renamed from: getCompositingStrategy--NrFUSI, reason: not valid java name */
    public final int m6697getCompositingStrategyNrFUSI() {
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

    public final void setAlpha(float r100) {
        this.alpha = r100;
    }

    public final void setAmbientShadowColor(int r100) {
        this.ambientShadowColor = r100;
    }

    /* JADX INFO: renamed from: setBlendMode-s9anfk8, reason: not valid java name */
    public final void m6698setBlendModes9anfk8(int r100) {
        this.blendMode = r100;
    }

    public final void setCameraDistance(float r100) {
        this.cameraDistance = r100;
    }

    public final void setClipToBounds(boolean r100) {
        this.clipToBounds = r100;
    }

    public final void setClipToOutline(boolean r100) {
        this.clipToOutline = r100;
    }

    public final void setColorFilter(ColorFilter r100) {
        this.colorFilter = r100;
    }

    /* JADX INFO: renamed from: setCompositingStrategy-aDBOjCE, reason: not valid java name */
    public final void m6699setCompositingStrategyaDBOjCE(int r100) {
        this.compositingStrategy = r100;
    }

    public final void setElevation(float r100) {
        this.elevation = r100;
    }

    public final void setPivotX(float r100) {
        this.pivotX = r100;
    }

    public final void setPivotY(float r100) {
        this.pivotY = r100;
    }

    public final void setRenderEffect(RenderEffect r100) {
        this.renderEffect = r100;
    }

    public final void setRotationX(float r100) {
        this.rotationX = r100;
    }

    public final void setRotationY(float r100) {
        this.rotationY = r100;
    }

    public final void setRotationZ(float r100) {
        this.rotationZ = r100;
    }

    public final void setScaleX(float r100) {
        this.scaleX = r100;
    }

    public final void setScaleY(float r100) {
        this.scaleY = r100;
    }

    public final void setSpotShadowColor(int r100) {
        this.spotShadowColor = r100;
    }

    public final void setTranslationX(float r100) {
        this.translationX = r100;
    }

    public final void setTranslationY(float r100) {
        this.translationY = r100;
    }

    private DeviceRenderNodeData(long r100, int r101, int r102, int r103, int r104, int r110, int r111, float r112, float r113, float r114, float r115, float r116, int r117, int r118, float r119, float r210, float r211, float r212, float r213, float r214, boolean r215, boolean r216, float r217, RenderEffect r218, int r219, ColorFilter r310, int r311) {
        this.uniqueId = r100;
        this.left = r101;
        this.top = r102;
        this.right = r103;
        this.bottom = r104;
        this.width = r110;
        this.height = r111;
        this.scaleX = r112;
        this.scaleY = r113;
        this.translationX = r114;
        this.translationY = r115;
        this.elevation = r116;
        this.ambientShadowColor = r117;
        this.spotShadowColor = r118;
        this.rotationZ = r119;
        this.rotationX = r210;
        this.rotationY = r211;
        this.cameraDistance = r212;
        this.pivotX = r213;
        this.pivotY = r214;
        this.clipToOutline = r215;
        this.clipToBounds = r216;
        this.alpha = r217;
        this.renderEffect = r218;
        this.blendMode = r219;
        this.colorFilter = r310;
        this.compositingStrategy = r311;
    }
}
