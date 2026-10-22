package kotlinx.coroutines.debug.internal;

import bg.h;
import com.bytedance.apm.constant.CommonKey;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.collections.g;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class ConcurrentWeakMap extends kotlin.collections.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f21374b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f21375c = null;

    @Volatile
    private volatile int _size;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReferenceQueue f21376a;

    @Volatile
    @Nullable
    private volatile Object core;

    public final class a {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final AtomicIntegerFieldUpdater f21377g = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f21378a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f21379b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f21380c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicReferenceArray f21381d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicReferenceArray f21382e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ConcurrentWeakMap f21383f;

        @Volatile
        private volatile int load;

        /* JADX INFO: renamed from: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$a$a, reason: collision with other inner class name */
        public final class C0293a implements Iterator, KMutableIterator {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Function2 f21384a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f21385b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Object f21386c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Object f21387d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ a f21388e;

            public C0293a(a r10, Function2 r11) {
                this.f21388e = r10;
                this.f21384a = r11;
                this.f21385b = -1;
                a();
            }

            public final void a() {
            L2:
                int r10 = this.f21385b + 1;
                this.f21385b = r10;
                if (r10 >= a.a(this.f21388e)) goto L23;
                d r11 = (d) a.b(this.f21388e).get(this.f21385b);
                if (r11 == null) goto L2;
                T r12 = r11.get();
                if (r12 == 0) goto L2;
                this.f21386c = r12;
                Object r13 = a.c(this.f21388e).get(this.f21385b);
                if ((r13 instanceof e) == false) goto L12;
                r13 = ((e) r13).f21409a;
            L12:
                if (r13 == null) goto L2;
                this.f21387d = r13;
                return;
            }

            public Void b() {
                kotlinx.coroutines.debug.internal.a.c();
                throw new KotlinNothingValueException();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.f21385b >= a.a(this.f21388e)) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // java.util.Iterator
            public Object next() {
                if (this.f21385b >= a.a(this.f21388e)) goto L13;
                Function2 r10 = this.f21384a;
                Object r11 = this.f21386c;
                if (r11 != null) goto L7;
                q.y("key");
                r11 = Unit.f21064a;
            L7:
                Object r12 = this.f21387d;
                if (r12 != null) goto L10;
                q.y(CommonKey.KEY_VALUE);
                r12 = Unit.f21064a;
            L10:
                Object r13 = r10.mo0invoke(r11, r12);
                a();
                return r13;
            L13:
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public /* bridge */ /* synthetic */ void remove() {
                b();
            }
        }

        static {
            f21377g = AtomicIntegerFieldUpdater.newUpdater(a.class, Card.KEY_API_LOAD);
        }

        public a(ConcurrentWeakMap r10, int r11) {
            this.f21383f = r10;
            this.f21378a = r11;
            this.f21379b = Integer.numberOfLeadingZeros(r11) + 1;
            this.f21380c = (r11 * 2) / 3;
            this.f21381d = new AtomicReferenceArray(r11);
            this.f21382e = new AtomicReferenceArray(r11);
        }

        public static final /* synthetic */ int a(a r10) {
            return r10.f21378a;
        }

        public static final /* synthetic */ AtomicReferenceArray b(a r10) {
            return r10.f21381d;
        }

        public static final /* synthetic */ AtomicReferenceArray c(a r10) {
            return r10.f21382e;
        }

        public static /* synthetic */ Object i(a r10, Object r11, Object r12, d r13, int r14, Object r15) {
            if ((r14 & 4) == 0) goto L6;
            r13 = null;
        L6:
            return r10.h(r11, r12, r13);
        }

        public final void d(d r10) {
            int r11 = f(r10.f21408a);
        L3:
            d r12 = (d) this.f21381d.get(r11);
            if (r12 == null) goto L5;
            if (r12 == r10) goto L7;
            if (r11 != 0) goto L11;
            r11 = this.f21378a;
        L11:
            r11 = r11 - 1;
            goto L3
        L7:
            k(r11);
            return;
        }

        public final Object e(Object r10) {
            int r11 = f(r10.hashCode());
        L3:
            d r12 = (d) this.f21381d.get(r11);
            if (r12 == null) goto L5;
            T r13 = r12.get();
            if (q.b(r10, r13) == true) goto L9;
            if (r13 != 0) goto L15;
            k(r11);
        L15:
            if (r11 != 0) goto L17;
            r11 = this.f21378a;
        L17:
            r11 = r11 - 1;
            goto L3
        L9:
            Object r14 = this.f21382e.get(r11);
            if ((r14 instanceof e) == true) goto L12;
            return r14;
        L12:
            return ((e) r14).f21409a;
        L5:
            return null;
        }

        public final int f(int r10) {
            return (r10 * (-1640531527)) >>> this.f21379b;
        }

        public final Iterator g(Function2 r10) {
            return new C0293a(this, r10);
        }

        public final Object h(Object r10, Object r11, d r12) {
            int r13 = f(r10.hashCode());
            boolean r14 = false;
        L3:
            d r15 = (d) this.f21381d.get(r13);
            if (r15 == null) goto L6;
            T r16 = r15.get();
            if (q.b(r10, r16) == true) goto L24;
            if (r16 != 0) goto L35;
            k(r13);
        L35:
            if (r13 != 0) goto L37;
            r13 = this.f21378a;
        L37:
            r13 = r13 - 1;
            goto L3
        L24:
            if (r14 == false) goto L26;
            f21377g.decrementAndGet(this);
        L26:
            Object r17 = this.f21382e.get(r13);
            if ((r17 instanceof e) == true) goto L29;
            if (com.google.common.util.concurrent.b.a(this.f21382e, r13, r17, r11) == false) goto L26;
            return r17;
        L29:
            return kotlinx.coroutines.debug.internal.a.a();
        L6:
            if (r11 == null) goto L7;
            if (r14 == true) goto L17;
            AtomicIntegerFieldUpdater r18 = f21377g;
        L10:
            int r19 = r18.get(this);
            if (r19 >= this.f21380c) goto L13;
            if (r18.compareAndSet(this, r19, r19 + 1) == false) goto L10;
            r14 = true;
            goto L17
        L13:
            return kotlinx.coroutines.debug.internal.a.a();
        L17:
            if (r12 != null) goto L20;
            r12 = new d(r10, ConcurrentWeakMap.g(this.f21383f));
        L20:
            if (com.google.common.util.concurrent.b.a(this.f21381d, r13, null, r12) == true) goto L26;
        L7:
            return null;
        }

        public final a j() {
        L2:
            int r10 = Integer.highestOneBit(h.d(this.f21383f.size(), 4)) * 4;
            a r11 = new a(this.f21383f, r10);
            int r12 = this.f21378a;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L21;
            d r14 = (d) this.f21381d.get(r13);
            if (r14 == null) goto L7;
            Object r15 = r14.get();
        L8:
            if (r14 == null) goto L11;
            if (r15 != null) goto L11;
            k(r13);
        L11:
            Object r16 = this.f21382e.get(r13);
            if ((r16 instanceof e) == true) goto L13;
            if (com.google.common.util.concurrent.b.a(this.f21382e, r13, r16, kotlinx.coroutines.debug.internal.a.b(r16)) == false) goto L11;
        L16:
            if (r15 == null) goto L20;
            if (r16 == null) goto L20;
            if (r11.h(r15, r16, r14) == kotlinx.coroutines.debug.internal.a.a()) goto L2;
        L20:
            r13 = r13 + 1;
            goto L3
        L13:
            r16 = ((e) r16).f21409a;
            goto L16
        L7:
            r15 = null;
            goto L8
        L21:
            return r11;
        }

        public final void k(int r10) {
        L2:
            Object r11 = this.f21382e.get(r10);
            if (r11 == null) goto L4;
            if ((r11 instanceof e) == true) goto L7;
            if (com.google.common.util.concurrent.b.a(this.f21382e, r10, r11, null) == false) goto L2;
            ConcurrentWeakMap.e(this.f21383f);
            return;
        L7:
            return;
        }
    }

    public static final class b implements Map.Entry, KMutableMap.Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f21389a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f21390b;

        public b(Object r10, Object r11) {
            this.f21389a = r10;
            this.f21390b = r11;
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f21389a;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f21390b;
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object r10) {
            kotlinx.coroutines.debug.internal.a.c();
            throw new KotlinNothingValueException();
        }
    }

    public final class c extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function2 f21391a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ConcurrentWeakMap f21392b;

        public c(ConcurrentWeakMap r10, Function2 r11) {
            this.f21392b = r10;
            this.f21391a = r11;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(Object r10) {
            kotlinx.coroutines.debug.internal.a.c();
            throw new KotlinNothingValueException();
        }

        @Override // kotlin.collections.g
        public int getSize() {
            return this.f21392b.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return ((a) ConcurrentWeakMap.f().get(this.f21392b)).g(this.f21391a);
        }
    }

    static {
        f21374b = AtomicIntegerFieldUpdater.newUpdater(ConcurrentWeakMap.class, "_size");
        f21375c = AtomicReferenceFieldUpdater.newUpdater(ConcurrentWeakMap.class, Object.class, "core");
    }

    public /* synthetic */ ConcurrentWeakMap(boolean r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = false;
    L5:
        this(r10);
    }

    public static final /* synthetic */ void e(ConcurrentWeakMap r10) {
        r10.i();
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater f() {
        return f21375c;
    }

    public static final /* synthetic */ ReferenceQueue g(ConcurrentWeakMap r10) {
        return r10.f21376a;
    }

    @Override // kotlin.collections.f
    public Set a() {
        return new c(this, ConcurrentWeakMap$entries$1.INSTANCE);
    }

    @Override // kotlin.collections.f
    public Set b() {
        return new c(this, ConcurrentWeakMap$keys$1.INSTANCE);
    }

    @Override // kotlin.collections.f
    public int c() {
        return f21374b.get(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Iterator r10 = keySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        remove(r10.next());
        goto L4
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return ((a) f21375c.get(this)).e(r10);
    }

    public final void h(d r10) {
        ((a) f21375c.get(this)).d(r10);
    }

    public final void i() {
        f21374b.decrementAndGet(this);
    }

    public final synchronized Object j(Object r10, Object r11) {
        monitor-enter(this);
        a r12 = (a) f21375c.get(this);     // Catch: Throwable -> L9
    L4:
        Object r13 = a.i(r12, r10, r11, null, 4, null);     // Catch: Throwable -> L9
        if (r13 != kotlinx.coroutines.debug.internal.a.a()) goto L6;
        r12 = r12.j();     // Catch: Throwable -> L9
        f21375c.set(this, r12);     // Catch: Throwable -> L9
        goto L4
    L6:
        monitor-exit(this);
        return r13;
    L9:
        th = move-exception;
        throw th;
    }

    public final void k() {
        if (this.f21376a == null) goto L9;
    L10:
        Reference r10 = this.f21376a.remove();     // Catch: InterruptedException -> L6
        q.e(r10, "null cannot be cast to non-null type kotlinx.coroutines.debug.internal.HashedWeakRef<*>");     // Catch: InterruptedException -> L6
        h((d) r10);     // Catch: InterruptedException -> L6
    L6:
        Thread.currentThread().interrupt();
        return;
    L9:
        throw new IllegalStateException("Must be created with weakRefQueue = true");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object r10, Object r11) {
        Object r12 = a.i((a) f21375c.get(this), r10, r11, null, 4, null);
        if (r12 != kotlinx.coroutines.debug.internal.a.a()) goto L5;
        r12 = j(r10, r11);
    L5:
        if (r12 != null) goto L7;
        f21374b.incrementAndGet(this);
    L7:
        return r12;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        Object r11 = a.i((a) f21375c.get(this), r10, null, null, 4, null);
        if (r11 != kotlinx.coroutines.debug.internal.a.a()) goto L8;
        r11 = j(r10, null);
    L8:
        if (r11 == null) goto L10;
        f21374b.decrementAndGet(this);
    L10:
        return r11;
    }

    public ConcurrentWeakMap(boolean r10) {
        this.core = new a(this, 16);
        if (r10 == false) goto L5;
        ReferenceQueue r11 = new ReferenceQueue();
    L6:
        this.f21376a = r11;
        return;
    L5:
        r11 = null;
        goto L6
    }
}
