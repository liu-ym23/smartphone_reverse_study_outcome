package Fa;

import java.util.Iterator;
import java.util.NoSuchElementException;
import q9.InterfaceC5162a;

/* loaded from: classes5.dex */
public final class o<T> extends c<T> {

    /* renamed from: a, reason: collision with root package name */
    public final T f2658a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2659b;

    public static final class a implements Iterator<T>, InterfaceC5162a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f2660a = true;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o<T> f2661b;

        public a(o<T> oVar) {
            this.f2661b = oVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2660a;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.f2660a) {
                throw new NoSuchElementException();
            }
            this.f2660a = false;
            return this.f2661b.f();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(T value, int i10) {
        super(null);
        kotlin.jvm.internal.p.i(value, "value");
        this.f2658a = value;
        this.f2659b = i10;
    }

    @Override // Fa.c
    public int b() {
        return 1;
    }

    @Override // Fa.c
    public void c(int i10, T value) {
        kotlin.jvm.internal.p.i(value, "value");
        throw new IllegalStateException();
    }

    public final int e() {
        return this.f2659b;
    }

    public final T f() {
        return this.f2658a;
    }

    @Override // Fa.c
    public T get(int i10) {
        if (i10 == this.f2659b) {
            return this.f2658a;
        }
        return null;
    }

    @Override // Fa.c, java.lang.Iterable
    public Iterator<T> iterator() {
        return new a(this);
    }
}
