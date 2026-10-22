package androidx.compose.foundation.layout;

import C7.r;
import D7.v;
import S7.o;
import androidx.collection.IntIntPair;
import androidx.compose.foundation.b;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.FlowLayoutOverflow;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0082\b\u0018\u00002\u00020\u00012\u00020\u0002BO\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J2\u0010\u001e\u001a\u00020\u001b*\u00020\u00152\u0012\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00162\u0006\u0010\u001a\u001a\u00020\u0019H\u0016ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ/\u0010\"\u001a\u00020\u000e*\u00020\u001f2\u0012\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u00160\u00162\u0006\u0010!\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\"\u0010#J/\u0010%\u001a\u00020\u000e*\u00020\u001f2\u0012\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u00160\u00162\u0006\u0010$\u001a\u00020\u000eH\u0016¢\u0006\u0004\b%\u0010#J/\u0010&\u001a\u00020\u000e*\u00020\u001f2\u0012\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u00160\u00162\u0006\u0010$\u001a\u00020\u000eH\u0016¢\u0006\u0004\b&\u0010#J/\u0010'\u001a\u00020\u000e*\u00020\u001f2\u0012\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u00160\u00162\u0006\u0010!\u001a\u00020\u000eH\u0016¢\u0006\u0004\b'\u0010#JK\u0010*\u001a\u00020\u000e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020 0\u00162\u0006\u0010(\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b*\u0010+J+\u0010-\u001a\u00020\u000e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020 0\u00162\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000e¢\u0006\u0004\b-\u0010.JK\u00100\u001a\u00020\u000e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020 0\u00162\u0006\u0010/\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b0\u0010+J\u0010\u00101\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b1\u00102J\u0010\u00103\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b3\u00104J\u0010\u00105\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b5\u00106J\u0010\u00107\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b7\u00108Jm\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u0011HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u0010\u0010=\u001a\u00020<HÖ\u0001¢\u0006\u0004\b=\u0010>J\u0010\u0010?\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b?\u0010@J\u001a\u0010C\u001a\u00020\u00032\b\u0010B\u001a\u0004\u0018\u00010AHÖ\u0003¢\u0006\u0004\bC\u0010DJ\u0016\u0010G\u001a\u00020\tHÂ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bE\u0010FJ\u0016\u0010I\u001a\u00020\tHÂ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bH\u0010FJ\u0010\u0010J\u001a\u00020\u000eHÂ\u0003¢\u0006\u0004\bJ\u0010@J\u0010\u0010K\u001a\u00020\u000eHÂ\u0003¢\u0006\u0004\bK\u0010@J\u0010\u0010L\u001a\u00020\u0011HÂ\u0003¢\u0006\u0004\bL\u0010MR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010N\u001a\u0004\b\u0004\u00102R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010O\u001a\u0004\bP\u00104R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010Q\u001a\u0004\bR\u00106R\u001a\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\n\u0010SR\u001a\u0010\f\u001a\u00020\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010T\u001a\u0004\bU\u00108R\u001a\u0010\r\u001a\u00020\t8\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\r\u0010SR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010VR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010VR\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010WR/\u0010Y\u001a\u001a\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0X8\u0006¢\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R/\u0010]\u001a\u001a\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0X8\u0006¢\u0006\f\n\u0004\b]\u0010Z\u001a\u0004\b^\u0010\\R/\u0010_\u001a\u001a\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0X8\u0006¢\u0006\f\n\u0004\b_\u0010Z\u001a\u0004\b`\u0010\\R/\u0010a\u001a\u001a\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0X8\u0006¢\u0006\f\n\u0004\ba\u0010Z\u001a\u0004\bb\u0010\\\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006c"}, d2 = {"Landroidx/compose/foundation/layout/FlowMeasurePolicy;", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;", "", "isHorizontal", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "verticalArrangement", "Landroidx/compose/ui/unit/Dp;", "mainAxisSpacing", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "crossAxisAlignment", "crossAxisArrangementSpacing", "", "maxItemsInMainAxis", "maxLines", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "overflow", AppAgent.CONSTRUCT, "(ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/layout/CrossAxisAlignment;FIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Lkotlin/jvm/internal/e;)V", "Landroidx/compose/ui/layout/MeasureScope;", "", "Landroidx/compose/ui/layout/Measurable;", "measurables", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "measure", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicWidth", "(Landroidx/compose/ui/layout/IntrinsicMeasureScope;Ljava/util/List;I)I", "width", "minIntrinsicHeight", "maxIntrinsicHeight", "maxIntrinsicWidth", "crossAxisAvailable", "crossAxisSpacing", "minIntrinsicMainAxisSize", "(Ljava/util/List;IIIIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)I", "arrangementSpacing", "maxIntrinsicMainAxisSize", "(Ljava/util/List;II)I", "mainAxisAvailable", "intrinsicCrossAxisSize", "component1", "()Z", "component2", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "component3", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "component5", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "copy-QuyCDyQ", "(ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/layout/CrossAxisAlignment;FIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)Landroidx/compose/foundation/layout/FlowMeasurePolicy;", "copy", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "component4-D9Ej5fM", "()F", "component4", "component6-D9Ej5fM", "component6", "component7", "component8", "component9", "()Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "Z", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getHorizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "getVerticalArrangement", "F", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "getCrossAxisAlignment", "I", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "Lkotlin/Function3;", "maxMainAxisIntrinsicItemSize", "LS7/o;", "getMaxMainAxisIntrinsicItemSize", "()LS7/o;", "maxCrossAxisIntrinsicItemSize", "getMaxCrossAxisIntrinsicItemSize", "minCrossAxisIntrinsicItemSize", "getMinCrossAxisIntrinsicItemSize", "minMainAxisIntrinsicItemSize", "getMinMainAxisIntrinsicItemSize", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final /* data */ class FlowMeasurePolicy implements MultiContentMeasurePolicy, FlowLineMeasurePolicy {
    private final CrossAxisAlignment crossAxisAlignment;
    private final float crossAxisArrangementSpacing;
    private final Arrangement.Horizontal horizontalArrangement;
    private final boolean isHorizontal;
    private final float mainAxisSpacing;
    private final o maxCrossAxisIntrinsicItemSize;
    private final int maxItemsInMainAxis;
    private final int maxLines;
    private final o maxMainAxisIntrinsicItemSize;
    private final o minCrossAxisIntrinsicItemSize;
    private final o minMainAxisIntrinsicItemSize;
    private final FlowLayoutOverflowState overflow;
    private final Arrangement.Vertical verticalArrangement;

    public /* synthetic */ FlowMeasurePolicy(boolean z10, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f, CrossAxisAlignment crossAxisAlignment, float f7, int i, int i6, FlowLayoutOverflowState flowLayoutOverflowState, e eVar) {
        this(z10, horizontal, vertical, f, crossAxisAlignment, f7, i, i6, flowLayoutOverflowState);
    }

    /* renamed from: component4-D9Ej5fM, reason: not valid java name and from getter */
    private final float getMainAxisSpacing() {
        return this.mainAxisSpacing;
    }

    /* renamed from: component6-D9Ej5fM, reason: not valid java name and from getter */
    private final float getCrossAxisArrangementSpacing() {
        return this.crossAxisArrangementSpacing;
    }

    /* renamed from: component7, reason: from getter */
    private final int getMaxItemsInMainAxis() {
        return this.maxItemsInMainAxis;
    }

    /* renamed from: component8, reason: from getter */
    private final int getMaxLines() {
        return this.maxLines;
    }

    /* renamed from: component9, reason: from getter */
    private final FlowLayoutOverflowState getOverflow() {
        return this.overflow;
    }

    /* renamed from: copy-QuyCDyQ$default, reason: not valid java name */
    public static /* synthetic */ FlowMeasurePolicy m646copyQuyCDyQ$default(FlowMeasurePolicy flowMeasurePolicy, boolean z10, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f, CrossAxisAlignment crossAxisAlignment, float f7, int i, int i6, FlowLayoutOverflowState flowLayoutOverflowState, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = flowMeasurePolicy.isHorizontal;
        }
        if ((i10 & 2) != 0) {
            horizontal = flowMeasurePolicy.horizontalArrangement;
        }
        if ((i10 & 4) != 0) {
            vertical = flowMeasurePolicy.verticalArrangement;
        }
        if ((i10 & 8) != 0) {
            f = flowMeasurePolicy.mainAxisSpacing;
        }
        if ((i10 & 16) != 0) {
            crossAxisAlignment = flowMeasurePolicy.crossAxisAlignment;
        }
        if ((i10 & 32) != 0) {
            f7 = flowMeasurePolicy.crossAxisArrangementSpacing;
        }
        if ((i10 & 64) != 0) {
            i = flowMeasurePolicy.maxItemsInMainAxis;
        }
        if ((i10 & 128) != 0) {
            i6 = flowMeasurePolicy.maxLines;
        }
        if ((i10 & 256) != 0) {
            flowLayoutOverflowState = flowMeasurePolicy.overflow;
        }
        int i11 = i6;
        FlowLayoutOverflowState flowLayoutOverflowState2 = flowLayoutOverflowState;
        float f9 = f7;
        int i12 = i;
        CrossAxisAlignment crossAxisAlignment2 = crossAxisAlignment;
        Arrangement.Vertical vertical2 = vertical;
        return flowMeasurePolicy.m647copyQuyCDyQ(z10, horizontal, vertical2, f, crossAxisAlignment2, f9, i12, i11, flowLayoutOverflowState2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsHorizontal() {
        return this.isHorizontal;
    }

    /* renamed from: component2, reason: from getter */
    public final Arrangement.Horizontal getHorizontalArrangement() {
        return this.horizontalArrangement;
    }

    /* renamed from: component3, reason: from getter */
    public final Arrangement.Vertical getVerticalArrangement() {
        return this.verticalArrangement;
    }

    /* renamed from: component5, reason: from getter */
    public final CrossAxisAlignment getCrossAxisAlignment() {
        return this.crossAxisAlignment;
    }

    /* renamed from: copy-QuyCDyQ, reason: not valid java name */
    public final FlowMeasurePolicy m647copyQuyCDyQ(boolean isHorizontal, Arrangement.Horizontal horizontalArrangement, Arrangement.Vertical verticalArrangement, float mainAxisSpacing, CrossAxisAlignment crossAxisAlignment, float crossAxisArrangementSpacing, int maxItemsInMainAxis, int maxLines, FlowLayoutOverflowState overflow) {
        return new FlowMeasurePolicy(isHorizontal, horizontalArrangement, verticalArrangement, mainAxisSpacing, crossAxisAlignment, crossAxisArrangementSpacing, maxItemsInMainAxis, maxLines, overflow, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FlowMeasurePolicy)) {
            return false;
        }
        FlowMeasurePolicy flowMeasurePolicy = (FlowMeasurePolicy) other;
        return this.isHorizontal == flowMeasurePolicy.isHorizontal && k.b(this.horizontalArrangement, flowMeasurePolicy.horizontalArrangement) && k.b(this.verticalArrangement, flowMeasurePolicy.verticalArrangement) && Dp.m6849equalsimpl0(this.mainAxisSpacing, flowMeasurePolicy.mainAxisSpacing) && k.b(this.crossAxisAlignment, flowMeasurePolicy.crossAxisAlignment) && Dp.m6849equalsimpl0(this.crossAxisArrangementSpacing, flowMeasurePolicy.crossAxisArrangementSpacing) && this.maxItemsInMainAxis == flowMeasurePolicy.maxItemsInMainAxis && this.maxLines == flowMeasurePolicy.maxLines && k.b(this.overflow, flowMeasurePolicy.overflow);
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public CrossAxisAlignment getCrossAxisAlignment() {
        return this.crossAxisAlignment;
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public Arrangement.Horizontal getHorizontalArrangement() {
        return this.horizontalArrangement;
    }

    public final o getMaxCrossAxisIntrinsicItemSize() {
        return this.maxCrossAxisIntrinsicItemSize;
    }

    public final o getMaxMainAxisIntrinsicItemSize() {
        return this.maxMainAxisIntrinsicItemSize;
    }

    public final o getMinCrossAxisIntrinsicItemSize() {
        return this.minCrossAxisIntrinsicItemSize;
    }

    public final o getMinMainAxisIntrinsicItemSize() {
        return this.minMainAxisIntrinsicItemSize;
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public Arrangement.Vertical getVerticalArrangement() {
        return this.verticalArrangement;
    }

    public int hashCode() {
        return this.overflow.hashCode() + a.a(this.maxLines, a.a(this.maxItemsInMainAxis, b.b(this.crossAxisArrangementSpacing, (this.crossAxisAlignment.hashCode() + b.b(this.mainAxisSpacing, (this.verticalArrangement.hashCode() + ((this.horizontalArrangement.hashCode() + (Boolean.hashCode(this.isHorizontal) * 31)) * 31)) * 31, 31)) * 31, 31), 31), 31);
    }

    public final int intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> measurables, int mainAxisAvailable, int mainAxisSpacing, int crossAxisSpacing, int maxItemsInMainAxis, int maxLines, FlowLayoutOverflowState overflow) {
        return IntIntPair.m27getFirstimpl(FlowLayoutKt.intrinsicCrossAxisSize((List<? extends IntrinsicMeasurable>) measurables, this.minMainAxisIntrinsicItemSize, this.minCrossAxisIntrinsicItemSize, mainAxisAvailable, mainAxisSpacing, crossAxisSpacing, maxItemsInMainAxis, maxLines, overflow));
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public boolean isHorizontal() {
        return this.isHorizontal;
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i) {
        FlowLayoutOverflowState flowLayoutOverflowState = this.overflow;
        List list2 = (List) v.D0(1, list);
        IntrinsicMeasurable intrinsicMeasurable = list2 != null ? (IntrinsicMeasurable) v.C0(list2) : null;
        List list3 = (List) v.D0(2, list);
        flowLayoutOverflowState.m630setOverflowMeasurableshBUhpc$foundation_layout_release(intrinsicMeasurable, list3 != null ? (IntrinsicMeasurable) v.C0(list3) : null, isHorizontal(), ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
        if (isHorizontal()) {
            List<? extends IntrinsicMeasurable> list4 = (List) v.C0(list);
            if (list4 == null) {
                list4 = EmptyList.f4893a;
            }
            return intrinsicCrossAxisSize(list4, i, intrinsicMeasureScope.mo375roundToPx0680j_4(this.mainAxisSpacing), intrinsicMeasureScope.mo375roundToPx0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
        }
        List<? extends IntrinsicMeasurable> list5 = (List) v.C0(list);
        if (list5 == null) {
            list5 = EmptyList.f4893a;
        }
        return maxIntrinsicMainAxisSize(list5, i, intrinsicMeasureScope.mo375roundToPx0680j_4(this.mainAxisSpacing));
    }

    public final int maxIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> measurables, int height, int arrangementSpacing) {
        return FlowLayoutKt.maxIntrinsicMainAxisSize(measurables, this.maxMainAxisIntrinsicItemSize, height, arrangementSpacing, this.maxItemsInMainAxis);
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i) {
        FlowLayoutOverflowState flowLayoutOverflowState = this.overflow;
        List list2 = (List) v.D0(1, list);
        IntrinsicMeasurable intrinsicMeasurable = list2 != null ? (IntrinsicMeasurable) v.C0(list2) : null;
        List list3 = (List) v.D0(2, list);
        flowLayoutOverflowState.m630setOverflowMeasurableshBUhpc$foundation_layout_release(intrinsicMeasurable, list3 != null ? (IntrinsicMeasurable) v.C0(list3) : null, isHorizontal(), ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
        if (isHorizontal()) {
            List<? extends IntrinsicMeasurable> list4 = (List) v.C0(list);
            if (list4 == null) {
                list4 = EmptyList.f4893a;
            }
            return maxIntrinsicMainAxisSize(list4, i, intrinsicMeasureScope.mo375roundToPx0680j_4(this.mainAxisSpacing));
        }
        List<? extends IntrinsicMeasurable> list5 = (List) v.C0(list);
        if (list5 == null) {
            list5 = EmptyList.f4893a;
        }
        return intrinsicCrossAxisSize(list5, i, intrinsicMeasureScope.mo375roundToPx0680j_4(this.mainAxisSpacing), intrinsicMeasureScope.mo375roundToPx0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult mo648measure3p2s80s(MeasureScope measureScope, List<? extends List<? extends Measurable>> list, long j5) {
        if (this.maxLines == 0 || this.maxItemsInMainAxis == 0 || list.isEmpty() || (Constraints.m6796getMaxHeightimpl(j5) == 0 && this.overflow.getType$foundation_layout_release() != FlowLayoutOverflow.OverflowType.Visible)) {
            return MeasureScope.layout$default(measureScope, 0, 0, null, new S7.k() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$measure$1
                public final void invoke(Placeable.PlacementScope placementScope) {
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Placeable.PlacementScope) obj);
                    return r.f317a;
                }
            }, 4, null);
        }
        List list2 = (List) v.A0(list);
        if (list2.isEmpty()) {
            return MeasureScope.layout$default(measureScope, 0, 0, null, new S7.k() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$measure$2
                public final void invoke(Placeable.PlacementScope placementScope) {
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Placeable.PlacementScope) obj);
                    return r.f317a;
                }
            }, 4, null);
        }
        List list3 = (List) v.D0(1, list);
        Measurable measurable = list3 != null ? (Measurable) v.C0(list3) : null;
        List list4 = (List) v.D0(2, list);
        Measurable measurable2 = list4 != null ? (Measurable) v.C0(list4) : null;
        this.overflow.setItemCount$foundation_layout_release(list2.size());
        this.overflow.m629setOverflowMeasurableshBUhpc$foundation_layout_release(this, measurable, measurable2, j5);
        return FlowLayoutKt.m625breakDownItemsdi9J0FM(measureScope, this, list2.iterator(), this.mainAxisSpacing, this.crossAxisArrangementSpacing, OrientationIndependentConstraints.m669constructorimpl(j5, isHorizontal() ? LayoutOrientation.Horizontal : LayoutOrientation.Vertical), this.maxItemsInMainAxis, this.maxLines, this.overflow);
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i) {
        FlowLayoutOverflowState flowLayoutOverflowState = this.overflow;
        List list2 = (List) v.D0(1, list);
        IntrinsicMeasurable intrinsicMeasurable = list2 != null ? (IntrinsicMeasurable) v.C0(list2) : null;
        List list3 = (List) v.D0(2, list);
        flowLayoutOverflowState.m630setOverflowMeasurableshBUhpc$foundation_layout_release(intrinsicMeasurable, list3 != null ? (IntrinsicMeasurable) v.C0(list3) : null, isHorizontal(), ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
        if (isHorizontal()) {
            List<? extends IntrinsicMeasurable> list4 = (List) v.C0(list);
            if (list4 == null) {
                list4 = EmptyList.f4893a;
            }
            return intrinsicCrossAxisSize(list4, i, intrinsicMeasureScope.mo375roundToPx0680j_4(this.mainAxisSpacing), intrinsicMeasureScope.mo375roundToPx0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
        }
        List<? extends IntrinsicMeasurable> list5 = (List) v.C0(list);
        if (list5 == null) {
            list5 = EmptyList.f4893a;
        }
        return minIntrinsicMainAxisSize(list5, i, intrinsicMeasureScope.mo375roundToPx0680j_4(this.mainAxisSpacing), intrinsicMeasureScope.mo375roundToPx0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
    }

    public final int minIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> measurables, int crossAxisAvailable, int mainAxisSpacing, int crossAxisSpacing, int maxItemsInMainAxis, int maxLines, FlowLayoutOverflowState overflow) {
        return FlowLayoutKt.minIntrinsicMainAxisSize(measurables, this.minMainAxisIntrinsicItemSize, this.minCrossAxisIntrinsicItemSize, crossAxisAvailable, mainAxisSpacing, crossAxisSpacing, maxItemsInMainAxis, maxLines, overflow);
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i) {
        FlowLayoutOverflowState flowLayoutOverflowState = this.overflow;
        List list2 = (List) v.D0(1, list);
        IntrinsicMeasurable intrinsicMeasurable = list2 != null ? (IntrinsicMeasurable) v.C0(list2) : null;
        List list3 = (List) v.D0(2, list);
        flowLayoutOverflowState.m630setOverflowMeasurableshBUhpc$foundation_layout_release(intrinsicMeasurable, list3 != null ? (IntrinsicMeasurable) v.C0(list3) : null, isHorizontal(), ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
        if (isHorizontal()) {
            List<? extends IntrinsicMeasurable> list4 = (List) v.C0(list);
            if (list4 == null) {
                list4 = EmptyList.f4893a;
            }
            return minIntrinsicMainAxisSize(list4, i, intrinsicMeasureScope.mo375roundToPx0680j_4(this.mainAxisSpacing), intrinsicMeasureScope.mo375roundToPx0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
        }
        List<? extends IntrinsicMeasurable> list5 = (List) v.C0(list);
        if (list5 == null) {
            list5 = EmptyList.f4893a;
        }
        return intrinsicCrossAxisSize(list5, i, intrinsicMeasureScope.mo375roundToPx0680j_4(this.mainAxisSpacing), intrinsicMeasureScope.mo375roundToPx0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FlowMeasurePolicy(isHorizontal=");
        sb.append(this.isHorizontal);
        sb.append(", horizontalArrangement=");
        sb.append(this.horizontalArrangement);
        sb.append(", verticalArrangement=");
        sb.append(this.verticalArrangement);
        sb.append(", mainAxisSpacing=");
        androidx.appfunctions.metadata.a.B(sb, ", crossAxisAlignment=", this.mainAxisSpacing);
        sb.append(this.crossAxisAlignment);
        sb.append(", crossAxisArrangementSpacing=");
        androidx.appfunctions.metadata.a.B(sb, ", maxItemsInMainAxis=", this.crossAxisArrangementSpacing);
        sb.append(this.maxItemsInMainAxis);
        sb.append(", maxLines=");
        sb.append(this.maxLines);
        sb.append(", overflow=");
        sb.append(this.overflow);
        sb.append(')');
        return sb.toString();
    }

    private FlowMeasurePolicy(boolean z10, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f, CrossAxisAlignment crossAxisAlignment, float f7, int i, int i6, FlowLayoutOverflowState flowLayoutOverflowState) {
        this.isHorizontal = z10;
        this.horizontalArrangement = horizontal;
        this.verticalArrangement = vertical;
        this.mainAxisSpacing = f;
        this.crossAxisAlignment = crossAxisAlignment;
        this.crossAxisArrangementSpacing = f7;
        this.maxItemsInMainAxis = i;
        this.maxLines = i6;
        this.overflow = flowLayoutOverflowState;
        this.maxMainAxisIntrinsicItemSize = isHorizontal() ? new o() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$maxMainAxisIntrinsicItemSize$1
            @Override // S7.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i10, int i11) {
                return Integer.valueOf(intrinsicMeasurable.maxIntrinsicWidth(i11));
            }
        } : new o() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$maxMainAxisIntrinsicItemSize$2
            @Override // S7.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i10, int i11) {
                return Integer.valueOf(intrinsicMeasurable.maxIntrinsicHeight(i11));
            }
        };
        this.maxCrossAxisIntrinsicItemSize = isHorizontal() ? new o() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$maxCrossAxisIntrinsicItemSize$1
            @Override // S7.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i10, int i11) {
                return Integer.valueOf(intrinsicMeasurable.maxIntrinsicHeight(i11));
            }
        } : new o() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$maxCrossAxisIntrinsicItemSize$2
            @Override // S7.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i10, int i11) {
                return Integer.valueOf(intrinsicMeasurable.maxIntrinsicWidth(i11));
            }
        };
        this.minCrossAxisIntrinsicItemSize = isHorizontal() ? new o() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$minCrossAxisIntrinsicItemSize$1
            @Override // S7.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i10, int i11) {
                return Integer.valueOf(intrinsicMeasurable.minIntrinsicHeight(i11));
            }
        } : new o() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$minCrossAxisIntrinsicItemSize$2
            @Override // S7.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i10, int i11) {
                return Integer.valueOf(intrinsicMeasurable.minIntrinsicWidth(i11));
            }
        };
        this.minMainAxisIntrinsicItemSize = isHorizontal() ? new o() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$minMainAxisIntrinsicItemSize$1
            @Override // S7.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i10, int i11) {
                return Integer.valueOf(intrinsicMeasurable.minIntrinsicWidth(i11));
            }
        } : new o() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$minMainAxisIntrinsicItemSize$2
            @Override // S7.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i10, int i11) {
                return Integer.valueOf(intrinsicMeasurable.minIntrinsicHeight(i11));
            }
        };
    }
}
