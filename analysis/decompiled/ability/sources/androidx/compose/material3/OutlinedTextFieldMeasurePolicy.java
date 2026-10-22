package androidx.compose.material3;

import C7.r;
import S7.k;
import S7.n;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
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
import androidx.compose.ui.util.MathHelpersKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B3\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJC\u0010\u0016\u001a\u00020\u0012*\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0018\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017JC\u0010\u0019\u001a\u00020\u0012*\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0018\u001a\u00020\u00122\u0018\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0014H\u0002¢\u0006\u0004\b\u0019\u0010\u0017J,\u0010!\u001a\u00020\u001e*\u00020\u001a2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000f2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J)\u0010\"\u001a\u00020\u0012*\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0018\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\"\u0010#J)\u0010$\u001a\u00020\u0012*\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0018\u001a\u00020\u0012H\u0016¢\u0006\u0004\b$\u0010#J)\u0010%\u001a\u00020\u0012*\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b%\u0010#J)\u0010&\u001a\u00020\u0012*\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b&\u0010#R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010'R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010(R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010)R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010*\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006+"}, d2 = {"Landroidx/compose/material3/OutlinedTextFieldMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Size;", "LC7/r;", "onLabelMeasured", "", "singleLine", "", "animationProgress", "Landroidx/compose/foundation/layout/PaddingValues;", "paddingValues", AppAgent.CONSTRUCT, "(LS7/k;ZFLandroidx/compose/foundation/layout/PaddingValues;)V", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "measurables", "", "height", "Lkotlin/Function2;", "intrinsicMeasurer", "intrinsicWidth", "(Landroidx/compose/ui/layout/IntrinsicMeasureScope;Ljava/util/List;ILS7/n;)I", "width", "intrinsicHeight", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "measure", "maxIntrinsicHeight", "(Landroidx/compose/ui/layout/IntrinsicMeasureScope;Ljava/util/List;I)I", "minIntrinsicHeight", "maxIntrinsicWidth", "minIntrinsicWidth", "LS7/k;", "Z", "F", "Landroidx/compose/foundation/layout/PaddingValues;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class OutlinedTextFieldMeasurePolicy implements MeasurePolicy {
    private final float animationProgress;
    private final k onLabelMeasured;
    private final PaddingValues paddingValues;
    private final boolean singleLine;

    public OutlinedTextFieldMeasurePolicy(k kVar, boolean z10, float f, PaddingValues paddingValues) {
        this.onLabelMeasured = kVar;
        this.singleLine = z10;
        this.animationProgress = f;
        this.paddingValues = paddingValues;
    }

    private final int intrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i, n nVar) {
        IntrinsicMeasurable intrinsicMeasurable;
        int iSubstractConstraintSafely;
        int iIntValue;
        IntrinsicMeasurable intrinsicMeasurable2;
        int iIntValue2;
        Object obj;
        IntrinsicMeasurable intrinsicMeasurable3;
        int iIntValue3;
        IntrinsicMeasurable intrinsicMeasurable4;
        int i6;
        Object obj2;
        Object obj3;
        int size = list.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                intrinsicMeasurable = null;
                break;
            }
            intrinsicMeasurable = list.get(i10);
            if (kotlin.jvm.internal.k.b(TextFieldImplKt.getLayoutId(intrinsicMeasurable), TextFieldImplKt.LeadingId)) {
                break;
            }
            i10++;
        }
        IntrinsicMeasurable intrinsicMeasurable5 = intrinsicMeasurable;
        if (intrinsicMeasurable5 != null) {
            iSubstractConstraintSafely = OutlinedTextFieldKt.substractConstraintSafely(i, intrinsicMeasurable5.maxIntrinsicWidth(Integer.MAX_VALUE));
            iIntValue = ((Number) nVar.invoke(intrinsicMeasurable5, Integer.valueOf(i))).intValue();
        } else {
            iSubstractConstraintSafely = i;
            iIntValue = 0;
        }
        int size2 = list.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size2) {
                intrinsicMeasurable2 = null;
                break;
            }
            intrinsicMeasurable2 = list.get(i11);
            if (kotlin.jvm.internal.k.b(TextFieldImplKt.getLayoutId(intrinsicMeasurable2), TextFieldImplKt.TrailingId)) {
                break;
            }
            i11++;
        }
        IntrinsicMeasurable intrinsicMeasurable6 = intrinsicMeasurable2;
        if (intrinsicMeasurable6 != null) {
            iSubstractConstraintSafely = OutlinedTextFieldKt.substractConstraintSafely(iSubstractConstraintSafely, intrinsicMeasurable6.maxIntrinsicWidth(Integer.MAX_VALUE));
            iIntValue2 = ((Number) nVar.invoke(intrinsicMeasurable6, Integer.valueOf(i))).intValue();
        } else {
            iIntValue2 = 0;
        }
        int size3 = list.size();
        int i12 = 0;
        while (true) {
            if (i12 >= size3) {
                obj = null;
                break;
            }
            obj = list.get(i12);
            if (kotlin.jvm.internal.k.b(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj), TextFieldImplKt.LabelId)) {
                break;
            }
            i12++;
        }
        Object obj4 = (IntrinsicMeasurable) obj;
        int iIntValue4 = obj4 != null ? ((Number) nVar.invoke(obj4, Integer.valueOf(MathHelpersKt.lerp(iSubstractConstraintSafely, i, this.animationProgress)))).intValue() : 0;
        int size4 = list.size();
        int i13 = 0;
        while (true) {
            if (i13 >= size4) {
                intrinsicMeasurable3 = null;
                break;
            }
            intrinsicMeasurable3 = list.get(i13);
            if (kotlin.jvm.internal.k.b(TextFieldImplKt.getLayoutId(intrinsicMeasurable3), TextFieldImplKt.PrefixId)) {
                break;
            }
            i13++;
        }
        IntrinsicMeasurable intrinsicMeasurable7 = intrinsicMeasurable3;
        if (intrinsicMeasurable7 != null) {
            iIntValue3 = ((Number) nVar.invoke(intrinsicMeasurable7, Integer.valueOf(iSubstractConstraintSafely))).intValue();
            iSubstractConstraintSafely = OutlinedTextFieldKt.substractConstraintSafely(iSubstractConstraintSafely, intrinsicMeasurable7.maxIntrinsicWidth(Integer.MAX_VALUE));
        } else {
            iIntValue3 = 0;
        }
        int size5 = list.size();
        int i14 = 0;
        while (true) {
            if (i14 >= size5) {
                intrinsicMeasurable4 = null;
                break;
            }
            intrinsicMeasurable4 = list.get(i14);
            if (kotlin.jvm.internal.k.b(TextFieldImplKt.getLayoutId(intrinsicMeasurable4), TextFieldImplKt.SuffixId)) {
                break;
            }
            i14++;
        }
        IntrinsicMeasurable intrinsicMeasurable8 = intrinsicMeasurable4;
        if (intrinsicMeasurable8 != null) {
            int iIntValue5 = ((Number) nVar.invoke(intrinsicMeasurable8, Integer.valueOf(iSubstractConstraintSafely))).intValue();
            iSubstractConstraintSafely = OutlinedTextFieldKt.substractConstraintSafely(iSubstractConstraintSafely, intrinsicMeasurable8.maxIntrinsicWidth(Integer.MAX_VALUE));
            i6 = iIntValue5;
        } else {
            i6 = 0;
        }
        int size6 = list.size();
        for (int i15 = 0; i15 < size6; i15++) {
            Object obj5 = list.get(i15);
            if (kotlin.jvm.internal.k.b(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj5), TextFieldImplKt.TextFieldId)) {
                int iIntValue6 = ((Number) nVar.invoke(obj5, Integer.valueOf(iSubstractConstraintSafely))).intValue();
                int size7 = list.size();
                int i16 = 0;
                while (true) {
                    if (i16 >= size7) {
                        obj2 = null;
                        break;
                    }
                    obj2 = list.get(i16);
                    if (kotlin.jvm.internal.k.b(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj2), TextFieldImplKt.PlaceholderId)) {
                        break;
                    }
                    i16++;
                }
                Object obj6 = (IntrinsicMeasurable) obj2;
                int iIntValue7 = obj6 != null ? ((Number) nVar.invoke(obj6, Integer.valueOf(iSubstractConstraintSafely))).intValue() : 0;
                int size8 = list.size();
                int i17 = 0;
                while (true) {
                    if (i17 >= size8) {
                        obj3 = null;
                        break;
                    }
                    Object obj7 = list.get(i17);
                    if (kotlin.jvm.internal.k.b(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj7), TextFieldImplKt.SupportingId)) {
                        obj3 = obj7;
                        break;
                    }
                    i17++;
                }
                Object obj8 = (IntrinsicMeasurable) obj3;
                return OutlinedTextFieldKt.m2116calculateHeightmKXJcVc(iIntValue, iIntValue2, iIntValue3, i6, iIntValue6, iIntValue4, iIntValue7, obj8 != null ? ((Number) nVar.invoke(obj8, Integer.valueOf(i))).intValue() : 0, this.animationProgress, TextFieldImplKt.getZeroConstraints(), intrinsicMeasureScope.getDensity(), this.paddingValues);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    private final int intrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i, n nVar) {
        IntrinsicMeasurable intrinsicMeasurable;
        IntrinsicMeasurable intrinsicMeasurable2;
        IntrinsicMeasurable intrinsicMeasurable3;
        IntrinsicMeasurable intrinsicMeasurable4;
        IntrinsicMeasurable intrinsicMeasurable5;
        IntrinsicMeasurable intrinsicMeasurable6;
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            IntrinsicMeasurable intrinsicMeasurable7 = list.get(i6);
            if (kotlin.jvm.internal.k.b(TextFieldImplKt.getLayoutId(intrinsicMeasurable7), TextFieldImplKt.TextFieldId)) {
                int iIntValue = ((Number) nVar.invoke(intrinsicMeasurable7, Integer.valueOf(i))).intValue();
                int size2 = list.size();
                int i10 = 0;
                while (true) {
                    intrinsicMeasurable = null;
                    if (i10 >= size2) {
                        intrinsicMeasurable2 = null;
                        break;
                    }
                    intrinsicMeasurable2 = list.get(i10);
                    if (kotlin.jvm.internal.k.b(TextFieldImplKt.getLayoutId(intrinsicMeasurable2), TextFieldImplKt.LabelId)) {
                        break;
                    }
                    i10++;
                }
                IntrinsicMeasurable intrinsicMeasurable8 = intrinsicMeasurable2;
                int iIntValue2 = intrinsicMeasurable8 != null ? ((Number) nVar.invoke(intrinsicMeasurable8, Integer.valueOf(i))).intValue() : 0;
                int size3 = list.size();
                int i11 = 0;
                while (true) {
                    if (i11 >= size3) {
                        intrinsicMeasurable3 = null;
                        break;
                    }
                    intrinsicMeasurable3 = list.get(i11);
                    if (kotlin.jvm.internal.k.b(TextFieldImplKt.getLayoutId(intrinsicMeasurable3), TextFieldImplKt.TrailingId)) {
                        break;
                    }
                    i11++;
                }
                IntrinsicMeasurable intrinsicMeasurable9 = intrinsicMeasurable3;
                int iIntValue3 = intrinsicMeasurable9 != null ? ((Number) nVar.invoke(intrinsicMeasurable9, Integer.valueOf(i))).intValue() : 0;
                int size4 = list.size();
                int i12 = 0;
                while (true) {
                    if (i12 >= size4) {
                        intrinsicMeasurable4 = null;
                        break;
                    }
                    intrinsicMeasurable4 = list.get(i12);
                    if (kotlin.jvm.internal.k.b(TextFieldImplKt.getLayoutId(intrinsicMeasurable4), TextFieldImplKt.LeadingId)) {
                        break;
                    }
                    i12++;
                }
                IntrinsicMeasurable intrinsicMeasurable10 = intrinsicMeasurable4;
                int iIntValue4 = intrinsicMeasurable10 != null ? ((Number) nVar.invoke(intrinsicMeasurable10, Integer.valueOf(i))).intValue() : 0;
                int size5 = list.size();
                int i13 = 0;
                while (true) {
                    if (i13 >= size5) {
                        intrinsicMeasurable5 = null;
                        break;
                    }
                    intrinsicMeasurable5 = list.get(i13);
                    if (kotlin.jvm.internal.k.b(TextFieldImplKt.getLayoutId(intrinsicMeasurable5), TextFieldImplKt.PrefixId)) {
                        break;
                    }
                    i13++;
                }
                IntrinsicMeasurable intrinsicMeasurable11 = intrinsicMeasurable5;
                int iIntValue5 = intrinsicMeasurable11 != null ? ((Number) nVar.invoke(intrinsicMeasurable11, Integer.valueOf(i))).intValue() : 0;
                int size6 = list.size();
                int i14 = 0;
                while (true) {
                    if (i14 >= size6) {
                        intrinsicMeasurable6 = null;
                        break;
                    }
                    intrinsicMeasurable6 = list.get(i14);
                    if (kotlin.jvm.internal.k.b(TextFieldImplKt.getLayoutId(intrinsicMeasurable6), TextFieldImplKt.SuffixId)) {
                        break;
                    }
                    i14++;
                }
                IntrinsicMeasurable intrinsicMeasurable12 = intrinsicMeasurable6;
                int iIntValue6 = intrinsicMeasurable12 != null ? ((Number) nVar.invoke(intrinsicMeasurable12, Integer.valueOf(i))).intValue() : 0;
                int size7 = list.size();
                int i15 = 0;
                while (true) {
                    if (i15 >= size7) {
                        break;
                    }
                    IntrinsicMeasurable intrinsicMeasurable13 = list.get(i15);
                    if (kotlin.jvm.internal.k.b(TextFieldImplKt.getLayoutId(intrinsicMeasurable13), TextFieldImplKt.PlaceholderId)) {
                        intrinsicMeasurable = intrinsicMeasurable13;
                        break;
                    }
                    i15++;
                }
                IntrinsicMeasurable intrinsicMeasurable14 = intrinsicMeasurable;
                return OutlinedTextFieldKt.m2117calculateWidthDHJA7U0(iIntValue4, iIntValue3, iIntValue5, iIntValue6, iIntValue, iIntValue2, intrinsicMeasurable14 != null ? ((Number) nVar.invoke(intrinsicMeasurable14, Integer.valueOf(i))).intValue() : 0, this.animationProgress, TextFieldImplKt.getZeroConstraints(), intrinsicMeasureScope.getDensity(), this.paddingValues);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicHeight(intrinsicMeasureScope, list, i, new n() { // from class: androidx.compose.material3.OutlinedTextFieldMeasurePolicy.maxIntrinsicHeight.1
            @Override // S7.n
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i6) {
                return Integer.valueOf(intrinsicMeasurable.maxIntrinsicHeight(i6));
            }
        });
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicWidth(intrinsicMeasureScope, list, i, new n() { // from class: androidx.compose.material3.OutlinedTextFieldMeasurePolicy.maxIntrinsicWidth.1
            @Override // S7.n
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i6) {
                return Integer.valueOf(intrinsicMeasurable.maxIntrinsicWidth(i6));
            }
        });
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo37measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
        Measurable measurable;
        Measurable measurable2;
        Measurable measurable3;
        Measurable measurable4;
        Placeable placeable;
        Measurable measurable5;
        Measurable measurable6;
        Measurable measurable7;
        final OutlinedTextFieldMeasurePolicy outlinedTextFieldMeasurePolicy = this;
        final MeasureScope measureScope2 = measureScope;
        int iMo375roundToPx0680j_4 = measureScope2.mo375roundToPx0680j_4(outlinedTextFieldMeasurePolicy.paddingValues.getBottom());
        long jM6787copyZbe2FdA$default = Constraints.m6787copyZbe2FdA$default(j5, 0, 0, 0, 0, 10, null);
        int size = list.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                measurable = null;
                break;
            }
            measurable = list.get(i);
            if (kotlin.jvm.internal.k.b(LayoutIdKt.getLayoutId(measurable), TextFieldImplKt.LeadingId)) {
                break;
            }
            i++;
        }
        Measurable measurable8 = measurable;
        Placeable placeableMo5549measureBRTryo0 = measurable8 != null ? measurable8.mo5549measureBRTryo0(jM6787copyZbe2FdA$default) : null;
        int iWidthOrZero = TextFieldImplKt.widthOrZero(placeableMo5549measureBRTryo0);
        int iMax = Math.max(0, TextFieldImplKt.heightOrZero(placeableMo5549measureBRTryo0));
        int size2 = list.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size2) {
                measurable2 = null;
                break;
            }
            measurable2 = list.get(i6);
            if (kotlin.jvm.internal.k.b(LayoutIdKt.getLayoutId(measurable2), TextFieldImplKt.TrailingId)) {
                break;
            }
            i6++;
        }
        Measurable measurable9 = measurable2;
        Placeable placeableMo5549measureBRTryo02 = measurable9 != null ? measurable9.mo5549measureBRTryo0(ConstraintsKt.m6817offsetNN6EwU$default(jM6787copyZbe2FdA$default, -iWidthOrZero, 0, 2, null)) : null;
        int iWidthOrZero2 = TextFieldImplKt.widthOrZero(placeableMo5549measureBRTryo02) + iWidthOrZero;
        int iMax2 = Math.max(iMax, TextFieldImplKt.heightOrZero(placeableMo5549measureBRTryo02));
        int size3 = list.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size3) {
                measurable3 = null;
                break;
            }
            measurable3 = list.get(i10);
            if (kotlin.jvm.internal.k.b(LayoutIdKt.getLayoutId(measurable3), TextFieldImplKt.PrefixId)) {
                break;
            }
            i10++;
        }
        Measurable measurable10 = measurable3;
        Placeable placeableMo5549measureBRTryo03 = measurable10 != null ? measurable10.mo5549measureBRTryo0(ConstraintsKt.m6817offsetNN6EwU$default(jM6787copyZbe2FdA$default, -iWidthOrZero2, 0, 2, null)) : null;
        int iWidthOrZero3 = TextFieldImplKt.widthOrZero(placeableMo5549measureBRTryo03) + iWidthOrZero2;
        int iMax3 = Math.max(iMax2, TextFieldImplKt.heightOrZero(placeableMo5549measureBRTryo03));
        int size4 = list.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size4) {
                measurable4 = null;
                break;
            }
            measurable4 = list.get(i11);
            if (kotlin.jvm.internal.k.b(LayoutIdKt.getLayoutId(measurable4), TextFieldImplKt.SuffixId)) {
                break;
            }
            i11++;
        }
        Measurable measurable11 = measurable4;
        Placeable placeableMo5549measureBRTryo04 = measurable11 != null ? measurable11.mo5549measureBRTryo0(ConstraintsKt.m6817offsetNN6EwU$default(jM6787copyZbe2FdA$default, -iWidthOrZero3, 0, 2, null)) : null;
        int iWidthOrZero4 = TextFieldImplKt.widthOrZero(placeableMo5549measureBRTryo04) + iWidthOrZero3;
        int iMax4 = Math.max(iMax3, TextFieldImplKt.heightOrZero(placeableMo5549measureBRTryo04));
        int iMo375roundToPx0680j_42 = measureScope2.mo375roundToPx0680j_4(outlinedTextFieldMeasurePolicy.paddingValues.mo652calculateRightPaddingu2uoSUM(measureScope2.getLayoutDirection())) + measureScope2.mo375roundToPx0680j_4(outlinedTextFieldMeasurePolicy.paddingValues.mo651calculateLeftPaddingu2uoSUM(measureScope2.getLayoutDirection()));
        int i12 = -iWidthOrZero4;
        int iLerp = MathHelpersKt.lerp(i12 - iMo375roundToPx0680j_42, -iMo375roundToPx0680j_42, outlinedTextFieldMeasurePolicy.animationProgress);
        int i13 = -iMo375roundToPx0680j_4;
        long jM6816offsetNN6EwU = ConstraintsKt.m6816offsetNN6EwU(jM6787copyZbe2FdA$default, iLerp, i13);
        int size5 = list.size();
        int i14 = 0;
        while (true) {
            if (i14 >= size5) {
                placeable = placeableMo5549measureBRTryo0;
                measurable5 = null;
                break;
            }
            measurable5 = list.get(i14);
            int i15 = i14;
            placeable = placeableMo5549measureBRTryo0;
            if (kotlin.jvm.internal.k.b(LayoutIdKt.getLayoutId(measurable5), TextFieldImplKt.LabelId)) {
                break;
            }
            i14 = i15 + 1;
            placeableMo5549measureBRTryo0 = placeable;
        }
        Measurable measurable12 = measurable5;
        final Placeable placeableMo5549measureBRTryo05 = measurable12 != null ? measurable12.mo5549measureBRTryo0(jM6816offsetNN6EwU) : null;
        outlinedTextFieldMeasurePolicy.onLabelMeasured.invoke(Size.m3952boximpl(placeableMo5549measureBRTryo05 != null ? SizeKt.Size(placeableMo5549measureBRTryo05.getWidth(), placeableMo5549measureBRTryo05.getHeight()) : Size.INSTANCE.m3973getZeroNHjbRc()));
        int size6 = list.size();
        int i16 = 0;
        while (true) {
            if (i16 >= size6) {
                measurable6 = null;
                break;
            }
            measurable6 = list.get(i16);
            int i17 = size6;
            if (kotlin.jvm.internal.k.b(LayoutIdKt.getLayoutId(measurable6), TextFieldImplKt.SupportingId)) {
                break;
            }
            i16++;
            size6 = i17;
        }
        Measurable measurable13 = measurable6;
        int iMinIntrinsicHeight = measurable13 != null ? measurable13.minIntrinsicHeight(Constraints.m6799getMinWidthimpl(j5)) : 0;
        int iMax5 = Math.max(TextFieldImplKt.heightOrZero(placeableMo5549measureBRTryo05) / 2, measureScope2.mo375roundToPx0680j_4(outlinedTextFieldMeasurePolicy.paddingValues.getTop()));
        long jM6787copyZbe2FdA$default2 = Constraints.m6787copyZbe2FdA$default(ConstraintsKt.m6816offsetNN6EwU(j5, i12, (i13 - iMax5) - iMinIntrinsicHeight), 0, 0, 0, 0, 11, null);
        int size7 = list.size();
        final Placeable placeable2 = placeableMo5549measureBRTryo04;
        int i18 = 0;
        while (i18 < size7) {
            final Placeable placeable3 = placeableMo5549measureBRTryo03;
            Measurable measurable14 = list.get(i18);
            int i19 = size7;
            final Placeable placeable4 = placeableMo5549measureBRTryo02;
            if (kotlin.jvm.internal.k.b(LayoutIdKt.getLayoutId(measurable14), TextFieldImplKt.TextFieldId)) {
                final Placeable placeableMo5549measureBRTryo06 = measurable14.mo5549measureBRTryo0(jM6787copyZbe2FdA$default2);
                long jM6787copyZbe2FdA$default3 = Constraints.m6787copyZbe2FdA$default(jM6787copyZbe2FdA$default2, 0, 0, 0, 0, 14, null);
                int size8 = list.size();
                int i20 = 0;
                while (true) {
                    if (i20 >= size8) {
                        measurable7 = null;
                        break;
                    }
                    measurable7 = list.get(i20);
                    int i21 = size8;
                    int i22 = i20;
                    if (kotlin.jvm.internal.k.b(LayoutIdKt.getLayoutId(measurable7), TextFieldImplKt.PlaceholderId)) {
                        break;
                    }
                    i20 = i22 + 1;
                    size8 = i21;
                }
                Measurable measurable15 = measurable7;
                final Placeable placeableMo5549measureBRTryo07 = measurable15 != null ? measurable15.mo5549measureBRTryo0(jM6787copyZbe2FdA$default3) : null;
                int iMax6 = Math.max(iMax4, Math.max(TextFieldImplKt.heightOrZero(placeableMo5549measureBRTryo06), TextFieldImplKt.heightOrZero(placeableMo5549measureBRTryo07)) + iMax5 + iMo375roundToPx0680j_4);
                final int iM2117calculateWidthDHJA7U0 = OutlinedTextFieldKt.m2117calculateWidthDHJA7U0(TextFieldImplKt.widthOrZero(placeable), TextFieldImplKt.widthOrZero(placeable4), TextFieldImplKt.widthOrZero(placeable3), TextFieldImplKt.widthOrZero(placeable2), placeableMo5549measureBRTryo06.getWidth(), TextFieldImplKt.widthOrZero(placeableMo5549measureBRTryo05), TextFieldImplKt.widthOrZero(placeableMo5549measureBRTryo07), outlinedTextFieldMeasurePolicy.animationProgress, j5, measureScope2.getDensity(), outlinedTextFieldMeasurePolicy.paddingValues);
                final Placeable placeableMo5549measureBRTryo08 = measurable13 != null ? measurable13.mo5549measureBRTryo0(Constraints.m6787copyZbe2FdA$default(ConstraintsKt.m6817offsetNN6EwU$default(jM6787copyZbe2FdA$default, 0, -iMax6, 1, null), 0, iM2117calculateWidthDHJA7U0, 0, 0, 9, null)) : null;
                int iHeightOrZero = TextFieldImplKt.heightOrZero(placeableMo5549measureBRTryo08);
                final int iM2116calculateHeightmKXJcVc = OutlinedTextFieldKt.m2116calculateHeightmKXJcVc(TextFieldImplKt.heightOrZero(placeable), TextFieldImplKt.heightOrZero(placeable4), TextFieldImplKt.heightOrZero(placeable3), TextFieldImplKt.heightOrZero(placeable2), placeableMo5549measureBRTryo06.getHeight(), TextFieldImplKt.heightOrZero(placeableMo5549measureBRTryo05), TextFieldImplKt.heightOrZero(placeableMo5549measureBRTryo07), TextFieldImplKt.heightOrZero(placeableMo5549measureBRTryo08), outlinedTextFieldMeasurePolicy.animationProgress, j5, measureScope2.getDensity(), outlinedTextFieldMeasurePolicy.paddingValues);
                int i23 = iM2116calculateHeightmKXJcVc - iHeightOrZero;
                int size9 = list.size();
                int i24 = 0;
                while (i24 < size9) {
                    Measurable measurable16 = list.get(i24);
                    if (kotlin.jvm.internal.k.b(LayoutIdKt.getLayoutId(measurable16), TextFieldImplKt.ContainerId)) {
                        final Placeable placeableMo5549measureBRTryo09 = measurable16.mo5549measureBRTryo0(ConstraintsKt.Constraints(iM2117calculateWidthDHJA7U0 != Integer.MAX_VALUE ? iM2117calculateWidthDHJA7U0 : 0, iM2117calculateWidthDHJA7U0, i23 != Integer.MAX_VALUE ? i23 : 0, i23));
                        final Placeable placeable5 = placeable;
                        return MeasureScope.layout$default(measureScope, iM2117calculateWidthDHJA7U0, iM2116calculateHeightmKXJcVc, null, new k() { // from class: androidx.compose.material3.OutlinedTextFieldMeasurePolicy$measure$1
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
                                OutlinedTextFieldKt.place(placementScope, iM2116calculateHeightmKXJcVc, iM2117calculateWidthDHJA7U0, placeable5, placeable4, placeable3, placeable2, placeableMo5549measureBRTryo06, placeableMo5549measureBRTryo05, placeableMo5549measureBRTryo07, placeableMo5549measureBRTryo09, placeableMo5549measureBRTryo08, outlinedTextFieldMeasurePolicy.animationProgress, outlinedTextFieldMeasurePolicy.singleLine, measureScope2.getDensity(), measureScope2.getLayoutDirection(), outlinedTextFieldMeasurePolicy.paddingValues);
                            }
                        }, 4, null);
                    }
                    i24++;
                    outlinedTextFieldMeasurePolicy = this;
                    measureScope2 = measureScope;
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            i18++;
            outlinedTextFieldMeasurePolicy = this;
            measureScope2 = measureScope;
            size7 = i19;
            placeableMo5549measureBRTryo03 = placeable3;
            placeableMo5549measureBRTryo02 = placeable4;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicHeight(intrinsicMeasureScope, list, i, new n() { // from class: androidx.compose.material3.OutlinedTextFieldMeasurePolicy.minIntrinsicHeight.1
            @Override // S7.n
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i6) {
                return Integer.valueOf(intrinsicMeasurable.minIntrinsicHeight(i6));
            }
        });
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicWidth(intrinsicMeasureScope, list, i, new n() { // from class: androidx.compose.material3.OutlinedTextFieldMeasurePolicy.minIntrinsicWidth.1
            @Override // S7.n
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i6) {
                return Integer.valueOf(intrinsicMeasurable.minIntrinsicWidth(i6));
            }
        });
    }
}
