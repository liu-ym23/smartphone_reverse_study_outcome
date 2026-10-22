package G1;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class m implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public n f607a;

    /* renamed from: b, reason: collision with root package name */
    public n f608b = null;

    /* renamed from: c, reason: collision with root package name */
    public int f609c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ o f610d;

    public m(o oVar) {
        this.f610d = oVar;
        this.f607a = oVar.f626f.f614d;
        this.f609c = oVar.f625e;
    }

    public final n a() {
        n nVar = this.f607a;
        o oVar = this.f610d;
        if (nVar == oVar.f626f) {
            throw new NoSuchElementException();
        }
        if (oVar.f625e != this.f609c) {
            throw new ConcurrentModificationException();
        }
        this.f607a = nVar.f614d;
        this.f608b = nVar;
        return nVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f607a != this.f610d.f626f;
    }

    @Override // java.util.Iterator
    public final void remove() {
        n nVar = this.f608b;
        if (nVar == null) {
            throw new IllegalStateException();
        }
        o oVar = this.f610d;
        oVar.c(nVar, true);
        this.f608b = null;
        this.f609c = oVar.f625e;
    }
}
