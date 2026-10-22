package u5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b implements Iterator, q5.a {

    /* renamed from: a, reason: collision with root package name */
    public final int f5660a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5661b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f5662c;
    public int d;

    public b(char c3, char c8, int i8) {
        this.f5660a = i8;
        this.f5661b = c8;
        boolean z = false;
        if (i8 <= 0 ? p.g(c3, c8) >= 0 : p.g(c3, c8) <= 0) {
            z = true;
        }
        this.f5662c = z;
        this.d = z ? c3 : c8;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5662c;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i8 = this.d;
        if (i8 != this.f5661b) {
            this.d = this.f5660a + i8;
        } else {
            if (!this.f5662c) {
                throw new NoSuchElementException();
            }
            this.f5662c = false;
        }
        return Character.valueOf((char) i8);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
