package e2;

import android.content.Context;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import e2.s;
import g2.C4094a;
import java.util.concurrent.Executor;
import l2.B;
import l2.C;
import l2.C4866f;
import l2.C4867g;
import l2.C4868h;
import l2.I;
import l2.InterfaceC4863c;

/* renamed from: e2.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3977d extends s {

    /* renamed from: a, reason: collision with root package name */
    public X8.a<Executor> f32256a;

    /* renamed from: b, reason: collision with root package name */
    public X8.a<Context> f32257b;

    /* renamed from: c, reason: collision with root package name */
    public X8.a f32258c;

    /* renamed from: d, reason: collision with root package name */
    public X8.a f32259d;

    /* renamed from: e, reason: collision with root package name */
    public X8.a f32260e;

    /* renamed from: f, reason: collision with root package name */
    public X8.a<B> f32261f;

    /* renamed from: g, reason: collision with root package name */
    public X8.a<SchedulerConfig> f32262g;

    /* renamed from: h, reason: collision with root package name */
    public X8.a<k2.o> f32263h;

    /* renamed from: i, reason: collision with root package name */
    public X8.a<j2.c> f32264i;

    /* renamed from: j, reason: collision with root package name */
    public X8.a<k2.i> f32265j;

    /* renamed from: k, reason: collision with root package name */
    public X8.a<k2.m> f32266k;

    /* renamed from: l, reason: collision with root package name */
    public X8.a<r> f32267l;

    /* renamed from: e2.d$b */
    public static final class b implements s.a {

        /* renamed from: a, reason: collision with root package name */
        public Context f32268a;

        public b() {
        }

        @Override // e2.s.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(Context context) {
            this.f32268a = (Context) g2.d.b(context);
            return this;
        }

        @Override // e2.s.a
        public s build() {
            g2.d.a(this.f32268a, Context.class);
            return new C3977d(this.f32268a);
        }
    }

    public static s.a g() {
        return new b();
    }

    @Override // e2.s
    public InterfaceC4863c b() {
        return this.f32261f.get();
    }

    @Override // e2.s
    public r e() {
        return this.f32267l.get();
    }

    public final void i(Context context) {
        this.f32256a = C4094a.a(C3983j.a());
        g2.b bVarA = g2.c.a(context);
        this.f32257b = bVarA;
        f2.h hVarA = f2.h.a(bVarA, n2.c.a(), n2.d.a());
        this.f32258c = hVarA;
        this.f32259d = C4094a.a(f2.j.a(this.f32257b, hVarA));
        this.f32260e = I.a(this.f32257b, C4866f.a(), C4867g.a());
        this.f32261f = C4094a.a(C.a(n2.c.a(), n2.d.a(), C4868h.a(), this.f32260e));
        j2.g gVarB = j2.g.b(n2.c.a());
        this.f32262g = gVarB;
        j2.i iVarA = j2.i.a(this.f32257b, this.f32261f, gVarB, n2.d.a());
        this.f32263h = iVarA;
        X8.a<Executor> aVar = this.f32256a;
        X8.a aVar2 = this.f32259d;
        X8.a<B> aVar3 = this.f32261f;
        this.f32264i = j2.d.a(aVar, aVar2, iVarA, aVar3, aVar3);
        X8.a<Context> aVar4 = this.f32257b;
        X8.a aVar5 = this.f32259d;
        X8.a<B> aVar6 = this.f32261f;
        this.f32265j = k2.j.a(aVar4, aVar5, aVar6, this.f32263h, this.f32256a, aVar6, n2.c.a());
        X8.a<Executor> aVar7 = this.f32256a;
        X8.a<B> aVar8 = this.f32261f;
        this.f32266k = k2.n.a(aVar7, aVar8, this.f32263h, aVar8);
        this.f32267l = C4094a.a(t.a(n2.c.a(), n2.d.a(), this.f32264i, this.f32265j, this.f32266k));
    }

    public C3977d(Context context) {
        i(context);
    }
}
