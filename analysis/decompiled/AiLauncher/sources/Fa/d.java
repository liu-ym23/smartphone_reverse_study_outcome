package Fa;

import Z8.AbstractC1155c;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes5.dex */
public final class d<T> extends c<T> {

    /* renamed from: c, reason: collision with root package name */
    public static final a f2631c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public Object[] f2632a;

    /* renamed from: b, reason: collision with root package name */
    public int f2633b;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    public static final class b extends AbstractC1155c<T> {

        /* renamed from: c, reason: collision with root package name */
        public int f2634c = -1;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ d<T> f2635d;

        public b(d<T> dVar) {
            this.f2635d = dVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // Z8.AbstractC1155c
        public void a() {
            do {
                int i10 = this.f2634c + 1;
                this.f2634c = i10;
                if (i10 >= this.f2635d.f2632a.length) {
                    break;
                }
            } while (this.f2635d.f2632a[this.f2634c] == null);
            if (this.f2634c >= this.f2635d.f2632a.length) {
                b();
                return;
            }
            Object obj = this.f2635d.f2632a[this.f2634c];
            kotlin.jvm.internal.p.g(obj, "null cannot be cast to non-null type T of org.jetbrains.kotlin.util.ArrayMapImpl");
            c(obj);
        }
    }

    public d(Object[] objArr, int i10) {
        super(null);
        this.f2632a = objArr;
        this.f2633b = i10;
    }

    private final void f(int i10) {
        Object[] objArr = this.f2632a;
        if (objArr.length > i10) {
            return;
        }
        int length = objArr.length;
        do {
            length *= 2;
        } while (length <= i10);
        Object[] objArrCopyOf = Arrays.copyOf(this.f2632a, length);
        kotlin.jvm.internal.p.h(objArrCopyOf, "copyOf(...)");
        this.f2632a = objArrCopyOf;
    }

    @Override // Fa.c
    public int b() {
        return this.f2633b;
    }

    @Override // Fa.c
    public void c(int i10, T value) {
        kotlin.jvm.internal.p.i(value, "value");
        f(i10);
        if (this.f2632a[i10] == null) {
            this.f2633b = b() + 1;
        }
        this.f2632a[i10] = value;
    }

    @Override // Fa.c
    public T get(int i10) {
        return (T) Z8.r.j0(this.f2632a, i10);
    }

    @Override // Fa.c, java.lang.Iterable
    public Iterator<T> iterator() {
        return new b(this);
    }

    public d() {
        this(new Object[20], 0);
    }
}
