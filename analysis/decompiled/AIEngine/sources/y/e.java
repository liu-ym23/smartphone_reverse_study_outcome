package y;

import androidx.compose.runtime.snapshots.SnapshotStateList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f13939a = new Object();

    public static final void a(int i10, int i11) {
        if (i10 < 0 || i10 >= i11) {
            throw new IndexOutOfBoundsException("index (" + i10 + ") is out of bound of [0, " + i11 + ')');
        }
    }

    public static final boolean b(h hVar, int i10, s.b bVar, boolean z) {
        boolean z3;
        synchronized (f13939a) {
            try {
                int i11 = hVar.f13946d;
                if (i11 == i10) {
                    hVar.f13945c = bVar;
                    z3 = true;
                    if (z) {
                        hVar.f13947e++;
                    }
                    hVar.f13946d = i11 + 1;
                } else {
                    z3 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z3;
    }

    public static final int c(long[] jArr, long j10) {
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

    public static final h d(SnapshotStateList snapshotStateList) {
        k firstStateRecord = snapshotStateList.getFirstStateRecord();
        kotlin.jvm.internal.g.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.<get-readable>>");
        return (h) d.h((h) firstStateRecord, snapshotStateList);
    }

    public static final int e(SnapshotStateList snapshotStateList) {
        k firstStateRecord = snapshotStateList.getFirstStateRecord();
        kotlin.jvm.internal.g.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
        return ((h) d.a((h) firstStateRecord)).f13947e;
    }

    public static final boolean f(SnapshotStateList snapshotStateList, zb.l lVar) {
        int i10;
        s.b<? extends T> bVar;
        Object objInvoke;
        b bVarB;
        boolean zB;
        do {
            synchronized (f13939a) {
                k firstStateRecord = snapshotStateList.getFirstStateRecord();
                kotlin.jvm.internal.g.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                h hVar = (h) d.a((h) firstStateRecord);
                i10 = hVar.f13946d;
                bVar = hVar.f13945c;
                lb.n nVar = lb.n.f10413a;
            }
            kotlin.jvm.internal.g.c(bVar);
            t.f fVarBuilder = bVar.builder();
            objInvoke = lVar.invoke(fVarBuilder);
            s.b bVarC = fVarBuilder.c();
            if (kotlin.jvm.internal.g.b(bVarC, bVar)) {
                break;
            }
            k firstStateRecord2 = snapshotStateList.getFirstStateRecord();
            kotlin.jvm.internal.g.d(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            h hVar2 = (h) firstStateRecord2;
            synchronized (d.f13933b) {
                bVarB = d.b();
                zB = b((h) d.i(hVar2, snapshotStateList, bVarB), i10, bVarC, true);
            }
            d.d(bVarB, snapshotStateList);
        } while (!zB);
        return ((Boolean) objInvoke).booleanValue();
    }
}
