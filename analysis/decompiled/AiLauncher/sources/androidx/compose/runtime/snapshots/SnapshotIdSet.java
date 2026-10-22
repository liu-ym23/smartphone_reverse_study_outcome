package androidx.compose.runtime.snapshots;

import Ka.l;
import Ka.m;
import Y8.t;
import Z8.C1174w;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import j0.C4744b;
import j0.C4747e;
import j0.C4748f;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.internal.i;
import p9.p;
import q9.InterfaceC5162a;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u0000 !2\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001:\u0001\u001bB5\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003\u0012\u000e\u0010\t\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\r2\n\u0010\f\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u00002\n\u0010\f\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0012H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0016\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0015\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u0018\u0010\u0006\u001a\u00060\u0002j\u0002`\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u001c\u0010\t\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "upperSet", "lowerSet", "lowerBound", "", "Landroidx/compose/runtime/snapshots/SnapshotIdArray;", "belowBound", "<init>", "(JJJ[J)V", "id", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(J)Z", "l", "(J)Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "", "iterator", "()Ljava/util/Iterator;", "default", "k", "(J)J", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "J", Const.INTENT_KEY_PKGNAME, "c", Const.INTENT_KEY_UMID, "[J", "e", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SnapshotIdSet implements Iterable<Long>, InterfaceC5162a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    public static final SnapshotIdSet f11761f = new SnapshotIdSet(0, 0, 0, null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final long upperSet;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final long lowerSet;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final long lowerBound;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final long[] belowBound;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdSet$a;", "", "<init>", "()V", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "EMPTY", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", Const.INTENT_KEY_APIKEY, "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: androidx.compose.runtime.snapshots.SnapshotIdSet$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final SnapshotIdSet a() {
            return SnapshotIdSet.f11761f;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\f\u0012\b\u0012\u00060\u0001j\u0002`\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"LKa/l;", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "LY8/t;", "<anonymous>", "(LKa/l;)V"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1", f = "SnapshotIdSet.kt", l = {252, 256, 263}, m = "invokeSuspend")
    /* renamed from: androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements p<l<? super Long>, InterfaceC4014c<? super t>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public Object f11766a;

        /* renamed from: b, reason: collision with root package name */
        public int f11767b;

        /* renamed from: c, reason: collision with root package name */
        public int f11768c;

        /* renamed from: d, reason: collision with root package name */
        public int f11769d;

        /* renamed from: e, reason: collision with root package name */
        public /* synthetic */ Object f11770e;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = SnapshotIdSet.this.new AnonymousClass1(interfaceC4014c);
            anonymousClass1.f11770e = obj;
            return anonymousClass1;
        }

        @Override // p9.p
        public final Object invoke(l<? super Long> lVar, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(lVar, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0079, code lost:
        
            if (r15.a(r4, r20) == r1) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x00b5, code lost:
        
            if (r13.a(r4, r20) == r1) goto L40;
         */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0063  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x007f  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x008c  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0090  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00ba  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00c5  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00c8  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0079 -> B:19:0x007d). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x009b -> B:30:0x00b8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00b5 -> B:30:0x00b8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00d3 -> B:43:0x00f4). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00f2 -> B:42:0x00f3). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 249
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotIdSet.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public SnapshotIdSet(long j10, long j11, long j12, long[] jArr) {
        this.upperSet = j10;
        this.lowerSet = j11;
        this.lowerBound = j12;
        this.belowBound = jArr;
    }

    @Override // java.lang.Iterable
    public Iterator<Long> iterator() {
        return m.b(new AnonymousClass1(null)).iterator();
    }

    public final boolean j(long id) {
        long[] jArr;
        long j10 = id - this.lowerBound;
        long j11 = 0;
        return (kotlin.jvm.internal.p.l(j10, j11) < 0 || kotlin.jvm.internal.p.l(j10, (long) 64) >= 0) ? (kotlin.jvm.internal.p.l(j10, (long) 64) < 0 || kotlin.jvm.internal.p.l(j10, (long) 128) >= 0) ? kotlin.jvm.internal.p.l(j10, j11) <= 0 && (jArr = this.belowBound) != null && C4748f.a(jArr, id) >= 0 : ((1 << (((int) j10) - 64)) & this.upperSet) != 0 : ((1 << ((int) j10)) & this.lowerSet) != 0;
    }

    public final long k(long j10) {
        long[] jArr = this.belowBound;
        if (jArr != null) {
            return jArr[0];
        }
        if (this.lowerSet != 0) {
            return this.lowerBound + Long.numberOfTrailingZeros(r0);
        }
        return this.upperSet != 0 ? this.lowerBound + 64 + Long.numberOfTrailingZeros(r0) : j10;
    }

    public final SnapshotIdSet l(long id) {
        long j10;
        long j11;
        long[] jArrB;
        long j12 = id - this.lowerBound;
        long j13 = 0;
        if (kotlin.jvm.internal.p.l(j12, j13) < 0 || kotlin.jvm.internal.p.l(j12, 64) >= 0) {
            long j14 = 64;
            if (kotlin.jvm.internal.p.l(j12, j14) < 0 || kotlin.jvm.internal.p.l(j12, 128) >= 0) {
                long j15 = 128;
                if (kotlin.jvm.internal.p.l(j12, j15) < 0) {
                    long[] jArr = this.belowBound;
                    if (jArr == null) {
                        return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, new long[]{id});
                    }
                    int iA = C4748f.a(jArr, id);
                    if (iA < 0) {
                        return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, C4748f.d(jArr, -(iA + 1), id));
                    }
                } else if (!j(id)) {
                    long j16 = this.upperSet;
                    long j17 = this.lowerSet;
                    long j18 = this.lowerBound;
                    long j19 = 1;
                    long j20 = ((id + j19) / j14) * j14;
                    if (kotlin.jvm.internal.p.l(j20, j13) < 0) {
                        j20 = (Long.MAX_VALUE - j15) + j19;
                    }
                    C4747e c4747e = null;
                    long j21 = j16;
                    while (true) {
                        if (kotlin.jvm.internal.p.l(j18, j20) >= 0) {
                            j10 = j17;
                            j11 = j18;
                            break;
                        }
                        if (j17 != 0) {
                            if (c4747e == null) {
                                c4747e = new C4747e(this.belowBound);
                            }
                            int i10 = 0;
                            while (i10 < 64) {
                                long j22 = j17;
                                if ((j17 & (1 << i10)) != 0) {
                                    c4747e.a(i10 + j18);
                                }
                                i10++;
                                j17 = j22;
                            }
                        }
                        if (j21 == 0) {
                            j11 = j20;
                            j10 = 0;
                            break;
                        }
                        j18 += j14;
                        j17 = j21;
                        j21 = 0;
                    }
                    if (c4747e == null || (jArrB = c4747e.b()) == null) {
                        jArrB = this.belowBound;
                    }
                    return new SnapshotIdSet(j21, j10, j11, jArrB).l(id);
                }
            } else {
                long j23 = 1 << (((int) j12) - 64);
                long j24 = this.upperSet;
                if ((j24 & j23) == 0) {
                    return new SnapshotIdSet(j24 | j23, this.lowerSet, this.lowerBound, this.belowBound);
                }
            }
        } else {
            long j25 = 1 << ((int) j12);
            long j26 = this.lowerSet;
            if ((j26 & j25) == 0) {
                return new SnapshotIdSet(this.upperSet, j26 | j25, this.lowerBound, this.belowBound);
            }
        }
        return this;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append(" [");
        ArrayList arrayList = new ArrayList(C1174w.x(this, 10));
        Iterator<Long> it = iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(it.next().longValue()));
        }
        sb2.append(C4744b.d(arrayList, null, null, null, 0, null, null, 63, null));
        sb2.append(']');
        return sb2.toString();
    }
}
