package androidx.compose.foundation.text.selection;

import C7.r;
import S7.k;
import androidx.collection.LongIntMap;
import androidx.collection.LongObjectMap;
import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableLongObjectMap;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0002\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J9\u0010\u0019\u001a\u00020\u0018*\b\u0012\u0004\u0012\u00020\f0\u00132\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010 \u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\nH\u0002¢\u0006\u0004\b \u0010\u001eJ\u0017\u0010#\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b#\u0010$J#\u0010'\u001a\u00020\u00182\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00180%H\u0016¢\u0006\u0004\b'\u0010(J\u0019\u0010)\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b)\u0010*J\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020\f0+2\u0006\u0010\u0014\u001a\u00020\fH\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b/\u00100R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00101\u001a\u0004\b2\u00103R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u00104\u001a\u0004\b5\u00106R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u00107\u001a\u0004\b8\u00109R\u001a\u0010\t\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u00107\u001a\u0004\b:\u00109R\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010;\u001a\u0004\b\u000b\u0010<R\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010=\u001a\u0004\b>\u0010?R\u0014\u0010A\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b@\u00109R\u0014\u0010E\u001a\u00020B8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0014\u0010H\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0014\u0010J\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bI\u0010GR\u0014\u0010L\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bK\u0010GR\u0014\u0010N\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bM\u0010GR\u0014\u0010P\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bO\u0010G¨\u0006Q"}, d2 = {"Landroidx/compose/foundation/text/selection/MultiSelectionLayout;", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "Landroidx/collection/LongIntMap;", "selectableIdToInfoListIndex", "", "Landroidx/compose/foundation/text/selection/SelectableInfo;", "infoList", "", "startSlot", "endSlot", "", "isStartHandle", "Landroidx/compose/foundation/text/selection/Selection;", "previousSelection", AppAgent.CONSTRUCT, "(Landroidx/collection/LongIntMap;Ljava/util/List;IIZLandroidx/compose/foundation/text/selection/Selection;)V", "other", "shouldAnyInfoRecomputeSelection", "(Landroidx/compose/foundation/text/selection/MultiSelectionLayout;)Z", "Landroidx/collection/MutableLongObjectMap;", "selection", "info", "minOffset", "maxOffset", "LC7/r;", "createAndPutSubSelection", "(Landroidx/collection/MutableLongObjectMap;Landroidx/compose/foundation/text/selection/Selection;Landroidx/compose/foundation/text/selection/SelectableInfo;II)V", "slot", "isStartSlot", "startOrEndSlotToIndex", "(IZ)I", "isMinimumSlot", "slotToIndex", "", "id", "getInfoListIndexBySelectableId", "(J)I", "Lkotlin/Function1;", "block", "forEachMiddleInfo", "(LS7/k;)V", "shouldRecomputeSelection", "(Landroidx/compose/foundation/text/selection/SelectionLayout;)Z", "Landroidx/collection/LongObjectMap;", "createSubSelections", "(Landroidx/compose/foundation/text/selection/Selection;)Landroidx/collection/LongObjectMap;", "", "toString", "()Ljava/lang/String;", "Landroidx/collection/LongIntMap;", "getSelectableIdToInfoListIndex", "()Landroidx/collection/LongIntMap;", "Ljava/util/List;", "getInfoList", "()Ljava/util/List;", "I", "getStartSlot", "()I", "getEndSlot", "Z", "()Z", "Landroidx/compose/foundation/text/selection/Selection;", "getPreviousSelection", "()Landroidx/compose/foundation/text/selection/Selection;", "getSize", "size", "Landroidx/compose/foundation/text/selection/CrossStatus;", "getCrossStatus", "()Landroidx/compose/foundation/text/selection/CrossStatus;", "crossStatus", "getStartInfo", "()Landroidx/compose/foundation/text/selection/SelectableInfo;", "startInfo", "getEndInfo", "endInfo", "getCurrentInfo", "currentInfo", "getFirstInfo", "firstInfo", "getLastInfo", "lastInfo", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class MultiSelectionLayout implements SelectionLayout {
    private final int endSlot;
    private final List<SelectableInfo> infoList;
    private final boolean isStartHandle;
    private final Selection previousSelection;
    private final LongIntMap selectableIdToInfoListIndex;
    private final int startSlot;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CrossStatus.values().length];
            try {
                iArr[CrossStatus.COLLAPSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CrossStatus.NOT_CROSSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CrossStatus.CROSSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public MultiSelectionLayout(LongIntMap longIntMap, List<SelectableInfo> list, int i, int i6, boolean z10, Selection selection) {
        this.selectableIdToInfoListIndex = longIntMap;
        this.infoList = list;
        this.startSlot = i;
        this.endSlot = i6;
        this.isStartHandle = z10;
        this.previousSelection = selection;
        if (list.size() > 1) {
            return;
        }
        throw new IllegalStateException(("MultiSelectionLayout requires an infoList size greater than 1, was " + list.size() + '.').toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void createAndPutSubSelection(MutableLongObjectMap<Selection> mutableLongObjectMap, Selection selection, SelectableInfo selectableInfo, int i, int i6) {
        Selection selectionMakeSingleLayoutSelection = selection.getHandlesCrossed() ? selectableInfo.makeSingleLayoutSelection(i6, i) : selectableInfo.makeSingleLayoutSelection(i, i6);
        if (i <= i6) {
            mutableLongObjectMap.put(selectableInfo.getSelectableId(), selectionMakeSingleLayoutSelection);
        } else {
            throw new IllegalStateException(("minOffset should be less than or equal to maxOffset: " + selectionMakeSingleLayoutSelection).toString());
        }
    }

    private final int getInfoListIndexBySelectableId(long id) {
        try {
            return this.selectableIdToInfoListIndex.get(id);
        } catch (NoSuchElementException e) {
            throw new IllegalStateException(androidx.compose.foundation.b.p(id, "Invalid selectableId: "), e);
        }
    }

    private final boolean shouldAnyInfoRecomputeSelection(MultiSelectionLayout other) {
        if (getSize() != other.getSize()) {
            return true;
        }
        int size = this.infoList.size();
        for (int i = 0; i < size; i++) {
            if (this.infoList.get(i).shouldRecomputeSelection(other.infoList.get(i))) {
                return true;
            }
        }
        return false;
    }

    private final int slotToIndex(int slot, boolean isMinimumSlot) {
        return (slot - (!isMinimumSlot ? 1 : 0)) / 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int startOrEndSlotToIndex(int r4, boolean r5) {
        /*
            r3 = this;
            androidx.compose.foundation.text.selection.CrossStatus r0 = r3.getCrossStatus()
            int[] r1 = androidx.compose.foundation.text.selection.MultiSelectionLayout.WhenMappings.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            if (r0 == r1) goto L17
            r2 = 2
            if (r0 == r2) goto L21
            r2 = 3
            if (r0 != r2) goto L1b
            if (r5 != 0) goto L19
        L17:
            r5 = r1
            goto L21
        L19:
            r5 = 0
            goto L21
        L1b:
            kotlin.NoWhenBranchMatchedException r3 = new kotlin.NoWhenBranchMatchedException
            r3.<init>()
            throw r3
        L21:
            int r3 = r3.slotToIndex(r4, r5)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.MultiSelectionLayout.startOrEndSlotToIndex(int, boolean):int");
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public LongObjectMap<Selection> createSubSelections(final Selection selection) {
        if (selection.getStart().getSelectableId() != selection.getEnd().getSelectableId()) {
            final MutableLongObjectMap<Selection> mutableLongObjectMapMutableLongObjectMapOf = LongObjectMapKt.mutableLongObjectMapOf();
            createAndPutSubSelection(mutableLongObjectMapMutableLongObjectMapOf, selection, getFirstInfo(), (selection.getHandlesCrossed() ? selection.getEnd() : selection.getStart()).getOffset(), getFirstInfo().getTextLength());
            forEachMiddleInfo(new k() { // from class: androidx.compose.foundation.text.selection.MultiSelectionLayout$createSubSelections$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((SelectableInfo) obj);
                    return r.f317a;
                }

                public final void invoke(SelectableInfo selectableInfo) {
                    this.this$0.createAndPutSubSelection(mutableLongObjectMapMutableLongObjectMapOf, selection, selectableInfo, 0, selectableInfo.getTextLength());
                }
            });
            createAndPutSubSelection(mutableLongObjectMapMutableLongObjectMapOf, selection, getLastInfo(), 0, (selection.getHandlesCrossed() ? selection.getStart() : selection.getEnd()).getOffset());
            return mutableLongObjectMapMutableLongObjectMapOf;
        }
        if ((selection.getHandlesCrossed() && selection.getStart().getOffset() >= selection.getEnd().getOffset()) || (!selection.getHandlesCrossed() && selection.getStart().getOffset() <= selection.getEnd().getOffset())) {
            return LongObjectMapKt.longObjectMapOf(selection.getStart().getSelectableId(), selection);
        }
        throw new IllegalStateException(("unexpectedly miss-crossed selection: " + selection).toString());
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public void forEachMiddleInfo(k block) {
        int infoListIndexBySelectableId = getInfoListIndexBySelectableId(getFirstInfo().getSelectableId());
        int infoListIndexBySelectableId2 = getInfoListIndexBySelectableId(getLastInfo().getSelectableId());
        int i = infoListIndexBySelectableId + 1;
        if (i >= infoListIndexBySelectableId2) {
            return;
        }
        while (i < infoListIndexBySelectableId2) {
            block.invoke(this.infoList.get(i));
            i++;
        }
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public CrossStatus getCrossStatus() {
        return getStartSlot() < getEndSlot() ? CrossStatus.NOT_CROSSED : getStartSlot() > getEndSlot() ? CrossStatus.CROSSED : this.infoList.get(getStartSlot() / 2).getRawCrossStatus();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    /* renamed from: getCurrentInfo */
    public SelectableInfo getInfo() {
        return getIsStartHandle() ? getStartInfo() : getEndInfo();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public SelectableInfo getEndInfo() {
        return this.infoList.get(startOrEndSlotToIndex(getEndSlot(), false));
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public int getEndSlot() {
        return this.endSlot;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public SelectableInfo getFirstInfo() {
        return getCrossStatus() == CrossStatus.CROSSED ? getEndInfo() : getStartInfo();
    }

    public final List<SelectableInfo> getInfoList() {
        return this.infoList;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public SelectableInfo getLastInfo() {
        return getCrossStatus() == CrossStatus.CROSSED ? getStartInfo() : getEndInfo();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public Selection getPreviousSelection() {
        return this.previousSelection;
    }

    public final LongIntMap getSelectableIdToInfoListIndex() {
        return this.selectableIdToInfoListIndex;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public int getSize() {
        return this.infoList.size();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public SelectableInfo getStartInfo() {
        return this.infoList.get(startOrEndSlotToIndex(getStartSlot(), true));
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public int getStartSlot() {
        return this.startSlot;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    /* renamed from: isStartHandle, reason: from getter */
    public boolean getIsStartHandle() {
        return this.isStartHandle;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public boolean shouldRecomputeSelection(SelectionLayout other) {
        if (getPreviousSelection() == null || other == null || !(other instanceof MultiSelectionLayout)) {
            return true;
        }
        MultiSelectionLayout multiSelectionLayout = (MultiSelectionLayout) other;
        return (getIsStartHandle() == multiSelectionLayout.getIsStartHandle() && getStartSlot() == multiSelectionLayout.getStartSlot() && getEndSlot() == multiSelectionLayout.getEndSlot() && !shouldAnyInfoRecomputeSelection(multiSelectionLayout)) ? false : true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MultiSelectionLayout(isStartHandle=");
        sb.append(getIsStartHandle());
        sb.append(", startPosition=");
        boolean z10 = true;
        float f = 2;
        sb.append((getStartSlot() + 1) / f);
        sb.append(", endPosition=");
        sb.append((getEndSlot() + 1) / f);
        sb.append(", crossed=");
        sb.append(getCrossStatus());
        sb.append(", infos=");
        StringBuilder sb2 = new StringBuilder("[\n\t");
        List<SelectableInfo> list = this.infoList;
        int size = list.size();
        int i = 0;
        while (i < size) {
            SelectableInfo selectableInfo = list.get(i);
            if (z10) {
                z10 = false;
            } else {
                sb2.append(",\n\t");
            }
            StringBuilder sb3 = new StringBuilder();
            i++;
            sb3.append(i);
            sb3.append(" -> ");
            sb3.append(selectableInfo);
            sb2.append(sb3.toString());
        }
        sb2.append("\n]");
        String string = sb2.toString();
        kotlin.jvm.internal.k.e(string, "StringBuilder().apply(builderAction).toString()");
        sb.append(string);
        sb.append(')');
        return sb.toString();
    }
}
