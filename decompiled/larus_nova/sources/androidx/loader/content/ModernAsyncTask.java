package androidx.loader.content;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import r27.a;

/* JADX INFO: loaded from: classes17.dex */
abstract class ModernAsyncTask<Params, Progress, Result> {
    private static final int CORE_POOL_SIZE = 5;
    private static final int KEEP_ALIVE = 1;
    private static final String LOG_TAG = "AsyncTask";
    private static final int MAXIMUM_POOL_SIZE = 128;
    private static final int MESSAGE_POST_PROGRESS = 2;
    private static final int MESSAGE_POST_RESULT = 1;
    public static final Executor THREAD_POOL_EXECUTOR = null;
    private static volatile Executor sDefaultExecutor;
    private static InternalHandler sHandler;
    private static final BlockingQueue<Runnable> sPoolWorkQueue = null;
    private static final ThreadFactory sThreadFactory = null;
    final AtomicBoolean mCancelled;
    private final FutureTask<Result> mFuture;
    private volatile Status mStatus;
    final AtomicBoolean mTaskInvoked;
    private final WorkerRunnable<Params, Result> mWorker;

    /* JADX INFO: renamed from: androidx.loader.content.ModernAsyncTask$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$androidx$loader$content$ModernAsyncTask$Status = null;

        static {
            int[] r100 = new int[Status.values().length];
            $SwitchMap$androidx$loader$content$ModernAsyncTask$Status = r100;
            r100[Status.RUNNING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$androidx$loader$content$ModernAsyncTask$Status[Status.FINISHED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static class AsyncTaskResult<Data> {
        final Data[] mData;
        final ModernAsyncTask mTask;

        public AsyncTaskResult(ModernAsyncTask r100, Data... r101) {
            this.mTask = r100;
            this.mData = r101;
        }
    }

    public static class InternalHandler extends Handler {
        public InternalHandler() {
            super(Looper.getMainLooper());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.os.Handler
        public void handleMessage(Message r100) {
            AsyncTaskResult r101 = (AsyncTaskResult) r100.obj;
            int r102 = r100.what;
            if (r102 != 1) goto L5;
            r101.mTask.finish(r101.mData[0]);
            return;
        L5:
            if (r102 != 2) goto L11;
            r101.mTask.onProgressUpdate(r101.mData);
            return;
        }
    }

    public static final enum Status extends Enum<Status> {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final Status FINISHED = null;
        public static final Status PENDING = null;
        public static final Status RUNNING = null;

        static {
            Status r100 = new Status("PENDING", 0);
            PENDING = r100;
            Status r101 = new Status("RUNNING", 1);
            RUNNING = r101;
            Status r102 = new Status("FINISHED", 2);
            FINISHED = r102;
            $VALUES = new Status[]{r100, r101, r102};
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }

        public static Status valueOf(String r100) {
            return (Status) a.a(Status.class, r100);
        }

        private Status(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static abstract class WorkerRunnable<Params, Result> implements Callable<Result> {
        Params[] mParams;

        public WorkerRunnable() {
        }
    }

    public abstract Result doInBackground(Params... r100);

    public void onCancelled() {
    }

    public void onPostExecute(Result r100) {
    }

    public void onPreExecute() {
    }

    public void onProgressUpdate(Progress... r100) {
    }

    static {
        ThreadFactory r100 = new AnonymousClass1();
        sThreadFactory = r100;
        LinkedBlockingQueue r101 = new LinkedBlockingQueue(10);
        sPoolWorkQueue = r101;
        PThreadPoolExecutor r102 = new PThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, r101, r100);
        THREAD_POOL_EXECUTOR = r102;
        sDefaultExecutor = r102;
    }

    private static Handler getHandler() {
        monitor-enter(ModernAsyncTask.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sHandler != null) goto L7;
        sHandler = new InternalHandler();     // Catch: Throwable -> L10
    L7:
        InternalHandler r100 = sHandler;     // Catch: Throwable -> L10
        monitor-exit(ModernAsyncTask.class);     // Catch: Throwable -> L10
        return r100;
    }

    public final Result get() throws InterruptedException, ExecutionException {
        return this.mFuture.get();
    }

    public final boolean isCancelled() {
        return this.mCancelled.get();
    }

    public ModernAsyncTask() {
        this.mStatus = Status.PENDING;
        this.mCancelled = new AtomicBoolean();
        this.mTaskInvoked = new AtomicBoolean();
        final WorkerRunnable<Params, Result> r100 = new AnonymousClass2(this);
        this.mWorker = r100;
        this.mFuture = new AnonymousClass3(this, r100);
    }

    public final Status getStatus() {
        return this.mStatus;
    }

    public static void setDefaultExecutor(Executor r100) {
        sDefaultExecutor = r100;
    }

    public final boolean cancel(boolean r100) {
        this.mCancelled.set(true);
        return this.mFuture.cancel(r100);
    }

    public final ModernAsyncTask<Params, Progress, Result> execute(Params... r100) {
        return executeOnExecutor(sDefaultExecutor, r100);
    }

    public void finish(Result r100) {
        if (isCancelled() == false) goto L5;
        onCancelled(r100);
    L6:
        this.mStatus = Status.FINISHED;
        return;
    L5:
        onPostExecute(r100);
        goto L6
    }

    public void onCancelled(Result r100) {
        onCancelled();
    }

    public Result postResult(Result r100) {
        getHandler().obtainMessage(1, new AsyncTaskResult(this, new Object[]{r100})).sendToTarget();
        return r100;
    }

    public void postResultIfNotInvoked(Result r100) {
        if (this.mTaskInvoked.get() == true) goto L6;
        postResult(r100);
        return;
    }

    public final void publishProgress(Progress... r100) {
        if (isCancelled() == true) goto L6;
        getHandler().obtainMessage(2, new AsyncTaskResult(this, r100)).sendToTarget();
        return;
    }

    public static void execute(Runnable r100) {
        sDefaultExecutor.execute(r100);
    }

    public final ModernAsyncTask<Params, Progress, Result> executeOnExecutor(Executor r100, Params... r101) {
        if (this.mStatus == Status.PENDING) goto L14;
        int r102 = AnonymousClass4.$SwitchMap$androidx$loader$content$ModernAsyncTask$Status[this.mStatus.ordinal()];
        if (r102 == 1) goto L13;
        if (r102 == 2) goto L11;
        throw new IllegalStateException("We should never reach this state");
    L11:
        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
    L13:
        throw new IllegalStateException("Cannot execute task: the task is already running.");
    L14:
        this.mStatus = Status.RUNNING;
        onPreExecute();
        this.mWorker.mParams = r101;
        r100.execute(this.mFuture);
        return this;
    }

    public final Result get(long r100, TimeUnit r101) throws InterruptedException, ExecutionException, TimeoutException {
        return this.mFuture.get(r100, r101);
    }
}
