package androidx.collection;

import D7.q;
import S7.a;
import S7.n;
import androidx.collection.internal.RuntimeHelpersKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0016\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J \u0010\u0019\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0014H\u0086\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0014¢\u0006\u0004\b\u001b\u0010\u001aJ%\u0010\u001b\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u0014¢\u0006\u0004\b\u001b\u0010\u001dJ\u0015\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0001¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010!\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0001H\u0086\n¢\u0006\u0004\b!\u0010 J\u0015\u0010\"\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\"\u0010#J\u001d\u0010\"\u001a\u00020$2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0014¢\u0006\u0004\b\"\u0010%J-\u0010(\u001a\u00020\u00062\u0018\u0010'\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020$0&H\u0086\bø\u0001\u0000¢\u0006\u0004\b(\u0010)J\u0018\u0010*\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0086\n¢\u0006\u0004\b*\u0010#J\u0018\u0010*\u001a\u00020\u00062\u0006\u0010,\u001a\u00020+H\u0086\n¢\u0006\u0004\b*\u0010-J\u0018\u0010*\u001a\u00020\u00062\u0006\u0010,\u001a\u00020.H\u0086\n¢\u0006\u0004\b*\u0010/J\u0018\u0010*\u001a\u00020\u00062\u0006\u0010,\u001a\u000200H\u0086\n¢\u0006\u0004\b*\u00101J\u0017\u00103\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u0002H\u0001¢\u0006\u0004\b3\u0010\u0005J\r\u00104\u001a\u00020\u0006¢\u0006\u0004\b4\u0010\u000bJ\r\u00105\u001a\u00020\u0002¢\u0006\u0004\b5\u00106J\u000f\u00108\u001a\u00020\u0006H\u0000¢\u0006\u0004\b7\u0010\u000bJ\u000f\u0010:\u001a\u00020\u0006H\u0000¢\u0006\u0004\b9\u0010\u000bJ\u0017\u0010=\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u0002H\u0000¢\u0006\u0004\b<\u0010\u0005R\u0016\u0010>\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006@"}, d2 = {"Landroidx/collection/MutableFloatLongMap;", "Landroidx/collection/FloatLongMap;", "", "initialCapacity", AppAgent.CONSTRUCT, "(I)V", "LC7/r;", "initializeStorage", "capacity", "initializeMetadata", "initializeGrowth", "()V", "", "key", "findInsertIndex", "(F)I", "hash1", "findFirstAvailableSlot", "(I)I", "Lkotlin/Function0;", "", "defaultValue", "getOrPut", "(FLS7/a;)J", "value", "set", "(FJ)V", "put", "default", "(FJJ)J", TypedValues.TransitionType.S_FROM, "putAll", "(Landroidx/collection/FloatLongMap;)V", "plusAssign", "remove", "(F)V", "", "(FJ)Z", "Lkotlin/Function2;", "predicate", "removeIf", "(LS7/n;)V", "minusAssign", "", "keys", "([F)V", "Landroidx/collection/FloatSet;", "(Landroidx/collection/FloatSet;)V", "Landroidx/collection/FloatList;", "(Landroidx/collection/FloatList;)V", "index", "removeValueAt", "clear", "trim", "()I", "adjustStorage$collection", "adjustStorage", "dropDeletes$collection", "dropDeletes", "newCapacity", "resizeStorage$collection", "resizeStorage", "growthLimit", "I", "collection"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MutableFloatLongMap extends FloatLongMap {
    private int growthLimit;

    public MutableFloatLongMap() {
        this(0, 1, null);
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

    private final int findInsertIndex(float key) {
        int iHashCode = Float.hashCode(key) * ScatterMapKt.MurmurHashC1;
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
            int i16 = i13;
            long j10 = j5 ^ (j6 * ScatterMapKt.BitmaskLsb);
            for (long j11 = (~j10) & (j10 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j11 != 0; j11 &= j11 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j11) >> 3) + i12) & i11;
                if (this.keys[iNumberOfTrailingZeros] == key) {
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
                return ~iFindFirstAvailableSlot;
            }
            i13 = i16 + 8;
            i12 = (i12 + i13) & i11;
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
        this.keys = new float[iMax];
        this.values = new long[iMax];
    }

    public final void adjustStorage$collection() {
        int i = this._capacity;
        if (i <= 8 || Long.compareUnsigned(this._size * 32, i * 25) > 0) {
            resizeStorage$collection(ScatterMapKt.nextCapacity(this._capacity));
        } else {
            dropDeletes$collection();
        }
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
        initializeGrowth();
    }

    public final void dropDeletes$collection() {
        long j5;
        long[] jArr = this.metadata;
        int i = this._capacity;
        float[] fArr = this.keys;
        long[] jArr2 = this.values;
        int i6 = (i + 7) >> 3;
        boolean z10 = false;
        for (int i10 = 0; i10 < i6; i10++) {
            long j6 = jArr[i10] & (-9187201950435737472L);
            jArr[i10] = (-72340172838076674L) & ((~j6) + (j6 >>> 7));
        }
        int iP0 = q.p0(jArr);
        int i11 = iP0 - 1;
        long j10 = 72057594037927935L;
        jArr[i11] = (jArr[i11] & 72057594037927935L) | (-72057594037927936L);
        jArr[iP0] = jArr[0];
        int i12 = 0;
        while (i12 != i) {
            int i13 = i12 >> 3;
            int i14 = (i12 & 7) << 3;
            long j11 = (jArr[i13] >> i14) & 255;
            if (j11 != 128 && j11 == 254) {
                int iHashCode = Float.hashCode(fArr[i12]) * ScatterMapKt.MurmurHashC1;
                int i15 = (iHashCode ^ (iHashCode << 16)) >>> 7;
                int iFindFirstAvailableSlot = findFirstAvailableSlot(i15);
                int i16 = i15 & i;
                boolean z11 = z10;
                if (((iFindFirstAvailableSlot - i16) & i) / 8 == ((i12 - i16) & i) / 8) {
                    jArr[i13] = ((r8 & 127) << i14) | ((~(255 << i14)) & jArr[i13]);
                    jArr[jArr.length - 1] = (jArr[z11 ? 1 : 0] & j10) | Long.MIN_VALUE;
                    i12++;
                    z10 = z11 ? 1 : 0;
                } else {
                    int i17 = iFindFirstAvailableSlot >> 3;
                    long j12 = jArr[i17];
                    int i18 = (iFindFirstAvailableSlot & 7) << 3;
                    if (((j12 >> i18) & 255) == 128) {
                        j5 = j10;
                        jArr[i17] = ((r8 & 127) << i18) | (j12 & (~(255 << i18)));
                        jArr[i13] = (jArr[i13] & (~(255 << i14))) | (128 << i14);
                        fArr[iFindFirstAvailableSlot] = fArr[i12];
                        fArr[i12] = 0.0f;
                        jArr2[iFindFirstAvailableSlot] = jArr2[i12];
                        jArr2[i12] = 0;
                    } else {
                        j5 = j10;
                        jArr[i17] = ((r8 & 127) << i18) | (j12 & (~(255 << i18)));
                        float f = fArr[iFindFirstAvailableSlot];
                        fArr[iFindFirstAvailableSlot] = fArr[i12];
                        fArr[i12] = f;
                        long j13 = jArr2[iFindFirstAvailableSlot];
                        jArr2[iFindFirstAvailableSlot] = jArr2[i12];
                        jArr2[i12] = j13;
                        i12--;
                    }
                    jArr[jArr.length - 1] = (jArr[z11 ? 1 : 0] & j5) | Long.MIN_VALUE;
                    i12++;
                    z10 = z11 ? 1 : 0;
                    j10 = j5;
                }
            } else {
                i12++;
            }
        }
        initializeGrowth();
    }

    public final long getOrPut(float key, a defaultValue) {
        k.f(defaultValue, "defaultValue");
        int iFindKeyIndex = findKeyIndex(key);
        if (iFindKeyIndex >= 0) {
            return this.values[iFindKeyIndex];
        }
        long jLongValue = ((Number) defaultValue.invoke()).longValue();
        put(key, jLongValue);
        return jLongValue;
    }

    public final void minusAssign(float key) {
        remove(key);
    }

    public final void plusAssign(FloatLongMap from) {
        k.f(from, "from");
        putAll(from);
    }

    public final void put(float key, long value) {
        set(key, value);
    }

    public final void putAll(FloatLongMap from) {
        k.f(from, "from");
        float[] fArr = from.keys;
        long[] jArr = from.values;
        long[] jArr2 = from.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j5 = jArr2[i];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j5) < 128) {
                        int i11 = (i << 3) + i10;
                        set(fArr[i11], jArr[i11]);
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

    public final void remove(float key) {
        int iFindKeyIndex = findKeyIndex(key);
        if (iFindKeyIndex >= 0) {
            removeValueAt(iFindKeyIndex);
        }
    }

    public final void removeIf(n predicate) {
        k.f(predicate, "predicate");
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
                        if (((Boolean) predicate.invoke(Float.valueOf(this.keys[i11]), Long.valueOf(this.values[i11]))).booleanValue()) {
                            removeValueAt(i11);
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

    public final void removeValueAt(int index) {
        this._size--;
        long[] jArr = this.metadata;
        int i = this._capacity;
        int i6 = index >> 3;
        int i10 = (index & 7) << 3;
        long j5 = (jArr[i6] & (~(255 << i10))) | (254 << i10);
        jArr[i6] = j5;
        jArr[(((index - 7) & i) + (i & 7)) >> 3] = j5;
    }

    public final void resizeStorage$collection(int newCapacity) {
        long[] jArr;
        MutableFloatLongMap mutableFloatLongMap = this;
        long[] jArr2 = mutableFloatLongMap.metadata;
        float[] fArr = mutableFloatLongMap.keys;
        long[] jArr3 = mutableFloatLongMap.values;
        int i = mutableFloatLongMap._capacity;
        initializeStorage(newCapacity);
        long[] jArr4 = mutableFloatLongMap.metadata;
        float[] fArr2 = mutableFloatLongMap.keys;
        long[] jArr5 = mutableFloatLongMap.values;
        int i6 = mutableFloatLongMap._capacity;
        int i10 = 0;
        while (i10 < i) {
            if (((jArr2[i10 >> 3] >> ((i10 & 7) << 3)) & 255) < 128) {
                float f = fArr[i10];
                int iHashCode = Float.hashCode(f) * ScatterMapKt.MurmurHashC1;
                int i11 = iHashCode ^ (iHashCode << 16);
                int iFindFirstAvailableSlot = mutableFloatLongMap.findFirstAvailableSlot(i11 >>> 7);
                long j5 = i11 & 127;
                int i12 = iFindFirstAvailableSlot >> 3;
                int i13 = (iFindFirstAvailableSlot & 7) << 3;
                jArr = jArr2;
                long j6 = (jArr4[i12] & (~(255 << i13))) | (j5 << i13);
                jArr4[i12] = j6;
                jArr4[(((iFindFirstAvailableSlot - 7) & i6) + (i6 & 7)) >> 3] = j6;
                fArr2[iFindFirstAvailableSlot] = f;
                jArr5[iFindFirstAvailableSlot] = jArr3[i10];
            } else {
                jArr = jArr2;
            }
            i10++;
            mutableFloatLongMap = this;
            jArr2 = jArr;
        }
    }

    public final void set(float key, long value) {
        int iFindInsertIndex = findInsertIndex(key);
        if (iFindInsertIndex < 0) {
            iFindInsertIndex = ~iFindInsertIndex;
        }
        this.keys[iFindInsertIndex] = key;
        this.values[iFindInsertIndex] = value;
    }

    public final int trim() {
        int i = this._capacity;
        int iNormalizeCapacity = ScatterMapKt.normalizeCapacity(ScatterMapKt.unloadedCapacity(this._size));
        if (iNormalizeCapacity >= i) {
            return 0;
        }
        resizeStorage$collection(iNormalizeCapacity);
        return i - this._capacity;
    }

    public MutableFloatLongMap(int i) {
        super(null);
        if (!(i >= 0)) {
            RuntimeHelpersKt.throwIllegalArgumentException("Capacity must be a positive value.");
        }
        initializeStorage(ScatterMapKt.unloadedCapacity(i));
    }

    public final void minusAssign(float[] keys) {
        k.f(keys, "keys");
        for (float f : keys) {
            remove(f);
        }
    }

    public final long put(float key, long value, long j5) {
        int iFindInsertIndex = findInsertIndex(key);
        if (iFindInsertIndex < 0) {
            iFindInsertIndex = ~iFindInsertIndex;
        } else {
            j5 = this.values[iFindInsertIndex];
        }
        this.keys[iFindInsertIndex] = key;
        this.values[iFindInsertIndex] = value;
        return j5;
    }

    public final boolean remove(float key, long value) {
        int iFindKeyIndex = findKeyIndex(key);
        if (iFindKeyIndex < 0 || this.values[iFindKeyIndex] != value) {
            return false;
        }
        removeValueAt(iFindKeyIndex);
        return true;
    }

    public final void minusAssign(FloatSet keys) {
        k.f(keys, "keys");
        float[] fArr = keys.elements;
        long[] jArr = keys.metadata;
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
                        remove(fArr[(i << 3) + i10]);
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

    public /* synthetic */ MutableFloatLongMap(int i, int i6, e eVar) {
        this((i6 & 1) != 0 ? 6 : i);
    }

    public final void minusAssign(FloatList keys) {
        k.f(keys, "keys");
        float[] fArr = keys.content;
        int i = keys._size;
        for (int i6 = 0; i6 < i; i6++) {
            remove(fArr[i6]);
        }
    }
}
