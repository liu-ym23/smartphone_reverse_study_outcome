package androidx.compose.material3;

import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ,\u0010\u0014\u001a\u00020\u0011*\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0019\u001a\u00020\u0017*\u00020\u00152\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00160\f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ)\u0010\u001c\u001a\u00020\u0017*\u00020\u00152\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00160\f2\u0006\u0010\u001b\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001c\u0010\u001aR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010\u0006\u001a\u00020\u00058\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0006\u0010 \u001a\u0004\b!\u0010\"R\u001d\u0010\u0007\u001a\u00020\u00058\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0007\u0010 \u001a\u0004\b#\u0010\"R\u001d\u0010\b\u001a\u00020\u00058\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\b\u0010 \u001a\u0004\b$\u0010\"\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006%"}, d2 = {"Landroidx/compose/material3/StartIconMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "Lkotlin/Function0;", "", "animationProgress", "Landroidx/compose/ui/unit/Dp;", "indicatorHorizontalPadding", "indicatorVerticalPadding", "startIconToLabelHorizontalPadding", AppAgent.CONSTRUCT, "(LS7/a;FFFLkotlin/jvm/internal/e;)V", "Landroidx/compose/ui/layout/MeasureScope;", "", "Landroidx/compose/ui/layout/Measurable;", "measurables", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "measure", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "", "height", "maxIntrinsicWidth", "(Landroidx/compose/ui/layout/IntrinsicMeasureScope;Ljava/util/List;I)I", "width", "maxIntrinsicHeight", "LS7/a;", "getAnimationProgress", "()LS7/a;", "F", "getIndicatorHorizontalPadding-D9Ej5fM", "()F", "getIndicatorVerticalPadding-D9Ej5fM", "getStartIconToLabelHorizontalPadding-D9Ej5fM", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class StartIconMeasurePolicy implements MeasurePolicy {
    private final S7.a animationProgress;
    private final float indicatorHorizontalPadding;
    private final float indicatorVerticalPadding;
    private final float startIconToLabelHorizontalPadding;

    public /* synthetic */ StartIconMeasurePolicy(S7.a aVar, float f, float f7, float f9, e eVar) {
        this(aVar, f, f7, f9);
    }

    public final S7.a getAnimationProgress() {
        return this.animationProgress;
    }

    /* renamed from: getIndicatorHorizontalPadding-D9Ej5fM, reason: not valid java name and from getter */
    public final float getIndicatorHorizontalPadding() {
        return this.indicatorHorizontalPadding;
    }

    /* renamed from: getIndicatorVerticalPadding-D9Ej5fM, reason: not valid java name and from getter */
    public final float getIndicatorVerticalPadding() {
        return this.indicatorVerticalPadding;
    }

    /* renamed from: getStartIconToLabelHorizontalPadding-D9Ej5fM, reason: not valid java name and from getter */
    public final float getStartIconToLabelHorizontalPadding() {
        return this.startIconToLabelHorizontalPadding;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            IntrinsicMeasurable intrinsicMeasurable = list.get(i6);
            if (k.b(TextFieldImplKt.getLayoutId(intrinsicMeasurable), "icon")) {
                int iMaxIntrinsicHeight = intrinsicMeasurable.maxIntrinsicHeight(i);
                int size2 = list.size();
                for (int i10 = 0; i10 < size2; i10++) {
                    IntrinsicMeasurable intrinsicMeasurable2 = list.get(i10);
                    if (k.b(TextFieldImplKt.getLayoutId(intrinsicMeasurable2), "label")) {
                        return Math.max(iMaxIntrinsicHeight, intrinsicMeasurable2.maxIntrinsicHeight(i)) + intrinsicMeasureScope.mo375roundToPx0680j_4(Dp.m6844constructorimpl(this.indicatorVerticalPadding * 2));
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            IntrinsicMeasurable intrinsicMeasurable = list.get(i6);
            if (k.b(TextFieldImplKt.getLayoutId(intrinsicMeasurable), "icon")) {
                int iMaxIntrinsicWidth = intrinsicMeasurable.maxIntrinsicWidth(i);
                int size2 = list.size();
                for (int i10 = 0; i10 < size2; i10++) {
                    IntrinsicMeasurable intrinsicMeasurable2 = list.get(i10);
                    if (k.b(TextFieldImplKt.getLayoutId(intrinsicMeasurable2), "label")) {
                        return iMaxIntrinsicWidth + intrinsicMeasurable2.maxIntrinsicWidth(i) + intrinsicMeasureScope.mo375roundToPx0680j_4(Dp.m6844constructorimpl(Dp.m6844constructorimpl(this.indicatorHorizontalPadding * 2) + this.startIconToLabelHorizontalPadding));
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo37measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
        MeasureScope measureScope2 = measureScope;
        float fFloatValue = ((Number) this.animationProgress.invoke()).floatValue();
        long jM6787copyZbe2FdA$default = Constraints.m6787copyZbe2FdA$default(j5, 0, 0, 0, 0, 10, null);
        float f = 2;
        long jM6816offsetNN6EwU = ConstraintsKt.m6816offsetNN6EwU(jM6787copyZbe2FdA$default, -measureScope2.mo375roundToPx0680j_4(Dp.m6844constructorimpl(this.indicatorHorizontalPadding * f)), -measureScope2.mo375roundToPx0680j_4(Dp.m6844constructorimpl(this.indicatorVerticalPadding * f)));
        int size = list.size();
        int i = 0;
        while (i < size) {
            Measurable measurable = list.get(i);
            if (k.b(LayoutIdKt.getLayoutId(measurable), "icon")) {
                Placeable placeableMo5549measureBRTryo0 = measurable.mo5549measureBRTryo0(jM6816offsetNN6EwU);
                int size2 = list.size();
                int i6 = 0;
                while (i6 < size2) {
                    Measurable measurable2 = list.get(i6);
                    if (k.b(LayoutIdKt.getLayoutId(measurable2), "label")) {
                        Placeable placeableMo5549measureBRTryo02 = measurable2.mo5549measureBRTryo0(ConstraintsKt.m6817offsetNN6EwU$default(jM6816offsetNN6EwU, -(measureScope2.mo375roundToPx0680j_4(this.startIconToLabelHorizontalPadding) + placeableMo5549measureBRTryo0.getWidth()), 0, 2, null));
                        int iMo375roundToPx0680j_4 = measureScope2.mo375roundToPx0680j_4(Dp.m6844constructorimpl(Dp.m6844constructorimpl(this.indicatorHorizontalPadding * f) + this.startIconToLabelHorizontalPadding)) + placeableMo5549measureBRTryo02.getWidth() + placeableMo5549measureBRTryo0.getWidth();
                        int iMo375roundToPx0680j_42 = measureScope2.mo375roundToPx0680j_4(Dp.m6844constructorimpl(this.indicatorVerticalPadding * f)) + Math.max(placeableMo5549measureBRTryo0.getHeight(), placeableMo5549measureBRTryo02.getHeight());
                        int iU = U7.a.U(iMo375roundToPx0680j_4 * fFloatValue);
                        int size3 = list.size();
                        int i10 = 0;
                        while (i10 < size3) {
                            Measurable measurable3 = list.get(i10);
                            if (k.b(LayoutIdKt.getLayoutId(measurable3), "indicatorRipple")) {
                                Placeable placeableMo5549measureBRTryo03 = measurable3.mo5549measureBRTryo0(ConstraintsKt.m6812constrainN9IONVI(jM6787copyZbe2FdA$default, Constraints.INSTANCE.m6807fixedJhjzzOo(iMo375roundToPx0680j_4, iMo375roundToPx0680j_42)));
                                int size4 = list.size();
                                int i11 = 0;
                                while (i11 < size4) {
                                    Measurable measurable4 = list.get(i11);
                                    if (k.b(LayoutIdKt.getLayoutId(measurable4), "indicator")) {
                                        return NavigationItemKt.m2083placeLabelAndStartIconnru01g4(measureScope2, placeableMo5549measureBRTryo02, placeableMo5549measureBRTryo0, placeableMo5549measureBRTryo03, measurable4.mo5549measureBRTryo0(ConstraintsKt.m6812constrainN9IONVI(jM6787copyZbe2FdA$default, Constraints.INSTANCE.m6807fixedJhjzzOo(iU, iMo375roundToPx0680j_42))), j5, this.startIconToLabelHorizontalPadding);
                                    }
                                    i11++;
                                    placeableMo5549measureBRTryo02 = placeableMo5549measureBRTryo02;
                                    placeableMo5549measureBRTryo0 = placeableMo5549measureBRTryo0;
                                    measureScope2 = measureScope;
                                }
                                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                            }
                            i10++;
                            placeableMo5549measureBRTryo0 = placeableMo5549measureBRTryo0;
                            measureScope2 = measureScope;
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                    i6++;
                    measureScope2 = measureScope;
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            i++;
            measureScope2 = measureScope;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    private StartIconMeasurePolicy(S7.a aVar, float f, float f7, float f9) {
        this.animationProgress = aVar;
        this.indicatorHorizontalPadding = f;
        this.indicatorVerticalPadding = f7;
        this.startIconToLabelHorizontalPadding = f9;
    }
}
