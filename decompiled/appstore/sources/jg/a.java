package jg;

import java.util.concurrent.TimeUnit;
import rx.Completable;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.internal.schedulers.SchedulerWhen;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {

    /* JADX INFO: renamed from: jg.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0284a implements Subscription {
        public AbstractC0284a() {
        }

        public abstract Subscription a(Action0 r10);

        public abstract Subscription b(Action0 r10, long r11, TimeUnit r12);
    }

    public a() {
    }

    public abstract AbstractC0284a createWorker();

    public long now() {
        return System.currentTimeMillis();
    }

    public <S extends a & Subscription> S when(Func1<Observable, Completable> r10) {
        return new SchedulerWhen(r10, this);
    }
}
