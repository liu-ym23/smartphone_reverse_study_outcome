package q;

import com.stepos.alphame.utils.Consts;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: q.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0820d implements Iterator, Map.Entry {

    /* renamed from: a, reason: collision with root package name */
    public int f13943a;

    /* renamed from: b, reason: collision with root package name */
    public int f13944b = -1;

    /* renamed from: c, reason: collision with root package name */
    public boolean f13945c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ f f13946d;

    public C0820d(f fVar) {
        this.f13946d = fVar;
        this.f13943a = fVar.f13970c - 1;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!this.f13945c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        int i4 = this.f13944b;
        f fVar = this.f13946d;
        return Intrinsics.areEqual(key, fVar.f(i4)) && Intrinsics.areEqual(entry.getValue(), fVar.i(this.f13944b));
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        if (this.f13945c) {
            return this.f13946d.f(this.f13944b);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.f13945c) {
            return this.f13946d.i(this.f13944b);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f13944b < this.f13943a;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        if (!this.f13945c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        int i4 = this.f13944b;
        f fVar = this.f13946d;
        Object objF = fVar.f(i4);
        Object objI = fVar.i(this.f13944b);
        return (objF == null ? 0 : objF.hashCode()) ^ (objI != null ? objI.hashCode() : 0);
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f13944b++;
        this.f13945c = true;
        return this;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f13945c) {
            throw new IllegalStateException();
        }
        this.f13946d.g(this.f13944b);
        this.f13944b--;
        this.f13943a--;
        this.f13945c = false;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (this.f13945c) {
            return this.f13946d.h(this.f13944b, obj);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final String toString() {
        return getKey() + Consts.SPLITTER_EQUAL + getValue();
    }
}
