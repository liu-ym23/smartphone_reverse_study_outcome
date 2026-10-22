package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionGroup;
import com.byted.cast.common.TeaEventTrack;
import com.larus.trace.CopyContentTypeString;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0011H\u0096\u0002J\t\u0010\u0012\u001a\u00020\u0002H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/compose/runtime/GroupIterator;", "", "Landroidx/compose/runtime/tooling/CompositionGroup;", CopyContentTypeString.TABLE, "Landroidx/compose/runtime/SlotTable;", "start", "", "end", "<init>", "(Landroidx/compose/runtime/SlotTable;II)V", "getTable", "()Landroidx/compose/runtime/SlotTable;", "getEnd", "()I", "index", "version", "hasNext", "", TeaEventTrack.ACTION_DRAMA_NEXT, "validateRead", "", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class GroupIterator implements Iterator<CompositionGroup>, KMappedMarker {
    private final int end;
    private int index;
    private final SlotTable table;
    private final int version;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    private final void validateRead() {
        if (this.table.getVersion$runtime() == this.version) goto L6;
        SlotTableKt.throwConcurrentModificationException();
        return;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.index >= this.end) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public CompositionGroup next() {
        validateRead();
        int r100 = this.index;
        this.index = SlotTableKt.access$groupSize(this.table.getGroups(), r100) + r100;
        return new SlotTableGroup(this.table, r100, this.version);
    }

    public final int getEnd() {
        return this.end;
    }

    public final SlotTable getTable() {
        return this.table;
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ CompositionGroup next() {
        return next();
    }

    public GroupIterator(SlotTable r100, int r101, int r102) {
        this.table = r100;
        this.end = r102;
        this.index = r101;
        this.version = r100.getVersion$runtime();
        if (r100.getWriter$runtime() == false) goto L6;
        SlotTableKt.throwConcurrentModificationException();
        return;
    }
}
