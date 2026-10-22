package f6;

import a6.a1;
import a6.b0;
import a6.i0;
import a6.o0;
import a6.q0;
import a6.v;
import a6.z1;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e extends q0 implements h5.d, f5.c {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f2637h = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_reusableCancellableContinuation$volatile");
    private volatile /* synthetic */ Object _reusableCancellableContinuation$volatile;
    public final b0 d;

    /* renamed from: e, reason: collision with root package name */
    public final h5.c f2638e;

    /* renamed from: f, reason: collision with root package name */
    public Object f2639f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f2640g;

    public e(b0 b0Var, h5.c cVar) {
        super(-1);
        this.d = b0Var;
        this.f2638e = cVar;
        this.f2639f = a.f2628b;
        this.f2640g = a.m(cVar.getContext());
    }

    @Override // h5.d
    public final h5.d getCallerFrame() {
        return this.f2638e;
    }

    @Override // f5.c
    public final f5.h getContext() {
        return this.f2638e.getContext();
    }

    @Override // a6.q0
    public final Object i() {
        Object obj = this.f2639f;
        this.f2639f = a.f2628b;
        return obj;
    }

    @Override // f5.c
    public final void resumeWith(Object obj) throws o0 {
        Throwable thA = b5.i.a(obj);
        Object vVar = thA == null ? obj : new v(thA, false);
        h5.c cVar = this.f2638e;
        f5.h context = cVar.getContext();
        b0 b0Var = this.d;
        if (a.j(b0Var, context)) {
            this.f2639f = vVar;
            this.f209c = 0;
            a.i(b0Var, cVar.getContext(), this);
            return;
        }
        a1 a1VarA = z1.a();
        if (a1VarA.f132c >= 4294967296L) {
            this.f2639f = vVar;
            this.f209c = 0;
            a1VarA.I(this);
            return;
        }
        a1VarA.K(true);
        try {
            f5.h context2 = cVar.getContext();
            Object objN = a.n(context2, this.f2640g);
            try {
                cVar.resumeWith(obj);
                while (a1VarA.M()) {
                }
            } finally {
                a.g(context2, objN);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public final String toString() {
        return "DispatchedContinuation[" + this.d + ", " + i0.x(this.f2638e) + AbstractJsonLexerKt.END_LIST;
    }

    @Override // a6.q0
    public final f5.c d() {
        return this;
    }
}
