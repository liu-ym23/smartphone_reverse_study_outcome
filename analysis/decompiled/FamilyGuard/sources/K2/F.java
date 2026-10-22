package K2;

import K2.q;
import M2.C0373j;
import M2.C0374k;
import M2.C0375l;
import M2.C0378o;
import M2.C0387y;
import M2.L;
import M2.M;
import M2.Q;
import M2.T;
import M2.Z;
import M2.a0;
import android.content.Context;
import android.view.View;

/* loaded from: classes.dex */
public final class F {

    /* renamed from: a, reason: collision with root package name */
    public static final F f3603a = new F();

    /* renamed from: b, reason: collision with root package name */
    private static final B<C0378o> f3604b = new C0375l();

    /* renamed from: c, reason: collision with root package name */
    private static final B<a0> f3605c = new Z();

    /* renamed from: d, reason: collision with root package name */
    private static final B<M> f3606d = new L();

    /* renamed from: e, reason: collision with root package name */
    private static final B<T> f3607e = new Q();

    /* renamed from: f, reason: collision with root package name */
    private static final B<C0374k> f3608f = new C0373j();

    /* renamed from: g, reason: collision with root package name */
    private static final B<M2.A> f3609g = new C0387y();

    public static final class a implements B<M2.C> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f3610a;

        /* renamed from: b, reason: collision with root package name */
        private static final M2.B f3611b;

        /* renamed from: c, reason: collision with root package name */
        private static final B<M2.C> f3612c;

        /* renamed from: d, reason: collision with root package name */
        private static final B<M2.C> f3613d;

        /* renamed from: e, reason: collision with root package name */
        private static final B<M2.C> f3614e;

        /* renamed from: K2.F$a$a, reason: collision with other inner class name */
        public static final class C0050a implements B<M2.C> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ q f3615a;

            C0050a(q qVar) {
                this.f3615a = qVar;
            }

            @Override // K2.B
            public boolean a(Context context) {
                j4.k.g(context, "context");
                return a.f3611b.a(context);
            }

            @Override // K2.B
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public s c(View view, M2.C c6) {
                j4.k.g(view, "view");
                j4.k.g(c6, "params");
                return a.f3611b.c(view, c6);
            }

            @Override // K2.B
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public M2.C b() {
                M2.C c6 = new M2.C();
                r.c(c6, this.f3615a);
                return c6;
            }

            @Override // K2.B
            public String getId() {
                return a.f3611b.getId();
            }
        }

        static {
            a aVar = new a();
            f3610a = aVar;
            f3611b = new M2.B();
            q.a aVar2 = q.f3643i;
            f3612c = aVar.h(aVar2.c());
            f3613d = aVar.h(aVar2.b());
            f3614e = aVar.h(aVar2.d());
        }

        private a() {
        }

        private final C0050a h(q qVar) {
            return new C0050a(qVar);
        }

        @Override // K2.B
        public boolean a(Context context) {
            j4.k.g(context, "context");
            return f3611b.a(context);
        }

        @Override // K2.B
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public s c(View view, M2.C c6) {
            j4.k.g(view, "view");
            j4.k.g(c6, "params");
            return f3611b.c(view, c6);
        }

        @Override // K2.B
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public M2.C b() {
            return f3611b.b();
        }

        public final B<M2.C> g() {
            return f3612c;
        }

        @Override // K2.B
        public String getId() {
            return f3611b.getId();
        }
    }

    private F() {
    }

    public final B<C0374k> a() {
        return f3608f;
    }

    public final B<C0378o> b() {
        return f3604b;
    }

    public final B<M2.A> c() {
        return f3609g;
    }

    public final B<M> d() {
        return f3606d;
    }

    public final B<T> e() {
        return f3607e;
    }

    public final B<a0> f() {
        return f3605c;
    }
}
