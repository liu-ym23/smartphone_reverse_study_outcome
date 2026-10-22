package H8;

import com.google.protobuf.O1;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/* loaded from: classes4.dex */
public final class u implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f780a;
    public final Object b;
    public Object c;

    public u(O1 o12, Iterator it) {
        this.f780a = 1;
        this.b = o12;
        this.c = it;
    }

    public r a() {
        r rVar;
        Stack stack = (Stack) this.b;
        r rVar2 = (r) this.c;
        if (rVar2 == null) {
            throw new NoSuchElementException();
        }
        while (true) {
            if (!stack.isEmpty()) {
                AbstractC0244e abstractC0244e = ((w) stack.pop()).d;
                while (abstractC0244e instanceof w) {
                    w wVar = (w) abstractC0244e;
                    stack.push(wVar);
                    abstractC0244e = wVar.c;
                }
                r rVar3 = (r) abstractC0244e;
                if (rVar3.b.length != 0) {
                    rVar = rVar3;
                    break;
                }
            } else {
                rVar = null;
                break;
            }
        }
        this.c = rVar;
        return rVar2;
    }

    public boolean equals(Object obj) {
        switch (this.f780a) {
            case 1:
                return ((Iterator) this.c).equals(obj);
            default:
                return super.equals(obj);
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f780a) {
            case 0:
                return ((r) this.c) != null;
            default:
                return ((Iterator) this.c).hasNext();
        }
    }

    public int hashCode() {
        switch (this.f780a) {
            case 1:
                return ((Iterator) this.c).hashCode();
            default:
                return super.hashCode();
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f780a) {
            case 0:
                return a();
            default:
                return ((Iterator) this.c).next();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f780a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                ((O1) this.b).L();
                ((Iterator) this.c).remove();
                return;
        }
    }

    public String toString() {
        switch (this.f780a) {
            case 1:
                return ((Iterator) this.c).toString();
            default:
                return super.toString();
        }
    }

    public u(AbstractC0244e abstractC0244e) {
        this.f780a = 0;
        this.b = new Stack();
        while (abstractC0244e instanceof w) {
            w wVar = (w) abstractC0244e;
            ((Stack) this.b).push(wVar);
            abstractC0244e = wVar.c;
        }
        this.c = (r) abstractC0244e;
    }
}
