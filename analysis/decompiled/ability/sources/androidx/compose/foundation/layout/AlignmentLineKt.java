package androidx.compose.foundation.layout;

import C7.r;
import S7.k;
import androidx.compose.foundation.b;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import g1.AbstractC1451a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a>\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00162\b\b\u0002\u0010\u000b\u001a\u00020\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a*\u0010\u0019\u001a\u00020\u0013*\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\n2\b\b\u0002\u0010\u001b\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a*\u0010\u0019\u001a\u00020\u0013*\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006 "}, d2 = {"horizontal", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getHorizontal", "(Landroidx/compose/ui/layout/AlignmentLine;)Z", "alignmentLineOffsetMeasure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "alignmentLine", "before", "Landroidx/compose/ui/unit/Dp;", "after", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "alignmentLineOffsetMeasure-tjqqzMA", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/AlignmentLine;FFLandroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "paddingFrom", "Landroidx/compose/ui/Modifier;", "paddingFrom-4j6BHR0", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/AlignmentLine;FF)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/unit/TextUnit;", "paddingFrom-Y_r0B1c", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/AlignmentLine;JJ)Landroidx/compose/ui/Modifier;", "paddingFromBaseline", "top", "bottom", "paddingFromBaseline-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "paddingFromBaseline-wCyjxdI", "(Landroidx/compose/ui/Modifier;JJ)Landroidx/compose/ui/Modifier;", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AlignmentLineKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: alignmentLineOffsetMeasure-tjqqzMA, reason: not valid java name */
    public static final MeasureResult m549alignmentLineOffsetMeasuretjqqzMA(MeasureScope measureScope, final AlignmentLine alignmentLine, final float f, float f7, Measurable measurable, long j5) {
        final Placeable placeableMo5549measureBRTryo0 = measurable.mo5549measureBRTryo0(getHorizontal(alignmentLine) ? Constraints.m6787copyZbe2FdA$default(j5, 0, 0, 0, 0, 11, null) : Constraints.m6787copyZbe2FdA$default(j5, 0, 0, 0, 0, 14, null));
        int i = placeableMo5549measureBRTryo0.get(alignmentLine);
        if (i == Integer.MIN_VALUE) {
            i = 0;
        }
        int height = getHorizontal(alignmentLine) ? placeableMo5549measureBRTryo0.getHeight() : placeableMo5549measureBRTryo0.getWidth();
        int iM6796getMaxHeightimpl = getHorizontal(alignmentLine) ? Constraints.m6796getMaxHeightimpl(j5) : Constraints.m6797getMaxWidthimpl(j5);
        Dp.Companion companion = Dp.INSTANCE;
        int i6 = iM6796getMaxHeightimpl - height;
        final int iU = AbstractC1451a.u((!Dp.m6849equalsimpl0(f, companion.m6864getUnspecifiedD9Ej5fM()) ? measureScope.mo375roundToPx0680j_4(f) : 0) - i, 0, i6);
        final int iU2 = AbstractC1451a.u(((!Dp.m6849equalsimpl0(f7, companion.m6864getUnspecifiedD9Ej5fM()) ? measureScope.mo375roundToPx0680j_4(f7) : 0) - height) + i, 0, i6 - iU);
        int width = getHorizontal(alignmentLine) ? placeableMo5549measureBRTryo0.getWidth() : Math.max(placeableMo5549measureBRTryo0.getWidth() + iU + iU2, Constraints.m6799getMinWidthimpl(j5));
        final int iMax = getHorizontal(alignmentLine) ? Math.max(placeableMo5549measureBRTryo0.getHeight() + iU + iU2, Constraints.m6798getMinHeightimpl(j5)) : placeableMo5549measureBRTryo0.getHeight();
        final int i10 = width;
        return MeasureScope.layout$default(measureScope, i10, iMax, null, new k() { // from class: androidx.compose.foundation.layout.AlignmentLineKt$alignmentLineOffsetMeasure$1
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
                int width2;
                if (AlignmentLineKt.getHorizontal(alignmentLine)) {
                    width2 = 0;
                } else {
                    width2 = !Dp.m6849equalsimpl0(f, Dp.INSTANCE.m6864getUnspecifiedD9Ej5fM()) ? iU : (i10 - iU2) - placeableMo5549measureBRTryo0.getWidth();
                }
                Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo5549measureBRTryo0, width2, AlignmentLineKt.getHorizontal(alignmentLine) ? !Dp.m6849equalsimpl0(f, Dp.INSTANCE.m6864getUnspecifiedD9Ej5fM()) ? iU : (iMax - iU2) - placeableMo5549measureBRTryo0.getHeight() : 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getHorizontal(AlignmentLine alignmentLine) {
        return alignmentLine instanceof HorizontalAlignmentLine;
    }

    @Stable
    /* renamed from: paddingFrom-4j6BHR0, reason: not valid java name */
    public static final Modifier m550paddingFrom4j6BHR0(Modifier modifier, final AlignmentLine alignmentLine, final float f, final float f7) {
        return modifier.then(new AlignmentLineOffsetDpElement(alignmentLine, f, f7, InspectableValueKt.isDebugInspectorInfoEnabled() ? new k() { // from class: androidx.compose.foundation.layout.AlignmentLineKt$paddingFrom-4j6BHR0$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return r.f317a;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("paddingFrom");
                inspectorInfo.getProperties().set("alignmentLine", alignmentLine);
                b.j(f, inspectorInfo.getProperties(), "before", inspectorInfo).set("after", Dp.m6842boximpl(f7));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* renamed from: paddingFrom-4j6BHR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m551paddingFrom4j6BHR0$default(Modifier modifier, AlignmentLine alignmentLine, float f, float f7, int i, Object obj) {
        if ((i & 2) != 0) {
            f = Dp.INSTANCE.m6864getUnspecifiedD9Ej5fM();
        }
        if ((i & 4) != 0) {
            f7 = Dp.INSTANCE.m6864getUnspecifiedD9Ej5fM();
        }
        return m550paddingFrom4j6BHR0(modifier, alignmentLine, f, f7);
    }

    @Stable
    /* renamed from: paddingFrom-Y_r0B1c, reason: not valid java name */
    public static final Modifier m552paddingFromY_r0B1c(Modifier modifier, final AlignmentLine alignmentLine, long j5, long j6) {
        AlignmentLine alignmentLine2;
        final long j10;
        final long j11;
        k noInspectorInfo;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            j10 = j5;
            j11 = j6;
            noInspectorInfo = new k() { // from class: androidx.compose.foundation.layout.AlignmentLineKt$paddingFrom-Y_r0B1c$$inlined$debugInspectorInfo$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((InspectorInfo) obj);
                    return r.f317a;
                }

                public final void invoke(InspectorInfo inspectorInfo) {
                    inspectorInfo.setName("paddingFrom");
                    inspectorInfo.getProperties().set("alignmentLine", alignmentLine);
                    inspectorInfo.getProperties().set("before", TextUnit.m7028boximpl(j10));
                    inspectorInfo.getProperties().set("after", TextUnit.m7028boximpl(j11));
                }
            };
            alignmentLine2 = alignmentLine;
        } else {
            alignmentLine2 = alignmentLine;
            j10 = j5;
            j11 = j6;
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new AlignmentLineOffsetTextUnitElement(alignmentLine2, j10, j11, noInspectorInfo, null));
    }

    /* renamed from: paddingFrom-Y_r0B1c$default, reason: not valid java name */
    public static /* synthetic */ Modifier m553paddingFromY_r0B1c$default(Modifier modifier, AlignmentLine alignmentLine, long j5, long j6, int i, Object obj) {
        if ((i & 2) != 0) {
            j5 = TextUnit.INSTANCE.m7049getUnspecifiedXSAIIZE();
        }
        long j10 = j5;
        if ((i & 4) != 0) {
            j6 = TextUnit.INSTANCE.m7049getUnspecifiedXSAIIZE();
        }
        return m552paddingFromY_r0B1c(modifier, alignmentLine, j10, j6);
    }

    @Stable
    /* renamed from: paddingFromBaseline-VpY3zN4, reason: not valid java name */
    public static final Modifier m554paddingFromBaselineVpY3zN4(Modifier modifier, float f, float f7) {
        Dp.Companion companion = Dp.INSTANCE;
        return modifier.then(!Dp.m6849equalsimpl0(f, companion.m6864getUnspecifiedD9Ej5fM()) ? m551paddingFrom4j6BHR0$default(Modifier.INSTANCE, androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline(), f, 0.0f, 4, null) : Modifier.INSTANCE).then(!Dp.m6849equalsimpl0(f7, companion.m6864getUnspecifiedD9Ej5fM()) ? m551paddingFrom4j6BHR0$default(Modifier.INSTANCE, androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline(), 0.0f, f7, 2, null) : Modifier.INSTANCE);
    }

    /* renamed from: paddingFromBaseline-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m555paddingFromBaselineVpY3zN4$default(Modifier modifier, float f, float f7, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.INSTANCE.m6864getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f7 = Dp.INSTANCE.m6864getUnspecifiedD9Ej5fM();
        }
        return m554paddingFromBaselineVpY3zN4(modifier, f, f7);
    }

    @Stable
    /* renamed from: paddingFromBaseline-wCyjxdI, reason: not valid java name */
    public static final Modifier m556paddingFromBaselinewCyjxdI(Modifier modifier, long j5, long j6) {
        return modifier.then(!TextUnitKt.m7056isUnspecifiedR2X_6o(j5) ? m553paddingFromY_r0B1c$default(Modifier.INSTANCE, androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline(), j5, 0L, 4, null) : Modifier.INSTANCE).then(!TextUnitKt.m7056isUnspecifiedR2X_6o(j6) ? m553paddingFromY_r0B1c$default(Modifier.INSTANCE, androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline(), 0L, j6, 2, null) : Modifier.INSTANCE);
    }

    /* renamed from: paddingFromBaseline-wCyjxdI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m557paddingFromBaselinewCyjxdI$default(Modifier modifier, long j5, long j6, int i, Object obj) {
        if ((i & 1) != 0) {
            j5 = TextUnit.INSTANCE.m7049getUnspecifiedXSAIIZE();
        }
        if ((i & 2) != 0) {
            j6 = TextUnit.INSTANCE.m7049getUnspecifiedXSAIIZE();
        }
        return m556paddingFromBaselinewCyjxdI(modifier, j5, j6);
    }
}
