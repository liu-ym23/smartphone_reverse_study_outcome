package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionGroup;
import com.larus.trace.CopyContentTypeString;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010(\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00010\u0002B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00010$H\u0096\u0002J\b\u0010)\u001a\u00020*H\u0002J\u0012\u0010+\u001a\u0004\u0018\u00010\u00012\u0006\u0010,\u001a\u00020\u0013H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015R\u001c\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0015R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001eR\u0014\u0010%\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\rR\u0014\u0010'\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\r¨\u0006-"}, d2 = {"Landroidx/compose/runtime/SlotTableGroup;", "Landroidx/compose/runtime/tooling/CompositionGroup;", "", CopyContentTypeString.TABLE, "Landroidx/compose/runtime/SlotTable;", "group", "", "version", "<init>", "(Landroidx/compose/runtime/SlotTable;II)V", "getTable", "()Landroidx/compose/runtime/SlotTable;", "getGroup", "()I", "getVersion", "isEmpty", "", "()Z", "key", "", "getKey", "()Ljava/lang/Object;", "sourceInfo", "", "getSourceInfo", "()Ljava/lang/String;", "node", "getNode", "data", "getData", "()Ljava/lang/Iterable;", DownloadHelper.IDENTITY, "getIdentity", "compositionGroups", "getCompositionGroups", "iterator", "", "groupSize", "getGroupSize", "slotsSize", "getSlotsSize", "validateRead", "", "find", "identityToFind", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class SlotTableGroup implements CompositionGroup, Iterable<CompositionGroup>, KMappedMarker {
    private final int group;
    private final SlotTable table;
    private final int version;

    @Override // androidx.compose.runtime.tooling.CompositionData
    public Iterable<CompositionGroup> getCompositionGroups() {
        return this;
    }

    private final void validateRead() {
        if (this.table.getVersion$runtime() == this.version) goto L6;
        SlotTableKt.throwConcurrentModificationException();
        return;
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public Iterable<Object> getData() {
        GroupSourceInformation r100 = this.table.sourceInformationOf(this.group);
        if (r100 == null) goto L6;
        return new SourceInformationGroupDataIterator(this.table, this.group, r100);
    L6:
        return new DataIterator(this.table, this.group);
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public int getGroupSize() {
        return SlotTableKt.access$groupSize(this.table.getGroups(), this.group);
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public Object getKey() {
        boolean r100 = true;
        if ((this.table.getGroups()[(this.group * 5) + 1] & 536870912) != 0) goto L6;
        r100 = false;
    L6:
        if (r100 == false) goto L9;
        Object r101 = this.table.getSlots()[SlotTableKt.access$objectKeyIndex(this.table.getGroups(), this.group)];
        Intrinsics.checkNotNull(r101);
        return r101;
    L9:
        return Integer.valueOf(this.table.getGroups()[this.group * 5]);
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public Object getNode() {
        boolean r100 = true;
        if ((this.table.getGroups()[(this.group * 5) + 1] & 1073741824) != 0) goto L6;
        r100 = false;
    L6:
        if (r100 == true) goto L10;
        return null;
    L10:
        return this.table.getSlots()[this.table.getGroups()[(this.group * 5) + 4]];
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public int getSlotsSize() {
        int r100 = this.group + getGroupSize();
        if (r100 >= this.table.getGroupsSize()) goto L5;
        int r101 = this.table.getGroups()[(r100 * 5) + 4];
    L7:
        return r101 - this.table.getGroups()[(this.group * 5) + 4];
    L5:
        r101 = this.table.getSlotsSize();
        goto L7
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public String getSourceInfo() {
        GroupSourceInformation r100 = this.table.sourceInformationOf(this.group);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSourceInformation();
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public boolean isEmpty() {
        if (SlotTableKt.access$groupSize(this.table.getGroups(), this.group) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public Object getIdentity() {
        validateRead();
        SlotReader r100 = this.table.openReader();
        Anchor r101 = r100.anchor(this.group);     // Catch: Throwable -> L6
        r100.close();
        return r101;
    L6:
        th = move-exception;
        r100.close();
        throw th;
    }

    @Override // java.lang.Iterable
    public Iterator<CompositionGroup> iterator() {
        validateRead();
        GroupSourceInformation r100 = this.table.sourceInformationOf(this.group);
        if (r100 == null) goto L5;
        SlotTable r101 = this.table;
        int r102 = this.group;
        return new SourceInformationGroupIterator(r101, r102, r100, new AnchoredGroupPath(r102));
    L5:
        SlotTable r103 = this.table;
        int r104 = this.group;
        return new GroupIterator(r103, r104 + 1, r104 + SlotTableKt.access$groupSize(r103.getGroups(), this.group));
    }

    public final int getGroup() {
        return this.group;
    }

    public final SlotTable getTable() {
        return this.table;
    }

    public final int getVersion() {
        return this.version;
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public CompositionGroup find(Object r100) {
        if ((r100 instanceof Anchor) == false) goto L6;
        return find$findAnchoredGroup(this, (Anchor) r100);
    L6:
        if ((r100 instanceof SourceInformationSlotTableGroupIdentity) == false) goto L11;
        SourceInformationSlotTableGroupIdentity r101 = (SourceInformationSlotTableGroupIdentity) r100;
        CompositionGroup r102 = find(r101.getParentIdentity());
        if (r102 == null) goto L11;
        return find$findRelativeGroup(r102, r101.getIndex());
    L11:
        return null;
    }

    private static final CompositionGroup find$findAnchoredGroup(SlotTableGroup r100, Anchor r101) {
        if (r100.table.ownsAnchor(r101) == false) goto L10;
        int r102 = r100.table.anchorIndex(r101);
        int r103 = r100.group;
        if (r102 >= r103) goto L7;
        return null;
    L7:
        if ((r102 - r103) < SlotTableKt.access$groupSize(r100.table.getGroups(), r100.group)) goto L9;
        return null;
    L9:
        return new SlotTableGroup(r100.table, r102, r100.version);
    L10:
        return null;
    }

    private static final CompositionGroup find$findRelativeGroup(CompositionGroup r100, int r101) {
        return (CompositionGroup) CollectionsKt.firstOrNull(CollectionsKt.drop(r100.getCompositionGroups(), r101));
    }

    public SlotTableGroup(SlotTable r100, int r101, int r102) {
        this.table = r100;
        this.group = r101;
        this.version = r102;
    }

    public /* synthetic */ SlotTableGroup(SlotTable r100, int r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = r100.getVersion$runtime();
    L5:
        this(r100, r101, r102);
    }
}
