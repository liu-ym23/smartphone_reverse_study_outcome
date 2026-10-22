package androidx.compose.runtime;

import com.byted.cast.common.TeaEventTrack;
import com.larus.trace.CopyContentTypeString;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0003H\u0096\u0002J\t\u0010\u0016\u001a\u00020\u0017H\u0096\u0002J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0002H\u0096\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0011\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Landroidx/compose/runtime/DataIterator;", "", "", "", CopyContentTypeString.TABLE, "Landroidx/compose/runtime/SlotTable;", "group", "", "<init>", "(Landroidx/compose/runtime/SlotTable;I)V", "getTable", "()Landroidx/compose/runtime/SlotTable;", "start", "getStart", "()I", "end", "getEnd", "index", "getIndex", "setIndex", "(I)V", "iterator", "hasNext", "", TeaEventTrack.ACTION_DRAMA_NEXT, "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DataIterator implements Iterable<Object>, Iterator<Object>, KMappedMarker {
    private final int end;
    private int index;
    private final int start;
    private final SlotTable table;

    @Override // java.lang.Iterable
    public Iterator<Object> iterator() {
        return this;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.index >= this.end) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Iterator
    public Object next() {
        int r100 = this.index;
        if (r100 >= 0) goto L5;
    L7:
        Object r101 = null;
    L8:
        this.index++;
        return r101;
    L5:
        if (r100 >= this.table.getSlots().length) goto L7;
        r101 = this.table.getSlots()[this.index];
        goto L8
    }

    public final int getEnd() {
        return this.end;
    }

    public final int getIndex() {
        return this.index;
    }

    public final int getStart() {
        return this.start;
    }

    public final SlotTable getTable() {
        return this.table;
    }

    public final void setIndex(int r100) {
        this.index = r100;
    }

    public DataIterator(SlotTable r100, int r101) {
        this.table = r100;
        int r102 = r100.getGroups()[(r101 * 5) + 4];
        this.start = r102;
        int r103 = r101 + 1;
        if (r103 >= r100.getGroupsSize()) goto L5;
        int r104 = r100.getGroups()[(r103 * 5) + 4];
    L6:
        this.end = r104;
        this.index = r102;
        return;
    L5:
        r104 = r100.getSlotsSize();
        goto L6
    }
}
