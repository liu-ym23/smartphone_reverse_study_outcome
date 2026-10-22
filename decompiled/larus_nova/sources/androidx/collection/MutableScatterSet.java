package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.collection.internal.RuntimeHelpersKt;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0010\n\u0002\u0010#\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\u0013\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u0012J\u001b\u0010\u0013\u001a\u00020\u000e2\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0015¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017J\u0014\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018J\u0014\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0014\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019J\u0014\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aJ\u001e\u0010\u0011\u001a\u00020\t2\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0015H\u0086\u0002¢\u0006\u0002\u0010\u001bJ\u0017\u0010\u0011\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0086\u0002J\u0017\u0010\u0011\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0086\u0002J\u0017\u0010\u0011\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\u0002J\u0017\u0010\u0011\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0086\u0002J\u0017\u0010\u0011\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0086\u0002J\u0013\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010\u0010J\u0016\u0010\u001d\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u0012J\u001b\u0010\u001e\u001a\u00020\u000e2\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0015¢\u0006\u0002\u0010\u0016J\u0014\u0010\u001e\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018J\u0014\u0010\u001e\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017J\u0014\u0010\u001e\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0014\u0010\u001e\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019J\u0014\u0010\u001e\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aJ\u001e\u0010\u001d\u001a\u00020\t2\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0015H\u0086\u0002¢\u0006\u0002\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0086\u0002J\u0017\u0010\u001d\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0086\u0002J\u0017\u0010\u001d\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\u0002J\u0017\u0010\u001d\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0086\u0002J\u0017\u0010\u001d\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0086\u0002J \u0010\u001f\u001a\u00020\t2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0!H\u0086\bø\u0001\u0000J\u0014\u0010\"\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000#J\u0014\u0010\"\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0014\u0010\"\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019J\u001a\u0010\"\u001a\u00020\u000e2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0!J\u0010\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u0004H\u0001J\u0006\u0010&\u001a\u00020\tJ\u0015\u0010'\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010(J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0004H\u0002J\b\u0010+\u001a\u00020\u0004H\u0007J\r\u0010,\u001a\u00020\tH\u0000¢\u0006\u0002\b-J\r\u0010.\u001a\u00020\tH\u0000¢\u0006\u0002\b/J\u0015\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\u0004H\u0000¢\u0006\u0002\b2J\f\u00103\u001a\b\u0012\u0004\u0012\u00028\u000004R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00065"}, d2 = {"Landroidx/collection/MutableScatterSet;", ExifInterface.LONGITUDE_EAST, "Landroidx/collection/ScatterSet;", "initialCapacity", "", "<init>", "(I)V", "growthLimit", "initializeStorage", "", "initializeMetadata", "capacity", "initializeGrowth", "add", "", "element", "(Ljava/lang/Object;)Z", "plusAssign", "(Ljava/lang/Object;)V", "addAll", SlcElement.KEY_ELEMENTS, "", "([Ljava/lang/Object;)Z", "", "Lkotlin/sequences/Sequence;", "Landroidx/collection/OrderedScatterSet;", "Landroidx/collection/ObjectList;", "([Ljava/lang/Object;)V", "remove", "minusAssign", "removeAll", "removeIf", "predicate", "Lkotlin/Function1;", "retainAll", "", "removeElementAt", "index", "clear", "findAbsoluteInsertIndex", "(Ljava/lang/Object;)I", "findFirstAvailableSlot", "hash1", "trim", "adjustStorage", "adjustStorage$collection", "dropDeletes", "dropDeletes$collection", "resizeStorage", "newCapacity", "resizeStorage$collection", "asMutableSet", "", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MutableScatterSet<E> extends ScatterSet<E> {
    private int growthLimit;

    public MutableScatterSet() {
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
        ArraysKt.fill(this.elements, null, 0, this._capacity);
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

    public final Set<E> asMutableSet() {
        return new MutableSetWrapper(this);
    }

    public final void dropDeletes$collection() {
        long[] r100 = this.metadata;
        int r101 = this._capacity;
        Object[] r102 = this.elements;
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
        r100[r121] = ((~(255 << r123)) & r122) | (((long) (r117 & 127)) << r123);
        r100[r111] = (r100[r111] & (~(255 << r112))) | (128 << r112);
        r102[r119] = r102[r110];
        r102[r110] = null;
    L24:
        r109 = 72057594037927935L;
        r100[ArraysKt.getLastIndex(r100)] = (r100[0] & 72057594037927935L) | Long.MIN_VALUE;
        r110 = r110 + 1;
        r104 = 0;
        goto L6
    L23:
        r100[r121] = (((long) (r117 & 127)) << r123) | ((~(255 << r123)) & r122);
        Object r124 = r102[r119];
        r102[r119] = r102[r110];
        r102[r110] = r124;
        r110 = r110 - 1;
        goto L24
    L19:
        long r125 = ((long) (r117 & 127)) << r112;
        r100[r111] = r125 | ((~(255 << r112)) & r100[r111]);
        r100[ArraysKt.getLastIndex(r100)] = (r100[r104] & r109) | Long.MIN_VALUE;
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

    public MutableScatterSet(int r100) {
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

    private final int findAbsoluteInsertIndex(E r210) {
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
        if (Intrinsics.areEqual(this.elements[r117], r210) == true) goto L15;
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
        return r118;
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
        if (r101 != 0) goto L8;
        Object[] r102 = ContainerHelpersKt.EMPTY_OBJECTS;
    L9:
        this.elements = r102;
        return;
    L8:
        r102 = new Object[r101];
        goto L9
    L4:
        r101 = 0;
        goto L5
    }

    public final boolean add(E r100) {
        int r101 = getSize();
        int r102 = findAbsoluteInsertIndex(r100);
        this.elements[r102] = r100;
        if (getSize() == r101) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean addAll(ObjectList<E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = getSize();
        plusAssign(r100);
        if (r101 == getSize()) goto L5;
        return true;
    L5:
        return false;
    }

    public final void minusAssign(E r110) {
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
        if (Intrinsics.areEqual(this.elements[r115], r110) == true) goto L20;
        r113 = r113 & (r113 - 1);
    L20:
        if (r115 < 0) goto L27;
        removeElementAt(r115);
        return;
    L27:
        return;
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

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(ScatterSet<E> r110) {
        Intrinsics.checkNotNullParameter(r110, SlcElement.KEY_ELEMENTS);
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

    public final boolean remove(E r110) {
        boolean r100 = false;
        if (r110 == null) goto L5;
        int r101 = r110.hashCode();
    L6:
        int r102 = r101 * ScatterMapKt.MurmurHashC1;
        int r103 = r102 ^ (r102 << 16);
        int r104 = r103 & 127;
        int r105 = this._capacity;
        int r106 = (r103 >>> 7) & r105;
        int r107 = 0;
    L7:
        long[] r108 = this.metadata;
        int r109 = r106 >> 3;
        int r111 = (r106 & 7) << 3;
        long r112 = ((r108[r109 + 1] << (64 - r111)) & ((-r111) >> 63)) | (r108[r109] >>> r111);
        long r113 = (((long) r104) * ScatterMapKt.BitmaskLsb) ^ r112;
        long r114 = ((~r113) & (r113 - ScatterMapKt.BitmaskLsb)) & (-9187201950435737472L);
    L9:
        if (r114 == 0) goto L11;
        boolean r115 = true;
    L12:
        if (r115 == false) goto L18;
        int r116 = ((Long.numberOfTrailingZeros(r114) >> 3) + r106) & r105;
        if (Intrinsics.areEqual(this.elements[r116], r110) == true) goto L20;
        r114 = r114 & (r114 - 1);
    L20:
        if (r116 < 0) goto L22;
        r100 = true;
    L22:
        if (r100 == false) goto L24;
        removeElementAt(r116);
    L24:
        return r100;
    L18:
        if (((r112 & ((~r112) << 6)) & (-9187201950435737472L)) != 0) goto L19;
        r107 = r107 + 8;
        r106 = (r106 + r107) & r105;
        goto L7
    L19:
        r116 = -1;
        goto L20
    L11:
        r115 = false;
        goto L12
    L5:
        r101 = 0;
        goto L6
    }

    public final boolean removeAll(ObjectList<E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = getSize();
        minusAssign(r100);
        if (r101 == getSize()) goto L5;
        return true;
    L5:
        return false;
    }

    public final void removeElementAt(int r100) {
        this._size--;
        long[] r101 = this.metadata;
        int r102 = this._capacity;
        int r103 = r100 >> 3;
        int r104 = (r100 & 7) << 3;
        long r105 = (r101[r103] & (~(255 << r104))) | (254 << r104);
        r101[r103] = r105;
        r101[(((r100 - 7) & r102) + (r102 & 7)) >> 3] = r105;
        this.elements[r100] = null;
    }

    public final void removeIf(Function1<? super E, Boolean> r110) {
        Intrinsics.checkNotNullParameter(r110, "predicate");
        Object[] r100 = this.elements;
        long[] r101 = this.metadata;
        int r102 = r101.length - 2;
        if (r102 < 0) goto L21;
        int r103 = 0;
    L5:
        long r104 = r101[r103];
        if (((((~r104) << 7) & r104) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r105 = 8 - ((~(r103 - r102)) >>> 31);
        int r111 = 0;
    L8:
        if (r111 >= r105) goto L18;
        if ((255 & r104) >= 128) goto L12;
        boolean r112 = true;
    L13:
        if (r112 == false) goto L17;
        int r113 = (r103 << 3) + r111;
        if (r110.invoke(r100[r113]).booleanValue() == false) goto L17;
        removeElementAt(r113);
    L17:
        r104 = r104 >> 8;
        r111 = r111 + 1;
        goto L8
    L12:
        r112 = false;
        goto L13
    L18:
        if (r105 == 8) goto L19;
        return;
    L19:
        if (r103 == r102) goto L29;
        r103 = r103 + 1;
        goto L5
    L29:
        return;
    }

    public final void resizeStorage$collection(int r210) {
        long[] r100 = this.metadata;
        Object[] r101 = this.elements;
        int r102 = this._capacity;
        initializeStorage(r210);
        long[] r103 = this.metadata;
        Object[] r104 = this.elements;
        int r105 = this._capacity;
        int r106 = 0;
    L3:
        if (r106 >= r102) goto L15;
        if (((r100[r106 >> 3] >> ((r106 & 7) << 3)) & 255) >= 128) goto L7;
        boolean r107 = true;
    L8:
        if (r107 == false) goto L14;
        Object r108 = r101[r106];
        if (r108 == null) goto L12;
        int r110 = r108.hashCode();
    L13:
        int r111 = r110 * ScatterMapKt.MurmurHashC1;
        int r112 = r111 ^ (r111 << 16);
        int r113 = findFirstAvailableSlot(r112 >>> 7);
        long r114 = r112 & 127;
        int r115 = r113 >> 3;
        int r116 = (r113 & 7) << 3;
        long r117 = (r103[r115] & (~(255 << r116))) | (r114 << r116);
        r103[r115] = r117;
        r103[(((r113 - 7) & r105) + (r105 & 7)) >> 3] = r117;
        r104[r113] = r108;
        goto L14
    L12:
        r110 = 0;
    L14:
        r106 = r106 + 1;
        goto L3
    L7:
        r107 = false;
        goto L8
    }

    public final boolean retainAll(Function1<? super E, Boolean> r210) {
        Intrinsics.checkNotNullParameter(r210, "predicate");
        Object[] r100 = this.elements;
        int r101 = this._size;
        long[] r102 = this.metadata;
        int r103 = r102.length - 2;
        if (r103 < 0) goto L22;
        int r104 = 0;
    L5:
        long r105 = r102[r104];
        if (((((~r105) << 7) & r105) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r110 = 8 - ((~(r104 - r103)) >>> 31);
        int r111 = 0;
    L8:
        if (r111 >= r110) goto L18;
        if ((255 & r105) >= 128) goto L12;
        boolean r112 = true;
    L13:
        if (r112 == false) goto L17;
        int r113 = (r104 << 3) + r111;
        if (r210.invoke(r100[r113]).booleanValue() == true) goto L17;
        removeElementAt(r113);
    L17:
        r105 = r105 >> 8;
        r111 = r111 + 1;
        goto L8
    L12:
        r112 = false;
        goto L13
    L18:
        if (r110 != 8) goto L22;
    L19:
        if (r104 == r103) goto L22;
        r104 = r104 + 1;
    L22:
        if (r101 != this._size) goto L32;
        return false;
    L32:
        return true;
    }

    public final boolean addAll(OrderedScatterSet<E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = getSize();
        plusAssign(r100);
        if (r101 == getSize()) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(ScatterSet<E> r110) {
        Intrinsics.checkNotNullParameter(r110, SlcElement.KEY_ELEMENTS);
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

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(OrderedScatterSet<E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        Object[] r101 = r100.elements;
        long[] r102 = r100.nodes;
        int r103 = r100.tail;
    L4:
        if (r103 == Integer.MAX_VALUE) goto L6;
        int r104 = (int) ((r102[r103] >> 31) & SieveCacheKt.NodeLinkMask);
        plusAssign(r101[r103]);
        r103 = r104;
        goto L4
    }

    public final boolean removeAll(OrderedScatterSet<E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = getSize();
        minusAssign(r100);
        if (r101 == getSize()) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean retainAll(Collection<? extends E> r210) {
        Intrinsics.checkNotNullParameter(r210, SlcElement.KEY_ELEMENTS);
        Object[] r100 = this.elements;
        int r101 = this._size;
        long[] r102 = this.metadata;
        int r103 = r102.length - 2;
        if (r103 < 0) goto L22;
        int r104 = 0;
    L5:
        long r105 = r102[r104];
        if (((((~r105) << 7) & r105) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r110 = 8 - ((~(r104 - r103)) >>> 31);
        int r111 = 0;
    L8:
        if (r111 >= r110) goto L18;
        if ((255 & r105) >= 128) goto L12;
        boolean r112 = true;
    L13:
        if (r112 == false) goto L17;
        int r113 = (r104 << 3) + r111;
        if (CollectionsKt.contains(r210, r100[r113]) == true) goto L17;
        removeElementAt(r113);
    L17:
        r105 = r105 >> 8;
        r111 = r111 + 1;
        goto L8
    L12:
        r112 = false;
        goto L13
    L18:
        if (r110 != 8) goto L22;
    L19:
        if (r104 == r103) goto L22;
        r104 = r104 + 1;
    L22:
        if (r101 == this._size) goto L24;
        return true;
    L24:
        return false;
    }

    public final boolean addAll(ScatterSet<E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = getSize();
        plusAssign(r100);
        if (r101 == getSize()) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(OrderedScatterSet<E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        Object[] r101 = r100.elements;
        long[] r102 = r100.nodes;
        int r103 = r100.tail;
    L4:
        if (r103 == Integer.MAX_VALUE) goto L6;
        int r104 = (int) ((r102[r103] >> 31) & SieveCacheKt.NodeLinkMask);
        minusAssign(r101[r103]);
        r103 = r104;
        goto L4
    }

    public final void plusAssign(Iterable<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        Iterator<? extends E> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        plusAssign(r101.next());
        goto L4
    }

    public final boolean removeAll(ScatterSet<E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = getSize();
        minusAssign(r100);
        if (r101 == getSize()) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean retainAll(OrderedScatterSet<E> r210) {
        Intrinsics.checkNotNullParameter(r210, SlcElement.KEY_ELEMENTS);
        Object[] r100 = this.elements;
        int r101 = this._size;
        long[] r102 = this.metadata;
        int r103 = r102.length - 2;
        if (r103 < 0) goto L22;
        int r104 = 0;
    L5:
        long r105 = r102[r104];
        if (((((~r105) << 7) & r105) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r110 = 8 - ((~(r104 - r103)) >>> 31);
        int r111 = 0;
    L8:
        if (r111 >= r110) goto L18;
        if ((255 & r105) >= 128) goto L12;
        boolean r112 = true;
    L13:
        if (r112 == false) goto L17;
        int r113 = (r104 << 3) + r111;
        if (r210.contains(r100[r113]) == true) goto L17;
        removeElementAt(r113);
    L17:
        r105 = r105 >> 8;
        r111 = r111 + 1;
        goto L8
    L12:
        r112 = false;
        goto L13
    L18:
        if (r110 != 8) goto L22;
    L19:
        if (r104 == r103) goto L22;
        r104 = r104 + 1;
    L22:
        if (r101 != this._size) goto L32;
        return false;
    L32:
        return true;
    }

    public final boolean addAll(Iterable<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = getSize();
        plusAssign(r100);
        if (r101 == getSize()) goto L5;
        return true;
    L5:
        return false;
    }

    public final void minusAssign(Iterable<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        Iterator<? extends E> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        minusAssign(r101.next());
        goto L4
    }

    public final void plusAssign(Sequence<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        Iterator<? extends E> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        plusAssign(r101.next());
        goto L4
    }

    public final boolean removeAll(Iterable<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = getSize();
        minusAssign(r100);
        if (r101 == getSize()) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean retainAll(ScatterSet<E> r210) {
        Intrinsics.checkNotNullParameter(r210, SlcElement.KEY_ELEMENTS);
        Object[] r100 = this.elements;
        int r101 = this._size;
        long[] r102 = this.metadata;
        int r103 = r102.length - 2;
        if (r103 < 0) goto L22;
        int r104 = 0;
    L5:
        long r105 = r102[r104];
        if (((((~r105) << 7) & r105) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r110 = 8 - ((~(r104 - r103)) >>> 31);
        int r111 = 0;
    L8:
        if (r111 >= r110) goto L18;
        if ((255 & r105) >= 128) goto L12;
        boolean r112 = true;
    L13:
        if (r112 == false) goto L17;
        int r113 = (r104 << 3) + r111;
        if (r210.contains(r100[r113]) == true) goto L17;
        removeElementAt(r113);
    L17:
        r105 = r105 >> 8;
        r111 = r111 + 1;
        goto L8
    L12:
        r112 = false;
        goto L13
    L18:
        if (r110 != 8) goto L22;
    L19:
        if (r104 == r103) goto L22;
        r104 = r104 + 1;
    L22:
        if (r101 != this._size) goto L32;
        return false;
    L32:
        return true;
    }

    public final boolean addAll(Sequence<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = getSize();
        plusAssign(r100);
        if (r101 == getSize()) goto L5;
        return true;
    L5:
        return false;
    }

    public final void minusAssign(Sequence<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        Iterator<? extends E> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        minusAssign(r101.next());
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(ObjectList<E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        Object[] r101 = r100.content;
        int r102 = r100._size;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        plusAssign(r101[r103]);
        r103 = r103 + 1;
        goto L3
    }

    public final boolean removeAll(Sequence<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = getSize();
        minusAssign(r100);
        if (r101 == getSize()) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean addAll(E[] r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = getSize();
        plusAssign(r100);
        if (r101 == getSize()) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(ObjectList<E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        Object[] r101 = r100.content;
        int r102 = r100._size;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        minusAssign(r101[r103]);
        r103 = r103 + 1;
        goto L3
    }

    public final void plusAssign(E[] r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        plusAssign(r100[r102]);
        r102 = r102 + 1;
        goto L3
    }

    public final boolean removeAll(E[] r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = getSize();
        minusAssign(r100);
        if (r101 == getSize()) goto L5;
        return true;
    L5:
        return false;
    }

    public final void minusAssign(E[] r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        minusAssign(r100[r102]);
        r102 = r102 + 1;
        goto L3
    }

    public final void plusAssign(E r100) {
        int r101 = findAbsoluteInsertIndex(r100);
        this.elements[r101] = r100;
    }

    public /* synthetic */ MutableScatterSet(int r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 6;
    L5:
        this(r100);
    }
}
