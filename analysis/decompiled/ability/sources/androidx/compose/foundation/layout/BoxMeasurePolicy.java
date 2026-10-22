package androidx.compose.foundation.layout;

import C7.r;
import androidx.appfunctions.metadata.a;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0007\u001a\u00020\u0003HÂ\u0003J\t\u0010\b\u001a\u00020\u0005HÂ\u0003J\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J,\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/layout/BoxMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "alignment", "Landroidx/compose/ui/Alignment;", "propagateMinConstraints", "", "(Landroidx/compose/ui/Alignment;Z)V", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final /* data */ class BoxMeasurePolicy implements MeasurePolicy {
    private final Alignment alignment;
    private final boolean propagateMinConstraints;

    public BoxMeasurePolicy(Alignment alignment, boolean z10) {
        this.alignment = alignment;
        this.propagateMinConstraints = z10;
    }

    /* renamed from: component1, reason: from getter */
    private final Alignment getAlignment() {
        return this.alignment;
    }

    /* renamed from: component2, reason: from getter */
    private final boolean getPropagateMinConstraints() {
        return this.propagateMinConstraints;
    }

    public static /* synthetic */ BoxMeasurePolicy copy$default(BoxMeasurePolicy boxMeasurePolicy, Alignment alignment, boolean z10, int i, Object obj) {
        if ((i & 1) != 0) {
            alignment = boxMeasurePolicy.alignment;
        }
        if ((i & 2) != 0) {
            z10 = boxMeasurePolicy.propagateMinConstraints;
        }
        return boxMeasurePolicy.copy(alignment, z10);
    }

    public final BoxMeasurePolicy copy(Alignment alignment, boolean propagateMinConstraints) {
        return new BoxMeasurePolicy(alignment, propagateMinConstraints);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BoxMeasurePolicy)) {
            return false;
        }
        BoxMeasurePolicy boxMeasurePolicy = (BoxMeasurePolicy) other;
        return k.b(this.alignment, boxMeasurePolicy.alignment) && this.propagateMinConstraints == boxMeasurePolicy.propagateMinConstraints;
    }

    public int hashCode() {
        return Boolean.hashCode(this.propagateMinConstraints) + (this.alignment.hashCode() * 31);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo37measure3p2s80s(final MeasureScope measureScope, final List<? extends Measurable> list, long j5) {
        long j6;
        int iM6799getMinWidthimpl;
        int iM6798getMinHeightimpl;
        Placeable placeableMo5549measureBRTryo0;
        if (list.isEmpty()) {
            return MeasureScope.layout$default(measureScope, Constraints.m6799getMinWidthimpl(j5), Constraints.m6798getMinHeightimpl(j5), null, new S7.k() { // from class: androidx.compose.foundation.layout.BoxMeasurePolicy$measure$1
                public final void invoke(Placeable.PlacementScope placementScope) {
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Placeable.PlacementScope) obj);
                    return r.f317a;
                }
            }, 4, null);
        }
        if (this.propagateMinConstraints) {
            j6 = j5;
        } else {
            j6 = j5;
            j5 = Constraints.m6787copyZbe2FdA$default(j6, 0, 0, 0, 0, 10, null);
        }
        if (list.size() == 1) {
            final Measurable measurable = list.get(0);
            if (BoxKt.getMatchesParentSize(measurable)) {
                iM6799getMinWidthimpl = Constraints.m6799getMinWidthimpl(j6);
                iM6798getMinHeightimpl = Constraints.m6798getMinHeightimpl(j6);
                placeableMo5549measureBRTryo0 = measurable.mo5549measureBRTryo0(Constraints.INSTANCE.m6807fixedJhjzzOo(Constraints.m6799getMinWidthimpl(j6), Constraints.m6798getMinHeightimpl(j6)));
            } else {
                placeableMo5549measureBRTryo0 = measurable.mo5549measureBRTryo0(j5);
                iM6799getMinWidthimpl = Math.max(Constraints.m6799getMinWidthimpl(j6), placeableMo5549measureBRTryo0.getWidth());
                iM6798getMinHeightimpl = Math.max(Constraints.m6798getMinHeightimpl(j6), placeableMo5549measureBRTryo0.getHeight());
            }
            final Placeable placeable = placeableMo5549measureBRTryo0;
            final int i = iM6799getMinWidthimpl;
            final int i6 = iM6798getMinHeightimpl;
            return MeasureScope.layout$default(measureScope, i, i6, null, new S7.k() { // from class: androidx.compose.foundation.layout.BoxMeasurePolicy$measure$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Placeable.PlacementScope) obj);
                    return r.f317a;
                }

                public final void invoke(Placeable.PlacementScope placementScope) {
                    BoxKt.placeInBox(placementScope, placeable, measurable, measureScope.getLayoutDirection(), i, i6, this.alignment);
                }
            }, 4, null);
        }
        final Placeable[] placeableArr = new Placeable[list.size()];
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.f4918a = Constraints.m6799getMinWidthimpl(j6);
        final Ref$IntRef ref$IntRef2 = new Ref$IntRef();
        ref$IntRef2.f4918a = Constraints.m6798getMinHeightimpl(j6);
        int size = list.size();
        boolean z10 = false;
        for (int i10 = 0; i10 < size; i10++) {
            Measurable measurable2 = list.get(i10);
            if (BoxKt.getMatchesParentSize(measurable2)) {
                z10 = true;
            } else {
                Placeable placeableMo5549measureBRTryo02 = measurable2.mo5549measureBRTryo0(j5);
                placeableArr[i10] = placeableMo5549measureBRTryo02;
                ref$IntRef.f4918a = Math.max(ref$IntRef.f4918a, placeableMo5549measureBRTryo02.getWidth());
                ref$IntRef2.f4918a = Math.max(ref$IntRef2.f4918a, placeableMo5549measureBRTryo02.getHeight());
            }
        }
        if (z10) {
            int i11 = ref$IntRef.f4918a;
            int i12 = i11 != Integer.MAX_VALUE ? i11 : 0;
            int i13 = ref$IntRef2.f4918a;
            long jConstraints = ConstraintsKt.Constraints(i12, i11, i13 != Integer.MAX_VALUE ? i13 : 0, i13);
            int size2 = list.size();
            for (int i14 = 0; i14 < size2; i14++) {
                Measurable measurable3 = list.get(i14);
                if (BoxKt.getMatchesParentSize(measurable3)) {
                    placeableArr[i14] = measurable3.mo5549measureBRTryo0(jConstraints);
                }
            }
        }
        return MeasureScope.layout$default(measureScope, ref$IntRef.f4918a, ref$IntRef2.f4918a, null, new S7.k() { // from class: androidx.compose.foundation.layout.BoxMeasurePolicy$measure$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return r.f317a;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Placeable[] placeableArr2 = placeableArr;
                List<Measurable> list2 = list;
                MeasureScope measureScope2 = measureScope;
                Ref$IntRef ref$IntRef3 = ref$IntRef;
                Ref$IntRef ref$IntRef4 = ref$IntRef2;
                BoxMeasurePolicy boxMeasurePolicy = this;
                int length = placeableArr2.length;
                int i15 = 0;
                int i16 = 0;
                while (i15 < length) {
                    Placeable placeable2 = placeableArr2[i15];
                    k.d(placeable2, "null cannot be cast to non-null type androidx.compose.ui.layout.Placeable");
                    BoxKt.placeInBox(placementScope, placeable2, list2.get(i16), measureScope2.getLayoutDirection(), ref$IntRef3.f4918a, ref$IntRef4.f4918a, boxMeasurePolicy.alignment);
                    i15++;
                    i16++;
                }
            }
        }, 4, null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BoxMeasurePolicy(alignment=");
        sb.append(this.alignment);
        sb.append(", propagateMinConstraints=");
        return a.r(sb, this.propagateMinConstraints, ')');
    }
}
