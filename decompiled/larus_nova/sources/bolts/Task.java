package bolts;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes28.dex */
public class Task<TResult> {
    public static final ExecutorService BACKGROUND_EXECUTOR = null;
    private static final Executor IMMEDIATE_EXECUTOR = null;
    private static Task<?> TASK_CANCELLED;
    private static Task<Boolean> TASK_FALSE;
    private static Task<?> TASK_NULL;
    private static Task<Boolean> TASK_TRUE;
    public static final Executor UI_THREAD_EXECUTOR = null;
    private static volatile q unobservedExceptionHandler;
    private boolean cancelled;
    private boolean complete;
    private List<Continuation<TResult, Void>> continuations;
    private Exception error;
    private boolean errorHasBeenObserved;
    private final Object lock;
    private TResult result;
    private bolts.a unobservedErrorNotifier;

    public class a implements Continuation<TResult, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v.e f19882a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Continuation f19883b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Executor f19884c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ CancellationToken f19885d;

        @Override // bolts.Continuation
        public final Void then(Task r100) throws Exception {
            Task.access$000(this.f19882a, this.f19883b, r100, this.f19884c, this.f19885d);
            return null;
        }

        public a(v.e r100, Continuation r101, Executor r102, CancellationToken r103) {
            this.f19882a = r100;
            this.f19883b = r101;
            this.f19884c = r102;
            this.f19885d = r103;
        }
    }

    public class b implements Continuation<TResult, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v.e f19886a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Continuation f19887b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Executor f19888c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ CancellationToken f19889d;

        @Override // bolts.Continuation
        public final Void then(Task r100) throws Exception {
            Task.access$100(this.f19886a, this.f19887b, r100, this.f19888c, this.f19889d);
            return null;
        }

        public b(v.e r100, Continuation r101, Executor r102, CancellationToken r103) {
            this.f19886a = r100;
            this.f19887b = r101;
            this.f19888c = r102;
            this.f19889d = r103;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [TContinuationResult] */
    public class c<TContinuationResult> implements Continuation<TResult, Task<TContinuationResult>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CancellationToken f19890a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Continuation f19891b;

        @Override // bolts.Continuation
        public final Object then(Task r100) throws Exception {
            CancellationToken r101 = this.f19890a;
            if (r101 == null) goto L8;
            if (r101.isCancellationRequested() == false) goto L8;
            return Task.cancelled();
        L8:
            if (r100.isFaulted() == false) goto L11;
            return Task.forError(r100.getError());
        L11:
            if (r100.isCancelled() == false) goto L14;
            return Task.cancelled();
        L14:
            return r100.continueWith(this.f19891b);
        }

        public c(CancellationToken r100, Continuation r101) {
            this.f19890a = r100;
            this.f19891b = r101;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [TContinuationResult] */
    public class d<TContinuationResult> implements Continuation<TResult, Task<TContinuationResult>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CancellationToken f19892a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Continuation f19893b;

        @Override // bolts.Continuation
        public final Object then(Task r100) throws Exception {
            CancellationToken r101 = this.f19892a;
            if (r101 == null) goto L8;
            if (r101.isCancellationRequested() == false) goto L8;
            return Task.cancelled();
        L8:
            if (r100.isFaulted() == false) goto L11;
            return Task.forError(r100.getError());
        L11:
            if (r100.isCancelled() == false) goto L14;
            return Task.cancelled();
        L14:
            return r100.continueWithTask(this.f19893b);
        }

        public d(CancellationToken r100, Continuation r101) {
            this.f19892a = r100;
            this.f19893b = r101;
        }
    }

    public static class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CancellationToken f19894a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v.e f19895b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Continuation f19896c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Task f19897d;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            CancellationToken r100 = this.f19894a;     // Catch: Throwable -> L14
            if (r100 != null) goto L5;
        L22:
            Object r101 = this.f19896c.then(this.f19897d);     // Catch: Exception -> L10 CancellationException -> L12 Throwable -> L14
            this.f19895b.setResult(r101);     // Catch: Exception -> L10 CancellationException -> L12 Throwable -> L14
        L19:
            return;
        L12:
            this.f19895b.a();     // Catch: Throwable -> L14
        L10:
            e = move-exception;
            this.f19895b.b(e);     // Catch: Throwable -> L14
            goto L19
        L5:
            if (r100.isCancellationRequested() == false) goto L22;
            this.f19895b.a();     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L24;
            throw th;
        }

        public e(CancellationToken r100, v.e r101, Continuation r102, Task r103) {
            this.f19894a = r100;
            this.f19895b = r101;
            this.f19896c = r102;
            this.f19897d = r103;
        }
    }

    public static class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CancellationToken f19898a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v.e f19899b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Continuation f19900c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Task f19901d;

        /* JADX INFO: Add missing generic type declarations: [TContinuationResult] */
        public class a<TContinuationResult> implements Continuation<TContinuationResult, Void> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ f f19902a;

            public a(f r100) {
                this.f19902a = r100;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // bolts.Continuation
            public final Void then(Task r100) throws Exception {
                CancellationToken r101 = this.f19902a.f19898a;
                if (r101 == null) goto L8;
                if (r101.isCancellationRequested() == false) goto L8;
                this.f19902a.f19899b.a();
                return null;
            L8:
                if (r100.isCancelled() == false) goto L11;
                this.f19902a.f19899b.a();
                return null;
            L11:
                if (r100.isFaulted() == false) goto L13;
                this.f19902a.f19899b.b(r100.getError());
                return null;
            L13:
                this.f19902a.f19899b.setResult(r100.getResult());
                return null;
            }
        }

        public final void a() {
            CancellationToken r100 = this.f19898a;
            if (r100 != null) goto L5;
        L17:
            Task r101 = (Task) this.f19900c.then(this.f19901d);     // Catch: Exception -> L13 CancellationException -> L15
            if (r101 != null) goto L11;
            this.f19899b.setResult(null);     // Catch: Exception -> L13 CancellationException -> L15
            return;
        L11:
            r101.continueWith(new a(this));     // Catch: Exception -> L13 CancellationException -> L15
            return;
        L15:
            this.f19899b.a();
            return;
        L13:
            e = move-exception;
            this.f19899b.b(e);
            return;
        L5:
            if (r100.isCancellationRequested() == false) goto L17;
            this.f19899b.a();
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public f(CancellationToken r100, v.e r101, Continuation r102, Task r103) {
            this.f19898a = r100;
            this.f19899b = r101;
            this.f19900c = r102;
            this.f19901d = r103;
        }
    }

    public static class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v.e f19903a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f19903a.f552273a.trySetResult(null);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public g(v.e r100) {
            this.f19903a = r100;
        }
    }

    public static class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ScheduledFuture f19904a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v.e f19905b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f19904a.cancel(true);     // Catch: Throwable -> L4
            this.f19905b.f552273a.trySetCancelled();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public h(ScheduledFuture r100, v.e r101) {
            this.f19904a = r100;
            this.f19905b = r101;
        }
    }

    public class i implements Continuation<TResult, Task<Void>> {
        public i() {
        }

        @Override // bolts.Continuation
        public final Task<Void> then(Task r100) throws Exception {
            if (r100.isCancelled() == false) goto L6;
            return Task.cancelled();
        L6:
            if (r100.isFaulted() == false) goto L9;
            return Task.forError(r100.getError());
        L9:
            return Task.forResult(null);
        }
    }

    public static class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CancellationToken f19906a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v.e f19907b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Callable f19908c;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            CancellationToken r100 = this.f19906a;     // Catch: Throwable -> L14
            if (r100 != null) goto L5;
        L22:
            this.f19907b.setResult(this.f19908c.call());     // Catch: Exception -> L10 CancellationException -> L12 Throwable -> L14
        L19:
            return;
        L12:
            this.f19907b.a();     // Catch: Throwable -> L14
        L10:
            e = move-exception;
            this.f19907b.b(e);     // Catch: Throwable -> L14
            goto L19
        L5:
            if (r100.isCancellationRequested() == false) goto L22;
            this.f19907b.a();     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L24;
            throw th;
        }

        public j(CancellationToken r100, v.e r101, Callable r102) {
            this.f19906a = r100;
            this.f19907b = r101;
            this.f19908c = r102;
        }
    }

    public static class k implements Continuation<TResult, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f19909a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v.e f19910b;

        @Override // bolts.Continuation
        public final Void then(Task r100) throws Exception {
            if (this.f19909a.compareAndSet(false, true) == false) goto L5;
            this.f19910b.setResult(r100);
            return null;
        L5:
            r100.getError();
            return null;
        }

        public k(AtomicBoolean r100, v.e r101) {
            this.f19909a = r100;
            this.f19910b = r101;
        }
    }

    public static class l implements Continuation<Object, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f19911a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v.e f19912b;

        @Override // bolts.Continuation
        public final Void then(Task<Object> r100) throws Exception {
            if (this.f19911a.compareAndSet(false, true) == false) goto L5;
            this.f19912b.setResult(r100);
            return null;
        L5:
            r100.getError();
            return null;
        }

        public l(AtomicBoolean r100, v.e r101) {
            this.f19911a = r100;
            this.f19912b = r101;
        }
    }

    public static class m implements Continuation<Void, List<TResult>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Collection f19913a;

        public m(Collection r100) {
            this.f19913a = r100;
        }

        @Override // bolts.Continuation
        public final Object then(Task<Void> r100) throws Exception {
            if (this.f19913a.size() == 0) goto L9;
            ArrayList r101 = new ArrayList();
            Iterator r102 = this.f19913a.iterator();
        L7:
            if (r102.hasNext() == false) goto L11;
            r101.add(((Task) r102.next()).getResult());
            goto L7
        L11:
            return r101;
        L9:
            return Collections.emptyList();
        }
    }

    public static class n implements Continuation<Object, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f19914a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f19915b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f19916c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f19917d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ v.e f19918e;

        @Override // bolts.Continuation
        public final Void then(Task<Object> r100) throws Exception {
            if (r100.isFaulted() == false) goto L13;
            Object r101 = this.f19914a;
            monitor-enter(r101);
            this.f19915b.add(r100.getError());     // Catch: Throwable -> L9
            monitor-exit(r101);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        L13:
            if (r100.isCancelled() == false) goto L16;
            this.f19916c.set(true);
        L16:
            if (this.f19917d.decrementAndGet() == 0) goto L18;
        L27:
            return null;
        L18:
            if (this.f19915b.size() == 0) goto L24;
            if (this.f19915b.size() != 1) goto L22;
            this.f19918e.b((Exception) ListProtector.get(this.f19915b, 0));
            goto L27
        L22:
            this.f19918e.b(new AggregateException(String.format("There were %d exceptions.", new Object[]{Integer.valueOf(this.f19915b.size())}), this.f19915b));
            goto L27
        L24:
            if (this.f19916c.get() == false) goto L26;
            this.f19918e.a();
            goto L27
        L26:
            this.f19918e.setResult(null);
            goto L27
        }

        public n(Object r100, ArrayList r101, AtomicBoolean r102, AtomicInteger r103, v.e r104) {
            this.f19914a = r100;
            this.f19915b = r101;
            this.f19916c = r102;
            this.f19917d = r103;
            this.f19918e = r104;
        }
    }

    public class o implements Continuation<Void, Task<Void>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CancellationToken f19919a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Callable f19920b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Continuation f19921c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Executor f19922d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ v.d f19923e;

        @Override // bolts.Continuation
        public final Task<Void> then(Task<Void> r100) throws Exception {
            CancellationToken r101 = this.f19919a;
            if (r101 == null) goto L8;
            if (r101.isCancellationRequested() == false) goto L8;
            return Task.cancelled();
        L8:
            if (((Boolean) this.f19920b.call()).booleanValue() == false) goto L11;
            return Task.forResult(null).onSuccessTask(this.f19921c, this.f19922d).onSuccessTask((Continuation) this.f19923e.f552272a, this.f19922d);
        L11:
            return Task.forResult(null);
        }

        public o(CancellationToken r100, Callable r101, Continuation r102, Executor r103, v.d r104) {
            this.f19919a = r100;
            this.f19920b = r101;
            this.f19921c = r102;
            this.f19922d = r103;
            this.f19923e = r104;
        }
    }

    public class p extends v.e<TResult> {
        public p() {
        }
    }

    public interface q {
    }

    public static q getUnobservedExceptionHandler() {
        return null;
    }

    public static void setUnobservedExceptionHandler(q r100) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <TOut> Task<TOut> cast() {
        return this;
    }

    static {
        v.b r100 = v.b.f552263d;
        BACKGROUND_EXECUTOR = r100.f552264a;
        IMMEDIATE_EXECUTOR = r100.f552266c;
        UI_THREAD_EXECUTOR = v.a.f552259b.f552262a;
        TASK_NULL = new Task(null);
        TASK_TRUE = new Task(Boolean.TRUE);
        TASK_FALSE = new Task(Boolean.FALSE);
        TASK_CANCELLED = new Task(true);
    }

    public static <TResult> Task<TResult>.p create() {
        new Task();
        return new p();
    }

    private void runContinuations() {
        Object r100 = this.lock;
        monitor-enter(r100);
        Iterator<Continuation<TResult, Void>> r101 = this.continuations.iterator();     // Catch: Throwable -> L18
    L6:
        if (r101.hasNext() == false) goto L15;
        r101.next().then(this);     // Catch: Exception -> L10 RuntimeException -> L13 Throwable -> L18
    L13:
        e = move-exception;
        throw e;     // Catch: Throwable -> L18
    L10:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L18
    L15:
        this.continuations = null;     // Catch: Throwable -> L18
        monitor-exit(r100);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public Exception getError() {
        Object r100 = this.lock;
        monitor-enter(r100);
        Exception r101 = this.error;     // Catch: Throwable -> L11
        if (r101 == null) goto L9;
        this.errorHasBeenObserved = true;     // Catch: Throwable -> L11
        bolts.a r102 = this.unobservedErrorNotifier;     // Catch: Throwable -> L11
        if (r102 == null) goto L9;
        r102.getClass();     // Catch: Throwable -> L11
        this.unobservedErrorNotifier = null;     // Catch: Throwable -> L11
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L11
        return r101;
    L11:
        th = move-exception;
        throw th;
    }

    public TResult getResult() {
        Object r100 = this.lock;
        monitor-enter(r100);
        TResult r101 = this.result;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isCancelled() {
        Object r100 = this.lock;
        monitor-enter(r100);
        boolean r101 = this.cancelled;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isCompleted() {
        Object r100 = this.lock;
        monitor-enter(r100);
        boolean r101 = this.complete;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isFaulted() {
        Object r100 = this.lock;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (getError() == null) goto L7;
        boolean r101 = true;
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L10
        return r101;
    L7:
        r101 = false;
        goto L8
    }

    public Task<Void> makeVoid() {
        return continueWithTask(new i());
    }

    public boolean trySetCancelled() {
        Object r100 = this.lock;
        monitor-enter(r100);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.complete == false) goto L9;
        monitor-exit(r100);     // Catch: Throwable -> L12
        return false;
    L9:
        this.complete = true;     // Catch: Throwable -> L12
        this.cancelled = true;     // Catch: Throwable -> L12
        this.lock.notifyAll();     // Catch: Throwable -> L12
        runContinuations();     // Catch: Throwable -> L12
        monitor-exit(r100);     // Catch: Throwable -> L12
        return true;
    }

    public void waitForCompletion() throws InterruptedException {
        Object r100 = this.lock;
        monitor-enter(r100);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (isCompleted() == true) goto L7;
        this.lock.wait();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L9
    }

    public Task() {
        this.lock = new Object();
        this.continuations = new ArrayList();
    }

    public static <TResult> Task<TResult> cancelled() {
        return (Task<TResult>) TASK_CANCELLED;
    }

    private Task(boolean r100) {
        this.lock = new Object();
        this.continuations = new ArrayList();
        if (r100 == false) goto L5;
        trySetCancelled();
        return;
    L5:
        trySetResult(null);
    }

    public static <TResult> Task<TResult> call(Callable<TResult> r100) {
        return call(r100, IMMEDIATE_EXECUTOR, null);
    }

    public static <TResult> Task<TResult> callInBackground(Callable<TResult> r100) {
        return call(r100, BACKGROUND_EXECUTOR, null);
    }

    public static Task<Void> delay(long r100) {
        return delay(r100, v.b.f552263d.f552265b, null);
    }

    public static <TResult> Task<TResult> forError(Exception r100) {
        Task<TResult> r101 = new Task();
        if (r101.trySetError(r100) == false) goto L6;
        return r101;
    L6:
        throw new IllegalStateException("Cannot set the error on a completed task.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <TResult> Task<TResult> forResult(TResult r100) {
        if (r100 != 0) goto L6;
        return (Task<TResult>) TASK_NULL;
    L6:
        if ((r100 instanceof Boolean) == true) goto L8;
        v.e r101 = new v.e();
        r101.setResult(r100);
        return r101.f552273a;
    L8:
        if (((Boolean) r100).booleanValue() == false) goto L11;
        return (Task<TResult>) TASK_TRUE;
    L11:
        return (Task<TResult>) TASK_FALSE;
    }

    public static Task<Void> whenAll(Collection<? extends Task<?>> r110) {
        if (r110.size() == 0) goto L5;
        v.e r100 = new v.e();
        ArrayList r101 = new ArrayList();
        Object r102 = new Object();
        AtomicInteger r103 = new AtomicInteger(r110.size());
        AtomicBoolean r111 = new AtomicBoolean(false);
        Iterator<? extends Task<?>> r112 = r110.iterator();
    L8:
        if (r112.hasNext() == false) goto L11;
        r112.next().continueWith(new n(r102, r101, r111, r103, r100));
        goto L8
    L11:
        return r100.f552273a;
    L5:
        return forResult(null);
    }

    public static <TResult> Task<List<TResult>> whenAllResult(Collection<? extends Task<TResult>> r100) {
        return (Task<List<TResult>>) whenAll(r100).onSuccess(new m(r100));
    }

    public static Task<Task<?>> whenAny(Collection<? extends Task<?>> r100) {
        if (r100.size() == 0) goto L5;
        v.e r101 = new v.e();
        AtomicBoolean r102 = new AtomicBoolean(false);
        Iterator<? extends Task<?>> r103 = r100.iterator();
    L8:
        if (r103.hasNext() == false) goto L11;
        r103.next().continueWith(new l(r102, r101));
        goto L8
    L11:
        return r101.f552273a;
    L5:
        return forResult(null);
    }

    public static <TResult> Task<Task<TResult>> whenAnyResult(Collection<? extends Task<TResult>> r100) {
        if (r100.size() == 0) goto L5;
        v.e r101 = new v.e();
        AtomicBoolean r102 = new AtomicBoolean(false);
        Iterator<? extends Task<TResult>> r103 = r100.iterator();
    L8:
        if (r103.hasNext() == false) goto L11;
        r103.next().continueWith(new k(r102, r101));
        goto L8
    L11:
        return r101.f552273a;
    L5:
        return forResult(null);
    }

    public <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> r100) {
        return continueWith(r100, IMMEDIATE_EXECUTOR, null);
    }

    public <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> r100) {
        return continueWithTask(r100, IMMEDIATE_EXECUTOR, null);
    }

    public <TContinuationResult> Task<TContinuationResult> onSuccess(Continuation<TResult, TContinuationResult> r100) {
        return onSuccess(r100, IMMEDIATE_EXECUTOR, null);
    }

    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(Continuation<TResult, Task<TContinuationResult>> r100) {
        return onSuccessTask(r100, IMMEDIATE_EXECUTOR);
    }

    public boolean trySetError(Exception r100) {
        Object r101 = this.lock;
        monitor-enter(r101);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.complete == false) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L13
        return false;
    L8:
        this.complete = true;     // Catch: Throwable -> L13
        this.error = r100;     // Catch: Throwable -> L13
        this.errorHasBeenObserved = false;     // Catch: Throwable -> L13
        this.lock.notifyAll();     // Catch: Throwable -> L13
        runContinuations();     // Catch: Throwable -> L13
        if (this.errorHasBeenObserved == true) goto L11;
        getUnobservedExceptionHandler();     // Catch: Throwable -> L13
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L13
        return true;
    }

    public boolean trySetResult(TResult r100) {
        Object r101 = this.lock;
        monitor-enter(r101);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.complete == false) goto L9;
        monitor-exit(r101);     // Catch: Throwable -> L12
        return false;
    L9:
        this.complete = true;     // Catch: Throwable -> L12
        this.result = r100;     // Catch: Throwable -> L12
        this.lock.notifyAll();     // Catch: Throwable -> L12
        runContinuations();     // Catch: Throwable -> L12
        monitor-exit(r101);     // Catch: Throwable -> L12
        return true;
    }

    private Task(TResult r100) {
        this.lock = new Object();
        this.continuations = new ArrayList();
        trySetResult(r100);
    }

    public static <TResult> Task<TResult> call(Callable<TResult> r100, CancellationToken r101) {
        return call(r100, IMMEDIATE_EXECUTOR, r101);
    }

    public static <TResult> Task<TResult> callInBackground(Callable<TResult> r100, CancellationToken r101) {
        return call(r100, BACKGROUND_EXECUTOR, r101);
    }

    public static Task<Void> delay(long r100, CancellationToken r101) {
        return delay(r100, v.b.f552263d.f552265b, r101);
    }

    public Task<Void> continueWhile(Callable<Boolean> r100, Continuation<Void, Task<Void>> r101) {
        return continueWhile(r100, r101, IMMEDIATE_EXECUTOR, null);
    }

    public <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> r100, CancellationToken r101) {
        return continueWith(r100, IMMEDIATE_EXECUTOR, r101);
    }

    public <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> r100, CancellationToken r101) {
        return continueWithTask(r100, IMMEDIATE_EXECUTOR, r101);
    }

    public <TContinuationResult> Task<TContinuationResult> onSuccess(Continuation<TResult, TContinuationResult> r100, CancellationToken r101) {
        return onSuccess(r100, IMMEDIATE_EXECUTOR, r101);
    }

    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(Continuation<TResult, Task<TContinuationResult>> r100, CancellationToken r101) {
        return onSuccessTask(r100, IMMEDIATE_EXECUTOR, r101);
    }

    public boolean waitForCompletion(long r100, TimeUnit r101) throws InterruptedException {
        Object r102 = this.lock;
        monitor-enter(r102);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (isCompleted() == true) goto L7;
        this.lock.wait(r101.toMillis(r100));     // Catch: Throwable -> L10
    L7:
        boolean r103 = isCompleted();     // Catch: Throwable -> L10
        monitor-exit(r102);     // Catch: Throwable -> L10
        return r103;
    }

    public static <TResult> Task<TResult> call(Callable<TResult> r100, Executor r101) {
        return call(r100, r101, null);
    }

    public <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> r100, Executor r101) {
        return continueWith(r100, r101, null);
    }

    public <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> r100, Executor r101) {
        return continueWithTask(r100, r101, null);
    }

    public <TContinuationResult> Task<TContinuationResult> onSuccess(Continuation<TResult, TContinuationResult> r100, Executor r101) {
        return onSuccess(r100, r101, null);
    }

    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(Continuation<TResult, Task<TContinuationResult>> r100, Executor r101) {
        return onSuccessTask(r100, r101, null);
    }

    public static <TResult> Task<TResult> call(Callable<TResult> r100, Executor r101, CancellationToken r102) {
        v.e r103 = new v.e();
        r101.execute(new j(r102, r103, r100));     // Catch: Exception -> L5
    L8:
        return r103.f552273a;
    L5:
        e = move-exception;
        r103.b(new ExecutorException(e));
        goto L8
    }

    public static Task<Void> delay(long r100, ScheduledExecutorService r101, CancellationToken r102) {
        if (r102 == null) goto L8;
        if (r102.isCancellationRequested() == false) goto L8;
        return cancelled();
    L8:
        if (r100 <= 0) goto L10;
        v.e r103 = new v.e();
        ScheduledFuture<?> r104 = r101.schedule(new g(r103), r100, TimeUnit.MILLISECONDS);
        if (r102 == null) goto L15;
        r102.register(new h(r104, r103));
    L15:
        return r103.f552273a;
    L10:
        return forResult(null);
    }

    public Task<Void> continueWhile(Callable<Boolean> r100, Continuation<Void, Task<Void>> r101, CancellationToken r102) {
        return continueWhile(r100, r101, IMMEDIATE_EXECUTOR, r102);
    }

    public <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> r100, Executor r101, CancellationToken r102) {
        v.e r103 = new v.e();
        Object r104 = this.lock;
        monitor-enter(r104);
        boolean r105 = isCompleted();     // Catch: Throwable -> L12
        if (r105 == true) goto L7;
        this.continuations.add(new a(r103, r100, r101, r102));     // Catch: Throwable -> L12
    L7:
        monitor-exit(r104);     // Catch: Throwable -> L12
        if (r105 == false) goto L11;
        completeImmediately(r103, r100, this, r101, r102);
    L11:
        return r103.f552273a;
    L12:
        th = move-exception;
        throw th;
    }

    public <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> r100, Executor r101, CancellationToken r102) {
        v.e r103 = new v.e();
        Object r104 = this.lock;
        monitor-enter(r104);
        boolean r105 = isCompleted();     // Catch: Throwable -> L12
        if (r105 == true) goto L7;
        this.continuations.add(new b(r103, r100, r101, r102));     // Catch: Throwable -> L12
    L7:
        monitor-exit(r104);     // Catch: Throwable -> L12
        if (r105 == false) goto L11;
        completeAfterTask(r103, r100, this, r101, r102);
    L11:
        return r103.f552273a;
    L12:
        th = move-exception;
        throw th;
    }

    public <TContinuationResult> Task<TContinuationResult> onSuccess(Continuation<TResult, TContinuationResult> r100, Executor r101, CancellationToken r102) {
        return continueWithTask(new c(r102, r100), r101);
    }

    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(Continuation<TResult, Task<TContinuationResult>> r100, Executor r101, CancellationToken r102) {
        return continueWithTask(new d(r102, r100), r101);
    }

    public Task<Void> continueWhile(Callable<Boolean> r100, Continuation<Void, Task<Void>> r101, Executor r102) {
        return continueWhile(r100, r101, r102, null);
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [T, bolts.Task$o] */
    public Task<Void> continueWhile(Callable<Boolean> r100, Continuation<Void, Task<Void>> r110, Executor r111, CancellationToken r112) {
        v.d r101 = new v.d();
        r101.f552272a = new o(r112, r100, r110, r111, r101);
        return makeVoid().continueWithTask((Continuation) r101.f552272a, r111);
    }

    public static /* synthetic */ void access$000(v.e r100, Continuation r101, Task r102, Executor r103, CancellationToken r104) {
        completeImmediately(r100, r101, r102, r103, r104);
    }

    public static /* synthetic */ void access$100(v.e r100, Continuation r101, Task r102, Executor r103, CancellationToken r104) {
        completeAfterTask(r100, r101, r102, r103, r104);
    }

    private static <TContinuationResult, TResult> void completeAfterTask(v.e<TContinuationResult> r100, Continuation<TResult, Task<TContinuationResult>> r101, Task<TResult> r102, Executor r103, CancellationToken r104) {
        r103.execute(new f(r104, r100, r101, r102));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        r100.b(new ExecutorException(e));
    }

    private static <TContinuationResult, TResult> void completeImmediately(v.e<TContinuationResult> r100, Continuation<TResult, TContinuationResult> r101, Task<TResult> r102, Executor r103, CancellationToken r104) {
        r103.execute(new e(r104, r100, r101, r102));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        r100.b(new ExecutorException(e));
    }
}
