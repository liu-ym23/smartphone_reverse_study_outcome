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

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ,\u0010\u0017\u001a\u00020\u0014*\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u001c\u001a\u00020\u001a*\u00020\u00182\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00190\u000f2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010!\u001a\u0004\b\"\u0010#R\u001d\u0010\b\u001a\u00020\u00078\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\b\u0010$\u001a\u0004\b%\u0010&R\u001d\u0010\t\u001a\u00020\u00078\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\t\u0010$\u001a\u0004\b'\u0010&R\u001d\u0010\n\u001a\u00020\u00078\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\n\u0010$\u001a\u0004\b(\u0010&R\u001d\u0010\u000b\u001a\u00020\u00078\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000b\u0010$\u001a\u0004\b)\u0010&\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006*"}, d2 = {"Landroidx/compose/material3/TopIconOrIconOnlyMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "", "hasLabel", "Lkotlin/Function0;", "", "animationProgress", "Landroidx/compose/ui/unit/Dp;", "indicatorHorizontalPadding", "indicatorVerticalPadding", "indicatorToLabelVerticalPadding", "topIconItemVerticalPadding", AppAgent.CONSTRUCT, "(ZLS7/a;FFFFLkotlin/jvm/internal/e;)V", "Landroidx/compose/ui/layout/MeasureScope;", "", "Landroidx/compose/ui/layout/Measurable;", "measurables", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "measure", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "", "width", "maxIntrinsicHeight", "(Landroidx/compose/ui/layout/IntrinsicMeasureScope;Ljava/util/List;I)I", "Z", "getHasLabel", "()Z", "LS7/a;", "getAnimationProgress", "()LS7/a;", "F", "getIndicatorHorizontalPadding-D9Ej5fM", "()F", "getIndicatorVerticalPadding-D9Ej5fM", "getIndicatorToLabelVerticalPadding-D9Ej5fM", "getTopIconItemVerticalPadding-D9Ej5fM", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class TopIconOrIconOnlyMeasurePolicy implements MeasurePolicy {
    private final S7.a animationProgress;
    private final boolean hasLabel;
    private final float indicatorHorizontalPadding;
    private final float indicatorToLabelVerticalPadding;
    private final float indicatorVerticalPadding;
    private final float topIconItemVerticalPadding;

    public /* synthetic */ TopIconOrIconOnlyMeasurePolicy(boolean z10, S7.a aVar, float f, float f7, float f9, float f10, e eVar) {
        this(z10, aVar, f, f7, f9, f10);
    }

    public final S7.a getAnimationProgress() {
        return this.animationProgress;
    }

    public final boolean getHasLabel() {
        return this.hasLabel;
    }

    /* renamed from: getIndicatorHorizontalPadding-D9Ej5fM, reason: not valid java name and from getter */
    public final float getIndicatorHorizontalPadding() {
        return this.indicatorHorizontalPadding;
    }

    /* renamed from: getIndicatorToLabelVerticalPadding-D9Ej5fM, reason: not valid java name and from getter */
    public final float getIndicatorToLabelVerticalPadding() {
        return this.indicatorToLabelVerticalPadding;
    }

    /* renamed from: getIndicatorVerticalPadding-D9Ej5fM, reason: not valid java name and from getter */
    public final float getIndicatorVerticalPadding() {
        return this.indicatorVerticalPadding;
    }

    /* renamed from: getTopIconItemVerticalPadding-D9Ej5fM, reason: not valid java name and from getter */
    public final float getTopIconItemVerticalPadding() {
        return this.topIconItemVerticalPadding;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        IntrinsicMeasurable intrinsicMeasurable;
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            IntrinsicMeasurable intrinsicMeasurable2 = list.get(i6);
            if (k.b(TextFieldImplKt.getLayoutId(intrinsicMeasurable2), "icon")) {
                int iMaxIntrinsicHeight = intrinsicMeasurable2.maxIntrinsicHeight(i);
                int size2 = list.size();
                int i10 = 0;
                while (true) {
                    if (i10 >= size2) {
                        intrinsicMeasurable = null;
                        break;
                    }
                    intrinsicMeasurable = list.get(i10);
                    if (k.b(TextFieldImplKt.getLayoutId(intrinsicMeasurable), "label")) {
                        break;
                    }
                    i10++;
                }
                IntrinsicMeasurable intrinsicMeasurable3 = intrinsicMeasurable;
                int iMaxIntrinsicHeight2 = intrinsicMeasurable3 != null ? intrinsicMeasurable3.maxIntrinsicHeight(i) : 0;
                float f = 2;
                return iMaxIntrinsicHeight + iMaxIntrinsicHeight2 + intrinsicMeasureScope.mo375roundToPx0680j_4(Dp.m6844constructorimpl(Dp.m6844constructorimpl(Dp.m6844constructorimpl(this.indicatorVerticalPadding * f) + Dp.m6844constructorimpl(this.topIconItemVerticalPadding * f)) + this.indicatorToLabelVerticalPadding));
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
        int size = list.size();
        int i = 0;
        int i6 = 0;
        while (i6 < size) {
            Measurable measurable = list.get(i6);
            if (k.b(LayoutIdKt.getLayoutId(measurable), "icon")) {
                float f = 2;
                Placeable placeableMo5549measureBRTryo0 = measurable.mo5549measureBRTryo0(ConstraintsKt.m6816offsetNN6EwU(jM6787copyZbe2FdA$default, -measureScope2.mo375roundToPx0680j_4(Dp.m6844constructorimpl(this.indicatorHorizontalPadding * f)), -measureScope2.mo375roundToPx0680j_4(Dp.m6844constructorimpl(this.indicatorVerticalPadding * f))));
                int iMo375roundToPx0680j_4 = measureScope2.mo375roundToPx0680j_4(Dp.m6844constructorimpl(this.indicatorHorizontalPadding * f)) + placeableMo5549measureBRTryo0.getWidth();
                int iMo375roundToPx0680j_42 = measureScope2.mo375roundToPx0680j_4(Dp.m6844constructorimpl(this.indicatorVerticalPadding * f)) + placeableMo5549measureBRTryo0.getHeight();
                int iU = U7.a.U(iMo375roundToPx0680j_4 * fFloatValue);
                int size2 = list.size();
                int i10 = 0;
                while (i10 < size2) {
                    Measurable measurable2 = list.get(i10);
                    if (k.b(LayoutIdKt.getLayoutId(measurable2), "indicatorRipple")) {
                        Placeable placeableMo5549measureBRTryo02 = measurable2.mo5549measureBRTryo0(ConstraintsKt.m6812constrainN9IONVI(jM6787copyZbe2FdA$default, Constraints.INSTANCE.m6807fixedJhjzzOo(iMo375roundToPx0680j_4, iMo375roundToPx0680j_42)));
                        int size3 = list.size();
                        int i11 = 0;
                        while (i11 < size3) {
                            Measurable measurable3 = list.get(i11);
                            if (k.b(LayoutIdKt.getLayoutId(measurable3), "indicator")) {
                                Placeable placeableMo5549measureBRTryo03 = measurable3.mo5549measureBRTryo0(ConstraintsKt.m6812constrainN9IONVI(jM6787copyZbe2FdA$default, Constraints.INSTANCE.m6807fixedJhjzzOo(iU, iMo375roundToPx0680j_42)));
                                if (!this.hasLabel) {
                                    return NavigationItemKt.m2082placeIconX9ElhV4(measureScope2, placeableMo5549measureBRTryo0, placeableMo5549measureBRTryo02, placeableMo5549measureBRTryo03, j5);
                                }
                                int size4 = list.size();
                                while (i < size4) {
                                    Measurable measurable4 = list.get(i);
                                    if (k.b(LayoutIdKt.getLayoutId(measurable4), "label")) {
                                        return NavigationItemKt.m2084placeLabelAndTopIconqoqLrGI(measureScope, measurable4.mo5549measureBRTryo0(ConstraintsKt.m6817offsetNN6EwU$default(jM6787copyZbe2FdA$default, 0, -(measureScope2.mo375roundToPx0680j_4(this.indicatorToLabelVerticalPadding) + placeableMo5549measureBRTryo03.getHeight()), 1, null)), placeableMo5549measureBRTryo0, placeableMo5549measureBRTryo02, placeableMo5549measureBRTryo03, j5, this.indicatorToLabelVerticalPadding, this.indicatorVerticalPadding, this.topIconItemVerticalPadding);
                                    }
                                    i++;
                                    placeableMo5549measureBRTryo03 = placeableMo5549measureBRTryo03;
                                    placeableMo5549measureBRTryo0 = placeableMo5549measureBRTryo0;
                                    measureScope2 = measureScope;
                                }
                                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                            }
                            i11++;
                            placeableMo5549measureBRTryo0 = placeableMo5549measureBRTryo0;
                            measureScope2 = measureScope;
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                    i10++;
                    measureScope2 = measureScope;
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            i6++;
            measureScope2 = measureScope;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    private TopIconOrIconOnlyMeasurePolicy(boolean z10, S7.a aVar, float f, float f7, float f9, float f10) {
        this.hasLabel = z10;
        this.animationProgress = aVar;
        this.indicatorHorizontalPadding = f;
        this.indicatorVerticalPadding = f7;
        this.indicatorToLabelVerticalPadding = f9;
        this.topIconItemVerticalPadding = f10;
    }
}
