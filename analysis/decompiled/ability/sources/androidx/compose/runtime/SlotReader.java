package androidx.compose.runtime;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.spatial.RectListKt;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b \b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\tJ\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\tJ\u0015\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\tJ\u0015\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\tJ\u0015\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\tJ\u0015\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\fJ\u0017\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u000fJ\u0017\u0010\u0017\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u000fJ\u0015\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u0014\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\fJ\u0015\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\fJ\u0015\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\tJ\u0017\u0010\u001e\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u000fJ\u0017\u0010\u001f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010\u000fJ\u001f\u0010\u001f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b!\u0010\"J\r\u0010$\u001a\u00020#¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020#¢\u0006\u0004\b&\u0010%J\r\u0010'\u001a\u00020#¢\u0006\u0004\b'\u0010%J\r\u0010(\u001a\u00020#¢\u0006\u0004\b(\u0010%J\r\u0010)\u001a\u00020#¢\u0006\u0004\b)\u0010%J\r\u0010*\u001a\u00020\u0006¢\u0006\u0004\b*\u0010+J\r\u0010,\u001a\u00020#¢\u0006\u0004\b,\u0010%J\u0015\u0010-\u001a\u00020#2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b-\u0010.J\u0015\u0010/\u001a\u00020#2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b/\u0010.J\r\u00100\u001a\u00020#¢\u0006\u0004\b0\u0010%J\u0013\u00103\u001a\b\u0012\u0004\u0012\u00020201¢\u0006\u0004\b3\u00104J\u000f\u00106\u001a\u000205H\u0016¢\u0006\u0004\b6\u00107J\u0017\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u00108J\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u0001*\u0002092\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010:J\u001d\u0010;\u001a\u0004\u0018\u00010\u0001*\u0002092\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b;\u0010:J\u001d\u0010<\u001a\u0004\u0018\u00010\u0001*\u0002092\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b<\u0010:R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010=\u001a\u0004\b>\u0010?R\u0014\u0010@\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010B\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u001e\u0010E\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010G\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010CR6\u0010K\u001a\"\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020I\u0018\u00010Hj\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020I\u0018\u0001`J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR$\u0010N\u001a\u00020\n2\u0006\u0010M\u001a\u00020\n8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QR\"\u0010R\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010C\u001a\u0004\bS\u0010+\"\u0004\bT\u0010.R$\u0010U\u001a\u00020\u00062\u0006\u0010M\u001a\u00020\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bU\u0010C\u001a\u0004\bV\u0010+R$\u0010\b\u001a\u00020\u00062\u0006\u0010M\u001a\u00020\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\b\u0010C\u001a\u0004\bW\u0010+R\u0014\u0010Y\u001a\u00020X8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010[\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010CR\u0016\u0010\\\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010CR\u0016\u0010]\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010CR$\u0010^\u001a\u00020\n2\u0006\u0010M\u001a\u00020\n8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b^\u0010O\u001a\u0004\b_\u0010QR\u0011\u0010a\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b`\u0010+R\u0011\u0010c\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bb\u0010+R\u0011\u0010\u000b\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010QR\u0011\u0010\r\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bd\u0010+R\u0011\u0010e\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\be\u0010QR\u0011\u0010g\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bf\u0010QR\u0011\u0010\u0010\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bh\u0010+R\u0011\u0010\u0013\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bi\u0010+R\u0011\u0010\u0014\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bj\u0010+R\u0011\u0010l\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bk\u0010+R\u0011\u0010\u0015\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bm\u0010QR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\bn\u0010\"R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\bo\u0010\"R\u0013\u0010q\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\bp\u0010\"R\u0011\u0010s\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\br\u0010+R\u0011\u0010u\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bt\u0010+R\u0011\u0010w\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bv\u0010+¨\u0006x"}, d2 = {"Landroidx/compose/runtime/SlotReader;", "", "Landroidx/compose/runtime/SlotTable;", "table", AppAgent.CONSTRUCT, "(Landroidx/compose/runtime/SlotTable;)V", "", "index", "parent", "(I)I", "", "isNode", "(I)Z", "nodeCount", "node", "(I)Ljava/lang/Object;", "groupSize", "group", "slotSize", "groupEnd", "groupKey", "hasObjectKey", "groupObjectKey", "groupAux", "Landroidx/compose/runtime/Anchor;", "anchor", "(Landroidx/compose/runtime/Anchor;)I", "hasMark", "containsMark", "parentOf", "get", "groupGet", "(II)Ljava/lang/Object;", "next", "()Ljava/lang/Object;", "LC7/r;", "beginEmpty", "()V", "endEmpty", "close", "startGroup", "startNode", "skipGroup", "()I", "skipToGroupEnd", "reposition", "(I)V", "restoreParent", "endGroup", "", "Landroidx/compose/runtime/KeyInfo;", "extractKeys", "()Ljava/util/List;", "", "toString", "()Ljava/lang/String;", "(I)Landroidx/compose/runtime/Anchor;", "", "([II)Ljava/lang/Object;", "aux", "objectKey", "Landroidx/compose/runtime/SlotTable;", "getTable$runtime", "()Landroidx/compose/runtime/SlotTable;", "groups", "[I", "groupsSize", "I", "", "slots", "[Ljava/lang/Object;", "slotsSize", "Ljava/util/HashMap;", "Landroidx/compose/runtime/GroupSourceInformation;", "Lkotlin/collections/HashMap;", "sourceInformationMap", "Ljava/util/HashMap;", "value", "closed", "Z", "getClosed", "()Z", "currentGroup", "getCurrentGroup", "setCurrentGroup", "currentEnd", "getCurrentEnd", "getParent", "Landroidx/compose/runtime/IntStack;", "currentSlotStack", "Landroidx/compose/runtime/IntStack;", "emptyCount", "currentSlot", "currentSlotEnd", "hadNext", "getHadNext", "getSize", "size", "getSlot", "slot", "getNodeCount", "isGroupEnd", "getInEmpty", "inEmpty", "getGroupSize", "getGroupEnd", "getGroupKey", "getGroupSlotIndex", "groupSlotIndex", "getHasObjectKey", "getGroupObjectKey", "getGroupAux", "getGroupNode", "groupNode", "getParentNodes", "parentNodes", "getRemainingSlots", "remainingSlots", "getGroupSlotCount", "groupSlotCount", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SlotReader {
    public static final int $stable = 8;
    private boolean closed;
    private int currentEnd;
    private int currentGroup;
    private int currentSlot;
    private int currentSlotEnd;
    private final IntStack currentSlotStack;
    private int emptyCount;
    private final int[] groups;
    private final int groupsSize;
    private boolean hadNext;
    private int parent;
    private Object[] slots;
    private final int slotsSize;
    private HashMap<Anchor, GroupSourceInformation> sourceInformationMap;
    private final SlotTable table;

    public SlotReader(SlotTable slotTable) {
        this.table = slotTable;
        this.groups = slotTable.getGroups();
        int groupsSize = slotTable.getGroupsSize();
        this.groupsSize = groupsSize;
        this.slots = slotTable.getSlots();
        this.slotsSize = slotTable.getSlotsSize();
        this.currentEnd = groupsSize;
        this.parent = -1;
        this.currentSlotStack = new IntStack();
    }

    public static /* synthetic */ Anchor anchor$default(SlotReader slotReader, int i, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = slotReader.currentGroup;
        }
        return slotReader.anchor(i);
    }

    private final Object aux(int[] iArr, int i) {
        return (iArr[(i * 5) + 1] & 268435456) != 0 ? this.slots[SlotTableKt.auxIndex(iArr, i)] : Composer.INSTANCE.getEmpty();
    }

    private final Object objectKey(int[] iArr, int i) {
        if ((iArr[(i * 5) + 1] & 536870912) != 0) {
            return this.slots[SlotTableKt.objectKeyIndex(iArr, i)];
        }
        return null;
    }

    public final Anchor anchor(int index) {
        ArrayList<Anchor> anchors$runtime = this.table.getAnchors$runtime();
        int iSearch = SlotTableKt.search(anchors$runtime, index, this.groupsSize);
        if (iSearch >= 0) {
            return anchors$runtime.get(iSearch);
        }
        Anchor anchor = new Anchor(index);
        anchors$runtime.add(-(iSearch + 1), anchor);
        return anchor;
    }

    public final void beginEmpty() {
        this.emptyCount++;
    }

    public final void close() {
        this.closed = true;
        this.table.close$runtime(this, this.sourceInformationMap);
        this.slots = new Object[0];
    }

    public final boolean containsMark(int index) {
        return (this.groups[(index * 5) + 1] & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0;
    }

    public final void endEmpty() {
        if (!(this.emptyCount > 0)) {
            PreconditionsKt.throwIllegalArgumentException("Unbalanced begin/end empty");
        }
        this.emptyCount--;
    }

    public final void endGroup() {
        if (this.emptyCount == 0) {
            if (!(this.currentGroup == this.currentEnd)) {
                ComposerKt.composeImmediateRuntimeError("endGroup() not called at the end of a group");
            }
            int[] iArr = this.groups;
            int i = iArr[(this.parent * 5) + 2];
            this.parent = i;
            this.currentEnd = i < 0 ? this.groupsSize : SlotTableKt.groupSize(iArr, i) + i;
            int iPop = this.currentSlotStack.pop();
            if (iPop < 0) {
                this.currentSlot = 0;
                this.currentSlotEnd = 0;
            } else {
                this.currentSlot = iPop;
                this.currentSlotEnd = i >= this.groupsSize - 1 ? this.slotsSize : this.groups[((i + 1) * 5) + 4];
            }
        }
    }

    public final List<KeyInfo> extractKeys() {
        ArrayList arrayList = new ArrayList();
        if (this.emptyCount <= 0) {
            int i = 0;
            int iGroupSize = this.currentGroup;
            while (true) {
                int i6 = i;
                if (iGroupSize >= this.currentEnd) {
                    break;
                }
                int[] iArr = this.groups;
                int i10 = iGroupSize * 5;
                int i11 = iArr[i10];
                Object objObjectKey = objectKey(iArr, iGroupSize);
                int i12 = 1;
                int i13 = this.groups[i10 + 1];
                if ((1073741824 & i13) == 0) {
                    i12 = i13 & RectListKt.Lower26Bits;
                }
                i = i6 + 1;
                arrayList.add(new KeyInfo(i11, objObjectKey, iGroupSize, i12, i6));
                iGroupSize += SlotTableKt.groupSize(this.groups, iGroupSize);
            }
        }
        return arrayList;
    }

    public final Object get(int index) {
        int i = this.currentSlot + index;
        return i < this.currentSlotEnd ? this.slots[i] : Composer.INSTANCE.getEmpty();
    }

    public final boolean getClosed() {
        return this.closed;
    }

    public final int getCurrentEnd() {
        return this.currentEnd;
    }

    public final int getCurrentGroup() {
        return this.currentGroup;
    }

    public final Object getGroupAux() {
        int i = this.currentGroup;
        if (i < this.currentEnd) {
            return aux(this.groups, i);
        }
        return 0;
    }

    public final int getGroupEnd() {
        return this.currentEnd;
    }

    public final int getGroupKey() {
        int i = this.currentGroup;
        if (i < this.currentEnd) {
            return this.groups[i * 5];
        }
        return 0;
    }

    public final Object getGroupNode() {
        int i = this.currentGroup;
        if (i < this.currentEnd) {
            return node(this.groups, i);
        }
        return null;
    }

    public final Object getGroupObjectKey() {
        int i = this.currentGroup;
        if (i < this.currentEnd) {
            return objectKey(this.groups, i);
        }
        return null;
    }

    public final int getGroupSize() {
        return SlotTableKt.groupSize(this.groups, this.currentGroup);
    }

    public final int getGroupSlotCount() {
        int i = this.currentGroup;
        int iSlotAnchor = SlotTableKt.slotAnchor(this.groups, i);
        int i6 = i + 1;
        return (i6 < this.groupsSize ? this.groups[(i6 * 5) + 4] : this.slotsSize) - iSlotAnchor;
    }

    public final int getGroupSlotIndex() {
        return this.currentSlot - SlotTableKt.slotAnchor(this.groups, this.parent);
    }

    public final boolean getHadNext() {
        return this.hadNext;
    }

    public final boolean getHasObjectKey() {
        int i = this.currentGroup;
        return i < this.currentEnd && (this.groups[(i * 5) + 1] & 536870912) != 0;
    }

    public final boolean getInEmpty() {
        return this.emptyCount > 0;
    }

    public final int getNodeCount() {
        return this.groups[(this.currentGroup * 5) + 1] & RectListKt.Lower26Bits;
    }

    public final int getParent() {
        return this.parent;
    }

    public final int getParentNodes() {
        int i = this.parent;
        if (i >= 0) {
            return this.groups[(i * 5) + 1] & RectListKt.Lower26Bits;
        }
        return 0;
    }

    public final int getRemainingSlots() {
        return this.currentSlotEnd - this.currentSlot;
    }

    /* renamed from: getSize, reason: from getter */
    public final int getGroupsSize() {
        return this.groupsSize;
    }

    public final int getSlot() {
        return this.currentSlot - SlotTableKt.slotAnchor(this.groups, this.parent);
    }

    /* renamed from: getTable$runtime, reason: from getter */
    public final SlotTable getTable() {
        return this.table;
    }

    public final Object groupAux(int index) {
        return aux(this.groups, index);
    }

    public final int groupEnd(int index) {
        return SlotTableKt.groupSize(this.groups, index) + index;
    }

    public final Object groupGet(int index) {
        return groupGet(this.currentGroup, index);
    }

    public final int groupKey(int index) {
        return this.groups[index * 5];
    }

    public final Object groupObjectKey(int index) {
        return objectKey(this.groups, index);
    }

    public final int groupSize(int index) {
        return SlotTableKt.groupSize(this.groups, index);
    }

    public final boolean hasMark(int index) {
        return (this.groups[(index * 5) + 1] & 134217728) != 0;
    }

    public final boolean hasObjectKey(int index) {
        return (this.groups[(index * 5) + 1] & 536870912) != 0;
    }

    public final boolean isGroupEnd() {
        return getInEmpty() || this.currentGroup == this.currentEnd;
    }

    public final boolean isNode() {
        return (this.groups[(this.currentGroup * 5) + 1] & BasicMeasure.EXACTLY) != 0;
    }

    public final Object next() {
        int i;
        if (this.emptyCount > 0 || (i = this.currentSlot) >= this.currentSlotEnd) {
            this.hadNext = false;
            return Composer.INSTANCE.getEmpty();
        }
        this.hadNext = true;
        Object[] objArr = this.slots;
        this.currentSlot = i + 1;
        return objArr[i];
    }

    public final Object node(int index) {
        int[] iArr = this.groups;
        if ((iArr[(index * 5) + 1] & BasicMeasure.EXACTLY) != 0) {
            return node(iArr, index);
        }
        return null;
    }

    public final int nodeCount(int index) {
        return this.groups[(index * 5) + 1] & RectListKt.Lower26Bits;
    }

    public final int parent(int index) {
        return this.groups[(index * 5) + 2];
    }

    public final int parentOf(int index) {
        if (!(index >= 0 && index < this.groupsSize)) {
            PreconditionsKt.throwIllegalArgumentException("Invalid group index " + index);
        }
        return this.groups[(index * 5) + 2];
    }

    public final void reposition(int index) {
        if (!(this.emptyCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot reposition while in an empty region");
        }
        this.currentGroup = index;
        int i = this.groupsSize;
        int i6 = index < i ? this.groups[(index * 5) + 2] : -1;
        if (i6 != this.parent) {
            this.parent = i6;
            if (i6 < 0) {
                this.currentEnd = i;
            } else {
                this.currentEnd = SlotTableKt.groupSize(this.groups, i6) + i6;
            }
            this.currentSlot = 0;
            this.currentSlotEnd = 0;
        }
    }

    public final void restoreParent(int index) {
        int iGroupSize = SlotTableKt.groupSize(this.groups, index) + index;
        int i = this.currentGroup;
        if (!(i >= index && i <= iGroupSize)) {
            ComposerKt.composeImmediateRuntimeError("Index " + index + " is not a parent of " + i);
        }
        this.parent = index;
        this.currentEnd = iGroupSize;
        this.currentSlot = 0;
        this.currentSlotEnd = 0;
    }

    public final void setCurrentGroup(int i) {
        this.currentGroup = i;
    }

    public final int skipGroup() {
        if (!(this.emptyCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot skip while in an empty region");
        }
        int[] iArr = this.groups;
        int i = this.currentGroup;
        int i6 = (iArr[(i * 5) + 1] & BasicMeasure.EXACTLY) == 0 ? iArr[(i * 5) + 1] & RectListKt.Lower26Bits : 1;
        this.currentGroup = SlotTableKt.groupSize(iArr, i) + i;
        return i6;
    }

    public final void skipToGroupEnd() {
        if (!(this.emptyCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot skip the enclosing group while in an empty region");
        }
        this.currentGroup = this.currentEnd;
        this.currentSlot = 0;
        this.currentSlotEnd = 0;
    }

    public final int slotSize(int group) {
        int iSlotAnchor = SlotTableKt.slotAnchor(this.groups, group);
        int i = group + 1;
        return (i < this.groupsSize ? this.groups[(i * 5) + 4] : this.slotsSize) - iSlotAnchor;
    }

    public final void startGroup() {
        GroupSourceInformation groupSourceInformation;
        if (this.emptyCount <= 0) {
            int i = this.parent;
            int i6 = this.currentGroup;
            if (!(this.groups[(i6 * 5) + 2] == i)) {
                PreconditionsKt.throwIllegalArgumentException("Invalid slot table detected");
            }
            HashMap<Anchor, GroupSourceInformation> map = this.sourceInformationMap;
            if (map != null && (groupSourceInformation = map.get(anchor(i))) != null) {
                groupSourceInformation.reportGroup(this.table, i6);
            }
            IntStack intStack = this.currentSlotStack;
            int i10 = this.currentSlot;
            int i11 = this.currentSlotEnd;
            if (i10 == 0 && i11 == 0) {
                intStack.push(-1);
            } else {
                intStack.push(i10);
            }
            this.parent = i6;
            this.currentEnd = SlotTableKt.groupSize(this.groups, i6) + i6;
            int i12 = i6 + 1;
            this.currentGroup = i12;
            this.currentSlot = SlotTableKt.slotAnchor(this.groups, i6);
            this.currentSlotEnd = i6 >= this.groupsSize - 1 ? this.slotsSize : this.groups[(i12 * 5) + 4];
        }
    }

    public final void startNode() {
        if (this.emptyCount <= 0) {
            if (!((this.groups[(this.currentGroup * 5) + 1] & BasicMeasure.EXACTLY) != 0)) {
                PreconditionsKt.throwIllegalArgumentException("Expected a node group");
            }
            startGroup();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SlotReader(current=");
        sb.append(this.currentGroup);
        sb.append(", key=");
        sb.append(getGroupKey());
        sb.append(", parent=");
        sb.append(this.parent);
        sb.append(", end=");
        return B7.a.o(sb, this.currentEnd, ')');
    }

    public final Object groupGet(int group, int index) {
        int iSlotAnchor = SlotTableKt.slotAnchor(this.groups, group);
        int i = group + 1;
        int i6 = iSlotAnchor + index;
        return i6 < (i < this.groupsSize ? this.groups[(i * 5) + 4] : this.slotsSize) ? this.slots[i6] : Composer.INSTANCE.getEmpty();
    }

    public final int groupKey(Anchor anchor) {
        if (anchor.getValid()) {
            return this.groups[this.table.anchorIndex(anchor) * 5];
        }
        return 0;
    }

    public final boolean isNode(int index) {
        return (this.groups[(index * 5) + 1] & BasicMeasure.EXACTLY) != 0;
    }

    private final Object node(int[] iArr, int i) {
        int i6 = i * 5;
        if ((iArr[i6 + 1] & BasicMeasure.EXACTLY) != 0) {
            return this.slots[iArr[i6 + 4]];
        }
        return Composer.INSTANCE.getEmpty();
    }
}
