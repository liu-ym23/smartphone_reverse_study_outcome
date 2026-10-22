package com.jeffmony.async.future;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes3.dex */
public class SimpleFuture extends d implements DependentFuture {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.jeffmony.async.a f10392f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Exception f10393g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f10394h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f10395i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public FutureCallbackInternal f10396j;

    public interface FutureCallbackInternal<T> {
        void onCompleted(Exception r10, T r11, a r12);
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Exception f10397a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f10398b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public FutureCallbackInternal f10399c;

        public a() {
        }

        public void a() {
        L2:
            FutureCallbackInternal r10 = this.f10399c;
            if (r10 == null) goto L5;
            Exception r11 = this.f10397a;
            Object r12 = this.f10398b;
            this.f10399c = null;
            this.f10397a = null;
            this.f10398b = null;
            r10.onCompleted(r11, r12, this);
            goto L2
        }
    }

    public SimpleFuture() {
    }

    public static /* synthetic */ void B(SuccessCallback r10, SimpleFuture r11, Exception e10, Object r12, a r13) {
        if (e10 == null) goto L8;
    L6:
        r11.J(e10, r12, r13);
        return;
    L8:
        r10.success(r12);     // Catch: Exception -> L5
    L5:
        e10 = e;
        goto L6
    }

    public static /* synthetic */ void C(SimpleFuture r10, ThenFutureCallback r11, Exception r12, Object r13, a r14) {
        if (r12 == null) goto L12;
        r10.J(r12, null, r14);
        return;
    L12:
        r10.H(r11.then(r13), r14);
        return;
    L9:
        e = move-exception;
        r10.J(e, null, r14);
    }

    public static /* synthetic */ Future D(ThenCallback r10, Object r11) {
        return new SimpleFuture(r10.then(r11));
    }

