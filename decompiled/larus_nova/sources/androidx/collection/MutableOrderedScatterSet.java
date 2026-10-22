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
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0015\n\u0002\u0010\u0016\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010#\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\u0013\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u0012J\u001b\u0010\u0013\u001a\u00020\u000e2\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0015¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017J\u0014\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018J\u0014\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0014\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019J\u0014\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aJ\u001e\u0010\u0011\u001a\u00020\t2\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0015H\u0086\u0002¢\u0006\u0002\u0010\u001bJ\u0017\u0010\u0011\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0086\u0002J\u0017\u0010\u0011\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0086\u0002J\u0017\u0010\u0011\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\u0002J\u0017\u0010\u0011\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0086\u0002J\u0017\u0010\u0011\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0086\u0002J\u0013\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010\u0010J\u0016\u0010\u001d\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u0012J\u001b\u0010\u001e\u001a\u00020\u000e2\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0015¢\u0006\u0002\u0010\u0016J\u0014\u0010\u001e\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018J\u0014\u0010\u001e\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017J\u0014\u0010\u001e\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0014\u0010\u001e\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019J\u0014\u0010\u001e\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aJ\u001e\u0010\u001d\u001a\u00020\t2\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0015H\u0086\u0002¢\u0006\u0002\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0086\u0002J\u0017\u0010\u001d\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0086\u0002J\u0017\u0010\u001d\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\u0002J\u0017\u0010\u001d\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0086\u0002J\u0017\u0010\u001d\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0086\u0002J \u0010\u001f\u001a\u00020\t2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0!H\u0086\bø\u0001\u0000J\u0014\u0010\"\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000#J\u0014\u0010\"\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0014\u0010\"\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019J \u0010\"\u001a\u00020\u000e2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0!H\u0086\bø\u0001\u0000J\u0010\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u0004H\u0001J\u0011\u0010&\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u0004H\u0082\bJ\u0011\u0010'\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u0004H\u0082\bJ\u0006\u0010(\u001a\u00020\tJ\u0015\u0010)\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010*J\u0010\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0004H\u0002J\b\u0010-\u001a\u00020\u0004H\u0007J\u000e\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u0004J\r\u00100\u001a\u00020\tH\u0000¢\u0006\u0002\b1J\r\u00102\u001a\u00020\tH\u0000¢\u0006\u0002\b3J\u0015\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020\u0004H\u0000¢\u0006\u0002\b6J\u0010\u00107\u001a\u00020\t2\u0006\u00108\u001a\u000209H\u0002J\u0010\u00107\u001a\u00020\t2\u0006\u00108\u001a\u00020:H\u0002J\f\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000<R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006="}, d2 = {"Landroidx/collection/MutableOrderedScatterSet;", ExifInterface.LONGITUDE_EAST, "Landroidx/collection/OrderedScatterSet;", "initialCapacity", "", "<init>", "(I)V", "growthLimit", "initializeStorage", "", "initializeMetadata", "capacity", "initializeGrowth", "add", "", "element", "(Ljava/lang/Object;)Z", "plusAssign", "(Ljava/lang/Object;)V", "addAll", SlcElement.KEY_ELEMENTS, "", "([Ljava/lang/Object;)Z", "", "Lkotlin/sequences/Sequence;", "Landroidx/collection/ScatterSet;", "Landroidx/collection/ObjectList;", "([Ljava/lang/Object;)V", "remove", "minusAssign", "removeAll", "removeIf", "predicate", "Lkotlin/Function1;", "retainAll", "", "removeElementAt", "index", "moveNodeToHead", "removeNode", "clear", "findAbsoluteInsertIndex", "(Ljava/lang/Object;)I", "findFirstAvailableSlot", "hash1", "trim", "trimToSize", "maxSize", "adjustStorage", "adjustStorage$collection", "dropDeletes", "dropDeletes$collection", "resizeStorage", "newCapacity", "resizeStorage$collection", "fixupNodes", "mapping", "", "", "asMutableSet", "", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MutableOrderedScatterSet<E> extends OrderedScatterSet<E> {
    private int growthLimit;

    public MutableOrderedScatterSet() {
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
        ArraysKt.fill$default(this.nodes, 4611686018427387903L, 0, 0, 6, null);
        this.head = Integer.MAX_VALUE;
        this.tail = Integer.MAX_VALUE;
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
        return new MutableOrderedSetWrapper(this);
    }

    public final void dropDeletes$collection() {
        long[] r100 = this.metadata;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = this._capacity;
        Object[] r102 = this.elements;
        long[] r103 = this.nodes;
        long[] r104 = new long[r101];
        ArraysKt.fill(r104, 9223372034707292159L, 0, r101);
        int r105 = (r101 + 7) >> 3;
        int r110 = 0;
    L6:
        if (r110 >= r105) goto L8;
        long r111 = r100[r110] & (-9187201950435737472L);
        r100[r110] = (-72340172838076674L) & ((~r111) + (r111 >>> 7));
        r110 = r110 + 1;
        goto L6
    L8:
        int r106 = ArraysKt.getLastIndex(r100);
        int r112 = r106 - 1;
        r100[r112] = (r100[r112] & 72057594037927935L) | (-72057594037927936L);
        r100[r106] = r100[0];
        int r107 = 0;
    L9:
        if (r107 == r101) goto L40;
        int r113 = r107 >> 3;
        int r114 = (r107 & 7) << 3;
        long r115 = (r100[r113] >> r114) & 255;
        if (r115 == 128) goto L12;
        if (r115 != 254) goto L12;
        Object r116 = r102[r107];
        if (r116 == null) goto L19;
        int r117 = r116.hashCode();
    L20:
        int r118 = r117 * ScatterMapKt.MurmurHashC1;
        int r119 = r118 ^ (r118 << 16);
        int r120 = r119 >>> 7;
        int r108 = findFirstAvailableSlot(r120);
        int r121 = r120 & r101;
        if ((((r108 - r121) & r101) / 8) != (((r107 - r121) & r101) / 8)) goto L27;
        r100[r113] = (((long) (r119 & 127)) << r114) | (r100[r113] & (~(255 << r114)));
        if (r104[r107] != 9223372034707292159L) goto L25;
        long r109 = r107;
        r104[r107] = r109 | (r109 << 32);
    L25:
        r100[r100.length - 1] = r100[0];
        r107 = r107 + 1;
        goto L9
    L27:
        int r122 = r108 >> 3;
        long r210 = r100[r122];
        int r123 = (r108 & 7) << 3;
        if (((r210 >> r123) & 255) != 128) goto L34;
        long[] r211 = r103;
        long[] r310 = r104;
        r100[r122] = (r210 & (~(255 << r123))) | (((long) (r119 & 127)) << r123);
        r100[r113] = (r100[r113] & (~(255 << r114))) | (128 << r114);
        r102[r108] = r102[r107];
        r102[r107] = null;
        r211[r108] = r211[r107];
        r211[r107] = 4611686018427387903L;
        int r124 = (int) ((r310[r107] >> 32) & BodyPartID.bodyIdMax);
        if (r124 == Integer.MAX_VALUE) goto L32;
        r310[r124] = (r310[r124] & (-4294967296L)) | ((long) r108);
        r310[r107] = (r310[r107] & BodyPartID.bodyIdMax) | (-4294967296L);
        char r125 = ' ';
    L33:
        r310[r108] = (((long) r107) << r125) | ((long) Integer.MAX_VALUE);
    L39:
        r100[r100.length - 1] = r100[0];
        r107 = r107 + 1;
        r103 = r211;
        r104 = r310;
        goto L9
    L32:
        r125 = ' ';
        r310[r107] = (((long) Integer.MAX_VALUE) << 32) | ((long) r108);
        goto L33
    L34:
        r211 = r103;
        r310 = r104;
        r100[r122] = (((long) (r119 & 127)) << r123) | (r210 & (~(255 << r123)));
        Object r126 = r102[r108];
        r102[r108] = r102[r107];
        r102[r107] = r126;
        long r127 = r211[r108];
        r211[r108] = r211[r107];
        r211[r107] = r127;
        int r128 = (int) ((r310[r107] >> 32) & BodyPartID.bodyIdMax);
        if (r128 == Integer.MAX_VALUE) goto L37;
        long r129 = r108;
        r310[r128] = (r310[r128] & (-4294967296L)) | r129;
        r310[r107] = (r310[r107] & BodyPartID.bodyIdMax) | (r129 << 32);
    L38:
        r310[r108] = (((long) r128) << 32) | ((long) r107);
        r107 = r107 - 1;
        goto L39
    L37:
        long r130 = r108;
        r310[r107] = r130 | (r130 << 32);
        r128 = r107;
        goto L38
    L19:
        r117 = 0;
    L12:
        r107 = r107 + 1;
        goto L9
    L40:
        initializeGrowth();
        fixupNodes(r104);
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

    public MutableOrderedScatterSet(int r100) {
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

    private final void fixupNodes(long[] r110) {
        long[] r100 = this.nodes;
        int r101 = r100.length;
        int r102 = 0;
    L3:
        int r103 = Integer.MAX_VALUE;
        if (r102 >= r101) goto L14;
        long r104 = r100[r102];
        int r111 = (int) ((r104 >> 31) & SieveCacheKt.NodeLinkMask);
        int r105 = (int) (SieveCacheKt.NodeLinkMask & r104);
        long r106 = r104 & SieveCacheKt.NodeMetaMask;
        if (r111 != Integer.MAX_VALUE) goto L8;
        int r112 = Integer.MAX_VALUE;
    L9:
        long r107 = (r106 | ((long) r112)) << 31;
        if (r105 == Integer.MAX_VALUE) goto L13;
        r103 = (int) (BodyPartID.bodyIdMax & r110[r105]);
    L13:
        r100[r102] = ((long) r103) | r107;
        r102 = r102 + 1;
        goto L3
    L8:
        r112 = (int) (r110[r111] & BodyPartID.bodyIdMax);
        goto L9
    L14:
        int r108 = this.head;
        if (r108 == Integer.MAX_VALUE) goto L17;
        this.head = (int) (r110[r108] & BodyPartID.bodyIdMax);
    L17:
        int r109 = this.tail;
        if (r109 == Integer.MAX_VALUE) goto L24;
        this.tail = (int) (r110[r109] & BodyPartID.bodyIdMax);
        return;
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
        if (r101 != 0) goto L12;
        long[] r103 = SieveCacheKt.getEmptyNodes();
    L13:
        this.nodes = r103;
        return;
    L12:
        r103 = new long[r101];
        ArraysKt.fill$default(r103, 4611686018427387903L, 0, 0, 6, null);
        goto L13
    L8:
        r102 = new Object[r101];
        goto L9
    L4:
        r101 = 0;
        goto L5
    }

    private final void moveNodeToHead(int r110) {
        long[] r100 = this.nodes;
        int r101 = this.head;
        r100[r110] = (((long) r101) & SieveCacheKt.NodeLinkMask) | 4611686016279904256L;
        if (r101 == Integer.MAX_VALUE) goto L5;
        long r102 = r100[r101] & SieveCacheKt.NodeMetaAndNextMask;
        r100[r101] = ((((long) r110) & SieveCacheKt.NodeLinkMask) << 31) | r102;
    L5:
        this.head = r110;
        if (this.tail != Integer.MAX_VALUE) goto L9;
        this.tail = r110;
        return;
    }

    private final void removeNode(int r110) {
        long[] r100 = this.nodes;
        long r101 = r100[r110];
        int r102 = (int) ((r101 >> 31) & SieveCacheKt.NodeLinkMask);
        int r103 = (int) (r101 & SieveCacheKt.NodeLinkMask);
        if (r102 == Integer.MAX_VALUE) goto L5;
        r100[r102] = (r100[r102] & SieveCacheKt.NodeMetaAndPreviousMask) | (((long) r103) & SieveCacheKt.NodeLinkMask);
    L6:
        if (r103 == Integer.MAX_VALUE) goto L8;
        long r104 = r100[r103] & SieveCacheKt.NodeMetaAndNextMask;
        r100[r103] = ((((long) r102) & SieveCacheKt.NodeLinkMask) << 31) | r104;
    L9:
        r100[r110] = 4611686018427387903L;
        return;
    L8:
        this.tail = r102;
        goto L9
    L5:
        this.head = r103;
        goto L6
    }

    public final boolean add(E r110) {
        int r100 = getSize();
        int r101 = findAbsoluteInsertIndex(r110);
        this.elements[r101] = r110;
        long[] r111 = this.nodes;
        int r102 = this.head;
        r111[r101] = (((long) r102) & SieveCacheKt.NodeLinkMask) | 4611686016279904256L;
        if (r102 == Integer.MAX_VALUE) goto L5;
        long r103 = r111[r102] & SieveCacheKt.NodeMetaAndNextMask;
        r111[r102] = ((((long) r101) & SieveCacheKt.NodeLinkMask) << 31) | r103;
    L5:
        this.head = r101;
        if (this.tail != Integer.MAX_VALUE) goto L9;
        this.tail = r101;
    L9:
        if (getSize() == r100) goto L11;
        return true;
    L11:
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

    public final void removeElementAt(int r110) {
        this._size--;
        long[] r100 = this.metadata;
        int r101 = this._capacity;
        int r102 = r110 >> 3;
        int r103 = (r110 & 7) << 3;
        long r104 = (r100[r102] & (~(255 << r103))) | (254 << r103);
        r100[r102] = r104;
        r100[(((r110 - 7) & r101) + (r101 & 7)) >> 3] = r104;
        this.elements[r110] = null;
        long[] r105 = this.nodes;
        long r106 = r105[r110];
        int r107 = (int) ((r106 >> 31) & SieveCacheKt.NodeLinkMask);
        int r108 = (int) (r106 & SieveCacheKt.NodeLinkMask);
        if (r107 == Integer.MAX_VALUE) goto L5;
        r105[r107] = (r105[r107] & SieveCacheKt.NodeMetaAndPreviousMask) | (((long) r108) & SieveCacheKt.NodeLinkMask);
    L6:
        if (r108 == Integer.MAX_VALUE) goto L8;
        r105[r108] = ((((long) r107) & SieveCacheKt.NodeLinkMask) << 31) | (r105[r108] & SieveCacheKt.NodeMetaAndNextMask);
    L9:
        r105[r110] = 4611686018427387903L;
        return;
    L8:
        this.tail = r107;
        goto L9
    L5:
        this.head = r108;
        goto L6
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
        long[] r102 = this.nodes;
        int r103 = this._capacity;
        int[] r104 = new int[r103];
        initializeStorage(r210);
        long[] r105 = this.metadata;
        Object[] r106 = this.elements;
        long[] r107 = this.nodes;
        int r108 = this._capacity;
        int r110 = 0;
    L3:
        if (r110 >= r103) goto L16;
        if (((r100[r110 >> 3] >> ((r110 & 7) << 3)) & 255) >= 128) goto L7;
        boolean r111 = true;
    L8:
        if (r111 == false) goto L15;
        Object r112 = r101[r110];
        if (r112 == null) goto L12;
        int r113 = r112.hashCode();
    L13:
        int r114 = r113 * ScatterMapKt.MurmurHashC1;
        int r115 = r114 ^ (r114 << 16);
        int r116 = findFirstAvailableSlot(r115 >>> 7);
        long r117 = r115 & 127;
        int r118 = r116 >> 3;
        int r119 = (r116 & 7) << 3;
        long r109 = (r105[r118] & (~(255 << r119))) | (r117 << r119);
        r105[r118] = r109;
        r105[(((r116 - 7) & r108) + (r108 & 7)) >> 3] = r109;
        r106[r116] = r112;
        r107[r116] = r102[r110];
        r104[r110] = r116;
        goto L15
    L12:
        r113 = 0;
    L15:
        r110 = r110 + 1;
        r100 = r100;
        r101 = r101;
        goto L3
    L7:
        r111 = false;
        goto L8
    L16:
        fixupNodes(r104);
    }

    public final boolean retainAll(Function1<? super E, Boolean> r210) {
        Intrinsics.checkNotNullParameter(r210, "predicate");
        Object[] r100 = this.elements;
        int r101 = getSize();
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
        if (r101 != getSize()) goto L32;
        return false;
    L32:
        return true;
    }

    public final void trimToSize(int r100) {
        long[] r101 = this.nodes;
        int r102 = this.head;
    L4:
        if (r102 == Integer.MAX_VALUE) goto L9;
        int r103 = this._size;
        if (r103 <= r100) goto L13;
        if (r103 == 0) goto L14;
        int r104 = (int) (r101[r102] & SieveCacheKt.NodeLinkMask);
        removeElementAt(r102);
        r102 = r104;
        goto L4
    L14:
        return;
    L13:
        return;
    }

    private final void fixupNodes(int[] r110) {
        long[] r100 = this.nodes;
        int r101 = r100.length;
        int r102 = 0;
    L3:
        int r103 = Integer.MAX_VALUE;
        if (r102 >= r101) goto L14;
        long r104 = r100[r102];
        int r105 = (int) ((r104 >> 31) & SieveCacheKt.NodeLinkMask);
        int r106 = (int) (SieveCacheKt.NodeLinkMask & r104);
        long r107 = r104 & SieveCacheKt.NodeMetaMask;
        if (r105 != Integer.MAX_VALUE) goto L8;
        int r108 = Integer.MAX_VALUE;
    L9:
        long r109 = (r107 | ((long) r108)) << 31;
        if (r106 == Integer.MAX_VALUE) goto L13;
        r103 = r110[r106];
    L13:
        r100[r102] = r109 | ((long) r103);
        r102 = r102 + 1;
        goto L3
    L8:
        r108 = r110[r105];
        goto L9
    L14:
        int r111 = this.head;
        if (r111 == Integer.MAX_VALUE) goto L17;
        this.head = r110[r111];
    L17:
        int r112 = this.tail;
        if (r112 == Integer.MAX_VALUE) goto L24;
        this.tail = r110[r112];
        return;
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

    public final void plusAssign(E r110) {
        int r100 = findAbsoluteInsertIndex(r110);
        this.elements[r100] = r110;
        long[] r111 = this.nodes;
        int r101 = this.head;
        r111[r100] = (((long) r101) & SieveCacheKt.NodeLinkMask) | 4611686016279904256L;
        if (r101 == Integer.MAX_VALUE) goto L5;
        long r102 = r111[r101] & SieveCacheKt.NodeMetaAndNextMask;
        r111[r101] = ((((long) r100) & SieveCacheKt.NodeLinkMask) << 31) | r102;
    L5:
        this.head = r100;
        if (this.tail != Integer.MAX_VALUE) goto L9;
        this.tail = r100;
        return;
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

    public final void plusAssign(Iterable<? extends E> r100) {
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

    public final void plusAssign(Sequence<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        Iterator<? extends E> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        plusAssign(r101.next());
        goto L4
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

    public /* synthetic */ MutableOrderedScatterSet(int r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 6;
    L5:
        this(r100);
    }
}
