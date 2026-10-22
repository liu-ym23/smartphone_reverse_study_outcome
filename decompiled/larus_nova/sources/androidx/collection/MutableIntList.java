package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003J\u0018\u0010\t\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003J\u0018\u0010\u000e\u001a\u00020\n2\b\b\u0001\u0010\r\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u000e\u001a\u00020\n2\b\b\u0001\u0010\r\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0001J\u0011\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0001H\u0086\bJ\u0011\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086\bJ\u0011\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0001H\u0086\nJ\u0011\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086\nJ\u0006\u0010\u0012\u001a\u00020\fJ\u0010\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\u0003J\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0003J\u0011\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0003H\u0086\nJ\u0011\u0010\u0016\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0003H\u0086\nJ\u000e\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003J\u000e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0001J\u0011\u0010\u0016\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086\u0002J\u0011\u0010\u0016\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0001H\u0086\u0002J\u0010\u0010\u0019\u001a\u00020\u00032\b\b\u0001\u0010\r\u001a\u00020\u0003J\u001a\u0010\u001a\u001a\u00020\f2\b\b\u0001\u0010\u001b\u001a\u00020\u00032\b\b\u0001\u0010\u001c\u001a\u00020\u0003J\u000e\u0010\u001d\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u001d\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0001J\u001b\u0010\u001e\u001a\u00020\u00032\b\b\u0001\u0010\r\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0086\u0002J\u0006\u0010\u001f\u001a\u00020\fJ\u0006\u0010 \u001a\u00020\fR\u0012\u0010\u0006\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006!"}, d2 = {"Landroidx/collection/MutableIntList;", "Landroidx/collection/IntList;", "initialCapacity", "", "<init>", "(I)V", "capacity", "getCapacity", "()I", "add", "", "element", "", "index", "addAll", SlcElement.KEY_ELEMENTS, "", "plusAssign", "clear", "trim", "minCapacity", "ensureCapacity", "minusAssign", "remove", "removeAll", "removeAt", "removeRange", "start", "end", "retainAll", "set", "sort", "sortDescending", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MutableIntList extends IntList {
    public MutableIntList() {
        int r100 = 0;
        this(r100, 1, null);
    }

    public final void clear() {
        this._size = 0;
    }

    public final int getCapacity() {
        return this.content.length;
    }

    public final void sort() {
        int r100 = this._size;
        if (r100 != 0) goto L5;
        return;
    L5:
        ArraysKt.sort(this.content, 0, r100);
    }

    public final void sortDescending() {
        int r100 = this._size;
        if (r100 != 0) goto L5;
        return;
    L5:
        ArraysKt.sortDescending(this.content, 0, r100);
    }

    public MutableIntList(int r100) {
        super(r100, null);
    }

    public final boolean add(int r100) {
        ensureCapacity(this._size + 1);
        int[] r101 = this.content;
        int r102 = this._size;
        r101[r102] = r100;
        this._size = r102 + 1;
        return true;
    }

    public final boolean addAll(IntList r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        return addAll(this._size, r100);
    }

    public final void ensureCapacity(int r100) {
        int[] r101 = this.content;
        if (r101.length >= r100) goto L6;
        this.content = Arrays.copyOf(r101, Math.max(r100, (r101.length * 3) / 2));
        return;
    }

    public final void minusAssign(IntList r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int[] r101 = r100.content;
        int r102 = r100._size;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        remove(r101[r103]);
        r103 = r103 + 1;
        goto L3
    }

    public final void plusAssign(IntList r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        addAll(this._size, r100);
    }

    public final boolean remove(int r100) {
        int r101 = indexOf(r100);
        if (r101 < 0) goto L6;
        removeAt(r101);
        return true;
    L6:
        return false;
    }

    public final boolean removeAll(IntList r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = this._size;
        int r102 = r100._size - 1;
        if (r102 < 0) goto L9;
        int r103 = 0;
    L5:
        remove(r100.get(r103));
        if (r103 == r102) goto L9;
        r103 = r103 + 1;
    L9:
        if (r101 != this._size) goto L14;
        return false;
    L14:
        return true;
    }

    public final int removeAt(int r100) {
        boolean r101 = false;
        if (r100 >= 0) goto L5;
    L7:
        if (r101 == true) goto L9;
        RuntimeHelpersKt.throwIndexOutOfBoundsException("Index must be between 0 and size");
    L9:
        int[] r102 = this.content;
        int r103 = r102[r100];
        int r104 = this._size;
        if (r100 == (r104 - 1)) goto L12;
        ArraysKt.copyInto(r102, r102, r100, r100 + 1, r104);
    L12:
        this._size--;
        return r103;
    L5:
        if (r100 >= this._size) goto L7;
        r101 = true;
        goto L7
    }

    public final boolean retainAll(int[] r110) {
        Intrinsics.checkNotNullParameter(r110, SlcElement.KEY_ELEMENTS);
        int r100 = this._size;
        int[] r101 = this.content;
        int r102 = r100 - 1;
    L3:
        int r103 = -1;
        if ((-1) >= r102) goto L18;
        int r104 = r101[r102];
        int r105 = r110.length;
        int r106 = 0;
    L6:
        if (r106 >= r105) goto L14;
        if (r110[r106] != r104) goto L10;
        boolean r107 = true;
    L11:
        if (r107 == true) goto L12;
        r106 = r106 + 1;
        goto L6
    L12:
        r103 = r106;
        goto L14
    L10:
        r107 = false;
    L14:
        if (r103 >= 0) goto L16;
        removeAt(r102);
    L16:
        r102 = r102 - 1;
        goto L3
    L18:
        if (r100 == this._size) goto L26;
        return true;
    L26:
        return false;
    }

    public final void trim(int r100) {
        int r101 = Math.max(r100, this._size);
        int[] r102 = this.content;
        if (r102.length <= r101) goto L6;
        this.content = Arrays.copyOf(r102, r101);
        return;
    }

    public final boolean addAll(int[] r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        return addAll(this._size, r100);
    }

    public final void minusAssign(int[] r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        remove(r100[r102]);
        r102 = r102 + 1;
        goto L3
    }

    public final void plusAssign(int[] r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        addAll(this._size, r100);
    }

    public final boolean removeAll(int[] r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = this._size;
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L6;
        remove(r100[r103]);
        r103 = r103 + 1;
        goto L3
    L6:
        if (r101 == this._size) goto L10;
        return true;
    L10:
        return false;
    }

    public final boolean retainAll(IntList r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = this._size;
        int[] r102 = this.content;
        int r103 = r101 - 1;
    L4:
        if ((-1) >= r103) goto L10;
        if (r100.contains(r102[r103]) == true) goto L8;
        removeAt(r103);
    L8:
        r103 = r103 - 1;
        goto L4
    L10:
        if (r101 == this._size) goto L12;
        return true;
    L12:
        return false;
    }

    public final void minusAssign(int r100) {
        remove(r100);
    }

    public final void plusAssign(int r100) {
        add(r100);
    }

    public final void add(int r100, int r101) {
        boolean r102 = false;
        if (r100 >= 0) goto L5;
    L7:
        if (r102 == true) goto L9;
        RuntimeHelpersKt.throwIndexOutOfBoundsException("Index must be between 0 and size");
    L9:
        ensureCapacity(this._size + 1);
        int[] r103 = this.content;
        int r104 = this._size;
        if (r100 == r104) goto L12;
        ArraysKt.copyInto(r103, r103, r100 + 1, r100, r104);
    L12:
        r103[r100] = r101;
        this._size++;
        return;
    L5:
        if (r100 > this._size) goto L7;
        r102 = true;
        goto L7
    }

    public final boolean addAll(int r110, int[] r111) {
        Intrinsics.checkNotNullParameter(r111, SlcElement.KEY_ELEMENTS);
        if (r110 >= 0) goto L5;
    L7:
        boolean r100 = false;
    L8:
        if (r100 == true) goto L11;
        RuntimeHelpersKt.throwIndexOutOfBoundsException("");
    L11:
        if (r111.length != 0) goto L13;
        boolean r101 = true;
    L14:
        if (r101 == false) goto L16;
        return false;
    L16:
        ensureCapacity(this._size + r111.length);
        int[] r102 = this.content;
        int r103 = this._size;
        if (r110 == r103) goto L19;
        ArraysKt.copyInto(r102, r102, r111.length + r110, r110, r103);
    L19:
        ArraysKt.copyInto$default(r111, r102, r110, 0, 0, 12, null);
        this._size += r111.length;
        return true;
    L13:
        r101 = false;
        goto L14
    L5:
        if (r110 > this._size) goto L7;
        r100 = true;
        goto L8
    }

    public final void removeRange(int r100, int r101) {
        boolean r102 = true;
        if (r100 >= 0) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L15;
        if (r101 >= 0) goto L11;
    L13:
        r102 = false;
    L14:
        if (r102 == false) goto L15;
    L16:
        if (r101 >= r100) goto L18;
        RuntimeHelpersKt.throwIllegalArgumentException("The end index must be < start index");
    L18:
        if (r101 == r100) goto L24;
        int r104 = this._size;
        if (r101 >= r104) goto L22;
        int[] r105 = this.content;
        ArraysKt.copyInto(r105, r105, r100, r101, r104);
    L22:
        this._size -= r101 - r100;
        return;
    L24:
        return;
    L11:
        if (r101 > this._size) goto L13;
    L15:
        RuntimeHelpersKt.throwIndexOutOfBoundsException("Index must be between 0 and size");
        goto L16
    L5:
        if (r100 > this._size) goto L7;
        r103 = true;
        goto L8
    }

    public final int set(int r100, int r101) {
        boolean r102 = false;
        if (r100 >= 0) goto L5;
    L7:
        if (r102 == true) goto L9;
        RuntimeHelpersKt.throwIndexOutOfBoundsException("Index must be between 0 and size");
    L9:
        int[] r103 = this.content;
        int r104 = r103[r100];
        r103[r100] = r101;
        return r104;
    L5:
        if (r100 >= this._size) goto L7;
        r102 = true;
        goto L7
    }

    public final boolean addAll(int r100, IntList r101) {
        Intrinsics.checkNotNullParameter(r101, SlcElement.KEY_ELEMENTS);
        if (r100 >= 0) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L10;
        RuntimeHelpersKt.throwIndexOutOfBoundsException("");
    L10:
        int r103 = r101._size;
        if (r103 != 0) goto L13;
        boolean r104 = true;
    L14:
        if (r104 == false) goto L16;
        return false;
    L16:
        ensureCapacity(this._size + r103);
        int[] r105 = this.content;
        int r106 = this._size;
        if (r100 == r106) goto L19;
        ArraysKt.copyInto(r105, r105, r101._size + r100, r100, r106);
    L19:
        ArraysKt.copyInto(r101.content, r105, r100, 0, r101._size);
        this._size += r101._size;
        return true;
    L13:
        r104 = false;
        goto L14
    L5:
        if (r100 > this._size) goto L7;
        r102 = true;
        goto L8
    }

    public /* synthetic */ MutableIntList(int r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 16;
    L5:
        this(r100);
    }

    public static /* synthetic */ void trim$default(MutableIntList r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = r100._size;
    L5:
        r100.trim(r101);
    }
}
