package j0;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Arrays;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u000b\u001a\u00020\n2\n\u0010\t\u001a\u00060\u0007j\u0002`\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0010¨\u0006\u0012"}, d2 = {"Lj0/e;", "", "", "Landroidx/compose/runtime/snapshots/SnapshotIdArray;", "array", "<init>", "([J)V", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "id", "LY8/t;", Const.INTENT_KEY_APIKEY, "(J)V", Const.INTENT_KEY_PKGNAME, "()[J", "Landroidx/collection/m;", "Landroidx/collection/m;", "list", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: j0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4747e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final androidx.collection.m list;

    public C4747e(long[] jArr) {
        androidx.collection.m mVar;
        if (jArr != null) {
            long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
            mVar = new androidx.collection.m(jArrCopyOf.length);
            mVar.d(mVar._size, jArrCopyOf);
        } else {
            mVar = new androidx.collection.m(0, 1, null);
        }
        this.list = mVar;
    }

    public final void a(long id) {
        this.list.c(id);
    }

    public final long[] b() {
        androidx.collection.m mVar = this.list;
        int i10 = mVar._size;
        if (i10 == 0) {
            return null;
        }
        long[] jArr = new long[i10];
        long[] jArr2 = mVar.content;
        for (int i11 = 0; i11 < i10; i11++) {
            jArr[i11] = jArr2[i11];
        }
        return jArr;
    }
}
