package v0;

import E0.a;
import E0.i;
import Q0.l;
import android.content.Context;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import q.C0933a;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name */
    private C0.k f23228b;

    /* renamed from: c, reason: collision with root package name */
    private D0.d f23229c;

    /* renamed from: d, reason: collision with root package name */
    private D0.b f23230d;

    /* renamed from: e, reason: collision with root package name */
    private E0.h f23231e;

    /* renamed from: f, reason: collision with root package name */
    private F0.a f23232f;

    /* renamed from: g, reason: collision with root package name */
    private F0.a f23233g;

    /* renamed from: h, reason: collision with root package name */
    private a.InterfaceC0020a f23234h;

    /* renamed from: i, reason: collision with root package name */
    private E0.i f23235i;

    /* renamed from: j, reason: collision with root package name */
    private Q0.d f23236j;

    /* renamed from: m, reason: collision with root package name */
    private l.b f23239m;

    /* renamed from: n, reason: collision with root package name */
    private F0.a f23240n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f23241o;

    /* renamed from: p, reason: collision with root package name */
    private List<T0.g<Object>> f23242p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f23243q;

    /* renamed from: a, reason: collision with root package name */
    private final Map<Class<?>, k<?, ?>> f23227a = new C0933a();

    /* renamed from: k, reason: collision with root package name */
    private int f23237k = 4;

    /* renamed from: l, reason: collision with root package name */
    private T0.h f23238l = new T0.h();

    ComponentCallbacks2C1180c a(Context context) {
        if (this.f23232f == null) {
            this.f23232f = F0.a.u();
        }
        if (this.f23233g == null) {
            this.f23233g = F0.a.o();
        }
        if (this.f23240n == null) {
            this.f23240n = F0.a.c();
        }
        if (this.f23235i == null) {
            this.f23235i = new i.a(context).a();
        }
        if (this.f23236j == null) {
            this.f23236j = new Q0.f();
        }
        if (this.f23229c == null) {
            int iB = this.f23235i.b();
            if (iB > 0) {
                this.f23229c = new D0.j(iB);
            } else {
                this.f23229c = new D0.e();
            }
        }
        if (this.f23230d == null) {
            this.f23230d = new D0.i(this.f23235i.a());
        }
        if (this.f23231e == null) {
            this.f23231e = new E0.g(this.f23235i.d());
        }
        if (this.f23234h == null) {
            this.f23234h = new E0.f(context);
        }
        if (this.f23228b == null) {
            this.f23228b = new C0.k(this.f23231e, this.f23234h, this.f23233g, this.f23232f, F0.a.w(), F0.a.c(), this.f23241o);
        }
        List<T0.g<Object>> list = this.f23242p;
        if (list == null) {
            this.f23242p = Collections.EMPTY_LIST;
        } else {
            this.f23242p = Collections.unmodifiableList(list);
        }
        return new ComponentCallbacks2C1180c(context, this.f23228b, this.f23231e, this.f23229c, this.f23230d, new l(this.f23239m), this.f23236j, this.f23237k, this.f23238l.L(), this.f23227a, this.f23242p, this.f23243q);
    }

    void b(l.b bVar) {
        this.f23239m = bVar;
    }
}
