package androidx.compose.material3;

import C7.r;
import H4.o;
import S7.k;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J2\u0010\u000f\u001a\u00020\f*\u00020\u00062\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R0\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"Landroidx/compose/material3/SegmentedButtonContentMeasurePolicy;", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "Lm9/z;", "scope", AppAgent.CONSTRUCT, "(Lm9/z;)V", "Landroidx/compose/ui/layout/MeasureScope;", "", "Landroidx/compose/ui/layout/Measurable;", "measurables", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "measure", "Lm9/z;", "getScope", "()Lm9/z;", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "animatable", "Landroidx/compose/animation/core/Animatable;", "getAnimatable", "()Landroidx/compose/animation/core/Animatable;", "setAnimatable", "(Landroidx/compose/animation/core/Animatable;)V", "initialOffset", "Ljava/lang/Integer;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SegmentedButtonContentMeasurePolicy implements MultiContentMeasurePolicy {
    public static final int $stable = 0;
    private Animatable<Integer, AnimationVector1D> animatable;
    private Integer initialOffset;
    private final InterfaceC1733z scope;

    public SegmentedButtonContentMeasurePolicy(InterfaceC1733z interfaceC1733z) {
        this.scope = interfaceC1733z;
    }

    public final Animatable<Integer, AnimationVector1D> getAnimatable() {
        return this.animatable;
    }

    public final InterfaceC1733z getScope() {
        return this.scope;
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo648measure3p2s80s(final MeasureScope measureScope, List<? extends List<? extends Measurable>> list, long j5) {
        Object obj;
        Object obj2;
        Object obj3;
        List<? extends Measurable> list2 = list.get(0);
        int i = 1;
        List<? extends Measurable> list3 = list.get(1);
        final ArrayList arrayList = new ArrayList(list2.size());
        int size = list2.size();
        for (int i6 = 0; i6 < size; i6++) {
            arrayList.add(list2.get(i6).mo5549measureBRTryo0(j5));
        }
        if (arrayList.isEmpty()) {
            obj = null;
        } else {
            obj = arrayList.get(0);
            int width = ((Placeable) obj).getWidth();
            int iH = o.H(arrayList);
            if (1 <= iH) {
                int i10 = 1;
                while (true) {
                    Object obj4 = arrayList.get(i10);
                    int width2 = ((Placeable) obj4).getWidth();
                    if (width < width2) {
                        obj = obj4;
                        width = width2;
                    }
                    if (i10 == iH) {
                        break;
                    }
                    i10++;
                }
            }
        }
        Placeable placeable = (Placeable) obj;
        int width3 = placeable != null ? placeable.getWidth() : 0;
        final ArrayList arrayList2 = new ArrayList(list3.size());
        int size2 = list3.size();
        for (int i11 = 0; i11 < size2; i11++) {
            arrayList2.add(list3.get(i11).mo5549measureBRTryo0(j5));
        }
        if (arrayList2.isEmpty()) {
            obj2 = null;
        } else {
            obj2 = arrayList2.get(0);
            int width4 = ((Placeable) obj2).getWidth();
            int iH2 = o.H(arrayList2);
            if (1 <= iH2) {
                int i12 = 1;
                while (true) {
                    Object obj5 = arrayList2.get(i12);
                    int width5 = ((Placeable) obj5).getWidth();
                    if (width4 < width5) {
                        obj2 = obj5;
                        width4 = width5;
                    }
                    if (i12 == iH2) {
                        break;
                    }
                    i12++;
                }
            }
        }
        Placeable placeable2 = (Placeable) obj2;
        Integer numValueOf = placeable2 != null ? Integer.valueOf(placeable2.getWidth()) : null;
        if (arrayList2.isEmpty()) {
            obj3 = null;
        } else {
            obj3 = arrayList2.get(0);
            int height = ((Placeable) obj3).getHeight();
            int iH3 = o.H(arrayList2);
            if (1 <= iH3) {
                while (true) {
                    Object obj6 = arrayList2.get(i);
                    int height2 = ((Placeable) obj6).getHeight();
                    if (height < height2) {
                        obj3 = obj6;
                        height = height2;
                    }
                    if (i == iH3) {
                        break;
                    }
                    i++;
                }
            }
        }
        Placeable placeable3 = (Placeable) obj3;
        int height3 = placeable3 != null ? placeable3.getHeight() : 0;
        SegmentedButtonDefaults segmentedButtonDefaults = SegmentedButtonDefaults.INSTANCE;
        int iMo375roundToPx0680j_4 = measureScope.mo375roundToPx0680j_4(SegmentedButtonKt.IconSpacing) + Math.max(measureScope.mo375roundToPx0680j_4(segmentedButtonDefaults.m2220getIconSizeD9Ej5fM()), width3) + (numValueOf != null ? numValueOf.intValue() : 0);
        int i13 = width3 == 0 ? (-(measureScope.mo375roundToPx0680j_4(SegmentedButtonKt.IconSpacing) + measureScope.mo375roundToPx0680j_4(segmentedButtonDefaults.m2220getIconSizeD9Ej5fM()))) / 2 : 0;
        Integer num = this.initialOffset;
        if (num == null) {
            this.initialOffset = Integer.valueOf(i13);
        } else {
            Animatable<Integer, AnimationVector1D> animatable = this.animatable;
            if (animatable == null) {
                Animatable<Integer, AnimationVector1D> animatable2 = new Animatable<>(num, VectorConvertersKt.getVectorConverter(i.f4925a), null, null, 12, null);
                this.animatable = animatable2;
                animatable = animatable2;
            }
            if (animatable.getTargetValue().intValue() != i13) {
                AbstractC1683A.n(this.scope, null, new SegmentedButtonContentMeasurePolicy$measure$1(animatable, i13, null), 3);
            }
        }
        final int i14 = height3;
        final int i15 = i13;
        return MeasureScope.layout$default(measureScope, iMo375roundToPx0680j_4, i14, null, new k() { // from class: androidx.compose.material3.SegmentedButtonContentMeasurePolicy$measure$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj7) {
                invoke((Placeable.PlacementScope) obj7);
                return r.f317a;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                List<Placeable> list4 = arrayList;
                int i16 = i14;
                int size3 = list4.size();
                for (int i17 = 0; i17 < size3; i17++) {
                    Placeable placeable4 = list4.get(i17);
                    Placeable.PlacementScope.place$default(placementScope, placeable4, 0, androidx.compose.foundation.b.f(placeable4, i16, 2), 0.0f, 4, null);
                }
                int iMo375roundToPx0680j_42 = measureScope.mo375roundToPx0680j_4(SegmentedButtonKt.IconSpacing) + measureScope.mo375roundToPx0680j_4(SegmentedButtonDefaults.INSTANCE.m2220getIconSizeD9Ej5fM());
                Animatable<Integer, AnimationVector1D> animatable3 = this.getAnimatable();
                int iIntValue = iMo375roundToPx0680j_42 + (animatable3 != null ? animatable3.getValue().intValue() : i15);
                List<Placeable> list5 = arrayList2;
                int i18 = i14;
                int size4 = list5.size();
                for (int i19 = 0; i19 < size4; i19++) {
                    Placeable placeable5 = list5.get(i19);
                    Placeable.PlacementScope.place$default(placementScope, placeable5, iIntValue, androidx.compose.foundation.b.f(placeable5, i18, 2), 0.0f, 4, null);
                }
            }
        }, 4, null);
    }

    public final void setAnimatable(Animatable<Integer, AnimationVector1D> animatable) {
        this.animatable = animatable;
    }
}
