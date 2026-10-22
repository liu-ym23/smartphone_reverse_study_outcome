package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.collection.internal.RuntimeHelpersKt;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010%\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\nH\u0002J'\u0010\u000e\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00028\u00002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0012JS\u0010\u0013\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00028\u000028\u0010\u0014\u001a4\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00028\u00010\u0015H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u0001H\u0086\u0002¢\u0006\u0002\u0010\u001bJ\u001d\u0010\u001c\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u0001¢\u0006\u0002\u0010\u001dJ'\u0010\u001e\u001a\u00020\n2\u001a\u0010\u001f\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010!0 ¢\u0006\u0002\u0010\"J \u0010\u001e\u001a\u00020\n2\u0018\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010!0#J \u0010\u001e\u001a\u00020\n2\u0018\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010!0$J\u001a\u0010\u001e\u001a\u00020\n2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010&J\u001a\u0010\u001e\u001a\u00020\n2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003J\u001d\u0010'\u001a\u00020\n2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010!H\u0086\nJ*\u0010'\u001a\u00020\n2\u001a\u0010\u001f\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010!0 H\u0086\n¢\u0006\u0002\u0010\"J#\u0010'\u001a\u00020\n2\u0018\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010!0#H\u0086\nJ#\u0010'\u001a\u00020\n2\u0018\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010!0$H\u0086\nJ\u001d\u0010'\u001a\u00020\n2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010&H\u0086\nJ\u001d\u0010'\u001a\u00020\n2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003H\u0086\nJ\u0015\u0010)\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010*J\u001b\u0010)\u001a\u00020+2\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u0001¢\u0006\u0002\u0010,J&\u0010-\u001a\u00020\n2\u0018\u0010.\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020+0\u0015H\u0086\bø\u0001\u0000J\u0016\u0010/\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00028\u0000H\u0086\n¢\u0006\u0002\u00100J\u001e\u0010/\u001a\u00020\n2\u000e\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000 H\u0086\n¢\u0006\u0002\u00102J\u0017\u0010/\u001a\u00020\n2\f\u00101\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0086\nJ\u0017\u0010/\u001a\u00020\n2\f\u00101\u001a\b\u0012\u0004\u0012\u00028\u00000$H\u0086\nJ\u0017\u0010/\u001a\u00020\n2\f\u00101\u001a\b\u0012\u0004\u0012\u00028\u000003H\u0086\nJ\u0017\u0010/\u001a\u00020\n2\f\u00101\u001a\b\u0012\u0004\u0012\u00028\u000004H\u0086\nJ\u0017\u00105\u001a\u0004\u0018\u00018\u00012\u0006\u00106\u001a\u00020\u0005H\u0001¢\u0006\u0002\u00107J\u0006\u00108\u001a\u00020\nJ\u0015\u00109\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00028\u0000H\u0001¢\u0006\u0002\u0010:J\u0010\u0010;\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0005H\u0002J\u0006\u0010=\u001a\u00020\u0005J\r\u0010>\u001a\u00020\nH\u0000¢\u0006\u0002\b?J\r\u0010@\u001a\u00020\nH\u0000¢\u0006\u0002\bAJ\u0015\u0010B\u001a\u00020\n2\u0006\u0010C\u001a\u00020\u0005H\u0000¢\u0006\u0002\bDJ\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010FR\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006G"}, d2 = {"Landroidx/collection/MutableScatterMap;", "K", "V", "Landroidx/collection/ScatterMap;", "initialCapacity", "", "<init>", "(I)V", "growthLimit", "initializeStorage", "", "initializeMetadata", "capacity", "initializeGrowth", "getOrPut", "key", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "compute", "computeBlock", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "set", "(Ljava/lang/Object;Ljava/lang/Object;)V", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "pairs", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)V", "", "Lkotlin/sequences/Sequence;", "from", "", "plusAssign", "pair", "remove", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "removeIf", "predicate", "minusAssign", "(Ljava/lang/Object;)V", "keys", "([Ljava/lang/Object;)V", "Landroidx/collection/ScatterSet;", "Landroidx/collection/ObjectList;", "removeValueAt", "index", "(I)Ljava/lang/Object;", "clear", "findInsertIndex", "(Ljava/lang/Object;)I", "findFirstAvailableSlot", "hash1", "trim", "adjustStorage", "adjustStorage$collection", "dropDeletes", "dropDeletes$collection", "resizeStorage", "newCapacity", "resizeStorage$collection", "asMutableMap", "", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MutableScatterMap<K, V> extends ScatterMap<K, V> {
    private int growthLimit;

    public MutableScatterMap() {
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
        ArraysKt.fill(this.values, null, 0, this._capacity);
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

    public final Map<K, V> asMutableMap() {
        return new MutableMapWrapper(this);
    }

    public final void dropDeletes$collection() {
        long[] r100 = this.metadata;
        int r101 = this._capacity;
        Object[] r102 = this.keys;
        Object[] r103 = this.values;
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
        r100[r109] = (r100[r109] & 72057594037927935L) | (-72057594037927936L);
        r100[r108] = r100[0];
        int r110 = 0;
    L6:
        if (r110 == r101) goto L25;
        int r111 = r110 >> 3;
        int r112 = (r110 & 7) << 3;
        long r113 = (r100[r111] >> r112) & 255;
        if (r113 == 128) goto L9;
        if (r113 != 254) goto L9;
        Object r114 = r102[r110];
        if (r114 == null) goto L16;
        int r115 = r114.hashCode();
    L17:
        int r116 = r115 * ScatterMapKt.MurmurHashC1;
        int r117 = r116 ^ (r116 << 16);
        int r118 = r117 >>> 7;
        int r119 = findFirstAvailableSlot(r118);
        int r120 = r118 & r101;
        if ((((r119 - r120) & r101) / 8) == (((r110 - r120) & r101) / 8)) goto L19;
        int r121 = r119 >> 3;
        long r122 = r100[r121];
        int r123 = (r119 & 7) << 3;
        if (((r122 >> r123) & 255) != 128) goto L23;
        Object[] r210 = r102;
        r100[r121] = ((~(255 << r123)) & r122) | (((long) (r117 & 127)) << r123);
        r100[r111] = (r100[r111] & (~(255 << r112))) | (128 << r112);
        r210[r119] = r210[r110];
        r210[r110] = null;
        r103[r119] = r103[r110];
        r103[r110] = null;
    L24:
        r100[ArraysKt.getLastIndex(r100)] = r100[0];
        r110 = r110 + 1;
        r101 = r101;
        r102 = r210;
        r105 = 0;
        goto L6
    L23:
        r210 = r102;
        r100[r121] = (((long) (r117 & 127)) << r123) | ((~(255 << r123)) & r122);
        Object r124 = r210[r119];
        r210[r119] = r210[r110];
        r210[r110] = r124;
        Object r125 = r103[r119];
        r103[r119] = r103[r110];
        r103[r110] = r125;
        r110 = r110 - 1;
        goto L24
    L19:
        long r126 = ((long) (r117 & 127)) << r112;
        r100[r111] = r126 | ((~(255 << r112)) & r100[r111]);
        r100[ArraysKt.getLastIndex(r100)] = r100[r105];
        goto L9
    L16:
        r115 = 0;
    L9:
        r110 = r110 + 1;
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

    public MutableScatterMap(int r100) {
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

    private final void initializeMetadata(int r100) {
        if (r100 != 0) goto L4;
        long[] r101 = ScatterMapKt.EmptyGroup;
    L5:
        this.metadata = r101;
        initializeGrowth();
        return;
    L4:
        long[] r102 = new long[((((r100 + 1) + 7) + 7) & (-8)) >> 3];
        ArraysKt.fill$default(r102, -9187201950435737472L, 0, 0, 6, null);
        int r103 = r100 >> 3;
        long r104 = 255 << ((r100 & 7) << 3);
        r102[r103] = (r102[r103] & (~r104)) | r104;
        r101 = r102;
        goto L5
    }

    private final void initializeStorage(int r100) {
        if (r100 <= 0) goto L4;
        int r101 = Math.max(7, ScatterMapKt.normalizeCapacity(r100));
    L5:
        this._capacity = r101;
        initializeMetadata(r101);
        if (r101 != 0) goto L8;
        Object[] r102 = ContainerHelpersKt.EMPTY_OBJECTS;
    L9:
        this.keys = r102;
        if (r101 != 0) goto L12;
        Object[] r103 = ContainerHelpersKt.EMPTY_OBJECTS;
    L13:
        this.values = r103;
        return;
    L12:
        r103 = new Object[r101];
        goto L13
    L8:
        r102 = new Object[r101];
        goto L9
    L4:
        r101 = 0;
        goto L5
    }

    public final int findInsertIndex(K r210) {
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

    public final void plusAssign(Pair<? extends K, ? extends V> r100) {
        Intrinsics.checkNotNullParameter(r100, "pair");
        set(r100.getFirst(), r100.getSecond());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void putAll(ScatterMap<K, V> r110) {
        Intrinsics.checkNotNullParameter(r110, "from");
        Object[] r100 = r110.keys;
        Object[] r101 = r110.values;
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

    public final V remove(K r110) {
        if (r110 == null) goto L5;
        int r100 = r110.hashCode();
    L6:
        int r101 = r100 * ScatterMapKt.MurmurHashC1;
        int r102 = r101 ^ (r101 << 16);
        int r103 = r102 & 127;
        int r104 = this._capacity;
        int r105 = (r102 >>> 7) & r104;
        int r106 = 0;
    L7:
        long[] r107 = this.metadata;
        int r108 = r105 >> 3;
        int r109 = (r105 & 7) << 3;
        long r111 = ((r107[r108 + 1] << (64 - r109)) & ((-r109) >> 63)) | (r107[r108] >>> r109);
        long r112 = (((long) r103) * ScatterMapKt.BitmaskLsb) ^ r111;
        long r113 = ((~r112) & (r112 - ScatterMapKt.BitmaskLsb)) & (-9187201950435737472L);
    L9:
        if (r113 == 0) goto L11;
        boolean r114 = true;
    L12:
        if (r114 == false) goto L18;
        int r115 = ((Long.numberOfTrailingZeros(r113) >> 3) + r105) & r104;
        if (Intrinsics.areEqual(this.keys[r115], r110) == true) goto L20;
        r113 = r113 & (r113 - 1);
    L20:
        if (r115 >= 0) goto L22;
        return null;
    L22:
        return removeValueAt(r115);
    L18:
        if (((r111 & ((~r111) << 6)) & (-9187201950435737472L)) != 0) goto L19;
        r106 = r106 + 8;
        r105 = (r105 + r106) & r104;
        goto L7
    L19:
        r115 = -1;
        goto L20
    L11:
        r114 = false;
        goto L12
    L5:
        r100 = 0;
        goto L6
    }

    public final void removeIf(Function2<? super K, ? super V, Boolean> r110) {
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
        if (r110.invoke(this.keys[r107], this.values[r107]).booleanValue() == false) goto L17;
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

    public final V removeValueAt(int r100) {
        this._size--;
        long[] r101 = this.metadata;
        int r102 = this._capacity;
        int r103 = r100 >> 3;
        int r104 = (r100 & 7) << 3;
        long r105 = (r101[r103] & (~(255 << r104))) | (254 << r104);
        r101[r103] = r105;
        r101[(((r100 - 7) & r102) + (r102 & 7)) >> 3] = r105;
        this.keys[r100] = null;
        Object[] r106 = this.values;
        V r107 = (V) r106[r100];
        r106[r100] = null;
        return r107;
    }

    public final void resizeStorage$collection(int r210) {
        long[] r100 = this.metadata;
        Object[] r101 = this.keys;
        Object[] r102 = this.values;
        int r103 = this._capacity;
        initializeStorage(r210);
        long[] r104 = this.metadata;
        Object[] r105 = this.keys;
        Object[] r106 = this.values;
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

    public final void plusAssign(ScatterMap<K, V> r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        putAll(r100);
    }

    public final void putAll(Map<K, ? extends V> r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Iterator<Map.Entry<K, ? extends V>> r101 = r100.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<K, ? extends V> r102 = r101.next();
        set(r102.getKey(), r102.getValue());
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

    public final void plusAssign(Iterable<? extends Pair<? extends K, ? extends V>> r100) {
        Intrinsics.checkNotNullParameter(r100, "pairs");
        putAll(r100);
    }

    public final void putAll(Iterable<? extends Pair<? extends K, ? extends V>> r100) {
        Intrinsics.checkNotNullParameter(r100, "pairs");
        Iterator<? extends Pair<? extends K, ? extends V>> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Pair<? extends K, ? extends V> r102 = r101.next();
        set(r102.component1(), r102.component2());
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(ObjectList<K> r100) {
        Intrinsics.checkNotNullParameter(r100, "keys");
        Object[] r101 = r100.content;
        int r102 = r100._size;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        remove(r101[r103]);
        r103 = r103 + 1;
        goto L3
    }

    public final void plusAssign(Map<K, ? extends V> r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        putAll(r100);
    }

    public final void putAll(Sequence<? extends Pair<? extends K, ? extends V>> r100) {
        Intrinsics.checkNotNullParameter(r100, "pairs");
        Iterator<? extends Pair<? extends K, ? extends V>> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Pair<? extends K, ? extends V> r102 = r101.next();
        set(r102.component1(), r102.component2());
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

    public final void plusAssign(Sequence<? extends Pair<? extends K, ? extends V>> r100) {
        Intrinsics.checkNotNullParameter(r100, "pairs");
        putAll(r100);
    }

    public final void putAll(Pair<? extends K, ? extends V>[] r100) {
        Intrinsics.checkNotNullParameter(r100, "pairs");
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        Pair<? extends K, ? extends V> r103 = r100[r102];
        set(r103.component1(), r103.component2());
        r102 = r102 + 1;
        goto L3
    }

    public final void minusAssign(K r100) {
        remove(r100);
    }

    public final void plusAssign(Pair<? extends K, ? extends V>[] r100) {
        Intrinsics.checkNotNullParameter(r100, "pairs");
        putAll(r100);
    }

    public final V compute(K r100, Function2<? super K, ? super V, ? extends V> r101) {
        Intrinsics.checkNotNullParameter(r101, "computeBlock");
        int r102 = findInsertIndex(r100);
        if (r102 >= 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        Object r104 = null;
    L9:
        V r105 = r101.invoke(r100, r104);
        if (r103 == false) goto L12;
        int r106 = ~r102;
        this.keys[r106] = r100;
        this.values[r106] = r105;
    L13:
        return r105;
    L12:
        this.values[r102] = r105;
        goto L13
    L8:
        r104 = this.values[r102];
        goto L9
    L5:
        r103 = false;
        goto L6
    }

    public final V getOrPut(K r100, Function0<? extends V> r101) {
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        V r102 = get(r100);
        if (r102 != null) goto L6;
        V r103 = r101.invoke();
        set(r100, r103);
        return r103;
    L6:
        return r102;
    }

    public final V put(K r100, V r101) {
        int r102 = findInsertIndex(r100);
        if (r102 >= 0) goto L5;
        r102 = ~r102;
    L5:
        Object[] r103 = this.values;
        V r104 = (V) r103[r102];
        this.keys[r102] = r100;
        r103[r102] = r101;
        return r104;
    }

    public final boolean remove(K r110, V r111) {
        if (r110 == null) goto L5;
        int r100 = r110.hashCode();
    L6:
        int r101 = r100 * ScatterMapKt.MurmurHashC1;
        int r102 = r101 ^ (r101 << 16);
        int r103 = r102 & 127;
        int r104 = this._capacity;
        int r105 = (r102 >>> 7) & r104;
        int r106 = 0;
    L7:
        long[] r107 = this.metadata;
        int r108 = r105 >> 3;
        int r109 = (r105 & 7) << 3;
        long r112 = ((r107[r108 + 1] << (64 - r109)) & ((-r109) >> 63)) | (r107[r108] >>> r109);
        long r113 = (((long) r103) * ScatterMapKt.BitmaskLsb) ^ r112;
        long r114 = ((~r113) & (r113 - ScatterMapKt.BitmaskLsb)) & (-9187201950435737472L);
    L9:
        if (r114 == 0) goto L11;
        boolean r115 = true;
    L12:
        if (r115 == false) goto L18;
        int r116 = ((Long.numberOfTrailingZeros(r114) >> 3) + r105) & r104;
        if (Intrinsics.areEqual(this.keys[r116], r110) == true) goto L20;
        r114 = r114 & (r114 - 1);
    L20:
        if (r116 >= 0) goto L22;
    L25:
        return false;
    L22:
        if (Intrinsics.areEqual(this.values[r116], r111) == false) goto L25;
        removeValueAt(r116);
        return true;
    L18:
        if (((r112 & ((~r112) << 6)) & (-9187201950435737472L)) != 0) goto L19;
        r106 = r106 + 8;
        r105 = (r105 + r106) & r104;
        goto L7
    L19:
        r116 = -1;
        goto L20
    L11:
        r115 = false;
        goto L12
    L5:
        r100 = 0;
        goto L6
    }

    public final void set(K r100, V r101) {
        int r102 = findInsertIndex(r100);
        if (r102 >= 0) goto L5;
        r102 = ~r102;
    L5:
        this.keys[r102] = r100;
        this.values[r102] = r101;
    }

    public /* synthetic */ MutableScatterMap(int r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 6;
    L5:
        this(r100);
    }
}
