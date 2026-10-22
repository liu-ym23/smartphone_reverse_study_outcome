package rx.subjects;

import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Actions;
import rx.subscriptions.e;

/* JADX INFO: loaded from: classes4.dex */
final class SubjectSubscriptionManager<T> extends AtomicReference<b> implements Observable.OnSubscribe<T> {
    private static final long serialVersionUID = 6035251036011671568L;
    boolean active;
    volatile Object latest;
    Action1<c> onAdded;
    Action1<c> onStart;
    Action1<c> onTerminated;

    public class a implements Action0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f24457a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SubjectSubscriptionManager f24458b;

        public a(SubjectSubscriptionManager r10, c r11) {
            this.f24458b = r10;
            this.f24457a = r11;
        }

        @Override // rx.functions.Action0
        public void call() {
            this.f24458b.remove(this.f24457a);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c[] f24459c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f24460d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f24461e = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f24462a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c[] f24463b;

        static {
            c[] r10 = new c[0];
            f24459c = r10;
            f24460d = new b(true, r10);
            f24461e = new b(false, r10);
        }

        public b(boolean r10, c[] r11) {
            this.f24462a = r10;
            this.f24463b = r11;
        }

        public b a(c r10) {
            c[] r11 = this.f24463b;
            int r12 = r11.length;
            c[] r13 = new c[r12 + 1];
            System.arraycopy(r11, 0, r13, 0, r12);
            r13[r12] = r10;
            return new b(this.f24462a, r13);
        }

        public b b(c r10) {
            c[] r11 = this.f24463b;
            int r12 = r11.length;
            if (r12 == 1) goto L5;
        L8:
            if (r12 != 0) goto L10;
            return this;
        L10:
            int r13 = r12 - 1;
            c[] r14 = new c[r13];
            int r15 = 0;
            int r16 = 0;
        L11:
            if (r15 >= r12) goto L18;
            c r17 = r11[r15];
            if (r17 == r10) goto L17;
            if (r16 == r13) goto L15;
            r14[r16] = r17;
            r16 = r16 + 1;
            goto L17
        L15:
            return this;
        L17:
            r15 = r15 + 1;
            goto L11
        L18:
            if (r16 == 0) goto L20;
            if (r16 >= r13) goto L24;
            c[] r18 = new c[r16];
            System.arraycopy(r14, 0, r18, 0, r16);
            r14 = r18;
        L24:
            return new b(this.f24462a, r14);
        L20:
            return f24461e;
        L5:
            if (r11[0] != r10) goto L8;
            return f24461e;
        }
    }

    public static final class c implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Subscriber f24464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f24465b;

        public c(Subscriber r10) {
            this.f24465b = true;
            this.f24464a = r10;
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.f24464a.onCompleted();
        }

        @Override // rx.Observer
        public void onError(Throwable r10) {
            this.f24464a.onError(r10);
        }

        @Override // rx.Observer
        public void onNext(Object r10) {
            this.f24464a.onNext(r10);
        }
    }

    public SubjectSubscriptionManager() {
        super(b.f24461e);
        this.active = true;
        this.onStart = Actions.a();
        this.onAdded = Actions.a();
        this.onTerminated = Actions.a();
    }

    public boolean add(c r10) {
    L2:
        b r11 = get();
        if (r11.f24462a == true) goto L4;
        if (compareAndSet(r11, r11.a(r10)) == false) goto L2;
        this.onAdded.call(r10);
        return true;
    L4:
        this.onTerminated.call(r10);
        return false;
    }

    public void addUnsubscriber(Subscriber r10, c r11) {
        r10.add(e.a(new a(this, r11)));
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Subscriber r10) {
        call2(r10);
    }

    public Object getLatest() {
        return this.latest;
    }

    public c[] next(Object r10) {
        setLatest(r10);
        return get().f24463b;
    }

    public c[] observers() {
        return get().f24463b;
    }

    public void remove(c r10) {
    L2:
        b r11 = get();
        if (r11.f24462a == true) goto L4;
        b r12 = r11.b(r10);
        if (r12 == r11) goto L9;
        if (compareAndSet(r11, r12) == false) goto L2;
        return;
    L9:
        return;
    }

    public void setLatest(Object r10) {
        this.latest = r10;
    }

    public c[] terminate(Object r10) {
        setLatest(r10);
        this.active = false;
        if (get().f24462a == false) goto L7;
        return b.f24459c;
    L7:
        return getAndSet(b.f24460d).f24463b;
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(Subscriber r10) {
        c r11 = new c(r10);
        addUnsubscriber(r10, r11);
        this.onStart.call(r11);
        if (r10.isUnsubscribed() == false) goto L5;
        return;
    L5:
        if (add(r11) == true) goto L7;
        return;
    L7:
        if (r10.isUnsubscribed() == false) goto L12;
        remove(r11);
        return;
    }
}
