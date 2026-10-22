package na;

import ia.d0;
import ia.k0;
import ia.m0;
import ia.x;
import ia.x0;
import ia.z1;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class g extends m0 implements i7.d, g7.d {

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6899m = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "_reusableCancellableContinuation$volatile");
    private volatile /* synthetic */ Object _reusableCancellableContinuation$volatile;

    /* renamed from: i, reason: collision with root package name */
    public final x f6900i;

    /* renamed from: j, reason: collision with root package name */
    public final i7.c f6901j;

    /* renamed from: k, reason: collision with root package name */
    public Object f6902k;

    /* renamed from: l, reason: collision with root package name */
    public final Object f6903l;

    public g(x xVar, i7.c cVar) {
        super(-1);
        this.f6900i = xVar;
        this.f6901j = cVar;
        this.f6902k = b.f6888b;
        this.f6903l = b.m(cVar.getContext());
    }

    @Override // ia.m0
    public final g7.d d() {
        return this;
    }

    @Override // i7.d
    public final i7.d getCallerFrame() {
        return this.f6901j;
    }

    @Override // g7.d
    public final g7.l getContext() {
        return this.f6901j.getContext();
    }

    @Override // ia.m0
    public final Object j() {
        Object obj = this.f6902k;
        this.f6902k = b.f6888b;
        return obj;
    }

    @Override // g7.d
    public final void resumeWith(Object obj) throws k0 {
        Throwable thA = c7.m.a(obj);
        Object vVar = thA == null ? obj : new ia.v(thA, false);
        i7.c cVar = this.f6901j;
        g7.l context = cVar.getContext();
        x xVar = this.f6900i;
        if (b.j(xVar, context)) {
            this.f6902k = vVar;
            this.f4976h = 0;
            b.i(xVar, cVar.getContext(), this);
            return;
        }
        x0 x0VarA = z1.a();
        if (x0VarA.f5023h >= 4294967296L) {
            this.f6902k = vVar;
            this.f4976h = 0;
            x0VarA.V(this);
            return;
        }
        x0VarA.X(true);
        try {
            g7.l context2 = cVar.getContext();
            Object objN = b.n(context2, this.f6903l);
            try {
                cVar.resumeWith(obj);
                while (x0VarA.Z()) {
                }
            } finally {
                b.g(context2, objN);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public final String toString() {
        return "DispatchedContinuation[" + this.f6900i + ", " + d0.y(this.f6901j) + ']';
    }
}
