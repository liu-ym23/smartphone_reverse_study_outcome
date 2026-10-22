package androidx.compose.ui.draw;

import C7.c;
import S7.k;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerScopeKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.shadow.Shadow;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a/\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001aC\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a#\u0010\u0010\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a/\u0010\u0010\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012H\u0007¢\u0006\u0004\b\u0010\u0010\u0016\u001a#\u0010\u0017\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0017\u0010\u0011\u001a/\u0010\u0017\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00140\u0012H\u0007¢\u0006\u0004\b\u0017\u0010\u0016¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/unit/Dp;", "elevation", "Landroidx/compose/ui/graphics/Shape;", "shape", "", "clip", "shadow-ziNgDLE", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Shape;Z)Landroidx/compose/ui/Modifier;", "shadow", "Landroidx/compose/ui/graphics/Color;", "ambientColor", "spotColor", "shadow-s4CzXII", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Shape;ZJJ)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/graphics/shadow/Shadow;", "dropShadow", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/shadow/Shadow;)Landroidx/compose/ui/Modifier;", "Lkotlin/Function1;", "Landroidx/compose/ui/draw/DropShadowScope;", "LC7/r;", "block", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;LS7/k;)Landroidx/compose/ui/Modifier;", "innerShadow", "Landroidx/compose/ui/draw/InnerShadowScope;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ShadowKt {
    @Stable
    public static final Modifier dropShadow(Modifier modifier, Shape shape, Shadow shadow) {
        return modifier.then(new SimpleDropShadowElement(shape, shadow));
    }

    @Stable
    public static final Modifier innerShadow(Modifier modifier, Shape shape, Shadow shadow) {
        return modifier.then(new SimpleInnerShadowElement(shape, shadow));
    }

    @Stable
    /* renamed from: shadow-s4CzXII, reason: not valid java name */
    public static final Modifier m3738shadows4CzXII(Modifier modifier, float f, Shape shape, boolean z10, long j5, long j6) {
        return (Dp.m6843compareTo0680j_4(f, Dp.m6844constructorimpl((float) 0)) > 0 || z10) ? modifier.then(new ShadowGraphicsLayerElement(f, shape, z10, j5, j6, null)) : modifier;
    }

    /* renamed from: shadow-s4CzXII$default, reason: not valid java name */
    public static /* synthetic */ Modifier m3739shadows4CzXII$default(Modifier modifier, float f, Shape shape, boolean z10, long j5, long j6, int i, Object obj) {
        boolean z11;
        Shape rectangleShape = (i & 2) != 0 ? RectangleShapeKt.getRectangleShape() : shape;
        if ((i & 4) != 0) {
            z11 = false;
            if (Dp.m6843compareTo0680j_4(f, Dp.m6844constructorimpl(0)) > 0) {
                z11 = true;
            }
        } else {
            z11 = z10;
        }
        return m3738shadows4CzXII(modifier, f, rectangleShape, z11, (i & 8) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : j5, (i & 16) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : j6);
    }

    @Stable
    @c
    /* renamed from: shadow-ziNgDLE, reason: not valid java name */
    public static final /* synthetic */ Modifier m3740shadowziNgDLE(Modifier modifier, float f, Shape shape, boolean z10) {
        return m3738shadows4CzXII(modifier, f, shape, z10, GraphicsLayerScopeKt.getDefaultShadowColor(), GraphicsLayerScopeKt.getDefaultShadowColor());
    }

    /* renamed from: shadow-ziNgDLE$default, reason: not valid java name */
    public static /* synthetic */ Modifier m3741shadowziNgDLE$default(Modifier modifier, float f, Shape shape, boolean z10, int i, Object obj) {
        if ((i & 2) != 0) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        if ((i & 4) != 0) {
            z10 = false;
            if (Dp.m6843compareTo0680j_4(f, Dp.m6844constructorimpl(0)) > 0) {
                z10 = true;
            }
        }
        return m3740shadowziNgDLE(modifier, f, shape, z10);
    }

    @Stable
    public static final Modifier dropShadow(Modifier modifier, Shape shape, k kVar) {
        return modifier.then(new BlockDropShadowElement(shape, kVar));
    }

    @Stable
    public static final Modifier innerShadow(Modifier modifier, Shape shape, k kVar) {
        return modifier.then(new BlockInnerShadowElement(shape, kVar));
    }
}
