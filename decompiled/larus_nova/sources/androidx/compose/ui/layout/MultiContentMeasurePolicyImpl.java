package androidx.compose.ui.layout;

import androidx.compose.ui.node.MeasureScopeWithLayoutNodeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\b\u001a\u00020\t*\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\"\u0010\u0012\u001a\u00020\u0013*\u00020\u00142\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00150\f2\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\"\u0010\u0017\u001a\u00020\u0013*\u00020\u00142\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00150\f2\u0006\u0010\u0018\u001a\u00020\u0013H\u0016J\"\u0010\u0019\u001a\u00020\u0013*\u00020\u00142\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00150\f2\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\"\u0010\u001a\u001a\u00020\u0013*\u00020\u00142\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00150\f2\u0006\u0010\u0018\u001a\u00020\u0013H\u0016J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0013HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006$"}, d2 = {"Landroidx/compose/ui/layout/MultiContentMeasurePolicyImpl;", "Landroidx/compose/ui/layout/MeasurePolicy;", "measurePolicy", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "<init>", "(Landroidx/compose/ui/layout/MultiContentMeasurePolicy;)V", "getMeasurePolicy", "()Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MultiContentMeasurePolicyImpl implements MeasurePolicy {
    public static final int $stable = 0;
    private final MultiContentMeasurePolicy measurePolicy;

    public static /* synthetic */ MultiContentMeasurePolicyImpl copy$default(MultiContentMeasurePolicyImpl r100, MultiContentMeasurePolicy r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.measurePolicy;
    L6:
        return r100.copy(r101);
    }

    public final MultiContentMeasurePolicy component1() {
        return this.measurePolicy;
    }

    public final MultiContentMeasurePolicyImpl copy(MultiContentMeasurePolicy r100) {
        return new MultiContentMeasurePolicyImpl(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MultiContentMeasurePolicyImpl) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.measurePolicy, ((MultiContentMeasurePolicyImpl) r100).measurePolicy) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.measurePolicy.hashCode();
    }

    public String toString() {
        return "MultiContentMeasurePolicyImpl(measurePolicy=" + this.measurePolicy + ')';
    }

    public final MultiContentMeasurePolicy getMeasurePolicy() {
        return this.measurePolicy;
    }

    public MultiContentMeasurePolicyImpl(MultiContentMeasurePolicy r100) {
        this.measurePolicy = r100;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope r100, List<? extends IntrinsicMeasurable> r101, int r102) {
        return this.measurePolicy.maxIntrinsicHeight(r100, MeasureScopeWithLayoutNodeKt.getChildrenOfVirtualChildren(r100), r102);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope r100, List<? extends IntrinsicMeasurable> r101, int r102) {
        return this.measurePolicy.maxIntrinsicWidth(r100, MeasureScopeWithLayoutNodeKt.getChildrenOfVirtualChildren(r100), r102);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo33measure3p2s80s(MeasureScope r100, List<? extends Measurable> r101, long r102) {
        return this.measurePolicy.mo678measure3p2s80s(r100, MeasureScopeWithLayoutNodeKt.getChildrenOfVirtualChildren(r100), r102);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope r100, List<? extends IntrinsicMeasurable> r101, int r102) {
        return this.measurePolicy.minIntrinsicHeight(r100, MeasureScopeWithLayoutNodeKt.getChildrenOfVirtualChildren(r100), r102);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope r100, List<? extends IntrinsicMeasurable> r101, int r102) {
        return this.measurePolicy.minIntrinsicWidth(r100, MeasureScopeWithLayoutNodeKt.getChildrenOfVirtualChildren(r100), r102);
    }
}
