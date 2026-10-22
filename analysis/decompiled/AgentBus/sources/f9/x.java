package f9;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/* loaded from: classes.dex */
public final class x implements Iterator {

    /* renamed from: f, reason: collision with root package name */
    public final Stack f3602f = new Stack();

    /* renamed from: g, reason: collision with root package name */
    public u f3603g;

    public x(d dVar) {
        while (dVar instanceof z) {
            z zVar = (z) dVar;
            this.f3602f.push(zVar);
            dVar = zVar.f3609h;
        }
        this.f3603g = (u) dVar;
    }

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final u next() {
        u uVar;
        u uVar2 = this.f3603g;
        if (uVar2 == null) {
            throw new NoSuchElementException();
        }
        while (true) {
            Stack stack = this.f3602f;
            if (!stack.isEmpty()) {
                Object obj = ((z) stack.pop()).f3610i;
                while (obj instanceof z) {
                    z zVar = (z) obj;
                    stack.push(zVar);
                    obj = zVar.f3609h;
                }
                uVar = (u) obj;
                if (uVar.f3600g.length != 0) {
                    break;
                }
            } else {
                uVar = null;
                break;
            }
        }
        this.f3603g = uVar;
        return uVar2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3603g != null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
