package rx.observers;

import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observer;
import rx.Producer;
import rx.Subscription;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes4.dex */
public interface AssertableSubscriber<T> extends Observer<T>, Subscription {
    AssertableSubscriber<T> assertCompleted();

    AssertableSubscriber<T> assertError(Class<? extends Throwable> r10);

    AssertableSubscriber<T> assertError(Throwable r10);

    AssertableSubscriber<T> assertFailure(Class<? extends Throwable> r10, T... r11);

    AssertableSubscriber<T> assertFailureAndMessage(Class<? extends Throwable> r10, String r11, T... r12);

    AssertableSubscriber<T> assertNoErrors();

    AssertableSubscriber<T> assertNoTerminalEvent();

    AssertableSubscriber<T> assertNoValues();

    AssertableSubscriber<T> assertNotCompleted();

    AssertableSubscriber<T> assertReceivedOnNext(List<T> r10);

    AssertableSubscriber<T> assertResult(T... r10);

    AssertableSubscriber<T> assertTerminalEvent();

    AssertableSubscriber<T> assertUnsubscribed();

    AssertableSubscriber<T> assertValue(T r10);

    AssertableSubscriber<T> assertValueCount(int r10);

    AssertableSubscriber<T> assertValues(T... r10);

    AssertableSubscriber<T> assertValuesAndClear(T r10, T... r11);

    AssertableSubscriber<T> awaitTerminalEvent();

    AssertableSubscriber<T> awaitTerminalEvent(long r10, TimeUnit r11);

    AssertableSubscriber<T> awaitTerminalEventAndUnsubscribeOnTimeout(long r10, TimeUnit r11);

    AssertableSubscriber<T> awaitValueCount(int r10, long r11, TimeUnit r12);

    int getCompletions();

    Thread getLastSeenThread();

    List<Throwable> getOnErrorEvents();

    List<T> getOnNextEvents();

    int getValueCount();

    @Override // rx.Subscription
    boolean isUnsubscribed();

    void onStart();

    AssertableSubscriber<T> perform(Action0 r10);

    AssertableSubscriber<T> requestMore(long r10);

    void setProducer(Producer r10);

    @Override // rx.Subscription
    void unsubscribe();
}
