package io.reactivex.internal.functions;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.LongConsumer;
import io.reactivex.functions.Predicate;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Functions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Function f20598a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Runnable f20599b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Action f20600c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Consumer f20601d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Consumer f20602e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Consumer f20603f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final LongConsumer f20604g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Predicate f20605h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Predicate f20606i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Callable f20607j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Comparator f20608k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Consumer f20609l = null;

    public static final enum HashSetCallable extends Enum<HashSetCallable> implements Callable<Set<Object>> {
        private static final /* synthetic */ HashSetCallable[] $VALUES = null;
        public static final HashSetCallable INSTANCE = null;

        static {
            HashSetCallable r10 = new HashSetCallable("INSTANCE", 0);
            INSTANCE = r10;
            $VALUES = new HashSetCallable[]{r10};
        }

        private HashSetCallable(String r10, int r11) {
            super(r10, r11);
        }

        public static HashSetCallable valueOf(String r10) {
            return (HashSetCallable) Enum.valueOf(HashSetCallable.class, r10);
        }

        public static HashSetCallable[] values() {
            return (HashSetCallable[]) $VALUES.clone();
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Set<Object> call() throws Exception {
            return call2();
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public Set<Object> call2() throws Exception {
            return new HashSet();
        }
    }

    public static final enum NaturalComparator extends Enum<NaturalComparator> implements Comparator<Object> {
        private static final /* synthetic */ NaturalComparator[] $VALUES = null;
        public static final NaturalComparator INSTANCE = null;

        static {
            NaturalComparator r10 = new NaturalComparator("INSTANCE", 0);
            INSTANCE = r10;
            $VALUES = new NaturalComparator[]{r10};
        }

        private NaturalComparator(String r10, int r11) {
            super(r10, r11);
        }

        public static NaturalComparator valueOf(String r10) {
            return (NaturalComparator) Enum.valueOf(NaturalComparator.class, r10);
        }

        public static NaturalComparator[] values() {
            return (NaturalComparator[]) $VALUES.clone();
        }

        @Override // java.util.Comparator
        public int compare(Object r10, Object r11) {
            return ((Comparable) r10).compareTo(r11);
        }
    }

    public static final class a implements Action {
        public a() {
        }

        @Override // io.reactivex.functions.Action
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    public static final class b implements Consumer {
        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Object r10) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    public static final class c implements LongConsumer {
        public c() {
        }

        @Override // io.reactivex.functions.LongConsumer
        public void accept(long r10) {
        }
    }

    public static final class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    public static final class e implements Consumer {
        public e() {
        }

        public void a(Throwable r10) {
            qf.a.e(r10);
        }

        @Override // io.reactivex.functions.Consumer
        public /* bridge */ /* synthetic */ void accept(Object r10) {
            a((Throwable) r10);
        }
    }

    public static final class f implements Predicate {
        public f() {
        }

        @Override // io.reactivex.functions.Predicate
        public boolean test(Object r10) {
            return false;
        }
    }

    public static final class g implements Function {
        public g() {
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object r10) {
            return r10;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    public static final class h implements Consumer {
        public h() {
        }

        public void a(Subscription r10) {
            r10.request(Long.MAX_VALUE);
        }

        @Override // io.reactivex.functions.Consumer
        public /* bridge */ /* synthetic */ void accept(Object r10) {
            a((Subscription) r10);
        }
    }

    public static final class i implements Comparator {
        public i() {
        }

        @Override // java.util.Comparator
        public int compare(Object r10, Object r11) {
            return ((Comparable) r10).compareTo(r11);
        }
    }

    public static final class j implements Callable {
        public j() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }
    }

    public static final class k implements Consumer {
        public k() {
        }

        public void a(Throwable r10) {
            qf.a.e(new OnErrorNotImplementedException(r10));
        }

        @Override // io.reactivex.functions.Consumer
        public /* bridge */ /* synthetic */ void accept(Object r10) {
            a((Throwable) r10);
        }
    }

    public static final class l implements Predicate {
        public l() {
        }

        @Override // io.reactivex.functions.Predicate
        public boolean test(Object r10) {
            return true;
        }
    }

    static {
        f20598a = new g();
        f20599b = new d();
        f20600c = new a();
        f20601d = new b();
        f20602e = new e();
        f20603f = new k();
        f20604g = new c();
        f20605h = new l();
        f20606i = new f();
        f20607j = new j();
        f20608k = new i();
        f20609l = new h();
    }
}
