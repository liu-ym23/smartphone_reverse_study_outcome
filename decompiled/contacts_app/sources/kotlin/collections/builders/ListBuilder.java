package kotlin.collections.builders;

import androidx.exifinterface.media.ExifInterface;
import com.android.common.speech.LoggingEvents;
import com.bytedance.apm.constant.PerfConsts;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;

/* JADX INFO: compiled from: ListBuilder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u0000 X*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\u00060\u0006j\u0002`\u0007:\u0002XYB\u0007\b\u0016¢\u0006\u0002\u0010\bB\u000f\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bBM\b\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000¢\u0006\u0002\u0010\u0014J\u0015\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\u001d\u0010\u001b\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010 J\u001e\u0010!\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\u0016\u0010!\u001a\u00020\u00112\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J&\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#2\u0006\u0010&\u001a\u00020\nH\u0002J\u001d\u0010'\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010 J\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000)J\b\u0010*\u001a\u00020\u001eH\u0002J\b\u0010+\u001a\u00020\u001eH\u0002J\b\u0010,\u001a\u00020\u001eH\u0016J\u0014\u0010-\u001a\u00020\u00112\n\u0010.\u001a\u0006\u0012\u0002\b\u00030)H\u0002J\u0010\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\nH\u0002J\u0010\u00101\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\nH\u0002J\u0013\u00102\u001a\u00020\u00112\b\u0010.\u001a\u0004\u0018\u000103H\u0096\u0002J\u0016\u00104\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\nH\u0096\u0002¢\u0006\u0002\u00105J\b\u00106\u001a\u00020\nH\u0016J\u0015\u00107\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00108J\u0018\u00109\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\nH\u0002J\b\u0010:\u001a\u00020\u0011H\u0016J\u000f\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000<H\u0096\u0002J\u0015\u0010=\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00108J\u000e\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00000?H\u0016J\u0016\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00000?2\u0006\u0010\u001f\u001a\u00020\nH\u0016J\b\u0010@\u001a\u00020\u001eH\u0002J\u0015\u0010A\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\u0016\u0010B\u001a\u00020\u00112\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\u0015\u0010C\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\nH\u0016¢\u0006\u0002\u00105J\u0015\u0010D\u001a\u00028\u00002\u0006\u0010%\u001a\u00020\nH\u0002¢\u0006\u0002\u00105J\u0018\u0010E\u001a\u00020\u001e2\u0006\u0010F\u001a\u00020\n2\u0006\u0010G\u001a\u00020\nH\u0002J\u0016\u0010H\u001a\u00020\u00112\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J.\u0010I\u001a\u00020\n2\u0006\u0010F\u001a\u00020\n2\u0006\u0010G\u001a\u00020\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#2\u0006\u0010J\u001a\u00020\u0011H\u0002J\u001e\u0010K\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010LJ\u001e\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010N\u001a\u00020\n2\u0006\u0010O\u001a\u00020\nH\u0016J\u0015\u0010P\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001030\rH\u0016¢\u0006\u0002\u0010QJ'\u0010P\u001a\b\u0012\u0004\u0012\u0002HR0\r\"\u0004\b\u0001\u0010R2\f\u0010S\u001a\b\u0012\u0004\u0012\u0002HR0\rH\u0016¢\u0006\u0002\u0010TJ\b\u0010U\u001a\u00020VH\u0016J\b\u0010W\u001a\u000203H\u0002R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006Z"}, d2 = {"Lkotlin/collections/builders/ListBuilder;", ExifInterface.LONGITUDE_EAST, "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/AbstractMutableList;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "initialCapacity", "", "(I)V", "array", "", "offset", LoggingEvents.VoiceIme.EXTRA_TEXT_MODIFIED_LENGTH, "isReadOnly", "", "backing", "root", "([Ljava/lang/Object;IIZLkotlin/collections/builders/ListBuilder;Lkotlin/collections/builders/ListBuilder;)V", "[Ljava/lang/Object;", "isEffectivelyReadOnly", "()Z", PerfConsts.PERF_DISK_FILE_SIZE, "getSize", "()I", "add", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "addAllInternal", "i", "n", "addAtInternal", "build", "", "checkForComodification", "checkIsMutable", "clear", "contentEquals", "other", "ensureCapacityInternal", "minCapacity", "ensureExtraCapacity", "equals", "", "get", "(I)Ljava/lang/Object;", "hashCode", "indexOf", "(Ljava/lang/Object;)I", "insertAtInternal", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "registerModification", "remove", "removeAll", "removeAt", "removeAtInternal", "removeRangeInternal", "rangeOffset", "rangeLength", "retainAll", "retainOrRemoveAllInternal", "retain", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "toArray", "()[Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, "destination", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "writeReplace", "Companion", "Itr", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ListBuilder<E> extends AbstractMutableList<E> implements List<E>, RandomAccess, Serializable, KMutableList {
    private static final Companion Companion = null;
    private static final ListBuilder Empty = null;
    private E[] array;
    private final ListBuilder<E> backing;
    private boolean isReadOnly;
    private int length;
    private int offset;
    private final ListBuilder<E> root;

    /* JADX INFO: compiled from: ListBuilder.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkotlin/collections/builders/ListBuilder$Companion;", "", "()V", "Empty", "Lkotlin/collections/builders/ListBuilder;", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: ListBuilder.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\b\u0016\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000bH\u0002J\t\u0010\u000f\u001a\u00020\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u000e\u0010\u0012\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\r\u0010\u0015\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0013J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016J\u0015\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lkotlin/collections/builders/ListBuilder$Itr;", ExifInterface.LONGITUDE_EAST, "", "list", "Lkotlin/collections/builders/ListBuilder;", "index", "", "(Lkotlin/collections/builders/ListBuilder;I)V", "expectedModCount", "lastIndex", "add", "", "element", "(Ljava/lang/Object;)V", "checkForComodification", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "previous", "previousIndex", "remove", "set", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class Itr<E> implements ListIterator<E>, KMutableListIterator {
        private int expectedModCount;
        private int index;
        private int lastIndex;
        private final ListBuilder<E> list;

        public Itr(ListBuilder<E> r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "list");
            this.list = r2;
            this.index = r3;
            this.lastIndex = -1;
            this.expectedModCount = ListBuilder.m1270access$getModCount$p$s2084097795(r2);
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            if (this.index <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            if (this.index >= ListBuilder.access$getLength$p(this.list)) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.index - 1;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.index;
        }

        @Override // java.util.ListIterator
        public E previous() {
            checkForComodification();
            int r0 = this.index;
            if (r0 <= 0) goto L7;
            int r1 = r0 - 1;
            this.index = r1;
            this.lastIndex = r1;
            return (E) ListBuilder.access$getArray$p(this.list)[ListBuilder.access$getOffset$p(this.list) + this.lastIndex];
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            checkForComodification();
            if (this.index >= ListBuilder.access$getLength$p(this.list)) goto L7;
            int r0 = this.index;
            this.index = r0 + 1;
            this.lastIndex = r0;
            return (E) ListBuilder.access$getArray$p(this.list)[ListBuilder.access$getOffset$p(this.list) + this.lastIndex];
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public void set(E r3) {
            checkForComodification();
            int r0 = this.lastIndex;
            if (r0 == (-1)) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L10;
            this.list.set(r0, r3);
            return;
        L10:
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
        L5:
            r1 = false;
            goto L6
        }

        @Override // java.util.ListIterator
        public void add(E r4) {
            checkForComodification();
            ListBuilder<E> r0 = this.list;
            int r1 = this.index;
            this.index = r1 + 1;
            r0.add(r1, r4);
            this.lastIndex = -1;
            this.expectedModCount = ListBuilder.m1270access$getModCount$p$s2084097795(this.list);
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            checkForComodification();
            int r0 = this.lastIndex;
            if (r0 == (-1)) goto L5;
            boolean r2 = true;
        L6:
            if (r2 == false) goto L10;
            this.list.remove(r0);
            this.index = this.lastIndex;
            this.lastIndex = -1;
            this.expectedModCount = ListBuilder.m1270access$getModCount$p$s2084097795(this.list);
            return;
        L10:
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
        L5:
            r2 = false;
            goto L6
        }

        private final void checkForComodification() {
            if (ListBuilder.m1270access$getModCount$p$s2084097795(this.list) != this.expectedModCount) goto L6;
            return;
        L6:
            throw new ConcurrentModificationException();
        }
    }

    public static final /* synthetic */ Object[] access$getArray$p(ListBuilder r0) {
        return r0.array;
    }

    public static final /* synthetic */ int access$getLength$p(ListBuilder r0) {
        return r0.length;
    }

    /* JADX INFO: renamed from: access$getModCount$p$s-2084097795, reason: not valid java name */
    public static final /* synthetic */ int m1270access$getModCount$p$s2084097795(ListBuilder r0) {
        return r0.modCount;
    }

    public static final /* synthetic */ int access$getOffset$p(ListBuilder r0) {
        return r0.offset;
    }

    private ListBuilder(E[] r1, int r2, int r3, boolean r4, ListBuilder<E> r5, ListBuilder<E> r6) {
        this.array = r1;
        this.offset = r2;
        this.length = r3;
        this.isReadOnly = r4;
        this.backing = r5;
        this.root = r6;
        if (r5 == null) goto L6;
        this.modCount = r5.modCount;
        return;
    }

    static {
        Companion = new Companion(null);
        ListBuilder r0 = new ListBuilder(0);
        r0.isReadOnly = true;
        Empty = r0;
    }

    public ListBuilder() {
        this(10);
    }

    public ListBuilder(int r8) {
        this(ListBuilderKt.arrayOfUninitializedElements(r8), 0, 0, false, null, null);
    }

    public final List<E> build() {
        if (this.backing != null) goto L11;
        checkIsMutable();
        this.isReadOnly = true;
        if (this.length > 0) goto L9;
        ListBuilder<E> this = Empty;
    L9:
        return this;
    L11:
        throw new IllegalStateException();
    }

    private final Object writeReplace() {
        if (isEffectivelyReadOnly() == false) goto L7;
        return new SerializedCollection(this, 0);
    L7:
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        checkForComodification();
        return this.length;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        checkForComodification();
        if (this.length != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int r3) {
        checkForComodification();
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(r3, this.length);
        return this.array[this.offset + r3];
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public E set(int r3, E r4) {
        checkIsMutable();
        checkForComodification();
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(r3, this.length);
        E[] r0 = this.array;
        int r2 = this.offset;
        E r1 = r0[r2 + r3];
        r0[r2 + r3] = r4;
        return r1;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object r4) {
        checkForComodification();
        int r0 = 0;
    L4:
        if (r0 >= this.length) goto L9;
        if (Intrinsics.areEqual(this.array[this.offset + r0], r4) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L9:
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object r4) {
        checkForComodification();
        int r0 = this.length - 1;
    L3:
        if (r0 < 0) goto L8;
        if (Intrinsics.areEqual(this.array[this.offset + r0], r4) == true) goto L6;
        r0 = r0 - 1;
        goto L3
    L6:
        return r0;
    L8:
        return -1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int r3) {
        checkForComodification();
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(r3, this.length);
        return new Itr(this, r3);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E r3) {
        checkIsMutable();
        checkForComodification();
        addAtInternal(this.offset + this.length, r3);
        return true;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int r3, E r4) {
        checkIsMutable();
        checkForComodification();
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(r3, this.length);
        addAtInternal(this.offset + r3, r4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> r4) {
        Intrinsics.checkNotNullParameter(r4, "elements");
        checkIsMutable();
        checkForComodification();
        int r0 = r4.size();
        addAllInternal(this.offset + this.length, r4, r0);
        if (r0 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int r3, Collection<? extends E> r4) {
        Intrinsics.checkNotNullParameter(r4, "elements");
        checkIsMutable();
        checkForComodification();
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(r3, this.length);
        int r0 = r4.size();
        addAllInternal(this.offset + r3, r4, r0);
        if (r0 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        checkIsMutable();
        checkForComodification();
        removeRangeInternal(this.offset, this.length);
    }

    @Override // kotlin.collections.AbstractMutableList
    public E removeAt(int r3) {
        checkIsMutable();
        checkForComodification();
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(r3, this.length);
        return removeAtInternal(this.offset + r3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object r1) {
        checkIsMutable();
        checkForComodification();
        int r2 = indexOf(r1);
        if (r2 < 0) goto L5;
        remove(r2);
    L5:
        if (r2 < 0) goto L7;
        return true;
    L7:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r4, "elements");
        checkIsMutable();
        checkForComodification();
        if (retainOrRemoveAllInternal(this.offset, this.length, r4, false) <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r4, "elements");
        checkIsMutable();
        checkForComodification();
        if (retainOrRemoveAllInternal(this.offset, this.length, r4, true) > 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public List<E> subList(int r10, int r11) {
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(r10, r11, this.length);
        E[] r3 = this.array;
        int r4 = this.offset + r10;
        int r5 = r11 - r10;
        boolean r6 = this.isReadOnly;
        ListBuilder<E> r12 = this.root;
        if (r12 != null) goto L5;
        ListBuilder<E> r8 = this;
    L7:
        return new ListBuilder(r3, r4, r5, r6, this, r8);
    L5:
        r8 = r12;
        goto L7
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] r5) {
        Intrinsics.checkNotNullParameter(r5, "destination");
        checkForComodification();
        int r0 = r5.length;
        int r1 = this.length;
        if (r0 >= r1) goto L6;
        E[] r2 = this.array;
        int r4 = this.offset;
        T[] r6 = (T[]) Arrays.copyOfRange(r2, r4, r1 + r4, r5.getClass());
        Intrinsics.checkNotNullExpressionValue(r6, "copyOfRange(...)");
        return r6;
    L6:
        E[] r3 = this.array;
        int r7 = this.offset;
        ArraysKt.copyInto(r3, r5, 0, r7, r1 + r7);
        return (T[]) CollectionsKt.terminateCollectionToArray(this.length, r5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        checkForComodification();
        E[] r0 = this.array;
        int r1 = this.offset;
        return ArraysKt.copyOfRange(r0, r1, this.length + r1);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object r2) {
        checkForComodification();
        if (r2 != this) goto L5;
    L10:
        return true;
    L5:
        if ((r2 instanceof List) == true) goto L7;
    L9:
        return false;
    L7:
        if (contentEquals((List) r2) == false) goto L9;
        goto L9
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        checkForComodification();
        return ListBuilderKt.access$subarrayContentHashCode(this.array, this.offset, this.length);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        checkForComodification();
        return ListBuilderKt.access$subarrayContentToString(this.array, this.offset, this.length, this);
    }

    private final void registerModification() {
        this.modCount++;
    }

    private final void checkForComodification() {
        ListBuilder<E> r0 = this.root;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.modCount != this.modCount) goto L8;
        return;
    L8:
        throw new ConcurrentModificationException();
    }

    private final void checkIsMutable() {
        if (isEffectivelyReadOnly() == true) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    private final boolean isEffectivelyReadOnly() {
        if (this.isReadOnly == true) goto L10;
        ListBuilder<E> r1 = this.root;
        if (r1 != null) goto L7;
    L9:
        return false;
    L7:
        if (r1.isReadOnly == false) goto L9;
    L10:
        return true;
    }

    private final void ensureExtraCapacity(int r2) {
        ensureCapacityInternal(this.length + r2);
    }

    private final void ensureCapacityInternal(int r3) {
        if (r3 < 0) goto L8;
        if (r3 <= this.array.length) goto L9;
        int r4 = AbstractList.Companion.newCapacity$kotlin_stdlib(this.array.length, r3);
        this.array = (E[]) ListBuilderKt.copyOfUninitializedElements(this.array, r4);
        return;
    L9:
        return;
    L8:
        throw new OutOfMemoryError();
    }

    private final boolean contentEquals(List<?> r3) {
        return ListBuilderKt.access$subarrayContentEquals(this.array, this.offset, this.length, r3);
    }

    private final void insertAtInternal(int r4, int r5) {
        ensureExtraCapacity(r5);
        E[] r0 = this.array;
        ArraysKt.copyInto(r0, r0, r4 + r5, r4, this.offset + this.length);
        this.length += r5;
    }

    private final void addAtInternal(int r3, E r4) {
        registerModification();
        ListBuilder<E> r0 = this.backing;
        if (r0 == null) goto L5;
        r0.addAtInternal(r3, r4);
        this.array = this.backing.array;
        this.length++;
        return;
    L5:
        insertAtInternal(r3, 1);
        this.array[r3] = r4;
    }

    private final void addAllInternal(int r5, Collection<? extends E> r6, int r7) {
        registerModification();
        ListBuilder<E> r0 = this.backing;
        if (r0 == null) goto L5;
        r0.addAllInternal(r5, r6, r7);
        this.array = this.backing.array;
        this.length += r7;
        return;
    L5:
        insertAtInternal(r5, r7);
        Iterator<? extends E> r8 = r6.iterator();
        int r1 = 0;
    L6:
        if (r1 >= r7) goto L10;
        this.array[r5 + r1] = r8.next();
        r1 = r1 + 1;
        goto L6
    }

    private final E removeAtInternal(int r6) {
        registerModification();
        ListBuilder<E> r0 = this.backing;
        if (r0 == null) goto L6;
        E r7 = r0.removeAtInternal(r6);
        this.length--;
        return r7;
    L6:
        E[] r1 = this.array;
        E r2 = r1[r6];
        ArraysKt.copyInto(r1, r1, r6, r6 + 1, this.offset + this.length);
        ListBuilderKt.resetAt(this.array, (this.offset + this.length) - 1);
        this.length--;
        return r2;
    }

    private final void removeRangeInternal(int r4, int r5) {
        if (r5 <= 0) goto L4;
        registerModification();
    L4:
        ListBuilder<E> r0 = this.backing;
        if (r0 == null) goto L7;
        r0.removeRangeInternal(r4, r5);
    L8:
        this.length -= r5;
        return;
    L7:
        E[] r1 = this.array;
        ArraysKt.copyInto(r1, r1, r4, r4 + r5, this.length);
        E[] r6 = this.array;
        int r2 = this.length;
        ListBuilderKt.resetRange(r6, r2 - r5, r2);
        goto L8
    }

    private final int retainOrRemoveAllInternal(int r6, int r7, Collection<? extends E> r8, boolean r9) {
        ListBuilder<E> r0 = this.backing;
        if (r0 == null) goto L5;
        int r10 = r0.retainOrRemoveAllInternal(r6, r7, r8, r9);
    L12:
        if (r10 <= 0) goto L14;
        registerModification();
    L14:
        this.length -= r10;
        return r10;
    L5:
        int r1 = 0;
        int r2 = 0;
    L6:
        if (r1 >= r7) goto L11;
        int r3 = r6 + r1;
        if (r8.contains(this.array[r3]) == r9) goto L9;
        r1 = r1 + 1;
        goto L6
    L9:
        E[] r4 = this.array;
        r1 = r1 + 1;
        r4[r2 + r6] = r4[r3];
        r2 = r2 + 1;
        goto L6
    L11:
        int r11 = r7 - r2;
        E[] r12 = this.array;
        ArraysKt.copyInto(r12, r12, r6 + r2, r7 + r6, this.length);
        E[] r13 = this.array;
        int r14 = this.length;
        ListBuilderKt.resetRange(r13, r14 - r11, r14);
        r10 = r11;
        goto L12
    }
}
