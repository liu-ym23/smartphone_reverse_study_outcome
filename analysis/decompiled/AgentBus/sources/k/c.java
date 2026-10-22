package k;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class c implements Iterator, Map.Entry {

    /* renamed from: f, reason: collision with root package name */
    public int f5458f;

    /* renamed from: g, reason: collision with root package name */
    public int f5459g = -1;

    /* renamed from: h, reason: collision with root package name */
    public boolean f5460h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ e f5461i;

    public c(e eVar) {
        this.f5461i = eVar;
        this.f5458f = eVar.f5479h - 1;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!this.f5460h) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        int i2 = this.f5459g;
        e eVar = this.f5461i;
        return q7.k.a(key, eVar.g(i2)) && q7.k.a(entry.getValue(), eVar.k(this.f5459g));
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        if (this.f5460h) {
            return this.f5461i.g(this.f5459g);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.f5460h) {
            return this.f5461i.k(this.f5459g);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5459g < this.f5458f;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        if (!this.f5460h) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        int i2 = this.f5459g;
        e eVar = this.f5461i;
        Object objG = eVar.g(i2);
        Object objK = eVar.k(this.f5459g);
        return (objG == null ? 0 : objG.hashCode()) ^ (objK != null ? objK.hashCode() : 0);
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f5459g++;
        this.f5460h = true;
        return this;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f5460h) {
            throw new IllegalStateException();
        }
        this.f5461i.i(this.f5459g);
        this.f5459g--;
        this.f5458f--;
        this.f5460h = false;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (this.f5460h) {
            return this.f5461i.j(this.f5459g, obj);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}
