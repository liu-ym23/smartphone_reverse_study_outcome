package ng;

import java.util.Arrays;
import og.f;
import rx.Subscriber;
import rx.exceptions.CompositeException;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;
import rx.exceptions.UnsubscribeFailedException;

/* JADX INFO: loaded from: classes4.dex */
public class a extends Subscriber {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Subscriber f22453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f22454b;

    public a(Subscriber r10) {
        super(r10);
        this.f22453a = r10;
    }

    public void b(Throwable r10) {
        f.c().b().a(r10);
        this.f22453a.onError(r10);     // Catch: Throwable -> L9 OnErrorNotImplementedException -> L11
        unsubscribe();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        og.c.j(th);
        throw new OnErrorFailedException(th);
    L11:
        e = move-exception;
        unsubscribe();     // Catch: Throwable -> L22
        throw e;
    L22:
        th = move-exception;
        og.c.j(th);
        throw new OnErrorNotImplementedException("Observer.onError not implemented and error while unsubscribing.", new CompositeException(Arrays.asList(new Throwable[]{r10, th})));
    L9:
        th = move-exception;
        og.c.j(th);
        unsubscribe();     // Catch: Throwable -> L17
        throw new OnErrorFailedException("Error occurred when trying to propagate error to Observer.onError", new CompositeException(Arrays.asList(new Throwable[]{r10, th})));
    L17:
        th = move-exception;
        og.c.j(th);
        throw new OnErrorFailedException("Error occurred when trying to propagate error to Observer.onError and during unsubscription.", new CompositeException(Arrays.asList(new Throwable[]{r10, th, th})));
    }

    @Override // rx.Observer
    public void onCompleted() {
        if (this.f22454b == true) goto L20;
        this.f22454b = true;
        this.f22453a.onCompleted();     // Catch: Throwable -> L11
        unsubscribe();     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        og.c.j(th);
        throw new UnsubscribeFailedException(th.getMessage(), th);
    L11:
        th = move-exception;
        rx.exceptions.a.e(th);     // Catch: Throwable -> L14
        og.c.j(th);     // Catch: Throwable -> L14
        throw new OnCompletedFailedException(th.getMessage(), th);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        unsubscribe();     // Catch: Throwable -> L17
        throw th;
    L17:
        th = move-exception;
        og.c.j(th);
        throw new UnsubscribeFailedException(th.getMessage(), th);
    }

    @Override // rx.Observer
    public void onError(Throwable r10) {
        rx.exceptions.a.e(r10);
        if (this.f22454b == true) goto L6;
        this.f22454b = true;
        b(r10);
        return;
    }

    @Override // rx.Observer
    public void onNext(Object r10) {
    L6:
        th = move-exception;
        rx.exceptions.a.f(th, this);
        return;
    L3:
        if (this.f22454b == true) goto L11;
        this.f22453a.onNext(r10);     // Catch: Throwable -> L6
        return;
    }
}
