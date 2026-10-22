package androidx.compose.runtime.snapshots;

import C7.r;
import D7.w;
import S7.n;
import androidx.compose.runtime.Immutable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import i9.k;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;

@Immutable
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u0000 .2\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001:\u0001.B5\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003\u0012\u000e\u0010\t\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b¢\u0006\u0004\b\n\u0010\u000bJ6\u0010\u000f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00002\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0000\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00000\rH\u0082\b¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u00122\n\u0010\u0011\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\u00002\n\u0010\u0011\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\u00002\n\u0010\u0011\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0017\u0010\u0016J\u0015\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0000¢\u0006\u0004\b\u001b\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0000¢\u0006\u0004\b\u001d\u0010\u001aJ\u001a\u0010\u001f\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u001eH\u0096\u0002¢\u0006\u0004\b\u001f\u0010 J(\u0010$\u001a\u00020\"2\u0016\u0010#\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\"0!H\u0086\b¢\u0006\u0004\b$\u0010%J\u001d\u0010'\u001a\u00060\u0002j\u0002`\u00032\n\u0010&\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b'\u0010(J\u000f\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b*\u0010+R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010,R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010,R\u0018\u0010\u0006\u001a\u00060\u0002j\u0002`\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010,R\u001c\u0010\t\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010-¨\u0006/"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "upperSet", "lowerSet", "lowerBound", "", "Landroidx/compose/runtime/snapshots/SnapshotIdArray;", "belowBound", AppAgent.CONSTRUCT, "(JJJ[J)V", "initial", "Lkotlin/Function2;", "operation", "fastFold", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;LS7/n;)Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "id", "", "get", "(J)Z", "set", "(J)Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "clear", "ids", "andNot", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "and", "bits", "or", "", "iterator", "()Ljava/util/Iterator;", "Lkotlin/Function1;", "LC7/r;", "block", "fastForEach", "(LS7/k;)V", "default", "lowest", "(J)J", "", "toString", "()Ljava/lang/String;", "J", "[J", "Companion", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SnapshotIdSet implements Iterable<Long>, T7.a {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SnapshotIdSet EMPTY = new SnapshotIdSet(0, 0, 0, null);
    private final long[] belowBound;
    private final long lowerBound;
    private final long lowerSet;
    private final long upperSet;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdSet$Companion;", "", AppAgent.CONSTRUCT, "()V", "EMPTY", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "getEMPTY", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final SnapshotIdSet getEMPTY() {
            return SnapshotIdSet.EMPTY;
        }

        private Companion() {
        }
    }

    @J7.c(c = "androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1", f = "SnapshotIdSet.kt", l = {252, 256, 263}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\f\u0012\b\u0012\u00060\u0001j\u0002`\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Li9/k;", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "LC7/r;", "<anonymous>", "(Li9/k;)V"}, k = 3, mv = {2, 0, 0})
    /* renamed from: androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements n {
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass1 anonymousClass1 = SnapshotIdSet.this.new AnonymousClass1(cVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // S7.n
        public final Object invoke(k kVar, H7.c<? super r> cVar) {
            return ((AnonymousClass1) create(kVar, cVar)).invokeSuspend(r.f317a);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x007b  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x007f  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00aa  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00b5  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00b8  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x008b -> B:26:0x00a8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00e2 -> B:37:0x00e3). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                Method dump skipped, instructions count: 233
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotIdSet.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private SnapshotIdSet(long j5, long j6, long j10, long[] jArr) {
        this.upperSet = j5;
        this.lowerSet = j6;
        this.lowerBound = j10;
        this.belowBound = jArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [androidx.compose.runtime.snapshots.SnapshotIdSet] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r13v0, types: [S7.n] */
    private final SnapshotIdSet fastFold(SnapshotIdSet initial, n operation) {
        long[] jArr = this.belowBound;
        int i = 0;
        if (jArr != null) {
            int length = jArr.length;
            int i6 = 0;
            initial = initial;
            while (i6 < length) {
                Object objInvoke = operation.invoke(initial, Long.valueOf(jArr[i6]));
                i6++;
                initial = objInvoke;
            }
        }
        if (this.lowerSet != 0) {
            int i10 = 0;
            initial = initial;
            while (i10 < 64) {
                if ((this.lowerSet & (1 << i10)) != 0) {
                    initial = operation.invoke(initial, Long.valueOf(this.lowerBound + i10));
                }
                i10++;
                initial = initial;
            }
        }
        initial = initial;
        if (this.upperSet != 0) {
            while (i < 64) {
                if ((this.upperSet & (1 << i)) != 0) {
                    initial = operation.invoke(initial, Long.valueOf(this.lowerBound + i + 64));
                }
                i++;
                initial = initial;
            }
        }
        return (SnapshotIdSet) initial;
    }

    public final SnapshotIdSet and(SnapshotIdSet ids) {
        SnapshotIdSet snapshotIdSet = EMPTY;
        if (!kotlin.jvm.internal.k.b(ids, snapshotIdSet) && !equals(snapshotIdSet)) {
            long j5 = ids.lowerBound;
            long j6 = this.lowerBound;
            if (j5 == j6) {
                long[] jArr = ids.belowBound;
                long[] jArr2 = this.belowBound;
                if (jArr == jArr2) {
                    long j10 = this.upperSet;
                    long j11 = ids.upperSet;
                    long j12 = j10 & j11;
                    long j13 = this.lowerSet;
                    long j14 = ids.lowerSet;
                    long j15 = j13 & j14;
                    if (j12 != 0 || j15 != 0 || jArr2 != null) {
                        return new SnapshotIdSet(j10 & j11, j13 & j14, j6, jArr2);
                    }
                }
            }
            int i = 0;
            if (this.belowBound == null) {
                long[] jArr3 = this.belowBound;
                if (jArr3 != null) {
                    for (long j16 : jArr3) {
                        if (ids.get(j16)) {
                            snapshotIdSet = snapshotIdSet.set(j16);
                        }
                    }
                }
                if (this.lowerSet != 0) {
                    for (int i6 = 0; i6 < 64; i6++) {
                        if ((this.lowerSet & (1 << i6)) != 0) {
                            long j17 = this.lowerBound + i6;
                            if (ids.get(j17)) {
                                snapshotIdSet = snapshotIdSet.set(j17);
                            }
                        }
                    }
                }
                if (this.upperSet != 0) {
                    while (i < 64) {
                        if ((this.upperSet & (1 << i)) != 0) {
                            long j18 = this.lowerBound + i + 64;
                            if (ids.get(j18)) {
                                snapshotIdSet = snapshotIdSet.set(j18);
                            }
                        }
                        i++;
                    }
                }
                return snapshotIdSet;
            }
            long[] jArr4 = ids.belowBound;
            if (jArr4 != null) {
                for (long j19 : jArr4) {
                    if (get(j19)) {
                        snapshotIdSet = snapshotIdSet.set(j19);
                    }
                }
            }
            if (ids.lowerSet != 0) {
                for (int i10 = 0; i10 < 64; i10++) {
                    if ((ids.lowerSet & (1 << i10)) != 0) {
                        long j20 = ids.lowerBound + i10;
                        if (get(j20)) {
                            snapshotIdSet = snapshotIdSet.set(j20);
                        }
                    }
                }
            }
            if (ids.upperSet != 0) {
                while (i < 64) {
                    if ((ids.upperSet & (1 << i)) != 0) {
                        long j21 = ids.lowerBound + i + 64;
                        if (get(j21)) {
                            snapshotIdSet = snapshotIdSet.set(j21);
                        }
                    }
                    i++;
                }
            }
            return snapshotIdSet;
        }
        return snapshotIdSet;
    }

    public final SnapshotIdSet andNot(SnapshotIdSet ids) {
        SnapshotIdSet snapshotIdSet = EMPTY;
        if (ids == snapshotIdSet) {
            return this;
        }
        if (this == snapshotIdSet) {
            return snapshotIdSet;
        }
        long j5 = ids.lowerBound;
        long j6 = this.lowerBound;
        if (j5 == j6) {
            long[] jArr = ids.belowBound;
            long[] jArr2 = this.belowBound;
            if (jArr == jArr2) {
                return new SnapshotIdSet((~ids.upperSet) & this.upperSet, this.lowerSet & (~ids.lowerSet), j6, jArr2);
            }
        }
        long[] jArr3 = ids.belowBound;
        if (jArr3 != null) {
            for (long j10 : jArr3) {
                this = this.clear(j10);
            }
        }
        if (ids.lowerSet != 0) {
            for (int i = 0; i < 64; i++) {
                if ((ids.lowerSet & (1 << i)) != 0) {
                    this = this.clear(ids.lowerBound + i);
                }
            }
        }
        if (ids.upperSet != 0) {
            for (int i6 = 0; i6 < 64; i6++) {
                if ((ids.upperSet & (1 << i6)) != 0) {
                    this = this.clear(ids.lowerBound + i6 + 64);
                }
            }
        }
        return this;
    }

    public final SnapshotIdSet clear(long id) {
        long[] jArr;
        int iBinarySearch;
        long j5 = id - this.lowerBound;
        long j6 = 0;
        if (kotlin.jvm.internal.k.h(j5, j6) >= 0 && kotlin.jvm.internal.k.h(j5, 64) < 0) {
            long j10 = 1 << ((int) j5);
            long j11 = this.lowerSet;
            if ((j11 & j10) != 0) {
                return new SnapshotIdSet(this.upperSet, j11 & (~j10), this.lowerBound, this.belowBound);
            }
        } else if (kotlin.jvm.internal.k.h(j5, 64) >= 0 && kotlin.jvm.internal.k.h(j5, 128) < 0) {
            long j12 = 1 << (((int) j5) - 64);
            long j13 = this.upperSet;
            if ((j13 & j12) != 0) {
                return new SnapshotIdSet(j13 & (~j12), this.lowerSet, this.lowerBound, this.belowBound);
            }
        } else if (kotlin.jvm.internal.k.h(j5, j6) < 0 && (jArr = this.belowBound) != null && (iBinarySearch = SnapshotId_jvmKt.binarySearch(jArr, id)) >= 0) {
            return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, SnapshotId_jvmKt.withIdRemovedAt(jArr, iBinarySearch));
        }
        return this;
    }

    public final void fastForEach(S7.k block) {
        long[] jArr = this.belowBound;
        if (jArr != null) {
            for (long j5 : jArr) {
                block.invoke(Long.valueOf(j5));
            }
        }
        if (this.lowerSet != 0) {
            for (int i = 0; i < 64; i++) {
                if ((this.lowerSet & (1 << i)) != 0) {
                    block.invoke(Long.valueOf(this.lowerBound + i));
                }
            }
        }
        if (this.upperSet != 0) {
            for (int i6 = 0; i6 < 64; i6++) {
                if ((this.upperSet & (1 << i6)) != 0) {
                    block.invoke(Long.valueOf(this.lowerBound + i6 + 64));
                }
            }
        }
    }

    public final boolean get(long id) {
        long[] jArr;
        long j5 = id - this.lowerBound;
        long j6 = 0;
        return (kotlin.jvm.internal.k.h(j5, j6) < 0 || kotlin.jvm.internal.k.h(j5, (long) 64) >= 0) ? (kotlin.jvm.internal.k.h(j5, (long) 64) < 0 || kotlin.jvm.internal.k.h(j5, (long) 128) >= 0) ? kotlin.jvm.internal.k.h(j5, j6) <= 0 && (jArr = this.belowBound) != null && SnapshotId_jvmKt.binarySearch(jArr, id) >= 0 : ((1 << (((int) j5) - 64)) & this.upperSet) != 0 : ((1 << ((int) j5)) & this.lowerSet) != 0;
    }

    @Override // java.lang.Iterable
    public Iterator<Long> iterator() {
        return U7.a.K(new AnonymousClass1(null));
    }

    public final long lowest(long j5) {
        long[] jArr = this.belowBound;
        if (jArr != null) {
            return jArr[0];
        }
        if (this.lowerSet != 0) {
            return this.lowerBound + Long.numberOfTrailingZeros(r0);
        }
        return this.upperSet != 0 ? this.lowerBound + 64 + Long.numberOfTrailingZeros(r0) : j5;
    }

    public final SnapshotIdSet or(SnapshotIdSet bits) {
        SnapshotIdSet snapshotIdSet = EMPTY;
        if (bits == snapshotIdSet) {
            return this;
        }
        if (this == snapshotIdSet) {
            return bits;
        }
        long j5 = bits.lowerBound;
        long j6 = this.lowerBound;
        if (j5 == j6) {
            long[] jArr = bits.belowBound;
            long[] jArr2 = this.belowBound;
            if (jArr == jArr2) {
                return new SnapshotIdSet(bits.upperSet | this.upperSet, this.lowerSet | bits.lowerSet, j6, jArr2);
            }
        }
        int i = 0;
        if (this.belowBound == null) {
            long[] jArr3 = this.belowBound;
            if (jArr3 != null) {
                for (long j10 : jArr3) {
                    bits = bits.set(j10);
                }
            }
            if (this.lowerSet != 0) {
                for (int i6 = 0; i6 < 64; i6++) {
                    if ((this.lowerSet & (1 << i6)) != 0) {
                        bits = bits.set(this.lowerBound + i6);
                    }
                }
            }
            if (this.upperSet != 0) {
                while (i < 64) {
                    if ((this.upperSet & (1 << i)) != 0) {
                        bits = bits.set(this.lowerBound + i + 64);
                    }
                    i++;
                }
            }
            return bits;
        }
        long[] jArr4 = bits.belowBound;
        if (jArr4 != null) {
            for (long j11 : jArr4) {
                this = this.set(j11);
            }
        }
        if (bits.lowerSet != 0) {
            for (int i10 = 0; i10 < 64; i10++) {
                if ((bits.lowerSet & (1 << i10)) != 0) {
                    this = this.set(bits.lowerBound + i10);
                }
            }
        }
        if (bits.upperSet != 0) {
            while (i < 64) {
                if ((bits.upperSet & (1 << i)) != 0) {
                    this = this.set(bits.lowerBound + i + 64);
                }
                i++;
            }
        }
        return this;
    }

    public final SnapshotIdSet set(long id) {
        long j5;
        long j6;
        long[] array;
        long j10 = id - this.lowerBound;
        long j11 = 0;
        if (kotlin.jvm.internal.k.h(j10, j11) < 0 || kotlin.jvm.internal.k.h(j10, 64) >= 0) {
            long j12 = 64;
            if (kotlin.jvm.internal.k.h(j10, j12) < 0 || kotlin.jvm.internal.k.h(j10, 128) >= 0) {
                long j13 = 128;
                if (kotlin.jvm.internal.k.h(j10, j13) < 0) {
                    long[] jArr = this.belowBound;
                    if (jArr == null) {
                        return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, new long[]{id});
                    }
                    int iBinarySearch = SnapshotId_jvmKt.binarySearch(jArr, id);
                    if (iBinarySearch < 0) {
                        return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, SnapshotId_jvmKt.withIdInsertedAt(jArr, -(iBinarySearch + 1), id));
                    }
                } else if (!get(id)) {
                    long j14 = this.upperSet;
                    long j15 = this.lowerSet;
                    long j16 = this.lowerBound;
                    long j17 = 1;
                    long j18 = ((id + j17) / j12) * j12;
                    if (kotlin.jvm.internal.k.h(j18, j11) < 0) {
                        j18 = (Long.MAX_VALUE - j13) + j17;
                    }
                    SnapshotIdArrayBuilder snapshotIdArrayBuilder = null;
                    long j19 = j14;
                    while (true) {
                        if (kotlin.jvm.internal.k.h(j16, j18) >= 0) {
                            j5 = j15;
                            j6 = j16;
                            break;
                        }
                        if (j15 != 0) {
                            if (snapshotIdArrayBuilder == null) {
                                snapshotIdArrayBuilder = new SnapshotIdArrayBuilder(this.belowBound);
                            }
                            int i = 0;
                            while (i < 64) {
                                long j20 = j15;
                                if ((j15 & (1 << i)) != 0) {
                                    snapshotIdArrayBuilder.add(i + j16);
                                }
                                i++;
                                j15 = j20;
                            }
                        }
                        if (j19 == 0) {
                            j6 = j18;
                            j5 = 0;
                            break;
                        }
                        j16 += j12;
                        j15 = j19;
                        j19 = 0;
                    }
                    if (snapshotIdArrayBuilder == null || (array = snapshotIdArrayBuilder.toArray()) == null) {
                        array = this.belowBound;
                    }
                    return new SnapshotIdSet(j19, j5, j6, array).set(id);
                }
            } else {
                long j21 = 1 << (((int) j10) - 64);
                long j22 = this.upperSet;
                if ((j22 & j21) == 0) {
                    return new SnapshotIdSet(j22 | j21, this.lowerSet, this.lowerBound, this.belowBound);
                }
            }
        } else {
            long j23 = 1 << ((int) j10);
            long j24 = this.lowerSet;
            if ((j24 & j23) == 0) {
                return new SnapshotIdSet(this.upperSet, j24 | j23, this.lowerBound, this.belowBound);
            }
        }
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" [");
        ArrayList arrayList = new ArrayList(w.c0(this, 10));
        Iterator<Long> it = iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(it.next().longValue()));
        }
        return B7.a.g(']', ListUtilsKt.fastJoinToString$default(arrayList, null, null, null, 0, null, null, 63, null), sb);
    }
}
