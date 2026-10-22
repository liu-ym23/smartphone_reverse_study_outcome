package s9;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import m9.AbstractC1683A;
import m9.AbstractC1689G;
import m9.AbstractC1701T;
import m9.AbstractC1729v;
import m9.C1727t;
import m9.t0;

/* renamed from: s9.e, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1925e extends AbstractC1689G implements J7.b, H7.c {
    public static final /* synthetic */ AtomicReferenceFieldUpdater h = AtomicReferenceFieldUpdater.newUpdater(C1925e.class, Object.class, "_reusableCancellableContinuation$volatile");
    private volatile /* synthetic */ Object _reusableCancellableContinuation$volatile;
    public final AbstractC1729v d;
    public final H7.c e;
    public Object f;
    public final Object g;

    public C1925e(AbstractC1729v abstractC1729v, H7.c cVar) {
        super(-1);
        this.d = abstractC1729v;
        this.e = cVar;
        this.f = AbstractC1921a.b;
        this.g = AbstractC1921a.k(cVar.getContext());
    }

    @Override // J7.b
    public final J7.b getCallerFrame() {
        H7.c cVar = this.e;
        if (cVar instanceof J7.b) {
            return (J7.b) cVar;
        }
        return null;
    }

    @Override // H7.c
    public final H7.h getContext() {
        return this.e.getContext();
    }

    @Override // m9.AbstractC1689G
    public final H7.c k() {
        return this;
    }

    @Override // m9.AbstractC1689G
    public final Object p() {
        Object obj = this.f;
        this.f = AbstractC1921a.b;
        return obj;
    }

    @Override // H7.c
    public final void resumeWith(Object obj) {
        Throwable thA = Result.a(obj);
        Object c1727t = thA == null ? obj : new C1727t(thA, false);
        H7.c cVar = this.e;
        H7.h context = cVar.getContext();
        AbstractC1729v abstractC1729v = this.d;
        if (abstractC1729v.isDispatchNeeded(context)) {
            this.f = c1727t;
            this.c = 0;
            abstractC1729v.dispatch(cVar.getContext(), this);
            return;
        }
        AbstractC1701T abstractC1701TA = t0.a();
        if (abstractC1701TA.f5319a >= 4294967296L) {
            this.f = c1727t;
            this.c = 0;
            abstractC1701TA.F(this);
            return;
        }
        abstractC1701TA.H(true);
        try {
            H7.h context2 = cVar.getContext();
            Object objL = AbstractC1921a.l(context2, this.g);
            try {
                cVar.resumeWith(obj);
                while (abstractC1701TA.J()) {
                }
            } finally {
                AbstractC1921a.g(context2, objL);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public final String toString() {
        return "DispatchedContinuation[" + this.d + ", " + AbstractC1683A.t(this.e) + ']';
    }
}