    public static /* synthetic */ void f(SuccessCallback r10, SimpleFuture r11, Exception r12, Object r13, a r14) {
        B(r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ Future g(ThenCallback r10, Object r11) {
        return D(r10, r11);
    }

    public static /* synthetic */ void h(SimpleFuture r10, SimpleFuture r11, Exception r12, Object r13) {
        r10.A(r11, r12, r13);
    }

    public static /* synthetic */ void i(FutureCallback r10, Exception r11, Object r12, a r13) {
        y(r10, r11, r12, r13);
    }

    public static /* synthetic */ void j(DoneCallback r10, SimpleFuture r11, Exception r12, Object r13, a r14) {
        u(r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ void k(SimpleFuture r10, FailRecoverCallback r11, Exception r12, Object r13, a r14) {
        x(r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ void l(SimpleFuture r10, ThenFutureCallback r11, Exception r12, Object r13, a r14) {
        C(r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ Future m(FailCallback r10, Exception r11) {
        return v(r10, r11);
    }

    public static /* synthetic */ Future n(FailConvertCallback r10, Exception r11) {
        return w(r10, r11);
    }

    public static /* synthetic */ void o(SimpleFuture r10, SimpleFuture r11, Exception r12, Object r13, a r14) {
        r10.z(r11, r12, r13, r14);
    }

    public static /* synthetic */ void u(DoneCallback r10, SimpleFuture r11, Exception e10, Object r12, a r13) {
        if (e10 == null) goto L8;
    L6:
        r11.J(e10, r12, r13);
        return;
    L8:
        r10.done(e10, r12);     // Catch: Exception -> L5
    L5:
        e10 = e;
        goto L6
    }

    public static /* synthetic */ Future v(FailCallback r10, Exception r11) {
        r10.fail(r11);
        return new SimpleFuture(null);
    }

    public static /* synthetic */ Future w(FailConvertCallback r10, Exception r11) {
        return new SimpleFuture(r10.fail(r11));
    }

    public static /* synthetic */ void x(SimpleFuture r10, FailRecoverCallback r11, Exception r12, Object r13, a r14) {
        if (r12 != null) goto L11;
        r10.J(r12, r13, r14);
        return;
    L11:
        r10.H(r11.fail(r12), r14);
        return;
    L8:
        e = move-exception;
        r10.J(e, null, r14);
    }

    public static /* synthetic */ void y(FutureCallback r10, Exception r11, Object r12, a r13) {
        r10.onCompleted(r11, r12);
    }

    public final /* synthetic */ void A(SimpleFuture r10, Exception r11, Object r12) {
        CancellationException r13 = null;
        if (J(r11, r12, null) == true) goto L6;
        r13 = new CancellationException();
    L6:
        r10.I(r13);
    }

    public void E() {
        com.jeffmony.async.a r10 = this.f10392f;
        if (r10 == null) goto L6;
        r10.b();
        this.f10392f = null;
        return;
    }

    public void F(a r10, FutureCallbackInternal r11) {
        monitor-enter(this);
        this.f10396j = r11;     // Catch: Throwable -> L9
        if (isDone() == false) goto L6;
    L11:
        FutureCallbackInternal r12 = t();     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        s(r10, r12);
        return;
    L6:
        if (isCancelled() == true) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public Future G(Future r10) {
        return H(r10, null);
    }

    public final Future H(Future r10, a r11) {
        setParent(r10);
        final SimpleFuture r12 = new SimpleFuture();
        if ((r10 instanceof SimpleFuture) == false) goto L5;
        ((SimpleFuture) r10).F(r11, new h(this, r12));
    L6:
        return r12;
    L5:
        r10.setCallback(new i(this, r12));
        goto L6
    }

    public boolean I(Exception r10) {
        return J(r10, null, null);
    }

    public final boolean J(Exception r10, Object r11, a r12) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (super.e() == true) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L8
        return false;
    L10:
        this.f10394h = r11;     // Catch: Throwable -> L8
        this.f10393g = r10;     // Catch: Throwable -> L8
        E();     // Catch: Throwable -> L8
        FutureCallbackInternal r13 = t();     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        s(r12, r13);
        return true;
    }

    public boolean K(Object r10) {
        return J(null, r10, null);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean r10) {
        return cancel();
    }

    @Override // com.jeffmony.async.future.Future
    public Future done(final DoneCallback r10) {
        final SimpleFuture r11 = new SimpleFuture();
        r11.setParent(this);
        F(null, new e(r10, r11));
        return r11;
    }

    @Override // com.jeffmony.async.future.Future
    public Future fail(final FailCallback r10) {
        return failRecover(new l(r10));
    }

    @Override // com.jeffmony.async.future.Future
    public Future failConvert(final FailConvertCallback r10) {
        return failRecover(new j(r10));
    }

    @Override // com.jeffmony.async.future.Future
    public Future failRecover(final FailRecoverCallback r10) {
        final SimpleFuture r11 = new SimpleFuture();
        r11.setParent(this);
        F(null, new f(r11, r10));
        return r11;
    }

    @Override // java.util.concurrent.Future
    public Object get() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (isCancelled() == false) goto L6;
    L14:
        Object r10 = r();     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        return r10;
    L6:
        if (isDone() == true) goto L14;
        com.jeffmony.async.a r11 = q();     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        r11.a();
        return r();
    }

    public final boolean p(boolean r10) {
        if (super.cancel() == true) goto L6;
        return false;
    L6:
        monitor-enter(this);
        this.f10393g = new CancellationException();     // Catch: Throwable -> L11
        E();     // Catch: Throwable -> L11
        FutureCallbackInternal r11 = t();     // Catch: Throwable -> L11
        this.f10395i = r10;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        s(null, r11);
        return true;
    L11:
        th = move-exception;
        throw th;
    }

    public com.jeffmony.async.a q() {
        if (this.f10392f != null) goto L6;
        this.f10392f = new com.jeffmony.async.a();
    L6:
        return this.f10392f;
    }

    public final Object r() {
        if (this.f10393g != null) goto L7;
        return this.f10394h;
    L7:
        throw new ExecutionException(this.f10393g);
    }

    public final void s(a r10, FutureCallbackInternal r11) {
        if (this.f10395i == false) goto L5;
        return;
    L5:
        if (r11 != null) goto L7;
        return;
    L7:
        if (r10 != null) goto L9;
        r10 = new a();
        boolean r12 = true;
    L10:
        r10.f10399c = r11;
        r10.f10397a = this.f10393g;
        r10.f10398b = this.f10394h;
        if (r12 == false) goto L14;
        r10.a();
        return;
    L14:
        return;
    L9:
        r12 = false;
        goto L10
    }

    @Override // com.jeffmony.async.future.Future
    public void setCallback(final FutureCallback r10) {
        if (r10 != null) goto L5;
        F(null, null);
        return;
    L5:
        F(null, new g(r10));
    }

    @Override // com.jeffmony.async.future.d, com.jeffmony.async.future.DependentCancellable
    public boolean setParent(Cancellable r10) {
        return super.setParent(r10);
    }

    @Override // com.jeffmony.async.future.Future
    public Future success(final SuccessCallback r10) {
        final SimpleFuture r11 = new SimpleFuture();
        r11.setParent(this);
        F(null, new m(r10, r11));
        return r11;
    }

    public final FutureCallbackInternal t() {
        FutureCallbackInternal r10 = this.f10396j;
        this.f10396j = null;
        return r10;
    }

    @Override // com.jeffmony.async.future.Future
    public Future then(final ThenFutureCallback r10) {
        final SimpleFuture r11 = new SimpleFuture();
        r11.setParent(this);
        F(null, new n(r11, r10));
        return r11;
    }

    @Override // com.jeffmony.async.future.Future
    public Future thenConvert(final ThenCallback r10) {
        return then(new k(r10));
    }

    @Override // com.jeffmony.async.future.Future
    public Object tryGet() {
        return this.f10394h;
    }

    @Override // com.jeffmony.async.future.Future
    public Exception tryGetException() {
        return this.f10393g;
    }

    public final /* synthetic */ void z(SimpleFuture r10, Exception r11, Object r12, a r13) {
        if (J(r11, r12, r13) == false) goto L5;
        CancellationException r14 = null;
    L6:
        r10.J(r14, r12, r13);
        return;
    L5:
        r14 = new CancellationException();
        goto L6
    }

    public SimpleFuture(Object r10) {
        K(r10);
    }

    @Override // com.jeffmony.async.future.d, com.jeffmony.async.future.Cancellable
    public boolean cancel() {
        return p(this.f10395i);
    }

    @Override // java.util.concurrent.Future
    public Object get(long r10, TimeUnit r11) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (isCancelled() == false) goto L6;
    L18:
        Object r12 = r();     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        return r12;
    L6:
        if (isDone() == true) goto L18;
        com.jeffmony.async.a r13 = q();     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        if (r13.c(r10, r11) == false) goto L15;
        return r();
    L15:
        throw new TimeoutException();
    }
}
