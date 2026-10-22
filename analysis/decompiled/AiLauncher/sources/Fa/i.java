package Fa;

import java.util.Iterator;
import java.util.NoSuchElementException;
import q9.InterfaceC5162a;

/* loaded from: classes5.dex */
public final class i extends c {

    /* renamed from: a, reason: collision with root package name */
    public static final i f2649a = new i();

    public static final class a implements Iterator, InterfaceC5162a {
        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public i() {
        super(null);
    }

    @Override // Fa.c
    public int b() {
        return 0;
    }

    @Override // Fa.c
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Void get(int i10) {
        return null;
    }

    @Override // Fa.c
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void c(int i10, Void value) {
        kotlin.jvm.internal.p.i(value, "value");
        throw new IllegalStateException();
    }

    @Override // Fa.c, java.lang.Iterable
    public Iterator iterator() {
        return new a();
    }
}
