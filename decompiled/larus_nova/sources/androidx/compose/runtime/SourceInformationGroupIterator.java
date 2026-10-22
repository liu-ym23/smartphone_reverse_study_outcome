package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionGroup;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.trace.CopyContentTypeString;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0017\u001a\u00020\u0018H\u0096\u0002J\t\u0010\u0019\u001a\u00020\u0002H\u0096\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/compose/runtime/SourceInformationGroupIterator;", "", "Landroidx/compose/runtime/tooling/CompositionGroup;", CopyContentTypeString.TABLE, "Landroidx/compose/runtime/SlotTable;", "parent", "", "group", "Landroidx/compose/runtime/GroupSourceInformation;", "path", "Landroidx/compose/runtime/SourceInformationGroupPath;", "<init>", "(Landroidx/compose/runtime/SlotTable;ILandroidx/compose/runtime/GroupSourceInformation;Landroidx/compose/runtime/SourceInformationGroupPath;)V", "getTable", "()Landroidx/compose/runtime/SlotTable;", "getParent", "()I", "getGroup", "()Landroidx/compose/runtime/GroupSourceInformation;", "getPath", "()Landroidx/compose/runtime/SourceInformationGroupPath;", "version", "index", "hasNext", "", TeaEventTrack.ACTION_DRAMA_NEXT, "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class SourceInformationGroupIterator implements Iterator<CompositionGroup>, KMappedMarker {
    private final GroupSourceInformation group;
    private int index;
    private final int parent;
    private final SourceInformationGroupPath path;
    private final SlotTable table;
    private final int version;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        ArrayList<Object> r100 = this.group.getGroups();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (this.index < r100.size()) goto L7;
        return false;
    L7:
        return true;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public CompositionGroup next() {
        ArrayList<Object> r100 = this.group.getGroups();
        if (r100 == null) goto L5;
        int r101 = this.index;
        this.index = r101 + 1;
        Object r102 = ListProtector.get(r100, r101);
    L7:
        if ((r102 instanceof Anchor) == false) goto L10;
        return new SlotTableGroup(this.table, ((Anchor) r102).getLocation$runtime(), this.version);
    L10:
        if ((r102 instanceof GroupSourceInformation) == true) goto L12;
        ComposerKt.composeRuntimeError("Unexpected group information structure");
        throw new KotlinNothingValueException();
    L12:
        return new SourceInformationSlotTableGroup(this.table, this.parent, (GroupSourceInformation) r102, new RelativeGroupPath(this.path, this.index - 1));
    L5:
        r102 = null;
        goto L7
    }

    public final GroupSourceInformation getGroup() {
        return this.group;
    }

    public final int getParent() {
        return this.parent;
    }

    public final SourceInformationGroupPath getPath() {
        return this.path;
    }

    public final SlotTable getTable() {
        return this.table;
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ CompositionGroup next() {
        return next();
    }

    public SourceInformationGroupIterator(SlotTable r100, int r101, GroupSourceInformation r102, SourceInformationGroupPath r103) {
        this.table = r100;
        this.parent = r101;
        this.group = r102;
        this.path = r103;
        this.version = r100.getVersion$runtime();
    }
}
