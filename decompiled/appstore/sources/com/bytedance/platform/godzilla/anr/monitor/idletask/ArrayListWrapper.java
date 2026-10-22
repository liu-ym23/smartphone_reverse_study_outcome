package com.bytedance.platform.godzilla.anr.monitor.idletask;

import android.os.MessageQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;
import r5.c;

/* JADX INFO: loaded from: classes.dex */
public class ArrayListWrapper extends ArrayList<MessageQueue.IdleHandler> {
    private ArrayList<MessageQueue.IdleHandler> mOriginalArrayList;

    public ArrayListWrapper(ArrayList<MessageQueue.IdleHandler> r10) {
        this.mOriginalArrayList = r10;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ void add(int r10, Object r11) {
        add(r10, (MessageQueue.IdleHandler) r11);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends MessageQueue.IdleHandler> r10) {
        throw new RuntimeException("Reach method addAll");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        throw new RuntimeException("Reach method clear");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object r10) {
        throw new RuntimeException("Reach method contains");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean containsAll(Collection<?> r10) {
        throw new RuntimeException("Reach method containsAll");
    }

    @Override // java.util.ArrayList
    public void ensureCapacity(int r10) {
        throw new RuntimeException("Reach method ensureCapacity");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object r10) {
        return super.equals(r10);
    }

    public void finalize() throws Throwable {
        super.finalize();
    }

    @Override // java.util.ArrayList, java.lang.Iterable
    public void forEach(Consumer<? super MessageQueue.IdleHandler> r10) {
        throw new RuntimeException("Reach method forEach");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r10) {
        return get(r10);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return super.hashCode();
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public int indexOf(Object r10) {
        throw new RuntimeException("Reach method indexOf");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        throw new RuntimeException("Reach method isEmpty");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<MessageQueue.IdleHandler> iterator() {
        return this.mOriginalArrayList.iterator();
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public int lastIndexOf(Object r10) {
        throw new RuntimeException("Reach method lastIndexOf");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public ListIterator<MessageQueue.IdleHandler> listIterator(int r10) {
        throw new RuntimeException("Reach method listIterator");
    }

    @Override // java.util.Collection
    public Stream<MessageQueue.IdleHandler> parallelStream() {
        throw new RuntimeException("Reach method parallelStream");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object remove(int r10) {
        return remove(r10);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> r10) {
        throw new RuntimeException("Reach method removeAll");
    }

    @Override // java.util.ArrayList, java.util.Collection
    public boolean removeIf(Predicate<? super MessageQueue.IdleHandler> r10) {
        throw new RuntimeException("Reach method removeIf");
    }

    @Override // java.util.ArrayList, java.util.AbstractList
    public void removeRange(int r10, int r11) {
        throw new RuntimeException("Reach method removeRange");
    }

    @Override // java.util.ArrayList, java.util.List
    public void replaceAll(UnaryOperator<MessageQueue.IdleHandler> r10) {
        throw new RuntimeException("Reach method replaceAll");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> r10) {
        throw new RuntimeException("Reach method retainAll");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object set(int r10, Object r11) {
        return set(r10, (MessageQueue.IdleHandler) r11);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.mOriginalArrayList.size();
    }

    @Override // java.util.ArrayList, java.util.List
    public void sort(Comparator<? super MessageQueue.IdleHandler> r10) {
        throw new RuntimeException("Reach method sort");
    }

    @Override // java.util.ArrayList, java.util.Collection, java.lang.Iterable, java.util.List
    public Spliterator<MessageQueue.IdleHandler> spliterator() {
        throw new RuntimeException("Reach method spliterator");
    }

    @Override // java.util.Collection
    public Stream<MessageQueue.IdleHandler> stream() {
        throw new RuntimeException("Reach method stream");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public List<MessageQueue.IdleHandler> subList(int r10, int r11) {
        throw new RuntimeException("Reach method subList");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] r10) {
        return (T[]) this.mOriginalArrayList.toArray(r10);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return super.toString();
    }

    @Override // java.util.ArrayList
    public void trimToSize() {
        throw new RuntimeException("Reach method trimToSize");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean add(Object r10) {
        return add((MessageQueue.IdleHandler) r10);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public boolean addAll(int r10, Collection<? extends MessageQueue.IdleHandler> r11) {
        throw new RuntimeException("Reach method addAll");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public MessageQueue.IdleHandler get(int r10) {
        throw new RuntimeException("Reach method get");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public ListIterator<MessageQueue.IdleHandler> listIterator() {
        throw new RuntimeException("Reach method listIterator");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public MessageQueue.IdleHandler remove(int r10) {
        return this.mOriginalArrayList.remove(r10);
    }

    public MessageQueue.IdleHandler set(int r10, MessageQueue.IdleHandler r11) {
        throw new RuntimeException("Reach method set");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        throw new RuntimeException("Reach method toArray");
    }

    public boolean add(MessageQueue.IdleHandler r10) {
        if (r10 == null) goto L8;
        if ((r10 instanceof c) == true) goto L8;
        return this.mOriginalArrayList.add(new c(r10));
    L8:
        return this.mOriginalArrayList.add(r10);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object r10) {
        if (this.mOriginalArrayList.remove(r10) == false) goto L6;
        return true;
    L6:
        Iterator<MessageQueue.IdleHandler> r11 = this.mOriginalArrayList.iterator();
    L8:
        if (r11.hasNext() == false) goto L14;
        MessageQueue.IdleHandler r12 = r11.next();
        if ((r12 instanceof c) == false) goto L8;
        c r13 = (c) r12;
        if (r13.a() != r10) goto L8;
    L15:
        if (r13 != null) goto L17;
        return false;
    L17:
        return this.mOriginalArrayList.remove(r13);
    L14:
        r13 = null;
        goto L15
    }

    public void add(int r10, MessageQueue.IdleHandler r11) {
        throw new RuntimeException("Reach method add");
    }
}
