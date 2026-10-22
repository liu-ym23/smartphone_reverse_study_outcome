package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.channels.Channel;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func0;

/* JADX INFO: loaded from: classes4.dex */
public final class OperatorReplay extends rx.observables.a implements Subscription {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Func0 f24167e = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Observable f24168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference f24169c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Func0 f24170d;

    public static class BoundedReplayBuffer<T> extends AtomicReference<Node> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        long index;
        int size;
        Node tail;

        public BoundedReplayBuffer() {
            Node r10 = new Node(null, 0);
            this.tail = r10;
            set(r10);
        }

        public final void addLast(Node r10) {
            this.tail.set(r10);
            this.tail = r10;
            this.size++;
        }

        public final void collect(Collection<? super T> r10) {
            Node r11 = getInitialHead();
        L3:
            r11 = r11.get();
            if (r11 == null) goto L11;
            Object r12 = leaveTransform(r11.value);
            if (NotificationLite.e(r12) == true) goto L15;
            if (NotificationLite.f(r12) == true) goto L16;
            r10.add((Object) NotificationLite.d(r12));
            goto L3
        L16:
            return;
        L15:
            return;
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public final void complete() {
            Object r10 = enterTransform(NotificationLite.b());
            long r11 = this.index + 1;
            this.index = r11;
            addLast(new Node(r10, r11));
            truncateFinal();
        }

        public Object enterTransform(Object r10) {
            return r10;
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public final void error(Throwable r10) {
            Object r11 = enterTransform(NotificationLite.c(r10));
            long r12 = this.index + 1;
            this.index = r12;
            addLast(new Node(r11, r12));
            truncateFinal();
        }

        public Node getInitialHead() {
            return get();
        }

        public boolean hasCompleted() {
            Object r10 = this.tail.value;
            if (r10 != null) goto L5;
        L7:
            return false;
        L5:
            if (NotificationLite.e(leaveTransform(r10)) == false) goto L7;
            return true;
        }

        public boolean hasError() {
            Object r10 = this.tail.value;
            if (r10 != null) goto L5;
        L7:
            return false;
        L5:
            if (NotificationLite.f(leaveTransform(r10)) == false) goto L7;
            return true;
        }

        public Object leaveTransform(Object r10) {
            return r10;
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public final void next(T r10) {
            Object r11 = enterTransform(NotificationLite.g(r10));
            long r12 = this.index + 1;
            this.index = r12;
            addLast(new Node(r11, r12));
            truncate();
        }

        public final void removeFirst() {
            Node r10 = get().get();
            if (r10 == null) goto L7;
            this.size--;
            setFirst(r10);
            return;
        L7:
            throw new IllegalStateException("Empty list!");
        }

        public final void removeSome(int r10) {
            Node r11 = get();
        L3:
            if (r10 <= 0) goto L5;
            r11 = r11.get();
            r10 = r10 - 1;
            this.size--;
            goto L3
        L5:
            setFirst(r11);
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public final void replay(InnerProducer<T> r12) {
            monitor-enter(r12);
        L8:
            th = move-exception;
            throw th;
        L4:
            if (r12.emitting == false) goto L10;
            r12.missed = true;     // Catch: Throwable -> L8
            monitor-exit(r12);     // Catch: Throwable -> L8
            return;
        L10:
            r12.emitting = true;     // Catch: Throwable -> L8
            monitor-exit(r12);     // Catch: Throwable -> L8
        L13:
            if (r12.isUnsubscribed() == true) goto L14;
            Node r10 = (Node) r12.index();
            if (r10 != null) goto L19;
            r10 = getInitialHead();
            r12.index = r10;
            r12.addTotalRequested(r10.index);
        L19:
            if (r12.isUnsubscribed() == true) goto L20;
            Subscriber r11 = r12.child;
            if (r11 == null) goto L23;
            long r13 = r12.get();
            long r14 = 0;
        L26:
            if (r14 == r13) goto L47;
            Node r15 = r10.get();
            if (r15 == null) goto L47;
            Object r16 = leaveTransform(r15.value);
        L34:
            th = move-exception;
            r12.index = null;
            rx.exceptions.a.e(th);
            r12.unsubscribe();
            if (NotificationLite.f(r16) == false) goto L43;
            return;
        L43:
            if (NotificationLite.e(r16) == true) goto L80;
            r11.onError(OnErrorThrowable.addValueAsLastCause(th, NotificationLite.d(r16)));
            return;
        L80:
            return;
        L31:
            if (NotificationLite.a(r11, r16) == true) goto L32;
            r14 = r14 + 1;
            if (r12.isUnsubscribed() == true) goto L38;
            r10 = r15;
            goto L26
        L38:
            return;
        L32:
            r12.index = null;     // Catch: Throwable -> L34
            return;
        L47:
            if (r14 == 0) goto L51;
            r12.index = r10;
            if (r13 == Long.MAX_VALUE) goto L51;
            r12.produced(r14);
        L51:
            monitor-enter(r12);
        L57:
            th = move-exception;
            throw th;
        L53:
            if (r12.missed == false) goto L54;
            r12.missed = false;     // Catch: Throwable -> L57
            monitor-exit(r12);     // Catch: Throwable -> L57
            goto L13
        L54:
            r12.emitting = false;     // Catch: Throwable -> L57
            monitor-exit(r12);     // Catch: Throwable -> L57
            return;
        L23:
            return;
        L20:
            return;
        }

        public final void setFirst(Node r10) {
            set(r10);
        }

        public void truncate() {
        }

        public void truncateFinal() {
        }
    }

    public static final class InnerProducer<T> extends AtomicLong implements Producer, Subscription {
        static final long UNSUBSCRIBED = Long.MIN_VALUE;
        private static final long serialVersionUID = -4453897557930727610L;
        Subscriber child;
        boolean emitting;
        Object index;
        boolean missed;
        final e parent;
        final AtomicLong totalRequested;

        public InnerProducer(e r10, Subscriber r11) {
            this.parent = r10;
            this.child = r11;
            this.totalRequested = new AtomicLong();
        }

        public void addTotalRequested(long r10) {
        L2:
            long r11 = this.totalRequested.get();
            long r12 = r11 + r10;
            if (r12 >= 0) goto L6;
            r12 = Long.MAX_VALUE;
        L6:
            if (this.totalRequested.compareAndSet(r11, r12) == false) goto L2;
        }

        public <U> U index() {
            return (U) this.index;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            if (get() != UNSUBSCRIBED) goto L5;
            return true;
        L5:
            return false;
        }

        public long produced(long r10) {
            if (r10 <= 0) goto L15;
        L4:
            long r11 = get();
            if (r11 == UNSUBSCRIBED) goto L6;
            long r12 = r11 - r10;
            if (r12 < 0) goto L13;
            if (compareAndSet(r11, r12) == false) goto L4;
            return r12;
        L13:
            throw new IllegalStateException("More produced (" + r10 + ") than requested (" + r11 + ")");
        L6:
            return UNSUBSCRIBED;
        L15:
            throw new IllegalArgumentException("Cant produce zero or less");
        }

        @Override // rx.Producer
        public void request(long r10) {
            if (r10 >= 0) goto L5;
            return;
        L5:
            long r11 = get();
            if (r11 == UNSUBSCRIBED) goto L7;
            if (r11 < 0) goto L12;
            if (r10 != 0) goto L12;
            return;
        L12:
            long r12 = r11 + r10;
            if (r12 >= 0) goto L16;
            r12 = Long.MAX_VALUE;
        L16:
            if (compareAndSet(r11, r12) == false) goto L5;
            addTotalRequested(r10);
            this.parent.f(this);
            this.parent.f24179a.replay(this);
            return;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (get() != UNSUBSCRIBED) goto L5;
            return;
        L5:
            if (getAndSet(UNSUBSCRIBED) == UNSUBSCRIBED) goto L9;
            this.parent.g(this);
            this.parent.f(this);
            this.child = null;
            return;
        }
    }

    public static final class Node extends AtomicReference<Node> {
        private static final long serialVersionUID = 245354315435971818L;
        final long index;
        final Object value;

        public Node(Object r10, long r11) {
            this.value = r10;
            this.index = r11;
        }
    }

    public interface ReplayBuffer<T> {
        void complete();

        void error(Throwable r10);

        void next(T r10);

        void replay(InnerProducer<T> r10);
    }

    public static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = 3457957419649567404L;
        final int limit;
        final long maxAgeInMillis;
        final jg.a scheduler;

        public SizeAndTimeBoundReplayBuffer(int r10, long r11, jg.a r12) {
            this.scheduler = r12;
            this.limit = r10;
            this.maxAgeInMillis = r11;
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        public Object enterTransform(Object r10) {
            return new pg.b(this.scheduler.now(), r10);
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        public Node getInitialHead() {
            long r10 = this.scheduler.now() - this.maxAgeInMillis;
            Node r11 = get();
            Node r12 = r11.get();
        L3:
            Node r13 = r12;
            Node r14 = r11;
            r11 = r13;
            if (r11 == null) goto L13;
            Object r15 = r11.value;
            Object r16 = leaveTransform(r15);
            if (NotificationLite.e(r16) == true) goto L13;
            if (NotificationLite.f(r16) == true) goto L13;
            if (((pg.b) r15).a() > r10) goto L13;
            r12 = r11.get();
        L13:
            return r14;
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        public Object leaveTransform(Object r10) {
            return ((pg.b) r10).b();
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        public void truncate() {
            long r10 = this.scheduler.now() - this.maxAgeInMillis;
            Node r11 = get();
            Node r12 = r11.get();
            int r13 = 0;
        L3:
            Node r14 = r12;
            Node r15 = r11;
            r11 = r14;
            if (r11 == null) goto L11;
            int r16 = this.size;
            if (r16 > this.limit) goto L7;
            if (((pg.b) r11.value).a() > r10) goto L11;
            r13 = r13 + 1;
            this.size--;
            r12 = r11.get();
            goto L3
        L7:
            r13 = r13 + 1;
            this.size = r16 - 1;
            r12 = r11.get();
        L11:
            if (r13 == 0) goto L21;
            setFirst(r15);
            return;
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        public void truncateFinal() {
            long r10 = this.scheduler.now() - this.maxAgeInMillis;
            Node r11 = get();
            Node r12 = r11.get();
            int r13 = 0;
        L3:
            Node r14 = r12;
            Node r15 = r11;
            r11 = r14;
            if (r11 == null) goto L10;
            if (this.size <= 1) goto L10;
            if (((pg.b) r11.value).a() > r10) goto L10;
            r13 = r13 + 1;
            this.size--;
            r12 = r11.get();
        L10:
            if (r13 == 0) goto L16;
            setFirst(r15);
            return;
        }
    }

    public static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        final int limit;

        public SizeBoundReplayBuffer(int r10) {
            this.limit = r10;
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        public void truncate() {
            if (this.size <= this.limit) goto L6;
            removeFirst();
            return;
        }
    }

    public static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        volatile int size;

        public UnboundedReplayBuffer(int r10) {
            super(r10);
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public void complete() {
            add(NotificationLite.b());
            this.size++;
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public void error(Throwable r10) {
            add(NotificationLite.c(r10));
            this.size++;
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public void next(T r10) {
            add(NotificationLite.g(r10));
            this.size++;
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public void replay(InnerProducer<T> r13) {
            monitor-enter(r13);
        L8:
            th = move-exception;
            throw th;
        L4:
            if (r13.emitting == false) goto L10;
            r13.missed = true;     // Catch: Throwable -> L8
            monitor-exit(r13);     // Catch: Throwable -> L8
            return;
        L10:
            r13.emitting = true;     // Catch: Throwable -> L8
            monitor-exit(r13);     // Catch: Throwable -> L8
        L13:
            if (r13.isUnsubscribed() == true) goto L14;
            int r10 = this.size;
            Integer r11 = (Integer) r13.index();
            if (r11 == null) goto L18;
            int r12 = r11.intValue();
        L19:
            Subscriber r14 = r13.child;
            if (r14 == null) goto L21;
            long r15 = r13.get();
            long r16 = 0;
        L24:
            if (r16 == r15) goto L42;
            if (r12 >= r10) goto L42;
            Object r17 = get(r12);
            if (NotificationLite.a(r14, r17) == true) goto L29;
            if (r13.isUnsubscribed() == true) goto L32;
            r12 = r12 + 1;
            r16 = r16 + 1;
            goto L24
        L32:
            return;
        L29:
            return;
        L34:
            th = move-exception;
            rx.exceptions.a.e(th);
            r13.unsubscribe();
            if (NotificationLite.f(r17) == false) goto L38;
            return;
        L38:
            if (NotificationLite.e(r17) == true) goto L74;
            r14.onError(OnErrorThrowable.addValueAsLastCause(th, NotificationLite.d(r17)));
            return;
        L74:
            return;
        L42:
            if (r16 == 0) goto L46;
            r13.index = Integer.valueOf(r12);
            if (r15 == Long.MAX_VALUE) goto L46;
            r13.produced(r16);
        L46:
            monitor-enter(r13);
        L52:
            th = move-exception;
            throw th;
        L48:
            if (r13.missed == false) goto L49;
            r13.missed = false;     // Catch: Throwable -> L52
            monitor-exit(r13);     // Catch: Throwable -> L52
            goto L13
        L49:
            r13.emitting = false;     // Catch: Throwable -> L52
            monitor-exit(r13);     // Catch: Throwable -> L52
            return;
        L21:
            return;
        L18:
            r12 = 0;
            goto L19
        }
    }

    public static class a implements Func0 {
        public a() {
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public Object call() {
            return new UnboundedReplayBuffer(16);
        }
    }

    public static class b implements Func0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f24171a;

        public b(int r10) {
            this.f24171a = r10;
        }

        public ReplayBuffer a() {
            return new SizeBoundReplayBuffer(this.f24171a);
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return a();
        }
    }

    public static class c implements Func0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f24172a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f24173b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ jg.a f24174c;

        public c(int r10, long r11, jg.a r12) {
            this.f24172a = r10;
            this.f24173b = r11;
            this.f24174c = r12;
        }

        public ReplayBuffer a() {
            return new SizeAndTimeBoundReplayBuffer(this.f24172a, this.f24173b, this.f24174c);
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return a();
        }
    }

    public static class d implements Observable.OnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f24175a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Func0 f24176b;

        public d(AtomicReference r10, Func0 r11) {
            this.f24175a = r10;
            this.f24176b = r11;
        }

        public void a(Subscriber r10) {
        L2:
            e r11 = (e) this.f24175a.get();
            if (r11 != null) goto L8;
            e r12 = new e((ReplayBuffer) this.f24176b.call());
            r12.d();
            if (androidx.lifecycle.p.a(this.f24175a, r11, r12) == false) goto L2;
            r11 = r12;
        L8:
            InnerProducer r13 = new InnerProducer(r11, r10);
            r11.b(r13);
            r10.add(r13);
            r11.f24179a.replay(r13);
            r10.setProducer(r13);
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Subscriber r10) {
            a(r10);
        }
    }

    public static final class e extends Subscriber implements Subscription {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final InnerProducer[] f24177p = null;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final InnerProducer[] f24178q = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ReplayBuffer f24179a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f24180b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f24181c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final rx.internal.util.d f24182d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public InnerProducer[] f24183e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public volatile long f24184f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f24185g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final AtomicBoolean f24186h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f24187i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f24188j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f24189k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f24190l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public volatile Producer f24191m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public List f24192n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f24193o;

        public class a implements Action0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f24194a;

            public a(e r10) {
                this.f24194a = r10;
            }

            @Override // rx.functions.Action0
            public void call() {
                if (this.f24194a.f24181c == true) goto L15;
                rx.internal.util.d r10 = this.f24194a.f24182d;
                monitor-enter(r10);
            L9:
                th = move-exception;
                throw th;
            L7:
                if (this.f24194a.f24181c == true) goto L11;
                this.f24194a.f24182d.g();     // Catch: Throwable -> L9
                this.f24194a.f24184f++;     // Catch: Throwable -> L9
                this.f24194a.f24181c = true;     // Catch: Throwable -> L9
            L11:
                monitor-exit(r10);     // Catch: Throwable -> L9
                return;
            }
        }

        static {
            f24177p = new InnerProducer[0];
            f24178q = new InnerProducer[0];
        }

        public e(ReplayBuffer r10) {
            this.f24179a = r10;
            this.f24182d = new rx.internal.util.d();
            this.f24183e = f24177p;
            this.f24186h = new AtomicBoolean();
            request(0);
        }

        public boolean b(InnerProducer r10) {
            if (r10 == null) goto L21;
            if (this.f24181c == false) goto L6;
            return false;
        L6:
            rx.internal.util.d r11 = this.f24182d;
            monitor-enter(r11);
        L12:
            th = move-exception;
            throw th;
        L9:
            if (this.f24181c == false) goto L14;
            monitor-exit(r11);     // Catch: Throwable -> L12
            return false;
        L14:
            this.f24182d.a(r10);     // Catch: Throwable -> L12
            this.f24184f++;     // Catch: Throwable -> L12
            monitor-exit(r11);     // Catch: Throwable -> L12
            return true;
        L21:
            throw null;
        }

        public InnerProducer[] c() {
            rx.internal.util.d r10 = this.f24182d;
            monitor-enter(r10);
            Object[] r11 = this.f24182d.h();     // Catch: Throwable -> L7
            int r12 = r11.length;     // Catch: Throwable -> L7
            InnerProducer[] r13 = new InnerProducer[r12];     // Catch: Throwable -> L7
            System.arraycopy(r11, 0, r13, 0, r12);     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r13;
        L7:
            th = move-exception;
            throw th;
        }

        public void d() {
            add(rx.subscriptions.e.a(new a(this)));
        }

        public void e(long r10, long r11) {
            long r12 = this.f24190l;
            Producer r13 = this.f24191m;
            long r14 = r10 - r11;
            if (r14 == 0) goto L15;
            this.f24189k = r10;
            if (r13 != null) goto L7;
            long r15 = r12 + r14;
            if (r15 >= 0) goto L13;
            r15 = Long.MAX_VALUE;
        L13:
            this.f24190l = r15;
            return;
        L7:
            if (r12 == 0) goto L9;
            this.f24190l = 0;
            r13.request(r12 + r14);
            return;
        L9:
            r13.request(r14);
            return;
        L15:
            if (r12 == 0) goto L22;
            if (r13 == null) goto L23;
            this.f24190l = 0;
            r13.request(r12);
            return;
        L23:
            return;
        }

        public void f(InnerProducer r10) {
            if (isUnsubscribed() == false) goto L5;
            return;
        L5:
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L7:
            if (this.f24187i == false) goto L19;
            if (r10 == null) goto L15;
            List r11 = this.f24192n;     // Catch: Throwable -> L12
            if (r11 != null) goto L14;
            r11 = new ArrayList();     // Catch: Throwable -> L12
            this.f24192n = r11;     // Catch: Throwable -> L12
        L14:
            r11.add(r10);     // Catch: Throwable -> L12
        L16:
            this.f24188j = true;     // Catch: Throwable -> L12
            monitor-exit(this);     // Catch: Throwable -> L12
            return;
        L15:
            this.f24193o = true;     // Catch: Throwable -> L12
            goto L16
        L19:
            this.f24187i = true;     // Catch: Throwable -> L12
            monitor-exit(this);     // Catch: Throwable -> L12
            long r12 = this.f24189k;
            if (r10 == null) goto L24;
            long r13 = Math.max(r12, r10.totalRequested.get());
        L31:
            e(r13, r12);
        L33:
            if (isUnsubscribed() == true) goto L34;
            monitor-enter(this);
        L41:
            th = move-exception;
            throw th;
        L37:
            if (this.f24188j == false) goto L38;
            this.f24188j = false;     // Catch: Throwable -> L41
            List r14 = this.f24192n;     // Catch: Throwable -> L41
            this.f24192n = null;     // Catch: Throwable -> L41
            boolean r15 = this.f24193o;     // Catch: Throwable -> L41
            this.f24193o = false;     // Catch: Throwable -> L41
            monitor-exit(this);     // Catch: Throwable -> L41
            long r16 = this.f24189k;
            if (r14 == null) goto L51;
            Iterator r17 = r14.iterator();
            long r18 = r16;
        L49:
            if (r17.hasNext() == false) goto L52;
            r18 = Math.max(r18, ((InnerProducer) r17.next()).totalRequested.get());
        L52:
            if (r15 == false) goto L59;
            InnerProducer[] r19 = c();
            int r20 = r19.length;
            int r21 = 0;
        L54:
            if (r21 >= r20) goto L59;
            InnerProducer r22 = r19[r21];
            if (r22 == null) goto L58;
            r18 = Math.max(r18, r22.totalRequested.get());
        L58:
            r21 = r21 + 1;
        L59:
            e(r18, r16);
            goto L33
        L51:
            r18 = r16;
            goto L52
        L38:
            this.f24187i = false;     // Catch: Throwable -> L41
            monitor-exit(this);     // Catch: Throwable -> L41
            return;
        L34:
            return;
        L24:
            InnerProducer[] r110 = c();
            int r23 = r110.length;
            long r24 = r12;
            int r25 = 0;
        L25:
            if (r25 >= r23) goto L30;
            InnerProducer r26 = r110[r25];
            if (r26 == null) goto L29;
            r24 = Math.max(r24, r26.totalRequested.get());
        L29:
            r25 = r25 + 1;
            goto L25
        L30:
            r13 = r24;
            goto L31
        }

        public void g(InnerProducer r10) {
            if (this.f24181c == false) goto L5;
            return;
        L5:
            rx.internal.util.d r11 = this.f24182d;
            monitor-enter(r11);
        L11:
            th = move-exception;
            throw th;
        L8:
            if (this.f24181c == false) goto L13;
            monitor-exit(r11);     // Catch: Throwable -> L11
            return;
        L13:
            this.f24182d.e(r10);     // Catch: Throwable -> L11
            if (this.f24182d.b() == false) goto L16;
            this.f24183e = f24177p;     // Catch: Throwable -> L11
        L16:
            this.f24184f++;     // Catch: Throwable -> L11
            monitor-exit(r11);     // Catch: Throwable -> L11
        }

        public void h() {
            InnerProducer[] r10 = this.f24183e;
            int r11 = 0;
            if (this.f24185g == this.f24184f) goto L16;
            rx.internal.util.d r12 = this.f24182d;
            monitor-enter(r12);
            r10 = this.f24183e;     // Catch: Throwable -> L9
            Object[] r13 = this.f24182d.h();     // Catch: Throwable -> L9
            int r14 = r13.length;     // Catch: Throwable -> L9
            if (r10.length == r14) goto L11;
            r10 = new InnerProducer[r14];     // Catch: Throwable -> L9
            this.f24183e = r10;     // Catch: Throwable -> L9
        L11:
            System.arraycopy(r13, 0, r10, 0, r14);     // Catch: Throwable -> L9
            this.f24185g = this.f24184f;     // Catch: Throwable -> L9
            monitor-exit(r12);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        L16:
            ReplayBuffer r15 = this.f24179a;
            int r16 = r10.length;
        L17:
            if (r11 >= r16) goto L22;
            InnerProducer r17 = r10[r11];
            if (r17 == null) goto L21;
            r15.replay(r17);
        L21:
            r11 = r11 + 1;
            goto L17
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (this.f24180b == true) goto L10;
            this.f24180b = true;
            this.f24179a.complete();     // Catch: Throwable -> L7
            h();     // Catch: Throwable -> L7
            unsubscribe();
            return;
        L7:
            th = move-exception;
            unsubscribe();
            throw th;
        }

        @Override // rx.Observer
        public void onError(Throwable r10) {
            if (this.f24180b == true) goto L10;
            this.f24180b = true;
            this.f24179a.error(r10);     // Catch: Throwable -> L7
            h();     // Catch: Throwable -> L7
            unsubscribe();
            return;
        L7:
            th = move-exception;
            unsubscribe();
            throw th;
        }

        @Override // rx.Observer
        public void onNext(Object r10) {
            if (this.f24180b == true) goto L6;
            this.f24179a.next(r10);
            h();
            return;
        }

        @Override // rx.Subscriber
        public void setProducer(Producer r10) {
            if (this.f24191m != null) goto L7;
            this.f24191m = r10;
            f(null);
            h();
            return;
        L7:
            throw new IllegalStateException("Only a single producer can be set on a Subscriber.");
        }
    }

    static {
        f24167e = new a();
    }

    public OperatorReplay(Observable.OnSubscribe r10, Observable r11, AtomicReference r12, Func0 r13) {
        super(r10);
        this.f24168b = r11;
        this.f24169c = r12;
        this.f24170d = r13;
    }

    public static rx.observables.a C(Observable r10) {
        return G(r10, f24167e);
    }

    public static rx.observables.a D(Observable r10, int r11) {
        if (r11 != Integer.MAX_VALUE) goto L7;
        return C(r10);
    L7:
        return G(r10, new b(r11));
    }

    public static rx.observables.a E(Observable r10, long r11, TimeUnit r12, jg.a r13) {
        return F(r10, r11, r12, r13, Channel.UNLIMITED);
    }

    public static rx.observables.a F(Observable r10, long r11, TimeUnit r12, jg.a r13, int r14) {
        return G(r10, new c(r14, r12.toMillis(r11), r13));
    }

    public static rx.observables.a G(Observable r10, Func0 r11) {
        AtomicReference r12 = new AtomicReference();
        return new OperatorReplay(new d(r12, r11), r10, r12, r11);
    }

    @Override // rx.observables.a
    public void B(Action1 r10) {
    L2:
        e r11 = (e) this.f24169c.get();
        if (r11 != null) goto L5;
    L6:
        e r12 = new e((ReplayBuffer) this.f24170d.call());
        r12.d();
        if (androidx.lifecycle.p.a(this.f24169c, r11, r12) == false) goto L2;
        r11 = r12;
    L10:
        boolean r13 = false;
        if (r11.f24186h.get() == false) goto L13;
    L15:
        r10.call(r11);
        if (r13 == false) goto L22;
        this.f24168b.z(r11);
        return;
    L22:
        return;
    L13:
        if (r11.f24186h.compareAndSet(false, true) == false) goto L15;
        r13 = true;
        goto L15
    L5:
        if (r11.isUnsubscribed() == false) goto L10;
        goto L6
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        e r10 = (e) this.f24169c.get();
        if (r10 != null) goto L5;
    L8:
        return true;
    L5:
        if (r10.isUnsubscribed() == true) goto L8;
        return false;
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        this.f24169c.lazySet(null);
    }
}
