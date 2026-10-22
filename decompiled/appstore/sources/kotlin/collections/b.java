package kotlin.collections;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.coroutines.channels.Channel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b extends AbstractCollection implements List, KMappedMarker {

    @NotNull
    public static final a Companion = null;
    private static final int maxArraySize = 2147483639;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final void a(int r10, int r11) {
            if (r10 < 0) goto L6;
            if (r10 >= r11) goto L6;
            return;
        L6:
            throw new IndexOutOfBoundsException("index: " + r10 + ", size: " + r11);
        }

        public final void b(int r10, int r11) {
            if (r10 < 0) goto L6;
            if (r10 > r11) goto L6;
            return;
        L6:
            throw new IndexOutOfBoundsException("index: " + r10 + ", size: " + r11);
        }

        public final void c(int r10, int r11, int r12) {
            if (r10 < 0) goto L10;
            if (r11 > r12) goto L10;
            if (r10 > r11) goto L8;
            return;
        L8:
            throw new IllegalArgumentException("fromIndex: " + r10 + " > toIndex: " + r11);
        L10:
            throw new IndexOutOfBoundsException("fromIndex: " + r10 + ", toIndex: " + r11 + ", size: " + r12);
        }

        public final int d(int r10, int r11) {
            int r12 = r10 + (r10 >> 1);
            if ((r12 - r11) >= 0) goto L5;
            r12 = r11;
        L5:
            int r13 = b.maxArraySize;
            if ((r12 - b.maxArraySize) <= 0) goto L11;
            if (r11 <= b.maxArraySize) goto L10;
            r13 = Channel.UNLIMITED;
        L10:
            return r13;
        L11:
            return r12;
        }

        public final boolean e(Collection r10, Collection r11) {
            kotlin.jvm.internal.q.g(r10, "c");
            kotlin.jvm.internal.q.g(r11, AppInfo.SEARCH_SOURCE_EXTENAL);
            if (r10.size() == r11.size()) goto L5;
            return false;
        L5:
            Iterator r12 = r11.iterator();
            Iterator r13 = r10.iterator();
        L7:
            if (r13.hasNext() == false) goto L11;
            if (kotlin.jvm.internal.q.b(r13.next(), r12.next()) == true) goto L7;
            return false;
        L11:
            return true;
        }

        public final int f(Collection r10) {
            kotlin.jvm.internal.q.g(r10, "c");
            Iterator r11 = r10.iterator();
            int r12 = 1;
        L4:
            if (r11.hasNext() == false) goto L10;
            Object r13 = r11.next();
            int r14 = r12 * 31;
            if (r13 == null) goto L8;
            int r15 = r13.hashCode();
        L9:
            r12 = r14 + r15;
            goto L4
        L8:
            r15 = 0;
            goto L9
        L10:
            return r12;
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: kotlin.collections.b$b, reason: collision with other inner class name */
    public class C0292b implements Iterator, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f21069a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f21070b;

        public C0292b(b r10) {
            this.f21070b = r10;
        }

        public final int a() {
            return this.f21069a;
        }

        public final void b(int r10) {
            this.f21069a = r10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f21069a >= this.f21070b.size()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (hasNext() == false) goto L7;
            b r10 = this.f21070b;
            int r11 = this.f21069a;
            this.f21069a = r11 + 1;
            return r10.get(r11);
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public class c extends C0292b implements ListIterator, KMappedMarker {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f21071c;

        public c(b r10, int r11) {
            this.f21071c = r10;
            super(r10);
            b.Companion.b(r11, r10.size());
            b(r11);
        }

        @Override // java.util.ListIterator
        public void add(Object r10) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            if (a() <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return a();
        }

        @Override // java.util.ListIterator
        public Object previous() {
            if (hasPrevious() == false) goto L7;
            b r10 = this.f21071c;
            b(a() - 1);
            return r10.get(a());
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return a() - 1;
        }

        @Override // java.util.ListIterator
        public void set(Object r10) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static final class d extends b implements RandomAccess {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f21072a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f21073b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f21074c;

        public d(b r10, int r11, int r12) {
            kotlin.jvm.internal.q.g(r10, ServerElements.LIST);
            this.f21072a = r10;
            this.f21073b = r11;
            b.Companion.c(r11, r12, r10.size());
            this.f21074c = r12 - r11;
        }

        @Override // kotlin.collections.b, java.util.List
        public Object get(int r10) {
            b.Companion.a(r10, this.f21074c);
            return this.f21072a.get(this.f21073b + r10);
        }

        @Override // kotlin.collections.AbstractCollection
        public int getSize() {
            return this.f21074c;
        }
    }

    static {
        Companion = new a(null);
    }

    public b() {
    }

    @Override // java.util.List
    public void add(int r10, Object r11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int r10, Collection<Object> r11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(@Nullable Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof List) == true) goto L10;
        return false;
    L10:
        return Companion.e(this, (Collection) r10);
    }

    @Override // java.util.List
    public abstract Object get(int r10);

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return Companion.f(this);
    }

    @Override // java.util.List
    public int indexOf(Object r10) {
        Iterator r11 = iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L9;
        if (kotlin.jvm.internal.q.b(r11.next(), r10) == true) goto L13;
        r12 = r12 + 1;
        goto L4
    L13:
        return r12;
    L9:
        return -1;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    @NotNull
    public Iterator<Object> iterator() {
        return new C0292b(this);
    }

    @Override // java.util.List
    public int lastIndexOf(Object r10) {
        ListIterator r11 = listIterator(size());
    L4:
        if (r11.hasPrevious() == false) goto L8;
        if (kotlin.jvm.internal.q.b(r11.previous(), r10) == false) goto L4;
        return r11.nextIndex();
    L8:
        return -1;
    }

    @Override // java.util.List
    @NotNull
    public ListIterator<Object> listIterator() {
        return new c(this, 0);
    }

    @Override // java.util.List
    public Object remove(int r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public Object set(int r10, Object r11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    @NotNull
    public List<Object> subList(int r10, int r11) {
        return new d(this, r10, r11);
    }

    @Override // java.util.List
    @NotNull
    public ListIterator<Object> listIterator(int r10) {
        return new c(this, r10);
    }
}
