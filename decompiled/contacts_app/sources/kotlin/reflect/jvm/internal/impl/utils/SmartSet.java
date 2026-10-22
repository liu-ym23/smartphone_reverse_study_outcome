package kotlin.reflect.jvm.internal.impl.utils;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;

/* JADX INFO: compiled from: SmartSet.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class SmartSet<T> extends AbstractSet<T> {
    public static final Companion Companion = null;
    private Object data;
    private int size;

    /* JADX INFO: compiled from: SmartSet.kt */
    private static final class ArrayIterator<T> implements Iterator<T>, KMutableIterator {
        private final Iterator<T> arrayIterator;

        public ArrayIterator(T[] r2) {
            Intrinsics.checkNotNullParameter(r2, "array");
            this.arrayIterator = ArrayIteratorKt.iterator(r2);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void remove() {
            remove();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.arrayIterator.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.arrayIterator.next();
        }

        @Override // java.util.Iterator
        public Void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: compiled from: SmartSet.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final <T> SmartSet<T> create() {
            return new SmartSet(null);
        }

        @JvmStatic
        public final <T> SmartSet<T> create(Collection<? extends T> r2) {
            Intrinsics.checkNotNullParameter(r2, "set");
            SmartSet<T> r1 = new SmartSet(null);
            r1.addAll(r2);
            return r1;
        }
    }

    /* JADX INFO: compiled from: SmartSet.kt */
    private static final class SingletonIterator<T> implements Iterator<T>, KMutableIterator {
        private final T element;
        private boolean hasNext;

        public SingletonIterator(T r1) {
            this.element = r1;
            this.hasNext = true;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void remove() {
            remove();
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.hasNext == false) goto L7;
            this.hasNext = false;
            return this.element;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.hasNext;
        }

        @Override // java.util.Iterator
        public Void remove() {
            throw new UnsupportedOperationException();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ SmartSet(DefaultConstructorMarker r1) {
        this();
    }

    @JvmStatic
    public static final <T> SmartSet<T> create() {
        return Companion.create();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return getSize();
    }

    private SmartSet() {
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int r1) {
        this.size = r1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<T> iterator() {
        if (size() != 0) goto L6;
        return Collections.emptySet().iterator();
    L6:
        if (size() != 1) goto L9;
        return new SingletonIterator(this.data);
    L9:
        if (size() >= 5) goto L11;
        Object r2 = this.data;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
        return new ArrayIterator((Object[]) r2);
    L11:
        Object r3 = this.data;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
        return TypeIntrinsics.asMutableSet(r3).iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(T r5) {
        if (size() != 0) goto L6;
        this.data = r5;
    L24:
        setSize(size() + 1);
        return true;
    L6:
        if (size() != 1) goto L12;
        if (Intrinsics.areEqual(this.data, r5) == false) goto L10;
        return false;
    L10:
        this.data = new Object[]{this.data, r5};
        goto L24
    L12:
        if (size() >= 5) goto L21;
        Object r0 = this.data;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
        Object[] r1 = (Object[]) r0;
        if (ArraysKt.contains(r1, r5) == false) goto L17;
        return false;
    L17:
        if (size() != 4) goto L19;
        LinkedHashSet r2 = SetsKt.linkedSetOf(Arrays.copyOf(r1, r1.length));
        r2.add(r5);
        Object r3 = r2;
    L20:
        this.data = r3;
        goto L24
    L19:
        Object[] r4 = Arrays.copyOf(r1, size() + 1);
        Intrinsics.checkNotNullExpressionValue(r4, "copyOf(this, newSize)");
        r4[r4.length - 1] = r5;
        r3 = r4;
        goto L20
    L21:
        Object r6 = this.data;
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
        if (TypeIntrinsics.asMutableSet(r6).add(r5) == true) goto L24;
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.data = null;
        setSize(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object r3) {
        if (size() != 0) goto L6;
        return false;
    L6:
        if (size() != 1) goto L9;
        return Intrinsics.areEqual(this.data, r3);
    L9:
        if (size() >= 5) goto L11;
        Object r2 = this.data;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
        return ArraysKt.contains((Object[]) r2, r3);
    L11:
        Object r4 = this.data;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.collections.Set<T of org.jetbrains.kotlin.utils.SmartSet>");
        return ((Set) r4).contains(r3);
    }
}
