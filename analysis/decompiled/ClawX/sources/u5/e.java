package u5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e implements Iterator, q5.a {

    /* renamed from: a, reason: collision with root package name */
    public final int f5666a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5667b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f5668c;
    public int d;

    public e(int i8, int i9, int i10) {
        this.f5666a = i10;
        this.f5667b = i9;
        boolean z = false;
        if (i10 <= 0 ? i8 >= i9 : i8 <= i9) {
            z = true;
        }
        this.f5668c = z;
        this.d = z ? i8 : i9;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5668c;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return Integer.valueOf(nextInt());
    }

    public final int nextInt() {
        int i8 = this.d;
        if (i8 != this.f5667b) {
            this.d = this.f5666a + i8;
            return i8;
        }
        if (!this.f5668c) {
            throw new NoSuchElementException();
        }
        this.f5668c = false;
        return i8;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
