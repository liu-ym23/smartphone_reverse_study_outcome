package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import mf.b;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
public final class SingleToFlowable extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SingleSource f20702b;

    public static final class SingleToFlowableObserver<T> extends DeferredScalarSubscription<T> implements SingleObserver<T> {
        private static final long serialVersionUID = 187782011903685568L;
        Disposable upstream;

        public SingleToFlowableObserver(Subscriber<? super T> r10) {
            super(r10);
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.upstream.dispose();
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable r10) {
            this.downstream.onError(r10);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable r10) {
            if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
            this.upstream = r10;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T r10) {
            complete(r10);
        }
    }

    public SingleToFlowable(SingleSource r10) {
        this.f20702b = r10;
    }

    @Override // mf.b
    public void c(Subscriber r10) {
        this.f20702b.subscribe(new SingleToFlowableObserver(r10));
    }
}
