package com.google.common.cache;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReferenceArray;
import l3.x;
import l3.y;

/* loaded from: classes3.dex */
public abstract class d implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public int f2737a;
    public int b = -1;
    public LocalCache$Segment c;
    public AtomicReferenceArray d;
    public y e;
    public x f;
    public x g;
    public final /* synthetic */ e h;

    public d(e eVar) {
        this.h = eVar;
        this.f2737a = eVar.c.length - 1;
        a();
    }

    public final void a() {
        this.f = null;
        if (d() || e()) {
            return;
        }
        while (true) {
            int i = this.f2737a;
            if (i < 0) {
                return;
            }
            LocalCache$Segment[] localCache$SegmentArr = this.h.c;
            this.f2737a = i - 1;
            LocalCache$Segment localCache$Segment = localCache$SegmentArr[i];
            this.c = localCache$Segment;
            if (localCache$Segment.b != 0) {
                this.d = this.c.f;
                this.b = r0.length() - 1;
                if (e()) {
                    return;
                }
            }
        }
    }

    public final boolean b(y yVar) {
        Object obj;
        e eVar = this.h;
        try {
            long jA = eVar.o.a();
            Object key = yVar.getKey();
            Object obj2 = null;
            if (yVar.getKey() != null && (obj = yVar.d().get()) != null && !eVar.g(yVar, jA)) {
                obj2 = obj;
            }
            if (obj2 == null) {
                this.c.i();
                return false;
            }
            this.f = new x(eVar, key, obj2);
            this.c.i();
            return true;
        } catch (Throwable th) {
            this.c.i();
            throw th;
        }
    }

    public final x c() {
        x xVar = this.f;
        if (xVar == null) {
            throw new NoSuchElementException();
        }
        this.g = xVar;
        a();
        return this.g;
    }

    public final boolean d() {
        y yVar = this.e;
        if (yVar == null) {
            return false;
        }
        while (true) {
            this.e = yVar.getNext();
            y yVar2 = this.e;
            if (yVar2 == null) {
                return false;
            }
            if (b(yVar2)) {
                return true;
            }
            yVar = this.e;
        }
    }

    public final boolean e() {
        while (true) {
            int i = this.b;
            if (i < 0) {
                return false;
            }
            AtomicReferenceArray atomicReferenceArray = this.d;
            this.b = i - 1;
            y yVar = (y) atomicReferenceArray.get(i);
            this.e = yVar;
            if (yVar != null && (b(yVar) || d())) {
                return true;
            }
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f != null;
    }

    @Override // java.util.Iterator
    public Object next() {
        return c();
    }

    @Override // java.util.Iterator
    public final void remove() {
        x xVar = this.g;
        if (xVar == null) {
            throw new IllegalStateException();
        }
        this.h.remove(xVar.f5284a);
        this.g = null;
    }
}
