package j;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c implements Iterator, Map.Entry {

    /* renamed from: a, reason: collision with root package name */
    public int f3284a;

    /* renamed from: b, reason: collision with root package name */
    public int f3285b = -1;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3286c;
    public final /* synthetic */ e d;

    public c(e eVar) {
        this.d = eVar;
        this.f3284a = eVar.f3306c - 1;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!this.f3286c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        int i8 = this.f3285b;
        e eVar = this.d;
        return p.a(key, eVar.f(i8)) && p.a(entry.getValue(), eVar.i(this.f3285b));
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        if (this.f3286c) {
            return this.d.f(this.f3285b);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.f3286c) {
            return this.d.i(this.f3285b);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3285b < this.f3284a;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        if (!this.f3286c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        int i8 = this.f3285b;
        e eVar = this.d;
        Object objF = eVar.f(i8);
        Object objI = eVar.i(this.f3285b);
        return (objF == null ? 0 : objF.hashCode()) ^ (objI != null ? objI.hashCode() : 0);
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f3285b++;
        this.f3286c = true;
        return this;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f3286c) {
            throw new IllegalStateException();
        }
        this.d.g(this.f3285b);
        this.f3285b--;
        this.f3284a--;
        this.f3286c = false;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (this.f3286c) {
            return this.d.h(this.f3285b, obj);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}
