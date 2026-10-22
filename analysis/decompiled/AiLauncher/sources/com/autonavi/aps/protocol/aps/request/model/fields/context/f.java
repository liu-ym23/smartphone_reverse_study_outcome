package com.autonavi.aps.protocol.aps.request.model.fields.context;

import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public class f implements Iterable<g> {

    /* renamed from: c, reason: collision with root package name */
    private int f19050c = -1;

    /* renamed from: a, reason: collision with root package name */
    private LinkedList<g> f19048a = new LinkedList<>();

    /* renamed from: b, reason: collision with root package name */
    private LinkedList<g> f19049b = new LinkedList<>();

    public static class a implements Iterator<g> {

        /* renamed from: a, reason: collision with root package name */
        private f f19051a;

        /* renamed from: b, reason: collision with root package name */
        private Iterator<g> f19052b;

        /* renamed from: c, reason: collision with root package name */
        private Iterator<g> f19053c;

        public a(f fVar, boolean z10) {
            this.f19051a = fVar;
            if (z10) {
                this.f19052b = fVar.f19048a.iterator();
                this.f19053c = this.f19051a.f19049b.iterator();
            } else {
                this.f19053c = fVar.f19048a.descendingIterator();
                this.f19052b = this.f19051a.f19049b.descendingIterator();
            }
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public g next() {
            if (this.f19052b.hasNext()) {
                return this.f19052b.next();
            }
            if (this.f19053c.hasNext()) {
                return this.f19053c.next();
            }
            return null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f19052b.hasNext() || this.f19053c.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.lang.Iterable
    public Iterator<g> iterator() {
        if (this.f19050c >= 0) {
            while (!this.f19048a.isEmpty() && this.f19050c - this.f19048a.getFirst().c() > 240) {
                this.f19048a.removeFirst();
            }
            while (!this.f19049b.isEmpty() && this.f19050c - this.f19049b.getFirst().c() > 240) {
                this.f19049b.removeFirst();
            }
            LinkedList linkedList = new LinkedList();
            while (!this.f19049b.isEmpty() && (this.f19050c - this.f19049b.getFirst().c() > 60 || this.f19049b.size() > 3)) {
                g gVarRemoveFirst = this.f19049b.removeFirst();
                if (!linkedList.isEmpty() && ((g) linkedList.getLast()).c() / 60 == gVarRemoveFirst.c() / 60 && ((g) linkedList.getLast()).d() < gVarRemoveFirst.d()) {
                    linkedList.removeLast();
                }
                if (linkedList.isEmpty() || ((g) linkedList.getLast()).c() / 60 != gVarRemoveFirst.c() / 60) {
                    linkedList.add(gVarRemoveFirst);
                }
            }
            if (!this.f19048a.isEmpty() && !linkedList.isEmpty() && ((g) linkedList.getFirst()).c() / 60 == this.f19048a.getLast().c() / 60) {
                g gVar = (g) linkedList.removeFirst();
                if (this.f19048a.getLast().d() < gVar.d()) {
                    this.f19048a.removeLast();
                    this.f19048a.add(gVar);
                }
            }
            this.f19048a.addAll(linkedList);
            while (this.f19048a.size() > 3) {
                this.f19048a.removeFirst();
            }
        }
        return new a(this, true);
    }

    public void a(g gVar) {
        this.f19049b.add(gVar);
    }
}
