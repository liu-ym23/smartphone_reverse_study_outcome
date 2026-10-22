package androidx.compose.runtime;

import androidx.compose.ui.spatial.RectListKt;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.pitaya.api.PTYSocketStateCallback;
import com.larus.trace.CopyContentTypeString;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010!\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000bJ\u000e\u0010-\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u000bJ\u000e\u0010.\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000bJ\u0010\u00100\u001a\u0004\u0018\u00010\u00012\u0006\u0010,\u001a\u00020\u000bJ\u000e\u00104\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000bJ\u000e\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000bJ\u000e\u00108\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000bJ\u000e\u0010:\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000bJ\u000e\u0010>\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u000bJ\u0010\u0010@\u001a\u0004\u0018\u00010\u00012\u0006\u0010,\u001a\u00020\u000bJ\u0010\u0010C\u001a\u0004\u0018\u00010\u00012\u0006\u0010,\u001a\u00020\u000bJ\u000e\u0010:\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020\u0012J\u000e\u0010H\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u000bJ\u000e\u0010I\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u000bJ\u000e\u0010N\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000bJ\u0010\u0010Q\u001a\u0004\u0018\u00010\u00012\u0006\u0010,\u001a\u00020\u000bJ\u0010\u0010R\u001a\u0004\u0018\u00010\u00012\u0006\u0010,\u001a\u00020\u000bJ\u0018\u0010R\u001a\u0004\u0018\u00010\u00012\u0006\u00107\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000bJ\b\u0010S\u001a\u0004\u0018\u00010\u0001J\u0006\u0010V\u001a\u00020WJ\u0006\u0010X\u001a\u00020WJ\u0006\u0010Y\u001a\u00020WJ\u0006\u0010Z\u001a\u00020WJ\u0006\u0010[\u001a\u00020WJ\u0006\u0010\\\u001a\u00020\u000bJ\u0006\u0010]\u001a\u00020WJ\u000e\u0010^\u001a\u00020W2\u0006\u0010,\u001a\u00020\u000bJ\u000e\u0010_\u001a\u00020W2\u0006\u0010,\u001a\u00020\u000bJ\u0006\u0010`\u001a\u00020WJ\f\u0010a\u001a\b\u0012\u0004\u0012\u00020c0bJ\b\u0010d\u001a\u00020eH\u0016J\u0010\u0010G\u001a\u00020\u00122\b\b\u0002\u0010,\u001a\u00020\u000bJ\u0016\u00100\u001a\u0004\u0018\u00010\u0001*\u00020\t2\u0006\u0010,\u001a\u00020\u000bH\u0002J\u0016\u0010f\u001a\u0004\u0018\u00010\u0001*\u00020\t2\u0006\u0010,\u001a\u00020\u000bH\u0002J\u0016\u0010g\u001a\u0004\u0018\u00010\u0001*\u00020\t2\u0006\u0010,\u001a\u00020\u000bH\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0011j\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u001e\u0010!\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010(\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b)\u0010\u001cR\u0011\u0010*\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b+\u0010\u001cR\u0011\u0010-\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b-\u0010\u0019R\u0011\u0010.\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b/\u0010\u001cR\u0011\u00101\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b1\u0010\u0019R\u0011\u00102\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b3\u0010\u0019R\u0011\u00104\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b5\u0010\u001cR\u0011\u00108\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b9\u0010\u001cR\u0011\u0010:\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b;\u0010\u001cR\u0011\u0010<\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b=\u0010\u001cR\u0011\u0010>\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b?\u0010\u0019R\u0013\u0010@\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0013\u0010C\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\bD\u0010BR\u0013\u0010E\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\bF\u0010BR\u0011\u0010J\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\bK\u0010\u001cR\u0011\u0010L\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\bM\u0010\u001cR\u0011\u0010O\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\bP\u0010\u001cR\u001e\u0010T\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bU\u0010\u0019¨\u0006h"}, d2 = {"Landroidx/compose/runtime/SlotReader;", "", CopyContentTypeString.TABLE, "Landroidx/compose/runtime/SlotTable;", "<init>", "(Landroidx/compose/runtime/SlotTable;)V", "getTable$runtime", "()Landroidx/compose/runtime/SlotTable;", "groups", "", "groupsSize", "", "slots", "", "[Ljava/lang/Object;", "slotsSize", "sourceInformationMap", "Ljava/util/HashMap;", "Landroidx/compose/runtime/Anchor;", "Landroidx/compose/runtime/GroupSourceInformation;", "Lkotlin/collections/HashMap;", "value", "", PTYSocketStateCallback.CLOSED, "getClosed", "()Z", "currentGroup", "getCurrentGroup", "()I", "setCurrentGroup", "(I)V", "currentEnd", "getCurrentEnd", "parent", "getParent", "currentSlotStack", "Landroidx/compose/runtime/IntStack;", "emptyCount", "currentSlot", "currentSlotEnd", "size", "getSize", "slot", "getSlot", "index", "isNode", "nodeCount", "getNodeCount", "node", "isGroupEnd", "inEmpty", "getInEmpty", "groupSize", "getGroupSize", "slotSize", "group", "groupEnd", "getGroupEnd", "groupKey", "getGroupKey", "groupSlotIndex", "getGroupSlotIndex", "hasObjectKey", "getHasObjectKey", "groupObjectKey", "getGroupObjectKey", "()Ljava/lang/Object;", "groupAux", "getGroupAux", "groupNode", "getGroupNode", "anchor", "hasMark", "containsMark", "parentNodes", "getParentNodes", "remainingSlots", "getRemainingSlots", "parentOf", "groupSlotCount", "getGroupSlotCount", MonitorConstants.CONNECT_TYPE_GET, "groupGet", TeaEventTrack.ACTION_DRAMA_NEXT, "hadNext", "getHadNext", "beginEmpty", "", "endEmpty", "close", "startGroup", "startNode", "skipGroup", "skipToGroupEnd", "reposition", "restoreParent", "endGroup", "extractKeys", "", "Landroidx/compose/runtime/KeyInfo;", "toString", "", "aux", "objectKey", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

    public final void close() {
        this.closed = true;
        this.table.close$runtime(this, this.sourceInformationMap);
        this.slots = new Object[0];
    }

    public final void beginEmpty() {
        this.emptyCount++;
    }

    public final void endEmpty() {
        if (this.emptyCount <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
        PreconditionsKt.throwIllegalArgumentException("Unbalanced begin/end empty");
    L8:
        this.emptyCount--;
        return;
    L5:
        r100 = false;
        goto L6
    }

    public final void endGroup() {
        if (this.emptyCount == 0) goto L5;
        return;
    L5:
        if (this.currentGroup != this.currentEnd) goto L7;
        boolean r100 = true;
    L8:
        if (r100 == true) goto L10;
        ComposerKt.composeImmediateRuntimeError("endGroup() not called at the end of a group");
    L10:
        int[] r101 = this.groups;
        int r102 = r101[(this.parent * 5) + 2];
        this.parent = r102;
        if (r102 >= 0) goto L13;
        int r103 = this.groupsSize;
    L14:
        this.currentEnd = r103;
        int r104 = this.currentSlotStack.pop();
        if (r104 >= 0) goto L17;
        this.currentSlot = 0;
        this.currentSlotEnd = 0;
        return;
    L17:
        this.currentSlot = r104;
        if (r102 < (this.groupsSize - 1)) goto L20;
        int r105 = this.slotsSize;
    L21:
        this.currentSlotEnd = r105;
        return;
    L20:
        r105 = this.groups[((r102 + 1) * 5) + 4];
        goto L21
    L13:
        r103 = SlotTableKt.access$groupSize(r101, r102) + r102;
        goto L14
    L7:
        r100 = false;
        goto L8
    }

    public final List<KeyInfo> extractKeys() {
        ArrayList r100 = new ArrayList();
        if (this.emptyCount <= 0) goto L5;
        return r100;
    L5:
        int r101 = this.currentGroup;
        int r102 = 0;
    L7:
        if (r101 >= this.currentEnd) goto L16;
        int[] r103 = this.groups;
        int r104 = r101 * 5;
        int r105 = r103[r104];
        Object r106 = objectKey(r103, r101);
        int r107 = 1;
        int r108 = this.groups[r104 + 1];
        if ((1073741824 & r108) == 0) goto L11;
        boolean r109 = true;
    L12:
        if (r109 == true) goto L15;
        r107 = r108 & RectListKt.Lower26Bits;
    L15:
        r100.add(new KeyInfo(r105, r106, r101, r107, r102));
        r101 = r101 + SlotTableKt.access$groupSize(this.groups, r101);
        r102 = r102 + 1;
        goto L7
    L11:
        r109 = false;
        goto L12
    L16:
        return r100;
    }

    public final Object getGroupAux() {
        int r100 = this.currentGroup;
        if (r100 >= this.currentEnd) goto L6;
        return aux(this.groups, r100);
    L6:
        return 0;
    }

    public final int getGroupKey() {
        int r100 = this.currentGroup;
        if (r100 < this.currentEnd) goto L7;
        return 0;
    L7:
        return this.groups[r100 * 5];
    }

    public final Object getGroupNode() {
        int r100 = this.currentGroup;
        if (r100 < this.currentEnd) goto L7;
        return null;
    L7:
        return node(this.groups, r100);
    }

    public final Object getGroupObjectKey() {
        int r100 = this.currentGroup;
        if (r100 < this.currentEnd) goto L7;
        return null;
    L7:
        return objectKey(this.groups, r100);
    }

    public final int getGroupSize() {
        return SlotTableKt.access$groupSize(this.groups, this.currentGroup);
    }

    public final int getGroupSlotCount() {
        int r100 = this.currentGroup;
        int r101 = SlotTableKt.access$slotAnchor(this.groups, r100);
        int r102 = r100 + 1;
        if (r102 >= this.groupsSize) goto L5;
        int r103 = this.groups[(r102 * 5) + 4];
    L7:
        return r103 - r101;
    L5:
        r103 = this.slotsSize;
        goto L7
    }

    public final int getGroupSlotIndex() {
        return this.currentSlot - SlotTableKt.access$slotAnchor(this.groups, this.parent);
    }

    public final boolean getHasObjectKey() {
        int r100 = this.currentGroup;
        if (r100 < this.currentEnd) goto L5;
        return false;
    L5:
        if ((this.groups[(r100 * 5) + 1] & 536870912) == 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r101 = false;
        goto L8
    }

    public final boolean getInEmpty() {
        if (this.emptyCount <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final int getNodeCount() {
        return this.groups[(this.currentGroup * 5) + 1] & RectListKt.Lower26Bits;
    }

    public final int getParentNodes() {
        int r100 = this.parent;
        if (r100 >= 0) goto L7;
        return 0;
    L7:
        return this.groups[(r100 * 5) + 1] & RectListKt.Lower26Bits;
    }

    public final int getRemainingSlots() {
        return this.currentSlotEnd - this.currentSlot;
    }

    public final int getSlot() {
        return this.currentSlot - SlotTableKt.access$slotAnchor(this.groups, this.parent);
    }

    public final boolean isNode() {
        if ((this.groups[(this.currentGroup * 5) + 1] & 1073741824) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public final Object next() {
        if (this.emptyCount > 0) goto L9;
        int r100 = this.currentSlot;
        if (r100 >= this.currentSlotEnd) goto L9;
        this.hadNext = true;
        Object[] r101 = this.slots;
        this.currentSlot = r100 + 1;
        return r101[r100];
    L9:
        this.hadNext = false;
        return Composer.Companion.getEmpty();
    }

    public final int skipGroup() {
        boolean r100 = false;
        int r101 = 1;
        if (this.emptyCount != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        ComposerKt.composeImmediateRuntimeError("Cannot skip while in an empty region");
    L8:
        int[] r103 = this.groups;
        int r104 = this.currentGroup;
        if ((r103[(r104 * 5) + 1] & 1073741824) == 0) goto L11;
        r100 = true;
    L11:
        if (r100 == true) goto L14;
        r101 = 67108863 & r103[(r104 * 5) + 1];
    L14:
        this.currentGroup = r104 + SlotTableKt.access$groupSize(r103, r104);
        return r101;
    L5:
        r102 = false;
        goto L6
    }

    public final void skipToGroupEnd() {
        if (this.emptyCount != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
        ComposerKt.composeImmediateRuntimeError("Cannot skip the enclosing group while in an empty region");
    L8:
        this.currentGroup = this.currentEnd;
        this.currentSlot = 0;
        this.currentSlotEnd = 0;
        return;
    L5:
        r100 = false;
        goto L6
    }

    public final void startGroup() {
        if (this.emptyCount > 0) goto L26;
        int r100 = this.parent;
        int r101 = this.currentGroup;
        if (this.groups[(r101 * 5) + 2] != r100) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L10;
        PreconditionsKt.throwIllegalArgumentException("Invalid slot table detected");
    L10:
        HashMap<Anchor, GroupSourceInformation> r103 = this.sourceInformationMap;
        if (r103 == null) goto L15;
        GroupSourceInformation r104 = r103.get(anchor(r100));
        if (r104 == null) goto L15;
        r104.reportGroup(this.table, r101);
    L15:
        IntStack r105 = this.currentSlotStack;
        int r106 = this.currentSlot;
        int r107 = this.currentSlotEnd;
        if (r106 != 0) goto L19;
        if (r107 != 0) goto L19;
        r105.push(-1);
    L20:
        this.parent = r101;
        this.currentEnd = SlotTableKt.access$groupSize(this.groups, r101) + r101;
        int r108 = r101 + 1;
        this.currentGroup = r108;
        this.currentSlot = SlotTableKt.access$slotAnchor(this.groups, r101);
        if (r101 < (this.groupsSize - 1)) goto L23;
        int r109 = this.slotsSize;
    L24:
        this.currentSlotEnd = r109;
        return;
    L23:
        r109 = this.groups[(r108 * 5) + 4];
    L19:
        r105.push(r106);
        goto L20
    L7:
        r102 = false;
        goto L8
    }

    public final void startNode() {
        if (this.emptyCount > 0) goto L12;
        boolean r100 = true;
        if ((this.groups[(this.currentGroup * 5) + 1] & 1073741824) != 0) goto L8;
        r100 = false;
    L8:
        if (r100 == true) goto L10;
        PreconditionsKt.throwIllegalArgumentException("Expected a node group");
    L10:
        startGroup();
        return;
    }

    public String toString() {
        return "SlotReader(current=" + this.currentGroup + ", key=" + getGroupKey() + ", parent=" + this.parent + ", end=" + this.currentEnd + ')';
    }

    public final boolean isGroupEnd() {
        if (getInEmpty() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.currentGroup == this.currentEnd) goto L8;
        return false;
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

    public final int getGroupEnd() {
        return this.currentEnd;
    }

    public final boolean getHadNext() {
        return this.hadNext;
    }

    public final int getParent() {
        return this.parent;
    }

    public final int getSize() {
        return this.groupsSize;
    }

    public final SlotTable getTable$runtime() {
        return this.table;
    }

    public SlotReader(SlotTable r100) {
        this.table = r100;
        this.groups = r100.getGroups();
        int r101 = r100.getGroupsSize();
        this.groupsSize = r101;
        this.slots = r100.getSlots();
        this.slotsSize = r100.getSlotsSize();
        this.currentEnd = r101;
        this.parent = -1;
        this.currentSlotStack = new IntStack();
    }

    public final Anchor anchor(int r100) {
        ArrayList<Anchor> r101 = this.table.getAnchors$runtime();
        int r102 = SlotTableKt.access$search(r101, r100, this.groupsSize);
        if (r102 >= 0) goto L6;
        Anchor r103 = new Anchor(r100);
        ListProtector.add(r101, -(r102 + 1), r103);
        return r103;
    L6:
        return (Anchor) ListProtector.get(r101, r102);
    }

    public final boolean containsMark(int r100) {
        if ((this.groups[(r100 * 5) + 1] & 67108864) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public final Object get(int r100) {
        int r101 = this.currentSlot + r100;
        if (r101 >= this.currentSlotEnd) goto L6;
        return this.slots[r101];
    L6:
        return Composer.Companion.getEmpty();
    }

    public final Object groupAux(int r100) {
        return aux(this.groups, r100);
    }

    public final int groupEnd(int r100) {
        return r100 + SlotTableKt.access$groupSize(this.groups, r100);
    }

    public final Object groupGet(int r100) {
        return groupGet(this.currentGroup, r100);
    }

    public final int groupKey(Anchor r100) {
        if (r100.getValid() == true) goto L7;
        return 0;
    L7:
        return this.groups[this.table.anchorIndex(r100) * 5];
    }

    public final Object groupObjectKey(int r100) {
        return objectKey(this.groups, r100);
    }

    public final int groupSize(int r100) {
        return SlotTableKt.access$groupSize(this.groups, r100);
    }

    public final boolean hasMark(int r100) {
        if ((this.groups[(r100 * 5) + 1] & AMapEngineUtils.HALF_MAX_P20_WIDTH) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean hasObjectKey(int r100) {
        if ((this.groups[(r100 * 5) + 1] & 536870912) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean isNode(int r100) {
        if ((this.groups[(r100 * 5) + 1] & 1073741824) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public final Object node(int r100) {
        int[] r101 = this.groups;
        boolean r102 = true;
        if ((r101[(r100 * 5) + 1] & 1073741824) != 0) goto L6;
        r102 = false;
    L6:
        if (r102 == true) goto L10;
        return null;
    L10:
        return node(r101, r100);
    }

    public final int nodeCount(int r100) {
        return this.groups[(r100 * 5) + 1] & RectListKt.Lower26Bits;
    }

    public final int parent(int r100) {
        return this.groups[(r100 * 5) + 2];
    }

    public final int parentOf(int r100) {
        if (r100 >= 0) goto L4;
    L6:
        boolean r101 = false;
    L7:
        if (r101 == true) goto L10;
        PreconditionsKt.throwIllegalArgumentException("Invalid group index " + r100);
    L10:
        return this.groups[(r100 * 5) + 2];
    L4:
        if (r100 >= this.groupsSize) goto L6;
        r101 = true;
        goto L7
    }

    public final void reposition(int r100) {
        if (this.emptyCount != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        ComposerKt.composeImmediateRuntimeError("Cannot reposition while in an empty region");
    L8:
        this.currentGroup = r100;
        int r102 = this.groupsSize;
        if (r100 >= r102) goto L11;
        int r103 = this.groups[(r100 * 5) + 2];
    L13:
        if (r103 == this.parent) goto L20;
        this.parent = r103;
        if (r103 >= 0) goto L17;
        this.currentEnd = r102;
    L18:
        this.currentSlot = 0;
        this.currentSlotEnd = 0;
        return;
    L17:
        this.currentEnd = r103 + SlotTableKt.access$groupSize(this.groups, r103);
        goto L18
    L20:
        return;
    L11:
        r103 = -1;
        goto L13
    L5:
        r101 = false;
        goto L6
    }

    public final void restoreParent(int r100) {
        int r101 = SlotTableKt.access$groupSize(this.groups, r100) + r100;
        int r102 = this.currentGroup;
        if (r102 < r100) goto L6;
        if (r102 > r101) goto L6;
        boolean r103 = true;
    L7:
        if (r103 == true) goto L9;
        ComposerKt.composeImmediateRuntimeError("Index " + r100 + " is not a parent of " + r102);
    L9:
        this.parent = r100;
        this.currentEnd = r101;
        this.currentSlot = 0;
        this.currentSlotEnd = 0;
        return;
    L6:
        r103 = false;
        goto L7
    }

    public final void setCurrentGroup(int r100) {
        this.currentGroup = r100;
    }

    public final int slotSize(int r100) {
        int r101 = SlotTableKt.access$slotAnchor(this.groups, r100);
        int r102 = r100 + 1;
        if (r102 >= this.groupsSize) goto L5;
        int r103 = this.groups[(r102 * 5) + 4];
    L7:
        return r103 - r101;
    L5:
        r103 = this.slotsSize;
        goto L7
    }

    public final int groupKey(int r100) {
        return this.groups[r100 * 5];
    }

    private final Object aux(int[] r100, int r101) {
        boolean r102 = true;
        if ((r100[(r101 * 5) + 1] & 268435456) != 0) goto L6;
        r102 = false;
    L6:
        if (r102 == false) goto L9;
        return this.slots[SlotTableKt.access$auxIndex(r100, r101)];
    L9:
        return Composer.Companion.getEmpty();
    }

    private final Object node(int[] r100, int r101) {
        int r102 = r101 * 5;
        if ((r100[r102 + 1] & 1073741824) == 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L9;
        return this.slots[r100[r102 + 4]];
    L9:
        return Composer.Companion.getEmpty();
    L5:
        r103 = false;
        goto L6
    }

    private final Object objectKey(int[] r100, int r101) {
        boolean r102 = true;
        if ((r100[(r101 * 5) + 1] & 536870912) != 0) goto L6;
        r102 = false;
    L6:
        if (r102 == true) goto L10;
        return null;
    L10:
        return this.slots[SlotTableKt.access$objectKeyIndex(r100, r101)];
    }

    public final Object groupGet(int r100, int r101) {
        int r102 = SlotTableKt.access$slotAnchor(this.groups, r100);
        int r103 = r100 + 1;
        if (r103 >= this.groupsSize) goto L5;
        int r104 = this.groups[(r103 * 5) + 4];
    L6:
        int r105 = r102 + r101;
        if (r105 >= r104) goto L10;
        return this.slots[r105];
    L10:
        return Composer.Companion.getEmpty();
    L5:
        r104 = this.slotsSize;
        goto L6
    }

    public static /* synthetic */ Anchor anchor$default(SlotReader r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.currentGroup;
    L6:
        return r100.anchor(r101);
    }
}
