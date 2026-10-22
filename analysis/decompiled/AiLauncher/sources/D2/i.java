package D2;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public abstract class i<TResult> {
    public abstract i<TResult> a(Executor executor, InterfaceC0791c interfaceC0791c);

    public abstract i<TResult> b(InterfaceC0792d<TResult> interfaceC0792d);

    public abstract i<TResult> c(Executor executor, InterfaceC0792d<TResult> interfaceC0792d);

    public abstract i<TResult> d(InterfaceC0793e interfaceC0793e);

    public abstract i<TResult> e(Executor executor, InterfaceC0793e interfaceC0793e);

    public abstract i<TResult> f(InterfaceC0794f<? super TResult> interfaceC0794f);

    public abstract i<TResult> g(Executor executor, InterfaceC0794f<? super TResult> interfaceC0794f);

    public abstract Exception h();

    public abstract TResult i();

    public abstract boolean j();

    public abstract boolean k();

    public abstract boolean l();

    public abstract <TContinuationResult> i<TContinuationResult> m(h<TResult, TContinuationResult> hVar);
}
