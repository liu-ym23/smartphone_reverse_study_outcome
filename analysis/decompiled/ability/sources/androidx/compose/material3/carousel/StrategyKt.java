package androidx.compose.material3.carousel;

import C7.r;
import D7.F;
import D7.v;
import D7.w;
import H4.o;
import S7.k;
import Y7.f;
import androidx.collection.FloatList;
import androidx.collection.FloatListKt;
import androidx.collection.MutableFloatList;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import g1.AbstractC1451a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010!\n\u0000\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002\u001a.\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002\u001a\u001e\u0010\u000f\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002\u001a \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0004H\u0002\u001a.\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002\u001a\u001e\u0010\u0019\u001a\u00020\u00042\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010\u0018\u001a\u00020\u0004H\u0002\u001a&\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002\u001a0\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0004H\u0002\u001a0\u0010&\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u001a(\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0**\b\u0012\u0004\u0012\u00020\b0*2\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\nH\u0002¨\u0006+"}, d2 = {"createShiftedKeylineListForContentPadding", "Landroidx/compose/material3/carousel/KeylineList;", TypedValues.TransitionType.S_FROM, "carouselMainAxisSize", "", "itemSpacing", "contentPadding", "pivot", "Landroidx/compose/material3/carousel/Keyline;", "pivotIndex", "", "getEndKeylineSteps", "", "defaultKeylines", "afterContentPadding", "getEndShiftDistance", "endKeylineSteps", "getShiftPointRange", "Landroidx/compose/material3/carousel/ShiftPointRange;", "stepsCount", "shiftPoint", "Landroidx/collection/FloatList;", "interpolation", "getStartKeylineSteps", "beforeContentPadding", "getStartShiftDistance", "startKeylineSteps", "getStepInterpolationPoints", "totalShiftDistance", "steps", "isShiftingLeft", "", "lerp", "outputMin", "outputMax", "inputMin", "inputMax", "value", "moveKeylineAndCreateShiftedKeylineList", "srcIndex", "dstIndex", "move", "", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class StrategyKt {
    private static final KeylineList createShiftedKeylineListForContentPadding(final KeylineList keylineList, float f, float f7, float f9, Keyline keyline, int i) {
        ArrayList arrayList = new ArrayList(keylineList.size());
        int size = keylineList.size();
        for (int i6 = 0; i6 < size; i6++) {
            Keyline keyline2 = keylineList.get(i6);
            if (!keyline2.isAnchor()) {
                arrayList.add(keyline2);
            }
        }
        final float size2 = f9 / arrayList.size();
        KeylineList keylineListKeylineListOf = KeylineListKt.keylineListOf(f, f7, i, (keyline.getOffset() - (size2 / 2.0f)) + f9, new k() { // from class: androidx.compose.material3.carousel.StrategyKt$createShiftedKeylineListForContentPadding$newKeylines$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((KeylineListScope) obj);
                return r.f317a;
            }

            public final void invoke(KeylineListScope keylineListScope) {
                KeylineList keylineList2 = keylineList;
                float f10 = size2;
                int size3 = keylineList2.size();
                for (int i10 = 0; i10 < size3; i10++) {
                    Keyline keyline3 = keylineList2.get(i10);
                    keylineListScope.add(keyline3.getSize() - Math.abs(f10), keyline3.isAnchor());
                }
            }
        });
        ArrayList arrayList2 = new ArrayList(keylineListKeylineListOf.size());
        int size3 = keylineListKeylineListOf.size();
        for (int i10 = 0; i10 < size3; i10++) {
            arrayList2.add(Keyline.copy$default(keylineListKeylineListOf.get(i10), 0.0f, 0.0f, keylineList.get(i10).getUnadjustedOffset(), false, false, false, 0.0f, 123, null));
        }
        return new KeylineList(arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<KeylineList> getEndKeylineSteps(KeylineList keylineList, float f, float f7, float f9) {
        if (keylineList.isEmpty()) {
            return EmptyList.f4893a;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(keylineList);
        if (keylineList.isLastFocalItemAtEndOfContainer(f)) {
            if (f9 == 0.0f) {
                return arrayList;
            }
            arrayList.add(createShiftedKeylineListForContentPadding(keylineList, f, f7, -f9, keylineList.getLastFocal(), keylineList.getLastFocalIndex()));
            return arrayList;
        }
        int lastFocalIndex = keylineList.getLastFocalIndex();
        int lastNonAnchorIndex = keylineList.getLastNonAnchorIndex();
        int i = lastNonAnchorIndex - lastFocalIndex;
        if (i <= 0 && keylineList.getLastFocal().getCutoff() > 0.0f) {
            arrayList.add(moveKeylineAndCreateShiftedKeylineList(keylineList, 0, 0, f, f7));
            return arrayList;
        }
        for (int i6 = 0; i6 < i; i6++) {
            KeylineList keylineList2 = (KeylineList) v.K0(arrayList);
            int i10 = lastNonAnchorIndex - i6;
            arrayList.add(moveKeylineAndCreateShiftedKeylineList(keylineList2, keylineList.getLastNonAnchorIndex(), i10 < o.H(keylineList) ? keylineList2.lastIndexBeforeFocalRangeWithSize(keylineList.get(i10 + 1).getSize()) + 1 : 0, f, f7));
        }
        if (f9 == 0.0f) {
            return arrayList;
        }
        arrayList.set(o.H(arrayList), createShiftedKeylineListForContentPadding((KeylineList) v.K0(arrayList), f, f7, -f9, ((KeylineList) v.K0(arrayList)).getLastFocal(), ((KeylineList) v.K0(arrayList)).getLastFocalIndex()));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float getEndShiftDistance(List<KeylineList> list, float f) {
        if (list.isEmpty()) {
            return 0.0f;
        }
        return Math.max(((Keyline) v.K0((List) v.A0(list))).getUnadjustedOffset() - ((Keyline) v.K0((List) v.K0(list))).getUnadjustedOffset(), f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShiftPointRange getShiftPointRange(int i, FloatList floatList, float f) {
        float f7 = floatList.get(0);
        Iterator it = AbstractC1451a.X(1, i).iterator();
        while (it.hasNext()) {
            int iNextInt = ((F) it).nextInt();
            float f9 = floatList.get(iNextInt);
            if (f <= f9) {
                return new ShiftPointRange(iNextInt - 1, iNextInt, lerp(0.0f, 1.0f, f7, f9, f));
            }
            f7 = f9;
        }
        return new ShiftPointRange(0, 0, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<KeylineList> getStartKeylineSteps(KeylineList keylineList, float f, float f7, float f9) {
        if (keylineList.isEmpty()) {
            return EmptyList.f4893a;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(keylineList);
        if (keylineList.isFirstFocalItemAtStartOfContainer()) {
            if (f9 == 0.0f) {
                return arrayList;
            }
            arrayList.add(createShiftedKeylineListForContentPadding(keylineList, f, f7, f9, keylineList.getFirstFocal(), keylineList.getFirstFocalIndex()));
            return arrayList;
        }
        int firstNonAnchorIndex = keylineList.getFirstNonAnchorIndex();
        int firstFocalIndex = keylineList.getFirstFocalIndex() - firstNonAnchorIndex;
        if (firstFocalIndex <= 0 && keylineList.getFirstFocal().getCutoff() > 0.0f) {
            arrayList.add(moveKeylineAndCreateShiftedKeylineList(keylineList, 0, 0, f, f7));
            return arrayList;
        }
        for (int i = 0; i < firstFocalIndex; i++) {
            KeylineList keylineList2 = (KeylineList) v.K0(arrayList);
            int i6 = firstNonAnchorIndex + i;
            int iH = o.H(keylineList);
            if (i6 > 0) {
                iH = keylineList2.firstIndexAfterFocalRangeWithSize(keylineList.get(i6 - 1).getSize()) - 1;
            }
            arrayList.add(moveKeylineAndCreateShiftedKeylineList(keylineList2, keylineList.getFirstNonAnchorIndex(), iH, f, f7));
        }
        if (f9 == 0.0f) {
            return arrayList;
        }
        arrayList.set(o.H(arrayList), createShiftedKeylineListForContentPadding((KeylineList) v.K0(arrayList), f, f7, f9, ((KeylineList) v.K0(arrayList)).getFirstFocal(), ((KeylineList) v.K0(arrayList)).getFirstFocalIndex()));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float getStartShiftDistance(List<KeylineList> list, float f) {
        if (list.isEmpty()) {
            return 0.0f;
        }
        return Math.max(((Keyline) v.A0((List) v.K0(list))).getUnadjustedOffset() - ((Keyline) v.A0((List) v.A0(list))).getUnadjustedOffset(), f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FloatList getStepInterpolationPoints(float f, List<KeylineList> list, boolean z10) {
        MutableFloatList mutableFloatListMutableFloatListOf = FloatListKt.mutableFloatListOf(0.0f);
        if (f != 0.0f && !list.isEmpty()) {
            f fVarX = AbstractC1451a.X(1, list.size());
            ArrayList arrayList = new ArrayList(w.c0(fVarX, 10));
            Iterator it = fVarX.iterator();
            while (it.hasNext()) {
                int iNextInt = ((F) it).nextInt();
                int i = iNextInt - 1;
                KeylineList keylineList = list.get(i);
                KeylineList keylineList2 = list.get(iNextInt);
                arrayList.add(Boolean.valueOf(mutableFloatListMutableFloatListOf.add(iNextInt == o.H(list) ? 1.0f : mutableFloatListMutableFloatListOf.get(i) + ((z10 ? ((Keyline) v.A0(keylineList2)).getUnadjustedOffset() - ((Keyline) v.A0(keylineList)).getUnadjustedOffset() : ((Keyline) v.K0(keylineList)).getUnadjustedOffset() - ((Keyline) v.K0(keylineList2)).getUnadjustedOffset()) / f))));
            }
        }
        return mutableFloatListMutableFloatListOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float lerp(float f, float f7, float f9, float f10, float f11) {
        return f11 <= f9 ? f : f11 >= f10 ? f7 : MathHelpersKt.lerp(f, f7, (f11 - f9) / (f10 - f9));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Keyline> move(List<Keyline> list, int i, int i6) {
        Keyline keyline = list.get(i);
        list.remove(i);
        list.add(i6, keyline);
        return list;
    }

    private static final KeylineList moveKeylineAndCreateShiftedKeylineList(final KeylineList keylineList, final int i, final int i6, float f, float f7) {
        int i10 = i > i6 ? 1 : -1;
        return KeylineListKt.keylineListOf(f, f7, keylineList.getPivotIndex() + i10, keylineList.getPivot().getOffset() + (((keylineList.get(i).getSize() - keylineList.get(i).getCutoff()) + f7) * i10), new k() { // from class: androidx.compose.material3.carousel.StrategyKt.moveKeylineAndCreateShiftedKeylineList.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((KeylineListScope) obj);
                return r.f317a;
            }

            public final void invoke(KeylineListScope keylineListScope) {
                List listMove = StrategyKt.move(v.g1(keylineList), i, i6);
                int size = listMove.size();
                for (int i11 = 0; i11 < size; i11++) {
                    Keyline keyline = (Keyline) listMove.get(i11);
                    keylineListScope.add(keyline.getSize(), keyline.isAnchor());
                }
            }
        });
    }
}
