package androidx.compose.ui.draw;

import C7.r;
import S7.a;
import S7.k;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.shadow.DropShadowPainter;
import androidx.compose.ui.graphics.shadow.Shadow;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpOffset;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B#\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\rJ\u000f\u0010\u0012\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\rJ\u000f\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\rJ)\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u0014\u0010\u000bJ\u0013\u0010\u0016\u001a\u00020\b*\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0018\u0010\rJ\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0096\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010!R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010(\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R<\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u00078\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\t\u0010-\"\u0004\b.\u0010/R*\u00101\u001a\u0002002\u0006\u0010,\u001a\u0002008\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R*\u00107\u001a\u0002002\u0006\u0010,\u001a\u0002008\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b7\u00102\u001a\u0004\b8\u00104\"\u0004\b9\u00106R*\u0010;\u001a\u00020:2\u0006\u0010,\u001a\u00020:8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R*\u0010B\u001a\u00020A2\u0006\u0010,\u001a\u00020A8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bB\u0010<\u001a\u0004\bC\u0010>\"\u0004\bD\u0010@R.\u0010F\u001a\u0004\u0018\u00010E2\b\u0010,\u001a\u0004\u0018\u00010E8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR*\u0010L\u001a\u0002002\u0006\u0010,\u001a\u0002008\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bL\u00102\u001a\u0004\bM\u00104\"\u0004\bN\u00106R*\u0010P\u001a\u00020O2\u0006\u0010,\u001a\u00020O8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010 \"\u0004\bS\u0010TR\u0014\u0010V\u001a\u0002008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bU\u00104R\u0014\u0010X\u001a\u0002008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bW\u00104¨\u0006Y"}, d2 = {"Landroidx/compose/ui/draw/BlockDropShadowNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/draw/DropShadowScope;", "Landroidx/compose/ui/graphics/Shape;", "shape", "Lkotlin/Function1;", "LC7/r;", "block", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/graphics/Shape;LS7/k;)V", "updateDensity", "()V", "Landroidx/compose/ui/graphics/shadow/DropShadowPainter;", "obtainPainter", "()Landroidx/compose/ui/graphics/shadow/DropShadowPainter;", "invalidateShadow", "onAttach", "onDensityChange", "update", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "draw", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;)V", "onObservedReadsChanged", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Landroidx/compose/ui/graphics/Shape;", "Landroidx/compose/ui/unit/Density;", "densityObject", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/graphics/shadow/Shadow;", "targetShadow", "Landroidx/compose/ui/graphics/shadow/Shadow;", "shadowPainter", "Landroidx/compose/ui/graphics/shadow/DropShadowPainter;", "blockRead", "Z", "value", "LS7/k;", "setBlock", "(LS7/k;)V", "", "radius", "F", "getRadius", "()F", "setRadius", "(F)V", "spread", "getSpread", "setSpread", "Landroidx/compose/ui/geometry/Offset;", TypedValues.CycleType.S_WAVE_OFFSET, "J", "getOffset-F1C5BW0", "()J", "setOffset-k-4lQ0M", "(J)V", "Landroidx/compose/ui/graphics/Color;", TypedValues.Custom.S_COLOR, "getColor-0d7_KjU", "setColor-8_81llA", "Landroidx/compose/ui/graphics/Brush;", "brush", "Landroidx/compose/ui/graphics/Brush;", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "setBrush", "(Landroidx/compose/ui/graphics/Brush;)V", "alpha", "getAlpha", "setAlpha", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "I", "getBlendMode-0nO6VwU", "setBlendMode-s9anfk8", "(I)V", "getDensity", "density", "getFontScale", "fontScale", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BlockDropShadowNode extends Modifier.Node implements DrawModifierNode, ObserverModifierNode, DropShadowScope {
    public static final int $stable = 0;
    private k block;
    private boolean blockRead;
    private Brush brush;
    private Density densityObject;
    private float radius;
    private DropShadowPainter shadowPainter;
    private Shape shape;
    private float spread;
    private Shadow targetShadow;
    private long offset = Offset.INSTANCE.m3911getZeroF1C5BW0();
    private long color = Color.INSTANCE.m4165getBlack0d7_KjU();
    private float alpha = 1.0f;
    private int blendMode = BlendMode.INSTANCE.m4080getSrcOver0nO6VwU();

    public BlockDropShadowNode(Shape shape, k kVar) {
        this.shape = shape;
        this.block = kVar;
    }

    private final void invalidateShadow() {
        this.targetShadow = null;
        this.shadowPainter = null;
        DrawModifierNodeKt.invalidateDraw(this);
    }

    private final DropShadowPainter obtainPainter() {
        if (!this.blockRead) {
            this.blockRead = true;
            ObserverModifierNodeKt.observeReads(this, new a() { // from class: androidx.compose.ui.draw.BlockDropShadowNode.obtainPainter.1
                {
                    super(0);
                }

                @Override // S7.a
                public /* bridge */ /* synthetic */ Object invoke() {
                    m3658invoke();
                    return r.f317a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m3658invoke() {
                    BlockDropShadowNode.this.block.invoke(BlockDropShadowNode.this);
                }
            });
        }
        Shadow shadow = this.targetShadow;
        DropShadowPainter dropShadowPainter = this.shadowPainter;
        Brush brush = getBrush();
        float fMo377toDpu2uoSUM = mo377toDpu2uoSUM(getRadius());
        float fMo377toDpu2uoSUM2 = mo377toDpu2uoSUM(getSpread());
        float fMo377toDpu2uoSUM3 = mo377toDpu2uoSUM(Float.intBitsToFloat((int) (getOffset() >> 32)));
        long jM6900constructorimpl = DpOffset.m6900constructorimpl((Float.floatToRawIntBits(mo377toDpu2uoSUM(Float.intBitsToFloat((int) (getOffset() & 4294967295L)))) & 4294967295L) | (Float.floatToRawIntBits(fMo377toDpu2uoSUM3) << 32));
        if (dropShadowPainter != null && shadow != null && Dp.m6849equalsimpl0(shadow.getRadius(), fMo377toDpu2uoSUM) && Dp.m6849equalsimpl0(shadow.getSpread(), fMo377toDpu2uoSUM2) && Color.m4140equalsimpl0(shadow.getColor(), getColor()) && kotlin.jvm.internal.k.b(shadow.getBrush(), brush) && shadow.getAlpha() == getAlpha() && BlendMode.m4049equalsimpl0(shadow.getBlendMode(), getBlendMode()) && DpOffset.m6904equalsimpl0(shadow.getOffset(), jM6900constructorimpl)) {
            return dropShadowPainter;
        }
        Shadow shadow2 = brush != null ? new Shadow(fMo377toDpu2uoSUM, brush, fMo377toDpu2uoSUM2, jM6900constructorimpl, getAlpha(), getBlendMode(), (e) null) : new Shadow(fMo377toDpu2uoSUM, getColor(), fMo377toDpu2uoSUM2, jM6900constructorimpl, getAlpha(), getBlendMode(), (e) null);
        this.targetShadow = shadow2;
        DropShadowPainter dropShadowPainterCreateDropShadowPainter = DelegatableNodeKt.requireGraphicsContext(this).getShadowContext().createDropShadowPainter(this.shape, shadow2);
        this.shadowPainter = dropShadowPainterCreateDropShadowPainter;
        return dropShadowPainterCreateDropShadowPainter;
    }

    private final void setBlock(k kVar) {
        if (this.block != kVar) {
            this.block = kVar;
            this.blockRead = false;
            DrawModifierNodeKt.invalidateDraw(this);
        }
    }

    private final void updateDensity() {
        Density densityRequireDensity = DelegatableNodeKt.requireDensity(this);
        if (kotlin.jvm.internal.k.b(this.densityObject, densityRequireDensity)) {
            return;
        }
        this.densityObject = densityRequireDensity;
        this.block.invoke(this);
        invalidateShadow();
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        Painter.m4832drawx_KDEd0$default(obtainPainter(), contentDrawScope, contentDrawScope.mo4707getSizeNHjbRc(), 0.0f, null, 6, null);
        contentDrawScope.drawContent();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null && (other instanceof BlockDropShadowNode)) {
            BlockDropShadowNode blockDropShadowNode = (BlockDropShadowNode) other;
            return getAlpha() == blockDropShadowNode.getAlpha() && kotlin.jvm.internal.k.b(this.shape, blockDropShadowNode.shape) && this.block == blockDropShadowNode.block && getRadius() == blockDropShadowNode.getRadius() && getSpread() == blockDropShadowNode.getSpread() && Offset.m3892equalsimpl0(getOffset(), blockDropShadowNode.getOffset()) && Color.m4140equalsimpl0(getColor(), blockDropShadowNode.getColor()) && kotlin.jvm.internal.k.b(getBrush(), blockDropShadowNode.getBrush()) && BlendMode.m4049equalsimpl0(getBlendMode(), blockDropShadowNode.getBlendMode());
        }
        return false;
    }

    @Override // androidx.compose.ui.draw.ShadowScope
    public float getAlpha() {
        return this.alpha;
    }

    @Override // androidx.compose.ui.draw.ShadowScope
    /* renamed from: getBlendMode-0nO6VwU, reason: not valid java name and from getter */
    public int getBlendMode() {
        return this.blendMode;
    }

    @Override // androidx.compose.ui.draw.ShadowScope
    public Brush getBrush() {
        return this.brush;
    }

    @Override // androidx.compose.ui.draw.ShadowScope
    /* renamed from: getColor-0d7_KjU, reason: not valid java name and from getter */
    public long getColor() {
        return this.color;
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        Density density = this.densityObject;
        if (density != null) {
            return density.getDensity();
        }
        return 1.0f;
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float getFontScale() {
        Density density = this.densityObject;
        if (density != null) {
            return density.getFontScale();
        }
        return 1.0f;
    }

    @Override // androidx.compose.ui.draw.ShadowScope
    /* renamed from: getOffset-F1C5BW0, reason: not valid java name and from getter */
    public long getOffset() {
        return this.offset;
    }

    @Override // androidx.compose.ui.draw.ShadowScope
    public float getRadius() {
        return this.radius;
    }

    @Override // androidx.compose.ui.draw.ShadowScope
    public float getSpread() {
        return this.spread;
    }

    public int hashCode() {
        int iM4146hashCodeimpl = (Color.m4146hashCodeimpl(getColor()) + ((Offset.m3897hashCodeimpl(getOffset()) + ((Float.hashCode(getSpread()) + ((Float.hashCode(getRadius()) + ((this.block.hashCode() + ((this.shape.hashCode() + (Float.hashCode(getAlpha()) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        Brush brush = getBrush();
        return BlendMode.m4050hashCodeimpl(getBlendMode()) + ((iM4146hashCodeimpl + (brush != null ? brush.hashCode() : 0)) * 31);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        super.onAttach();
        updateDensity();
    }

    @Override // androidx.compose.ui.node.DelegatableNode
    public void onDensityChange() {
        if (getIsAttached()) {
            updateDensity();
        }
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public void onObservedReadsChanged() {
        invalidateShadow();
        this.blockRead = false;
    }

    @Override // androidx.compose.ui.draw.ShadowScope
    public void setAlpha(float f) {
        if (this.alpha == f) {
            return;
        }
        this.alpha = f;
        invalidateShadow();
    }

    @Override // androidx.compose.ui.draw.ShadowScope
    /* renamed from: setBlendMode-s9anfk8, reason: not valid java name */
    public void mo3655setBlendModes9anfk8(int i) {
        if (BlendMode.m4049equalsimpl0(this.blendMode, i)) {
            return;
        }
        this.blendMode = i;
        invalidateShadow();
    }

    @Override // androidx.compose.ui.draw.ShadowScope
    public void setBrush(Brush brush) {
        if (kotlin.jvm.internal.k.b(this.brush, brush)) {
            return;
        }
        this.brush = brush;
        invalidateShadow();
    }

    @Override // androidx.compose.ui.draw.ShadowScope
    /* renamed from: setColor-8_81llA, reason: not valid java name */
    public void mo3656setColor8_81llA(long j5) {
        if (j5 == 16) {
            j5 = Color.INSTANCE.m4165getBlack0d7_KjU();
        }
        if (Color.m4140equalsimpl0(this.color, j5)) {
            return;
        }
        this.color = j5;
        invalidateShadow();
    }

    @Override // androidx.compose.ui.draw.ShadowScope
    /* renamed from: setOffset-k-4lQ0M, reason: not valid java name */
    public void mo3657setOffsetk4lQ0M(long j5) {
        if (Offset.m3892equalsimpl0(this.offset, j5)) {
            return;
        }
        this.offset = j5;
        DrawModifierNodeKt.invalidateDraw(this);
    }

    @Override // androidx.compose.ui.draw.ShadowScope
    public void setRadius(float f) {
        if (this.radius == f) {
            return;
        }
        this.radius = f;
        invalidateShadow();
    }

    @Override // androidx.compose.ui.draw.ShadowScope
    public void setSpread(float f) {
        if (this.spread == f) {
            return;
        }
        this.spread = f;
        invalidateShadow();
    }

    public final void update(Shape shape, k block) {
        this.shape = shape;
        setBlock(block);
    }
}
