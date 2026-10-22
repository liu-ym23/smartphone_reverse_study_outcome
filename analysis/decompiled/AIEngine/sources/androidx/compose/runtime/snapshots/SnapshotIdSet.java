package androidx.compose.runtime.snapshots;

import ac.a;
import com.stepos.core.common.util.TraceIdKeys;
import fc.k;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.internal.g;
import lb.n;
import mb.m;
import qb.b;
import rb.c;
import y.e;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SnapshotIdSet implements Iterable<Long>, a {

    /* renamed from: e, reason: collision with root package name */
    public static final SnapshotIdSet f990e = new SnapshotIdSet(0, 0, 0, null);

    /* renamed from: a, reason: collision with root package name */
    public final long f991a;

    /* renamed from: b, reason: collision with root package name */
    public final long f992b;

    /* renamed from: c, reason: collision with root package name */
    public final long f993c;

    /* renamed from: d, reason: collision with root package name */
    public final long[] f994d;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1", f = "SnapshotIdSet.kt", l = {252, 256, 263}, m = "invokeSuspend")
    /* renamed from: androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements p<k<? super Long>, b<? super n>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public long[] f995a;

        /* renamed from: b, reason: collision with root package name */
        public int f996b;

        /* renamed from: c, reason: collision with root package name */
        public int f997c;

        /* renamed from: d, reason: collision with root package name */
        public int f998d;

        /* renamed from: e, reason: collision with root package name */
        public /* synthetic */ Object f999e;

        public AnonymousClass1(b<? super AnonymousClass1> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<n> create(Object obj, b<?> bVar) {
            AnonymousClass1 anonymousClass1 = SnapshotIdSet.this.new AnonymousClass1(bVar);
            anonymousClass1.f999e = obj;
            return anonymousClass1;
        }

        @Override // zb.p
        public final Object invoke(k<? super Long> kVar, b<? super n> bVar) {
            return ((AnonymousClass1) create(kVar, bVar)).invokeSuspend(n.f10413a);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0079  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x007e  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x009c  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00a1  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00a6  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0083 -> B:26:0x009a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00c5 -> B:37:0x00c6). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r22) {
            /*
                Method dump skipped, instructions count: 203
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotIdSet.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public SnapshotIdSet(long j10, long j11, long j12, long[] jArr) {
        this.f991a = j10;
        this.f992b = j11;
        this.f993c = j12;
        this.f994d = jArr;
    }

    public final boolean a(long j10) {
        long[] jArr;
        long j11 = j10 - this.f993c;
        long j12 = 0;
        return (g.h(j11, j12) < 0 || g.h(j11, (long) 64) >= 0) ? (g.h(j11, (long) 64) < 0 || g.h(j11, (long) TraceIdKeys.MAX_LENGTH) >= 0) ? g.h(j11, j12) <= 0 && (jArr = this.f994d) != null && e.c(jArr, j10) >= 0 : ((1 << (((int) j11) - 64)) & this.f991a) != 0 : ((1 << ((int) j11)) & this.f992b) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0133  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.compose.runtime.snapshots.SnapshotIdSet b(long r38) {
        /*
            Method dump skipped, instructions count: 387
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotIdSet.b(long):androidx.compose.runtime.snapshots.SnapshotIdSet");
    }

    @Override // java.lang.Iterable
    public final Iterator<Long> iterator() {
        return a4.a.o(new AnonymousClass1(null));
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append(" [");
        ArrayList arrayList = new ArrayList(m.Z(this, 10));
        Iterator<Long> it = iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(it.next().longValue()));
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append((CharSequence) "");
        int size = arrayList.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            Object obj = arrayList.get(i11);
            i10++;
            if (i10 > 1) {
                sb3.append((CharSequence) ", ");
            }
            if (obj != null ? obj instanceof CharSequence : true) {
                sb3.append((CharSequence) obj);
            } else if (obj instanceof Character) {
                sb3.append(((Character) obj).charValue());
            } else {
                sb3.append((CharSequence) obj.toString());
            }
        }
        sb3.append((CharSequence) "");
        sb2.append(sb3.toString());
        sb2.append(']');
        return sb2.toString();
    }
}
