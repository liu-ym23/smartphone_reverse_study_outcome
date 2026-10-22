package androidx.compose.runtime;

import D7.v;
import androidx.compose.runtime.tooling.CompositionGroup;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00010\u0002B!\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u001a\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u0004\u0018\u00010!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0016\u0010&\u001a\u0004\u0018\u00010\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u001fR\u001c\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u001fR\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010(R\u0014\u0010/\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0019R\u0014\u00101\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u0019¨\u00062"}, d2 = {"Landroidx/compose/runtime/SlotTableGroup;", "Landroidx/compose/runtime/tooling/CompositionGroup;", "", "Landroidx/compose/runtime/SlotTable;", "table", "", "group", "version", AppAgent.CONSTRUCT, "(Landroidx/compose/runtime/SlotTable;II)V", "LC7/r;", "validateRead", "()V", "", "iterator", "()Ljava/util/Iterator;", "", "identityToFind", "find", "(Ljava/lang/Object;)Landroidx/compose/runtime/tooling/CompositionGroup;", "Landroidx/compose/runtime/SlotTable;", "getTable", "()Landroidx/compose/runtime/SlotTable;", "I", "getGroup", "()I", "getVersion", "", "isEmpty", "()Z", "getKey", "()Ljava/lang/Object;", "key", "", "getSourceInfo", "()Ljava/lang/String;", "sourceInfo", "getNode", "node", "getData", "()Ljava/lang/Iterable;", SettingsConfig.KEY_DATA, "getIdentity", "identity", "getCompositionGroups", "compositionGroups", "getGroupSize", "groupSize", "getSlotsSize", "slotsSize", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class SlotTableGroup implements CompositionGroup, Iterable<CompositionGroup>, T7.a {
    private final int group;
    private final SlotTable table;
    private final int version;

    public SlotTableGroup(SlotTable slotTable, int i, int i6) {
        this.table = slotTable;
        this.group = i;
        this.version = i6;
    }

    private static final CompositionGroup find$findAnchoredGroup(SlotTableGroup slotTableGroup, Anchor anchor) {
        int iAnchorIndex;
        int i;
        if (!slotTableGroup.table.ownsAnchor(anchor) || (iAnchorIndex = slotTableGroup.table.anchorIndex(anchor)) < (i = slotTableGroup.group) || iAnchorIndex - i >= SlotTableKt.groupSize(slotTableGroup.table.getGroups(), slotTableGroup.group)) {
            return null;
        }
        return new SlotTableGroup(slotTableGroup.table, iAnchorIndex, slotTableGroup.version);
    }

    private static final CompositionGroup find$findRelativeGroup(CompositionGroup compositionGroup, int i) {
        return (CompositionGroup) v.C0(v.w0(compositionGroup.getCompositionGroups(), i));
    }

    private final void validateRead() {
        if (this.table.getVersion() != this.version) {
            SlotTableKt.throwConcurrentModificationException();
        }
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public CompositionGroup find(Object identityToFind) {
        if (identityToFind instanceof Anchor) {
            return find$findAnchoredGroup(this, (Anchor) identityToFind);
        }
        if (identityToFind instanceof SourceInformationSlotTableGroupIdentity) {
            SourceInformationSlotTableGroupIdentity sourceInformationSlotTableGroupIdentity = (SourceInformationSlotTableGroupIdentity) identityToFind;
            CompositionGroup compositionGroupFind = find(sourceInformationSlotTableGroupIdentity.getParentIdentity());
            if (compositionGroupFind != null) {
                return find$findRelativeGroup(compositionGroupFind, sourceInformationSlotTableGroupIdentity.getIndex());
            }
        }
        return null;
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public Iterable<CompositionGroup> getCompositionGroups() {
        return this;
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public Iterable<Object> getData() {
        GroupSourceInformation groupSourceInformationSourceInformationOf = this.table.sourceInformationOf(this.group);
        return groupSourceInformationSourceInformationOf != null ? new SourceInformationGroupDataIterator(this.table, this.group, groupSourceInformationSourceInformationOf) : new DataIterator(this.table, this.group);
    }

    public final int getGroup() {
        return this.group;
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public int getGroupSize() {
        return SlotTableKt.groupSize(this.table.getGroups(), this.group);
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public Object getIdentity() {
        validateRead();
        SlotReader slotReaderOpenReader = this.table.openReader();
        try {
            return slotReaderOpenReader.anchor(this.group);
        } finally {
            slotReaderOpenReader.close();
        }
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public Object getKey() {
        if ((this.table.getGroups()[(this.group * 5) + 1] & 536870912) == 0) {
            return Integer.valueOf(this.table.getGroups()[this.group * 5]);
        }
        Object obj = this.table.getSlots()[SlotTableKt.objectKeyIndex(this.table.getGroups(), this.group)];
        kotlin.jvm.internal.k.c(obj);
        return obj;
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public Object getNode() {
        if ((this.table.getGroups()[(this.group * 5) + 1] & BasicMeasure.EXACTLY) != 0) {
            return this.table.getSlots()[this.table.getGroups()[(this.group * 5) + 4]];
        }
        return null;
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public int getSlotsSize() {
        int groupSize = this.group + getGroupSize();
        return (groupSize < this.table.getGroupsSize() ? this.table.getGroups()[(groupSize * 5) + 4] : this.table.getSlotsSize()) - this.table.getGroups()[(this.group * 5) + 4];
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public String getSourceInfo() {
        GroupSourceInformation groupSourceInformationSourceInformationOf = this.table.sourceInformationOf(this.group);
        if (groupSourceInformationSourceInformationOf != null) {
            return groupSourceInformationSourceInformationOf.getSourceInformation();
        }
        return null;
    }

    public final SlotTable getTable() {
        return this.table;
    }

    public final int getVersion() {
        return this.version;
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public boolean isEmpty() {
        return SlotTableKt.groupSize(this.table.getGroups(), this.group) == 0;
    }

    @Override // java.lang.Iterable
    public Iterator<CompositionGroup> iterator() {
        validateRead();
        GroupSourceInformation groupSourceInformationSourceInformationOf = this.table.sourceInformationOf(this.group);
        if (groupSourceInformationSourceInformationOf != null) {
            SlotTable slotTable = this.table;
            int i = this.group;
            return new SourceInformationGroupIterator(slotTable, i, groupSourceInformationSourceInformationOf, new AnchoredGroupPath(i));
        }
        SlotTable slotTable2 = this.table;
        int i6 = this.group;
        return new GroupIterator(slotTable2, i6 + 1, SlotTableKt.groupSize(slotTable2.getGroups(), this.group) + i6);
    }

    public /* synthetic */ SlotTableGroup(SlotTable slotTable, int i, int i6, int i10, kotlin.jvm.internal.e eVar) {
        this(slotTable, i, (i10 & 4) != 0 ? slotTable.getVersion() : i6);
    }
}
