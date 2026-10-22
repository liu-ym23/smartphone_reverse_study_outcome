package androidx.compose.runtime.snapshots;

import Y8.t;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/runtime/snapshots/a;", "Landroidx/compose/runtime/snapshots/b;", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "snapshotId", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", M5.b.AUTH_STATUS_INVALID, "<init>", "(JLandroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class a extends b {
    public a(long j10, SnapshotIdSet snapshotIdSet) {
        super(j10, snapshotIdSet, null, new InterfaceC5074l() { // from class: j0.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return androidx.compose.runtime.snapshots.a.m(obj);
            }
        });
    }

    public static final t m(Object obj) {
        synchronized (d.h()) {
            List list = d.f11796j;
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((InterfaceC5074l) list.get(i10)).invoke(obj);
            }
        }
        return t.f7040a;
    }
}
