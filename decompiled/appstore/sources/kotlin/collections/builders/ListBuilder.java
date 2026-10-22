package kotlin.collections.builders;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.tmall.wireless.tangram.structure.card.SlideCard;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.m;
import kotlin.collections.s;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u001e\n\u0002\b\u0016\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0019\n\u0002\u0010\u000e\n\u0002\b\r\b\u0000\u0018\u0000 i*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\u00060\u0006j\u0002`\u0007:\u0002jkBO\b\u0002\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000¢\u0006\u0004\b\u0011\u0010\u0012B\t\b\u0016¢\u0006\u0004\b\u0011\u0010\u0013B\u0011\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u0013J\u000f\u0010\u001b\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u0013J\u000f\u0010\u001c\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u0013J\u0017\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001e\u0010\u0015J\u0017\u0010 \u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\nH\u0002¢\u0006\u0004\b \u0010\u0015J\u001b\u0010#\u001a\u00020\r2\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030!H\u0002¢\u0006\u0004\b#\u0010$J\u001f\u0010&\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\u0002¢\u0006\u0004\b&\u0010'J\u001f\u0010)\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\n2\u0006\u0010(\u001a\u00028\u0000H\u0002¢\u0006\u0004\b)\u0010*J-\u0010-\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\n2\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000+2\u0006\u0010\u001d\u001a\u00020\nH\u0002¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00028\u00002\u0006\u0010%\u001a\u00020\nH\u0002¢\u0006\u0004\b/\u00100J\u001f\u00103\u001a\u00020\u00192\u0006\u00101\u001a\u00020\n2\u0006\u00102\u001a\u00020\nH\u0002¢\u0006\u0004\b3\u0010'J5\u00105\u001a\u00020\n2\u0006\u00101\u001a\u00020\n2\u0006\u00102\u001a\u00020\n2\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000+2\u0006\u00104\u001a\u00020\rH\u0002¢\u0006\u0004\b5\u00106J\u0013\u00107\u001a\b\u0012\u0004\u0012\u00028\u00000!¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\rH\u0016¢\u0006\u0004\b9\u0010:J\u0018\u0010<\u001a\u00028\u00002\u0006\u0010;\u001a\u00020\nH\u0096\u0002¢\u0006\u0004\b<\u00100J \u0010=\u001a\u00028\u00002\u0006\u0010;\u001a\u00020\n2\u0006\u0010(\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u00020\n2\u0006\u0010(\u001a\u00028\u0000H\u0016¢\u0006\u0004\b?\u0010@J\u0017\u0010A\u001a\u00020\n2\u0006\u0010(\u001a\u00028\u0000H\u0016¢\u0006\u0004\bA\u0010@J\u0016\u0010C\u001a\b\u0012\u0004\u0012\u00028\u00000BH\u0096\u0002¢\u0006\u0004\bC\u0010DJ\u0015\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000EH\u0016¢\u0006\u0004\bF\u0010GJ\u001d\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000E2\u0006\u0010;\u001a\u00020\nH\u0016¢\u0006\u0004\bF\u0010HJ\u0017\u0010I\u001a\u00020\r2\u0006\u0010(\u001a\u00028\u0000H\u0016¢\u0006\u0004\bI\u0010JJ\u001f\u0010I\u001a\u00020\u00192\u0006\u0010;\u001a\u00020\n2\u0006\u0010(\u001a\u00028\u0000H\u0016¢\u0006\u0004\bI\u0010*J\u001d\u0010K\u001a\u00020\r2\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000+H\u0016¢\u0006\u0004\bK\u0010LJ%\u0010K\u001a\u00020\r2\u0006\u0010;\u001a\u00020\n2\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000+H\u0016¢\u0006\u0004\bK\u0010MJ\u000f\u0010N\u001a\u00020\u0019H\u0016¢\u0006\u0004\bN\u0010\u0013J\u0017\u0010O\u001a\u00028\u00002\u0006\u0010;\u001a\u00020\nH\u0016¢\u0006\u0004\bO\u00100J\u0017\u0010P\u001a\u00020\r2\u0006\u0010(\u001a\u00028\u0000H\u0016¢\u0006\u0004\bP\u0010JJ\u001d\u0010Q\u001a\u00020\r2\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000+H\u0016¢\u0006\u0004\bQ\u0010LJ\u001d\u0010R\u001a\u00020\r2\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000+H\u0016¢\u0006\u0004\bR\u0010LJ%\u0010U\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010S\u001a\u00020\n2\u0006\u0010T\u001a\u00020\nH\u0016¢\u0006\u0004\bU\u0010VJ)\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00010\b\"\u0004\b\u0001\u0010W2\f\u0010X\u001a\b\u0012\u0004\u0012\u00028\u00010\bH\u0016¢\u0006\u0004\bY\u0010ZJ\u0017\u0010Y\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\bH\u0016¢\u0006\u0004\bY\u0010[J\u001a\u0010\\\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010\u0016H\u0096\u0002¢\u0006\u0004\b\\\u0010JJ\u000f\u0010]\u001a\u00020\nH\u0016¢\u0006\u0004\b]\u0010^J\u000f\u0010`\u001a\u00020_H\u0016¢\u0006\u0004\b`\u0010aR\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010bR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010cR\u0016\u0010\f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010cR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010dR\u001c\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010eR\u001c\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010eR\u0014\u0010f\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bf\u0010:R\u0014\u0010h\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bg\u0010^¨\u0006l"}, d2 = {"Lkotlin/collections/builders/ListBuilder;", "E", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/e;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "array", "", "offset", "length", "", "isReadOnly", "backing", "root", "<init>", "([Ljava/lang/Object;IIZLkotlin/collections/builders/ListBuilder;Lkotlin/collections/builders/ListBuilder;)V", "()V", "initialCapacity", "(I)V", "", "writeReplace", "()Ljava/lang/Object;", "", "registerModification", "checkForComodification", "checkIsMutable", "n", "ensureExtraCapacity", "minCapacity", "ensureCapacityInternal", "", AppInfo.SEARCH_SOURCE_EXTENAL, "contentEquals", "(Ljava/util/List;)Z", "i", "insertAtInternal", "(II)V", "element", "addAtInternal", "(ILjava/lang/Object;)V", "", "elements", "addAllInternal", "(ILjava/util/Collection;I)V", "removeAtInternal", "(I)Ljava/lang/Object;", "rangeOffset", "rangeLength", "removeRangeInternal", "retain", "retainOrRemoveAllInternal", "(IILjava/util/Collection;Z)I", "build", "()Ljava/util/List;", "isEmpty", "()Z", SlideCard.KEY_INDEX, "get", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "", "iterator", "()Ljava/util/Iterator;", "", "listIterator", "()Ljava/util/ListIterator;", "(I)Ljava/util/ListIterator;", "add", "(Ljava/lang/Object;)Z", "addAll", "(Ljava/util/Collection;)Z", "(ILjava/util/Collection;)Z", "clear", "removeAt", "remove", "removeAll", "retainAll", "fromIndex", "toIndex", "subList", "(II)Ljava/util/List;", "T", "destination", "toArray", "([Ljava/lang/Object;)[Ljava/lang/Object;", "()[Ljava/lang/Object;", "equals", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "[Ljava/lang/Object;", "I", "Z", "Lkotlin/collections/builders/ListBuilder;", "isEffectivelyReadOnly", "getSize", "size", "Companion", "a", "b", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nListBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListBuilder.kt\nkotlin/collections/builders/ListBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,487:1\n1#2:488\n*E\n"})
public final class ListBuilder<E> extends kotlin.collections.e implements List<E>, RandomAccess, Serializable, KMutableList {

    @NotNull
    private static final a Companion = null;

    @NotNull
    private static final ListBuilder Empty = null;

    @NotNull
    private E[] array;

    @Nullable
    private final ListBuilder<E> backing;
    private boolean isReadOnly;
    private int length;
    private int offset;

    @Nullable
    private final ListBuilder<E> root;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public static final class b implements ListIterator, KMutableListIterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ListBuilder f21076a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f21077b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f21078c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f21079d;

        public b(ListBuilder r10, int r11) {
            q.g(r10, ServerElements.LIST);
            this.f21076a = r10;
            this.f21077b = r11;
            this.f21078c = -1;
            this.f21079d = ListBuilder.m45access$getModCount$p$s2084097795(r10);
        }

        public final void a() {
            if (ListBuilder.m45access$getModCount$p$s2084097795(this.f21076a) != this.f21079d) goto L6;
            return;
        L6:
            throw new ConcurrentModificationException();
        }

        @Override // java.util.ListIterator
        public void add(Object r10) {
            a();
            ListBuilder r11 = this.f21076a;
            int r12 = this.f21077b;
            this.f21077b = r12 + 1;
            r11.add(r12, r10);
            this.f21078c = -1;
            this.f21079d = ListBuilder.m45access$getModCount$p$s2084097795(this.f21076a);
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            if (this.f21077b >= ListBuilder.access$getLength$p(this.f21076a)) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            if (this.f21077b <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public Object next() {
            a();
            if (this.f21077b >= ListBuilder.access$getLength$p(this.f21076a)) goto L7;
            int r10 = this.f21077b;
            this.f21077b = r10 + 1;
            this.f21078c = r10;
            return ListBuilder.access$getArray$p(this.f21076a)[ListBuilder.access$getOffset$p(this.f21076a) + this.f21078c];
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f21077b;
        }

        @Override // java.util.ListIterator
        public Object previous() {
            a();
            int r10 = this.f21077b;
            if (r10 <= 0) goto L7;
            int r11 = r10 - 1;
            this.f21077b = r11;
            this.f21078c = r11;
            return ListBuilder.access$getArray$p(this.f21076a)[ListBuilder.access$getOffset$p(this.f21076a) + this.f21078c];
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f21077b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            a();
            int r10 = this.f21078c;
            if (r10 == (-1)) goto L7;
            this.f21076a.remove(r10);
            this.f21077b = this.f21078c;
            this.f21078c = -1;
            this.f21079d = ListBuilder.m45access$getModCount$p$s2084097795(this.f21076a);
            return;
        L7:
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
        }

        @Override // java.util.ListIterator
        public void set(Object r10) {
            a();
            int r11 = this.f21078c;
            if (r11 == (-1)) goto L7;
            this.f21076a.set(r11, r10);
            return;
        L7:
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
        }
    }

    static {
        Companion = new a(null);
        ListBuilder r10 = new ListBuilder(0);
        r10.isReadOnly = true;
        Empty = r10;
    }

    private ListBuilder(E[] r10, int r11, int r12, boolean r13, ListBuilder<E> r14, ListBuilder<E> r15) {
        this.array = r10;
        this.offset = r11;
        this.length = r12;
        this.isReadOnly = r13;
        this.backing = r14;
        this.root = r15;
        if (r14 == null) goto L6;
        ((AbstractList) this).modCount = ((AbstractList) r14).modCount;
        return;
    }

    public static final /* synthetic */ Object[] access$getArray$p(ListBuilder r10) {
        return r10.array;
    }

    public static final /* synthetic */ int access$getLength$p(ListBuilder r10) {
        return r10.length;
    }

    /* JADX INFO: renamed from: access$getModCount$p$s-2084097795, reason: not valid java name */
    public static final /* synthetic */ int m45access$getModCount$p$s2084097795(ListBuilder r10) {
        return ((AbstractList) r10).modCount;
    }

    public static final /* synthetic */ int access$getOffset$p(ListBuilder r10) {
        return r10.offset;
    }

    private final void addAllInternal(int r10, Collection<? extends E> r11, int r12) {
        registerModification();
        ListBuilder<E> r13 = this.backing;
        if (r13 == null) goto L5;
        r13.addAllInternal(r10, r11, r12);
        this.array = this.backing.array;
        this.length += r12;
        return;
    L5:
        insertAtInternal(r10, r12);
        Iterator<? extends E> r14 = r11.iterator();
        int r15 = 0;
    L6:
        if (r15 >= r12) goto L10;
        this.array[r10 + r15] = r14.next();
        r15 = r15 + 1;
        goto L6
    }

    private final void addAtInternal(int r10, E r11) {
        registerModification();
        ListBuilder<E> r12 = this.backing;
        if (r12 == null) goto L5;
        r12.addAtInternal(r10, r11);
        this.array = this.backing.array;
        this.length++;
        return;
    L5:
        insertAtInternal(r10, 1);
        this.array[r10] = r11;
    }

    private final void checkForComodification() {
        ListBuilder<E> r10 = this.root;
        if (r10 != null) goto L5;
        return;
    L5:
        if (((AbstractList) r10).modCount != ((AbstractList) this).modCount) goto L8;
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

    private final boolean contentEquals(List<?> r10) {
        return kotlin.collections.builders.b.a(this.array, this.offset, this.length, r10);
    }

    private final void ensureCapacityInternal(int r10) {
        if (r10 < 0) goto L8;
        E[] r11 = this.array;
        if (r10 <= r11.length) goto L9;
        int r12 = kotlin.collections.b.Companion.d(r11.length, r10);
        this.array = (E[]) kotlin.collections.builders.b.e(this.array, r12);
        return;
    L9:
        return;
    L8:
        throw new OutOfMemoryError();
    }

    private final void ensureExtraCapacity(int r10) {
        ensureCapacityInternal(this.length + r10);
    }

    private final void insertAtInternal(int r10, int r11) {
        ensureExtraCapacity(r11);
        E[] r12 = this.array;
        m.e(r12, r12, r10 + r11, r10, this.offset + this.length);
        this.length += r11;
    }

    private final boolean isEffectivelyReadOnly() {
        if (this.isReadOnly == true) goto L10;
        ListBuilder<E> r10 = this.root;
        if (r10 != null) goto L7;
    L9:
        return false;
    L7:
        if (r10.isReadOnly == false) goto L9;
    L10:
        return true;
    }

    private final void registerModification() {
        ((AbstractList) this).modCount++;
    }

    private final E removeAtInternal(int r10) {
        registerModification();
        ListBuilder<E> r11 = this.backing;
        if (r11 == null) goto L6;
        E r12 = r11.removeAtInternal(r10);
        this.length--;
        return r12;
    L6:
        E[] r13 = this.array;
        E r14 = r13[r10];
        m.e(r13, r13, r10, r10 + 1, this.offset + this.length);
        kotlin.collections.builders.b.f(this.array, (this.offset + this.length) - 1);
        this.length--;
        return r14;
    }

    private final void removeRangeInternal(int r10, int r11) {
        if (r11 <= 0) goto L4;
        registerModification();
    L4:
        ListBuilder<E> r12 = this.backing;
        if (r12 == null) goto L7;
        r12.removeRangeInternal(r10, r11);
    L8:
        this.length -= r11;
        return;
    L7:
        E[] r13 = this.array;
        m.e(r13, r13, r10, r10 + r11, this.length);
        E[] r14 = this.array;
        int r15 = this.length;
        kotlin.collections.builders.b.g(r14, r15 - r11, r15);
        goto L8
    }

    private final int retainOrRemoveAllInternal(int r10, int r11, Collection<? extends E> r12, boolean r13) {
        ListBuilder<E> r14 = this.backing;
        if (r14 == null) goto L5;
        int r15 = r14.retainOrRemoveAllInternal(r10, r11, r12, r13);
    L12:
        if (r15 <= 0) goto L14;
        registerModification();
    L14:
        this.length -= r15;
        return r15;
    L5:
        int r16 = 0;
        int r17 = 0;
    L6:
        if (r16 >= r11) goto L11;
        int r18 = r10 + r16;
        if (r12.contains(this.array[r18]) == r13) goto L9;
        r16 = r16 + 1;
        goto L6
    L9:
        E[] r19 = this.array;
        r16 = r16 + 1;
        r19[r17 + r10] = r19[r18];
        r17 = r17 + 1;
        goto L6
    L11:
        int r20 = r11 - r17;
        E[] r21 = this.array;
        m.e(r21, r21, r10 + r17, r11 + r10, this.length);
        E[] r22 = this.array;
        int r23 = this.length;
        kotlin.collections.builders.b.g(r22, r23 - r20, r23);
        r15 = r20;
        goto L12
    }

    private final Object writeReplace() {
        if (isEffectivelyReadOnly() == false) goto L7;
        return new SerializedCollection(this, 0);
    L7:
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E r10) {
        checkIsMutable();
        checkForComodification();
        addAtInternal(this.offset + this.length, r10);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(@NotNull Collection<? extends E> r10) {
        q.g(r10, "elements");
        checkIsMutable();
        checkForComodification();
        int r11 = r10.size();
        addAllInternal(this.offset + this.length, r10, r11);
        if (r11 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @NotNull
    public final List<E> build() {
        if (this.backing != null) goto L10;
        checkIsMutable();
        this.isReadOnly = true;
        if (this.length <= 0) goto L8;
        return this;
    L8:
        return Empty;
    L10:
        throw new IllegalStateException();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        checkIsMutable();
        checkForComodification();
        removeRangeInternal(this.offset, this.length);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(@Nullable Object r10) {
        checkForComodification();
        if (r10 != this) goto L5;
    L10:
        return true;
    L5:
        if ((r10 instanceof List) == true) goto L7;
    L9:
        return false;
    L7:
        if (contentEquals((List) r10) == false) goto L9;
        goto L9
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int r10) {
        checkForComodification();
        kotlin.collections.b.Companion.a(r10, this.length);
        return this.array[this.offset + r10];
    }

    @Override // kotlin.collections.e
    public int getSize() {
        checkForComodification();
        return this.length;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        checkForComodification();
        return kotlin.collections.builders.b.b(this.array, this.offset, this.length);
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object r10) {
        checkForComodification();
        int r11 = 0;
    L4:
        if (r11 >= this.length) goto L9;
        if (q.b(this.array[this.offset + r11], r10) == true) goto L7;
        r11 = r11 + 1;
        goto L4
    L7:
        return r11;
    L9:
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        checkForComodification();
        if (this.length != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    @NotNull
    public Iterator<E> iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object r10) {
        checkForComodification();
        int r11 = this.length - 1;
    L3:
        if (r11 < 0) goto L8;
        if (q.b(this.array[this.offset + r11], r10) == true) goto L6;
        r11 = r11 - 1;
        goto L3
    L6:
        return r11;
    L8:
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    @NotNull
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object r10) {
        checkIsMutable();
        checkForComodification();
        int r11 = indexOf(r10);
        if (r11 < 0) goto L5;
        remove(r11);
    L5:
        if (r11 < 0) goto L7;
        return true;
    L7:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(@NotNull Collection<? extends Object> r10) {
        q.g(r10, "elements");
        checkIsMutable();
        checkForComodification();
        if (retainOrRemoveAllInternal(this.offset, this.length, r10, false) <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // kotlin.collections.e
    public E removeAt(int r10) {
        checkIsMutable();
        checkForComodification();
        kotlin.collections.b.Companion.a(r10, this.length);
        return removeAtInternal(this.offset + r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(@NotNull Collection<? extends Object> r10) {
        q.g(r10, "elements");
        checkIsMutable();
        checkForComodification();
        if (retainOrRemoveAllInternal(this.offset, this.length, r10, true) > 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int r10, E r11) {
        checkIsMutable();
        checkForComodification();
        kotlin.collections.b.Companion.a(r10, this.length);
        E[] r12 = this.array;
        int r13 = this.offset;
        E r14 = r12[r13 + r10];
        r12[r13 + r10] = r11;
        return r14;
    }

    @Override // java.util.AbstractList, java.util.List
    @NotNull
    public List<E> subList(int r10, int r11) {
        kotlin.collections.b.Companion.c(r10, r11, this.length);
        E[] r12 = this.array;
        int r13 = this.offset + r10;
        int r14 = r11 - r10;
        boolean r15 = this.isReadOnly;
        ListBuilder<E> r16 = this.root;
        if (r16 != null) goto L5;
        ListBuilder<E> r17 = this;
    L7:
        return new ListBuilder(r12, r13, r14, r15, this, r17);
    L5:
        r17 = r16;
        goto L7
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @NotNull
    public <T> T[] toArray(@NotNull T[] r10) {
        q.g(r10, "destination");
        checkForComodification();
        int r11 = r10.length;
        int r12 = this.length;
        if (r11 >= r12) goto L6;
        E[] r13 = this.array;
        int r14 = this.offset;
        T[] r15 = (T[]) Arrays.copyOfRange(r13, r14, r12 + r14, r10.getClass());
        q.f(r15, "copyOfRange(...)");
        return r15;
    L6:
        E[] r16 = this.array;
        int r17 = this.offset;
        m.e(r16, r10, 0, r17, r12 + r17);
        return (T[]) s.f(this.length, r10);
    }

    @Override // java.util.AbstractCollection
    @NotNull
    public String toString() {
        checkForComodification();
        return kotlin.collections.builders.b.c(this.array, this.offset, this.length, this);
    }

    @Override // java.util.AbstractList, java.util.List
    @NotNull
    public ListIterator<E> listIterator(int r10) {
        checkForComodification();
        kotlin.collections.b.Companion.b(r10, this.length);
        return new b(this, r10);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int r10, E r11) {
        checkIsMutable();
        checkForComodification();
        kotlin.collections.b.Companion.b(r10, this.length);
        addAtInternal(this.offset + r10, r11);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int r10, @NotNull Collection<? extends E> r11) {
        q.g(r11, "elements");
        checkIsMutable();
        checkForComodification();
        kotlin.collections.b.Companion.b(r10, this.length);
        int r12 = r11.size();
        addAllInternal(this.offset + r10, r11, r12);
        if (r12 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @NotNull
    public Object[] toArray() {
        checkForComodification();
        E[] r10 = this.array;
        int r11 = this.offset;
        return m.g(r10, r11, this.length + r11);
    }

    public ListBuilder() {
        this(10);
    }

    public ListBuilder(int r10) {
        this(kotlin.collections.builders.b.d(r10), 0, 0, false, null, null);
    }
}
