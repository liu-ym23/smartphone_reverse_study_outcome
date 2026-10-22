package androidx.compose.ui.graphics;

import C7.c;
import S7.k;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0095\u0001\u0010\u0014\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a¡\u0001\u0010\u0014\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001aµ\u0001\u0010\u0014\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001a¿\u0001\u0010\u0014\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001f\u001a\u00020\u001eH\u0007¢\u0006\u0004\b \u0010!\u001aÕ\u0001\u0010\u0014\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010#\u001a\u00020\"2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$H\u0007¢\u0006\u0004\b&\u0010'\u001a'\u0010\u0014\u001a\u00020\u0000*\u00020\u00002\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*0(H\u0007¢\u0006\u0004\b\u0014\u0010,\u001a\u0013\u0010-\u001a\u00020\u0000*\u00020\u0000H\u0007¢\u0006\u0004\b-\u0010.¨\u0006/"}, d2 = {"Landroidx/compose/ui/Modifier;", "", "scaleX", "scaleY", "alpha", "translationX", "translationY", "shadowElevation", "rotationX", "rotationY", "rotationZ", "cameraDistance", "Landroidx/compose/ui/graphics/TransformOrigin;", "transformOrigin", "Landroidx/compose/ui/graphics/Shape;", "shape", "", "clip", "graphicsLayer-sKFY_QE", "(Landroidx/compose/ui/Modifier;FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;Z)Landroidx/compose/ui/Modifier;", "graphicsLayer", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "graphicsLayer-2Xn7asI", "(Landroidx/compose/ui/Modifier;FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/graphics/Color;", "ambientShadowColor", "spotShadowColor", "graphicsLayer-pANQ8Wg", "(Landroidx/compose/ui/Modifier;FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;JJ)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/graphics/CompositingStrategy;", "compositingStrategy", "graphicsLayer-Ap8cVGQ", "(Landroidx/compose/ui/Modifier;FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;JJI)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "graphicsLayer-_6ThJ44", "(Landroidx/compose/ui/Modifier;FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;JJIILandroidx/compose/ui/graphics/ColorFilter;)Landroidx/compose/ui/Modifier;", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "LC7/r;", "block", "(Landroidx/compose/ui/Modifier;LS7/k;)Landroidx/compose/ui/Modifier;", "toolingGraphicsLayer", "(Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GraphicsLayerModifierKt {
    @Stable
    public static final Modifier graphicsLayer(Modifier modifier, k kVar) {
        return modifier.then(new BlockGraphicsLayerElement(kVar));
    }

    @Stable
    @c
    /* renamed from: graphicsLayer-2Xn7asI, reason: not valid java name */
    public static final /* synthetic */ Modifier m4299graphicsLayer2Xn7asI(Modifier modifier, float f, float f7, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, long j5, Shape shape, boolean z10, RenderEffect renderEffect) {
        return m4303graphicsLayer_6ThJ44(modifier, f, f7, f9, f10, f11, f12, f13, f14, f15, f16, j5, shape, z10, renderEffect, GraphicsLayerScopeKt.getDefaultShadowColor(), GraphicsLayerScopeKt.getDefaultShadowColor(), CompositingStrategy.INSTANCE.m4228getAutoNrFUSI(), BlendMode.INSTANCE.m4080getSrcOver0nO6VwU(), null);
    }

    @Stable
    @c
    /* renamed from: graphicsLayer-Ap8cVGQ, reason: not valid java name */
    public static final /* synthetic */ Modifier m4301graphicsLayerAp8cVGQ(Modifier modifier, float f, float f7, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, long j5, Shape shape, boolean z10, RenderEffect renderEffect, long j6, long j10, int i) {
        return m4303graphicsLayer_6ThJ44(modifier, f, f7, f9, f10, f11, f12, f13, f14, f15, f16, j5, shape, z10, renderEffect, j6, j10, i, BlendMode.INSTANCE.m4080getSrcOver0nO6VwU(), null);
    }

    @Stable
    /* renamed from: graphicsLayer-_6ThJ44, reason: not valid java name */
    public static final Modifier m4303graphicsLayer_6ThJ44(Modifier modifier, float f, float f7, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, long j5, Shape shape, boolean z10, RenderEffect renderEffect, long j6, long j10, int i, int i6, ColorFilter colorFilter) {
        return modifier.then(new GraphicsLayerElement(f, f7, f9, f10, f11, f12, f13, f14, f15, f16, j5, shape, z10, renderEffect, j6, j10, i, i6, colorFilter, null));
    }

    /* renamed from: graphicsLayer-_6ThJ44$default, reason: not valid java name */
    public static /* synthetic */ Modifier m4304graphicsLayer_6ThJ44$default(Modifier modifier, float f, float f7, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, long j5, Shape shape, boolean z10, RenderEffect renderEffect, long j6, long j10, int i, int i6, ColorFilter colorFilter, int i10, Object obj) {
        return m4303graphicsLayer_6ThJ44(modifier, (i10 & 1) != 0 ? 1.0f : f, (i10 & 2) != 0 ? 1.0f : f7, (i10 & 4) == 0 ? f9 : 1.0f, (i10 & 8) != 0 ? 0.0f : f10, (i10 & 16) != 0 ? 0.0f : f11, (i10 & 32) != 0 ? 0.0f : f12, (i10 & 64) != 0 ? 0.0f : f13, (i10 & 128) != 0 ? 0.0f : f14, (i10 & 256) == 0 ? f15 : 0.0f, (i10 & 512) != 0 ? 8.0f : f16, (i10 & 1024) != 0 ? TransformOrigin.INSTANCE.m4546getCenterSzJe1aQ() : j5, (i10 & 2048) != 0 ? RectangleShapeKt.getRectangleShape() : shape, (i10 & 4096) != 0 ? false : z10, (i10 & 8192) != 0 ? null : renderEffect, (i10 & 16384) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : j6, (32768 & i10) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : j10, (65536 & i10) != 0 ? CompositingStrategy.INSTANCE.m4228getAutoNrFUSI() : i, (i10 & 131072) != 0 ? BlendMode.INSTANCE.m4080getSrcOver0nO6VwU() : i6, (i10 & 262144) != 0 ? null : colorFilter);
    }

    @Stable
    @c
    /* renamed from: graphicsLayer-pANQ8Wg, reason: not valid java name */
    public static final /* synthetic */ Modifier m4305graphicsLayerpANQ8Wg(Modifier modifier, float f, float f7, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, long j5, Shape shape, boolean z10, RenderEffect renderEffect, long j6, long j10) {
        return m4303graphicsLayer_6ThJ44(modifier, f, f7, f9, f10, f11, f12, f13, f14, f15, f16, j5, shape, z10, renderEffect, j6, j10, CompositingStrategy.INSTANCE.m4228getAutoNrFUSI(), BlendMode.INSTANCE.m4080getSrcOver0nO6VwU(), null);
    }

    @Stable
    @c
    /* renamed from: graphicsLayer-sKFY_QE, reason: not valid java name */
    public static final /* synthetic */ Modifier m4307graphicsLayersKFY_QE(Modifier modifier, float f, float f7, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, long j5, Shape shape, boolean z10) {
        return m4304graphicsLayer_6ThJ44$default(modifier, f, f7, f9, f10, f11, f12, f13, f14, f15, f16, j5, shape, z10, null, 0L, 0L, 0, BlendMode.INSTANCE.m4080getSrcOver0nO6VwU(), null, 114688, null);
    }

    /* renamed from: graphicsLayer-sKFY_QE$default, reason: not valid java name */
    public static /* synthetic */ Modifier m4308graphicsLayersKFY_QE$default(Modifier modifier, float f, float f7, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, long j5, Shape shape, boolean z10, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        return m4307graphicsLayersKFY_QE(modifier, f, (i & 2) != 0 ? 1.0f : f7, (i & 4) == 0 ? f9 : 1.0f, (i & 8) != 0 ? 0.0f : f10, (i & 16) != 0 ? 0.0f : f11, (i & 32) != 0 ? 0.0f : f12, (i & 64) != 0 ? 0.0f : f13, (i & 128) != 0 ? 0.0f : f14, (i & 256) == 0 ? f15 : 0.0f, (i & 512) != 0 ? 8.0f : f16, (i & 1024) != 0 ? TransformOrigin.INSTANCE.m4546getCenterSzJe1aQ() : j5, (i & 2048) != 0 ? RectangleShapeKt.getRectangleShape() : shape, (i & 4096) != 0 ? false : z10);
    }

    @Stable
    public static final Modifier toolingGraphicsLayer(Modifier modifier) {
        return InspectableValueKt.isDebugInspectorInfoEnabled() ? modifier.then(m4304graphicsLayer_6ThJ44$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 0, null, 524287, null)) : modifier;
    }
}
