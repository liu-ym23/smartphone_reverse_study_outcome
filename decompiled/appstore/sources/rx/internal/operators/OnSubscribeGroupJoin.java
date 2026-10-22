package rx.internal.operators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.subjects.PublishSubject;
import rx.subscriptions.RefCountSubscription;

/* JADX INFO: loaded from: classes4.dex */
public abstract class OnSubscribeGroupJoin implements Observable.OnSubscribe {

    public final class ResultManager extends HashMap<Integer, Observer<Object>> implements Subscription {
        private static final long serialVersionUID = -3035156013812425335L;
        final RefCountSubscription cancel;
        final rx.subscriptions.b group;
        boolean leftDone;
        int leftIds;
        boolean rightDone;
        int rightIds;
        final Map<Integer, Object> rightMap;
        final Subscriber subscriber;
        final /* synthetic */ OnSubscribeGroupJoin this$0;

        public final class a extends Subscriber {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ResultManager f24157a;

            public a(ResultManager r10) {
                this.f24157a = r10;
            }

            @Override // rx.Observer
            public void onCompleted() {
                ResultManager r10 = this.f24157a;
                monitor-enter(r10);
                ResultManager r11 = this.f24157a;     // Catch: Throwable -> L7
                r11.leftDone = true;     // Catch: Throwable -> L7
                if (r11.rightDone == false) goto L9;
                ArrayList r12 = new ArrayList(this.f24157a.leftMap().values());     // Catch: Throwable -> L7
                this.f24157a.leftMap().clear();     // Catch: Throwable -> L7
                this.f24157a.rightMap.clear();     // Catch: Throwable -> L7
            L10:
                monitor-exit(r10);     // Catch: Throwable -> L7
                this.f24157a.complete(r12);
                return;
            L9:
                r12 = null;
            L7:
                th = move-exception;
                throw th;
            }

            @Override // rx.Observer
            public void onError(Throwable r10) {
                this.f24157a.errorAll(r10);
            }

            @Override // rx.Observer
            public void onNext(Object r10) {
                PublishSubject r11 = PublishSubject.B();     // Catch: Throwable -> L8
                ng.b r12 = new ng.b(r11);     // Catch: Throwable -> L8
                ResultManager r13 = this.f24157a;     // Catch: Throwable -> L8
                monitor-enter(r13);     // Catch: Throwable -> L8
                ResultManager r14 = this.f24157a;     // Catch: Throwable -> L10
                int r15 = r14.leftIds;     // Catch: Throwable -> L10
                r14.leftIds = r15 + 1;     // Catch: Throwable -> L10
                r14.leftMap().put(Integer.valueOf(r15), r12);     // Catch: Throwable -> L10
                monitor-exit(r13);     // Catch: Throwable -> L10
                Observable.y(new a(r11, this.f24157a.cancel));     // Catch: Throwable -> L8
                this.f24157a.getClass();     // Catch: Throwable -> L8
                throw null;     // Catch: Throwable -> L8
            L10:
                th = move-exception;
                throw th;     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                rx.exceptions.a.f(th, this);
            }
        }

        public final class b extends Subscriber {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ResultManager f24158a;

            public b(ResultManager r10) {
                this.f24158a = r10;
            }

            @Override // rx.Observer
            public void onCompleted() {
                ResultManager r10 = this.f24158a;
                monitor-enter(r10);
                ResultManager r11 = this.f24158a;     // Catch: Throwable -> L7
                r11.rightDone = true;     // Catch: Throwable -> L7
                if (r11.leftDone == false) goto L9;
                ArrayList r12 = new ArrayList(this.f24158a.leftMap().values());     // Catch: Throwable -> L7
                this.f24158a.leftMap().clear();     // Catch: Throwable -> L7
                this.f24158a.rightMap.clear();     // Catch: Throwable -> L7
            L10:
                monitor-exit(r10);     // Catch: Throwable -> L7
                this.f24158a.complete(r12);
                return;
            L9:
                r12 = null;
            L7:
                th = move-exception;
                throw th;
            }

            @Override // rx.Observer
            public void onError(Throwable r10) {
                this.f24158a.errorAll(r10);
            }

