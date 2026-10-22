package H8;

import java.util.Iterator;

/* loaded from: classes4.dex */
public final class v implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final u f781a;
    public q b;
    public int c;

    public v(w wVar) {
        u uVar = new u(wVar);
        this.f781a = uVar;
        this.b = new q(uVar.a());
        this.c = wVar.b;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.c > 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.b.hasNext()) {
            this.b = new q(this.f781a.a());
        }
        this.c--;
        return Byte.valueOf(this.b.nextByte());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
