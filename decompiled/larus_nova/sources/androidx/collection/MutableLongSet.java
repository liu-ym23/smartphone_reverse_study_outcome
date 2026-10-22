package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0011\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086\u0002J\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013J\u0011\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0086\u0002J\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0001J\u0011\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0001H\u0086\u0002J\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0011\u0010\u0015\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086\u0002J\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013J\u0011\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0086\u0002J\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0001J\u0011\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0001H\u0086\u0002J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0003H\u0002J\u0006\u0010\u0019\u001a\u00020\bJ\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0003H\u0002J\b\u0010\u001d\u001a\u00020\u0003H\u0007J\r\u0010\u001e\u001a\u00020\bH\u0000¢\u0006\u0002\b\u001fJ\r\u0010 \u001a\u00020\bH\u0000¢\u0006\u0002\b!J\u0015\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u0003H\u0000¢\u0006\u0002\b$R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Landroidx/collection/MutableLongSet;", "Landroidx/collection/LongSet;", "initialCapacity", "", "<init>", "(I)V", "growthLimit", "initializeStorage", "", "initializeMetadata", "capacity", "initializeGrowth", "add", "", "element", "", "plusAssign", "addAll", SlcElement.KEY_ELEMENTS, "", "remove", "minusAssign", "removeAll", "removeElementAt", "index", "clear", "findAbsoluteInsertIndex", "findFirstAvailableSlot", "hash1", "trim", "adjustStorage", "adjustStorage$collection", "dropDeletes", "dropDeletes$collection", "resizeStorage", "newCapacity", "resizeStorage$collection", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MutableLongSet extends LongSet {
    private int growthLimit;

    public MutableLongSet() {
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
        long[] r102 = this.elements;
        int r103 = (r101 + 7) >> 3;
        char r104 = 0;
        int r105 = 0;
    L3:
        if (r105 >= r103) goto L5;
        long r106 = r100[r105] & (-9187201950435737472L);
        r100[r105] = (-72340172838076674L) & ((~r106) + (r106 >>> 7));
        r105 = r105 + 1;
        goto L3
    L5:
        int r107 = ArraysKt.getLastIndex(r100);
        int r108 = r107 - 1;
        long r109 = 72057594037927935L;
        r100[r108] = (r100[r108] & 72057594037927935L) | (-72057594037927936L);
        r100[r107] = r100[0];
        int r110 = 0;
    L6:
        if (r110 == r101) goto L21;
        int r111 = r110 >> 3;
        int r112 = (r110 & 7) << 3;
        long r113 = (r100[r111] >> r112) & 255;
        if (r113 == 128) goto L9;
        if (r113 != 254) goto L9;
        long r114 = r102[r110];
        int r115 = ((int) (r114 ^ (r114 >>> 32))) * ScatterMapKt.MurmurHashC1;
        int r116 = (r115 << 16) ^ r115;
        int r117 = r116 >>> 7;
        int r118 = findFirstAvailableSlot(r117);
        int r119 = r117 & r101;
        if ((((r118 - r119) & r101) / 8) == (((r110 - r119) & r101) / 8)) goto L15;
        int r120 = r118 >> 3;
        long r121 = r100[r120];
        int r122 = (r118 & 7) << 3;
        if (((r121 >> r122) & 255) != 128) goto L19;
        r100[r120] = ((~(255 << r122)) & r121) | (((long) (r116 & 127)) << r122);
        r100[r111] = (r100[r111] & (~(255 << r112))) | (128 << r112);
        r102[r118] = r102[r110];
        r102[r110] = 0;
    L20:
        r109 = 72057594037927935L;
        r100[ArraysKt.getLastIndex(r100)] = (r100[0] & 72057594037927935L) | Long.MIN_VALUE;
        r110 = r110 + 1;
        r104 = 0;
        goto L6
    L19:
        r100[r120] = (((long) (r116 & 127)) << r122) | ((~(255 << r122)) & r121);
        long r123 = r102[r118];
        r102[r118] = r102[r110];
        r102[r110] = r123;
        r110 = r110 - 1;
        goto L20
    L15:
        long r124 = ((long) (r116 & 127)) << r112;
        r100[r111] = r124 | ((~(255 << r112)) & r100[r111]);
        r100[ArraysKt.getLastIndex(r100)] = (r100[r104] & r109) | Long.MIN_VALUE;
    L9:
        r110 = r110 + 1;
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

    public MutableLongSet(int r100) {
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

    private final int findAbsoluteInsertIndex(long r210) {
        int r100 = ((int) (r210 ^ (r210 >>> 32))) * ScatterMapKt.MurmurHashC1;
        int r101 = (r100 << 16) ^ r100;
        int r102 = r101 >>> 7;
        int r103 = r101 & 127;
        int r104 = this._capacity;
        int r105 = r102 & r104;
        int r106 = 0;
    L3:
        long[] r107 = this.metadata;
        int r108 = r105 >> 3;
        int r109 = (r105 & 7) << 3;
        long r110 = ((r107[r108 + 1] << (64 - r109)) & ((-r109) >> 63)) | (r107[r108] >>> r109);
        long r111 = r103;
        int r112 = r106;
        long r113 = r110 ^ (r111 * ScatterMapKt.BitmaskLsb);
        long r114 = ((~r113) & (r113 - ScatterMapKt.BitmaskLsb)) & (-9187201950435737472L);
    L5:
        if (r114 == 0) goto L7;
        boolean r115 = true;
    L8:
        if (r115 == false) goto L14;
        int r116 = ((Long.numberOfTrailingZeros(r114) >> 3) + r105) & r104;
        if (this.elements[r116] == r210) goto L11;
        r114 = r114 & (r114 - 1);
        goto L5
    L11:
        return r116;
    L14:
        if (((((~r110) << 6) & r110) & (-9187201950435737472L)) != 0) goto L15;
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
        return r117;
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
        this.elements = new long[r101];
        return;
    L4:
        r101 = 0;
        goto L5
    }

    private final void removeElementAt(int r100) {
        this._size--;
        long[] r101 = this.metadata;
        int r102 = this._capacity;
        int r103 = r100 >> 3;
        int r104 = (r100 & 7) << 3;
        long r105 = (r101[r103] & (~(255 << r104))) | (254 << r104);
        r101[r103] = r105;
        r101[(((r100 - 7) & r102) + (r102 & 7)) >> 3] = r105;
    }

    public final boolean add(long r100) {
        int r101 = this._size;
        int r102 = findAbsoluteInsertIndex(r100);
        this.elements[r102] = r100;
        if (this._size == r101) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean addAll(LongSet r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = this._size;
        plusAssign(r100);
        if (r101 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    public final void minusAssign(long r110) {
        int r100 = ((int) (r110 ^ (r110 >>> 32))) * ScatterMapKt.MurmurHashC1;
        int r101 = (r100 << 16) ^ r100;
        int r102 = r101 & 127;
        int r103 = this._capacity;
        int r104 = (r101 >>> 7) & r103;
        int r105 = 0;
    L3:
        long[] r106 = this.metadata;
        int r107 = r104 >> 3;
        int r108 = (r104 & 7) << 3;
        long r109 = ((r106[r107 + 1] << (64 - r108)) & ((-r108) >> 63)) | (r106[r107] >>> r108);
        long r111 = (((long) r102) * ScatterMapKt.BitmaskLsb) ^ r109;
        long r112 = ((~r111) & (r111 - ScatterMapKt.BitmaskLsb)) & (-9187201950435737472L);
    L5:
        if (r112 == 0) goto L7;
        boolean r113 = true;
    L8:
        if (r113 == false) goto L14;
        int r114 = ((Long.numberOfTrailingZeros(r112) >> 3) + r104) & r103;
        if (this.elements[r114] == r110) goto L16;
        r112 = r112 & (r112 - 1);
    L16:
        if (r114 < 0) goto L23;
        removeElementAt(r114);
        return;
    L23:
        return;
    L14:
        if (((r109 & ((~r109) << 6)) & (-9187201950435737472L)) != 0) goto L15;
        r105 = r105 + 8;
        r104 = (r104 + r105) & r103;
        goto L3
    L15:
        r114 = -1;
        goto L16
    L7:
        r113 = false;
        goto L8
    }

    public final void plusAssign(LongSet r110) {
        Intrinsics.checkNotNullParameter(r110, SlcElement.KEY_ELEMENTS);
        long[] r100 = r110.elements;
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
        plusAssign(r100[(r102 << 3) + r105]);
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

    public final boolean remove(long r110) {
        int r100 = ((int) (r110 ^ (r110 >>> 32))) * ScatterMapKt.MurmurHashC1;
        int r101 = (r100 << 16) ^ r100;
        int r102 = r101 & 127;
        int r103 = this._capacity;
        int r104 = (r101 >>> 7) & r103;
        boolean r105 = false;
        int r106 = 0;
    L3:
        long[] r107 = this.metadata;
        int r108 = r104 >> 3;
        int r109 = (r104 & 7) << 3;
        long r111 = ((r107[r108 + 1] << (64 - r109)) & ((-r109) >> 63)) | (r107[r108] >>> r109);
        long r112 = (((long) r102) * ScatterMapKt.BitmaskLsb) ^ r111;
        long r113 = ((~r112) & (r112 - ScatterMapKt.BitmaskLsb)) & (-9187201950435737472L);
    L5:
        if (r113 == 0) goto L7;
        boolean r114 = true;
    L8:
        if (r114 == false) goto L14;
        int r115 = ((Long.numberOfTrailingZeros(r113) >> 3) + r104) & r103;
        if (this.elements[r115] == r110) goto L16;
        r113 = r113 & (r113 - 1);
    L16:
        if (r115 < 0) goto L18;
        r105 = true;
    L18:
        if (r105 == false) goto L20;
        removeElementAt(r115);
    L20:
        return r105;
    L14:
        if (((r111 & ((~r111) << 6)) & (-9187201950435737472L)) != 0) goto L15;
        r106 = r106 + 8;
        r104 = (r104 + r106) & r103;
        goto L3
    L15:
        r115 = -1;
        goto L16
    L7:
        r114 = false;
        goto L8
    }

    public final boolean removeAll(LongSet r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = this._size;
        minusAssign(r100);
        if (r101 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    public final void resizeStorage$collection(int r210) {
        long[] r100 = this.metadata;
        long[] r101 = this.elements;
        int r102 = this._capacity;
        initializeStorage(r210);
        long[] r103 = this.metadata;
        long[] r104 = this.elements;
        int r105 = this._capacity;
        int r106 = 0;
    L3:
        if (r106 >= r102) goto L12;
        if (((r100[r106 >> 3] >> ((r106 & 7) << 3)) & 255) >= 128) goto L7;
        boolean r107 = true;
    L8:
        if (r107 == false) goto L11;
        long r108 = r101[r106];
        int r110 = ((int) ((r108 >>> 32) ^ r108)) * ScatterMapKt.MurmurHashC1;
        int r111 = (r110 << 16) ^ r110;
        int r112 = findFirstAvailableSlot(r111 >>> 7);
        long r109 = r111 & 127;
        int r113 = r112 >> 3;
        int r114 = (r112 & 7) << 3;
        long r115 = (r109 << r114) | (r103[r113] & (~(255 << r114)));
        r103[r113] = r115;
        r103[(((r112 - 7) & r105) + (r105 & 7)) >> 3] = r115;
        r104[r112] = r108;
    L11:
        r106 = r106 + 1;
        goto L3
    L7:
        r107 = false;
        goto L8
    }

    public final boolean addAll(long[] r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = this._size;
        plusAssign(r100);
        if (r101 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    public final void minusAssign(LongSet r110) {
        Intrinsics.checkNotNullParameter(r110, SlcElement.KEY_ELEMENTS);
        long[] r100 = r110.elements;
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
        minusAssign(r100[(r102 << 3) + r105]);
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

    public final void plusAssign(long[] r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        plusAssign(r100[r102]);
        r102 = r102 + 1;
        goto L3
    }

    public final boolean removeAll(long[] r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = this._size;
        minusAssign(r100);
        if (r101 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    public final void minusAssign(long[] r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        minusAssign(r100[r102]);
        r102 = r102 + 1;
        goto L3
    }

    public final void plusAssign(long r100) {
        int r101 = findAbsoluteInsertIndex(r100);
        this.elements[r101] = r100;
    }

    public /* synthetic */ MutableLongSet(int r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 6;
    L5:
        this(r100);
    }
}
