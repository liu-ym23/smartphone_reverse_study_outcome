package androidx.collection;

import D7.q;
import S7.a;
import S7.n;
import androidx.collection.internal.RuntimeHelpersKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import i9.i;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0016\u001a\u00020\u00142\u0006\u0010\r\u001a\u00028\u00002\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J \u0010\u0019\u001a\u00020\u00072\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0014H\u0086\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0014¢\u0006\u0004\b\u001b\u0010\u001aJ%\u0010\u001b\u001a\u00020\u00142\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u0014¢\u0006\u0004\b\u001b\u0010\u001dJ\u001b\u0010\u001f\u001a\u00020\u00072\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u001f\u0010 J\u001e\u0010!\u001a\u00020\u00072\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\n¢\u0006\u0004\b!\u0010 J\u0015\u0010\"\u001a\u00020\u00072\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0004\b\"\u0010#J\u001d\u0010\"\u001a\u00020$2\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0014¢\u0006\u0004\b\"\u0010%J-\u0010(\u001a\u00020\u00072\u0018\u0010'\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020$0&H\u0086\bø\u0001\u0000¢\u0006\u0004\b(\u0010)J\u0018\u0010*\u001a\u00020\u00072\u0006\u0010\r\u001a\u00028\u0000H\u0086\n¢\u0006\u0004\b*\u0010#J \u0010*\u001a\u00020\u00072\u000e\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000+H\u0086\n¢\u0006\u0004\b*\u0010-J\u001e\u0010*\u001a\u00020\u00072\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000.H\u0086\n¢\u0006\u0004\b*\u0010/J\u001e\u0010*\u001a\u00020\u00072\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u000000H\u0086\n¢\u0006\u0004\b*\u00101J\u001e\u0010*\u001a\u00020\u00072\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u000002H\u0086\n¢\u0006\u0004\b*\u00103J\u0017\u00105\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0003H\u0001¢\u0006\u0004\b5\u0010\u0006J\r\u00106\u001a\u00020\u0007¢\u0006\u0004\b6\u0010\fJ\r\u00107\u001a\u00020\u0003¢\u0006\u0004\b7\u00108J\u000f\u0010:\u001a\u00020\u0007H\u0000¢\u0006\u0004\b9\u0010\fJ\u000f\u0010<\u001a\u00020\u0007H\u0000¢\u0006\u0004\b;\u0010\fJ\u0017\u0010?\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u0003H\u0000¢\u0006\u0004\b>\u0010\u0006R\u0016\u0010@\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010A\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006B"}, d2 = {"Landroidx/collection/MutableObjectFloatMap;", "K", "Landroidx/collection/ObjectFloatMap;", "", "initialCapacity", AppAgent.CONSTRUCT, "(I)V", "LC7/r;", "initializeStorage", "capacity", "initializeMetadata", "initializeGrowth", "()V", "key", "findIndex", "(Ljava/lang/Object;)I", "hash1", "findFirstAvailableSlot", "(I)I", "Lkotlin/Function0;", "", "defaultValue", "getOrPut", "(Ljava/lang/Object;LS7/a;)F", "value", "set", "(Ljava/lang/Object;F)V", "put", "default", "(Ljava/lang/Object;FF)F", TypedValues.TransitionType.S_FROM, "putAll", "(Landroidx/collection/ObjectFloatMap;)V", "plusAssign", "remove", "(Ljava/lang/Object;)V", "", "(Ljava/lang/Object;F)Z", "Lkotlin/Function2;", "predicate", "removeIf", "(LS7/n;)V", "minusAssign", "", "keys", "([Ljava/lang/Object;)V", "", "(Ljava/lang/Iterable;)V", "Li9/i;", "(Li9/i;)V", "Landroidx/collection/ScatterSet;", "(Landroidx/collection/ScatterSet;)V", "index", "removeValueAt", "clear", "trim", "()I", "adjustStorage$collection", "adjustStorage", "dropDeletes$collection", "dropDeletes", "newCapacity", "resizeStorage$collection", "resizeStorage", "growthLimit", "I", "collection"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MutableObjectFloatMap<K> extends ObjectFloatMap<K> {
    private int growthLimit;

    public MutableObjectFloatMap() {
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

    private final int findIndex(K key) {
        int iHashCode = (key != null ? key.hashCode() : 0) * ScatterMapKt.MurmurHashC1;
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
                if (k.b(this.keys[iNumberOfTrailingZeros], key)) {
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
            i13 += 8;
            i12 = (i12 + i13) & i11;
            i10 = i16;
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
        this.keys = new Object[iMax];
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
        q.f0(null, 0, this.keys, this._capacity);
        initializeGrowth();
    }

    public final void dropDeletes$collection() {
        long j5;
        long[] jArr = this.metadata;
        int i = this._capacity;
        Object[] objArr = this.keys;
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
                Object obj = objArr[i13];
                int iHashCode = (obj != null ? obj.hashCode() : i10) * ScatterMapKt.MurmurHashC1;
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
                        objArr[iFindFirstAvailableSlot] = objArr[i13];
                        objArr[i13] = null;
                        fArr[iFindFirstAvailableSlot] = fArr[i13];
                        fArr[i13] = 0.0f;
                    } else {
                        j5 = j10;
                        jArr[i19] = ((r8 & 127) << i20) | (j12 & (~(255 << i20)));
                        Object obj2 = objArr[iFindFirstAvailableSlot];
                        objArr[iFindFirstAvailableSlot] = objArr[i13];
                        objArr[i13] = obj2;
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

    public final float getOrPut(K key, a defaultValue) {
        k.f(defaultValue, "defaultValue");
        int iFindKeyIndex = findKeyIndex(key);
        if (iFindKeyIndex >= 0) {
            return this.values[iFindKeyIndex];
        }
        float fFloatValue = ((Number) defaultValue.invoke()).floatValue();
        set(key, fFloatValue);
        return fFloatValue;
    }

    public final void minusAssign(K key) {
        remove(key);
    }

    public final void plusAssign(ObjectFloatMap<K> from) {
        k.f(from, "from");
        putAll(from);
    }

    public final void put(K key, float value) {
        set(key, value);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void putAll(ObjectFloatMap<K> from) {
        k.f(from, "from");
        Object[] objArr = from.keys;
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
                        set(objArr[i11], fArr[i11]);
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

    public final void remove(K key) {
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
                        if (((Boolean) predicate.invoke(this.keys[i11], Float.valueOf(this.values[i11]))).booleanValue()) {
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
        this.keys[index] = null;
    }

    public final void resizeStorage$collection(int newCapacity) {
        int i;
        long[] jArr = this.metadata;
        Object[] objArr = this.keys;
        float[] fArr = this.values;
        int i6 = this._capacity;
        initializeStorage(newCapacity);
        long[] jArr2 = this.metadata;
        Object[] objArr2 = this.keys;
        float[] fArr2 = this.values;
        int i10 = this._capacity;
        int i11 = 0;
        while (i11 < i6) {
            if (((jArr[i11 >> 3] >> ((i11 & 7) << 3)) & 255) < 128) {
                Object obj = objArr[i11];
                int iHashCode = (obj != null ? obj.hashCode() : 0) * ScatterMapKt.MurmurHashC1;
                int i12 = iHashCode ^ (iHashCode << 16);
                int iFindFirstAvailableSlot = findFirstAvailableSlot(i12 >>> 7);
                i = i11;
                long j5 = i12 & 127;
                int i13 = iFindFirstAvailableSlot >> 3;
                int i14 = (iFindFirstAvailableSlot & 7) << 3;
                long j6 = (j5 << i14) | (jArr2[i13] & (~(255 << i14)));
                jArr2[i13] = j6;
                jArr2[(((iFindFirstAvailableSlot - 7) & i10) + (i10 & 7)) >> 3] = j6;
                objArr2[iFindFirstAvailableSlot] = obj;
                fArr2[iFindFirstAvailableSlot] = fArr[i];
            } else {
                i = i11;
            }
            i11 = i + 1;
        }
    }

    public final void set(K key, float value) {
        int iFindIndex = findIndex(key);
        if (iFindIndex < 0) {
            iFindIndex = ~iFindIndex;
        }
        this.keys[iFindIndex] = key;
        this.values[iFindIndex] = value;
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

    public /* synthetic */ MutableObjectFloatMap(int i, int i6, e eVar) {
        this((i6 & 1) != 0 ? 6 : i);
    }

    public final void minusAssign(K[] keys) {
        k.f(keys, "keys");
        for (K k : keys) {
            remove(k);
        }
    }

    public final float put(K key, float value, float f) {
        int iFindIndex = findIndex(key);
        if (iFindIndex < 0) {
            iFindIndex = ~iFindIndex;
        } else {
            f = this.values[iFindIndex];
        }
        this.keys[iFindIndex] = key;
        this.values[iFindIndex] = value;
        return f;
    }

    public MutableObjectFloatMap(int i) {
        super(null);
        if (!(i >= 0)) {
            RuntimeHelpersKt.throwIllegalArgumentException("Capacity must be a positive value.");
        }
        initializeStorage(ScatterMapKt.unloadedCapacity(i));
    }

    public final boolean remove(K key, float value) {
        int iFindKeyIndex = findKeyIndex(key);
        if (iFindKeyIndex < 0 || this.values[iFindKeyIndex] != value) {
            return false;
        }
        removeValueAt(iFindKeyIndex);
        return true;
    }

    public final void minusAssign(Iterable<? extends K> keys) {
        k.f(keys, "keys");
        Iterator<? extends K> it = keys.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(i keys) {
        k.f(keys, "keys");
        Iterator it = keys.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(ScatterSet<K> keys) {
        k.f(keys, "keys");
        Object[] objArr = keys.elements;
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
                        remove(objArr[(i << 3) + i10]);
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
}
