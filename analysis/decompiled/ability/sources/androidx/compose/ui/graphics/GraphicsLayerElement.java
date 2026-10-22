package androidx.compose.ui.graphics;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u001e\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B£\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0002H\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020\u0002H\u0016¢\u0006\u0004\b%\u0010&J\u0013\u0010(\u001a\u00020$*\u00020'H\u0016¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b,\u0010+J\u0010\u0010-\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b-\u0010+J\u0010\u0010.\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b.\u0010+J\u0010\u0010/\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b/\u0010+J\u0010\u00100\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b0\u0010+J\u0010\u00101\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b1\u0010+J\u0010\u00102\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b2\u0010+J\u0010\u00103\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b3\u0010+J\u0010\u00104\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b4\u0010+J\u0010\u00107\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b5\u00106J\u0010\u00108\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b8\u00109J\u0010\u0010:\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b:\u0010;J\u0012\u0010<\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b<\u0010=J\u0010\u0010?\u001a\u00020\u0016HÆ\u0003¢\u0006\u0004\b>\u00106J\u0010\u0010A\u001a\u00020\u0016HÆ\u0003¢\u0006\u0004\b@\u00106J\u0010\u0010D\u001a\u00020\u0019HÆ\u0003¢\u0006\u0004\bB\u0010CJ\u0010\u0010F\u001a\u00020\u001bHÆ\u0003¢\u0006\u0004\bE\u0010CJ\u0012\u0010G\u001a\u0004\u0018\u00010\u001dHÆ\u0003¢\u0006\u0004\bG\u0010HJÒ\u0001\u0010K\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00162\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÆ\u0001¢\u0006\u0004\bI\u0010JJ\u0010\u0010M\u001a\u00020LHÖ\u0001¢\u0006\u0004\bM\u0010NJ\u0010\u0010P\u001a\u00020OHÖ\u0001¢\u0006\u0004\bP\u0010CJ\u001a\u0010S\u001a\u00020\u00122\b\u0010R\u001a\u0004\u0018\u00010QHÖ\u0003¢\u0006\u0004\bS\u0010TR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010U\u001a\u0004\bV\u0010+R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010U\u001a\u0004\bW\u0010+R\u0017\u0010\u0006\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0006\u0010U\u001a\u0004\bX\u0010+R\u0017\u0010\u0007\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0007\u0010U\u001a\u0004\bY\u0010+R\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\b\u0010U\u001a\u0004\bZ\u0010+R\u0017\u0010\t\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\t\u0010U\u001a\u0004\b[\u0010+R\u0017\u0010\n\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\n\u0010U\u001a\u0004\b\\\u0010+R\u0017\u0010\u000b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u000b\u0010U\u001a\u0004\b]\u0010+R\u0017\u0010\f\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\f\u0010U\u001a\u0004\b^\u0010+R\u0017\u0010\r\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\r\u0010U\u001a\u0004\b_\u0010+R\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010`\u001a\u0004\ba\u00106R\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010b\u001a\u0004\bc\u00109R\u0017\u0010\u0013\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010d\u001a\u0004\be\u0010;R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010f\u001a\u0004\bg\u0010=R\u0017\u0010\u0017\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010`\u001a\u0004\bh\u00106R\u0017\u0010\u0018\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\b\u0018\u0010`\u001a\u0004\bi\u00106R\u0017\u0010\u001a\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010j\u001a\u0004\bk\u0010CR\u0017\u0010\u001c\u001a\u00020\u001b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010j\u001a\u0004\bl\u0010CR\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010m\u001a\u0004\bn\u0010H¨\u0006o"}, d2 = {"Landroidx/compose/ui/graphics/GraphicsLayerElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/graphics/SimpleGraphicsLayerModifier;", "", "scaleX", "scaleY", "alpha", "translationX", "translationY", "shadowElevation", "rotationX", "rotationY", "rotationZ", "cameraDistance", "Landroidx/compose/ui/graphics/TransformOrigin;", "transformOrigin", "Landroidx/compose/ui/graphics/Shape;", "shape", "", "clip", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "Landroidx/compose/ui/graphics/Color;", "ambientShadowColor", "spotShadowColor", "Landroidx/compose/ui/graphics/CompositingStrategy;", "compositingStrategy", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", AppAgent.CONSTRUCT, "(FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;JJIILandroidx/compose/ui/graphics/ColorFilter;Lkotlin/jvm/internal/e;)V", "create", "()Landroidx/compose/ui/graphics/SimpleGraphicsLayerModifier;", "node", "LC7/r;", "update", "(Landroidx/compose/ui/graphics/SimpleGraphicsLayerModifier;)V", "Landroidx/compose/ui/platform/InspectorInfo;", "inspectableProperties", "(Landroidx/compose/ui/platform/InspectorInfo;)V", "component1", "()F", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11-SzJe1aQ", "()J", "component11", "component12", "()Landroidx/compose/ui/graphics/Shape;", "component13", "()Z", "component14", "()Landroidx/compose/ui/graphics/RenderEffect;", "component15-0d7_KjU", "component15", "component16-0d7_KjU", "component16", "component17--NrFUSI", "()I", "component17", "component18-0nO6VwU", "component18", "component19", "()Landroidx/compose/ui/graphics/ColorFilter;", "copy-cp5nf6A", "(FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;JJIILandroidx/compose/ui/graphics/ColorFilter;)Landroidx/compose/ui/graphics/GraphicsLayerElement;", "copy", "", "toString", "()Ljava/lang/String;", "", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "F", "getScaleX", "getScaleY", "getAlpha", "getTranslationX", "getTranslationY", "getShadowElevation", "getRotationX", "getRotationY", "getRotationZ", "getCameraDistance", "J", "getTransformOrigin-SzJe1aQ", "Landroidx/compose/ui/graphics/Shape;", "getShape", "Z", "getClip", "Landroidx/compose/ui/graphics/RenderEffect;", "getRenderEffect", "getAmbientShadowColor-0d7_KjU", "getSpotShadowColor-0d7_KjU", "I", "getCompositingStrategy--NrFUSI", "getBlendMode-0nO6VwU", "Landroidx/compose/ui/graphics/ColorFilter;", "getColorFilter", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final /* data */ class GraphicsLayerElement extends ModifierNodeElement<SimpleGraphicsLayerModifier> {
    private final float alpha;
    private final long ambientShadowColor;
    private final int blendMode;
    private final float cameraDistance;
    private final boolean clip;
    private final ColorFilter colorFilter;
    private final int compositingStrategy;
    private final RenderEffect renderEffect;
    private final float rotationX;
    private final float rotationY;
    private final float rotationZ;
    private final float scaleX;
    private final float scaleY;
    private final float shadowElevation;
    private final Shape shape;
    private final long spotShadowColor;
    private final long transformOrigin;
    private final float translationX;
    private final float translationY;

    public /* synthetic */ GraphicsLayerElement(float f, float f7, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, long j5, Shape shape, boolean z10, RenderEffect renderEffect, long j6, long j10, int i, int i6, ColorFilter colorFilter, e eVar) {
        this(f, f7, f9, f10, f11, f12, f13, f14, f15, f16, j5, shape, z10, renderEffect, j6, j10, i, i6, colorFilter);
    }

    /* renamed from: copy-cp5nf6A$default, reason: not valid java name */
    public static /* synthetic */ GraphicsLayerElement m4287copycp5nf6A$default(GraphicsLayerElement graphicsLayerElement, float f, float f7, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, long j5, Shape shape, boolean z10, RenderEffect renderEffect, long j6, long j10, int i, int i6, ColorFilter colorFilter, int i10, Object obj) {
        ColorFilter colorFilter2;
        int i11;
        float f17 = (i10 & 1) != 0 ? graphicsLayerElement.scaleX : f;
        float f18 = (i10 & 2) != 0 ? graphicsLayerElement.scaleY : f7;
        float f19 = (i10 & 4) != 0 ? graphicsLayerElement.alpha : f9;
        float f20 = (i10 & 8) != 0 ? graphicsLayerElement.translationX : f10;
        float f21 = (i10 & 16) != 0 ? graphicsLayerElement.translationY : f11;
        float f22 = (i10 & 32) != 0 ? graphicsLayerElement.shadowElevation : f12;
        float f23 = (i10 & 64) != 0 ? graphicsLayerElement.rotationX : f13;
        float f24 = (i10 & 128) != 0 ? graphicsLayerElement.rotationY : f14;
        float f25 = (i10 & 256) != 0 ? graphicsLayerElement.rotationZ : f15;
        float f26 = (i10 & 512) != 0 ? graphicsLayerElement.cameraDistance : f16;
        long j11 = (i10 & 1024) != 0 ? graphicsLayerElement.transformOrigin : j5;
        Shape shape2 = (i10 & 2048) != 0 ? graphicsLayerElement.shape : shape;
        boolean z11 = (i10 & 4096) != 0 ? graphicsLayerElement.clip : z10;
        float f27 = f17;
        RenderEffect renderEffect2 = (i10 & 8192) != 0 ? graphicsLayerElement.renderEffect : renderEffect;
        long j12 = (i10 & 16384) != 0 ? graphicsLayerElement.ambientShadowColor : j6;
        long j13 = (i10 & 32768) != 0 ? graphicsLayerElement.spotShadowColor : j10;
        int i12 = (i10 & 65536) != 0 ? graphicsLayerElement.compositingStrategy : i;
        int i13 = (i10 & 131072) != 0 ? graphicsLayerElement.blendMode : i6;
        if ((i10 & 262144) != 0) {
            i11 = i12;
            colorFilter2 = graphicsLayerElement.colorFilter;
        } else {
            colorFilter2 = colorFilter;
            i11 = i12;
        }
        return graphicsLayerElement.m4293copycp5nf6A(f27, f18, f19, f20, f21, f22, f23, f24, f25, f26, j11, shape2, z11, renderEffect2, j12, j13, i11, i13, colorFilter2);
    }

    /* renamed from: component1, reason: from getter */
    public final float getScaleX() {
        return this.scaleX;
    }

    /* renamed from: component10, reason: from getter */
    public final float getCameraDistance() {
        return this.cameraDistance;
    }

    /* renamed from: component11-SzJe1aQ, reason: not valid java name and from getter */
    public final long getTransformOrigin() {
        return this.transformOrigin;
    }

    /* renamed from: component12, reason: from getter */
    public final Shape getShape() {
        return this.shape;
    }

    /* renamed from: component13, reason: from getter */
    public final boolean getClip() {
        return this.clip;
    }

    /* renamed from: component14, reason: from getter */
    public final RenderEffect getRenderEffect() {
        return this.renderEffect;
    }

    /* renamed from: component15-0d7_KjU, reason: not valid java name and from getter */
    public final long getAmbientShadowColor() {
        return this.ambientShadowColor;
    }

    /* renamed from: component16-0d7_KjU, reason: not valid java name and from getter */
    public final long getSpotShadowColor() {
        return this.spotShadowColor;
    }

    /* renamed from: component17--NrFUSI, reason: not valid java name and from getter */
    public final int getCompositingStrategy() {
        return this.compositingStrategy;
    }

    /* renamed from: component18-0nO6VwU, reason: not valid java name and from getter */
    public final int getBlendMode() {
        return this.blendMode;
    }

    /* renamed from: component19, reason: from getter */
    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    /* renamed from: component2, reason: from getter */
    public final float getScaleY() {
        return this.scaleY;
    }

    /* renamed from: component3, reason: from getter */
    public final float getAlpha() {
        return this.alpha;
    }

    /* renamed from: component4, reason: from getter */
    public final float getTranslationX() {
        return this.translationX;
    }

    /* renamed from: component5, reason: from getter */
    public final float getTranslationY() {
        return this.translationY;
    }

    /* renamed from: component6, reason: from getter */
    public final float getShadowElevation() {
        return this.shadowElevation;
    }

    /* renamed from: component7, reason: from getter */
    public final float getRotationX() {
        return this.rotationX;
    }

    /* renamed from: component8, reason: from getter */
    public final float getRotationY() {
        return this.rotationY;
    }

    /* renamed from: component9, reason: from getter */
    public final float getRotationZ() {
        return this.rotationZ;
    }

    /* renamed from: copy-cp5nf6A, reason: not valid java name */
    public final GraphicsLayerElement m4293copycp5nf6A(float scaleX, float scaleY, float alpha, float translationX, float translationY, float shadowElevation, float rotationX, float rotationY, float rotationZ, float cameraDistance, long transformOrigin, Shape shape, boolean clip, RenderEffect renderEffect, long ambientShadowColor, long spotShadowColor, int compositingStrategy, int blendMode, ColorFilter colorFilter) {
        return new GraphicsLayerElement(scaleX, scaleY, alpha, translationX, translationY, shadowElevation, rotationX, rotationY, rotationZ, cameraDistance, transformOrigin, shape, clip, renderEffect, ambientShadowColor, spotShadowColor, compositingStrategy, blendMode, colorFilter, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GraphicsLayerElement)) {
            return false;
        }
        GraphicsLayerElement graphicsLayerElement = (GraphicsLayerElement) other;
        return Float.compare(this.scaleX, graphicsLayerElement.scaleX) == 0 && Float.compare(this.scaleY, graphicsLayerElement.scaleY) == 0 && Float.compare(this.alpha, graphicsLayerElement.alpha) == 0 && Float.compare(this.translationX, graphicsLayerElement.translationX) == 0 && Float.compare(this.translationY, graphicsLayerElement.translationY) == 0 && Float.compare(this.shadowElevation, graphicsLayerElement.shadowElevation) == 0 && Float.compare(this.rotationX, graphicsLayerElement.rotationX) == 0 && Float.compare(this.rotationY, graphicsLayerElement.rotationY) == 0 && Float.compare(this.rotationZ, graphicsLayerElement.rotationZ) == 0 && Float.compare(this.cameraDistance, graphicsLayerElement.cameraDistance) == 0 && TransformOrigin.m4540equalsimpl0(this.transformOrigin, graphicsLayerElement.transformOrigin) && k.b(this.shape, graphicsLayerElement.shape) && this.clip == graphicsLayerElement.clip && k.b(this.renderEffect, graphicsLayerElement.renderEffect) && Color.m4140equalsimpl0(this.ambientShadowColor, graphicsLayerElement.ambientShadowColor) && Color.m4140equalsimpl0(this.spotShadowColor, graphicsLayerElement.spotShadowColor) && CompositingStrategy.m4224equalsimpl0(this.compositingStrategy, graphicsLayerElement.compositingStrategy) && BlendMode.m4049equalsimpl0(this.blendMode, graphicsLayerElement.blendMode) && k.b(this.colorFilter, graphicsLayerElement.colorFilter);
    }

    public final float getAlpha() {
        return this.alpha;
    }

    /* renamed from: getAmbientShadowColor-0d7_KjU, reason: not valid java name */
    public final long m4294getAmbientShadowColor0d7_KjU() {
        return this.ambientShadowColor;
    }

    /* renamed from: getBlendMode-0nO6VwU, reason: not valid java name */
    public final int m4295getBlendMode0nO6VwU() {
        return this.blendMode;
    }

    public final float getCameraDistance() {
        return this.cameraDistance;
    }

    public final boolean getClip() {
        return this.clip;
    }

    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    /* renamed from: getCompositingStrategy--NrFUSI, reason: not valid java name */
    public final int m4296getCompositingStrategyNrFUSI() {
        return this.compositingStrategy;
    }

    public final RenderEffect getRenderEffect() {
        return this.renderEffect;
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

    public final float getShadowElevation() {
        return this.shadowElevation;
    }

    public final Shape getShape() {
        return this.shape;
    }

    /* renamed from: getSpotShadowColor-0d7_KjU, reason: not valid java name */
    public final long m4297getSpotShadowColor0d7_KjU() {
        return this.spotShadowColor;
    }

    /* renamed from: getTransformOrigin-SzJe1aQ, reason: not valid java name */
    public final long m4298getTransformOriginSzJe1aQ() {
        return this.transformOrigin;
    }

    public final float getTranslationX() {
        return this.translationX;
    }

    public final float getTranslationY() {
        return this.translationY;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int iD = androidx.appfunctions.metadata.a.d((this.shape.hashCode() + ((TransformOrigin.m4543hashCodeimpl(this.transformOrigin) + androidx.appfunctions.metadata.a.b(this.cameraDistance, androidx.appfunctions.metadata.a.b(this.rotationZ, androidx.appfunctions.metadata.a.b(this.rotationY, androidx.appfunctions.metadata.a.b(this.rotationX, androidx.appfunctions.metadata.a.b(this.shadowElevation, androidx.appfunctions.metadata.a.b(this.translationY, androidx.appfunctions.metadata.a.b(this.translationX, androidx.appfunctions.metadata.a.b(this.alpha, androidx.appfunctions.metadata.a.b(this.scaleY, Float.hashCode(this.scaleX) * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31)) * 31)) * 31, 31, this.clip);
        RenderEffect renderEffect = this.renderEffect;
        int iM4050hashCodeimpl = (BlendMode.m4050hashCodeimpl(this.blendMode) + ((CompositingStrategy.m4225hashCodeimpl(this.compositingStrategy) + androidx.compose.foundation.b.c(androidx.compose.foundation.b.c((iD + (renderEffect == null ? 0 : renderEffect.hashCode())) * 31, 31, this.ambientShadowColor), 31, this.spotShadowColor)) * 31)) * 31;
        ColorFilter colorFilter = this.colorFilter;
        return iM4050hashCodeimpl + (colorFilter != null ? colorFilter.hashCode() : 0);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("graphicsLayer");
        inspectorInfo.getProperties().set("scaleX", Float.valueOf(this.scaleX));
        inspectorInfo.getProperties().set("scaleY", Float.valueOf(this.scaleY));
        inspectorInfo.getProperties().set("alpha", Float.valueOf(this.alpha));
        inspectorInfo.getProperties().set("translationX", Float.valueOf(this.translationX));
        inspectorInfo.getProperties().set("translationY", Float.valueOf(this.translationY));
        inspectorInfo.getProperties().set("shadowElevation", Float.valueOf(this.shadowElevation));
        inspectorInfo.getProperties().set("rotationX", Float.valueOf(this.rotationX));
        inspectorInfo.getProperties().set("rotationY", Float.valueOf(this.rotationY));
        inspectorInfo.getProperties().set("rotationZ", Float.valueOf(this.rotationZ));
        inspectorInfo.getProperties().set("cameraDistance", Float.valueOf(this.cameraDistance));
        inspectorInfo.getProperties().set("transformOrigin", TransformOrigin.m4533boximpl(this.transformOrigin));
        inspectorInfo.getProperties().set("shape", this.shape);
        androidx.compose.foundation.b.k(this.clip, inspectorInfo.getProperties(), "clip", inspectorInfo).set("renderEffect", this.renderEffect);
        inspectorInfo.getProperties().set("ambientShadowColor", Color.m4129boximpl(this.ambientShadowColor));
        inspectorInfo.getProperties().set("spotShadowColor", Color.m4129boximpl(this.spotShadowColor));
        inspectorInfo.getProperties().set("compositingStrategy", CompositingStrategy.m4221boximpl(this.compositingStrategy));
        inspectorInfo.getProperties().set("blendMode", BlendMode.m4046boximpl(this.blendMode));
        inspectorInfo.getProperties().set("colorFilter", this.colorFilter);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GraphicsLayerElement(scaleX=");
        sb.append(this.scaleX);
        sb.append(", scaleY=");
        sb.append(this.scaleY);
        sb.append(", alpha=");
        sb.append(this.alpha);
        sb.append(", translationX=");
        sb.append(this.translationX);
        sb.append(", translationY=");
        sb.append(this.translationY);
        sb.append(", shadowElevation=");
        sb.append(this.shadowElevation);
        sb.append(", rotationX=");
        sb.append(this.rotationX);
        sb.append(", rotationY=");
        sb.append(this.rotationY);
        sb.append(", rotationZ=");
        sb.append(this.rotationZ);
        sb.append(", cameraDistance=");
        sb.append(this.cameraDistance);
        sb.append(", transformOrigin=");
        sb.append((Object) TransformOrigin.m4544toStringimpl(this.transformOrigin));
        sb.append(", shape=");
        sb.append(this.shape);
        sb.append(", clip=");
        sb.append(this.clip);
        sb.append(", renderEffect=");
        sb.append(this.renderEffect);
        sb.append(", ambientShadowColor=");
        androidx.compose.foundation.b.z(this.ambientShadowColor, ", spotShadowColor=", sb);
        androidx.compose.foundation.b.z(this.spotShadowColor, ", compositingStrategy=", sb);
        sb.append((Object) CompositingStrategy.m4226toStringimpl(this.compositingStrategy));
        sb.append(", blendMode=");
        sb.append((Object) BlendMode.m4051toStringimpl(this.blendMode));
        sb.append(", colorFilter=");
        sb.append(this.colorFilter);
        sb.append(')');
        return sb.toString();
    }

    private GraphicsLayerElement(float f, float f7, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, long j5, Shape shape, boolean z10, RenderEffect renderEffect, long j6, long j10, int i, int i6, ColorFilter colorFilter) {
        this.scaleX = f;
        this.scaleY = f7;
        this.alpha = f9;
        this.translationX = f10;
        this.translationY = f11;
        this.shadowElevation = f12;
        this.rotationX = f13;
        this.rotationY = f14;
        this.rotationZ = f15;
        this.cameraDistance = f16;
        this.transformOrigin = j5;
        this.shape = shape;
        this.clip = z10;
        this.renderEffect = renderEffect;
        this.ambientShadowColor = j6;
        this.spotShadowColor = j10;
        this.compositingStrategy = i;
        this.blendMode = i6;
        this.colorFilter = colorFilter;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* renamed from: create */
    public SimpleGraphicsLayerModifier getNode() {
        return new SimpleGraphicsLayerModifier(this.scaleX, this.scaleY, this.alpha, this.translationX, this.translationY, this.shadowElevation, this.rotationX, this.rotationY, this.rotationZ, this.cameraDistance, this.transformOrigin, this.shape, this.clip, this.renderEffect, this.ambientShadowColor, this.spotShadowColor, this.compositingStrategy, this.blendMode, this.colorFilter, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(SimpleGraphicsLayerModifier node) {
        node.setScaleX(this.scaleX);
        node.setScaleY(this.scaleY);
        node.setAlpha(this.alpha);
        node.setTranslationX(this.translationX);
        node.setTranslationY(this.translationY);
        node.setShadowElevation(this.shadowElevation);
        node.setRotationX(this.rotationX);
        node.setRotationY(this.rotationY);
        node.setRotationZ(this.rotationZ);
        node.setCameraDistance(this.cameraDistance);
        node.m4489setTransformOrigin__ExYCQ(this.transformOrigin);
        node.setShape(this.shape);
        node.setClip(this.clip);
        node.setRenderEffect(this.renderEffect);
        node.m4485setAmbientShadowColor8_81llA(this.ambientShadowColor);
        node.m4488setSpotShadowColor8_81llA(this.spotShadowColor);
        node.m4487setCompositingStrategyaDBOjCE(this.compositingStrategy);
        node.m4486setBlendModes9anfk8(this.blendMode);
        node.setColorFilter(this.colorFilter);
        node.invalidateLayerBlock();
    }
}
