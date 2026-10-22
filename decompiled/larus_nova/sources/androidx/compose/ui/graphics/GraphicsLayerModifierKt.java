package androidx.compose.ui.graphics;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0095\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001a¡\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001aµ\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001a¿\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007¢\u0006\u0004\b \u0010!\u001aÕ\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\"\u001a\u00020#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%H\u0007¢\u0006\u0004\b&\u0010'\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0017\u0010(\u001a\u0013\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)¢\u0006\u0002\b,H\u0007\u001a\f\u0010-\u001a\u00020\u0001*\u00020\u0001H\u0007¨\u0006."}, d2 = {"graphicsLayer", "Landroidx/compose/ui/Modifier;", LiveDegradeFpsAnimator.SCALE_X, "", LiveDegradeFpsAnimator.SCALE_Y, "alpha", LiveDegradeFpsAnimator.TRANSLATION_X, LiveDegradeFpsAnimator.TRANSLATION_Y, "shadowElevation", "rotationX", "rotationY", "rotationZ", "cameraDistance", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "shape", "Landroidx/compose/ui/graphics/Shape;", "clip", "", "graphicsLayer-sKFY_QE", "(Landroidx/compose/ui/Modifier;FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;Z)Landroidx/compose/ui/Modifier;", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "graphicsLayer-2Xn7asI", "(Landroidx/compose/ui/Modifier;FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;)Landroidx/compose/ui/Modifier;", "ambientShadowColor", "Landroidx/compose/ui/graphics/Color;", "spotShadowColor", "graphicsLayer-pANQ8Wg", "(Landroidx/compose/ui/Modifier;FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;JJ)Landroidx/compose/ui/Modifier;", "compositingStrategy", "Landroidx/compose/ui/graphics/CompositingStrategy;", "graphicsLayer-Ap8cVGQ", "(Landroidx/compose/ui/Modifier;FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;JJI)Landroidx/compose/ui/Modifier;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "graphicsLayer-_6ThJ44", "(Landroidx/compose/ui/Modifier;FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;JJIILandroidx/compose/ui/graphics/ColorFilter;)Landroidx/compose/ui/Modifier;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "toolingGraphicsLayer", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class GraphicsLayerModifierKt {
    public static final Modifier toolingGraphicsLayer(Modifier r210) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L6;
        return r210.then(m4992graphicsLayer_6ThJ44$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, false, null, 0, 0, 0, 0, null, 524287, null));
    L6:
        return r210;
    }

    public static final Modifier graphicsLayer(Modifier r100, Function1<? super GraphicsLayerScope, Unit> r101) {
        return r100.then(new BlockGraphicsLayerElement(r101));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replace with graphicsLayer that consumes an optional RenderEffect parameter and shadow color parameters", replaceWith = @ReplaceWith(expression = "Modifier.graphicsLayer(scaleX, scaleY, alpha, translationX, translationY, shadowElevation, rotationX, rotationY, rotationZ, cameraDistance, transformOrigin, shape, clip, null, DefaultShadowColor, DefaultShadowColor)", imports = {"androidx.compose.ui.graphics"}))
    /* JADX INFO: renamed from: graphicsLayer-sKFY_QE, reason: not valid java name */
    public static final /* synthetic */ Modifier m4995graphicsLayersKFY_QE(Modifier r210, float r211, float r212, float r213, float r214, float r310, float r311, float r312, float r313, float r314, float r315, long r316, Shape r317, boolean r318) {
        return m4992graphicsLayer_6ThJ44$default(r210, r211, r212, r213, r214, r310, r311, r312, r313, r314, r315, r316, r317, r318, null, 0, 0, 0, BlendMode.Companion.m4768getSrcOver0nO6VwU(), null, 114688, null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replace with graphicsLayer that consumes shadow color parameters", replaceWith = @ReplaceWith(expression = "Modifier.graphicsLayer(scaleX, scaleY, alpha, translationX, translationY, shadowElevation, rotationX, rotationY, rotationZ, cameraDistance, transformOrigin, shape, clip, null, DefaultShadowColor, DefaultShadowColor)", imports = {"androidx.compose.ui.graphics"}))
    /* JADX INFO: renamed from: graphicsLayer-2Xn7asI, reason: not valid java name */
    public static final /* synthetic */ Modifier m4987graphicsLayer2Xn7asI(Modifier r210, float r211, float r212, float r213, float r214, float r215, float r216, float r310, float r311, float r312, float r313, long r314, Shape r315, boolean r316, RenderEffect r317) {
        return m4991graphicsLayer_6ThJ44(r210, r211, r212, r213, r214, r215, r216, r310, r311, r312, r313, r314, r315, r316, r317, GraphicsLayerScopeKt.getDefaultShadowColor(), GraphicsLayerScopeKt.getDefaultShadowColor(), CompositingStrategy.Companion.m4916getAutoNrFUSI(), BlendMode.Companion.m4768getSrcOver0nO6VwU(), null);
    }

    /* JADX INFO: renamed from: graphicsLayer-sKFY_QE$default, reason: not valid java name */
    public static /* synthetic */ Modifier m4996graphicsLayersKFY_QE$default(Modifier r110, float r111, float r112, float r113, float r114, float r115, float r210, float r211, float r212, float r213, float r214, long r215, Shape r216, boolean r217, int r218, Object r310) {
        float r100 = 1.0f;
        if ((r218 & 1) == 0) goto L5;
        float r101 = 1.0f;
    L7:
        if ((r218 & 2) == 0) goto L9;
        float r102 = 1.0f;
    L11:
        if ((r218 & 4) != 0) goto L14;
        r100 = r113;
    L14:
        float r103 = 0.0f;
        if ((r218 & 8) == 0) goto L17;
        float r104 = 0.0f;
    L19:
        if ((r218 & 16) == 0) goto L21;
        float r105 = 0.0f;
    L23:
        if ((r218 & 32) == 0) goto L25;
        float r106 = 0.0f;
    L27:
        if ((r218 & 64) == 0) goto L29;
        float r107 = 0.0f;
    L31:
        if ((r218 & 128) == 0) goto L33;
        float r108 = 0.0f;
    L35:
        if ((r218 & 256) != 0) goto L39;
        r103 = r213;
    L39:
        if ((r218 & 512) == 0) goto L41;
        float r116 = 8.0f;
    L43:
        if ((r218 & 1024) == 0) goto L45;
        long r117 = TransformOrigin.Companion.m5244getCenterSzJe1aQ();
    L47:
        if ((r218 & 2048) == 0) goto L49;
        Shape r118 = RectangleShapeKt.getRectangleShape();
    L51:
        if ((r218 & 4096) == 0) goto L53;
        boolean r109 = false;
    L55:
        return m4995graphicsLayersKFY_QE(r110, r101, r102, r100, r104, r105, r106, r107, r108, r103, r116, r117, r118, r109);
    L53:
        r109 = r217;
        goto L55
    L49:
        r118 = r216;
        goto L51
    L45:
        r117 = r215;
        goto L47
    L41:
        r116 = r214;
        goto L43
    L33:
        r108 = r212;
        goto L35
    L29:
        r107 = r211;
        goto L31
    L25:
        r106 = r210;
        goto L27
    L21:
        r105 = r115;
        goto L23
    L17:
        r104 = r114;
        goto L19
    L9:
        r102 = r112;
        goto L11
    L5:
        r101 = r111;
        goto L7
    }

    /* JADX INFO: renamed from: graphicsLayer-2Xn7asI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m4988graphicsLayer2Xn7asI$default(Modifier r110, float r111, float r112, float r113, float r114, float r210, float r211, float r212, float r213, float r214, float r215, long r216, Shape r217, boolean r218, RenderEffect r310, int r311, Object r312) {
        float r100 = 1.0f;
        if ((r311 & 1) == 0) goto L5;
        float r101 = 1.0f;
    L7:
        if ((r311 & 2) == 0) goto L9;
        float r102 = 1.0f;
    L11:
        if ((r311 & 4) != 0) goto L14;
        r100 = r113;
    L14:
        float r103 = 0.0f;
        if ((r311 & 8) == 0) goto L17;
        float r104 = 0.0f;
    L19:
        if ((r311 & 16) == 0) goto L21;
        float r105 = 0.0f;
    L23:
        if ((r311 & 32) == 0) goto L25;
        float r106 = 0.0f;
    L27:
        if ((r311 & 64) == 0) goto L29;
        float r107 = 0.0f;
    L31:
        if ((r311 & 128) == 0) goto L33;
        float r108 = 0.0f;
    L35:
        if ((r311 & 256) != 0) goto L39;
        r103 = r214;
    L39:
        if ((r311 & 512) == 0) goto L41;
        float r115 = 8.0f;
    L43:
        if ((r311 & 1024) == 0) goto L45;
        long r116 = TransformOrigin.Companion.m5244getCenterSzJe1aQ();
    L47:
        if ((r311 & 2048) == 0) goto L49;
        Shape r117 = RectangleShapeKt.getRectangleShape();
    L51:
        if ((r311 & 4096) == 0) goto L53;
        boolean r118 = false;
    L55:
        if ((r311 & 8192) == 0) goto L57;
        RenderEffect r109 = null;
    L59:
        return m4987graphicsLayer2Xn7asI(r110, r101, r102, r100, r104, r105, r106, r107, r108, r103, r115, r116, r117, r118, r109);
    L57:
        r109 = r310;
        goto L59
    L53:
        r118 = r218;
        goto L55
    L49:
        r117 = r217;
        goto L51
    L45:
        r116 = r216;
        goto L47
    L41:
        r115 = r215;
        goto L43
    L33:
        r108 = r213;
        goto L35
    L29:
        r107 = r212;
        goto L31
    L25:
        r106 = r211;
        goto L27
    L21:
        r105 = r210;
        goto L23
    L17:
        r104 = r114;
        goto L19
    L9:
        r102 = r112;
        goto L11
    L5:
        r101 = r111;
        goto L7
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replace with graphicsLayer that consumes a compositing strategy", replaceWith = @ReplaceWith(expression = "Modifier.graphicsLayer(scaleX, scaleY, alpha, translationX, translationY, shadowElevation, rotationX, rotationY, rotationZ, cameraDistance, transformOrigin, shape, clip, renderEffect, ambientShadowColor, spotShadowColor, CompositingStrategy.Auto)", imports = {"androidx.compose.ui.graphics"}))
    /* JADX INFO: renamed from: graphicsLayer-pANQ8Wg, reason: not valid java name */
    public static final /* synthetic */ Modifier m4993graphicsLayerpANQ8Wg(Modifier r210, float r211, float r212, float r213, float r214, float r215, float r216, float r310, float r311, float r312, float r313, long r314, Shape r315, boolean r316, RenderEffect r317, long r318, long r410) {
        return m4991graphicsLayer_6ThJ44(r210, r211, r212, r213, r214, r215, r216, r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, CompositingStrategy.Companion.m4916getAutoNrFUSI(), BlendMode.Companion.m4768getSrcOver0nO6VwU(), null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replace with graphicsLayer that consumes a blend mode and a color filter", replaceWith = @ReplaceWith(expression = "Modifier.graphicsLayer(scaleX, scaleY, alpha, translationX, translationY, shadowElevation, rotationX, rotationY, rotationZ, cameraDistance, transformOrigin, shape, clip, renderEffect, ambientShadowColor, spotShadowColor, compositingStrategy, BlendMode.SrcOver, null)", imports = {"androidx.compose.ui.graphics"}))
    /* JADX INFO: renamed from: graphicsLayer-Ap8cVGQ, reason: not valid java name */
    public static final /* synthetic */ Modifier m4989graphicsLayerAp8cVGQ(Modifier r210, float r211, float r212, float r213, float r214, float r215, float r216, float r310, float r311, float r312, float r313, long r314, Shape r315, boolean r316, RenderEffect r317, long r318, long r410, int r411) {
        return m4991graphicsLayer_6ThJ44(r210, r211, r212, r213, r214, r215, r216, r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, BlendMode.Companion.m4768getSrcOver0nO6VwU(), null);
    }

    /* JADX INFO: renamed from: graphicsLayer-pANQ8Wg$default, reason: not valid java name */
    public static /* synthetic */ Modifier m4994graphicsLayerpANQ8Wg$default(Modifier r110, float r210, float r211, float r212, float r213, float r214, float r215, float r216, float r217, float r218, float r219, long r310, Shape r311, boolean r312, RenderEffect r313, long r314, long r315, int r316, Object r410) {
        float r100 = 1.0f;
        if ((r316 & 1) == 0) goto L5;
        float r101 = 1.0f;
    L7:
        if ((r316 & 2) == 0) goto L9;
        float r102 = 1.0f;
    L11:
        if ((r316 & 4) != 0) goto L14;
        r100 = r212;
    L14:
        float r103 = 0.0f;
        if ((r316 & 8) == 0) goto L17;
        float r104 = 0.0f;
    L19:
        if ((r316 & 16) == 0) goto L21;
        float r105 = 0.0f;
    L23:
        if ((r316 & 32) == 0) goto L25;
        float r106 = 0.0f;
    L27:
        if ((r316 & 64) == 0) goto L29;
        float r107 = 0.0f;
    L31:
        if ((r316 & 128) == 0) goto L33;
        float r108 = 0.0f;
    L35:
        if ((r316 & 256) != 0) goto L39;
        r103 = r218;
    L39:
        if ((r316 & 512) == 0) goto L41;
        float r111 = 8.0f;
    L43:
        if ((r316 & 1024) == 0) goto L45;
        long r112 = TransformOrigin.Companion.m5244getCenterSzJe1aQ();
    L47:
        if ((r316 & 2048) == 0) goto L49;
        Shape r113 = RectangleShapeKt.getRectangleShape();
    L51:
        if ((r316 & 4096) == 0) goto L53;
        boolean r114 = false;
    L55:
        if ((r316 & 8192) == 0) goto L57;
        RenderEffect r115 = null;
    L58:
        RenderEffect r317 = r115;
        if ((r316 & 16384) == 0) goto L61;
        long r116 = GraphicsLayerScopeKt.getDefaultShadowColor();
    L63:
        if ((r316 & 32768) == 0) goto L65;
        long r117 = GraphicsLayerScopeKt.getDefaultShadowColor();
    L67:
        return m4993graphicsLayerpANQ8Wg(r110, r101, r102, r100, r104, r105, r106, r107, r108, r103, r111, r112, r113, r114, r317, r116, r117);
    L65:
        r117 = r315;
        goto L67
    L61:
        r116 = r314;
        goto L63
    L57:
        r115 = r313;
        goto L58
    L53:
        r114 = r312;
        goto L55
    L49:
        r113 = r311;
        goto L51
    L45:
        r112 = r310;
        goto L47
    L41:
        r111 = r219;
        goto L43
    L33:
        r108 = r217;
        goto L35
    L29:
        r107 = r216;
        goto L31
    L25:
        r106 = r215;
        goto L27
    L21:
        r105 = r214;
        goto L23
    L17:
        r104 = r213;
        goto L19
    L9:
        r102 = r211;
        goto L11
    L5:
        r101 = r210;
        goto L7
    }

    /* JADX INFO: renamed from: graphicsLayer-Ap8cVGQ$default, reason: not valid java name */
    public static /* synthetic */ Modifier m4990graphicsLayerAp8cVGQ$default(Modifier r210, float r211, float r212, float r213, float r214, float r215, float r216, float r217, float r218, float r219, float r310, long r311, Shape r312, boolean r313, RenderEffect r314, long r315, long r316, int r410, int r411, Object r412) {
        float r100 = 1.0f;
        if ((r411 & 1) == 0) goto L5;
        float r101 = 1.0f;
    L7:
        if ((r411 & 2) == 0) goto L9;
        float r102 = 1.0f;
    L11:
        if ((r411 & 4) != 0) goto L14;
        r100 = r213;
    L14:
        float r103 = 0.0f;
        if ((r411 & 8) == 0) goto L17;
        float r104 = 0.0f;
    L19:
        if ((r411 & 16) == 0) goto L21;
        float r105 = 0.0f;
    L23:
        if ((r411 & 32) == 0) goto L25;
        float r106 = 0.0f;
    L27:
        if ((r411 & 64) == 0) goto L29;
        float r107 = 0.0f;
    L31:
        if ((r411 & 128) == 0) goto L33;
        float r108 = 0.0f;
    L35:
        if ((r411 & 256) != 0) goto L39;
        r103 = r219;
    L39:
        if ((r411 & 512) == 0) goto L41;
        float r110 = 8.0f;
    L43:
        if ((r411 & 1024) == 0) goto L45;
        long r111 = TransformOrigin.Companion.m5244getCenterSzJe1aQ();
    L47:
        if ((r411 & 2048) == 0) goto L49;
        Shape r112 = RectangleShapeKt.getRectangleShape();
    L51:
        if ((r411 & 4096) == 0) goto L53;
        boolean r113 = false;
    L55:
        if ((r411 & 8192) == 0) goto L57;
        RenderEffect r114 = null;
    L58:
        RenderEffect r317 = r114;
        if ((r411 & 16384) == 0) goto L61;
        long r115 = GraphicsLayerScopeKt.getDefaultShadowColor();
    L63:
        if ((r411 & 32768) == 0) goto L65;
        long r116 = GraphicsLayerScopeKt.getDefaultShadowColor();
    L67:
        if ((r411 & 65536) == 0) goto L69;
        int r109 = CompositingStrategy.Companion.m4916getAutoNrFUSI();
    L71:
        return m4989graphicsLayerAp8cVGQ(r210, r101, r102, r100, r104, r105, r106, r107, r108, r103, r110, r111, r112, r113, r317, r115, r116, r109);
    L69:
        r109 = r410;
        goto L71
    L65:
        r116 = r316;
        goto L67
    L61:
        r115 = r315;
        goto L63
    L57:
        r114 = r314;
        goto L58
    L53:
        r113 = r313;
        goto L55
    L49:
        r112 = r312;
        goto L51
    L45:
        r111 = r311;
        goto L47
    L41:
        r110 = r310;
        goto L43
    L33:
        r108 = r218;
        goto L35
    L29:
        r107 = r217;
        goto L31
    L25:
        r106 = r216;
        goto L27
    L21:
        r105 = r215;
        goto L23
    L17:
        r104 = r214;
        goto L19
    L9:
        r102 = r212;
        goto L11
    L5:
        r101 = r211;
        goto L7
    }

    /* JADX INFO: renamed from: graphicsLayer-_6ThJ44, reason: not valid java name */
    public static final Modifier m4991graphicsLayer_6ThJ44(Modifier r210, float r211, float r212, float r213, float r214, float r215, float r310, float r311, float r312, float r313, float r314, long r315, Shape r316, boolean r317, RenderEffect r318, long r410, long r411, int r412, int r413, ColorFilter r414) {
        return r210.then(new GraphicsLayerElement(r211, r212, r213, r214, r215, r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r412, r413, r414, null));
    }

    /* JADX INFO: renamed from: graphicsLayer-_6ThJ44$default, reason: not valid java name */
    public static /* synthetic */ Modifier m4992graphicsLayer_6ThJ44$default(Modifier r210, float r211, float r212, float r213, float r214, float r215, float r216, float r310, float r311, float r312, float r313, long r314, Shape r315, boolean r316, RenderEffect r317, long r318, long r410, int r411, int r412, ColorFilter r413, int r414, Object r415) {
        float r100 = 1.0f;
        if ((r414 & 1) == 0) goto L5;
        float r101 = 1.0f;
    L7:
        if ((r414 & 2) == 0) goto L9;
        float r102 = 1.0f;
    L11:
        if ((r414 & 4) != 0) goto L14;
        r100 = r213;
    L14:
        float r103 = 0.0f;
        if ((r414 & 8) == 0) goto L17;
        float r104 = 0.0f;
    L19:
        if ((r414 & 16) == 0) goto L21;
        float r105 = 0.0f;
    L23:
        if ((r414 & 32) == 0) goto L25;
        float r106 = 0.0f;
    L27:
        if ((r414 & 64) == 0) goto L29;
        float r107 = 0.0f;
    L31:
        if ((r414 & 128) == 0) goto L33;
        float r108 = 0.0f;
    L35:
        if ((r414 & 256) != 0) goto L39;
        r103 = r312;
    L39:
        if ((r414 & 512) == 0) goto L41;
        float r110 = 8.0f;
    L43:
        if ((r414 & 1024) == 0) goto L45;
        long r111 = TransformOrigin.Companion.m5244getCenterSzJe1aQ();
    L47:
        if ((r414 & 2048) == 0) goto L49;
        Shape r112 = RectangleShapeKt.getRectangleShape();
    L51:
        if ((r414 & 4096) == 0) goto L53;
        boolean r113 = false;
    L54:
        ColorFilter r114 = null;
        if ((r414 & 8192) == 0) goto L57;
        RenderEffect r115 = null;
    L58:
        RenderEffect r319 = r115;
        if ((r414 & 16384) == 0) goto L61;
        long r116 = GraphicsLayerScopeKt.getDefaultShadowColor();
    L63:
        if ((32768 & r414) == 0) goto L65;
        long r117 = GraphicsLayerScopeKt.getDefaultShadowColor();
    L67:
        if ((65536 & r414) == 0) goto L69;
        int r118 = CompositingStrategy.Companion.m4916getAutoNrFUSI();
    L71:
        if ((r414 & 131072) == 0) goto L73;
        int r217 = BlendMode.Companion.m4768getSrcOver0nO6VwU();
    L75:
        if ((r414 & 262144) != 0) goto L79;
        r114 = r413;
    L79:
        return m4991graphicsLayer_6ThJ44(r210, r101, r102, r100, r104, r105, r106, r107, r108, r103, r110, r111, r112, r113, r319, r116, r117, r118, r217, r114);
    L73:
        r217 = r412;
        goto L75
    L69:
        r118 = r411;
        goto L71
    L65:
        r117 = r410;
        goto L67
    L61:
        r116 = r318;
        goto L63
    L57:
        r115 = r317;
        goto L58
    L53:
        r113 = r316;
        goto L54
    L49:
        r112 = r315;
        goto L51
    L45:
        r111 = r314;
        goto L47
    L41:
        r110 = r313;
        goto L43
    L33:
        r108 = r311;
        goto L35
    L29:
        r107 = r310;
        goto L31
    L25:
        r106 = r216;
        goto L27
    L21:
        r105 = r215;
        goto L23
    L17:
        r104 = r214;
        goto L19
    L9:
        r102 = r212;
        goto L11
    L5:
        r101 = r211;
        goto L7
    }
}
