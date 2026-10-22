package org.apache.http.pool;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.Future;
import org.apache.http.pool.PoolEntry;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

/* JADX INFO: loaded from: classes4.dex */
abstract class RouteSpecificPool<T, C, E extends PoolEntry<T, C>> {
    private final LinkedList<E> available;
    private final Set<E> leased;
    private final LinkedList<Future<E>> pending;
    private final T route;

    public RouteSpecificPool(T r10) {
        this.route = r10;
        this.leased = new HashSet();
        this.available = new LinkedList();
        this.pending = new LinkedList();
    }

    public E add(C r10) {
        E r11 = (E) createEntry(r10);
        this.leased.add(r11);
        return r11;
    }

    public abstract E createEntry(C r10);

    public void free(E r10, boolean r11) {
        Args.notNull(r10, "Pool entry");
        Asserts.check(this.leased.remove(r10), "Entry %s has not been leased from this pool", r10);
        if (r11 == false) goto L6;
        this.available.addFirst(r10);
        return;
    }

    public int getAllocatedCount() {
        return this.available.size() + this.leased.size();
    }

    public int getAvailableCount() {
        return this.available.size();
    }

    public E getFree(Object r10) {
        if (this.available.isEmpty() == true) goto L19;
        if (r10 == null) goto L12;
        Iterator<E> r11 = this.available.iterator();
    L7:
        if (r11.hasNext() == false) goto L12;
        E r12 = r11.next();
        if (r10.equals(r12.getState()) == false) goto L7;
        r11.remove();
        this.leased.add(r12);
        return r12;
    L12:
        Iterator<E> r13 = this.available.iterator();
    L14:
        if (r13.hasNext() == false) goto L27;
        E r14 = r13.next();
        if (r14.getState() != null) goto L14;
        r13.remove();
        this.leased.add(r14);
        return r14;
    L27:
        return null;
    L19:
        return null;
    }

    public E getLastUsed() {
        if (this.available.isEmpty() == false) goto L6;
        return null;
    L6:
        return this.available.getLast();
    }

    public int getLeasedCount() {
        return this.leased.size();
    }

    public int getPendingCount() {
        return this.pending.size();
    }

    public final T getRoute() {
        return this.route;
    }

    public Future<E> nextPending() {
        return this.pending.poll();
    }

    public void queue(Future<E> r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.pending.add(r10);
    }

    public boolean remove(E r10) {
        Args.notNull(r10, "Pool entry");
        if (this.available.remove(r10) == false) goto L5;
        return true;
    L5:
        if (this.leased.remove(r10) == true) goto L10;
        return false;
    L10:
        return true;
    }

    public void shutdown() {
        Iterator<Future<E>> r10 = this.pending.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().cancel(true);
        goto L4
    L6:
        this.pending.clear();
        Iterator<E> r11 = this.available.iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        r11.next().close();
        goto L8
    L10:
        this.available.clear();
        Iterator<E> r12 = this.leased.iterator();
    L12:
        if (r12.hasNext() == false) goto L14;
        r12.next().close();
        goto L12
    L14:
        this.leased.clear();
    }

    public String toString() {
        return "[route: " + this.route + "][leased: " + this.leased.size() + "][available: " + this.available.size() + "][pending: " + this.pending.size() + "]";
    }

    public void unqueue(Future<E> r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.pending.remove(r10);
    }
}
