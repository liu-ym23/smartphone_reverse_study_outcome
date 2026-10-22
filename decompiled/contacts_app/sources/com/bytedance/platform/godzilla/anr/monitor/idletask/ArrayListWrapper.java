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

/* JADX INFO: loaded from: classes2.dex */
public class ArrayListWrapper extends ArrayList<MessageQueue.IdleHandler> {
    private ArrayList<MessageQueue.IdleHandler> mOriginalArrayList;

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ void add(int r1, Object r2) {
        add(r1, (MessageQueue.IdleHandler) r2);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean add(Object r1) {
        return add((MessageQueue.IdleHandler) r1);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r1) {
        return get(r1);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object remove(int r1) {
        return remove(r1);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object set(int r1, Object r2) {
        return set(r1, (MessageQueue.IdleHandler) r2);
    }

    public ArrayListWrapper(ArrayList<MessageQueue.IdleHandler> r1) {
        this.mOriginalArrayList = r1;
    }

    public boolean add(MessageQueue.IdleHandler r2) {
        if (r2 == null) goto L8;
        if ((r2 instanceof IdleHandlerWrapper) == true) goto L8;
        return this.mOriginalArrayList.add(new IdleHandlerWrapper(r2));
    L8:
        return this.mOriginalArrayList.add(r2);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public MessageQueue.IdleHandler remove(int r1) {
        return this.mOriginalArrayList.remove(r1);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object r4) {
        if (this.mOriginalArrayList.remove(r4) == false) goto L6;
        return true;
    L6:
        Iterator<MessageQueue.IdleHandler> r0 = this.mOriginalArrayList.iterator();
    L8:
        if (r0.hasNext() == false) goto L14;
        MessageQueue.IdleHandler r1 = r0.next();
        if ((r1 instanceof IdleHandlerWrapper) == false) goto L8;
        IdleHandlerWrapper r2 = (IdleHandlerWrapper) r1;
        if (r2.getOriginalIdleHandler() != r4) goto L8;
    L15:
        if (r2 != null) goto L17;
        return false;
    L17:
        return this.mOriginalArrayList.remove(r2);
    L14:
        r2 = null;
        goto L15
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.mOriginalArrayList.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] r1) {
        return (T[]) this.mOriginalArrayList.toArray(r1);
    }

    @Override // java.util.ArrayList
    public void trimToSize() {
        throw new RuntimeException("Reach method trimToSize");
    }

    @Override // java.util.ArrayList
    public void ensureCapacity(int r1) {
        throw new RuntimeException("Reach method ensureCapacity");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        throw new RuntimeException("Reach method isEmpty");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object r1) {
        throw new RuntimeException("Reach method contains");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public int indexOf(Object r1) {
        throw new RuntimeException("Reach method indexOf");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public int lastIndexOf(Object r1) {
        throw new RuntimeException("Reach method lastIndexOf");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        throw new RuntimeException("Reach method toArray");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public MessageQueue.IdleHandler get(int r1) {
        throw new RuntimeException("Reach method get");
    }

    public MessageQueue.IdleHandler set(int r1, MessageQueue.IdleHandler r2) {
        throw new RuntimeException("Reach method set");
    }

    public void add(int r1, MessageQueue.IdleHandler r2) {
        throw new RuntimeException("Reach method add");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        throw new RuntimeException("Reach method clear");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends MessageQueue.IdleHandler> r1) {
        throw new RuntimeException("Reach method addAll");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public boolean addAll(int r1, Collection<? extends MessageQueue.IdleHandler> r2) {
        throw new RuntimeException("Reach method addAll");
    }

    @Override // java.util.ArrayList, java.util.AbstractList
    protected void removeRange(int r1, int r2) {
        throw new RuntimeException("Reach method removeRange");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> r1) {
        throw new RuntimeException("Reach method removeAll");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> r1) {
        throw new RuntimeException("Reach method retainAll");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public ListIterator<MessageQueue.IdleHandler> listIterator(int r1) {
        throw new RuntimeException("Reach method listIterator");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public ListIterator<MessageQueue.IdleHandler> listIterator() {
        throw new RuntimeException("Reach method listIterator");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<MessageQueue.IdleHandler> iterator() {
        return this.mOriginalArrayList.iterator();
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public List<MessageQueue.IdleHandler> subList(int r1, int r2) {
        throw new RuntimeException("Reach method subList");
    }

    @Override // java.util.ArrayList, java.lang.Iterable
    public void forEach(Consumer<? super MessageQueue.IdleHandler> r1) {
        throw new RuntimeException("Reach method forEach");
    }

    @Override // java.util.ArrayList, java.util.Collection, java.lang.Iterable, java.util.List
    public Spliterator<MessageQueue.IdleHandler> spliterator() {
        throw new RuntimeException("Reach method spliterator");
    }

    @Override // java.util.ArrayList, java.util.Collection
    public boolean removeIf(Predicate<? super MessageQueue.IdleHandler> r1) {
        throw new RuntimeException("Reach method removeIf");
    }

    @Override // java.util.ArrayList, java.util.List
    public void replaceAll(UnaryOperator<MessageQueue.IdleHandler> r1) {
        throw new RuntimeException("Reach method replaceAll");
    }

    @Override // java.util.ArrayList, java.util.List
    public void sort(Comparator<? super MessageQueue.IdleHandler> r1) {
        throw new RuntimeException("Reach method sort");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object r1) {
        return super.equals(r1);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return super.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean containsAll(Collection<?> r1) {
        throw new RuntimeException("Reach method containsAll");
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return super.toString();
    }

    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override // java.util.Collection
    public Stream<MessageQueue.IdleHandler> stream() {
        throw new RuntimeException("Reach method stream");
    }

    @Override // java.util.Collection
    public Stream<MessageQueue.IdleHandler> parallelStream() {
        throw new RuntimeException("Reach method parallelStream");
    }
}
