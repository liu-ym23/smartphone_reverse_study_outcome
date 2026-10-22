package androidx.compose.animation;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ#\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0016H\u0016¢\u0006\u0004\b \u0010!J\u001c\u0010\"\u001a\u00020#*\u00020$2\u0006\u0010\u001d\u001a\u00020%2\u0006\u0010&\u001a\u00020#H\u0016J\u001c\u0010'\u001a\u00020#*\u00020$2\u0006\u0010\u001d\u001a\u00020%2\u0006\u0010&\u001a\u00020#H\u0016J\u001c\u0010(\u001a\u00020#*\u00020$2\u0006\u0010\u001d\u001a\u00020%2\u0006\u0010)\u001a\u00020#H\u0016J\u001c\u0010*\u001a\u00020#*\u00020$2\u0006\u0010\u001d\u001a\u00020%2\u0006\u0010)\u001a\u00020#H\u0016R/\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR7\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0005\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0019¨\u0006+"}, d2 = {"Landroidx/compose/animation/SkipToLookaheadNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "scaleToBounds", "Landroidx/compose/animation/ScaleToBoundsImpl;", "isEnabled", "Lkotlin/Function0;", "", "<init>", "(Landroidx/compose/animation/ScaleToBoundsImpl;Lkotlin/jvm/functions/Function0;)V", "<set-?>", "getScaleToBounds", "()Landroidx/compose/animation/ScaleToBoundsImpl;", "setScaleToBounds", "(Landroidx/compose/animation/ScaleToBoundsImpl;)V", "scaleToBounds$delegate", "Landroidx/compose/runtime/MutableState;", "()Lkotlin/jvm/functions/Function0;", "setEnabled", "(Lkotlin/jvm/functions/Function0;)V", "isEnabled$delegate", "lookaheadConstraints", "Landroidx/compose/ui/unit/Constraints;", "lookaheadSize", "Landroidx/compose/ui/unit/IntSize;", "J", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "maxIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicWidth", "maxIntrinsicHeight", "width", "minIntrinsicHeight", GXTemplateKey.GAIAX_ANIMATION}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SkipToLookaheadNode extends Modifier.Node implements LayoutModifierNode {
    public static final int $stable = 8;
    private final MutableState isEnabled$delegate;
    private Constraints lookaheadConstraints;
    private long lookaheadSize;
    private final MutableState scaleToBounds$delegate;

    /* JADX WARN: Multi-variable type inference failed */
    public final ScaleToBoundsImpl getScaleToBounds() {
        return (ScaleToBoundsImpl) this.scaleToBounds$delegate.getValue();
    }

    public final Function0<Boolean> isEnabled() {
        return (Function0) this.isEnabled$delegate.getValue();
    }

    public static final /* synthetic */ long access$getLookaheadSize$p(SkipToLookaheadNode r100) {
        return r100.lookaheadSize;
    }

    public final void setEnabled(Function0<Boolean> r100) {
        this.isEnabled$delegate.setValue(r100);
    }

    public final void setScaleToBounds(ScaleToBoundsImpl r100) {
        this.scaleToBounds$delegate.setValue(r100);
    }

    public SkipToLookaheadNode(ScaleToBoundsImpl r100, Function0<Boolean> r101) {
        this.scaleToBounds$delegate = SnapshotStateKt.mutableStateOf$default(r100, null, 2, null);
        this.isEnabled$delegate = SnapshotStateKt.mutableStateOf$default(r101, null, 2, null);
        this.lookaheadSize = AnimationModifierKt.getInvalidSize();
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope r100, IntrinsicMeasurable r101, int r102) {
        if (r100.isLookingAhead() == true) goto L8;
        if (AnimationModifierKt.m65isValidozmzZPI(this.lookaheadSize) == false) goto L8;
        return (int) (this.lookaheadSize & BodyPartID.bodyIdMax);
    L8:
        return r101.maxIntrinsicHeight(r102);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope r100, IntrinsicMeasurable r101, int r102) {
        if (r100.isLookingAhead() == true) goto L8;
        if (AnimationModifierKt.m65isValidozmzZPI(this.lookaheadSize) == false) goto L8;
        return (int) (this.lookaheadSize >> 32);
    L8:
        return r101.maxIntrinsicWidth(r102);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo61measure3p2s80s(final MeasureScope r110, Measurable r210, long r211) {
        if (r110.isLookingAhead() == false) goto L6;
        this.lookaheadConstraints = Constraints.m7474boximpl(r211);
    L6:
        if (isEnabled().invoke().booleanValue() == true) goto L10;
        final Placeable r100 = r210.mo6256measureBRTryo0(r211);
        return MeasureScope.CC.layout$default(r110, r100.getWidth(), r100.getHeight(), null, new SkipToLookaheadNode$measure$1$1(r100), 4, null);
    L10:
        if (r110.isLookingAhead() == false) goto L12;
        Placeable r101 = r210.mo6256measureBRTryo0(r211);
        int r102 = r101.getWidth();
        long r103 = ((long) r102) << 32;
        this.lookaheadSize = IntSize.m7714constructorimpl((((long) r101.getHeight()) & BodyPartID.bodyIdMax) | r103);
    L13:
        final Placeable r104 = r101;
        final long r105 = ConstraintsKt.m7501constrain4WqzIAM(r211, this.lookaheadSize);
        return MeasureScope.CC.layout$default(r110, (int) (r105 >> 32), (int) (r105 & BodyPartID.bodyIdMax), null, new SkipToLookaheadNode$measure$2(this, r104, r105, r110), 4, null);
    L12:
        Constraints r106 = this.lookaheadConstraints;
        Intrinsics.checkNotNull(r106);
        r101 = r210.mo6256measureBRTryo0(r106.m7493unboximpl());
        goto L13
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope r100, IntrinsicMeasurable r101, int r102) {
        if (r100.isLookingAhead() == true) goto L8;
        if (AnimationModifierKt.m65isValidozmzZPI(this.lookaheadSize) == false) goto L8;
        return (int) (this.lookaheadSize & BodyPartID.bodyIdMax);
    L8:
        return r101.minIntrinsicHeight(r102);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope r100, IntrinsicMeasurable r101, int r102) {
        if (r100.isLookingAhead() == true) goto L8;
        if (AnimationModifierKt.m65isValidozmzZPI(this.lookaheadSize) == false) goto L8;
        return (int) (this.lookaheadSize >> 32);
    L8:
        return r101.minIntrinsicWidth(r102);
    }
}
