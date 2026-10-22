package androidx.compose.runtime.snapshots;

import androidx.collection.MutableLongList;
import java.util.Arrays;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0002\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\fj\u0002`\rJ\u000e\u0010\u000e\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdArrayBuilder;", "", "array", "", "Landroidx/compose/runtime/snapshots/SnapshotIdArray;", "<init>", "([J)V", "list", "Landroidx/collection/MutableLongList;", "add", "", "id", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "toArray", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SnapshotIdArrayBuilder {
    public static final int $stable = 8;
    private final MutableLongList list;

    public final long[] toArray() {
        MutableLongList r100 = this.list;
        int r101 = r100._size;
        if (r101 != 0) goto L6;
        return null;
    L6:
        long[] r102 = new long[r101];
        long[] r103 = r100.content;
        int r104 = 0;
    L7:
        if (r104 >= r101) goto L9;
        r102[r104] = r103[r104];
        r104 = r104 + 1;
        goto L7
    L9:
        return r102;
    }

    public SnapshotIdArrayBuilder(long[] r100) {
        if (r100 == null) goto L5;
        long[] r101 = Arrays.copyOf(r100, r100.length);
        MutableLongList r102 = new MutableLongList(r101.length);
        r102.addAll(r102._size, r101);
    L6:
        this.list = r102;
        return;
    L5:
        r102 = new MutableLongList(0, 1, null);
        goto L6
    }

    public final void add(long r100) {
        this.list.add(r100);
    }
}
