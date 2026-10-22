package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\tH\u0002J'\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00028\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u001e\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0002\u0010\u0014J\u001b\u0010\u0015\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u0004¢\u0006\u0002\u0010\u0014J#\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004¢\u0006\u0002\u0010\u0017J\u0014\u0010\u0018\u001a\u00020\t2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0017\u0010\u001a\u001a\u00020\t2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\nJ\u0013\u0010\u001b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cJ\u001b\u0010\u001b\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u0004¢\u0006\u0002\u0010\u001eJ&\u0010\u001f\u001a\u00020\t2\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001d0!H\u0086\bø\u0001\u0000J\u0016\u0010\"\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00028\u0000H\u0086\n¢\u0006\u0002\u0010\u001cJ\u001e\u0010\"\u001a\u00020\t2\u000e\u0010#\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000$H\u0086\n¢\u0006\u0002\u0010%J\u0017\u0010\"\u001a\u00020\t2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000&H\u0086\nJ\u0017\u0010\"\u001a\u00020\t2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000'H\u0086\nJ\u0017\u0010\"\u001a\u00020\t2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000(H\u0086\nJ\u0010\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\u0004H\u0001J\u0006\u0010+\u001a\u00020\tJ\u0015\u0010,\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010-J\u0010\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u0004H\u0002J\u0006\u00100\u001a\u00020\u0004J\r\u00101\u001a\u00020\tH\u0000¢\u0006\u0002\b2J\r\u00103\u001a\u00020\tH\u0000¢\u0006\u0002\b4J\u0015\u00105\u001a\u00020\t2\u0006\u00106\u001a\u00020\u0004H\u0000¢\u0006\u0002\b7R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00068"}, d2 = {"Landroidx/collection/MutableObjectIntMap;", "K", "Landroidx/collection/ObjectIntMap;", "initialCapacity", "", "<init>", "(I)V", "growthLimit", "initializeStorage", "", "initializeMetadata", "capacity", "initializeGrowth", "getOrPut", "key", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)I", "set", "value", "(Ljava/lang/Object;I)V", "put", "default", "(Ljava/lang/Object;II)I", "putAll", "from", "plusAssign", "remove", "(Ljava/lang/Object;)V", "", "(Ljava/lang/Object;I)Z", "removeIf", "predicate", "Lkotlin/Function2;", "minusAssign", "keys", "", "([Ljava/lang/Object;)V", "", "Lkotlin/sequences/Sequence;", "Landroidx/collection/ScatterSet;", "removeValueAt", "index", "clear", "findIndex", "(Ljava/lang/Object;)I", "findFirstAvailableSlot", "hash1", "trim", "adjustStorage", "adjustStorage$collection", "dropDeletes", "dropDeletes$collection", "resizeStorage", "newCapacity", "resizeStorage$collection", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MutableObjectIntMap<K> extends ObjectIntMap<K> {
    private int growthLimit;

    public MutableObjectIntMap() {
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
        ArraysKt.fill(this.keys, null, 0, this._capacity);
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
        Object[] r102 = this.keys;
        int[] r103 = this.values;
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
        if (r111 == r101) goto L25;
        int r112 = r111 >> 3;
        int r113 = (r111 & 7) << 3;
        long r114 = (r100[r112] >> r113) & 255;
        if (r114 == 128) goto L9;
        if (r114 != 254) goto L9;
        Object r115 = r102[r111];
        if (r115 == null) goto L16;
        int r116 = r115.hashCode();
    L17:
        int r117 = r116 * ScatterMapKt.MurmurHashC1;
        int r118 = r117 ^ (r117 << 16);
        int r119 = r118 >>> 7;
        int r120 = findFirstAvailableSlot(r119);
        int r121 = r119 & r101;
        if ((((r120 - r121) & r101) / 8) == (((r111 - r121) & r101) / 8)) goto L19;
        int r122 = r120 >> 3;
        long r123 = r100[r122];
        int r124 = (r120 & 7) << 3;
        if (((r123 >> r124) & 255) != 128) goto L23;
        r100[r122] = ((~(255 << r124)) & r123) | (((long) (r118 & 127)) << r124);
        r100[r112] = (r100[r112] & (~(255 << r113))) | (128 << r113);
        r102[r120] = r102[r111];
        r102[r111] = null;
        r103[r120] = r103[r111];
        r103[r111] = 0;
    L24:
        r110 = 72057594037927935L;
        r100[ArraysKt.getLastIndex(r100)] = (r100[0] & 72057594037927935L) | Long.MIN_VALUE;
        r111 = r111 + 1;
        r105 = 0;
        goto L6
    L23:
        r100[r122] = (((long) (r118 & 127)) << r124) | ((~(255 << r124)) & r123);
        Object r125 = r102[r120];
        r102[r120] = r102[r111];
        r102[r111] = r125;
        int r126 = r103[r120];
        r103[r120] = r103[r111];
        r103[r111] = r126;
        r111 = r111 - 1;
        goto L24
    L19:
        long r127 = ((long) (r118 & 127)) << r113;
        r100[r112] = r127 | ((~(255 << r113)) & r100[r112]);
        r100[ArraysKt.getLastIndex(r100)] = (r100[r105] & r110) | Long.MIN_VALUE;
        goto L9
    L16:
        r116 = 0;
    L9:
        r111 = r111 + 1;
        goto L6
    L25:
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

    public MutableObjectIntMap(int r100) {
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

    private final int findIndex(K r210) {
        if (r210 == null) goto L5;
        int r100 = r210.hashCode();
    L6:
        int r101 = r100 * ScatterMapKt.MurmurHashC1;
        int r102 = r101 ^ (r101 << 16);
        int r103 = r102 >>> 7;
        int r104 = r102 & 127;
        int r105 = this._capacity;
        int r106 = r103 & r105;
        int r107 = 0;
    L7:
        long[] r108 = this.metadata;
        int r109 = r106 >> 3;
        int r110 = (r106 & 7) << 3;
        long r111 = ((r108[r109 + 1] << (64 - r110)) & ((-r110) >> 63)) | (r108[r109] >>> r110);
        long r112 = r104;
        int r113 = r104;
        long r114 = r111 ^ (r112 * ScatterMapKt.BitmaskLsb);
        long r115 = ((~r114) & (r114 - ScatterMapKt.BitmaskLsb)) & (-9187201950435737472L);
    L9:
        if (r115 == 0) goto L11;
        boolean r116 = true;
    L12:
        if (r116 == false) goto L18;
        int r117 = (r106 + (Long.numberOfTrailingZeros(r115) >> 3)) & r105;
        if (Intrinsics.areEqual(this.keys[r117], r210) == true) goto L15;
        r115 = r115 & (r115 - 1);
        goto L9
    L15:
        return r117;
    L18:
        if (((((~r111) << 6) & r111) & (-9187201950435737472L)) != 0) goto L19;
        r107 = r107 + 8;
        r106 = (r106 + r107) & r105;
        r104 = r113;
        goto L7
    L19:
        int r118 = findFirstAvailableSlot(r103);
        if (this.growthLimit == 0) goto L22;
    L27:
        this._size++;
        int r119 = this.growthLimit;
        long[] r120 = this.metadata;
        int r121 = r118 >> 3;
        long r122 = r120[r121];
        int r123 = (r118 & 7) << 3;
        if (((r122 >> r123) & 255) != 128) goto L30;
        int r124 = 1;
    L31:
        this.growthLimit = r119 - r124;
        int r125 = this._capacity;
        long r126 = ((~(255 << r123)) & r122) | (r112 << r123);
        r120[r121] = r126;
        r120[(((r118 - 7) & r125) + (r125 & 7)) >> 3] = r126;
        return ~r118;
    L30:
        r124 = 0;
        goto L31
    L22:
        if (((this.metadata[r118 >> 3] >> ((r118 & 7) << 3)) & 255) != 254) goto L24;
        boolean r127 = true;
    L25:
        if (r127 == true) goto L27;
        adjustStorage$collection();
        r118 = findFirstAvailableSlot(r103);
        goto L27
    L24:
        r127 = false;
        goto L25
    L11:
        r116 = false;
        goto L12
    L5:
        r100 = 0;
        goto L6
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
        this.keys = new Object[r101];
        this.values = new int[r101];
        return;
    L4:
        r101 = 0;
        goto L5
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(ScatterSet<K> r110) {
        Intrinsics.checkNotNullParameter(r110, "keys");
        Object[] r100 = r110.elements;
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

    public final void plusAssign(ObjectIntMap<K> r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        putAll(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void putAll(ObjectIntMap<K> r110) {
        Intrinsics.checkNotNullParameter(r110, "from");
        Object[] r100 = r110.keys;
        int[] r101 = r110.values;
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

    public final void remove(K r100) {
        int r101 = findKeyIndex(r100);
        if (r101 < 0) goto L6;
        removeValueAt(r101);
        return;
    }

    public final void removeIf(Function2<? super K, ? super Integer, Boolean> r110) {
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
        if (r110.invoke(this.keys[r107], Integer.valueOf(this.values[r107])).booleanValue() == false) goto L17;
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
        this.keys[r100] = null;
    }

    public final void resizeStorage$collection(int r210) {
        long[] r100 = this.metadata;
        Object[] r101 = this.keys;
        int[] r102 = this.values;
        int r103 = this._capacity;
        initializeStorage(r210);
        long[] r104 = this.metadata;
        Object[] r105 = this.keys;
        int[] r106 = this.values;
        int r107 = this._capacity;
        int r110 = 0;
    L3:
        if (r110 >= r103) goto L16;
        if (((r100[r110 >> 3] >> ((r110 & 7) << 3)) & 255) >= 128) goto L7;
        boolean r111 = true;
    L8:
        if (r111 == false) goto L14;
        Object r112 = r101[r110];
        if (r112 == null) goto L12;
        int r113 = r112.hashCode();
    L13:
        int r114 = r113 * ScatterMapKt.MurmurHashC1;
        int r115 = r114 ^ (r114 << 16);
        int r116 = findFirstAvailableSlot(r115 >>> 7);
        int r117 = r110;
        long r108 = r115 & 127;
        int r118 = r116 >> 3;
        int r119 = (r116 & 7) << 3;
        long r109 = (r108 << r119) | (r104[r118] & (~(255 << r119)));
        r104[r118] = r109;
        r104[(((r116 - 7) & r107) + (r107 & 7)) >> 3] = r109;
        r105[r116] = r112;
        r106[r116] = r102[r117];
    L15:
        r110 = r117 + 1;
        goto L3
    L12:
        r113 = 0;
        goto L13
    L14:
        r117 = r110;
        goto L15
    L7:
        r111 = false;
        goto L8
    }

    public final void minusAssign(Iterable<? extends K> r100) {
        Intrinsics.checkNotNullParameter(r100, "keys");
        Iterator<? extends K> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        remove(r101.next());
        goto L4
    }

    public final void minusAssign(Sequence<? extends K> r100) {
        Intrinsics.checkNotNullParameter(r100, "keys");
        Iterator<? extends K> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        remove(r101.next());
        goto L4
    }

    public final void minusAssign(K[] r100) {
        Intrinsics.checkNotNullParameter(r100, "keys");
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        remove(r100[r102]);
        r102 = r102 + 1;
        goto L3
    }

    public final void minusAssign(K r100) {
        remove(r100);
    }

    public final int getOrPut(K r100, Function0<Integer> r101) {
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        int r102 = findKeyIndex(r100);
        if (r102 >= 0) goto L5;
        int r103 = r101.invoke().intValue();
        set(r100, r103);
        return r103;
    L5:
        return this.values[r102];
    }

    public final void put(K r100, int r101) {
        set(r100, r101);
    }

    public final boolean remove(K r100, int r101) {
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

    public final void set(K r100, int r101) {
        int r102 = findIndex(r100);
        if (r102 >= 0) goto L5;
        r102 = ~r102;
    L5:
        this.keys[r102] = r100;
        this.values[r102] = r101;
    }

    public /* synthetic */ MutableObjectIntMap(int r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 6;
    L5:
        this(r100);
    }

    public final int put(K r100, int r101, int r102) {
        int r103 = findIndex(r100);
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
