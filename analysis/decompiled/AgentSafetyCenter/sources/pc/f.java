package pc;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kc.c0;
import kc.j0;
import kc.l1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f extends c0 implements pb.d, nb.c {

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f9955l = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "_reusableCancellableContinuation$volatile");
    private volatile /* synthetic */ Object _reusableCancellableContinuation$volatile;

    /* renamed from: h, reason: collision with root package name */
    public kc.p f9956h;
    public pb.c i;

    /* renamed from: j, reason: collision with root package name */
    public Object f9957j;

    /* renamed from: k, reason: collision with root package name */
    public Object f9958k;

    @Override // pb.d
    public final pb.d getCallerFrame() {
        pb.c cVar = this.i;
        if (cVar != null) {
            return cVar;
        }
        return null;
    }

    @Override // nb.c
    public final nb.g getContext() {
        return this.i.getContext();
    }

    @Override // kc.c0
    public final Object h() {
        Object obj = this.f9957j;
        this.f9957j = a.f9944b;
        return obj;
    }

    @Override // nb.c
    public final void resumeWith(Object obj) {
        Throwable thB = jb.i.b(obj);
        Object nVar = thB == null ? obj : new kc.n(thB, false);
        kc.p pVar = this.f9956h;
        pb.c cVar = this.i;
        if (pVar.O(cVar.getContext())) {
            this.f9957j = nVar;
            this.f7419g = 0;
            pVar.M(cVar.getContext(), this);
            return;
        }
        j0 j0VarA = l1.a();
        if (j0VarA.f7444f >= 4294967296L) {
            this.f9957j = nVar;
            this.f7419g = 0;
            j0VarA.R(this);
            return;
        }
        j0VarA.S(true);
        try {
            nb.g context = cVar.getContext();
            Object objL = a.l(context, this.f9958k);
            try {
                cVar.resumeWith(obj);
                while (j0VarA.U()) {
                }
            } finally {
                a.g(context, objL);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public final String toString() {
        return "DispatchedContinuation[" + this.f9956h + ", " + kc.w.B(this.i) + ']';
    }

    @Override // kc.c0
    public final nb.c c() {
        return this;
    }
}
