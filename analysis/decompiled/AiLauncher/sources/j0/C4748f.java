package j0;

import Z8.C1168p;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\u001b\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a#\u0010\t\u001a\u00020\u0000*\u00060\u0002j\u0002`\u00032\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0000¢\u0006\u0004\b\t\u0010\n\u001a/\u0010\f\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\u0006\u0010\u000b\u001a\u00020\u00002\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0017\u0010\u000e\u001a\u00060\u0006j\u0002`\u0007*\u00020\u0000H\u0000¢\u0006\u0004\b\u000e\u0010\u000f*\n\u0010\u0010\"\u00020\u00062\u00020\u0006*\n\u0010\u0011\"\u00020\u00022\u00020\u0002¨\u0006\u0012"}, d2 = {"", "capacity", "", "Landroidx/compose/runtime/snapshots/SnapshotIdArray;", Const.INTENT_KEY_PKGNAME, "(I)[J", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "id", Const.INTENT_KEY_APIKEY, "([JJ)I", "index", Const.INTENT_KEY_UMID, "([JIJ)[J", "c", "(I)J", "SnapshotId", "SnapshotIdArray", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* renamed from: j0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4748f {
    public static final int a(long[] jArr, long j10) {
        int length = jArr.length - 1;
        int i10 = 0;
        while (i10 <= length) {
            int i11 = (i10 + length) >>> 1;
            long j11 = jArr[i11];
            if (j10 > j11) {
                i10 = i11 + 1;
            } else {
                if (j10 >= j11) {
                    return i11;
                }
                length = i11 - 1;
            }
        }
        return -(i10 + 1);
    }

    public static final long[] b(int i10) {
        return new long[i10];
    }

    public static final long c(int i10) {
        return i10;
    }

    public static final long[] d(long[] jArr, int i10, long j10) {
        int length = jArr.length;
        long[] jArr2 = new long[length + 1];
        C1168p.h(jArr, jArr2, 0, 0, i10);
        C1168p.h(jArr, jArr2, i10 + 1, i10, length);
        jArr2[i10] = j10;
        return jArr2;
    }
}
