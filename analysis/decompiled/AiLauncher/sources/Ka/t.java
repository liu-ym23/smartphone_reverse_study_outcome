package Ka;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import q9.InterfaceC5162a;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001a#\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a-\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005\"\u00028\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\t\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a\u0019\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000¢\u0006\u0004\b\f\u0010\r\u001a)\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a+\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00100\u0002H\u0007¢\u0006\u0004\b\u0011\u0010\u000f\u001aE\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0012*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00010\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001a#\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0017\u0010\u000f\u001a-\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0000*\u00020\u00182\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0019¢\u0006\u0004\b\u001b\u0010\u001c\u001a?\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0000*\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00018\u00002\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0013H\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001aC\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0000*\u00020\u00182\u000e\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00192\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0013¢\u0006\u0004\b!\u0010\"¨\u0006#"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "LKa/j;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/util/Iterator;)LKa/j;", "", "elements", "w", "([Ljava/lang/Object;)LKa/j;", "element", "v", "(Ljava/lang/Object;)LKa/j;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()LKa/j;", "k", "(LKa/j;)LKa/j;", "", "p", "R", "Lkotlin/Function1;", "iterator", "l", "(LKa/j;Lp9/l;)LKa/j;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "", "Lkotlin/Function0;", "nextFunction", "r", "(Lp9/a;)LKa/j;", "seed", "q", "(Ljava/lang/Object;Lp9/l;)LKa/j;", "seedFunction", "s", "(Lp9/a;Lp9/l;)LKa/j;", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/sequences/SequencesKt")
/* loaded from: classes5.dex */
public class t extends n {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Ka/t$a", "LKa/j;", "", "iterator", "()Ljava/util/Iterator;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements j<T> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator f4236a;

        public a(Iterator it) {
            this.f4236a = it;
        }

        @Override // Ka.j
        public Iterator<T> iterator() {
            return this.f4236a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Ka/t$b", "LKa/j;", "", "iterator", "()Ljava/util/Iterator;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b<T> implements j<T> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f4237a;

        public b(Object obj) {
            this.f4237a = obj;
        }

        @Override // Ka.j
        public Iterator<T> iterator() {
            return new c(this.f4237a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0002\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Ka/t$c", "", "next", "()Ljava/lang/Object;", "", "hasNext", "()Z", Const.INTENT_KEY_APIKEY, "Z", "_hasNext", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c<T> implements Iterator<T>, InterfaceC5162a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public boolean _hasNext = true;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ T f4239b;

        public c(T t10) {
            this.f4239b = t10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this._hasNext;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this._hasNext) {
                throw new NoSuchElementException();
            }
            this._hasNext = false;
            return this.f4239b;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static <T> j<T> h(Iterator<? extends T> it) {
        kotlin.jvm.internal.p.i(it, "<this>");
        return i(new a(it));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> j<T> i(j<? extends T> jVar) {
        kotlin.jvm.internal.p.i(jVar, "<this>");
        return jVar instanceof C0927a ? jVar : new C0927a(jVar);
    }

    public static <T> j<T> j() {
        return f.f4209a;
    }

    public static final <T> j<T> k(j<? extends j<? extends T>> jVar) {
        kotlin.jvm.internal.p.i(jVar, "<this>");
        return l(jVar, new InterfaceC5074l() { // from class: Ka.q
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return t.m((j) obj);
            }
        });
    }

    public static final <T, R> j<R> l(j<? extends T> jVar, InterfaceC5074l<? super T, ? extends Iterator<? extends R>> interfaceC5074l) {
        return jVar instanceof A ? ((A) jVar).e(interfaceC5074l) : new h(jVar, new InterfaceC5074l() { // from class: Ka.s
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return t.o(obj);
            }
        }, interfaceC5074l);
    }

    public static final Iterator m(j it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.iterator();
    }

    public static final Iterator n(Iterable it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.iterator();
    }

    public static final Object o(Object obj) {
        return obj;
    }

    public static <T> j<T> p(j<? extends Iterable<? extends T>> jVar) {
        kotlin.jvm.internal.p.i(jVar, "<this>");
        return l(jVar, new InterfaceC5074l() { // from class: Ka.r
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return t.n((Iterable) obj);
            }
        });
    }

    public static <T> j<T> q(final T t10, InterfaceC5074l<? super T, ? extends T> nextFunction) {
        kotlin.jvm.internal.p.i(nextFunction, "nextFunction");
        return t10 == null ? f.f4209a : new i(new InterfaceC5063a() { // from class: Ka.o
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return t.u(t10);
            }
        }, nextFunction);
    }

    public static <T> j<T> r(final InterfaceC5063a<? extends T> nextFunction) {
        kotlin.jvm.internal.p.i(nextFunction, "nextFunction");
        return i(new i(nextFunction, new InterfaceC5074l() { // from class: Ka.p
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return t.t(nextFunction, obj);
            }
        }));
    }

    public static <T> j<T> s(InterfaceC5063a<? extends T> seedFunction, InterfaceC5074l<? super T, ? extends T> nextFunction) {
        kotlin.jvm.internal.p.i(seedFunction, "seedFunction");
        kotlin.jvm.internal.p.i(nextFunction, "nextFunction");
        return new i(seedFunction, nextFunction);
    }

    public static final Object t(InterfaceC5063a interfaceC5063a, Object it) {
        kotlin.jvm.internal.p.i(it, "it");
        return interfaceC5063a.invoke();
    }

    public static final Object u(Object obj) {
        return obj;
    }

    public static <T> j<T> v(T t10) {
        return new b(t10);
    }

    public static <T> j<T> w(T... elements) {
        kotlin.jvm.internal.p.i(elements, "elements");
        return Z8.r.M(elements);
    }
}
