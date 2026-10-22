package v7;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class c implements Iterator, r7.a {

    /* renamed from: f, reason: collision with root package name */
    public final int f10526f;

    /* renamed from: g, reason: collision with root package name */
    public final int f10527g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f10528h;

    /* renamed from: i, reason: collision with root package name */
    public int f10529i;

    public c(int i2, int i10, int i11) {
        this.f10526f = i11;
        this.f10527g = i10;
        boolean z4 = false;
        if (i11 <= 0 ? i2 >= i10 : i2 <= i10) {
            z4 = true;
        }
        this.f10528h = z4;
        this.f10529i = z4 ? i2 : i10;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f10528h;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return Integer.valueOf(nextInt());
    }

    public final int nextInt() {
        int i2 = this.f10529i;
        if (i2 != this.f10527g) {
            this.f10529i = this.f10526f + i2;
            return i2;
        }
        if (!this.f10528h) {
            throw new NoSuchElementException();
        }
        this.f10528h = false;
        return i2;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
