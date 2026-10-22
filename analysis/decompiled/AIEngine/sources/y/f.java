package y;

import androidx.compose.runtime.snapshots.SnapshotStateSet;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f13940a = new Object();

    public static final <T> boolean a(m<T> mVar, int i10, s.c<? extends T> cVar) {
        boolean z;
        synchronized (f13940a) {
            int i11 = mVar.f13956d;
            if (i11 == i10) {
                mVar.f13955c = cVar;
                z = true;
                mVar.f13956d = i11 + 1;
            } else {
                z = false;
            }
        }
        return z;
    }

    public static final <T> int b(SnapshotStateSet<T> snapshotStateSet) {
        k firstStateRecord = snapshotStateSet.getFirstStateRecord();
        kotlin.jvm.internal.g.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.withCurrent>");
        return ((m) d.a((m) firstStateRecord)).f13956d;
    }

    public static final <T> m<T> c(SnapshotStateSet<T> snapshotStateSet) {
        k firstStateRecord = snapshotStateSet.getFirstStateRecord();
        kotlin.jvm.internal.g.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.<get-readable>>");
        return (m) d.h((m) firstStateRecord, snapshotStateSet);
    }
}
