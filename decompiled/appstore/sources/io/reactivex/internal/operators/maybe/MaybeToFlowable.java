package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
public final class MaybeToFlowable extends mf.b implements HasUpstreamMaybeSource {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MaybeSource f20657b;

    public static final class MaybeToFlowableSubscriber<T> extends DeferredScalarSubscription<T> implements MaybeObserver<T> {
        private static final long serialVersionUID = 7603343402964826922L;
        Disposable upstream;

        public MaybeToFlowableSubscriber(Subscriber<? super T> r10) {
            super(r10);
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.upstream.dispose();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable r10) {
            this.downstream.onError(r10);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable r10) {
            if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
            this.upstream = r10;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T r10) {
            complete(r10);
        }
    }

    public MaybeToFlowable(MaybeSource r10) {
        this.f20657b = r10;
    }

    @Override // mf.b
    public void c(Subscriber r10) {
        this.f20657b.subscribe(new MaybeToFlowableSubscriber(r10));
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamMaybeSource
    public MaybeSource source() {
        return this.f20657b;
    }
}
