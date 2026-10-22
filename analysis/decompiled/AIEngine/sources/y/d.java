package y;

import androidx.compose.runtime.internal.AtomicInt;
import androidx.compose.runtime.snapshots.SnapshotIdSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.EmptyList;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final androidx.preference.c f13932a = new androidx.preference.c(7);

    /* renamed from: b, reason: collision with root package name */
    public static final Object f13933b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static final SnapshotIdSet f13934c;

    /* renamed from: d, reason: collision with root package name */
    public static final long f13935d;

    /* renamed from: e, reason: collision with root package name */
    public static final c f13936e;

    /* renamed from: f, reason: collision with root package name */
    public static final List<? extends p<? super Set<? extends Object>, ? super b, lb.n>> f13937f = null;

    /* renamed from: g, reason: collision with root package name */
    public static final List<? extends zb.l<Object, lb.n>> f13938g;
    public static final a h;

    static {
        SnapshotIdSet snapshotIdSet = SnapshotIdSet.f990e;
        f13934c = snapshotIdSet;
        long j10 = 1;
        f13935d = j10 + j10;
        c cVar = new c();
        cVar.f13928b = new long[16];
        cVar.f13929c = new int[16];
        int[] iArr = new int[16];
        int i10 = 0;
        while (i10 < 16) {
            int i11 = i10 + 1;
            iArr[i10] = i11;
            i10 = i11;
        }
        cVar.f13930d = iArr;
        f13936e = cVar;
        f13938g = EmptyList.f10001a;
        long j11 = f13935d;
        f13935d = j10 + j11;
        a aVar = new a(j11, snapshotIdSet, null, new n9.d(6));
        f13934c = f13934c.b(aVar.f13926b);
        h = aVar;
        new AtomicInt(0);
    }

    public static final <T extends k> T a(T t8) {
        T t10;
        b bVarB = b();
        T t11 = (T) g(t8, bVarB.d(), bVarB.a());
        if (t11 != null) {
            return t11;
        }
        synchronized (f13933b) {
            b bVarB2 = b();
            t10 = (T) g(t8, bVarB2.d(), bVarB2.a());
        }
        if (t10 != null) {
            return t10;
        }
        f();
        throw null;
    }

    public static final b b() {
        b bVar = (b) f13932a.j();
        return bVar == null ? h : bVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0042, code lost:
    
        r3 = (T) r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T extends y.k> T c(T r10, y.i r11) {
        /*
            y.k r0 = r11.getFirstStateRecord()
            y.c r1 = y.d.f13936e
            int r2 = r1.f13927a
            if (r2 <= 0) goto L10
            long[] r1 = r1.f13928b
            r2 = 0
            r1 = r1[r2]
            goto L12
        L10:
            long r1 = y.d.f13935d
        L12:
            r3 = 1
            long r3 = (long) r3
            long r1 = r1 - r3
            r3 = 0
            r4 = r3
        L17:
            if (r0 == 0) goto L49
            long r5 = r0.f13948a
            r7 = 0
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 != 0) goto L22
            goto L42
        L22:
            int r7 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r7 == 0) goto L46
            int r7 = kotlin.jvm.internal.g.h(r5, r1)
            if (r7 > 0) goto L46
            androidx.compose.runtime.snapshots.SnapshotIdSet r7 = androidx.compose.runtime.snapshots.SnapshotIdSet.f990e
            boolean r5 = r7.a(r5)
            if (r5 != 0) goto L46
            if (r4 != 0) goto L38
            r4 = r0
            goto L46
        L38:
            long r1 = r0.f13948a
            long r5 = r4.f13948a
            int r1 = kotlin.jvm.internal.g.h(r1, r5)
            if (r1 >= 0) goto L44
        L42:
            r3 = r0
            goto L49
        L44:
            r3 = r4
            goto L49
        L46:
            y.k r0 = r0.f13949b
            goto L17
        L49:
            r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r3 == 0) goto L53
            r3.f13948a = r0
            return r3
        L53:
            y.k r10 = r10.b(r0)
            y.k r0 = r11.getFirstStateRecord()
            r10.f13949b = r0
            r11.prependStateRecord(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: y.d.c(y.k, y.i):y.k");
    }

    public static final void d(b bVar, i iVar) {
        bVar.h(bVar.e() + 1);
        zb.l<Object, lb.n> lVarF = bVar.f();
        if (lVarF != null) {
            lVarF.invoke(iVar);
        }
    }

    public static final k e(k kVar, j jVar, b bVar, k kVar2) {
        k kVarC;
        if (bVar.c()) {
            bVar.g(jVar);
        }
        long jD = bVar.d();
        if (kVar2.f13948a == jD) {
            return kVar2;
        }
        synchronized (f13933b) {
            kVarC = c(kVar, jVar);
        }
        kVarC.f13948a = jD;
        if (kVar2.f13948a != 1) {
            bVar.g(jVar);
        }
        return kVarC;
    }

    public static final void f() {
        throw new IllegalStateException("Reading a state that was created after the snapshot was taken or in a snapshot that has not yet been applied");
    }

    public static final <T extends k> T g(T t8, long j10, SnapshotIdSet snapshotIdSet) {
        T t10 = null;
        while (t8 != null) {
            long j11 = t8.f13948a;
            if (j11 != 0 && kotlin.jvm.internal.g.h(j11, j10) <= 0 && !snapshotIdSet.a(j11) && (t10 == null || kotlin.jvm.internal.g.h(t10.f13948a, t8.f13948a) < 0)) {
                t10 = t8;
            }
            t8 = (T) t8.f13949b;
        }
        if (t10 != null) {
            return t10;
        }
        return null;
    }

    public static final <T extends k> T h(T t8, i iVar) {
        T t10;
        b bVarB = b();
        zb.l<Object, lb.n> lVarB = bVarB.b();
        if (lVarB != null) {
            lVarB.invoke(iVar);
        }
        T t11 = (T) g(t8, bVarB.d(), bVarB.a());
        if (t11 != null) {
            return t11;
        }
        synchronized (f13933b) {
            b bVarB2 = b();
            k firstStateRecord = iVar.getFirstStateRecord();
            kotlin.jvm.internal.g.d(firstStateRecord, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.readable");
            t10 = (T) g(firstStateRecord, bVarB2.d(), bVarB2.a());
            if (t10 == null) {
                f();
                throw null;
            }
        }
        return t10;
    }

    public static final <T extends k> T i(T t8, i iVar, b bVar) {
        T t10;
        if (bVar.c()) {
            bVar.g(iVar);
        }
        long jD = bVar.d();
        T t11 = (T) g(t8, jD, bVar.a());
        if (t11 == null) {
            f();
            throw null;
        }
        if (t11.f13948a == bVar.d()) {
            return t11;
        }
        synchronized (f13933b) {
            t10 = (T) g(iVar.getFirstStateRecord(), jD, bVar.a());
            if (t10 == null) {
                f();
                throw null;
            }
            if (t10.f13948a != jD) {
                k kVarC = c(t10, iVar);
                kVarC.a(t10);
                kVarC.f13948a = bVar.d();
                t10 = (T) kVarC;
            }
        }
        if (t11.f13948a != 1) {
            bVar.g(iVar);
        }
        return t10;
    }
}
