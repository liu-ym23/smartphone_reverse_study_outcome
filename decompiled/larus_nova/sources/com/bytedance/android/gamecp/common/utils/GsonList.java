package com.bytedance.android.gamecp.common.utils;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.Unit;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes44.dex */
public final class GsonList implements List<Object>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JsonArray f57164a;

    public final class a implements ListIterator<Object>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f57165a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ GsonList f57166b;

        @Override // java.util.ListIterator
        public final void add(Object r100) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public final void set(Object r100) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final boolean hasNext() {
            if (this.f57165a >= this.f57166b.f57164a.size()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            if (this.f57165a <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final Object next() {
            JsonArray r100 = this.f57166b.f57164a;
            int r101 = this.f57165a;
            this.f57165a = r101 + 1;
            Unit r102 = Unit.INSTANCE;
            JsonElement r103 = r100.get(r101);
            if (r103 != null) goto L7;
            return null;
        L7:
            return UtilsKt.b(r103);
        }

        @Override // java.util.ListIterator
        public final Object previous() {
            JsonArray r100 = this.f57166b.f57164a;
            int r101 = this.f57165a - 1;
            this.f57165a = r101;
            Unit r102 = Unit.INSTANCE;
            JsonElement r103 = r100.get(r101);
            if (r103 != null) goto L7;
            return null;
        L7:
            return UtilsKt.b(r103);
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            return this.f57165a - 1;
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            return this.f57165a;
        }

        public a(GsonList r100, int r101) {
            this.f57166b = r100;
            this.f57165a = r101;
        }
    }

    public static final class b implements Iterator<Object>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<JsonElement> f57167a;

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f57167a.hasNext();
        }

        @Override // java.util.Iterator
        public final Object next() {
            JsonElement r100 = this.f57167a.next();
            if (r100 != null) goto L7;
            return null;
        L7:
            return UtilsKt.b(r100);
        }

        public b(GsonList r100) {
            this.f57167a = r100.f57164a.iterator();
        }
    }

    @Override // java.util.List
    public final void add(int r100, Object r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean add(Object r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final boolean addAll(int r100, Collection<? extends Object> r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends Object> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final Object remove(int r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection<? extends Object> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final void replaceAll(UnaryOperator<Object> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection<? extends Object> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final Object set(int r100, Object r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final void sort(Comparator<? super Object> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public final <T> T[] toArray(T[] r100) {
        return (T[]) CollectionToArray.toArray(this, r100);
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator<Object> iterator() {
        return new b(this);
    }

    @Override // java.util.List
    public final ListIterator<Object> listIterator() {
        return new a(this, 0);
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.f57164a.size();
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public GsonList(JsonArray r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f57164a = r100;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object r100) {
        throw new UnsupportedOperationException("Operation not supported.");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection<? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        throw new UnsupportedOperationException("Operation not supported.");
    }

    @Override // java.util.List
    public final Object get(int r100) {
        JsonElement r101 = this.f57164a.get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return UtilsKt.b(r101);
    }

    @Override // java.util.List
    public final int indexOf(Object r100) {
        throw new UnsupportedOperationException("Operation not supported.");
    }

    @Override // java.util.List
    public final int lastIndexOf(Object r100) {
        throw new UnsupportedOperationException("Operation not supported.");
    }

    @Override // java.util.List
    public final ListIterator<Object> listIterator(int r100) {
        return new a(this, r100);
    }

    @Override // java.util.List
    public final List<Object> subList(final int r100, final int r101) {
        return SequencesKt.toList(SequencesKt.map(SequencesKt.filterIndexed(SequencesKt.asSequence(this.f57164a.iterator()), new AnonymousClass1(r100, r101)), AnonymousClass2.INSTANCE));
    }
}
