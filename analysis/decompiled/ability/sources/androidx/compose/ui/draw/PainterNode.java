package androidx.compose.ui.draw;

import C7.r;
import S7.k;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.ScaleFactorKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b%\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BA\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u0015J\u0013\u0010\u001d\u001a\u00020\u0006*\u00020\u0012H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u001f\u001a\u00020\u0006*\u00020\u0012H\u0002¢\u0006\u0004\b\u001e\u0010\u001cJ#\u0010&\u001a\u00020#*\u00020 2\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b$\u0010%J#\u0010+\u001a\u00020)*\u00020'2\u0006\u0010\"\u001a\u00020(2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,J#\u0010-\u001a\u00020)*\u00020'2\u0006\u0010\"\u001a\u00020(2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b-\u0010,J#\u0010/\u001a\u00020)*\u00020'2\u0006\u0010\"\u001a\u00020(2\u0006\u0010.\u001a\u00020)H\u0016¢\u0006\u0004\b/\u0010,J#\u00100\u001a\u00020)*\u00020'2\u0006\u0010\"\u001a\u00020(2\u0006\u0010.\u001a\u00020)H\u0016¢\u0006\u0004\b0\u0010,J\u0013\u00103\u001a\u000202*\u000201H\u0016¢\u0006\u0004\b3\u00104J\u000f\u00106\u001a\u000205H\u0016¢\u0006\u0004\b6\u00107R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0014\u0010W\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bV\u0010?R\u0014\u0010Y\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bX\u0010?¨\u0006Z"}, d2 = {"Landroidx/compose/ui/draw/PainterNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/graphics/painter/Painter;", "painter", "", "sizeToIntrinsics", "Landroidx/compose/ui/Alignment;", "alignment", "Landroidx/compose/ui/layout/ContentScale;", "contentScale", "", "alpha", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/graphics/painter/Painter;ZLandroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V", "Landroidx/compose/ui/geometry/Size;", "dstSize", "calculateScaledSize-E7KxVPU", "(J)J", "calculateScaledSize", "Landroidx/compose/ui/unit/Constraints;", "constraints", "modifyConstraints-ZezNO4M", "modifyConstraints", "hasSpecifiedAndFiniteWidth-uvyYCjk", "(J)Z", "hasSpecifiedAndFiniteWidth", "hasSpecifiedAndFiniteHeight-uvyYCjk", "hasSpecifiedAndFiniteHeight", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measurable", "Landroidx/compose/ui/layout/MeasureResult;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "measure", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "", "height", "minIntrinsicWidth", "(Landroidx/compose/ui/layout/IntrinsicMeasureScope;Landroidx/compose/ui/layout/IntrinsicMeasurable;I)I", "maxIntrinsicWidth", "width", "minIntrinsicHeight", "maxIntrinsicHeight", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "LC7/r;", "draw", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;)V", "", "toString", "()Ljava/lang/String;", "Landroidx/compose/ui/graphics/painter/Painter;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "setPainter", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "Z", "getSizeToIntrinsics", "()Z", "setSizeToIntrinsics", "(Z)V", "Landroidx/compose/ui/Alignment;", "getAlignment", "()Landroidx/compose/ui/Alignment;", "setAlignment", "(Landroidx/compose/ui/Alignment;)V", "Landroidx/compose/ui/layout/ContentScale;", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "setContentScale", "(Landroidx/compose/ui/layout/ContentScale;)V", "F", "getAlpha", "()F", "setAlpha", "(F)V", "Landroidx/compose/ui/graphics/ColorFilter;", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "getUseIntrinsicSize", "useIntrinsicSize", "getShouldAutoInvalidate", "shouldAutoInvalidate", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class PainterNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode {
    private Alignment alignment;
    private float alpha;
    private ColorFilter colorFilter;
    private ContentScale contentScale;
    private Painter painter;
    private boolean sizeToIntrinsics;

    public /* synthetic */ PainterNode(Painter painter, boolean z10, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, e eVar) {
        this(painter, z10, (i & 4) != 0 ? Alignment.INSTANCE.getCenter() : alignment, (i & 8) != 0 ? ContentScale.INSTANCE.getInside() : contentScale, (i & 16) != 0 ? 1.0f : f, (i & 32) != 0 ? null : colorFilter);
    }

    /* renamed from: calculateScaledSize-E7KxVPU, reason: not valid java name */
    private final long m3726calculateScaledSizeE7KxVPU(long dstSize) {
        if (!getUseIntrinsicSize()) {
            return dstSize;
        }
        long jM3955constructorimpl = Size.m3955constructorimpl((Float.floatToRawIntBits(!m3728hasSpecifiedAndFiniteWidthuvyYCjk(this.painter.getIntrinsicSize()) ? Float.intBitsToFloat((int) (dstSize >> 32)) : Float.intBitsToFloat((int) (this.painter.getIntrinsicSize() >> 32))) << 32) | (Float.floatToRawIntBits(!m3727hasSpecifiedAndFiniteHeightuvyYCjk(this.painter.getIntrinsicSize()) ? Float.intBitsToFloat((int) (dstSize & 4294967295L)) : Float.intBitsToFloat((int) (this.painter.getIntrinsicSize() & 4294967295L))) & 4294967295L));
        return (Float.intBitsToFloat((int) (dstSize >> 32)) == 0.0f || Float.intBitsToFloat((int) (dstSize & 4294967295L)) == 0.0f) ? Size.INSTANCE.m3973getZeroNHjbRc() : ScaleFactorKt.m5657timesUQTWf7w(jM3955constructorimpl, this.contentScale.mo5542computeScaleFactorH7hwNQA(jM3955constructorimpl, dstSize));
    }

    private final boolean getUseIntrinsicSize() {
        return this.sizeToIntrinsics && this.painter.getIntrinsicSize() != InlineClassHelperKt.UnspecifiedPackedFloats;
    }

    /* renamed from: hasSpecifiedAndFiniteHeight-uvyYCjk, reason: not valid java name */
    private final boolean m3727hasSpecifiedAndFiniteHeightuvyYCjk(long j5) {
        return !Size.m3960equalsimpl0(j5, Size.INSTANCE.m3972getUnspecifiedNHjbRc()) && (Float.floatToRawIntBits(Float.intBitsToFloat((int) (j5 & 4294967295L))) & Integer.MAX_VALUE) < 2139095040;
    }

    /* renamed from: hasSpecifiedAndFiniteWidth-uvyYCjk, reason: not valid java name */
    private final boolean m3728hasSpecifiedAndFiniteWidthuvyYCjk(long j5) {
        return !Size.m3960equalsimpl0(j5, Size.INSTANCE.m3972getUnspecifiedNHjbRc()) && (Float.floatToRawIntBits(Float.intBitsToFloat((int) (j5 >> 32))) & Integer.MAX_VALUE) < 2139095040;
    }

    /* renamed from: modifyConstraints-ZezNO4M, reason: not valid java name */
    private final long m3729modifyConstraintsZezNO4M(long constraints) {
        boolean z10 = false;
        boolean z11 = Constraints.m6793getHasBoundedWidthimpl(constraints) && Constraints.m6792getHasBoundedHeightimpl(constraints);
        if (Constraints.m6795getHasFixedWidthimpl(constraints) && Constraints.m6794getHasFixedHeightimpl(constraints)) {
            z10 = true;
        }
        if ((!getUseIntrinsicSize() && z11) || z10) {
            return Constraints.m6787copyZbe2FdA$default(constraints, Constraints.m6797getMaxWidthimpl(constraints), 0, Constraints.m6796getMaxHeightimpl(constraints), 0, 10, null);
        }
        long intrinsicSize = this.painter.getIntrinsicSize();
        int iRound = m3728hasSpecifiedAndFiniteWidthuvyYCjk(intrinsicSize) ? Math.round(Float.intBitsToFloat((int) (intrinsicSize >> 32))) : Constraints.m6799getMinWidthimpl(constraints);
        int iRound2 = m3727hasSpecifiedAndFiniteHeightuvyYCjk(intrinsicSize) ? Math.round(Float.intBitsToFloat((int) (intrinsicSize & 4294967295L))) : Constraints.m6798getMinHeightimpl(constraints);
        int iM6814constrainWidthK40F9xA = ConstraintsKt.m6814constrainWidthK40F9xA(constraints, iRound);
        long jM3726calculateScaledSizeE7KxVPU = m3726calculateScaledSizeE7KxVPU(Size.m3955constructorimpl((Float.floatToRawIntBits(ConstraintsKt.m6813constrainHeightK40F9xA(constraints, iRound2)) & 4294967295L) | (Float.floatToRawIntBits(iM6814constrainWidthK40F9xA) << 32)));
        return Constraints.m6787copyZbe2FdA$default(constraints, ConstraintsKt.m6814constrainWidthK40F9xA(constraints, Math.round(Float.intBitsToFloat((int) (jM3726calculateScaledSizeE7KxVPU >> 32)))), 0, ConstraintsKt.m6813constrainHeightK40F9xA(constraints, Math.round(Float.intBitsToFloat((int) (jM3726calculateScaledSizeE7KxVPU & 4294967295L)))), 0, 10, null);
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        long intrinsicSize = this.painter.getIntrinsicSize();
        long jM3955constructorimpl = Size.m3955constructorimpl((Float.floatToRawIntBits(m3728hasSpecifiedAndFiniteWidthuvyYCjk(intrinsicSize) ? Float.intBitsToFloat((int) (intrinsicSize >> 32)) : Float.intBitsToFloat((int) (contentDrawScope.mo4707getSizeNHjbRc() >> 32))) << 32) | (Float.floatToRawIntBits(m3727hasSpecifiedAndFiniteHeightuvyYCjk(intrinsicSize) ? Float.intBitsToFloat((int) (intrinsicSize & 4294967295L)) : Float.intBitsToFloat((int) (contentDrawScope.mo4707getSizeNHjbRc() & 4294967295L))) & 4294967295L));
        long jM3973getZeroNHjbRc = (Float.intBitsToFloat((int) (contentDrawScope.mo4707getSizeNHjbRc() >> 32)) == 0.0f || Float.intBitsToFloat((int) (contentDrawScope.mo4707getSizeNHjbRc() & 4294967295L)) == 0.0f) ? Size.INSTANCE.m3973getZeroNHjbRc() : ScaleFactorKt.m5657timesUQTWf7w(jM3955constructorimpl, this.contentScale.mo5542computeScaleFactorH7hwNQA(jM3955constructorimpl, contentDrawScope.mo4707getSizeNHjbRc()));
        long jMo3612alignKFBX0sM = this.alignment.mo3612alignKFBX0sM(IntSize.m7010constructorimpl((Math.round(Float.intBitsToFloat((int) (jM3973getZeroNHjbRc & 4294967295L))) & 4294967295L) | (Math.round(Float.intBitsToFloat((int) (jM3973getZeroNHjbRc >> 32))) << 32)), IntSize.m7010constructorimpl((Math.round(Float.intBitsToFloat((int) (contentDrawScope.mo4707getSizeNHjbRc() & 4294967295L))) & 4294967295L) | (Math.round(Float.intBitsToFloat((int) (contentDrawScope.mo4707getSizeNHjbRc() >> 32))) << 32)), contentDrawScope.getLayoutDirection());
        float fM6972getXimpl = IntOffset.m6972getXimpl(jMo3612alignKFBX0sM);
        float fM6973getYimpl = IntOffset.m6973getYimpl(jMo3612alignKFBX0sM);
        contentDrawScope.getDrawContext().getTransform().translate(fM6972getXimpl, fM6973getYimpl);
        try {
            this.painter.m4833drawx_KDEd0(contentDrawScope, jM3973getZeroNHjbRc, this.alpha, this.colorFilter);
            contentDrawScope.getDrawContext().getTransform().translate(-fM6972getXimpl, -fM6973getYimpl);
            contentDrawScope.drawContent();
        } catch (Throwable th) {
            contentDrawScope.getDrawContext().getTransform().translate(-fM6972getXimpl, -fM6973getYimpl);
            throw th;
        }
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    public final Painter getPainter() {
        return this.painter;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public final boolean getSizeToIntrinsics() {
        return this.sizeToIntrinsics;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.maxIntrinsicHeight(i);
        }
        long jM3729modifyConstraintsZezNO4M = m3729modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
        return Math.max(Constraints.m6798getMinHeightimpl(jM3729modifyConstraintsZezNO4M), intrinsicMeasurable.maxIntrinsicHeight(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.maxIntrinsicWidth(i);
        }
        long jM3729modifyConstraintsZezNO4M = m3729modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
        return Math.max(Constraints.m6799getMinWidthimpl(jM3729modifyConstraintsZezNO4M), intrinsicMeasurable.maxIntrinsicWidth(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo89measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j5) {
        final Placeable placeableMo5549measureBRTryo0 = measurable.mo5549measureBRTryo0(m3729modifyConstraintsZezNO4M(j5));
        return MeasureScope.layout$default(measureScope, placeableMo5549measureBRTryo0.getWidth(), placeableMo5549measureBRTryo0.getHeight(), null, new k() { // from class: androidx.compose.ui.draw.PainterNode$measure$1
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return r.f317a;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo5549measureBRTryo0, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.minIntrinsicHeight(i);
        }
        long jM3729modifyConstraintsZezNO4M = m3729modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
        return Math.max(Constraints.m6798getMinHeightimpl(jM3729modifyConstraintsZezNO4M), intrinsicMeasurable.minIntrinsicHeight(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.minIntrinsicWidth(i);
        }
        long jM3729modifyConstraintsZezNO4M = m3729modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
        return Math.max(Constraints.m6799getMinWidthimpl(jM3729modifyConstraintsZezNO4M), intrinsicMeasurable.minIntrinsicWidth(i));
    }

    public final void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public final void setAlpha(float f) {
        this.alpha = f;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
    }

    public final void setContentScale(ContentScale contentScale) {
        this.contentScale = contentScale;
    }

    public final void setPainter(Painter painter) {
        this.painter = painter;
    }

    public final void setSizeToIntrinsics(boolean z10) {
        this.sizeToIntrinsics = z10;
    }

    public String toString() {
        return "PainterModifier(painter=" + this.painter + ", sizeToIntrinsics=" + this.sizeToIntrinsics + ", alignment=" + this.alignment + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }

    public PainterNode(Painter painter, boolean z10, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter) {
        this.painter = painter;
        this.sizeToIntrinsics = z10;
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = f;
        this.colorFilter = colorFilter;
    }
}
