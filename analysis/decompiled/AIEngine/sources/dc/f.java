package dc;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f implements Iterator, ac.a {

    /* renamed from: a, reason: collision with root package name */
    public final long f8459a;

    /* renamed from: b, reason: collision with root package name */
    public final long f8460b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f8461c;

    /* renamed from: d, reason: collision with root package name */
    public long f8462d;

    public f(long j10, long j11, long j12) {
        this.f8459a = j12;
        this.f8460b = j11;
        boolean z = false;
        if (j12 <= 0 ? j10 >= j11 : j10 <= j11) {
            z = true;
        }
        this.f8461c = z;
        this.f8462d = z ? j10 : j11;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f8461c;
    }

    @Override // java.util.Iterator
    public final Object next() {
        long j10 = this.f8462d;
        if (j10 != this.f8460b) {
            this.f8462d = this.f8459a + j10;
        } else {
            if (!this.f8461c) {
                throw new NoSuchElementException();
            }
            this.f8461c = false;
        }
        return Long.valueOf(j10);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
