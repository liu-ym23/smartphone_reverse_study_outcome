package androidx.loader.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.util.TimeUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.wallpaper.ChatThemeInfo;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes17.dex */
public abstract class AsyncTaskLoader<D> extends Loader<D> {
    static final boolean DEBUG = false;
    static final String TAG = "AsyncTaskLoader";
    volatile AsyncTaskLoader<D>.LoadTask mCancellingTask;
    private final Executor mExecutor;
    Handler mHandler;
    long mLastLoadCompleteTime;
    volatile AsyncTaskLoader<D>.LoadTask mTask;
    long mUpdateThrottle;

    public final class LoadTask extends ModernAsyncTask<Void, Void, D> implements Runnable {
        private final CountDownLatch mDone;
        final /* synthetic */ AsyncTaskLoader this$0;
        boolean waiting;

        public void androidx_loader_content_AsyncTaskLoader$LoadTask__run$___twin___() {
            this.waiting = false;
            this.this$0.executePendingTask();
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx_loader_content_AsyncTaskLoader$LoadTask_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void waitForLoader() {
            this.mDone.await();     // Catch: InterruptedException -> L4
            return;
        }

        public LoadTask(AsyncTaskLoader r100) {
            this.this$0 = r100;
            this.mDone = new CountDownLatch(1);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void androidx_loader_content_AsyncTaskLoader$LoadTask_com_larus_apm_impl_protector_RunnableLancet_run(LoadTask r100) {
            r100.androidx_loader_content_AsyncTaskLoader$LoadTask__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        public D doInBackground2(Void... r100) {
            return (D) this.this$0.onLoadInBackground();
        L4:
            e = move-exception;
            if (isCancelled() == false) goto L9;
            return null;
        L9:
            throw e;
        }

        @Override // androidx.loader.content.ModernAsyncTask
        public void onCancelled(D r100) {
            this.this$0.dispatchOnCancelled(this, r100);     // Catch: Throwable -> L5
            this.mDone.countDown();
            return;
        L5:
            th = move-exception;
            this.mDone.countDown();
            throw th;
        }

        @Override // androidx.loader.content.ModernAsyncTask
        public void onPostExecute(D r100) {
            this.this$0.dispatchOnLoadComplete(this, r100);     // Catch: Throwable -> L5
            this.mDone.countDown();
            return;
        L5:
            th = move-exception;
            this.mDone.countDown();
            throw th;
        }

        @Override // androidx.loader.content.ModernAsyncTask
        public /* bridge */ /* synthetic */ Object doInBackground(Void[] r100) {
            return doInBackground2(r100);
        }
    }

    public void cancelLoadInBackground() {
    }

    public abstract D loadInBackground();

    public void onCanceled(D r100) {
    }

    public void executePendingTask() {
        if (this.mCancellingTask == null) goto L5;
        return;
    L5:
        if (this.mTask != null) goto L7;
        return;
    L7:
        if (this.mTask.waiting == false) goto L10;
        this.mTask.waiting = false;
        this.mHandler.removeCallbacks(this.mTask);
    L10:
        if (this.mUpdateThrottle > 0) goto L12;
    L15:
        this.mTask.executeOnExecutor(this.mExecutor, null);
        return;
    L12:
        if (SystemClock.uptimeMillis() >= (this.mLastLoadCompleteTime + this.mUpdateThrottle)) goto L15;
        this.mTask.waiting = true;
        this.mHandler.postAtTime(this.mTask, this.mLastLoadCompleteTime + this.mUpdateThrottle);
    }

    public boolean isLoadInBackgroundCanceled() {
        if (this.mCancellingTask == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.loader.content.Loader
    public boolean onCancelLoad() {
        if (this.mTask != null) goto L5;
        return false;
    L5:
        if (this.mStarted == true) goto L8;
        this.mContentChanged = true;
    L8:
        if (this.mCancellingTask == null) goto L15;
        if (this.mTask.waiting == false) goto L12;
        this.mTask.waiting = false;
        this.mHandler.removeCallbacks(this.mTask);
    L12:
        this.mTask = null;
        return false;
    L15:
        if (this.mTask.waiting == false) goto L18;
        this.mTask.waiting = false;
        this.mHandler.removeCallbacks(this.mTask);
        this.mTask = null;
        return false;
    L18:
        boolean r100 = this.mTask.cancel(false);
        if (r100 == false) goto L21;
        this.mCancellingTask = this.mTask;
        cancelLoadInBackground();
    L21:
        this.mTask = null;
        return r100;
    }

    public void waitForLoader() {
        AsyncTaskLoader<D>.LoadTask r100 = this.mTask;
        if (r100 == null) goto L6;
        r100.waitForLoader();
        return;
    }

    @Override // androidx.loader.content.Loader
    public void onForceLoad() {
        super.onForceLoad();
        cancelLoad();
        this.mTask = new LoadTask(this);
        executePendingTask();
    }

    public D onLoadInBackground() {
        return loadInBackground();
    }

    public AsyncTaskLoader(Context r100) {
        this(r100, ModernAsyncTask.THREAD_POOL_EXECUTOR);
    }

    public void setUpdateThrottle(long r100) {
        this.mUpdateThrottle = r100;
        if (r100 == 0) goto L6;
        this.mHandler = new Handler();
        return;
    }

    private AsyncTaskLoader(Context r100, Executor r101) {
        super(r100);
        this.mLastLoadCompleteTime = ChatThemeInfo.FAKE_ID;
        this.mExecutor = r101;
    }

    public void dispatchOnCancelled(AsyncTaskLoader<D>.LoadTask r100, D r101) {
        onCanceled(r101);
        if (this.mCancellingTask != r100) goto L6;
        rollbackContentChanged();
        this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
        this.mCancellingTask = null;
        deliverCancellation();
        executePendingTask();
        return;
    }

    public void dispatchOnLoadComplete(AsyncTaskLoader<D>.LoadTask r100, D r101) {
        if (this.mTask == r100) goto L6;
        dispatchOnCancelled(r100, r101);
        return;
    L6:
        if (isAbandoned() == false) goto L8;
        onCanceled(r101);
        return;
    L8:
        commitContentChanged();
        this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
        this.mTask = null;
        deliverResult(r101);
    }

    @Override // androidx.loader.content.Loader
    public void dump(String r100, FileDescriptor r101, PrintWriter r102, String[] r103) {
        super.dump(r100, r101, r102, r103);
        if (this.mTask == null) goto L6;
        r102.print(r100);
        r102.print("mTask=");
        r102.print(this.mTask);
        r102.print(" waiting=");
        r102.println(this.mTask.waiting);
    L6:
        if (this.mCancellingTask == null) goto L9;
        r102.print(r100);
        r102.print("mCancellingTask=");
        r102.print(this.mCancellingTask);
        r102.print(" waiting=");
        r102.println(this.mCancellingTask.waiting);
    L9:
        if (this.mUpdateThrottle == 0) goto L12;
        r102.print(r100);
        r102.print("mUpdateThrottle=");
        TimeUtils.formatDuration(this.mUpdateThrottle, r102);
        r102.print(" mLastLoadCompleteTime=");
        TimeUtils.formatDuration(this.mLastLoadCompleteTime, SystemClock.uptimeMillis(), r102);
        r102.println();
        return;
    }
}
