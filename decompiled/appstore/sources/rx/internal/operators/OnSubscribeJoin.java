package rx.internal.operators;

import java.util.HashMap;
import java.util.Map;
import rx.Observable;
import rx.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
public abstract class OnSubscribeJoin implements Observable.OnSubscribe {

    public final class ResultSink extends HashMap<Integer, Object> {
        private static final long serialVersionUID = 3491669543549085380L;
        final rx.subscriptions.b group;
        boolean leftDone;
        int leftId;
        boolean rightDone;
        int rightId;
        final Map<Integer, Object> rightMap;
        final Subscriber subscriber;
        final /* synthetic */ OnSubscribeJoin this$0;

        public final class a extends Subscriber {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ResultSink f24164a;

            public a(ResultSink r10) {
                this.f24164a = r10;
            }

            @Override // rx.Observer
            public void onCompleted() {
                ResultSink r10 = this.f24164a;
                monitor-enter(r10);
                ResultSink r11 = this.f24164a;     // Catch: Throwable -> L10
                boolean r12 = true;
                r11.leftDone = true;     // Catch: Throwable -> L10
                if (r11.rightDone == false) goto L7;
            L12:
                monitor-exit(r10);     // Catch: Throwable -> L10
                if (r12 == false) goto L15;
                this.f24164a.subscriber.onCompleted();
                this.f24164a.subscriber.unsubscribe();
                return;
            L15:
                this.f24164a.group.b(this);
                return;
            L7:
                if (r11.leftMap().isEmpty() == true) goto L12;
                r12 = false;
            L10:
                th = move-exception;
                throw th;
            }

            @Override // rx.Observer
            public void onError(Throwable r10) {
                this.f24164a.subscriber.onError(r10);
                this.f24164a.subscriber.unsubscribe();
            }

            @Override // rx.Observer
            public void onNext(Object r10) {
                ResultSink r11 = this.f24164a;
                monitor-enter(r11);
                ResultSink r12 = this.f24164a;     // Catch: Throwable -> L11
                int r13 = r12.leftId;     // Catch: Throwable -> L11
                r12.leftId = r13 + 1;     // Catch: Throwable -> L11
                r12.leftMap().put(Integer.valueOf(r13), r10);     // Catch: Throwable -> L11
                ResultSink r14 = this.f24164a;     // Catch: Throwable -> L11
                int r15 = r14.rightId;     // Catch: Throwable -> L11
                monitor-exit(r11);     // Catch: Throwable -> L11
                r14.getClass();     // Catch: Throwable -> L8
                throw null;     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                rx.exceptions.a.f(th, this);
                return;
            L11:
                th = move-exception;
                throw th;
            }
        }

        public final class b extends Subscriber {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ResultSink f24165a;

            public b(ResultSink r10) {
                this.f24165a = r10;
            }

            @Override // rx.Observer
            public void onCompleted() {
                ResultSink r10 = this.f24165a;
                monitor-enter(r10);
                ResultSink r11 = this.f24165a;     // Catch: Throwable -> L10
                boolean r12 = true;
                r11.rightDone = true;     // Catch: Throwable -> L10
                if (r11.leftDone == false) goto L7;
            L12:
                monitor-exit(r10);     // Catch: Throwable -> L10
                if (r12 == false) goto L15;
                this.f24165a.subscriber.onCompleted();
                this.f24165a.subscriber.unsubscribe();
                return;
            L15:
                this.f24165a.group.b(this);
                return;
            L7:
                if (r11.rightMap.isEmpty() == true) goto L12;
                r12 = false;
            L10:
                th = move-exception;
                throw th;
            }

            @Override // rx.Observer
            public void onError(Throwable r10) {
                this.f24165a.subscriber.onError(r10);
                this.f24165a.subscriber.unsubscribe();
            }

            @Override // rx.Observer
            public void onNext(Object r10) {
                ResultSink r11 = this.f24165a;
                monitor-enter(r11);
                ResultSink r12 = this.f24165a;     // Catch: Throwable -> L12
                int r13 = r12.rightId;     // Catch: Throwable -> L12
                r12.rightId = r13 + 1;     // Catch: Throwable -> L12
                r12.rightMap.put(Integer.valueOf(r13), r10);     // Catch: Throwable -> L12
                int r14 = this.f24165a.leftId;     // Catch: Throwable -> L12
                monitor-exit(r11);     // Catch: Throwable -> L12
                rx.subscriptions.d r15 = new rx.subscriptions.d();
                this.f24165a.group.a(r15);
                this.f24165a.getClass();     // Catch: Throwable -> L9
                throw null;     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                rx.exceptions.a.f(th, this);
                return;
            L12:
                th = move-exception;
                throw th;
            }
        }

        public ResultSink(OnSubscribeJoin r10, Subscriber r11) {
            this.subscriber = r11;
            this.group = new rx.subscriptions.b();
            this.rightMap = new HashMap();
        }

        public HashMap<Integer, Object> leftMap() {
            return this;
        }

        public void run() {
            this.subscriber.add(this.group);
            a r10 = new a(this);
            b r11 = new b(this);
            this.group.a(r10);
            this.group.a(r11);
            throw null;
        }
    }
}
