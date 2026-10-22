package kotlin.reflect.jvm.internal.pcollections;

import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
final class ConsPStack<E> implements Iterable<E> {
    private static final ConsPStack<Object> EMPTY = null;
    final E first;
    final ConsPStack<E> rest;
    private final int size;

    private static class Itr<E> implements Iterator<E> {
        private ConsPStack<E> next;

        public Itr(ConsPStack<E> r1) {
            this.next = r1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (ConsPStack.access$000(this.next) <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            E r0 = this.next.first;
            this.next = this.next.rest;
            return r0;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    static /* synthetic */ int access$000(ConsPStack r0) {
        return r0.size;
    }

    static {
        EMPTY = new ConsPStack();
    }

    public static <E> ConsPStack<E> empty() {
        return (ConsPStack<E>) EMPTY;
    }

    private ConsPStack() {
        this.size = 0;
        this.first = null;
        this.rest = null;
    }

    private ConsPStack(E r1, ConsPStack<E> r2) {
        this.first = r1;
        this.rest = r2;
        this.size = r2.size + 1;
    }

    public E get(int r3) {
        if (r3 < 0) goto L10;
        if (r3 > this.size) goto L10;
        return iterator(r3).next();
    L8:
        throw new IndexOutOfBoundsException("Index: " + r3);
    L10:
        throw new IndexOutOfBoundsException();
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return iterator(0);
    }

    public int size() {
        return this.size;
    }

    private Iterator<E> iterator(int r2) {
        return new Itr(subList(r2));
    }

    public ConsPStack<E> plus(E r2) {
        return new ConsPStack(r2, this);
    }

    private ConsPStack<E> minus(Object r2) {
        if (this.size != 0) goto L6;
        return this;
    L6:
        if (this.first.equals(r2) == true) goto L8;
        ConsPStack<E> r3 = this.rest.minus(r2);
        if (r3 != this.rest) goto L13;
        return this;
    L13:
        return new ConsPStack(this.first, r3);
    L8:
        return this.rest;
    }

    public ConsPStack<E> minus(int r1) {
        return minus(get(r1));
    }

    private ConsPStack<E> subList(int r2) {
        if (r2 < 0) goto L10;
        if (r2 > this.size) goto L10;
        if (r2 != 0) goto L8;
        return this;
    L8:
        return this.rest.subList(r2 - 1);
    L10:
        throw new IndexOutOfBoundsException();
    }
}
