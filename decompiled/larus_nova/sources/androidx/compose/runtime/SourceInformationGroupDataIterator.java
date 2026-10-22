package androidx.compose.runtime;

import com.byted.cast.common.TeaEventTrack;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.trace.CopyContentTypeString;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0003H\u0096\u0002J\t\u0010\u0015\u001a\u00020\u0016H\u0096\u0002J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0096\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/compose/runtime/SourceInformationGroupDataIterator;", "", "", "", CopyContentTypeString.TABLE, "Landroidx/compose/runtime/SlotTable;", "group", "", "sourceInformation", "Landroidx/compose/runtime/GroupSourceInformation;", "<init>", "(Landroidx/compose/runtime/SlotTable;ILandroidx/compose/runtime/GroupSourceInformation;)V", "getTable", "()Landroidx/compose/runtime/SlotTable;", "base", "start", "end", "filter", "Landroidx/compose/runtime/BitVector;", "index", "iterator", "hasNext", "", TeaEventTrack.ACTION_DRAMA_NEXT, "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class SourceInformationGroupDataIterator implements Iterable<Object>, Iterator<Object>, KMappedMarker {
    private final int base;
    private final int end;
    private final BitVector filter;
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
        int r100 = this.end;
        int r101 = this.index;
        boolean r102 = false;
        if (r101 < 0) goto L6;
        if (r101 >= r100) goto L6;
        r102 = true;
    L6:
        if (r102 == false) goto L8;
        Object r103 = this.table.getSlots()[this.base + this.index];
    L9:
        this.index = this.filter.nextClear(this.index + 1);
        return r103;
    L8:
        r103 = null;
        goto L9
    }

    public final SlotTable getTable() {
        return this.table;
    }

    public SourceInformationGroupDataIterator(SlotTable r100, int r101, GroupSourceInformation r102) {
        this.table = r100;
        int r103 = r100.getGroups()[(r101 * 5) + 4];
        this.base = r103;
        this.start = r102.getDataStartOffset();
        int r104 = r102.getDataEndOffset();
        if (r104 > 0) goto L10;
        int r105 = r101 + 1;
        if (r105 >= r100.getGroupsSize()) goto L8;
        int r106 = r100.getGroups()[(r105 * 5) + 4];
    L9:
        r104 = r106 - r103;
        goto L10
    L8:
        r106 = r100.getSlotsSize();
    L10:
        this.end = r104;
        BitVector r107 = new BitVector();
        ArrayList<Object> r108 = r102.getGroups();
        if (r108 == null) goto L19;
        int r109 = r108.size();
        int r110 = 0;
    L14:
        if (r110 >= r109) goto L19;
        Object r111 = ListProtector.get(r108, r110);
        if ((r111 instanceof GroupSourceInformation) == false) goto L18;
        GroupSourceInformation r112 = (GroupSourceInformation) r111;
        r107.setRange(r112.getDataStartOffset(), r112.getDataEndOffset());
    L18:
        r110 = r110 + 1;
    L19:
        this.filter = r107;
        this.index = r107.nextClear(this.start);
    }
}
