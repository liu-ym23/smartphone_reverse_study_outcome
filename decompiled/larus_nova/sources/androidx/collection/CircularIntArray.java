package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0003J\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0003J\u0006\u0010\u0010\u001a\u00020\u0003J\u0006\u0010\u0011\u001a\u00020\u0003J\u0006\u0010\u0012\u001a\u00020\fJ\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0003J\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0003J\u0011\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0003H\u0086\u0002J\u0006\u0010\u001d\u001a\u00020\u0003J\u0006\u0010\u001e\u001a\u00020\u001fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018¨\u0006 "}, d2 = {"Landroidx/collection/CircularIntArray;", "", "minCapacity", "", "<init>", "(I)V", SlcElement.KEY_ELEMENTS, "", "head", "tail", "capacityBitmask", "doubleCapacity", "", "addFirst", "element", "addLast", "popFirst", "popLast", "clear", "removeFromStart", "count", "removeFromEnd", SoloKtvContext.SOLO_PAGE_FIRST, "getFirst", "()I", "last", "getLast", MonitorConstants.CONNECT_TYPE_GET, "index", "size", "isEmpty", "", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CircularIntArray {
    private int capacityBitmask;
    private int[] elements;
    private int head;
    private int tail;

    public CircularIntArray() {
        int r100 = 0;
        this(r100, 1, null);
    }

    private final void doubleCapacity() {
        int[] r100 = this.elements;
        int r101 = r100.length;
        int r102 = this.head;
        int r103 = r101 - r102;
        int r104 = r101 << 1;
        if (r104 < 0) goto L7;
        int[] r105 = new int[r104];
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

    public final void clear() {
        this.tail = this.head;
    }

    public final int getFirst() {
        int r100 = this.head;
        if (r100 != this.tail) goto L5;
        CollectionPlatformUtils r101 = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    L5:
        return this.elements[r100];
    }

    public final int getLast() {
        int r100 = this.head;
        int r101 = this.tail;
        if (r100 != r101) goto L5;
        CollectionPlatformUtils r102 = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    L5:
        return this.elements[(r101 - 1) & this.capacityBitmask];
    }

    public final boolean isEmpty() {
        if (this.head != this.tail) goto L5;
        return true;
    L5:
        return false;
    }

    public final int popFirst() {
        int r100 = this.head;
        if (r100 == this.tail) goto L6;
        int r101 = this.elements[r100];
        this.head = (r100 + 1) & this.capacityBitmask;
        return r101;
    L6:
        CollectionPlatformUtils r102 = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final int popLast() {
        int r100 = this.head;
        int r101 = this.tail;
        if (r100 == r101) goto L6;
        int r102 = this.capacityBitmask & (r101 - 1);
        int r103 = this.elements[r102];
        this.tail = r102;
        return r103;
    L6:
        CollectionPlatformUtils r104 = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final int size() {
        return (this.tail - this.head) & this.capacityBitmask;
    }

    public CircularIntArray(int r100) {
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
        this.elements = new int[r100];
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void addFirst(int r100) {
        int r101 = (this.head - 1) & this.capacityBitmask;
        this.head = r101;
        this.elements[r101] = r100;
        if (r101 != this.tail) goto L6;
        doubleCapacity();
        return;
    }

    public final void addLast(int r100) {
        int[] r101 = this.elements;
        int r102 = this.tail;
        r101[r102] = r100;
        int r103 = this.capacityBitmask;
        int r104 = r103 & (r102 + 1);
        this.tail = r104;
        if (r104 != this.head) goto L6;
        doubleCapacity();
        return;
    }

    public final int get(int r100) {
        if (r100 >= 0) goto L4;
    L7:
        CollectionPlatformUtils r101 = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    L4:
        if (r100 >= size()) goto L7;
        int[] r102 = this.elements;
        int r103 = this.head + r100;
        return r102[this.capacityBitmask & r103];
    }

    public final void removeFromEnd(int r100) {
        if (r100 > 0) goto L5;
        return;
    L5:
        if (r100 > size()) goto L8;
        int r101 = this.tail - r100;
        this.tail = this.capacityBitmask & r101;
        return;
    L8:
        CollectionPlatformUtils r102 = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final void removeFromStart(int r100) {
        if (r100 > 0) goto L5;
        return;
    L5:
        if (r100 > size()) goto L8;
        int r101 = this.head + r100;
        this.head = this.capacityBitmask & r101;
        return;
    L8:
        CollectionPlatformUtils r102 = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public /* synthetic */ CircularIntArray(int r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 8;
    L5:
        this(r100);
    }
}
