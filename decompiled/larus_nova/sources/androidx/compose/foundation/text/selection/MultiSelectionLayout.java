package androidx.compose.foundation.text.selection;

import androidx.collection.LongIntMap;
import androidx.collection.LongObjectMap;
import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableLongObjectMap;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\b\u0002\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010+\u001a\u00020,2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020,0.H\u0016J\u0012\u0010/\u001a\u00020\u000b2\b\u00100\u001a\u0004\u0018\u00010\u0001H\u0016J\u0010\u00101\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u0000H\u0002J\u0016\u00102\u001a\b\u0012\u0004\u0012\u00020\r032\u0006\u00104\u001a\u00020\rH\u0016J2\u00105\u001a\u00020,*\b\u0012\u0004\u0012\u00020\r062\u0006\u00104\u001a\u00020\r2\u0006\u00107\u001a\u00020\u00062\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\bH\u0002J\b\u0010:\u001a\u00020;H\u0016J\u0018\u0010<\u001a\u00020\b2\u0006\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u00020\u000bH\u0002J\u0018\u0010?\u001a\u00020\b2\u0006\u0010=\u001a\u00020\b2\u0006\u0010@\u001a\u00020\u000bH\u0002J\u0010\u0010A\u001a\u00020\b2\u0006\u0010B\u001a\u00020CH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\t\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0017R\u0016\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015R\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\"R\u0014\u0010%\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\"R\u0014\u0010'\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\"R\u0014\u0010)\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\"¨\u0006D"}, d2 = {"Landroidx/compose/foundation/text/selection/MultiSelectionLayout;", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "selectableIdToInfoListIndex", "Landroidx/collection/LongIntMap;", "infoList", "", "Landroidx/compose/foundation/text/selection/SelectableInfo;", "startSlot", "", "endSlot", "isStartHandle", "", "previousSelection", "Landroidx/compose/foundation/text/selection/Selection;", "<init>", "(Landroidx/collection/LongIntMap;Ljava/util/List;IIZLandroidx/compose/foundation/text/selection/Selection;)V", "getSelectableIdToInfoListIndex", "()Landroidx/collection/LongIntMap;", "getInfoList", "()Ljava/util/List;", "getStartSlot", "()I", "getEndSlot", "()Z", "getPreviousSelection", "()Landroidx/compose/foundation/text/selection/Selection;", "size", "getSize", "crossStatus", "Landroidx/compose/foundation/text/selection/CrossStatus;", "getCrossStatus", "()Landroidx/compose/foundation/text/selection/CrossStatus;", "startInfo", "getStartInfo", "()Landroidx/compose/foundation/text/selection/SelectableInfo;", "endInfo", "getEndInfo", "currentInfo", "getCurrentInfo", "firstInfo", "getFirstInfo", "lastInfo", "getLastInfo", "forEachMiddleInfo", "", "block", "Lkotlin/Function1;", "shouldRecomputeSelection", "other", "shouldAnyInfoRecomputeSelection", "createSubSelections", "Landroidx/collection/LongObjectMap;", "selection", "createAndPutSubSelection", "Landroidx/collection/MutableLongObjectMap;", "info", "minOffset", "maxOffset", "toString", "", "startOrEndSlotToIndex", "slot", "isStartSlot", "slotToIndex", "isMinimumSlot", "getInfoListIndexBySelectableId", "id", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class MultiSelectionLayout implements SelectionLayout {
    private final int endSlot;
    private final List<SelectableInfo> infoList;
    private final boolean isStartHandle;
    private final Selection previousSelection;
    private final LongIntMap selectableIdToInfoListIndex;
    private final int startSlot;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[CrossStatus.values().length];
            r100[CrossStatus.COLLAPSED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[CrossStatus.NOT_CROSSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[CrossStatus.CROSSED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r100;
        }
    }

    public static /* synthetic */ Unit a(MultiSelectionLayout r100, MutableLongObjectMap r101, Selection r102, SelectableInfo r103) {
        return createSubSelections$lambda$5$lambda$3(r100, r101, r102, r103);
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public SelectableInfo getEndInfo() {
        return (SelectableInfo) ListProtector.get(this.infoList, startOrEndSlotToIndex(getEndSlot(), false));
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public int getSize() {
        return this.infoList.size();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public SelectableInfo getStartInfo() {
        return (SelectableInfo) ListProtector.get(this.infoList, startOrEndSlotToIndex(getStartSlot(), true));
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("MultiSelectionLayout(isStartHandle=");
        r100.append(isStartHandle());
        r100.append(", startPosition=");
        boolean r101 = true;
        float r102 = 2;
        r100.append((getStartSlot() + 1) / r102);
        r100.append(", endPosition=");
        r100.append((getEndSlot() + 1) / r102);
        r100.append(", crossed=");
        r100.append(getCrossStatus());
        r100.append(", infos=");
        StringBuilder r103 = new StringBuilder("[\n\t");
        List<SelectableInfo> r104 = this.infoList;
        int r105 = r104.size();
        int r106 = 0;
    L3:
        if (r106 >= r105) goto L9;
        SelectableInfo r107 = (SelectableInfo) ListProtector.get(r104, r106);
        if (r101 == false) goto L7;
        r101 = false;
    L8:
        StringBuilder r108 = new StringBuilder();
        r106 = r106 + 1;
        r108.append(r106);
        r108.append(" -> ");
        r108.append(r107);
        r103.append(r108.toString());
        goto L3
    L7:
        r103.append(",\n\t");
        goto L8
    L9:
        r103.append("\n]");
        r100.append(r103.toString());
        r100.append(')');
        return r100.toString();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public CrossStatus getCrossStatus() {
        if (getStartSlot() >= getEndSlot()) goto L6;
        return CrossStatus.NOT_CROSSED;
    L6:
        if (getStartSlot() <= getEndSlot()) goto L9;
        return CrossStatus.CROSSED;
    L9:
        return ((SelectableInfo) ListProtector.get(this.infoList, getStartSlot() / 2)).getRawCrossStatus();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public SelectableInfo getCurrentInfo() {
        if (isStartHandle() == false) goto L6;
        return getStartInfo();
    L6:
        return getEndInfo();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public SelectableInfo getFirstInfo() {
        if (getCrossStatus() != CrossStatus.CROSSED) goto L6;
        return getEndInfo();
    L6:
        return getStartInfo();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public SelectableInfo getLastInfo() {
        if (getCrossStatus() != CrossStatus.CROSSED) goto L6;
        return getStartInfo();
    L6:
        return getEndInfo();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public int getEndSlot() {
        return this.endSlot;
    }

    public final List<SelectableInfo> getInfoList() {
        return this.infoList;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public Selection getPreviousSelection() {
        return this.previousSelection;
    }

    public final LongIntMap getSelectableIdToInfoListIndex() {
        return this.selectableIdToInfoListIndex;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public int getStartSlot() {
        return this.startSlot;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public boolean isStartHandle() {
        return this.isStartHandle;
    }

    private final int getInfoListIndexBySelectableId(long r100) {
        return this.selectableIdToInfoListIndex.get(r100);
    L4:
        e = move-exception;
        throw new IllegalStateException("Invalid selectableId: " + r100, e);
    }

    private final boolean shouldAnyInfoRecomputeSelection(MultiSelectionLayout r100) {
        if (getSize() == r100.getSize()) goto L5;
        return true;
    L5:
        int r101 = this.infoList.size();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L11;
        if (((SelectableInfo) ListProtector.get(this.infoList, r102)).shouldRecomputeSelection((SelectableInfo) ListProtector.get(r100.infoList, r102)) == true) goto L9;
        r102 = r102 + 1;
        goto L6
    L9:
        return true;
    L11:
        return false;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public LongObjectMap<Selection> createSubSelections(final Selection r100) {
        if (r100.getStart().getSelectableId() == r100.getEnd().getSelectableId()) goto L5;
        final MutableLongObjectMap<Selection> r101 = LongObjectMapKt.mutableLongObjectMapOf();
        if (r100.getHandlesCrossed() == false) goto L20;
        Selection.AnchorInfo r102 = r100.getEnd();
    L21:
        createAndPutSubSelection(r101, r100, getFirstInfo(), r102.getOffset(), getFirstInfo().getTextLength());
        forEachMiddleInfo(new i(this, r101, r100));
        if (r100.getHandlesCrossed() == false) goto L24;
        Selection.AnchorInfo r103 = r100.getStart();
    L25:
        createAndPutSubSelection(r101, r100, getLastInfo(), 0, r103.getOffset());
        return r101;
    L24:
        r103 = r100.getEnd();
        goto L25
    L20:
        r102 = r100.getStart();
        goto L21
    L5:
        if (r100.getHandlesCrossed() == false) goto L9;
        if (r100.getStart().getOffset() < r100.getEnd().getOffset()) goto L9;
    L12:
        boolean r104 = true;
    L14:
        if (r104 == true) goto L27;
        InlineClassHelperKt.throwIllegalStateException("unexpectedly miss-crossed selection: " + r100);
    L27:
        return LongObjectMapKt.longObjectMapOf(r100.getStart().getSelectableId(), r100);
    L9:
        if (r100.getHandlesCrossed() == false) goto L11;
    L13:
        r104 = false;
        goto L14
    L11:
        if (r100.getStart().getOffset() > r100.getEnd().getOffset()) goto L13;
        goto L12
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public void forEachMiddleInfo(Function1<? super SelectableInfo, Unit> r100) {
        int r101 = getInfoListIndexBySelectableId(getFirstInfo().getSelectableId());
        int r102 = getInfoListIndexBySelectableId(getLastInfo().getSelectableId());
        int r103 = r101 + 1;
        if (r103 < r102) goto L5;
        return;
    L5:
        if (r103 >= r102) goto L7;
        r100.invoke(ListProtector.get(this.infoList, r103));
        r103 = r103 + 1;
        goto L5
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public boolean shouldRecomputeSelection(SelectionLayout r100) {
        if (getPreviousSelection() == null) goto L17;
        if (r100 == null) goto L17;
        if ((r100 instanceof MultiSelectionLayout) == false) goto L17;
        MultiSelectionLayout r101 = (MultiSelectionLayout) r100;
        if (isStartHandle() != r101.isStartHandle()) goto L17;
        if (getStartSlot() != r101.getStartSlot()) goto L17;
        if (getEndSlot() != r101.getEndSlot()) goto L17;
        if (shouldAnyInfoRecomputeSelection(r101) == true) goto L17;
        return false;
    L17:
        return true;
    }

    private final int slotToIndex(int r100, boolean r101) {
        return (r100 - (!r101 ? 1 : 0)) / 2;
    }

    private final int startOrEndSlotToIndex(int r100, boolean r101) {
        CrossStatus r102 = getCrossStatus();
        int r103 = WhenMappings.$EnumSwitchMapping$0[r102.ordinal()];
        if (r103 != 1) goto L5;
    L13:
        r101 = true;
    L15:
        return slotToIndex(r100, r101);
    L5:
        if (r103 == 2) goto L15;
        if (r103 != 3) goto L12;
        if (r101 == false) goto L13;
        r101 = false;
        goto L15
    L12:
        throw new NoWhenBranchMatchedException();
    }

    private static final Unit createSubSelections$lambda$5$lambda$3(MultiSelectionLayout r100, MutableLongObjectMap r101, Selection r102, SelectableInfo r103) {
        r100.createAndPutSubSelection(r101, r102, r103, 0, r103.getTextLength());
        return Unit.INSTANCE;
    }

    private final void createAndPutSubSelection(MutableLongObjectMap<Selection> r100, Selection r101, SelectableInfo r102, int r103, int r104) {
        if (r101.getHandlesCrossed() == false) goto L5;
        Selection r105 = r102.makeSingleLayoutSelection(r104, r103);
    L6:
        if (r103 > r104) goto L8;
        boolean r106 = true;
    L9:
        if (r106 == true) goto L11;
        InlineClassHelperKt.throwIllegalStateException("minOffset should be less than or equal to maxOffset: " + r105);
    L11:
        r100.put(r102.getSelectableId(), r105);
        return;
    L8:
        r106 = false;
        goto L9
    L5:
        r105 = r102.makeSingleLayoutSelection(r103, r104);
        goto L6
    }

    public MultiSelectionLayout(LongIntMap r100, List<SelectableInfo> r101, int r102, int r103, boolean r104, Selection r105) {
        this.selectableIdToInfoListIndex = r100;
        this.infoList = r101;
        this.startSlot = r102;
        this.endSlot = r103;
        this.isStartHandle = r104;
        this.previousSelection = r105;
        boolean r106 = true;
        if (r101.size() > 1) goto L6;
        r106 = false;
    L6:
        if (r106 == true) goto L9;
        InlineClassHelperKt.throwIllegalStateException("MultiSelectionLayout requires an infoList size greater than 1, was " + r101.size() + '.');
        return;
    }
}
