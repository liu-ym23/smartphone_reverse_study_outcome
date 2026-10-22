package mf;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscribers.StrictSubscriber;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b implements Publisher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f22298a = 0;

    static {
        f22298a = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());
    }

    public b() {
    }

    public static int a() {
        return f22298a;
    }

    public final void b(FlowableSubscriber r10) {
        io.reactivex.internal.functions.a.b(r10, "s is null");
        Subscriber r11 = qf.a.g(this, r10);     // Catch: Throwable -> L5 NullPointerException -> L7
        io.reactivex.internal.functions.a.b(r11, "The RxJavaPlugins.onSubscribe hook returned a null FlowableSubscriber. Please check the handler provided to RxJavaPlugins.setOnFlowableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");     // Catch: Throwable -> L5 NullPointerException -> L7
        c(r11);     // Catch: Throwable -> L5 NullPointerException -> L7
        return;
    L7:
        e = move-exception;
        throw e;
    L5:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        qf.a.e(th);
        NullPointerException r12 = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
        r12.initCause(th);
        throw r12;
    }

    public abstract void c(Subscriber r10);

    @Override // org.reactivestreams.Publisher
    public final void subscribe(Subscriber r10) {
        if ((r10 instanceof FlowableSubscriber) == false) goto L5;
        b((FlowableSubscriber) r10);
        return;
    L5:
        io.reactivex.internal.functions.a.b(r10, "s is null");
        b(new StrictSubscriber(r10));
    }
}