            @Override // rx.Observer
            public void onNext(Object r10) {
                ResultManager r11 = this.f24158a;     // Catch: Throwable -> L8
                monitor-enter(r11);     // Catch: Throwable -> L8
                ResultManager r12 = this.f24158a;     // Catch: Throwable -> L10
                int r13 = r12.rightIds;     // Catch: Throwable -> L10
                r12.rightIds = r13 + 1;     // Catch: Throwable -> L10
                r12.rightMap.put(Integer.valueOf(r13), r10);     // Catch: Throwable -> L10
                monitor-exit(r11);     // Catch: Throwable -> L10
                this.f24158a.getClass();     // Catch: Throwable -> L8
                throw null;     // Catch: Throwable -> L8
            L10:
                th = move-exception;
                throw th;     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                rx.exceptions.a.f(th, this);
            }
        }

        public ResultManager(OnSubscribeGroupJoin r10, Subscriber r11) {
            this.rightMap = new HashMap();
            this.subscriber = r11;
            rx.subscriptions.b r12 = new rx.subscriptions.b();
            this.group = r12;
            this.cancel = new RefCountSubscription(r12);
        }

        public void complete(List<Observer<Object>> r10) {
            if (r10 == null) goto L10;
            Iterator<Observer<Object>> r11 = r10.iterator();
        L5:
            if (r11.hasNext() == false) goto L7;
            r11.next().onCompleted();
            goto L5
        L7:
            this.subscriber.onCompleted();
            this.cancel.unsubscribe();
            return;
        }

        public void errorAll(Throwable r10) {
            monitor-enter(this);
            ArrayList r11 = new ArrayList(leftMap().values());     // Catch: Throwable -> L11
            leftMap().clear();     // Catch: Throwable -> L11
            this.rightMap.clear();     // Catch: Throwable -> L11
            monitor-exit(this);     // Catch: Throwable -> L11
            Iterator r12 = r11.iterator();
        L7:
            if (r12.hasNext() == false) goto L9;
            ((Observer) r12.next()).onError(r10);
            goto L7
        L9:
            this.subscriber.onError(r10);
            this.cancel.unsubscribe();
            return;
        L11:
            th = move-exception;
            throw th;
        }

        public void errorMain(Throwable r10) {
            monitor-enter(this);
            leftMap().clear();     // Catch: Throwable -> L7
            this.rightMap.clear();     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            this.subscriber.onError(r10);
            this.cancel.unsubscribe();
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void init() {
            a r10 = new a(this);
            b r11 = new b(this);
            this.group.a(r10);
            this.group.a(r11);
            throw null;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.cancel.isUnsubscribed();
        }

        public Map<Integer, Observer<Object>> leftMap() {
            return this;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.cancel.unsubscribe();
        }
    }

    public static final class a implements Observable.OnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RefCountSubscription f24159a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Observable f24160b;

        /* JADX INFO: renamed from: rx.internal.operators.OnSubscribeGroupJoin$a$a, reason: collision with other inner class name */
        public final class C0362a extends Subscriber {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Subscriber f24161a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Subscription f24162b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ a f24163c;

            public C0362a(a r10, Subscriber r11, Subscription r12) {
                this.f24163c = r10;
                super(r11);
                this.f24161a = r11;
                this.f24162b = r12;
            }

            @Override // rx.Observer
            public void onCompleted() {
                this.f24161a.onCompleted();
                this.f24162b.unsubscribe();
            }

            @Override // rx.Observer
            public void onError(Throwable r10) {
                this.f24161a.onError(r10);
                this.f24162b.unsubscribe();
            }

            @Override // rx.Observer
            public void onNext(Object r10) {
                this.f24161a.onNext(r10);
            }
        }

        public a(Observable r10, RefCountSubscription r11) {
            this.f24159a = r11;
            this.f24160b = r10;
        }

        public void a(Subscriber r10) {
            Subscription r11 = this.f24159a.a();
            C0362a r12 = new C0362a(this, r10, r11);
            r12.add(r11);
            this.f24160b.z(r12);
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Subscriber r10) {
            a(r10);
        }
    }
}
