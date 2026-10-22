package androidx.compose.material3;

import C7.r;
import S7.n;
import androidx.compose.foundation.layout.PaddingValues;
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
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ?\u0010\u0011\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\r2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012JC\u0010\u0015\u001a\u00020\r*\u00020\u00132\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0014\u001a\u00020\r2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u000fH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J,\u0010\u001e\u001a\u00020\u001b*\u00020\u00172\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00180\n2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010\u001f\u001a\u00020\r*\u00020\u00132\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0014\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001f\u0010 J)\u0010!\u001a\u00020\r*\u00020\u00132\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0014\u001a\u00020\rH\u0016¢\u0006\u0004\b!\u0010 J)\u0010\"\u001a\u00020\r*\u00020\u00132\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\"\u0010 J)\u0010#\u001a\u00020\r*\u00020\u00132\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b#\u0010 R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010$R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010%R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010&\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006'"}, d2 = {"Landroidx/compose/material3/TextFieldMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "", "singleLine", "", "animationProgress", "Landroidx/compose/foundation/layout/PaddingValues;", "paddingValues", AppAgent.CONSTRUCT, "(ZFLandroidx/compose/foundation/layout/PaddingValues;)V", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "measurables", "", "height", "Lkotlin/Function2;", "intrinsicMeasurer", "intrinsicWidth", "(Ljava/util/List;ILS7/n;)I", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "width", "intrinsicHeight", "(Landroidx/compose/ui/layout/IntrinsicMeasureScope;Ljava/util/List;ILS7/n;)I", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "measure", "maxIntrinsicHeight", "(Landroidx/compose/ui/layout/IntrinsicMeasureScope;Ljava/util/List;I)I", "minIntrinsicHeight", "maxIntrinsicWidth", "minIntrinsicWidth", "Z", "F", "Landroidx/compose/foundation/layout/PaddingValues;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class TextFieldMeasurePolicy implements MeasurePolicy {
    private final float animationProgress;
    private final PaddingValues paddingValues;
    private final boolean singleLine;

    public TextFieldMeasurePolicy(boolean z10, float f, PaddingValues paddingValues) {
        this.singleLine = z10;
        this.animationProgress = f;
        this.paddingValues = paddingValues;
    }

    private final int intrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i, n nVar) {
        IntrinsicMeasurable intrinsicMeasurable;
        int i6;
        int iSubstractConstraintSafely;
        int iIntValue;
        IntrinsicMeasurable intrinsicMeasurable2;
        int iIntValue2;
        Object obj;
        IntrinsicMeasurable intrinsicMeasurable3;
        int iIntValue3;
        IntrinsicMeasurable intrinsicMeasurable4;
        int i10;
        Object obj2;
        Object obj3;
        int size = list.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                intrinsicMeasurable = null;
                break;
            }
            intrinsicMeasurable = list.get(i11);
            if (k.b(TextFieldImplKt.getLayoutId(intrinsicMeasurable), TextFieldImplKt.LeadingId)) {
                break;
            }
            i11++;
        }
        IntrinsicMeasurable intrinsicMeasurable5 = intrinsicMeasurable;
        if (intrinsicMeasurable5 != null) {
            i6 = i;
            iSubstractConstraintSafely = TextFieldKt.substractConstraintSafely(i6, intrinsicMeasurable5.maxIntrinsicWidth(Integer.MAX_VALUE));
            iIntValue = ((Number) nVar.invoke(intrinsicMeasurable5, Integer.valueOf(i6))).intValue();
        } else {
            i6 = i;
            iSubstractConstraintSafely = i6;
            iIntValue = 0;
        }
        int size2 = list.size();
        int i12 = 0;
        while (true) {
            if (i12 >= size2) {
                intrinsicMeasurable2 = null;
                break;
            }
            intrinsicMeasurable2 = list.get(i12);
            if (k.b(TextFieldImplKt.getLayoutId(intrinsicMeasurable2), TextFieldImplKt.TrailingId)) {
                break;
            }
            i12++;
        }
        IntrinsicMeasurable intrinsicMeasurable6 = intrinsicMeasurable2;
        if (intrinsicMeasurable6 != null) {
            iSubstractConstraintSafely = TextFieldKt.substractConstraintSafely(iSubstractConstraintSafely, intrinsicMeasurable6.maxIntrinsicWidth(Integer.MAX_VALUE));
            iIntValue2 = ((Number) nVar.invoke(intrinsicMeasurable6, Integer.valueOf(i6))).intValue();
        } else {
            iIntValue2 = 0;
        }
        int size3 = list.size();
        int i13 = 0;
        while (true) {
            if (i13 >= size3) {
                obj = null;
                break;
            }
            obj = list.get(i13);
            if (k.b(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj), TextFieldImplKt.LabelId)) {
                break;
            }
            i13++;
        }
        Object obj4 = (IntrinsicMeasurable) obj;
        int iIntValue4 = obj4 != null ? ((Number) nVar.invoke(obj4, Integer.valueOf(iSubstractConstraintSafely))).intValue() : 0;
        int size4 = list.size();
        int i14 = 0;
        while (true) {
            if (i14 >= size4) {
                intrinsicMeasurable3 = null;
                break;
            }
            intrinsicMeasurable3 = list.get(i14);
            if (k.b(TextFieldImplKt.getLayoutId(intrinsicMeasurable3), TextFieldImplKt.PrefixId)) {
                break;
            }
            i14++;
        }
        IntrinsicMeasurable intrinsicMeasurable7 = intrinsicMeasurable3;
        if (intrinsicMeasurable7 != null) {
            iIntValue3 = ((Number) nVar.invoke(intrinsicMeasurable7, Integer.valueOf(iSubstractConstraintSafely))).intValue();
            iSubstractConstraintSafely = TextFieldKt.substractConstraintSafely(iSubstractConstraintSafely, intrinsicMeasurable7.maxIntrinsicWidth(Integer.MAX_VALUE));
        } else {
            iIntValue3 = 0;
        }
        int size5 = list.size();
        int i15 = 0;
        while (true) {
            if (i15 >= size5) {
                intrinsicMeasurable4 = null;
                break;
            }
            intrinsicMeasurable4 = list.get(i15);
            if (k.b(TextFieldImplKt.getLayoutId(intrinsicMeasurable4), TextFieldImplKt.SuffixId)) {
                break;
            }
            i15++;
        }
        IntrinsicMeasurable intrinsicMeasurable8 = intrinsicMeasurable4;
        if (intrinsicMeasurable8 != null) {
            int iIntValue5 = ((Number) nVar.invoke(intrinsicMeasurable8, Integer.valueOf(iSubstractConstraintSafely))).intValue();
            iSubstractConstraintSafely = TextFieldKt.substractConstraintSafely(iSubstractConstraintSafely, intrinsicMeasurable8.maxIntrinsicWidth(Integer.MAX_VALUE));
            i10 = iIntValue5;
        } else {
            i10 = 0;
        }
        int size6 = list.size();
        for (int i16 = 0; i16 < size6; i16++) {
            Object obj5 = list.get(i16);
            if (k.b(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj5), TextFieldImplKt.TextFieldId)) {
                int iIntValue6 = ((Number) nVar.invoke(obj5, Integer.valueOf(iSubstractConstraintSafely))).intValue();
                int size7 = list.size();
                int i17 = 0;
                while (true) {
                    if (i17 >= size7) {
                        obj2 = null;
                        break;
                    }
                    obj2 = list.get(i17);
                    if (k.b(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj2), TextFieldImplKt.PlaceholderId)) {
                        break;
                    }
                    i17++;
                }
                Object obj6 = (IntrinsicMeasurable) obj2;
                int iIntValue7 = obj6 != null ? ((Number) nVar.invoke(obj6, Integer.valueOf(iSubstractConstraintSafely))).intValue() : 0;
                int size8 = list.size();
                int i18 = 0;
                while (true) {
                    if (i18 >= size8) {
                        obj3 = null;
                        break;
                    }
                    obj3 = list.get(i18);
                    if (k.b(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj3), TextFieldImplKt.SupportingId)) {
                        break;
                    }
                    i18++;
                }
                Object obj7 = (IntrinsicMeasurable) obj3;
                return TextFieldKt.m2461calculateHeightmKXJcVc(iIntValue6, iIntValue4, iIntValue, iIntValue2, iIntValue3, i10, iIntValue7, obj7 != null ? ((Number) nVar.invoke(obj7, Integer.valueOf(i6))).intValue() : 0, this.animationProgress, TextFieldImplKt.getZeroConstraints(), intrinsicMeasureScope.getDensity(), this.paddingValues);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    private final int intrinsicWidth(List<? extends IntrinsicMeasurable> measurables, int height, n intrinsicMeasurer) {
        IntrinsicMeasurable intrinsicMeasurable;
        IntrinsicMeasurable intrinsicMeasurable2;
        IntrinsicMeasurable intrinsicMeasurable3;
        IntrinsicMeasurable intrinsicMeasurable4;
        IntrinsicMeasurable intrinsicMeasurable5;
        IntrinsicMeasurable intrinsicMeasurable6;
        int size = measurables.size();
        for (int i = 0; i < size; i++) {
            IntrinsicMeasurable intrinsicMeasurable7 = measurables.get(i);
            if (k.b(TextFieldImplKt.getLayoutId(intrinsicMeasurable7), TextFieldImplKt.TextFieldId)) {
                int iIntValue = ((Number) intrinsicMeasurer.invoke(intrinsicMeasurable7, Integer.valueOf(height))).intValue();
                int size2 = measurables.size();
                int i6 = 0;
                while (true) {
                    intrinsicMeasurable = null;
                    if (i6 >= size2) {
                        intrinsicMeasurable2 = null;
                        break;
                    }
                    intrinsicMeasurable2 = measurables.get(i6);
                    if (k.b(TextFieldImplKt.getLayoutId(intrinsicMeasurable2), TextFieldImplKt.LabelId)) {
                        break;
                    }
                    i6++;
                }
                IntrinsicMeasurable intrinsicMeasurable8 = intrinsicMeasurable2;
                int iIntValue2 = intrinsicMeasurable8 != null ? ((Number) intrinsicMeasurer.invoke(intrinsicMeasurable8, Integer.valueOf(height))).intValue() : 0;
                int size3 = measurables.size();
                int i10 = 0;
                while (true) {
                    if (i10 >= size3) {
                        intrinsicMeasurable3 = null;
                        break;
                    }
                    intrinsicMeasurable3 = measurables.get(i10);
                    if (k.b(TextFieldImplKt.getLayoutId(intrinsicMeasurable3), TextFieldImplKt.TrailingId)) {
                        break;
                    }
                    i10++;
                }
                IntrinsicMeasurable intrinsicMeasurable9 = intrinsicMeasurable3;
                int iIntValue3 = intrinsicMeasurable9 != null ? ((Number) intrinsicMeasurer.invoke(intrinsicMeasurable9, Integer.valueOf(height))).intValue() : 0;
                int size4 = measurables.size();
                int i11 = 0;
                while (true) {
                    if (i11 >= size4) {
                        intrinsicMeasurable4 = null;
                        break;
                    }
                    intrinsicMeasurable4 = measurables.get(i11);
                    if (k.b(TextFieldImplKt.getLayoutId(intrinsicMeasurable4), TextFieldImplKt.PrefixId)) {
                        break;
                    }
                    i11++;
                }
                IntrinsicMeasurable intrinsicMeasurable10 = intrinsicMeasurable4;
                int iIntValue4 = intrinsicMeasurable10 != null ? ((Number) intrinsicMeasurer.invoke(intrinsicMeasurable10, Integer.valueOf(height))).intValue() : 0;
                int size5 = measurables.size();
                int i12 = 0;
                while (true) {
                    if (i12 >= size5) {
                        intrinsicMeasurable5 = null;
                        break;
                    }
                    intrinsicMeasurable5 = measurables.get(i12);
                    if (k.b(TextFieldImplKt.getLayoutId(intrinsicMeasurable5), TextFieldImplKt.SuffixId)) {
                        break;
                    }
                    i12++;
                }
                IntrinsicMeasurable intrinsicMeasurable11 = intrinsicMeasurable5;
                int iIntValue5 = intrinsicMeasurable11 != null ? ((Number) intrinsicMeasurer.invoke(intrinsicMeasurable11, Integer.valueOf(height))).intValue() : 0;
                int size6 = measurables.size();
                int i13 = 0;
                while (true) {
                    if (i13 >= size6) {
                        intrinsicMeasurable6 = null;
                        break;
                    }
                    intrinsicMeasurable6 = measurables.get(i13);
                    if (k.b(TextFieldImplKt.getLayoutId(intrinsicMeasurable6), TextFieldImplKt.LeadingId)) {
                        break;
                    }
                    i13++;
                }
                IntrinsicMeasurable intrinsicMeasurable12 = intrinsicMeasurable6;
                int iIntValue6 = intrinsicMeasurable12 != null ? ((Number) intrinsicMeasurer.invoke(intrinsicMeasurable12, Integer.valueOf(height))).intValue() : 0;
                int size7 = measurables.size();
                int i14 = 0;
                while (true) {
                    if (i14 >= size7) {
                        break;
                    }
                    IntrinsicMeasurable intrinsicMeasurable13 = measurables.get(i14);
                    if (k.b(TextFieldImplKt.getLayoutId(intrinsicMeasurable13), TextFieldImplKt.PlaceholderId)) {
                        intrinsicMeasurable = intrinsicMeasurable13;
                        break;
                    }
                    i14++;
                }
                IntrinsicMeasurable intrinsicMeasurable14 = intrinsicMeasurable;
                return TextFieldKt.m2462calculateWidthyeHjK3Y(iIntValue6, iIntValue3, iIntValue4, iIntValue5, iIntValue, iIntValue2, intrinsicMeasurable14 != null ? ((Number) intrinsicMeasurer.invoke(intrinsicMeasurable14, Integer.valueOf(height))).intValue() : 0, TextFieldImplKt.getZeroConstraints());
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicHeight(intrinsicMeasureScope, list, i, new n() { // from class: androidx.compose.material3.TextFieldMeasurePolicy.maxIntrinsicHeight.1
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
        return intrinsicWidth(list, i, new n() { // from class: androidx.compose.material3.TextFieldMeasurePolicy.maxIntrinsicWidth.1
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
        long j6;
        Placeable placeableMo5549measureBRTryo0;
        Measurable measurable3;
        Measurable measurable4;
        final Placeable placeable;
        int i;
        Placeable placeable2;
        long j10;
        Placeable placeableMo5549measureBRTryo02;
        Placeable placeable3;
        Measurable measurable5;
        Placeable placeable4;
        Measurable measurable6;
        Placeable placeable5;
        Measurable measurable7;
        final TextFieldMeasurePolicy textFieldMeasurePolicy = this;
        final MeasureScope measureScope2 = measureScope;
        List<? extends Measurable> list2 = list;
        final int iMo375roundToPx0680j_4 = measureScope2.mo375roundToPx0680j_4(textFieldMeasurePolicy.paddingValues.getTop());
        int iMo375roundToPx0680j_42 = measureScope2.mo375roundToPx0680j_4(textFieldMeasurePolicy.paddingValues.getBottom());
        long jM6787copyZbe2FdA$default = Constraints.m6787copyZbe2FdA$default(j5, 0, 0, 0, 0, 10, null);
        int size = list2.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size) {
                measurable = null;
                break;
            }
            measurable = list2.get(i6);
            if (k.b(LayoutIdKt.getLayoutId(measurable), TextFieldImplKt.LeadingId)) {
                break;
            }
            i6++;
        }
        Measurable measurable8 = measurable;
        Placeable placeableMo5549measureBRTryo03 = measurable8 != null ? measurable8.mo5549measureBRTryo0(jM6787copyZbe2FdA$default) : null;
        int iWidthOrZero = TextFieldImplKt.widthOrZero(placeableMo5549measureBRTryo03);
        int iMax = Math.max(0, TextFieldImplKt.heightOrZero(placeableMo5549measureBRTryo03));
        int size2 = list2.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size2) {
                measurable2 = null;
                break;
            }
            measurable2 = list2.get(i10);
            if (k.b(LayoutIdKt.getLayoutId(measurable2), TextFieldImplKt.TrailingId)) {
                break;
            }
            i10++;
        }
        Measurable measurable9 = measurable2;
        if (measurable9 != null) {
            j6 = jM6787copyZbe2FdA$default;
            placeableMo5549measureBRTryo0 = measurable9.mo5549measureBRTryo0(ConstraintsKt.m6817offsetNN6EwU$default(j6, -iWidthOrZero, 0, 2, null));
        } else {
            j6 = jM6787copyZbe2FdA$default;
            placeableMo5549measureBRTryo0 = null;
        }
        int iWidthOrZero2 = TextFieldImplKt.widthOrZero(placeableMo5549measureBRTryo0) + iWidthOrZero;
        int iMax2 = Math.max(iMax, TextFieldImplKt.heightOrZero(placeableMo5549measureBRTryo0));
        int size3 = list2.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size3) {
                measurable3 = null;
                break;
            }
            measurable3 = list2.get(i11);
            if (k.b(LayoutIdKt.getLayoutId(measurable3), TextFieldImplKt.PrefixId)) {
                break;
            }
            i11++;
        }
        Measurable measurable10 = measurable3;
        final Placeable placeableMo5549measureBRTryo04 = measurable10 != null ? measurable10.mo5549measureBRTryo0(ConstraintsKt.m6817offsetNN6EwU$default(j6, -iWidthOrZero2, 0, 2, null)) : null;
        int iWidthOrZero3 = TextFieldImplKt.widthOrZero(placeableMo5549measureBRTryo04) + iWidthOrZero2;
        int iMax3 = Math.max(iMax2, TextFieldImplKt.heightOrZero(placeableMo5549measureBRTryo04));
        int size4 = list2.size();
        int i12 = 0;
        while (true) {
            if (i12 >= size4) {
                measurable4 = null;
                break;
            }
            measurable4 = list2.get(i12);
            if (k.b(LayoutIdKt.getLayoutId(measurable4), TextFieldImplKt.SuffixId)) {
                break;
            }
            i12++;
        }
        Measurable measurable11 = measurable4;
        if (measurable11 != null) {
            placeable = placeableMo5549measureBRTryo0;
            long jM6817offsetNN6EwU$default = ConstraintsKt.m6817offsetNN6EwU$default(j6, -iWidthOrZero3, 0, 2, null);
            i = iWidthOrZero3;
            placeable2 = placeableMo5549measureBRTryo03;
            j10 = j6;
            placeableMo5549measureBRTryo02 = measurable11.mo5549measureBRTryo0(jM6817offsetNN6EwU$default);
        } else {
            placeable = placeableMo5549measureBRTryo0;
            i = iWidthOrZero3;
            placeable2 = placeableMo5549measureBRTryo03;
            j10 = j6;
            placeableMo5549measureBRTryo02 = null;
        }
        int iWidthOrZero4 = TextFieldImplKt.widthOrZero(placeableMo5549measureBRTryo02) + i;
        int iMax4 = Math.max(iMax3, TextFieldImplKt.heightOrZero(placeableMo5549measureBRTryo02));
        int i13 = -iWidthOrZero4;
        long jM6816offsetNN6EwU = ConstraintsKt.m6816offsetNN6EwU(j10, i13, -iMo375roundToPx0680j_42);
        int size5 = list2.size();
        int i14 = 0;
        while (true) {
            if (i14 >= size5) {
                placeable3 = placeableMo5549measureBRTryo02;
                measurable5 = null;
                break;
            }
            measurable5 = list2.get(i14);
            int i15 = i14;
            placeable3 = placeableMo5549measureBRTryo02;
            if (k.b(LayoutIdKt.getLayoutId(measurable5), TextFieldImplKt.LabelId)) {
                break;
            }
            i14 = i15 + 1;
            placeableMo5549measureBRTryo02 = placeable3;
        }
        Measurable measurable12 = measurable5;
        Placeable placeableMo5549measureBRTryo05 = measurable12 != null ? measurable12.mo5549measureBRTryo0(jM6816offsetNN6EwU) : null;
        int size6 = list2.size();
        int i16 = 0;
        while (true) {
            if (i16 >= size6) {
                placeable4 = placeableMo5549measureBRTryo05;
                measurable6 = null;
                break;
            }
            measurable6 = list2.get(i16);
            placeable4 = placeableMo5549measureBRTryo05;
            if (k.b(LayoutIdKt.getLayoutId(measurable6), TextFieldImplKt.SupportingId)) {
                break;
            }
            i16++;
            placeableMo5549measureBRTryo05 = placeable4;
        }
        Measurable measurable13 = measurable6;
        int iMinIntrinsicHeight = measurable13 != null ? measurable13.minIntrinsicHeight(Constraints.m6799getMinWidthimpl(j5)) : 0;
        int iHeightOrZero = TextFieldImplKt.heightOrZero(placeable4) + iMo375roundToPx0680j_4;
        long j11 = j10;
        long jM6816offsetNN6EwU2 = ConstraintsKt.m6816offsetNN6EwU(Constraints.m6787copyZbe2FdA$default(j5, 0, 0, 0, 0, 11, null), i13, ((-iHeightOrZero) - iMo375roundToPx0680j_42) - iMinIntrinsicHeight);
        int size7 = list2.size();
        int i17 = 0;
        while (i17 < size7) {
            Measurable measurable14 = list2.get(i17);
            int i18 = size7;
            int i19 = iHeightOrZero;
            if (k.b(LayoutIdKt.getLayoutId(measurable14), TextFieldImplKt.TextFieldId)) {
                Placeable placeableMo5549measureBRTryo06 = measurable14.mo5549measureBRTryo0(jM6816offsetNN6EwU2);
                long jM6787copyZbe2FdA$default2 = Constraints.m6787copyZbe2FdA$default(jM6816offsetNN6EwU2, 0, 0, 0, 0, 14, null);
                int size8 = list2.size();
                int i20 = 0;
                while (true) {
                    if (i20 >= size8) {
                        placeable5 = placeableMo5549measureBRTryo06;
                        measurable7 = null;
                        break;
                    }
                    measurable7 = list2.get(i20);
                    placeable5 = placeableMo5549measureBRTryo06;
                    int i21 = size8;
                    if (k.b(LayoutIdKt.getLayoutId(measurable7), TextFieldImplKt.PlaceholderId)) {
                        break;
                    }
                    i20++;
                    size8 = i21;
                    placeableMo5549measureBRTryo06 = placeable5;
                }
                Measurable measurable15 = measurable7;
                final Placeable placeableMo5549measureBRTryo07 = measurable15 != null ? measurable15.mo5549measureBRTryo0(jM6787copyZbe2FdA$default2) : null;
                int iMax5 = Math.max(iMax4, Math.max(TextFieldImplKt.heightOrZero(placeable5), TextFieldImplKt.heightOrZero(placeableMo5549measureBRTryo07)) + i19 + iMo375roundToPx0680j_42);
                int iM2462calculateWidthyeHjK3Y = TextFieldKt.m2462calculateWidthyeHjK3Y(TextFieldImplKt.widthOrZero(placeable2), TextFieldImplKt.widthOrZero(placeable), TextFieldImplKt.widthOrZero(placeableMo5549measureBRTryo04), TextFieldImplKt.widthOrZero(placeable3), placeable5.getWidth(), TextFieldImplKt.widthOrZero(placeable4), TextFieldImplKt.widthOrZero(placeableMo5549measureBRTryo07), j5);
                int i22 = iM2462calculateWidthyeHjK3Y;
                final Placeable placeableMo5549measureBRTryo08 = measurable13 != null ? measurable13.mo5549measureBRTryo0(Constraints.m6787copyZbe2FdA$default(ConstraintsKt.m6817offsetNN6EwU$default(j11, 0, -iMax5, 1, null), 0, iM2462calculateWidthyeHjK3Y, 0, 0, 9, null)) : null;
                int iHeightOrZero2 = TextFieldImplKt.heightOrZero(placeableMo5549measureBRTryo08);
                int iM2461calculateHeightmKXJcVc = TextFieldKt.m2461calculateHeightmKXJcVc(placeable5.getHeight(), TextFieldImplKt.heightOrZero(placeable4), TextFieldImplKt.heightOrZero(placeable2), TextFieldImplKt.heightOrZero(placeable), TextFieldImplKt.heightOrZero(placeableMo5549measureBRTryo04), TextFieldImplKt.heightOrZero(placeable3), TextFieldImplKt.heightOrZero(placeableMo5549measureBRTryo07), TextFieldImplKt.heightOrZero(placeableMo5549measureBRTryo08), textFieldMeasurePolicy.animationProgress, j5, measureScope2.getDensity(), textFieldMeasurePolicy.paddingValues);
                int i23 = iM2461calculateHeightmKXJcVc - iHeightOrZero2;
                int size9 = list2.size();
                int i24 = 0;
                while (i24 < size9) {
                    Measurable measurable16 = list2.get(i24);
                    final int i25 = iM2461calculateHeightmKXJcVc;
                    if (k.b(LayoutIdKt.getLayoutId(measurable16), TextFieldImplKt.ContainerId)) {
                        final Placeable placeableMo5549measureBRTryo09 = measurable16.mo5549measureBRTryo0(ConstraintsKt.Constraints(i22 != Integer.MAX_VALUE ? i22 : 0, i22, i23 != Integer.MAX_VALUE ? i23 : 0, i23));
                        final int i26 = i22;
                        final Placeable placeable6 = placeable2;
                        final Placeable placeable7 = placeable3;
                        final Placeable placeable8 = placeable4;
                        final Placeable placeable9 = placeable5;
                        return MeasureScope.layout$default(measureScope, i26, i25, null, new S7.k() { // from class: androidx.compose.material3.TextFieldMeasurePolicy$measure$1
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
                                Placeable placeable10 = placeable8;
                                if (placeable10 == null) {
                                    TextFieldKt.placeWithoutLabel(placementScope, i26, i25, placeable9, placeableMo5549measureBRTryo07, placeable6, placeable, placeableMo5549measureBRTryo04, placeable7, placeableMo5549measureBRTryo09, placeableMo5549measureBRTryo08, textFieldMeasurePolicy.singleLine, measureScope2.getDensity(), textFieldMeasurePolicy.paddingValues);
                                    return;
                                }
                                int i27 = i26;
                                int i28 = i25;
                                Placeable placeable11 = placeable9;
                                Placeable placeable12 = placeableMo5549measureBRTryo07;
                                Placeable placeable13 = placeable6;
                                Placeable placeable14 = placeable;
                                Placeable placeable15 = placeableMo5549measureBRTryo04;
                                Placeable placeable16 = placeable7;
                                Placeable placeable17 = placeableMo5549measureBRTryo09;
                                Placeable placeable18 = placeableMo5549measureBRTryo08;
                                boolean z10 = textFieldMeasurePolicy.singleLine;
                                int i29 = iMo375roundToPx0680j_4;
                                TextFieldKt.placeWithLabel(placementScope, i27, i28, placeable11, placeable10, placeable12, placeable13, placeable14, placeable15, placeable16, placeable17, placeable18, z10, i29, placeable8.getHeight() + i29, textFieldMeasurePolicy.animationProgress, measureScope2.getDensity());
                            }
                        }, 4, null);
                    }
                    i24++;
                    i22 = i22;
                    iM2461calculateHeightmKXJcVc = i25;
                    textFieldMeasurePolicy = this;
                    measureScope2 = measureScope;
                    list2 = list;
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            i17++;
            textFieldMeasurePolicy = this;
            measureScope2 = measureScope;
            size7 = i18;
            iHeightOrZero = i19;
            list2 = list;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicHeight(intrinsicMeasureScope, list, i, new n() { // from class: androidx.compose.material3.TextFieldMeasurePolicy.minIntrinsicHeight.1
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
        return intrinsicWidth(list, i, new n() { // from class: androidx.compose.material3.TextFieldMeasurePolicy.minIntrinsicWidth.1
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
