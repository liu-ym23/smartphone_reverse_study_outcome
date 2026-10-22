package kotlin.coroutines.jvm.internal;

import e9.InterfaceC4014c;
import g9.C4110b;
import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b!\u0018\u00002\u00020\u0001B#\u0012\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB\u001b\b\u0016\u0012\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\tJ\u0015\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000fR \u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "Le9/c;", "", "completion", "Lkotlin/coroutines/d;", "_context", "<init>", "(Le9/c;Lkotlin/coroutines/d;)V", "(Le9/c;)V", "intercepted", "()Le9/c;", "LY8/t;", "releaseIntercepted", "()V", "Lkotlin/coroutines/d;", "Le9/c;", "getContext", "()Lkotlin/coroutines/d;", "context", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class ContinuationImpl extends BaseContinuationImpl {
    private final d _context;
    private transient InterfaceC4014c<Object> intercepted;

    public ContinuationImpl(InterfaceC4014c<Object> interfaceC4014c, d dVar) {
        super(interfaceC4014c);
        this._context = dVar;
    }

    @Override // e9.InterfaceC4014c
    public d getContext() {
        d dVar = this._context;
        p.f(dVar);
        return dVar;
    }

    public final InterfaceC4014c<Object> intercepted() {
        InterfaceC4014c<Object> interfaceC4014cInterceptContinuation = this.intercepted;
        if (interfaceC4014cInterceptContinuation == null) {
            c cVar = (c) getContext().get(c.INSTANCE);
            if (cVar == null || (interfaceC4014cInterceptContinuation = cVar.interceptContinuation(this)) == null) {
                interfaceC4014cInterceptContinuation = this;
            }
            this.intercepted = interfaceC4014cInterceptContinuation;
        }
        return interfaceC4014cInterceptContinuation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void releaseIntercepted() {
        InterfaceC4014c<?> interfaceC4014c = this.intercepted;
        if (interfaceC4014c != null && interfaceC4014c != this) {
            d.b bVar = getContext().get(c.INSTANCE);
            p.f(bVar);
            ((c) bVar).releaseInterceptedContinuation(interfaceC4014c);
        }
        this.intercepted = C4110b.f32706a;
    }

    public ContinuationImpl(InterfaceC4014c<Object> interfaceC4014c) {
        this(interfaceC4014c, interfaceC4014c != null ? interfaceC4014c.getContext() : null);
    }
}
