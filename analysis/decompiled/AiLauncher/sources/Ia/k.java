package Ia;

import Z8.AbstractC1162j;
import Z8.Y;
import Z8.r;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.internal.C4851b;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.z;
import q9.InterfaceC5162a;

/* loaded from: classes5.dex */
public final class k<T> extends AbstractC1162j<T> {

    /* renamed from: c, reason: collision with root package name */
    public static final b f3419c = new b(null);

    /* renamed from: a, reason: collision with root package name */
    public Object f3420a;

    /* renamed from: b, reason: collision with root package name */
    public int f3421b;

    public static final class a<T> implements Iterator<T>, InterfaceC5162a {

        /* renamed from: a, reason: collision with root package name */
        public final Iterator<T> f3422a;

        public a(T[] array) {
            p.i(array, "array");
            this.f3422a = C4851b.a(array);
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f3422a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.f3422a.next();
        }
    }

    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final <T> k<T> a() {
            return new k<>(null);
        }

        public final <T> k<T> b(Collection<? extends T> set) {
            p.i(set, "set");
            k<T> kVar = new k<>(null);
            kVar.addAll(set);
            return kVar;
        }

        public b() {
        }
    }

    public static final class c<T> implements Iterator<T>, InterfaceC5162a {

        /* renamed from: a, reason: collision with root package name */
        public final T f3423a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f3424b = true;

        public c(T t10) {
            this.f3423a = t10;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f3424b;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.f3424b) {
                throw new NoSuchElementException();
            }
            this.f3424b = false;
            return this.f3423a;
        }
    }

    public /* synthetic */ k(kotlin.jvm.internal.i iVar) {
        this();
    }

    public static final <T> k<T> c() {
        return f3419c.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.util.AbstractCollection, java.util.LinkedHashSet] */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(T t10) {
        Object[] objArr;
        if (size() == 0) {
            this.f3420a = t10;
        } else if (size() == 1) {
            if (p.d(this.f3420a, t10)) {
                return false;
            }
            this.f3420a = new Object[]{this.f3420a, t10};
        } else if (size() < 5) {
            Object obj = this.f3420a;
            p.g(obj, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            Object[] objArr2 = (Object[]) obj;
            if (r.R(objArr2, t10)) {
                return false;
            }
            if (size() == 4) {
                ?? G10 = Y.g(Arrays.copyOf(objArr2, objArr2.length));
                G10.add(t10);
                objArr = G10;
            } else {
                Object[] objArrCopyOf = Arrays.copyOf(objArr2, size() + 1);
                p.h(objArrCopyOf, "copyOf(...)");
                objArrCopyOf[objArrCopyOf.length - 1] = t10;
                objArr = objArrCopyOf;
            }
            this.f3420a = objArr;
        } else {
            Object obj2 = this.f3420a;
            p.g(obj2, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
            if (!z.f(obj2).add(t10)) {
                return false;
            }
        }
        e(size() + 1);
        return true;
    }

    @Override // Z8.AbstractC1162j
    public int b() {
        return this.f3421b;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f3420a = null;
        e(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (size() == 0) {
            return false;
        }
        if (size() == 1) {
            return p.d(this.f3420a, obj);
        }
        if (size() < 5) {
            Object obj2 = this.f3420a;
            p.g(obj2, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            return r.R((Object[]) obj2, obj);
        }
        Object obj3 = this.f3420a;
        p.g(obj3, "null cannot be cast to non-null type kotlin.collections.Set<T of org.jetbrains.kotlin.utils.SmartSet>");
        return ((Set) obj3).contains(obj);
    }

    public void e(int i10) {
        this.f3421b = i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<T> iterator() {
        if (size() == 0) {
            return Collections.EMPTY_SET.iterator();
        }
        if (size() == 1) {
            return new c(this.f3420a);
        }
        if (size() < 5) {
            Object obj = this.f3420a;
            p.g(obj, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            return new a((Object[]) obj);
        }
        Object obj2 = this.f3420a;
        p.g(obj2, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
        return z.f(obj2).iterator();
    }

    public k() {
    }
}
