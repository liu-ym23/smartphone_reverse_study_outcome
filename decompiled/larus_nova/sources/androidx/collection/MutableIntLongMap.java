package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\"\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u0010H\u0086\bø\u0001\u0000J\u0019\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\rH\u0086\u0002J\u0016\u0010\u0013\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\rJ\u001e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rJ\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0001J\u0011\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0001H\u0086\nJ\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0003J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\rJ&\u0010\u001a\u001a\u00020\b2\u0018\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00190\u001cH\u0086\bø\u0001\u0000J\u0011\u0010\u001d\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0003H\u0086\nJ\u0011\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0086\nJ\u0011\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020 H\u0086\nJ\u0011\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020!H\u0086\nJ\u0010\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u0003H\u0001J\u0006\u0010$\u001a\u00020\bJ\u0010\u0010%\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0003H\u0002J\u0006\u0010(\u001a\u00020\u0003J\r\u0010)\u001a\u00020\bH\u0000¢\u0006\u0002\b*J\r\u0010+\u001a\u00020\bH\u0000¢\u0006\u0002\b,J\u0015\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u0003H\u0000¢\u0006\u0002\b/R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00060"}, d2 = {"Landroidx/collection/MutableIntLongMap;", "Landroidx/collection/IntLongMap;", "initialCapacity", "", "<init>", "(I)V", "growthLimit", "initializeStorage", "", "initializeMetadata", "capacity", "initializeGrowth", "getOrPut", "", "key", "defaultValue", "Lkotlin/Function0;", "set", "value", "put", "default", "putAll", "from", "plusAssign", "remove", "", "removeIf", "predicate", "Lkotlin/Function2;", "minusAssign", "keys", "", "Landroidx/collection/IntSet;", "Landroidx/collection/IntList;", "removeValueAt", "index", "clear", "findInsertIndex", "findFirstAvailableSlot", "hash1", "trim", "adjustStorage", "adjustStorage$collection", "dropDeletes", "dropDeletes$collection", "resizeStorage", "newCapacity", "resizeStorage$collection", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MutableIntLongMap extends IntLongMap {
    private int growthLimit;

    public MutableIntLongMap() {
        int r100 = 0;
        this(r100, 1, null);
    }

    public final void clear() {
        this._size = 0;
        long[] r100 = this.metadata;
        if (r100 == ScatterMapKt.EmptyGroup) goto L5;
        ArraysKt.fill$default(r100, -9187201950435737472L, 0, 0, 6, null);
        long[] r101 = this.metadata;
        int r102 = this._capacity;
        int r103 = r102 >> 3;
        long r104 = 255 << ((r102 & 7) << 3);
        r101[r103] = (r101[r103] & (~r104)) | r104;
    L5:
        initializeGrowth();
    }

    public final void adjustStorage$collection() {
        if (this._capacity > 8) goto L5;
    L7:
        resizeStorage$collection(ScatterMapKt.nextCapacity(this._capacity));
        return;
    L5:
        if (Long.compare(ULong.m9623constructorimpl(ULong.m9623constructorimpl(this._size) * 32) ^ Long.MIN_VALUE, ULong.m9623constructorimpl(ULong.m9623constructorimpl(this._capacity) * 25) ^ Long.MIN_VALUE) > 0) goto L7;
        dropDeletes$collection();
    }

    public final void dropDeletes$collection() {
        long[] r100 = this.metadata;
        int r101 = this._capacity;
        int[] r102 = this.keys;
        long[] r103 = this.values;
        int r104 = (r101 + 7) >> 3;
        char r105 = 0;
        int r106 = 0;
    L3:
        if (r106 >= r104) goto L5;
        long r107 = r100[r106] & (-9187201950435737472L);
        r100[r106] = (-72340172838076674L) & ((~r107) + (r107 >>> 7));
        r106 = r106 + 1;
        goto L3
    L5:
        int r108 = ArraysKt.getLastIndex(r100);
        int r109 = r108 - 1;
        long r110 = 72057594037927935L;
        r100[r109] = (r100[r109] & 72057594037927935L) | (-72057594037927936L);
        r100[r108] = r100[0];
        int r111 = 0;
    L6:
        if (r111 == r101) goto L21;
        int r112 = r111 >> 3;
        int r113 = (r111 & 7) << 3;
        long r114 = (r100[r112] >> r113) & 255;
        if (r114 == 128) goto L9;
        if (r114 != 254) goto L9;
        int r115 = r102[r111] * ScatterMapKt.MurmurHashC1;
        int r116 = r115 ^ (r115 << 16);
        int r117 = r116 >>> 7;
        int r118 = findFirstAvailableSlot(r117);
        int r119 = r117 & r101;
        if ((((r118 - r119) & r101) / 8) == (((r111 - r119) & r101) / 8)) goto L15;
        int r120 = r118 >> 3;
        long r121 = r100[r120];
        int r122 = (r118 & 7) << 3;
        if (((r121 >> r122) & 255) != 128) goto L19;
        r100[r120] = ((~(255 << r122)) & r121) | (((long) (r116 & 127)) << r122);
        r100[r112] = (r100[r112] & (~(255 << r113))) | (128 << r113);
        r102[r118] = r102[r111];
        r102[r111] = 0;
        r103[r118] = r103[r111];
        r103[r111] = 0;
    L20:
        r110 = 72057594037927935L;
        r100[ArraysKt.getLastIndex(r100)] = (r100[0] & 72057594037927935L) | Long.MIN_VALUE;
        r111 = r111 + 1;
        r105 = 0;
        goto L6
    L19:
        r100[r120] = (((long) (r116 & 127)) << r122) | ((~(255 << r122)) & r121);
        int r123 = r102[r118];
        r102[r118] = r102[r111];
        r102[r111] = r123;
        long r124 = r103[r118];
        r103[r118] = r103[r111];
        r103[r111] = r124;
        r111 = r111 - 1;
        goto L20
    L15:
        long r125 = ((long) (r116 & 127)) << r113;
        r100[r112] = r125 | ((~(255 << r113)) & r100[r112]);
        r100[ArraysKt.getLastIndex(r100)] = (r100[r105] & r110) | Long.MIN_VALUE;
    L9:
        r111 = r111 + 1;
        goto L6
    L21:
        initializeGrowth();
    }

    public final int trim() {
        int r100 = this._capacity;
        int r101 = ScatterMapKt.normalizeCapacity(ScatterMapKt.unloadedCapacity(this._size));
        if (r101 >= r100) goto L6;
        resizeStorage$collection(r101);
        return r100 - this._capacity;
    L6:
        return 0;
    }

    private final void initializeGrowth() {
        this.growthLimit = ScatterMapKt.loadedCapacity(getCapacity()) - this._size;
    }

    public MutableIntLongMap(int r100) {
        super(null);
        if (r100 < 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        RuntimeHelpersKt.throwIllegalArgumentException("Capacity must be a positive value.");
    L8:
        initializeStorage(ScatterMapKt.unloadedCapacity(r100));
        return;
    L5:
        r101 = false;
        goto L6
    }

    private final int findFirstAvailableSlot(int r110) {
        int r100 = this._capacity;
        int r111 = r110 & r100;
        int r101 = 0;
    L3:
        long[] r102 = this.metadata;
        int r103 = r111 >> 3;
        int r104 = (r111 & 7) << 3;
        long r105 = ((r102[r103 + 1] << (64 - r104)) & ((-r104) >> 63)) | (r102[r103] >>> r104);
        long r106 = (r105 & ((~r105) << 7)) & (-9187201950435737472L);
        if (r106 != 0) goto L6;
        r101 = r101 + 8;
        r111 = (r111 + r101) & r100;
        goto L3
    L6:
        return (r111 + (Long.numberOfTrailingZeros(r106) >> 3)) & r100;
    }

    private final int findInsertIndex(int r210) {
        int r100 = ScatterMapKt.MurmurHashC1 * r210;
        int r101 = r100 ^ (r100 << 16);
        int r102 = r101 >>> 7;
        int r103 = r101 & 127;
        int r104 = this._capacity;
        int r105 = r102 & r104;
        int r106 = 0;
    L3:
        long[] r107 = this.metadata;
        int r108 = r105 >> 3;
        int r110 = (r105 & 7) << 3;
        long r109 = ((r107[r108 + 1] << (64 - r110)) & ((-r110) >> 63)) | (r107[r108] >>> r110);
        long r111 = r103;
        int r112 = r106;
        long r113 = r109 ^ (r111 * ScatterMapKt.BitmaskLsb);
        long r114 = ((~r113) & (r113 - ScatterMapKt.BitmaskLsb)) & (-9187201950435737472L);
    L5:
        if (r114 == 0) goto L7;
        boolean r115 = true;
    L8:
        if (r115 == false) goto L14;
        int r116 = (r105 + (Long.numberOfTrailingZeros(r114) >> 3)) & r104;
        if (this.keys[r116] == r210) goto L11;
        r114 = r114 & (r114 - 1);
        goto L5
    L11:
        return r116;
    L14:
        if (((((~r109) << 6) & r109) & (-9187201950435737472L)) != 0) goto L15;
        r106 = r112 + 8;
        r105 = (r105 + r106) & r104;
        goto L3
    L15:
        int r117 = findFirstAvailableSlot(r102);
        if (this.growthLimit == 0) goto L18;
    L23:
        this._size++;
        int r118 = this.growthLimit;
        long[] r119 = this.metadata;
        int r120 = r117 >> 3;
        long r121 = r119[r120];
        int r122 = (r117 & 7) << 3;
        if (((r121 >> r122) & 255) != 128) goto L26;
        int r123 = 1;
    L27:
        this.growthLimit = r118 - r123;
        int r124 = this._capacity;
        long r125 = ((~(255 << r122)) & r121) | (r111 << r122);
        r119[r120] = r125;
        r119[(((r117 - 7) & r124) + (r124 & 7)) >> 3] = r125;
        return ~r117;
    L26:
        r123 = 0;
        goto L27
    L18:
        if (((this.metadata[r117 >> 3] >> ((r117 & 7) << 3)) & 255) != 254) goto L20;
        boolean r126 = true;
    L21:
        if (r126 == true) goto L23;
        adjustStorage$collection();
        r117 = findFirstAvailableSlot(r102);
        goto L23
    L20:
        r126 = false;
        goto L21
    L7:
        r115 = false;
        goto L8
    }

    private final void initializeMetadata(int r100) {
        if (r100 != 0) goto L4;
        long[] r101 = ScatterMapKt.EmptyGroup;
    L5:
        this.metadata = r101;
        int r102 = r100 >> 3;
        long r103 = 255 << ((r100 & 7) << 3);
        r101[r102] = (r101[r102] & (~r103)) | r103;
        initializeGrowth();
        return;
    L4:
        r101 = new long[((((r100 + 1) + 7) + 7) & (-8)) >> 3];
        ArraysKt.fill$default(r101, -9187201950435737472L, 0, 0, 6, null);
        goto L5
    }

    private final void initializeStorage(int r100) {
        if (r100 <= 0) goto L4;
        int r101 = Math.max(7, ScatterMapKt.normalizeCapacity(r100));
    L5:
        this._capacity = r101;
        initializeMetadata(r101);
        this.keys = new int[r101];
        this.values = new long[r101];
        return;
    L4:
        r101 = 0;
        goto L5
    }

    public final void minusAssign(IntSet r110) {
        Intrinsics.checkNotNullParameter(r110, "keys");
        int[] r100 = r110.elements;
        long[] r111 = r110.metadata;
        int r101 = r111.length - 2;
        if (r101 < 0) goto L19;
        int r102 = 0;
    L5:
        long r103 = r111[r102];
        if (((((~r103) << 7) & r103) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L17;
        int r104 = 8 - ((~(r102 - r101)) >>> 31);
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L16;
        if ((255 & r103) >= 128) goto L12;
        boolean r106 = true;
    L13:
        if (r106 == false) goto L15;
        remove(r100[(r102 << 3) + r105]);
    L15:
        r103 = r103 >> 8;
        r105 = r105 + 1;
        goto L8
    L12:
        r106 = false;
        goto L13
    L16:
        if (r104 == 8) goto L17;
        return;
    L17:
        if (r102 == r101) goto L26;
        r102 = r102 + 1;
        goto L5
    L26:
        return;
    }

    public final void plusAssign(IntLongMap r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        putAll(r100);
    }

    public final void putAll(IntLongMap r110) {
        Intrinsics.checkNotNullParameter(r110, "from");
        int[] r100 = r110.keys;
        long[] r101 = r110.values;
        long[] r102 = r110.metadata;
        int r103 = r102.length - 2;
        if (r103 < 0) goto L24;
        int r104 = 0;
    L5:
        long r105 = r102[r104];
        if (((((~r105) << 7) & r105) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L21;
        int r106 = 8 - ((~(r104 - r103)) >>> 31);
        int r111 = 0;
    L8:
        if (r111 >= r106) goto L18;
        if ((255 & r105) >= 128) goto L12;
        boolean r112 = true;
    L13:
        if (r112 == false) goto L16;
        int r113 = (r104 << 3) + r111;
        set(r100[r113], r101[r113]);
    L16:
        r105 = r105 >> 8;
        r111 = r111 + 1;
        goto L8
    L12:
        r112 = false;
        goto L13
    L18:
        if (r106 == 8) goto L21;
        return;
    L21:
        if (r104 == r103) goto L31;
        r104 = r104 + 1;
        goto L5
    L31:
        return;
    }

    public final void remove(int r100) {
        int r101 = findKeyIndex(r100);
        if (r101 < 0) goto L6;
        removeValueAt(r101);
        return;
    }

    public final void removeIf(Function2<? super Integer, ? super Long, Boolean> r110) {
        Intrinsics.checkNotNullParameter(r110, "predicate");
        long[] r100 = this.metadata;
        int r101 = r100.length - 2;
        if (r101 < 0) goto L21;
        int r102 = 0;
    L5:
        long r103 = r100[r102];
        if (((((~r103) << 7) & r103) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r104 = 8 - ((~(r102 - r101)) >>> 31);
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L18;
        if ((255 & r103) >= 128) goto L12;
        boolean r106 = true;
    L13:
        if (r106 == false) goto L17;
        int r107 = (r102 << 3) + r105;
        if (r110.invoke(Integer.valueOf(this.keys[r107]), Long.valueOf(this.values[r107])).booleanValue() == false) goto L17;
        removeValueAt(r107);
    L17:
        r103 = r103 >> 8;
        r105 = r105 + 1;
        goto L8
    L12:
        r106 = false;
        goto L13
    L18:
        if (r104 == 8) goto L19;
        return;
    L19:
        if (r102 == r101) goto L29;
        r102 = r102 + 1;
        goto L5
    L29:
        return;
    }

    public final void removeValueAt(int r100) {
        this._size--;
        long[] r101 = this.metadata;
        int r102 = this._capacity;
        int r103 = r100 >> 3;
        int r104 = (r100 & 7) << 3;
        long r105 = (r101[r103] & (~(255 << r104))) | (254 << r104);
        r101[r103] = r105;
        r101[(((r100 - 7) & r102) + (r102 & 7)) >> 3] = r105;
    }

    public final void resizeStorage$collection(int r210) {
        long[] r100 = this.metadata;
        int[] r101 = this.keys;
        long[] r102 = this.values;
        int r103 = this._capacity;
        initializeStorage(r210);
        long[] r104 = this.metadata;
        int[] r105 = this.keys;
        long[] r106 = this.values;
        int r107 = this._capacity;
        int r110 = 0;
    L3:
        if (r110 >= r103) goto L12;
        if (((r100[r110 >> 3] >> ((r110 & 7) << 3)) & 255) >= 128) goto L7;
        boolean r111 = true;
    L8:
        if (r111 == false) goto L10;
        int r112 = r101[r110];
        int r113 = ScatterMapKt.MurmurHashC1 * r112;
        int r114 = r113 ^ (r113 << 16);
        int r115 = findFirstAvailableSlot(r114 >>> 7);
        int r116 = r110;
        long r108 = r114 & 127;
        int r117 = r115 >> 3;
        int r118 = (r115 & 7) << 3;
        long r109 = (r108 << r118) | (r104[r117] & (~(255 << r118)));
        r104[r117] = r109;
        r104[(((r115 - 7) & r107) + (r107 & 7)) >> 3] = r109;
        r105[r115] = r112;
        r106[r115] = r102[r116];
    L11:
        r110 = r116 + 1;
        goto L3
    L10:
        r116 = r110;
        goto L11
    L7:
        r111 = false;
        goto L8
    }

    public final void minusAssign(IntList r100) {
        Intrinsics.checkNotNullParameter(r100, "keys");
        int[] r101 = r100.content;
        int r102 = r100._size;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        remove(r101[r103]);
        r103 = r103 + 1;
        goto L3
    }

    public final void minusAssign(int[] r100) {
        Intrinsics.checkNotNullParameter(r100, "keys");
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        remove(r100[r102]);
        r102 = r102 + 1;
        goto L3
    }

    public final void minusAssign(int r100) {
        remove(r100);
    }

    public final long getOrPut(int r100, Function0<Long> r101) {
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        int r102 = findKeyIndex(r100);
        if (r102 >= 0) goto L6;
        long r103 = r101.invoke().longValue();
        put(r100, r103);
        return r103;
    L6:
        return this.values[r102];
    }

    public final void put(int r100, long r101) {
        set(r100, r101);
    }

    public final boolean remove(int r100, long r101) {
        int r102 = findKeyIndex(r100);
        if (r102 >= 0) goto L5;
        return false;
    L5:
        if (this.values[r102] != r101) goto L10;
        removeValueAt(r102);
        return true;
    L10:
        return false;
    }

    public final void set(int r100, long r101) {
        int r102 = findInsertIndex(r100);
        if (r102 >= 0) goto L5;
        r102 = ~r102;
    L5:
        this.keys[r102] = r100;
        this.values[r102] = r101;
    }

    public /* synthetic */ MutableIntLongMap(int r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 6;
    L5:
        this(r100);
    }

    public final long put(int r100, long r101, long r102) {
        int r103 = findInsertIndex(r100);
        if (r103 >= 0) goto L5;
        r103 = ~r103;
    L6:
        this.keys[r103] = r100;
        this.values[r103] = r101;
        return r102;
    L5:
        r102 = this.values[r103];
        goto L6
    }
}
