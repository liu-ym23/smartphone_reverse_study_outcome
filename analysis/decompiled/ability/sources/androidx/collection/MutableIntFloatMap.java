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

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ)\u0010\u0014\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u00022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J \u0010\u0017\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0012H\u0086\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u0019\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0012¢\u0006\u0004\b\u0019\u0010\u0018J%\u0010\u0019\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0012¢\u0006\u0004\b\u0019\u0010\u001bJ\u0015\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0001H\u0086\n¢\u0006\u0004\b\u001f\u0010\u001eJ\u0015\u0010 \u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b \u0010\u0005J\u001d\u0010 \u001a\u00020!2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0012¢\u0006\u0004\b \u0010\"J-\u0010%\u001a\u00020\u00062\u0018\u0010$\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020!0#H\u0086\bø\u0001\u0000¢\u0006\u0004\b%\u0010&J\u0018\u0010'\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0002H\u0086\n¢\u0006\u0004\b'\u0010\u0005J\u0018\u0010'\u001a\u00020\u00062\u0006\u0010)\u001a\u00020(H\u0086\n¢\u0006\u0004\b'\u0010*J\u0018\u0010'\u001a\u00020\u00062\u0006\u0010)\u001a\u00020+H\u0086\n¢\u0006\u0004\b'\u0010,J\u0018\u0010'\u001a\u00020\u00062\u0006\u0010)\u001a\u00020-H\u0086\n¢\u0006\u0004\b'\u0010.J\u0017\u00100\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0002H\u0001¢\u0006\u0004\b0\u0010\u0005J\r\u00101\u001a\u00020\u0006¢\u0006\u0004\b1\u0010\u000bJ\r\u00102\u001a\u00020\u0002¢\u0006\u0004\b2\u00103J\u000f\u00105\u001a\u00020\u0006H\u0000¢\u0006\u0004\b4\u0010\u000bJ\u000f\u00107\u001a\u00020\u0006H\u0000¢\u0006\u0004\b6\u0010\u000bJ\u0017\u0010:\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u0002H\u0000¢\u0006\u0004\b9\u0010\u0005R\u0016\u0010;\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006="}, d2 = {"Landroidx/collection/MutableIntFloatMap;", "Landroidx/collection/IntFloatMap;", "", "initialCapacity", AppAgent.CONSTRUCT, "(I)V", "LC7/r;", "initializeStorage", "capacity", "initializeMetadata", "initializeGrowth", "()V", "key", "findInsertIndex", "(I)I", "hash1", "findFirstAvailableSlot", "Lkotlin/Function0;", "", "defaultValue", "getOrPut", "(ILS7/a;)F", "value", "set", "(IF)V", "put", "default", "(IFF)F", TypedValues.TransitionType.S_FROM, "putAll", "(Landroidx/collection/IntFloatMap;)V", "plusAssign", "remove", "", "(IF)Z", "Lkotlin/Function2;", "predicate", "removeIf", "(LS7/n;)V", "minusAssign", "", "keys", "([I)V", "Landroidx/collection/IntSet;", "(Landroidx/collection/IntSet;)V", "Landroidx/collection/IntList;", "(Landroidx/collection/IntList;)V", "index", "removeValueAt", "clear", "trim", "()I", "adjustStorage$collection", "adjustStorage", "dropDeletes$collection", "dropDeletes", "newCapacity", "resizeStorage$collection", "resizeStorage", "growthLimit", "I", "collection"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MutableIntFloatMap extends IntFloatMap {
    private int growthLimit;

    public MutableIntFloatMap() {
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

    private final int findInsertIndex(int key) {
        int iHashCode = Integer.hashCode(key) * ScatterMapKt.MurmurHashC1;
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
            int i16 = 1;
            long j5 = ((jArr[i14 + 1] << (64 - i15)) & ((-i15) >> 63)) | (jArr[i14] >>> i15);
            long j6 = i10;
            int i17 = i13;
            long j10 = j5 ^ (j6 * ScatterMapKt.BitmaskLsb);
            long j11 = (~j10) & (j10 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L);
            while (j11 != 0) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j11) >> 3) + i12) & i11;
                int i18 = i16;
                if (this.keys[iNumberOfTrailingZeros] == key) {
                    return iNumberOfTrailingZeros;
                }
                j11 &= j11 - 1;
                i16 = i18;
            }
            int i19 = i16;
            if ((((~j5) << 6) & j5 & (-9187201950435737472L)) != 0) {
                int iFindFirstAvailableSlot = findFirstAvailableSlot(i6);
                if (this.growthLimit == 0 && ((this.metadata[iFindFirstAvailableSlot >> 3] >> ((iFindFirstAvailableSlot & 7) << 3)) & 255) != 254) {
                    adjustStorage$collection();
                    iFindFirstAvailableSlot = findFirstAvailableSlot(i6);
                }
                this._size++;
                int i20 = this.growthLimit;
                long[] jArr2 = this.metadata;
                int i21 = iFindFirstAvailableSlot >> 3;
                long j12 = jArr2[i21];
                int i22 = (iFindFirstAvailableSlot & 7) << 3;
                this.growthLimit = i20 - (((j12 >> i22) & 255) == 128 ? i19 : 0);
                int i23 = this._capacity;
                long j13 = ((~(255 << i22)) & j12) | (j6 << i22);
                jArr2[i21] = j13;
                jArr2[(((iFindFirstAvailableSlot - 7) & i23) + (i23 & 7)) >> 3] = j13;
                return ~iFindFirstAvailableSlot;
            }
            i13 = i17 + 8;
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
        this.keys = new int[iMax];
        this.values = new float[iMax];
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
        int[] iArr = this.keys;
        float[] fArr = this.values;
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
                int iHashCode = Integer.hashCode(iArr[i13]) * ScatterMapKt.MurmurHashC1;
                int i16 = (iHashCode ^ (iHashCode << 16)) >>> 7;
                int iFindFirstAvailableSlot = findFirstAvailableSlot(i16);
                int i17 = i16 & i;
                int i18 = i10;
                if (((iFindFirstAvailableSlot - i17) & i) / 8 == ((i13 - i17) & i) / 8) {
                    jArr[i14] = ((r8 & 127) << i15) | ((~(255 << i15)) & jArr[i14]);
                    jArr[jArr.length - 1] = (jArr[i18] & j10) | Long.MIN_VALUE;
                    i13++;
                    i10 = i18;
                } else {
                    int i19 = iFindFirstAvailableSlot >> 3;
                    long j12 = jArr[i19];
                    int i20 = (iFindFirstAvailableSlot & 7) << 3;
                    if (((j12 >> i20) & 255) == 128) {
                        j5 = j10;
                        jArr[i19] = ((r8 & 127) << i20) | (j12 & (~(255 << i20)));
                        jArr[i14] = (jArr[i14] & (~(255 << i15))) | (128 << i15);
                        iArr[iFindFirstAvailableSlot] = iArr[i13];
                        iArr[i13] = i18;
                        fArr[iFindFirstAvailableSlot] = fArr[i13];
                        fArr[i13] = 0.0f;
                    } else {
                        j5 = j10;
                        jArr[i19] = ((r8 & 127) << i20) | (j12 & (~(255 << i20)));
                        int i21 = iArr[iFindFirstAvailableSlot];
                        iArr[iFindFirstAvailableSlot] = iArr[i13];
                        iArr[i13] = i21;
                        float f = fArr[iFindFirstAvailableSlot];
                        fArr[iFindFirstAvailableSlot] = fArr[i13];
                        fArr[i13] = f;
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

    public final float getOrPut(int key, a defaultValue) {
        k.f(defaultValue, "defaultValue");
        int iFindKeyIndex = findKeyIndex(key);
        if (iFindKeyIndex >= 0) {
            return this.values[iFindKeyIndex];
        }
        float fFloatValue = ((Number) defaultValue.invoke()).floatValue();
        put(key, fFloatValue);
        return fFloatValue;
    }

    public final void minusAssign(int key) {
        remove(key);
    }

    public final void plusAssign(IntFloatMap from) {
        k.f(from, "from");
        putAll(from);
    }

    public final void put(int key, float value) {
        set(key, value);
    }

    public final void putAll(IntFloatMap from) {
        k.f(from, "from");
        int[] iArr = from.keys;
        float[] fArr = from.values;
        long[] jArr = from.metadata;
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
                        set(iArr[i11], fArr[i11]);
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

    public final void remove(int key) {
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
                        if (((Boolean) predicate.invoke(Integer.valueOf(this.keys[i11]), Float.valueOf(this.values[i11]))).booleanValue()) {
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
        MutableIntFloatMap mutableIntFloatMap = this;
        long[] jArr2 = mutableIntFloatMap.metadata;
        int[] iArr = mutableIntFloatMap.keys;
        float[] fArr = mutableIntFloatMap.values;
        int i = mutableIntFloatMap._capacity;
        initializeStorage(newCapacity);
        long[] jArr3 = mutableIntFloatMap.metadata;
        int[] iArr2 = mutableIntFloatMap.keys;
        float[] fArr2 = mutableIntFloatMap.values;
        int i6 = mutableIntFloatMap._capacity;
        int i10 = 0;
        while (i10 < i) {
            if (((jArr2[i10 >> 3] >> ((i10 & 7) << 3)) & 255) < 128) {
                int i11 = iArr[i10];
                int iHashCode = Integer.hashCode(i11) * ScatterMapKt.MurmurHashC1;
                int i12 = iHashCode ^ (iHashCode << 16);
                int iFindFirstAvailableSlot = mutableIntFloatMap.findFirstAvailableSlot(i12 >>> 7);
                long j5 = i12 & 127;
                int i13 = iFindFirstAvailableSlot >> 3;
                int i14 = (iFindFirstAvailableSlot & 7) << 3;
                jArr = jArr2;
                long j6 = (jArr3[i13] & (~(255 << i14))) | (j5 << i14);
                jArr3[i13] = j6;
                jArr3[(((iFindFirstAvailableSlot - 7) & i6) + (i6 & 7)) >> 3] = j6;
                iArr2[iFindFirstAvailableSlot] = i11;
                fArr2[iFindFirstAvailableSlot] = fArr[i10];
            } else {
                jArr = jArr2;
            }
            i10++;
            mutableIntFloatMap = this;
            jArr2 = jArr;
        }
    }

    public final void set(int key, float value) {
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

    public MutableIntFloatMap(int i) {
        super(null);
        if (!(i >= 0)) {
            RuntimeHelpersKt.throwIllegalArgumentException("Capacity must be a positive value.");
        }
        initializeStorage(ScatterMapKt.unloadedCapacity(i));
    }

    public final void minusAssign(int[] keys) {
        k.f(keys, "keys");
        for (int i : keys) {
            remove(i);
        }
    }

    public final float put(int key, float value, float f) {
        int iFindInsertIndex = findInsertIndex(key);
        if (iFindInsertIndex < 0) {
            iFindInsertIndex = ~iFindInsertIndex;
        } else {
            f = this.values[iFindInsertIndex];
        }
        this.keys[iFindInsertIndex] = key;
        this.values[iFindInsertIndex] = value;
        return f;
    }

    public final boolean remove(int key, float value) {
        int iFindKeyIndex = findKeyIndex(key);
        if (iFindKeyIndex < 0 || this.values[iFindKeyIndex] != value) {
            return false;
        }
        removeValueAt(iFindKeyIndex);
        return true;
    }

    public final void minusAssign(IntSet keys) {
        k.f(keys, "keys");
        int[] iArr = keys.elements;
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
                        remove(iArr[(i << 3) + i10]);
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

    public /* synthetic */ MutableIntFloatMap(int i, int i6, e eVar) {
        this((i6 & 1) != 0 ? 6 : i);
    }

    public final void minusAssign(IntList keys) {
        k.f(keys, "keys");
        int[] iArr = keys.content;
        int i = keys._size;
        for (int i6 = 0; i6 < i; i6++) {
            remove(iArr[i6]);
        }
    }
}
