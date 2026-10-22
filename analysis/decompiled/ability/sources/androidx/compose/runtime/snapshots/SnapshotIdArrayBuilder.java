package androidx.compose.runtime.snapshots;

import androidx.collection.MutableLongList;
import androidx.compose.runtime.internal.StabilityInferred;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Arrays;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u000b\u001a\u00020\n2\n\u0010\t\u001a\u00060\u0007j\u0002`\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdArrayBuilder;", "", "", "Landroidx/compose/runtime/snapshots/SnapshotIdArray;", "array", AppAgent.CONSTRUCT, "([J)V", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "id", "LC7/r;", "add", "(J)V", "toArray", "()[J", "Landroidx/collection/MutableLongList;", "list", "Landroidx/collection/MutableLongList;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SnapshotIdArrayBuilder {
    public static final int $stable = 8;
    private final MutableLongList list;

    public SnapshotIdArrayBuilder(long[] jArr) {
        MutableLongList mutableLongList;
        if (jArr != null) {
            long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
            mutableLongList = new MutableLongList(jArrCopyOf.length);
            mutableLongList.addAll(mutableLongList._size, jArrCopyOf);
        } else {
            mutableLongList = new MutableLongList(0, 1, null);
        }
        this.list = mutableLongList;
    }

    public final void add(long id) {
        this.list.add(id);
    }

    public final long[] toArray() {
        MutableLongList mutableLongList = this.list;
        int i = mutableLongList._size;
        if (i == 0) {
            return null;
        }
        long[] jArr = new long[i];
        long[] jArr2 = mutableLongList.content;
        for (int i6 = 0; i6 < i; i6++) {
            jArr[i6] = jArr2[i6];
        }
        return jArr;
    }
}
