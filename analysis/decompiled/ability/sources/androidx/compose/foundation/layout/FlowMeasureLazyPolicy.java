package androidx.compose.foundation.layout;

import C7.r;
import D7.v;
import S7.k;
import S7.n;
import S7.p;
import androidx.appfunctions.metadata.a;
import androidx.compose.foundation.b;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.FlowLayoutOverflow;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0010\b\u0082\b\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0017\u0010\u0017\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0002\b\u00160\u0013\u0012\u001d\u0010\u001a\u001a\u0019\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00150\u0018¢\u0006\u0002\b\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001e\u0010#\u001a\u00020 *\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u0016\u0010&\u001a\u00020\bHÂ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010%J\u0016\u0010(\u001a\u00020\bHÂ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010%J\u0010\u0010)\u001a\u00020\rHÂ\u0003¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\rHÂ\u0003¢\u0006\u0004\b+\u0010*J\u0010\u0010,\u001a\u00020\rHÂ\u0003¢\u0006\u0004\b,\u0010*J\u0010\u0010-\u001a\u00020\u0011HÂ\u0003¢\u0006\u0004\b-\u0010.J!\u0010/\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0002\b\u00160\u0013HÂ\u0003¢\u0006\u0004\b/\u00100J'\u00101\u001a\u0019\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00150\u0018¢\u0006\u0002\b\u0016HÂ\u0003¢\u0006\u0004\b1\u00102J\u001f\u00103\u001a\u0014\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020 0\u0018¢\u0006\u0004\b3\u00104J\u0010\u00105\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b5\u00106J\u0010\u00107\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b7\u00108J\u0010\u00109\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b9\u0010:J\u0010\u0010;\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b;\u0010<J³\u0001\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u0019\b\u0002\u0010\u0017\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0002\b\u00160\u00132\u001f\b\u0002\u0010\u001a\u001a\u0019\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00150\u0018¢\u0006\u0002\b\u0016HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010>J\u0010\u0010A\u001a\u00020@HÖ\u0001¢\u0006\u0004\bA\u0010BJ\u0010\u0010C\u001a\u00020\rHÖ\u0001¢\u0006\u0004\bC\u0010*J\u001a\u0010F\u001a\u00020\u00022\b\u0010E\u001a\u0004\u0018\u00010DHÖ\u0003¢\u0006\u0004\bF\u0010GR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010H\u001a\u0004\b\u0003\u00106R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010I\u001a\u0004\bJ\u00108R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010K\u001a\u0004\bL\u0010:R\u001a\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\t\u0010MR\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010N\u001a\u0004\bO\u0010<R\u001a\u0010\f\u001a\u00020\b8\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\f\u0010MR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010PR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010PR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010PR\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010QR%\u0010\u0017\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0002\b\u00160\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010RR+\u0010\u001a\u001a\u0019\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00150\u0018¢\u0006\u0002\b\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010S\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006T"}, d2 = {"Landroidx/compose/foundation/layout/FlowMeasureLazyPolicy;", "Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;", "", "isHorizontal", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "verticalArrangement", "Landroidx/compose/ui/unit/Dp;", "mainAxisSpacing", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "crossAxisAlignment", "crossAxisArrangementSpacing", "", "itemCount", "maxLines", "maxItemsInMainAxis", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "overflow", "", "Lkotlin/Function0;", "LC7/r;", "Landroidx/compose/runtime/Composable;", "overflowComposables", "Lkotlin/Function2;", "Landroidx/compose/foundation/layout/FlowLineInfo;", "getComposable", AppAgent.CONSTRUCT, "(ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/layout/CrossAxisAlignment;FIIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Ljava/util/List;LS7/p;Lkotlin/jvm/internal/e;)V", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "measure-0kLqBqw", "(Landroidx/compose/ui/layout/SubcomposeMeasureScope;J)Landroidx/compose/ui/layout/MeasureResult;", "measure", "component4-D9Ej5fM", "()F", "component4", "component6-D9Ej5fM", "component6", "component7", "()I", "component8", "component9", "component10", "()Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "component11", "()Ljava/util/List;", "component12", "()LS7/p;", "getMeasurePolicy", "()LS7/n;", "component1", "()Z", "component2", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "component3", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "component5", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "copy-E4Q9ldg", "(ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/layout/CrossAxisAlignment;FIIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Ljava/util/List;LS7/p;)Landroidx/compose/foundation/layout/FlowMeasureLazyPolicy;", "copy", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getHorizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "getVerticalArrangement", "F", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "getCrossAxisAlignment", "I", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "Ljava/util/List;", "LS7/p;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final /* data */ class FlowMeasureLazyPolicy implements FlowLineMeasurePolicy {
    private final CrossAxisAlignment crossAxisAlignment;
    private final float crossAxisArrangementSpacing;
    private final p getComposable;
    private final Arrangement.Horizontal horizontalArrangement;
    private final boolean isHorizontal;
    private final int itemCount;
    private final float mainAxisSpacing;
    private final int maxItemsInMainAxis;
    private final int maxLines;
    private final FlowLayoutOverflowState overflow;
    private final List<n> overflowComposables;
    private final Arrangement.Vertical verticalArrangement;

    public /* synthetic */ FlowMeasureLazyPolicy(boolean z10, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f, CrossAxisAlignment crossAxisAlignment, float f7, int i, int i6, int i10, FlowLayoutOverflowState flowLayoutOverflowState, List list, p pVar, e eVar) {
        this(z10, horizontal, vertical, f, crossAxisAlignment, f7, i, i6, i10, flowLayoutOverflowState, list, pVar);
    }

    /* renamed from: component10, reason: from getter */
    private final FlowLayoutOverflowState getOverflow() {
        return this.overflow;
    }

    private final List<n> component11() {
        return this.overflowComposables;
    }

    /* renamed from: component12, reason: from getter */
    private final p getGetComposable() {
        return this.getComposable;
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
    private final int getItemCount() {
        return this.itemCount;
    }

    /* renamed from: component8, reason: from getter */
    private final int getMaxLines() {
        return this.maxLines;
    }

    /* renamed from: component9, reason: from getter */
    private final int getMaxItemsInMainAxis() {
        return this.maxItemsInMainAxis;
    }

    /* renamed from: copy-E4Q9ldg$default, reason: not valid java name */
    public static /* synthetic */ FlowMeasureLazyPolicy m640copyE4Q9ldg$default(FlowMeasureLazyPolicy flowMeasureLazyPolicy, boolean z10, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f, CrossAxisAlignment crossAxisAlignment, float f7, int i, int i6, int i10, FlowLayoutOverflowState flowLayoutOverflowState, List list, p pVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = flowMeasureLazyPolicy.isHorizontal;
        }
        if ((i11 & 2) != 0) {
            horizontal = flowMeasureLazyPolicy.horizontalArrangement;
        }
        if ((i11 & 4) != 0) {
            vertical = flowMeasureLazyPolicy.verticalArrangement;
        }
        if ((i11 & 8) != 0) {
            f = flowMeasureLazyPolicy.mainAxisSpacing;
        }
        if ((i11 & 16) != 0) {
            crossAxisAlignment = flowMeasureLazyPolicy.crossAxisAlignment;
        }
        if ((i11 & 32) != 0) {
            f7 = flowMeasureLazyPolicy.crossAxisArrangementSpacing;
        }
        if ((i11 & 64) != 0) {
            i = flowMeasureLazyPolicy.itemCount;
        }
        if ((i11 & 128) != 0) {
            i6 = flowMeasureLazyPolicy.maxLines;
        }
        if ((i11 & 256) != 0) {
            i10 = flowMeasureLazyPolicy.maxItemsInMainAxis;
        }
        if ((i11 & 512) != 0) {
            flowLayoutOverflowState = flowMeasureLazyPolicy.overflow;
        }
        if ((i11 & 1024) != 0) {
            list = flowMeasureLazyPolicy.overflowComposables;
        }
        if ((i11 & 2048) != 0) {
            pVar = flowMeasureLazyPolicy.getComposable;
        }
        List list2 = list;
        p pVar2 = pVar;
        int i12 = i10;
        FlowLayoutOverflowState flowLayoutOverflowState2 = flowLayoutOverflowState;
        int i13 = i;
        int i14 = i6;
        CrossAxisAlignment crossAxisAlignment2 = crossAxisAlignment;
        float f9 = f7;
        return flowMeasureLazyPolicy.m642copyE4Q9ldg(z10, horizontal, vertical, f, crossAxisAlignment2, f9, i13, i14, i12, flowLayoutOverflowState2, list2, pVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: measure-0kLqBqw, reason: not valid java name */
    public final MeasureResult m641measure0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, long j5) {
        if (this.itemCount <= 0 || this.maxLines == 0 || this.maxItemsInMainAxis == 0 || (Constraints.m6796getMaxHeightimpl(j5) == 0 && this.overflow.getType$foundation_layout_release() != FlowLayoutOverflow.OverflowType.Visible)) {
            return MeasureScope.layout$default(subcomposeMeasureScope, 0, 0, null, new k() { // from class: androidx.compose.foundation.layout.FlowMeasureLazyPolicy$measure$1
                public final void invoke(Placeable.PlacementScope placementScope) {
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Placeable.PlacementScope) obj);
                    return r.f317a;
                }
            }, 4, null);
        }
        ContextualFlowItemIterator contextualFlowItemIterator = new ContextualFlowItemIterator(this.itemCount, new n() { // from class: androidx.compose.foundation.layout.FlowMeasureLazyPolicy$measure$measurablesIterator$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // S7.n
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke(((Number) obj).intValue(), (FlowLineInfo) obj2);
            }

            public final List<Measurable> invoke(final int i, final FlowLineInfo flowLineInfo) {
                SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                Integer numValueOf = Integer.valueOf(i);
                final FlowMeasureLazyPolicy flowMeasureLazyPolicy = this;
                return subcomposeMeasureScope2.subcompose(numValueOf, ComposableLambdaKt.composableLambdaInstance(-195060736, true, new n() { // from class: androidx.compose.foundation.layout.FlowMeasureLazyPolicy$measure$measurablesIterator$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // S7.n
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return r.f317a;
                    }

                    @Composable
                    public final void invoke(Composer composer, int i6) {
                        if ((i6 & 3) == 2 && composer.getSkipping()) {
                            composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-195060736, i6, -1, "androidx.compose.foundation.layout.FlowMeasureLazyPolicy.measure.<anonymous>.<anonymous> (ContextualFlowLayout.kt:452)");
                        }
                        flowMeasureLazyPolicy.getComposable.invoke(Integer.valueOf(i), flowLineInfo, composer, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }));
            }
        });
        this.overflow.setItemCount$foundation_layout_release(this.itemCount);
        this.overflow.m631setOverflowMeasurablesVKLhPVY$foundation_layout_release(this, j5, new n() { // from class: androidx.compose.foundation.layout.FlowMeasureLazyPolicy$measure$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // S7.n
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke(((Boolean) obj).booleanValue(), ((Number) obj2).intValue());
            }

            public final Measurable invoke(boolean z10, int i) {
                n nVar = (n) v.D0(!z10 ? 1 : 0, this.this$0.overflowComposables);
                if (nVar == null) {
                    return null;
                }
                SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                FlowMeasureLazyPolicy flowMeasureLazyPolicy = this.this$0;
                StringBuilder sb = new StringBuilder();
                sb.append(z10);
                sb.append(flowMeasureLazyPolicy.itemCount);
                sb.append(i);
                return (Measurable) v.D0(0, subcomposeMeasureScope2.subcompose(sb.toString(), nVar));
            }
        });
        return FlowLayoutKt.m625breakDownItemsdi9J0FM(subcomposeMeasureScope, this, contextualFlowItemIterator, this.mainAxisSpacing, this.crossAxisArrangementSpacing, OrientationIndependentConstraints.m669constructorimpl(j5, isHorizontal() ? LayoutOrientation.Horizontal : LayoutOrientation.Vertical), this.maxItemsInMainAxis, this.maxLines, this.overflow);
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

    /* renamed from: copy-E4Q9ldg, reason: not valid java name */
    public final FlowMeasureLazyPolicy m642copyE4Q9ldg(boolean isHorizontal, Arrangement.Horizontal horizontalArrangement, Arrangement.Vertical verticalArrangement, float mainAxisSpacing, CrossAxisAlignment crossAxisAlignment, float crossAxisArrangementSpacing, int itemCount, int maxLines, int maxItemsInMainAxis, FlowLayoutOverflowState overflow, List<? extends n> overflowComposables, p getComposable) {
        return new FlowMeasureLazyPolicy(isHorizontal, horizontalArrangement, verticalArrangement, mainAxisSpacing, crossAxisAlignment, crossAxisArrangementSpacing, itemCount, maxLines, maxItemsInMainAxis, overflow, overflowComposables, getComposable, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FlowMeasureLazyPolicy)) {
            return false;
        }
        FlowMeasureLazyPolicy flowMeasureLazyPolicy = (FlowMeasureLazyPolicy) other;
        return this.isHorizontal == flowMeasureLazyPolicy.isHorizontal && kotlin.jvm.internal.k.b(this.horizontalArrangement, flowMeasureLazyPolicy.horizontalArrangement) && kotlin.jvm.internal.k.b(this.verticalArrangement, flowMeasureLazyPolicy.verticalArrangement) && Dp.m6849equalsimpl0(this.mainAxisSpacing, flowMeasureLazyPolicy.mainAxisSpacing) && kotlin.jvm.internal.k.b(this.crossAxisAlignment, flowMeasureLazyPolicy.crossAxisAlignment) && Dp.m6849equalsimpl0(this.crossAxisArrangementSpacing, flowMeasureLazyPolicy.crossAxisArrangementSpacing) && this.itemCount == flowMeasureLazyPolicy.itemCount && this.maxLines == flowMeasureLazyPolicy.maxLines && this.maxItemsInMainAxis == flowMeasureLazyPolicy.maxItemsInMainAxis && kotlin.jvm.internal.k.b(this.overflow, flowMeasureLazyPolicy.overflow) && kotlin.jvm.internal.k.b(this.overflowComposables, flowMeasureLazyPolicy.overflowComposables) && kotlin.jvm.internal.k.b(this.getComposable, flowMeasureLazyPolicy.getComposable);
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public CrossAxisAlignment getCrossAxisAlignment() {
        return this.crossAxisAlignment;
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public Arrangement.Horizontal getHorizontalArrangement() {
        return this.horizontalArrangement;
    }

    public final n getMeasurePolicy() {
        return new n() { // from class: androidx.compose.foundation.layout.FlowMeasureLazyPolicy.getMeasurePolicy.1
            {
                super(2);
            }

            @Override // S7.n
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return m643invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).getValue());
            }

            /* renamed from: invoke-0kLqBqw, reason: not valid java name */
            public final MeasureResult m643invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j5) {
                return FlowMeasureLazyPolicy.this.m641measure0kLqBqw(subcomposeMeasureScope, j5);
            }
        };
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public Arrangement.Vertical getVerticalArrangement() {
        return this.verticalArrangement;
    }

    public int hashCode() {
        return this.getComposable.hashCode() + a.e(this.overflowComposables, (this.overflow.hashCode() + androidx.constraintlayout.core.dsl.a.a(this.maxItemsInMainAxis, androidx.constraintlayout.core.dsl.a.a(this.maxLines, androidx.constraintlayout.core.dsl.a.a(this.itemCount, b.b(this.crossAxisArrangementSpacing, (this.crossAxisAlignment.hashCode() + b.b(this.mainAxisSpacing, (this.verticalArrangement.hashCode() + ((this.horizontalArrangement.hashCode() + (Boolean.hashCode(this.isHorizontal) * 31)) * 31)) * 31, 31)) * 31, 31), 31), 31), 31)) * 31, 31);
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public boolean isHorizontal() {
        return this.isHorizontal;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FlowMeasureLazyPolicy(isHorizontal=");
        sb.append(this.isHorizontal);
        sb.append(", horizontalArrangement=");
        sb.append(this.horizontalArrangement);
        sb.append(", verticalArrangement=");
        sb.append(this.verticalArrangement);
        sb.append(", mainAxisSpacing=");
        a.B(sb, ", crossAxisAlignment=", this.mainAxisSpacing);
        sb.append(this.crossAxisAlignment);
        sb.append(", crossAxisArrangementSpacing=");
        a.B(sb, ", itemCount=", this.crossAxisArrangementSpacing);
        sb.append(this.itemCount);
        sb.append(", maxLines=");
        sb.append(this.maxLines);
        sb.append(", maxItemsInMainAxis=");
        sb.append(this.maxItemsInMainAxis);
        sb.append(", overflow=");
        sb.append(this.overflow);
        sb.append(", overflowComposables=");
        sb.append(this.overflowComposables);
        sb.append(", getComposable=");
        sb.append(this.getComposable);
        sb.append(')');
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private FlowMeasureLazyPolicy(boolean z10, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f, CrossAxisAlignment crossAxisAlignment, float f7, int i, int i6, int i10, FlowLayoutOverflowState flowLayoutOverflowState, List<? extends n> list, p pVar) {
        this.isHorizontal = z10;
        this.horizontalArrangement = horizontal;
        this.verticalArrangement = vertical;
        this.mainAxisSpacing = f;
        this.crossAxisAlignment = crossAxisAlignment;
        this.crossAxisArrangementSpacing = f7;
        this.itemCount = i;
        this.maxLines = i6;
        this.maxItemsInMainAxis = i10;
        this.overflow = flowLayoutOverflowState;
        this.overflowComposables = list;
        this.getComposable = pVar;
    }
}
