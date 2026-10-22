package androidx.collection;

import D7.q;
import androidx.annotation.IntRange;
import androidx.collection.internal.ContainerHelpersKt;
import androidx.collection.internal.RuntimeHelpersKt;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import i9.i;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0010\n\u0002\u0010#\n\u0002\b\u000e\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0010\u001a\u00020\b2\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0010\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012¢\u0006\u0004\b\u0010\u0010\u0013J\u001b\u0010\u0010\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\u0004\b\u0010\u0010\u0015J\u001b\u0010\u0010\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0010\u0010\u0016J\u001b\u0010\u0010\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017¢\u0006\u0004\b\u0010\u0010\u0018J\u001b\u0010\u0010\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019¢\u0006\u0004\b\u0010\u0010\u001aJ \u0010\f\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000eH\u0086\u0002¢\u0006\u0004\b\f\u0010\u001bJ\u001e\u0010\f\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0086\u0002¢\u0006\u0004\b\f\u0010\u001cJ\u001e\u0010\f\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0086\u0002¢\u0006\u0004\b\f\u0010\u001dJ\u001e\u0010\f\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\u0002¢\u0006\u0004\b\f\u0010\u001eJ\u001e\u0010\f\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0086\u0002¢\u0006\u0004\b\f\u0010\u001fJ\u001e\u0010\f\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0086\u0002¢\u0006\u0004\b\f\u0010 J\u0015\u0010!\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b!\u0010\nJ\u0018\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\"\u0010\rJ\u001d\u0010#\u001a\u00020\b2\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000e¢\u0006\u0004\b#\u0010\u0011J\u001b\u0010#\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\u0004\b#\u0010\u0015J\u001b\u0010#\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012¢\u0006\u0004\b#\u0010\u0013J\u001b\u0010#\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b#\u0010\u0016J\u001b\u0010#\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017¢\u0006\u0004\b#\u0010\u0018J\u001b\u0010#\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019¢\u0006\u0004\b#\u0010\u001aJ \u0010\"\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000eH\u0086\u0002¢\u0006\u0004\b\"\u0010\u001bJ\u001e\u0010\"\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0086\u0002¢\u0006\u0004\b\"\u0010\u001dJ\u001e\u0010\"\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0086\u0002¢\u0006\u0004\b\"\u0010\u001cJ\u001e\u0010\"\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\u0002¢\u0006\u0004\b\"\u0010\u001eJ\u001e\u0010\"\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0086\u0002¢\u0006\u0004\b\"\u0010\u001fJ\u001e\u0010\"\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0086\u0002¢\u0006\u0004\b\"\u0010 J'\u0010&\u001a\u00020\u000b2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0$H\u0086\bø\u0001\u0000¢\u0006\u0004\b&\u0010'J\u001b\u0010)\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000(¢\u0006\u0004\b)\u0010*J\u001b\u0010)\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b)\u0010\u0016J\u001b\u0010)\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017¢\u0006\u0004\b)\u0010\u0018J!\u0010)\u001a\u00020\b2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0$¢\u0006\u0004\b)\u0010+J\u0017\u0010-\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u0003H\u0001¢\u0006\u0004\b-\u0010\u0006J\r\u0010.\u001a\u00020\u000b¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u0003H\u0007¢\u0006\u0004\b0\u00101J\u000f\u00103\u001a\u00020\u000bH\u0000¢\u0006\u0004\b2\u0010/J\u000f\u00105\u001a\u00020\u000bH\u0000¢\u0006\u0004\b4\u0010/J\u0017\u00108\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u0003H\u0000¢\u0006\u0004\b7\u0010\u0006J\u0013\u0010:\u001a\b\u0012\u0004\u0012\u00028\u000009¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b<\u0010\u0006J\u0017\u0010>\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020\u0003H\u0002¢\u0006\u0004\b>\u0010\u0006J\u000f\u0010?\u001a\u00020\u000bH\u0002¢\u0006\u0004\b?\u0010/J\u0017\u0010@\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00028\u0000H\u0002¢\u0006\u0004\b@\u0010AJ\u0017\u0010C\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u0003H\u0002¢\u0006\u0004\bC\u0010DR\u0016\u0010E\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010F\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006G"}, d2 = {"Landroidx/collection/MutableScatterSet;", ExifInterface.LONGITUDE_EAST, "Landroidx/collection/ScatterSet;", "", "initialCapacity", AppAgent.CONSTRUCT, "(I)V", "element", "", "add", "(Ljava/lang/Object;)Z", "LC7/r;", "plusAssign", "(Ljava/lang/Object;)V", "", "elements", "addAll", "([Ljava/lang/Object;)Z", "", "(Ljava/lang/Iterable;)Z", "Li9/i;", "(Li9/i;)Z", "(Landroidx/collection/ScatterSet;)Z", "Landroidx/collection/OrderedScatterSet;", "(Landroidx/collection/OrderedScatterSet;)Z", "Landroidx/collection/ObjectList;", "(Landroidx/collection/ObjectList;)Z", "([Ljava/lang/Object;)V", "(Ljava/lang/Iterable;)V", "(Li9/i;)V", "(Landroidx/collection/ScatterSet;)V", "(Landroidx/collection/OrderedScatterSet;)V", "(Landroidx/collection/ObjectList;)V", "remove", "minusAssign", "removeAll", "Lkotlin/Function1;", "predicate", "removeIf", "(LS7/k;)V", "", "retainAll", "(Ljava/util/Collection;)Z", "(LS7/k;)Z", "index", "removeElementAt", "clear", "()V", "trim", "()I", "adjustStorage$collection", "adjustStorage", "dropDeletes$collection", "dropDeletes", "newCapacity", "resizeStorage$collection", "resizeStorage", "", "asMutableSet", "()Ljava/util/Set;", "initializeStorage", "capacity", "initializeMetadata", "initializeGrowth", "findAbsoluteInsertIndex", "(Ljava/lang/Object;)I", "hash1", "findFirstAvailableSlot", "(I)I", "growthLimit", "I", "collection"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MutableScatterSet<E> extends ScatterSet<E> {
    private int growthLimit;

    public MutableScatterSet() {
        this(0, 1, null);
    }

    private final int findAbsoluteInsertIndex(E element) {
        int iHashCode = (element != null ? element.hashCode() : 0) * ScatterMapKt.MurmurHashC1;
        int i = iHashCode ^ (iHashCode << 16);
        int i6 = i >>> 7;
        int i10 = i & 127;
        int i11 = this._capacity;
        int i12 = i6 & i11;
        int i13 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i14 = i12 >> 3;
            int i15 = (i12 & 7) << 3;
            long j5 = ((jArr[i14 + 1] << (64 - i15)) & ((-i15) >> 63)) | (jArr[i14] >>> i15);
            long j6 = i10;
            int i16 = i10;
            long j10 = j5 ^ (j6 * ScatterMapKt.BitmaskLsb);
            for (long j11 = (~j10) & (j10 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j11 != 0; j11 &= j11 - 1) {
                int iNumberOfTrailingZeros = (i12 + (Long.numberOfTrailingZeros(j11) >> 3)) & i11;
                if (k.b(this.elements[iNumberOfTrailingZeros], element)) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((((~j5) << 6) & j5 & (-9187201950435737472L)) != 0) {
                int iFindFirstAvailableSlot = findFirstAvailableSlot(i6);
                if (this.growthLimit == 0 && ((this.metadata[iFindFirstAvailableSlot >> 3] >> ((iFindFirstAvailableSlot & 7) << 3)) & 255) != 254) {
                    adjustStorage$collection();
                    iFindFirstAvailableSlot = findFirstAvailableSlot(i6);
                }
                this._size++;
                int i17 = this.growthLimit;
                long[] jArr2 = this.metadata;
                int i18 = iFindFirstAvailableSlot >> 3;
                long j12 = jArr2[i18];
                int i19 = (iFindFirstAvailableSlot & 7) << 3;
                this.growthLimit = i17 - (((j12 >> i19) & 255) == 128 ? 1 : 0);
                int i20 = this._capacity;
                long j13 = ((~(255 << i19)) & j12) | (j6 << i19);
                jArr2[i18] = j13;
                jArr2[(((iFindFirstAvailableSlot - 7) & i20) + (i20 & 7)) >> 3] = j13;
                return iFindFirstAvailableSlot;
            }
            i13 += 8;
            i12 = (i12 + i13) & i11;
            i10 = i16;
        }
    }

    private final int findFirstAvailableSlot(int hash1) {
        int i = this._capacity;
        int i6 = hash1 & i;
        int i10 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i11 = i6 >> 3;
            int i12 = (i6 & 7) << 3;
            long j5 = ((jArr[i11 + 1] << (64 - i12)) & ((-i12) >> 63)) | (jArr[i11] >>> i12);
            long j6 = j5 & ((~j5) << 7) & (-9187201950435737472L);
            if (j6 != 0) {
                return (i6 + (Long.numberOfTrailingZeros(j6) >> 3)) & i;
            }
            i10 += 8;
            i6 = (i6 + i10) & i;
        }
    }

    private final void initializeGrowth() {
        this.growthLimit = ScatterMapKt.loadedCapacity(get_capacity()) - this._size;
    }

    private final void initializeMetadata(int capacity) {
        long[] jArr;
        if (capacity == 0) {
            jArr = ScatterMapKt.EmptyGroup;
        } else {
            jArr = new long[((capacity + 15) & (-8)) >> 3];
            q.h0(jArr, -9187201950435737472L);
        }
        this.metadata = jArr;
        int i = capacity >> 3;
        long j5 = 255 << ((capacity & 7) << 3);
        jArr[i] = (jArr[i] & (~j5)) | j5;
        initializeGrowth();
    }

    private final void initializeStorage(int initialCapacity) {
        int iMax = initialCapacity > 0 ? Math.max(7, ScatterMapKt.normalizeCapacity(initialCapacity)) : 0;
        this._capacity = iMax;
        initializeMetadata(iMax);
        this.elements = iMax == 0 ? ContainerHelpersKt.EMPTY_OBJECTS : new Object[iMax];
    }

    public final boolean add(E element) {
        int i = get_size();
        this.elements[findAbsoluteInsertIndex(element)] = element;
        return get_size() != i;
    }

    public final boolean addAll(E[] elements) {
        k.f(elements, "elements");
        int i = get_size();
        plusAssign((Object[]) elements);
        return i != get_size();
    }

    public final void adjustStorage$collection() {
        int i = this._capacity;
        if (i <= 8 || Long.compareUnsigned(this._size * 32, i * 25) > 0) {
            resizeStorage$collection(ScatterMapKt.nextCapacity(this._capacity));
        } else {
            dropDeletes$collection();
        }
    }

    public final Set<E> asMutableSet() {
        return new MutableSetWrapper(this);
    }

    public final void clear() {
        this._size = 0;
        long[] jArr = this.metadata;
        if (jArr != ScatterMapKt.EmptyGroup) {
            q.h0(jArr, -9187201950435737472L);
            long[] jArr2 = this.metadata;
            int i = this._capacity;
            int i6 = i >> 3;
            long j5 = 255 << ((i & 7) << 3);
            jArr2[i6] = (jArr2[i6] & (~j5)) | j5;
        }
        q.f0(null, 0, this.elements, this._capacity);
        initializeGrowth();
    }

    public final void dropDeletes$collection() {
        long j5;
        long[] jArr = this.metadata;
        int i = this._capacity;
        Object[] objArr = this.elements;
        int i6 = (i + 7) >> 3;
        int i10 = 0;
        for (int i11 = 0; i11 < i6; i11++) {
            long j6 = jArr[i11] & (-9187201950435737472L);
            jArr[i11] = (-72340172838076674L) & ((~j6) + (j6 >>> 7));
        }
        int iP0 = q.p0(jArr);
        int i12 = iP0 - 1;
        long j10 = 72057594037927935L;
        jArr[i12] = (jArr[i12] & 72057594037927935L) | (-72057594037927936L);
        jArr[iP0] = jArr[0];
        int i13 = 0;
        while (i13 != i) {
            int i14 = i13 >> 3;
            int i15 = (i13 & 7) << 3;
            long j11 = (jArr[i14] >> i15) & 255;
            if (j11 != 128 && j11 == 254) {
                Object obj = objArr[i13];
                int iHashCode = (obj != null ? obj.hashCode() : i10) * ScatterMapKt.MurmurHashC1;
                int i16 = (iHashCode ^ (iHashCode << 16)) >>> 7;
                int iFindFirstAvailableSlot = findFirstAvailableSlot(i16);
                int i17 = i16 & i;
                int i18 = i10;
                if (((iFindFirstAvailableSlot - i17) & i) / 8 == ((i13 - i17) & i) / 8) {
                    jArr[i14] = ((r7 & 127) << i15) | ((~(255 << i15)) & jArr[i14]);
                    jArr[jArr.length - 1] = (jArr[i18] & j10) | Long.MIN_VALUE;
                    i13++;
                    i10 = i18;
                } else {
                    int i19 = iFindFirstAvailableSlot >> 3;
                    long j12 = jArr[i19];
                    int i20 = (iFindFirstAvailableSlot & 7) << 3;
                    if (((j12 >> i20) & 255) == 128) {
                        j5 = j10;
                        jArr[i19] = ((r7 & 127) << i20) | (j12 & (~(255 << i20)));
                        jArr[i14] = (jArr[i14] & (~(255 << i15))) | (128 << i15);
                        objArr[iFindFirstAvailableSlot] = objArr[i13];
                        objArr[i13] = null;
                    } else {
                        j5 = j10;
                        jArr[i19] = ((r7 & 127) << i20) | (j12 & (~(255 << i20)));
                        Object obj2 = objArr[iFindFirstAvailableSlot];
                        objArr[iFindFirstAvailableSlot] = objArr[i13];
                        objArr[i13] = obj2;
                        i13--;
                    }
                    jArr[jArr.length - 1] = (jArr[i18] & j5) | Long.MIN_VALUE;
                    i13++;
                    i10 = i18;
                    j10 = j5;
                }
            } else {
                i13++;
            }
        }
        initializeGrowth();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0068, code lost:
    
        if (((r4 & ((~r4) << 6)) & (-9187201950435737472L)) == 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x006a, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void minusAssign(E r14) {
        /*
            r13 = this;
            r0 = 0
            if (r14 == 0) goto L8
            int r1 = r14.hashCode()
            goto L9
        L8:
            r1 = r0
        L9:
            r2 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r1 = r1 * r2
            int r2 = r1 << 16
            r1 = r1 ^ r2
            r2 = r1 & 127(0x7f, float:1.78E-43)
            int r3 = r13._capacity
            int r1 = r1 >>> 7
        L16:
            r1 = r1 & r3
            long[] r4 = r13.metadata
            int r5 = r1 >> 3
            r6 = r1 & 7
            int r6 = r6 << 3
            r7 = r4[r5]
            long r7 = r7 >>> r6
            int r5 = r5 + 1
            r4 = r4[r5]
            int r9 = 64 - r6
            long r4 = r4 << r9
            long r9 = (long) r6
            long r9 = -r9
            r6 = 63
            long r9 = r9 >> r6
            long r4 = r4 & r9
            long r4 = r4 | r7
            long r6 = (long) r2
            r8 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r6 = r6 * r8
            long r6 = r6 ^ r4
            long r8 = r6 - r8
            long r6 = ~r6
            long r6 = r6 & r8
            r8 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r6 = r6 & r8
        L42:
            r10 = 0
            int r12 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r12 == 0) goto L61
            int r10 = java.lang.Long.numberOfTrailingZeros(r6)
            int r10 = r10 >> 3
            int r10 = r10 + r1
            r10 = r10 & r3
            java.lang.Object[] r11 = r13.elements
            r11 = r11[r10]
            boolean r11 = kotlin.jvm.internal.k.b(r11, r14)
            if (r11 == 0) goto L5b
            goto L6b
        L5b:
            r10 = 1
            long r10 = r6 - r10
            long r6 = r6 & r10
            goto L42
        L61:
            long r6 = ~r4
            r12 = 6
            long r6 = r6 << r12
            long r4 = r4 & r6
            long r4 = r4 & r8
            int r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r4 == 0) goto L71
            r10 = -1
        L6b:
            if (r10 < 0) goto L70
            r13.removeElementAt(r10)
        L70:
            return
        L71:
            int r0 = r0 + 8
            int r1 = r1 + r0
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableScatterSet.minusAssign(java.lang.Object):void");
    }

    public final void plusAssign(E element) {
        this.elements[findAbsoluteInsertIndex(element)] = element;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x006d, code lost:
    
        if (((r7 & ((~r7) << 6)) & (-9187201950435737472L)) == 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x006f, code lost:
    
        r11 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean remove(E r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = 0
            if (r1 == 0) goto Lc
            int r3 = r1.hashCode()
            goto Ld
        Lc:
            r3 = r2
        Ld:
            r4 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r3 = r3 * r4
            int r4 = r3 << 16
            r3 = r3 ^ r4
            r4 = r3 & 127(0x7f, float:1.78E-43)
            int r5 = r0._capacity
            int r3 = r3 >>> 7
            r3 = r3 & r5
            r6 = r2
        L1c:
            long[] r7 = r0.metadata
            int r8 = r3 >> 3
            r9 = r3 & 7
            int r9 = r9 << 3
            r10 = r7[r8]
            long r10 = r10 >>> r9
            r12 = 1
            int r8 = r8 + r12
            r7 = r7[r8]
            int r13 = 64 - r9
            long r7 = r7 << r13
            long r13 = (long) r9
            long r13 = -r13
            r9 = 63
            long r13 = r13 >> r9
            long r7 = r7 & r13
            long r7 = r7 | r10
            long r9 = (long) r4
            r13 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r9 = r9 * r13
            long r9 = r9 ^ r7
            long r13 = r9 - r13
            long r9 = ~r9
            long r9 = r9 & r13
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r13
        L47:
            r15 = 0
            int r11 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r11 == 0) goto L66
            int r11 = java.lang.Long.numberOfTrailingZeros(r9)
            int r11 = r11 >> 3
            int r11 = r11 + r3
            r11 = r11 & r5
            java.lang.Object[] r15 = r0.elements
            r15 = r15[r11]
            boolean r15 = kotlin.jvm.internal.k.b(r15, r1)
            if (r15 == 0) goto L60
            goto L70
        L60:
            r15 = 1
            long r15 = r9 - r15
            long r9 = r9 & r15
            goto L47
        L66:
            long r9 = ~r7
            r11 = 6
            long r9 = r9 << r11
            long r7 = r7 & r9
            long r7 = r7 & r13
            int r7 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r7 == 0) goto L79
            r11 = -1
        L70:
            if (r11 < 0) goto L73
            r2 = r12
        L73:
            if (r2 == 0) goto L78
            r0.removeElementAt(r11)
        L78:
            return r2
        L79:
            int r6 = r6 + 8
            int r3 = r3 + r6
            r3 = r3 & r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableScatterSet.remove(java.lang.Object):boolean");
    }

    public final boolean removeAll(E[] elements) {
        k.f(elements, "elements");
        int i = get_size();
        minusAssign((Object[]) elements);
        return i != get_size();
    }

    public final void removeElementAt(int index) {
        this._size--;
        long[] jArr = this.metadata;
        int i = this._capacity;
        int i6 = index >> 3;
        int i10 = (index & 7) << 3;
        long j5 = (jArr[i6] & (~(255 << i10))) | (254 << i10);
        jArr[i6] = j5;
        jArr[(((index - 7) & i) + (i & 7)) >> 3] = j5;
        this.elements[index] = null;
    }

    public final void removeIf(S7.k predicate) {
        k.f(predicate, "predicate");
        Object[] objArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j5 = jArr[i];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j5) < 128) {
                        int i11 = (i << 3) + i10;
                        if (((Boolean) predicate.invoke(objArr[i11])).booleanValue()) {
                            removeElementAt(i11);
                        }
                    }
                    j5 >>= 8;
                }
                if (i6 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    public final void resizeStorage$collection(int newCapacity) {
        long[] jArr = this.metadata;
        Object[] objArr = this.elements;
        int i = this._capacity;
        initializeStorage(newCapacity);
        long[] jArr2 = this.metadata;
        Object[] objArr2 = this.elements;
        int i6 = this._capacity;
        for (int i10 = 0; i10 < i; i10++) {
            if (((jArr[i10 >> 3] >> ((i10 & 7) << 3)) & 255) < 128) {
                Object obj = objArr[i10];
                int iHashCode = (obj != null ? obj.hashCode() : 0) * ScatterMapKt.MurmurHashC1;
                int i11 = iHashCode ^ (iHashCode << 16);
                int iFindFirstAvailableSlot = findFirstAvailableSlot(i11 >>> 7);
                long j5 = i11 & 127;
                int i12 = iFindFirstAvailableSlot >> 3;
                int i13 = (iFindFirstAvailableSlot & 7) << 3;
                long j6 = (jArr2[i12] & (~(255 << i13))) | (j5 << i13);
                jArr2[i12] = j6;
                jArr2[(((iFindFirstAvailableSlot - 7) & i6) + (i6 & 7)) >> 3] = j6;
                objArr2[iFindFirstAvailableSlot] = obj;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean retainAll(java.util.Collection<? extends E> r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            java.lang.String r2 = "elements"
            kotlin.jvm.internal.k.f(r1, r2)
            java.lang.Object[] r2 = r0.elements
            int r3 = r0._size
            long[] r4 = r0.metadata
            int r5 = r4.length
            int r5 = r5 + (-2)
            r6 = 0
            if (r5 < 0) goto L57
            r7 = r6
        L16:
            r8 = r4[r7]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L52
            int r10 = r7 - r5
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r6
        L30:
            if (r12 >= r10) goto L50
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L4c
            int r13 = r7 << 3
            int r13 = r13 + r12
            r14 = r1
            java.lang.Iterable r14 = (java.lang.Iterable) r14
            r15 = r2[r13]
            boolean r14 = D7.v.u0(r14, r15)
            if (r14 != 0) goto L4c
            r0.removeElementAt(r13)
        L4c:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L30
        L50:
            if (r10 != r11) goto L57
        L52:
            if (r7 == r5) goto L57
            int r7 = r7 + 1
            goto L16
        L57:
            int r0 = r0._size
            if (r3 == r0) goto L5d
            r0 = 1
            return r0
        L5d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableScatterSet.retainAll(java.util.Collection):boolean");
    }

    @IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT)
    public final int trim() {
        int i = this._capacity;
        int iNormalizeCapacity = ScatterMapKt.normalizeCapacity(ScatterMapKt.unloadedCapacity(this._size));
        if (iNormalizeCapacity >= i) {
            return 0;
        }
        resizeStorage$collection(iNormalizeCapacity);
        return i - this._capacity;
    }

    public MutableScatterSet(int i) {
        super(null);
        if (!(i >= 0)) {
            RuntimeHelpersKt.throwIllegalArgumentException("Capacity must be a positive value.");
        }
        initializeStorage(ScatterMapKt.unloadedCapacity(i));
    }

    public final void plusAssign(E[] elements) {
        k.f(elements, "elements");
        for (E e : elements) {
            plusAssign((MutableScatterSet<E>) e);
        }
    }

    public final boolean addAll(Iterable<? extends E> elements) {
        k.f(elements, "elements");
        int i = get_size();
        plusAssign((Iterable) elements);
        return i != get_size();
    }

    public final boolean removeAll(i elements) {
        k.f(elements, "elements");
        int i = get_size();
        minusAssign(elements);
        return i != get_size();
    }

    public final void plusAssign(Iterable<? extends E> elements) {
        k.f(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            plusAssign((MutableScatterSet<E>) it.next());
        }
    }

    public /* synthetic */ MutableScatterSet(int i, int i6, e eVar) {
        this((i6 & 1) != 0 ? 6 : i);
    }

    public final boolean addAll(i elements) {
        k.f(elements, "elements");
        int i = get_size();
        plusAssign(elements);
        return i != get_size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(i elements) {
        k.f(elements, "elements");
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            plusAssign((MutableScatterSet<E>) it.next());
        }
    }

    public final boolean removeAll(Iterable<? extends E> elements) {
        k.f(elements, "elements");
        int i = get_size();
        minusAssign((Iterable) elements);
        return i != get_size();
    }

    public final void minusAssign(E[] elements) {
        k.f(elements, "elements");
        for (E e : elements) {
            minusAssign((MutableScatterSet<E>) e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(ScatterSet<E> elements) {
        k.f(elements, "elements");
        Object[] objArr = elements.elements;
        long[] jArr = elements.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j5 = jArr[i];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j5) < 128) {
                        plusAssign((MutableScatterSet<E>) objArr[(i << 3) + i10]);
                    }
                    j5 >>= 8;
                }
                if (i6 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean retainAll(androidx.collection.ScatterSet<E> r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            java.lang.String r2 = "elements"
            kotlin.jvm.internal.k.f(r1, r2)
            java.lang.Object[] r2 = r0.elements
            int r3 = r0._size
            long[] r4 = r0.metadata
            int r5 = r4.length
            int r5 = r5 + (-2)
            r6 = 0
            if (r5 < 0) goto L54
            r7 = r6
        L16:
            r8 = r4[r7]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L4f
            int r10 = r7 - r5
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r6
        L30:
            if (r12 >= r10) goto L4d
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L49
            int r13 = r7 << 3
            int r13 = r13 + r12
            r14 = r2[r13]
            boolean r14 = r1.contains(r14)
            if (r14 != 0) goto L49
            r0.removeElementAt(r13)
        L49:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L30
        L4d:
            if (r10 != r11) goto L54
        L4f:
            if (r7 == r5) goto L54
            int r7 = r7 + 1
            goto L16
        L54:
            int r0 = r0._size
            if (r3 == r0) goto L5a
            r0 = 1
            return r0
        L5a:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableScatterSet.retainAll(androidx.collection.ScatterSet):boolean");
    }

    public final boolean addAll(ScatterSet<E> elements) {
        k.f(elements, "elements");
        int i = get_size();
        plusAssign((ScatterSet) elements);
        return i != get_size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(i elements) {
        k.f(elements, "elements");
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            minusAssign((MutableScatterSet<E>) it.next());
        }
    }

    public final boolean removeAll(ScatterSet<E> elements) {
        k.f(elements, "elements");
        int i = get_size();
        minusAssign((ScatterSet) elements);
        return i != get_size();
    }

    public final void minusAssign(Iterable<? extends E> elements) {
        k.f(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            minusAssign((MutableScatterSet<E>) it.next());
        }
    }

    public final boolean addAll(OrderedScatterSet<E> elements) {
        k.f(elements, "elements");
        int i = get_size();
        plusAssign((OrderedScatterSet) elements);
        return i != get_size();
    }

    public final boolean removeAll(OrderedScatterSet<E> elements) {
        k.f(elements, "elements");
        int i = get_size();
        minusAssign((OrderedScatterSet) elements);
        return i != get_size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(ScatterSet<E> elements) {
        k.f(elements, "elements");
        Object[] objArr = elements.elements;
        long[] jArr = elements.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j5 = jArr[i];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j5) < 128) {
                        minusAssign((MutableScatterSet<E>) objArr[(i << 3) + i10]);
                    }
                    j5 >>= 8;
                }
                if (i6 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(OrderedScatterSet<E> elements) {
        k.f(elements, "elements");
        Object[] objArr = elements.elements;
        long[] jArr = elements.nodes;
        int i = elements.tail;
        while (i != Integer.MAX_VALUE) {
            int i6 = (int) ((jArr[i] >> 31) & SieveCacheKt.NodeLinkMask);
            plusAssign((MutableScatterSet<E>) objArr[i]);
            i = i6;
        }
    }

    public final boolean addAll(ObjectList<E> elements) {
        k.f(elements, "elements");
        int i = get_size();
        plusAssign((ObjectList) elements);
        return i != get_size();
    }

    public final boolean removeAll(ObjectList<E> elements) {
        k.f(elements, "elements");
        int i = get_size();
        minusAssign((ObjectList) elements);
        return i != get_size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean retainAll(androidx.collection.OrderedScatterSet<E> r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            java.lang.String r2 = "elements"
            kotlin.jvm.internal.k.f(r1, r2)
            java.lang.Object[] r2 = r0.elements
            int r3 = r0._size
            long[] r4 = r0.metadata
            int r5 = r4.length
            int r5 = r5 + (-2)
            r6 = 0
            if (r5 < 0) goto L54
            r7 = r6
        L16:
            r8 = r4[r7]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L4f
            int r10 = r7 - r5
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r6
        L30:
            if (r12 >= r10) goto L4d
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L49
            int r13 = r7 << 3
            int r13 = r13 + r12
            r14 = r2[r13]
            boolean r14 = r1.contains(r14)
            if (r14 != 0) goto L49
            r0.removeElementAt(r13)
        L49:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L30
        L4d:
            if (r10 != r11) goto L54
        L4f:
            if (r7 == r5) goto L54
            int r7 = r7 + 1
            goto L16
        L54:
            int r0 = r0._size
            if (r3 == r0) goto L5a
            r0 = 1
            return r0
        L5a:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableScatterSet.retainAll(androidx.collection.OrderedScatterSet):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(OrderedScatterSet<E> elements) {
        k.f(elements, "elements");
        Object[] objArr = elements.elements;
        long[] jArr = elements.nodes;
        int i = elements.tail;
        while (i != Integer.MAX_VALUE) {
            int i6 = (int) ((jArr[i] >> 31) & SieveCacheKt.NodeLinkMask);
            minusAssign((MutableScatterSet<E>) objArr[i]);
            i = i6;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(ObjectList<E> elements) {
        k.f(elements, "elements");
        Object[] objArr = elements.content;
        int i = elements._size;
        for (int i6 = 0; i6 < i; i6++) {
            plusAssign((MutableScatterSet<E>) objArr[i6]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean retainAll(S7.k r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            java.lang.String r2 = "predicate"
            kotlin.jvm.internal.k.f(r1, r2)
            java.lang.Object[] r2 = r0.elements
            int r3 = r0._size
            long[] r4 = r0.metadata
            int r5 = r4.length
            int r5 = r5 + (-2)
            r6 = 0
            if (r5 < 0) goto L5a
            r7 = r6
        L16:
            r8 = r4[r7]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L55
            int r10 = r7 - r5
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r6
        L30:
            if (r12 >= r10) goto L53
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L4f
            int r13 = r7 << 3
            int r13 = r13 + r12
            r14 = r2[r13]
            java.lang.Object r14 = r1.invoke(r14)
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r14 = r14.booleanValue()
            if (r14 != 0) goto L4f
            r0.removeElementAt(r13)
        L4f:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L30
        L53:
            if (r10 != r11) goto L5a
        L55:
            if (r7 == r5) goto L5a
            int r7 = r7 + 1
            goto L16
        L5a:
            int r0 = r0._size
            if (r3 == r0) goto L60
            r0 = 1
            return r0
        L60:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableScatterSet.retainAll(S7.k):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(ObjectList<E> elements) {
        k.f(elements, "elements");
        Object[] objArr = elements.content;
        int i = elements._size;
        for (int i6 = 0; i6 < i; i6++) {
            minusAssign((MutableScatterSet<E>) objArr[i6]);
        }
    }
}
