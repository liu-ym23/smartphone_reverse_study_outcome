package q;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMutableIterator;

/* loaded from: classes.dex */
public abstract class h implements Iterator, KMutableIterator {

    /* renamed from: a, reason: collision with root package name */
    public int f13954a;

    /* renamed from: b, reason: collision with root package name */
    public int f13955b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f13956c;

    public h(int i4) {
        this.f13954a = i4;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f13955b < this.f13954a;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object objF;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i4 = this.f13955b;
        C0818b c0818b = (C0818b) this;
        int i5 = c0818b.f13940d;
        Object obj = c0818b.f13941e;
        switch (i5) {
            case 0:
                objF = ((f) obj).f(i4);
                break;
            case 1:
                objF = ((f) obj).i(i4);
                break;
            default:
                objF = ((g) obj).f13952b[i4];
                break;
        }
        this.f13955b++;
        this.f13956c = true;
        return objF;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f13956c) {
            throw new IllegalStateException("Call next() before removing an element.".toString());
        }
        int i4 = this.f13955b - 1;
        this.f13955b = i4;
        C0818b c0818b = (C0818b) this;
        int i5 = c0818b.f13940d;
        Object obj = c0818b.f13941e;
        switch (i5) {
            case 0:
                ((f) obj).g(i4);
                break;
            case 1:
                ((f) obj).g(i4);
                break;
            default:
                ((g) obj).a(i4);
                break;
        }
        this.f13954a--;
        this.f13956c = false;
    }
}
