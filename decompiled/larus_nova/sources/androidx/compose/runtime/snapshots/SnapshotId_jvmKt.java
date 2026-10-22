package androidx.compose.runtime.snapshots;

import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001d\u0010\b\u001a\u00020\u0006*\u00060\u0001j\u0002`\u00032\n\u0010\t\u001a\u00060\u0001j\u0002`\u0003H\u0080\n\u001a\u0019\u0010\b\u001a\u00020\u0006*\u00060\u0001j\u0002`\u00032\u0006\u0010\t\u001a\u00020\u0006H\u0080\n\u001a\u001d\u0010\n\u001a\u00060\u0001j\u0002`\u0003*\u00060\u0001j\u0002`\u00032\u0006\u0010\t\u001a\u00020\u0006H\u0080\n\u001a!\u0010\u000b\u001a\u00060\u0001j\u0002`\u0003*\u00060\u0001j\u0002`\u00032\n\u0010\t\u001a\u00060\u0001j\u0002`\u0003H\u0080\n\u001a\u001d\u0010\u000b\u001a\u00060\u0001j\u0002`\u0003*\u00060\u0001j\u0002`\u00032\u0006\u0010\t\u001a\u00020\u0006H\u0080\n\u001a\u001d\u0010\f\u001a\u00060\u0001j\u0002`\u0003*\u00060\u0001j\u0002`\u00032\u0006\u0010\t\u001a\u00020\u0006H\u0080\n\u001a\u001d\u0010\r\u001a\u00060\u0001j\u0002`\u0003*\u00060\u0001j\u0002`\u00032\u0006\u0010\t\u001a\u00020\u0006H\u0080\n\u001a\u0011\u0010\u000e\u001a\u00020\u0006*\u00060\u0001j\u0002`\u0003H\u0086\b\u001a\u0011\u0010\u000f\u001a\u00020\u0001*\u00060\u0001j\u0002`\u0003H\u0086\b\u001a\u0014\u0010\u0012\u001a\u00060\u0011j\u0002`\u00132\u0006\u0010\u0014\u001a\u00020\u0006H\u0000\u001a\u001d\u0010\u0015\u001a\u00060\u0001j\u0002`\u0003*\u00060\u0011j\u0002`\u00132\u0006\u0010\u0016\u001a\u00020\u0006H\u0080\n\u001a%\u0010\u0017\u001a\u00020\u0018*\u00060\u0011j\u0002`\u00132\u0006\u0010\u0016\u001a\u00020\u00062\n\u0010\u0019\u001a\u00060\u0001j\u0002`\u0003H\u0080\n\u001a\u001d\u0010\u001d\u001a\u00020\u0018*\u00060\u0011j\u0002`\u00132\n\u0010\t\u001a\u00060\u0011j\u0002`\u0013H\u0080\b\u001a\u0015\u0010\u001e\u001a\u00060\u0001j\u0002`\u0003*\u00060\u0011j\u0002`\u0013H\u0080\b\u001a\u001c\u0010\u001f\u001a\u00020\u0006*\u00060\u0011j\u0002`\u00132\n\u0010 \u001a\u00060\u0001j\u0002`\u0003H\u0000\u001a)\u0010!\u001a\u00020\u0018*\u00060\u0011j\u0002`\u00132\u0016\u0010\"\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0012\u0004\u0012\u00020\u00180#H\u0080\b\u001a(\u0010$\u001a\u00060\u0011j\u0002`\u0013*\u00060\u0011j\u0002`\u00132\u0006\u0010\u0016\u001a\u00020\u00062\n\u0010 \u001a\u00060\u0001j\u0002`\u0003H\u0000\u001a \u0010%\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0013*\u00060\u0011j\u0002`\u00132\u0006\u0010\u0016\u001a\u00020\u0006H\u0000\u001a\u0019\u0010&\u001a\u00060\u0011j\u0002`\u00132\n\u0010 \u001a\u00060\u0001j\u0002`\u0003H\u0080\b\u001a\u0010\u0010'\u001a\u00060\u0001j\u0002`\u0003*\u00020\u0006H\u0000\u001a\u0010\u0010'\u001a\u00060\u0001j\u0002`\u0003*\u00020\u0001H\u0000\"\u0012\u0010\u0002\u001a\u00060\u0001j\u0002`\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0004\u001a\u00060\u0001j\u0002`\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0007\u001a\u00060\u0001j\u0002`\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u001d\u0010\u001a\u001a\u00020\u0006*\u00060\u0011j\u0002`\u00138À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c*\n\u0010\u0000\"\u00020\u00012\u00020\u0001*\n\u0010\u0010\"\u00020\u00112\u00020\u0011¨\u0006("}, d2 = {"SnapshotId", "", "SnapshotIdZero", "Landroidx/compose/runtime/snapshots/SnapshotId;", "SnapshotIdMax", "SnapshotIdSize", "", "SnapshotIdInvalidValue", "compareTo", "other", "plus", "minus", "div", "times", "toInt", "toLong", "SnapshotIdArray", "", "snapshotIdArrayWithCapacity", "Landroidx/compose/runtime/snapshots/SnapshotIdArray;", "capacity", MonitorConstants.CONNECT_TYPE_GET, "index", "set", "", "value", "size", "getSize", "([J)I", "copyInto", SoloKtvContext.SOLO_PAGE_FIRST, "binarySearch", "id", "forEach", "block", "Lkotlin/Function1;", "withIdInsertedAt", "withIdRemovedAt", "snapshotIdArrayOf", "toSnapshotId", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SnapshotId_jvmKt {
    public static final long SnapshotIdInvalidValue = -1;
    public static final long SnapshotIdMax = Long.MAX_VALUE;
    public static final int SnapshotIdSize = 64;
    public static final long SnapshotIdZero = 0;

    public static final long minus(long r100, int r101) {
        return r100 - ((long) r101);
    }

    public static final long minus(long r100, long r101) {
        return r100 - r101;
    }

    public static final long plus(long r100, int r101) {
        return r100 + ((long) r101);
    }

    public static final long[] snapshotIdArrayOf(long r100) {
        return new long[]{r100};
    }

    public static final long times(long r100, int r101) {
        return r100 * ((long) r101);
    }

    public static final int toInt(long r100) {
        return (int) r100;
    }

    public static final long toLong(long r100) {
        return r100;
    }

    public static final long toSnapshotId(int r100) {
        return r100;
    }

    public static final long toSnapshotId(long r100) {
        return r100;
    }

    public static final long first(long[] r100) {
        return r100[0];
    }

    public static final int getSize(long[] r100) {
        return r100.length;
    }

    public static final long[] snapshotIdArrayWithCapacity(int r100) {
        return new long[r100];
    }

    public static final int binarySearch(long[] r100, long r101) {
        int r102 = r100.length - 1;
        int r103 = 0;
    L3:
        if (r103 > r102) goto L11;
        int r104 = (r103 + r102) >>> 1;
        long r105 = r100[r104];
        if (r101 > r105) goto L6;
        if (r101 >= r105) goto L9;
        r102 = r104 - 1;
        goto L3
    L9:
        return r104;
    L6:
        r103 = r104 + 1;
        goto L3
    L11:
        return -(r103 + 1);
    }

    public static final int compareTo(long r100, int r101) {
        return Intrinsics.compare(r100, r101);
    }

    public static final void copyInto(long[] r100, long[] r101) {
        ArraysKt.copyInto$default(r100, r101, 0, 0, 0, 12, null);
    }

    public static final long div(long r100, int r101) {
        return r100 / ((long) r101);
    }

    public static final void forEach(long[] r100, Function1<? super Long, Unit> r101) {
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.invoke(Long.valueOf(r100[r103]));
        r103 = r103 + 1;
        goto L3
    }

    public static final long get(long[] r100, int r101) {
        return r100[r101];
    }

    public static final long[] withIdRemovedAt(long[] r100, int r101) {
        int r102 = r100.length - 1;
        if (r102 != 0) goto L6;
        return null;
    L6:
        long[] r103 = new long[r102];
        if (r101 <= 0) goto L9;
        ArraysKt.copyInto(r100, r103, 0, 0, r101);
    L9:
        if (r101 >= r102) goto L11;
        ArraysKt.copyInto(r100, r103, r101, r101 + 1, r102 + 1);
    L11:
        return r103;
    }

    public static final int compareTo(long r100, long r101) {
        return Intrinsics.compare(r100, r101);
    }

    public static final void set(long[] r100, int r101, long r102) {
        r100[r101] = r102;
    }

    public static final long[] withIdInsertedAt(long[] r100, int r101, long r102) {
        int r103 = r100.length + 1;
        long[] r104 = new long[r103];
        ArraysKt.copyInto(r100, r104, 0, 0, r101);
        ArraysKt.copyInto(r100, r104, r101 + 1, r101, r103 - 1);
        r104[r101] = r102;
        return r104;
    }
}
