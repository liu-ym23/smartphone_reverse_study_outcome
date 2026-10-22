package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0013\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00028\u0000¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00028\u0000¢\u0006\u0002\u0010\u0011J\u000b\u0010\u0013\u001a\u00028\u0000¢\u0006\u0002\u0010\u0014J\u000b\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u0014J\u0006\u0010\u0016\u001a\u00020\u000eJ\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0004J\u0016\u0010\u001e\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0002\u0010 J\u0006\u0010!\u001a\u00020\u0004J\u0006\u0010\"\u001a\u00020#R\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001a\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u001c\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0014¨\u0006$"}, d2 = {"Landroidx/collection/CircularArray;", ExifInterface.LONGITUDE_EAST, "", "minCapacity", "", "<init>", "(I)V", SlcElement.KEY_ELEMENTS, "", "[Ljava/lang/Object;", "head", "tail", "capacityBitmask", "doubleCapacity", "", "addFirst", "element", "(Ljava/lang/Object;)V", "addLast", "popFirst", "()Ljava/lang/Object;", "popLast", "clear", "removeFromStart", "count", "removeFromEnd", SoloKtvContext.SOLO_PAGE_FIRST, "getFirst", "last", "getLast", MonitorConstants.CONNECT_TYPE_GET, "index", "(I)Ljava/lang/Object;", "size", "isEmpty", "", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CircularArray<E> {
    private int capacityBitmask;
    private E[] elements;
    private int head;
    private int tail;

    public CircularArray() {
        int r100 = 0;
        this(r100, 1, null);
    }

    private final void doubleCapacity() {
        E[] r100 = this.elements;
        int r101 = r100.length;
        int r102 = this.head;
        int r103 = r101 - r102;
        int r104 = r101 << 1;
        if (r104 < 0) goto L7;
        E[] r105 = (E[]) new Object[r104];
        ArraysKt.copyInto(r100, r105, 0, r102, r101);
        ArraysKt.copyInto(this.elements, r105, r103, 0, this.head);
        this.elements = r105;
        this.head = 0;
        this.tail = r101;
        this.capacityBitmask = r104 - 1;
        return;
    L7:
        throw new RuntimeException("Max array capacity exceeded");
    }

    public final E getFirst() {
        int r100 = this.head;
        if (r100 == this.tail) goto L6;
        E r101 = this.elements[r100];
        Intrinsics.checkNotNull(r101);
        return r101;
    L6:
        CollectionPlatformUtils r102 = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final E getLast() {
        int r100 = this.head;
        int r101 = this.tail;
        if (r100 == r101) goto L6;
        E r102 = this.elements[(r101 - 1) & this.capacityBitmask];
        Intrinsics.checkNotNull(r102);
        return r102;
    L6:
        CollectionPlatformUtils r103 = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final boolean isEmpty() {
        if (this.head != this.tail) goto L5;
        return true;
    L5:
        return false;
    }

    public final E popFirst() {
        int r100 = this.head;
        if (r100 == this.tail) goto L6;
        E[] r101 = this.elements;
        E r102 = r101[r100];
        r101[r100] = null;
        this.head = (r100 + 1) & this.capacityBitmask;
        return r102;
    L6:
        CollectionPlatformUtils r103 = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final E popLast() {
        int r100 = this.head;
        int r101 = this.tail;
        if (r100 == r101) goto L6;
        int r102 = this.capacityBitmask & (r101 - 1);
        E[] r103 = this.elements;
        E r104 = r103[r102];
        r103[r102] = null;
        this.tail = r102;
        return r104;
    L6:
        CollectionPlatformUtils r105 = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final int size() {
        return (this.tail - this.head) & this.capacityBitmask;
    }

    public final void clear() {
        removeFromStart(size());
    }

    public CircularArray(int r100) {
        boolean r101 = false;
        if (r100 < 1) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L9;
        RuntimeHelpersKt.throwIllegalArgumentException("capacity must be >= 1");
    L9:
        if (r100 > 1073741824) goto L11;
        r101 = true;
    L11:
        if (r101 == true) goto L14;
        RuntimeHelpersKt.throwIllegalArgumentException("capacity must be <= 2^30");
    L14:
        if (Integer.bitCount(r100) == 1) goto L16;
        r100 = Integer.highestOneBit(r100 - 1) << 1;
    L16:
        this.capacityBitmask = r100 - 1;
        this.elements = (E[]) new Object[r100];
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void addFirst(E r100) {
        int r101 = (this.head - 1) & this.capacityBitmask;
        this.head = r101;
        this.elements[r101] = r100;
        if (r101 != this.tail) goto L6;
        doubleCapacity();
        return;
    }

    public final void addLast(E r100) {
        E[] r101 = this.elements;
        int r102 = this.tail;
        r101[r102] = r100;
        int r103 = this.capacityBitmask;
        int r104 = r103 & (r102 + 1);
        this.tail = r104;
        if (r104 != this.head) goto L6;
        doubleCapacity();
        return;
    }

    public final E get(int r100) {
        if (r100 >= 0) goto L4;
    L7:
        CollectionPlatformUtils r101 = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    L4:
        if (r100 >= size()) goto L7;
        E[] r102 = this.elements;
        int r103 = this.head + r100;
        E r104 = r102[this.capacityBitmask & r103];
        Intrinsics.checkNotNull(r104);
        return r104;
    }

    public final void removeFromEnd(int r100) {
        if (r100 > 0) goto L5;
        return;
    L5:
        if (r100 > size()) goto L21;
        int r101 = this.tail;
        if (r100 >= r101) goto L9;
        int r102 = r101 - r100;
    L10:
        int r103 = r102;
    L12:
        if (r103 >= r101) goto L14;
        this.elements[r103] = null;
        r103 = r103 + 1;
        goto L12
    L14:
        int r104 = this.tail;
        int r105 = r104 - r102;
        int r106 = r100 - r105;
        this.tail = r104 - r105;
        if (r106 <= 0) goto L25;
        int r107 = this.elements.length;
        this.tail = r107;
        int r108 = r107 - r106;
        int r109 = r108;
    L17:
        if (r109 >= r107) goto L19;
        this.elements[r109] = null;
        r109 = r109 + 1;
        goto L17
    L19:
        this.tail = r108;
        return;
    L25:
        return;
    L9:
        r102 = 0;
        goto L10
    L21:
        CollectionPlatformUtils r110 = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final void removeFromStart(int r100) {
        if (r100 > 0) goto L5;
        return;
    L5:
        if (r100 > size()) goto L19;
        int r101 = this.elements.length;
        int r102 = this.head;
        if (r100 >= (r101 - r102)) goto L10;
        r101 = r102 + r100;
    L10:
        if (r102 >= r101) goto L12;
        this.elements[r102] = null;
        r102 = r102 + 1;
        goto L10
    L12:
        int r103 = this.head;
        int r104 = r101 - r103;
        int r105 = r100 - r104;
        int r106 = r103 + r104;
        this.head = this.capacityBitmask & r106;
        if (r105 <= 0) goto L24;
        int r107 = 0;
    L15:
        if (r107 >= r105) goto L17;
        this.elements[r107] = null;
        r107 = r107 + 1;
        goto L15
    L17:
        this.head = r105;
        return;
    L24:
        return;
    L19:
        CollectionPlatformUtils r108 = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public /* synthetic */ CircularArray(int r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 8;
    L5:
        this(r100);
    }
}
